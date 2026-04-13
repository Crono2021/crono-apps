import { TelegramClient, Api } from 'telegram';
import { StringSession } from 'telegram/sessions';
import { computeCheck } from 'telegram/Password';
import bigInt from 'big-integer';

const API_ID = 25193949;
const API_HASH = '0523cf42fe71db02eeaa8ba52124c826';
const BOT_USERNAME = 'videoclubpacobot';
const SESSION_KEY = 'tg_session';

let client = null;
let phoneHash = null;
let swPort = null;
const streamRegistry = new Map(); // streamId -> { client, doc }

// ===== NATIVE BRIDGE =====
let nativeAuthResolver = null;
window.onTelegramAuthStateChanged = (state) => {
    console.log('[NativeBridge] Auth state:', state);
    if (nativeAuthResolver) {
        nativeAuthResolver(state);
        nativeAuthResolver = null;
    }
};
window.onTelegramError = (err) => {
    console.error('[NativeBridge] Error:', err);
    if (nativeAuthResolver) {
        nativeAuthResolver('ERROR: ' + err);
        nativeAuthResolver = null;
    }
};

function callNativeAsync(method, param = null) {
    return new Promise((resolve) => {
        nativeAuthResolver = resolve;
        if (param !== null) window.AndroidTelegram[method](param);
        else window.AndroidTelegram[method]();
    });
}

// ===== DATA NATIVE BRIDGE (TDLib Fallback) =====
const nativeDataResolvers = new Map();

window.onTelegramCallback = (queryId, success, payload) => {
    if (nativeDataResolvers.has(queryId)) {
        const { resolve, reject } = nativeDataResolvers.get(queryId);
        nativeDataResolvers.delete(queryId);
        if (success) {
            resolve(payload);
        } else {
            reject(new Error(payload));
        }
    }
};

function callNativeDataAsync(methodName, ...args) {
    return new Promise((resolve, reject) => {
        const queryId = Date.now().toString() + Math.random().toString().slice(2);
        nativeDataResolvers.set(queryId, { resolve, reject });
        if (window.AndroidTelegram && window.AndroidTelegram[methodName]) {
             window.AndroidTelegram[methodName](queryId, ...args);
        } else {
            reject(new Error('Native method missing: ' + methodName));
        }
    });
}

// ===== SESSION =====

function getSavedSession() {
    return localStorage.getItem(SESSION_KEY) || '';
}

function saveSession() {
    if (!client) return;
    const sessionStr = client.session.save();
    // 1. Always save to localStorage (fast, synchronous)
    localStorage.setItem(SESSION_KEY, sessionStr);
    // 2. On Android: also persist to native SharedPreferences (survives memory cleanup)
    if (window.Capacitor?.isNativePlatform?.()) {
        const prefs = window.Capacitor?.Plugins?.Preferences;
        if (prefs) prefs.set({ key: SESSION_KEY, value: sessionStr }).catch(() => {});
    }
}

/**
 * On Android, localStorage can be wiped by the OS under memory pressure.
 * This function restores the session from native SharedPreferences to localStorage
 * BEFORE init() checks isLoggedIn(). Must be awaited at app startup.
 */
export async function restoreNativeSession() {
    if (!window.Capacitor?.isNativePlatform?.()) return; // web: nothing to do
    try {
        const prefs = window.Capacitor?.Plugins?.Preferences;
        if (!prefs) return;
        const { value } = await prefs.get({ key: SESSION_KEY });
        if (value && !localStorage.getItem(SESSION_KEY)) {
            localStorage.setItem(SESSION_KEY, value);
            console.log('[Session] Restored from native storage ✓');
        }
    } catch (e) {
        console.warn('[Session] Could not restore from native storage:', e.message);
    }
}

// ===== CLIENT =====

export async function getClient() {
    if (client && client.connected) return client;
    const session = new StringSession(getSavedSession());
    client = new TelegramClient(session, API_ID, API_HASH, {
        connectionRetries: 5,
        useWSS: true,
    });
    await client.connect();
    return client;
}

// ===== AUTH =====

