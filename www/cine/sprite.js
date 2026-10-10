/* Sprite 16-bit procedural (24x34) + paletas — extraído del creador de personajes */
// Color helper to shade pixels
function adjustColor(hex, amt) {
    let usePound = false;
    if (hex[0] === '#') { hex = hex.slice(1); usePound = true; }
    let num = parseInt(hex, 16);
    let r = (num >> 16) + amt;
    let b = ((num >> 8) & 0x00FF) + amt;
    let g = (num & 0x0000FF) + amt;
    r = Math.max(Math.min(255, r), 0);
    b = Math.max(Math.min(255, b), 0);
    g = Math.max(Math.min(255, g), 0);
    return (usePound ? '#' : '') + (g | (b << 8) | (r << 16)).toString(16).padStart(6, '0');
}

/* =========================================================================
   PALETTES & OPTIONS
   ========================================================================= */

const SKIN_PALETTE = ['#fdf2e9', '#ffcc99', '#f5cba7', '#edbb99', '#d7a176', '#875129', '#2ecc71', '#5dade2'];
const HAIR_PALETTE = ['#17202a', '#3a2518', '#784212', '#a04000', '#f7dc6f', '#e74c3c', '#9b59b6', '#d5dbdb'];
const TOP_PALETTE  = ['#c0392b', '#2563eb', '#059669', '#7c3aed', '#d97706', '#334155', '#ecf0f1', '#0d9488'];

const HAIR_STYLES = [
    { id: 'messy', name: 'Despeinado', icon: '💇‍♂️' },
    { id: 'short', name: 'Clásico', icon: '✂️' },
    { id: 'ponytail', name: 'Coleta', icon: '👱‍♀️' },
    { id: 'afro', name: 'Afro', icon: '🦱' },
    { id: 'wizard', name: 'Mago/Barba', icon: '🧙‍♂️' },
    { id: 'anime', name: 'Anime', icon: '⚡' },
    { id: 'elven', name: 'Élfico', icon: '🧝' },
    { id: 'bald', name: 'Rapado', icon: '👨‍🦲' }
];

const TOP_STYLES = [
    { id: 'cineflix_tee', name: 'Camiseta Cineflix', icon: '👕' },
    { id: 'hoodie', name: 'Sudadera', icon: '🧥' },
    { id: 'suit', name: 'Traje de Gala', icon: '👔' },
    { id: 'hawaii', name: 'Hawaiana', icon: '🌺' },
    { id: 'robe', name: 'Túnica', icon: '👘' },
    { id: 'jacket', name: 'Chupa Cuero', icon: '🕶️' }
];

const ACCESSORIES = [
    { id: 'none', name: 'Ninguno', icon: '❌' },
    { id: '3d_glasses', name: 'Gafas 3D Retro', icon: '🕶️' },
    { id: 'popcorn', name: 'Palomitas', icon: '🍿' },
    { id: 'soda', name: 'Refresco', icon: '🥤' },
    { id: 'wizard_hat', name: 'Gorro Mago', icon: '🧙' },
    { id: 'headphones', name: 'Auriculares', icon: '🎧' },
    { id: 'elf_ears', name: 'Orejas Elfo', icon: '🧝' }
];

/* =========================================================================
   HIGH FIDELITY 16-BIT PROCEDURAL SPRITE RENDERER
   Sprite Grid: 24 wide x 34 tall
   ========================================================================= */

