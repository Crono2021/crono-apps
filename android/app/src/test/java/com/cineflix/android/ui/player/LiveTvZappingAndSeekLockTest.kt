package com.cineflix.android.ui.player

import android.view.KeyEvent
import com.cineflix.android.MainActivity
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class LiveTvZappingAndSeekLockTest {

    @Test
    fun seekIsLockedForAllLiveTvChannelsAndPremiereButNotVod() {
        assertFalse(PlayerActivity.shouldLockSeekForPlayback(isLiveTvMode = false, isPremiereSyncLocked = false))
        assertTrue(PlayerActivity.shouldLockSeekForPlayback(isLiveTvMode = true, isPremiereSyncLocked = false))
        assertTrue(PlayerActivity.shouldLockSeekForPlayback(isLiveTvMode = false, isPremiereSyncLocked = true))
        assertTrue(PlayerActivity.shouldLockSeekForPlayback(isLiveTvMode = true, isPremiereSyncLocked = true))
    }

    @Test
    fun duplicateNewIntentGuardNeverSwallowsLiveChannelZap() {
        // Exact same VOD file with no zap pending -> ignore duplicate
        assertTrue(
            PlayerActivity.shouldIgnoreDuplicateNewIntent(
                attachOnly = false,
                newFileId = 42,
                currentFileId = 42,
                sameMultipart = true,
                sameLiveMode = true,
                sameLiveChannel = true,
                releasedWhileBackgrounded = false,
                liveTvAutoAdvancePending = false,
                liveTvZapPending = false
            )
        )

        // Zapping to a different Live TV channel (even if fileId happened to match) -> MUST switch stream
        assertFalse(
            PlayerActivity.shouldIgnoreDuplicateNewIntent(
                attachOnly = false,
                newFileId = 42,
                currentFileId = 42,
                sameMultipart = true,
                sameLiveMode = true,
                sameLiveChannel = false,
                releasedWhileBackgrounded = false,
                liveTvAutoAdvancePending = false,
                liveTvZapPending = false
            )
        )

        // Zap in progress -> MUST switch stream
        assertFalse(
            PlayerActivity.shouldIgnoreDuplicateNewIntent(
                attachOnly = false,
                newFileId = 42,
                currentFileId = 42,
                sameMultipart = true,
                sameLiveMode = true,
                sameLiveChannel = true,
                releasedWhileBackgrounded = false,
                liveTvAutoAdvancePending = false,
                liveTvZapPending = true
            )
        )
    }

    @Test
    fun parseNativeZapResponseHandlesWebViewDoubleQuotedJsonAndEdgeCases() {
        val webViewEscaped =
            "\"{\\\"ok\\\":true,\\\"channelId\\\":\\\"ch_accion\\\",\\\"channelLabel\\\":\\\"CANAL 102 · Acción\\\",\\\"programTitle\\\":\\\"John Wick\\\",\\\"isPremiereLocked\\\":false}\""
        val parsed = MainActivity.parseNativeZapResponseJson(webViewEscaped)
        assertNotNull(parsed)
        assertEquals("ch_accion", parsed!!.channelId)
        assertEquals("CANAL 102 · Acción", parsed.channelLabel)
        assertEquals("John Wick", parsed.programTitle)
        assertFalse(parsed.isPremiereLocked)

        val premiereRaw =
            """{"ok":true,"channelId":"ch_premiere_sabado","channelLabel":"CANAL 100 · El Peliculón","programTitle":"Gladiator","isPremiereLocked":true}"""
        val parsedPrem = MainActivity.parseNativeZapResponseJson(premiereRaw)
        assertNotNull(parsedPrem)
        assertTrue(parsedPrem!!.isPremiereLocked)

        // Edge cases: null, "null", empty, loadingEpg, malformed JSON
        assertNull(MainActivity.parseNativeZapResponseJson(null))
        assertNull(MainActivity.parseNativeZapResponseJson(""))
        assertNull(MainActivity.parseNativeZapResponseJson("null"))
        assertNull(MainActivity.parseNativeZapResponseJson("""{"ok":true,"loadingEpg":true}"""))
        assertNull(MainActivity.parseNativeZapResponseJson("""{"ok":false}"""))
        assertNull(MainActivity.parseNativeZapResponseJson("{malformed"))
    }

    @Test
    fun androidTvChannelUpDownDoNotCollideWithBrowserBack166() {
        val chUp = MainActivity.mapAndroidTvRemoteKey(KeyEvent.KEYCODE_CHANNEL_UP)
        val chDown = MainActivity.mapAndroidTvRemoteKey(KeyEvent.KEYCODE_CHANNEL_DOWN)
        val pgUp = MainActivity.mapAndroidTvRemoteKey(KeyEvent.KEYCODE_PAGE_UP)
        val pgDown = MainActivity.mapAndroidTvRemoteKey(KeyEvent.KEYCODE_PAGE_DOWN)

        assertEquals(Pair(427, "ChannelUp"), chUp)
        assertEquals(Pair(427, "ChannelUp"), pgUp)
        assertEquals(Pair(428, "ChannelDown"), chDown)
        assertEquals(Pair(428, "ChannelDown"), pgDown)
        assertNotEquals(166, chUp?.first)
    }

    @Test
    fun pauseIsLockedForAllLiveTvChannelsAndPremiereButNotVod() {
        assertFalse(PlayerActivity.shouldLockPauseForPlayback(isLiveTvMode = false, isPremiereSyncLocked = false))
        assertTrue(PlayerActivity.shouldLockPauseForPlayback(isLiveTvMode = true, isPremiereSyncLocked = false))
        assertTrue(PlayerActivity.shouldLockPauseForPlayback(isLiveTvMode = false, isPremiereSyncLocked = true))
        assertTrue(PlayerActivity.shouldLockPauseForPlayback(isLiveTvMode = true, isPremiereSyncLocked = true))
    }

    @Test
    fun formatLiveTvProgramDisplayTitleFormatsMoviesSeriesAndEdgeCases() {
        assertEquals(
            "Epic Movie (2007)",
            PlayerActivity.formatLiveTvProgramDisplayTitle(
                explicitProgramTitle = "Epic Movie (2007)",
                cleanTitle = "Epic Movie",
                year = "2007",
                mediaType = "movie"
            )
        )
        assertEquals(
            "Epic Movie (2007)",
            PlayerActivity.formatLiveTvProgramDisplayTitle(
                explicitProgramTitle = "",
                cleanTitle = "Epic Movie",
                year = "2007",
                mediaType = "movie"
            )
        )
        assertEquals(
            "Epic Movie (2007)",
            PlayerActivity.formatLiveTvProgramDisplayTitle(
                explicitProgramTitle = null,
                cleanTitle = null,
                rawTitle = "🎬 Epic.Movie.2007.1080p.Dual.mkv",
                year = null,
                mediaType = "movie"
            )
        )
        assertEquals(
            "Los Simpson (1989) · T4·E12",
            PlayerActivity.formatLiveTvProgramDisplayTitle(
                explicitProgramTitle = null,
                cleanTitle = "Los Simpson",
                year = "1989",
                mediaType = "tv",
                season = "4",
                episode = "12"
            )
        )
        assertEquals(
            "Los Simpson (1989) · T4·E12",
            PlayerActivity.formatLiveTvProgramDisplayTitle(
                explicitProgramTitle = "Los Simpson · T4·E12",
                cleanTitle = "Los Simpson",
                year = "1989",
                mediaType = "tv"
            )
        )
        assertEquals(
            "",
            PlayerActivity.formatLiveTvProgramDisplayTitle(
                explicitProgramTitle = "null",
                cleanTitle = "null",
                rawTitle = "",
                year = "null"
            )
        )
    }

    @Test
    fun parseNativeZapResponseExtractsFullFichaMetadata() {
        val raw =
            """{"ok":true,"channelId":"ch_comedia","channelLabel":"CANAL 104 · 😂 Comedia","programTitle":"Epic Movie (2007)","itemId":"881","tmdbId":9760,"year":"2007","mediaType":"movie","cleanTitle":"Epic Movie","posterPath":"/epic.jpg","payload":"","rawItemJson":"{\"id\":881,\"tmdb_id\":9760,\"title\":\"Epic Movie\",\"year\":2007}","isPremiereLocked":false}"""
        val parsed = MainActivity.parseNativeZapResponseJson(raw)
        assertNotNull(parsed)
        assertEquals("ch_comedia", parsed!!.channelId)
        assertEquals("CANAL 104 · 😂 Comedia", parsed.channelLabel)
        assertEquals("Epic Movie (2007)", parsed.programTitle)
        assertEquals("881", parsed.itemId)
        assertEquals(9760, parsed.tmdbId)
        assertEquals("2007", parsed.year)
        assertEquals("movie", parsed.mediaType)
        assertEquals("Epic Movie", parsed.cleanTitle)
        assertEquals("/epic.jpg", parsed.posterPath)
        assertTrue(parsed.rawItemJson.contains("\"tmdb_id\":9760"))
        assertFalse(parsed.isPremiereLocked)
    }

    @Test
    fun applyNativeZapTargetReplacesStaleFichaFieldsWithoutLeakingPreviousChannelYearOrTmdb() {
        // Zapping from Series (e.g. Los Simpson 1989, tmdbId=456, payload=series_pl) to a Doc/Movie with no year/payload/tmdbId
        val nextTarget = MainActivity.Companion.NativeZapTarget(
            channelId = "ch_docs",
            channelLabel = "CANAL 301 · 🌍 Documentales",
            programTitle = "Planeta Tierra",
            isPremiereLocked = false,
            itemId = "999",
            tmdbId = 0,
            year = "",
            mediaType = "movie",
            cleanTitle = "Planeta Tierra",
            posterPath = "",
            payload = "",
            rawItemJson = ""
        )
        val snap = PlayerActivity.applyNativeZapTargetToFichaState(
            previousChannelId = "ch_simpsons",
            previousChannelLabel = "CANAL 201 · Simpson",
            target = nextTarget
        )
        assertEquals("ch_docs", snap.channelId)
        assertEquals("CANAL 301 · 🌍 Documentales", snap.channelLabel)
        assertEquals("Planeta Tierra", snap.programDisplayTitle)
        assertEquals("999", snap.itemId)
        assertEquals(0, snap.tmdbId)
        assertEquals("", snap.year)
        assertEquals("movie", snap.mediaType)
        assertEquals("", snap.posterPath)
        assertEquals("", snap.payload)
        assertEquals("", snap.rawItemJson)
        assertFalse(snap.isPremiereLocked)
    }

    @Test
    fun castMediaMetadataMarksLiveAndPremiereBroadcastsLocked() {
        val vodMeta = com.cineflix.android.ui.player.cast.CastSessionCoordinator.CastMediaMetadata(
            fileId = 10,
            multipartParts = null,
            multipartJson = null,
            fileSize = 1000L,
            mimeType = "video/mp4",
            title = "VOD Movie",
            chatId = 1L,
            msgId = 2L,
            phone = "+34600000000",
            contentId = "mv_10",
            season = "",
            episode = "",
            creditsStart = "",
            introStartMs = "",
            introEndMs = "",
            introDbCreditsMs = "",
            storedSevenZip = false
        )
        assertFalse(vodMeta.isLiveBroadcastLocked)

        val liveMeta = vodMeta.copy(
            isLiveTv = true,
            liveTvChannelId = "ch_comedia",
            liveTvProgramTitle = "Epic Movie (2007)"
        )
        assertTrue(liveMeta.isLiveBroadcastLocked)
        assertEquals("Epic Movie (2007)", liveMeta.liveTvProgramTitle)

        val premiereMeta = vodMeta.copy(isLiveTv = false, isPremiereLocked = true)
        assertTrue(premiereMeta.isLiveBroadcastLocked)
    }

    @Test
    fun continuityPlanNeverCutsWithoutVerifiedMarkAndUsesFinalTailSqueeze() {
        // 2h movie (7200s) with no verified credits mark -> never trims, squeezes in final 45s (7155..7200)
        val moviePlan = LiveTvSqueezeBackController.evaluateContinuityPlan(
            serverContinuityJson = """{"creditsVerified":false,"realDurationSec":7200,"broadcastDurationSec":7200}""",
            realDurationSec = 7200,
            mediaType = "movie"
        )
        assertFalse(moviePlan.creditsTrimmed)
        assertFalse(moviePlan.creditsVerified)
        assertEquals(7200, moviePlan.broadcastDurationSec)
        assertEquals("no_verified_mark", moviePlan.lockStatus)
        assertEquals(7155, moviePlan.squeezeStartSec)
        assertFalse(LiveTvSqueezeBackController.isInSqueezeWindow(7154, moviePlan))
        assertTrue(LiveTvSqueezeBackController.isInSqueezeWindow(7155, moviePlan))
        assertFalse(LiveTvSqueezeBackController.shouldTriggerSynchronizedCut(7200, moviePlan))

        // 42m TV episode (2520s) with no verified mark -> never trims, squeezes in final 30s (2490..2520)
        val tvPlan = LiveTvSqueezeBackController.evaluateContinuityPlan(
            serverContinuityJson = null,
            realDurationSec = 2520,
            mediaType = "tv"
        )
        assertFalse(tvPlan.creditsTrimmed)
        assertEquals(2490, tvPlan.squeezeStartSec)
        assertTrue(LiveTvSqueezeBackController.isInSqueezeWindow(2500, tvPlan))
    }

    @Test
    fun continuityPlanEnforcesLock1Final18PercentBoundary() {
        // 1000s episode -> 82% floor is 820s. Mark at 819s MUST be rejected by Lock 1!
        val earlyAnomaly = LiveTvSqueezeBackController.evaluateContinuityPlan(
            serverContinuityJson = """{"creditsVerified":true,"creditsStartSec":819,"realDurationSec":1000}""",
            realDurationSec = 1000,
            mediaType = "tv"
        )
        assertFalse(earlyAnomaly.creditsTrimmed)
        assertFalse(earlyAnomaly.creditsVerified)
        assertEquals("rejected_lock1_early", earlyAnomaly.lockStatus)
        assertEquals(1000, earlyAnomaly.broadcastDurationSec)
        assertFalse(LiveTvSqueezeBackController.shouldTriggerSynchronizedCut(834, earlyAnomaly))

        // Exact 82% boundary (820s on 1000s) -> passes Lock 1 and trims with +15s Lock 3 buffer (835s)
        val exactBoundary = LiveTvSqueezeBackController.evaluateContinuityPlan(
            serverContinuityJson = """{"creditsVerified":true,"creditsStartSec":820,"realDurationSec":1000}""",
            realDurationSec = 1000,
            mediaType = "tv"
        )
        assertTrue(exactBoundary.creditsTrimmed)
        assertTrue(exactBoundary.creditsVerified)
        assertEquals("trimmed_verified_3locks", exactBoundary.lockStatus)
        assertEquals(835, exactBoundary.broadcastDurationSec)
    }

    @Test
    fun continuityPlanEnforcesLock2AntiPostCreditsAndRestoresFullscreenDuringScene() {
        // Marvel/Anime case: realDuration = 7565s, credits = 7039s..7512s -> 53s left (> 20s) => post-credits!
        val postCreditsPlan = LiveTvSqueezeBackController.evaluateContinuityPlan(
            serverContinuityJson = """{"creditsVerified":true,"creditsStartSec":7039,"creditsEndSec":7512,"hasPostCredits":true,"realDurationSec":7565,"finalTailSqueezeStartSec":7547}""",
            realDurationSec = 7565,
            mediaType = "movie"
        )
        assertFalse(postCreditsPlan.creditsTrimmed)
        assertTrue(postCreditsPlan.hasPostCredits)
        assertEquals("blocked_lock2_post_credits", postCreditsPlan.lockStatus)
        assertEquals(7565, postCreditsPlan.broadcastDurationSec)
        assertFalse(LiveTvSqueezeBackController.shouldTriggerSynchronizedCut(7054, postCreditsPlan))

        // Squeeze-Back active during main credits (7039..7511)
        assertFalse(LiveTvSqueezeBackController.isInSqueezeWindow(7038, postCreditsPlan))
        assertTrue(LiveTvSqueezeBackController.isInSqueezeWindow(7039, postCreditsPlan))
        assertTrue(LiveTvSqueezeBackController.isInSqueezeWindow(7511, postCreditsPlan))

        // Expands back to 100% fullscreen at 7512s so viewer watches post-credits scene in full!
        assertFalse(LiveTvSqueezeBackController.isInSqueezeWindow(7512, postCreditsPlan))
        assertFalse(LiveTvSqueezeBackController.isInSqueezeWindow(7540, postCreditsPlan))

        // Re-enters Squeeze-Back during final 18s tail (7547..7564)
        assertTrue(LiveTvSqueezeBackController.isInSqueezeWindow(7548, postCreditsPlan))

        // Boundary check: exactly 20s remaining after credits_end (e.g. studio logo, 1000 - 980 == 20) is NOT > 20s -> trims!
        val twentySecLogo = LiveTvSqueezeBackController.evaluateContinuityPlan(
            serverContinuityJson = """{"creditsVerified":true,"creditsStartSec":900,"creditsEndSec":980,"hasPostCredits":false,"realDurationSec":1000}""",
            realDurationSec = 1000,
            mediaType = "movie"
        )
        assertTrue(twentySecLogo.creditsTrimmed)
        assertEquals(915, twentySecLogo.broadcastDurationSec)

        // 21s remaining after credits_end (1000 - 979 == 21 > 20s) -> blocked by Lock 2 even if server flag omitted!
        val twentyOneSecScene = LiveTvSqueezeBackController.evaluateContinuityPlan(
            serverContinuityJson = """{"creditsVerified":true,"creditsStartSec":900,"creditsEndSec":979,"hasPostCredits":false,"realDurationSec":1000}""",
            realDurationSec = 1000,
            mediaType = "movie"
        )
        assertFalse(twentyOneSecScene.creditsTrimmed)
        assertTrue(twentyOneSecScene.hasPostCredits)
        assertEquals(1000, twentyOneSecScene.broadcastDurationSec)
    }

    @Test
    fun continuityPlanEnforcesLock3Plus15SecCushionAndLocalMarkSafety() {
        // Breaking Bad S1E1 style: realDuration = 3486s, creditsStart = 3395s -> broadcastDuration = 3410s (+15s)
        val trimmed = LiveTvSqueezeBackController.evaluateContinuityPlan(
            serverContinuityJson = """{"creditsVerified":true,"creditsStartSec":3395,"realDurationSec":3486}""",
            realDurationSec = 3486,
            mediaType = "tv"
        )
        assertTrue(trimmed.creditsTrimmed)
        assertEquals(3410, trimmed.broadcastDurationSec)
        assertTrue(LiveTvSqueezeBackController.isInSqueezeWindow(3395, trimmed))
        assertTrue(LiveTvSqueezeBackController.isInSqueezeWindow(3409, trimmed))
        assertFalse(LiveTvSqueezeBackController.shouldTriggerSynchronizedCut(3409, trimmed))
        assertTrue(LiveTvSqueezeBackController.shouldTriggerSynchronizedCut(3410, trimmed))

        // Local-only introDbCreditsMs without server confirmation MUST NOT cut early (protects Marvel post-credits & EPG sync)
        val localOnly = LiveTvSqueezeBackController.evaluateContinuityPlan(
            serverContinuityJson = null,
            realDurationSec = 7565,
            mediaType = "movie",
            introDbCreditsMs = 7_039_000L
        )
        assertFalse(localOnly.creditsTrimmed)
        assertEquals("local_mark_awaiting_server", localOnly.lockStatus)
        assertFalse(LiveTvSqueezeBackController.shouldTriggerSynchronizedCut(7054, localOnly))
        assertTrue(LiveTvSqueezeBackController.isInSqueezeWindow(7045, localOnly))

        // Short clip (< 300s) -> never trims or squeezes
        val shortClip = LiveTvSqueezeBackController.evaluateContinuityPlan(
            serverContinuityJson = """{"creditsVerified":true,"creditsStartSec":200,"realDurationSec":240}""",
            realDurationSec = 240,
            mediaType = "tv"
        )
        assertFalse(shortClip.creditsTrimmed)
        assertEquals("no_real_duration", shortClip.lockStatus)
        assertFalse(LiveTvSqueezeBackController.isInSqueezeWindow(210, shortClip))
    }

    @Test
    fun squeezeGeometryPreserves16By9AndNeverOverlapsSurfaceViewAcrossAspectRatios() {
        for ((w, h) in listOf(1920 to 1080, 1280 to 720, 2560 to 1080, 1024 to 768)) {
            val geo = LiveTvSqueezeBackController.computeSqueezeGeometry(
                containerWidthPx = w,
                containerHeightPx = h,
                padXPx = 24,
                padYPx = 20,
                gapPx = 16
            )
            val ratio = geo.videoWidth.toDouble() / geo.videoHeight.toDouble()
            assertTrue("Expected 16:9 ratio for ${w}x${h}, got $ratio", kotlin.math.abs(ratio - (16.0 / 9.0)) < 0.02)
            assertTrue(geo.rightLeft >= geo.videoLeft + geo.videoWidth + geo.gap)
            assertTrue(geo.rightLeft + geo.rightWidth <= w)
            assertTrue(geo.bottomTop >= geo.videoTop + geo.videoHeight + geo.gap)
            assertTrue(geo.bottomTop + geo.bottomHeight <= h)
        }

        // Compact landscape phone / 360dp-height layout leaves generous non-clipping bottom headroom while preserving 16:9
        val compactGeo = LiveTvSqueezeBackController.computeSqueezeGeometry(
            containerWidthPx = 800,
            containerHeightPx = 360,
            padXPx = 12,
            padYPx = 10,
            gapPx = 9,
            compactHeight = true
        )
        val compactRatio = compactGeo.videoWidth.toDouble() / compactGeo.videoHeight.toDouble()
        assertTrue("Expected 16:9 ratio for compact 800x360, got $compactRatio", kotlin.math.abs(compactRatio - (16.0 / 9.0)) < 0.02)
        assertTrue("Expected >= 135px bottom strip headroom on 360px height, got ${compactGeo.bottomHeight}", compactGeo.bottomHeight >= 135)
        assertTrue(compactGeo.rightLeft >= compactGeo.videoLeft + compactGeo.videoWidth + compactGeo.gap)
    }

    @Test
    fun continuityParsersHandleUpNextAndOtherChannelsPayloadsCleanly() {
        val upNext = LiveTvSqueezeBackController.parseUpNextJson(
            """{"movie":{"id":42,"media_type":"tv","tmdb_id":1396,"season":1,"episode":2,"ep_code":"T1·E2","tmdb_name":"Breaking Bad (2008)","year":"2008","tmdb_rating":8.9,"tmdb_overview":"Walter y Jesse...","tmdb_poster":"/bb.jpg"}}"""
        )
        assertNotNull(upNext)
        assertEquals("tv", upNext!!.mediaType)
        assertEquals("Breaking Bad", upNext.title)
        assertEquals("T1·E2", upNext.epCode)
        assertEquals("★ 8.9", upNext.rating)
        assertEquals("/bb.jpg", upNext.posterPath)

        val others = LiveTvSqueezeBackController.parseOtherChannelsJson(
            """[{"channelId":"ch_accion","number":102,"name":"Acción","icon":"💥","programTitle":"Matrix","progressPct":45,"remainingMin":62,"viewers":5},{"channelId":""}]"""
        )
        assertEquals(1, others.size)
        assertEquals("ch_accion", others[0].channelId)
        assertEquals(102, others[0].number)
        assertEquals(62, others[0].remainingMin)

        assertNull(LiveTvSqueezeBackController.parseUpNextJson(null))
        assertNull(LiveTvSqueezeBackController.parseUpNextJson("{bad"))
        assertTrue(LiveTvSqueezeBackController.parseOtherChannelsJson("").isEmpty())
        assertTrue(LiveTvSqueezeBackController.parseOtherChannelsJson("[bad").isEmpty())
    }

    @Test
    fun continuityPlanEnforcesAllThreeSafetyLocksAndPostCreditsProtection() {
        // 0. Unverified / short duration (< 300s) -> never cut
        val shortPlan = LiveTvSqueezeBackController.evaluateContinuityPlan(
            serverContinuityJson = null,
            realDurationSec = 120,
            mediaType = "movie"
        )
        assertFalse(shortPlan.creditsTrimmed)
        assertEquals(0, shortPlan.realDurationSec)
        assertEquals("no_real_duration", shortPlan.lockStatus)

        // 1. Lock 1 rejects suspicious early credits (< 82% of 6000s = 4920s)
        val earlyBadPlan = LiveTvSqueezeBackController.evaluateContinuityPlan(
            serverContinuityJson = """{"creditsVerified":true,"creditsStartSec":3600}""",
            realDurationSec = 6000,
            mediaType = "movie"
        )
        assertFalse(earlyBadPlan.creditsTrimmed)
        assertFalse(earlyBadPlan.creditsVerified)
        assertEquals(6000, earlyBadPlan.broadcastDurationSec)
        assertEquals("rejected_lock1_early", earlyBadPlan.lockStatus)

        // 2. Lock 2 blocks trimming when >20s remain after creditsEndSec (Marvel/Pixar post-credits scene)
        val postCreditsPlan = LiveTvSqueezeBackController.evaluateContinuityPlan(
            serverContinuityJson = """{"creditsVerified":true,"creditsStartSec":5400,"creditsEndSec":5580,"hasPostCredits":true,"finalTailSqueezeStartSec":5982}""",
            realDurationSec = 6000,
            mediaType = "movie"
        )
        assertFalse(postCreditsPlan.creditsTrimmed)
        assertTrue(postCreditsPlan.hasPostCredits)
        assertEquals(6000, postCreditsPlan.broadcastDurationSec)
        // Squeeze during credits (5400..5580), expand to fullscreen during post-credits scene (5580..5981), squeeze tail (5982..5999)
        assertTrue(LiveTvSqueezeBackController.isInSqueezeWindow(5450, postCreditsPlan))
        assertFalse(LiveTvSqueezeBackController.isInSqueezeWindow(5650, postCreditsPlan))
        assertTrue(LiveTvSqueezeBackController.isInSqueezeWindow(5990, postCreditsPlan))
        assertFalse(LiveTvSqueezeBackController.shouldTriggerSynchronizedCut(5415, postCreditsPlan))

        // 3. Verified late credits with no post-credits -> trims at creditsStartSec + 15s musical buffer (Lock 3)
        val verifiedTrimPlan = LiveTvSqueezeBackController.evaluateContinuityPlan(
            serverContinuityJson = """{"creditsVerified":true,"creditsStartSec":5500,"creditsEndSec":5995,"hasPostCredits":false}""",
            realDurationSec = 6000,
            mediaType = "movie"
        )
        assertTrue(verifiedTrimPlan.creditsTrimmed)
        assertTrue(verifiedTrimPlan.creditsVerified)
        assertEquals(5515, verifiedTrimPlan.broadcastDurationSec)
        assertTrue(LiveTvSqueezeBackController.isInSqueezeWindow(5505, verifiedTrimPlan))
        assertFalse(LiveTvSqueezeBackController.shouldTriggerSynchronizedCut(5514, verifiedTrimPlan))
        assertTrue(LiveTvSqueezeBackController.shouldTriggerSynchronizedCut(5515, verifiedTrimPlan))

        // 4. Unverified movie with no mark -> 0% trim, Squeeze-Back in final 45s
        val unverifiedPlan = LiveTvSqueezeBackController.evaluateContinuityPlan(
            serverContinuityJson = null,
            realDurationSec = 5400,
            mediaType = "movie"
        )
        assertFalse(unverifiedPlan.creditsTrimmed)
        assertEquals(5400, unverifiedPlan.broadcastDurationSec)
        assertEquals(5355, unverifiedPlan.squeezeStartSec)
        assertFalse(LiveTvSqueezeBackController.isInSqueezeWindow(5300, unverifiedPlan))
        assertTrue(LiveTvSqueezeBackController.isInSqueezeWindow(5360, unverifiedPlan))

        // 5. 16:9 ~58% Squeeze-Back geometry stays strictly non-overlapping inside 1920x1080
        val geo = LiveTvSqueezeBackController.computeSqueezeGeometry(
            containerWidthPx = 1920,
            containerHeightPx = 1080,
            padXPx = 36,
            padYPx = 32,
            gapPx = 28
        )
        assertEquals(1114, geo.videoWidth)
        assertEquals(627, geo.videoHeight)
        assertTrue(geo.rightLeft >= geo.videoLeft + geo.videoWidth + 28)
        assertTrue(geo.bottomTop >= geo.videoTop + geo.videoHeight + 28)
        assertTrue(geo.rightWidth > 300)
        assertTrue(geo.bottomHeight > 200)
    }

    @Test
    fun continuityPlanRejectsEditionMismatchAndUnboundedNullEndTail() {
        // Extended Cut credits_end (9342s) applied to Theatrical Cut file (8882s) -> rejected_edition_mismatch
        val editionMismatch = LiveTvSqueezeBackController.evaluateContinuityPlan(
            serverContinuityJson = """{"creditsVerified":true,"creditsStartSec":8500,"creditsEndSec":9342,"realDurationSec":8882}""",
            realDurationSec = 8882,
            mediaType = "movie"
        )
        assertFalse(editionMismatch.creditsTrimmed)
        assertFalse(editionMismatch.creditsVerified)
        assertEquals("rejected_edition_mismatch", editionMismatch.lockStatus)
        assertEquals(8882, editionMismatch.broadcastDurationSec)

        // 3h movie (10800s) with 83% mark (8964s -> 1836s tail > 780s) and null creditsEndSec -> blocked_unbounded_credits_tail
        val unboundedMovieTail = LiveTvSqueezeBackController.evaluateContinuityPlan(
            serverContinuityJson = """{"creditsVerified":true,"creditsStartSec":8964,"realDurationSec":10800}""",
            realDurationSec = 10800,
            mediaType = "movie"
        )
        assertFalse(unboundedMovieTail.creditsTrimmed)
        assertFalse(unboundedMovieTail.creditsVerified)
        assertEquals("blocked_unbounded_credits_tail", unboundedMovieTail.lockStatus)
        assertEquals(10800, unboundedMovieTail.broadcastDurationSec)

        // 45m TV episode (2700s) with 82% mark (2214s -> 486s tail > 300s) and null creditsEndSec -> blocked_unbounded_credits_tail
        val unboundedTvTail = LiveTvSqueezeBackController.evaluateContinuityPlan(
            serverContinuityJson = """{"creditsVerified":true,"creditsStartSec":2214,"realDurationSec":2700}""",
            realDurationSec = 2700,
            mediaType = "tv"
        )
        assertFalse(unboundedTvTail.creditsTrimmed)
        assertEquals("blocked_unbounded_credits_tail", unboundedTvTail.lockStatus)

        // Normal 6m movie credits (6000s - 5640s = 360s <= 780s) with null creditsEndSec -> allowed & trimmed at +15s!
        val boundedNullEnd = LiveTvSqueezeBackController.evaluateContinuityPlan(
            serverContinuityJson = """{"creditsVerified":true,"creditsStartSec":5640,"realDurationSec":6000}""",
            realDurationSec = 6000,
            mediaType = "movie"
        )
        assertTrue(boundedNullEnd.creditsTrimmed)
        assertEquals(5655, boundedNullEnd.broadcastDurationSec)
    }
}
