/**
 * MPV Controller — Cineflix Desktop (Embedded mode)
 *
 * Plays video by rendering MPV into a native window (--wid) instead of
 * opening a separate standalone MPV window.  The renderer window handle
 * is obtained from a dedicated black BrowserWindow and passed to MPV as
 * the --wid argument so MPV paints into it directly.
 *
 * Architecture:
 *   playerWindow (black BrowserWindow)  ← MPV renders here via --wid
 *   overlayWindow (transparent BW)      ← HTML controls sit on top
 *
 * IPC control via Named Pipe (Windows) or Unix socket (macOS/Linux).
 */

const { spawn } = require('child_process')
const net        = require('net')
const path       = require('path')
const fs         = require('fs')
const os         = require('os')
const { app }    = require('electron')

const isMac = process.platform === 'darwin'
const isWin = process.platform === 'win32'
const mpvBinaryName = isWin ? 'mpv.exe' : 'mpv'
const PIPE_PATH = isWin
  ? '\\\\.\\pipe\\cineflix-mpv'
  : path.join(os.tmpdir(), 'cineflix-mpv.sock')

let mpvProcess   = null
let pipeClient   = null
let _overlayWin  = null  // to forward events
let _streamPort  = null
let _state       = { playing: false, paused: false, pos: 0, duration: 0, title: '' }

// ── Find mpv binary (cross-platform) ──────────────────────────────────────────
function findMpv() {
  const candidates = [
    // Dev mode: project root / resources / mpv[.exe]
    path.join(app.getAppPath(), 'resources', mpvBinaryName),
    // Production (electron-builder): extraResources copies to resources/ next to app
    path.join(process.resourcesPath || '', mpvBinaryName),
    // Also try one level up from resourcesPath (some builder layouts)
    path.join(path.dirname(process.resourcesPath || ''), mpvBinaryName),
    path.join(app.getAppPath(), '..', mpvBinaryName),
    path.join(path.dirname(process.execPath), mpvBinaryName),
  ]

  // macOS: also check Homebrew paths
  if (isMac) {
    candidates.push('/opt/homebrew/bin/mpv')   // Apple Silicon Homebrew
    candidates.push('/usr/local/bin/mpv')       // Intel Homebrew
  }

  candidates.push('mpv')  // system PATH as last resort

  for (const c of candidates) {
    try {
      if (c !== 'mpv' && fs.existsSync(c)) {
        console.log('[MPV] Found at:', c)
        return c
      }
    } catch {}
  }
  console.log('[MPV] Not found in bundled paths, falling back to system PATH')
  return 'mpv'
}

function setStreamPort(port) { _streamPort = port }

// ── Named Pipe ────────────────────────────────────────────────────────────────
function sendRaw(payload) {
  if (!pipeClient || pipeClient.destroyed) return false
  try { pipeClient.write(JSON.stringify(payload) + '\n'); return true } catch { return false }
}

function sendCommand(cmd) {
  return sendRaw({ command: Array.isArray(cmd) ? cmd : [cmd] })
}

function connectPipe(retries = 20) {
  return new Promise((resolve, reject) => {
    const attempt = (n) => {
      const client = net.createConnection(PIPE_PATH)
      client.on('connect', () => {
        pipeClient = client
        setupObservers()
        resolve(client)
      })
      client.on('error', () => {
        if (n > 0) setTimeout(() => attempt(n - 1), 300)
        else reject(new Error('Could not connect to MPV IPC pipe'))
      })
      client.on('data', buf => {
        buf.toString().split('\n').filter(Boolean).forEach(line => {
          try { handleEvent(JSON.parse(line)) } catch {}
        })
      })
      client.on('close', () => {
        pipeClient = null
        _state.playing = false
        emit({ type: 'stopped' })
      })
    }
    attempt(retries)
  })
}

function setupObservers() {
  sendRaw({ command: ['observe_property', 1, 'time-pos'] })
  sendRaw({ command: ['observe_property', 2, 'duration'] })
  sendRaw({ command: ['observe_property', 3, 'pause'] })
}

function emit(evt) {
  if (_overlayWin && !_overlayWin.isDestroyed()) {
    _overlayWin.webContents.send('mpv:event', evt)
  }
}

function handleEvent(msg) {
  if (!msg) return
  if (msg.event === 'property-change') {
    switch (msg.name) {
      case 'time-pos':
        _state.pos = msg.data || 0
        emit({ type: 'timepos', pos: _state.pos, duration: _state.duration })
        break
      case 'duration':
        _state.duration = msg.data || 0
        break
      case 'pause':
        _state.paused = !!msg.data
        emit({ type: 'pause', paused: _state.paused })
        break
    }
  }
  if (msg.event === 'end-file') {
    _state.playing = false
    emit({ type: 'ended' })
  }
}

// ── Get native window handle from a BrowserWindow (cross-platform) ───────────
function getHwnd(win) {
  const buf = win.getNativeWindowHandle()
  if (isWin) {
    // On Windows x64 the HWND is a 64-bit pointer
    if (buf.length >= 8) return buf.readBigUInt64LE(0)
    return BigInt(buf.readUInt32LE(0))
  }
  // On macOS the handle is the NSView pointer (not used with --wid on macOS)
  return BigInt(buf.readUInt32LE(0))
}

