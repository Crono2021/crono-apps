/* =========================================================================
   CINEFLIX 16-BIT — Cartelera, salas compartidas en directo y creador
   ========================================================================= */
'use strict';

const STORAGE_AVATAR = 'cineflix_16bit_avatar';
const STORAGE_KEY = 'cineflix_cine_key';
const ROWS = 4, COLS = 8, SEAT_COUNT = 32;
const SEAT_W = 56, SEAT_H = 42;
const ROW_Y = [258, 318, 378, 438];
const SCR = { x: 170, y: 20, w: 620, h: 210 };

const ROOMS = [
    { id: 'bttf',  name: 'Regreso al Futuro',       tagline: '88 millas por hora' },
    { id: 'indy',  name: 'Indiana Jones',           tagline: '¡Corre, que viene la roca!' },
    { id: 'lotr',  name: 'El Señor de los Anillos', tagline: 'Un anillo para gobernarlos a todos' },
    { id: 'inter', name: 'Interstellar',            tagline: 'Más allá del horizonte de sucesos' }
];

/* ───────────────────────── Personaje del usuario ───────────────────────── */
const DEFAULT_AVATAR = {
    name: '', quote: '',
    skin: '#ffcc99', hairStyle: 'messy', hairColor: '#3a2518',
    topStyle: 'cineflix_tee', topColor: '#c0392b', bottomColor: '#1e293b', accessory: '3d_glasses',
    eyeColor: '#0f172a', hat: 'none', hatColor: '#c0392b', facial: 'none', glasses: 'none',
    bottomStyle: 'pants', shoeColor: '#111827', mouth: 'neutral'
};
let myCharacter = Object.assign({}, DEFAULT_AVATAR);
let hasSavedAvatar = false;
try {
    const saved = localStorage.getItem(STORAGE_AVATAR);
    if (saved) { Object.assign(myCharacter, JSON.parse(saved)); hasSavedAvatar = true; }
} catch (e) {}
if (!myCharacter.name) {
    // Nombre por defecto: el del perfil de Cineflix (solo una sugerencia editable, no toca la cuenta)
    try {
        const p = JSON.parse(localStorage.getItem('cineflix_current_profile') || 'null');
        if (p && typeof p.name === 'string') myCharacter.name = p.name.slice(0, 16);
    } catch (e) {}
    if (!myCharacter.name) myCharacter.name = 'Cinéfilo';
}

function getClientKey() {
    let k = null;
    try { k = localStorage.getItem(STORAGE_KEY); } catch (e) {}
    if (!k || k.length < 12) {
        const a = new Uint8Array(12);
        if (window.crypto && crypto.getRandomValues) crypto.getRandomValues(a);
        else for (let i = 0; i < a.length; i++) a[i] = Math.floor(Math.random() * 256);
        k = Array.from(a).map(b => b.toString(16).padStart(2, '0')).join('');
        try { localStorage.setItem(STORAGE_KEY, k); } catch (e) {}
    }
    return k;
}
const CLIENT_KEY = getClientKey();

function charPayload() {
    const c = myCharacter;
    return {
        skin: c.skin, hairStyle: c.hairStyle, hairColor: c.hairColor, topStyle: c.topStyle, topColor: c.topColor,
        bottomColor: c.bottomColor, accessory: c.accessory, eyeColor: c.eyeColor, hat: c.hat, hatColor: c.hatColor,
        facial: c.facial, glasses: c.glasses, bottomStyle: c.bottomStyle, shoeColor: c.shoeColor, mouth: c.mouth
    };
}

/* ───────────────────────── Estado de la sala ───────────────────────── */
const net = {
    ws: null, wantRoom: null, wantSeated: true, meta: null, status: 'offline',
    seats: new Array(SEAT_COUNT).fill(null), youId: null, viewers: 0, seated: 0,
    retry: 0, retryTimer: null, pingTimer: null, replaced: false
};
const trips = {};          // seat -> { start, duration }
const popcornUntil = {};   // seat -> timestamp
let showNames = false, bubblesOn = true, hoverSeat = -1, view = 'lobby';
let kbSeat = -1, kbCursorOn = false;   // butaca seleccionada con teclado / mando
let roomStats = {};

function mySeat() {
    if (!net.youId) return -1;
    return net.seats.findIndex(u => u && u.id === net.youId);
}

function seatPos(idx) {
    const r = Math.floor(idx / COLS), c = idx % COLS;
    return { x: c < 4 ? 140 + c * 68 : 560 + (c - 4) * 68, y: ROW_Y[r], r, c };
}

/* ───────────────────────── Red (WebSocket) ───────────────────────── */
function wsUrl() { return (location.protocol === 'https:' ? 'wss://' : 'ws://') + location.host + '/cine-ws'; }
function netSend(o) { if (net.ws && net.ws.readyState === 1) net.ws.send(JSON.stringify(o)); }

function setStatus(s) {
    net.status = s;
    const el = document.getElementById('room-status');
    el.textContent = s === 'online' ? '🟢 En directo' : s === 'connecting' ? '🟡 Conectando…' : '🔴 Sin conexión';
}

function closeSocket() {
    clearTimeout(net.retryTimer); clearInterval(net.pingTimer);
    if (net.ws) { const w = net.ws; net.ws = null; try { w.onclose = null; w.close(); } catch (e) {} }
}

function connectRoom() {
    closeSocket();
    if (!net.wantRoom) return;
    setStatus('connecting');
    let ws;
    try { ws = new WebSocket(wsUrl()); } catch (e) { scheduleReconnect(); return; }
    net.ws = ws;
    ws.onopen = () => {
        net.retry = 0;
        netSend({ type: 'join', room: net.wantRoom, clientKey: CLIENT_KEY, name: myCharacter.name, character: charPayload(), quote: myCharacter.quote || '', autoSit: net.wantSeated });
        net.pingTimer = setInterval(() => netSend({ type: 'ping' }), 25000);
    };
    ws.onmessage = (ev) => { let m; try { m = JSON.parse(ev.data); } catch (e) { return; } onNetMessage(m); };
    ws.onclose = () => {
        if (net.ws !== ws) return;
        net.ws = null; clearInterval(net.pingTimer);
        setStatus('offline');
        if (net.wantRoom && !net.replaced) scheduleReconnect();
    };
    ws.onerror = () => {};
}

