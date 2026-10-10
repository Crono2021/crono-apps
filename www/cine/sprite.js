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

const SKIN_PALETTE = ['#fdf2e9', '#ffdfc4', '#ffcc99', '#f5cba7', '#edbb99', '#d7a176', '#b9784a', '#875129', '#5a3320', '#2ecc71', '#5dade2', '#c39bd3'];
const HAIR_PALETTE = ['#17202a', '#3a2518', '#5d3a1a', '#784212', '#a04000', '#d4a017', '#f7dc6f', '#e74c3c', '#ec7fb4', '#9b59b6', '#3498db', '#1abc9c', '#d5dbdb', '#ffffff'];
const TOP_PALETTE  = ['#c0392b', '#e67e22', '#d97706', '#f1c40f', '#059669', '#0d9488', '#2563eb', '#1e3a8a', '#7c3aed', '#db2777', '#334155', '#111827', '#ecf0f1'];
const BOTTOM_PALETTE = ['#1e293b', '#111827', '#334155', '#1e3a8a', '#2563eb', '#475569', '#7f1d1d', '#065f46', '#78350f', '#a16207', '#6d28d9', '#ecf0f1'];
const SHOE_PALETTE = ['#111827', '#f8fafc', '#7f1d1d', '#1d4ed8', '#854d0e', '#065f46', '#c026d3', '#facc15'];
const EYE_PALETTE  = ['#0f172a', '#78350f', '#2563eb', '#059669', '#7c3aed', '#dc2626', '#0891b2'];
const HAT_PALETTE  = ['#c0392b', '#2563eb', '#059669', '#7c3aed', '#d97706', '#334155', '#111827', '#ecf0f1', '#78350f'];

const HAIR_STYLES = [
    { id: 'messy', name: 'Despeinado', icon: '💇‍♂️' },
    { id: 'short', name: 'Clásico', icon: '✂️' },
    { id: 'ponytail', name: 'Coleta', icon: '👱‍♀️' },
    { id: 'afro', name: 'Afro', icon: '🦱' },
    { id: 'wizard', name: 'Mago/Barba', icon: '🧙‍♂️' },
    { id: 'anime', name: 'Anime', icon: '⚡' },
    { id: 'elven', name: 'Élfico', icon: '🧝' },
    { id: 'mohawk', name: 'Cresta', icon: '🦜' },
    { id: 'long', name: 'Melena', icon: '👩' },
    { id: 'curly', name: 'Rizos', icon: '🌀' },
    { id: 'bun', name: 'Moño', icon: '🍙' },
    { id: 'spiky', name: 'Pinchos', icon: '🦔' },
    { id: 'bob', name: 'Media melena', icon: '💁' },
    { id: 'pigtails', name: 'Dos coletas', icon: '🎀' },
    { id: 'bald', name: 'Rapado', icon: '👨‍🦲' }
];

const TOP_STYLES = [
    { id: 'cineflix_tee', name: 'Camiseta Cineflix', icon: '👕' },
    { id: 'hoodie', name: 'Sudadera', icon: '🧥' },
    { id: 'suit', name: 'Traje de Gala', icon: '👔' },
    { id: 'hawaii', name: 'Hawaiana', icon: '🌺' },
    { id: 'robe', name: 'Túnica', icon: '👘' },
    { id: 'jacket', name: 'Chupa Cuero', icon: '🕶️' },
    { id: 'tank', name: 'Tirantes', icon: '🎽' },
    { id: 'striped', name: 'Rayas', icon: '🦓' },
    { id: 'overalls', name: 'Peto vaquero', icon: '👖' },
    { id: 'armor', name: 'Armadura', icon: '🛡️' },
    { id: 'poncho', name: 'Poncho', icon: '🪶' }
];

const BOTTOM_STYLES = [
    { id: 'pants', name: 'Pantalón', icon: '👖' },
    { id: 'shorts', name: 'Pantalón corto', icon: '🩳' },
    { id: 'skirt', name: 'Falda', icon: '👗' }
];

