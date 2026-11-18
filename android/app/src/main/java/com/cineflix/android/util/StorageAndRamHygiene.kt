package com.cineflix.android.util

import android.app.ActivityManager
import android.app.UiModeManager
import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.os.Environment
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.io.File
import java.util.Locale
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Central storage & RAM hygiene controller for Cineflix Android / Android TV.
 *
 * Guarantees that:
 *  1. App User Data (`filesDir/tdlib_data` + `app_webview`) never grows unboundedly over weeks/months,
 *     while 100% preserving Telegram authentication (`td.binlog`), `SharedPreferences`, `localStorage`,
 *     and active catalog metadata.
 *  2. Disposable caches (`tdlib_files`, WebView HTTP/Code/GPU/ServiceWorker caches, OTA `.apk`s,
 *     and diagnostic `.txt` crash reports) are strictly bounded and purged after use without racing
 *     Chromium's open `SimpleCache` / `mmap` descriptors.
 *  3. Video playback RAM budgets (`ExoPlayer` `DefaultLoadControl` + `LocalStreamServer` read-ahead)
 *     adapt to real device RAM with hard byte caps so 4K Remux streams never exhaust Android TV RAM.
 */
object StorageAndRamHygiene {

    private const val TAG = "StorageHygiene"
    const val PREF_PENDING_PRE_WEBVIEW_PURGE = "pending_pre_webview_purge"
    private const val WEBVIEW_TRASH_PREFIX = "webview_trash_"

    const val DEFAULT_TV_WEBVIEW_CACHE_CAP_BYTES = 28L * 1024L * 1024L      // 28 MB max on Android TV
    const val DEFAULT_MOBILE_WEBVIEW_CACHE_CAP_BYTES = 40L * 1024L * 1024L  // 40 MB max on phones/tablets
    private const val IMAGE_DISK_CACHE_CAP_BYTES = 8L * 1024L * 1024L       // 8 MB max for Coil/OkHttp cache

    private val webViewInitializedInProcess = AtomicBoolean(false)
    private val backgroundHygieneScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    fun markWebViewInitialized() {
        webViewInitializedInProcess.set(true)
    }

    fun isWebViewInitializedInProcess(): Boolean = webViewInitializedInProcess.get()

    internal fun resetWebViewInitializedForTesting() {
        webViewInitializedInProcess.set(false)
    }

    fun launchBackgroundHygiene(block: suspend CoroutineScope.() -> Unit) {
        backgroundHygieneScope.launch(block = block)
    }

    private val TDLIB_REQUIRED_CACHE_SUBDIRS = listOf(
        "temp", "videos", "documents", "thumbnails", "profile_photos"
    )

    private val TDLIB_LEGACY_DATA_SUBDIRS = setOf(
        "videos", "documents", "profile_photos", "thumbnails", "temp",
        "stickers", "animations", "voice", "music", "video_notes",
        "wallpapers", "passport", "secret", "secret_thumbnails"
    )

    data class StorageReport(
        val tdlibDataBytes: Long,
        val tdlibCacheBytes: Long,
        val webViewDisposableCacheBytes: Long,
        val webViewPersistentBytes: Long,
        val otherCacheBytes: Long
    ) {
        val totalBytes: Long
            get() = tdlibDataBytes + tdlibCacheBytes + webViewDisposableCacheBytes + webViewPersistentBytes + otherCacheBytes

        val totalDisposableBytes: Long
            get() = tdlibCacheBytes + webViewDisposableCacheBytes + otherCacheBytes

        fun toJsonString(): String {
            return JSONObject().apply {
                put("tdlibDataBytes", tdlibDataBytes)
                put("tdlibCacheBytes", tdlibCacheBytes)
                put("webViewCacheBytes", webViewDisposableCacheBytes)
                put("webViewPersistentBytes", webViewPersistentBytes)
                put("otherCacheBytes", otherCacheBytes)
                put("totalBytes", totalBytes)
                put("totalDisposableBytes", totalDisposableBytes)
                put("totalMB", String.format(Locale.US, "%.1f", totalBytes / (1024.0 * 1024.0)))
            }.toString()
        }
    }

    data class PlayerRamBudget(
        val exoTargetBufferBytes: Int,
        val minBufferMs: Int,
        val maxBufferMs: Int,
        val bufferForPlaybackMs: Int,
        val bufferForPlaybackAfterRebufferMs: Int,
        val localServerPrefetchBytes: Long,
        val prioritizeTimeOverSizeThresholds: Boolean
    )