function scheduleReconnect() {
    clearTimeout(net.retryTimer);
    const delay = Math.min(8000, 800 * Math.pow(2, net.retry++));
    net.retryTimer = setTimeout(connectRoom, delay);
}

function onNetMessage(m) {
    const now = Date.now();
    switch (m.type) {
        case 'joined': {
            net.meta = m.room; net.seats = m.seats; net.youId = m.you.id;
            net.viewers = m.viewers; net.seated = m.seated;
            for (const k in trips) delete trips[k];
            net.seats.forEach((u, i) => { if (u && u.away) trips[i] = { start: now - 8000, duration: 16000 }; });
            clearBubbles();
            setStatus('online'); updateRoomUI();
            break;
        }
        case 'seat': {
            const prev = net.seats[m.seat];
            net.seats[m.seat] = m.user; net.seated = m.seated;
            if (!m.user) { delete trips[m.seat]; removeBubble(m.seat); }
            else if (!m.user.away) delete trips[m.seat];
            if (m.user && m.user.id === net.youId && !(prev && prev.id === net.youId)) playSfx('sit');
            else if (!m.user && prev && prev.id === net.youId) playSfx('stand');
            updateRoomUI();
            break;
        }
        case 'count': net.viewers = m.viewers; net.seated = m.seated; updateRoomUI(); break;
        case 'say': {
            if (trips[m.seat] && now - trips[m.seat].start < trips[m.seat].duration) break;
            showBubble(m.seat, m.name, m.text, m.kind);
            break;
        }
        case 'event': {
            if (m.kind === 'restroom') {
                if (net.seats[m.seat]) net.seats[m.seat].away = true;
                trips[m.seat] = { start: now, duration: m.duration || 16000 };
                removeBubble(m.seat);
                playSfx('door');
            } else if (m.kind === 'back') {
                if (net.seats[m.seat]) net.seats[m.seat].away = false;
                delete trips[m.seat];
                popcornUntil[m.seat] = now + 9000;
                playSfx('crunch');
            }
            break;
        }
        case 'you': updateRoomUI(); break;
        case 'error': toast(m.msg || 'Error'); break;
        case 'replaced': {
            net.replaced = true;
            document.getElementById('overlay-text').textContent = 'Has abierto el cine en otra pestaña o dispositivo, así que esta sesión se ha cerrado.';
            document.getElementById('overlay').classList.remove('hidden');
            break;
        }
    }
}

/* ───────────────────────── Acciones de usuario ───────────────────────── */
function enterRoom(id) {
    if (!ROOMS.some(r => r.id === id)) return;
    net.wantRoom = id; net.wantSeated = true; net.replaced = false; net.retry = 0;
    net.seats = new Array(SEAT_COUNT).fill(null); net.youId = null; net.meta = ROOMS.find(r => r.id === id);
    for (const k in trips) delete trips[k];
    clearBubbles();
    document.getElementById('room-title').textContent = '🎬 ' + net.meta.name;
    switchView('cinema');
    updateRoomUI();
    connectRoom();
    try { history.replaceState(null, '', '?room=' + id); } catch (e) {}
}

function leaveToLobby() {
    netSend({ type: 'leave' });
    net.wantRoom = null; closeSocket(); clearBubbles();
    try { history.replaceState(null, '', location.pathname); } catch (e) {}
    goLobby();
}
function goLobby() { switchView('lobby'); fetchRoomStats(); }

function toggleSit() {
    if (mySeat() >= 0) { net.wantSeated = false; netSend({ type: 'stand' }); }
    else {
        net.wantSeated = true;
        const free = net.seats.findIndex((u, i) => !u && [1, 2].includes(seatPos(i).r));
        const any = free >= 0 ? free : net.seats.findIndex(u => !u);
        if (any < 0) return toast('La sala está llena 😢');
        netSend({ type: 'sit', seat: any });
    }
}
function sitAtNumber() {
    const n = parseInt(document.getElementById('seat-input').value, 10);
    if (!(n >= 1 && n <= SEAT_COUNT)) return toast('Elige una butaca del 1 al 32');
    trySit(n - 1);
}
function trySit(idx) {
    const u = net.seats[idx];
    if (u && u.id === net.youId) return;
    if (u) return toast('Esa butaca ya la ocupa ' + u.name);
    net.wantSeated = true;
    netSend({ type: 'sit', seat: idx });
}
function sendChat() {
    const inp = document.getElementById('hud-chat-input');
    const t = inp.value.trim();
    if (!t) return;
    if (mySeat() < 0) return toast('Siéntate primero para poder hablar 🪑');
    netSend({ type: 'say', text: t });
    inp.value = '';
}
function toggleBubbles() {
    bubblesOn = !bubblesOn;
    const b = document.getElementById('tool-bubbles');
    b.textContent = '💬 Burbujas: ' + (bubblesOn ? 'ON' : 'OFF');
    b.classList.toggle('on', bubblesOn);
    if (!bubblesOn) clearBubbles();
}
function toggleNames() {
    showNames = !showNames;
    const b = document.getElementById('tool-names');
    b.textContent = '🏷️ Nombres: ' + (showNames ? 'ON' : 'OFF');
    b.classList.toggle('on', showNames);
}

/* ───────────────────────── Interfaz ───────────────────────── */
let toastTimer = null;
function toast(msg) {
    const el = document.getElementById('toast');
    el.textContent = msg; el.classList.remove('hidden');
    clearTimeout(toastTimer); toastTimer = setTimeout(() => el.classList.add('hidden'), 2600);
}

