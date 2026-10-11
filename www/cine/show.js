/* Sesión de cine: votación → carga → reproducción sincronizada en la pantalla de la sala.
   Se carga ANTES de app.js: solo define estado y funciones; las globales de app.js (net, view, netSend, toast…)
   se usan únicamente dentro de funciones que se llaman después de su carga. Todo texto remoto va por textContent. */
'use strict';
const SHOW_VER = (function () { try { return new URL(document.currentScript.src).searchParams.get('v') || ''; } catch (e) { return ''; } })();
const SHOW_NATIVE = !!(window.AndroidBridge || (window.Capacitor && window.Capacitor.isNative));

const SHOW = {
    phase: 'idle', candidates: [], votes: [], endsAt: 0, movie: null, startAt: 0, duration: 0, by: '', myVote: -1, cooldownUntil: 0,
    offset: 0, bestRtt: Infinity,
    key: '', prepared: false, preparing: false, status: '', error: '', blocked: false,
    expanded: false, soundOn: true, caps: [], engine: null, lastDur: 0
};
let showVideo = null, showPix = null, showPixCtx = null;

function srvNow() { return Date.now() + SHOW.offset; }

/* ── Reloj: el servidor es la referencia; se usa la muestra de menor latencia (RTT/2) ── */
function showClockSample(m) {
    if (!m || !m.c || !m.t) return;
    const rtt = Date.now() - m.c;
    if (rtt < 0 || rtt >= SHOW.bestRtt) return;
    SHOW.bestRtt = rtt;
    SHOW.offset = m.t + rtt / 2 - Date.now();
}
function showOnOpen() {
    SHOW.bestRtt = Infinity;
    [0, 350, 900].forEach(d => setTimeout(() => netSend({ type: 'ping', c: Date.now() }), d));
}

function showEl(id) { return document.getElementById(id); }
function showFmt(ms) {
    const s = Math.max(0, Math.ceil(ms / 1000));
    return Math.floor(s / 60) + ':' + String(s % 60).padStart(2, '0');
}
function showTitle(m) {
    if (!m) return '';
    const title = String(m.title || '');
    if (m.year && !title.includes(String(m.year))) return title + ' (' + m.year + ')';
    return title;
}

/* ── Estado del servidor ── */
function showOnState(st, fromJoin) {
    const prevPhase = SHOW.phase;
    if (st.serverNow && fromJoin !== true) {
        // muestra extra del reloj (sin RTT: solo si aún no hay una mejor)
        if (SHOW.bestRtt === Infinity) SHOW.offset = st.serverNow - Date.now();
    }
    SHOW.phase = st.phase;
    SHOW.candidates = st.candidates || [];
    SHOW.votes = st.votes || [];
    SHOW.endsAt = st.endsAt || 0;
    SHOW.movie = st.movie || null;
    SHOW.startAt = st.startAt || 0;
    SHOW.duration = st.duration || 0;
    SHOW.by = st.by || '';
    SHOW.isProposer = !!st.isProposer;
    SHOW.proposerKey = st.proposerKey || '';
    SHOW.cooldownUntil = st.cooldownUntil || 0;
    if (typeof st.myVote === 'number') SHOW.myVote = st.myVote;
    else if (st.phase !== 'voting' || prevPhase !== 'voting') SHOW.myVote = -1;   // nueva votación (o fuera de ella): sin voto
    if (st.notice) { try { toast(st.notice); } catch (e) {} }

    if (st.phase === 'idle') showStopPlayback();
    else if ((st.phase === 'loading' || st.phase === 'playing') && SHOW.movie) showStartPrepare();
    else if (st.phase === 'voting') showStopPlayback();

    // Si la película ya estaba preparada y pasamos a 'playing', asegurar reproducción inmediata
    if (st.phase === 'playing' && SHOW.prepared && showVideo && showVideo.paused) {
        showPlay();
    }
    showRender();
}

/* ── Preparación del vídeo (cada espectador desde su propia cuenta de Telegram) ── */
const nativeResolvers = new Map();
const prevOnTelegramCallback = window.onTelegramCallback;
window.onTelegramCallback = (queryId, success, payload) => {
    const r = nativeResolvers.get(queryId);
    if (r) {
        nativeResolvers.delete(queryId);
        if (success) {
            try { r.resolve(typeof payload === 'string' ? JSON.parse(payload) : payload); }
            catch (_) { r.resolve(payload); }
        } else {
            r.reject(new Error(payload));
        }
        return;
    }
    if (prevOnTelegramCallback) prevOnTelegramCallback(queryId, success, payload);
};

function callNativeCineStream(searchTitle, yearStr, fileMsgIdStr = '', multipartJsonStr = '') {
    return new Promise((resolve, reject) => {
        const queryId = 'cine_' + Date.now() + '_' + Math.random().toString(36).slice(2, 7);
        nativeResolvers.set(queryId, { resolve, reject });
        try {
            if (window.AndroidBridge && window.AndroidBridge.startCineScreenStreamWithMultipart) {
                window.AndroidBridge.startCineScreenStreamWithMultipart(queryId, String(searchTitle || ''), String(yearStr || ''), String(fileMsgIdStr || ''), String(multipartJsonStr || ''));
            } else if (window.AndroidBridge && window.AndroidBridge.startCineScreenStreamWithFile) {
                window.AndroidBridge.startCineScreenStreamWithFile(queryId, String(searchTitle || ''), String(yearStr || ''), String(fileMsgIdStr || ''));
            } else if (window.AndroidBridge && window.AndroidBridge.startCineScreenStream) {
                window.AndroidBridge.startCineScreenStream(queryId, String(searchTitle || ''), String(yearStr || ''));
            } else {
                nativeResolvers.delete(queryId);
                reject(new Error('NO_BRIDGE'));
            }
        } catch (e) {
            nativeResolvers.delete(queryId);
            reject(e);
        }
    });
}

function callNativeSearchMovie(searchTitle) {
    return new Promise((resolve, reject) => {
        const queryId = 'search_' + Date.now() + '_' + Math.random().toString(36).slice(2, 7);
        nativeResolvers.set(queryId, { resolve, reject });
        try {
            if (window.AndroidBridge && window.AndroidBridge.searchMovieByPayload) {
                window.AndroidBridge.searchMovieByPayload(queryId, String(searchTitle || ''));
            } else {
                nativeResolvers.delete(queryId);
                reject(new Error('NO_BRIDGE'));
            }
        } catch (e) {
            nativeResolvers.delete(queryId);
            reject(e);
        }
    });
}

