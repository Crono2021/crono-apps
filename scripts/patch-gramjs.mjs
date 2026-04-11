// scripts/patch-gramjs.mjs
// Patches GramJS serializeBytes to handle Uint8Array from Web Crypto API.
// In production Vite builds, Web Crypto returns Uint8Array, not Buffer —
// this causes "Bytes or str expected, not e" (minified class name).
import { readFileSync, writeFileSync } from 'fs';
import { resolve, dirname } from 'path';
import { fileURLToPath } from 'url';

const __dirname = dirname(fileURLToPath(import.meta.url));
const target = resolve(__dirname, '../node_modules/telegram/tl/generationHelpers.js');

let src;
try {
    src = readFileSync(target, 'utf-8');
} catch {
    console.warn('patch-gramjs: file not found, skipping');
    process.exit(0);
}

if (src.includes('gramjs-uint8array-patch')) {
    console.log('patch-gramjs: already applied, skipping');
    process.exit(0);
}

const FIND = 'throw Error(`Bytes or str expected, not ${data.constructor.name}`);';
const REPLACE = `/* gramjs-uint8array-patch */ if (ArrayBuffer.isView(data)) { data = Buffer.from(data.buffer, data.byteOffset, data.byteLength); } else { throw Error('Bytes or str expected, not ' + typeof data); }`;

if (!src.includes(FIND)) {
    console.warn('patch-gramjs: target string not found in generationHelpers.js');
    process.exit(0);
}

src = src.replace(FIND, REPLACE);
writeFileSync(target, src, 'utf-8');
console.log('patch-gramjs: ✅ serializeBytes patched for Uint8Array support');
