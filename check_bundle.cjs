const fs = require('fs');
const content = fs.readFileSync('dist/assets/index-BOWsrcj9.js', 'utf8');

const checks = [
    ['registerPlugin', false, 'NO debe estar (ya no usamos @capacitor/core)'],
    ['@capacitor/core', false, 'NO debe estar'],
    ['window.Capacitor', true, 'Debe acceder al bridge nativo directo'],
    ['ExoPlayer plugin no disponible', true, 'Error message de getExoPlayer()'],
    ['Native Player', true, 'Alert de error en playVideo catch'],
    ['initStream', true, 'Llamada al plugin nativo'],
    ['pushChunk', true, 'Envío de chunks al nativo'],
];

console.log('=== Verificación del bundle compilado ===\n');
let allOk = true;
for (const [pattern, shouldExist, desc] of checks) {
    const found = content.includes(pattern);
    const ok = found === shouldExist;
    console.log(`${ok ? '✅' : '❌'} "${pattern}" → ${found ? 'ENCONTRADO' : 'NO encontrado'} (${desc})`);
    if (!ok) allOk = false;
}
console.log(`\n${allOk ? '🎉 Bundle CORRECTO' : '⚠️ HAY PROBLEMAS'}`);