    fun computeOptimalPlayerRamBudget(totalDeviceRamBytes: Long, isTv: Boolean): PlayerRamBudget {
        val mb = 1024 * 1024
        return when {
            totalDeviceRamBytes in 1..(1_650L * mb) -> PlayerRamBudget(
                exoTargetBufferBytes = 18 * mb,
                minBufferMs = 12_000,
                maxBufferMs = 24_000,
                bufferForPlaybackMs = 2_500,
                bufferForPlaybackAfterRebufferMs = 4_500,
                localServerPrefetchBytes = 2L * mb,
                prioritizeTimeOverSizeThresholds = false
            )
            totalDeviceRamBytes in 1..(2_700L * mb) || isTv && totalDeviceRamBytes <= 0L -> PlayerRamBudget(
                exoTargetBufferBytes = 28 * mb,
                minBufferMs = 15_000,
                maxBufferMs = 30_000,
                bufferForPlaybackMs = 2_500,
                bufferForPlaybackAfterRebufferMs = 4_500,
                localServerPrefetchBytes = 4L * mb,
                prioritizeTimeOverSizeThresholds = false
            )
            totalDeviceRamBytes <= 4_500L * mb -> PlayerRamBudget(
                exoTargetBufferBytes = 40 * mb,
                minBufferMs = 18_000,
                maxBufferMs = 35_000,
                bufferForPlaybackMs = 2_500,
                bufferForPlaybackAfterRebufferMs = 4_500,
                localServerPrefetchBytes = 4L * mb,
                prioritizeTimeOverSizeThresholds = false
            )
            else -> PlayerRamBudget(
                exoTargetBufferBytes = 56 * mb,
                minBufferMs = 20_000,
                maxBufferMs = 40_000,
                bufferForPlaybackMs = 2_500,
                bufferForPlaybackAfterRebufferMs = 4_500,
                localServerPrefetchBytes = 4L * mb,
                prioritizeTimeOverSizeThresholds = false
            )
        }
    }

    fun resolvePlayerRamBudget(context: Context): PlayerRamBudget {
        val isTv = isTelevision(context)
        val totalRam = try {
            val am = context.getSystemService(Context.ACTIVITY_SERVICE) as? ActivityManager
            val memInfo = ActivityManager.MemoryInfo()
            am?.getMemoryInfo(memInfo)
            memInfo.totalMem
        } catch (_: Throwable) {
            0L
        }
        return computeOptimalPlayerRamBudget(totalRam, isTv)
    }

    @Volatile
    private var runtimeTelevisionDetected = false

    fun markTelevisionDetectedAtRuntime() {
        runtimeTelevisionDetected = true
    }

    internal fun resetRuntimeTelevisionForTesting() {
        runtimeTelevisionDetected = false
    }

    internal fun isTelevisionDevice(
        uiModeType: Int,
        hasLeanback: Boolean,
        hasTelevisionFeature: Boolean,
        hasTouchscreen: Boolean,
        runtimeDetected: Boolean = false
    ): Boolean {
        if (runtimeDetected) return true
        if (uiModeType == Configuration.UI_MODE_TYPE_TELEVISION) return true
        if (hasLeanback || hasTelevisionFeature) return true
        if (uiModeType == Configuration.UI_MODE_TYPE_WATCH || uiModeType == Configuration.UI_MODE_TYPE_CAR) {
            return false
        }
        // Non-touchscreen AOSP HDMI TV boxes often report UI_MODE_TYPE_NORMAL without FEATURE_LEANBACK
        return !hasTouchscreen
    }

    internal fun shouldUpgradeToTvModeOnDpad(
        isRemoteDpadKey: Boolean,
        isAlphabeticKeyboard: Boolean,
        hasTelephony: Boolean,
        isDedicatedRemoteDeviceName: Boolean = false
    ): Boolean {
        if (!isRemoteDpadKey) return false
        // Do not activate on-screen virtual keyboard mode when a physical Bluetooth/USB QWERTY keyboard is used on a tablet/phone
        if (isAlphabeticKeyboard && !isDedicatedRemoteDeviceName) return false
        // Upgrade non-telephony AOSP boxes (even if ROM falsely advertises FEATURE_TOUCHSCREEN)
        // or dedicated IR/HDMI-CEC/2.4GHz TV remote receivers on sloppy generic AOSP ROMs
        return !hasTelephony || isDedicatedRemoteDeviceName
    }

