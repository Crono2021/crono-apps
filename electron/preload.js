const { contextBridge, ipcRenderer } = require('electron')

contextBridge.exposeInMainWorld('cineflix', {
  // ── Window controls ─────────────────────────────────────────────────────────
  win: {
    minimize:    () => ipcRenderer.invoke('win:minimize'),
    maximize:    () => ipcRenderer.invoke('win:maximize'),
    close:       () => ipcRenderer.invoke('win:close'),
    isMaximized: () => ipcRenderer.invoke('win:isMaximized'),
  },

  // ── Persistent key-value store (survives installs) ──────────────────────────
  store: {
    get:    (key)        => ipcRenderer.invoke('store:get', key),
    set:    (key, value) => ipcRenderer.invoke('store:set', key, value),
    delete: (key)        => ipcRenderer.invoke('store:delete', key),
  },

  // ── MPV player ──────────────────────────────────────────────────────────────
  mpv: {
    // Play a Telegram stream via local HTTP server
    play:       (streamInfo)          => ipcRenderer.invoke('mpv:play', streamInfo),
    command:    (cmd)                 => ipcRenderer.invoke('mpv:command', cmd),
    quit:       ()                    => ipcRenderer.invoke('mpv:quit'),
    getState:   ()                    => ipcRenderer.invoke('mpv:getState'),
    streamPort: ()                    => ipcRenderer.invoke('mpv:streamPort'),
    onEvent:    (cb) => {
      ipcRenderer.on('mpv:event', (_e, data) => cb(data))
      return () => ipcRenderer.removeAllListeners('mpv:event')
    },
  },

  // ── Telegram stream bridge ───────────────────────────────────────────────────
  stream: {
    // Register a Telegram doc so the HTTP server knows its size/mimeType
    register: (streamId, docInfo) => ipcRenderer.invoke('stream:register', streamId, docInfo),
    // Send fetched bytes back to the HTTP server (called from onFetchRange handler)
    replyRange: (requestId, buffer) => ipcRenderer.send('stream:rangeReply', requestId, buffer),
    // Listen for fetch-range requests from the HTTP server
    onFetchRange: (cb) => {
      ipcRenderer.on('stream:fetchRange', (_e, data) => cb(data))
      return () => ipcRenderer.removeAllListeners('stream:fetchRange')
    },
  },

  // ── Integrated player ─────────────────────────────────────────────────────────
  player: {
    launch:       (streamInfo) => ipcRenderer.invoke('player:launch', streamInfo),
    back:         ()           => ipcRenderer.invoke('player:back'),
    enableMouse:  ()           => ipcRenderer.send('player:enableMouse'),
    disableMouse: ()           => ipcRenderer.send('player:disableMouse'),
  },

  // ── Is running inside Electron? ──────────────────────────────────────────────
  isElectron: true,

  // ── Movies catalog (fetched via main process to bypass CORS) ─────────────────
  movies: {
    fetch: () => ipcRenderer.invoke('movies:fetch'),
  },

  // ── Auto Updater ─────────────────────────────────────────────────────────────
  updater: {
    openExternal: (url) => ipcRenderer.invoke('open-external', url),
  },
})
