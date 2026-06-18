
const http = require('http')
const net  = require('net')

let _server     = null
let _getWindow  = null  // lazy getter — set by main.js after window creation

// streamId → { size, mimeType }
const streamRegistry = new Map()

// requestId → { resolve, reject, timeout }
const pendingRequests = new Map()
let reqCounter = 0



function setWindowGetter(fn) { _getWindow = fn }

function start() {
  return new Promise((resolve, reject) => {
    _server = http.createServer(handleRequest)
    _server.listen(0, '127.0.0.1', () => {
      const port = _server.address().port
      console.log(`[StreamServer] Listening on http://127.0.0.1:${port}`)
      resolve(port)
    })
    _server.on('error', reject)
  })
}

function stop() {
  if (_server) { _server.close(); _server = null }
}

function registerStream(streamId, docInfo) {
  streamRegistry.set(streamId, docInfo)
}

function handleRangeReply(requestId, buffer) {
  const pending = pendingRequests.get(requestId)
  if (!pending) return
  clearTimeout(pending.timeout)
  pendingRequests.delete(requestId)
  pending.resolve(Buffer.from(buffer))
}



function handleRequest(req, res) {
  // Use URL parsing to drop query params and split the path
  const urlParts = new URL(req.url, 'http://localhost');
  const m = urlParts.pathname.match(/^\/stream\/([^\/?]+)/);
  if (!m) { res.writeHead(404); res.end(); return }

  const streamId = m[1]
  const info = streamRegistry.get(streamId)
  if (!info) { res.writeHead(404); res.end('Stream not registered'); return }

  const totalSize = info.size
  const mimeType  = info.mimeType || 'video/mp4'

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

  // Dynamic chunk sizing (TCP Slow Start)
  // Start small (512KB) so that ffmpeg's initial probing seeks are lightning fast.
  // Double the size on successful contiguous reads up to 4MB to maximize bandwidth during playback.
  let currentChunkSize = 512 * 1024; 
  const MAX_CHUNK_SIZE = 4 * 1024 * 1024;
  let currentStart = start;
  let emptyRetries = 0;  // Track consecutive empty reads

  const streamLoop = async () => {
    while (currentStart <= end) {
      if (req.destroyed || res.destroyed) break;
      
      const fetchSize = Math.min(currentChunkSize, end - currentStart + 1);
      try {
        const buf = await fetchRange(streamId, currentStart, fetchSize);
        
        if (!buf || buf.byteLength === 0) {
          emptyRetries++;
          if (emptyRetries >= 3) {
            // After 3 empty reads, pad the remaining bytes with zeros
            // This prevents ffmpeg's "Stream ends prematurely" exponential backoff
            const remaining = end - currentStart + 1;
            if (remaining > 0 && remaining <= 1024 * 1024) {  // Only pad up to 1MB
              console.log(`[StreamServer] Padding ${remaining} bytes at EOF to prevent ffmpeg retry storm`);
              if (!req.destroyed && !res.destroyed) {
                res.write(Buffer.alloc(remaining));
              }
              currentStart = end + 1;  // Mark as complete
            }
            break;
          }
          continue;  // Retry instead of breaking immediately
        }
        
        emptyRetries = 0;  // Reset on successful read
        if (req.destroyed || res.destroyed) break;
        
        const canWrite = res.write(buf);
        currentStart += buf.byteLength;
        
        const win = _getWindow && _getWindow();
        if (win && !win.isDestroyed()) {
          win.webContents.send('stream:progress', { downloaded: currentStart, total: totalSize });
        }
        
        if (!canWrite) {
          await new Promise(resolve => {
            const onDrain = () => {
              res.removeListener('close', onClose);
              resolve();
            };
            const onClose = () => {
              res.removeListener('drain', onDrain);
              resolve();
            };
            res.once('drain', onDrain);
            res.once('close', onClose);
          });
        }
        
        // Increase chunk size if we successfully wrote without dropping the connection
        if (!req.destroyed && !res.destroyed && currentChunkSize < MAX_CHUNK_SIZE) {
          currentChunkSize = Math.min(currentChunkSize * 2, MAX_CHUNK_SIZE);
        }
      } catch (err) {
        console.error('[StreamServer] fetch error:', err);
        break;
      }
    }
    res.end();
  };
  
  streamLoop();
}

async function streamChunked(streamId, start, end, totalSize, mimeType, res) {
  const CHUNK = 512 * 1024 // 512KB chunks
  let pos = start
  while (pos <= end) {
    const size = Math.min(CHUNK, end - pos + 1)
    try {
      const buf = await fetchRange(streamId, pos, size)
      if (!res.writableEnded) res.write(buf)
    } catch {
      break
    }
    pos += size
  }
  if (!res.writableEnded) res.end()
}



function fetchRange(streamId, start, size) {
  return new Promise((resolve, reject) => {
    const win = _getWindow ? _getWindow() : null
    if (!win || win.isDestroyed()) {
      return reject(new Error('No window'))
    }

    const requestId = `r${++reqCounter}`
    const timeout = setTimeout(() => {
      pendingRequests.delete(requestId)
      reject(new Error(`Timeout fetching range ${start}+${size}`))
    }, 30_000)

    pendingRequests.set(requestId, { resolve, reject, timeout })
    win.webContents.send('stream:fetchRange', { requestId, streamId, start, size })
  })
}

module.exports = { start, stop, setWindowGetter, registerStream, handleRangeReply }