function showLoadEngine() {
    if (window.__cineStreamMock) return Promise.resolve(window.__cineStreamMock);
    if (SHOW.engine) return Promise.resolve(SHOW.engine);
    return import('/cine/stream.bundle.js' + (SHOW_VER ? '?v=' + SHOW_VER : '')).then(mod => { SHOW.engine = mod.default || window.CineStream; return SHOW.engine; });
}
const SHOW_ERRORS = {
    NATIVE: '📺 Tu app aún no puede reproducirla en la sala; sigue el chat y las votaciones. En la web (PC) sí.',
    UNSUPPORTED: 'Este dispositivo no admite la reproducción en la sala.',
    NO_LOGIN: '🔒 Inicia sesión en Cineflix (Telegram) para ver la película.',
    NO_MP4: '🎞️ Esa película no tiene versión compatible.',
    NOT_FOUND: '🔎 El bot no ha encontrado la película.',
    FAILED: '⚠️ No se pudo preparar el vídeo.'
};
async function showStartPrepare() {
    const mv = SHOW.movie;
    const key = mv.id + ':' + SHOW.startAt;
    if (SHOW.key === key) return;
    SHOW.key = key; SHOW.prepared = false; SHOW.preparing = true; SHOW.error = ''; SHOW.status = ''; SHOW.blocked = false; SHOW.lastDur = 0;
    SHOW.lastSeekAt = 0; SHOW.lead = 0; SHOW.seekPending = false;
    showVideoEl();

    // Reproducción nativa en la app Android para la pantalla del cine
    if (window.AndroidBridge && window.AndroidBridge.startCineScreenStream) {
        SHOW.status = 'Cargando película en la app…'; showRender();
        try {
            const searchTitle = mv.search_title || mv.title;
            const yearStr = mv.year ? String(mv.year) : '';
            const fileMsgIdStr = mv.file_msg_id ? String(mv.file_msg_id) : '';
            const multipartJsonStr = (mv.payload_multipart && Array.isArray(mv.payload_multipart)) ? JSON.stringify(mv.payload_multipart) : '';
            const res = await callNativeCineStream(searchTitle, yearStr, fileMsgIdStr, multipartJsonStr);
            if (SHOW.key !== key) return;
            SHOW.nativeVideoInfo = res;
            showVideo.src = res.streamUrl;
            showVideo.load();
            SHOW.prepared = true;
            SHOW.preparing = false;
            SHOW.status = '✅ Película lista';
            showReportDuration(res.duration);
        } catch (e) {
            if (SHOW.key !== key) return;
            SHOW.preparing = false; SHOW.prepared = false;
            const msg = (e && e.message) || String(e);
            if (/AUTH_REQUIRED/.test(msg)) SHOW.error = SHOW_ERRORS.NO_LOGIN;
            else if (/NOT_FOUND/.test(msg)) SHOW.error = SHOW_ERRORS.NOT_FOUND;
            else SHOW.error = '⚠️ Error al cargar vídeo: ' + msg;
        }
        showRender();
        return;
    }

    if (SHOW_NATIVE && !window.__cineStreamMock) { SHOW.preparing = false; SHOW.error = SHOW_ERRORS.NATIVE; showRender(); return; }
    SHOW.status = 'Cargando el reproductor…'; showRender();
    try {
        const eng = await showLoadEngine();
        if (SHOW.key !== key) return;
        const r = await eng.prepare(mv, showVideo, (s) => { if (SHOW.key === key) { SHOW.status = s; showRender(); } });
        if (SHOW.key !== key) { try { eng.stop(showVideo); } catch (e) {} return; }
        SHOW.prepared = true; SHOW.preparing = false; SHOW.status = '✅ Película lista';
        showReportDuration(r && r.duration);
        if (SHOW.phase === 'playing' && SHOW.startAt) {
            const target = Math.max(0, (srvNow() - SHOW.startAt) / 1000);
            if (target > 1 && showVideo) {
                try { showVideo.currentTime = target; } catch (e) {}
            }
            showPlay();
        }
    } catch (e) {
        if (SHOW.key !== key) return;
        SHOW.preparing = false; SHOW.prepared = false;
        SHOW.error = (e && e.code && SHOW_ERRORS[e.code]) || (e && e.code === 'STOPPED' ? '' : SHOW_ERRORS.FAILED);
        if (e && e.code && !SHOW_ERRORS[e.code] && e.message) SHOW.error = e.message;
    }
    showRender();
}
function showReportDuration(sec) {
    sec = Number(sec) || 0;
    if (!(sec >= 10) && showVideo && isFinite(showVideo.duration)) sec = showVideo.duration;
    if (sec >= 10 && !SHOW.duration) netSend({ type: 'show_duration', sec: Math.round(sec) });
    else if (!(sec >= 10) && showVideo) {
        // duración aún desconocida: se informa cuando el vídeo la conozca
        const f = () => { if (isFinite(showVideo.duration) && showVideo.duration >= 10 && !SHOW.duration) netSend({ type: 'show_duration', sec: Math.round(showVideo.duration) }); };
        showVideo.addEventListener('loadedmetadata', f, { once: true });
    }
}
function showStopPlayback() {
    const had = SHOW.key !== '';
    SHOW.key = ''; SHOW.prepared = false; SHOW.preparing = false; SHOW.error = ''; SHOW.status = ''; SHOW.blocked = false;
    SHOW.nativeVideoInfo = null;
    if (window.AndroidBridge && window.AndroidBridge.stopCineScreenStream) {
        try { window.AndroidBridge.stopCineScreenStream(); } catch (e) {}
    }
    if (had) {
        try {
            const eng = window.__cineStreamMock || SHOW.engine;
            if (eng) eng.stop(showVideo); else if (showVideo) { showVideo.pause(); showVideo.removeAttribute('src'); }
        } catch (e) {}
    }
    if (SHOW.expanded) showSetExpanded(false);
    SHOW.caps = [];
}
/* Al salir de la sala o cambiar de sala */
function showResetLocal() {
    SHOW.phase = 'idle'; SHOW.candidates = []; SHOW.movie = null; SHOW.startAt = 0; SHOW.duration = 0; SHOW.myVote = -1;
    showStopPlayback();
    showRender();
}

function showVideoEl() {
    if (showVideo) return showVideo;
    showVideo = showEl('show-video');
    showVideo.muted = !SHOW.soundOn;
    if (SHOW.soundOn) showVideo.volume = 1;
    showVideo.playsInline = true;
    showVideo.setAttribute('playsinline', '');
    showVideo.addEventListener('error', () => { if (SHOW.prepared) { SHOW.error = SHOW_ERRORS.FAILED; showRender(); } });
    showVideo.addEventListener('seeked', () => { if (SHOW.seekPending) { SHOW.seekPending = false; SHOW.lead = Math.min(8, Math.max(0, (Date.now() - SHOW.lastSeekAt) / 1000)); } });
    return showVideo;
}
function showPlay() {
    const v = showVideoEl();
    if (!v) return;
    v.muted = !SHOW.soundOn;
    if (SHOW.soundOn) v.volume = 1;
    const p = v.play();
    if (p && p.catch) {
        p.then(() => {
            if (SHOW.blocked) { SHOW.blocked = false; showRender(); }
        }).catch((err) => {
            console.warn('[Show] Play error:', err);
        });
    }
}
function showSyncTick() {
    if (!SHOW.prepared || !showVideo || !SHOW.startAt || (SHOW.phase !== 'loading' && SHOW.phase !== 'playing')) return;
    const v = showVideo;
    const target = (srvNow() - SHOW.startAt) / 1000;
    if (target < 0) {   // aún no es la hora: preparado y en pausa al principio
        if (!v.paused) v.pause();
        if (v.currentTime > 0.5 && v.readyState >= 1) { try { v.currentTime = 0; } catch (e) {} }
        return;
    }
    if (SHOW.duration && target > SHOW.duration + 1) { if (!v.paused) v.pause(); return; }

    // Si ya es la hora o la película está en emisión, arrancar la reproducción inmediatamente
    if (v.paused && !v.ended) showPlay();

    // NUNCA hacer saltos (seek) si el vídeo está pausado, en proceso de seek, o sin buffer suficiente
    if (v.readyState < 2 || v.paused || v.seeking || SHOW.seekPending) return;

    const drift = target - v.currentTime;
    const limit = isFinite(v.duration) ? Math.max(0, v.duration - 0.5) : target;
    const since = Date.now() - (SHOW.lastSeekAt || 0);

    // Salto directo para sincronizar si el desfase es notable (> 5s)
    if (Math.abs(drift) > 5 && since > 4000) {
        SHOW.lastSeekAt = Date.now(); SHOW.seekPending = true;
        try { v.currentTime = Math.max(0, Math.min(target, limit)); } catch (e) {}
        v.playbackRate = 1;
        return;
    }

    // Micro-ajuste suave para drift moderado (2.5s - 5s)
    if (Math.abs(drift) > 2.5) {
        v.playbackRate = drift > 0 ? 1.03 : 0.97;
    } else if (v.playbackRate !== 1) {
        v.playbackRate = 1;
    }
}