function updateRoomUI() {
    const seated = mySeat() >= 0;
    const sit = document.getElementById('tool-sit');
    sit.textContent = seated ? '🚶 Levantarme' : '🪑 Sentarme';
    sit.classList.toggle('on', seated);
    document.getElementById('room-count').textContent = `👥 ${net.viewers} · 🪑 ${net.seated}/${SEAT_COUNT}`;
    const inp = document.getElementById('hud-chat-input');
    inp.placeholder = seated ? 'Escribe algo y tu personaje lo dirá en voz alta…' : 'Siéntate para poder hablar…';
}

function switchView(name) {
    view = name;
    document.getElementById('view-lobby').classList.toggle('hidden', name !== 'lobby');
    document.getElementById('view-cinema').classList.toggle('hidden', name !== 'cinema');
    document.getElementById('view-creator').classList.toggle('hidden', name !== 'creator');
    document.getElementById('btn-tab-lobby').classList.toggle('active', name !== 'creator');
    document.getElementById('btn-tab-creator').classList.toggle('active', name === 'creator');
    if (name === 'creator') { initCreatorOptions(); renderCreatorPreview(); }
    if (name === 'lobby') renderLobbyMe();
}

function renderLobbyMe() {
    document.getElementById('lobby-me-name').textContent = myCharacter.name || 'Cinéfilo';
    const cv = document.getElementById('lobby-avatar-canvas');
    const ctx = cv.getContext('2d');
    ctx.clearRect(0, 0, cv.width, cv.height);
    draw16BitCharacterCrisp(ctx, myCharacter, 12, 22, 2, { isSitting: false, animFrame: 0 });
}

function buildLobby() {
    const grid = document.getElementById('lobby-grid');
    grid.textContent = '';
    ROOMS.forEach(r => {
        const card = document.createElement('button');
        card.className = 'room-card'; card.type = 'button'; card.dataset.room = r.id;
        const cv = document.createElement('canvas');
        cv.width = SCENE_W; cv.height = SCENE_H; cv.id = 'thumb-' + r.id;
        const body = document.createElement('div'); body.className = 'room-card-body';
        const name = document.createElement('div'); name.className = 'room-card-name'; name.textContent = r.name;
        const tag = document.createElement('div'); tag.className = 'room-card-tag'; tag.textContent = '“' + r.tagline + '”';
        const meta = document.createElement('div'); meta.className = 'room-card-meta';
        const cnt = document.createElement('span'); cnt.id = 'cnt-' + r.id; cnt.textContent = '🪑 0/' + SEAT_COUNT;
        const bar = document.createElement('div'); bar.className = 'room-card-bar';
        const fill = document.createElement('i'); fill.id = 'bar-' + r.id; bar.appendChild(fill);
        meta.append(cnt, bar);
        const go = document.createElement('div'); go.className = 'room-card-go'; go.textContent = '🎟️ Entrar a la sala';
        body.append(name, tag, meta, go);
        card.append(cv, body);
        card.onclick = () => enterRoom(r.id);
        grid.appendChild(card);
    });
}

async function fetchRoomStats() {
    try {
        const res = await fetch('/api/cine/rooms', { cache: 'no-store' });
        if (!res.ok) return;
        const list = await res.json();
        list.forEach(s => {
            roomStats[s.id] = s;
            const cnt = document.getElementById('cnt-' + s.id), bar = document.getElementById('bar-' + s.id);
            if (cnt) cnt.textContent = `🪑 ${s.seated}/${s.capacity}` + (s.viewers > s.seated ? ` · 👀 ${s.viewers - s.seated}` : '');
            if (bar) bar.style.width = Math.round(100 * s.seated / s.capacity) + '%';
        });
    } catch (e) {}
}
setInterval(() => { if (view === 'lobby' && !document.hidden) fetchRoomStats(); }, 5000);

/* ───────────────────────── Burbujas de texto (DOM, siempre textContent) ───────────────────────── */
const bubbleLayer = document.getElementById('bubble-layer');
const bubbles = new Map();   // seat -> element

function removeBubble(seat) { const b = bubbles.get(seat); if (b) { b.remove(); bubbles.delete(seat); } }
function clearBubbles() { bubbles.forEach(b => b.remove()); bubbles.clear(); }

function showBubble(seat, name, text, kind) {
    if (!bubblesOn || view !== 'cinema') return;
    removeBubble(seat);
    while (bubbles.size >= 6) { const first = bubbles.keys().next().value; removeBubble(first); }
    const p = seatPos(seat);
    const b = document.createElement('div');
    b.className = 'pixel-bubble' + (kind === 'ambient' ? ' ambient' : '') + (net.seats[seat] && net.seats[seat].id === net.youId ? ' mine' : '');
    const sp = document.createElement('div'); sp.className = 'bubble-speaker';
    const ic = document.createElement('span'); ic.textContent = '🎬';
    const nm = document.createElement('span'); nm.textContent = String(name || '');
    sp.append(ic, nm);
    const tx = document.createElement('div'); tx.className = 'bubble-text'; tx.textContent = String(text || '');
    b.append(sp, tx);
    bubbleLayer.appendChild(b);
    const W = bubbleLayer.clientWidth, H = bubbleLayer.clientHeight;
    const cx = (p.x + 28) / 960 * W, cy = (p.y - 24) / 540 * H;
    const bw = b.offsetWidth;
    // Zona visible (en móvil la sala se recorta a los lados): las burbujas no deben salirse de ella
    const wr = document.getElementById('cinema-wrapper').getBoundingClientRect(), sr = bubbleLayer.getBoundingClientRect();
    const minX = Math.max(0, wr.left - sr.left), maxX = Math.min(W, wr.right - sr.left);
    const clamped = Math.min(Math.max(cx, minX + bw / 2 + 4), maxX - bw / 2 - 4);
    b.style.left = clamped + 'px';
    b.style.top = Math.max(cy, b.offsetHeight + 8) + 'px';
    b.style.setProperty('--tx', Math.max(-bw / 2 + 14, Math.min(bw / 2 - 14, cx - clamped)) + 'px');
    bubbles.set(seat, b);
    playBlip(kind === 'ambient' ? 440 : 560, 'sine', 0.07);
    const life = kind === 'ambient' ? 5200 : 6500;
    setTimeout(() => {
        if (bubbles.get(seat) !== b) return;
        b.classList.add('fade-out');
        setTimeout(() => { if (bubbles.get(seat) === b) bubbles.delete(seat); b.remove(); }, 320);
    }, life);
}

