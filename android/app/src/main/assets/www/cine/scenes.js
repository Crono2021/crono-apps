/* =========================================================================
   CINEFLIX 16-BIT — Proyecciones de la pantalla (pixel-art procedural)
   Cada escena se dibuja en un lienzo pequeño de 207x70 px que luego se amplía x3
   sin suavizado, así queda un píxel gordo y nítido de verdad.
   Son homenajes de dibujo original: sin imágenes, logos ni música de las películas.
   ========================================================================= */

const SCENE_W = 207;
const SCENE_H = 70;

function sR(c, col, x, y, w, h) {
    c.fillStyle = col;
    c.fillRect(Math.round(x), Math.round(y), Math.max(1, Math.round(w)), Math.max(1, Math.round(h)));
}
function sRnd(n) { const s = Math.sin(n * 12.9898 + 4.1414) * 43758.5453; return s - Math.floor(s); }
function sClamp(v, a, b) { return Math.max(a, Math.min(b, v)); }
function sEase(p) { p = sClamp(p, 0, 1); return p * p * (3 - 2 * p); }

// Mini fuente 3x5 para contadores
const SGLYPH = {
    '0': '111101101101111', '1': '010110010010111', '2': '111001111100111', '3': '111001111001111',
    '4': '101101111001001', '5': '111100111001111', '6': '111100111101111', '7': '111001001010010',
    '8': '111101111101111', '9': '111101111001111',
    'A': '010101111101101', 'D': '110101101101110', 'E': '111100110100111', 'H': '101101111101101',
    'I': '111010010010111', 'L': '100100100100111', 'M': '101111111101101', 'N': '110101101101101',
    'O': '111101101101111', 'P': '111101111100100', 'R': '110101110101101', 'S': '111100111001111',
    'T': '111010010010010', 'U': '101101101101111', 'Y': '101101010010010', ' ': '000000000000000'
};
function sText(c, str, x, y, col) {
    let cx = Math.round(x);
    c.fillStyle = col;
    for (const ch of String(str)) {
        const g = SGLYPH[ch] || SGLYPH[' '];
        for (let i = 0; i < 15; i++) {
            if (g[i] === '1') c.fillRect(cx + (i % 3), Math.round(y) + Math.floor(i / 3), 1, 1);
        }
        cx += 4;
    }
}

function sBolt(c, x0, y0, x1, y1, seed, col) {
    let x = x0, y = y0;
    const steps = 9;
    for (let i = 1; i <= steps; i++) {
        const nx = x0 + (x1 - x0) * i / steps + (i < steps ? (sRnd(seed + i) - 0.5) * 12 : 0);
        const ny = y0 + (y1 - y0) * i / steps;
        const dx = Math.sign(nx - x) || 1;
        for (let xx = Math.round(Math.min(x, nx)); xx <= Math.round(Math.max(x, nx)); xx++) sR(c, col, xx, y, 1, 1);
        sR(c, col, nx, y, 1, Math.max(1, ny - y));
        x = nx; y = ny;
    }
}

