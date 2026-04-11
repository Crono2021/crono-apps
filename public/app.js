const $ = s => document.querySelector(s);
const state = { phone: '', hash: '', chats: [], filtered: [], videos: [], chat: null, offset: 0, more: false };

// --- API ---
async function post(url, data) { return (await fetch(url, { method:'POST', headers:{'Content-Type':'application/json'}, body:JSON.stringify(data) })).json(); }
async function get(url) { const r = await fetch(url); if (!r.ok) throw new Error(r.status); return r.json(); }

// --- Views ---
function show(view) {
    document.querySelectorAll('.view').forEach(v => v.classList.remove('active'));
    $(`#view-${view}`).classList.add('active');
}
function showStep(step) {
    document.querySelectorAll('.login-step').forEach(s => s.classList.remove('active'));
    $(`#step-${step}`).classList.add('active');
}
function btnLoad(btn, on) { btn.classList.toggle('loading', on); btn.disabled = on; }

// --- Auth ---
async function checkAuth() {
    try {
        const d = await get('/auth/status');
        if (d.authenticated) {
            $('#user-name').textContent = d.user.firstName || d.user.username || '';
            $('#loading-screen').classList.remove('active');
            show('chats');
            loadChats();
        } else {
            $('#loading-screen').classList.remove('active');
            show('login');
        }
    } catch {
        $('#loading-screen').classList.remove('active');
        show('login');
    }
}

async function sendCode() {
    const phone = $('#input-phone').value.trim();
    if (!phone) { $('#phone-error').textContent = 'Introduce tu numero'; return; }
    $('#phone-error').textContent = '';
    btnLoad($('#btn-send-code'), true);
    try {
        const d = await post('/auth/send-code', { phoneNumber: phone });
        if (d.success) { state.phone = phone; state.hash = d.phoneCodeHash; showStep('code'); $('#input-code').focus(); }
        else { $('#phone-error').textContent = d.error || 'Error'; }
    } catch (e) { $('#phone-error').textContent = e.message; }
    finally { btnLoad($('#btn-send-code'), false); }
}

async function verifyCode() {
    const code = $('#input-code').value.trim();
    if (!code) { $('#code-error').textContent = 'Introduce el codigo'; return; }
    $('#code-error').textContent = '';
    btnLoad($('#btn-verify'), true);
    try {
        const d = await post('/auth/verify-code', { phoneNumber: state.phone, code, phoneCodeHash: state.hash });
        if (d.needs2FA) { showStep('2fa'); $('#input-2fa').focus(); }
        else if (d.success) { $('#user-name').textContent = d.user?.firstName || ''; show('chats'); loadChats(); }
        else { $('#code-error').textContent = d.error || 'Codigo incorrecto'; }
    } catch (e) { $('#code-error').textContent = e.message; }
    finally { btnLoad($('#btn-verify'), false); }
}

async function verify2FA() {
    const pw = $('#input-2fa').value.trim();
    if (!pw) { $('#twofa-error').textContent = 'Introduce la contrasena'; return; }
    $('#twofa-error').textContent = '';
    btnLoad($('#btn-2fa'), true);
    try {
        const d = await post('/auth/2fa', { password: pw });
        if (d.success) { $('#user-name').textContent = d.user?.firstName || ''; show('chats'); loadChats(); }
        else { $('#twofa-error').textContent = d.error || 'Incorrecta'; }
    } catch (e) { $('#twofa-error').textContent = e.message; }
    finally { btnLoad($('#btn-2fa'), false); }
}

async function logout() {
    await post('/auth/logout', {}).catch(() => {});
    show('login'); showStep('phone');
    $('#input-phone').value = ''; $('#input-code').value = ''; $('#input-2fa').value = '';
}

// --- Chats ---
async function loadChats() {
    $('#chats-loading').style.display = 'flex';
    $('#chats-grid').innerHTML = '';
    try {
        const d = await get('/api/chats');
        state.chats = d.chats || [];
        state.filtered = [...state.chats];
        renderChats(state.filtered);
    } catch (e) {
        $('#chats-grid').innerHTML = `<div class="empty-state" style="grid-column:1/-1"><div class="empty-icon">⚠️</div><h4>Error</h4><p>${e.message}</p></div>`;
    }
    $('#chats-loading').style.display = 'none';
}

function renderChats(list) {
    const grid = $('#chats-grid');
    if (!list.length) { grid.innerHTML = '<div class="empty-state" style="grid-column:1/-1"><div class="empty-icon">📭</div><h4>Sin grupos</h4></div>'; return; }
    grid.innerHTML = list.map(c => {
        const ini = c.title.charAt(0).toUpperCase();
        const type = c.type === 'channel' ? 'Canal' : c.type === 'supergroup' ? 'Supergrupo' : 'Grupo';
        const av = c.hasPhoto ? `<img src="/api/chats/${c.id}/photo" onerror="this.parentElement.textContent='${ini}'">` : ini;
        return `<div class="chat-card" onclick="openChat('${c.id}','${esc(c.title)}')">
            <div class="chat-avatar">${av}</div>
            <div class="chat-info"><div class="chat-title">${esc(c.title)}</div><div class="chat-type ${c.type}">${type}</div></div>
            <svg class="chat-arrow" width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"><polyline points="9,6 15,12 9,18"></polyline></svg>
        </div>`;
    }).join('');
}

