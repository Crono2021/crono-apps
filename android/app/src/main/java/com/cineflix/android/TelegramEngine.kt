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
            is TdApi.AuthorizationStateWaitCode        -> _authState.value = AuthState.WaitCode
            is TdApi.AuthorizationStateWaitPassword    -> _authState.value = AuthState.WaitPassword
            is TdApi.AuthorizationStateReady           -> _authState.value = AuthState.Ready
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
        val local = file.local ?: return
        val path = local.path ?: return
        if (path.isNotEmpty()) {
            filePathEmitters[file.id]?.complete(path)
        }
    }

    private fun handleNewMessage(msg: TdApi.Message) {
        val content = msg.content
        val isVideo = content is TdApi.MessageDocument || content is TdApi.MessageVideo

        // Notify active collectors
        for ((_, collector) in msgCollectors) {
            if (msg.chatId == collector.chatId && msg.id > collector.afterMsgId && isVideo) {
                val info = extractVideoInfo(msg) ?: continue
                synchronized(collector.videos) { collector.videos.add(info) }
                collector.lastReceived = System.currentTimeMillis()
            }
        }

        // Pre-cache fileId + start download for instant playback
        if (isVideo) {
            val info = extractVideoInfo(msg) ?: return
            val cacheKey = "${msg.chatId}:${msg.id}"
            fileIdCache[cacheKey] = Pair(info.fileId, info.mimeType)
            // Pre-warm download (full file, low priority 1)
            client?.send(TdApi.DownloadFile(info.fileId, 1, 0, 0, false)) {}
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

    fun sendPhone(phone: String, onError: (String) -> Unit) {
        client?.send(TdApi.SetAuthenticationPhoneNumber(phone, null)) { result ->
            if (result is TdApi.Error) onError(result.message)
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

        val text = TdApi.FormattedText("/start $payload", emptyArray())
        client?.send(TdApi.SendMessage(chatId, null, null, null, null,
            TdApi.InputMessageText(text, null, false)
        )) { sendResult ->
            if (sendResult is TdApi.Error) { deferred.complete(null); return@send }
            scope.launch {
                delay(2500)
                client?.send(TdApi.GetChatHistory(chatId, 0L, 0, 5, false)) { hist ->
                    if (hist !is TdApi.Messages) { deferred.complete(null); return@send }
                    for (msg in hist.messages) {
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
                            val bodyText = (msg.content as? TdApi.MessageText)?.text?.text ?: ""
                            deferred.complete(SeasonResponse(msg.id, chatId, bodyText, buttons))
                            return@send
                        }
                    }
                    deferred.complete(SeasonResponse(0L, chatId, "", emptyList()))
                }
            }
        }
        deferred.await()
    }

    /** Click an inline button and wait for the bot to finish sending episode videos */
    suspend fun clickInlineButton(chatId: Long, msgId: Long, dataBase64: String): List<VideoInfo> =
        withContext(Dispatchers.IO) {
            val dataBytes = android.util.Base64.decode(dataBase64, android.util.Base64.DEFAULT)
            val collectorKey = "click_${System.currentTimeMillis()}"
            val collector = MsgCollector(chatId = chatId, afterMsgId = msgId)
            msgCollectors[collectorKey] = collector

            val callbackDeferred = CompletableDeferred<Boolean>()
            client?.send(TdApi.GetCallbackQueryAnswer(
                chatId, msgId, TdApi.CallbackQueryPayloadData(dataBytes)
            )) { result ->
                callbackDeferred.complete(result !is TdApi.Error)
            }

            val ok = callbackDeferred.await()
            if (!ok) { msgCollectors.remove(collectorKey); return@withContext emptyList() }

            // Smart wait: 1.5s silence after last message, max 10s
            val silenceMs = 1500L
            val maxWait   = 10_000L
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

    // ── File / Streaming ──────────────────────────────────────────────────────

    /**
     * Download a file and return its local path when ready.
     * Uses TVGram approach: TDLib writes to disk, ExoPlayer reads file:// directly.
     */
    suspend fun downloadAndGetPath(fileId: Int, priority: Int = 32): String =
        withContext(Dispatchers.IO) {
            // Register deferred BEFORE calling DownloadFile to avoid race
            val deferred = filePathEmitters.getOrPut(fileId) { CompletableDeferred() }

            // Request full file download (limit=0 = no limit)
            client?.send(TdApi.DownloadFile(fileId, priority, 0, 0, false)) { result ->
                // If already downloaded, the result IS the file with local path
                if (result is TdApi.File) {
                    val p = result.local?.path
                    if (!p.isNullOrEmpty()) deferred.complete(p)
                }
            }

            withTimeoutOrNull(120_000) { deferred.await() }
                ?: throw Exception("TDLib download timeout for fileId=$fileId")
        }

    /** Hint TDLib to prioritize bytes starting at offset (for seek support) */
    fun hintDownloadOffset(fileId: Int, offset: Long) {
        client?.send(TdApi.DownloadFile(fileId, 32, offset, 0, false)) {}
    }

    // ── Helpers ───────────────────────────────────────────────────────────────

    private suspend fun getBotChatId(): Long? =
        suspendCancellableCoroutine { cont ->
            client?.send(TdApi.SearchPublicChat(BOT_USERNAME)) { result ->
                cont.resume(if (result is TdApi.Chat) result.id else null) {}
            }
        }

    fun getClient(): Client? = client
}
