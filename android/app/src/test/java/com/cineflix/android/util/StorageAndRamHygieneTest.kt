package com.cineflix.android.util

import com.cineflix.android.ui.player.FilePart
import com.cineflix.android.ui.player.XrayOverlayController
import org.junit.After
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import java.io.File

class StorageAndRamHygieneTest {

    @get:Rule
    val tempFolder = TemporaryFolder()

    @After
    fun tearDown() {
        StorageAndRamHygiene.resetWebViewInitializedForTesting()
    }

    private fun writeSizedFile(file: File, sizeBytes: Int): File {
        file.parentFile?.mkdirs()
        file.writeBytes(ByteArray(sizeBytes) { (it % 127).toByte() })
        return file
    }

    @Test
    fun cleanTdlibDatabaseBloat_preservesAuthBinlogAndDeletesSqliteLogsAndLegacyMedia() {
        val filesDir = tempFolder.newFolder("files")
        val tdData = File(filesDir, "tdlib_data").apply { mkdirs() }

        val binlog = writeSizedFile(File(tdData, "td.binlog"), 4096)
        val binlogNew = writeSizedFile(File(tdData, "td.binlog.new"), 512)
        val sqlite = writeSizedFile(File(tdData, "db.sqlite"), 50_000)
        val sqliteWal = writeSizedFile(File(tdData, "db.sqlite-wal"), 20_000)
        val sqliteShm = writeSizedFile(File(tdData, "db.sqlite-shm"), 8_000)
        val tdLog = writeSizedFile(File(tdData, "tdlib.log"), 12_000)
        val tdLogOld = writeSizedFile(File(tdData, "tdlib.log.old"), 15_000)
        val legacyVid = writeSizedFile(File(tdData, "videos/old_movie.mkv"), 100_000)
        val legacySticker = writeSizedFile(File(tdData, "stickers/anim.tgs"), 5_000)

        val reclaimed = StorageAndRamHygiene.cleanTdlibDatabaseBloat(filesDir)

        assertTrue("Expected >200KB reclaimed, got $reclaimed", reclaimed >= 210_000L)
        assertTrue("td.binlog must NEVER be deleted", binlog.exists())
        assertTrue("td.binlog.new must NEVER be deleted", binlogNew.exists())
        assertFalse(sqlite.exists())
        assertFalse(sqliteWal.exists())
        assertFalse(sqliteShm.exists())
        assertFalse(tdLog.exists())
        assertFalse(tdLogOld.exists())
        assertFalse(legacyVid.exists())
        assertFalse(legacySticker.exists())
    }

    @Test
    fun cleanTdlibTempFiles_wipesChunksAndKeepsRequiredDirectorySkeleton() {
        val cacheDir = tempFolder.newFolder("cache")
        val tdFiles = File(cacheDir, "tdlib_files")

        val videoChunk = writeSizedFile(File(tdFiles, "videos/chunk_01.part"), 64_000)
        val tempChunk = writeSizedFile(File(tdFiles, "temp/49182"), 32_000)
        val docChunk = writeSizedFile(File(tdFiles, "documents/archive.7z.001"), 16_000)
        val rogueStickerDir = File(tdFiles, "stickers")
        writeSizedFile(File(rogueStickerDir, "s1.webp"), 4_000)

        val reclaimed = StorageAndRamHygiene.cleanTdlibTempFiles(cacheDir)

        assertEquals(116_000L, reclaimed)
        assertFalse(videoChunk.exists())
        assertFalse(tempChunk.exists())
        assertFalse(docChunk.exists())
        assertFalse(rogueStickerDir.exists())

        // TDLib C++ requires these exact subdirectories to remain present and writable
        for (required in listOf("temp", "videos", "documents", "thumbnails", "profile_photos")) {
            val dir = File(tdFiles, required)
            assertTrue("Missing required TDLib cache dir: $required", dir.exists() && dir.isDirectory)
        }
    }