/* ───────────────────────── Dibujo de la sala ───────────────────────── */
const cinemaCanvas = document.getElementById('cinema-canvas');
const cinemaCtx = cinemaCanvas.getContext('2d');
cinemaCtx.imageSmoothingEnabled = false;

function makeLayer(draw) {
    const cv = document.createElement('canvas'); cv.width = 960; cv.height = 540;
    const c = cv.getContext('2d'); c.imageSmoothingEnabled = false; draw(c); return cv;
}

function paintRoomBackground(ctx) {
    const w = 960, h = 540, wallW = 110;
    ctx.fillStyle = '#080a10'; ctx.fillRect(0, 0, w, h);
    // Paredes laterales con paneles
    for (const x0 of [0, w - wallW]) {
        ctx.fillStyle = '#16131c'; ctx.fillRect(x0, 0, wallW, h);
        for (let i = 0; i < 6; i++) {
            ctx.fillStyle = '#231e2d'; ctx.fillRect(x0 + 15, 35 + i * 82, 80, 60);
            ctx.fillStyle = '#120f18'; ctx.fillRect(x0 + 20, 40 + i * 82, 70, 50);
        }
    }
    // Apliques
    [[55, 110], [55, 270], [w - 55, 110], [w - 55, 270]].forEach(([x, y]) => {
        ctx.fillStyle = '#d97706'; ctx.fillRect(x - 4, y, 8, 14);
        ctx.fillStyle = '#fef08a'; ctx.fillRect(x - 6, y - 10, 12, 10);
        const g = ctx.createRadialGradient(x, y - 5, 2, x, y - 5, 45);
        g.addColorStop(0, 'rgba(251,191,36,0.4)'); g.addColorStop(1, 'rgba(251,191,36,0)');
        ctx.fillStyle = g; ctx.beginPath(); ctx.arc(x, y - 5, 45, 0, Math.PI * 2); ctx.fill();
    });
    // Salidas
    ctx.fillStyle = '#064e3b'; ctx.fillRect(35, 25, 45, 18); ctx.fillRect(w - 80, 25, 45, 18);
    ctx.font = 'bold 8px "Press Start 2P", monospace'; ctx.fillStyle = '#34d399';
    ctx.fillText('SALIDA', 39, 38); ctx.fillText('SALIDA', w - 76, 38);
    // Suelo y pasillo central
    ctx.fillStyle = '#260a0f'; ctx.fillRect(wallW, 240, w - wallW * 2, h - 240);
    ctx.fillStyle = '#7f1d1d'; ctx.fillRect(412, 240, 136, h - 240);
    ctx.fillStyle = '#f59e0b'; ctx.fillRect(410, 240, 3, h - 240); ctx.fillRect(547, 240, 3, h - 240);
    ctx.fillStyle = 'rgba(245,158,11,0.12)';
    for (let cy = 258; cy < h; cy += 34) { ctx.fillRect(458, cy, 10, 10); ctx.fillRect(492, cy, 10, 10); }
    // Luces de fila en el suelo
    ctx.fillStyle = 'rgba(253,224,71,0.35)';
    for (let r = 0; r < ROWS; r++) { ctx.fillRect(404, ROW_Y[r] + 46, 6, 3); ctx.fillRect(550, ROW_Y[r] + 46, 6, 3); }
    // Marco de la pantalla
    ctx.fillStyle = '#0f172a'; ctx.fillRect(SCR.x - 8, SCR.y - 8, SCR.w + 16, SCR.h + 16);
    ctx.fillStyle = '#334155'; ctx.fillRect(SCR.x - 4, SCR.y - 4, SCR.w + 8, SCR.h + 8);
    ctx.fillStyle = '#000'; ctx.fillRect(SCR.x, SCR.y, SCR.w, SCR.h);
}

function paintRoomForeground(ctx) {
    // Línea de escaneo suave sobre la pantalla (alineada a los píxeles gordos)
    ctx.fillStyle = 'rgba(0,0,0,0.16)';
    for (let y = SCR.y; y < SCR.y + SCR.h; y += 3) ctx.fillRect(SCR.x, y + 2, SCR.w, 1);
    // Ventanilla del proyector (sin haz sobre la pantalla para no velar la imagen)
    ctx.fillStyle = '#05070c'; ctx.fillRect(452, 0, 56, 9);
    ctx.fillStyle = 'rgba(224,242,254,0.85)'; ctx.fillRect(470, 3, 20, 4);
    // Cortinas
    const cw = 60;
    const gl = ctx.createLinearGradient(SCR.x - cw, 0, SCR.x + 10, 0);
    gl.addColorStop(0, '#581c1c'); gl.addColorStop(0.5, '#991b1b'); gl.addColorStop(1, '#450a0a');
    ctx.fillStyle = gl; ctx.fillRect(SCR.x - cw, SCR.y - 15, cw + 10, SCR.h + 30);
    ctx.fillStyle = '#f59e0b'; ctx.fillRect(SCR.x + 6, SCR.y - 15, 3, SCR.h + 30);
    const gr = ctx.createLinearGradient(SCR.x + SCR.w - 10, 0, SCR.x + SCR.w + cw, 0);
    gr.addColorStop(0, '#450a0a'); gr.addColorStop(0.5, '#991b1b'); gr.addColorStop(1, '#581c1c');
    ctx.fillStyle = gr; ctx.fillRect(SCR.x + SCR.w - 10, SCR.y - 15, cw + 10, SCR.h + 30);
    ctx.fillStyle = '#f59e0b'; ctx.fillRect(SCR.x + SCR.w - 9, SCR.y - 15, 3, SCR.h + 30);
    ctx.fillStyle = '#7f1d1d'; ctx.fillRect(SCR.x - cw, SCR.y - 15, SCR.w + cw * 2, 18);
    ctx.fillStyle = '#f59e0b'; ctx.fillRect(SCR.x - cw, SCR.y + 3, SCR.w + cw * 2, 3);
}
const bgLayer = makeLayer(paintRoomBackground);
const fgLayer = makeLayer(paintRoomForeground);