    fun isTelevision(context: Context): Boolean {
        if (runtimeTelevisionDetected) return true
        return try {
            val uiMode = context.getSystemService(Context.UI_MODE_SERVICE) as? UiModeManager
            val uiModeType = uiMode?.currentModeType ?: Configuration.UI_MODE_TYPE_NORMAL
            val pm = context.packageManager
            val hasLeanback = pm.hasSystemFeature(android.content.pm.PackageManager.FEATURE_LEANBACK) ||
                pm.hasSystemFeature("android.software.leanback_only")
            @Suppress("DEPRECATION")
            val hasTvFeature = pm.hasSystemFeature(android.content.pm.PackageManager.FEATURE_TELEVISION)
            val hasTouchscreen = pm.hasSystemFeature(android.content.pm.PackageManager.FEATURE_TOUCHSCREEN)
            isTelevisionDevice(
                uiModeType = uiModeType,
                hasLeanback = hasLeanback,
                hasTelevisionFeature = hasTvFeature,
                hasTouchscreen = hasTouchscreen,
                runtimeDetected = runtimeTelevisionDetected
            )
        } catch (_: Throwable) {
            runtimeTelevisionDetected
        }
    }

    /**
     * Preserves `td.binlog*` (which stores Telegram's auth keys and DC session) while removing
     * bloated SQLite databases (`db.sqlite*`), native TDLib `.log` files, and legacy media subdirs
     * inside `filesDir/tdlib_data` (and `tdlib_data_alt`).
     *
     * Must only be called when TDLib has been configured with `useFileDatabase = false`,
     * `useChatInfoDatabase = false`, `useMessageDatabase = false` (so `db.sqlite` is not open).
     */
    fun cleanTdlibDatabaseBloat(filesDir: File): Long {
        var reclaimed = 0L
        for (dirName in listOf("tdlib_data", "tdlib_data_alt")) {
            val dbDir = File(filesDir, dirName)
            if (!dbDir.exists() || !dbDir.isDirectory) continue

            dbDir.listFiles()?.forEach { child ->
                val nameLower = child.name.lowercase(Locale.ROOT)
                if (child.isDirectory) {
                    if (nameLower in TDLIB_LEGACY_DATA_SUBDIRS) {
                        val sz = measureDirectoryBytes(child)
                        if (deleteRecursivelySafe(child)) {
                            reclaimed += sz
                        }
                    }
                } else {
                    val isProtectedAuthFile = nameLower.startsWith("td.binlog") ||
                        nameLower.contains("binlog") ||
                        nameLower.contains("auth") ||
                        nameLower.contains("key")
                    val isDisposableBloat = !isProtectedAuthFile && (
                        nameLower.startsWith("db.sqlite") ||
                            nameLower.endsWith(".sqlite") ||
                            nameLower.endsWith(".sqlite-wal") ||
                            nameLower.endsWith(".sqlite-shm") ||
                            nameLower.endsWith(".sqlite-journal") ||
                            nameLower.endsWith(".log") ||
                            nameLower.endsWith(".log.old")
                        )
                    if (isDisposableBloat) {
                        val len = child.length()
                        if (runCatching { child.delete() }.getOrDefault(false)) {
                            reclaimed += len
                        }
                    }
                }
            }
        }

        if (reclaimed > 0L) {
            Log.i(TAG, "🧹 Reclaimed ${reclaimed / 1024} KB of TDLib database/log bloat from tdlib_data")
        }
        return reclaimed
    }

    /**
     * Deletes only native TDLib log files (`tdlib.log`, `tdlib.log.old`) safe to remove even before `Ready`.
     */
    fun cleanTdlibLogFiles(filesDir: File): Long {
        var reclaimed = 0L
        for (dirName in listOf("tdlib_data", "tdlib_data_alt")) {
            val dbDir = File(filesDir, dirName)
            if (!dbDir.exists() || !dbDir.isDirectory) continue
            dbDir.listFiles()?.forEach { f ->
                val n = f.name.lowercase(Locale.ROOT)
                if (f.isFile && (n == "tdlib.log" || n == "tdlib.log.old" || n.endsWith(".log"))) {
                    val len = f.length()
                    if (runCatching { f.delete() }.getOrDefault(false)) {
                        reclaimed += len
                    }
                }
            }
        }
        return reclaimed
    }

    /**
     * Wipes all downloaded chunks, thumbnails, avatars, stickers, and temporary files inside
     * `cacheDir/tdlib_files` while strictly keeping the directory skeleton required by TDLib C++.
     */
    fun cleanTdlibTempFiles(cacheDir: File): Long {
        val cacheBase = File(cacheDir, "tdlib_files")
        var reclaimed = 0L
        if (cacheBase.exists() && cacheBase.isDirectory) {
            cacheBase.listFiles()?.forEach { child ->
                if (child.isDirectory) {
                    reclaimed += clearDirectoryContents(child)
                    if (child.name !in TDLIB_REQUIRED_CACHE_SUBDIRS) {
                        runCatching { child.delete() }
                    }
                } else {
                    val len = child.length()
                    if (runCatching { child.delete() }.getOrDefault(false)) {
                        reclaimed += len
                    }
                }
            }
        }
        ensureTdlibCacheSkeleton(cacheBase)
        if (reclaimed > 0L) {
            Log.i(TAG, "🧹 Purged ${reclaimed / 1024} KB from tdlib_files cache")
        }
        return reclaimed
    }