    @Test
    fun enforceWebViewCacheQuota_respectsThresholdAndProtectsLocalStorageCookiesAndIndexedDb() {
        val dataDir = tempFolder.newFolder("app_data")
        val cacheDir = tempFolder.newFolder("cache")

        val appWebView = File(dataDir, "app_webview")
        val defaultProfile = File(appWebView, "Default")
        val localStorageFile = writeSizedFile(File(defaultProfile, "Local Storage/leveldb/000003.log"), 4_096)
        val cookiesFile = writeSizedFile(File(defaultProfile, "Cookies"), 2_048)
        val idbFile = writeSizedFile(File(defaultProfile, "IndexedDB/https_cineflixapp.duckdns.org_0.indexeddb.leveldb/CURRENT"), 1_024)

        val httpCacheFile = writeSizedFile(File(defaultProfile, "Cache/Cache_Data/f_0001"), 50_000)
        val codeCacheFile = writeSizedFile(File(defaultProfile, "Code Cache/js/index_wasm"), 40_000)
        val swCacheFile = writeSizedFile(File(defaultProfile, "Service Worker/CacheStorage/abc/chunk.bin"), 30_000)
        val mediaCacheFile = writeSizedFile(File(defaultProfile, "Media Cache/vid_01"), 15_000)
        val opfsRomFile = writeSizedFile(File(defaultProfile, "File System/000/p/00/00000000"), 25_000)
        val crashpadDump = writeSizedFile(File(appWebView, "Crashpad/completed/dump.dmp"), 18_000)
        val browserMetricsSpare = writeSizedFile(File(appWebView, "BrowserMetrics-spare.pma"), 12_000)
        val gpuCacheFile = writeSizedFile(File(cacheDir, "WebView/Default/HTTP Cache/data_1"), 20_000)

        // 1. Quota higher than current 210 KB -> should NOT clear anything
        val (clearedUnder, bytesUnder) = StorageAndRamHygiene.enforceWebViewCacheQuota(
            dataDir = dataDir,
            cacheDir = cacheDir,
            maxCacheBytes = 500_000L
        )
        assertFalse(clearedUnder)
        assertEquals(0L, bytesUnder)
        assertTrue(httpCacheFile.exists())
        assertTrue(opfsRomFile.exists())
        assertTrue(crashpadDump.exists())

        // 2. Quota lower than current 210 KB -> MUST clear disposable caches (incl. OPFS & Crashpad) while keeping persistent state!
        val (clearedOver, bytesOver) = StorageAndRamHygiene.enforceWebViewCacheQuota(
            dataDir = dataDir,
            cacheDir = cacheDir,
            maxCacheBytes = 100_000L
        )
        assertTrue(clearedOver)
        assertEquals(210_000L, bytesOver)

        assertFalse(httpCacheFile.exists())
        assertFalse(codeCacheFile.exists())
        assertFalse(swCacheFile.exists())
        assertFalse(mediaCacheFile.exists())
        assertFalse(opfsRomFile.exists())
        assertFalse(crashpadDump.exists())
        assertFalse(browserMetricsSpare.exists())
        assertFalse(gpuCacheFile.exists())

        // User session & catalog IndexedDB MUST remain 100% untouched!
        assertTrue(localStorageFile.exists())
        assertTrue(cookiesFile.exists())
        assertTrue(idbFile.exists())

        // Hygiene JS in forceCompactIdb mode must also sweep OPFS entries
        val compactJs = StorageAndRamHygiene.buildWebViewStorageHygieneJs(forceCompactIdb = true)
        assertTrue(compactJs.contains("navigator.storage.getDirectory"))
    }

    @Test
    fun cleanEphemeralCacheArtifacts_respectsOtaAgeAndPurgesCrashLogs() {
        val cacheDir = tempFolder.newFolder("cache")
        val now = 1_700_000_000_000L

        val staleApk = writeSizedFile(File(cacheDir, "cineflix_update.apk"), 80_000).apply {
            setLastModified(now - 60L * 60_000L) // 60 min old -> delete
        }
        val freshApk = writeSizedFile(File(cacheDir, "in_progress.apk"), 25_000).apply {
            setLastModified(now - 2L * 60_000L) // 2 min old -> keep
        }
        val crashTxt = writeSizedFile(File(cacheDir, "crash_reports/cineflix_error_123.txt"), 6_000).apply {
            setLastModified(now - 5_000L)
        }

        val reclaimed = StorageAndRamHygiene.cleanEphemeralCacheArtifacts(
            cacheDir = cacheDir,
            maxCrashReportAgeMs = 0L,
            maxOtaApkAgeMs = 20L * 60_000L,
            nowMs = now
        )

        assertEquals(86_000L, reclaimed)
        assertFalse(staleApk.exists())
        assertTrue("Fresh OTA APK must not be deleted mid-install", freshApk.exists())
        assertFalse(crashTxt.exists())
    }

