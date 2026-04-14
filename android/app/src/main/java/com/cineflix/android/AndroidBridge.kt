package com.cineflix.android

import android.content.Context
import android.content.Intent
import android.webkit.JavascriptInterface
import android.webkit.WebView
import com.cineflix.android.ui.player.PlayerActivity
import kotlinx.coroutines.*
import org.json.JSONArray
import org.json.JSONObject
import org.drinkless.tdlib.TdApi

/**
 * AndroidBridge — injected as window.AndroidBridge in the WebView.
 *
 * Replaces all Capacitor plugin calls from telegram.js:
 *   - Auth: requestAuthState / loginWithPhone / signInWithCode / signInWithPassword / logOut
 *   - Bot:  sendBotCommand / clickInlineButton / searchMovieByPayload
 *   - Play: playVideo  →  launches PlayerActivity (TVGram approach)
 *
 * Async results are delivered back to JS via:
 *   - window.onTelegramAuthStateChanged(state) for auth
 *   - window.onTelegramCallback(queryId, success, payload) for bot/data calls
 */
class AndroidBridge(
    private val context: Context,
    private val webView: WebView,
    private val engine: TelegramEngine,
) {
    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    // ──────────────────────────────────────────────────────────────────────────
    // Auth methods (called by callNativeAsync in telegram.js)
    // ──────────────────────────────────────────────────────────────────────────

    @JavascriptInterface
    fun requestAuthState() {
        val state = when (engine.authState.value) {
            is TelegramEngine.AuthState.Ready         -> "READY"
            is TelegramEngine.AuthState.WaitPhone     -> "WAIT_PHONE"
            is TelegramEngine.AuthState.WaitCode      -> "WAIT_CODE"
            is TelegramEngine.AuthState.WaitPassword  -> "WAIT_PASSWORD"
            else                                      -> "UNKNOWN"
        }
        sendAuthState(state)
    }

    @JavascriptInterface
    fun loginWithPhone(phone: String) {
        engine.sendPhone(phone) { err ->
            if (err != null) sendAuthError(err)
            else sendAuthState("WAIT_CODE")
        }
    }

    @JavascriptInterface
    fun signInWithCode(code: String) {
        engine.sendCode(code) { err ->
            if (err != null) sendAuthError(err)
            else {
                val state = when (engine.authState.value) {
                    is TelegramEngine.AuthState.WaitPassword -> "WAIT_PASSWORD"
                    is TelegramEngine.AuthState.Ready        -> "READY"
                    else                                     -> "READY"
                }
                sendAuthState(state)
            }
        }
    }

    @JavascriptInterface
    fun signInWithPassword(password: String) {
        engine.sendPassword(password) { err ->
            if (err != null) sendAuthError(err)
            else sendAuthState("READY")
        }
    }

    @JavascriptInterface
    fun logOut() {
        engine.logout { sendAuthState("WAIT_PHONE") }
    }

    // ──────────────────────────────────────────────────────────────────────────
    // Bot methods (called by callNativeDataAsync in telegram.js)
    // ──────────────────────────────────────────────────────────────────────────

    /**
     * sendBotCommand(queryId, payload)
     * Returns JSON: { messageId, chatId, buttons: [{text, data, msgId}], text }
     * Equivalent to web's sendBotCommand(payload)
     */
    @JavascriptInterface
    fun sendBotCommand(queryId: String, payload: String) {
        scope.launch {
            try {
                val response = engine.sendBotCommand(payload)
                if (response == null) {
                    callback(queryId, false, "Bot no respondió")
                    return@launch
                }
                val buttons = JSONArray()
                for (btn in response.buttons) {
                    buttons.put(JSONObject().apply {
                        put("text",   btn.text)
                        put("data",   btn.dataBase64)   // base64 — TdApi callback data
                        put("msgId",  response.messageId)
                    })
                }
                val result = JSONObject().apply {
                    put("messageId", response.messageId)
                    put("chatId",    response.chatId)
                    put("buttons",   buttons)
                    put("text",      response.text)
                }
                callback(queryId, true, result.toString())
            } catch (e: Exception) {
                callback(queryId, false, e.message ?: "Error desconocido")
            }
        }
    }

    /**
     * clickInlineButton(queryId, msgId, data)
     * Returns JSON array of video objects.
     * Equivalent to web's clickInlineButton(msgId, data) + getVideoMessages()
     *
     * NOTE: data here is base64 (TDLib bytes), same as what sendBotCommand returned.
     */
    @JavascriptInterface
    fun clickInlineButton(queryId: String, msgIdStr: String, dataBase64: String) {
        scope.launch {
            try {
                val chatId = engine.getBotChatIdPublic() ?: run {
                    callback(queryId, false, "No se pudo obtener chatId del bot")
                    return@launch
                }
                val msgId = msgIdStr.toLongOrNull() ?: 0L
                val videos = engine.clickInlineButton(chatId, msgId, dataBase64)
                callback(queryId, true, videosToJson(videos, chatId))
            } catch (e: Exception) {
                callback(queryId, false, e.message ?: "Error desconocido")
            }
        }
    }

    /**
     * searchMovieByPayload(queryId, searchTitle)
     * Sends /peli <title> to bot and returns video array.
     * Equivalent to web's searchMovieByPayload(searchTitle)
     */
    @JavascriptInterface
    fun searchMovieByPayload(queryId: String, searchTitle: String) {
        scope.launch {
            try {
                val videos = engine.searchMovieByPayload(searchTitle)
                val chatId = engine.getBotChatIdPublic() ?: 0L
                callback(queryId, true, videosToJson(videos, chatId))
            } catch (e: Exception) {
                callback(queryId, false, e.message ?: "Error desconocido")
            }
        }
    }

    // ──────────────────────────────────────────────────────────────────────────
    // Playback — launches PlayerActivity (TVGram approach)
    // ──────────────────────────────────────────────────────────────────────────

    /**
     * playVideo(chatId, msgId, title)
     * Called by streamVideoNative() in telegram.js.
     * Launches PlayerActivity which uses TDLib downloadAndGetPath + ExoPlayer.
     */
    @JavascriptInterface
    fun playVideo(chatId: String, msgId: String, title: String) {
        val intent = Intent(context, PlayerActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            putExtra(PlayerActivity.EXTRA_CHAT_ID, chatId.toLongOrNull() ?: 0L)
            putExtra(PlayerActivity.EXTRA_MSG_ID,  msgId.toLongOrNull()  ?: 0L)
            putExtra(PlayerActivity.EXTRA_TITLE,   title)
            putExtra(PlayerActivity.EXTRA_FILE_ID, 0)   // resolved by PlayerActivity via msgId
        }
        context.startActivity(intent)
    }

    // ──────────────────────────────────────────────────────────────────────────
    // Helpers
    // ──────────────────────────────────────────────────────────────────────────

    private fun sendAuthState(state: String) {
        runOnUiThread { webView.evaluateJavascript(
            "window.onTelegramAuthStateChanged && window.onTelegramAuthStateChanged('$state')", null
        )}
    }

    private fun sendAuthError(msg: String) {
        val escaped = msg.replace("'", "\\'").replace("\n", " ")
        runOnUiThread { webView.evaluateJavascript(
            "window.onTelegramError && window.onTelegramError('$escaped')", null
        )}
    }

    /** Deliver async result to JS via window.onTelegramCallback(queryId, success, payload) */
    private fun callback(queryId: String, success: Boolean, payload: String) {
        // payload is either a JSON string or an error message
        val escaped = payload
            .replace("\\", "\\\\")
            .replace("'", "\\'")
            .replace("\n", "\\n")
            .replace("\r", "")
        runOnUiThread {
            webView.evaluateJavascript(
                "window.onTelegramCallback && window.onTelegramCallback('$queryId', $success, '$escaped')",
                null
            )
        }
    }

    private fun runOnUiThread(block: () -> Unit) {
        android.os.Handler(android.os.Looper.getMainLooper()).post(block)
    }

    /** Convert List<TelegramEngine.VideoInfo> to a JSON array string matching the web app format */
    private fun videosToJson(videos: List<TelegramEngine.VideoInfo>, chatId: Long): String {
        val arr = JSONArray()
        for (v in videos) {
            arr.put(JSONObject().apply {
                put("msgId",    v.msgId)
                put("fileName", v.fileName)
                put("fileSize", v.fileSize)
                put("mimeType", v.mimeType)
                put("duration", 0)          // not cached in VideoInfo, ExoPlayer reads from file
                put("width",    0)
                put("height",   0)
                put("date",     v.date)
                put("caption",  v.caption)
                put("chatId",   chatId.toString())
                put("fileId",   v.fileId)
            })
        }
        return arr.toString()
    }

    fun cleanup() { scope.cancel() }
}