/* ── Panel (debajo de la sala) ── */
function showBtn(label, key, onClick, cls) {
    const b = document.createElement('button');
    b.type = 'button'; b.className = 'tool-btn show-btn' + (cls ? ' ' + cls : ''); b.textContent = label; b.dataset.k = key;
    b.onclick = onClick;
    return b;
}
function showInCinema() { return typeof view !== 'undefined' && view === 'cinema' && net.wantRoom; }
let showCountEl = null;
function showRender() {
    const panel = showEl('show-panel');
    if (!panel) return;
    if (!showInCinema()) { panel.classList.add('hidden'); document.documentElement.style.setProperty('--show-h', '0px'); return; }
    panel.classList.remove('hidden');
    const focusKey = (document.activeElement && panel.contains(document.activeElement)) ? document.activeElement.dataset.k : null;
    panel.textContent = '';
    showCountEl = null;
    const head = document.createElement('div'); head.className = 'show-head';
    const msg = document.createElement('span'); msg.className = 'show-msg';
    const rowBtns = document.createElement('div'); rowBtns.className = 'show-btns';
    const st = document.createElement('div'); st.className = 'show-status';
    const seated = mySeat() >= 0;
    if (SHOW.phase === 'idle') {
        msg.textContent = '🎟️ Sesión de cine: elige del catálogo o 4 al azar (mín. 2 personas para iniciar)';
        rowBtns.appendChild(showBtn('🔍 Buscar en catálogo', 'propose-catalog', () => {
            if (!seated) return toast('Siéntate para proponer una película 🪑');
            openProposeModal();
        }, 'on'));
        rowBtns.appendChild(showBtn('🎲 4 al azar', 'propose-random', () => {
            if (!seated) return toast('Siéntate para proponer 🪑');
            netSend({ type: 'show_start' });
        }));
    } else if (SHOW.phase === 'voting') {
        if (SHOW.candidates.length === 1) {
            const single = SHOW.candidates[0];
            const isMyProposal = SHOW.isProposer || (SHOW.by && myCharacter.name === SHOW.by);
            if (isMyProposal) {
                msg.textContent = '🍿 Has propuesto «' + showTitle(single) + '». Esperando votos de la sala… ⏳ ';
                showCountEl = document.createElement('b'); showCountEl.id = 'show-count'; msg.appendChild(showCountEl);

                const nYes = SHOW.votes[0] || 0;
                const bYes = showBtn('✔ Tu propuesta · ' + nYes + (nYes === 1 ? ' voto' : ' votos'), 'vote0', null, 'on');
                bYes.disabled = true;
                bYes.style.cursor = 'default';
                rowBtns.appendChild(bYes);

                const nNo = SHOW.votes[1] || 0;
                if (nNo > 0) {
                    const bNo = showBtn('🔄 Rechazos: ' + nNo, 'vote1', null, '');
                    bNo.disabled = true;
                    bNo.style.cursor = 'default';
                    rowBtns.appendChild(bNo);
                }

                const bCatalog = showBtn('🔍 Cambiar película', 'vote-catalog', () => {
                    openProposeModal();
                });
                rowBtns.appendChild(bCatalog);

                const bCancel = showBtn('❌ Cancelar propuesta', 'vote-cancel', () => {
                    netSend({ type: 'show_cancel' });
                });
                rowBtns.appendChild(bCancel);
            } else {
                msg.textContent = '🍿 ' + (SHOW.by ? SHOW.by + ' propone: ' : 'Propuesta: ') + '«' + showTitle(single) + '» ⏳ ';
                showCountEl = document.createElement('b'); showCountEl.id = 'show-count'; msg.appendChild(showCountEl);

                const nYes = SHOW.votes[0] || 0;
                const bYes = showBtn((SHOW.myVote === 0 ? '✔ ' : '') + '👍 ¡Me apunto! · ' + nYes + (nYes === 1 ? ' voto' : ' votos'), 'vote0', () => {
                    SHOW.myVote = 0; netSend({ type: 'show_vote', i: 0 }); showRender();
                }, SHOW.myVote === 0 ? 'on' : '');
                rowBtns.appendChild(bYes);

                const nNo = SHOW.votes[1] || 0;
                const bNo = showBtn((SHOW.myVote === 1 ? '✔ ' : '') + '🔄 Rechazar / 4 al azar · ' + nNo + (nNo === 1 ? ' voto' : ' votos'), 'vote1', () => {
                    SHOW.myVote = 1; netSend({ type: 'show_vote', i: 1 }); showRender();
                }, SHOW.myVote === 1 ? 'on' : '');
                rowBtns.appendChild(bNo);

                const bCatalog = showBtn('🔍 Buscar en catálogo', 'vote-catalog', () => {
                    openProposeModal();
                });
                rowBtns.appendChild(bCatalog);

                const bCancel = showBtn('❌ Cancelar', 'vote-cancel', () => {
                    netSend({ type: 'show_cancel' });
                });
                rowBtns.appendChild(bCancel);
            }
        } else {
            msg.textContent = '🗳️ ¿Qué vemos?' + (SHOW.by ? ' (lo propone ' + SHOW.by + ')' : '') + ' ⏳ ';
            showCountEl = document.createElement('b'); showCountEl.id = 'show-count'; msg.appendChild(showCountEl);
            SHOW.candidates.forEach((c, i) => {
                const n = SHOW.votes[i] || 0;
                const b = showBtn((SHOW.myVote === i ? '✔ ' : '') + showTitle(c) + ' · ' + n + (n === 1 ? ' voto' : ' votos'), 'vote' + i, () => {
                    if (!seated) return toast('Siéntate para votar 🪑');
                    SHOW.myVote = i; netSend({ type: 'show_vote', i }); showRender();
                }, SHOW.myVote === i ? 'on' : '');
                rowBtns.appendChild(b);
            });
            const rerollIdx = SHOW.candidates.length;
            const nReroll = SHOW.votes[rerollIdx] || 0;
            const bReroll = showBtn((SHOW.myVote === rerollIdx ? '✔ ' : '') + '🔄 Pedir 4 distintas · ' + nReroll + (nReroll === 1 ? ' voto' : ' votos'), 'vote-reroll', () => {
                if (!seated) return toast('Siéntate para votar 🪑');
                SHOW.myVote = rerollIdx; netSend({ type: 'show_vote', i: rerollIdx }); showRender();
            }, SHOW.myVote === rerollIdx ? 'on' : '');
            rowBtns.appendChild(bReroll);

            const bCatalog = showBtn('🔍 Buscar en catálogo', 'vote-catalog', () => {
                if (!seated) return toast('Siéntate para proponer 🪑');
                openProposeModal();
            }, 'on');
            rowBtns.appendChild(bCatalog);

            const bCancel = showBtn('❌ Cancelar', 'vote-cancel', () => {
                if (!seated) return toast('Siéntate para cancelar 🪑');
                netSend({ type: 'show_cancel' });
            });
            rowBtns.appendChild(bCancel);
        }
    } else if (SHOW.phase === 'loading') {
        msg.textContent = '🍿 «' + showTitle(SHOW.movie) + '» empieza en ';
        showCountEl = document.createElement('b'); showCountEl.id = 'show-count'; msg.appendChild(showCountEl);
        st.textContent = SHOW.error || SHOW.status || '';
    } else if (SHOW.phase === 'playing') {
        const isPriv = (typeof net !== 'undefined' && net.wantRoom && net.wantRoom.startsWith('priv_'));
        const privCode = isPriv ? net.wantRoom.replace('priv_', '') : '';
        const rIdx = (typeof ROOMS !== 'undefined' && typeof net !== 'undefined' && net.wantRoom)
            ? ROOMS.findIndex(r => r.id === net.wantRoom) : -1;
        const rNum = isPriv ? privCode : (rIdx >= 0 ? (rIdx + 1) : 1);
        msg.textContent = '🎬 En pantalla: «' + showTitle(SHOW.movie) + '»';
        const ok = SHOW.prepared && !SHOW.error;
        if (ok) {
            rowBtns.appendChild(showBtn(SHOW.soundOn ? '🔊 Sonido: ON' : '🔇 Activar sonido', 'mute', showToggleSound, SHOW.soundOn ? 'on' : ''));
            rowBtns.appendChild(showBtn('📺 Pantalla completa', 'fullscreen', showOpenFullscreen, 'on'));
            if (SHOW.blocked) rowBtns.appendChild(showBtn('▶ Toca para reproducir', 'play', () => { SHOW.blocked = false; showPlay(); showRender(); }, 'on'));
        }
        st.textContent = SHOW.error || (ok ? (isPriv ? `📱 Chat y mando: Código de sala privada: ${rNum}` : `📱 Chat y mando desde el móvil: Código de sala: ${rNum}`) : (SHOW.status || 'Preparando…'));
    }
    head.append(msg, rowBtns);
    panel.append(head, st);
    if (!st.textContent) st.classList.add('hidden');
    showTick();
    if (focusKey) { const f = panel.querySelector('[data-k="' + focusKey + '"]'); if (f) { try { f.focus({ preventScroll: true }); } catch (e) { f.focus(); } } }
    document.documentElement.style.setProperty('--show-h', (panel.offsetHeight + 10) + 'px');
    showUpdateOverlayBtns();
}

function showOpenFullscreen() {
    if (!SHOW.prepared || !showVideo) return;
    showSetExpanded(true);
}