    @Test
    fun computeOptimalPlayerRamBudget_enforcesStrictSizeThresholdsAcrossAllDeviceTiers() {
        val mb = 1024L * 1024L

        val lowTv = StorageAndRamHygiene.computeOptimalPlayerRamBudget(1_024L * mb, isTv = true)
        assertFalse(lowTv.prioritizeTimeOverSizeThresholds)
        assertEquals(18 * 1024 * 1024, lowTv.exoTargetBufferBytes)
        assertEquals(2L * mb, lowTv.localServerPrefetchBytes)

        val stdTv = StorageAndRamHygiene.computeOptimalPlayerRamBudget(2_048L * mb, isTv = true)
        assertFalse(stdTv.prioritizeTimeOverSizeThresholds)
        assertEquals(28 * 1024 * 1024, stdTv.exoTargetBufferBytes)
        assertEquals(4L * mb, stdTv.localServerPrefetchBytes)

        val unknownTv = StorageAndRamHygiene.computeOptimalPlayerRamBudget(0L, isTv = true)
        assertEquals(28 * 1024 * 1024, unknownTv.exoTargetBufferBytes)

        val midDevice = StorageAndRamHygiene.computeOptimalPlayerRamBudget(4_096L * mb, isTv = false)
        assertFalse(midDevice.prioritizeTimeOverSizeThresholds)
        assertEquals(40 * 1024 * 1024, midDevice.exoTargetBufferBytes)

        val highPhone = StorageAndRamHygiene.computeOptimalPlayerRamBudget(8_192L * mb, isTv = false)
        assertFalse(highPhone.prioritizeTimeOverSizeThresholds)
        assertEquals(56 * 1024 * 1024, highPhone.exoTargetBufferBytes)
    }

    @Test
    fun xrayPhoneNormalization_preservesMultiProfileAndKidsScopeWhileRejectingPlaceholders() {
        assertEquals("34600000000", XrayOverlayController.normalizeScopedUserPhone("+34 600 000 000"))
        assertEquals("34600000000:p2", XrayOverlayController.normalizeScopedUserPhone("34600000000:p2"))
        assertEquals("34600000000:kids", XrayOverlayController.normalizeScopedUserPhone("+34 600-000-000:kids"))
        assertEquals("34600000000", XrayOverlayController.normalizeScopedUserPhone("34600000000:default"))
        assertEquals("", XrayOverlayController.normalizeScopedUserPhone("unknown"))
        assertEquals("", XrayOverlayController.normalizeScopedUserPhone("native_user"))
        assertEquals("", XrayOverlayController.normalizeScopedUserPhone(""))
    }