export async function isLoggedIn() {
    if (isNativeApp()) {
        const state = await callNativeAsync('requestAuthState');
        return state === 'READY';
    }
    // GramJS Fallback for PC/Electron
    try {
        await getClient();
        const me = await client.getMe();
        if (!me) return false;
        await client.getDialogs({ limit: 1 });
        return true;
    } catch (err) {
        const msg = (err.message || '').toUpperCase();
        if (msg.includes('SESSION_PASSWORD_NEEDED') || msg.includes('AUTH_KEY') || msg.includes('UNAUTHORIZED')) {
            localStorage.removeItem(SESSION_KEY);
            client = null;
        }
        return false;
    }
}

export async function sendCode(phone) {
    if (isNativeApp()) {
        const state = await callNativeAsync('loginWithPhone', phone);
        if (state.startsWith('ERROR')) throw new Error(state);
        return { isCodeViaApp: state === 'WAIT_CODE', success: true };
    }
    await getClient();
    const result = await client.invoke(new Api.auth.SendCode({
        phoneNumber: phone,
        apiId: API_ID,
        apiHash: API_HASH,
        settings: new Api.CodeSettings({}),
    }));
    phoneHash = result.phoneCodeHash;
    return { success: true };
}

export async function verifyCode(phone, code) {
    if (isNativeApp()) {
        const state = await callNativeAsync('signInWithCode', code);
        if (state.startsWith('ERROR')) throw new Error(state);
        if (state === 'WAIT_PASSWORD') return { success: false, needs2FA: true };
        return { success: true, needs2FA: false };
    }
    try {
        await client.invoke(new Api.auth.SignIn({
            phoneNumber: phone,
            phoneCodeHash: phoneHash,
            phoneCode: code,
        }));
        saveSession();
        return { success: true, needs2FA: false };
    } catch (err) {
        if ((err.message || '').includes('SESSION_PASSWORD_NEEDED')) {
            return { success: false, needs2FA: true };
        }
        throw err;
    }
}

export async function verify2FA(password) {
    if (isNativeApp()) {
        const state = await callNativeAsync('signInWithPassword', password);
        if (state.startsWith('ERROR')) throw new Error(state);
        return;
    }
    const pwdInfo = await client.invoke(new Api.account.GetPassword());
    // In the browser production bundle, computeCheck needs an explicit Buffer
    const algo = pwdInfo.currentAlgo;
    const pwdRes = await computeCheck(algo, password);
    await client.invoke(new Api.auth.CheckPassword({ password: pwdRes }));
    saveSession();
}

export async function logout() {
    if (isNativeApp()) {
        await callNativeAsync('logOut');
        return;
    }
    if (client && client.connected) {
        await client.invoke(new Api.auth.LogOut());
    }
    saveSession('');
    localStorage.removeItem(SESSION_KEY);
    client = null;
}

// ===== BOT INTERACTION =====

export async function sendBotCommand(payload) {
    if (isNativeApp()) {
        return await callNativeDataAsync('sendBotCommand', payload);
    }
    const c = await getClient();
    const bot = await c.getEntity(BOT_USERNAME);
    await c.sendMessage(bot, { message: `/start ${payload}` });
    await new Promise(r => setTimeout(r, 2500));
    const messages = await c.getMessages(bot, { limit: 5 });

    for (const msg of messages) {
        if (msg.replyMarkup && msg.replyMarkup.rows) {
            const buttons = [];
            for (const row of msg.replyMarkup.rows)
                for (const btn of row.buttons)
                    buttons.push({
                        text: btn.text,
                        data: btn.data ? new TextDecoder().decode(btn.data) : null,
                        msgId: msg.id,
                    });
            return { messageId: msg.id, buttons, text: msg.message };
        }
    }
    return { messageId: null, buttons: [], text: 'No response from bot' };
}