function getCinemaScreenRect() {
    const canvas = showEl('cinema-canvas') || showEl('room-canvas');
    if (!canvas) return null;
    const r = canvas.getBoundingClientRect();
    const sx = r.width / 960, sy = r.height / 540;
    return {
        x: r.left + 170 * sx,
        y: r.top + 20 * sy,
        w: 620 * sx,
        h: 210 * sy
    };
}

let expandAnimTimer = null;
function showSetExpanded(on) {
    const ov = showEl('screen-overlay');
    if (!ov) return;
    const box = ov.querySelector('.screen-box');
    if (expandAnimTimer) { clearTimeout(expandAnimTimer); expandAnimTimer = null; }

    if (on) {
        SHOW.expanded = true;
        // Activar sonido si estaba muteado para escuchar la película en pantalla completa
        if (showVideo) {
            if (showVideo.muted) {
                showVideo.muted = false;
                showVideo.volume = 1;
            }
            SHOW.soundOn = true;
            SHOW.mutedByAutoplay = false;
            SHOW.blocked = false;
            if (showVideo.paused) showPlay();
            showRender();
        }

        const startRect = getCinemaScreenRect();
        ov.classList.remove('mini');
        ov.classList.add('full');
        ov.classList.add('user-active');
        if (typeof showRegisterActivity === 'function') showRegisterActivity();
        showUpdateOverlayBtns();
        showRenderCaps();

        if (box && startRect && startRect.w > 20) {
            const targetRect = box.getBoundingClientRect();
            if (targetRect.w > 40 && targetRect.h > 40) {
                const scaleX = startRect.w / targetRect.w;
                const scaleY = startRect.h / targetRect.h;
                const dx = (startRect.x + startRect.w / 2) - (targetRect.left + targetRect.w / 2);
                const dy = (startRect.y + startRect.h / 2) - (targetRect.top + targetRect.h / 2);

                // Empezar exactamente sobre la pantalla del cine
                box.style.transition = 'none';
                box.style.transform = `translate(${dx}px, ${dy}px) scale(${scaleX}, ${scaleY})`;
                ov.style.transition = 'none';
                ov.style.backgroundColor = 'rgba(0, 0, 0, 0)';

                // Animar crecimiento hacia pantalla completa
                requestAnimationFrame(() => {
                    requestAnimationFrame(() => {
                        box.style.transition = 'transform 0.45s cubic-bezier(0.16, 1, 0.3, 1)';
                        box.style.transform = 'translate(0px, 0px) scale(1, 1)';
                        ov.style.transition = 'background-color 0.45s ease';
                        ov.style.backgroundColor = 'rgba(4, 6, 12, 0.96)';
                    });
                });
            }
        }
        const c = showEl('so-close'); if (c) { try { c.focus({ preventScroll: true }); } catch (e) {} }
    } else {
        SHOW.expanded = false;
        if (typeof showActivityTimer !== 'undefined' && showActivityTimer) { clearTimeout(showActivityTimer); showActivityTimer = null; }
        ov.classList.remove('user-active');
        const targetRect = getCinemaScreenRect();
        if (box && targetRect && targetRect.w > 20) {
            const curRect = box.getBoundingClientRect();
            const scaleX = targetRect.w / curRect.w;
            const scaleY = targetRect.h / curRect.h;
            const dx = (targetRect.x + targetRect.w / 2) - (curRect.left + curRect.w / 2);
            const dy = (targetRect.y + targetRect.h / 2) - (curRect.top + curRect.h / 2);

            box.style.transition = 'transform 0.35s cubic-bezier(0.16, 1, 0.3, 1), opacity 0.3s ease';
            box.style.transform = `translate(${dx}px, ${dy}px) scale(${scaleX}, ${scaleY})`;
            box.style.opacity = '0.3';
            ov.style.transition = 'background-color 0.35s ease';
            ov.style.backgroundColor = 'rgba(0, 0, 0, 0)';

            expandAnimTimer = setTimeout(() => {
                ov.classList.remove('full');
                ov.classList.add('mini');
                box.style.transform = '';
                box.style.transition = '';
                box.style.opacity = '';
                ov.style.backgroundColor = '';
                ov.style.transition = '';
            }, 350);
        } else {
            ov.classList.remove('full');
            ov.classList.add('mini');
            if (box) { box.style.transform = ''; box.style.transition = ''; }
        }
    }
}
function showTick() {
    if (!showCountEl) return;
    const t = SHOW.phase === 'voting' ? SHOW.endsAt : SHOW.startAt;
    showCountEl.textContent = showFmt(t - srvNow());
}
setInterval(() => {
    if (SHOW.phase !== 'idle') { showTick(); showSyncTick(); }
    const panel = showEl('show-panel');
    if (panel && panel.classList.contains('hidden') === showInCinema()) showRender();   // entrar/salir de la sala
}, 500);

/* ── Sonido y ampliación ── */
function showToggleSound() {
    SHOW.soundOn = !SHOW.soundOn;
    if (showVideo) { showVideo.muted = !SHOW.soundOn; if (SHOW.soundOn) showVideo.volume = 1; }
    showRender();
}
function showUpdateOverlayBtns() {
    const m = showEl('so-mute');
    if (m) m.textContent = SHOW.soundOn ? '🔊 Sonido: ON' : '🔇 Silenciar';
    const b = showEl('so-room-badge');
    if (b) {
        const isPriv = (typeof net !== 'undefined' && net.wantRoom && net.wantRoom.startsWith('priv_'));
        const privCode = isPriv ? net.wantRoom.replace('priv_', '') : '';
        const rIdx = (typeof ROOMS !== 'undefined' && typeof net !== 'undefined' && net.wantRoom)
            ? ROOMS.findIndex(r => r.id === net.wantRoom) : -1;
        const rNum = isPriv ? privCode : (rIdx >= 0 ? (rIdx + 1) : 1);
        b.textContent = `📱 Chat móvil: Código ${rNum}`;
    }
}

function unlockShowAudio() {
    if (!showVideo) return;
    if (showVideo.paused && SHOW.phase === 'playing' && SHOW.prepared) {
        showPlay();
    }
    if (SHOW.soundOn && showVideo.muted) {
        showVideo.muted = false;
        showVideo.volume = 1;
        SHOW.blocked = false;
        showRender();
    }
}
document.addEventListener('click', unlockShowAudio, { passive: true });
document.addEventListener('keydown', unlockShowAudio, { passive: true });
let showActivityTimer = null;
function showRegisterActivity() {
    const ov = showEl('screen-overlay');
    if (!ov || !SHOW.expanded) return;
    ov.classList.add('user-active');
    if (showActivityTimer) clearTimeout(showActivityTimer);
    showActivityTimer = setTimeout(() => {
        if (SHOW.expanded && ov) {
            ov.classList.remove('user-active');
        }
    }, 3500);
}
window.addEventListener('mousemove', showRegisterActivity, { passive: true });
window.addEventListener('pointermove', showRegisterActivity, { passive: true });
window.addEventListener('mousedown', showRegisterActivity, { passive: true });
window.addEventListener('touchstart', showRegisterActivity, { passive: true });

document.addEventListener('keydown', (e) => {
    if (e.key === 'Escape' || e.keyCode === 27) {
        const propModal = showEl('propose-modal');
        if (propModal && !propModal.classList.contains('hidden')) {
            e.preventDefault();
            e.stopPropagation();
            e.stopImmediatePropagation();
            closeProposeModal();
            return;
        }
        if (SHOW.expanded) {
            e.preventDefault();
            e.stopPropagation();
            e.stopImmediatePropagation();
            showSetExpanded(false);
            return;
        }
    }
    if (SHOW.expanded) {
        showRegisterActivity();
    }
}, true);

function showHandleBack() {
    const propModal = showEl('propose-modal');
    if (propModal && !propModal.classList.contains('hidden')) {
        closeProposeModal();
        return true;
    }
    if (SHOW.expanded) { showSetExpanded(false); return true; }
    return false;
}
function showOverlaySend() {
    const inp = showEl('so-input');
    const t = inp.value.trim();
    if (!t) return;
    if (mySeat() < 0) return toast('Siéntate primero para poder hablar 🪑');
    netSend({ type: 'say', text: t });
    inp.value = '';
}