    @Test
    fun xrayParsingAndHelpers_handleValidAndEdgeCasePayloadsCleanly() {
        assertEquals(
            "Interstellar",
            XrayOverlayController.sanitizeLookupTitle("Interstellar.2014.(Castellano.1080p).[HDR].mkv")
        )
        assertEquals(
            "Interstellar",
            XrayOverlayController.sanitizeLookupTitle("Interstellar (2014)")
        )
        assertEquals(
            "1917",
            XrayOverlayController.sanitizeLookupTitle("1917.2019.1080p.WEB-DL.mkv")
        )
        assertEquals(
            "1917",
            XrayOverlayController.sanitizeLookupTitle("1917.mkv")
        )
        assertEquals(
            "Blade Runner 2049",
            XrayOverlayController.sanitizeLookupTitle("Blade.Runner.2049.2017.2160p.HEVC.mkv")
        )
        assertEquals(
            "Blade Runner 2049",
            XrayOverlayController.sanitizeLookupTitle("Blade.Runner.2049.mkv")
        )
        assertEquals(
            "Wonder Woman 1984",
            XrayOverlayController.sanitizeLookupTitle("Wonder Woman 1984")
        )
        assertEquals(
            "Wonder Woman 1984",
            XrayOverlayController.sanitizeLookupTitle("Wonder.Woman.1984.2020.1080p.mkv")
        )
        assertEquals(
            "Fear Street Part Two 1978",
            XrayOverlayController.sanitizeLookupTitle("Fear Street Part Two 1978")
        )
        assertEquals(
            "Breaking Bad",
            XrayOverlayController.sanitizeLookupTitle("Breaking.Bad.S03E10.Fly.1080p.mkv")
        )
        assertEquals(
            "Breaking Bad",
            XrayOverlayController.sanitizeLookupTitle("Breaking Bad - 1x01 - Piloto")
        )
        assertEquals(
            "The Bear",
            XrayOverlayController.sanitizeLookupTitle("The Bear — 2x07 — Tenedores")
        )
        assertEquals(
            "Severance",
            XrayOverlayController.sanitizeLookupTitle("Severance · S01E09")
        )
        assertEquals(
            "Dark",
            XrayOverlayController.sanitizeLookupTitle("Dark - Temporada 2 - Episodio 4")
        )
        assertEquals(
            "Breaking Bad",
            XrayOverlayController.sanitizeLookupTitle("Breaking Bad - Capítulo 1 - Piloto")
        )
        assertEquals(
            "It Capítulo 2",
            XrayOverlayController.sanitizeLookupTitle("It Capítulo 2 (2019)")
        )
        assertEquals(
            "Spider-Man: No Way Home",
            XrayOverlayController.sanitizeLookupTitle("🎬 Spider-Man: No Way Home (2021)")
        )
        assertEquals(
            "Gladiator II",
            XrayOverlayController.sanitizeLookupTitle("🎬 Gladiator II (2024)\n🔊 Audio: Castellano AC3 5.1\n📡 @videoclubpacobot")
        )
        assertEquals(
            "El Padrino",
            XrayOverlayController.sanitizeLookupTitle("🎥 El Padrino [1972] MicroHD m1080p Castellano")
        )
        // Episode-only captions without series name must yield "" so server falls back to PostgreSQL series.tmdb_name
        assertEquals("", XrayOverlayController.sanitizeLookupTitle("Capítulo 01 - Piloto"))
        assertEquals("", XrayOverlayController.sanitizeLookupTitle("1x01 - Piloto"))
        assertEquals("", XrayOverlayController.sanitizeLookupTitle("S01E01 - Winter Is Coming"))

        assertEquals("2019", XrayOverlayController.extractYearFromTitle("1917 (2019) 1080p"))
        assertEquals("2014", XrayOverlayController.extractYearFromTitle("Interstellar (2014) 1080p"))
        assertEquals(
            "2000",
            XrayOverlayController.extractYearFromTitle("🎬 Gladiator (2000)\nResolución 1920x1080 · Subido en 2025")
        )
        assertEquals("", XrayOverlayController.extractYearFromTitle("Sin Año"))

        // Short remaining time (<30s) or short video (<60s) suppresses finish clock
        assertEquals("", XrayOverlayController.formatFinishClock(10_000L, 45_000L, 1_700_000_000_000L))
        assertEquals("", XrayOverlayController.formatFinishClock(3_585_000L, 3_600_000L, 1_700_000_000_000L))
        assertTrue(
            XrayOverlayController.formatFinishClock(600_000L, 7_200_000L, 1_700_000_000_000L)
                .startsWith("🕒 Termina a las ")
        )

        // Malformed / empty X-Ray responses return null or emptyList safely
        assertNull(XrayOverlayController.parseXrayResponseJson(""))
        assertNull(XrayOverlayController.parseXrayResponseJson("{not valid json"))
        assertNull(XrayOverlayController.parseXrayResponseJson("""{"ok":true,"people":[]}"""))

        val validXray = XrayOverlayController.parseXrayResponseJson(
            """
            {
              "ok": true,
              "media_type": "movie",
              "tmdb_id": 157336,
              "title": "Interstellar",
              "year": "2014",
              "fact_line": "Dirigida por Christopher Nolan",
              "people": [
                {"id": 525, "role_type": "director", "name": "Christopher Nolan", "character": "Director", "profile_path": "/nolan.jpg"},
                {"id": 10297, "role_type": "cast", "name": "Matthew McConaughey", "character": "Cooper", "profile_path": null}
              ]
            }
            """.trimIndent()
        )
        assertNotNull(validXray)
        assertEquals(2, validXray!!.people.size)
        assertEquals("Christopher Nolan", validXray.people[0].name)
        assertNull(validXray.people[1].profilePath)

        val personItems = XrayOverlayController.parsePersonCatalogJson(
            """
            {
              "items": [
                {"id": "42", "media_type": "movie", "title": "Inception", "search_title": "Inception 2010", "tmdb_name": "Origen", "tmdb_id": 27205, "year": 2010, "person_role": "Director"},
                {"id": "88", "media_type": "tv", "title": "Westworld", "tmdb_name": "Westworld", "tmdb_id": 63247, "payload": null, "payload_mkv": "/serie_westworld_mkv"},
                {"id": null, "title": "Invalid"}
              ]
            }
            """.trimIndent()
        )
        assertEquals(2, personItems.size)
        assertEquals("Origen", personItems[0].title)
        assertEquals("2010", personItems[0].year)
        assertTrue("rawItemJson must preserve search_title for bot lookup", personItems[0].rawItemJson.contains("Inception 2010"))
        assertEquals("/serie_westworld_mkv", personItems[1].payload)
        assertTrue("rawItemJson must preserve payload_mkv for series hub", personItems[1].rawItemJson.contains("/serie_westworld_mkv"))
    }

