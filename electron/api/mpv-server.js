
const http = require('http')
const fs   = require('fs')
const path = require('path')

function slog(msg) {
  const logPath = path.join(require('os').tmpdir(), 'cineflix_main_tg.log');
  fs.appendFileSync(logPath, `[${new Date().toISOString()}][StreamServer] ${msg}\n`);
}

let _server     = null
let _getWindow  = null

// streamId → { size, mimeType }
const streamRegistry = new Map()

// Pending range requests: requestId → { resolve, reject, timer }
const pendingRequests = new Map()
let _requestCounter = 0

function setWindowGetter(fn) { _getWindow = fn }

function start() {
  return new Promise((resolve, reject) => {
    _server = http.createServer(handleRequest)
    _server.listen(0, '127.0.0.1', () => {
      const port = _server.address().port
      slog(`Listening on http://127.0.0.1:${port}`)
      console.log(`[StreamServer] Listening on http://127.0.0.1:${port}`)
      resolve(port)
    })
    _server.on('error', reject)
  })
}

function stop() {
  if (_server) { _server.close(); _server = null }
  for (const [id, p] of pendingRequests) {
    clearTimeout(p.timer)
    p.reject(new Error('Server stopped'))
  }
  pendingRequests.clear()
}

function registerStream(streamId, docInfo) {
  slog(`registerStream: ${streamId} size=${docInfo.size} mime=${docInfo.mimeType}`)
  streamRegistry.set(streamId, docInfo)
}

/**
 * Handle a rangeReply from the renderer process.
 */
function handleRangeReply(requestId, buffer) {
  const pending = pendingRequests.get(requestId)
  if (!pending) return
  pendingRequests.delete(requestId)
  clearTimeout(pending.timer)
  pending.resolve(buffer)
}

/**
 * Cancel all pending IPC requests belonging to a specific connection.
 */
function cancelConnectionRequests(connectionId) {
  const cancelledIds = []
  for (const [id, p] of pendingRequests) {
    if (p.connectionId === connectionId) {
      pendingRequests.delete(id)
      clearTimeout(p.timer)
      p.resolve(null) // Resolve with null to signal cancellation (don't reject to avoid noise)
      cancelledIds.push(id)
    }
  }
  // Tell the renderer to drop these from its download queue
  if (cancelledIds.length > 0) {
    slog(`Cancelling ${cancelledIds.length} renderer requests for connId=${connectionId}`)
    const win = _getWindow && _getWindow()
    if (win && !win.isDestroyed()) {
      win.webContents.send('stream:cancelRequests', cancelledIds)
    }
  }
}

/**
 * Request a byte range from the renderer process via IPC.
 */
function fetchRange(streamId, start, size, connectionId) {
  return new Promise((resolve, reject) => {
    const win = _getWindow && _getWindow()
    if (!win || win.isDestroyed()) {
      return reject(new Error('No window available for IPC'))
    }

    const requestId = `req_${++_requestCounter}_${Date.now()}`
    
    const timer = setTimeout(() => {
      pendingRequests.delete(requestId)
      slog(`IPC TIMEOUT: ${requestId} streamId=${streamId} offset=${start}`)
      reject(new Error(`IPC fetch timeout for ${streamId} offset=${start}`))
    }, 30000)

    pendingRequests.set(requestId, { resolve, reject, timer, connectionId })

    win.webContents.send('stream:fetchRange', { requestId, streamId, start, size })
  })
}

function setCorsHeaders(res) {
  res.setHeader('Access-Control-Allow-Origin', '*')
  res.setHeader('Access-Control-Allow-Private-Network', 'true')
  res.setHeader('Access-Control-Allow-Methods', 'GET, HEAD, OPTIONS')
  res.setHeader('Access-Control-Allow-Headers', 'Range, Content-Type, Accept-Encoding, Access-Control-Request-Private-Network')
  res.setHeader('Access-Control-Expose-Headers', 'Content-Range, Content-Length, Accept-Ranges')
}