    fun ensureTdlibCacheSkeleton(cacheBase: File) {
        try {
            if (!cacheBase.exists()) cacheBase.mkdirs()
            cacheBase.setReadable(true, false)
            cacheBase.setWritable(true, false)
            cacheBase.setExecutable(true, false)
            for (sub in TDLIB_REQUIRED_CACHE_SUBDIRS) {
                val d = File(cacheBase, sub)
                if (!d.exists()) d.mkdirs()
                d.setReadable(true, false)
                d.setWritable(true, false)
                d.setExecutable(true, false)
            }
        } catch (_: Throwable) {}
    }

    /**
     * Removes leftover OTA `.apk` packages, sent/stale crash report `.txt` files, and oversized
     * image disk caches inside `cacheDir` (plus stale external `Downloads/cineflix_update.apk`).
     */
    fun cleanEphemeralCacheArtifacts(
        cacheDir: File,
        maxCrashReportAgeMs: Long = 0L,
        maxOtaApkAgeMs: Long = 20L * 60_000L,
        nowMs: Long = System.currentTimeMillis()
    ): Long {
        var reclaimed = 0L
        if (!cacheDir.exists()) return 0L

        // 1. Leftover OTA update APKs in cacheDir
        cacheDir.listFiles()?.forEach { child ->
            val nameLower = child.name.lowercase(Locale.ROOT)
            if (child.isFile && nameLower.endsWith(".apk")) {
                val age = nowMs - child.lastModified()
                if (maxOtaApkAgeMs <= 0L || age >= maxOtaApkAgeMs) {
                    val len = child.length()
                    if (runCatching { child.delete() }.getOrDefault(false)) {
                        reclaimed += len
                    }
                }
            } else if (child.isDirectory && (nameLower == "image_cache" || nameLower.contains("okhttp"))) {
                val dirSize = measureDirectoryBytes(child)
                if (maxOtaApkAgeMs <= 0L || dirSize > IMAGE_DISK_CACHE_CAP_BYTES) {
                    reclaimed += clearDirectoryContents(child)
                }
            }
        }

        // 2. Diagnostic crash_reports/*.txt
        val crashDir = File(cacheDir, "crash_reports")
        if (crashDir.exists() && crashDir.isDirectory) {
            crashDir.listFiles()?.forEach { report ->
                if (report.isFile) {
                    val age = nowMs - report.lastModified()
                    if (maxCrashReportAgeMs <= 0L || age >= maxCrashReportAgeMs) {
                        val len = report.length()
                        if (runCatching { report.delete() }.getOrDefault(false)) {
                            reclaimed += len
                        }
                    }
                }
            }
        }

        // 3. Best-effort cleanup of stale Downloads/cineflix_update.apk
        try {
            val pubDownloads = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
            if (pubDownloads != null && pubDownloads.exists()) {
                val extApk = File(pubDownloads, "cineflix_update.apk")
                if (extApk.exists() && (maxOtaApkAgeMs <= 0L || (nowMs - extApk.lastModified()) >= maxOtaApkAgeMs)) {
                    val len = extApk.length()
                    if (extApk.delete()) {
                        reclaimed += len
                    }
                }
            }
        } catch (_: Throwable) {}

        if (reclaimed > 0L) {
            Log.i(TAG, "🧹 Reclaimed ${reclaimed / 1024} KB of ephemeral APK/log/image cache artifacts")
        }
        return reclaimed
    }

    private val sharedCompatSslSocketFactory: javax.net.ssl.SSLSocketFactory? by lazy {
        try {
            val trustAllCerts = arrayOf<javax.net.ssl.TrustManager>(object : javax.net.ssl.X509TrustManager {
                override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate> = emptyArray()
                override fun checkClientTrusted(certs: Array<java.security.cert.X509Certificate>?, authType: String?) {}
                override fun checkServerTrusted(certs: Array<java.security.cert.X509Certificate>?, authType: String?) {}
            })
            val sc = javax.net.ssl.SSLContext.getInstance("TLS")
            sc.init(null, trustAllCerts, java.security.SecureRandom())
            sc.socketFactory
        } catch (_: Throwable) {
            null
        }
    }

    private val sharedCompatHostnameVerifier = javax.net.ssl.HostnameVerifier { _, _ -> true }

