// TelegramFlix Service Worker — True Range-Request Streaming
// Serves /tg-stream/{streamId} with proper HTTP Range support.
// Streams data in 1MB chunks via a ReadableStream, fetched from the main thread.

const streams = new Map();  // streamId -> { fileSize, mimeType }
const pending = new Map();  // requestId -> { resolve, reject }
let port = null;

self.addEventListener('install', () => self.skipWaiting());
self.addEventListener('activate', (e) => e.waitUntil(clients.claim()));

self.addEventListener('message', (e) => {
    const { type } = e.data || {};
    if (type === 'INIT') {
        port = e.ports[0];
        port.onmessage = (ev) => {
            const { requestId, chunk, error } = ev.data;
            const p = pending.get(requestId);
            if (!p) return;
            pending.delete(requestId);
            if (error) p.reject(new Error(error));
            else p.resolve(chunk instanceof ArrayBuffer ? new Uint8Array(chunk) : chunk);
        };
        port.postMessage({ type: 'READY' });
    }
    if (type === 'REGISTER') {
        streams.set(e.data.streamId, {
            fileSize: e.data.fileSize,
            mimeType: e.data.mimeType,
        });
    }
});

/** Ask the main thread for one 1MB chunk at `start` */
function fetchChunk(streamId, start, size) {
    return new Promise((resolve, reject) => {
        if (!port) { reject(new Error('Port not ready')); return; }
        const requestId = `${streamId}-${start}-${Date.now()}`;
        pending.set(requestId, { resolve, reject });
        port.postMessage({ type: 'FETCH_RANGE', requestId, streamId, start, size });
        // Timeout after 30s
        setTimeout(() => {
            if (pending.has(requestId)) {
                pending.delete(requestId);
                reject(new Error('Timeout'));
            }
        }, 30000);
    });
}

self.addEventListener('fetch', (e) => {
    const url = new URL(e.request.url);
    const TG_MARKER = 'tg-stream/';
    const markerIdx = url.pathname.indexOf(TG_MARKER);
    if (markerIdx === -1) return;

    const streamId = url.pathname.slice(markerIdx + TG_MARKER.length);
    const meta = streams.get(streamId);
    if (!meta || !port) {
        e.respondWith(new Response('Stream not ready', { status: 503 }));
        return;
    }

    const rangeHeader = e.request.headers.get('range') || '';
    let start = 0;
    let end = meta.fileSize - 1;

    if (rangeHeader) {
        const m = rangeHeader.match(/bytes=(\d+)-(\d*)/);
        if (m) {
            start = parseInt(m[1]);
            end = m[2] ? Math.min(parseInt(m[2]), meta.fileSize - 1) : meta.fileSize - 1;
        }
    }

    const CHUNK_SIZE = 1024 * 1024; // 1MB per Telegram request
    const totalRequested = end - start + 1;

    const headers = {
        'Content-Type': meta.mimeType || 'video/mp4',
        'Accept-Ranges': 'bytes',
        'Content-Length': String(totalRequested),
        'Content-Range': `bytes ${start}-${end}/${meta.fileSize}`,
    };

    // Fast path: If the requested range is 1MB or less (probes, small ranges),
    // serve as a static ArrayBuffer response. This is 100% compatible with all Smart TV browsers.
    if (totalRequested <= CHUNK_SIZE) {
        e.respondWith((async () => {
            try {
                const chunk = await fetchChunk(streamId, start, totalRequested);
                return new Response(chunk, {
                    status: rangeHeader ? 206 : 200,
                    headers,
                });
            } catch (err) {
                return new Response('Stream fetch error: ' + err.message, { status: 500 });
            }
        })());
        return;
    }

    // Build a ReadableStream that pumps 1MB at a time from main thread for larger ranges
    let pos = start;
    let isCancelled = false;
    const readableStream = new ReadableStream({
        async pull(controller) {
            if (pos > end || isCancelled) {
                controller.close();
                return;
            }
            const size = Math.min(CHUNK_SIZE, end - pos + 1);
            try {
                const chunk = await fetchChunk(streamId, pos, size);
                if (isCancelled) {
                    controller.close();
                    return;
                }
                controller.enqueue(chunk);
                pos += chunk.byteLength;
                if (pos > end) controller.close();
            } catch (err) {
                if (!isCancelled) controller.error(err);
            }
        },
        cancel() {
            isCancelled = true;
        }
    });

    e.respondWith(new Response(readableStream, {
        status: rangeHeader ? 206 : 200,
        headers,
    }));
});