/* ── Subtítulos de chat sobre el vídeo ampliado ── */
function showCaption(name, text) {
    SHOW.caps.push({ name: String(name || ''), text: String(text || ''), at: Date.now() });
    if (SHOW.caps.length > 3) SHOW.caps.shift();
    if (SHOW.expanded) showRenderCaps();
}
function showRenderCaps() {
    const box = showEl('screen-caps');
    if (!box) return;
    const now = Date.now();
    SHOW.caps = SHOW.caps.filter(c => now - c.at < 9000);
    box.textContent = '';
    SHOW.caps.forEach(c => {
        const d = document.createElement('div'); d.className = 'cap';
        const n = document.createElement('b'); n.textContent = c.name + ': ';
        const t = document.createElement('span'); t.textContent = c.text;
        d.append(n, t); box.appendChild(d);
    });
}
setInterval(() => { if (SHOW.expanded) showRenderCaps(); }, 1500);

/* ── Dibujo en la pantalla del cine (llamado desde drawRoom, dentro del recorte de la pantalla) ── */
const SHOW_FONT = '"Press Start 2P", monospace';
function showFit(ctx, text, maxW) {
    if (ctx.measureText(text).width <= maxW) return text;
    let t = text;
    while (t.length > 3 && ctx.measureText(t + '…').width > maxW) t = t.slice(0, -1);
    return t + '…';
}
function drawShowScreen(ctx, now, SCR) {
    if (SHOW.phase === 'idle' || SHOW.expanded) return;
    const cx = SCR.x + SCR.w / 2;
    ctx.save();
    ctx.textAlign = 'center';
    const canDraw = SHOW.phase === 'playing' && SHOW.prepared && showVideo && (showVideo.readyState >= 2 || (showVideo.readyState >= 1 && (showVideo.videoWidth > 0 || showVideo.currentTime > 0)) || showVideo.currentTime > 0) && !SHOW.error;
    if (canDraw) {
        // Vídeo en baja resolución con píxeles gruesos (estilo retro): 186×105 ampliado ×2
        const PW = 186, PH = 105;
        if (!showPix) { showPix = document.createElement('canvas'); showPix.width = PW; showPix.height = PH; showPixCtx = showPix.getContext('2d'); }
        const vw = showVideo.videoWidth || 16, vh = showVideo.videoHeight || 9;
        const sc = Math.min(PW / vw, PH / vh), dw = Math.round(vw * sc), dh = Math.round(vh * sc);
        if (now - (SHOW._lastPixDraw || 0) >= 40) {
            SHOW._lastPixDraw = now;
            showPixCtx.fillStyle = '#000'; showPixCtx.fillRect(0, 0, PW, PH);
            try { showPixCtx.drawImage(showVideo, Math.round((PW - dw) / 2), Math.round((PH - dh) / 2), dw, dh); } catch (e) {}
        }
        ctx.fillStyle = '#000'; ctx.fillRect(SCR.x, SCR.y, SCR.w, SCR.h);
        ctx.imageSmoothingEnabled = false;
        ctx.drawImage(showPix, 0, 0, PW, PH, Math.round(cx - PW), SCR.y, PW * 2, PH * 2);
        ctx.restore();
        return;
    }
    ctx.fillStyle = 'rgba(4,6,12,0.86)'; ctx.fillRect(SCR.x, SCR.y, SCR.w, SCR.h);
    const gold = '#f1c40f';
    if (SHOW.phase === 'voting') {
        if (SHOW.candidates.length === 1) {
            const single = SHOW.candidates[0];
            ctx.fillStyle = gold; ctx.font = '10px ' + SHOW_FONT;
            ctx.fillText('¿VER ESTA PELI?  ' + showFmt(SHOW.endsAt - srvNow()), cx, SCR.y + 24);
            ctx.fillStyle = '#fff'; ctx.font = '9px ' + SHOW_FONT;
            ctx.fillText(showFit(ctx, showTitle(single), SCR.w - 30), cx, SCR.y + 54);

            const nYes = SHOW.votes[0] || 0;
            ctx.fillStyle = SHOW.myVote === 0 ? '#2ecc71' : '#f1c40f';
            ctx.font = '8px ' + SHOW_FONT;
            ctx.fillText(showFit(ctx, '1. 👍 ¡Me apunto!  [' + nYes + ']', SCR.w - 30), cx, SCR.y + 86);

            const nNo = SHOW.votes[1] || 0;
            ctx.fillStyle = SHOW.myVote === 1 ? '#2ecc71' : '#e74c3c';
            ctx.fillText(showFit(ctx, '2. 🔄 4 al azar  [' + nNo + ']', SCR.w - 30), cx, SCR.y + 110);
        } else {
            ctx.fillStyle = gold; ctx.font = '11px ' + SHOW_FONT;
            ctx.fillText('¿QUÉ VEMOS?  ' + showFmt(SHOW.endsAt - srvNow()), cx, SCR.y + 24);
            ctx.font = '8px ' + SHOW_FONT;
            SHOW.candidates.forEach((c, i) => {
                const n = SHOW.votes[i] || 0;
                ctx.fillStyle = SHOW.myVote === i ? '#2ecc71' : '#fff';
                ctx.fillText(showFit(ctx, (i + 1) + '. ' + showTitle(c) + '  [' + n + ']', SCR.w - 30), cx, SCR.y + 48 + i * 22);
            });
            const rerollIdx = SHOW.candidates.length;
            const nReroll = SHOW.votes[rerollIdx] || 0;
            ctx.fillStyle = SHOW.myVote === rerollIdx ? '#2ecc71' : '#f39c12';
            ctx.fillText(showFit(ctx, '5. 🔄 Pedir 4 distintas  [' + nReroll + ']', SCR.w - 30), cx, SCR.y + 48 + rerollIdx * 22);
        }
    } else {
        ctx.fillStyle = gold; ctx.font = '11px ' + SHOW_FONT;
        const title = showTitle(SHOW.movie).toUpperCase();
        ctx.fillText(showFit(ctx, title, SCR.w - 40), cx, SCR.y + 70);
        ctx.fillStyle = '#fff'; ctx.font = '10px ' + SHOW_FONT;
        const blink = Math.floor(now / 500) % 2 === 0;
        if (SHOW.phase === 'loading') {
            ctx.fillText('EMPIEZA EN ' + showFmt(SHOW.startAt - srvNow()), cx, SCR.y + 110);
        } else {
            ctx.fillText(SHOW.error ? 'SIN SEÑAL' : (blink ? 'CARGANDO…' : 'CARGANDO'), cx, SCR.y + 110);
        }
        ctx.fillStyle = SHOW.error ? '#e74c3c' : '#94a3b8'; ctx.font = '8px ' + SHOW_FONT;
        const sub = SHOW.error ? SHOW.error.replace(/^[^A-Za-zÀ-ÿ¡¿]+/, '') : (SHOW.status || '');
        if (sub) ctx.fillText(showFit(ctx, sub, SCR.w - 30), cx, SCR.y + 146);
    }
    ctx.restore();
}

/* ── Modal de Búsqueda y Propuesta de Películas del Catálogo ── */
let proposeSearchDebounce = null;

function showFormatBytes(bytes) {
    bytes = Number(bytes) || 0;
    if (bytes <= 0) return '0 B';
    const k = 1024;
    const sizes = ['B', 'KB', 'MB', 'GB', 'TB'];
    const i = Math.floor(Math.log(bytes) / Math.log(k));
    return parseFloat((bytes / Math.pow(k, i)).toFixed(2)) + ' ' + sizes[i];
}

