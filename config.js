/**
 * TelegramFlix Configuration
 * 
 * ⚠️ Set your API_ID and API_HASH below (one-time developer setup)
 * Get them from https://my.telegram.org → "API development tools"
 */

module.exports = {
    API_ID: 25193949,
    API_HASH: '0523cf42fe71db02eeaa8ba52124c826',

    PORT: 3001,
    HOST: 'localhost',
    SESSION_FILE: './session/.session',
    CHUNK_SIZE: 512 * 1024,
};