function drawVelvetSeat(ctx, x, y, hot) {
    const sw = SEAT_W, sh = SEAT_H;
    ctx.fillStyle = hot ? '#f39c12' : '#1e0508'; ctx.fillRect(x - 2, y - 2, sw + 4, sh + 4);
    ctx.fillStyle = '#831843'; ctx.fillRect(x, y, sw, sh);
    ctx.fillStyle = '#9d174d'; ctx.fillRect(x + 4, y + 4, sw - 8, sh - 14);
    ctx.fillStyle = '#500724'; ctx.fillRect(x + 16, y + 10, 2, 10); ctx.fillRect(x + 36, y + 10, 2, 10);
    ctx.fillStyle = '#261b17'; ctx.fillRect(x - 6, y + 14, 6, 26); ctx.fillRect(x + sw, y + 14, 6, 26);
    ctx.fillStyle = '#d97706'; ctx.fillRect(x - 5, y + 14, 4, 3); ctx.fillRect(x + sw + 1, y + 14, 4, 3);
    ctx.fillStyle = '#701a35'; ctx.fillRect(x - 2, y + sh - 8, sw + 4, 18);
}

// Posición a lo largo del camino asiento → pasillo → salida (s = distancia recorrida desde la butaca)
function pathPoint(seatIdx, s) {
    const p = seatPos(seatIdx);
    const fx = p.x + 28, fy = p.y + 56;
    const aisle = 480, exitY = 585;
    const d1 = Math.abs(aisle - fx), d2 = exitY - fy;
    if (s < d1) return { x: fx + Math.sign(aisle - fx) * s, y: fy, total: d1 + d2 };
    return { x: aisle, y: fy + (s - d1), total: d1 + d2 };
}
const WALK_SPEED = 120; // px/s en coordenadas de sala
function tripState(seatIdx, trip, now) {
    const el = now - trip.start;
    if (el >= trip.duration) return null;
    const total = pathPoint(seatIdx, 0).total;
    const leaveT = total / WALK_SPEED * 1000;
    if (el < leaveT) return { ...pathPoint(seatIdx, el / 1000 * WALK_SPEED), returning: false };
    const returnStart = trip.duration - leaveT;
    if (el >= returnStart) return { ...pathPoint(seatIdx, (trip.duration - el) / 1000 * WALK_SPEED), returning: true };
    return { hidden: true };
}

function drawRoom(now) {
    const ctx = cinemaCtx;
    ctx.drawImage(bgLayer, 0, 0);
    // Proyección (sincronizada para todos con el reloj real)
    const roomId = net.meta ? net.meta.id : 'bttf';
    const sc = renderScene(roomId, now);
    ctx.save();
    ctx.beginPath(); ctx.rect(SCR.x, SCR.y, SCR.w, SCR.h); ctx.clip();
    ctx.imageSmoothingEnabled = false;
    ctx.drawImage(sc, 0, 0, SCENE_W, SCENE_H, SCR.x, SCR.y, SCENE_W * 3, SCENE_H * 3);
    ctx.restore();
    ctx.drawImage(fgLayer, 0, 0);

    const me = mySeat();
    const walkers = [];
    for (let r = 0; r < ROWS; r++) {
        for (let c = 0; c < COLS; c++) {
            const idx = r * COLS + c, p = seatPos(idx);
            const u = net.seats[idx];
            drawVelvetSeat(ctx, p.x, p.y, (idx === hoverSeat && !u) || idx === me);
            let trip = trips[idx];
            let st = trip ? tripState(idx, trip, now) : null;
            if (trip && !st) { delete trips[idx]; popcornUntil[idx] = now + 9000; trip = null; }
            if (!u) {
                // butaca libre: número
                ctx.font = 'bold 10px "Press Start 2P", monospace'; ctx.textAlign = 'center';
                ctx.fillStyle = idx === hoverSeat ? '#fff' : 'rgba(253,231,239,0.75)';
                ctx.fillText(String(idx + 1), p.x + 28, p.y + 34);
                ctx.textAlign = 'left';
                continue;
            }
            if (st) { walkers.push({ idx, u, st }); continue; }
            const chewing = now < (popcornUntil[idx] || 0) || (u.character.accessory === 'popcorn' && Math.floor(now / 450) % 2 === 0);
            const ch = (now < (popcornUntil[idx] || 0) && u.character.accessory === 'none') ? Object.assign({}, u.character, { accessory: 'popcorn' }) : u.character;
            draw16BitCharacterCrisp(ctx, ch, p.x + 4, p.y - 18, 2, {
                isSitting: true, isChewing: chewing && Math.floor(now / 450) % 2 === 0,
                blink: (Math.floor((now + idx * 977) / 2500) % 7 === 0)
            });
        }
    }
    // Quien camina (baño, palomitas)
    walkers.forEach(w => {
        if (w.st.hidden) return;
        const ch = w.st.returning ? Object.assign({}, w.u.character, { accessory: 'popcorn' }) : w.u.character;
        draw16BitCharacterCrisp(ctx, ch, w.st.x - 24, w.st.y - 66, 2, { isSitting: false, animFrame: Math.floor(now / 150) % 4 });
    });

    // Marca "TÚ" y nombres
    ctx.textAlign = 'center';
    if (me >= 0 && !(trips[me])) {
        const p = seatPos(me), bob = Math.round(Math.sin(now / 250) * 2);
        ctx.font = 'bold 8px "Press Start 2P", monospace';
        ctx.fillStyle = '#000'; ctx.fillText('TÚ', p.x + 29, p.y - 31 + bob);
        ctx.fillStyle = '#f1c40f'; ctx.fillText('TÚ', p.x + 28, p.y - 32 + bob);
        ctx.fillStyle = '#f1c40f'; ctx.fillRect(p.x + 25, p.y - 28 + bob, 7, 2); ctx.fillRect(p.x + 27, p.y - 26 + bob, 3, 2);
    }
    if (showNames) {
        ctx.font = '700 10px Outfit, sans-serif';
        net.seats.forEach((u, idx) => {
            if (!u || trips[idx]) return;
            const p = seatPos(idx);
            let nm = u.name.length > 10 ? u.name.slice(0, 9) + '…' : u.name;
            const tw = ctx.measureText(nm).width + 8;
            ctx.fillStyle = 'rgba(0,0,0,0.72)'; ctx.fillRect(Math.round(p.x + 28 - tw / 2), p.y + 36, tw, 13);
            ctx.fillStyle = idx === me ? '#f1c40f' : '#e2e8f0'; ctx.fillText(nm, p.x + 28, p.y + 46);
        });
    }
    ctx.textAlign = 'left';

    // Cursor de butaca (mando de TV / teclado): visible cuando la sala tiene el foco
    if (kbCursorOn && document.activeElement === cinemaCanvas && kbSeat >= 0) {
        const p = seatPos(kbSeat), u = net.seats[kbSeat];
        ctx.save();
        ctx.lineWidth = 3; ctx.strokeStyle = '#f1c40f'; ctx.setLineDash([6, 4]);
        ctx.lineDashOffset = -(now / 60) % 10;
        ctx.strokeRect(p.x - 8, p.y - 20, SEAT_W + 16, 80);
        ctx.restore();
        const label = u ? (u.id === net.youId ? 'Tu butaca ' + (kbSeat + 1) + ' · OK para levantarte' : u.name + ' · butaca ' + (kbSeat + 1))
                        : 'Butaca ' + (kbSeat + 1) + ' libre · OK para sentarte';
        ctx.font = '700 13px Outfit, sans-serif'; ctx.textAlign = 'center';
        const tw = ctx.measureText(label).width + 16;
        const lx = Math.min(Math.max(p.x + SEAT_W / 2, tw / 2 + 4), 960 - tw / 2 - 4), ly = p.y - 34;
        ctx.fillStyle = 'rgba(0,0,0,0.85)'; ctx.fillRect(Math.round(lx - tw / 2), ly - 14, tw, 20);
        ctx.strokeStyle = '#f1c40f'; ctx.lineWidth = 1; ctx.strokeRect(Math.round(lx - tw / 2) + 0.5, ly - 13.5, tw - 1, 19);
        ctx.fillStyle = '#f1c40f'; ctx.fillText(label, lx, ly);
        ctx.textAlign = 'left';
    }
}

