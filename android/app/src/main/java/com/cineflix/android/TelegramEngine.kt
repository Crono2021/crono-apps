package com.cineflix.android

import android.app.UiModeManager
import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.provider.Settings
import android.util.Log
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.sync.withLock
import org.drinkless.tdlib.Client
import org.drinkless.tdlib.TdApi
import java.io.File
import java.util.Locale
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

        private val UPPERCASE_BRANDS = setOf(
            "LG", "TCL", "HTC", "ZTE", "OPPO", "VIVO", "ASUS", "HONOR", "POCO", "RCA", "JVC"
        )
        private val MARKETING_MODEL_KEYWORDS_REGEX = Regex(
            "\\b(?:Galaxy|Redmi|POCO|Pixel|Moto|Motorola|OnePlus|Realme|Reno\\d*|Find\\s*X|Xperia|Zenfone\\d*|ROG\\s*Phone|Nothing\\s*Phone|Honor|Mate\\s*\\d+|Pura\\s*\\d+|Nova\\s*\\d+|Xiaomi\\s*\\d+|Mi\\s*\\d+|Pad\\s*\\d+|Tab\\s*[AS]\\d+|Chromecast|Shield|Bravia|Fire\\s*TV)",
            RegexOption.IGNORE_CASE
        )
        private val IGNORED_GENERIC_DEVICE_NAMES = setOf(
            "android", "android tv", "localhost", "unknown", "phone", "tablet", "device"
        )

        @Volatile
        private var INSTANCE: TelegramEngine? = null

        fun getInstance(context: Context): TelegramEngine =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: TelegramEngine(context.applicationContext).also { INSTANCE = it }
            }

        fun resolveDeviceModel(context: Context): String {
            val isTv = com.cineflix.android.util.StorageAndRamHygiene.isTelevision(context)
            val deviceName = try {
                Settings.Global.getString(context.contentResolver, Settings.Global.DEVICE_NAME)
            } catch (_: Throwable) {
                null
            }
            return formatRealAndroidDeviceModel(
                manufacturerRaw = Build.MANUFACTURER,
                modelRaw = Build.MODEL,
                deviceNameRaw = deviceName,
                isTelevision = isTv
            )
        }

        fun resolveSystemVersion(): String {
            return formatRealAndroidSystemVersion(Build.VERSION.RELEASE, Build.VERSION.SDK_INT)
        }

        fun resolveSystemLanguageCode(): String {
            val lang = try {
                Locale.getDefault().language.lowercase(Locale.ROOT).trim()
            } catch (_: Throwable) {
                "es"
            }
            return if (lang.length in 2..3) lang else "es"
        }

        fun formatRealAndroidDeviceModel(
            manufacturerRaw: String?,
            modelRaw: String?,
            deviceNameRaw: String?,
            isTelevision: Boolean = false
        ): String {
            val brand = formatManufacturer(manufacturerRaw)
            val model = sanitizeIdentityToken(modelRaw)
            val friendly = sanitizeIdentityToken(deviceNameRaw)

            val hardwareModel = when {
                brand.equals("Amazon", ignoreCase = true) && model.startsWith("AFT", ignoreCase = true) ->
                    "Amazon Fire TV ($model)"
                model.isEmpty() ->
                    brand.ifEmpty { if (isTelevision) "Android TV" else "Android" }
                brand.isNotEmpty() && !model.startsWith(brand, ignoreCase = true) ->
                    "$brand $model"
                else -> model
            }

            val friendlyLower = friendly.lowercase(Locale.ROOT)
            val hasUsefulFriendlyName = friendly.isNotEmpty() &&
                friendlyLower !in IGNORED_GENERIC_DEVICE_NAMES &&
                !friendly.equals(model, ignoreCase = true) &&
                !friendly.equals(hardwareModel, ignoreCase = true)

            val startsWithBrandName = brand.isNotEmpty() && friendly.startsWith("$brand ", ignoreCase = true)
            val combined = if (!hasUsefulFriendlyName) {
                hardwareModel
            } else if (startsWithBrandName || MARKETING_MODEL_KEYWORDS_REGEX.containsMatchIn(friendly)) {
                if (brand.isNotEmpty() && !friendly.startsWith(brand, ignoreCase = true)) {
                    "$brand $friendly"
                } else {
                    friendly
                }
            } else if (!hardwareModel.contains(friendly, ignoreCase = true)) {
                "$hardwareModel ($friendly)"
            } else {
                hardwareModel
            }

            return combined.take(64).trim().ifEmpty { if (isTelevision) "Android TV" else "Android" }
        }

        fun formatRealAndroidSystemVersion(releaseRaw: String?, sdkInt: Int): String {
            val rel = sanitizeIdentityToken(releaseRaw)
            return when {
                rel.isEmpty() -> if (sdkInt > 0) "Android (SDK $sdkInt)" else "Android"
                rel.startsWith("Android", ignoreCase = true) -> rel.take(32).trim()
                else -> "Android $rel".take(32).trim()
            }
        }

        private fun formatManufacturer(raw: String?): String {
            val clean = sanitizeIdentityToken(raw)
            if (clean.isEmpty()) return ""
            val upper = clean.uppercase(Locale.ROOT)
            if (upper in UPPERCASE_BRANDS) return upper
            return clean.replaceFirstChar { ch ->
                if (ch.isLowerCase()) ch.titlecase(Locale.ROOT) else ch.toString()
            }
        }

        private fun sanitizeIdentityToken(raw: String?): String {
            if (raw.isNullOrBlank()) return ""
            return raw
                .replace(Regex("[\\r\\n\\t\\p{Cntrl}]+"), " ")
                .replace(Regex("\\s+"), " ")
                .trim()
        }

        internal fun normalizePhoneInput(raw: String?): String {
            if (raw.isNullOrBlank()) return ""
            var cleaned = raw
                .replace(Regex("[\\u200B-\\u200F\\u202A-\\u202E\\u2066-\\u2069]"), "")
                .replace(Regex("[\\s\\-().]+"), "")
                .trim()
            if (cleaned.startsWith("+34+")) {
                cleaned = cleaned.substring(3)
            }
            if (cleaned.startsWith("+3400") && cleaned.length >= 12) {
                cleaned = "+" + cleaned.substring(5)
            }
            if (cleaned.startsWith("00")) {
                cleaned = "+" + cleaned.substring(2)
            }
            val hasPlus = cleaned.startsWith("+")
            val digits = cleaned.filter { it.isDigit() }
            if (digits.length !in 7..15) return ""
            // User typed "34612345678" after prefilled "+34" -> "+3434612345678" (impossible in Spain's closed 9-digit plan)
            if (Regex("^3434[6789]\\d{8}$").matches(digits)) {
                return "+" + digits.substring(2)
            }
            // Common Spanish TV input case: user cleared "+34" and typed 9-digit mobile (6xx/7xx)
            if (!hasPlus && digits.length == 9 && (digits.startsWith("6") || digits.startsWith("7"))) {
                return "+34$digits"
            }
            return "+$digits"
        }

        internal const val MAX_SET_PARAMS_RECOVERY_ATTEMPTS = 2
        private const val PREF_SESSION_AUTHENTICATED = "tdlib_session_authenticated"

        internal fun sanitizeVerificationCode(raw: String?): String {
            if (raw.isNullOrBlank()) return ""
            val clean = raw
                .replace(Regex("[\\u200B-\\u200F\\u202A-\\u202E\\u2066-\\u2069]+"), "")
                .trim()
            if (clean.isEmpty()) return ""
            // Preserve single spaces between alphabetic words for AuthenticationCodeTypeSmsPhrase
            if (Regex("[A-Za-z\\u00C0-\\u024F]+\\s+[A-Za-z\\u00C0-\\u024F]+").containsMatchIn(clean)) {
                return clean.replace(Regex("\\s+"), " ").trim()
            }
            return clean.replace(Regex("[\\s\\-]+"), "").trim()
        }

        internal fun isFirebaseAuthCodeType(type: TdApi.AuthenticationCodeType?): Boolean {
            return type is TdApi.AuthenticationCodeTypeFirebaseAndroid ||
                type is TdApi.AuthenticationCodeTypeFirebaseIos
        }

        internal sealed class CodeInfoDecision {
            data class TryFirebaseFallback(val normalizedPhone: String) : CodeInfoDecision()
            data class RejectUnsupportedDelivery(val reason: String, val normalizedPhone: String) : CodeInfoDecision()
            data class AcceptWaitCode(val waitCode: AuthState.WaitCode, val normalizedPhone: String) : CodeInfoDecision()
        }

        internal fun classifyAuthenticationCodeInfo(
            codeInfo: TdApi.AuthenticationCodeInfo?,
            firebaseFallbackAlreadyAttempted: Boolean
        ): CodeInfoDecision {
            val normalizedPhone = normalizePhoneInput(codeInfo?.phoneNumber)
            val currentType = codeInfo?.type
            val nextType = codeInfo?.nextType
            val hasUsableNextType = nextType != null && !isFirebaseAuthCodeType(nextType)

            if (isFirebaseAuthCodeType(currentType)) {
                return if (!firebaseFallbackAlreadyAttempted && hasUsableNextType) {
                    CodeInfoDecision.TryFirebaseFallback(normalizedPhone)
                } else {
                    CodeInfoDecision.RejectUnsupportedDelivery(
                        reason = "SEND_CODE_UNAVAILABLE: Telegram requiere vincular escaneando el Código QR del panel izquierdo desde tu móvil (Ajustes > Dispositivos > Vincular dispositivo).",
                        normalizedPhone = normalizedPhone
                    )
                }
            }

            val (deliveryType, codeLength, deliveryHint) = when (currentType) {
                is TdApi.AuthenticationCodeTypeTelegramMessage ->
                    Triple("app", currentType.length.coerceAtLeast(0), "")
                is TdApi.AuthenticationCodeTypeSms ->
                    Triple("sms", currentType.length.coerceAtLeast(0), "")
                is TdApi.AuthenticationCodeTypeSmsWord ->
                    Triple("sms_word", 0, currentType.firstLetter?.trim().orEmpty())
                is TdApi.AuthenticationCodeTypeSmsPhrase ->
                    Triple("sms_phrase", 0, currentType.firstWord?.trim().orEmpty())
                is TdApi.AuthenticationCodeTypeCall ->
                    Triple("call", currentType.length.coerceAtLeast(0), "")
                is TdApi.AuthenticationCodeTypeMissedCall ->
                    Triple("missed_call", currentType.length.coerceAtLeast(0), currentType.phoneNumberPrefix?.trim().orEmpty())
                is TdApi.AuthenticationCodeTypeFlashCall ->
                    Triple("flash_call", 0, currentType.pattern?.trim().orEmpty())
                is TdApi.AuthenticationCodeTypeFragment ->
                    Triple("fragment", currentType.length.coerceAtLeast(0), currentType.url?.trim().orEmpty())
                else ->
                    Triple("app", 5, "")
            }

            return CodeInfoDecision.AcceptWaitCode(
                waitCode = AuthState.WaitCode(
                    deliveryType = deliveryType,
                    codeLength = codeLength,
                    deliveryHint = deliveryHint,
                    hasNextType = hasUsableNextType
                ),
                normalizedPhone = normalizedPhone
            )
        }

        internal fun buildSafePhoneAuthSettings(): TdApi.PhoneNumberAuthenticationSettings {
            return TdApi.PhoneNumberAuthenticationSettings(
                /* allowFlashCall = */ false,
                /* allowMissedCall = */ false,
                /* isCurrentPhoneNumber = */ false,
                /* hasUnknownPhoneNumber = */ false,
                /* allowSmsRetrieverApi = */ false,
                /* firebaseAuthenticationSettings = */ null,
                /* authenticationTokens = */ emptyArray()
            )
        }

        internal fun hasProtectedAuthenticatedSession(
            dbDir: File,
            isMarkedAuthenticated: Boolean,
            savedUserPhone: String?
        ): Boolean {
            if (!isMarkedAuthenticated && savedUserPhone.isNullOrBlank()) return false
            if (!dbDir.exists() || !dbDir.isDirectory) return false
            return dbDir.listFiles()?.any { f ->
                f.isFile && f.length() > 0L && f.name.lowercase(Locale.ROOT).startsWith("td.binlog")
            } == true
        }

        internal fun isTransientAuthQueryConflict(errorMsg: String?): Boolean {
            if (errorMsg.isNullOrBlank()) return false
            val lower = errorMsg.lowercase(Locale.ROOT)
            return lower.contains("another authorization query has started") ||
                lower.contains("unexpected") ||
                lower.contains("auth_restart")
        }

        internal fun isFloodWaitError(errorMsg: String?): Boolean {
            if (errorMsg.isNullOrBlank()) return false
            val lower = errorMsg.lowercase(Locale.ROOT)
            return lower.contains("flood_wait") ||
                lower.contains("phone_password_flood") ||
                lower.contains("too many requests") ||
                lower.contains("wait of ")
        }

        internal fun nextAlternateTdlibDbDirName(currentDirName: String?): String {
            return if (currentDirName == "tdlib_data_alt") "tdlib_data" else "tdlib_data_alt"
        }
    }

    private data class SetParamsFailure(val gen: Int, val code: Int, val message: String)

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private var client: Client? = null
    private val authMutex = kotlinx.coroutines.sync.Mutex()
    private val clientGeneration = java.util.concurrent.atomic.AtomicInteger(0)
    private val setParamsRecoveryAttempts = java.util.concurrent.atomic.AtomicInteger(0)
    private val setParamsFailureFlow = MutableStateFlow<SetParamsFailure?>(null)
    private val firebaseFallbackPendingGen = java.util.concurrent.atomic.AtomicInteger(0)
    private val authStateEventSeq = java.util.concurrent.atomic.AtomicLong(0L)
    private val closedSignals = ConcurrentHashMap<Int, CompletableDeferred<Unit>>()
    @Volatile private var activeDbDirName: String = run {
        try {
            val saved = context.getSharedPreferences("CineflixPrefs", Context.MODE_PRIVATE)
                .getString("tdlib_active_db_dir", "tdlib_data")
                ?.trim()
                .orEmpty()
            if (saved == "tdlib_data" || saved == "tdlib_data_alt") saved else "tdlib_data"
        } catch (_: Throwable) {
            "tdlib_data"
        }
    }
    @Volatile private var lastSubmittedPhone: String = ""
    @Volatile private var lastWaitCodeHasNextType: Boolean = false
    @Volatile private var firebaseFallbackAttempted: Boolean = false
    @Volatile private var lastCodeDeliveryState: AuthState.WaitCode = AuthState.WaitCode()
    @Volatile private var lastPasswordHint: String = ""

    fun getLastSubmittedPhone(): String = lastSubmittedPhone
    fun getLastPasswordHint(): String = lastPasswordHint

    fun getCodeDeliveryInfoJson(): String {
        val st = (_authState.value as? AuthState.WaitCode) ?: lastCodeDeliveryState
        return org.json.JSONObject().apply {
            put("deliveryType", st.deliveryType)
            put("codeLength", st.codeLength)
            put("deliveryHint", st.deliveryHint)
            put("hasNextType", st.hasNextType)
        }.toString()
    }

    // ── Auth State ────────────────────────────────────────────────────────────
    sealed class AuthState {
        object Unknown : AuthState()
        object WaitPhone : AuthState()
        data class WaitCode(
            val deliveryType: String = "app",
            val codeLength: Int = 5,
            val deliveryHint: String = "",
            val hasNextType: Boolean = false
        ) : AuthState()
        data class WaitEmailCode(val emailPattern: String) : AuthState()
        object WaitPassword : AuthState()
        data class WaitQrCode(val link: String) : AuthState()
        data class AuthRejected(val reason: String) : AuthState()
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
    val fileSizeCache = ConcurrentHashMap<String, Long>()
    private val botChatMutex = kotlinx.coroutines.sync.Mutex()

    // Per-fileId lock to serialize concurrent DownloadFile range requests and avoid TDLib Error 200
    private val downloadLocks = ConcurrentHashMap<Int, Any>()
    private val streamingSessionGeneration = java.util.concurrent.atomic.AtomicLong(0L)
    private val activeStreamOwners = ConcurrentHashMap.newKeySet<String>()

    fun onStreamOwnerStarted(ownerToken: String) {
        if (ownerToken.isNotEmpty()) {
            activeStreamOwners.add(ownerToken)
        }
        streamingSessionGeneration.incrementAndGet()
    }

    fun onStreamOwnerStopped(ownerToken: String) {
        if (ownerToken.isNotEmpty()) {
            activeStreamOwners.remove(ownerToken)
        }
    }

    fun hasActiveStreamOwners(): Boolean = activeStreamOwners.isNotEmpty()

    private val boundedVideoCache = BoundedVideoCache(
        backend = object : BoundedVideoCache.Backend {
            override fun purge(fileId: Int): Boolean {
                val started = android.os.SystemClock.elapsedRealtime()
                val ok = cancelAndDeleteVideoSync(fileId)
                val duration = android.os.SystemClock.elapsedRealtime() - started
                logStreamStorage("purge fileId=$fileId ok=$ok durationMs=$duration")
                com.cineflix.android.util.ErrorLogCollector.log(TAG, "Cache purge fileId=$fileId ok=$ok in ${duration}ms")
                return ok
            }
            override fun cached(fileId: Int, offset: Long, count: Long) = readFilePartSync(fileId, offset, count)
            override fun download(fileId: Int, offset: Long, count: Long) = downloadRangeAndRead(fileId, offset, count)
        },
        limitBytes = run {
            val isTv = com.cineflix.android.util.StorageAndRamHygiene.isTelevision(context)
            val usable = try { context.cacheDir.usableSpace } catch (_: Throwable) { 0L }
            when {
                isTv || usable < 2_000_000_000L -> 32L * 1024L * 1024L
                usable < 4_000_000_000L -> 48L * 1024L * 1024L
                else -> 64L * 1024L * 1024L
            }
        }
    )

    private fun cacheMessageFileMeta(cacheKey: String, fileId: Int, mimeType: String, fileSize: Long) {
        if (fileIdCache.size >= 300) {
            val iterator = fileIdCache.keys.iterator()
            var removed = 0
            while (iterator.hasNext() && removed < 100) {
                val k = iterator.next()
                fileIdCache.remove(k)
                fileSizeCache.remove(k)
                removed++
            }
        }
        fileIdCache[cacheKey] = Pair(fileId, mimeType)
        if (fileSize > 0L) {
            fileSizeCache[cacheKey] = fileSize
        }
    }

    fun readBoundedVideoRange(
        fileId: Int,
        offset: Long,
        count: Long,
        isCancelled: (() -> Boolean)? = null
    ): ByteArray? = boundedVideoCache.read(fileId, offset, count, isCancelled)

    /** Allocated blocks, not apparent length: TDLib can create sparse multi-GB files. */
    fun logStreamStorage(event: String) {
        scope.launch(Dispatchers.IO) {
            try {
                val root = File(context.cacheDir, "tdlib_files")
                var allocated = 0L
                var logical = 0L
                var files = 0
                root.walkTopDown().filter { it.isFile }.forEach {
                    val stat = android.system.Os.stat(it.absolutePath)
                    allocated += stat.st_blocks * 512L
                    logical += stat.st_size
                    files++
                }
                Log.i("StreamStorage", "$event cacheAllocatedBytes=$allocated cacheLogicalBytes=$logical files=$files freeBytes=${context.cacheDir.usableSpace}")
                com.cineflix.android.util.ErrorLogCollector.log("StreamStorage", "$event alloc=${allocated / (1024 * 1024)}MB free=${context.cacheDir.usableSpace / (1024 * 1024)}MB")
            } catch (e: Exception) {
                Log.w("StreamStorage", "Storage measurement failed: ${e.message}")
            }
        }
    }

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
        cleanInactiveTdlibDbDirs()
        ensureDirectoriesExist()
        initClient()
    }

    private fun persistActiveDbDirName(name: String) {
        activeDbDirName = name
        runCatching {
            context.getSharedPreferences("CineflixPrefs", Context.MODE_PRIVATE)
                .edit()
                .putString("tdlib_active_db_dir", name)
                .apply()
        }
    }

    private fun persistSessionAuthenticatedFlag(authenticated: Boolean) {
        runCatching {
            val prefs = context.getSharedPreferences("CineflixPrefs", Context.MODE_PRIVATE)
            val editor = prefs.edit().putBoolean(PREF_SESSION_AUTHENTICATED, authenticated)
            if (!authenticated && prefs.getString("tg_session", "").isNullOrBlank()) {
                editor.remove("user_phone")
            }
            editor.apply()
        }
    }

    private fun isDbDirProtectedByAuthenticatedSession(dbDir: File): Boolean {
        val prefs = runCatching {
            context.getSharedPreferences("CineflixPrefs", Context.MODE_PRIVATE)
        }.getOrNull()
        val isMarkedAuth = prefs?.getBoolean(PREF_SESSION_AUTHENTICATED, false) == true
        val savedPhone = prefs?.getString("user_phone", null)
        return hasProtectedAuthenticatedSession(dbDir, isMarkedAuth, savedPhone)
    }

    private fun cleanInactiveTdlibDbDirs() {
        runCatching {
            val inactive = nextAlternateTdlibDbDirName(activeDbDirName)
            val staleDir = File(context.filesDir, inactive)
            if (staleDir.exists() && !isDbDirProtectedByAuthenticatedSession(staleDir)) {
                staleDir.deleteRecursively()
            }
        }
    }

    /**
     * Ensure TDLib database and cache directory hierarchy strictly exists on disk.
     * Prevents native C++ POSIX ENOENT (errno: 2) errors when TDLib creates temp files or chunks.
     */
    fun ensureDirectoriesExist() {
        try {
            val dbDir = File(context.filesDir, activeDbDirName)
            if (!dbDir.exists()) dbDir.mkdirs()
            dbDir.setReadable(true, false)
            dbDir.setWritable(true, false)
            dbDir.setExecutable(true, false)

            val cacheBase = File(context.cacheDir, "tdlib_files")
            if (!cacheBase.exists()) cacheBase.mkdirs()
            cacheBase.setReadable(true, false)
            cacheBase.setWritable(true, false)
            cacheBase.setExecutable(true, false)

            val subdirs = listOf("temp", "videos", "documents", "thumbnails", "profile_photos")
            for (sub in subdirs) {
                val d = File(cacheBase, sub)
                if (!d.exists()) d.mkdirs()
                d.setReadable(true, false)
                d.setWritable(true, false)
                d.setExecutable(true, false)
            }
        } catch (e: Exception) {
            Log.e(TAG, "❌ Error ensuring TDLib directory structure: ${e.message}", e)
        }
    }

    private fun initClient() {
        val gen = clientGeneration.incrementAndGet()
        setParamsFailureFlow.value = null
        firebaseFallbackPendingGen.set(0)
        closedSignals[gen] = CompletableDeferred()
        Log.i(TAG, "Initializing TDLib client (gen=$gen, db=$activeDbDirName)...")
        try {
            Client.execute(TdApi.SetLogVerbosityLevel(0))
            Client.execute(TdApi.SetLogStream(TdApi.LogStreamEmpty()))
        } catch (_: Exception) {}
        com.cineflix.android.util.StorageAndRamHygiene.cleanTdlibLogFiles(context.filesDir)
        client = Client.create(
            { result ->
                if (result is TdApi.UpdateAuthorizationState && result.authorizationState is TdApi.AuthorizationStateClosed) {
                    closedSignals.remove(gen)?.complete(Unit)
                }
                if (gen == clientGeneration.get()) {
                    handleResult(result, gen)
                }
            },
            { error -> Log.e(TAG, "TDLib Error: ${error.message}", error) },
            { error -> Log.e(TAG, "TDLib Default Error: ${error.message}", error) }
        )
    }

    private suspend fun recoverFromSetTdlibParametersFailure(failedGen: Int, errCode: Int, errMessage: String) {
        authMutex.withLock {
            recoverFromSetTdlibParametersFailureLocked(failedGen, errCode, errMessage)
        }
    }

    private suspend fun recoverFromSetTdlibParametersFailureLocked(failedGen: Int, errCode: Int, errMessage: String) {
        if (failedGen != clientGeneration.get() || _authState.value !is AuthState.Unknown) {
            return
        }

        val attempt = setParamsRecoveryAttempts.incrementAndGet()
        if (attempt > MAX_SET_PARAMS_RECOVERY_ATTEMPTS) {
            Log.e(TAG, "❌ SetTdlibParameters exhausted $MAX_SET_PARAMS_RECOVERY_ATTEMPTS recovery attempts ($errCode: $errMessage)")
            _authState.value = AuthState.Error(
                "Error inicializando almacenamiento de Telegram ($errMessage). Reinicia la aplicación."
            )
            authStateEventSeq.incrementAndGet()
            return
        }

        val prevDirName = activeDbDirName
        val prevDirFile = File(context.filesDir, prevDirName)
        val isProtectedSession = isDbDirProtectedByAuthenticatedSession(prevDirFile)

        val oldClient = client
        val oldSig = closedSignals[failedGen]
        clientGeneration.incrementAndGet() // Detach late callbacks from failedGen
        client = null
        runCatching { oldClient?.send(TdApi.Close()) {} }

        val closedInTime = if (oldClient != null && oldSig != null) {
            withTimeoutOrNull(3_500L) { oldSig.await() } != null
        } else {
            delay(200L)
            true
        }

        if (isProtectedSession) {
            // NEVER delete or rotate away from an existing authenticated td.binlog!
            Log.w(TAG, "⚠️ SetTdlibParameters failed on protected authenticated session ($prevDirName, attempt=$attempt); retrying safely without deleting td.binlog")
            if (!closedInTime && oldSig != null) {
                withTimeoutOrNull(2_500L) { oldSig.await() }
            }
            delay(250L)
            com.cineflix.android.util.StorageAndRamHygiene.cleanTdlibLogFiles(context.filesDir)
            ensureDirectoriesExist()
            initClient()
            return
        }

        if (closedInTime) {
            runCatching {
                if (prevDirFile.exists()) {
                    prevDirFile.listFiles()?.forEach { f -> runCatching { f.deleteRecursively() } }
                }
                ensureDirectoriesExist()
            }
        } else {
            val altDir = nextAlternateTdlibDbDirName(prevDirName)
            Log.w(TAG, "⚠️ SetTdlibParameters lock held on unauthenticated $prevDirName; rotating to $altDir (attempt=$attempt)")
            persistActiveDbDirName(altDir)
            runCatching {
                val altFile = File(context.filesDir, altDir)
                if (altFile.exists() && !isDbDirProtectedByAuthenticatedSession(altFile)) {
                    altFile.listFiles()?.forEach { f -> runCatching { f.deleteRecursively() } }
                }
                ensureDirectoriesExist()
            }
            oldSig?.invokeOnCompletion {
                if (!isDbDirProtectedByAuthenticatedSession(prevDirFile)) {
                    runCatching { prevDirFile.deleteRecursively() }
                }
            }
        }
        initClient()
    }

    // ── TDLib Event Handler ───────────────────────────────────────────────────
    private fun handleResult(result: TdApi.Object, gen: Int) {
        when (result) {
            is TdApi.UpdateAuthorizationState -> handleAuthState(result.authorizationState, gen)
            is TdApi.UpdateFile               -> handleUpdateFile(result.file)
            is TdApi.UpdateNewMessage         -> handleNewMessage(result.message)
            else -> { /* ignore */ }
        }
    }

    private fun handleAuthState(state: TdApi.AuthorizationState, gen: Int) {
        Log.i(TAG, "Auth state (gen=$gen): ${state.javaClass.simpleName}")
        when (state) {
            is TdApi.AuthorizationStateWaitTdlibParameters -> {
                ensureDirectoriesExist()
                val dbPath = File(context.filesDir, activeDbDirName).absolutePath
                val cachePath = File(context.cacheDir, "tdlib_files").absolutePath
                val realDeviceModel = resolveDeviceModel(context)
                val realSystemVersion = resolveSystemVersion()
                val realLangCode = resolveSystemLanguageCode()
                Log.i(TAG, "📱 TDLib device identity: model='$realDeviceModel', os='$realSystemVersion', lang='$realLangCode'")
                // Zero-SQLite-bloat mode: auth session lives in td.binlog (~32 KB), while personal
                // Telegram chats/groups/channels/messages are NEVER persisted into a growing db.sqlite!
                client?.send(TdApi.SetTdlibParameters(
                    false, dbPath, cachePath, null,
                    false, false, false, false,
                    API_ID, API_HASH,
                    realLangCode, realDeviceModel, realSystemVersion, "11.1.3"
                )) { res ->
                    if (res is TdApi.Error && gen == clientGeneration.get()) {
                        val errMsg = res.message ?: "SetTdlibParameters error"
                        Log.e(TAG, "❌ SetTdlibParameters failed (code=${res.code}): $errMsg")
                        setParamsFailureFlow.value = SetParamsFailure(gen, res.code, errMsg)
                        scope.launch {
                            recoverFromSetTdlibParametersFailure(gen, res.code, errMsg)
                        }
                    }
                }
            }
            is TdApi.AuthorizationStateWaitPhoneNumber -> {
                setParamsRecoveryAttempts.set(0)
                firebaseFallbackAttempted = false
                firebaseFallbackPendingGen.set(0)
                persistSessionAuthenticatedFlag(false)
                _authState.value = AuthState.WaitPhone
                authStateEventSeq.incrementAndGet()
            }
            is TdApi.AuthorizationStateWaitOtherDeviceConfirmation -> {
                setParamsRecoveryAttempts.set(0)
                firebaseFallbackPendingGen.set(0)
                _authState.value = AuthState.WaitQrCode(state.link)
                authStateEventSeq.incrementAndGet()
            }
            is TdApi.AuthorizationStateWaitCode -> {
                setParamsRecoveryAttempts.set(0)
                when (val decision = classifyAuthenticationCodeInfo(state.codeInfo, firebaseFallbackAttempted)) {
                    is CodeInfoDecision.TryFirebaseFallback -> {
                        firebaseFallbackAttempted = true
                        firebaseFallbackPendingGen.set(gen)
                        if (decision.normalizedPhone.isNotEmpty()) {
                            lastSubmittedPhone = decision.normalizedPhone
                        }
                        Log.w(TAG, "⚠️ TDLib received Firebase code type (${state.codeInfo?.type?.javaClass?.simpleName}); requesting nextType fallback...")
                        val activeClient = client
                        if (activeClient == null) {
                            firebaseFallbackPendingGen.set(0)
                            _authState.value = AuthState.AuthRejected(
                                "SEND_CODE_UNAVAILABLE: Telegram requiere vincular escaneando el Código QR del panel izquierdo desde tu móvil (Ajustes > Dispositivos > Vincular dispositivo)."
                            )
                            authStateEventSeq.incrementAndGet()
                        } else {
                            activeClient.send(
                                TdApi.ResendAuthenticationCode(
                                    TdApi.ResendCodeReasonVerificationFailed("PLAY_SERVICES_NOT_AVAILABLE")
                                )
                            ) { res ->
                                if (res is TdApi.Error && gen == clientGeneration.get()) {
                                    if (firebaseFallbackPendingGen.compareAndSet(gen, 0)) {
                                        Log.w(TAG, "⚠️ Firebase nextType fallback rejected (${res.code}): ${res.message}")
                                        _authState.value = AuthState.AuthRejected(
                                            "SEND_CODE_UNAVAILABLE: Telegram requiere vincular escaneando el Código QR del panel izquierdo desde tu móvil (Ajustes > Dispositivos > Vincular dispositivo)."
                                        )
                                        authStateEventSeq.incrementAndGet()
                                    }
                                }
                            }
                            scope.launch {
                                delay(6_000L)
                                if (gen == clientGeneration.get() && firebaseFallbackPendingGen.compareAndSet(gen, 0)) {
                                    _authState.value = AuthState.AuthRejected(
                                        "SEND_CODE_UNAVAILABLE: Telegram requiere vincular escaneando el Código QR del panel izquierdo desde tu móvil (Ajustes > Dispositivos > Vincular dispositivo)."
                                    )
                                    authStateEventSeq.incrementAndGet()
                                }
                            }
                        }
                    }
                    is CodeInfoDecision.RejectUnsupportedDelivery -> {
                        firebaseFallbackPendingGen.set(0)
                        if (decision.normalizedPhone.isNotEmpty()) {
                            lastSubmittedPhone = decision.normalizedPhone
                        }
                        lastWaitCodeHasNextType = false
                        Log.w(TAG, "⚠️ Rejecting undeliverable Firebase code state (${state.codeInfo?.type?.javaClass?.simpleName}) -> guiding user to QR")
                        _authState.value = AuthState.AuthRejected(decision.reason)
                        authStateEventSeq.incrementAndGet()
                    }
                    is CodeInfoDecision.AcceptWaitCode -> {
                        firebaseFallbackPendingGen.set(0)
                        if (decision.normalizedPhone.isNotEmpty()) {
                            lastSubmittedPhone = decision.normalizedPhone
                        }
                        lastWaitCodeHasNextType = decision.waitCode.hasNextType
                        lastCodeDeliveryState = decision.waitCode
                        Log.i(TAG, "📩 WaitCode deliveryType=${decision.waitCode.deliveryType} len=${decision.waitCode.codeLength} hasNextType=${decision.waitCode.hasNextType}")
                        _authState.value = decision.waitCode
                        authStateEventSeq.incrementAndGet()
                    }
                }
            }
            is TdApi.AuthorizationStateWaitEmailCode -> {
                setParamsRecoveryAttempts.set(0)
                firebaseFallbackPendingGen.set(0)
                val pattern = state.codeInfo?.emailAddressPattern?.trim().orEmpty()
                _authState.value = AuthState.WaitEmailCode(pattern)
                authStateEventSeq.incrementAndGet()
            }
            is TdApi.AuthorizationStateWaitPassword -> {
                setParamsRecoveryAttempts.set(0)
                firebaseFallbackPendingGen.set(0)
                lastPasswordHint = state.passwordHint?.trim().orEmpty()
                _authState.value = AuthState.WaitPassword
                authStateEventSeq.incrementAndGet()
            }
            is TdApi.AuthorizationStateWaitRegistration -> {
                setParamsRecoveryAttempts.set(0)
                firebaseFallbackPendingGen.set(0)
                _authState.value = AuthState.AuthRejected(
                    "PHONE_UNREGISTERED: Este número no tiene cuenta de Telegram registrada. Revisa el prefijo (+34...) e inténtalo de nuevo."
                )
                authStateEventSeq.incrementAndGet()
            }
            is TdApi.AuthorizationStateWaitEmailAddress,
            is TdApi.AuthorizationStateWaitPremiumPurchase -> {
                setParamsRecoveryAttempts.set(0)
                firebaseFallbackPendingGen.set(0)
                _authState.value = AuthState.AuthRejected(
                    "SETUP_EMAIL_REQUIRED: Telegram requiere vincular escaneando el Código QR del panel izquierdo desde tu móvil (Ajustes > Dispositivos > Vincular dispositivo)."
                )
                authStateEventSeq.incrementAndGet()
            }
            is TdApi.AuthorizationStateReady -> {
                setParamsRecoveryAttempts.set(0)
                cachedBotChatId = null
                lastSubmittedPhone = ""
                lastWaitCodeHasNextType = false
                firebaseFallbackAttempted = false
                firebaseFallbackPendingGen.set(0)
                lastCodeDeliveryState = AuthState.WaitCode()
                lastPasswordHint = ""
                persistSessionAuthenticatedFlag(true)
                _authState.value = AuthState.Ready
                authStateEventSeq.incrementAndGet()

                // Disable TDLib auto-downloads & background notification tracking completely
                val emptySettings = TdApi.AutoDownloadSettings().apply { isAutoDownloadEnabled = false }
                client?.send(TdApi.SetAutoDownloadSettings(emptySettings, TdApi.NetworkTypeWiFi())) {}
                client?.send(TdApi.SetAutoDownloadSettings(emptySettings, TdApi.NetworkTypeMobile())) {}
                client?.send(TdApi.SetAutoDownloadSettings(emptySettings, TdApi.NetworkTypeMobileRoaming())) {}
                client?.send(TdApi.SetAutoDownloadSettings(emptySettings, TdApi.NetworkTypeOther())) {}
                client?.send(TdApi.SetOption("storage_max_files_size", TdApi.OptionValueInteger(32L * 1024L * 1024L))) {}
                client?.send(TdApi.SetOption("notification_group_count_max", TdApi.OptionValueInteger(0))) {}

                scope.launch(Dispatchers.IO) {
                    try {
                        com.cineflix.android.util.StorageAndRamHygiene.cleanTdlibDatabaseBloat(context.filesDir)
                        com.cineflix.android.util.StorageAndRamHygiene.cleanTdlibTempFiles(context.cacheDir)
                        ensureDirectoriesExist()
                        optimizeStorage(0L, immunityDelaySec = 0)
                    } catch (_: Exception) {}
                }
            }
            is TdApi.AuthorizationStateLoggingOut,
            is TdApi.AuthorizationStateClosing -> {
                firebaseFallbackPendingGen.set(0)
                cachedBotChatId = null
                _authState.value = AuthState.LoggingOut
            }
            is TdApi.AuthorizationStateClosed -> {
                firebaseFallbackPendingGen.set(0)
                cachedBotChatId = null
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

        // Only update FileState if an active caller explicitly subscribed to this fileId
        fileStates[file.id]?.let { flow ->
            flow.value = FileState(
                path = file.local?.path ?: "",
                downloadedPrefixSize = file.local?.downloadedPrefixSize ?: 0L,
                downloadedSize = file.local?.downloadedSize ?: 0L,
                expectedSize = file.expectedSize.toLong(),
                isCompleted = file.local?.isDownloadingCompleted == true
            )
        }
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

        // Pre-cache fileId for instant playback (bounded to max 300 entries in RAM)
        if (isVideo) {
            val info = extractVideoInfo(msg) ?: return
            val cacheKey = "${msg.chatId}:${msg.id}"
            cacheMessageFileMeta(cacheKey, info.fileId, info.mimeType, info.fileSize)
        }
    }

    private fun extractVideoInfo(msg: TdApi.Message): VideoInfo? {
        return try {
            when (val c = msg.content) {
                is TdApi.MessageDocument -> {
                    val doc = c.document
                    val mime = doc.mimeType
                    val isMultipart = Regex("""\.(?:part0*\d+|0*\d+)$""", RegexOption.IGNORE_CASE).containsMatchIn(doc.fileName)
                    val isMedia = mime.contains("video") ||
                            doc.fileName.endsWith(".mp4") ||
                            doc.fileName.endsWith(".mkv") ||
                            doc.fileName.endsWith(".avi") ||
                            isMultipart
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

    // ── Auth Operations (Serialized & Self-Healing) ──────────────────────────

    private suspend fun awaitNonUnknownAuthState(timeoutMs: Long = 8_000L): AuthState {
        val cur = _authState.value
        if (cur !is AuthState.Unknown && cur !is AuthState.LoggingOut) return cur
        return withTimeoutOrNull(timeoutMs) {
            authState.first { it !is AuthState.Unknown && it !is AuthState.LoggingOut }
        } ?: _authState.value
    }

    private suspend fun awaitFreshClientWaitPhoneOrReadyLocked(timeoutMs: Long = 8_000L): AuthState? {
        val deadline = android.os.SystemClock.elapsedRealtime() + timeoutMs
        while (true) {
            val cur = _authState.value
            if (cur is AuthState.WaitPhone || cur is AuthState.Ready || cur is AuthState.Error) {
                return cur
            }
            val activeGen = clientGeneration.get()
            val pendingFail = setParamsFailureFlow.value
            if (pendingFail != null && pendingFail.gen == activeGen) {
                setParamsFailureFlow.value = null
                recoverFromSetTdlibParametersFailureLocked(pendingFail.gen, pendingFail.code, pendingFail.message)
                continue
            }
            val remaining = deadline - android.os.SystemClock.elapsedRealtime()
            if (remaining <= 0L) return _authState.value
            withTimeoutOrNull(remaining.coerceAtMost(250L)) {
                merge(
                    authState.filter { it is AuthState.WaitPhone || it is AuthState.Ready || it is AuthState.Error },
                    setParamsFailureFlow.filterNotNull().filter { it.gen == activeGen }
                ).first()
            }
        }
    }

    /**
     * Resets an unauthenticated TDLib session back to AuthState.WaitPhone.
     * Safe against stalled MTProto queries ("Another authorization query has started"), SetTdlibParameters
     * inline lock recovery (zero authMutex deadlock), and strictly preserves authenticated td.binlog*.
     */
    private suspend fun resetUnauthenticatedClientLocked(): Boolean {
        if (_authState.value is AuthState.Ready) return false
        Log.i(TAG, "Resetting unauthenticated TDLib client (current=${_authState.value})...")
        lastWaitCodeHasNextType = false
        firebaseFallbackAttempted = false
        firebaseFallbackPendingGen.set(0)
        lastCodeDeliveryState = AuthState.WaitCode()
        lastPasswordHint = ""

        val currentDbDir = File(context.filesDir, activeDbDirName)
        val isProtectedSession = isDbDirProtectedByAuthenticatedSession(currentDbDir)

        val oldClient = client
        if (oldClient != null && !isProtectedSession) {
            val destroyOk = CompletableDeferred<Boolean>()
            oldClient.send(TdApi.Destroy()) { res ->
                destroyOk.complete(res !is TdApi.Error)
            }
            val accepted = withTimeoutOrNull(2_500L) { destroyOk.await() } == true
            if (accepted) {
                val reached = awaitFreshClientWaitPhoneOrReadyLocked(5_500L)
                if (reached is AuthState.WaitPhone) {
                    return true
                }
                if (reached is AuthState.Ready) {
                    return false
                }
            }
        }

        if (_authState.value is AuthState.Ready) return false

        // Hard fallback when Destroy() was rejected ("Another authorization query has started"), timed out, or session is protected
        Log.w(TAG, "Recreating TDLib client safely (protectedSession=$isProtectedSession)...")
        val oldGen = clientGeneration.get()
        val oldClosedSignal = closedSignals[oldGen]
        clientGeneration.incrementAndGet() // Silence any late state mutations from oldClient
        client = null
        _authState.value = AuthState.Unknown
        setParamsRecoveryAttempts.set(0)
        runCatching { oldClient?.send(TdApi.Close()) {} }

        val closedCleanly = if (oldClient != null && oldClosedSignal != null) {
            withTimeoutOrNull(3_500L) { oldClosedSignal.await() } != null
        } else {
            delay(200L)
            true
        }

        if (isProtectedSession) {
            // NEVER delete or rotate away from an existing authenticated td.binlog!
            if (!closedCleanly && oldClosedSignal != null) {
                withTimeoutOrNull(2_500L) { oldClosedSignal.await() }
            }
            delay(200L)
            com.cineflix.android.util.StorageAndRamHygiene.cleanTdlibLogFiles(context.filesDir)
            ensureDirectoriesExist()
            initClient()
            val freshProtected = awaitFreshClientWaitPhoneOrReadyLocked(8_000L)
            return freshProtected is AuthState.WaitPhone
        }

        if (closedCleanly) {
            try {
                val dbDir = File(context.filesDir, activeDbDirName)
                if (dbDir.exists() && !isDbDirProtectedByAuthenticatedSession(dbDir)) {
                    dbDir.listFiles()?.forEach { f -> runCatching { f.deleteRecursively() } }
                }
                ensureDirectoriesExist()
            } catch (e: Exception) {
                Log.w(TAG, "Failed cleaning unauthenticated $activeDbDirName: ${e.message}")
            }
        } else {
            // oldClient C++ thread is still holding flock on td.binlog; switch to alternate DB directory
            // so the new Client never collides on td.binlog lock, and delete old dir once Close finishes.
            val lockedDirName = activeDbDirName
            val lockedDirFile = File(context.filesDir, lockedDirName)
            val nextDirName = nextAlternateTdlibDbDirName(lockedDirName)
            Log.w(TAG, "Old TDLib client gen=$oldGen still closing; rotating DB dir $lockedDirName -> $nextDirName")
            persistActiveDbDirName(nextDirName)
            runCatching {
                val nextDir = File(context.filesDir, nextDirName)
                if (nextDir.exists() && !isDbDirProtectedByAuthenticatedSession(nextDir)) {
                    nextDir.listFiles()?.forEach { f -> runCatching { f.deleteRecursively() } }
                }
                ensureDirectoriesExist()
            }
            oldClosedSignal?.invokeOnCompletion {
                if (!isDbDirProtectedByAuthenticatedSession(lockedDirFile)) {
                    runCatching { lockedDirFile.deleteRecursively() }
                }
            }
        }

        initClient()
        val freshState = awaitFreshClientWaitPhoneOrReadyLocked(8_000L)
        return freshState is AuthState.WaitPhone
    }

    private suspend fun executeAuthFunctionAndAwaitLocked(
        request: TdApi.Function<*>,
        timeoutMs: Long = 18_000L,
        mapTargetState: (AuthState) -> String?
    ): Result<String> = coroutineScope {
        val activeClient = client ?: return@coroutineScope Result.failure(
            IllegalStateException("Cliente TDLib reiniciándose. Inténtalo de nuevo.")
        )
        val outcome = CompletableDeferred<Result<String>>()

        val stateWatcher = launch {
            authState.collect { st ->
                if (st is AuthState.AuthRejected) {
                    if (outcome.complete(Result.failure(IllegalStateException(st.reason)))) {
                        cancel()
                    }
                    return@collect
                }
                if (st is AuthState.Error) {
                    if (outcome.complete(Result.failure(IllegalStateException(st.message)))) {
                        cancel()
                    }
                    return@collect
                }
                val mapped = mapTargetState(st)
                if (mapped != null) {
                    if (outcome.complete(Result.success(mapped))) {
                        cancel()
                    }
                }
            }
        }

        activeClient.send(request) { res ->
            if (res is TdApi.Error) {
                outcome.complete(Result.failure(IllegalStateException(res.message ?: "Error de Telegram")))
            }
        }

        val finalRes = withTimeoutOrNull(timeoutMs) {
            outcome.await()
        } ?: Result.failure(IllegalStateException("TIMEOUT: Tiempo de espera agotado conectando con Telegram."))

        stateWatcher.cancel()

        // If TDLib landed in AuthRejected (e.g. WaitRegistration / WaitEmailAddress / Firebase), clean up back to WaitPhone
        if (_authState.value is AuthState.AuthRejected) {
            resetUnauthenticatedClientLocked()
        }
        finalRes
    }

    fun formatCurrentAuthStateString(): String {
        return when (val s = _authState.value) {
            is AuthState.Ready         -> "READY"
            is AuthState.WaitPhone     -> "WAIT_PHONE"
            is AuthState.WaitCode      -> "WAIT_CODE"
            is AuthState.WaitEmailCode -> "WAIT_EMAIL_CODE|${s.emailPattern}"
            is AuthState.WaitPassword  -> "WAIT_PASSWORD"
            is AuthState.WaitQrCode    -> "WAIT_QR|${s.link}"
            is AuthState.AuthRejected  -> "AUTH_REJECTED|${s.reason}"
            is AuthState.Error         -> "ERROR: ${s.message}"
            else                       -> "UNKNOWN"
        }
    }

    suspend fun resetAuthSessionSuspend(): Result<String> {
        awaitNonUnknownAuthState(8_000L)
        return authMutex.withLock {
            val cur = awaitNonUnknownAuthState(2_500L)
            if (cur is AuthState.Ready) return@withLock Result.success("READY")
            lastSubmittedPhone = ""
            if (cur is AuthState.WaitPhone) return@withLock Result.success("WAIT_PHONE")
            val ok = resetUnauthenticatedClientLocked()
            if (ok || _authState.value is AuthState.WaitPhone) {
                Result.success("WAIT_PHONE")
            } else {
                Result.success(formatCurrentAuthStateString())
            }
        }
    }

    suspend fun requestQrLoginSuspend(forceReset: Boolean = false): Result<String> {
        awaitNonUnknownAuthState(8_000L)
        return authMutex.withLock {
            val cur = awaitNonUnknownAuthState(2_500L)
            when (cur) {
                is AuthState.Ready -> return@withLock Result.success("READY")
                is AuthState.WaitPassword -> return@withLock Result.success("WAIT_PASSWORD")
                is AuthState.WaitQrCode -> {
                    if (!forceReset && cur.link.isNotBlank()) {
                        // Already in WaitQrCode with a live token — return immediately without colliding in TDLib!
                        return@withLock Result.success("WAIT_QR|${cur.link}")
                    }
                    resetUnauthenticatedClientLocked()
                }
                is AuthState.WaitCode,
                is AuthState.WaitEmailCode -> {
                    if (!forceReset) {
                        return@withLock Result.success(formatCurrentAuthStateString())
                    }
                    resetUnauthenticatedClientLocked()
                }
                is AuthState.AuthRejected,
                is AuthState.Error -> {
                    resetUnauthenticatedClientLocked()
                }
                else -> {}
            }

            if (_authState.value !is AuthState.WaitPhone) {
                val resetOk = resetUnauthenticatedClientLocked()
                if (_authState.value is AuthState.Ready) return@withLock Result.success("READY")
                if (!resetOk && _authState.value !is AuthState.WaitPhone) {
                    return@withLock Result.failure(IllegalStateException("No se pudo iniciar la sesión QR. Revisa tu conexión."))
                }
            }

            val firstTry = executeAuthFunctionAndAwaitLocked(
                request = TdApi.RequestQrCodeAuthentication(LongArray(0)),
                timeoutMs = 15_000L
            ) { st ->
                when (st) {
                    is AuthState.WaitQrCode   -> if (st.link.isNotBlank()) "WAIT_QR|${st.link}" else null
                    is AuthState.Ready        -> "READY"
                    is AuthState.WaitPassword -> "WAIT_PASSWORD"
                    else -> null
                }
            }

            if (firstTry.isFailure && isTransientAuthQueryConflict(firstTry.exceptionOrNull()?.message)) {
                val curAfter = _authState.value
                if (curAfter is AuthState.WaitQrCode && curAfter.link.isNotBlank()) {
                    return@withLock Result.success("WAIT_QR|${curAfter.link}")
                }
                Log.w(TAG, "QR request hit transient conflict (${firstTry.exceptionOrNull()?.message}), self-healing...")
                if (resetUnauthenticatedClientLocked()) {
                    return@withLock executeAuthFunctionAndAwaitLocked(
                        request = TdApi.RequestQrCodeAuthentication(LongArray(0)),
                        timeoutMs = 15_000L
                    ) { st ->
                        when (st) {
                            is AuthState.WaitQrCode   -> if (st.link.isNotBlank()) "WAIT_QR|${st.link}" else null
                            is AuthState.Ready        -> "READY"
                            is AuthState.WaitPassword -> "WAIT_PASSWORD"
                            else -> null
                        }
                    }
                }
            }
            firstTry
        }
    }

    suspend fun loginWithPhoneSuspend(rawPhone: String): Result<String> {
        val normalizedPhone = normalizePhoneInput(rawPhone)
        if (normalizedPhone.isEmpty()) {
            return Result.failure(
                IllegalArgumentException("PHONE_NUMBER_INVALID: Introduce tu número completo con prefijo internacional (ej: +34 612 345 678).")
            )
        }

        awaitNonUnknownAuthState(8_000L)
        return authMutex.withLock {
            val cur = awaitNonUnknownAuthState(2_500L)
            if (cur is AuthState.Ready) {
                return@withLock Result.success("READY")
            }

            // Same phone already in WaitCode AND TDLib offers a nextType (e.g. SMS fallback): try ResendAuthenticationCode first
            if (cur is AuthState.WaitCode && normalizedPhone == lastSubmittedPhone && lastWaitCodeHasNextType) {
                Log.i(TAG, "Resending authentication code via nextType for $normalizedPhone...")
                val seqBeforeResend = authStateEventSeq.get()
                val resendDone = CompletableDeferred<TdApi.Object?>()
                client?.send(TdApi.ResendAuthenticationCode(TdApi.ResendCodeReasonUserRequest())) { res ->
                    resendDone.complete(res)
                }
                val resendRes = withTimeoutOrNull(10_000L) { resendDone.await() }
                if (resendRes is TdApi.Ok) {
                    val waitDeadline = android.os.SystemClock.elapsedRealtime() + 7_500L
                    while (android.os.SystemClock.elapsedRealtime() < waitDeadline) {
                        if (authStateEventSeq.get() > seqBeforeResend && firebaseFallbackPendingGen.get() == 0) {
                            break
                        }
                        delay(60L)
                    }
                    if (_authState.value is AuthState.AuthRejected) {
                        val reason = (_authState.value as AuthState.AuthRejected).reason
                        resetUnauthenticatedClientLocked()
                        return@withLock Result.failure(IllegalStateException(reason))
                    }
                    val updated = formatCurrentAuthStateString()
                    return@withLock Result.success(if (updated == "UNKNOWN") "WAIT_CODE" else updated)
                }
                val resendErrMsg = (resendRes as? TdApi.Error)?.message
                if (isFloodWaitError(resendErrMsg)) {
                    // Keep existing WaitCode session alive so previously sent app code stays valid!
                    return@withLock Result.failure(IllegalStateException(resendErrMsg ?: "FLOOD_WAIT_60"))
                }
                Log.w(TAG, "ResendAuthenticationCode failed ($resendErrMsg), resetting to send fresh code...")
            }

            // If TDLib is in WaitQrCode, WaitCode (different phone or no nextType), WaitEmailCode, WaitPassword, or AuthRejected -> clean reset!
            if (_authState.value !is AuthState.WaitPhone) {
                val resetOk = resetUnauthenticatedClientLocked()
                if (!resetOk && _authState.value !is AuthState.WaitPhone) {
                    if (_authState.value is AuthState.Ready) return@withLock Result.success("READY")
                    return@withLock Result.failure(
                        IllegalStateException("Error preparando la conexión con Telegram. Revisa tu internet e inténtalo de nuevo.")
                    )
                }
            }

            suspend fun attemptSetPhone(): Result<String> {
                firebaseFallbackAttempted = false
                return executeAuthFunctionAndAwaitLocked(
                    request = TdApi.SetAuthenticationPhoneNumber(normalizedPhone, buildSafePhoneAuthSettings()),
                    timeoutMs = 20_000L
                ) { st ->
                    when (st) {
                        is AuthState.WaitCode      -> "WAIT_CODE"
                        is AuthState.WaitEmailCode -> "WAIT_EMAIL_CODE|${st.emailPattern}"
                        is AuthState.WaitPassword  -> "WAIT_PASSWORD"
                        is AuthState.Ready         -> "READY"
                        else -> null
                    }
                }
            }

            var attempt = attemptSetPhone()
            if (attempt.isFailure && isTransientAuthQueryConflict(attempt.exceptionOrNull()?.message)) {
                Log.w(TAG, "SetAuthenticationPhoneNumber hit transient conflict (${attempt.exceptionOrNull()?.message}), self-healing...")
                if (resetUnauthenticatedClientLocked()) {
                    attempt = attemptSetPhone()
                }
            }

            if (attempt.isSuccess) {
                lastSubmittedPhone = normalizedPhone
            }
            attempt
        }
    }

    suspend fun signInWithCodeSuspend(rawCode: String): Result<String> {
        val cleanCode = sanitizeVerificationCode(rawCode)
        if (cleanCode.isEmpty()) {
            return Result.failure(IllegalArgumentException("PHONE_CODE_INVALID: Introduce el código recibido."))
        }

        awaitNonUnknownAuthState(4_000L)
        return authMutex.withLock {
            val cur = awaitNonUnknownAuthState(2_000L)
            when (cur) {
                is AuthState.Ready -> return@withLock Result.success("READY")
                is AuthState.WaitPassword -> return@withLock Result.success("WAIT_PASSWORD")
                is AuthState.WaitEmailCode -> {
                    return@withLock executeAuthFunctionAndAwaitLocked(
                        request = TdApi.CheckAuthenticationEmailCode(TdApi.EmailAddressAuthenticationCode(cleanCode)),
                        timeoutMs = 18_000L
                    ) { st ->
                        when (st) {
                            is AuthState.Ready        -> "READY"
                            is AuthState.WaitPassword -> "WAIT_PASSWORD"
                            is AuthState.WaitCode     -> "WAIT_CODE"
                            else -> null
                        }
                    }
                }
                is AuthState.WaitCode -> {
                    return@withLock executeAuthFunctionAndAwaitLocked(
                        request = TdApi.CheckAuthenticationCode(cleanCode),
                        timeoutMs = 18_000L
                    ) { st ->
                        when (st) {
                            is AuthState.Ready        -> "READY"
                            is AuthState.WaitPassword -> "WAIT_PASSWORD"
                            else -> null
                        }
                    }
                }
                else -> {
                    return@withLock Result.failure(
                        IllegalStateException("CHECKAUTHENTICATIONCODE UNEXPECTED: La sesión de verificación cambió o expiró. Pulsa Reenviar o Cambiar número.")
                    )
                }
            }
        }
    }

    suspend fun signInWithPasswordSuspend(password: String): Result<String> {
        if (password.isEmpty()) {
            return Result.failure(IllegalArgumentException("PASSWORD_HASH_INVALID: Introduce tu contraseña 2FA."))
        }
        awaitNonUnknownAuthState(4_000L)
        return authMutex.withLock {
            val cur = awaitNonUnknownAuthState(2_000L)
            if (cur is AuthState.Ready) {
                return@withLock Result.success("READY")
            }
            if (cur !is AuthState.WaitPassword) {
                return@withLock Result.failure(
                    IllegalStateException("La sesión cambió antes de verificar la contraseña. Vuelve atrás e inténtalo de nuevo.")
                )
            }
            executeAuthFunctionAndAwaitLocked(
                request = TdApi.CheckAuthenticationPassword(password),
                timeoutMs = 18_000L
            ) { st ->
                when (st) {
                    is AuthState.Ready -> "READY"
                    else -> null
                }
            }
        }
    }

    // Legacy callback wrappers preserved for compatibility
    fun requestQrLogin(onError: (String) -> Unit) {
        scope.launch {
            requestQrLoginSuspend(forceReset = false).onFailure { onError(it.message ?: "Error QR") }
        }
    }

    fun sendPhone(phone: String, onError: (String) -> Unit) {
        scope.launch {
            loginWithPhoneSuspend(phone).onFailure { onError(it.message ?: "Error enviando teléfono") }
        }
    }

    fun sendCode(code: String, onError: (String) -> Unit) {
        scope.launch {
            signInWithCodeSuspend(code).onFailure { onError(it.message ?: "Error verificando código") }
        }
    }

    fun sendPassword(password: String, onError: (String) -> Unit) {
        scope.launch {
            signInWithPasswordSuspend(password).onFailure { onError(it.message ?: "Error verificando contraseña") }
        }
    }

    suspend fun logoutSuspend(): String = authMutex.withLock {
        lastSubmittedPhone = ""
        lastWaitCodeHasNextType = false
        firebaseFallbackAttempted = false
        lastCodeDeliveryState = AuthState.WaitCode()
        lastPasswordHint = ""
        cachedBotChatId = null
        persistSessionAuthenticatedFlag(false)
        runCatching {
            context.getSharedPreferences("CineflixPrefs", Context.MODE_PRIVATE)
                .edit()
                .remove("user_phone")
                .remove("tg_session")
                .putBoolean(PREF_SESSION_AUTHENTICATED, false)
                .apply()
        }
        val c = client ?: return@withLock "WAIT_PHONE"
        val done = CompletableDeferred<TdApi.Object?>()
        c.send(TdApi.LogOut()) { res -> done.complete(res) }
        val logOutRes = withTimeoutOrNull(5_000L) { done.await() }
        if (logOutRes is TdApi.Error) {
            resetUnauthenticatedClientLocked()
        } else {
            withTimeoutOrNull(6_000L) {
                authState.first { it is AuthState.WaitPhone }
            }
        }
        "WAIT_PHONE"
    }

    fun logout(onDone: () -> Unit) {
        scope.launch {
            logoutSuspend()
            onDone()
        }
    }

    fun getMe(onResult: (TdApi.User?) -> Unit) {
        client?.send(TdApi.GetMe()) { result ->
            onResult(if (result is TdApi.User) result else null)
        }
    }

    // ── Bot Operations ────────────────────────────────────────────────────────

    /** Send /start <payload> to bot, wait for inline keyboard reply */
    suspend fun sendBotCommand(payload: String): SeasonResponse? = withContext(Dispatchers.IO) {
        if (!ensureReady()) {
            throw IllegalStateException("AUTH_REQUIRED: No hay sesión activa en Telegram.")
        }
        val chatId = getBotChatId() ?: throw IllegalStateException("BOT_NOT_FOUND: No se pudo conectar con @$BOT_USERNAME")
        client?.send(TdApi.OpenChat(chatId)) { }
        val deferred = CompletableDeferred<SeasonResponse?>()

        // Register a keyboard-reply listener BEFORE sending the command
        val listenerKey = "kbd_${System.currentTimeMillis()}"
        inlineKeyboardListeners[listenerKey] = InlineKeyboardListener(chatId, deferred)

        val text = TdApi.FormattedText("/start $payload", emptyArray())
        client?.send(TdApi.SendMessage(chatId, null, null, null, null,
            TdApi.InputMessageText(text, null, false)
        )) { sendResult ->
            if (sendResult is TdApi.Error) {
                Log.e(TAG, "SendMessage /start error: ${sendResult.code} - ${sendResult.message}")
                inlineKeyboardListeners.remove(listenerKey)
                deferred.complete(null)
            }
        }

        // Wait up to 120s for the bot to reply with the keyboard (un-analyzed series take time to index)
        val result = withTimeoutOrNull(120_000) { deferred.await() }
        inlineKeyboardListeners.remove(listenerKey)
        result
    }

    /**
     * Click an inline button (season) and wait for the bot to finish sending episode videos.
     * Web equivalent: clickInlineButton(msgId, data) + getVideoMessages()
     * Smart-wait: we stop 1.5s after the last video arrived, or after 90s max.
     */
    suspend fun clickInlineButton(chatId: Long, msgId: Long, dataBase64: String): List<VideoInfo> =
        withContext(Dispatchers.IO) {
            if (!ensureReady()) {
                throw IllegalStateException("AUTH_REQUIRED: No hay sesión activa en Telegram.")
            }
            client?.send(TdApi.OpenChat(chatId)) { }
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

            // Smart wait: stop 1.5s after last video OR after 90s total (exits early as soon as files are collected)
            val silenceMs = 1500L
            val maxWait   = 90_000L
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
            if (!ensureReady()) {
                throw IllegalStateException("AUTH_REQUIRED: No hay sesión activa en Telegram.")
            }
            val chatId = getBotChatId() ?: throw IllegalStateException("BOT_NOT_FOUND: No se pudo conectar con @$BOT_USERNAME")

            // Open chat to force live updates
            client?.send(TdApi.OpenChat(chatId)) { }

            // Get the last message id before sending so we only collect AFTER our command
            val anchorDeferred = CompletableDeferred<Long>()
            client?.send(TdApi.GetChatHistory(chatId, 0L, 0, 1, false)) { hist ->
                val lastId = if (hist is TdApi.Messages && hist.messages.isNotEmpty())
                    hist.messages[0].id else 0L
                anchorDeferred.complete(lastId)
            }
            val anchorMsgId = withTimeoutOrNull(3000) { anchorDeferred.await() } ?: 0L

            // Register collector BEFORE sending command
            val collectorKey = "peli_${System.currentTimeMillis()}"
            val collector = MsgCollector(chatId = chatId, afterMsgId = anchorMsgId)
            msgCollectors[collectorKey] = collector

            // Send /peli <title>
            val text = TdApi.FormattedText("/peli $searchTitle", emptyArray())
            val sendDeferred = CompletableDeferred<Boolean>()
            client?.send(TdApi.SendMessage(chatId, null, null, null, null,
                TdApi.InputMessageText(text, null, false)
            )) { result ->
                if (result is TdApi.Error) {
                    Log.e(TAG, "SendMessage /peli error: ${result.code} - ${result.message}")
                    sendDeferred.complete(false)
                } else {
                    sendDeferred.complete(true)
                }
            }

            if (!sendDeferred.await()) {
                msgCollectors.remove(collectorKey)
                throw IllegalStateException("BOT_SEND_FAILED: No se pudo enviar el comando al bot")
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

    suspend fun waitForMyContentVideos(): List<VideoInfo> =
        withContext(Dispatchers.IO) {
            if (!ensureReady()) {
                throw IllegalStateException("AUTH_REQUIRED: No hay sesión activa en Telegram.")
            }
            val chatId = getBotChatId() ?: throw IllegalStateException("BOT_NOT_FOUND: No se pudo conectar con @$BOT_USERNAME")

            // Get anchor message id
            val anchorDeferred = CompletableDeferred<Long>()
            client?.send(TdApi.GetChatHistory(chatId, 0L, 0, 1, false)) { hist ->
                val lastId = if (hist is TdApi.Messages && hist.messages.isNotEmpty())
                    hist.messages[0].id else 0L
                anchorDeferred.complete(lastId)
            }
            val anchorMsgId = anchorDeferred.await()

            // Open the chat to force TDLib to sync live updates
            client?.send(TdApi.OpenChat(chatId)) { }

            // Send /micontenido
            Log.d(TAG, "waitForMyContentVideos: anchorMsgId=$anchorMsgId, sending /micontenido")
            val text = TdApi.FormattedText("/micontenido", emptyArray())
            val sendDeferred = CompletableDeferred<Boolean>()
            client?.send(TdApi.SendMessage(chatId, null, null, null, null,
                TdApi.InputMessageText(text, null, false)
            )) { result -> 
                Log.d(TAG, "waitForMyContentVideos: SendMessage result: ${result.javaClass.simpleName}")
                sendDeferred.complete(result !is TdApi.Error) 
            }

            if (!sendDeferred.await()) {
                Log.e(TAG, "waitForMyContentVideos: SendMessage failed")
                client?.send(TdApi.CloseChat(chatId)) { }
                return@withContext emptyList()
            }
            
            try {

            // Poll for completion message
            var isDone = false
            var attempts = 0
            while (!isDone && attempts < 120) {
                delay(3000)
                attempts++
                Log.d(TAG, "waitForMyContentVideos: polling attempt $attempts")
                
                val recentDeferred = CompletableDeferred<List<TdApi.Message>>()
                client?.send(TdApi.GetChatHistory(chatId, 0L, 0, 15, false)) { hist ->
                    if (hist is TdApi.Messages) {
                        recentDeferred.complete(hist.messages.toList())
                    } else {
                        Log.e(TAG, "waitForMyContentVideos: GetChatHistory returned ${hist.javaClass.simpleName}")
                        recentDeferred.complete(emptyList())
                    }
                }
                val recentMessages = recentDeferred.await()
                Log.d(TAG, "waitForMyContentVideos: got ${recentMessages.size} recent messages")
                
                for (m in recentMessages) {
                    Log.d(TAG, "waitForMyContentVideos: checking message id=${m.id}, type=${m.content.javaClass.simpleName}")
                    if (m.id <= anchorMsgId) {
                        Log.d(TAG, "waitForMyContentVideos: reached anchor message id=${m.id} <= $anchorMsgId. Breaking.")
                        break
                    }
                    val content = m.content
                    if (content is TdApi.MessageText) {
                        val msgText = content.text.text
                        Log.d(TAG, "waitForMyContentVideos: text: '$msgText'")
                        if (msgText.contains("✅") || msgText == "/fin" || msgText.contains("El contenido está listo")) {
                            Log.d(TAG, "waitForMyContentVideos: found completion text!")
                            isDone = true
                            break
                        }
                    }
                }
            }

                if (!isDone) throw Exception("Tiempo de espera agotado.")

                // Fetch videos after anchor
                val videosDeferred = CompletableDeferred<List<VideoInfo>>()
                val collected = mutableListOf<VideoInfo>()
                client?.send(TdApi.GetChatHistory(chatId, 0L, 0, 100, false)) { hist ->
                    if (hist is TdApi.Messages) {
                        for (m in hist.messages) {
                            if (m.id <= anchorMsgId) continue
                            val info = extractVideoInfo(m) ?: continue
                            collected.add(info)
                        }
                    }
                    videosDeferred.complete(collected)
                }
                videosDeferred.await().sortedBy { it.msgId }
            } finally {
                client?.send(TdApi.CloseChat(chatId)) { }
            }
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
            ensureDirectoriesExist()
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
            ensureDirectoriesExist()
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
        ensureDirectoriesExist()
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
            } else if (result is TdApi.Error) {
                Log.d(TAG, "ReadFilePart miss: ${result.code} ${result.message} fileId=$fileId offset=$offset count=$count")
            }
            latch.countDown()
        } ?: return null

        try {
            latch.await(5_000, java.util.concurrent.TimeUnit.MILLISECONDS)
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
            return null
        }
        return chunk
    }

    /**
     * Download a specific range from Telegram's CDN and read it. Uses DownloadFile(synchronous=true)
     * which means TDLib won't invoke the callback until the bytes are fully downloaded.
     * This eliminates the poll-sleep-retry loop for un-downloaded bytes.
     * Returns the bytes, or null on timeout (30s).
     */
    fun downloadRangeAndRead(fileId: Int, offset: Long, count: Long): ByteArray? {
        val lock = downloadLocks.getOrPut(fileId) { Any() }
        synchronized(lock) {
            ensureDirectoriesExist()
            // Step 1: Tell TDLib to download this exact range. synchronous=true blocks until ready.
            val downloadLatch = java.util.concurrent.CountDownLatch(1)
            var isSuccess = false
            client?.send(TdApi.DownloadFile(fileId, 32, offset, count, true)) { result ->
                if (result is TdApi.File) {
                    isSuccess = true
                } else if (result is TdApi.Error) {
                    Log.w(TAG, "DownloadFile(sync) error: ${result.code} ${result.message} fileId=$fileId offset=$offset count=$count")
                }
                downloadLatch.countDown()
            } ?: return null

            // Wait up to 30s for TDLib to fetch from Telegram CDN (resilient against network spikes)
            try {
                if (!downloadLatch.await(30_000, java.util.concurrent.TimeUnit.MILLISECONDS)) {
                    Log.w(TAG, "downloadRangeAndRead TIMEOUT offset=$offset count=$count")
                    return null
                }
            } catch (e: InterruptedException) {
                Thread.currentThread().interrupt()
                return null
            }

            if (!isSuccess) return null

            // Step 2: Bytes are guaranteed available. Read them.
            return readFilePartSync(fileId, offset, count)
        }
    }

    suspend fun isFileIdValid(fileId: Int): Boolean = withContext(Dispatchers.IO) {
        if (fileId <= 0) return@withContext false
        val c = client ?: return@withContext false
        val deferred = CompletableDeferred<Boolean>()
        c.send(TdApi.GetFile(fileId)) { res ->
            deferred.complete(res is TdApi.File)
        }
        withTimeoutOrNull(2000) { deferred.await() } ?: false
    }

    private suspend fun ensureChatKnownInSession(chatId: Long, botChatId: Long?) {
        if (chatId == 0L || chatId == botChatId) return
        val c = client ?: return
        val alreadyKnown = withTimeoutOrNull(1200) {
            val d = CompletableDeferred<Boolean>()
            c.send(TdApi.GetChat(chatId)) { res -> d.complete(res is TdApi.Chat) }
            d.await()
        } == true
        if (alreadyKnown) return
        withTimeoutOrNull(4000) {
            val d = CompletableDeferred<Unit>()
            c.send(TdApi.GetChats(null, 60)) { d.complete(Unit) }
            d.await()
        }
    }

    /**
     * Ensures [fileId] is valid in the current TDLib in-memory FileManager, transparently
     * re-resolving from `(chatId, msgId)` on Telegram's server if `fileId <= 0` or stale.
     */
    suspend fun ensureValidFileId(
        fileId: Int,
        chatId: Long,
        msgId: Long,
        fallbackSize: Long = 0L
    ): Pair<Int, Long>? = withContext(Dispatchers.IO) {
        if (fileId > 0 && isFileIdValid(fileId)) {
            val sz = if (fallbackSize > 0L) fallbackSize else resolveFileSizeForFileId(fileId)
            return@withContext Pair(fileId, sz)
        }
        if (msgId != 0L) {
            return@withContext resolveFileIdForMessage(chatId, msgId)
        }
        null
    }

    /**
     * Ensures every part in a multipart / `7z-copy` archive has a live TDLib `fileId` in the
     * current session, batch-recovering stale part `fileId`s from Telegram's server via `GetMessages`
     * whenever per-part `msgId`s are available.
     */
    suspend fun ensureValidMultipartParts(
        parts: List<com.cineflix.android.ui.player.FilePart>,
        chatId: Long
    ): List<com.cineflix.android.ui.player.FilePart>? = withContext(Dispatchers.IO) {
        if (parts.isEmpty()) return@withContext emptyList()
        val staleIndices = ArrayList<Int>()
        for (i in parts.indices) {
            val p = parts[i]
            if (p.fileId <= 0 || !isFileIdValid(p.fileId)) {
                staleIndices.add(i)
            }
        }
        if (staleIndices.isEmpty()) return@withContext parts

        val botChat = getBotChatId()
        val effectiveChatId = if (chatId != 0L) chatId else (botChat ?: return@withContext null)
        ensureChatKnownInSession(effectiveChatId, botChat)
        val c = client ?: return@withContext null

        val batchMsgIds = staleIndices
            .map { parts[it].msgId }
            .filter { it != 0L }
            .distinct()
            .toLongArray()

        val resolvedByMsgId = HashMap<Long, Pair<Int, Long>>()
        if (batchMsgIds.isNotEmpty()) {
            val batchDeferred = CompletableDeferred<Unit>()
            c.send(TdApi.GetMessages(effectiveChatId, batchMsgIds)) { result ->
                if (result is TdApi.Messages) {
                    for (msg in result.messages) {
                        if (msg == null) continue
                        val info = extractVideoInfo(msg)
                        if (info != null && info.fileId > 0) {
                            cacheMessageFileMeta("$effectiveChatId:${msg.id}", info.fileId, info.mimeType, info.fileSize)
                            resolvedByMsgId[msg.id] = Pair(info.fileId, info.fileSize)
                        }
                    }
                }
                batchDeferred.complete(Unit)
            }
            withTimeoutOrNull(7000) { batchDeferred.await() }
        }

        val updated = ArrayList<com.cineflix.android.ui.player.FilePart>(parts.size)
        for (i in parts.indices) {
            val orig = parts[i]
            if (i !in staleIndices) {
                updated.add(orig)
                continue
            }
            val recovered = resolvedByMsgId[orig.msgId]
                ?: (if (orig.msgId != 0L) resolveFileIdForMessage(effectiveChatId, orig.msgId) else null)
            if (recovered == null || recovered.first <= 0) {
                Log.e(TAG, "Failed to recover stale multipart part #$i (msgId=${orig.msgId}, oldFileId=${orig.fileId})")
                return@withContext null
            }
            val sz = if (orig.size > 0L) orig.size else recovered.second
            if (sz <= 0L) return@withContext null
            updated.add(com.cineflix.android.ui.player.FilePart(recovered.first, sz, orig.msgId))
        }
        updated
    }

    /**
     * Resolves the real TDLib fileId and fileSize for a given chatId and msgId.
     * Checks in-memory cache first, then queries TDLib via GetMessage and server-backed GetMessages.
     */
    suspend fun resolveFileIdForMessage(chatId: Long, msgId: Long): Pair<Int, Long>? = withContext(Dispatchers.IO) {
        if (msgId == 0L) return@withContext null
        val botChat = getBotChatId()
        val effectiveChatId = if (chatId != 0L) chatId else (botChat ?: return@withContext null)
        ensureChatKnownInSession(effectiveChatId, botChat)
        val cacheKey = "$effectiveChatId:$msgId"

        fileIdCache[cacheKey]?.let { pair ->
            if (isFileIdValid(pair.first)) {
                val cachedSize = fileSizeCache[cacheKey] ?: 0L
                val actualSize = if (cachedSize > 0L) cachedSize else resolveFileSizeForFileId(pair.first)
                if (actualSize > 0L) fileSizeCache[cacheKey] = actualSize
                return@withContext Pair(pair.first, actualSize)
            } else {
                fileIdCache.remove(cacheKey)
                fileSizeCache.remove(cacheKey)
            }
        }

        val c = client ?: return@withContext null
        val localDeferred = CompletableDeferred<Pair<Int, Long>?>()
        c.send(TdApi.GetMessage(effectiveChatId, msgId)) { result ->
            if (result is TdApi.Message) {
                val info = extractVideoInfo(result)
                if (info != null && info.fileId > 0) {
                    cacheMessageFileMeta(cacheKey, info.fileId, info.mimeType, info.fileSize)
                    localDeferred.complete(Pair(info.fileId, info.fileSize))
                } else {
                    localDeferred.complete(null)
                }
            } else {
                localDeferred.complete(null)
            }
        }
        val fromLocal = withTimeoutOrNull(2500) { localDeferred.await() }
        if (fromLocal != null) return@withContext fromLocal

        // Server-backed fallback (essential when useMessageDatabase = false)
        val serverDeferred = CompletableDeferred<Pair<Int, Long>?>()
        c.send(TdApi.GetMessages(effectiveChatId, longArrayOf(msgId))) { result ->
            if (result is TdApi.Messages && result.messages.isNotEmpty()) {
                val msg = result.messages.firstOrNull { it != null }
                val info = msg?.let { extractVideoInfo(it) }
                if (info != null && info.fileId > 0) {
                    cacheMessageFileMeta(cacheKey, info.fileId, info.mimeType, info.fileSize)
                    serverDeferred.complete(Pair(info.fileId, info.fileSize))
                } else {
                    serverDeferred.complete(null)
                }
            } else {
                serverDeferred.complete(null)
            }
        }
        withTimeoutOrNull(6000) { serverDeferred.await() }
    }

    suspend fun resolveFileSizeForFileId(fileId: Int): Long = withContext(Dispatchers.IO) {
        if (fileId <= 0) return@withContext 0L
        fileStates[fileId]?.value?.expectedSize?.takeIf { it > 0L }?.let { return@withContext it }
        val deferred = CompletableDeferred<Long>()
        client?.send(TdApi.GetFile(fileId)) { res ->
            if (res is TdApi.File) {
                val sz = if (res.size > 0L) res.size else res.expectedSize
                deferred.complete(sz.coerceAtLeast(0L))
            } else {
                deferred.complete(0L)
            }
        } ?: deferred.complete(0L)
        withTimeoutOrNull(2500) { deferred.await() } ?: 0L
    }

    // ── Helpers ───────────────────────────────────────────────────────────────

    /**
     * Fetch up to [limit] video messages from the bot chat newer than [minId].
     * Paginates up to 3 slices because TDLib's `GetChatHistory` may return only in-memory messages
     * on the first call before fetching older messages from Telegram's server.
     */
    suspend fun getVideoMessagesHistory(limit: Int = 50, minId: Long = 0L): List<VideoInfo> =
        withContext(Dispatchers.IO) {
            val chatId = getBotChatId() ?: return@withContext emptyList()
            val c = client ?: return@withContext emptyList()
            val targetLimit = limit.coerceIn(10, 260)
            val byMsgId = LinkedHashMap<Long, VideoInfo>()
            var fromMsgId = 0L
            var pages = 0

            while (pages < 4 && byMsgId.size < targetLimit) {
                pages++
                val pageDeferred = CompletableDeferred<Array<TdApi.Message>?>()
                c.send(TdApi.GetChatHistory(chatId, fromMsgId, 0, (targetLimit - byMsgId.size).coerceAtLeast(20), false)) { result ->
                    if (result is TdApi.Messages) {
                        pageDeferred.complete(result.messages)
                    } else {
                        pageDeferred.complete(null)
                    }
                }
                val batch = withTimeoutOrNull(8_000) { pageDeferred.await() } ?: break
                if (batch.isEmpty()) break

                var reachedMinId = false
                for (msg in batch) {
                    if (msg.id <= minId) {
                        reachedMinId = true
                        continue
                    }
                    val info = extractVideoInfo(msg)
                    if (info != null) {
                        byMsgId[info.msgId] = info
                    }
                }
                val oldestId = batch.last().id
                if (reachedMinId || oldestId <= 0L || oldestId == fromMsgId) break
                fromMsgId = oldestId
            }
            byMsgId.values.sortedBy { it.msgId }
        }

    @Volatile
    private var cachedBotChatId: Long? = null

    suspend fun ensureReady(): Boolean {
        if (_authState.value is AuthState.Ready) return true
        Log.i(TAG, "TDLib not ready yet (current: ${_authState.value}), waiting for Ready state...")
        val reached = withTimeoutOrNull(15_000) {
            authState.first {
                it is AuthState.Ready ||
                it is AuthState.WaitPhone ||
                it is AuthState.WaitQrCode ||
                it is AuthState.WaitCode ||
                it is AuthState.WaitEmailCode ||
                it is AuthState.WaitPassword ||
                it is AuthState.AuthRejected ||
                it is AuthState.Error
            }
        }
        return reached is AuthState.Ready
    }

    private suspend fun getBotChatId(): Long? {
        if (!ensureReady()) {
            Log.e(TAG, "Cannot get bot chatId: TDLib is not ready (state: ${_authState.value})")
            return null
        }
        cachedBotChatId?.let { return it }

        return botChatMutex.withLock {
            cachedBotChatId?.let { return@withLock it }
            val c = client ?: run {
                Log.e(TAG, "TDLib client is null when getting bot chatId")
                return@withLock null
            }

            val savedId = context.getSharedPreferences("CineflixPrefs", Context.MODE_PRIVATE).getLong("bot_chat_id", 0L)
            if (savedId != 0L) {
                val knownInSession = withTimeoutOrNull(1500) {
                    val d = CompletableDeferred<Boolean>()
                    c.send(TdApi.GetChat(savedId)) { res -> d.complete(res is TdApi.Chat) }
                    d.await()
                } == true
                if (knownInSession) {
                    cachedBotChatId = savedId
                    return@withLock savedId
                }
            }

            val resolvedId = withTimeoutOrNull(12_000) {
                suspendCancellableCoroutine<Long?> { cont ->
                    try {
                        c.send(TdApi.SearchPublicChat(BOT_USERNAME)) { result ->
                            val id = if (result is TdApi.Chat) result.id else null
                            if (id != null) {
                                cachedBotChatId = id
                                context.getSharedPreferences("CineflixPrefs", Context.MODE_PRIVATE)
                                    .edit().putLong("bot_chat_id", id).apply()
                                Log.i(TAG, "Resolved and cached bot chatId: $id")
                                if (cont.isActive) cont.resume(id) {}
                            } else {
                                if (result is TdApi.Error) {
                                    Log.w(TAG, "SearchPublicChat failed (${result.code} - ${result.message}), trying SearchChatsOnServer...")
                                }
                                c.send(TdApi.SearchChatsOnServer(BOT_USERNAME, 5)) { searchRes ->
                                    val fallbackId = if (searchRes is TdApi.Chats && searchRes.chatIds.isNotEmpty()) {
                                        searchRes.chatIds[0]
                                    } else null
                                    if (fallbackId != null) {
                                        cachedBotChatId = fallbackId
                                        context.getSharedPreferences("CineflixPrefs", Context.MODE_PRIVATE)
                                            .edit().putLong("bot_chat_id", fallbackId).apply()
                                        Log.i(TAG, "Resolved bot chatId via SearchChatsOnServer: $fallbackId")
                                    }
                                    if (cont.isActive) cont.resume(fallbackId) {}
                                }
                            }
                        }
                    } catch (e: Exception) {
                        if (cont.isActive) cont.resume(null) {}
                    }
                }
            }
            resolvedId
        }
    }

    /** Public version for AndroidBridge (same logic, exposed outside package) */
    suspend fun getBotChatIdPublic(): Long? = getBotChatId()

    fun getClient(): Client? = client

    /**
     * Stop downloading and forcefully delete the file chunk from TDLib cache to free TV storage.
     */
    fun cancelAndDeleteVideo(fileId: Int) {
        if (fileId <= 0) return
        scope.launch(Dispatchers.IO) {
            val ok = boundedVideoCache.release(fileId)
            filePathEmitters.remove(fileId)
            fileStates.remove(fileId)
            Log.i(TAG, "Cleaning up TDLib cache fileId=$fileId ok=$ok")
        }
    }

    /**
     * Releases a specific set of old `fileId`s without disturbing any newly started stream's
     * `BoundedVideoCache` window or `tdlib_files` directory. Safe during channel zaps and movie switches.
     */
    fun releaseSpecificVideoFiles(fileIds: Collection<Int>) {
        val ids = fileIds.filter { it > 0 }.toSet()
        if (ids.isEmpty()) return
        scope.launch(Dispatchers.IO) {
            for (fid in ids) {
                boundedVideoCache.release(fid)
                filePathEmitters.remove(fid)
                fileStates.remove(fid)
            }
        }
    }

    /**
     * Releases all active streaming caches, transient RAM maps, and wipes `tdlib_files` on disk
     * sequentially after confirming TDLib has cancelled and closed every open file handle —
     * while aborting the global folder wipe if a new stream started concurrently!
     */
    fun purgeAllStreamingCaches(extraFileIds: Collection<Int> = emptyList()) {
        val genAtRequest = streamingSessionGeneration.get()
        val snapshotIds = LinkedHashSet<Int>().apply {
            extraFileIds.forEach { if (it > 0) add(it) }
            filePathEmitters.keys.forEach { if (it > 0) add(it) }
            fileStates.keys.forEach { if (it > 0) add(it) }
        }
        scope.launch(Dispatchers.IO) {
            try {
                for (fid in snapshotIds) {
                    boundedVideoCache.release(fid)
                    filePathEmitters.remove(fid)
                    fileStates.remove(fid)
                }
                if (streamingSessionGeneration.get() != genAtRequest || hasActiveStreamOwners()) {
                    Log.d(TAG, "purgeAllStreamingCaches: new stream active, skipped global tdlib_files wipe after releasing ${snapshotIds.size} old file(s)")
                    return@launch
                }
                boundedVideoCache.releaseAll()
                var wipedGlobal = false
                synchronized(boundedVideoCache) {
                    if (streamingSessionGeneration.get() == genAtRequest && !hasActiveStreamOwners()) {
                        filePathEmitters.clear()
                        fileStates.clear()
                        if (downloadLocks.size > 16) {
                            downloadLocks.clear()
                        }
                        com.cineflix.android.util.StorageAndRamHygiene.cleanTdlibTempFiles(context.cacheDir)
                        com.cineflix.android.util.StorageAndRamHygiene.cleanTdlibLogFiles(context.filesDir)
                        ensureDirectoriesExist()
                        wipedGlobal = true
                    }
                }
                if (wipedGlobal) {
                    optimizeStorage(0L, immunityDelaySec = 0)
                    logStreamStorage("post-playback-zero-purge")
                }
            } catch (e: Exception) {
                Log.w(TAG, "purgeAllStreamingCaches warning: ${e.message}")
            }
        }
    }

    /**
     * Synchronous version: cancel download + delete file and WAIT for TDLib
     * to confirm both operations. This ensures the file descriptor is closed
     * and disk space is actually freed before returning.
     */
    fun cancelAndDeleteVideoSync(fileId: Int, timeoutMs: Long = 5000): Boolean {
        val lock = downloadLocks.getOrPut(fileId) { Any() }
        val ok = synchronized(lock) {
            val c = client ?: return false
            val deadline = android.os.SystemClock.elapsedRealtime() + timeoutMs
            fun request(action: TdApi.Function<*>): TdApi.Object? {
                val latch = java.util.concurrent.CountDownLatch(1)
                var result: TdApi.Object? = null
                c.send(action) { result = it; latch.countDown() }
                val remaining = deadline - android.os.SystemClock.elapsedRealtime()
                if (remaining <= 0 || !latch.await(remaining, java.util.concurrent.TimeUnit.MILLISECONDS)) return null
                return result
            }
            try {
                // Fast-path: if file has never been downloaded and is not active, nothing is on disk to purge!
                val initial = request(TdApi.GetFile(fileId)) as? TdApi.File
                if (initial != null &&
                    !initial.local.isDownloadingActive &&
                    initial.local.downloadedSize == 0L &&
                    initial.local.path.isNullOrEmpty()
                ) {
                    return@synchronized true
                }

                // Cancel any active range download (ignore Error if already idle)
                request(TdApi.CancelDownloadFile(fileId, false))

                // Delete local cached file (tolerate Error if local path is already empty)
                val delRes = request(TdApi.DeleteFile(fileId))
                if (delRes == null) return@synchronized false

                // TDLib unlinks asynchronously on its disk thread; poll GetFile briefly until 0 bytes confirmed
                var confirmed = false
                while (android.os.SystemClock.elapsedRealtime() < deadline) {
                    val file = request(TdApi.GetFile(fileId)) as? TdApi.File ?: break
                    val localPath = file.local?.path.orEmpty()
                    val goneFromDisk = localPath.isEmpty() || !java.io.File(localPath).exists()
                    if (!file.local.isDownloadingActive && (file.local.downloadedSize == 0L || goneFromDisk)) {
                        confirmed = true
                        break
                    }
                    Thread.sleep(45L)
                }
                confirmed
            } catch (e: InterruptedException) {
                Thread.currentThread().interrupt()
                false
            }
        }
        if (ok) {
            filePathEmitters.remove(fileId)
            fileStates.remove(fileId)
        }
        return ok
    }

    /**
     * Ask TDLib's native C++ engine to optimize disk usage by removing old cached chunks.
     * Safe to call during or after playback as it does not abort active downloads.
     */
    fun optimizeStorage(maxSizeBytes: Long = 0L, immunityDelaySec: Int = 0) {
        val req = TdApi.OptimizeStorage(
            maxSizeBytes,
            0,            // ttl: 0 = eligible for deletion regardless of age
            0,            // count: 0 = no count limit
            immunityDelaySec, // immunityDelay: protect files accessed in the last N seconds
            null,
            null,
            null,
            false,
            0
        )
        client?.send(req) { result ->
            Log.d(TAG, "🧹 TDLib optimizeStorage completed (max=${maxSizeBytes}B, immunity=${immunityDelaySec}s): ${result.javaClass.simpleName}")
        }
    }

    /**
     * Returns the app's files directory for direct disk access.
     */
    fun getAppFilesDir(): java.io.File {
        return context.filesDir
    }

    /**
     * Envía un archivo de log de error al bot (@videoclubpacobot) como documento .txt y mensaje.
     */
    fun sendLogDocumentToBot(
        logFile: java.io.File, 
        caption: String, 
        onComplete: ((Boolean, String?) -> Unit)? = null
    ) {
        scope.launch(Dispatchers.IO) {
            try {
                if (!ensureReady()) {
                    Log.e(TAG, "Cannot send log to bot: TDLib not ready")
                    onComplete?.invoke(false, "TDLib no está listo")
                    return@launch
                }
                val c = client
                if (c == null) {
                    Log.e(TAG, "Cannot send log to bot: TDLib client is null")
                    onComplete?.invoke(false, "TDLib no está conectado")
                    return@launch
                }

                val chatId = getBotChatId()
                if (chatId == null) {
                    Log.e(TAG, "Cannot send log to bot: bot chatId is null")
                    onComplete?.invoke(false, "No se pudo encontrar el bot @$BOT_USERNAME")
                    return@launch
                }

                // Ensure chat is initialized in TDLib's in-memory ChatManager (useChatInfoDatabase = false)
                withTimeoutOrNull(2500L) {
                    val initDef = CompletableDeferred<Unit>()
                    c.send(TdApi.CreatePrivateChat(chatId, false)) {
                        c.send(TdApi.OpenChat(chatId)) { initDef.complete(Unit) }
                    }
                    initDef.await()
                }

                // 1. Send instant plain-text summary first so it arrives in <200ms with zero file-upload delay
                val textSummaryOk = runCatching {
                    val fullTxt = if (logFile.exists()) logFile.readText() else ""
                    val tailSnippet = if (fullTxt.length > 2600) fullTxt.takeLast(2600) else fullTxt
                    val bodyStr = if (tailSnippet.isNotBlank()) "$caption\n\n$tailSnippet" else caption
                    val msgBody = TdApi.InputMessageText(
                        TdApi.FormattedText(bodyStr.take(3950), emptyArray()),
                        null,
                        false
                    )
                    val txtDef = CompletableDeferred<Boolean>()
                    c.send(TdApi.SendMessage(chatId, null, null, null, null, msgBody)) { tRes ->
                        txtDef.complete(tRes !is TdApi.Error)
                    }
                    withTimeoutOrNull(10_000L) { txtDef.await() } == true
                }.getOrDefault(false)

                // 2. Also attach full .txt document (logFile is kept alive for 3 min by ErrorLogCollector)
                var docQueuedOk = false
                var lastErr: String? = null
                if (logFile.exists() && logFile.length() > 0L) {
                    Log.i(TAG, "📤 Enviando log document (${logFile.name}, ${logFile.length()} bytes) a chatId=$chatId")
                    val inputFile = TdApi.InputFileLocal(logFile.absolutePath)
                    val formattedCaption = TdApi.FormattedText(caption.take(950), emptyArray())
                    val docContent = TdApi.InputMessageDocument(inputFile, null, false, formattedCaption)

                    val deferred = CompletableDeferred<Pair<Boolean, String?>>()
                    c.send(TdApi.SendMessage(chatId, null, null, null, null, docContent)) { res ->
                        if (res is TdApi.Error) {
                            Log.e(TAG, "Error sending log document to bot: ${res.code} - ${res.message}")
                            deferred.complete(Pair(false, res.message))
                        } else {
                            Log.i(TAG, "Log document encolado en TDLib para envío al bot")
                            deferred.complete(Pair(true, null))
                        }
                    }
                    val docOutcome = withTimeoutOrNull(15_000L) { deferred.await() }
                        ?: Pair(false, "Timeout esperando confirmación del envío")
                    docQueuedOk = docOutcome.first
                    lastErr = docOutcome.second
                }

                onComplete?.invoke(textSummaryOk || docQueuedOk, if (textSummaryOk || docQueuedOk) null else lastErr)
            } catch (e: Exception) {
                Log.e(TAG, "Exception enviando log al bot: ${e.message}", e)
                onComplete?.invoke(false, e.message)
            }
        }
    }
}