    /**
     * Opens an HTTP/HTTPS connection compatible with older Android 5-7 TV boxes whose system trust store
     * has expired ISRG Root X1 Let's Encrypt roots, reusing a single lazy `SSLContext` instead of
     * allocating a new `SSLContext` + `SecureRandom` per request.
     */
    fun openCompatUrlConnection(urlStr: String): java.net.HttpURLConnection {
        val conn = java.net.URL(urlStr).openConnection() as java.net.HttpURLConnection
        if (conn is javax.net.ssl.HttpsURLConnection && Build.VERSION.SDK_INT < Build.VERSION_CODES.N_MR1) {
            sharedCompatSslSocketFactory?.let { conn.sslSocketFactory = it }
            conn.hostnameVerifier = sharedCompatHostnameVerifier
        }
        return conn
    }

    private fun getWebViewDisposableDirs(dataDir: File, cacheDir: File): List<File> {
        val webViewRoot = File(dataDir, "app_webview")
        val defaultProfile = File(webViewRoot, "Default")
        return listOf(
            File(cacheDir, "WebView"),
            File(cacheDir, "org.chromium.android_webview"),
            File(webViewRoot, "Cache"),
            File(webViewRoot, "GPUCache"),
            File(webViewRoot, "Code Cache"),
            File(webViewRoot, "GrShaderCache"),
            File(webViewRoot, "GraphiteDawnCache"),
            File(webViewRoot, "Crashpad"),
            File(webViewRoot, "BrowserMetrics"),
            File(defaultProfile, "Cache"),
            File(defaultProfile, "Media Cache"),
            File(defaultProfile, "Code Cache"),
            File(defaultProfile, "GPUCache"),
            File(defaultProfile, "DawnCache"),
            File(defaultProfile, "blob_storage"),
            File(defaultProfile, "File System"),
            File(defaultProfile, "Service Worker/CacheStorage"),
            File(defaultProfile, "Service Worker/ScriptCache")
        )
    }

    /**
     * Detached Crashpad minidump folders that do NOT hold Chromium `SimpleCache` index locks or
     * `mmap`ped shader/histogram pages, making them safe to delete on `Dispatchers.IO` even while
     * `WebView` is active.
     */
    private fun getWebViewSafeDetachedDirsWhileActive(dataDir: File): List<File> {
        val crashpadRoot = File(File(dataDir, "app_webview"), "Crashpad")
        return listOf(
            File(crashpadRoot, "completed"),
            File(crashpadRoot, "pending"),
            File(crashpadRoot, "new"),
            File(crashpadRoot, "attachments")
        )
    }

    /**
     * Atomically `O(1)`-renames (`File.renameTo`) disposable WebView cache directories into an
     * unreferenced staging trash folder inside [cacheDir] BEFORE `WebView(context)` is first
     * instantiated in the process (0 open Chromium FDs, `< 1 ms` on main thread), allowing
     * [cleanStagedWebViewTrash] to delete the files asynchronously on `Dispatchers.IO` with zero
     * `SimpleCache` race conditions.
     *
     * NEVER touches `Local Storage`, `Cookies`, `IndexedDB`, or `Session Storage`.
     */
    fun stageWebViewCachesForAsyncDeletion(dataDir: File, cacheDir: File): Boolean {
        if (isWebViewInitializedInProcess()) {
            Log.w(TAG, "stageWebViewCachesForAsyncDeletion skipped: WebView already initialized in process")
            return false
        }
        val stamp = System.nanoTime()
        // Keep each staged rename inside its own Android installd quota root (dataDir vs cacheDir)
        // because ext4/f2fs project quotas reject cross-project directory rename() with -EXDEV!
        val dataTrashBatch = File(dataDir, "$WEBVIEW_TRASH_PREFIX$stamp")
        val cacheTrashBatch = File(cacheDir, "$WEBVIEW_TRASH_PREFIX$stamp")
        val cacheRootPath = runCatching { cacheDir.canonicalPath }.getOrElse { cacheDir.absolutePath }
        var movedOrClearedAny = false
        try {
            val webViewRoot = File(dataDir, "app_webview")
            val spareMetricsFile = File(webViewRoot, "BrowserMetrics-spare.pma")
            val dirs = getWebViewDisposableDirs(dataDir, cacheDir)
            for ((idx, dir) in dirs.withIndex()) {
                if (!dir.exists()) continue
                val dirPath = runCatching { dir.canonicalPath }.getOrElse { dir.absolutePath }
                val targetBatch = if (dirPath.startsWith(cacheRootPath)) cacheTrashBatch else dataTrashBatch
                if (!targetBatch.exists()) targetBatch.mkdirs()
                val dest = File(targetBatch, "d_$idx")
                if (runCatching { dir.renameTo(dest) }.getOrDefault(false)) {
                    movedOrClearedAny = true
                } else if (!isWebViewInitializedInProcess()) {
                    // Safe fallback before WebView(context) opens any FDs if a ROM/filesystem refuses rename
                    if (clearDirectoryContents(dir) > 0L || deleteRecursivelySafe(dir)) {
                        movedOrClearedAny = true
                    }
                }
            }
            if (spareMetricsFile.isFile) {
                if (!dataTrashBatch.exists()) dataTrashBatch.mkdirs()
                val destMetrics = File(dataTrashBatch, "BrowserMetrics-spare.pma")
                if (runCatching { spareMetricsFile.renameTo(destMetrics) }.getOrDefault(false)) {
                    movedOrClearedAny = true
                } else if (!isWebViewInitializedInProcess() && runCatching { spareMetricsFile.delete() }.getOrDefault(false)) {
                    movedOrClearedAny = true
                }
            }
        } catch (e: Throwable) {
            Log.w(TAG, "stageWebViewCachesForAsyncDeletion warning: ${e.message}")
        }
        return movedOrClearedAny
    }

