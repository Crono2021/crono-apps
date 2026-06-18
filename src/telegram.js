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

// ===== NATIVE BRIDGE (AndroidBridge JavascriptInterface) =====
// On Android the Kotlin class AndroidBridge is injected as window.AndroidBridge.
// Auth callbacks come back via window.onTelegramAuthStateChanged / window.onTelegramCallback.

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
    return new Promise((resolve, reject) => {
        nativeAuthResolver = resolve;
        const bridge = window.AndroidBridge;
        try {
            switch (method) {
                case 'loginWithPhone': bridge.loginWithPhone(param); break;
                case 'signInWithCode': bridge.signInWithCode(param); break;
                case 'signInWithPassword': bridge.signInWithPassword(param); break;
                case 'requestAuthState': bridge.requestAuthState(); break;
                case 'logout': bridge.logout(); break;
                default: 
                    if (param !== null) bridge[method](param);
                    else bridge[method]();
            }
        } catch (e) {
            console.error('callNativeAsync failed:', e);
            reject(e);
        }
    });
}

// ===== DATA NATIVE BRIDGE =====
const nativeDataResolvers = new Map();

// Kotlin calls this when an async result is ready
window.onTelegramCallback = (queryId, success, payload) => {
    if (nativeDataResolvers.has(queryId)) {
        const { resolve, reject } = nativeDataResolvers.get(queryId);
        nativeDataResolvers.delete(queryId);
        success ? resolve(payload) : reject(new Error(payload));
    }
};

function callNativeDataAsync(methodName, ...args) {
    return new Promise((resolve, reject) => {
        const queryId = Date.now().toString() + Math.random().toString().slice(2);
        nativeDataResolvers.set(queryId, { resolve, reject });
        const bridge = window.AndroidBridge;
        if (bridge && bridge[methodName]) {
            bridge[methodName](queryId, ...args);
        } else {
            reject(new Error('AndroidBridge method missing: ' + methodName));
        }
    });
}

// ===== SESSION =====

async function getSavedSession() {
    let sessionStr = localStorage.getItem(SESSION_KEY) || '';
    if (!sessionStr && window.cineflix?.isElectron) {
        try {
            sessionStr = await window.cineflix.store.get(SESSION_KEY) || '';
            if (sessionStr) {
                localStorage.setItem(SESSION_KEY, sessionStr);
            }
        } catch {}
    }
    return sessionStr;
}

function saveSession(overrideStr) {
    if (!client && overrideStr === undefined) return;
    const sessionStr = overrideStr !== undefined ? overrideStr : client.session.save();
    
    // 1. Always save to localStorage (fast, synchronous)
    if (sessionStr) localStorage.setItem(SESSION_KEY, sessionStr);
    else localStorage.removeItem(SESSION_KEY);
    
    // 2. On Electron: sync to local desktop config
    if (window.cineflix?.isElectron) {
        if (sessionStr) window.cineflix.store.set(SESSION_KEY, sessionStr).catch(()=>{});
        else window.cineflix.store.delete(SESSION_KEY).catch(()=>{});
    }

    // 3. On Android: persist to native SharedPreferences (survives memory cleanup)
    if (window.Capacitor?.isNativePlatform?.()) {
        const prefs = window.Capacitor?.Plugins?.Preferences;
        if (prefs) prefs.set({ key: SESSION_KEY, value: sessionStr || '' }).catch(() => {});
    }
}

/**
 * On Android, localStorage can be wiped by the OS under memory pressure.
 * This function restores the session from native SharedPreferences to localStorage
 * BEFORE init() checks isLoggedIn(). Must be awaited at app startup.
 */
export async function restoreNativeSession() {
    // Desktop: Pre-load session into localStorage to avoid login loop
    if (window.cineflix?.isElectron) {
        try {
            const sessionStr = await window.cineflix.store.get(SESSION_KEY);
            if (sessionStr && !localStorage.getItem(SESSION_KEY)) {
                localStorage.setItem(SESSION_KEY, sessionStr);
            }
        } catch {}
    }

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
    const sessionStr = await getSavedSession();
    const session = new StringSession(sessionStr);
    client = new TelegramClient(session, API_ID, API_HASH, {
        connectionRetries: 5,
        useWSS: true,
    });
    await client.connect();
    return client;
}

export async function getUserPhone() {
    if (isNativeApp()) {
        let saved = localStorage.getItem('user_phone');
        if (saved) return saved;
        return 'native_user'; 
    }
    try {
        const c = await getClient();
        const me = await c.getMe();
        const phone = me.phone || me.id.toString();
        localStorage.setItem('user_phone', phone);
        return phone;
    } catch {
        let saved = localStorage.getItem('user_phone');
        if (saved) return saved;
        return 'unknown';
    }
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
        console.error('[AUTH ERROR IN isLoggedIn]', err);
        const msg = (err.message || '').toUpperCase();
        
        // ONLY remove session if it's explicitly an AuthKey error from Telegram Server
        // Do NOT remove session if it's a parse error or network error!
        if (msg.includes('AUTH_KEY_UNREGISTERED') || msg.includes('AUTH_KEY_DUPLICATED') || msg.includes('SESSION_REVOKED') || msg.includes('401')) {
            console.warn('[AUTH] Wiping session due to fatal Telegram authorization error.');
            localStorage.removeItem(SESSION_KEY);
            // Also wipe Electron's persistent store so restoreNativeSession() doesn't restore the corrupted session
            if (window.cineflix?.isElectron) {
                try { window.cineflix.store.delete(SESSION_KEY).catch(()=>{}); } catch {}
            }
            client = null;
        } else {
            console.warn('[AUTH] Soft error in GramJS, preserving session.');
            // We disconnect to force a clean reconnect next time
            if (client) {
                try { await client.disconnect(); } catch (e) {}
                client = null;
            }
        }
        return false;
    }
}