/* ───────────────────────── Ratón / tacto sobre la sala ───────────────────────── */
function canvasPoint(ev) {
    const r = cinemaCanvas.getBoundingClientRect();
    const t = ev.touches && ev.touches[0] ? ev.touches[0] : ev;
    return { x: (t.clientX - r.left) / r.width * 960, y: (t.clientY - r.top) / r.height * 540, px: t.clientX - r.left, py: t.clientY - r.top };
}
function seatAt(pt) {
    for (let r = ROWS - 1; r >= 0; r--) {          // la fila delantera tiene prioridad
        for (let c = COLS - 1; c >= 0; c--) {
            const idx = r * COLS + c, p = seatPos(idx);
            if (pt.x >= p.x - 6 && pt.x <= p.x + SEAT_W + 6 && pt.y >= p.y - 18 && pt.y <= p.y + 58) return idx;
        }
    }
    return -1;
}
const seatTip = document.getElementById('seat-tip');
cinemaCanvas.addEventListener('mousemove', (ev) => {
    const pt = canvasPoint(ev), idx = seatAt(pt);
    hoverSeat = idx;
    cinemaCanvas.classList.toggle('hover-seat', idx >= 0 && !net.seats[idx]);
    if (idx < 0) { seatTip.classList.add('hidden'); return; }
    const u = net.seats[idx];
    seatTip.textContent = '';
    const b = document.createElement('div');
    b.textContent = u ? u.name : `Butaca ${idx + 1} · libre`;
    seatTip.appendChild(b);
    if (u && u.quote) { const q = document.createElement('small'); q.textContent = '“' + u.quote + '”'; seatTip.appendChild(q); }
    if (!u) { const q = document.createElement('small'); q.textContent = 'Clic para sentarte'; seatTip.appendChild(q); }
    seatTip.style.left = pt.px + 'px'; seatTip.style.top = Math.max(pt.py - 12, 30) + 'px';
    seatTip.classList.remove('hidden');
});
cinemaCanvas.addEventListener('mouseleave', () => { hoverSeat = -1; seatTip.classList.add('hidden'); cinemaCanvas.classList.remove('hover-seat'); });
cinemaCanvas.addEventListener('click', (ev) => {
    const idx = seatAt(canvasPoint(ev));
    if (idx >= 0) trySit(idx);
});
document.getElementById('hud-chat-input').addEventListener('keydown', (e) => { if (e.key === 'Enter') sendChat(); });
document.getElementById('seat-input').addEventListener('keydown', (e) => { if (e.key === 'Enter') sitAtNumber(); });

/* ───────────────────────── Creador de personaje ───────────────────────── */
let previewBlink = false;
const previewCtx = document.getElementById('preview-canvas').getContext('2d');
previewCtx.imageSmoothingEnabled = false;
const hudAvatarCtx = document.getElementById('hud-avatar-canvas').getContext('2d');
hudAvatarCtx.imageSmoothingEnabled = false;
setInterval(() => {
    if (view !== 'creator') return;
    previewBlink = true; renderCreatorPreview();
    setTimeout(() => { previewBlink = false; renderCreatorPreview(); }, 180);
}, 3200);

function renderCreatorPreview() {
    previewCtx.clearRect(0, 0, 240, 240);
    draw16BitCharacterCrisp(previewCtx, myCharacter, 60, 52, 5, { isSitting: false, animFrame: 0, blink: previewBlink });
    hudAvatarCtx.clearRect(0, 0, 64, 64);
    draw16BitCharacterCrisp(hudAvatarCtx, myCharacter, 8, 2, 2, { isSitting: false, animFrame: 0 });
    document.getElementById('preview-name').textContent = myCharacter.name || 'Cinéfilo';
    document.getElementById('preview-quote').textContent = myCharacter.quote ? `"${myCharacter.quote}"` : 'Sin frase propia: dirá frases aleatorias del cine 🍿';
}