// ───────────────────────────── 1. REGRESO AL FUTURO ─────────────────────────────
function sceneBTTF(c, t) {
    const P = 20000, T = t % P, W = SCENE_W;
    const road = 53;

    // Cielo nocturno
    const sky = ['#05071a', '#080c26', '#0c1236', '#101848', '#16215a', '#1d2a6a'];
    sky.forEach((col, i) => sR(c, col, 0, i * 8, W, 8));
    for (let i = 0; i < 30; i++) {
        if (((T / 260) + i) % 7 < 6) sR(c, '#cfd8ff', sRnd(i) * W, sRnd(i + 40) * 34, 1, 1);
    }
    // Luna
    sR(c, '#e9e4c4', 20, 6, 8, 8); sR(c, '#d2cba2', 22, 8, 2, 2); sR(c, '#05071a', 25, 5, 5, 3);
    // Nubes
    const cl = (T / 400) % (W + 60);
    sR(c, '#101a44', W - cl, 14, 28, 3); sR(c, '#101a44', W - cl + 6, 11, 16, 3);

    // Silueta de edificios
    const bld = [[0, 36, 18], [18, 30, 14], [32, 38, 20], [52, 33, 16], [68, 40, 22], [92, 31, 14], [106, 37, 18], [124, 34, 14]];
    bld.forEach(([x, y, w], i) => {
        sR(c, '#0b0e24', x, y, w, road - y);
        for (let wy = y + 3; wy < road - 4; wy += 5) for (let wx = x + 2; wx < x + w - 2; wx += 4) {
            if (sRnd(i * 31 + wx * 7 + wy) > 0.55) sR(c, '#f2c94c', wx, wy, 2, 2);
        }
    });

    // Torre del reloj
    const tx = 152, tTop = 6;
    sR(c, '#2b3050', tx, tTop + 12, 20, road - tTop - 12);
    sR(c, '#3a4068', tx + 14, tTop + 12, 6, road - tTop - 12);
    sR(c, '#2b3050', tx + 2, tTop + 4, 16, 9);
    sR(c, '#1c2038', tx + 6, tTop - 2, 8, 7);       // chapitel
    sR(c, '#1c2038', tx + 8, tTop - 6, 4, 5);
    sR(c, '#1c2038', tx + 9, tTop - 9, 2, 4);
    // Esfera del reloj
    sR(c, '#e8dfae', tx + 6, tTop + 6, 8, 8); sR(c, '#bdb485', tx + 6, tTop + 13, 8, 1);
    sR(c, '#1a1a1a', tx + 10, tTop + 7, 1, 4); sR(c, '#1a1a1a', tx + 10, tTop + 10, 3, 1);
    for (let wy = tTop + 18; wy < road - 6; wy += 7) { sR(c, '#12162a', tx + 4, wy, 4, 4); sR(c, '#12162a', tx + 12, wy, 4, 4); }

    // Relámpago sobre la torre
    const lightning = (T > 14800 && T < 14950) || (T > 15150 && T < 15300) || (T > 15500 && T < 15620);
    if (lightning) {
        sR(c, 'rgba(180,200,255,0.25)', 0, 0, W, road);
        sBolt(c, 126 + (T > 15100 ? 10 : 0), 0, tx + 10, tTop - 8, Math.floor(T / 90), '#ffffff');
        sR(c, '#ffffff', tx + 6, tTop + 6, 8, 8);
    }

    // Calle y acera
    sR(c, '#3a3f58', 0, road - 3, W, 3);
    sR(c, '#1a1c27', 0, road, W, 17);
    sR(c, '#12141c', 0, road + 14, W, 3);

    // Velocidad del coche
    let carX = -50, mph = 0, carOn = true;
    if (T < 1000) { carX = -40 + 56 * sEase(T / 1000); }
    else if (T < 9000) {
        const p = (T - 1000) / 8000;
        carX = 16 + 100 * (p * p);
        mph = Math.min(88, Math.floor(88 * p));
    } else if (T < 9300) { carX = 116; mph = 88; }
    else carOn = false;

    // Líneas de la carretera
    const rs = mph > 0 ? (30 + mph * 3.2) : 8;
    const roadOff = (T / 1000 * rs) % 36;
    for (let x = -36; x < W + 36; x += 36) sR(c, '#e0b83a', x - roadOff, road + 8, 18, 1);

    // Líneas de velocidad
    if (carOn && mph > 35) {
        for (let i = 0; i < 6; i++) {
            const ly = road - 12 + sRnd(i + Math.floor(T / 70)) * 24;
            const ll = 14 + sRnd(i * 3 + Math.floor(T / 90)) * 30 * (mph / 88);
            sR(c, 'rgba(210,225,255,0.45)', carX - ll - 6, ly, ll, 1);
        }
    }

    // Estela de fuego (dos líneas) tras el salto temporal
    if (T >= 9300 && T < 14400) {
        const since = T - 9300;
        const vanishX = 130;
        const startX = since > 3200 ? sClamp((since - 3200) / 1700, 0, 1) * (vanishX + 6) : 0;
        for (let x = Math.round(startX); x <= vanishX + 4; x++) {
            for (let lane = 0; lane < 2; lane++) {
                const y = road + 3 + lane * 6;
                const r = sRnd(x * 1.7 + lane * 9 + Math.floor(T / 55));
                const col = r > 0.66 ? '#ffd23a' : (r > 0.33 ? '#ff7a1a' : '#38bdf8');
                sR(c, col, x, y, 1, 2);
                if (r > 0.5) sR(c, col, x, y - 1 - Math.floor(r * 3), 1, 1);
            }
        }
        // Chispas de fuego
        for (let i = 0; i < 10; i++) {
            const px = sRnd(i + Math.floor(T / 130)) * vanishX;
            sR(c, '#ffd23a', px, road - 2 - sRnd(i * 9 + Math.floor(T / 100)) * 7, 1, 1);
        }
    }

    // DeLorean
    if (carOn) {
        const x = Math.round(carX), y = road + 8;
        // sombra y brillo inferior
        sR(c, '#0a0b12', x + 2, y - 1, 32, 2);
        if (mph > 55) sR(c, '#38bdf8', x + 6, y, 24, 1);
        // carrocería plateada
        sR(c, '#8d97a6', x, y - 8, 36, 5);
        sR(c, '#c9d2de', x + 1, y - 9, 30, 1);
        sR(c, '#6c7686', x, y - 4, 36, 2);
        sR(c, '#aeb8c6', x + 28, y - 8, 8, 4);        // capó
        sR(c, '#c9d2de', x + 30, y - 9, 6, 1);
        // cabina
        sR(c, '#aeb8c6', x + 9, y - 13, 14, 5);
        sR(c, '#43607e', x + 12, y - 12, 7, 4);
        sR(c, '#6c93b8', x + 19, y - 12, 4, 4);
        sR(c, '#c9d2de', x + 9, y - 14, 10, 1);
        // luces
        sR(c, '#e02f2f', x, y - 8, 2, 3);
        sR(c, '#fff3b0', x + 35, y - 7, 2, 2);
        // ruedas
        for (const wx of [x + 5, x + 26]) {
            sR(c, '#0a0a0a', wx, y - 4, 7, 7);
            sR(c, '#7b8494', wx + 2, y - 2, 3, 3);
        }
        // condensador de fluzo
        if (mph > 20) sR(c, ((T / 90) | 0) % 2 ? '#7dd3fc' : '#fef08a', x + 3, y - 10, 3, 2);
    }

    // Contador de MPH
    if (T > 1000 && T < 9800) {
        sR(c, '#000000', 168, 3, 36, 14);
        const s = String(T >= 9300 ? 88 : mph).padStart(2, '0');
        sText(c, s, 171, 5, mph >= 85 ? '#ff3b30' : '#ff8a3a');
        sText(c, 'MPH', 184, 5, '#c0c0c0');
        sR(c, '#33373f', 170, 12, 32, 1);
    }

    // Destello al llegar a 88
    if (T >= 8900 && T < 9500) {
        const a = T < 9300 ? sClamp((T - 8900) / 400, 0, 1) : 1 - sClamp((T - 9300) / 200, 0, 1);
        sR(c, `rgba(255,255,255,${a.toFixed(2)})`, 0, 0, W, SCENE_H);
    }
    // Fundido de entrada / salida
    if (T < 500) sR(c, `rgba(0,0,0,${(1 - T / 500).toFixed(2)})`, 0, 0, W, SCENE_H);
    if (T > 19300) sR(c, `rgba(0,0,0,${((T - 19300) / 700).toFixed(2)})`, 0, 0, W, SCENE_H);
}

