const express = require('express');
const router = express.Router();
const { Api } = require('telegram');
const tgClient = require('../telegram-client');

/**
 * GET /api/chats/:chatId/videos
 * List video messages from a chat (paginated)
 * Query: ?limit=20&offsetId=0
 */
router.get('/:chatId/videos', async (req, res) => {
    try {
        const client = tgClient.getClient();
        const { chatId } = req.params;
        const limit = parseInt(req.query.limit) || 30;
        const offsetId = parseInt(req.query.offsetId) || 0;

        const entity = await client.getEntity(chatId);

        const messages = await client.getMessages(entity, {
            limit: limit,
            offsetId: offsetId,
            filter: new Api.InputMessagesFilterVideo(),
        });

        const videos = [];
        for (const msg of messages) {
            if (!msg.media || !msg.media.document) continue;

            const doc = msg.media.document;

            // Extract video attributes
            let width = 0, height = 0, duration = 0;
            let fileName = 'video.mp4';

            for (const attr of doc.attributes || []) {
                if (attr.className === 'DocumentAttributeVideo') {
                    width = attr.w || 0;
                    height = attr.h || 0;
                    duration = Math.round(attr.duration || 0);
                } else if (attr.className === 'DocumentAttributeFilename') {
                    fileName = attr.fileName;
                }
            }

            // Check for thumbnails
            const hasThumbs = doc.thumbs && doc.thumbs.length > 0;

            videos.push({
                messageId: msg.id,
                chatId: chatId,
                fileName: fileName,
                fileSize: doc.size ? Number(doc.size) : 0,
                mimeType: doc.mimeType || 'video/mp4',
                width: width,
                height: height,
                duration: duration,
                date: msg.date,
                caption: msg.message || '',
                hasThumbnail: hasThumbs,
                thumbnailUrl: hasThumbs ? `/api/chats/thumbnail/${chatId}/${msg.id}` : null,
            });
        }

        // For pagination: the last message ID
        const lastId = messages.length > 0 ? messages[messages.length - 1].id : 0;

        res.json({
            videos,
            nextOffsetId: lastId,
            hasMore: messages.length === limit,
        });
    } catch (err) {
        console.error('[Media] Videos error:', err.message);
        res.status(500).json({ error: err.message });
    }
});

/**
 * GET /api/thumbnail/:chatId/:msgId
 * Download and serve a video thumbnail
 */
router.get('/thumbnail/:chatId/:msgId', async (req, res) => {
    try {
        const client = tgClient.getClient();
        const { chatId, msgId } = req.params;

        const entity = await client.getEntity(chatId);
        const messages = await client.getMessages(entity, {
            ids: [parseInt(msgId)],
        });

        const msg = messages[0];
        if (!msg || !msg.media || !msg.media.document) {
            return res.status(404).send('Not found');
        }

        const doc = msg.media.document;
        if (!doc.thumbs || doc.thumbs.length === 0) {
            return res.status(404).send('No thumbnail');
        }

        // Get the largest thumbnail
        const thumb = doc.thumbs[doc.thumbs.length - 1];

        // Check if it's a cached/stripped thumb (data already in object)
        if (thumb.bytes && thumb.bytes.length > 0) {
            res.setHeader('Content-Type', 'image/jpeg');
            res.setHeader('Cache-Control', 'public, max-age=86400');
            return res.send(Buffer.from(thumb.bytes));
        }

        // Download the thumbnail
        const buffer = await client.downloadFile(
            new Api.InputDocumentFileLocation({
                id: doc.id,
                accessHash: doc.accessHash,
                fileReference: doc.fileReference,
                thumbSize: thumb.type,
            }),
            {
                dcId: doc.dcId,
            }
        );

        res.setHeader('Content-Type', 'image/jpeg');
        res.setHeader('Cache-Control', 'public, max-age=86400');
        res.send(Buffer.from(buffer));
    } catch (err) {
        console.error('[Media] Thumbnail error:', err.message);
        res.status(404).send('Thumbnail unavailable');
    }
});

module.exports = router;
