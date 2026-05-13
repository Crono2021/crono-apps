/**
 * MPV Streaming Server — Cineflix Desktop
 *
 * A local HTTP server that MPV can stream from.
 * MPV requests bytes via HTTP Range requests to:
 *   http://127.0.0.1:<port>/stream/<streamId>
 *
 * The server asks the renderer (via IPC) for the actual bytes,
 * which the renderer fetches from Telegram using GramJS.
 *
 * Flow:
 *   MPV → HTTP Range Request
 *     → mpv-server.js receives it
 *     → sends 'stream:fetchRange' to renderer via mainWindow.webContents.send
 *     → renderer calls fetchTelegramRange() via GramJS
 *     → renderer responds with 'stream:rangeReply' via ipcMain.on
 *     → server completes the HTTP response to MPV
 */

const http = require('http')
const net  = require('net')

let _server     = null
let _getWindow  = null  // lazy getter — set by main.js after window creation

// streamId → { size, mimeType }
const streamRegistry = new Map()

// requestId → { resolve, reject, timeout }
const pendingRequests = new Map()
let reqCounter = 0

// ── Public API ────────────────────────────────────────────────────────────────

/**
 * Starts the server on a random free port.
 * @returns {number} The port the server is listening on
 */
/** Set the function that returns the current main window (used for IPC). */
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

/**
 * Register a stream. Called when renderer is about to open a file.
 */
function registerStream(streamId, docInfo) {
  streamRegistry.set(streamId, docInfo)
}

/**
 * Called by ipcMain when the renderer delivers byte data.
 */
function handleRangeReply(requestId, buffer) {
  const pending = pendingRequests.get(requestId)
  if (!pending) return
  clearTimeout(pending.timeout)
  pendingRequests.delete(requestId)
  pending.resolve(Buffer.from(buffer))
}

// ── HTTP request handler ──────────────────────────────────────────────────────

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

  // Parse Range header: "bytes=X-Y"
  const rangeHeader = req.headers['range']
  if (!rangeHeader) {
    // Full file request (MPV initial probe)
    res.writeHead(200, {
      'Content-Type': mimeType,
      'Content-Length': totalSize,
      'Accept-Ranges': 'bytes',
    })
    // Stream the whole thing in chunks
    streamChunked(streamId, 0, totalSize - 1, totalSize, mimeType, res)
    return
  }

  const [, startStr, endStr] = rangeHeader.match(/bytes=(\d+)-(\d*)/) || []
  if (startStr === undefined) { res.writeHead(400); res.end(); return }

  const start = parseInt(startStr)
  const end   = endStr ? parseInt(endStr) : Math.min(start + 512 * 1024 - 1, totalSize - 1)
  const chunkSize = end - start + 1

  res.writeHead(206, {
    'Content-Type': mimeType,
    'Content-Range': `bytes ${start}-${end}/${totalSize}`,
    'Content-Length': chunkSize,
    'Accept-Ranges': 'bytes',
  })

  fetchRange(streamId, start, chunkSize)
    .then(buf => res.end(buf))
    .catch(err => { console.error('[StreamServer] range error:', err); res.end() })
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

// ── Byte fetching via IPC to renderer ─────────────────────────────────────────

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
