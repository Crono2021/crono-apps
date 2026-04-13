const fs = require('fs');
let c = fs.readFileSync('src/telegram.js', 'utf8');
// Remove the duplicate closing brace after the function
c = c.replace(/(\n}\n)\n}\n\n$/, '$1\n');
fs.writeFileSync('src/telegram.js', c);
console.log('Done. Total lines:', c.split('\n').length);
console.log('Last 5 lines:', c.split('\n').slice(-5).join('\n'));