export async function clickInlineButton(msgId, data) {
    if (isNativeApp()) {
        // En Android Native TDLib toma el data en base64 desde strings.
        // GramJS nos devuelve el string que descodificamos. Pero en el Native hemos hecho
        // que el string `data` que pasa el framework sea base64? No, la vista espera que no haya lios.
        // Para simplificar, en Android el `data` que recibimos es base64 tal cual desde TDLib.
        return await callNativeDataAsync('clickInlineButton', msgId, data);
    }
    const c = await getClient();
    const bot = await c.getEntity(BOT_USERNAME);

    const MAX_RETRIES = 3;
    for (let attempt = 1; attempt <= MAX_RETRIES; attempt++) {
        try {
            await c.invoke(new Api.messages.GetBotCallbackAnswer({
                peer: bot,
                msgId,
                data: Buffer.from(data, 'utf8'),
            }));
            await new Promise(r => setTimeout(r, 3000));
            return true;
        } catch (err) {
            const isBotTimeout = err?.message?.includes('BOT_RESPONSE_TIMEOUT');
            if (isBotTimeout && attempt < MAX_RETRIES) {
                console.warn(`[Bot] BOT_RESPONSE_TIMEOUT (attempt ${attempt}/${MAX_RETRIES}), retrying...`);
                await new Promise(r => setTimeout(r, 2000 * attempt));
            } else {
                throw err;
        }
        }
    }
}

/**
 * Search for a movie using the /peli command.
 * The bot sends all matching video files directly (no buttons needed).
 * @param {string} searchTitle  - title to search (sent as "/peli [title]")
 * @returns {Array}             - video objects (same shape as getVideoMessages)
 */
export async function searchMovieByPayload(searchTitle) {
    if (isNativeApp()) {
        return await callNativeDataAsync('searchMovieByPayload', searchTitle);
    }
    const c = await getClient();
    const bot = await c.getEntity(BOT_USERNAME);

    const sentMsg = await c.sendMessage(bot, { message: `/peli ${searchTitle}` });
    await new Promise(r => setTimeout(r, 4000)); // wait for bot to send all files

    // Collect up to 30 video files sent after our command
    return await getVideoMessages(30, sentMsg.id);
}

export async function getVideoMessages(limit = 50, minId = 0) {
    if (isNativeApp()) {
        return await callNativeDataAsync('getVideoMessages', limit, minId);
    }
    const c = await getClient();
    const bot = await c.getEntity(BOT_USERNAME);
    // minId ensures we only get messages AFTER the season menu message,
    // preventing episodes from previous series leaking into the current list.
    const messages = await c.getMessages(bot, { limit, minId: minId || 0 });
    const videos = [];

    for (const msg of messages) {
        if (!msg.media?.document) continue;
        const doc = msg.media.document;
        let isVideo = false, fileName = '', width = 0, height = 0, duration = 0;

        for (const attr of doc.attributes || []) {
            const cn = (attr.className || '').toLowerCase();
            // Detect video attribute — check className OR presence of duration/w/h fields
            if (cn === 'documentattributevideo' || (attr.duration !== undefined && attr.w !== undefined)) {
                isVideo = true;
                width = attr.w || 0;
                height = attr.h || 0;
                duration = Math.round(attr.duration || 0);
            }
            // Detect filename attribute — check className OR presence of fileName field
            if (cn === 'documentattributefilename' || (attr.fileName && !attr.duration)) {
                if (attr.fileName) fileName = attr.fileName;
            }
        }
        if (!isVideo) continue;

        // Fallback: use caption, then generic name with msgId
        if (!fileName) {
            const cap = (msg.message || '').trim();
            fileName = cap || `video_${msg.id}.mp4`;
        }
        // Ensure it has an extension
        if (!fileName.includes('.')) fileName += '.mp4';

        videos.push({
            msgId: msg.id, fileName,
            fileSize: Number(doc.size),
            mimeType: doc.mimeType || 'video/mp4',
            width, height, duration,
            date: msg.date, caption: msg.message || '',
            media: msg.media,
            chatId: bot.id.toString()
        });
    }
    return videos;
}

// ===== SERVICE WORKER STREAMING =====

/**
 * Fetch a specific byte range from a Telegram document.
 * IMPORTANT: GramJS uses the 'big-integer' library, NOT native JS BigInt.
 * IMPORTANT: Telegram only allows limit values of 4KB, 128KB or 512KB.
 */