    /**
     * Deletes any unreferenced `webview_trash_*` directories previously staged by
     * [stageWebViewCachesForAsyncDeletion] in [cacheDir] and/or [dataDir].
     * Safe to run at any time on `Dispatchers.IO`.
     */
    fun cleanStagedWebViewTrash(cacheDir: File, dataDir: File? = null): Long {
        var freed = 0L
        val roots = buildList {
            add(cacheDir)
            if (dataDir != null && dataDir.absolutePath != cacheDir.absolutePath) {
                add(dataDir)
            }
        }
        for (root in roots) {
            if (!root.exists() || !root.isDirectory) continue
            root.listFiles()?.forEach { child ->
                if (child.name.startsWith(WEBVIEW_TRASH_PREFIX)) {
                    val sz = measureDirectoryBytes(child)
                    if (deleteRecursivelySafe(child)) {
                        freed += sz
                    }
                }
            }
        }
        return freed
    }

    fun measureWebViewDisposableCacheBytes(dataDir: File, cacheDir: File): Long {
        val webViewRoot = File(dataDir, "app_webview")
        val spareMetricsFile = File(webViewRoot, "BrowserMetrics-spare.pma")
        var total = if (spareMetricsFile.isFile) spareMetricsFile.length().coerceAtLeast(0L) else 0L
        for (dir in getWebViewDisposableDirs(dataDir, cacheDir)) {
            if (dir.exists()) {
                total += measureDirectoryBytes(dir)
            }
        }
        return total
    }

    /**
     * Checks Chromium WebView's disposable HTTP/Code/GPU/Blob/Crashpad/OPFS/ServiceWorker caches and
     * enforces [maxCacheBytes] (or unconditionally if `maxCacheBytes <= 0L`).
     *
     *  - When [isWebViewActive] is `false` (before `WebView` is initialized in this process), clears
     *    all disposable cache directories on disk directly.
     *  - When [isWebViewActive] is `true` (Chromium already holds open `SimpleCache` / `mmap` FDs),
     *    NEVER unlinks live `Cache`, `Code Cache`, `GPUCache`, `DawnCache`, or `BrowserMetrics` files
     *    under Chromium; instead sweeps only detached `Crashpad` dumps + staged `webview_trash_*` and
     *    returns `wasOverQuota = true` so the caller purges HTTP/RAM cache safely via
     *    `webView.clearCache(true)` on the UI thread (and flags cold-boot staging if needed).
     *
     * NEVER touches `Local Storage`, `Cookies`, `IndexedDB`, or `Session Storage`.
     *
     * @return Pair(wasOverQuota, bytesReclaimedDirectlyOnDisk)
     */
    fun enforceWebViewCacheQuota(
        dataDir: File,
        cacheDir: File,
        maxCacheBytes: Long,
        isWebViewActive: Boolean = isWebViewInitializedInProcess()
    ): Pair<Boolean, Long> {
        val trashFreed = cleanStagedWebViewTrash(cacheDir, dataDir)
        val currentBytes = measureWebViewDisposableCacheBytes(dataDir, cacheDir)
        if (maxCacheBytes > 0L && currentBytes <= maxCacheBytes) {
            return Pair(false, trashFreed)
        }

        var reclaimed = trashFreed
        if (isWebViewActive) {
            for (safeDir in getWebViewSafeDetachedDirsWhileActive(dataDir)) {
                if (safeDir.exists() && safeDir.isDirectory) {
                    reclaimed += clearDirectoryContents(safeDir)
                }
            }
            Log.i(
                TAG,
                "🧹 WebView disposable cache over quota (${currentBytes / (1024 * 1024)}MB > ${maxCacheBytes / (1024 * 1024)}MB) " +
                    "while WebView active: delegating HTTP cache purge to WebView.clearCache(true) on UI thread (detachedFreed=${reclaimed / 1024}KB)"
            )
            return Pair(true, reclaimed)
        }

        val webViewRoot = File(dataDir, "app_webview")
        val spareMetricsFile = File(webViewRoot, "BrowserMetrics-spare.pma")
        if (spareMetricsFile.isFile) {
            val sz = spareMetricsFile.length().coerceAtLeast(0L)
            if (runCatching { spareMetricsFile.delete() }.getOrDefault(false)) {
                reclaimed += sz
            }
        }
        for (dir in getWebViewDisposableDirs(dataDir, cacheDir)) {
            if (dir.exists() && dir.isDirectory) {
                reclaimed += clearDirectoryContents(dir)
            }
        }
        Log.i(
            TAG,
            "🧹 WebView disposable cache exceeded quota (${currentBytes / (1024 * 1024)}MB > ${maxCacheBytes / (1024 * 1024)}MB): " +
                "reclaimed ${reclaimed / (1024 * 1024)}MB"
        )
        return Pair(true, reclaimed)
    }

