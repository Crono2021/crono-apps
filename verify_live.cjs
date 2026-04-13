const https = require('https');

https.get('https://crono2021.github.io/crono-apps/assets/index-DQ3U6qED.js', (res) => {
    let data = '';
    res.on('data', chunk => data += chunk);
    res.on('end', () => {
        const patterns = [
            'isNativePlatform',
            'Native Player',
            'ExoPlayer',
            'initStream',
            'pushChunk',
        ];
        for (const p of patterns) {
            const idx = data.indexOf(p);
            if (idx >= 0) {
                const start = Math.max(0, idx - 50);
                const end = Math.min(data.length, idx + p.length + 80);
                console.log(`✅ "${p}" → ...${data.slice(start, end)}...`);
            } else {
                console.log(`❌ "${p}" NOT found`);
            }
        }
    });
}).on('error', console.error);
