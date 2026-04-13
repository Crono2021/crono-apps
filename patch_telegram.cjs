const fs = require('fs');
let b = fs.readFileSync('src/telegram.js', 'utf8');

// 1. Remove NodeJS import
b = b.replace(/import \{ NodeJS \} from '@choreruiz\/capacitor-node-js';\n/, '');

// 2. Replace the entire streamVideoNative function
const oldFnStart = '// ===== NATIVE ANDROID STREAMING (Capacitor + ExoPlayer) =====';
const oldFnEnd = b.length; // everything after this marker to end of file

const startIdx = b.indexOf(oldFnStart);
if (startIdx === -1) {
    console.error('Could not find NATIVE ANDROID STREAMING marker');
    process.exit(1);
}

const newCode = `// ===== NATIVE ANDROID STREAMING (Capacitor + ExoPlayer) =====
// Arquitectura Tevegram: ServerSocket local en Kotlin sirve HTTP Range
// mientras GramJS descarga chunks progresivamente desde Telegram.

/**
 * Check if the app is running inside Capacitor (Android/iOS).
 */
export function isNativeApp() {
    return !!(window.Capacitor && window.Capacitor.isNativePlatform);
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
 * Stream a video natively via ExoPlayer (Android only).
 * Réplica de la arquitectura Tevegram (LocalStreamProxy):
 *   1. JS descarga chunks con GramJS
 *   2. Los envía como Base64 al plugin Capacitor
 *   3. Kotlin los escribe en un archivo temporal en disco
 *   4. StreamProxy (ServerSocket) sirve el archivo vía HTTP Range
 *   5. ExoPlayer reproduce desde http://127.0.0.1:<port>/stream
 */
export async function streamVideoNative(media) {
    const { ExoPlayer } = window.Capacitor.Plugins;
    const c = await getClient();
    const doc = media.document;

    // Safe fileSize coercion
    let fileSize;
    try {
        fileSize = typeof doc.size === 'bigint'
            ? Number(doc.size)
            : Number(String(doc.size));
    } catch { fileSize = 0; }
    fileSize = Math.floor(fileSize);

    if (!fileSize || fileSize <= 0 || isNaN(fileSize)) {
        console.warn('[Native] No fileSize, cannot stream:', doc);
        throw new Error('No se pudo obtener el tamaño del archivo');
    }

    const mimeType = doc.mimeType || 'video/mp4';
    const CHUNK_SIZE = 512 * 1024; // 512KB per chunk (safe for Binder IPC)
    const BUFFER_BEFORE_PLAY = 2 * 1024 * 1024; // 2MB antes de lanzar player

    console.log('[Native] Iniciando stream:', fileSize, 'bytes,', mimeType);

    // 1. Inicializar el proxy local (crea archivo temporal en disco)
    await ExoPlayer.initStream({ fileSize, mimeType });

    // 2. Descargar y empujar chunks progresivamente
    let offset = 0;
    let playerLaunched = false;

    while (offset < fileSize) {
        const size = Math.min(CHUNK_SIZE, fileSize - offset);

        let chunk;
        try {
            chunk = await fetchTelegramRange(c, doc, offset, size);
        } catch (err) {
            // Reintentar una vez tras reconectar
            if (err.message && err.message.toLowerCase().includes('disconnect')) {
                console.warn('[Native] Reconectando...');
                await c.connect();
            }
            // Segundo intento
            try {
                chunk = await fetchTelegramRange(c, doc, offset, size);
            } catch (e2) {
                console.error('[Native] Error descarga fatal en offset', offset, e2);
                break;
            }
        }

        // Enviar chunk como Base64 al plugin nativo → disco
        const base64 = uint8ToBase64(chunk);
        await ExoPlayer.pushChunk({ data: base64 });

        offset += chunk.length;

        // 3. Lanzar ExoPlayer después del buffer inicial
        if (!playerLaunched && offset >= BUFFER_BEFORE_PLAY) {
            playerLaunched = true;
            console.log('[Native] ▶️ Buffer alcanzado, lanzando ExoPlayer...');
            ExoPlayer.play({}); // fire-and-forget (no await)
        }
    }

    // 4. Marcar descarga completa
    await ExoPlayer.downloadComplete({});

    // Si el archivo era muy pequeño y nunca lanzamos el player
    if (!playerLaunched) {
        console.log('[Native] ▶️ Archivo pequeño, lanzando ExoPlayer...');
        await ExoPlayer.play({});
    }

    console.log('[Native] ✅ Descarga completa:', offset, 'bytes');
}
`;

b = b.substring(0, startIdx) + newCode;

fs.writeFileSync('src/telegram.js', b);
console.log('✅ telegram.js patched successfully');