function buildPalette(cont, colors, key) {
    cont.textContent = '';
    colors.forEach(color => {
        const el = document.createElement('div');
        el.className = 'color-circle' + (myCharacter[key] === color ? ' selected' : '');
        el.style.backgroundColor = color;
        el.tabIndex = 0;
        el.setAttribute('role', 'button');
        el.setAttribute('aria-label', 'Color ' + color);
        const pickIt = () => {
            myCharacter[key] = color;
            cont.querySelectorAll('.color-circle').forEach(c => c.classList.remove('selected'));
            el.classList.add('selected'); renderCreatorPreview();
            playBlip(660, 'square', 0.04);
        };
        el.onclick = pickIt;
        el.onkeydown = ev => { if (ev.key === 'Enter' || ev.key === ' ') { ev.preventDefault(); pickIt(); } };
        cont.appendChild(el);
    });
}
// Iconos en miniatura: se dibuja el propio sprite recortado a la zona relevante
const ICON_REGIONS = {
    head:  { x: 0, y: -10, w: 24, h: 26, s: 2 },
    face:  { x: 4, y: 2,   w: 16, h: 13, s: 3 },
    torso: { x: 0, y: 12,  w: 24, h: 16, s: 2 },
    legs:  { x: 0, y: 22,  w: 24, h: 13, s: 2 },
    hand:  { x: 12, y: 13, w: 12, h: 16, s: 3 },
    right: { x: 14, y: 15, w: 10, h: 11, s: 4 },
    hair:  { x: 0, y: -6,  w: 24, h: 21, s: 2 },
    neck:  { x: 5,  y: 11, w: 14, h: 13, s: 3 }
};
const HEAD_ACCESSORIES = ['3d_glasses', 'wizard_hat', 'headphones', 'elf_ears'];
const ICON_SPEC = {
    hairStyle:   { region: 'hair',  reset: { hat: 'none', accessory: 'none', glasses: 'none', facial: 'none' } },
    hat:         { region: 'head',  reset: { hairStyle: 'short', accessory: 'none', glasses: 'none', facial: 'none' } },
    facial:      { region: 'face',  reset: { hairStyle: 'short', hat: 'none', accessory: 'none', glasses: 'none' } },
    glasses:     { region: 'face',  reset: { hairStyle: 'short', hat: 'none', accessory: 'none', facial: 'none' } },
    mouth:       { region: 'face',  reset: { hairStyle: 'short', hat: 'none', accessory: 'none', glasses: 'none', facial: 'none' } },
    topStyle:    { region: 'torso', reset: { accessory: 'none' } },
    bottomStyle: { region: 'legs',  reset: {} },
    accessory:   { region: (id) => HEAD_ACCESSORIES.includes(id) ? 'head' : (['popcorn', 'soda'].includes(id) ? 'hand' : (['ticket', 'clapper'].includes(id) ? 'right' : 'neck')), reset: { hat: 'none', glasses: 'none', facial: 'none' } }
};
function paintIcon(cv) {
    const key = cv.dataset.key, id = cv.dataset.id, spec = ICON_SPEC[key];
    if (!spec) return;
    const R = ICON_REGIONS[typeof spec.region === 'function' ? spec.region(id) : spec.region];
    cv.width = R.w * R.s; cv.height = R.h * R.s;
    const ctx = cv.getContext('2d');
    ctx.imageSmoothingEnabled = false;
    ctx.clearRect(0, 0, cv.width, cv.height);
    const ch = Object.assign({}, DEFAULT_AVATAR, spec.reset);
    ch[key] = id;
    draw16BitCharacterCrisp(ctx, ch, -R.x * R.s, -R.y * R.s, R.s, { isSitting: false, animFrame: 0 });
}
function refreshIcons() {
    document.querySelectorAll('#creator-sections canvas.choice-canvas').forEach(paintIcon);
}
function buildChoices(cont, options, key) {
    cont.textContent = '';
    options.forEach(o => {
        const btn = document.createElement('button');
        btn.type = 'button';
        btn.className = 'choice-btn' + (myCharacter[key] === o.id ? ' selected' : '');
        const ic = document.createElement('span'); ic.className = 'choice-icon';
        if (ICON_SPEC[key] && o.id !== 'none') {
            const cv = document.createElement('canvas');
            cv.className = 'choice-canvas'; cv.dataset.key = key; cv.dataset.id = o.id;
            ic.appendChild(cv);
        } else ic.textContent = o.icon;
        const nm = document.createElement('span'); nm.textContent = o.name;
        btn.append(ic, nm);
        btn.onclick = () => {
            myCharacter[key] = o.id;
            cont.querySelectorAll('.choice-btn').forEach(b => b.classList.remove('selected'));
            btn.classList.add('selected'); renderCreatorPreview();
            playBlip(660, 'square', 0.04);
        };
        cont.appendChild(btn);
    });
}

