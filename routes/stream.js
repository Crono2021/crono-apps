const express = require('express');
const router = express.Router();
const { Api } = require('telegram');
const bigInt = require('big-integer');
const tgClient = require('../telegram-client');
const config = require('../config');

/**
 * GET /api/stream/:chatId/:msgId
 * Stream video with HTTP Range support
 * Offsets aligned to Telegram chunk boundaries
 */
router.get('/:chatId/:msgId', async (req, res) => {
    try {
        const client = tgClient.getClient();
        const { chatId, msgId } = req.params;

        const entity = await client.getEntity(chatId);
        const messages = await client.getMessages(entity, { ids: [parseInt(msgId)] });

        const msg = messages[0];
        if (!msg || !msg.media || !msg.media.document) {
            return res.status(404).json({ error: 'Video not found' });
        }

        const doc = msg.media.document;
        const fileSize = Number(doc.size);
        const mimeType = doc.mimeType || 'video/mp4';
        const chunkSize = config.CHUNK_SIZE; // 512KB, must be power of 2

        const range = req.headers.range;

        if (range) {
            const parts = range.replace(/bytes=/, '').split('-');
            const start = parseInt(parts[0], 10);
            const end = parts[1] ? parseInt(parts[1], 10) : fileSize - 1;
            const contentLen = end - start + 1;

            // Align offset DOWN to chunk boundary (required by Telegram API)
            const alignedStart = Math.floor(start / chunkSize) * chunkSize;
            const skipBytes = start - alignedStart;

            res.writeHead(206, {
                'Content-Range': `bytes ${start}-${end}/${fileSize}`,
                'Accept-Ranges': 'bytes',
                'Content-Length': contentLen,
                'Content-Type': mimeType,
            });

            let bytesSkipped = 0;
            let bytesSent = 0;

            for await (const chunk of client.iterDownload({
                file: new Api.InputDocumentFileLocation({
                    id: doc.id,
                    accessHash: doc.accessHash,
                    fileReference: doc.fileReference,
                    thumbSize: '',
                }),
                offset: bigInt(alignedStart),
                requestSize: chunkSize,
                dcId: doc.dcId,
                fileSize: doc.size,
            })) {
                if (res.writableEnded) break;

                let data = Buffer.from(chunk);

                // Skip prefix bytes from alignment
                if (bytesSkipped < skipBytes) {
                    const toSkip = Math.min(data.length, skipBytes - bytesSkipped);
                    data = data.slice(toSkip);
                    bytesSkipped += toSkip;
                }

                if (data.length === 0) continue;

                // Trim to remaining needed bytes
                const remaining = contentLen - bytesSent;
                if (remaining <= 0) break;
                if (data.length > remaining) data = data.slice(0, remaining);

                res.write(data);
                bytesSent += data.length;
                if (bytesSent >= contentLen) break;
            }

            if (!res.writableEnded) res.end();
        } else {
            // Full file (no range)
            res.writeHead(200, {
                'Accept-Ranges': 'bytes',
                'Content-Length': fileSize,
                'Content-Type': mimeType,
            });

            for await (const chunk of client.iterDownload({
                file: new Api.InputDocumentFileLocation({
                    id: doc.id,
                    accessHash: doc.accessHash,
                    fileReference: doc.fileReference,
                    thumbSize: '',
                }),
                requestSize: chunkSize,
                dcId: doc.dcId,
                fileSize: doc.size,
            })) {
                if (res.writableEnded) break;
                res.write(Buffer.from(chunk));
            }

            if (!res.writableEnded) res.end();
        }
    } catch (err) {
        console.error('[Stream] Error:', err.message);
        if (!res.headersSent) {
            res.status(500).json({ error: err.message });
        }
    }
});

module.exports = router;