    @Test
    fun xrayPauseRevealAndAnchorLogic_preventsSeekBarStarvationAndCenterControlsCollision() {
        // First pause transition schedules reveal once
        assertEquals(
            XrayOverlayController.PauseRevealAction.SCHEDULE_REVEAL,
            XrayOverlayController.computePauseRevealAction(
                isPausedReady = true,
                suppressAll = false,
                isPanelVisible = false,
                isMiniPillVisible = false,
                dismissedForCurrentPause = false,
                revealAlreadyPending = false
            )
        )

        // Subsequent 1000ms updateSeekBar() ticks while revealAlreadyPending == true MUST NOT reschedule/starve
        assertEquals(
            XrayOverlayController.PauseRevealAction.NO_OP,
            XrayOverlayController.computePauseRevealAction(
                isPausedReady = true,
                suppressAll = false,
                isPanelVisible = false,
                isMiniPillVisible = false,
                dismissedForCurrentPause = false,
                revealAlreadyPending = true
            )
        )

        // Once panel is visible, periodic ticks only update finish clock
        assertEquals(
            XrayOverlayController.PauseRevealAction.UPDATE_CLOCK_ONLY,
            XrayOverlayController.computePauseRevealAction(
                isPausedReady = true,
                suppressAll = false,
                isPanelVisible = true,
                isMiniPillVisible = false,
                dismissedForCurrentPause = false,
                revealAlreadyPending = false
            )
        )

        // Manual ✨ X-Ray open while paused in STATE_BUFFERING (isPlaybackPaused=true, isPausedReady=false)
        // MUST keep the panel alive instead of self-destructing on the next 1s updateSeekBar() tick!
        assertEquals(
            XrayOverlayController.PauseRevealAction.UPDATE_CLOCK_ONLY,
            XrayOverlayController.computePauseRevealAction(
                isPausedReady = false,
                suppressAll = false,
                isPanelVisible = true,
                isMiniPillVisible = false,
                dismissedForCurrentPause = false,
                revealAlreadyPending = false,
                isPlaybackPaused = true
            )
        )

        // Paused during STATE_BUFFERING without manual open waits quietly (NO_OP) until STATE_READY
        assertEquals(
            XrayOverlayController.PauseRevealAction.NO_OP,
            XrayOverlayController.computePauseRevealAction(
                isPausedReady = false,
                suppressAll = false,
                isPanelVisible = false,
                isMiniPillVisible = false,
                dismissedForCurrentPause = false,
                revealAlreadyPending = false,
                isPlaybackPaused = true
            )
        )

        // Dismissed for current pause (including via Back gesture/key!) stays NO_OP until resume
        assertEquals(
            XrayOverlayController.PauseRevealAction.NO_OP,
            XrayOverlayController.computePauseRevealAction(
                isPausedReady = true,
                suppressAll = false,
                isPanelVisible = false,
                isMiniPillVisible = true,
                dismissedForCurrentPause = true,
                revealAlreadyPending = false
            )
        )

        // Resuming playback or suppression (Live TV / Cast / PiP / Seek) hides and resets immediately
        assertEquals(
            XrayOverlayController.PauseRevealAction.HIDE_AND_RESET,
            XrayOverlayController.computePauseRevealAction(
                isPausedReady = false,
                suppressAll = false,
                isPanelVisible = true,
                isMiniPillVisible = false,
                dismissedForCurrentPause = false,
                revealAlreadyPending = true,
                isPlaybackPaused = false
            )
        )
        assertEquals(
            XrayOverlayController.PauseRevealAction.HIDE_AND_RESET,
            XrayOverlayController.computePauseRevealAction(
                isPausedReady = true,
                suppressAll = true,
                isPanelVisible = false,
                isMiniPillVisible = false,
                dismissedForCurrentPause = false,
                revealAlreadyPending = true
            )
        )

        // Compact landscape mobile screens (<500dp) anchor at top ONLY while controls are visible
        assertTrue(XrayOverlayController.shouldAnchorOverlayAtTop(360, controlsVisible = true))
        assertTrue(XrayOverlayController.shouldAnchorOverlayAtTop(412, controlsVisible = true))
        assertTrue(XrayOverlayController.shouldAnchorOverlayAtTop(499, controlsVisible = true))
        assertFalse(XrayOverlayController.shouldAnchorOverlayAtTop(360, controlsVisible = false))
        assertFalse(XrayOverlayController.shouldAnchorOverlayAtTop(500, controlsVisible = true))
        assertFalse(XrayOverlayController.shouldAnchorOverlayAtTop(540, controlsVisible = true))
        assertFalse(XrayOverlayController.shouldAnchorOverlayAtTop(0, controlsVisible = true))
    }