// Secciones del creador: [título, [ {type:'choices'|'palette', label?, key, list} ... ]]
const CREATOR_SECTIONS = [
    ['Tono de piel', [{ type: 'palette', key: 'skin', list: SKIN_PALETTE }]],
    ['Ojos y boca', [
        { type: 'palette', label: 'Color de ojos:', key: 'eyeColor', list: EYE_PALETTE },
        { type: 'choices', label: 'Boca:', key: 'mouth', list: MOUTH_STYLES }]],
    ['Peinado', [
        { type: 'choices', key: 'hairStyle', list: HAIR_STYLES },
        { type: 'palette', label: 'Color de pelo:', key: 'hairColor', list: HAIR_PALETTE }]],
    ['Barba y bigote', [{ type: 'choices', key: 'facial', list: FACIAL_STYLES }]],
    ['Gafas', [{ type: 'choices', key: 'glasses', list: GLASSES_STYLES }]],
    ['Sombrero', [
        { type: 'choices', key: 'hat', list: HAT_STYLES },
        { type: 'palette', label: 'Color del sombrero:', key: 'hatColor', list: HAT_PALETTE }]],
    ['Ropa superior', [
        { type: 'choices', key: 'topStyle', list: TOP_STYLES },
        { type: 'palette', label: 'Color del atuendo:', key: 'topColor', list: TOP_PALETTE }]],
    ['Pantalón, falda y calzado', [
        { type: 'choices', key: 'bottomStyle', list: BOTTOM_STYLES },
        { type: 'palette', label: 'Color de la parte de abajo:', key: 'bottomColor', list: BOTTOM_PALETTE },
        { type: 'palette', label: 'Color de zapatillas:', key: 'shoeColor', list: SHOE_PALETTE }]],
    ['Accesorio de cine & rol', [{ type: 'choices', key: 'accessory', list: ACCESSORIES }]]
];
function initCreatorOptions() {
    const root = document.getElementById('creator-sections');
    root.textContent = '';
    CREATOR_SECTIONS.forEach(([title, blocks], i) => {
        const t = document.createElement('div'); t.className = 'section-title';
        const ts = document.createElement('span'); ts.textContent = (i + 2) + '. ' + title;
        t.appendChild(ts); root.appendChild(t);
        blocks.forEach(b => {
            if (b.label) {
                const l = document.createElement('label'); l.className = 'mini-label'; l.textContent = b.label;
                root.appendChild(l);
            }
            const grid = document.createElement('div');
            grid.className = b.type === 'palette' ? 'palette-grid' : 'option-grid';
            root.appendChild(grid);
            if (b.type === 'palette') buildPalette(grid, b.list, b.key);
            else buildChoices(grid, b.list, b.key);
        });
    });
    refreshIcons();
    document.getElementById('input-char-name').value = myCharacter.name || '';
    document.getElementById('input-char-quote').value = myCharacter.quote || '';
    document.getElementById('btn-save-char').lastChild.textContent = net.wantRoom ? ' Guardar y volver a la sala' : ' Guardar personaje';
}
function updateProfileMeta() {
    myCharacter.name = document.getElementById('input-char-name').value.trim().slice(0, 16) || 'Cinéfilo';
    myCharacter.quote = document.getElementById('input-char-quote').value.trim().slice(0, 60);
    renderCreatorPreview();
}
function randomizeCharacter() {
    const pick = a => a[Math.floor(Math.random() * a.length)];
    const chance = p => Math.random() < p;
    myCharacter.skin = pick(SKIN_PALETTE);
    myCharacter.eyeColor = pick(EYE_PALETTE);
    myCharacter.hairStyle = pick(HAIR_STYLES).id;
    myCharacter.hairColor = pick(HAIR_PALETTE);
    myCharacter.facial = chance(0.35) ? pick(FACIAL_STYLES).id : 'none';
    myCharacter.glasses = chance(0.35) ? pick(GLASSES_STYLES).id : 'none';
    myCharacter.hat = chance(0.3) ? pick(HAT_STYLES).id : 'none';
    myCharacter.hatColor = pick(HAT_PALETTE);
    myCharacter.topStyle = pick(TOP_STYLES).id;
    myCharacter.topColor = pick(TOP_PALETTE);
    myCharacter.bottomStyle = pick(BOTTOM_STYLES).id;
    myCharacter.bottomColor = pick(BOTTOM_PALETTE);
    myCharacter.shoeColor = pick(SHOE_PALETTE);
    myCharacter.mouth = pick(MOUTH_STYLES).id;
    myCharacter.accessory = pick(ACCESSORIES).id;
    initCreatorOptions(); renderCreatorPreview();
    playBlip(784, 'triangle', 0.1);
}
function saveCharacter() {
    updateProfileMeta();
    try { localStorage.setItem(STORAGE_AVATAR, JSON.stringify(myCharacter)); hasSavedAvatar = true; } catch (e) {}
    playBlip(880, 'sine', 0.15);
    if (net.wantRoom) {
        netSend({ type: 'profile', name: myCharacter.name, character: charPayload(), quote: myCharacter.quote || '' });
        switchView('cinema');
        toast('Personaje actualizado ✅');
    } else {
        switchView('lobby');
        toast('Personaje guardado ✅ Elige una sala');
    }
}
function exportAvatarPNG() {
    const cv = document.createElement('canvas'); cv.width = 256; cv.height = 256;
    const c = cv.getContext('2d'); c.imageSmoothingEnabled = false;
    draw16BitCharacterCrisp(c, myCharacter, 48, 16, 6, { isSitting: false });
    const a = document.createElement('a');
    a.download = `avatar_16bit_${(myCharacter.name || 'cinefilo').toLowerCase().replace(/\s+/g, '_')}.png`;
    a.href = cv.toDataURL(); a.click();
}

/* ───────────────────────── Bucle de animación ───────────────────────── */
let lastLobbyDraw = 0;
function animationLoop() {
    const now = Date.now();
    if (view === 'cinema') {
        drawRoom(now);
    } else if (view === 'lobby' && now - lastLobbyDraw > 45) {
        lastLobbyDraw = now;
        ROOMS.forEach(r => {
            const cv = document.getElementById('thumb-' + r.id);
            if (!cv) return;
            const sc = renderScene(r.id, now);
            const c = cv.getContext('2d'); c.imageSmoothingEnabled = false; c.drawImage(sc, 0, 0);
        });
    }
    requestAnimationFrame(animationLoop);
}

/* ───────────────────────── Arranque ───────────────────────── */
buildLobby();
initCreatorOptions();
renderCreatorPreview();
document.getElementById('tool-bubbles').classList.add('on');
animationLoop();

(function boot() {
    const wanted = new URLSearchParams(location.search).get('room');
    if (!hasSavedAvatar) {
        // Primera vez: crear personaje antes de entrar
        switchView('creator');
        toast('🎨 Crea tu personaje para entrar en el cine');
    } else if (wanted && ROOMS.some(r => r.id === wanted)) {
        enterRoom(wanted);
    } else {
        goLobby();
    }
})();
