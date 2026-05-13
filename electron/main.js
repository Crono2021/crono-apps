/**
 * Electron Main Process — Cineflix Desktop
 *
 * Responsibilities:
 *  1. Create the main BrowserWindow (app UI)
 *  2. Integrated player: playerWindow (MPV target) + overlayWindow (HTML controls)
 *  3. Local HTTP streaming server so MPV can read Telegram data
 *  4. IPC bridge for store, MPV, streaming
 */

const { app, BrowserWindow, ipcMain, globalShortcut, shell } = require('electron')
const path = require('path')
const fs   = require('fs')

const mpvController = require(path.join(__dirname, 'api', 'mpv.js'))
const mpvServer     = require(path.join(__dirname, 'api', 'mpv-server.js'))

// ── Persistent store ──────────────────────────────────────────────────────────
class SimpleStore {
  constructor(name = 'config') {
    this._path = null; this._name = name; this._data = {}
  }
  _ensurePath() {
    if (this._path) return
    this._path = path.join(app.getPath('userData'), `${this._name}.json`)
    try { this._data = JSON.parse(fs.readFileSync(this._path, 'utf8')) } catch {}
  }
  get(key)        { this._ensurePath(); return this._data[key] }
  set(key, value) { this._ensurePath(); this._data[key] = value; this._save() }
  delete(key)     { this._ensurePath(); delete this._data[key]; this._save() }
  _save()         { try { fs.writeFileSync(this._path, JSON.stringify(this._data, null, 2)) } catch {} }
}

const store  = new SimpleStore('cineflix-config')
const isDev  = !app.isPackaged

let mainWindow    = null
let playerWindow  = null   // black window — MPV renders into this via --wid
let overlayWindow = null   // transparent window — HTML controls on top

// ── Main window ───────────────────────────────────────────────────────────────
function createWindow() {
  mainWindow = new BrowserWindow({
    width: 1400, height: 860,
    minWidth: 1000, minHeight: 640,
    frame: true,
    backgroundColor: '#0d0d17',
    webPreferences: {
      preload: path.join(__dirname, '../preload/preload.js'),
      contextIsolation: true,
      nodeIntegration: false,
      webSecurity: false,
    },
    show: false,
    autoHideMenuBar: true,
    title: 'Cineflix',
  })

  mainWindow.once('ready-to-show', () => mainWindow.show())

  // Inject version and platform variables so renderer can check OTA updates
  mainWindow.webContents.on('did-finish-load', () => {
    mainWindow.webContents.executeJavaScript(`
      window.__appPlatform = 'desktop';
      window.__appVersion = '${app.getVersion()}';
    `)
  })

  if (isDev) {
    mainWindow.loadURL('http://localhost:7500')
    // mainWindow.webContents.openDevTools({ mode: 'detach' })
  } else {
    mainWindow.loadURL('https://cineflix-production-19e3.up.railway.app/')
  }
}

// ── Integrated Player windows ─────────────────────────────────────────────────
function getMainBounds() {
  return mainWindow ? mainWindow.getBounds() : { x: 0, y: 0, width: 1400, height: 860 }
}

async function openPlayerWindows(streamInfo) {
  // Launch MPV in its own native window natively with the regular MPV UI
  await mpvController.playEmbedded(streamInfo)

  // Hide main app while watching (only AFTER MPV has spawned/connected)
  mainWindow.hide()
}

function closePlayerWindows() {
  mpvController.quit()
  if (mainWindow && !mainWindow.isDestroyed()) {
    mainWindow.show()
    mainWindow.focus()
  }
}

// ── App lifecycle ─────────────────────────────────────────────────────────────
app.whenReady().then(async () => {
  const streamPort = await mpvServer.start()
  mpvServer.setWindowGetter(() => mainWindow)   // so server can get mainWindow dynamically
  mpvController.setStreamPort(streamPort)
  app.streamPort = streamPort
  createWindow()

  // Setup protocol handlers or other logic if needed
})

app.on('window-all-closed', () => {
  mpvController.quit()
  mpvServer.stop()
  if (process.platform !== 'darwin') app.quit()
})

// ── IPC: Window controls ──────────────────────────────────────────────────────
ipcMain.handle('win:minimize',    () => mainWindow?.minimize())
ipcMain.handle('win:maximize',    () => mainWindow?.isMaximized() ? mainWindow.unmaximize() : mainWindow?.maximize())
ipcMain.handle('win:close',       () => mainWindow?.close())
ipcMain.handle('win:isMaximized', () => mainWindow?.isMaximized() ?? false)

// ── IPC: Store ────────────────────────────────────────────────────────────────
ipcMain.handle('store:get',    (_e, key)        => store.get(key))
ipcMain.handle('store:set',    (_e, key, value) => { store.set(key, value) })
ipcMain.handle('store:delete', (_e, key)        => { store.delete(key) })

// ── IPC: Integrated player lifecycle ─────────────────────────────────────────
ipcMain.handle('player:launch', async (_e, streamInfo) => {
  try {
    await openPlayerWindows(streamInfo)
    return { ok: true }
  } catch (e) {
    console.error('[player:launch]', e)
    closePlayerWindows()
    return { ok: false, error: e.message }
  }
})

ipcMain.handle('player:back', () => {
  closePlayerWindows()
  return { ok: true }
})

// Mouse passthrough control from overlay HTML
ipcMain.on('player:enableMouse',  () => overlayWindow?.setIgnoreMouseEvents(false))
ipcMain.on('player:disableMouse', () => overlayWindow?.setIgnoreMouseEvents(true, { forward: true }))

// ── IPC: MPV commands (forwarded from overlay controls) ───────────────────────
ipcMain.handle('mpv:play',      (_e, streamInfo) => mpvController.play(mainWindow, streamInfo))
ipcMain.handle('mpv:command',   (_e, cmd)         => mpvController.sendCommand(cmd))
ipcMain.handle('mpv:quit',      ()               => mpvController.quit())
ipcMain.handle('mpv:getState',  ()               => mpvController.getState())
ipcMain.handle('mpv:streamPort',()               => app.streamPort)

// ── IPC: External Browser ─────────────────────────────────────────────────────────
ipcMain.handle('open-external', (_e, url) => shell.openExternal(url))

// ── IPC: Stream registry ──────────────────────────────────────────────────────
ipcMain.handle('stream:register', (_e, streamId, docInfo) => {
  mpvServer.registerStream(streamId, docInfo)
  return { ok: true }
})

ipcMain.on('stream:rangeReply', (_e, requestId, buffer) => {
  mpvServer.handleRangeReply(requestId, buffer)
})

// ── IPC: Movies API (no CORS via main process) ────────────────────────────────
ipcMain.handle('movies:fetch', async () => {
  try {
    const res = await fetch('https://cineflix-production-19e3.up.railway.app/api/movies')
    if (!res.ok) return []
    return await res.json()
  } catch (e) {
    console.error('[movies:fetch]', e.message)
    return []
  }
})
