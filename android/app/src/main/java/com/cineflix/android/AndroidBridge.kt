package com.cineflix.android

import android.content.Context
import android.content.Intent
import android.webkit.JavascriptInterface
import android.webkit.WebView
import com.cineflix.android.ui.player.PlayerActivity
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.first
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
        // Send the phone number to TDLib. TDLib's response comes asynchronously via
        // UpdateAuthorizationState -> WaitCode. We observe the Flow and reply to JS
        // as soon as we see WaitCode (or an Error state).
        scope.launch {
            engine.sendPhone(phone) { err -> sendAuthError(err) }
            // Wait for TDLib to transition to WaitCode (up to 15 s)
            val timeout = kotlinx.coroutines.withTimeoutOrNull(15_000) {
                engine.authState.first {
                    it is TelegramEngine.AuthState.WaitCode ||
                    it is TelegramEngine.AuthState.Error
                }
            }
            when (timeout) {
                is TelegramEngine.AuthState.WaitCode -> sendAuthState("WAIT_CODE")
                is TelegramEngine.AuthState.Error    -> sendAuthError((timeout as TelegramEngine.AuthState.Error).message)
                null -> sendAuthError("Timeout: TDLib did not confirm phone")
                else -> sendAuthError("Unexpected state: $timeout")
            }
        }
    }

    @JavascriptInterface
    fun signInWithCode(code: String) {
        scope.launch {
            engine.sendCode(code) { err -> sendAuthError(err) }
            val timeout = kotlinx.coroutines.withTimeoutOrNull(15_000) {
                engine.authState.first {
                    it is TelegramEngine.AuthState.Ready ||
                    it is TelegramEngine.AuthState.WaitPassword ||
                    it is TelegramEngine.AuthState.Error
                }
            }
            when (timeout) {
                is TelegramEngine.AuthState.Ready       -> sendAuthState("READY")
                is TelegramEngine.AuthState.WaitPassword -> sendAuthState("WAIT_PASSWORD")
                is TelegramEngine.AuthState.Error       -> sendAuthError((timeout as TelegramEngine.AuthState.Error).message)
                null -> sendAuthError("Timeout: TDLib did not confirm code")
                else -> sendAuthError("Unexpected state: $timeout")
            }
        }
    }

    @JavascriptInterface
    fun signInWithPassword(password: String) {
        scope.launch {
            engine.sendPassword(password) { err -> sendAuthError(err) }
            val timeout = kotlinx.coroutines.withTimeoutOrNull(15_000) {
                engine.authState.first {
                    it is TelegramEngine.AuthState.Ready ||
                    it is TelegramEngine.AuthState.Error
                }
            }
            when (timeout) {
                is TelegramEngine.AuthState.Ready -> sendAuthState("READY")
                is TelegramEngine.AuthState.Error -> sendAuthError((timeout as TelegramEngine.AuthState.Error).message)
                null -> sendAuthError("Timeout: TDLib did not confirm 2FA")
                else -> sendAuthError("Unexpected state: $timeout")
            }
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
     * Native storage for the most recent sendBotCommand result.
     * Buttons are indexed (0, 1, 2...) so JS only needs to pass an integer back
     * for clickInlineButton, completely avoiding the base64 round-trip.
     */
    @Volatile private var lastBotResponse: TelegramEngine.SeasonResponse? = null
    /**
     * sendBotCommand(queryId, payload)
     * Returns JSON: { messageId, chatId, buttons: [{text, data, msgId}], text }
     * button.data is the button INDEX ("0", "1", ...) — JS passes it back to
     * clickInlineButton which looks up the native SeasonButton to get real TDLib bytes.
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
                // Store entire response natively — buttons' raw TDLib bytes are never serialized to JS
                lastBotResponse = response
                val buttons = JSONArray()
                for ((index, btn) in response.buttons.withIndex()) {
                    buttons.put(JSONObject().apply {
                        put("text",  btn.text)
                        put("data",  index.toString())   // INDEX, not base64
                        put("msgId", response.messageId)
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
     * clickInlineButton(queryId, msgId, buttonIndex)
     *
     * buttonIndex is the integer index returned by sendBotCommand ("0", "1", ...).
     * The raw TDLib callback bytes come from the natively-stored lastBotResponse
     * — they NEVER go through JavaScript, eliminating all base64 round-trip issues.
     */
    @JavascriptInterface
    fun clickInlineButton(queryId: String, msgIdStr: String, buttonIndex: String) {
        scope.launch {
            try {
                val response = lastBotResponse ?: run {
                    callback(queryId, false, "No hay respuesta del bot en memoria — reinicia la búsqueda")
                    return@launch
                }
                val idx = buttonIndex.toIntOrNull() ?: run {
                    callback(queryId, false, "Índice de botón inválido: $buttonIndex")
                    return@launch
                }
                val button = response.buttons.getOrNull(idx) ?: run {
                    callback(queryId, false, "Botón $idx no encontrado (total: ${response.buttons.size})")
                    return@launch
                }
                val chatId = engine.getBotChatIdPublic() ?: run {
                    callback(queryId, false, "No se pudo obtener chatId del bot")
                    return@launch
                }
                // Use stored native msgId and raw TDLib bytes directly — no JS serialization
                val videos = engine.clickInlineButton(chatId, response.messageId, button.dataBase64)
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

    /**
     * getVideoMessages(queryId, limit, minId)
     * Fallback used by JS when clickInlineButton returns empty.
     * Uses TDLib GetChatHistory to find video messages newer than minId.
     */
    @JavascriptInterface
    fun getVideoMessages(queryId: String, limitStr: String, minIdStr: String) {
        scope.launch {
            try {
                val limit = limitStr.toIntOrNull() ?: 50
                val minId = minIdStr.toLongOrNull() ?: 0L
                val videos = engine.getVideoMessagesHistory(limit, minId)
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
     * playVideo(chatId, msgId, fileId, fileSize, mimeType, title)
     * Called by streamVideoNative() in telegram.js.
     * Launches PlayerActivity with the streaming HTTP proxy (NanoHTTPD).
     */
    @JavascriptInterface
    fun playVideo(chatId: String, msgId: String, fileId: String, fileSize: String, mimeType: String, title: String) {
        val intent = Intent(context, PlayerActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            putExtra(PlayerActivity.EXTRA_CHAT_ID,   chatId.toLongOrNull()   ?: 0L)
            putExtra(PlayerActivity.EXTRA_MSG_ID,    msgId.toLongOrNull()    ?: 0L)
            putExtra(PlayerActivity.EXTRA_FILE_ID,   fileId.toIntOrNull()    ?: 0)
            putExtra(PlayerActivity.EXTRA_FILE_SIZE, fileSize.toLongOrNull() ?: 0L)
            putExtra(PlayerActivity.EXTRA_MIME_TYPE, mimeType.ifEmpty { "video/mp4" })
            putExtra(PlayerActivity.EXTRA_TITLE,     title)
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