function draw16BitCharacterCrisp(ctx, char, originX, originY, scale = 2, options = {}) {
    const isSitting = options.isSitting !== undefined ? options.isSitting : true;
    const animFrame = options.animFrame || 0; // 0, 1, 2, 3
    const isChewing = options.isChewing || false;
    const blink = options.blink || false;
    const s = scale;

    ctx.save();
    ctx.imageSmoothingEnabled = false;
    ctx.translate(Math.round(originX), Math.round(originY));

    function rect(x, y, w, h, color) {
        ctx.fillStyle = color;
        ctx.fillRect(x * s, y * s, w * s, h * s);
    }

    const skin = char.skin || '#f5cba7';
    const skinShadow = adjustColor(skin, -45);
    const hair = char.hairColor || '#3a2518';
    const hairHighlight = adjustColor(hair, 35);
    const hairShadow = adjustColor(hair, -35);
    const top = char.topColor || '#c0392b';
    const topShadow = adjustColor(top, -40);
    const topHighlight = adjustColor(top, 30);
    const bot = char.bottomColor || '#1e293b';
    const botShadow = adjustColor(bot, -30);

    // Ground/Seat Shadow
    ctx.fillStyle = 'rgba(0, 0, 0, 0.4)';
    ctx.fillRect(3 * s, 31 * s, 18 * s, 4 * s);

    const headBob = (!isSitting && (animFrame === 1 || animFrame === 3)) ? -1 : 0;
    const bodyBob = (!isSitting && (animFrame === 1 || animFrame === 3)) ? -1 : 0;

    // 1. LEGS & SHOES
    if (isSitting) {
        // Sitting folded legs
        rect(5, 24, 14, 5, bot);
        rect(5, 27, 14, 2, botShadow);
        // Shoes
        rect(4, 29, 6, 4, '#111827');
        rect(14, 29, 6, 4, '#111827');
        rect(5, 29, 4, 1, '#475569');
        rect(15, 29, 4, 1, '#475569');
    } else {
        // Standing / Walking
        let leftLegOff = 0;
        let rightLegOff = 0;
        if (animFrame === 1) { leftLegOff = -2; rightLegOff = 2; }
        else if (animFrame === 3) { leftLegOff = 2; rightLegOff = -2; }

        rect(6, 23 + bodyBob, 5, 8 + leftLegOff, bot);
        rect(13, 23 + bodyBob, 5, 8 + rightLegOff, bot);
        // Shoes
        rect(5, 31 + bodyBob + leftLegOff, 6, 3, '#111827');
        rect(13, 31 + bodyBob + rightLegOff, 6, 3, '#111827');
        rect(6, 31 + bodyBob + leftLegOff, 4, 1, '#475569');
        rect(14, 31 + bodyBob + rightLegOff, 4, 1, '#475569');
    }

    // 2. TORSO & CLOTHING
    rect(5, 14 + bodyBob, 14, 10, top);
    rect(5, 14 + bodyBob, 2, 10, topShadow);
    rect(17, 14 + bodyBob, 2, 10, topShadow);
    rect(5, 23 + bodyBob, 14, 1, topShadow);

    if (char.topStyle === 'cineflix_tee') {
        // Golden Cineflix 'C' Logo
        rect(10, 16 + bodyBob, 4, 1, '#f1c40f');
        rect(9, 17 + bodyBob, 2, 4, '#f1c40f');
        rect(10, 20 + bodyBob, 4, 1, '#f1c40f');
        rect(11, 16 + bodyBob, 2, 1, '#fef08a');
        rect(10, 14 + bodyBob, 4, 1, '#e2e8f0'); // collar
    } else if (char.topStyle === 'suit') {
        rect(10, 14 + bodyBob, 4, 9, '#ffffff');
        rect(11, 16 + bodyBob, 2, 6, '#0f172a');
        rect(11, 15 + bodyBob, 2, 1, '#c0392b');
        rect(8, 14 + bodyBob, 2, 8, topShadow);
        rect(14, 14 + bodyBob, 2, 8, topShadow);
    } else if (char.topStyle === 'hoodie') {
        rect(9, 15 + bodyBob, 1, 4, '#ffffff');
        rect(14, 15 + bodyBob, 1, 4, '#ffffff');
        rect(7, 19 + bodyBob, 10, 4, topShadow);
        rect(8, 20 + bodyBob, 8, 2, top);
    } else if (char.topStyle === 'hawaii') {
        rect(7, 16 + bodyBob, 2, 2, '#fef08a');
        rect(15, 18 + bodyBob, 2, 2, '#fef08a');
        rect(9, 21 + bodyBob, 2, 2, '#67e8f9');
        rect(13, 15 + bodyBob, 2, 2, '#67e8f9');
        rect(11, 14 + bodyBob, 2, 3, skin);
    } else if (char.topStyle === 'robe') {
        rect(11, 14 + bodyBob, 2, 10, '#f1c40f');
        rect(10, 17 + bodyBob, 4, 2, '#38bdf8');
    } else if (char.topStyle === 'jacket') {
        rect(10, 14 + bodyBob, 4, 9, '#1e293b');
        rect(11, 15 + bodyBob, 1, 7, '#94a3b8'); // zipper
        rect(7, 14 + bodyBob, 2, 5, '#0f172a'); // lapel
        rect(15, 14 + bodyBob, 2, 5, '#0f172a');
    }

    // 3. ARMS & SLEEVES
    rect(3, 15 + bodyBob, 2, 7, top);
    rect(19, 15 + bodyBob, 2, 7, top);
    rect(3, 22 + bodyBob, 2, 2, skin);
    rect(19, 22 + bodyBob, 2, 2, skin);

    // 4. NECK & HEAD
    rect(10, 12 + headBob, 4, 3, skinShadow);
    rect(6, 4 + headBob, 12, 9, skin);
    rect(6, 12 + headBob, 12, 1, skinShadow);
    rect(6, 11 + headBob, 2, 1, skinShadow);
    rect(16, 11 + headBob, 2, 1, skinShadow);

    // Elf Ears
    if (char.accessory === 'elf_ears') {
        rect(4, 7 + headBob, 2, 3, skin);
        rect(2, 6 + headBob, 2, 2, skin);
        rect(1, 5 + headBob, 1, 2, skin);
        rect(18, 7 + headBob, 2, 3, skin);
        rect(20, 6 + headBob, 2, 2, skin);
        rect(22, 5 + headBob, 1, 2, skin);
    }

    // Cheeks blush
    rect(6, 9 + headBob, 2, 1, '#fca5a5');
    rect(16, 9 + headBob, 2, 1, '#fca5a5');

    // 5. EYES & BROWS
    rect(7, 6 + headBob, 3, 1, hairShadow);
    rect(14, 6 + headBob, 3, 1, hairShadow);

    if (!blink) {
        rect(7, 7 + headBob, 3, 3, '#ffffff');
        rect(14, 7 + headBob, 3, 3, '#ffffff');
        rect(8, 7 + headBob, 2, 3, '#0f172a');
        rect(15, 7 + headBob, 2, 3, '#0f172a');
        rect(8, 7 + headBob, 1, 1, '#ffffff');
        rect(15, 7 + headBob, 1, 1, '#ffffff');
    } else {
        rect(7, 8 + headBob, 3, 1, '#334155');
        rect(14, 8 + headBob, 3, 1, '#334155');
    }

    // Nose
    rect(11, 9 + headBob, 2, 1, skinShadow);

    // Mouth
    if (!isChewing) {
        rect(11, 11 + headBob, 2, 1, '#991b1b');
    } else {
        rect(10, 10 + headBob, 4, 3, '#7f1d1d');
        rect(11, 11 + headBob, 2, 1, '#ffffff');
        rect(9, 10 + headBob, 1, 1, '#fef08a');
        rect(14, 12 + headBob, 1, 1, '#fef08a');
    }

    // 6. 3D GLASSES
    if (char.accessory === '3d_glasses') {
        rect(5, 6 + headBob, 14, 4, '#f8fafc');
        rect(7, 7 + headBob, 3, 2, '#ef4444');
        rect(14, 7 + headBob, 3, 2, '#06b6d4');
        rect(7, 7 + headBob, 1, 1, '#ffffff');
        rect(14, 7 + headBob, 1, 1, '#ffffff');
        rect(10, 7 + headBob, 4, 1, '#e2e8f0');
    }

    // 7. HAIR STYLES
    if (char.hairStyle === 'messy') {
        rect(5, 2 + headBob, 14, 4, hair);
        rect(6, 1 + headBob, 11, 2, hair);
        rect(7, 0 + headBob, 6, 2, hairHighlight);
        rect(14, 1 + headBob, 4, 2, hair);
        rect(4, 4 + headBob, 2, 5, hair);
        rect(18, 4 + headBob, 2, 5, hair);
        rect(7, 3 + headBob, 7, 2, hairHighlight);
        rect(6, 5 + headBob, 3, 1, hair);
    } else if (char.hairStyle === 'short') {
        rect(5, 2 + headBob, 14, 4, hair);
        rect(7, 1 + headBob, 10, 2, hair);
        rect(8, 2 + headBob, 8, 1, hairHighlight);
        rect(5, 4 + headBob, 2, 5, hair);
        rect(17, 4 + headBob, 2, 5, hair);
    } else if (char.hairStyle === 'ponytail') {
        rect(5, 2 + headBob, 14, 4, hair);
        rect(5, 4 + headBob, 2, 5, hair);
        rect(17, 4 + headBob, 2, 5, hair);
        rect(2, 4 + headBob, 3, 10, hair);
        rect(2, 14 + headBob, 2, 5, hairShadow);
        rect(3, 4 + headBob, 2, 1, '#e11d48');
    } else if (char.hairStyle === 'afro') {
        rect(3, 0 + headBob, 18, 8, hair);
        rect(2, 2 + headBob, 20, 6, hair);
        rect(4, 1 + headBob, 16, 2, hairHighlight);
        rect(2, 7 + headBob, 4, 4, hairShadow);
        rect(18, 7 + headBob, 4, 4, hairShadow);
    } else if (char.hairStyle === 'wizard') {
        rect(5, 2 + headBob, 14, 4, hair);
        rect(4, 4 + headBob, 3, 13, hair);
        rect(17, 4 + headBob, 3, 13, hair);
        rect(7, 11 + headBob, 10, 10, hair);
        rect(8, 21 + headBob, 8, 4, hair);
        rect(9, 25 + headBob, 6, 3, hair);
        rect(9, 12 + headBob, 6, 2, hairHighlight);
    } else if (char.hairStyle === 'anime') {
        rect(5, 1 + headBob, 14, 4, hair);
        rect(4, -3 + headBob, 4, 5, hair);
        rect(5, -2 + headBob, 2, 3, hairHighlight);
        rect(10, -4 + headBob, 4, 6, hair);
        rect(11, -3 + headBob, 2, 4, hairHighlight);
        rect(16, -2 + headBob, 4, 5, hair);
        rect(4, 4 + headBob, 2, 5, hair);
        rect(18, 4 + headBob, 2, 5, hair);
    } else if (char.hairStyle === 'elven') {
        rect(5, 2 + headBob, 14, 4, hair);
        rect(7, 2 + headBob, 10, 2, hairHighlight);
        rect(4, 4 + headBob, 3, 17, hair);
        rect(17, 4 + headBob, 3, 17, hair);
        rect(5, 19 + headBob, 2, 4, hairShadow);
        rect(17, 19 + headBob, 2, 4, hairShadow);
    } else if (char.hairStyle === 'bald') {
        rect(6, 3 + headBob, 12, 2, hairShadow);
        rect(5, 4 + headBob, 2, 3, hairShadow);
        rect(17, 4 + headBob, 2, 3, hairShadow);
    }

    // 8. ACCESSORIES
    if (char.accessory === 'wizard_hat') {
        rect(2, 2 + headBob, 20, 2, '#312e81');
        rect(5, -1 + headBob, 14, 3, '#3730a3');
        rect(7, -4 + headBob, 10, 3, '#4338ca');
        rect(9, -7 + headBob, 6, 3, '#4f46e5');
        rect(11, -10 + headBob, 3, 3, '#6366f1');
        rect(10, 0 + headBob, 4, 2, '#facc15');
        rect(11, -3 + headBob, 2, 2, '#fef08a');
    } else if (char.accessory === 'headphones') {
        rect(6, 1 + headBob, 12, 2, '#334155');
        rect(3, 5 + headBob, 3, 7, '#10b981');
        rect(18, 5 + headBob, 3, 7, '#10b981');
        rect(4, 6 + headBob, 1, 5, '#a7f3d0');
        rect(19, 6 + headBob, 1, 5, '#a7f3d0');
    } else if (char.accessory === 'popcorn') {
        const px = 14;
        const py = 18 + bodyBob;
        rect(px, py + 2, 8, 8, '#ef4444');
        rect(px + 2, py + 3, 2, 7, '#ffffff');
        rect(px + 5, py + 3, 1, 7, '#ffffff');
        rect(px - 1, py, 10, 3, '#facc15');
        rect(px, py - 1, 3, 2, '#ffffff');
        rect(px + 4, py - 1, 3, 2, '#ffffff');
        rect(px + 2, py - 2, 3, 2, '#fef08a');
    } else if (char.accessory === 'soda') {
        const sx = 15;
        const sy = 19 + bodyBob;
        rect(sx, sy + 2, 6, 8, '#0284c7');
        rect(sx - 1, sy + 1, 8, 2, '#ffffff');
        rect(sx + 3, sy - 3, 2, 4, '#ef4444');
        rect(sx + 3, sy - 2, 2, 1, '#ffffff');
        rect(sx + 4, sy - 5, 3, 2, '#ef4444');
    }

    ctx.restore();
}