    @Test
    fun xrayUnavailablePayloadForPause_attemptsOnceAndNeverLoopsUntilResetOrManualClick() {
        // 1. Initial pause schedules auto-reveal once
        assertEquals(
            XrayOverlayController.PauseRevealAction.SCHEDULE_REVEAL,
            XrayOverlayController.computePauseRevealAction(
                isPausedReady = true,
                suppressAll = false,
                isPanelVisible = false,
                isMiniPillVisible = false,
                dismissedForCurrentPause = false,
                revealAlreadyPending = false,
                revealAttemptedForCurrentPause = false
            )
        )

        // 2. After revealRunnable fires and /api/xray returns null or empty people (e.g. Mi Contenido),
        // panelView stays GONE and dismissedForCurrentPause stays false, while revealAttemptedForCurrentPause is true.
        // Every subsequent 1000ms updateSeekBar() tick MUST return NO_OP instead of looping SCHEDULE_REVEAL!
        assertEquals(
            XrayOverlayController.PauseRevealAction.NO_OP,
            XrayOverlayController.computePauseRevealAction(
                isPausedReady = true,
                suppressAll = false,
                isPanelVisible = false,
                isMiniPillVisible = false,
                dismissedForCurrentPause = false,
                revealAlreadyPending = false,
                revealAttemptedForCurrentPause = true
            )
        )

        // 3. Resuming playback or suppression (seek / PiP / Cast) returns HIDE_AND_RESET even after a failed reveal
        assertEquals(
            XrayOverlayController.PauseRevealAction.HIDE_AND_RESET,
            XrayOverlayController.computePauseRevealAction(
                isPausedReady = false,
                suppressAll = false,
                isPanelVisible = false,
                isMiniPillVisible = false,
                dismissedForCurrentPause = false,
                revealAlreadyPending = false,
                isPlaybackPaused = false,
                revealAttemptedForCurrentPause = true
            )
        )
        assertEquals(
            XrayOverlayController.PauseRevealAction.HIDE_AND_RESET,
            XrayOverlayController.computePauseRevealAction(
                isPausedReady = true,
                suppressAll = true,
                isPanelVisible = false,
                isMiniPillVisible = false,
                dismissedForCurrentPause = false,
                revealAlreadyPending = false,
                isPlaybackPaused = true,
                revealAttemptedForCurrentPause = true
            )
        )

        // 4. Once HIDE_AND_RESET (or manual ✨ X-Ray click) resets revealAttemptedForCurrentPause = false,
        // the next pause schedules reveal cleanly again
        assertEquals(
            XrayOverlayController.PauseRevealAction.SCHEDULE_REVEAL,
            XrayOverlayController.computePauseRevealAction(
                isPausedReady = true,
                suppressAll = false,
                isPanelVisible = false,
                isMiniPillVisible = false,
                dismissedForCurrentPause = false,
                revealAlreadyPending = false,
                revealAttemptedForCurrentPause = false
            )
        )
    }

