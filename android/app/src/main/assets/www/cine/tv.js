/* =========================================================================
   CINEFLIX 16-BIT — Mando de TV / teclado: navegación con D-pad, cursor de
   butacas y teclado en pantalla. Se carga después de app.js.
   - En Android TV la app nativa convierte el D-pad en KeyboardEvents sobre
     `document` (no sobre el elemento enfocado), por eso todo cuelga de document.
   ========================================================================= */
(function () {
    'use strict';

    /* ───────────── Detección de TV (mismas reglas que la app principal) ───────────── */
    function detectTV() {
        try {
            const q = new URLSearchParams(location.search).get('tv');
            if (q === '1') return true;
            if (q === '0') return false;
        } catch (e) {}
        try {
            if (window._cineflixIsTV === true) return true;
            if (window.AndroidBridge && typeof window.AndroidBridge.getPlatform === 'function') {
                return window.AndroidBridge.getPlatform() === 'android_tv';
            }
        } catch (e) {}
        const ua = (navigator.userAgent || '').toLowerCase();
        const isPC = (/windows nt|win32|win64|wow64/i.test(ua) ||
                     (/macintosh|mac os x/i.test(ua) && !/iphone|ipad|ipod/i.test(ua)) ||
                     (/linux/i.test(ua) && !/android/i.test(ua)) || /cros/i.test(ua)) &&
                     !/smart.?tv|bravia|tizen|webos|hbbtv|vidaa|viera|nettv|philipstv|googletv|androidtv|box|crkey|firetv|aft[mbtsk]|mibox|shield|roku/i.test(ua);
        if (isPC) return false;
        if (/android.+mobile|iphone|ipad|ipod/i.test(ua) && !/tv|mibox|shield/i.test(ua)) return false;
        return /\btv\b|smart\-?tv|tizen|webos|crkey|firetv|aft[mbtsk]|bravia|viera|roku|mibox|shield|googletv/i.test(ua);
    }
    const isTV = detectTV();
    window.cineIsTV = isTV;
    if (isTV) document.body.classList.add('tv-mode');

    const $ = (id) => document.getElementById(id);
    const canvas = $('cinema-canvas');
    canvas.tabIndex = 0;
    canvas.setAttribute('aria-label', 'Sala de cine: usa las flechas para elegir butaca y OK para sentarte');

    /* ───────────── Teclas ───────────── */
    function keyInfo(e) {
        const k = e.key, c = e.keyCode || e.which;
        const named = k && k !== 'Unidentified';
        return {
            up: k === 'ArrowUp' || c === 38 || (!named && c === 19),
            down: k === 'ArrowDown' || c === 40 || (!named && c === 20),
            left: k === 'ArrowLeft' || c === 37 || (!named && c === 21),
            right: k === 'ArrowRight' || c === 39 || (!named && c === 22),
            enter: k === 'Enter' || c === 13 || c === 23 || c === 66,
            space: k === ' ' || k === 'Spacebar',
            back: k === 'Escape' || c === 27 || c === 4 || k === 'GoBack' || k === 'BrowserBack',
            bs: k === 'Backspace' || c === 8
        };
    }
    const dirOf = (ki) => ki.up ? 'up' : ki.down ? 'down' : ki.left ? 'left' : ki.right ? 'right' : null;

    /* ───────────── Navegación espacial ───────────── */
    const FOCUS_SEL = 'button:not([disabled]), a[href], input:not([disabled]), textarea:not([disabled]), [tabindex="0"]';
    function isVisible(el) {
        if (el.closest('.hidden, [hidden]')) return false;
        const r = el.getBoundingClientRect();
        if (r.width < 2 || r.height < 2) return false;
        const cs = getComputedStyle(el);
        return cs.visibility !== 'hidden' && cs.display !== 'none';
    }
    function focusables(root) { return Array.from(root.querySelectorAll(FOCUS_SEL)).filter(isVisible); }
    function currentRoot() {
        if (vk.open) return vk.el;
        const ov = $('overlay');
        if (ov && !ov.classList.contains('hidden')) return ov;
        const qrModal = $('qr-modal');
        if (qrModal && !qrModal.classList.contains('hidden')) return qrModal;
        if (typeof SHOW !== 'undefined' && SHOW.expanded) return $('screen-overlay');
        return document.body;
    }
    function focusEl(el) {
        if (!el) return;
        try { el.focus({ preventScroll: true }); } catch (e) { el.focus(); }
        try { el.scrollIntoView({ block: 'nearest', inline: 'nearest' }); } catch (e) {}
    }
    function moveFocus(dir, root) {
        root = root || currentRoot();
        const list = focusables(root);
        if (!list.length) return false;
        const cur = document.activeElement;
        if (!cur || !list.includes(cur)) { focusEl(list[0]); return true; }
        const c = cur.getBoundingClientRect();
        const ccx = c.left + c.width / 2, ccy = c.top + c.height / 2;
        let best = null, bestScore = Infinity;
        for (const el of list) {
            if (el === cur) continue;
            const r = el.getBoundingClientRect();
            const cx = r.left + r.width / 2, cy = r.top + r.height / 2;
            let prim, sec, overlap;
            if (dir === 'right' || dir === 'left') {
                if (dir === 'right' ? !(cx > ccx + 2) : !(cx < ccx - 2)) continue;
                prim = dir === 'right' ? Math.max(0, r.left - c.right) : Math.max(0, c.left - r.right);
                sec = Math.abs(cy - ccy);
                overlap = Math.min(r.bottom, c.bottom) - Math.max(r.top, c.top) > 0;
            } else {
                if (dir === 'down' ? !(cy > ccy + 2) : !(cy < ccy - 2)) continue;
                prim = dir === 'down' ? Math.max(0, r.top - c.bottom) : Math.max(0, c.top - r.bottom);
                sec = Math.abs(cx - ccx);
                overlap = Math.min(r.right, c.right) - Math.max(r.left, c.left) > 0;
            }
            const score = prim + sec * (overlap ? 0.3 : 3);
            if (score < bestScore) { bestScore = score; best = el; }
        }
        if (best) { focusEl(best); return true; }
        if (root === document.body && (dir === 'down' || dir === 'up')) window.scrollBy(0, dir === 'down' ? 140 : -140);
        return false;
    }

    /* ───────────── Cursor de butacas en la sala ───────────── */
    function defaultSeat() {
        const me = mySeat();
        if (me >= 0) return me;
        let best = -1, bd = 1e9;
        for (let i = 0; i < SEAT_COUNT; i++) {
            if (net.seats[i]) continue;
            const d = Math.abs(Math.floor(i / COLS) - 1) * 3 + Math.abs((i % COLS) - 3.5);
            if (d < bd) { bd = d; best = i; }
        }
        return best >= 0 ? best : 0;
    }
    function canvasKey(ki, e) {
        if (kbSeat < 0) kbSeat = defaultSeat();
        let r = Math.floor(kbSeat / COLS), c = kbSeat % COLS;
        if (ki.enter || ki.space) {
            const u = net.seats[kbSeat];
            if (u && u.id === net.youId) toggleSit(); else trySit(kbSeat);
            return true;
        }
        if (ki.left) { if (c === 0) return false; c--; }
        else if (ki.right) { if (c === COLS - 1) return false; c++; }
        else if (ki.up) { if (r === 0) return false; r--; }
        else if (ki.down) { if (r === ROWS - 1) return false; r++; }
        else return false;
        kbSeat = r * COLS + c;
        return true;
    }
    canvas.addEventListener('focus', () => { if (kbSeat < 0) kbSeat = defaultSeat(); if (isTV) kbCursorOn = true; });
    canvas.addEventListener('mousedown', () => { kbCursorOn = false; });
    canvas.addEventListener('touchstart', () => { kbCursorOn = false; }, { passive: true });

    /* ───────────── Atrás ───────────── */
    function handleBack() {
        if (vk.open) { closeVK(false); return true; }
        const qrModal = $('qr-modal');
        if (qrModal && !qrModal.classList.contains('hidden')) {
            if (typeof window.closeQrChatModal === 'function') window.closeQrChatModal();
            else qrModal.classList.add('hidden');
            return true;
        }
        if (window.showHandleBack && showHandleBack()) return true;   // vídeo ampliado de la sesión de cine
        const ov = $('overlay');
        if (ov && !ov.classList.contains('hidden')) return false;
        if (view === 'cinema') { leaveToLobby(); return true; }
        if (view === 'creator') { if (net.wantRoom) switchView('cinema'); else goLobby(); return true; }
        return false;   // en la cartelera: que la app vuelva a la pantalla anterior
    }
    window.__cineflixBack = handleBack;

    /* ───────────── Teclado en pantalla ───────────── */
    const vk = { open: false, input: null, orig: '', text: '', shift: false, el: null, numeric: false, max: 60, disp: null };
    const VK_LABELS = {
        'hud-chat-input': ['Mensaje para la sala', 'Enviar'],
        'so-input': ['Comenta la película', 'Enviar'],
        'input-char-name': ['Nombre de tu personaje', 'Aceptar'],
        'input-char-quote': ['Tu frase (opcional)', 'Aceptar'],
        'seat-input': ['Número de butaca (1-32)', 'Ir']
    };
    const ROWS_TXT = [
        '1234567890'.split(''),
        'qwertyuiop'.split(''),
        'asdfghjklñ'.split(''),
        'zxcvbnm,.?'.split(''),
        ['¿', '¡', '!', '-', '_', ':', '\'', '(', ')', '@']
    ];
    const ROWS_NUM = ['123'.split(''), '456'.split(''), '789'.split(''), ['0']];

    function setValue(t) {
        vk.text = t;
        if (vk.input) {
            vk.input.value = t;
            vk.input.dispatchEvent(new Event('input', { bubbles: true }));
        }
        renderDisplay();
    }
    function renderDisplay() {
        const d = vk.disp; d.textContent = '';
        if (!vk.text) {
            const ph = document.createElement('span'); ph.className = 'tvkb-ph';
            ph.textContent = (vk.input && vk.input.placeholder) || ''; d.appendChild(ph);
        } else d.appendChild(document.createTextNode(vk.text));
        const caret = document.createElement('span'); caret.className = 'tvkb-caret'; caret.textContent = '▌';
        d.appendChild(caret);
    }
    function mkKey(label, cls, onPress) {
        const b = document.createElement('button');
        b.type = 'button'; b.className = 'tvkb-key' + (cls ? ' ' + cls : '');
        b.textContent = label; b.addEventListener('click', onPress);
        return b;
    }
    function typeChar(ch) {
        if (vk.text.length >= vk.max) return;
        setValue(vk.text + (vk.shift && !vk.numeric ? ch.toUpperCase() : ch));
        if (vk.shift) { vk.shift = false; renderKeys(); }
    }
    function renderKeys() {
        const box = vk.keysEl; box.textContent = '';
        const rows = vk.numeric ? ROWS_NUM : ROWS_TXT;
        const addRow = () => { const r = document.createElement('div'); r.className = 'tvkb-row'; box.appendChild(r); return r; };
        rows.forEach(chars => {
            const row = addRow();
            chars.forEach(ch => row.appendChild(mkKey(vk.shift ? ch.toUpperCase() : ch, '', () => typeChar(ch))));
        });
        const meta = VK_LABELS[vk.input && vk.input.id] || ['Escribe', 'Aceptar'];
        const last = addRow();
        if (!vk.numeric) last.appendChild(mkKey('⇧ Mayús', 'mid' + (vk.shift ? ' on' : ''), () => { vk.shift = !vk.shift; renderKeys(); focusKeyByAct('shift'); }));
        if (!vk.numeric) last.appendChild(mkKey('Espacio', 'wide', () => typeChar(' ')));
        last.appendChild(mkKey('⌫ Borrar', 'mid', () => setValue(vk.text.slice(0, -1))));
        last.appendChild(mkKey('✔ ' + meta[1], 'ok', () => closeVK(true)));
        last.appendChild(mkKey('✖ Cancelar', 'cancel', () => closeVK(false)));
        Array.from(last.children).forEach((b, i) => { b.dataset.act = ['shift', 'space', 'del', 'ok', 'cancel'][vk.numeric ? i + 2 : i]; });
    }
    function focusKeyByAct(act) {
        const b = vk.keysEl.querySelector('[data-act="' + act + '"]');
        if (b) b.focus({ preventScroll: true });
    }
    function buildVK() {
        const el = document.createElement('div');
        el.id = 'tvkb'; el.className = 'tvkb hidden';
        const box = document.createElement('div'); box.className = 'tvkb-box';
        const title = document.createElement('div'); title.className = 'tvkb-title';
        const disp = document.createElement('div'); disp.className = 'tvkb-display';
        const keys = document.createElement('div');
        box.append(title, disp, keys); el.appendChild(box);
        document.body.appendChild(el);
        vk.el = el; vk.title = title; vk.disp = disp; vk.keysEl = keys;
    }
    function openVK(input) {
        if (vk.open) return;
        if (!vk.el) buildVK();
        vk.input = input; vk.orig = input.value || ''; vk.text = vk.orig; vk.shift = false;
        vk.numeric = input.type === 'number';
        const ml = parseInt(input.getAttribute('maxlength'), 10);
        vk.max = ml > 0 ? ml : (vk.numeric ? 2 : 60);
        const meta = VK_LABELS[input.id] || ['Escribe', 'Aceptar'];
        vk.title.textContent = '⌨ ' + meta[0];
        vk.el.classList.toggle('tvkb-numeric', vk.numeric);
        renderKeys(); renderDisplay();
        vk.el.classList.remove('hidden');
        vk.open = true;
        const first = vk.numeric ? vk.keysEl.querySelector('.tvkb-key') : (vk.keysEl.querySelectorAll('.tvkb-row')[2] || vk.keysEl).querySelector('.tvkb-key');
        if (first) first.focus({ preventScroll: true });
    }
    function closeVK(accept) {
        if (!vk.open) return;
        const inp = vk.input;
        if (!accept) setValue(vk.orig);
        vk.open = false; vk.input = null;
        vk.el.classList.add('hidden');
        if (inp) {
            focusEl(inp);
            if (accept) {
                if (inp.id === 'hud-chat-input') sendChat();
                else if (inp.id === 'so-input') showOverlaySend();
                else if (inp.id === 'seat-input') sitAtNumber();
            }
        }
    }
    function vkKey(e, ki) {
        // Todo lo que llega con el teclado en pantalla abierto se queda aquí
        const dir = dirOf(ki);
        if (ki.back) { e.preventDefault(); e.stopPropagation(); closeVK(false); return; }
        if (dir) { e.preventDefault(); e.stopPropagation(); moveFocus(dir, vk.el); return; }
        if (ki.enter) {
            e.preventDefault(); e.stopPropagation();
            const a = document.activeElement;
            if (a && vk.el.contains(a)) a.click(); else closeVK(true);
            return;
        }
        if (ki.bs) { e.preventDefault(); e.stopPropagation(); setValue(vk.text.slice(0, -1)); return; }
        if (e.key && e.key.length === 1 && !e.ctrlKey && !e.metaKey && !e.altKey) {
            e.preventDefault(); e.stopPropagation();
            if (!vk.numeric || /[0-9]/.test(e.key)) typeChar(e.key);
        }
    }

    // En TV los campos de texto no abren el teclado del sistema: usan el nuestro
    const textInputs = Array.from(document.querySelectorAll('input[type="text"], input[type="number"]'));
    if (isTV) {
        textInputs.forEach(inp => {
            inp.readOnly = true;
            inp.setAttribute('inputmode', 'none');
            inp.addEventListener('click', () => openVK(inp));
        });
    }

    /* ───────────── Manejador global de teclas ───────────── */
    function onKey(e) {
        if (e.isComposing) return;
        const ki = keyInfo(e);
        if (vk.open) { vkKey(e, ki); return; }
        const a = document.activeElement;
        const typing = a && a.matches && a.matches('input:not([readonly]), textarea');
        const dir = dirOf(ki);

        // Cursor de butacas (teclado y mando)
        if (a === canvas && view === 'cinema' && (dir || ki.enter || ki.space)) {
            kbCursorOn = true;
            if (canvasKey(ki, e)) { e.preventDefault(); e.stopPropagation(); return; }
            // borde de la sala: seguir con la navegación espacial (solo TV)
        }
        if (!isTV) return;

        if (ki.back || (ki.bs && !typing)) {
            if (handleBack()) { e.preventDefault(); e.stopPropagation(); }
            return;
        }
        if (typing) return;
        if (dir) { e.preventDefault(); e.stopPropagation(); moveFocus(dir); return; }
        if (ki.enter) {
            if (a && a !== document.body) {
                e.preventDefault(); e.stopPropagation();
                if (a.matches && a.matches('input[type="text"], input[type="number"]')) openVK(a);
                else if (a !== canvas) a.click();
            }
        }
    }
    document.addEventListener('keydown', onKey, true);

    /* ───────────── Foco inicial por vista (TV) ───────────── */
    function focusView(name) {
        if (!isTV || vk.open) return;
        let t = null;
        if (name === 'lobby') t = document.querySelector('#lobby-grid .room-card');
        else if (name === 'creator') t = document.querySelector('#creator-sections .color-circle');
        else if (name === 'cinema') t = canvas;
        focusEl(t);
    }
    const origSwitch = window.switchView;
    window.switchView = function (name) {
        if (vk.open) closeVK(false);
        if (name === 'cinema' && view !== 'cinema') kbSeat = -1;
        const r = origSwitch.apply(this, arguments);
        if (isTV) setTimeout(() => focusView(name), 60);
        return r;
    };
    if (isTV) {
        setTimeout(() => focusView(view), 150);
        // Pantalla "has abierto el cine en otra pestaña": enfocar su botón
        const ov = $('overlay');
        if (ov && window.MutationObserver) {
            new MutationObserver(() => {
                if (!ov.classList.contains('hidden')) focusEl(ov.querySelector('button'));
            }).observe(ov, { attributes: true, attributeFilter: ['class'] });
        }
    }
})();
