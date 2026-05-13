import { TelegramClient, Api } from 'telegram';
import { StringSession } from 'telegram/sessions';
import { computeCheck } from 'telegram/Password';
import bigInt from 'big-integer';

const API_ID       = 25193949;
const API_HASH     = '0523cf42fe71db02eeaa8ba52124c826';
const BOT_USERNAME = 'videoclubpacobot';
const SESSION_KEY  = 'tg_session';

let client    = null;
let phoneHash = null;

// streamId → { doc } — needed so we can answer fetchRange from the HTTP server
const streamRegistry = new Map();

// ── Is running inside Electron? ───────────────────────────────────────────────
const isElectron = () => !!(window.cineflix?.isElectron);

// ── Session: in Electron use the persistent store, otherwise localStorage ─────
async function getSavedSession() {
    if (isElectron()) return (await window.cineflix.store.get(SESSION_KEY)) || '';
    return localStorage.getItem(SESSION_KEY) || '';
}

async function saveSession() {
    if (!client) return;
    const s = client.session.save();
    if (isElectron()) await window.cineflix.store.set(SESSION_KEY, s);
    else localStorage.setItem(SESSION_KEY, s);
}

// ── Client ────────────────────────────────────────────────────────────────────
export async function getClient() {
    if (client && client.connected) return client;
    const session = new StringSession(await getSavedSession());
    client = new TelegramClient(session, API_ID, API_HASH, {
        connectionRetries: 5,
        useWSS: true,
    });
    await client.connect();
    return client;
}

// ── Auth ──────────────────────────────────────────────────────────────────────
export async function isLoggedIn() {
    try {
        await getClient();
        const me = await client.getMe();
        if (!me) return false;
        await client.getDialogs({ limit: 1 });

        // In Electron: start listening for fetch-range events from the stream server
        if (isElectron()) initElectronStreamHandler();

        return true;
    } catch (err) {
        const msg = (err.message || '').toUpperCase();
        if (msg.includes('SESSION_PASSWORD_NEEDED') || msg.includes('AUTH_KEY') || msg.includes('UNAUTHORIZED')) {
            if (isElectron()) await window.cineflix.store.delete(SESSION_KEY);
            else localStorage.removeItem(SESSION_KEY);
            client = null;
        }
        return false;
    }
}

export async function sendCode(phone, isRetry = false) {
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
            if (isElectron()) await window.cineflix.store.delete(SESSION_KEY);
            else localStorage.removeItem(SESSION_KEY);
            
            await new Promise(r => setTimeout(r, 1000));
            return await sendCode(phone, true);
        }
        throw err;
    }
}

export async function verifyCode(phone, code) {
    try {
        await client.invoke(new Api.auth.SignIn({
            phoneNumber: phone,
            phoneCodeHash: phoneHash,
            phoneCode: code,
        }));
        await saveSession();
        if (isElectron()) initElectronStreamHandler();
        return { success: true, needs2FA: false };
    } catch (err) {
        if ((err.message || '').includes('SESSION_PASSWORD_NEEDED')) {
            return { success: false, needs2FA: true };
        }
        throw err;
    }
}

export async function verify2FA(password) {
    const pwdInfo   = await client.invoke(new Api.account.GetPassword());
    const pwdBuffer = Buffer.from(password, 'utf-8');
    const inputCheck = await computeCheck(pwdInfo, pwdBuffer);
    await client.invoke(new Api.auth.CheckPassword({ password: inputCheck }));
    await saveSession();
    if (isElectron()) initElectronStreamHandler();
    return { success: true };
}

export async function logout() {
    try { await client.invoke(new Api.auth.LogOut()); } catch {}
    if (isElectron()) await window.cineflix.store.delete(SESSION_KEY);
    else localStorage.removeItem(SESSION_KEY);
    client = null;
}

