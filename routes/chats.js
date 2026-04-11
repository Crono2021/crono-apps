const express = require('express');
const router = express.Router();
const { Api } = require('telegram');
const tgClient = require('../telegram-client');

/**
 * GET /api/chats
 * List all dialogs (groups, channels, supergroups) that may contain videos
 */
router.get('/', async (req, res) => {
    try {
        const client = tgClient.getClient();
        const dialogs = await client.getDialogs({ limit: 200 });

        const chats = [];
        for (const dialog of dialogs) {
            const entity = dialog.entity;
            if (!entity) continue;

            // Only include groups, supergroups, and channels
            const isGroup = entity.className === 'Chat';
            const isSupergroup = entity.className === 'Channel' && entity.megagroup;
            const isChannel = entity.className === 'Channel' && !entity.megagroup;

            if (!isGroup && !isSupergroup && !isChannel) continue;

            let type = 'group';
            if (isSupergroup) type = 'supergroup';
            if (isChannel) type = 'channel';

            chats.push({
                id: entity.id.toString(),
                title: entity.title || 'Sin nombre',
                type: type,
                accessHash: entity.accessHash?.toString(),
                unreadCount: dialog.unreadCount || 0,
                // We'll get photos separately if needed
                hasPhoto: !!entity.photo,
            });
        }

        res.json({ chats });
    } catch (err) {
        console.error('[Chats] Error:', err.message);
        res.status(500).json({ error: err.message });
    }
});

/**
 * GET /api/chats/:chatId/photo
 * Get a chat's profile photo
 */
router.get('/:chatId/photo', async (req, res) => {
    try {
        const client = tgClient.getClient();
        const { chatId } = req.params;

        const entity = await client.getEntity(chatId);
        if (!entity) {
            return res.status(404).send('Chat not found');
        }

        const photo = await client.downloadProfilePhoto(entity, {
            isBig: false,
        });

        if (!photo || photo.length === 0) {
            return res.status(404).send('No photo');
        }

        res.setHeader('Content-Type', 'image/jpeg');
        res.setHeader('Cache-Control', 'public, max-age=86400');
        res.send(Buffer.from(photo));
    } catch (err) {
        console.error('[Chats] Photo error:', err.message);
        res.status(404).send('No photo');
    }
});

module.exports = router;