// ── Launch standalone MPV but tie it to our main app flow ──
async function playEmbedded(streamInfo) {
  const { playlist, startIndex = 0, seriesTitle } = streamInfo
  if (!playlist || playlist.length === 0) return { ok: false, error: 'No media' }

  _state = { playing: true, title: seriesTitle || playlist[startIndex].title, pos: 0, duration: 0, paused: false }

  // Kill any existing MPV
  if (mpvProcess) {
    try { mpvProcess.kill() } catch {}
    mpvProcess = null
    pipeClient = null
    await new Promise(r => setTimeout(r, 400))
  }

  // macOS/Linux: clean up stale Unix socket file before launching MPV
  if (!isWin) {
    try { fs.unlinkSync(PIPE_PATH) } catch {}
  }

  const mpvExe = findMpv()
  
  // Create a temporary M3U playlist for MPV
  const os = require('os')
  const m3uPath = path.join(os.tmpdir(), `cineflix_playlist_${Date.now()}.m3u`)
  let m3uContent = '#EXTM3U\n'
  playlist.forEach(item => {
    const rawTitle = item.title || 'Video';
    m3uContent += `#EXTINF:-1,${rawTitle}\n`
    m3uContent += `http://127.0.0.1:${_streamPort}/stream/${item.streamId}/${encodeURIComponent(rawTitle)}.mp4\n`
  })
  fs.writeFileSync(m3uPath, m3uContent)

  const args = [
    `--playlist=${m3uPath}`,
    `--playlist-start=${startIndex}`,
    `--input-ipc-server=${PIPE_PATH}`,
    '--force-window=yes',
    '--fs=yes',                                    // Always force full screen
    `--title=Cineflix - ${seriesTitle || 'Reproductor'}`, // Window title
    '--hwdec=auto-safe',                           // Force hardware acceleration for video
    '--vo=gpu',                                    // GPU video out
    '--script-opts=osc-windowcontrols=yes,osc-layout=bottombar', // Show minimize/close X button
    '--keep-open=yes',
    '--sub-auto=fuzzy',
    '--slang=spa,es,en',
    '--alang=spa,es,en',
    '--ytdl=no',
    '--demuxer-max-bytes=100MiB',
    '--cache=yes',
  ]

  mpvProcess = spawn(mpvExe, args, { detached: false, stdio: 'pipe' })
  const currentProcess = mpvProcess
  let hasFailed = false;

  mpvProcess.stdout.on('data', data => console.log('[MPV OUT]', data.toString().trim()))
  mpvProcess.stderr.on('data', data => console.error('[MPV ERR]', data.toString().trim()))

  function restoreMainApp() {
    _state.playing = false
    const { app, BrowserWindow } = require('electron')
    const allWins = BrowserWindow.getAllWindows()
    allWins.forEach(w => {
      if (!w.isDestroyed()) {
        w.show()
        w.focus()
        w.webContents.send('mpv:event', { type: 'ended' })
      }
    })
  }

  mpvProcess.on('error', e => {
    console.error('[MPV] Spawn Error:', e)
    hasFailed = true;
    restoreMainApp()
    if (e.code === 'ENOENT') {
      const hint = isMac ? 'Instala mpv con: brew install mpv' : `Ruta intentada: ${mpvExe}`
      require('electron').dialog.showErrorBox('Error de reproducción', `No se encontró ${mpvBinaryName}.\n${hint}`);
    } else {
      require('electron').dialog.showErrorBox('Error de reproducción', `El reproductor no pudo iniciar.\nError: ${e.message}`);
    }
  })

  mpvProcess.on('exit', (code, signal) => {
    console.log(`[MPV] Exited with code ${code} (signal: ${signal})`)
    if (mpvProcess === currentProcess && !hasFailed) {
      restoreMainApp()
    }
  })

  try {
    await connectPipe(25)
  } catch (e) {
    console.warn('[MPV] IPC pipe connection failed:', e.message)
    if (!hasFailed && mpvProcess === currentProcess) {
       // if it failed to connect pipe, let's just restore app just in case it crashed silently
       restoreMainApp()
    }
  }

  return { ok: true }
}

// ── Standalone play (fallback — separate MPV window) ─────────────────────────
async function play(mainWindow, streamInfo) {
  const { streamId, title, startTime = 0, size } = streamInfo
  _overlayWin = mainWindow
  _state = { playing: true, title, pos: 0, duration: 0, paused: false }

  if (mpvProcess) {
    try { mpvProcess.kill() } catch {}
    mpvProcess = null; pipeClient = null
    await new Promise(r => setTimeout(r, 400))
  }

  const mpvExe = findMpv()
  const url    = `http://127.0.0.1:${_streamPort}/stream/${streamId}`

  const args = [
    url,
    `--input-ipc-server=${PIPE_PATH}`,
    '--force-window=yes',
    `--title=Cineflix — ${title}`,
    `--start=${startTime}`,
    '--keep-open=yes',
    '--ytdl=no',
    '--cache=yes',
  ]

  mpvProcess = spawn(mpvExe, args, { detached: false, stdio: 'ignore' })
  mpvProcess.on('error', e => emit({ type: 'error', message: e.message }))
  mpvProcess.on('exit', () => { _state.playing = false; emit({ type: 'stopped' }) })

  try { await connectPipe(20) } catch {}
  return { ok: true }
}

function quit() {
  sendCommand(['quit'])
  if (mpvProcess) { try { mpvProcess.kill() } catch {}; mpvProcess = null }
  pipeClient = null
  _overlayWin = null
  return { ok: true }
}

function getState() { return { ..._state } }

module.exports = { play, playEmbedded, sendCommand, quit, getState, setStreamPort, getHwnd }
