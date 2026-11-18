package com.cineflix.android

import android.content.Context
import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
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
    private val TAG = "AndroidBridge"
    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    @JavascriptInterface
    fun supportsStoredSevenZip(): Boolean = true

    @JavascriptInterface
    fun getDeviceModel(): String = TelegramEngine.resolveDeviceModel(context)

    @JavascriptInterface
    fun getSystemVersion(): String = TelegramEngine.resolveSystemVersion()

    init {
        GramJSStreamManager.webView = webView
        scope.launch {
            engine.authState.collect { authState ->
                val state = when (authState) {
                    is TelegramEngine.AuthState.Ready -> "READY"
                    is TelegramEngine.AuthState.WaitPhone -> "WAIT_PHONE"
                    is TelegramEngine.AuthState.WaitCode -> "WAIT_CODE"
                    is TelegramEngine.AuthState.WaitEmailCode -> "WAIT_EMAIL_CODE|${authState.emailPattern}"
                    is TelegramEngine.AuthState.WaitPassword -> "WAIT_PASSWORD"
                    is TelegramEngine.AuthState.WaitQrCode -> "WAIT_QR|${authState.link}"
                    else -> null
                }
                if (state != null) {
                    sendAuthState(state)
                }
            }
        }
    }

    // ──────────────────────────────────────────────────────────────────────────
    // Auth methods — QueryId-correlated (zero cross-talk) + Legacy compatible
    // ──────────────────────────────────────────────────────────────────────────

    @JavascriptInterface
    fun getPasswordHint(): String = engine.getLastPasswordHint()

    @JavascriptInterface
    fun getLastSubmittedPhone(): String = engine.getLastSubmittedPhone()

    @JavascriptInterface
    fun getCodeDeliveryInfo(): String = engine.getCodeDeliveryInfoJson()

    @JavascriptInterface
    fun requestAuthState() {
        sendAuthState(engine.formatCurrentAuthStateString())
    }

    @JavascriptInterface
    fun requestAuthStateAsync(queryId: String) {
        callback(queryId, true, engine.formatCurrentAuthStateString())
    }

    @JavascriptInterface
    fun resetAuthSession() {
        scope.launch {
            engine.resetAuthSessionSuspend()
                .onSuccess { sendAuthState(it) }
                .onFailure { sendAuthError(it.message ?: "Error reiniciando sesión") }
        }
    }

    @JavascriptInterface
    fun resetAuthSessionAsync(queryId: String) {
        scope.launch {
            engine.resetAuthSessionSuspend()
                .onSuccess { callback(queryId, true, it) }
                .onFailure { callback(queryId, false, it.message ?: "Error reiniciando sesión") }
        }
    }

    @JavascriptInterface
    fun loginWithPhone(phone: String) {
        scope.launch {
            engine.loginWithPhoneSuspend(phone)
                .onSuccess { sendAuthState(it) }
                .onFailure { sendAuthError(it.message ?: "Error enviando código") }
        }
    }

    @JavascriptInterface
    fun loginWithPhoneAsync(queryId: String, phone: String) {
        scope.launch {
            engine.loginWithPhoneSuspend(phone)
                .onSuccess { callback(queryId, true, it) }
                .onFailure { callback(queryId, false, it.message ?: "Error enviando código") }
        }
    }

    @JavascriptInterface
    fun signInWithCode(code: String) {
        scope.launch {
            engine.signInWithCodeSuspend(code)
                .onSuccess { sendAuthState(it) }
                .onFailure { sendAuthError(it.message ?: "Error verificando código") }
        }
    }

    @JavascriptInterface
    fun signInWithCodeAsync(queryId: String, code: String) {
        scope.launch {
            engine.signInWithCodeSuspend(code)
                .onSuccess { callback(queryId, true, it) }
                .onFailure { callback(queryId, false, it.message ?: "Error verificando código") }
        }
    }

    @JavascriptInterface
    fun signInWithPassword(password: String) {
        scope.launch {
            engine.signInWithPasswordSuspend(password)
                .onSuccess { sendAuthState(it) }
                .onFailure { sendAuthError(it.message ?: "Error verificando contraseña 2FA") }
        }
    }

    @JavascriptInterface
    fun signInWithPasswordAsync(queryId: String, password: String) {
        scope.launch {
            engine.signInWithPasswordSuspend(password)
                .onSuccess { callback(queryId, true, it) }
                .onFailure { callback(queryId, false, it.message ?: "Error verificando contraseña 2FA") }
        }
    }

    @JavascriptInterface
    fun logOut() {
        savePhone("")
        saveTelegramSession("")
        scope.launch {
            val st = engine.logoutSuspend()
            sendAuthState(st)
        }
    }

    @JavascriptInterface
    fun logOutAsync(queryId: String) {
        savePhone("")
        saveTelegramSession("")
        scope.launch {
            val st = engine.logoutSuspend()
            callback(queryId, true, st)
        }
    }

    @JavascriptInterface
    fun logout() {
        logOut()
    }

    @JavascriptInterface
    fun getMe(queryId: String) {
        engine.getMe { user ->
            if (user != null) {
                val json = JSONObject().apply {
                    put("id", user.id)
                    put("phoneNumber", user.phoneNumber ?: "")
                    put("firstName", user.firstName ?: "")
                    put("lastName", user.lastName ?: "")
                }.toString()
                callback(queryId, true, json)
            } else {
                callback(queryId, false, "Not logged in")
            }
        }
    }

    /**
     * Request QR code login. TDLib transitions to WaitOtherDeviceConfirmation
     * with a tg://login?token=... link, while engine.authState.collect in init
     * forwards subsequent QR token rotations, WAIT_PASSWORD, and READY events.
     */
    @JavascriptInterface
    fun requestQrLogin() {
        scope.launch {
            engine.requestQrLoginSuspend(forceReset = false)
                .onSuccess { sendAuthState(it) }
                .onFailure { sendAuthError(it.message ?: "Error generando código QR") }
        }
    }

    @JavascriptInterface
    fun requestQrLoginAsync(queryId: String, forceResetStr: String) {
        val force = forceResetStr.equals("true", ignoreCase = true) || forceResetStr == "1"
        scope.launch {
            engine.requestQrLoginSuspend(forceReset = force)
                .onSuccess { callback(queryId, true, it) }
                .onFailure { callback(queryId, false, it.message ?: "Error generando código QR") }
        }
    }

    // â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€
    // Bot methods (called by callNativeDataAsync in telegram.js)
    // â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

    /**
     * Native storage for the most recent sendBotCommand result.
     * Buttons are indexed (0, 1, 2...) so JS only needs to pass an integer back
     * for clickInlineButton, completely avoiding the base64 round-trip.
     */
    @Volatile private var lastBotResponse: TelegramEngine.SeasonResponse? = null
    /**
     * sendBotCommand(queryId, payload)
     * Returns JSON: { messageId, chatId, buttons: [{text, data, msgId}], text }
     * button.data is the button INDEX ("0", "1", ...) â€” JS passes it back to
     * clickInlineButton which looks up the native SeasonButton to get real TDLib bytes.
     */
    @JavascriptInterface
    fun sendBotCommand(queryId: String, payload: String) {
        scope.launch {
            try {
                val response = engine.sendBotCommand(payload)
                if (response == null) {
                    callback(queryId, false, "Bot no respondiÃ³")
                    return@launch
                }
                // Store entire response natively â€” buttons' raw TDLib bytes are never serialized to JS
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
     * â€” they NEVER go through JavaScript, eliminating all base64 round-trip issues.
     */
    @JavascriptInterface
    fun clickInlineButton(queryId: String, msgIdStr: String, buttonIndex: String) {
        scope.launch {
            try {
                val response = lastBotResponse ?: run {
                    callback(queryId, false, "No hay respuesta del bot en memoria â€” reinicia la bÃºsqueda")
                    return@launch
                }
                val idx = buttonIndex.toIntOrNull() ?: run {
                    callback(queryId, false, "Ãndice de botÃ³n invÃ¡lido: $buttonIndex")
                    return@launch
                }
                val button = response.buttons.getOrNull(idx) ?: run {
                    callback(queryId, false, "BotÃ³n $idx no encontrado (total: ${response.buttons.size})")
                    return@launch
                }
                val chatId = engine.getBotChatIdPublic() ?: run {
                    callback(queryId, false, "No se pudo obtener chatId del bot")
                    return@launch
                }
                // Use stored native msgId and raw TDLib bytes directly â€” no JS serialization
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
     * waitForMyContentVideos(queryId)
     * Equivalente a waitForMyContentVideos() web.
     */
    @JavascriptInterface
    fun waitForMyContentVideos(queryId: String) {
        scope.launch {
            try {
                val videos = engine.waitForMyContentVideos()
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

    // â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€
    // Playback â€” launches PlayerActivity (TVGram approach)
    // â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

    @Volatile
    private var pendingPlaybackMetaJson: String? = null

    @Volatile
    private var pendingPlaybackMetaAtElapsedMs: Long = 0L

    @JavascriptInterface
    fun setNextPlaybackMetadata(jsonStr: String) {
        val clean = jsonStr.takeIf { it.isNotBlank() }
        pendingPlaybackMetaJson = clean
        pendingPlaybackMetaAtElapsedMs = if (clean != null) android.os.SystemClock.elapsedRealtime() else 0L
    }

    @JavascriptInterface
    fun closeLiveTvPip() {
        pendingPlaybackMetaJson = null
        pendingPlaybackMetaAtElapsedMs = 0L
        PlayerActivity.finishActiveLiveTvInstanceIfAny()
    }

    @JavascriptInterface
    fun expandLiveTvPip(channelId: String): Boolean {
        if (!PlayerActivity.canExpandActiveLiveTvPip(channelId)) {
            return false
        }
        PlayerActivity.markLaunchDispatched()
        runOnUiThread {
            if (!PlayerActivity.canExpandActiveLiveTvPip(channelId)) return@runOnUiThread
            val intent = Intent(context, PlayerActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT or Intent.FLAG_ACTIVITY_SINGLE_TOP)
                if (context !is android.app.Activity) {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                putExtra(PlayerActivity.EXTRA_EXPAND_EXISTING_PIP, true)
            }
            context.startActivity(intent)
            MainActivity.scheduleRePauseWebViewAfterHeadlessLaunch()
        }
        return true
    }

    private fun applyPendingPlaybackMetaToIntent(intent: Intent, progressFallback: String? = null) {
        val raw = pendingPlaybackMetaJson ?: return
        val savedAtElapsed = pendingPlaybackMetaAtElapsedMs
        pendingPlaybackMetaJson = null
        pendingPlaybackMetaAtElapsedMs = 0L
        if (savedAtElapsed > 0L && (android.os.SystemClock.elapsedRealtime() - savedAtElapsed) > 120_000L) {
            return
        }
        try {
            val obj = JSONObject(raw)
            val isLiveTv = obj.optBoolean("isLiveTv", false)
            val chId = obj.optString("channelId", "").trim()
            val chLabel = obj.optString("channelLabel", "").trim()
            val tunedAtMs = obj.optLong("tunedAtMs", 0L)
            val fallbackOffset = progressFallback?.toFloatOrNull()?.toLong()?.coerceAtLeast(0L) ?: 0L
            val baseOffsetSec = obj.optLong("baseOffsetSec", fallbackOffset).coerceAtLeast(0L)
            val isPremiere = obj.optBoolean("isPremiereLocked", false) ||
                chId.equals("ch_premiere_sabado", ignoreCase = true)
            val expandFromPip = obj.optBoolean("expandFromPip", false)

            if (isLiveTv || isPremiere) {
                intent.putExtra(PlayerActivity.EXTRA_IS_LIVE_TV, true)
                intent.putExtra(PlayerActivity.EXTRA_LIVE_TV_CHANNEL_ID, chId)
                intent.putExtra(PlayerActivity.EXTRA_LIVE_TV_CHANNEL_LABEL, chLabel)
                intent.putExtra(PlayerActivity.EXTRA_LIVE_TV_TUNED_AT_MS, if (tunedAtMs > 0L) tunedAtMs else System.currentTimeMillis())
                intent.putExtra(PlayerActivity.EXTRA_LIVE_TV_BASE_OFFSET_SEC, baseOffsetSec)
                intent.putExtra(PlayerActivity.EXTRA_IS_PREMIERE_LOCKED, isPremiere)
                intent.putExtra(PlayerActivity.EXTRA_LIVE_TV_EXPAND_FROM_PIP, expandFromPip)
                val programTitle = obj.optString("programTitle", "").trim()
                if (programTitle.isNotEmpty() && programTitle != "null") {
                    intent.putExtra(PlayerActivity.EXTRA_LIVE_TV_PROGRAM_TITLE, programTitle)
                }
                val itemId = obj.optString("itemId", "").trim()
                if (itemId.isNotEmpty() && itemId != "null") {
                    intent.putExtra(PlayerActivity.EXTRA_LIVE_TV_ITEM_ID, itemId)
                }
                val posterPath = obj.optString("posterPath", "").trim()
                if (posterPath.isNotEmpty() && posterPath != "null") {
                    intent.putExtra(PlayerActivity.EXTRA_LIVE_TV_POSTER_PATH, posterPath)
                }
                val payload = obj.optString("payload", "").trim()
                if (payload.isNotEmpty() && payload != "null") {
                    intent.putExtra(PlayerActivity.EXTRA_LIVE_TV_PAYLOAD, payload)
                }
                val rawItemJson = obj.optString("rawItemJson", "").trim()
                if (rawItemJson.isNotEmpty() && rawItemJson != "null") {
                    intent.putExtra(PlayerActivity.EXTRA_LIVE_TV_RAW_ITEM_JSON, rawItemJson)
                }
                val continuityJson = obj.optString("continuityJson", "").trim()
                if (continuityJson.isNotEmpty() && continuityJson != "null") {
                    intent.putExtra(PlayerActivity.EXTRA_LIVE_TV_CONTINUITY_JSON, continuityJson)
                }
                val upNextJson = obj.optString("upNextJson", "").trim()
                if (upNextJson.isNotEmpty() && upNextJson != "null") {
                    intent.putExtra(PlayerActivity.EXTRA_LIVE_TV_UP_NEXT_JSON, upNextJson)
                }
                val otherChannelsJson = obj.optString("otherChannelsJson", "").trim()
                if (otherChannelsJson.isNotEmpty() && otherChannelsJson != "null") {
                    intent.putExtra(PlayerActivity.EXTRA_LIVE_TV_OTHER_CHANNELS_JSON, otherChannelsJson)
                }
            }

            val tmdbId = obj.optInt("tmdbId", 0)
            if (tmdbId > 0) intent.putExtra(PlayerActivity.EXTRA_XRAY_TMDB_ID, tmdbId)
            val year = obj.optString("year", "").trim()
            if (year.isNotEmpty() && year != "null") intent.putExtra(PlayerActivity.EXTRA_XRAY_YEAR, year)
            val mediaType = obj.optString("mediaType", "").trim()
            if (mediaType.isNotEmpty() && mediaType != "null") intent.putExtra(PlayerActivity.EXTRA_XRAY_MEDIA_TYPE, mediaType)
            val cleanTitle = obj.optString("cleanTitle", "").trim()
            if (cleanTitle.isNotEmpty() && cleanTitle != "null") intent.putExtra(PlayerActivity.EXTRA_XRAY_CLEAN_TITLE, cleanTitle)
            if (obj.optBoolean("isKids", false)) {
                intent.putExtra(PlayerActivity.EXTRA_IS_KIDS_PROFILE, true)
            }
        } catch (e: Exception) {
            Log.w(TAG, "Failed to parse pendingPlaybackMetaJson: ${e.message}")
        }
    }

    private fun launchOrRouteToPlayer(intent: Intent) {
        PlayerActivity.markLaunchDispatched()
        runOnUiThread {
            PlayerActivity.markLaunchDispatched()
            // If PlayerActivity is currently floating in 16:9 Picture-in-Picture and the user zapped
            // to another Live TV channel (without requesting fullscreen expansion), switch the stream
            // directly in-process so the floating Mini-TV stays docked over the guide!
            if (PlayerActivity.dispatchNewIntentToActivePipIfStayInPip(intent)) {
                MainActivity.scheduleRePauseWebViewAfterHeadlessLaunch()
                return@runOnUiThread
            }
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            if (context !is android.app.Activity) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(intent)
            MainActivity.scheduleRePauseWebViewAfterHeadlessLaunch()
        }
    }

    /**
     * playVideo(chatId, msgId, fileId, fileSize, mimeType, title)
     * Called by streamVideoNative() in telegram.js.
     * Launches PlayerActivity with the streaming HTTP proxy (NanoHTTPD).
     */
    @JavascriptInterface
    fun playVideo(chatId: String, msgId: String, fileId: String, fileSize: String, mimeType: String, title: String) {
        val intent = Intent(context, PlayerActivity::class.java).apply {
            putExtra(PlayerActivity.EXTRA_CHAT_ID,   chatId.toLongOrNull()   ?: 0L)
            putExtra(PlayerActivity.EXTRA_MSG_ID,    msgId.toLongOrNull()    ?: 0L)
            putExtra(PlayerActivity.EXTRA_FILE_ID,   fileId.toIntOrNull()    ?: 0)
            putExtra(PlayerActivity.EXTRA_FILE_SIZE, fileSize.toLongOrNull() ?: 0L)
            putExtra(PlayerActivity.EXTRA_MIME_TYPE, mimeType.ifEmpty { "video/mp4" })
            putExtra(PlayerActivity.EXTRA_TITLE,     title)
            applyPendingPlaybackMetaToIntent(this)
        }
        launchOrRouteToPlayer(intent)
    }

    private var launcher: ((Intent) -> Unit)? = null

    fun setPlayerLauncher(l: (Intent) -> Unit) {
        launcher = l
    }

    /**
     * playVideoWithProgress(...)
     * Similar to playVideo, but passes progress tracking metadata to PlayerActivity.
     */
    @JavascriptInterface
    fun playVideoWithProgress(
        chatId: String, msgId: String, fileId: String, fileSize: String, mimeType: String, title: String,
        phone: String, contentId: String, season: String, episode: String
    ) {
        val intent = Intent(context, PlayerActivity::class.java).apply {
            putExtra(PlayerActivity.EXTRA_CHAT_ID,   chatId.toLongOrNull()   ?: 0L)
            putExtra(PlayerActivity.EXTRA_MSG_ID,    msgId.toLongOrNull()    ?: 0L)
            putExtra(PlayerActivity.EXTRA_FILE_ID,   fileId.toIntOrNull()    ?: 0)
            putExtra(PlayerActivity.EXTRA_FILE_SIZE, fileSize.toLongOrNull() ?: 0L)
            putExtra(PlayerActivity.EXTRA_MIME_TYPE, mimeType.ifEmpty { "video/mp4" })
            putExtra(PlayerActivity.EXTRA_TITLE,     title)
            putExtra(PlayerActivity.EXTRA_PHONE,      phone)
            putExtra(PlayerActivity.EXTRA_CONTENT_ID, contentId)
            putExtra(PlayerActivity.EXTRA_SEASON,     season)
            putExtra(PlayerActivity.EXTRA_EPISODE,    episode)
            applyPendingPlaybackMetaToIntent(this)
        }
        launchOrRouteToPlayer(intent)
    }

    @JavascriptInterface
    fun playVideoWithCredits(
        chatId: String, msgId: String, fileId: String, fileSize: String, mimeType: String, title: String,
        phone: String, contentId: String, season: String, episode: String, creditsStart: String
    ) {
        val intent = Intent(context, PlayerActivity::class.java).apply {
            putExtra(PlayerActivity.EXTRA_CHAT_ID,   chatId.toLongOrNull()   ?: 0L)
            putExtra(PlayerActivity.EXTRA_MSG_ID,    msgId.toLongOrNull()    ?: 0L)
            putExtra(PlayerActivity.EXTRA_FILE_ID,   fileId.toIntOrNull()    ?: 0)
            putExtra(PlayerActivity.EXTRA_FILE_SIZE, fileSize.toLongOrNull() ?: 0L)
            putExtra(PlayerActivity.EXTRA_MIME_TYPE, mimeType.ifEmpty { "video/mp4" })
            putExtra(PlayerActivity.EXTRA_TITLE,     title)
            putExtra(PlayerActivity.EXTRA_PHONE,      phone)
            putExtra(PlayerActivity.EXTRA_CONTENT_ID, contentId)
            putExtra(PlayerActivity.EXTRA_SEASON,     season)
            putExtra(PlayerActivity.EXTRA_EPISODE,    episode)
            putExtra(PlayerActivity.EXTRA_CREDITS_START, creditsStart)
            applyPendingPlaybackMetaToIntent(this)
        }
        launchOrRouteToPlayer(intent)
    }

    private fun playVideoInternal(
        chatId: String, msgId: String, mimeType: String, title: String,
        phone: String, contentId: String, season: String, episode: String,
        creditsStart: String, introStart: String, introEnd: String, introDbCreditsMs: String,
        fileId: String? = null, fileSize: String? = null, multipartJson: String? = null,
        progress: String? = null
    ) {
        val intent = Intent(context, PlayerActivity::class.java).apply {
            putExtra(PlayerActivity.EXTRA_CHAT_ID,   chatId.toLongOrNull()   ?: 0L)
            putExtra(PlayerActivity.EXTRA_MSG_ID,    msgId.toLongOrNull()    ?: 0L)
            putExtra("EXTRA_PLAYBACK_ID", GramJSStreamManager.currentPlaybackId)

            if (multipartJson != null) {
                putExtra(PlayerActivity.EXTRA_MULTIPART_JSON, multipartJson)
                if (!fileSize.isNullOrEmpty()) {
                    putExtra(PlayerActivity.EXTRA_FILE_SIZE, fileSize.toLongOrNull() ?: 0L)
                }
            } else {
                putExtra(PlayerActivity.EXTRA_FILE_ID,   fileId?.toIntOrNull()    ?: 0)
                putExtra(PlayerActivity.EXTRA_FILE_SIZE, fileSize?.toLongOrNull() ?: 0L)
            }

            putExtra(PlayerActivity.EXTRA_MIME_TYPE, mimeType.ifEmpty { "video/mp4" })
            putExtra(PlayerActivity.EXTRA_TITLE,     title)

            putExtra(PlayerActivity.EXTRA_PHONE,      phone)
            putExtra(PlayerActivity.EXTRA_CONTENT_ID, contentId)
            putExtra(PlayerActivity.EXTRA_SEASON,     season)
            putExtra(PlayerActivity.EXTRA_EPISODE,    episode)

            putExtra(PlayerActivity.EXTRA_CREDITS_START, creditsStart)
            putExtra(PlayerActivity.EXTRA_INTRO_START_MS, introStart)
            putExtra(PlayerActivity.EXTRA_INTRO_END_MS, introEnd)
            putExtra(PlayerActivity.EXTRA_INTRODB_CREDITS_MS, introDbCreditsMs)

            if (!progress.isNullOrEmpty()) {
                putExtra(PlayerActivity.EXTRA_PROGRESS, progress)
            }
            applyPendingPlaybackMetaToIntent(this, progressFallback = progress)
        }
        launchOrRouteToPlayer(intent)
    }

    @JavascriptInterface
    fun playVideoWithIntroDB(
        chatId: String, msgId: String, fileId: String, fileSize: String, mimeType: String, title: String,
        phone: String, contentId: String, season: String, episode: String,
        creditsStart: String, introStart: String, introEnd: String, introDbCreditsMs: String
    ) {
        playVideoInternal(
            chatId, msgId, mimeType, title, phone, contentId, season, episode,
            creditsStart, introStart, introEnd, introDbCreditsMs,
            fileId = fileId, fileSize = fileSize
        )
    }

    @JavascriptInterface
    fun playVideoWithIntroDBAndProgress(
        chatId: String, msgId: String, fileId: String, fileSize: String, mimeType: String, title: String,
        phone: String, contentId: String, season: String, episode: String,
        creditsStart: String, introStart: String, introEnd: String, introDbCreditsMs: String,
        progress: String
    ) {
        playVideoInternal(
            chatId, msgId, mimeType, title, phone, contentId, season, episode,
            creditsStart, introStart, introEnd, introDbCreditsMs,
            fileId = fileId, fileSize = fileSize, progress = progress
        )
    }

    @JavascriptInterface
    fun playMultipartVideoWithIntroDB(
        chatId: String, msgId: String, multipartJson: String, mimeType: String, title: String,
        phone: String, contentId: String, season: String, episode: String,
        creditsStart: String, introStart: String, introEnd: String, introDbCreditsMs: String
    ) {
        playVideoInternal(
            chatId, msgId, mimeType, title, phone, contentId, season, episode,
            creditsStart, introStart, introEnd, introDbCreditsMs,
            multipartJson = multipartJson
        )
    }

    @JavascriptInterface
    fun playMultipartVideoWithIntroDBAndProgress(
        chatId: String, msgId: String, multipartJson: String, mimeType: String, title: String,
        phone: String, contentId: String, season: String, episode: String,
        creditsStart: String, introStart: String, introEnd: String, introDbCreditsMs: String,
        progress: String
    ) {
        playVideoInternal(
            chatId, msgId, mimeType, title, phone, contentId, season, episode,
            creditsStart, introStart, introEnd, introDbCreditsMs,
            multipartJson = multipartJson, progress = progress
        )
    }

    // ──────────────────────────────────────────────────────────────────────────
    // Cinema Screen Playback (16-bit retro room in WebView)
    // ──────────────────────────────────────────────────────────────────────────

    private var cineScreenServer: com.cineflix.android.ui.player.CineScreenStreamServer? = null
    @Volatile private var cineCurrentVideoInfo: TelegramEngine.VideoInfo? = null
    @Volatile private var cineCurrentMovieTitle: String = ""

    @JavascriptInterface
    fun startCineScreenStream(queryId: String, searchTitle: String, yearStr: String) {
        startCineScreenStreamWithMultipart(queryId, searchTitle, yearStr, "", "")
    }

    @JavascriptInterface
    fun startCineScreenStreamWithFile(queryId: String, searchTitle: String, yearStr: String, fileMsgIdStr: String) {
        startCineScreenStreamWithMultipart(queryId, searchTitle, yearStr, fileMsgIdStr, "")
    }

    @JavascriptInterface
    fun startCineScreenStreamWithMultipart(queryId: String, searchTitle: String, yearStr: String, fileMsgIdStr: String, multipartJsonStr: String) {
        scope.launch {
            try {
                if (engine.authState.value !is TelegramEngine.AuthState.Ready) {
                    callback(queryId, false, "AUTH_REQUIRED")
                    return@launch
                }
                var parsedParts: List<com.cineflix.android.ui.player.FilePart>? = null
                if (multipartJsonStr.isNotBlank()) {
                    try {
                        val arr = JSONArray(multipartJsonStr)
                        val list = mutableListOf<com.cineflix.android.ui.player.FilePart>()
                        for (i in 0 until arr.length()) {
                            val o = arr.getJSONObject(i)
                            val fId = o.optInt("fileId", 0)
                            val sz = o.optLong("size", 0L)
                            val mId = o.optLong("msgId", 0L)
                            if ((fId > 0 || mId != 0L) && sz > 0) {
                                list.add(com.cineflix.android.ui.player.FilePart(fId, sz, mId))
                            }
                        }
                        if (list.isNotEmpty()) parsedParts = list
                    } catch (e: Exception) {
                        Log.w("AndroidBridge", "Error parsing multipart JSON for cine: ${e.message}")
                    }
                }

                var videos = engine.searchMovieByPayload(searchTitle)
                if (videos.isEmpty() && yearStr.isNotBlank()) {
                    videos = engine.searchMovieByPayload("$searchTitle $yearStr")
                }
                if (videos.isEmpty()) {
                    callback(queryId, false, "NOT_FOUND")
                    return@launch
                }

                val targetMsgId = fileMsgIdStr.trim().toLongOrNull() ?: 0L
                val picked = (if (targetMsgId > 0) {
                    videos.firstOrNull { it.msgId == targetMsgId }
                } else null) ?: run {
                    // Compatibilidad Cineflix:
                    // 1) Si hay MP4, SIEMPRE elegir versión MP4 para máxima compatibilidad
                    // 2) Si no, MKV que no supere 4GB (evita 4K / Dolby Vision / HDR pesados)
                    // 3) Primera disponible
                    videos.firstOrNull {
                        it.mimeType.equals("video/mp4", ignoreCase = true) ||
                        it.fileName.endsWith(".mp4", ignoreCase = true)
                    } ?: videos.firstOrNull {
                        it.fileSize <= 4294967296L // <= 4GB
                    } ?: videos.first()
                }

                if (parsedParts != null) {
                    parsedParts = engine.ensureValidMultipartParts(parsedParts, picked.chatId)
                }

                try {
                    cineScreenServer?.stop(keepCacheForImmediateHandoff = false, replacingWithNewStream = true)
                } catch (_: Exception) {}
                cineScreenServer = null

                val totalSize = parsedParts?.sumOf { it.size }?.takeIf { it > 0 } ?: picked.fileSize
                val firstFileId = parsedParts?.firstOrNull()?.fileId ?: picked.fileId

                val server = com.cineflix.android.ui.player.CineScreenStreamServer(engine)
                val streamUrl = server.start(
                    fileId = firstFileId,
                    totalSize = totalSize,
                    mimeType = picked.mimeType.ifEmpty { "video/mp4" },
                    multipartParts = parsedParts
                )
                cineScreenServer = server
                cineCurrentVideoInfo = picked
                cineCurrentMovieTitle = searchTitle

                val result = JSONObject().apply {
                    put("streamUrl", streamUrl)
                    put("fileId", firstFileId)
                    put("fileSize", totalSize)
                    put("mimeType", picked.mimeType)
                    put("chatId", picked.chatId)
                    put("msgId", picked.msgId)
                    put("fileName", picked.fileName)
                    put("title", searchTitle)
                    put("isMultipart", parsedParts != null && parsedParts.size > 1)
                    put("partsCount", parsedParts?.size ?: 1)
                }
                callback(queryId, true, result.toString())
            } catch (e: Exception) {
                Log.e("AndroidBridge", "startCineScreenStream error", e)
                callback(queryId, false, e.message ?: "STREAM_FAILED")
            }
        }
    }

    fun isCineScreenActive(): Boolean = cineScreenServer?.isActivelyRunning() == true

    private fun stopCineScreenStreamInternal(keepCacheForImmediateHandoff: Boolean) {
        try {
            cineScreenServer?.stop(keepCacheForImmediateHandoff = keepCacheForImmediateHandoff)
        } catch (_: Exception) {}
        cineScreenServer = null
        cineCurrentVideoInfo = null
        cineCurrentMovieTitle = ""
    }

    @JavascriptInterface
    fun stopCineScreenStream() {
        stopCineScreenStreamInternal(keepCacheForImmediateHandoff = false)
    }

    @JavascriptInterface
    fun playCineFullscreen(progressSec: String) {
        val info = cineCurrentVideoInfo
        val titleCopy = cineCurrentMovieTitle
        PlayerActivity.markLaunchDispatched()
        stopCineScreenStreamInternal(keepCacheForImmediateHandoff = true)
        val intent = Intent(context, com.cineflix.android.ui.player.PlayerActivity::class.java).apply {
            putExtra(com.cineflix.android.ui.player.PlayerActivity.EXTRA_CHAT_ID,   info?.chatId ?: 0L)
            putExtra(com.cineflix.android.ui.player.PlayerActivity.EXTRA_MSG_ID,    info?.msgId ?: 0L)
            putExtra(com.cineflix.android.ui.player.PlayerActivity.EXTRA_FILE_ID,   info?.fileId ?: 0)
            putExtra(com.cineflix.android.ui.player.PlayerActivity.EXTRA_FILE_SIZE, info?.fileSize ?: 0L)
            putExtra(com.cineflix.android.ui.player.PlayerActivity.EXTRA_MIME_TYPE, info?.mimeType?.ifEmpty { "video/mp4" } ?: "video/mp4")
            putExtra(com.cineflix.android.ui.player.PlayerActivity.EXTRA_TITLE,     titleCopy.ifEmpty { info?.fileName ?: "Cineflix" })
            putExtra(com.cineflix.android.ui.player.PlayerActivity.EXTRA_PROGRESS,  progressSec)
            applyPendingPlaybackMetaToIntent(this, progressFallback = progressSec)
        }
        launchOrRouteToPlayer(intent)
    }

    @JavascriptInterface
    fun playCineFullscreenFull(
        chatId: String, msgId: String, fileId: String, fileSize: String, mimeType: String, title: String, progressSec: String
    ) {
        PlayerActivity.markLaunchDispatched()
        stopCineScreenStreamInternal(keepCacheForImmediateHandoff = true)
        val intent = Intent(context, com.cineflix.android.ui.player.PlayerActivity::class.java).apply {
            putExtra(com.cineflix.android.ui.player.PlayerActivity.EXTRA_CHAT_ID,   chatId.toLongOrNull() ?: 0L)
            putExtra(com.cineflix.android.ui.player.PlayerActivity.EXTRA_MSG_ID,    msgId.toLongOrNull() ?: 0L)
            putExtra(com.cineflix.android.ui.player.PlayerActivity.EXTRA_FILE_ID,   fileId.toIntOrNull() ?: 0)
            putExtra(com.cineflix.android.ui.player.PlayerActivity.EXTRA_FILE_SIZE, fileSize.toLongOrNull() ?: 0L)
            putExtra(com.cineflix.android.ui.player.PlayerActivity.EXTRA_MIME_TYPE, mimeType.ifEmpty { "video/mp4" })
            putExtra(com.cineflix.android.ui.player.PlayerActivity.EXTRA_TITLE,     title)
            putExtra(com.cineflix.android.ui.player.PlayerActivity.EXTRA_PROGRESS,  progressSec)
            applyPendingPlaybackMetaToIntent(this, progressFallback = progressSec)
        }
        launchOrRouteToPlayer(intent)
    }

    // â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€
    // OTA Update: Download and install new APK
    // â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

    @JavascriptInterface
    fun downloadAndInstallUpdate(url: String) {
        try {
            // Delete previous update file if it exists to prevent "update-1.apk" renaming issues
            val oldFile = java.io.File(
                android.os.Environment.getExternalStoragePublicDirectory(android.os.Environment.DIRECTORY_DOWNLOADS),
                "cineflix_update.apk"
            )
            if (oldFile.exists()) oldFile.delete()

            val req = android.app.DownloadManager.Request(android.net.Uri.parse(url))
            req.setTitle("Cineflix Update")
            req.setDescription("Descargando nueva versiÃ³n...")
            req.setNotificationVisibility(android.app.DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            req.setDestinationInExternalPublicDir(android.os.Environment.DIRECTORY_DOWNLOADS, "cineflix_update.apk")
            
            val dm = context.getSystemService(Context.DOWNLOAD_SERVICE) as android.app.DownloadManager
            val downloadId = dm.enqueue(req)
            
            val appCtx = context.applicationContext
            val receiver = object : android.content.BroadcastReceiver() {
                override fun onReceive(ctx: Context, intent: Intent) {
                    val id = intent.getLongExtra(android.app.DownloadManager.EXTRA_DOWNLOAD_ID, -1)
                    if (id == downloadId) {
                        try {
                            val apkUri = dm.getUriForDownloadedFile(downloadId)
                            val installIntent = Intent(Intent.ACTION_VIEW).apply {
                                setDataAndType(apkUri, "application/vnd.android.package-archive")
                                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_GRANT_READ_URI_PERMISSION
                            }
                            ctx.startActivity(installIntent)
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                        runCatching { appCtx.unregisterReceiver(this) }
                    }
                }
            }
            if (android.os.Build.VERSION.SDK_INT >= 33) {
                appCtx.registerReceiver(receiver, android.content.IntentFilter(android.app.DownloadManager.ACTION_DOWNLOAD_COMPLETE), Context.RECEIVER_EXPORTED)
            } else {
                appCtx.registerReceiver(receiver, android.content.IntentFilter(android.app.DownloadManager.ACTION_DOWNLOAD_COMPLETE))
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    // â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€
    // Helpers
    // â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€

    private fun sendAuthState(state: String) {
        val quotedState = JSONObject.quote(state)
        runOnUiThread { webView.evaluateJavascript(
            "window.onTelegramAuthStateChanged && window.onTelegramAuthStateChanged($quotedState)", null
        )}

        // When auth reaches READY, proactively inject the user's phone into WebView localStorage + CineflixPrefs
        // so that getUserPhone() always finds it at Priority 1 (cross-device sync for favorites/progress)
        if (state == "READY") {
            engine.getMe { user ->
                if (user != null) {
                    val phone = (user.phoneNumber?.takeIf { it.isNotEmpty() } ?: user.id.toString())
                        .replace("+", "").trim()
                    if (phone.isNotEmpty()) {
                        savePhone(phone)
                    }
                    val tgName = listOf(user.firstName ?: "", user.lastName ?: "")
                        .map { it.trim() }.filter { it.isNotEmpty() }.joinToString(" ").take(16).trim()
                    val quotedPhone = JSONObject.quote(phone)
                    val quotedTgName = JSONObject.quote(tgName)
                    runOnUiThread {
                        webView.evaluateJavascript("""
                            (function() {
                                try {
                                    var ph = $quotedPhone;
                                    var nm = $quotedTgName;
                                    if (nm) localStorage.setItem('cineflix_tg_name', nm);
                                    if (ph) {
                                        localStorage.setItem('user_phone', ph);
                                        localStorage.setItem('cineflix_current_phone', ph);
                                        localStorage.setItem('cineflix_verified_phone', ph);
                                        sessionStorage.setItem('cineflix_current_phone', ph);
                                    }
                                    console.log('[Native] Auth READY — phone synced to localStorage:', ph);
                                } catch (_) {}
                            })();
                        """.trimIndent(), null)
                    }
                }
            }
        }
    }

    private fun sendAuthError(msg: String) {
        val quotedMsg = JSONObject.quote(msg.replace("\r", " ").replace("\n", " "))
        runOnUiThread { webView.evaluateJavascript(
            "window.onTelegramError && window.onTelegramError($quotedMsg)", null
        )}
    }

    /** Deliver async result to JS via window.onTelegramCallback(queryId, success, payload) */
    private fun callback(queryId: String, success: Boolean, payload: String) {
        val quotedQueryId = JSONObject.quote(queryId)
        val quotedPayload = JSONObject.quote(payload)
        runOnUiThread {
            webView.evaluateJavascript(
                "window.onTelegramCallback && window.onTelegramCallback($quotedQueryId, $success, $quotedPayload)",
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
                put("id",       v.fileId)
            })
        }
        return arr.toString()
    }

    @JavascriptInterface
    fun getPlatform(): String {
        return if (com.cineflix.android.util.StorageAndRamHygiene.isTelevision(context)) {
            "android_tv"
        } else {
            "android"
        }
    }

    @JavascriptInterface
    fun getVersionCode(): Long {
        return try {
            val pi = context.packageManager.getPackageInfo(context.packageName, 0)
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
                pi.longVersionCode
            } else {
                @Suppress("DEPRECATION")
                pi.versionCode.toLong()
            }
        } catch (e: Throwable) {
            2L
        }
    }

    @JavascriptInterface
    fun getStorageReportJson(): String {
        return try {
            val dataDir = context.applicationContext.dataDir ?: context.filesDir.parentFile ?: context.filesDir
            com.cineflix.android.util.StorageAndRamHygiene.measureAppStorageBytes(dataDir, context.cacheDir).toJsonString()
        } catch (e: Throwable) {
            "{}"
        }
    }

    @JavascriptInterface
    fun performDeepCacheCleanup(): String {
        val dataDir = context.applicationContext.dataDir ?: context.filesDir.parentFile ?: context.filesDir
        val before = com.cineflix.android.util.StorageAndRamHygiene.measureAppStorageBytes(dataDir, context.cacheDir)
        context.getSharedPreferences("CineflixPrefs", Context.MODE_PRIVATE)
            .edit()
            .putBoolean(com.cineflix.android.util.StorageAndRamHygiene.PREF_PENDING_PRE_WEBVIEW_PURGE, true)
            .apply()
        runOnUiThread {
            try {
                webView.clearCache(true)
                webView.evaluateJavascript(
                    com.cineflix.android.util.StorageAndRamHygiene.buildWebViewStorageHygieneJs(forceCompactIdb = true),
                    null
                )
            } catch (_: Throwable) {}
        }
        scope.launch {
            try {
                com.cineflix.android.util.StorageAndRamHygiene.cleanTdlibDatabaseBloat(context.filesDir)
                if (!com.cineflix.android.ui.player.cast.CastSessionCoordinator.isCastingActive &&
                    !PlayerActivity.isPlaybackOrLaunchActive() &&
                    !isCineScreenActive()
                ) {
                    engine.purgeAllStreamingCaches()
                }
                com.cineflix.android.util.StorageAndRamHygiene.cleanEphemeralCacheArtifacts(
                    cacheDir = context.cacheDir,
                    maxCrashReportAgeMs = 0L,
                    maxOtaApkAgeMs = 0L
                )
                com.cineflix.android.util.StorageAndRamHygiene.enforceWebViewCacheQuota(
                    dataDir = dataDir,
                    cacheDir = context.cacheDir,
                    maxCacheBytes = 0L,
                    isWebViewActive = true
                )
                delay(450L)
                val after = com.cineflix.android.util.StorageAndRamHygiene.measureAppStorageBytes(dataDir, context.cacheDir)
                val freedMb = ((before.totalBytes - after.totalBytes).coerceAtLeast(0L)) / (1024.0 * 1024.0)
                runOnUiThread {
                    val msg = if (freedMb >= 0.5) {
                        String.format(java.util.Locale.US, "🧹 Limpieza completada: %.1f MB liberados (sesión intacta)", freedMb)
                    } else {
                        "🧹 La app ya está limpia y optimizada (${String.format(java.util.Locale.US, "%.1f", after.totalBytes / (1024.0 * 1024.0))} MB en uso)"
                    }
                    android.widget.Toast.makeText(context.applicationContext, msg, android.widget.Toast.LENGTH_LONG).show()
                }
            } catch (e: Throwable) {
                Log.w(TAG, "performDeepCacheCleanup error: ${e.message}")
            }
        }
        return before.toJsonString()
    }

    private var lastShowKeyboardTime = 0L

    @JavascriptInterface
    fun showKeyboard() {
        lastShowKeyboardTime = System.currentTimeMillis()
        runOnUiThread {
            try {
                webView.requestFocus()
                val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as android.view.inputmethod.InputMethodManager
                imm.showSoftInput(webView, android.view.inputmethod.InputMethodManager.SHOW_IMPLICIT)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    @JavascriptInterface
    fun hideKeyboard() {
        val isTv = com.cineflix.android.util.StorageAndRamHygiene.isTelevision(context)
        val isAmazon = android.os.Build.MANUFACTURER.equals("Amazon", ignoreCase = true)

        if (isTv && !isAmazon) {
            if (System.currentTimeMillis() - lastShowKeyboardTime < 1500) {
                android.util.Log.d("CineflixMain", "Ignored hideKeyboard() due to TV window focus blur")
                return
            }
        }

        runOnUiThread {
            try {
                val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as android.view.inputmethod.InputMethodManager
                imm.hideSoftInputFromWindow(webView.windowToken, 0)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    @JavascriptInterface
    fun requestSearchKeyboard(currentText: String?, targetInputId: String) {
        runOnUiThread {
            val activity = context as? android.app.Activity ?: return@runOnUiThread
            val editText = android.widget.EditText(activity)
            editText.setText(currentText ?: "")
            editText.setSelection(editText.text.length)
            editText.isSingleLine = true

            val dialog = android.app.AlertDialog.Builder(activity, android.R.style.Theme_DeviceDefault_Dialog_Alert)
                .setTitle("Buscar")
                .setView(editText)
                .setPositiveButton("Buscar") { _, _ ->
                    val query = editText.text.toString().replace("'", "\\'")
                    webView.evaluateJavascript("""
                        (function() {
                            var input = document.getElementById('$targetInputId');
                            if(input) {
                                input.value = '$query';
                                input.dispatchEvent(new Event('input', { bubbles: true }));
                            }
                        })();
                    """.trimIndent(), null)
                }
                .setNegativeButton("Cancelar", null)
                .create()

            dialog.setOnShowListener {
                editText.requestFocus()
                val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as android.view.inputmethod.InputMethodManager
                imm.showSoftInput(editText, android.view.inputmethod.InputMethodManager.SHOW_IMPLICIT)
            }
            dialog.show()
        }
    }

    fun cleanup() {
        stopCineScreenStream()
        launcher = null
        lastBotResponse = null
        pendingPlaybackMetaJson = null
        if (GramJSStreamManager.webView === webView) {
            GramJSStreamManager.webView = null
        }
        GramJSStreamManager.activeRequests.clear()
        scope.cancel()
    }

    // --- GramJS Bridge (Phase 1 & 2) ---
    @JavascriptInterface
    fun supportsGramJSStreaming(): Boolean = false

    @JavascriptInterface
    fun getTelegramSession(): String {
        return context.getSharedPreferences("CineflixPrefs", Context.MODE_PRIVATE)
            .getString("tg_session", "") ?: ""
    }

    @JavascriptInterface
    fun saveTelegramSession(session: String) {
        context.getSharedPreferences("CineflixPrefs", Context.MODE_PRIVATE)
            .edit()
            .putString("tg_session", session)
            .apply()
    }

    @JavascriptInterface
    fun setPlaybackSession(playbackId: String) {
        android.util.Log.i("AndroidBridge", "⚡ setPlaybackSession: $playbackId")
        GramJSStreamManager.currentPlaybackId = playbackId
    }

    @JavascriptInterface
    fun startGramJSStream(
        fileSize: String,
        mimeType: String,
        title: String,
        phone: String,
        contentId: String,
        season: String,
        episode: String,
        creditsStart: String,
        introStart: String,
        introEnd: String,
        introDbCreditsMs: String
    ) {
        android.util.Log.i("AndroidBridge", "🚀 startGramJSStream: playbackId=${GramJSStreamManager.currentPlaybackId}, size=$fileSize, title=$title")
        val intent = Intent(context, PlayerActivity::class.java).apply {
            putExtra("EXTRA_PLAYBACK_ID", GramJSStreamManager.currentPlaybackId)
            putExtra(PlayerActivity.EXTRA_FILE_SIZE, fileSize.toLongOrNull() ?: 0L)
            putExtra(PlayerActivity.EXTRA_MIME_TYPE, mimeType.ifEmpty { "video/mp4" })
            putExtra(PlayerActivity.EXTRA_TITLE, title)
            putExtra(PlayerActivity.EXTRA_PHONE, phone)
            putExtra(PlayerActivity.EXTRA_CONTENT_ID, contentId)
            putExtra(PlayerActivity.EXTRA_SEASON, season)
            putExtra(PlayerActivity.EXTRA_EPISODE, episode)
            putExtra(PlayerActivity.EXTRA_CREDITS_START, creditsStart)
            putExtra(PlayerActivity.EXTRA_INTRO_START_MS, introStart)
            putExtra(PlayerActivity.EXTRA_INTRO_END_MS, introEnd)
            putExtra(PlayerActivity.EXTRA_INTRODB_CREDITS_MS, introDbCreditsMs)
            applyPendingPlaybackMetaToIntent(this)
        }
        launchOrRouteToPlayer(intent)
    }

    @JavascriptInterface
    fun deliverChunkBase64(requestId: String, base64Data: String) {
        val request = GramJSStreamManager.activeRequests.remove(requestId) ?: return
        
        try {
            if (base64Data.isEmpty()) {
                request.deferred.complete(Result.success(ByteArray(0)))
                return
            }
            val bytes = android.util.Base64.decode(base64Data, android.util.Base64.DEFAULT)
            request.deferred.complete(Result.success(bytes))
        } catch (e: Exception) {
            request.deferred.complete(Result.failure(Exception("Base64 Decode Error: " + e.message)))
        }
    }

    @JavascriptInterface
    fun deliverChunkError(requestId: String, error: String) {
        val request = GramJSStreamManager.activeRequests.remove(requestId) ?: return
        request.deferred.complete(Result.failure(Exception(error)))
    }

    // --- Audio Output Mode (Stereo PCM vs 5.1 Passthrough) ---
    @JavascriptInterface
    fun setAudioOutputMode(mode: String) {
        context.getSharedPreferences("CineflixPrefs", Context.MODE_PRIVATE)
            .edit()
            .putString("audio_output_mode", mode)
            .apply()
    }

    @JavascriptInterface
    fun getAudioOutputMode(): String {
        return context.getSharedPreferences("CineflixPrefs", Context.MODE_PRIVATE)
            .getString("audio_output_mode", "stereo") ?: "stereo"
    }

    // --- Enviar Log al Bot de Telegram ---
    @JavascriptInterface
    fun sendLogToBot(reason: String) {
        android.widget.Toast.makeText(context, "Enviando log de diagnóstico al bot...", android.widget.Toast.LENGTH_SHORT).show()
        com.cineflix.android.util.ErrorLogCollector.sendReportToBot(
            context = context.applicationContext,
            reason = reason.ifEmpty { "Reporte enviado desde la interfaz web" },
            extraInfo = mapOf("source" to "WebView/Frontend")
        ) { success, _ ->
            android.os.Handler(android.os.Looper.getMainLooper()).post {
                if (success) {
                    android.widget.Toast.makeText(context, "Log enviado con éxito a @videoclubpacobot", android.widget.Toast.LENGTH_LONG).show()
                } else {
                    android.widget.Toast.makeText(context, "No se pudo enviar al bot. Guardado localmente.", android.widget.Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    @JavascriptInterface
    fun getSavedPhone(): String {
        return context.getSharedPreferences("CineflixPrefs", Context.MODE_PRIVATE)
            .getString("user_phone", "") ?: ""
    }

    @JavascriptInterface
    fun savePhone(phone: String) {
        context.getSharedPreferences("CineflixPrefs", Context.MODE_PRIVATE)
            .edit()
            .putString("user_phone", phone)
            .apply()
    }
}

data class PendingGramJSRequest(
    val generation: Int,
    val virtualOffset: Long,
    val deferred: kotlinx.coroutines.CompletableDeferred<Result<ByteArray>>
)

@SuppressLint("StaticFieldLeak")
object GramJSStreamManager {
    @Volatile
    var webView: WebView? = null
    
    val activeRequests = java.util.concurrent.ConcurrentHashMap<String, PendingGramJSRequest>()
    
    @Volatile
    var currentPlaybackId: String = ""
}