// ── Bot interaction ───────────────────────────────────────────────────────────
export async function sendBotCommand(payload) {
    const c   = await getClient();
    const bot = await c.getEntity(BOT_USERNAME);
    await c.sendMessage(bot, { message: `/start ${payload}` });
    await new Promise(r => setTimeout(r, 2500));
    const messages = await c.getMessages(bot, { limit: 5 });

    for (const msg of messages) {
        if (msg.replyMarkup?.rows) {
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
    const c   = await getClient();
    const bot = await c.getEntity(BOT_USERNAME);
    const MAX_RETRIES = 3;
    for (let attempt = 1; attempt <= MAX_RETRIES; attempt++) {
        try {
            await c.invoke(new Api.messages.GetBotCallbackAnswer({
                peer: bot, msgId, data: Buffer.from(data, 'utf8'),
            }));
            await new Promise(r => setTimeout(r, 3000));
            return true;
        } catch (err) {
            const isBotTimeout = err?.message?.includes('BOT_RESPONSE_TIMEOUT');
            if (isBotTimeout && attempt < MAX_RETRIES) {
                await new Promise(r => setTimeout(r, 2000 * attempt));
            } else {
                throw err;
            }
        }
    }
}

export async function searchMovieByPayload(searchTitle) {
    const c   = await getClient();
    const bot = await c.getEntity(BOT_USERNAME);
    const sentMsg = await c.sendMessage(bot, { message: `/peli ${searchTitle}` });
    await new Promise(r => setTimeout(r, 4000));
    return await getVideoMessages(30, sentMsg.id);
}

export async function getVideoMessages(limit = 50, minId = 0) {
    const c   = await getClient();
    const bot = await c.getEntity(BOT_USERNAME);
    const messages = await c.getMessages(bot, { limit, minId: minId || 0 });
    const videos = [];

    for (const msg of messages) {
        if (!msg.media?.document) continue;
        const doc = msg.media.document;
        let isVideo = false, fileName = '', width = 0, height = 0, duration = 0;

        for (const attr of doc.attributes || []) {
            const cn = (attr.className || '').toLowerCase();
            if (cn === 'documentattributevideo' || (attr.duration !== undefined && attr.w !== undefined)) {
                isVideo = true;
                width    = attr.w || 0;
                height   = attr.h || 0;
                duration = Math.round(attr.duration || 0);
            }
            if (cn === 'documentattributefilename' || (attr.fileName && !attr.duration)) {
                if (attr.fileName) fileName = attr.fileName;
            }
        }
        if (!isVideo) continue;

        if (!fileName) {
            const cap = (msg.message || '').trim();
            fileName = cap || `video_${msg.id}.mp4`;
        }
        if (!fileName.includes('.')) fileName += '.mp4';

        videos.push({
            msgId: msg.id, fileName,
            fileSize: Number(doc.size),
            mimeType: doc.mimeType || 'video/mp4',
            width, height, duration,
            date: msg.date, caption: msg.message || '',
            media: msg.media,
        });
    }
    return videos;
}

// ── Telegram byte-range fetching (shared by SW and Electron stream server) ────
async function fetchTelegramRange(tgClient, doc, start, size) {
    const VALID_LIMITS = [4096, 131072, 524288];
    const BLOCK        = 4096;
    const alignedStart = Math.floor(start / BLOCK) * BLOCK;
    const needed       = (start - alignedStart) + size;
    const limit        = VALID_LIMITS.find(v => v >= needed) || VALID_LIMITS[VALID_LIMITS.length - 1];

    let received = null;
    for await (const chunk of tgClient.iterDownload({
        file: new Api.InputDocumentFileLocation({
            id: doc.id, accessHash: doc.accessHash,
            fileReference: doc.fileReference, thumbSize: '',
        }),
        offset: bigInt(alignedStart),
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

// ── Electron: IPC stream handler ──────────────────────────────────────────────
// The local HTTP server in the main process asks the renderer for bytes.
// We listen for 'stream:fetchRange' and reply with 'stream:replyRange'.

let _electronHandlerActive = false;
function initElectronStreamHandler() {
    if (!isElectron() || _electronHandlerActive) return;
    _electronHandlerActive = true;

    window.cineflix.stream.onFetchRange(async ({ requestId, streamId, start, size }) => {
        const info = streamRegistry.get(streamId);
        if (!info) {
            // Reply with empty buffer rather than hanging
            window.cineflix.stream.replyRange(requestId, new ArrayBuffer(0));
            return;
        }
        try {
            const c     = await getClient();
            const chunk = await fetchTelegramRange(c, info.doc, start, size);
            window.cineflix.stream.replyRange(requestId, chunk.buffer);
        } catch (err) {
            console.error('[ElectronStream] fetchRange error:', err.message);
            window.cineflix.stream.replyRange(requestId, new ArrayBuffer(0));
        }
    });
}

/**
 * Stream a video file using MPV (Electron desktop) or Service Worker (web).
 * In Electron: registers the stream with the local HTTP server and launches MPV.
 * In web: falls through to Service Worker streaming.
 */
export async function streamVideo(media, videoElement, onProgress) {
    const doc      = media.document;
    const fileSize = Number(doc.size);
    const mimeType = doc.mimeType || 'video/mp4';

    // ── Electron path: stream via local HTTP server → MPV ───────────────────
    if (isElectron()) {
        const streamId = `${doc.id.toString()}-${Date.now()}`;

        // Keep doc in our local registry so IPC handler can fetch ranges
        streamRegistry.set(streamId, { doc });

        // Tell the main process HTTP server about this stream's metadata
        await window.cineflix.stream.register(streamId, {
            size:     fileSize,
            mimeType: mimeType,
        });

        return { streamId, fileSize, mimeType };
    }

    // ── Web path: Service Worker streaming ───────────────────────────────────
    await initServiceWorker();
    // ... (existing SW logic below)
    return null;
}

/**
 * Play in embedded MPV (Electron only).
 * Opens the integrated player: MPV renders into a native window (--wid),
 * transparent HTML controls float on top.
 */
export async function playInMpv(playlistArray, seriesTitle, startIndex = 0) {
    const streamInfos = [];
    
    // Register all chapters in the local server for MPV
    for (let i = 0; i < playlistArray.length; i++) {
        const v = playlistArray[i];
        let media = v.media || v;
        const result = await streamVideo(media, null, null);
        if (!result) continue;
        
        const label = v.displayTitle || (v.caption || v.fileName || v.title || seriesTitle || '').replace(/\.[^.]+$/, '');
        streamInfos.push({
            streamId: result.streamId,
            fileSize: result.fileSize,
            mimeType: result.mimeType,
            title: label,
        });
    }

    if (streamInfos.length === 0) return;

    // Send the whole batch to Electron Main
    const res = await window.cineflix.player.launch({
        playlist: streamInfos,
        startIndex,
        seriesTitle
    });

    if (res && !res.ok) {
        throw new Error(res.error || 'No se pudo abrir el reproductor');
    }
}

// ── Web-only: Service Worker ──────────────────────────────────────────────────

let swPort = null;

export async function initServiceWorker() {
    if (isElectron()) return true; // not needed in desktop app
    if (!('serviceWorker' in navigator)) { console.warn('[SW] Not supported'); return false; }

    try {
        const reg = await navigator.serviceWorker.register('/sw.js', { scope: '/' });
        await new Promise((resolve) => {
            const sw = reg.installing || reg.waiting || reg.active;
            if (reg.active && !reg.installing && !reg.waiting) { resolve(); return; }
            sw.addEventListener('statechange', function handler() {
                if (this.state === 'activated') { resolve(); sw.removeEventListener('statechange', handler); }
            });
        });
        await navigator.serviceWorker.ready;

        const channel = new MessageChannel();
        await new Promise((resolve) => {
            channel.port1.onmessage = (e) => { if (e.data?.type === 'READY') resolve(); };
            reg.active.postMessage({ type: 'INIT' }, [channel.port2]);
        });
        swPort = channel.port1;

        swPort.onmessage = async (e) => {
            const { type, requestId, streamId, start, size } = e.data;
            if (type !== 'FETCH_RANGE') return;
            const info = streamRegistry.get(streamId);
            if (!info) { swPort.postMessage({ requestId, error: 'Stream not found' }); return; }
            try {
                const chunk = await fetchTelegramRange(info.client, info.doc, start, size);
                swPort.postMessage({ requestId, chunk: chunk.buffer }, [chunk.buffer]);
            } catch (err) {
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
