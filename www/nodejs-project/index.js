const { channel } = require('bridge');
const express = require('express');
const { TelegramClient } = require('telegram');
const { StringSession } = require('telegram/sessions');
// Need to mock or configure browser dependencies for node
// but telegram package supports Node inherently!

const app = express();
const port = 3000;

let client = null;
let currentSessionString = '';

// CORS para que ExoPlayer pueda acceder sin problemas
app.use((req, res, next) => {
    res.header('Access-Control-Allow-Origin', '*');
    res.header('Access-Control-Allow-Headers', '*');
    next();
});

// Start proxy desde la UI (recibe el token de conexion y arranca tcp nativo)
channel.addListener('start_proxy', async (data) => {
    try {
        const { sessionString, apiId, apiHash } = data;
        
        if (client && currentSessionString === sessionString) {
             channel.send('proxy_started', { success: true, port: port, message: 'Already running' });
             return;
        }

        if (client) {
            await client.disconnect();
        }

        currentSessionString = sessionString;
        const session = new StringSession(sessionString);
        
        console.log('[NodeProxy] Iniciando TelegramClient nativo...');
        client = new TelegramClient(session, apiId, apiHash, {
            connectionRetries: 5,
        });

        await client.connect();
        console.log('[NodeProxy] TelegramClient conectado con exito y sesion autorizada');
        
        if (!app.listening) {
            app.listen(port, '127.0.0.1', () => {
                console.log(`[NodeProxy] Servidor HTTP de streaming nativo escuchando en http://127.0.0.1:${port}`);
            });
            app.listening = true;
        }

        channel.send('proxy_started', { success: true, port: port });
    } catch (e) {
         console.error('[NodeProxy] Error fatal:', e);
         channel.send('proxy_started', { success: false, error: String(e) });
    }
});

const streams = new Map();

channel.addListener('register_stream', (data) => {
    const { streamId, doc } = data;
    streams.set(streamId, {
        id: BigInt(doc.id),
        accessHash: BigInt(doc.accessHash),
        fileReference: Buffer.from(doc.fileReference, 'base64'),
        size: parseInt(doc.size, 10),
        mimeType: doc.mimeType || 'video/x-matroska'
    });
    channel.send('stream_registered', { streamId });
});

// Endpoint de streaming crudo directamente a ExoPlayer (TCP a TCP puro)
app.get('/stream/:streamId', async (req, res) => {
    if (!client) {
         return res.status(500).send('TelegramClient offline');
    }

    const { streamId } = req.params;
    const docInfo = streams.get(streamId);

    if (!docInfo) {
        return res.status(404).send('Stream no registrado en Node');
    }

    try {
        const totalSize = docInfo.size;
        const mimeType = docInfo.mimeType;

        const rangeHeader = req.headers['range'];

        if (!rangeHeader) {
            res.writeHead(200, {
                'Content-Type': mimeType,
                'Content-Length': totalSize,
                'Accept-Ranges': 'bytes',
            });
            return res.end();
        }

        const [, startStr, endStr] = rangeHeader.match(/bytes=(\d+)-(\d*)/) || [];
        if (startStr === undefined) return res.status(400).end();

        const start = parseInt(startStr, 10);
        // ExoPlayer a menudo no envía endStr, requiriendo un chunk grande
        const end = endStr ? parseInt(endStr, 10) : Math.min(start + 512 * 1024 - 1, totalSize - 1);
        const chunkSize = end - start + 1;

        res.writeHead(206, {
            'Content-Type': mimeType,
            'Content-Range': `bytes ${start}-${end}/${totalSize}`,
            'Content-Length': chunkSize,
            'Accept-Ranges': 'bytes',
        });

        // Configurar la descarga MTProto (NATIVA desde el Backend)
        const fileLocation = new Api.InputDocumentFileLocation({
            id: docInfo.id,
            accessHash: docInfo.accessHash,
            fileReference: docInfo.fileReference,
            thumbSize: '',
        });

        let pos = start;
        while (pos <= end) {
            const currentSize = Math.min(end - pos + 1, 512 * 1024);
            const alignedStart = Math.floor(pos / 4096) * 4096;
            const VALID_LIMITS = [4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288];
            const needed = (pos - alignedStart) + currentSize;
            const limit = VALID_LIMITS.find(v => v >= needed) || VALID_LIMITS[VALID_LIMITS.length - 1];

            const result = await client.invoke(
                new Api.upload.GetFile({
                    location: fileLocation,
                    offset: BigInt(alignedStart),
                    limit: limit,
                    precise: true,
                })
            );

            const offsetInChunk = pos - alignedStart;
            const bytesChunk = result.bytes.slice(offsetInChunk, offsetInChunk + currentSize);

            if (!res.writableEnded) {
                res.write(bytesChunk);
            } else {
                break;
            }

            pos += bytesChunk.length;
            if (bytesChunk.length === 0) break; // EOF inesperado
        }

        if (!res.writableEnded) {
            res.end();
        }

    } catch (e) {
         console.error('[NodeProxy] Stream request fracasó:', e);
         if (!res.headersSent) res.status(500).send(String(e));
    }
});

channel.send('ready', { status: 'nodejs-background-alive' });