    @Test
    fun xrayAsyncRevealGuard_abortsStaleCoroutineWhenResumedSuppressedDismissedOrSuperseded() {
        // Active paused session with matching token -> render allowed
        assertTrue(
            XrayOverlayController.shouldCompleteAsyncReveal(
                isDestroyed = false,
                dismissedForCurrentPause = false,
                isPlaybackPaused = true,
                suppressAll = false,
                requestToken = 4,
                currentToken = 4
            )
        )

        // User pressed Play while /api/xray HTTP was still in flight -> MUST abort so X-Ray never sticks over playing video
        assertFalse(
            XrayOverlayController.shouldCompleteAsyncReveal(
                isDestroyed = false,
                dismissedForCurrentPause = false,
                isPlaybackPaused = false,
                suppressAll = false,
                requestToken = 4,
                currentToken = 5
            )
        )
        assertFalse(
            XrayOverlayController.shouldCompleteAsyncReveal(
                isDestroyed = false,
                dismissedForCurrentPause = false,
                isPlaybackPaused = false,
                suppressAll = false,
                requestToken = 4,
                currentToken = 4
            )
        )

        // Suppressed (seek / PiP / Cast) or superseded by manual ✨ X-Ray tap -> MUST abort stale coroutine
        assertFalse(
            XrayOverlayController.shouldCompleteAsyncReveal(
                isDestroyed = false,
                dismissedForCurrentPause = false,
                isPlaybackPaused = true,
                suppressAll = true,
                requestToken = 4,
                currentToken = 4
            )
        )
        assertFalse(
            XrayOverlayController.shouldCompleteAsyncReveal(
                isDestroyed = false,
                dismissedForCurrentPause = false,
                isPlaybackPaused = true,
                suppressAll = false,
                requestToken = 4,
                currentToken = 5
            )
        )
        assertFalse(
            XrayOverlayController.shouldCompleteAsyncReveal(
                isDestroyed = false,
                dismissedForCurrentPause = true,
                isPlaybackPaused = true,
                suppressAll = false,
                requestToken = 4,
                currentToken = 4
            )
        )
        assertFalse(
            XrayOverlayController.shouldCompleteAsyncReveal(
                isDestroyed = true,
                dismissedForCurrentPause = false,
                isPlaybackPaused = true,
                suppressAll = false,
                requestToken = 4,
                currentToken = 4
            )
        )
    }

    @Test
    fun filePart_preservesDefaultZeroAndExplicitMsgId() {
        val legacyPart = FilePart(fileId = 10, size = 1024L)
        assertEquals(0L, legacyPart.msgId)

        val partWithMsg = FilePart(fileId = 11, size = 2048L, msgId = 99887766L)
        assertEquals(99887766L, partWithMsg.msgId)
    }

    @Test
    fun enforceWebViewCacheQuota_whenWebViewActive_neverUnlinksLiveSimpleCacheAndCleansDetachedArtifacts() {
        val dataDir = tempFolder.newFolder("app_data_active")
        val cacheDir = tempFolder.newFolder("cache_active")

        val appWebView = File(dataDir, "app_webview")
        val defaultProfile = File(appWebView, "Default")
        val localStorageFile = writeSizedFile(File(defaultProfile, "Local Storage/leveldb/000003.log"), 4_096)
        val cookiesFile = writeSizedFile(File(defaultProfile, "Cookies"), 2_048)
        val idbFile = writeSizedFile(File(defaultProfile, "IndexedDB/https_cineflixapp.duckdns.org_0.indexeddb.leveldb/CURRENT"), 1_024)

        val liveHttpCache = writeSizedFile(File(defaultProfile, "Cache/Cache_Data/f_0001"), 60_000)
        val liveCodeCache = writeSizedFile(File(defaultProfile, "Code Cache/js/index_wasm"), 40_000)
        val liveSwCache = writeSizedFile(File(defaultProfile, "Service Worker/CacheStorage/abc/chunk.bin"), 25_000)
        val liveOpfsFile = writeSizedFile(File(defaultProfile, "File System/000/p/00/00000000"), 15_000)
        val liveGpuCache = writeSizedFile(File(cacheDir, "WebView/Default/GPUCache/data_1"), 20_000)
        val liveBrowserMetrics = writeSizedFile(File(appWebView, "BrowserMetrics-spare.pma"), 8_000)

        val detachedCrashpad = writeSizedFile(File(appWebView, "Crashpad/completed/dump.dmp"), 18_000)
        val stagedTrashFile = writeSizedFile(File(cacheDir, "webview_trash_999/old_cache.bin"), 12_000)
        val stagedDataTrashFile = writeSizedFile(File(dataDir, "webview_trash_888/old_code_cache.bin"), 10_000)

        StorageAndRamHygiene.markWebViewInitialized()
        assertTrue(StorageAndRamHygiene.isWebViewInitializedInProcess())

        val (overQuota, reclaimedDetached) = StorageAndRamHygiene.enforceWebViewCacheQuota(
            dataDir = dataDir,
            cacheDir = cacheDir,
            maxCacheBytes = 50_000L
        )

        assertTrue("Expected overQuota=true so caller invokes WebView.clearCache(true) on UI thread", overQuota)
        assertEquals(40_000L, reclaimedDetached)

        // Detached artifacts ARE safely removed immediately from both cacheDir and dataDir
        assertFalse(detachedCrashpad.exists())
        assertFalse(stagedTrashFile.exists())
        assertFalse(stagedDataTrashFile.exists())

        // Live Chromium SimpleCache / mmap files MUST NOT be unlinked behind Chromium's back
        assertTrue(liveHttpCache.exists())
        assertTrue(liveCodeCache.exists())
        assertTrue(liveSwCache.exists())
        assertTrue(liveOpfsFile.exists())
        assertTrue(liveGpuCache.exists())
        assertTrue(liveBrowserMetrics.exists())

        // Persistent session state remains intact
        assertTrue(localStorageFile.exists())
        assertTrue(cookiesFile.exists())
        assertTrue(idbFile.exists())
    }