function setupDragToScroll(container) {
    if (!container || container._hasDragScroll) return;
    container._hasDragScroll = true;

    let isDown = false;
    let startY = 0;
    let startScrollTop = 0;
    let isDragging = false;
    let velocityY = 0;
    let lastY = 0;
    let lastTime = 0;
    let momentumId = null;
    let blockNextClick = false;

    // Deshabilitar selección de texto durante el arrastre
    container.style.userSelect = 'none';
    container.style.webkitUserSelect = 'none';

    function onPointerDown(e) {
        if (e.button !== 0 && e.button !== undefined) return;
        // Dejar que el scroll táctil nativo funcione en móviles táctiles
        if (e.pointerType === 'touch') return;

        isDown = true;
        isDragging = false;
        startY = e.clientY;
        startScrollTop = container.scrollTop;
        lastY = e.clientY;
        lastTime = performance.now();
        velocityY = 0;

        if (momentumId) {
            cancelAnimationFrame(momentumId);
            momentumId = null;
        }
    }

    function onPointerMove(e) {
        if (!isDown) return;
        const dy = e.clientY - startY;

        if (!isDragging && Math.abs(dy) > 6) {
            isDragging = true;
            container.classList.add('is-dragging');
        }

        if (isDragging) {
            container.scrollTop = startScrollTop - dy;
            const now = performance.now();
            const dt = now - lastTime;
            if (dt > 0) {
                velocityY = 0.5 * velocityY + 0.5 * ((e.clientY - lastY) / dt);
            }
            lastY = e.clientY;
            lastTime = now;
            updateProposeScrollNav();
        }
    }

    function onPointerUp() {
        if (!isDown) return;
        isDown = false;

        if (isDragging) {
            blockNextClick = true;
            setTimeout(() => {
                blockNextClick = false;
                isDragging = false;
                container.classList.remove('is-dragging');
            }, 120);

            // Inercia / momentum cinético suave
            let vel = velocityY * 12;
            const friction = 0.92;
            function momentumStep() {
                if (Math.abs(vel) < 0.5 || isDown) {
                    momentumId = null;
                    updateProposeScrollNav();
                    return;
                }
                container.scrollTop -= vel;
                vel *= friction;
                updateProposeScrollNav();
                momentumId = requestAnimationFrame(momentumStep);
            }
            momentumId = requestAnimationFrame(momentumStep);
        } else {
            isDragging = false;
        }
    }

    // Interceptar clics durante o inmediatamente después del arrastre
    container.addEventListener('click', (e) => {
        if (blockNextClick || isDragging) {
            e.preventDefault();
            e.stopPropagation();
            e.stopImmediatePropagation();
            blockNextClick = false;
            isDragging = false;
            container.classList.remove('is-dragging');
        }
    }, true);

    if (window.PointerEvent) {
        container.addEventListener('pointerdown', onPointerDown);
        window.addEventListener('pointermove', onPointerMove);
        window.addEventListener('pointerup', onPointerUp);
        window.addEventListener('pointercancel', onPointerUp);
    } else {
        container.addEventListener('mousedown', onPointerDown);
        window.addEventListener('mousemove', onPointerMove);
        window.addEventListener('mouseup', onPointerUp);
    }

    container.addEventListener('scroll', () => {
        updateProposeScrollNav();
    }, { passive: true });
}

function scrollProposeContainer(dir) {
    const filesCont = showEl('propose-files');
    const resultsCont = showEl('propose-results');
    const cont = (filesCont && !filesCont.classList.contains('hidden')) ? filesCont : resultsCont;
    if (!cont) return;
    const step = Math.max(160, Math.round(cont.clientHeight * 0.72));
    cont.scrollBy({ top: dir * step, behavior: 'smooth' });
    setTimeout(updateProposeScrollNav, 150);
    setTimeout(updateProposeScrollNav, 400);
}

function updateProposeScrollNav() {
    const nav = showEl('propose-scroll-nav');
    if (!nav) return;
    const filesCont = showEl('propose-files');
    const resultsCont = showEl('propose-results');
    const cont = (filesCont && !filesCont.classList.contains('hidden')) ? filesCont : resultsCont;
    if (!cont) {
        nav.classList.add('hidden');
        return;
    }
    const canScroll = cont.scrollHeight > cont.clientHeight + 10;
    if (!canScroll) {
        nav.classList.add('hidden');
        return;
    }
    nav.classList.remove('hidden');

    const btnUp = showEl('propose-scroll-up');
    const btnDown = showEl('propose-scroll-down');
    if (btnUp) {
        btnUp.classList.toggle('disabled', cont.scrollTop <= 6);
    }
    if (btnDown) {
        btnDown.classList.toggle('disabled', cont.scrollTop + cont.clientHeight >= cont.scrollHeight - 6);
    }
}

function backToProposeCatalog() {
    const wrap = showEl('propose-search-wrap');
    const results = showEl('propose-results');
    const filesCont = showEl('propose-files');
    const titleEl = showEl('propose-modal-title');
    const descEl = showEl('propose-modal-desc');
    const badgeEl = showEl('propose-modal-badge');

    if (filesCont) {
        filesCont.classList.add('hidden');
        filesCont.scrollTop = 0;
    }
    if (wrap) wrap.classList.remove('hidden');
    if (results) results.classList.remove('hidden');

    if (badgeEl) badgeEl.textContent = '🎬 CATÁLOGO CINEFLIX';
    if (titleEl) titleEl.textContent = 'Elegir película para la sala';
    if (descEl) descEl.textContent = 'Busca cualquier película del catálogo para verla todos juntos en la gran pantalla.';

    if (results) setupDragToScroll(results);
    if (filesCont) setupDragToScroll(filesCont);
    setTimeout(updateProposeScrollNav, 60);
}

function openProposeModal() {
    const modal = showEl('propose-modal');
    if (!modal) return;
    backToProposeCatalog();
    modal.classList.remove('hidden');
    const input = showEl('propose-search-input');
    if (input) {
        input.value = '';
        setTimeout(() => input.focus(), 60);
    }
    fetchProposeMovies('');
    setTimeout(updateProposeScrollNav, 100);
}

function closeProposeModal() {
    const modal = showEl('propose-modal');
    if (modal) modal.classList.add('hidden');
    backToProposeCatalog();
}

function onProposeSearchInput() {
    if (proposeSearchDebounce) clearTimeout(proposeSearchDebounce);
    proposeSearchDebounce = setTimeout(() => {
        const input = showEl('propose-search-input');
        const q = input ? input.value.trim() : '';
        fetchProposeMovies(q);
    }, 250);
}

async function fetchProposeMovies(query) {
    const container = showEl('propose-results');
    if (!container) return;
    container.innerHTML = '<div class="propose-state-msg">Cargando catálogo… 🍿</div>';
    try {
        const url = query
            ? `/api/movies?q=${encodeURIComponent(query)}&limit=15`
            : `/api/movies?limit=15&sort=random`;
        const res = await fetch(url);
        if (!res.ok) throw new Error('Error al conectar con el catálogo');
        const data = await res.json();
        const items = data.items || (Array.isArray(data) ? data : []);
        renderProposeResults(items);
    } catch (err) {
        container.innerHTML = `<div class="propose-state-msg" style="color:#f87171;">⚠️ Error: ${err.message || 'No se pudieron cargar las películas'}</div>`;
    }
}

function renderProposeResults(items) {
    const container = showEl('propose-results');
    if (!container) return;
    container.innerHTML = '';
    if (!items || !items.length) {
        container.innerHTML = '<div class="propose-state-msg">No se encontraron películas con ese título 🔎</div>';
        return;
    }
    items.forEach(m => {
        const item = document.createElement('div');
        item.className = 'propose-item';
        item.style.cursor = 'pointer';
        item.tabIndex = 0;
        item.setAttribute('role', 'button');
        item.setAttribute('aria-label', `Elegir película ${m.title || ''}`);

        const poster = document.createElement('img');
        poster.className = 'propose-item-poster';
        poster.loading = 'lazy';
        poster.alt = m.title || '';
        poster.src = m.tmdb_poster ? `https://image.tmdb.org/t/p/w185${m.tmdb_poster}` : '/placeholder-poster.png';
        poster.onerror = () => { poster.style.display = 'none'; };

        const info = document.createElement('div');
        info.className = 'propose-item-info';

        const title = document.createElement('div');
        title.className = 'propose-item-title';
        title.textContent = m.title || 'Sin título';

        const year = document.createElement('div');
        year.className = 'propose-item-year';
        year.textContent = m.year ? String(m.year) : (m.genre || 'Película');

        info.append(title, year);

        const btn = document.createElement('button');
        btn.type = 'button';
        btn.className = 'propose-item-btn';
        btn.textContent = '🎬 Elegir versión';
        btn.onclick = (e) => {
            e.stopPropagation();
            selectMovieForProposal(m);
        };

        item.onclick = () => selectMovieForProposal(m);
        item.onkeydown = (e) => {
            if (e.key === 'Enter' || e.key === ' ') {
                e.preventDefault();
                selectMovieForProposal(m);
            }
        };

        item.append(poster, info, btn);
        container.appendChild(item);
    });

    setupDragToScroll(container);
    updateProposeScrollNav();
    setTimeout(updateProposeScrollNav, 60);
}