async function fetchTelegramRange(tgClient, doc, start, size) {
    // Telegram valid limit values (powers of 2, must be multiple of 4KB)
    const VALID_LIMITS = [4096, 131072, 524288]; // 4KB, 128KB, 512KB

    const BLOCK = 4096;
    const alignedStart = Math.floor(start / BLOCK) * BLOCK;

    // Pick the smallest valid limit that covers our requested size
    const needed = (start - alignedStart) + size;
    const limit = VALID_LIMITS.find(v => v >= needed) || VALID_LIMITS[VALID_LIMITS.length - 1];

    let received = null;
    for await (const chunk of tgClient.iterDownload({
        file: new Api.InputDocumentFileLocation({
            id: doc.id,
            accessHash: doc.accessHash,
            fileReference: doc.fileReference,
            thumbSize: '',
        }),
        offset: typeof doc.size === 'bigint' ? BigInt(alignedStart) : bigInt(alignedStart),
        requestSize: limit,
        dcId: doc.dcId,
    })) {
        received = new Uint8Array(chunk);
        break;
    }

    if (!received) return new Uint8Array(0);
    const trimStart = start - alignedStart;
    return received.slice(trimStart, trimStart + size);
}




/**
 * Register and initialize the Service Worker.
 * MUST be awaited before any video playback.
 */
export async function initServiceWorker() {
    if (!('serviceWorker' in navigator)) {
        console.warn('[SW] Not supported');
        return false;
    }

    try {
        const swUrl = (import.meta.env.BASE_URL || '/') + 'sw.js';
        const swScope = import.meta.env.BASE_URL || '/';
        const reg = await navigator.serviceWorker.register(swUrl, { scope: swScope });

        // Wait for the SW to become active
        await new Promise((resolve) => {
            const sw = reg.installing || reg.waiting || reg.active;
            if (reg.active && !reg.installing && !reg.waiting) { resolve(); return; }
            sw.addEventListener('statechange', function handler() {
                if (this.state === 'activated') { resolve(); sw.removeEventListener('statechange', handler); }
            });
        });

        await navigator.serviceWorker.ready;

        // Open a dedicated MessageChannel
        const channel = new MessageChannel();
        await new Promise((resolve) => {
            channel.port1.onmessage = (e) => {
                if (e.data?.type === 'READY') resolve();
            };
            reg.active.postMessage({ type: 'INIT' }, [channel.port2]);
        });

        swPort = channel.port1;

        // Handle range requests from SW
        swPort.onmessage = async (e) => {
            const { type, requestId, streamId, start, size } = e.data;
            if (type !== 'FETCH_RANGE') return;

            const info = streamRegistry.get(streamId);
            if (!info) {
                swPort.postMessage({ requestId, error: 'Stream not found' });
                return;
            }

            try {
                const chunk = await fetchTelegramRange(info.client, info.doc, start, size);
                swPort.postMessage({ requestId, chunk: chunk.buffer }, [chunk.buffer]);
            } catch (err) {
                console.error('[SW Range] Error:', err.message);
                swPort.postMessage({ requestId, error: err.message });
            }
        };

        console.log('[SW] Ready ✓');
        return true;
    } catch (err) {
        console.warn('[SW] Failed:', err.message);
        return false;
    }
}

/**
 * Play a video using Service Worker range-request streaming.
 * The browser handles buffering, seeking and moov atom detection automatically.
 */
