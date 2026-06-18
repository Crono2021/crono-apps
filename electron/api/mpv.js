
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
let _currentPlaylist = []
let _currentPlaylistIndex = 0
let _buttonState = '' // 'intro', 'next', or ''

function dlog(...args) {
  try {
    fs.appendFileSync(path.join(os.tmpdir(), 'cineflix_debug.log'), new Date().toISOString() + ' ' + args.join(' ') + '\n');
  } catch(e){}
}
dlog('MPV JS MODULE LOADED');


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
  sendRaw({ command: ['observe_property', 4, 'playlist-pos'] })
}

function emit(evt) {
  dlog('EMIT TO FRONTEND:', JSON.stringify(evt));
  if (_overlayWin && !_overlayWin.isDestroyed()) {
    _overlayWin.webContents.send('mpv:event', evt)
  }
}

function handleEvent(msg) {
  if (!msg) return
  if (msg.event === 'playback-restart' || msg.event === 'file-loaded') {
    emit({ type: 'playback-restart' })
    sendCommand(['set_property', 'fullscreen', 'yes'])
    if (_overlayWin && !_overlayWin.isDestroyed()) {
      _overlayWin.hide()
    }
  }
  if (msg.event === 'property-change') {
    switch (msg.name) {
      case 'time-pos': {
        _state.pos = msg.data || 0
        emit({ type: 'timepos', pos: _state.pos, duration: _state.duration })
        
        // Handle skip buttons
        const currentItem = _currentPlaylist[_currentPlaylistIndex]
        if (currentItem) {
            const timeMs = _state.pos * 1000
            let shouldShow = ''
            let targetTime = 0
            
            // Check intro
            if (currentItem.introStartMs && currentItem.introEndMs && 
                timeMs >= currentItem.introStartMs && timeMs <= currentItem.introEndMs) {
                shouldShow = 'intro'
                targetTime = currentItem.introEndMs / 1000
            } 
            // Check credits
            else if (currentItem.creditsStartMs && timeMs >= currentItem.creditsStartMs) {
                shouldShow = 'next'
            }

            // dlog('timeMs:', timeMs, 'introStart:', currentItem.introStartMs, 'introEnd:', currentItem.introEndMs, 'shouldShow:', shouldShow, 'btnState:', _buttonState);

            // Update UI state if changed
            if (shouldShow !== _buttonState) {
                dlog('Button state changed to:', shouldShow, 'targetTime:', targetTime);
                _buttonState = shouldShow
                if (shouldShow) {
                    sendCommand(['script-message', 'show_button', shouldShow, targetTime.toString()])
                    emit({ type: 'button_state', state: shouldShow, targetTime })
                } else {
                    sendCommand(['script-message', 'hide_button'])
                    emit({ type: 'button_state', state: '' })
                }
            }
        }
        break
      }
      case 'duration':
        _state.duration = msg.data || 0
        break
      case 'pause':
        _state.paused = !!msg.data
        emit({ type: 'pause', paused: _state.paused })
        break
      case 'playlist-pos':
        _currentPlaylistIndex = msg.data || 0
        _buttonState = '' // reset button on track change
        sendCommand(['script-message', 'hide_button'])
        emit({ type: 'button_state', state: '' })
        break
    }
  }
  if (msg.event === 'end-file') {
    _state.playing = false
    emit({ type: 'ended' })
  }
}


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


async function playEmbedded(streamInfo, overlayWin) {
  const { playlist, startIndex = 0, seriesTitle } = streamInfo
  dlog('playEmbedded called! seriesTitle:', seriesTitle, 'startIndex:', startIndex);
  if (!playlist || playlist.length === 0) return { ok: false, error: 'No media' }

  _currentPlaylist = playlist
  _currentPlaylistIndex = startIndex
  _buttonState = ''
  
  dlog('First playlist item introStartMs:', playlist[startIndex]?.introStartMs);

  _overlayWin = overlayWin
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
    // Sanitize title: strip newlines (Telegram captions include synopses),
    // limit length, and remove characters that break URLs/filenames
    const rawTitle = (item.title || 'Video').split('\n')[0].trim().substring(0, 120);
    const safeTitle = rawTitle.replace(/[<>:"/\\|?*]/g, '');
    m3uContent += `#EXTINF:-1,${safeTitle}\n`
    m3uContent += `http://127.0.0.1:${_streamPort}/stream/${item.streamId}/${encodeURIComponent(safeTitle)}.mp4\n`
  })
  fs.writeFileSync(m3uPath, m3uContent)

  // Copy ui.lua to tmpdir because external MPV cannot read inside app.asar
  const uiLuaSrc = path.join(__dirname, 'ui.lua')
  const uiLuaTmp = path.join(os.tmpdir(), 'cineflix_ui.lua')
  try {
    const luaContent = fs.readFileSync(uiLuaSrc)
    fs.writeFileSync(uiLuaTmp, luaContent)
  } catch (e) {
    fs.writeFileSync(path.join(os.tmpdir(), 'cineflix_ui_error.log'), 'Error copying: ' + uiLuaSrc + '\n' + e.message)
    console.error('[MPV] Error copying ui.lua to tmp:', e)
  }

  const args = [
    `--playlist=${m3uPath}`,
    `--playlist-start=${startIndex}`,
    `--input-ipc-server=${PIPE_PATH}`,
    `--log-file=${path.join(os.tmpdir(), 'mpv_debug.log')}`,
    `--title=Cineflix - ${seriesTitle || 'Reproductor'}`, // Window title
    '--hwdec=auto-safe',                           // Force hardware acceleration for video
    '--vo=gpu',                                    // GPU video out
    '--osc=no',                                    // Disable default OSC
    `--config-dir=${path.join(process.resourcesPath, 'uosc')}`, // Load uosc
    '--keep-open=yes',
    '--sub-auto=fuzzy',
    '--slang=spa,es,en',
    '--alang=spa,es,en',
    '--ytdl=no',
    '--cache=yes',
    '--demuxer-max-bytes=150MiB',
    '--demuxer-max-back-bytes=50MiB',
    '--cache-secs=120',
    '--force-seekable=yes',
    '--hr-seek=no',
    '--cache-pause=no',
    '--vd-lavc-fast',
    `--script=${uiLuaTmp}`
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
    emit({ type: 'started', title: _state.title })
  } catch (e) {
    console.warn('[MPV] IPC pipe connection failed:', e.message)
    if (!hasFailed && mpvProcess === currentProcess) {
       // if it failed to connect pipe, let's just restore app just in case it crashed silently
       restoreMainApp()
    }
  }

  return { ok: true }
}


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
    `--title=Cineflix — ${title}`,
    `--start=${startTime}`,
    '--keep-open=yes',
    '--ytdl=no',
    '--cache=yes',
  ]

  mpvProcess = spawn(mpvExe, args, { detached: false, stdio: 'ignore' })
  mpvProcess.on('error', e => emit({ type: 'error', message: e.message }))
  mpvProcess.on('exit', () => { _state.playing = false; emit({ type: 'stopped' }) })

  try { 
    await connectPipe(20) 
    emit({ type: 'started', title: _state.title })
  } catch {}
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
