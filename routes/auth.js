const express = require('express');
const router = express.Router();
const tgClient = require('../telegram-client');

router.get('/status', async (req, res) => {
    try {
        const ok = await tgClient.isAuthorized();
        if (ok) {
            const me = await tgClient.getClient().getMe();
            res.json({ authenticated: true, user: { firstName: me.firstName, username: me.username } });
        } else {
            res.json({ authenticated: false });
        }
    } catch { res.json({ authenticated: false }); }
});

router.post('/send-code', async (req, res) => {
    try {
        const { phoneNumber } = req.body;
        if (!phoneNumber) return res.status(400).json({ error: 'Introduce tu numero' });
        const result = await tgClient.sendCode(phoneNumber);
        res.json({ success: true, phoneCodeHash: result.phoneCodeHash });
    } catch (err) {
        res.status(500).json({ error: err.message });
    }
});

router.post('/verify-code', async (req, res) => {
    try {
        const { phoneNumber, code, phoneCodeHash } = req.body;
        const result = await tgClient.verifyCode(phoneNumber, code, phoneCodeHash);
        if (result.needs2FA) return res.json({ success: false, needs2FA: true });
        res.json({ success: true, user: { firstName: result.user?.firstName, username: result.user?.username } });
    } catch (err) {
        res.status(500).json({ error: err.message });
    }
});

router.post('/2fa', async (req, res) => {
    try {
        const { password } = req.body;
        const result = await tgClient.submit2FA(password);
        res.json({ success: true, user: { firstName: result.user?.firstName, username: result.user?.username } });
    } catch (err) {
        res.status(500).json({ error: err.message });
    }
});

router.post('/logout', async (req, res) => {
    try { await tgClient.logout(); res.json({ success: true }); }
    catch (err) { res.status(500).json({ error: err.message }); }
});

module.exports = router;