const FACIAL_STYLES = [
    { id: 'none', name: 'Sin vello', icon: '🙂' },
    { id: 'stubble', name: 'Barba de 3 días', icon: '😶' },
    { id: 'mustache', name: 'Bigote', icon: '👨' },
    { id: 'goatee', name: 'Perilla', icon: '🧔‍♂️' },
    { id: 'beard', name: 'Barba', icon: '🧔' }
];

const GLASSES_STYLES = [
    { id: 'none', name: 'Sin gafas', icon: '❌' },
    { id: 'round', name: 'Redondas', icon: '👓' },
    { id: 'square', name: 'Cuadradas', icon: '🤓' },
    { id: 'sunglasses', name: 'De sol', icon: '😎' },
    { id: 'monocle', name: 'Monóculo', icon: '🧐' },
    { id: 'eyepatch', name: 'Parche', icon: '🏴‍☠️' }
];

const HAT_STYLES = [
    { id: 'none', name: 'Sin gorro', icon: '❌' },
    { id: 'cap', name: 'Gorra', icon: '🧢' },
    { id: 'beanie', name: 'Gorro de lana', icon: '🧶' },
    { id: 'fedora', name: 'Fedora', icon: '🕵️' },
    { id: 'cowboy', name: 'Sombrero vaquero', icon: '🤠' },
    { id: 'tophat', name: 'Chistera', icon: '🎩' },
    { id: 'crown', name: 'Corona', icon: '👑' },
    { id: 'party', name: 'Gorro de fiesta', icon: '🥳' }
];

const MOUTH_STYLES = [
    { id: 'neutral', name: 'Serio', icon: '😐' },
    { id: 'smile', name: 'Sonrisa', icon: '🙂' },
    { id: 'grin', name: 'Sonrisón', icon: '😁' },
    { id: 'tongue', name: 'Lengua', icon: '😛' }
];