function showParseMultipartName(filename) {
    const s = String(filename || '').trim();
    if (!s) return null;

    // Patrón 1: Sufijo .ext.partX o .ext.00X o .7z.00X (ej: Movie.mkv.part1, Movie.mkv.001, Movie.7z.001)
    const m1 = s.match(/^(.*?\.(?:(?:mkv|mp4|avi|ts|mov|webm)(?:\.7z)?|7z))\.(?:part0*(\d+)|0*(\d+))$/i);
    if (m1) {
        const isArchive = /\.7z$/i.test(m1[1]);
        const cleanBase = isArchive ? m1[1].slice(0, -3) : m1[1];
        const ext = cleanBase.match(/\.(mkv|mp4|avi|ts|mov|webm)$/i)?.[1]?.toLowerCase() || (isArchive ? '7z' : 'mkv');
        const part = Number(m1[2] || m1[3]);
        return {
            baseKey: cleanBase.replace(/\.[^.]+$/, '').toLowerCase().trim(),
            displayName: cleanBase.replace(/\.[^.]+$/, '').trim(),
            ext,
            part,
            isArchive,
            isExplicitSplit: true
        };
    }

    // Patrón 2: Paréntesis o corchetes infijos (ej: Movie [Part 1].mkv, Movie (Parte 1).mkv, Movie [1 de 2].mkv, Movie (1/2).mkv)
    const m2 = s.match(/^(.*?)[ ._\-]+[\[{(](?:(?:part|parte|pt|cd|disc|disco)\s*0*(\d+)|0*(\d+)\s*(?:de|of|\/|-)\s*(\d+))[\]})]\.(mkv|mp4|avi|ts|mov|webm)$/i);
    if (m2) {
        const part = Number(m2[2] || m2[3]);
        const total = m2[4] ? Number(m2[4]) : null;
        if (part >= 1 && part <= 50) {
            const rawBase = m2[1].trim().replace(/[-._ ]+$/, '');
            return {
                baseKey: rawBase.toLowerCase(),
                displayName: rawBase,
                ext: m2[5].toLowerCase(),
                part,
                totalParts: total,
                isArchive: false,
                isExplicitSplit: !!total || !m2[3]
            };
        }
    }

    // Patrón 3: Palabra clave infija (ej: Movie.part1.mkv, Movie - Parte 02.mkv, Movie.CD1.avi, Movie_pt1.mkv)
    const m3 = s.match(/^(.*?)[ ._\-]+(?:part|parte|pt|cd|disc|disco)[ ._\-]*0*(\d+)(?:[ ._\-]*(?:de|of)[ ._\-]*(\d+))?\.(mkv|mp4|avi|ts|mov|webm)$/i);
    if (m3) {
        const part = Number(m3[2]);
        const total = m3[3] ? Number(m3[3]) : null;
        if (part >= 1 && part <= 50) {
            const rawBase = m3[1].trim().replace(/[-._ ]+$/, '');
            const matchedPrefix = s.slice(m3[1].length);
            const isExplicit = !!total || /[._]part0*\d+/i.test(matchedPrefix) || /[._-]cd0*\d+/i.test(matchedPrefix) || /[._-]pt0*\d+/i.test(matchedPrefix);
            return {
                baseKey: rawBase.toLowerCase(),
                displayName: rawBase,
                ext: m3[4].toLowerCase(),
                part,
                totalParts: total,
                isArchive: false,
                isExplicitSplit: isExplicit
            };
        }
    }

    // Patrón 4: Fragmento numérico 3 dígitos infijo (ej: Movie.001.mkv, Movie.002.mkv)
    const m4 = s.match(/^(.*?)[ ._\-]+(00\d|0\d)\.(mkv|mp4|avi|ts|mov|webm)$/i);
    if (m4) {
        const part = Number(m4[2]);
        if (part >= 1 && part <= 50) {
            const rawBase = m4[1].trim().replace(/[-._ ]+$/, '');
            return {
                baseKey: rawBase.toLowerCase(),
                displayName: rawBase,
                ext: m4[3].toLowerCase(),
                part,
                isArchive: false,
                isExplicitSplit: true
            };
        }
    }

    return null;
}

function showGroupMultipartVideos(videos) {
    if (!videos || !videos.length) return [];
    const groups = new Map();
    const singles = [];

    for (const video of videos) {
        if (video.isMultipart) {
            singles.push(video);
            continue;
        }
        const name = String(video.fileName || video.caption || '').trim();
        const parsed = showParseMultipartName(name);

        if (!parsed) {
            singles.push(video);
            continue;
        }

        const groupKey = `${video.chatId ?? ''}:${parsed.baseKey}:${parsed.ext}`;
        if (!groups.has(groupKey)) {
            groups.set(groupKey, {
                meta: parsed,
                representative: video,
                parts: []
            });
        }
        groups.get(groupKey).parts.push({
            video,
            part: parsed.part,
            size: Number(video.fileSize || 0),
            fileId: video.fileId || video.id,
            msgId: video.msgId
        });
    }

    const result = [...singles];

    for (const group of groups.values()) {
        const { meta, representative, parts } = group;
        parts.sort((a, b) => a.part - b.part);

        if (parts.length === 1 && !meta.isExplicitSplit) {
            result.push(representative);
            continue;
        }

        const totalSize = parts.reduce((sum, p) => sum + p.size, 0);
        const valid = parts.every((p, i) => p.part === i + 1 && p.size > 0);
        const isArchive = meta.isArchive;

        const isMp4 = meta.ext === 'mp4' || meta.ext === 'webm';
        const isUnder4GB = totalSize <= 4 * 1024 * 1024 * 1024;

        const mimeMap = {
            mkv: 'video/x-matroska',
            mp4: 'video/mp4',
            avi: 'video/x-msvideo',
            ts: 'video/mp2t',
            mov: 'video/quicktime',
            webm: 'video/webm'
        };

        const groupObj = {
            ...representative,
            isMultipart: true,
            partsCount: parts.length,
            fileName: `${meta.displayName} (Completa)`,
            fileSize: totalSize,
            originalExt: meta.ext,
            archiveFormat: isArchive ? '7z-copy' : null,
            multipartArray: parts.map(p => ({
                fileId: p.fileId,
                size: p.size,
                part: p.part,
                msgId: p.msgId,
                media: p.video?.media || null
            })),
            payload_multipart: parts.map(p => ({
                fileId: p.fileId,
                size: p.size,
                ...(isArchive ? { archive: '7z-copy' } : {})
            })),
            multipartError: valid ? null : 'Faltan partes o están desordenadas',
            mimeType: mimeMap[meta.ext] || representative.mimeType || 'application/octet-stream',
            isMp4,
            isUnder4GB
        };

        if (groupObj.caption) {
            groupObj.caption = groupObj.caption.replace(/\.(?:part0*\d+|0*\d+)$/i, ' (Completa)');
        }

        result.push(groupObj);
    }

    return result;
}

