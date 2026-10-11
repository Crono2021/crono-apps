const { TelegramClient, Api } = require('telegram');
const { StringSession } = require('telegram/sessions');
const fs = require('fs');

function logToFile(msg, err = '') {
    const logPath = require('path').join(require('os').tmpdir(), 'cineflix_main_tg.log');
    fs.appendFileSync(logPath, `[${new Date().toISOString()}] ${msg} ${err}\n`);
}

let clientPool = null;
let apiId = null;
let apiHash = null;

// Registry to keep track of active Telegram documents by streamId
// Since MPV uses streamId, we can map it to the Telegram doc
const streamRegistry = new Map();

/**
 * Ensures the Telegram Client Pool is connected in the Main Process using raw TCP sockets.
 */
async function initTelegramPool(sessionStr, id, hash) {
    if (clientPool) return clientPool;

    apiId = parseInt(id, 10);
    apiHash = hash;

    try {
        console.log('[Main-Telegram] Creating pool of 8 TelegramClients using RAW TCP...');
        logToFile('Creating pool of 8 TelegramClients using RAW TCP...');
        const pool = [];
        const promises = [];
        
        for (let i = 0; i < 8; i++) {
            const { ConnectionTCPObfuscated } = require('telegram/network/connection');
            const { PromisedWebSockets } = require('telegram/extensions');

            const client = new TelegramClient(new StringSession(sessionStr), apiId, apiHash, {
                connectionRetries: 5,
                useWSS: true,
                connection: ConnectionTCPObfuscated,
                networkSocket: PromisedWebSockets,
            });
            
            pool.push(client);
            promises.push(client.connect().catch(err => {
                console.error('[Main-Telegram] connect err', err);
                logToFile('connect err', err.stack || err);
            }));
        }

        // Wait for all clients to connect in parallel
        await Promise.all(promises);
        
        clientPool = pool;
        console.log('[Main-Telegram] Telegram Client Pool (TCP) connected successfully.');
        logToFile('Telegram Client Pool (TCP) connected successfully.');
        return clientPool;
    } catch (error) {
        console.error('[Main-Telegram] Failed to init Telegram Client Pool:', error);
        logToFile('Failed to init Telegram Client Pool:', error.stack || error);
        throw error;
    }
}

/**
 * Register a document with a streamId so MPV can fetch it later.
 */
function registerTelegramStream(streamId, doc) {
    logToFile(`Registering stream: ${streamId}`);
    streamRegistry.set(streamId, doc);
}

/**
 * Fetch a range of bytes directly using the Telegram pool.
 */
const bigInt = require('big-integer');

async function fetchTelegramRangeMain(streamId, start, size) {
    const doc = streamRegistry.get(streamId);
    if (!doc) throw new Error(`[Main-Telegram] Stream not registered: ${streamId}`);
    
    if (!clientPool) throw new Error('[Main-Telegram] Client pool not initialized');

    // Telegram requires 4KB alignment
    const ALIGN_BLOCK = 4096;
    const alignedStart = Math.floor(start / ALIGN_BLOCK) * ALIGN_BLOCK;
    const alignedEnd = Math.ceil((start + size) / ALIGN_BLOCK) * ALIGN_BLOCK;
    const totalNeededBytes = alignedEnd - alignedStart;

    logToFile(`Fetch request: start=${start} size=${size}. Aligned: ${alignedStart}-${alignedEnd} (${totalNeededBytes} bytes)`);

    const LIMIT = 128 * 1024; // 128KB max per request
    let chunks = [];

    for (let j = 0; j < totalNeededBytes; j += LIMIT) {
        const chunkOffset = alignedStart + j;
        const chunkSize = Math.min(LIMIT, totalNeededBytes - j);
        chunks.push({ requestOffset: chunkOffset, requestSize: chunkSize, destOffset: j });
    }

    const MAX_CONCURRENT = clientPool.length;
    const results = new Uint8Array(totalNeededBytes);

    for (let i = 0; i < chunks.length; i += MAX_CONCURRENT) {
        const batch = chunks.slice(i, i + MAX_CONCURRENT);
        const promises = batch.map(async (chunkInfo, batchIdx) => {
            let receivedBytes = null;
            const tgClient = clientPool[batchIdx % clientPool.length];
            
            for (let retries = 0; retries < 3; retries++) {
                try {
                    const result = await Promise.race([
                        tgClient.invoke(new Api.upload.GetFile({
                            location: new Api.InputDocumentFileLocation({
                                id: bigInt(doc.id),
                                accessHash: bigInt(doc.accessHash),
                                fileReference: Buffer.from(doc.fileReference),
                                thumbSize: ''
                            }),
                            offset: bigInt(chunkInfo.requestOffset),
                            limit: chunkInfo.requestSize
                        })),
                        new Promise((_, reject) => setTimeout(() => reject(new Error('INVOKE_TIMEOUT')), 10000))
                    ]);
                    
                    receivedBytes = result.bytes;
                    break;
                } catch (e) {
                    if (e.message && e.message.includes('FLOOD')) {
                        await new Promise(r => setTimeout(r, 1000));
                        continue;
                    }
                    console.error(`[Main-Telegram] fetch chunk error offset=${chunkInfo.requestOffset}`, e);
                    logToFile(`fetch chunk error offset=${chunkInfo.requestOffset}`, e.stack || e);
                    throw e;
                }
            }
            
            if (!receivedBytes) {
                throw new Error('[Main-Telegram] Failed to fetch chunk after 3 retries');
            }
            results.set(receivedBytes, chunkInfo.destOffset);
        });
        
        await Promise.all(promises);
    }
    
    const trimStart = start - alignedStart;
    const finalChunk = results.subarray(trimStart, trimStart + size);
    return Buffer.from(finalChunk);
}

module.exports = {
    initTelegramPool,
    registerTelegramStream,
    fetchTelegramRangeMain
};