// --- Videos ---
async function openChat(id, title) {
    state.chat = { id, title }; state.videos = []; state.offset = 0;
    $('#videos-title').textContent = title;
    $('#videos-grid').innerHTML = '';
    $('#btn-load-more').style.display = 'none';
    $('#videos-count').textContent = '';
    show('videos');
    await loadVideos(id, 0);
}

async function loadVideos(chatId, offset) {
    $('#videos-loading').style.display = 'flex';
    try {
        const d = await get(`/api/chats/${chatId}/videos?limit=30&offsetId=${offset}`);
        state.videos = [...state.videos, ...(d.videos || [])];
        state.offset = d.nextOffsetId;
        state.more = d.hasMore;
        $('#videos-count').textContent = `${state.videos.length} videos`;
        renderVideos(state.videos);
        $('#btn-load-more').style.display = state.more ? 'block' : 'none';
    } catch (e) {
        if (!state.videos.length) $('#videos-grid').innerHTML = `<div class="empty-state" style="grid-column:1/-1"><div class="empty-icon">📹</div><h4>Sin videos</h4><p>${e.message}</p></div>`;
    }
    $('#videos-loading').style.display = 'none';
}

function renderVideos(list) {
    const grid = $('#videos-grid');
    if (!list.length) { grid.innerHTML = '<div class="empty-state" style="grid-column:1/-1"><div class="empty-icon">📹</div><h4>Sin videos</h4></div>'; return; }
    grid.innerHTML = list.map(v => {
        const thumb = v.thumbnailUrl ? `<img src="${v.thumbnailUrl}" loading="lazy">` : '<div class="video-thumb-placeholder"><svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="1.5"><polygon points="5,3 19,12 5,21"></polygon></svg></div>';
        const dur = fmtDur(v.duration);
        const name = v.caption ? v.caption.substring(0, 80) : v.fileName;
        const res = v.width && v.height ? `${v.width}x${v.height}` : '';
        return `<div class="video-card" onclick="playVideo('${v.chatId}','${v.messageId}','${esc(v.fileName)}')">
            <div class="video-thumb">${thumb}${dur ? `<span class="video-duration">${dur}</span>` : ''}
                <div class="video-play-overlay"><div class="play-btn-circle"><svg viewBox="0 0 24 24" fill="currentColor"><polygon points="5,3 19,12 5,21"></polygon></svg></div></div>
            </div>
            <div class="video-info"><div class="video-name" title="${esc(v.fileName)}">${esc(name)}</div>
                <div class="video-meta">${fmtSize(v.fileSize) ? `<span>📦 ${fmtSize(v.fileSize)}</span>` : ''}${res ? `<span>📐 ${res}</span>` : ''}${v.date ? `<span>📅 ${fmtDate(v.date)}</span>` : ''}</div>
            </div>
        </div>`;
    }).join('');
}

// --- Player ---
function playVideo(chatId, msgId, fileName) {
    $('#player-title').textContent = fileName;
    $('#player-subtitle').textContent = state.chat?.title || '';
    const player = $('#video-player');
    player.src = `/api/stream/${chatId}/${msgId}`;
    show('player');
    player.play().catch(() => {});
}

function stopPlayer() {
    const p = $('#video-player');
    p.pause(); p.removeAttribute('src'); p.load();
}

// --- Utils ---
function esc(s) { const d = document.createElement('div'); d.textContent = s || ''; return d.innerHTML; }
function fmtDur(s) { if (!s) return ''; const h=Math.floor(s/3600),m=Math.floor(s%3600/60),ss=s%60; return h ? `${h}:${String(m).padStart(2,'0')}:${String(ss).padStart(2,'0')}` : `${m}:${String(ss).padStart(2,'0')}`; }
function fmtSize(b) { if (!b) return ''; const u=['B','KB','MB','GB']; let i=0,s=b; while(s>=1024&&i<3){s/=1024;i++;} return `${s.toFixed(s<10?1:0)} ${u[i]}`; }
function fmtDate(t) { if (!t) return ''; const d=new Date(t*1000); return `${String(d.getDate()).padStart(2,'0')}/${String(d.getMonth()+1).padStart(2,'0')}/${d.getFullYear()}`; }

// --- Events ---
document.addEventListener('DOMContentLoaded', () => {
    $('#btn-send-code').onclick = sendCode;
    $('#input-phone').onkeypress = e => { if (e.key === 'Enter') sendCode(); };
    $('#btn-verify').onclick = verifyCode;
    $('#input-code').onkeypress = e => { if (e.key === 'Enter') verifyCode(); };
    $('#btn-2fa').onclick = verify2FA;
    $('#input-2fa').onkeypress = e => { if (e.key === 'Enter') verify2FA(); };
    $('#btn-logout').onclick = logout;
    $('#search-chats').oninput = e => { const q = e.target.value.toLowerCase(); state.filtered = q ? state.chats.filter(c => c.title.toLowerCase().includes(q)) : [...state.chats]; renderChats(state.filtered); };
    $('#btn-back-chats').onclick = () => show('chats');
    $('#btn-back-videos').onclick = () => { stopPlayer(); show('videos'); };
    $('#btn-load-more').onclick = () => { if (state.chat && state.more) loadVideos(state.chat.id, state.offset); };
    document.onkeydown = e => { if (e.key === 'Escape' && $('#view-player').classList.contains('active')) { stopPlayer(); show('videos'); } };
    checkAuth();
});