    fun measureAppStorageBytes(dataDir: File, cacheDir: File): StorageReport {
        val tdlibDataDir = File(dataDir, "files/tdlib_data")
        val tdlibCacheDir = File(cacheDir, "tdlib_files")
        val webViewRoot = File(dataDir, "app_webview")
        val spareMetricsFile = File(webViewRoot, "BrowserMetrics-spare.pma")
        val spareMetricsBytes = if (spareMetricsFile.isFile) spareMetricsFile.length().coerceAtLeast(0L) else 0L

        val tdlibDataBytes = measureDirectoryBytes(tdlibDataDir)
        val tdlibCacheBytes = measureDirectoryBytes(tdlibCacheDir)

        val disposableDirs = getWebViewDisposableDirs(dataDir, cacheDir)
        var webViewDisposableBytes = spareMetricsBytes
        for (d in disposableDirs) {
            webViewDisposableBytes += measureDirectoryBytes(d)
        }
        val stagedCacheTrashBytes = cacheDir.listFiles()
            ?.filter { it.name.startsWith(WEBVIEW_TRASH_PREFIX) }
            ?.sumOf { measureDirectoryBytes(it) }
            ?: 0L
        val stagedDataTrashBytes = if (dataDir.absolutePath != cacheDir.absolutePath) {
            dataDir.listFiles()
                ?.filter { it.name.startsWith(WEBVIEW_TRASH_PREFIX) }
                ?.sumOf { measureDirectoryBytes(it) }
                ?: 0L
        } else {
            0L
        }
        webViewDisposableBytes += stagedCacheTrashBytes + stagedDataTrashBytes

        val totalWebViewRoot = measureDirectoryBytes(webViewRoot)
        val disposableInsideRoot = spareMetricsBytes + disposableDirs
            .filter { it.absolutePath.startsWith(webViewRoot.absolutePath) }
            .sumOf { measureDirectoryBytes(it) }
        val webViewPersistentBytes = (totalWebViewRoot - disposableInsideRoot).coerceAtLeast(0L)

        val totalCacheDir = measureDirectoryBytes(cacheDir)
        val cacheWebViewPortion = stagedCacheTrashBytes + disposableDirs
            .filter { it.absolutePath.startsWith(cacheDir.absolutePath) }
            .sumOf { measureDirectoryBytes(it) }
        val otherCacheBytes = (totalCacheDir - tdlibCacheBytes - cacheWebViewPortion).coerceAtLeast(0L)

        return StorageReport(
            tdlibDataBytes = tdlibDataBytes,
            tdlibCacheBytes = tdlibCacheBytes,
            webViewDisposableCacheBytes = webViewDisposableBytes,
            webViewPersistentBytes = webViewPersistentBytes,
            otherCacheBytes = otherCacheBytes
        )
    }