// ─────────────────────────────── 2. INDIANA JONES ───────────────────────────────
function sceneIndy(c, t) {
    const T = t % 24000, W = SCENE_W;
    const ground = 52;
    const sx = T * 0.05;               // desplazamiento del mundo (px de escena)
    const wallSx = sx * 0.5;

    // Pared de ladrillos
    sR(c, '#2b2018', 0, 0, W, ground);
    for (let row = 0; row < 7; row++) {
        const off = (row % 2) * 9;
        for (let x = -18; x < W + 18; x += 18) {
            const bx = x + off - (wallSx % 18);
            const shade = sRnd(row * 13 + Math.floor((x + wallSx) / 18) + 1);
            sR(c, shade > 0.5 ? '#4a3825' : '#55402a', bx + 1, row * 7 + 1, 16, 5);
            sR(c, '#6a5136', bx + 1, row * 7 + 1, 16, 1);
        }
    }
    // Columnas / arco de fondo
    for (let k = -1; k < 4; k++) {
        const px = Math.round(k * 80 + 30 - (wallSx * 1.1 % 80));
        sR(c, '#201710', px, 0, 10, ground);
        sR(c, '#33261a', px + 2, 0, 3, ground);
        sR(c, '#3a2b1d', px - 2, 0, 14, 3);
    }
    // Antorchas
    for (let k = -1; k < 5; k++) {
        const tx = Math.round(k * 60 + 22 - (sx * 0.8 % 60));
        sR(c, '#5a4630', tx, 22, 2, 8);
        const f = Math.floor(T / 90 + k) % 3;
        sR(c, '#d94a12', tx - 1, 17 - f, 4, 5);
        sR(c, '#ffb020', tx, 16 - f, 2, 4);
        sR(c, '#fff3a0', tx, 17 - f, 1, 2);
        sR(c, 'rgba(255,170,60,0.10)', tx - 14, 8, 30, 28);
    }

    // Suelo con fosos
    sR(c, '#6e5434', 0, ground, W, SCENE_H - ground);
    sR(c, '#8a6a42', 0, ground, W, 1);
    for (let row = 0; row < 3; row++) {
        for (let x = -24; x < W + 24; x += 24) {
            const bx = x + (row % 2) * 12 - (sx % 24);
            sR(c, '#4f3a22', bx, ground + 3 + row * 6, 24, 1);
            sR(c, '#4f3a22', bx, ground + 3 + row * 6, 1, 6);
        }
    }
    const PIT = 150;
    const pitsOnScreen = [];
    for (let k = Math.floor(sx / PIT) - 1; k < Math.floor((sx + W) / PIT) + 2; k++) {
        const wx = k * PIT + 110;
        const px = Math.round(wx - sx);
        pitsOnScreen.push(wx);
        sR(c, '#050403', px, ground, 26, SCENE_H - ground);
        sR(c, '#17110b', px - 1, ground, 1, 6);
        sR(c, '#17110b', px + 26, ground, 1, 6);
        // pinchos
        for (let s = 0; s < 6; s++) sR(c, '#a9a9a9', px + 2 + s * 4, ground + 12, 1, 3);
    }

    // Jugador
    const playerX = 112;
    const worldPX = sx + playerX;
    let lift = 0;
    for (const wx of pitsOnScreen) {
        const d = wx - worldPX;                // distancia hasta el foso
        if (d < 34 && d > -42) {
            const p = (34 - d) / 76;
            lift = Math.max(lift, Math.sin(p * Math.PI) * 18);
        }
    }
    const feet = ground - lift;
    const step = Math.floor(T / 110) % 2;

    // Boulder (detrás)
    const bR = 20;
    const bx = 18 + Math.sin(T / 1100) * 5;
    const by = ground - bR;
    const rot = T / 260;
    for (let dy = -bR; dy <= bR; dy++) {
        const half = Math.floor(Math.sqrt(bR * bR - dy * dy));
        sR(c, dy < -bR * 0.4 ? '#9b8a70' : (dy > bR * 0.5 ? '#4e4434' : '#7d6e57'), bx - half, by + dy, half * 2, 1);
    }
    for (let i = 0; i < 9; i++) {
        const a = rot + i * 0.7, rr = 4 + (i * 5) % (bR - 5);
        const cx = bx + Math.cos(a) * rr, cy = by + Math.sin(a) * rr;
        sR(c, '#3d3427', cx, cy, 2 + (i % 2), 2);
    }
    // Polvo
    for (let i = 0; i < 8; i++) {
        const age = ((T / 40) + i * 7) % 28;
        sR(c, `rgba(190,165,120,${(0.5 - age / 56).toFixed(2)})`, bx + bR + age * 1.4, ground - 2 - sRnd(i) * 8 - age * 0.15, 2 + i % 2, 2);
    }

    // Aventurero (sombrero fedora, chaqueta, látigo)
    const px = playerX, py = Math.round(feet);
    sR(c, '#3b2a14', px - 1, py - 21, 10, 2);        // ala
    sR(c, '#5a3d1c', px + 1, py - 25, 6, 4);        // copa
    sR(c, '#2b1d0d', px + 1, py - 22, 6, 1);        // cinta
    sR(c, '#e0b080', px + 2, py - 19, 5, 4);        // cara
    sR(c, '#5b3a1a', px + 2, py - 17, 3, 1);
    sR(c, '#8a5a2a', px, py - 15, 8, 7);            // chaqueta
    sR(c, '#c8a46a', px + 3, py - 15, 2, 6);        // camisa
    sR(c, '#6a431f', px - 2, py - 14, 3, 2);        // brazo atrás
    sR(c, '#6a431f', px + 8, py - 14, 3, 2);        // brazo delante
    sR(c, '#7a6a48', px + 1, py - 8, 6, 4);         // pantalón
    if (lift > 1) {
        sR(c, '#7a6a48', px - 1, py - 5, 4, 2); sR(c, '#7a6a48', px + 5, py - 5, 4, 2);
        sR(c, '#2a1a0a', px - 2, py - 4, 3, 2); sR(c, '#2a1a0a', px + 8, py - 4, 3, 2);
    } else if (step === 0) {
        sR(c, '#7a6a48', px, py - 4, 3, 4); sR(c, '#7a6a48', px + 5, py - 4, 3, 4);
        sR(c, '#2a1a0a', px - 1, py - 1, 4, 1); sR(c, '#2a1a0a', px + 5, py - 1, 4, 1);
    } else {
        sR(c, '#7a6a48', px + 2, py - 4, 4, 4);
        sR(c, '#2a1a0a', px + 2, py - 1, 5, 1);
    }
    // Látigo
    const crack = Math.floor(T / 3000) % 2 === 0 && (T % 3000) < 450;
    sR(c, '#4a2f12', px + 11, py - 14, 8, 1);
    if (crack) { sR(c, '#4a2f12', px + 19, py - 17, 8, 1); sR(c, '#ffffff', px + 27, py - 18, 2, 2); }

    // Resplandor y niebla de polvo
    for (let i = 0; i < 12; i++) {
        const mx = (sRnd(i) * W + T * 0.01 * (1 + i % 3)) % W;
        sR(c, 'rgba(255,220,150,0.35)', mx, 6 + sRnd(i + 20) * 40, 1, 1);
    }
    if (T < 500) sR(c, `rgba(0,0,0,${(1 - T / 500).toFixed(2)})`, 0, 0, W, SCENE_H);
    if (T > 23300) sR(c, `rgba(0,0,0,${((T - 23300) / 700).toFixed(2)})`, 0, 0, W, SCENE_H);
}

