package com.cineflix.android

import android.content.Context
import android.util.Log
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import org.drinkless.tdlib.Client
import org.drinkless.tdlib.TdApi
import java.io.File
import java.util.concurrent.ConcurrentHashMap

/**
 * TelegramEngine — Motor TDLib nativo, sin WebView ni Capacitor.
 * Expone Flows reactivos para la UI de Jetpack Compose.
 */
class TelegramEngine(private val context: Context) {

    companion object {
        private const val TAG = "TelegramEngine"
        const val BOT_USERNAME = "videoclubpacobot"
        const val API_ID = 36374374
        const val API_HASH = "8000603d2523b8a22df55c9476d9c64a"

        @Volatile
        private var INSTANCE: TelegramEngine? = null

        fun getInstance(context: Context): TelegramEngine =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: TelegramEngine(context.applicationContext).also { INSTANCE = it }
            }
    }

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private var client: Client? = null

    // ── Auth State ────────────────────────────────────────────────────────────
    sealed class AuthState {
        object Unknown : AuthState()
        object WaitPhone : AuthState()
        object WaitCode : AuthState()
        object WaitPassword : AuthState()
        data class WaitQrCode(val link: String) : AuthState()
        object Ready : AuthState()
        object LoggingOut : AuthState()
        data class Error(val message: String) : AuthState()
    }

    private val _authState = MutableStateFlow<AuthState>(AuthState.Unknown)
    val authState: StateFlow<AuthState> = _authState.asStateFlow()

    // ── File Download Tracking ────────────────────────────────────────────────
    // fileId → local path (emitted when TDLib writes file to disk)
    private val filePathEmitters = ConcurrentHashMap<Int, CompletableDeferred<String>>()

    // Pre-cached fileId for bot episode messages: "chatId:msgId" → Pair(fileId, mimeType)
    val fileIdCache = ConcurrentHashMap<String, Pair<Int, String>>()

    // ── Bot Message Collector ─────────────────────────────────────────────────
    data class MsgCollector(
        val chatId: Long,
        val afterMsgId: Long,
        val videos: MutableList<VideoInfo> = mutableListOf(),
        @Volatile var lastReceived: Long = System.currentTimeMillis(),
    )

    data class VideoInfo(
        val msgId: Long,
        val chatId: Long,
        val fileId: Int,
        val fileName: String,
        val fileSize: Long,
        val mimeType: String,
        val caption: String,
        val date: Int,
    )

    data class SeasonResponse(
        val messageId: Long,
        val chatId: Long,
        val text: String,
        val buttons: List<SeasonButton>,
    )

    data class SeasonButton(
        val text: String,
        val dataBase64: String,
        val msgId: Long,
    )

    private val msgCollectors = ConcurrentHashMap<String, MsgCollector>()

    // ── Inline Keyboard Reply Listener ───────────────────────────────────────
    /** Used by sendBotCommand to detect the bot's keyboard reply via UpdateNewMessage */
    data class InlineKeyboardListener(
        val chatId: Long,
        val deferred: CompletableDeferred<SeasonResponse?>,
    )
    private val inlineKeyboardListeners = ConcurrentHashMap<String, InlineKeyboardListener>()

    // ── Init ─────────────────────────────────────────────────────────────────
    init {
        initClient()
    }

    private fun initClient() {
        Log.i(TAG, "Initializing TDLib client...")
        client = Client.create(
            { result -> handleResult(result) },
            { error -> Log.e(TAG, "TDLib Error: ${error.message}", error) },
            { error -> Log.e(TAG, "TDLib Default Error: ${error.message}", error) }
        )
    }

    // ── TDLib Event Handler ───────────────────────────────────────────────────
    private fun handleResult(result: TdApi.Object) {
        when (result) {
            is TdApi.UpdateAuthorizationState -> handleAuthState(result.authorizationState)
            is TdApi.UpdateFile               -> handleUpdateFile(result.file)
            is TdApi.UpdateNewMessage         -> handleNewMessage(result.message)
            else -> { /* ignore */ }
        }
    }

    private fun handleAuthState(state: TdApi.AuthorizationState) {
        Log.i(TAG, "Auth state: ${state.javaClass.simpleName}")
        when (state) {
            is TdApi.AuthorizationStateWaitTdlibParameters -> {
                val dbPath = File(context.filesDir, "tdlib_data").absolutePath
                client?.send(TdApi.SetTdlibParameters(
                    false, dbPath, dbPath, null,
                    true, true, true, true,
                    API_ID, API_HASH,
                    "es", "Android", "14", "Cineflix/2.0"
                )) {}
            }
            is TdApi.AuthorizationStateWaitPhoneNumber -> _authState.value = AuthState.WaitPhone
            is TdApi.AuthorizationStateWaitOtherDeviceConfirmation -> {
                _authState.value = AuthState.WaitQrCode(state.link)
            }
            is TdApi.AuthorizationStateWaitCode        -> _authState.value = AuthState.WaitCode
            is TdApi.AuthorizationStateWaitPassword    -> _authState.value = AuthState.WaitPassword
            is TdApi.AuthorizationStateReady           -> {
                _authState.value = AuthState.Ready
                // Cleanup stray 2.8GB caches at boot to rescue TV storage
                try {
                    val videosDir = java.io.File(context.filesDir, "tdlib_data/videos")
                    if (videosDir.exists()) videosDir.deleteRecursively()
                    val docsDir = java.io.File(context.filesDir, "tdlib_data/documents")
                    if (docsDir.exists()) docsDir.deleteRecursively()
                } catch (_: Exception) {}
            }
            is TdApi.AuthorizationStateLoggingOut      -> _authState.value = AuthState.LoggingOut
            is TdApi.AuthorizationStateClosed          -> {
                client = null
                _authState.value = AuthState.Unknown
                initClient()
            }
            else -> {}
        }
    }

    private fun handleUpdateFile(file: TdApi.File) {
        val p = file.local?.path
        if (!p.isNullOrEmpty()) {
            val deferred = filePathEmitters[file.id]
            if (deferred != null && !deferred.isCompleted) {
                deferred.complete(p)
            }
        }
        
        // Update FileState flow so StreamProxyServer can safely read bytes
        val flow = fileStates.getOrPut(file.id) { kotlinx.coroutines.flow.MutableStateFlow(null) }
        flow.value = FileState(
            path = file.local?.path ?: "",
            downloadedPrefixSize = file.local?.downloadedPrefixSize ?: 0L,
            downloadedSize = file.local?.downloadedSize ?: 0L,
            expectedSize = file.expectedSize.toLong(),
            isCompleted = file.local?.isDownloadingCompleted == true
        )
    }

    private fun handleNewMessage(msg: TdApi.Message) {
        val content = msg.content
        val isVideo = content is TdApi.MessageDocument || content is TdApi.MessageVideo

        // Check if this message is a bot keyboard reply we're waiting for
        for ((key, listener) in inlineKeyboardListeners) {
            if (msg.chatId == listener.chatId && !listener.deferred.isCompleted) {
                val kb = msg.replyMarkup
                if (kb is TdApi.ReplyMarkupInlineKeyboard) {
                    val buttons = mutableListOf<SeasonButton>()
                    for (row in kb.rows) {
                        for (btn in row) {
                            val t = btn.type
                            if (t is TdApi.InlineKeyboardButtonTypeCallback) {
                                buttons.add(SeasonButton(
                                    text       = btn.text,
                                    dataBase64 = android.util.Base64.encodeToString(t.data, android.util.Base64.NO_WRAP),
                                    msgId      = msg.id,
                                ))
                            }
                        }
                    }
                    val bodyText = (content as? TdApi.MessageText)?.text?.text ?: ""
                    val response = SeasonResponse(msg.id, msg.chatId, bodyText, buttons)
                    listener.deferred.complete(response)
                    inlineKeyboardListeners.remove(key)
                }
            }
        }

        // Notify active video collectors
        for ((_, collector) in msgCollectors) {
            if (msg.chatId == collector.chatId && msg.id > collector.afterMsgId && isVideo) {
                val info = extractVideoInfo(msg) ?: continue
                synchronized(collector.videos) { collector.videos.add(info) }
                collector.lastReceived = System.currentTimeMillis()
            }
        }

        // Pre-cache fileId for instant playback
        if (isVideo) {
            val info = extractVideoInfo(msg) ?: return
            val cacheKey = "${msg.chatId}:${msg.id}"
            fileIdCache[cacheKey] = Pair(info.fileId, info.mimeType)
            // (Removed buggy DownloadFile pre-warm that saturated Android TV storage and CPU)
        }
    }

    private fun extractVideoInfo(msg: TdApi.Message): VideoInfo? {
        return try {
            when (val c = msg.content) {
                is TdApi.MessageDocument -> {
                    val doc = c.document
                    val mime = doc.mimeType
                    val isMedia = mime.contains("video") ||
                            doc.fileName.endsWith(".mp4") ||
                            doc.fileName.endsWith(".mkv")
                    if (!isMedia) return null
                    VideoInfo(
                        msgId    = msg.id,
                        chatId   = msg.chatId,
                        fileId   = doc.document.id,
                        fileName = doc.fileName,
                        fileSize = doc.document.size,
                        mimeType = mime.ifEmpty { "video/mp4" },
                        caption  = c.caption.text,
                        date     = msg.date,
                    )
                }
                is TdApi.MessageVideo -> {
                    val vid = c.video
                    VideoInfo(
                        msgId    = msg.id,
                        chatId   = msg.chatId,
                        fileId   = vid.video.id,
                        fileName = vid.fileName,
                        fileSize = vid.video.size,
                        mimeType = vid.mimeType.ifEmpty { "video/mp4" },
                        caption  = c.caption.text,
                        date     = msg.date,
                    )
                }
                else -> null
            }
        } catch (e: Exception) { null }
    }

    // ── Auth Operations ───────────────────────────────────────────────────────

    fun requestQrLogin(onError: (String) -> Unit) {
        client?.send(TdApi.RequestQrCodeAuthentication(LongArray(0))) { result ->
            if (result is TdApi.Error) onError(result.message)
        }
    }

    fun sendPhone(phone: String, onError: (String) -> Unit) {
        if (_authState.value is AuthState.WaitQrCode) {
            // TDLib cannot transition from WaitOtherDeviceConfirmation to phone auth directly.
            // We must Close() the client → handleAuthState recreates it → wait for WaitPhone → send number.
            Log.i(TAG, "Canceling QR login to fallback to phone number...")
            val oldClient = client
            scope.launch {
                oldClient?.send(TdApi.Close()) {}
                // Wait until the NEW client reaches WaitPhone (initClient runs inside AuthorizationStateClosed)
                val reached = withTimeoutOrNull(8000) {
                    authState.first { it is AuthState.WaitPhone }
                }
                if (reached != null) {
                    // Use this.client — it's the FRESH instance created by initClient()
                    val freshClient = client
                    Log.i(TAG, "New client ready, sending phone number...")
                    freshClient?.send(TdApi.SetAuthenticationPhoneNumber(phone, null)) { result ->
                        if (result is TdApi.Error) onError(result.message)
                    }
                } else {
                    Log.e(TAG, "Timeout waiting for new client after QR cancel")
                    onError("No se pudo cancelar el inicio de sesión por QR. Reinicia la app.")
                }
            }
        } else {
            client?.send(TdApi.SetAuthenticationPhoneNumber(phone, null)) { result ->
                if (result is TdApi.Error) onError(result.message)
            }
        }
    }

    fun sendCode(code: String, onError: (String) -> Unit) {
        client?.send(TdApi.CheckAuthenticationCode(code)) { result ->
            if (result is TdApi.Error) onError(result.message)
        }
    }

    fun sendPassword(password: String, onError: (String) -> Unit) {
        client?.send(TdApi.CheckAuthenticationPassword(password)) { result ->
            if (result is TdApi.Error) onError(result.message)
        }
    }

    fun logout(onDone: () -> Unit) {
        client?.send(TdApi.LogOut()) { onDone() }
    }

    fun getMe(onResult: (TdApi.User?) -> Unit) {
        client?.send(TdApi.GetMe()) { result ->
            onResult(if (result is TdApi.User) result else null)
        }
    }

    // ── Bot Operations ────────────────────────────────────────────────────────

    /** Send /start <payload> to bot, wait for inline keyboard reply */
    suspend fun sendBotCommand(payload: String): SeasonResponse? = withContext(Dispatchers.IO) {
        val chatId = getBotChatId() ?: return@withContext null
        val deferred = CompletableDeferred<SeasonResponse?>()

        // Register a keyboard-reply listener BEFORE sending the command
        val listenerKey = "kbd_${System.currentTimeMillis()}"
        inlineKeyboardListeners[listenerKey] = InlineKeyboardListener(chatId, deferred)

        val text = TdApi.FormattedText("/start $payload", emptyArray())
        client?.send(TdApi.SendMessage(chatId, null, null, null, null,
            TdApi.InputMessageText(text, null, false)
        )) { sendResult ->
            if (sendResult is TdApi.Error) {
                inlineKeyboardListeners.remove(listenerKey)
                deferred.complete(null)
            }
        }

        // Wait up to 15s for the bot to reply with the keyboard
        val result = withTimeoutOrNull(15_000) { deferred.await() }
        inlineKeyboardListeners.remove(listenerKey)
        result
    }

    /**
     * Click an inline button (season) and wait for the bot to finish sending episode videos.
     * Web equivalent: clickInlineButton(msgId, data) + getVideoMessages()
     * Smart-wait: we stop 1.5s after the last video arrived, or after 12s max.
     */
    suspend fun clickInlineButton(chatId: Long, msgId: Long, dataBase64: String): List<VideoInfo> =
        withContext(Dispatchers.IO) {
            val dataBytes = android.util.Base64.decode(dataBase64, android.util.Base64.DEFAULT)
            val collectorKey = "click_${System.currentTimeMillis()}"
            val collector = MsgCollector(chatId = chatId, afterMsgId = msgId)
            msgCollectors[collectorKey] = collector

            // Send callback query — we don't require TDLib to confirm it with a bot answer.
            // videoclubpacobot often returns BOT_RESPONSE_TIMEOUT but still sends episode files.
            val callbackDeferred = CompletableDeferred<Unit>()
            client?.send(TdApi.GetCallbackQueryAnswer(
                chatId, msgId, TdApi.CallbackQueryPayloadData(dataBytes)
            )) { result ->
                if (result is TdApi.Error) {
                    Log.w(TAG, "GetCallbackQueryAnswer error (${result.code}): ${result.message} — still waiting for bot messages")
                } else {
                    Log.d(TAG, "GetCallbackQueryAnswer OK")
                }
                callbackDeferred.complete(Unit)
            }

            // Wait for TDLib to process the send (or time out after 8s) before starting collector loop
            withTimeoutOrNull(8_000) { callbackDeferred.await() }

            // Smart wait: stop 1.5s after last video OR after 12s total (web uses 3s fixed)
            val silenceMs = 1500L
            val maxWait   = 12_000L
            val start     = System.currentTimeMillis()
            while (System.currentTimeMillis() - start < maxWait) {
                delay(200)
                val since = System.currentTimeMillis() - collector.lastReceived
                val hasVideos = synchronized(collector.videos) { collector.videos.isNotEmpty() }
                if (since >= silenceMs && hasVideos) break
            }
            msgCollectors.remove(collectorKey)
            synchronized(collector.videos) { collector.videos.toList() }
        }

    /**
     * Search for a movie using /peli command — exact equivalent of web's searchMovieByPayload.
     * The bot sends video files directly (no inline keyboard needed).
     */
    suspend fun searchMovieByPayload(searchTitle: String): List<VideoInfo> =
        withContext(Dispatchers.IO) {
            val chatId = getBotChatId() ?: return@withContext emptyList()

            // Get the last message id before sending so we only collect AFTER our command
            val anchorDeferred = CompletableDeferred<Long>()
            client?.send(TdApi.GetChatHistory(chatId, 0L, 0, 1, false)) { hist ->
                val lastId = if (hist is TdApi.Messages && hist.messages.isNotEmpty())
                    hist.messages[0].id else 0L
                anchorDeferred.complete(lastId)
            }
            val anchorMsgId = anchorDeferred.await()

            // Register collector BEFORE sending command
            val collectorKey = "peli_${System.currentTimeMillis()}"
            val collector = MsgCollector(chatId = chatId, afterMsgId = anchorMsgId)
            msgCollectors[collectorKey] = collector

            // Send /peli <title>
            val text = TdApi.FormattedText("/peli $searchTitle", emptyArray())
            val sendDeferred = CompletableDeferred<Boolean>()
            client?.send(TdApi.SendMessage(chatId, null, null, null, null,
                TdApi.InputMessageText(text, null, false)
            )) { result -> sendDeferred.complete(result !is TdApi.Error) }

            if (!sendDeferred.await()) {
                msgCollectors.remove(collectorKey)
                return@withContext emptyList()
            }

            // Wait 4s + smart silence (same logic as web: "await new Promise(r => setTimeout(r, 4000))")
            delay(4000)
            val silenceMs = 1500L
            val maxExtra  = 8_000L
            val start     = System.currentTimeMillis()
            while (System.currentTimeMillis() - start < maxExtra) {
                delay(200)
                val since = System.currentTimeMillis() - collector.lastReceived
                val hasVideos = synchronized(collector.videos) { collector.videos.isNotEmpty() }
                if (since >= silenceMs && hasVideos) break
                if (since >= silenceMs && !hasVideos && System.currentTimeMillis() - start > 3_000) break
            }

            msgCollectors.remove(collectorKey)
            synchronized(collector.videos) { collector.videos.toList() }
        }

    // ── File / Streaming ──────────────────────────────────────────────────────

    data class FileState(
        val path: String,
        val downloadedPrefixSize: Long,
        val downloadedSize: Long,
        val expectedSize: Long,
        val isCompleted: Boolean
    )

    private val fileStates = ConcurrentHashMap<Int, kotlinx.coroutines.flow.MutableStateFlow<FileState?>>()

    fun getFileStateFlow(fileId: Int): kotlinx.coroutines.flow.StateFlow<FileState?> {
        return fileStates.getOrPut(fileId) { kotlinx.coroutines.flow.MutableStateFlow(null) }
    }

    /**
     * Start a TDLib download and return the local file path as soon as TDLib
     * assigns it (i.e. when the download STARTS, not when it completes).
     * Used by the streaming player — ExoPlayer can start reading while TDLib writes.
     */
    suspend fun startDownloadReturnPath(fileId: Int, priority: Int = 32): String? =
        withContext(Dispatchers.IO) {
            Log.d(TAG, "startDownloadReturnPath fileId=$fileId priority=$priority")
            val deferred = filePathEmitters.getOrPut(fileId) { CompletableDeferred() }

            // Only download the first 1MB to get the path assigned quickly.
            // DO NOT use limit=0 (entire file) — it steals bandwidth from MOOV pre-fetch.
            // All subsequent data fetching happens on-demand via downloadRangeAndRead.
            client?.send(TdApi.DownloadFile(fileId, priority, 0, 1024L * 1024, false)) { result ->
                Log.d(TAG, "DownloadFile callback: ${result.javaClass.simpleName}")
                if (result is TdApi.File) {
                    val p = result.local?.path
                    if (!p.isNullOrEmpty()) {
                        deferred.complete(p)
                    }
                } else if (result is TdApi.Error) {
                    Log.e(TAG, "DownloadFile error: ${result.code} ${result.message}")
                }
            }

            // Wait up to 25 s for TDLib to at least assign a path
            val path = withTimeoutOrNull(25_000) { deferred.await() }
            Log.d(TAG, "startDownloadReturnPath result: $path")
            path
        }


    /**
     * Download a file and return its local path ONLY when the download is complete.
     * Legacy / fallback; prefer startDownloadReturnPath for streaming.
     */
    suspend fun downloadAndGetPath(fileId: Int, priority: Int = 32): String =
        withContext(Dispatchers.IO) {
            val deferred = filePathEmitters.getOrPut(fileId) { CompletableDeferred() }
            client?.send(TdApi.DownloadFile(fileId, priority, 0, 0, false)) { result ->
                if (result is TdApi.File) {
                    val p = result.local?.path
                    if (!p.isNullOrEmpty()) deferred.complete(p)
                }
            }
            withTimeoutOrNull(120_000) { deferred.await() }
                ?: throw Exception("TDLib download timeout for fileId=$fileId")
        }

    /** Hint TDLib to prioritize bytes starting at offset (for seek support) */
    fun hintDownloadOffset(fileId: Int, offset: Long, limit: Long = 2L * 1024 * 1024) {
        // Specify a concrete limit so TDLib knows exactly which range to prioritize
        // instead of "everything from offset to end" (limit=0) which is too vague for large files
        client?.send(TdApi.DownloadFile(fileId, 32, offset, limit, false)) {}
    }

    /** Synchronously fetch a file chunk directly from TDLib's internal manager. Returns null if not downloaded yet. */
    fun readFilePartSync(fileId: Int, offset: Long, count: Long): ByteArray? {
        val latch = java.util.concurrent.CountDownLatch(1)
        var chunk: ByteArray? = null

        client?.send(TdApi.ReadFilePart(fileId, offset, count)) { result ->
            if (result is TdApi.Data) {
                if (result.data.isNotEmpty()) {
                    chunk = result.data
                }
            }
            latch.countDown()
        } ?: return null

        latch.await(3_000, java.util.concurrent.TimeUnit.MILLISECONDS)
        return chunk
    }

    /**
     * Download a specific range from Telegram's CDN and read it. Uses DownloadFile(synchronous=true)
     * which means TDLib won't invoke the callback until the bytes are fully downloaded.
     * This eliminates the poll-sleep-retry loop for un-downloaded bytes.
     * Returns the bytes, or null on timeout (30s).
     */
    fun downloadRangeAndRead(fileId: Int, offset: Long, count: Long): ByteArray? {
        // Step 1: Tell TDLib to download this exact range. synchronous=true blocks until ready.
        val downloadLatch = java.util.concurrent.CountDownLatch(1)
        client?.send(TdApi.DownloadFile(fileId, 32, offset, count, true)) { result ->
            downloadLatch.countDown()
        } ?: return null

        // Wait up to 30s for TDLib to fetch from Telegram CDN (large file seek can be slow)
        if (!downloadLatch.await(30_000, java.util.concurrent.TimeUnit.MILLISECONDS)) {
            Log.w(TAG, "downloadRangeAndRead TIMEOUT offset=$offset count=$count")
            return null
        }

        // Step 2: Bytes are guaranteed available. Read them.
        return readFilePartSync(fileId, offset, count)
    }

    // ── Helpers ───────────────────────────────────────────────────────────────

    /**
     * Fetch up to [limit] video messages from the bot chat newer than [minId].
     * Used by AndroidBridge.getVideoMessages as a reliable fallback via TDLib GetChatHistory.
     */
    suspend fun getVideoMessagesHistory(limit: Int = 50, minId: Long = 0L): List<VideoInfo> =
        withContext(Dispatchers.IO) {
            val chatId = getBotChatId() ?: return@withContext emptyList()
            val collected = mutableListOf<VideoInfo>()
            val deferred = CompletableDeferred<Unit>()
            client?.send(TdApi.GetChatHistory(chatId, 0L, 0, limit.coerceAtLeast(10), false)) { result ->
                if (result is TdApi.Messages) {
                    for (msg in result.messages) {
                        if (msg.id <= minId) continue
                        val info = extractVideoInfo(msg) ?: continue
                        collected.add(info)
                    }
                }
                deferred.complete(Unit)
            }
            withTimeoutOrNull(10_000) { deferred.await() }
            collected.sortedBy { it.msgId }
        }

    private suspend fun getBotChatId(): Long? =
        suspendCancellableCoroutine { cont ->
            client?.send(TdApi.SearchPublicChat(BOT_USERNAME)) { result ->
                cont.resume(if (result is TdApi.Chat) result.id else null) {}
            }
        }

    /** Public version for AndroidBridge (same logic, exposed outside package) */
    suspend fun getBotChatIdPublic(): Long? = getBotChatId()

    fun getClient(): Client? = client

    /**
     * Stop downloading and forcefully delete the file chunk from TDLib cache to free TV storage.
     */
    fun cancelAndDeleteVideo(fileId: Int) {
        Log.i(TAG, "🧹 Cleaning up TDLib cache for fileId: $fileId")
        client?.send(TdApi.CancelDownloadFile(fileId, false)) {}
        client?.send(TdApi.DeleteFile(fileId)) {}
    }
}