const ACCESSORIES = [
    { id: 'none', name: 'Ninguno', icon: '❌' },
    { id: '3d_glasses', name: 'Gafas 3D Retro', icon: '🕶️' },
    { id: 'popcorn', name: 'Palomitas', icon: '🍿' },
    { id: 'soda', name: 'Refresco', icon: '🥤' },
    { id: 'ticket', name: 'Entrada', icon: '🎟️' },
    { id: 'clapper', name: 'Claqueta', icon: '🎬' },
    { id: 'bowtie', name: 'Pajarita', icon: '🎀' },
    { id: 'scarf', name: 'Bufanda', icon: '🧣' },
    { id: 'necklace', name: 'Collar', icon: '📿' },
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
    const skinShadow = adjustColor(skin, -28);   // cuello / nariz
    const skinChin = adjustColor(skin, -14);     // sombra muy suave bajo la boca
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
    const bStyle = char.bottomStyle || 'pants';
    const shoe = char.shoeColor || '#111827';
    const shoeLight = adjustColor(shoe, 45);
    if (isSitting) {
        // Sitting folded legs
        if (bStyle === 'shorts') {
            rect(5, 24, 14, 3, bot);
            rect(5, 27, 14, 2, skin);
            rect(5, 28, 14, 1, skinShadow);
        } else if (bStyle === 'skirt') {
            rect(4, 23, 16, 5, bot);
            rect(4, 27, 16, 1, botShadow);
            rect(6, 28, 4, 1, skin);
            rect(14, 28, 4, 1, skin);
        } else {
            rect(5, 24, 14, 5, bot);
            rect(5, 27, 14, 2, botShadow);
        }
        // Shoes
        rect(4, 29, 6, 4, shoe);
        rect(14, 29, 6, 4, shoe);
        rect(5, 29, 4, 1, shoeLight);
        rect(15, 29, 4, 1, shoeLight);
    } else {
        // Standing / Walking
        let leftLegOff = 0;
        let rightLegOff = 0;
        if (animFrame === 1) { leftLegOff = -2; rightLegOff = 2; }
        else if (animFrame === 3) { leftLegOff = 2; rightLegOff = -2; }

        if (bStyle === 'shorts') {
            rect(6, 23 + bodyBob, 5, 4, bot);
            rect(13, 23 + bodyBob, 5, 4, bot);
            rect(6, 27 + bodyBob, 5, 4 + leftLegOff, skin);
            rect(13, 27 + bodyBob, 5, 4 + rightLegOff, skin);
        } else if (bStyle === 'skirt') {
            rect(4, 23 + bodyBob, 16, 5, bot);
            rect(4, 27 + bodyBob, 16, 1, botShadow);
            rect(6, 28 + bodyBob, 5, 3 + leftLegOff, skin);
            rect(13, 28 + bodyBob, 5, 3 + rightLegOff, skin);
        } else {
            rect(6, 23 + bodyBob, 5, 8 + leftLegOff, bot);
            rect(13, 23 + bodyBob, 5, 8 + rightLegOff, bot);
        }
        // Shoes
        rect(5, 31 + bodyBob + leftLegOff, 6, 3, shoe);
        rect(13, 31 + bodyBob + rightLegOff, 6, 3, shoe);
        rect(6, 31 + bodyBob + leftLegOff, 4, 1, shoeLight);
        rect(14, 31 + bodyBob + rightLegOff, 4, 1, shoeLight);
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
    } else if (char.topStyle === 'tank') {
        rect(5, 14 + bodyBob, 3, 2, skin);
        rect(16, 14 + bodyBob, 3, 2, skin);
        rect(8, 14 + bodyBob, 8, 2, skin);
        rect(9, 16 + bodyBob, 6, 1, topShadow);
    } else if (char.topStyle === 'striped') {
        const stripe = adjustColor(top, 80);
        for (let yy = 15; yy < 24; yy += 2) rect(7, yy + bodyBob, 10, 1, stripe);
        rect(10, 14 + bodyBob, 4, 1, '#e2e8f0');
    } else if (char.topStyle === 'overalls') {
        rect(7, 18 + bodyBob, 10, 6, '#2f5fa8');
        rect(8, 14 + bodyBob, 2, 4, '#2f5fa8');
        rect(14, 14 + bodyBob, 2, 4, '#2f5fa8');
        rect(9, 19 + bodyBob, 6, 3, '#274f8c');
        rect(8, 18 + bodyBob, 1, 1, '#facc15');
        rect(15, 18 + bodyBob, 1, 1, '#facc15');
    } else if (char.topStyle === 'armor') {
        rect(5, 14 + bodyBob, 14, 10, '#9aa5b1');
        rect(5, 14 + bodyBob, 14, 2, '#cbd5e1');
        rect(11, 15 + bodyBob, 2, 8, '#64748b');
        rect(7, 17 + bodyBob, 3, 3, '#b6c0cb');
        rect(14, 17 + bodyBob, 3, 3, '#b6c0cb');
        rect(5, 22 + bodyBob, 14, 2, top);
        rect(2, 14 + bodyBob, 4, 3, '#cbd5e1');
        rect(18, 14 + bodyBob, 4, 3, '#cbd5e1');
    } else if (char.topStyle === 'poncho') {
        rect(3, 14 + bodyBob, 18, 8, top);
        rect(3, 17 + bodyBob, 18, 2, topHighlight);
        rect(3, 20 + bodyBob, 18, 1, topShadow);
        for (let xx = 3; xx < 21; xx += 2) rect(xx, 22 + bodyBob, 1, 2, topShadow);
        rect(10, 14 + bodyBob, 4, 2, skin);
    } else if (char.topStyle === 'jacket') {
        rect(10, 14 + bodyBob, 4, 9, '#1e293b');
        rect(11, 15 + bodyBob, 1, 7, '#94a3b8'); // zipper
        rect(7, 14 + bodyBob, 2, 5, '#0f172a'); // lapel
        rect(15, 14 + bodyBob, 2, 5, '#0f172a');
    }

    // 3. ARMS & SLEEVES
    const sleeve = char.topStyle === 'tank' ? skin : (char.topStyle === 'armor' ? '#64748b' : top);
    rect(3, 15 + bodyBob, 2, 7, sleeve);
    rect(19, 15 + bodyBob, 2, 7, sleeve);
    rect(3, 22 + bodyBob, 2, 2, skin);
    rect(19, 22 + bodyBob, 2, 2, skin);

    // 4. NECK & HEAD
    rect(10, 12 + headBob, 4, 3, skinShadow);
    rect(6, 4 + headBob, 12, 9, skin);
    rect(7, 12 + headBob, 10, 1, skinChin);

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
        rect(8, 7 + headBob, 2, 3, char.eyeColor || '#0f172a');
        rect(15, 7 + headBob, 2, 3, char.eyeColor || '#0f172a');
        rect(8, 7 + headBob, 1, 1, '#ffffff');
        rect(15, 7 + headBob, 1, 1, '#ffffff');
    } else {
        rect(7, 8 + headBob, 3, 1, '#334155');
        rect(14, 8 + headBob, 3, 1, '#334155');
    }

    // Nose
    rect(11, 9 + headBob, 2, 1, skinShadow);

    // Facial hair (se dibuja antes de la boca para que la boca siga visible)
    const facial = char.facial || 'none';
    if (facial === 'stubble') {
        // Barba de 3 días: puntitos del color del pelo (no depende del tono de piel)
        for (let yy = 10; yy <= 12; yy++) {
            for (let xx = 6; xx < 18; xx++) {
                if ((xx + yy) % 2 === 0 && !(xx >= 10 && xx <= 13 && yy <= 11)) rect(xx, yy + headBob, 1, 1, hair);
            }
        }
    } else if (facial === 'mustache') {
        rect(9, 10 + headBob, 6, 1, hairShadow);
        rect(8, 11 + headBob, 1, 1, hairShadow);
        rect(15, 11 + headBob, 1, 1, hairShadow);
    } else if (facial === 'goatee') {
        rect(10, 12 + headBob, 4, 1, hair);
        rect(11, 13 + headBob, 2, 1, hair);
        rect(9, 10 + headBob, 6, 1, hairShadow);
    } else if (facial === 'beard') {
        rect(6, 9 + headBob, 3, 4, hair);
        rect(15, 9 + headBob, 3, 4, hair);
        rect(7, 12 + headBob, 10, 2, hair);
        rect(9, 10 + headBob, 6, 1, hairShadow);
        rect(9, 13 + headBob, 6, 1, hairHighlight);
    }

    // Mouth (filas 11-13, nunca tapada por gafas)
    const mouth = char.mouth || 'neutral';
    if (!isChewing) {
        if (mouth === 'smile') {
            // sonrisa en "U": comisuras arriba, curva abajo
            rect(9, 11 + headBob, 1, 1, '#991b1b');
            rect(10, 12 + headBob, 4, 1, '#991b1b');
            rect(14, 11 + headBob, 1, 1, '#991b1b');
        } else if (mouth === 'grin') {
            rect(9, 11 + headBob, 6, 2, '#7f1d1d');
            rect(10, 11 + headBob, 4, 1, '#ffffff');
        } else if (mouth === 'tongue') {
            rect(10, 11 + headBob, 4, 1, '#991b1b');
            rect(11, 12 + headBob, 2, 2, '#f472b6');
            rect(12, 12 + headBob, 1, 1, '#fb9ac8');
        } else {
            rect(10, 11 + headBob, 4, 1, '#991b1b');
        }
    } else {
        rect(10, 11 + headBob, 4, 2, '#7f1d1d');
        rect(11, 11 + headBob, 2, 1, '#ffffff');
        rect(9, 11 + headBob, 1, 1, '#fef08a');
        rect(14, 12 + headBob, 1, 1, '#fef08a');
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
    } else if (char.hairStyle === 'mohawk') {
        rect(6, 3 + headBob, 12, 2, hairShadow);
        rect(10, -3 + headBob, 4, 8, hair);
        rect(11, -4 + headBob, 2, 1, hairHighlight);
        rect(11, -2 + headBob, 1, 5, hairHighlight);
    } else if (char.hairStyle === 'long') {
        rect(5, 2 + headBob, 14, 4, hair);
        rect(7, 2 + headBob, 10, 1, hairHighlight);
        rect(4, 4 + headBob, 3, 16, hair);
        rect(17, 4 + headBob, 3, 16, hair);
        rect(4, 18 + headBob, 3, 2, hairShadow);
        rect(17, 18 + headBob, 3, 2, hairShadow);
        rect(6, 5 + headBob, 12, 1, hair);
    } else if (char.hairStyle === 'curly') {
        rect(4, 0 + headBob, 16, 6, hair);
        rect(3, 2 + headBob, 3, 5, hair);
        rect(18, 2 + headBob, 3, 5, hair);
        rect(5, -1 + headBob, 4, 2, hair);
        rect(10, -2 + headBob, 4, 2, hair);
        rect(15, -1 + headBob, 4, 2, hair);
        rect(7, 1 + headBob, 2, 1, hairHighlight);
        rect(13, 0 + headBob, 2, 1, hairHighlight);
        rect(17, 3 + headBob, 1, 1, hairHighlight);
    } else if (char.hairStyle === 'bun') {
        rect(5, 2 + headBob, 14, 4, hair);
        rect(4, 4 + headBob, 2, 5, hair);
        rect(18, 4 + headBob, 2, 5, hair);
        rect(9, -3 + headBob, 6, 5, hair);
        rect(10, -2 + headBob, 2, 2, hairHighlight);
        rect(9, 1 + headBob, 6, 1, hairShadow);
    } else if (char.hairStyle === 'spiky') {
        rect(5, 2 + headBob, 14, 4, hair);
        rect(5, -1 + headBob, 3, 4, hair);
        rect(9, -3 + headBob, 3, 6, hair);
        rect(13, -2 + headBob, 3, 5, hair);
        rect(17, -1 + headBob, 3, 4, hair);
        rect(10, -2 + headBob, 1, 3, hairHighlight);
        rect(4, 4 + headBob, 2, 4, hair);
        rect(18, 4 + headBob, 2, 4, hair);
    } else if (char.hairStyle === 'bob') {
        rect(5, 2 + headBob, 14, 4, hair);
        rect(7, 2 + headBob, 10, 1, hairHighlight);
        rect(4, 4 + headBob, 3, 9, hair);
        rect(17, 4 + headBob, 3, 9, hair);
        rect(4, 12 + headBob, 3, 1, hairShadow);
        rect(17, 12 + headBob, 3, 1, hairShadow);
        rect(6, 5 + headBob, 12, 1, hair);
    } else if (char.hairStyle === 'pigtails') {
        rect(5, 2 + headBob, 14, 4, hair);
        rect(5, 4 + headBob, 2, 5, hair);
        rect(17, 4 + headBob, 2, 5, hair);
        rect(1, 7 + headBob, 3, 10, hair);
        rect(20, 7 + headBob, 3, 10, hair);
        rect(1, 6 + headBob, 3, 1, '#e11d48');
        rect(20, 6 + headBob, 3, 1, '#e11d48');
        rect(2, 16 + headBob, 2, 2, hairShadow);
        rect(21, 16 + headBob, 2, 2, hairShadow);
    } else if (char.hairStyle === 'bald') {
        rect(6, 3 + headBob, 12, 2, hairShadow);
        rect(5, 4 + headBob, 2, 3, hairShadow);
        rect(17, 4 + headBob, 2, 3, hairShadow);
    }

    // 7b. GAFAS (encima del pelo; solo filas 6-9 para no tapar la boca)
    if (char.accessory === '3d_glasses') {
        // Gafas 3D retro: montura de cartón blanca y cristales rojo / cian
        const F = '#f8fafc';
        rect(5, 6 + headBob, 14, 1, F);                       // barra superior
        rect(5, 7 + headBob, 1, 2, F); rect(18, 7 + headBob, 1, 2, F);   // patillas
        rect(11, 7 + headBob, 2, 1, F);                       // puente
        for (const gx of [6, 13]) {
            rect(gx, 7 + headBob, 1, 3, F); rect(gx + 4, 7 + headBob, 1, 3, F);
            rect(gx + 1, 9 + headBob, 3, 1, F);
        }
        rect(7, 7 + headBob, 3, 2, 'rgba(239,68,68,0.55)');
        rect(14, 7 + headBob, 3, 2, 'rgba(6,182,212,0.55)');
        rect(7, 7 + headBob, 1, 1, 'rgba(255,255,255,0.6)'); rect(14, 7 + headBob, 1, 1, 'rgba(255,255,255,0.6)');
    }
    const gl = char.glasses || 'none';
    if (gl === 'round') {
        for (const gx of [6, 13]) {
            rect(gx, 6 + headBob, 5, 1, '#111827'); rect(gx, 9 + headBob, 5, 1, '#111827');
            rect(gx, 6 + headBob, 1, 4, '#111827'); rect(gx + 4, 6 + headBob, 1, 4, '#111827');
        }
        rect(11, 7 + headBob, 2, 1, '#111827');
    } else if (gl === 'square') {
        for (const gx of [6, 13]) {
            rect(gx, 6 + headBob, 5, 4, 'rgba(147,197,253,0.35)');
            rect(gx, 6 + headBob, 5, 1, '#7c2d12'); rect(gx, 9 + headBob, 5, 1, '#7c2d12');
            rect(gx, 6 + headBob, 1, 4, '#7c2d12'); rect(gx + 4, 6 + headBob, 1, 4, '#7c2d12');
        }
        rect(11, 7 + headBob, 2, 1, '#7c2d12');
    } else if (gl === 'sunglasses') {
        rect(6, 6 + headBob, 5, 3, '#0b0b12'); rect(13, 6 + headBob, 5, 3, '#0b0b12');
        rect(11, 6 + headBob, 2, 1, '#0b0b12'); rect(5, 6 + headBob, 1, 1, '#0b0b12'); rect(18, 6 + headBob, 1, 1, '#0b0b12');
        rect(7, 6 + headBob, 1, 1, '#6b7280'); rect(14, 6 + headBob, 1, 1, '#6b7280');
    } else if (gl === 'monocle') {
        rect(13, 6 + headBob, 5, 1, '#facc15'); rect(13, 9 + headBob, 5, 1, '#facc15');
        rect(13, 6 + headBob, 1, 4, '#facc15'); rect(17, 6 + headBob, 1, 4, '#facc15');
        rect(17, 10 + headBob, 1, 6, '#facc15');
    } else if (gl === 'eyepatch') {
        rect(6, 6 + headBob, 5, 4, '#111827');
        rect(5, 5 + headBob, 14, 1, '#111827');
        rect(7, 7 + headBob, 1, 1, '#374151');
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

    // 9. HATS (encima del pelo)
    const hat = char.hat || 'none';
    const hc = char.hatColor || '#c0392b';
    const hcD = adjustColor(hc, -45);
    const hcL = adjustColor(hc, 40);
    if (hat === 'cap') {
        rect(5, 0 + headBob, 14, 5, hc);
        rect(7, -1 + headBob, 10, 1, hc);
        rect(5, 4 + headBob, 14, 1, hcD);
        rect(13, 4 + headBob, 10, 2, hcD);
        rect(11, 1 + headBob, 2, 1, hcL);
    } else if (hat === 'beanie') {
        rect(5, 0 + headBob, 14, 5, hc);
        rect(5, 4 + headBob, 14, 2, hcD);
        rect(6, 1 + headBob, 12, 1, hcL);
        rect(10, -2 + headBob, 4, 3, '#f8fafc');
        rect(7, 4 + headBob, 1, 2, hc); rect(10, 4 + headBob, 1, 2, hc); rect(13, 4 + headBob, 1, 2, hc); rect(16, 4 + headBob, 1, 2, hc);
    } else if (hat === 'fedora') {
        rect(2, 3 + headBob, 20, 2, hcD);
        rect(6, -2 + headBob, 12, 5, hc);
        rect(6, 2 + headBob, 12, 1, '#111827');
        rect(8, -2 + headBob, 8, 1, hcL);
        rect(11, -3 + headBob, 2, 1, hc);
    } else if (hat === 'cowboy') {
        rect(1, 3 + headBob, 22, 2, hcD);
        rect(0, 2 + headBob, 3, 2, hcD);
        rect(21, 2 + headBob, 3, 2, hcD);
        rect(7, -1 + headBob, 10, 4, hc);
        rect(11, -2 + headBob, 2, 1, hc);
        rect(7, 2 + headBob, 10, 1, hcL);
        rect(11, 2 + headBob, 2, 1, '#facc15');
    } else if (hat === 'tophat') {
        rect(3, 3 + headBob, 18, 2, '#111827');
        rect(6, -6 + headBob, 12, 9, '#1f2937');
        rect(6, 0 + headBob, 12, 2, hc);
        rect(7, -5 + headBob, 2, 5, '#374151');
    } else if (hat === 'crown') {
        rect(6, 0 + headBob, 12, 3, '#facc15');
        rect(6, -2 + headBob, 2, 2, '#facc15');
        rect(11, -3 + headBob, 2, 3, '#facc15');
        rect(16, -2 + headBob, 2, 2, '#facc15');
        rect(6, 2 + headBob, 12, 1, '#b45309');
        rect(11, 1 + headBob, 2, 1, '#ef4444');
        rect(8, 1 + headBob, 1, 1, '#38bdf8'); rect(15, 1 + headBob, 1, 1, '#38bdf8');
    } else if (hat === 'party') {
        rect(8, 1 + headBob, 8, 2, hc);
        rect(9, -1 + headBob, 6, 2, hcL);
        rect(10, -3 + headBob, 4, 2, hc);
        rect(11, -5 + headBob, 2, 2, hcL);
        rect(11, -7 + headBob, 2, 2, '#fde047');
        rect(8, 2 + headBob, 8, 1, '#fde047');
    }

    // 10. EXTRA ACCESSORIES
    if (char.accessory === 'bowtie') {
        rect(8, 14 + bodyBob, 3, 3, '#dc2626');
        rect(13, 14 + bodyBob, 3, 3, '#dc2626');
        rect(11, 15 + bodyBob, 2, 2, '#7f1d1d');
    } else if (char.accessory === 'scarf') {
        rect(7, 13 + bodyBob, 10, 3, '#e74c3c');
        rect(7, 14 + bodyBob, 10, 1, '#f8fafc');
        rect(14, 16 + bodyBob, 3, 6, '#e74c3c');
        rect(14, 18 + bodyBob, 3, 1, '#f8fafc');
        rect(14, 21 + bodyBob, 3, 1, '#b91c1c');
    } else if (char.accessory === 'necklace') {
        rect(8, 14 + bodyBob, 8, 1, '#facc15');
        rect(9, 15 + bodyBob, 1, 1, '#facc15'); rect(14, 15 + bodyBob, 1, 1, '#facc15');
        rect(11, 15 + bodyBob, 2, 2, '#38bdf8');
    } else if (char.accessory === 'ticket') {
        rect(19, 19 + bodyBob, 5, 4, '#fde68a');
        rect(19, 20 + bodyBob, 5, 1, '#b45309');
        rect(21, 19 + bodyBob, 1, 4, '#d97706');
    } else if (char.accessory === 'clapper') {
        rect(18, 19 + bodyBob, 6, 5, '#1f2937');
        rect(18, 17 + bodyBob, 6, 2, '#f8fafc');
        rect(19, 17 + bodyBob, 1, 2, '#111827'); rect(21, 17 + bodyBob, 1, 2, '#111827'); rect(23, 17 + bodyBob, 1, 2, '#111827');
        rect(19, 21 + bodyBob, 4, 1, '#94a3b8');
    }

    ctx.restore();
}
