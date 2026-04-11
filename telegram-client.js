const { TelegramClient, Api } = require('telegram');
const { StringSession } = require('telegram/sessions');
const { computeCheck } = require('telegram/Password');
const fs = require('fs');
const path = require('path');
const config = require('./config');

class TelegramClientManager {
    constructor() {
        this.client = null;
        this.session = null;
        this.connected = false;
        this.phoneCodeHash = null;
    }

    _loadSession() {
        const dir = path.dirname(config.SESSION_FILE);
        if (!fs.existsSync(dir)) fs.mkdirSync(dir, { recursive: true });
        try {
            if (fs.existsSync(config.SESSION_FILE)) {
                const s = fs.readFileSync(config.SESSION_FILE, 'utf-8').trim();
                if (s) return new StringSession(s);
            }
        } catch (e) { }
        return new StringSession('');
    }

    _saveSession() {
        try {
            const dir = path.dirname(config.SESSION_FILE);
            if (!fs.existsSync(dir)) fs.mkdirSync(dir, { recursive: true });
            fs.writeFileSync(config.SESSION_FILE, this.client.session.save());
        } catch (e) { }
    }

    async init() {
        if (this.client) return;
        this.session = this._loadSession();
        this.client = new TelegramClient(this.session, config.API_ID, config.API_HASH, {
            connectionRetries: 5,
            retryDelay: 1000,
        });
    }

    async connect() {
        if (!this.client) await this.init();
        await this.client.connect();
        this.connected = true;
    }

    async isAuthorized() {
        if (!this.client || !this.connected) return false;
        try { return !!(await this.client.getMe()); } catch { return false; }
    }

    async sendCode(phoneNumber) {
        if (!this.connected) await this.connect();
        const result = await this.client.invoke(
            new Api.auth.SendCode({
                phoneNumber,
                apiId: config.API_ID,
                apiHash: config.API_HASH,
                settings: new Api.CodeSettings({}),
            })
        );
        this.phoneCodeHash = result.phoneCodeHash;
        return { phoneCodeHash: result.phoneCodeHash };
    }

    async verifyCode(phoneNumber, code, phoneCodeHash) {
        try {
            const result = await this.client.invoke(
                new Api.auth.SignIn({
                    phoneNumber,
                    phoneCodeHash: phoneCodeHash || this.phoneCodeHash,
                    phoneCode: code,
                })
            );
            this._saveSession();
            return { success: true, user: result.user };
        } catch (err) {
            if (err.errorMessage === 'SESSION_PASSWORD_NEEDED') {
                return { success: false, needs2FA: true };
            }
            throw err;
        }
    }

    async submit2FA(password) {
        const pwdInfo = await this.client.invoke(new Api.account.GetPassword());
        const srp = await computeCheck(pwdInfo, password);
        const result = await this.client.invoke(new Api.auth.CheckPassword({ password: srp }));
        this._saveSession();
        return { success: true, user: result.user };
    }

    async logout() {
        try { await this.client.invoke(new Api.auth.LogOut()); } catch { }
        try { fs.unlinkSync(config.SESSION_FILE); } catch { }
        this.connected = false;
        this.client = null;
    }

    getClient() { return this.client; }
}

module.exports = new TelegramClientManager();