async function selectMovieForProposal(m) {
    if (mySeat() < 0) return toast('Siéntate para proponer una película 🪑');

    const wrap = showEl('propose-search-wrap');
    const results = showEl('propose-results');
    const filesCont = showEl('propose-files');
    const titleEl = showEl('propose-modal-title');
    const descEl = showEl('propose-modal-desc');
    const badgeEl = showEl('propose-modal-badge');

    if (!filesCont) {
        proposeMovie(m, null);
        return;
    }

    if (wrap) wrap.classList.add('hidden');
    if (results) results.classList.add('hidden');
    filesCont.classList.remove('hidden');

    if (badgeEl) badgeEl.textContent = '🤖 ARCHIVOS EN TELEGRAM';
    if (titleEl) titleEl.textContent = showTitle(m);
    if (descEl) descEl.textContent = 'Buscando archivos y versiones disponibles en el bot de Telegram... ⏳';

    filesCont.innerHTML = '<div class="propose-state-msg">Buscando versiones del bot de Telegram... 🤖🍿</div>';

    let files = [];
    try {
        const queryTitle = m.search_title || m.title;
        if (window.AndroidBridge && window.AndroidBridge.searchMovieByPayload) {
            const raw = await callNativeSearchMovie(queryTitle);
            let list = Array.isArray(raw) ? raw : (raw && raw.videos ? raw.videos : []);
            if ((!list || !list.length) && m.year) {
                const raw2 = await callNativeSearchMovie(`${queryTitle} ${m.year}`);
                list = Array.isArray(raw2) ? raw2 : (raw2 && raw2.videos ? raw2.videos : []);
            }
            const groupedList = showGroupMultipartVideos(list || []);
            files = groupedList.map(v => {
                const isMp4 = (v.mimeType && v.mimeType.toLowerCase() === 'video/mp4') || /\.mp4$/i.test(v.fileName || '') || /\.webm$/i.test(v.fileName || '');
                const sz = Number(v.fileSize) || 0;
                return {
                    msgId: v.msgId,
                    fileId: v.fileId || v.id,
                    fileName: v.fileName || '',
                    fileSize: sz,
                    mimeType: v.mimeType || (isMp4 ? 'video/mp4' : 'video/x-matroska'),
                    isMp4,
                    isUnder4GB: sz <= 4 * 1024 * 1024 * 1024,
                    isMultipart: !!v.isMultipart,
                    partsCount: v.partsCount || 1,
                    payload_multipart: v.payload_multipart || null,
                    multipartArray: v.multipartArray || null,
                    archiveFormat: v.archiveFormat || null
                };
            });
        } else {
            const eng = await showLoadEngine();
            if (eng && eng.searchMovieFiles) {
                const rawFiles = await eng.searchMovieFiles(queryTitle, m.year);
                files = showGroupMultipartVideos(rawFiles || []);
            }
        }
    } catch (err) {
        console.warn('[Cine] error al buscar archivos en bot:', err);
    }

    renderMovieFiles(m, files);
}

function renderMovieFiles(m, files) {
    const filesCont = showEl('propose-files');
    const descEl = showEl('propose-modal-desc');
    if (!filesCont) return;
    filesCont.innerHTML = '';

    if (descEl) {
        descEl.textContent = 'Elige qué versión reproducir. Los MP4 son los más compatibles con todos los dispositivos:';
    }

    // Botón para volver atrás
    const backBtn = document.createElement('button');
    backBtn.type = 'button';
    backBtn.className = 'propose-back-btn';
    backBtn.innerHTML = '⬅ Volver al catálogo';
    backBtn.onclick = () => backToProposeCatalog();
    filesCont.appendChild(backBtn);

    // Opción Automática inteligente (MP4 preferido o MKV <= 4GB)
    const autoItem = document.createElement('div');
    autoItem.className = 'propose-file-item recommended';
    autoItem.tabIndex = 0;
    autoItem.setAttribute('role', 'button');
    autoItem.setAttribute('aria-label', 'Selección automática recomendada');
    autoItem.innerHTML = `
        <div class="propose-file-top">
            <span class="propose-file-name">⚡ Selección Automática (Recomendada)</span>
            <span class="propose-file-badge badge-auto">ÓPTIMO</span>
        </div>
        <div class="propose-file-meta">
            <span class="propose-file-size">Elige siempre MP4 si existe, o el MKV más ligero (&lt;4GB) para evitar bloqueos.</span>
        </div>
    `;
    autoItem.onclick = () => proposeMovie(m, null);
    autoItem.onkeydown = (e) => {
        if (e.key === 'Enter' || e.key === ' ') {
            e.preventDefault();
            proposeMovie(m, null);
        }
    };
    filesCont.appendChild(autoItem);

    if (!files || !files.length) {
        const warn = document.createElement('div');
        warn.className = 'propose-state-msg';
        warn.innerHTML = `
            <div style="margin-bottom:8px;">⚠️ El bot no listó archivos directamente para esta película en este momento.</div>
            <div style="font-size:11px;color:#94a3b8;margin-bottom:12px;">Puedes continuar con selección automática y el reproductor la buscará al empezar.</div>
        `;
        const directBtn = document.createElement('button');
        directBtn.type = 'button';
        directBtn.className = 'propose-item-btn';
        directBtn.textContent = '🎬 Poner con selección automática';
        directBtn.onclick = () => proposeMovie(m, null);
        warn.appendChild(directBtn);
        filesCont.appendChild(warn);
        setupDragToScroll(filesCont);
        updateProposeScrollNav();
        return;
    }

    // Ordenar archivos: MP4 primero, luego MKV <= 4GB, luego el resto
    const sorted = [...files].sort((a, b) => {
        if (a.isMp4 && !b.isMp4) return -1;
        if (!a.isMp4 && b.isMp4) return 1;
        if (a.isUnder4GB && !b.isUnder4GB) return -1;
        if (!a.isUnder4GB && b.isUnder4GB) return 1;
        return (a.fileSize || 0) - (b.fileSize || 0);
    });

    sorted.forEach((f, idx) => {
        const item = document.createElement('div');
        item.className = 'propose-file-item';
        item.tabIndex = 0;
        item.setAttribute('role', 'button');
        item.setAttribute('aria-label', `Archivo ${idx + 1}: ${f.fileName || ''}`);

        let badgeHtml = '';
        if (f.isMp4) {
            badgeHtml = '<span class="propose-file-badge badge-mp4">⭐ MP4 (Más compatible)</span>';
        } else if (f.isUnder4GB) {
            badgeHtml = f.isMultipart
                ? `<span class="propose-file-badge badge-mkv-light">🎞️ MKV (&lt;4GB • ${f.partsCount} partes)</span>`
                : '<span class="propose-file-badge badge-mkv-light">🎞️ MKV (&lt;4GB)</span>';
        } else {
            badgeHtml = f.isMultipart
                ? `<span class="propose-file-badge badge-mkv-heavy">⚠️ MKV (&gt;4GB • ${f.partsCount} partes)</span>`
                : '<span class="propose-file-badge badge-mkv-heavy">⚠️ MKV (&gt;4GB - Pesado)</span>';
        }

        const sizeStr = showFormatBytes(f.fileSize);
        const nameClean = f.fileName || `Archivo #${idx + 1}`;
        const partsText = f.isMultipart ? ` • ${f.partsCount} partes` : '';

        item.innerHTML = `
            <div class="propose-file-top">
                <span class="propose-file-name">${nameClean}</span>
                ${badgeHtml}
            </div>
            <div class="propose-file-meta">
                <span class="propose-file-size">📦 ${sizeStr}${partsText}</span>
                <span style="font-size:11px;color:#cbd5e1;margin-left:auto;">🎬 Toca para poner en sala</span>
            </div>
        `;
        item.onclick = () => proposeMovie(m, f);
        item.onkeydown = (e) => {
            if (e.key === 'Enter' || e.key === ' ') {
                e.preventDefault();
                proposeMovie(m, f);
            }
        };
        filesCont.appendChild(item);
    });

    setupDragToScroll(filesCont);
    updateProposeScrollNav();
    setTimeout(updateProposeScrollNav, 60);
}

function proposeMovie(m, chosenFile = null) {
    if (mySeat() < 0) return toast('Siéntate para proponer una película 🪑');
    closeProposeModal();
    const moviePayload = {
        id: m.id,
        title: m.title,
        year: m.year,
        search_title: m.search_title || m.title
    };
    if (chosenFile) {
        if (chosenFile.msgId) moviePayload.file_msg_id = chosenFile.msgId;
        if (chosenFile.fileName) moviePayload.file_name = chosenFile.fileName;
        if (chosenFile.fileSize) moviePayload.file_size = chosenFile.fileSize;
        if (chosenFile.mimeType) moviePayload.mime_type = chosenFile.mimeType;
        if (chosenFile.isMultipart) {
            moviePayload.is_multipart = true;
            moviePayload.parts_count = chosenFile.partsCount;
            moviePayload.payload_multipart = chosenFile.payload_multipart;
            moviePayload.multipart_array = chosenFile.multipartArray;
            moviePayload.archive_format = chosenFile.archiveFormat;
        }
    }
    netSend({
        type: 'show_start',
        movie: moviePayload
    });
}

window.openProposeModal = openProposeModal;
window.closeProposeModal = closeProposeModal;
window.backToProposeCatalog = backToProposeCatalog;
window.selectMovieForProposal = selectMovieForProposal;
window.renderMovieFiles = renderMovieFiles;
window.renderProposeResults = renderProposeResults;
window.onProposeSearchInput = onProposeSearchInput;
window.proposeMovie = proposeMovie;
window.scrollProposeContainer = scrollProposeContainer;
window.updateProposeScrollNav = updateProposeScrollNav;