export async function sendCode(phone, isRetry = false) {
    localStorage.setItem('user_phone', phone);
    if (isNativeApp()) {
        const state = await callNativeAsync('loginWithPhone', phone);
        if (state.startsWith('ERROR')) throw new Error(state);
        return { isCodeViaApp: state === 'WAIT_CODE', success: true };
    }
    try {
        await getClient();
        const result = await client.invoke(new Api.auth.SendCode({
            phoneNumber: phone,
            apiId: API_ID,
            apiHash: API_HASH,
            settings: new Api.CodeSettings({}),
        }));
        phoneHash = result.phoneCodeHash;
        return { success: true };
    } catch (err) {
        const msg = (err.message || '').toUpperCase();
        if (!isRetry && msg.includes('AUTH_RESTART')) {
            console.warn('[Auth] AUTH_RESTART caught. Clearing session and retrying...');
            if (client) {
                try { await client.disconnect(); } catch {}
                client = null;
            }
            saveSession(''); // Attempt to clear
            localStorage.removeItem(SESSION_KEY);
            
            await new Promise(r => setTimeout(r, 1000));
            return await sendCode(phone, true);
        }
        throw err;
    }
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
    const pwdBuffer = Buffer.from(password, 'utf-8');
    const pwdRes = await computeCheck(pwdInfo, pwdBuffer);
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

/**
 * Request QR code login (Android only).
 * Returns the tg://login?token=... link to render as QR.
 * The native bridge keeps listening — when the user scans,
 * window.onTelegramAuthStateChanged fires with READY or WAIT_PASSWORD.
 */
export async function requestQrLogin() {
    if (!isNativeApp()) throw new Error('QR login solo disponible en Android');
    const state = await callNativeAsync('requestQrLogin');
    if (state.startsWith('ERROR')) throw new Error(state);
    if (state.startsWith('WAIT_QR|')) {
        return state.substring(8); // return the tg://login?token=... link
    }
    // If state is READY or WAIT_PASSWORD, auth completed during the call
    return state;
}

// ===== BOT INTERACTION =====

export async function sendBotCommand(payload) {
    if (isNativeApp()) {
        const raw = await callNativeDataAsync('sendBotCommand', payload);
        // Kotlin delivers a JSON string; parse it into a plain object
        return typeof raw === 'string' ? JSON.parse(raw) : raw;
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
        // Kotlin returns the video list as a JSON string; parse to array
        const raw = await callNativeDataAsync('clickInlineButton', msgId, data);
        return typeof raw === 'string' ? JSON.parse(raw) : raw;
    }
    const c = await getClient();
    const bot = await c.getEntity(BOT_USERNAME);

    // Capture the absolute latest message ID BEFORE clicking.
    // Everything with id > this value was sent AFTER our click.
    const msgs = await c.getMessages(bot, { limit: 1 });
    const boundaryId = msgs.length > 0 ? msgs[0].id : msgId;

    const MAX_RETRIES = 3;
    for (let attempt = 1; attempt <= MAX_RETRIES; attempt++) {
        try {
            await c.invoke(new Api.messages.GetBotCallbackAnswer({
                peer: bot,
                msgId,
                data: Buffer.from(data, 'utf8'),
            }));

            // Smart wait + direct collection: poll the chat and collect
            // ONLY video messages with id > boundaryId. This is the same
            // pattern Kotlin/TDLib uses (which works perfectly).
            // We return the videos directly — NO separate getVideoMessages call.
            let collectedVideos = [];
            let stableRounds = 0;
            for (let i = 0; i < 12; i++) { // max ~6s (12 × 500ms)
                await new Promise(r => setTimeout(r, 500));
                const recent = await c.getMessages(bot, { limit: 50 });
                const fresh = [];
                for (const m of recent) {
                    if (m.id <= boundaryId) continue; // older than our click
                    if (!m.media?.document) continue;
                    const doc = m.media.document;
                    let isVideo = false, fileName = '', width = 0, height = 0, duration = 0;
                    for (const attr of doc.attributes || []) {
                        const cn = (attr.className || '').toLowerCase();
                        if (cn === 'documentattributevideo' || (attr.duration !== undefined && attr.w !== undefined)) {
                            isVideo = true;
                            width = attr.w || 0;
                            height = attr.h || 0;
                            duration = Math.round(attr.duration || 0);
                        }
                        if (cn === 'documentattributefilename' || (attr.fileName && !attr.duration)) {
                            if (attr.fileName) fileName = attr.fileName;
                        }
                    }
                    if (!isVideo && fileName) {
                        const ext = fileName.split('.').pop().toLowerCase();
                        if (['mkv','avi','ts','m2ts','webm','flv','wmv','m4v','mov'].includes(ext)) isVideo = true;
                    }
                    if (!isVideo) continue;
                    if (!fileName) {
                        const cap = (m.message || '').trim();
                        fileName = cap || `video_${m.id}.mp4`;
                    }
                    if (!fileName.includes('.')) fileName += '.mp4';

                    let parsedSize = 0;
                    try { parsedSize = Number(String(doc.size)); } catch { parsedSize = 0; }

                    fresh.push({
                        msgId: m.id, fileName,
                        fileSize: parsedSize,
                        mimeType: doc.mimeType || 'video/mp4',
                        width, height, duration,
                        date: m.date, caption: m.message || '',
                        media: m.media,
                        chatId: bot.id.toString()
                    });
                }
                if (fresh.length > 0 && fresh.length === collectedVideos.length) {
                    stableRounds++;
                    if (stableRounds >= 2) { collectedVideos = fresh; break; }
                } else {
                    stableRounds = 0;
                }
                collectedVideos = fresh;
            }
            return collectedVideos; // Direct video array, same as Kotlin path
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
        const raw = await callNativeDataAsync('searchMovieByPayload', searchTitle);
        return typeof raw === 'string' ? JSON.parse(raw) : raw;
    }
    const c = await getClient();
    const bot = await c.getEntity(BOT_USERNAME);

    const sentMsg = await c.sendMessage(bot, { message: `/peli ${searchTitle}` });

    // Smart wait: poll for up to 12s until videos stop arriving
    let collectedVideos = [];
    let stableRounds = 0;
    for (let i = 0; i < 24; i++) { // max ~12s (24 × 500ms)
        await new Promise(r => setTimeout(r, 500));
        const fresh = await getVideoMessages(30, sentMsg.id);
        
        if (fresh.length > 0 && fresh.length === collectedVideos.length) {
            stableRounds++;
            if (stableRounds >= 3) { // 1.5s of silence after receiving at least 1 video
                collectedVideos = fresh;
                break;
            }
        } else {
            stableRounds = 0;
        }
        collectedVideos = fresh;
    }
    return collectedVideos;
}

export async function getVideoMessages(limit = 50, minId = 0, minTimestamp = 0) {
    if (isNativeApp()) {
        const raw = await callNativeDataAsync('getVideoMessages', limit, minId);
        return typeof raw === 'string' ? JSON.parse(raw) : raw;
    }
    const c = await getClient();
    const bot = await c.getEntity(BOT_USERNAME);
    // IMPORTANT: Do NOT pass minId to GramJS — its browser implementation
    // does not reliably filter by minId, causing episodes from previous
    // seasons to bleed through. Instead, we fetch all recent messages
    // and filter manually below using both msg.id and msg.date.
    const messages = await c.getMessages(bot, { limit });
    const videos = [];

    for (const msg of messages) {
        // ── Manual boundary filters (replaces broken GramJS minId) ──
        // Skip any message older than the boundary ID from before our click
        if (minId && msg.id <= minId) continue;
        // Skip any message from before this click's timestamp
        if (minTimestamp && msg.date < minTimestamp) continue;

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
        // Fallback for non-native video formats (MKV, AVI, TS…).
        // Telegram doesn't assign DocumentAttributeVideo to files it can't transcode,
        // so we promote them to "video" based on file extension.
        if (!isVideo && fileName) {
            const ext = fileName.split('.').pop().toLowerCase();
            if (['mkv','avi','ts','m2ts','webm','flv','wmv','m4v','mov'].includes(ext)) {
                isVideo = true;
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

        // GramJS uses big-integer objects for large sizes, so we must String() it first
        let parsedSize = 0;
        try { parsedSize = Number(String(doc.size)); } catch { parsedSize = 0; }

        videos.push({
            msgId: msg.id, fileName,
            fileSize: parsedSize,
            mimeType: doc.mimeType || 'video/mp4',
            width, height, duration,
            date: msg.date, caption: msg.message || '',
            media: msg.media,
            chatId: bot.id.toString()
        });
    }
    return videos;
}

// ── Electron: IPC stream handler ──────────────────────────────────────────────
let _electronHandlerActive = false;
export function initElectronStreamHandler() {
    if (!window.cineflix?.isElectron || _electronHandlerActive) return;
    _electronHandlerActive = true;

    // ── Read-ahead block cache (DESKTOP ONLY — PCs have plenty of RAM) ──────
    // Subsequent requests within the same block are served instantly from memory.
    const CACHE_BLOCK = 1 * 1024 * 1024;  // 1MB per cached block
    const MAX_CACHE_BLOCKS = 64;           // 64MB max memory
    const _blockCache = new Map();          // key: `${streamId}:${blockIdx}` → Uint8Array

    // Fetch from cache or download a full block
    const _cachedFetch = async (client, doc, streamId, start, size) => {
        const fileSize = Number(doc.size);
        const blockIdx = Math.floor(start / CACHE_BLOCK);
        const cacheKey = `${streamId}:${blockIdx}`;

        let block = _blockCache.get(cacheKey);
        if (!block) {
            // Download block using safe parallel fetcher
            const blockStart = blockIdx * CACHE_BLOCK;
            const blockSize = Math.min(CACHE_BLOCK, fileSize - blockStart);
            try {
                block = await fetchTelegramRangeAndroid(client, doc, blockStart, blockSize);
            } catch (e) {
                console.warn('[Electron] fetchTelegramRangeAndroid failed directly, falling back', e);
                block = await fetchTelegramRange(client, doc, blockStart, blockSize);
            }
            _blockCache.set(cacheKey, block);

            if (_blockCache.size > MAX_CACHE_BLOCKS) {
                const oldest = _blockCache.keys().next().value;
                _blockCache.delete(oldest);
            }
        }

        const offsetInBlock = start - (blockIdx * CACHE_BLOCK);
        const chunk = block.slice(offsetInBlock, offsetInBlock + size);
        return new Uint8Array(chunk);
    };

    const _processRange = async (requestId, streamId, start, size) => {
        const info = streamRegistry.get(streamId);
        if (!info) return;

        try {
            const chunk = await _cachedFetch(info.client, info.doc, streamId, start, size);
            window.cineflix.stream.replyRange(requestId, chunk.buffer);
        } catch (error) {
            console.error('[Electron] fetchRange error:', error);
            window.cineflix.stream.replyRange(requestId, new ArrayBuffer(0));
        }
    };

    // Process strictly 1 block download concurrently to absolutely guarantee zero FloodWaits
    let _activeReqs = 0;
    const _queue = [];

    const _runNext = () => {
        while (_activeReqs < 1 && _queue.length > 0) {
            _activeReqs++;
            const args = _queue.shift();
            _processRange(...args).finally(() => { _activeReqs--; _runNext(); });
        }
    };

    window.cineflix.stream.onFetchRange(({ requestId, streamId, start, size }) => {
        // If a new request comes in, any queued requests are from dead/aborted sockets (seeks).
        // Clear the queue so the new seek gets immediate priority.
        _queue.length = 0;
        _queue.push([requestId, streamId, start, size]);
        _runNext();
    });
}

/**
 * Play in embedded MPV (Electron only).
 * @param {Array} playlistArray - videos to play
 * @param {string} seriesTitle
 * @param {number} startIndex
 * @param {Promise|null} introDataPromise - resolves to { introStartMs, introEndMs, theIntroDbCreditsMs }
 */
export async function playInMpv(playlistArray, seriesTitle, startIndex = 0, introDataPromise = null) {
    initElectronStreamHandler();

    // Get the Telegram client ONCE (not per-episode)
    const c = await getClient();

    // Prepare all stream metadata synchronously (no awaits needed)
    const prepared = playlistArray.map((v, i) => {
        const media = v.media || v;
        const doc = media.document;
        const streamId = `${doc.id.toString()}-${Date.now()}-${i}`;
        const label = v.displayTitle || (v.caption || v.fileName || v.title || seriesTitle || '').replace(/\.[^.]+$/, '');
        streamRegistry.set(streamId, { client: c, doc });
        return { streamId, doc, label, v };
    });

    // Register ALL streams in PARALLEL (instead of one-by-one)
    await Promise.all(prepared.map(p =>
        window.cineflix.stream.register(p.streamId, {
            size: Number(p.doc.size),
            mimeType: p.doc.mimeType || 'video/mp4',
        })
    ));

    const streamInfos = prepared.map(p => ({
        streamId: p.streamId,
        fileSize: Number(p.doc.size),
        mimeType: p.doc.mimeType || 'video/mp4',
        title: p.label,
        // Preserve any intro data already attached to the video object
        introStartMs: p.v.introStartMs,
        introEndMs: p.v.introEndMs,
        creditsStartMs: p.v.creditsStartMs,
    }));

    if (streamInfos.length === 0) return;

    // Resolve intro data from promise if provided (parallel fetch from main.js)
    if (introDataPromise) {
        try {
            const introData = await introDataPromise;
            if (introData && streamInfos[startIndex]) {
                if (introData.introStartMs) streamInfos[startIndex].introStartMs = Number(introData.introStartMs);
                if (introData.introEndMs) streamInfos[startIndex].introEndMs = Number(introData.introEndMs);
                if (introData.theIntroDbCreditsMs) streamInfos[startIndex].creditsStartMs = Number(introData.theIntroDbCreditsMs);
            }
        } catch {}
    }

    // Launch MPV
    const res = await window.cineflix.player.launch({
        playlist: streamInfos,
        startIndex,
        seriesTitle
    });

    if (res && !res.ok) {
        throw new Error(res.error || 'No se pudo abrir el reproductor');
    }
}

// ===== SERVICE WORKER STREAMING =====

/**
 * Fetch a specific byte range from a Telegram document.
 * IMPORTANT: GramJS uses the 'big-integer' library, NOT native JS BigInt.
 * IMPORTANT: Telegram only allows limit values of 4KB, 128KB or 512KB.
 */
async function fetchTelegramRange(tgClient, doc, start, size) {
    const BLOCK = 4096;
    const alignedStart = Math.floor(start / BLOCK) * BLOCK;

    const needed = (start - alignedStart) + size;
    let received = new Uint8Array(needed);
    let ptr = 0;
    
    for await (const chunk of tgClient.iterDownload({
        file: new Api.InputDocumentFileLocation({
            id: doc.id,
            accessHash: doc.accessHash,
            fileReference: doc.fileReference,
            thumbSize: '',
        }),
        offset: typeof doc.size === 'bigint' ? BigInt(alignedStart) : bigInt(alignedStart),
        requestSize: 524288,
        dcId: doc.dcId,
    })) {
        const chunkLen = Math.min(chunk.length, needed - ptr);
        received.set(new Uint8Array(chunk.slice(0, chunkLen)), ptr);
        ptr += chunkLen;
        if (ptr >= needed) break;
    }

    if (ptr === 0) return new Uint8Array(0);
    const trimStart = start - alignedStart;
    const usableBytes = Math.max(0, ptr - trimStart);
    const finalChunk = received.subarray(trimStart, trimStart + Math.min(size, usableBytes));
    
    // Memory purification for MessageChannel/IPC
    const pureBuffer = new ArrayBuffer(finalChunk.byteLength);
    new Uint8Array(pureBuffer).set(finalChunk);
    return new Uint8Array(pureBuffer);
}

async function fetchTelegramRangeAndroid(tgClient, doc, start, size) {
    // Límite máximo permitido por Telegram por cada conexión: 512 KB
    const LIMIT = 524288;
    const ALIGN_BLOCK = 4096;
    
    // Alinear siempre la solicitud a múltiplos de 4KB por exigencia estricta de Telegram
    const alignedStart = Math.floor(start / ALIGN_BLOCK) * ALIGN_BLOCK;
    const alignedEnd = Math.ceil((start + size) / ALIGN_BLOCK) * ALIGN_BLOCK;
    const totalNeededBytes = alignedEnd - alignedStart;
    
    // Trocear la solicitud completa de ExoPlayer en bloques pequeños de 512 KB
    const chunks = [];
    for (let offset = 0; offset < totalNeededBytes; offset += LIMIT) {
        chunks.push({
            relativeOffset: offset,
            requestOffset: alignedStart + offset,
            requestSize: Math.min(LIMIT, totalNeededBytes - offset)
        });
    }

    // Descargar en ráfagas de 2 conexiones en paralelo (Multiplexing MTProto nativo optimizado para evitar baneos)
    const MAX_CONCURRENT = 2;
    const results = new Uint8Array(totalNeededBytes);
    
    for (let i = 0; i < chunks.length; i += MAX_CONCURRENT) {
        const batch = chunks.slice(i, i + MAX_CONCURRENT);
        const promises = batch.map(async (chunkInfo) => {
            let receivedBytes = null;
            
            // Mecanismo de supervivencia y reintentos por caída
            for (let retries = 0; retries < 3; retries++) {
                try {
                    const result = await tgClient.invoke(new Api.upload.GetFile({
                        location: new Api.InputDocumentFileLocation({
                            id: doc.id,
                            accessHash: doc.accessHash,
                            fileReference: doc.fileReference,
                            thumbSize: ''
                        }),
                        offset: typeof doc.size === 'bigint' ? BigInt(chunkInfo.requestOffset) : bigInt(chunkInfo.requestOffset),
                        limit: chunkInfo.requestSize
                    }));
                    receivedBytes = result.bytes;
                    break;
                } catch (e) {
                    if (e.message && e.message.includes('FLOOD')) {
                        await new Promise(r => setTimeout(r, 1000));
                        continue;
                    }
                    throw e;
                }
            }
            if (!receivedBytes) throw new Error('Chunk download failed');
            
            // Copiar al Buffer Maestro una vez llega
            results.set(receivedBytes, chunkInfo.relativeOffset);
        });
        
        await Promise.all(promises);
    }
    
    // Si Telegram nos mandó datos de más en la alineación, recortamos estrictamente a lo pedido
    const trimStart = start - alignedStart;
    return results.slice(trimStart, trimStart + size);
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
    // ── Electron path: stream via local HTTP server → MPV ───────────────────
    if (window.cineflix?.isElectron) {
        initElectronStreamHandler();
        const c = await getClient();
        const doc = media.document;
        const streamId = `${doc.id.toString()}-${Date.now()}`;
        streamRegistry.set(streamId, { client: c, doc });
        await window.cineflix.stream.register(streamId, {
            size: Number(doc.size),
            mimeType: doc.mimeType || 'video/mp4',
        });
        return { streamId, fileSize: Number(doc.size), mimeType: doc.mimeType || 'video/mp4' };
    }

    // ── Smart TV detection ──────────────────────────────────────────────────
    // Samsung Tizen, LG WebOS, Sony BRAVIA, etc. have broken ReadableStream
    // support in Service Worker fetch responses. Videos get stuck in a
    // play/pause loop, show black screen, or pixelate heavily.
    // Skip the SW entirely on these devices → use MSE progressive buffering.
    const _isTVBrowser = /SmartTV|Tizen|Web0S|WebOS|BRAVIA|Viera|NetCast|HbbTV|SMART-TV|SmartHubTV/i.test(navigator.userAgent);

    if (!_isTVBrowser) {
        // Always re-init SW port before playing — the browser can restart the SW
        // after idle periods, resetting its in-memory state (port = null).
        // Re-initializing takes < 50ms when the SW is already active.
        await initServiceWorker();
    } else {
        console.log('[Stream] Smart TV detected — skipping Service Worker, using MSE/progressive fallback');
    }

    const c = await getClient();
    const doc = media.document;
    const fileSize = Number(doc.size);
    const mimeType = doc.mimeType || 'video/mp4';

    // ── Helper: MSE progressive buffering ───────────────────────────────────
    // Downloads 512KB chunks from Telegram and feeds them to the video element
    // incrementally. Playback starts as soon as enough data is buffered (canplay).
    // Uses a sliding window to prevent memory exhaustion on Smart TVs:
    // removes already-played data from the SourceBuffer periodically.
    const _streamViaMSE = async () => {
        console.log('[Stream] Using MSE progressive buffering');
        const fileLocation = new Api.InputDocumentFileLocation({
            id: doc.id, accessHash: doc.accessHash,
            fileReference: doc.fileReference, thumbSize: '',
        });
        const ms = new MediaSource();
        videoElement.src = URL.createObjectURL(ms);
        await new Promise(r => ms.addEventListener('sourceopen', r, { once: true }));
        const sb = ms.addSourceBuffer(mimeType);
        let dl = 0, started = false;
        const waitUpdate = () => new Promise(r => sb.addEventListener('updateend', r, { once: true }));

        // ── Sliding window: evict played data to keep memory bounded ────────
        // Smart TVs typically have 300-512MB total for the browser process.
        // We purge data behind the playhead every ~20MB of new downloads.
        const EVICT_INTERVAL = 20 * 1024 * 1024; // check every 20MB
        const KEEP_BEHIND = 30; // keep 30 seconds behind current position
        let lastEvictAt = 0;

        const evictPlayed = async () => {
            try {
                const ct = videoElement.currentTime;
                if (ct < KEEP_BEHIND + 5) return; // not enough played yet
                const removeEnd = ct - KEEP_BEHIND;
                if (sb.buffered.length > 0 && sb.buffered.start(0) < removeEnd) {
                    if (sb.updating) await waitUpdate();
                    sb.remove(0, removeEnd);
                    if (sb.updating) await waitUpdate();
                    console.log(`[Stream] Evicted buffer 0-${removeEnd.toFixed(1)}s (currentTime: ${ct.toFixed(1)}s)`);
                }
            } catch (e) {
                console.warn('[Stream] Evict error (non-fatal):', e.message);
            }
        };

        videoElement.addEventListener('canplay', () => {
            if (!started) { started = true; videoElement.play().catch(() => {}); }
        }, { once: true });

        for await (const chunk of c.iterDownload({ file: fileLocation, requestSize: 512 * 1024, dcId: doc.dcId, fileSize: doc.size })) {
            if (sb.updating) await waitUpdate();
            sb.appendBuffer(new Uint8Array(chunk));
            dl += chunk.length;
            onProgress?.({ downloaded: dl, total: fileSize, percent: Math.round(dl / fileSize * 100), ready: false });

            // Periodically evict played data to free memory
            if (dl - lastEvictAt >= EVICT_INTERVAL) {
                lastEvictAt = dl;
                await evictPlayed();
            }
        }
        if (sb.updating) await waitUpdate();
        ms.endOfStream();
        if (!started) videoElement.play().catch(() => {});
    };

    // ── Helper: Full blob download ──────────────────────────────────────────
    const _streamViaBlob = async () => {
        console.log('[Stream] Using full blob download');
        const fileLocation = new Api.InputDocumentFileLocation({
            id: doc.id, accessHash: doc.accessHash,
            fileReference: doc.fileReference, thumbSize: '',
        });
        const chunks = []; let dl = 0;
        for await (const chunk of c.iterDownload({ file: fileLocation, requestSize: 512 * 1024, dcId: doc.dcId, fileSize: doc.size })) {
            chunks.push(new Uint8Array(chunk));
            dl += chunk.length;
            onProgress?.({ downloaded: dl, total: fileSize, percent: Math.round(dl / fileSize * 100), ready: false });
        }
        videoElement.src = URL.createObjectURL(new Blob(chunks, { type: mimeType }));
        videoElement.play().catch(() => {});
    };

    // ── Helper: Use best available fallback (MSE → Blob) ────────────────────
    const _streamFallback = async () => {
        if (typeof MediaSource !== 'undefined' && MediaSource.isTypeSupported(mimeType)) {
            await _streamViaMSE();
        } else {
            await _streamViaBlob();
        }
    };

    // ── Smart TV: skip SW entirely, go straight to MSE/blob ─────────────────
    if (_isTVBrowser) {
        await _streamFallback();
        return;
    }

    // ── Normal browser: try Service Worker, fall back to MSE on error ────────
    if (swPort) {
        const streamId = `${doc.id.toString()}-${Date.now()}`;
        streamRegistry.set(streamId, { client: c, doc });

        const reg = await navigator.serviceWorker.ready;
        reg.active.postMessage({
            type: 'REGISTER',
            streamId,
            fileSize,
            mimeType,
        });

        await new Promise(r => setTimeout(r, 100));

        // Set up error recovery: if the SW-based video fails to play,
        // automatically retry with MSE progressive buffering.
        const swFallbackPromise = new Promise((resolve, reject) => {
            let settled = false;

            const onCanPlay = () => {
                if (!settled) { settled = true; cleanup(); resolve(); }
            };
            const onError = () => {
                if (!settled) {
                    settled = true;
                    cleanup();
                    console.warn('[Stream] SW playback failed, falling back to MSE');
                    videoElement.src = '';
                    streamRegistry.delete(streamId);
                    reject(new Error('SW_PLAYBACK_FAILED'));
                }
            };
            // If the video hasn't started playing after 15s, the SW is probably broken
            const timeout = setTimeout(() => {
                if (!settled && videoElement.readyState < 2) {
                    settled = true;
                    cleanup();
                    console.warn('[Stream] SW playback timeout (15s), falling back to MSE');
                    videoElement.src = '';
                    streamRegistry.delete(streamId);
                    reject(new Error('SW_PLAYBACK_TIMEOUT'));
                }
            }, 15000);

            const cleanup = () => {
                clearTimeout(timeout);
                videoElement.removeEventListener('canplay', onCanPlay);
                videoElement.removeEventListener('error', onError);
            };

            videoElement.addEventListener('canplay', onCanPlay, { once: true });
            videoElement.addEventListener('error', onError, { once: true });
        });

        videoElement.src = (import.meta.env.BASE_URL || '/') + `tg-stream/${streamId}`;

        videoElement.addEventListener('ended', () => {
            streamRegistry.delete(streamId);
        }, { once: true });

        try {
            await swFallbackPromise;
            return; // SW playback is working fine
        } catch {
            // SW failed — fall through to MSE/blob
            console.log('[Stream] Retrying with MSE fallback after SW failure');
            await _streamFallback();
            return;
        }
    }

    // No SW available at all — use MSE/blob directly
    console.warn('[Stream] SW not ready, using MSE fallback');
    await _streamFallback();
}

// ===== NATIVE ANDROID STREAMING (Capacitor + ExoPlayer) =====
// Arquitectura Tevegram: ServerSocket local en Kotlin sirve HTTP Range
// mientras GramJS descarga chunks progresivamente desde Telegram.

/**
 * Check if the app is running inside Capacitor (Android/iOS).
 */
export function isNativeApp() {
    // On Android: Kotlin injects window.AndroidBridge (old) or we use window.Capacitor (new)
    return !!(window.AndroidBridge) || !!(window.Capacitor && window.Capacitor.isNative);
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

export async function streamVideoNative(videoObj, introStartMs = '', introEndMs = '', theIntroDbCreditsMs = '') {
    // Extract chatId and msgId — normalize to string
    let chatId = videoObj.chatId;
    let msgId  = videoObj.msgId;

    if (chatId && typeof chatId === 'object' && chatId.value) {
        chatId = chatId.value.toString();
    } else if (chatId) {
        chatId = chatId.toString();
    }

    if (!chatId || !msgId) {
        throw new Error('No se pudo obtener chatId/msgId para reproducción nativa.');
    }

    const fileId   = (videoObj.fileId   ?? 0).toString();
    const fileSize = (videoObj.fileSize  ?? 0).toString();
    const mimeType = (videoObj.mimeType  ?? 'video/mp4');
    const title    = videoObj.caption || videoObj.fileName || 'Episodio';

    console.log('[Native] 🎬 Streaming — chatId:', chatId, 'msgId:', msgId, 'fileId:', fileId, 'size:', fileSize);
    console.log('[Native] 🎬 IntroDB — introStart:', introStartMs, 'introEnd:', introEndMs, 'credits:', theIntroDbCreditsMs);

    // Try to extract watch progress metadata
    let phone = '';
    let contentId = '';
    let season = '';
    let episode = '';
    
    let creditsStartStr = '';
    try {
        phone = await getUserPhone() || '';
        if (window.currentWatchContext) {
            contentId = window.currentWatchContext.content_id || '';
            season = window.currentWatchContext.season != null ? window.currentWatchContext.season.toString() : '';
            episode = window.currentWatchContext.episode != null ? window.currentWatchContext.episode.toString() : '';
            
            if (window.creditsDB && window.creditsDB[contentId] && window.creditsDB[contentId][`${season}x${episode}`]) {
                creditsStartStr = window.creditsDB[contentId][`${season}x${episode}`].toString();
            }
        }
    } catch (e) {
        console.warn("[Native] Could not extract progress metadata:", e);
    }

    // ── DIAGNOSTIC: Log which bridge methods are available ──
    console.log('[Native] 🔍 BRIDGE METHODS AVAILABLE:',
        'playVideoWithIntroDB=', !!window.AndroidBridge.playVideoWithIntroDB,
        'playVideoWithCredits=', !!window.AndroidBridge.playVideoWithCredits,
        'playVideoWithProgress=', !!window.AndroidBridge.playVideoWithProgress,
        'playVideo=', !!window.AndroidBridge.playVideo
    );
    console.log('[Native] 🔍 BRIDGE DATA: contentId=', contentId, 'season=', season, 'episode=', episode,
        'creditsStartStr=', creditsStartStr, 'introStartMs=', introStartMs, 'introEndMs=', introEndMs,
        'theIntroDbCreditsMs=', theIntroDbCreditsMs
    );

    if (window.AndroidBridge.playVideoWithIntroDB) {
        console.log('[Native] ✅ Using playVideoWithIntroDB (full TheIntroDB data)');
        // New bridge method with full TheIntroDB data (intro + credits)
        window.AndroidBridge.playVideoWithIntroDB(
            chatId,
            msgId.toString(),
            fileId,
            fileSize,
            mimeType,
            title,
            phone,
            contentId,
            season,
            episode,
            creditsStartStr,
            introStartMs,
            introEndMs,
            theIntroDbCreditsMs
        );
    } else if (window.AndroidBridge.playVideoWithCredits) {
        console.warn('[Native] ⚠️ FALLBACK: Using playVideoWithCredits (NO IntroDB data will reach player!)');
        window.AndroidBridge.playVideoWithCredits(
            chatId,
            msgId.toString(),
            fileId,
            fileSize,
            mimeType,
            title,
            phone,
            contentId,
            season,
            episode,
            creditsStartStr
        );
    } else if (window.AndroidBridge.playVideoWithProgress) {
        console.warn('[Native] ⚠️ FALLBACK: Using playVideoWithProgress (NO credits or IntroDB!)');
        window.AndroidBridge.playVideoWithProgress(
            chatId,
            msgId.toString(),
            fileId,
            fileSize,
            mimeType,
            title,
            phone,
            contentId,
            season,
            episode
        );
    } else {
        console.error('[Native] 🚨 FALLBACK: Using playVideo (oldest APK — NO progress, credits, or IntroDB!)');
        window.AndroidBridge.playVideo(
            chatId,
            msgId.toString(),
            fileId,
            fileSize,
            mimeType,
            title
        );
    }
}



/**
 * Android Mobile Fallback: Capacitor ExoPlayer Plugin with base64 chunks proxy.
 */
export async function streamVideoMobileCapacitor(videoObj) {
    const media = videoObj.media ? videoObj.media : videoObj;
    const ExoPlayer = window.Capacitor?.Plugins?.ExoPlayer;
    if (!ExoPlayer) throw new Error('Capacitor ExoPlayer plugin no disponible');
    
    const c = await getClient();
    const doc = media.document;

    let fileSize;
    try {
        fileSize = typeof doc.size === 'bigint' ? Number(doc.size) : Number(String(doc.size));
    } catch { fileSize = 0; }
    fileSize = Math.floor(fileSize);

    if (!fileSize || fileSize <= 0 || isNaN(fileSize)) {
        throw new Error('No se pudo obtener el tamaño del archivo');
    }

    const mimeType = doc.mimeType || 'video/mp4';
    console.log('[Native Mobile] Iniciando stream reactivo (fetchRange):', fileSize, 'bytes,', mimeType);

    let wakeLock = null;

    // Adquirir Wakelock del navegador para que no se apague la pantalla ni el puente JS
    if ('wakeLock' in navigator) {
        try {
            wakeLock = await navigator.wakeLock.request('screen');
            console.log('[Native Mobile] ☀️ Wakelock de pantalla activado');
        } catch (err) {
            console.warn('[Native Mobile] No se pudo activar Wakelock:', err.message);
        }
    }

    const streamId = `${doc.id.toString()}-${Date.now()}`;
    await ExoPlayer.registerStream({ streamId, fileSize, mimeType });

    // Escuchar peticiones bajo demanda para soportar saltos temporales (seeking)
    const listener = await ExoPlayer.addListener('fetchRange', async ({ requestId, start, size }) => {
        try {
            let chunk;
            try {
                chunk = await fetchTelegramRangeAndroid(c, doc, start, size);
            } catch (err) {
                if (err.message && err.message.toLowerCase().includes('disconnect')) {
                    console.warn('[Native Stream] Reparando socket cerrado de Telegram...');
                    await c.connect();
                    chunk = await fetchTelegramRangeAndroid(c, doc, start, size);
                } else {
                    throw err;
                }
            }
            
            // TUBERÍA BINARIA PURA (Loopback)
            const response = await fetch(`http://127.0.0.1:3999/deliverChunk?requestId=${requestId}`, {
                method: 'POST',
                body: chunk 
            });

            if (!response.ok) {
                throw new Error('Native IPC Pipe Server reject: ' + response.statusText);
            }
        } catch (err) {
            console.error('[Native Stream] fetchRange error:', err.message);
            await fetch(`http://127.0.0.1:3999/deliverChunk?requestId=${requestId}`, {
                method: 'POST',
                body: new Uint8Array(0) 
            }).catch(() => {});
        }
    });

    console.log('[Native Mobile] ▶️ Lanzando reproductor interactivo...');
    await ExoPlayer.play({ streamId });

    // Auto-limpieza tras 4 horas maximo
    setTimeout(() => {
        listener?.remove?.();
        if (wakeLock) {
            wakeLock.release().catch(()=>{});
        }
    }, 4 * 60 * 60 * 1000);
}