function handleRequest(req, res) {
  setCorsHeaders(res)

  if (req.method === 'OPTIONS') {
    res.writeHead(204)
    res.end()
    return
  }

  const urlParts = new URL(req.url, 'http://localhost');
  const m = urlParts.pathname.match(/^\/stream\/([^\/?]+)/);
  if (!m) { res.writeHead(404); res.end(); return }

  const streamId = m[1]
  const info = streamRegistry.get(streamId)
  if (!info) {
    slog(`404: stream not found: ${streamId}. Registry has: ${[...streamRegistry.keys()].join(', ')}`)
    res.writeHead(404); res.end('Stream not registered'); return
  }

  const totalSize = info.size
  const mimeType  = info.mimeType || 'video/mp4'

  if (req.method === 'HEAD') {
    res.writeHead(200, {
      'Content-Type': mimeType,
      'Content-Length': totalSize,
      'Accept-Ranges': 'bytes',
    })
    res.end()
    return
  }

  const rangeHeader = req.headers['range']
  let start = 0
  let end = totalSize - 1
  let isRange = false

  if (rangeHeader) {
    const match = rangeHeader.match(/bytes=(\d+)-(\d*)/)
    if (match) {
      start = parseInt(match[1])
      if (match[2] && match[2] !== '') end = parseInt(match[2])
      isRange = true
    } else {
      res.writeHead(400); res.end(); return
    }
  }

  const responseSize = end - start + 1
  // Unique ID for this HTTP connection, used to cancel stale IPC requests on abort
  const connectionId = `conn_${++_requestCounter}_${Date.now()}`

  slog(`Serving stream: ${streamId} range=${start}-${end} (${responseSize} bytes) connId=${connectionId}`)

  if (isRange) {
    res.writeHead(206, {
      'Content-Type': mimeType,
      'Content-Range': `bytes ${start}-${end}/${totalSize}`,
      'Content-Length': responseSize,
      'Accept-Ranges': 'bytes',
    })
  } else {
    res.writeHead(200, {
      'Content-Type': mimeType,
      'Content-Length': responseSize,
      'Accept-Ranges': 'bytes',
    })
  }

  // When MPV seeks, it destroys the old HTTP connection.
  // We must cancel all pending IPC requests for this connection immediately.
  req.on('close', () => {
    cancelConnectionRequests(connectionId)
  })

  // 2MB chunks matching renderer cache blocks (each triggers 4-way parallel Telegram download)
  const CHUNK_SIZE = 2 * 1024 * 1024;
  // Keep 4 requests in flight at all times via sliding window (no gaps between batches)
  const PIPELINE_SIZE = 4;
  let currentStart = start;

  const streamLoop = async () => {
    // Sliding window: always keep PIPELINE_SIZE requests in flight
    const pipeline = [];  // { offset, size, promise }
    let nextFetchOffset = start;

    // Fill the pipeline
    const fillPipeline = () => {
      while (pipeline.length < PIPELINE_SIZE && nextFetchOffset <= end) {
        if (req.destroyed || res.destroyed) break;
        // Align fetchSize so we don't cross a CHUNK_SIZE (2MB) boundary.
        // This ensures the renderer's block slicing perfectly matches our offsets without gaps.
        const nextBoundary = Math.ceil((nextFetchOffset + 1) / CHUNK_SIZE) * CHUNK_SIZE;
        const maxFetch = nextBoundary - nextFetchOffset;
        const fetchSize = Math.min(maxFetch, end - nextFetchOffset + 1);
        
        pipeline.push({
          offset: nextFetchOffset,
          size: fetchSize,
          promise: fetchRange(streamId, nextFetchOffset, fetchSize, connectionId)
        });
        nextFetchOffset += fetchSize;
      }
    };

    fillPipeline();

    while (pipeline.length > 0) {
      if (req.destroyed || res.destroyed) {
        cancelConnectionRequests(connectionId);
        break;
      }

      const item = pipeline.shift();  // Take the oldest (first in sequence)
      try {
        const buf = await item.promise;
        if (buf === null) break;  // cancelled
        if (!buf || buf.byteLength === 0) {
          const remaining = end - item.offset + 1;
          if (remaining > 0 && remaining <= 1024 * 1024) {
            if (!req.destroyed && !res.destroyed) res.write(Buffer.alloc(remaining));
          }
          break;
        }

        if (req.destroyed || res.destroyed) break;
        const data = Buffer.isBuffer(buf) ? buf : Buffer.from(buf);
        const canWrite = res.write(data);
        currentStart = item.offset + data.byteLength;

        // Immediately queue the next request (sliding window - no gap!)
        fillPipeline();

        if (!canWrite) {
          await new Promise(resolve => {
            const onDrain = () => { res.removeListener('close', onClose); resolve(); };
            const onClose = () => { res.removeListener('drain', onDrain); resolve(); };
            res.once('drain', onDrain);
            res.once('close', onClose);
          });
        }
      } catch (err) {
        if (!req.destroyed) slog(`FETCH ERROR at offset=${item.offset}: ${err.message}`);
        break;
      }
    }
    if (!res.destroyed && !res.writableEnded) {
      res.end();
    }
  };
  
  streamLoop();
}

module.exports = { start, stop, setWindowGetter, registerStream, handleRangeReply }