    @Test
    fun stageWebViewCachesForAsyncDeletion_stagesWithinEachQuotaRootAndRefusesWhenActive() {
        val dataDir = tempFolder.newFolder("app_data_stage")
        val cacheDir = tempFolder.newFolder("cache_stage")

        val appWebView = File(dataDir, "app_webview")
        val defaultProfile = File(appWebView, "Default")
        val localStorageFile = writeSizedFile(File(defaultProfile, "Local Storage/leveldb/000003.log"), 4_096)
        val cookiesFile = writeSizedFile(File(defaultProfile, "Cookies"), 2_048)
        val idbFile = writeSizedFile(File(defaultProfile, "IndexedDB/https_cineflixapp.duckdns.org_0.indexeddb.leveldb/CURRENT"), 1_024)

        val httpCacheFile = writeSizedFile(File(defaultProfile, "Cache/Cache_Data/f_0001"), 50_000)
        val codeCacheFile = writeSizedFile(File(defaultProfile, "Code Cache/js/index_wasm"), 40_000)
        val gpuCacheFile = writeSizedFile(File(cacheDir, "WebView/Default/HTTP Cache/data_1"), 20_000)
        val browserMetricsSpare = writeSizedFile(File(appWebView, "BrowserMetrics-spare.pma"), 10_000)
        val crashpadDump = writeSizedFile(File(appWebView, "Crashpad/completed/dump.dmp"), 15_000)

        val staged = StorageAndRamHygiene.stageWebViewCachesForAsyncDeletion(dataDir, cacheDir)
        assertTrue("Expected disposable cache targets to be staged", staged)

        // Original paths are immediately empty before WebView(context) opens a single FD
        assertFalse(httpCacheFile.exists())
        assertFalse(codeCacheFile.exists())
        assertFalse(gpuCacheFile.exists())
        assertFalse(browserMetricsSpare.exists())
        assertFalse(crashpadDump.exists())

        // Verify dataDir targets were staged inside dataDir (same Android project quota ID, avoiding -EXDEV)
        // and cacheDir targets were staged inside cacheDir!
        val stagedInData = dataDir.listFiles()?.filter { it.name.startsWith("webview_trash_") }.orEmpty()
        val stagedInCache = cacheDir.listFiles()?.filter { it.name.startsWith("webview_trash_") }.orEmpty()
        assertEquals("dataDir targets must stage inside dataDir", 1, stagedInData.size)
        assertEquals("cacheDir targets must stage inside cacheDir", 1, stagedInCache.size)

        // Session & catalog IndexedDB are never staged
        assertTrue(localStorageFile.exists())
        assertTrue(cookiesFile.exists())
        assertTrue(idbFile.exists())

        // Async cleanup sweeps staged trash across BOTH cacheDir and dataDir completely
        val reclaimed = StorageAndRamHygiene.cleanStagedWebViewTrash(cacheDir, dataDir)
        assertEquals(135_000L, reclaimed)
        assertTrue(cacheDir.listFiles()?.filter { it.name.startsWith("webview_trash_") }.orEmpty().isEmpty())
        assertTrue(dataDir.listFiles()?.filter { it.name.startsWith("webview_trash_") }.orEmpty().isEmpty())

        // Once WebView is initialized in process, staging MUST refuse to touch live dirs
        val liveCacheAfterInit = writeSizedFile(File(defaultProfile, "Cache/Cache_Data/f_0002"), 16_000)
        StorageAndRamHygiene.markWebViewInitialized()
        val refused = StorageAndRamHygiene.stageWebViewCachesForAsyncDeletion(dataDir, cacheDir)
        assertFalse(refused)
        assertTrue(liveCacheAfterInit.exists())
    }
}