// ───────────────────────────── 3. EL SEÑOR DE LOS ANILLOS ─────────────────────────────
function sceneLOTR(c, t) {
    const T = t % 28000, W = SCENE_W;
    // Cielo rojizo
    const sky = ['#120303', '#1d0504', '#2b0905', '#401006', '#5c1a08', '#7d2a0a', '#a03e0e'];
    sky.forEach((col, i) => sR(c, col, 0, i * 7, W, 7));
    sR(c, '#b8480f', 0, 49, W, SCENE_H - 49);
    // Nubes de ceniza
    for (let i = 0; i < 7; i++) {
        const cx = ((i * 53 + T * 0.012 * (1 + i % 3)) % (W + 80)) - 40;
        const cy = 6 + (i * 11) % 30;
        sR(c, '#190807', cx, cy, 44, 6); sR(c, '#241008', cx + 8, cy - 3, 28, 4); sR(c, '#190807', cx + 14, cy + 5, 22, 3);
    }
    // Chispas de ceniza
    for (let i = 0; i < 16; i++) {
        const ax = (sRnd(i) * W + T * 0.02) % W, ay = (sRnd(i + 9) * 60 + T * 0.01 * (1 + i % 2)) % 56;
        sR(c, i % 3 ? '#ff7a2a' : '#ffc060', ax, ay, 1, 1);
    }

    // Montaña del Destino (derecha)
    const mx = 152, base = 56, peak = 18;
    for (let y = peak; y < base; y++) {
        const w = 3 + (y - peak) * 1.55;
        sR(c, y < peak + 8 ? '#2b1612' : '#1d0e0b', mx - w, y, w * 2, 1);
        sR(c, '#3a1d16', mx - w, y, 2, 1);
    }
    // cráter y lava
    sR(c, '#ff5a14', mx - 6, peak - 1, 12, 3);
    sR(c, ((T / 120) | 0) % 2 ? '#ffd23a' : '#ff9a2a', mx - 4, peak - 2, 8, 2);
    for (let i = 0; i < 3; i++) {
        const lx = mx - 4 + i * 4, len = 22 + i * 7;
        for (let y = 0; y < len; y++) {
            const wob = Math.round(Math.sin(y * 0.35 + T / 400 + i) * 2);
            const col = sRnd(y * 3 + i + Math.floor(T / 150)) > 0.5 ? '#ff6a1a' : '#e03c0a';
            sR(c, col, lx + wob + (i - 1) * y * 0.35, peak + 2 + y, 2, 1);
        }
    }
    // Erupción
    for (let i = 0; i < 9; i++) {
        const age = ((T / 55) + i * 9) % 40;
        const vx = mx + (sRnd(i * 5) - 0.5) * 24 * (age / 40 + 0.3);
        const vy = peak - age * 0.9 + age * age * 0.012;
        sR(c, age < 25 ? '#ffb020' : '#ff5a14', vx, vy, 2, 2);
    }
    sR(c, 'rgba(255,90,20,0.10)', mx - 40, peak - 14, 80, 30);

    // Barad-dûr (izquierda) con el Ojo
    const tx = 40;
    for (let y = 14; y < 58; y++) {
        const w = 5 + Math.max(0, (y - 14)) * 0.16;
        sR(c, '#0c0507', tx - w, y, w * 2, 1);
    }
    sR(c, '#16090c', tx - 12, 36, 24, 22);
    sR(c, '#0c0507', tx - 15, 46, 30, 12);
    // espinas
    for (const d of [-8, -4, 4, 8]) { sR(c, '#0c0507', tx + d, 8, 2, 8); sR(c, '#0c0507', tx + d, 5, 1, 4); }
    sR(c, '#0c0507', tx - 10, 12, 20, 4);
    for (let wy = 24; wy < 56; wy += 6) { sR(c, ((T / 300 + wy) | 0) % 3 ? '#ff6a1a' : '#802008', tx - 1, wy, 2, 3); }
    // El Ojo
    const eyeY = 6, flick = ((T / 110) | 0) % 3;
    sR(c, 'rgba(255,90,20,0.20)', tx - 22, eyeY - 12, 44, 26);
    sR(c, '#ff3a0a', tx - 8, eyeY - 1, 16, 4);
    sR(c, '#ff7a1a', tx - 6, eyeY - 2, 12, 6);
    sR(c, flick === 0 ? '#ffd23a' : '#ffb020', tx - 4, eyeY - 1, 8, 4);
    sR(c, '#160000', tx - 1, eyeY - 2, 2, 6);               // pupila vertical
    // Haz de luz del Ojo (parpadea)
    if (((T / 1400) | 0) % 3 === 1) sR(c, 'rgba(255,140,50,0.12)', tx + 8, eyeY, 60, 5);

    // Anillo único que gira en el centro
    const rcx = 100, rcy = 22, phi = T / 500;
    const rxe = Math.abs(Math.cos(phi)) * 9 + 1.5;
    const glow = 0.18 + 0.12 * Math.sin(T / 300);
    sR(c, `rgba(255,210,60,${glow.toFixed(2)})`, rcx - 14, rcy - 11, 28, 22);
    for (let a = 0; a < Math.PI * 2; a += 0.12) {
        const rx = Math.round(rcx + Math.cos(a) * rxe), ry = Math.round(rcy + Math.sin(a) * 9);
        const light = Math.sin(a + phi) > 0.2;
        sR(c, light ? '#fff0a0' : '#d49a10', rx, ry, 2, 2);
    }
    // inscripción
    if (Math.abs(Math.cos(phi)) > 0.5) sR(c, '#ff5a14', rcx - 1, rcy - 9, 2, 1);

    // Cresta en primer plano
    const ridge = [];
    for (let x = 0; x < W; x++) ridge[x] = 57 + Math.round(Math.sin(x * 0.07) * 2 + Math.sin(x * 0.19) * 1.5);
    for (let x = 0; x < W; x++) sR(c, '#07030a', x, ridge[x], 1, SCENE_H - ridge[x]);
    // La Compañía: 9 siluetas
    for (let i = 0; i < 9; i++) {
        const fx = Math.round(((T / 170 + i * 8) % (W + 24)) - 12);
        if (fx < 0 || fx >= W) continue;
        const h = i === 0 ? 11 : (i >= 7 ? 5 : 8);
        const fy = ridge[fx] - h + 1 + (((T / 200 + i) | 0) % 2);
        sR(c, '#07030a', fx, fy, 3, h);
        sR(c, '#07030a', fx, fy - 2, 3, 2);
        if (i === 0) { sR(c, '#07030a', fx + 3, fy - 9, 1, 20 > 0 ? 12 : 0); sR(c, '#f5f0e0', fx + 3, fy - 10, 1, 2); } // báculo mago
        if (i === 1) sR(c, '#c8c8d0', fx + 3, fy + 2, 1, 5);                                                    // espada
        if (i >= 7) sR(c, '#4a2a18', fx, fy - 1, 3, 1);
    }
    if (T < 500) sR(c, `rgba(0,0,0,${(1 - T / 500).toFixed(2)})`, 0, 0, W, SCENE_H);
    if (T > 27300) sR(c, `rgba(0,0,0,${((T - 27300) / 700).toFixed(2)})`, 0, 0, W, SCENE_H);
}

