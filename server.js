const express = require('express');
const path = require('path');
const cors = require('cors');
const config = require('./config');
const tgClient = require('./telegram-client');

const authRoutes = require('./routes/auth');
const chatRoutes = require('./routes/chats');
const mediaRoutes = require('./routes/media');
const streamRoutes = require('./routes/stream');

const app = express();
app.use(cors());
app.use(express.json());
app.use(express.static(path.join(__dirname, 'public')));

app.use('/auth', authRoutes);
app.use('/api/chats', mediaRoutes);
app.use('/api/chats', chatRoutes);
app.use('/api/stream', streamRoutes);

app.get('*', (req, res) => {
    res.sendFile(path.join(__dirname, 'public', 'index.html'));
});

async function start() {
    if (!config.API_ID || !config.API_HASH) {
        console.error('\n  ERROR: Configura API_ID y API_HASH en config.js\n  Obtenlos en https://my.telegram.org\n');
        process.exit(1);
    }

    try {
        await tgClient.init();
        await tgClient.connect();
        console.log('[Server] Telegram client connected');
    } catch (err) {
        console.log('[Server] Will connect on first login');
    }

    app.listen(config.PORT, () => {
        console.log(`\n  TelegramFlix → http://${config.HOST}:${config.PORT}\n`);
    });
}

start();
