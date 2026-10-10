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
    expanded: false, soundOn: false, caps: [], engine: null, lastDur: 0
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
function showTitle(m) { return m ? m.title + (m.year ? ' (' + m.year + ')' : '') : ''; }

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
    SHOW.cooldownUntil = st.cooldownUntil || 0;
    if (typeof st.myVote === 'number') SHOW.myVote = st.myVote;
    else if (st.phase !== 'voting' || prevPhase !== 'voting') SHOW.myVote = -1;   // nueva votación (o fuera de ella): sin voto
    if (st.notice) { try { toast(st.notice); } catch (e) {} }

    if (st.phase === 'idle') showStopPlayback();
    else if ((st.phase === 'loading' || st.phase === 'playing') && SHOW.movie) showStartPrepare();
    else if (st.phase === 'voting') showStopPlayback();
    showRender();
}

/* ── Preparación del vídeo (cada espectador desde su propia cuenta de Telegram) ── */
function showLoadEngine() {
    if (window.__cineStreamMock) return Promise.resolve(window.__cineStreamMock);
    if (SHOW.engine) return Promise.resolve(SHOW.engine);
    return import('/cine/stream.bundle.js' + (SHOW_VER ? '?v=' + SHOW_VER : '')).then(mod => { SHOW.engine = mod.default || window.CineStream; return SHOW.engine; });
}
const SHOW_ERRORS = {
    NATIVE: '📺 Tu app aún no puede reproducirla en la sala; sigue el chat y las votaciones. En la web (PC) sí.',
    UNSUPPORTED: 'Este dispositivo no admite la reproducción en la sala.',
    NO_LOGIN: '🔒 Inicia sesión en Cineflix (Telegram) en esta web para ver la película.',
    NO_MP4: '🎞️ Esa película no tiene versión mp4.',
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
    if (SHOW_NATIVE && !window.__cineStreamMock) { SHOW.preparing = false; SHOW.error = SHOW_ERRORS.NATIVE; showRender(); return; }
    SHOW.status = 'Cargando el reproductor…'; showRender();
    try {
        const eng = await showLoadEngine();
        if (SHOW.key !== key) return;
        const r = await eng.prepare(mv, showVideo, (s) => { if (SHOW.key === key) { SHOW.status = s; showRender(); } });
        if (SHOW.key !== key) { try { eng.stop(showVideo); } catch (e) {} return; }
        SHOW.prepared = true; SHOW.preparing = false; SHOW.status = '✅ Película lista';
        showReportDuration(r && r.duration);
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

/* ── Vídeo (en un contenedor mínimo; ampliable) ── */
function showVideoEl() {
    if (showVideo) return showVideo;
    showVideo = showEl('show-video');
    showVideo.muted = true; showVideo.playsInline = true; showVideo.setAttribute('playsinline', '');
    showVideo.addEventListener('error', () => { if (SHOW.prepared) { SHOW.error = SHOW_ERRORS.FAILED; showRender(); } });
    showVideo.addEventListener('seeked', () => { if (SHOW.seekPending) { SHOW.seekPending = false; SHOW.lead = Math.min(8, Math.max(0, (Date.now() - SHOW.lastSeekAt) / 1000)); } });
    return showVideo;
}
function showPlay() {
    const v = showVideoEl();
    const p = v.play();
    if (p && p.catch) p.then(() => { if (SHOW.blocked) { SHOW.blocked = false; showRender(); } }).catch(() => { if (!SHOW.blocked) { SHOW.blocked = true; showRender(); } });
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
    if (v.readyState < 1) return;
    if (v.seeking) return;
    const drift = target - v.currentTime;
    const limit = isFinite(v.duration) ? Math.max(0, v.duration - 0.5) : target;
    const since = Date.now() - (SHOW.lastSeekAt || 0);
    // Desfase grande: se salta al punto actual (más lo que tardó el salto anterior en completarse). Sin saltos en cadena.
    if (Math.abs(drift) > 1.5 && (since > 5000 || Math.abs(drift) > 8)) {
        SHOW.lastSeekAt = Date.now(); SHOW.seekPending = true;
        try { v.currentTime = Math.max(0, Math.min(target + (SHOW.lead || 0), limit)); } catch (e) {}
        v.playbackRate = 1;
    }
    else if (Math.abs(drift) > 0.5) v.playbackRate = drift > 0 ? 1.15 : 0.88;
    else if (v.playbackRate !== 1) v.playbackRate = 1;
    if (v.paused && !v.ended && !SHOW.blocked) showPlay();
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
        msg.textContent = '🎟️ Sesión de cine: vota entre 4 películas y velas todos juntos en la pantalla';
        rowBtns.appendChild(showBtn('🗳️ Proponer película', 'start', () => {
            if (!seated) return toast('Siéntate para proponer una película 🪑');
            netSend({ type: 'show_start' });
        }));
    } else if (SHOW.phase === 'voting') {
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
    } else if (SHOW.phase === 'loading') {
        msg.textContent = '🍿 «' + showTitle(SHOW.movie) + '» empieza en ';
        showCountEl = document.createElement('b'); showCountEl.id = 'show-count'; msg.appendChild(showCountEl);
        st.textContent = SHOW.error || SHOW.status || '';
    } else if (SHOW.phase === 'playing') {
        msg.textContent = '🎬 En pantalla: «' + showTitle(SHOW.movie) + '»';
        const ok = SHOW.prepared && !SHOW.error;
        if (ok) {
            rowBtns.appendChild(showBtn(SHOW.soundOn ? '🔊 Sonido: ON' : '🔇 Activar sonido', 'mute', showToggleSound, SHOW.soundOn ? 'on' : ''));
            rowBtns.appendChild(showBtn('🔍 Ampliar', 'expand', () => showSetExpanded(true)));
            if (SHOW.blocked) rowBtns.appendChild(showBtn('▶ Toca para reproducir', 'play', () => { SHOW.blocked = false; showPlay(); showRender(); }, 'on'));
        }
        st.textContent = SHOW.error || (ok ? '' : (SHOW.status || 'Preparando…'));
    }
    head.append(msg, rowBtns);
    panel.append(head, st);
    if (!st.textContent) st.classList.add('hidden');
    showTick();
    if (focusKey) { const f = panel.querySelector('[data-k="' + focusKey + '"]'); if (f) { try { f.focus({ preventScroll: true }); } catch (e) { f.focus(); } } }
    document.documentElement.style.setProperty('--show-h', (panel.offsetHeight + 10) + 'px');
    showUpdateOverlayBtns();
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
function showSetExpanded(on) {
    const ov = showEl('screen-overlay');
    if (!ov) return;
    SHOW.expanded = !!on;
    ov.classList.toggle('full', SHOW.expanded);
    ov.classList.toggle('mini', !SHOW.expanded);
    if (SHOW.expanded) {
        showRenderCaps();
        const c = showEl('so-close'); if (c) { try { c.focus({ preventScroll: true }); } catch (e) { c.focus(); } }
    }
    showUpdateOverlayBtns();
}
function showUpdateOverlayBtns() {
    const m = showEl('so-mute');
    if (m) m.textContent = SHOW.soundOn ? '🔊 Sonido: ON' : '🔇 Activar sonido';
}
function showHandleBack() {
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
    if (SHOW.phase === 'idle') return;
    const cx = SCR.x + SCR.w / 2;
    ctx.save();
    ctx.textAlign = 'center';
    if (SHOW.phase === 'playing' && SHOW.prepared && showVideo && showVideo.readyState >= 2 && !SHOW.error) {
        // Vídeo en baja resolución con píxeles gruesos (estilo retro): 186×105 ampliado ×2
        const PW = 186, PH = 105;
        if (!showPix) { showPix = document.createElement('canvas'); showPix.width = PW; showPix.height = PH; showPixCtx = showPix.getContext('2d'); }
        const vw = showVideo.videoWidth || 16, vh = showVideo.videoHeight || 9;
        const sc = Math.min(PW / vw, PH / vh), dw = Math.round(vw * sc), dh = Math.round(vh * sc);
        showPixCtx.fillStyle = '#000'; showPixCtx.fillRect(0, 0, PW, PH);
        try { showPixCtx.drawImage(showVideo, Math.round((PW - dw) / 2), Math.round((PH - dh) / 2), dw, dh); } catch (e) {}
        ctx.fillStyle = '#000'; ctx.fillRect(SCR.x, SCR.y, SCR.w, SCR.h);
        ctx.imageSmoothingEnabled = false;
        ctx.drawImage(showPix, 0, 0, PW, PH, Math.round(cx - PW), SCR.y, PW * 2, PH * 2);
        ctx.restore();
        return;
    }
    ctx.fillStyle = 'rgba(4,6,12,0.86)'; ctx.fillRect(SCR.x, SCR.y, SCR.w, SCR.h);
    const gold = '#f1c40f';
    if (SHOW.phase === 'voting') {
        ctx.fillStyle = gold; ctx.font = '12px ' + SHOW_FONT;
        ctx.fillText('¿QUÉ VEMOS?  ' + showFmt(SHOW.endsAt - srvNow()), cx, SCR.y + 28);
        ctx.font = '9px ' + SHOW_FONT;
        SHOW.candidates.forEach((c, i) => {
            const n = SHOW.votes[i] || 0;
            ctx.fillStyle = SHOW.myVote === i ? '#2ecc71' : '#fff';
            ctx.fillText(showFit(ctx, (i + 1) + '. ' + showTitle(c) + '  [' + n + ']', SCR.w - 40), cx, SCR.y + 62 + i * 28);
        });
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