// ─────────────────────────────────── 4. INTERSTELLAR ───────────────────────────────────
function sceneInter(c, t) {
    const P = 30000, T = t % P, W = SCENE_W;
    sR(c, '#010208', 0, 0, W, SCENE_H);
    // Estrellas con ligera deriva
    for (let i = 0; i < 70; i++) {
        const x = ((sRnd(i) * W) - T * 0.004 * (1 + i % 3) + W * 10) % W;
        const y = sRnd(i + 77) * SCENE_H;
        const b = i % 5 === 0 ? '#ffffff' : (i % 3 === 0 ? '#9fb2ff' : '#5a6490');
        sR(c, b, x, y, 1, 1);
    }

    // Agujero negro "Gargantúa"
    const cx = 138, cy = 34, R = 9;
    // halo de lente gravitacional
    for (let a = 0; a < Math.PI * 2; a += 0.05) {
        const rr = R + 2 + Math.sin(a * 2 + T / 900) * 0.4;
        const hx = cx + Math.cos(a) * rr, hy = cy + Math.sin(a) * rr;
        const topBottom = Math.abs(Math.sin(a));
        sR(c, topBottom > 0.6 ? '#ffd9a0' : '#c8672b', hx, hy, 1, 1);
    }
    // disco de acreción trasero (arco superior)
    for (let dx = -44; dx <= 44; dx++) {
        const f = 1 - Math.abs(dx) / 44;
        const sh = 0.6 + 0.4 * Math.sin(T / 220 + dx * 0.4);
        const col = f > 0.75 ? '#fff3cf' : (f > 0.45 ? '#ffb85a' : (f > 0.2 ? '#d9692a' : '#7a2a14'));
        const th = Math.max(1, Math.round(f * 3 * sh + 1));
        if (Math.abs(dx) < R + 3) {
            // por detrás del agujero: curvatura sobre el hueco (lensing)
            const lift = Math.round(Math.sqrt(Math.max(0, (R + 4) * (R + 4) - dx * dx)));
            sR(c, col, cx + dx, cy - lift, 1, th);
            sR(c, col, cx + dx, cy + lift - th + 1, 1, th);
        }
    }
    // horizonte de sucesos
    for (let dy = -R; dy <= R; dy++) {
        const half = Math.round(Math.sqrt(R * R - dy * dy));
        sR(c, '#000000', cx - half, cy + dy, half * 2 + 1, 1);
    }
    // disco delantero (banda horizontal brillante)
    for (let dx = -46; dx <= 46; dx++) {
        const f = 1 - Math.abs(dx) / 46;
        const sh = 0.55 + 0.45 * Math.sin(T / 190 - dx * 0.35);
        const dopp = dx < 0 ? 1 : 0.75;                      // lado que se acerca más brillante
        const v = f * dopp;
        const col = v > 0.7 ? '#fff6dc' : (v > 0.45 ? '#ffc472' : (v > 0.22 ? '#e0762f' : '#8a3216'));
        sR(c, col, cx + dx, cy + 1 - (f > 0.6 ? 1 : 0), 1, Math.max(1, Math.round(1 + f * 2 * sh)));
    }

    // Estación Endurance (anillo de módulos)
    const sx = 42, sy = 24, rot = T / 2200;
    sR(c, '#2a2f3d', sx - 1, sy - 1, 3, 3);
    for (let i = 0; i < 12; i++) {
        const a = rot + i * Math.PI / 6;
        const mx = sx + Math.cos(a) * 11, my = sy + Math.sin(a) * 11;
        sR(c, i % 2 ? '#dfe5ef' : '#8c95a6', mx - 1, my - 1, 3, 3);
        sR(c, '#4a5266', mx, my, 1, 1);
    }
    sR(c, '#4a5266', sx - 11, sy, 22, 1);
    sR(c, '#4a5266', sx, sy - 11, 1, 22);
    // luz parpadeante de la estación
    if (((T / 500) | 0) % 2) sR(c, '#ff4a4a', sx, sy - 12, 1, 1);

    // Nave Ranger entre la estación y el agujero negro
    const cyc = T % 24000;
    const p = sClamp((cyc - 1500) / 20000, 0, 1);
    const shipX = 56 + p * 66, shipY = 28 + p * 4 + Math.sin(T / 700) * 1.5;
    if (cyc > 1500 && p < 1) {
        const s = 1 - p * 0.55;
        const w = Math.max(2, Math.round(7 * s)), h = Math.max(1, Math.round(3 * s));
        sR(c, '#e6ebf3', shipX, shipY, w, h);
        sR(c, '#9fb2d0', shipX + 1, shipY + h - 1, Math.max(1, w - 2), 1);
        sR(c, '#4fc3f7', shipX - 2, shipY + (h > 1 ? 1 : 0), 2, 1);
    }

    // Contador de años (la dilatación temporal)
    const years = Math.floor(sEase(p) * 91 + (cyc < 1500 ? 0 : 0));
    sR(c, '#000000', 4, 60, 40, 8);
    sText(c, 'ANOS', 6, 62, '#8fb4ff');
    sText(c, String(years).padStart(2, '0'), 24, 62, '#ffd9a0');

    if (T < 500) sR(c, `rgba(0,0,0,${(1 - T / 500).toFixed(2)})`, 0, 0, W, SCENE_H);
    if (T > 29300) sR(c, `rgba(0,0,0,${((T - 29300) / 700).toFixed(2)})`, 0, 0, W, SCENE_H);
}

const CINE_SCENES = { bttf: sceneBTTF, indy: sceneIndy, lotr: sceneLOTR, inter: sceneInter };

// Pequeño gestor de lienzos de escena (uno por sala) reutilizado por la sala y la cartelera
const _sceneCanvases = {};
function getSceneCanvas(id) {
    if (!_sceneCanvases[id]) {
        const cv = document.createElement('canvas');
        cv.width = SCENE_W; cv.height = SCENE_H;
        const ctx = cv.getContext('2d');
        ctx.imageSmoothingEnabled = false;
        _sceneCanvases[id] = { cv, ctx };
    }
    return _sceneCanvases[id];
}
function renderScene(id, t) {
    const o = getSceneCanvas(id);
    const fn = CINE_SCENES[id] || sceneBTTF;
    o.ctx.clearRect(0, 0, SCENE_W, SCENE_H);
    fn(o.ctx, t);
    return o.cv;
}