    /**
     * JavaScript snippet injected once per session into the Android WebView to:
     *  1. Unregister unused Service Workers (`/sw.js` is only needed for browser GramJS streaming,
     *     never on native Android where `LocalStreamServer` streams directly).
     *  2. Purge all `CacheStorage` (`window.caches`) buckets and OPFS (Origin Private File System) ROM blobs.
     *  3. Evict obsolete `v1`/`v2`/`v3` catalog entries in `cineflix_storage` IndexedDB and any
     *     leftover web-emulator ROM IndexedDB databases while keeping `v4` movies, `v3` series,
     *     `localStorage`, and user credentials intact.
     */
    fun buildWebViewStorageHygieneJs(forceCompactIdb: Boolean = false): String {
        val forceFlag = if (forceCompactIdb) "true" else "false"
        return """
            (function() {
                if (window.__cfNativeStorageHygieneRan && !$forceFlag) return;
                window.__cfNativeStorageHygieneRan = true;
                try {
                    if (navigator.serviceWorker && typeof navigator.serviceWorker.getRegistrations === 'function') {
                        navigator.serviceWorker.getRegistrations().then(function(regs) {
                            for (var i = 0; i < regs.length; i++) {
                                try { regs[i].unregister(); } catch (_) {}
                            }
                        }).catch(function(){});
                    }
                } catch (_) {}
                try {
                    if (window.caches && typeof window.caches.keys === 'function') {
                        window.caches.keys().then(function(keys) {
                            for (var k = 0; k < keys.length; k++) {
                                try { window.caches.delete(keys[k]); } catch (_) {}
                            }
                        }).catch(function(){});
                    }
                } catch (_) {}
                try {
                    if ($forceFlag && navigator.storage && typeof navigator.storage.getDirectory === 'function') {
                        navigator.storage.getDirectory().then(function(root) {
                            if (root && typeof root.keys === 'function') {
                                var it = root.keys();
                                function step() {
                                    it.next().then(function(r) {
                                        if (r.done) return;
                                        try { root.removeEntry(r.value, { recursive: true }).catch(function(){}); } catch (_) {}
                                        step();
                                    }).catch(function(){});
                                }
                                step();
                            }
                        }).catch(function(){});
                    }
                } catch (_) {}
                try {
                    if (window.indexedDB) {
                        var staleEmulatorDbs = ['RetroArch', 'emularity', 'dosbox', 'js-dos', 'idbfs', '/home/web_user/retroarch/userdata'];
                        for (var d = 0; d < staleEmulatorDbs.length; d++) {
                            try { window.indexedDB.deleteDatabase(staleEmulatorDbs[d]); } catch (_) {}
                        }
                        if (typeof window.indexedDB.databases === 'function') {
                            window.indexedDB.databases().then(function(dbs) {
                                if (!dbs) return;
                                for (var j = 0; j < dbs.length; j++) {
                                    var name = dbs[j] && dbs[j].name ? String(dbs[j].name) : '';
                                    if (name && name !== 'cineflix_storage' &&
                                        /retroarch|emulator|emularity|dosbox|jsdos|scummvm|opfs/i.test(name)) {
                                        try { window.indexedDB.deleteDatabase(name); } catch (_) {}
                                    }
                                }
                            }).catch(function(){});
                        }
                        var openReq = window.indexedDB.open('cineflix_storage', 1);
                        openReq.onsuccess = function() {
                            try {
                                var db = openReq.result;
                                if (!db.objectStoreNames.contains('cache')) { db.close(); return; }
                                var tx = db.transaction('cache', 'readwrite');
                                var store = tx.objectStore('cache');
                                var staleKeys = [
                                    'cineflix_movies_cache', 'cineflix_movies_cache_v1', 'cineflix_movies_cache_v2', 'cineflix_movies_cache_v3',
                                    'cineflix_movies_cache_v1_kids', 'cineflix_movies_cache_v2_kids', 'cineflix_movies_cache_v3_kids',
                                    'cineflix_catalog_cache', 'cineflix_catalog_cache_v1', 'cineflix_catalog_cache_v2',
                                    'cineflix_catalog_cache_v1_kids', 'cineflix_catalog_cache_v2_kids'
                                ];
                                for (var s = 0; s < staleKeys.length; s++) {
                                    try { store.delete(staleKeys[s]); } catch (_) {}
                                }
                                tx.oncomplete = function() { try { db.close(); } catch (_) {} };
                                tx.onerror = function() { try { db.close(); } catch (_) {} };
                            } catch (_) {}
                        };
                    }
                } catch (_) {}
            })();
        """.trimIndent()
    }

    fun measureDirectoryBytes(root: File): Long {
        if (!root.exists()) return 0L
        if (root.isFile) return root.length().coerceAtLeast(0L)
        var sum = 0L
        val stack = ArrayDeque<File>()
        stack.addLast(root)
        while (stack.isNotEmpty()) {
            val cur = stack.removeLast()
            val children = try { cur.listFiles() } catch (_: Throwable) { null } ?: continue
            for (c in children) {
                if (c.isDirectory) {
                    stack.addLast(c)
                } else {
                    sum += c.length().coerceAtLeast(0L)
                }
            }
        }
        return sum
    }

    private fun clearDirectoryContents(dir: File): Long {
        if (!dir.exists() || !dir.isDirectory) return 0L
        var freed = 0L
        dir.listFiles()?.forEach { child ->
            val sz = measureDirectoryBytes(child)
            if (deleteRecursivelySafe(child)) {
                freed += sz
            }
        }
        return freed
    }

    private fun deleteRecursivelySafe(target: File): Boolean {
        if (!target.exists()) return true
        if (target.isDirectory) {
            target.listFiles()?.forEach { child ->
                deleteRecursivelySafe(child)
            }
        }
        return runCatching { target.delete() }.getOrDefault(false)
    }
}