export async function streamVideo(media, videoElement, onProgress) {
    // Always re-init SW port before playing — the browser can restart the SW
    // after idle periods, resetting its in-memory state (port = null).
    // Re-initializing takes < 50ms when the SW is already active.
    await initServiceWorker();

    const c = await getClient();
    const doc = media.document;
    const fileSize = Number(doc.size);
    const mimeType = doc.mimeType || 'video/mp4';

    if (swPort) {
        // Register stream metadata with SW
        const streamId = `${doc.id.toString()}-${Date.now()}`;
        streamRegistry.set(streamId, { client: c, doc });

        // Tell SW about this stream's metadata
        const reg = await navigator.serviceWorker.ready;
        reg.active.postMessage({
            type: 'REGISTER',
            streamId,
            fileSize,
            mimeType,
        });

        // Give the SW a tick to register
        await new Promise(r => setTimeout(r, 100));

        videoElement.src = (import.meta.env.BASE_URL || '/') + `tg-stream/${streamId}`;

        // Cleanup when done
        videoElement.addEventListener('ended', () => {
            streamRegistry.delete(streamId);
        }, { once: true });

        return;
    }

    // Fallback: MSE progressive buffering (if SW not available)
    console.warn('[Stream] SW not ready, using MSE fallback');
    const fileLocation = new Api.InputDocumentFileLocation({
        id: doc.id, accessHash: doc.accessHash,
        fileReference: doc.fileReference, thumbSize: '',
    });

    if (typeof MediaSource !== 'undefined' && MediaSource.isTypeSupported(mimeType)) {
        const ms = new MediaSource();
        videoElement.src = URL.createObjectURL(ms);
        await new Promise(r => ms.addEventListener('sourceopen', r, { once: true }));
        const sb = ms.addSourceBuffer(mimeType);
        let dl = 0, started = false;
        const waitUpdate = () => new Promise(r => sb.addEventListener('updateend', r, { once: true }));

        videoElement.addEventListener('canplay', () => {
            if (!started) { started = true; videoElement.play().catch(() => {}); }
        }, { once: true });

        for await (const chunk of c.iterDownload({ file: fileLocation, requestSize: 512 * 1024, dcId: doc.dcId, fileSize: doc.size })) {
            if (sb.updating) await waitUpdate();
            sb.appendBuffer(new Uint8Array(chunk));
            dl += chunk.length;
            onProgress?.({ downloaded: dl, total: fileSize, percent: Math.round(dl / fileSize * 100), ready: false });
        }
        if (sb.updating) await waitUpdate();
        ms.endOfStream();
        if (!started) videoElement.play().catch(() => {});
        return;
    }

    // Last resort: full download
    const chunks = []; let dl = 0;
    for await (const chunk of c.iterDownload({ file: fileLocation, requestSize: 512 * 1024, dcId: doc.dcId, fileSize: doc.size })) {
        chunks.push(new Uint8Array(chunk));
        dl += chunk.length;
        onProgress?.({ downloaded: dl, total: fileSize, percent: Math.round(dl / fileSize * 100), ready: false });
    }
    videoElement.src = URL.createObjectURL(new Blob(chunks, { type: mimeType }));
    videoElement.play().catch(() => {});
}

// ===== NATIVE ANDROID STREAMING (Capacitor + ExoPlayer) =====
// Arquitectura Tevegram: ServerSocket local en Kotlin sirve HTTP Range
// mientras GramJS descarga chunks progresivamente desde Telegram.

/**
 * Check if the app is running inside Capacitor (Android/iOS).
 */
export function isNativeApp() {
    try {
        return !!(window.Capacitor && window.Capacitor.isNativePlatform());
    } catch {
        return false;
    }
}

/**
 * Convierte Uint8Array a Base64 de forma eficiente (sin overflow de stack).
 */
function uint8ToBase64(bytes) {
    const CHUNK = 0x8000; // 32KB por iteración
    let binary = '';
    for (let i = 0; i < bytes.length; i += CHUNK) {
        binary += String.fromCharCode.apply(null, bytes.subarray(i, Math.min(i + CHUNK, bytes.length)));
    }
    return btoa(binary);
}

/**
 * Obtiene el plugin ExoPlayer del bridge nativo de Capacitor.
 * Solo funciona cuando la web se carga desde local (www/), NO desde URL remota.
 */
function getExoPlayer() {
    const plugin = window.Capacitor?.Plugins?.ExoPlayer;
    if (!plugin) {
        throw new Error('ExoPlayer plugin no disponible. ¿Estás en la app Android?');
    }
    return plugin;
}

export async function streamVideoNative(videoObj) {
    const ExoPlayer = getExoPlayer();
    
    // Extraemos chatId y msgId del objeto video
    let chatId = videoObj.chatId;
    let msgId = videoObj.msgId;
    
    // Si chatId es un usuario y estamos usando API Hash de GramJS
    if (chatId && typeof chatId === 'object' && chatId.value) {
        chatId = chatId.value.toString();
    } else if (chatId) {
        chatId = chatId.toString();
    }

    if (!chatId || !msgId) {
        throw new Error("No se pudo obtener el chatId o msgId necesario para TDLib.");
    }

    const proxyPort = window.CINEFLIX_PROXY_PORT || 0;
    const url = `http://127.0.0.1:${proxyPort}/resolve?chat_id=${chatId}&msg_id=${msgId}`;
    
    console.log('[Native] 🎬 Iniciando ExoPlayer con TDLib. URL:', url);

    await ExoPlayer.play({ url });
}

