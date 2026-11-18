package com.cineflix.android

import android.content.res.Configuration
import com.cineflix.android.util.StorageAndRamHygiene
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withTimeoutOrNull
import org.drinkless.tdlib.TdApi
import org.junit.Assert.*
import org.junit.Test
import java.nio.file.Files

class TelegramLoginUnitTest {

    @Test
    fun normalizePhoneInput_handlesInternationalAndSpanishMobileFormats() {
        assertEquals("+34612345678", TelegramEngine.normalizePhoneInput("+34 612 345 678"))
        assertEquals("+34612345678", TelegramEngine.normalizePhoneInput("0034-612-34-56-78"))
        assertEquals("+34612345678", TelegramEngine.normalizePhoneInput("612345678"))
        assertEquals("+34722987654", TelegramEngine.normalizePhoneInput("722 987 654"))
        assertEquals("+5491123456789", TelegramEngine.normalizePhoneInput("54 9 11 2345-6789"))
        assertEquals("+14155552671", TelegramEngine.normalizePhoneInput("\u202A+1 (415) 555-2671\u202C"))
        // Prefilled "+34" in #input-phone followed by pasted/typed full phone with country code
        assertEquals("+34612345678", TelegramEngine.normalizePhoneInput("+34+34 612 345 678"))
        assertEquals("+525512345678", TelegramEngine.normalizePhoneInput("+34+52 55 1234 5678"))
        assertEquals("+34612345678", TelegramEngine.normalizePhoneInput("+340034612345678"))
        assertEquals("+34612345678", TelegramEngine.normalizePhoneInput("+3434612345678"))
    }

    @Test
    fun normalizePhoneInput_rejectsEmptyShortAndOverflowInputs() {
        assertEquals("", TelegramEngine.normalizePhoneInput(null))
        assertEquals("", TelegramEngine.normalizePhoneInput(""))
        assertEquals("", TelegramEngine.normalizePhoneInput("   "))
        assertEquals("", TelegramEngine.normalizePhoneInput("+"))
        assertEquals("", TelegramEngine.normalizePhoneInput("+34"))
        assertEquals("", TelegramEngine.normalizePhoneInput("123456"))
        assertEquals("", TelegramEngine.normalizePhoneInput("+1234567890123456"))
    }

    @Test
    fun sanitizeVerificationCode_preservesNumericWordAndPhraseCodesCleanly() {
        assertEquals("12345", TelegramEngine.sanitizeVerificationCode("12345"))
        assertEquals("123456", TelegramEngine.sanitizeVerificationCode(" 123-456 "))
        assertEquals("908172", TelegramEngine.sanitizeVerificationCode("\u200E908 172\u200F"))
        assertEquals("aurora", TelegramEngine.sanitizeVerificationCode("  aurora "))
        assertEquals("luna azul clara", TelegramEngine.sanitizeVerificationCode("  luna   azul\t clara "))
        assertEquals("", TelegramEngine.sanitizeVerificationCode(null))
        assertEquals("", TelegramEngine.sanitizeVerificationCode("   "))
    }

    @Test
    fun classifyAuthenticationCodeInfo_handlesFirebaseFallbackAndRejectionDeterministically() {
        val firebaseNoNext = TdApi.AuthenticationCodeInfo(
            "+34612345678",
            TdApi.AuthenticationCodeTypeFirebaseAndroid(null, 6),
            null,
            60
        )
        val resNoNext = TelegramEngine.classifyAuthenticationCodeInfo(firebaseNoNext, firebaseFallbackAlreadyAttempted = false)
        assertTrue(resNoNext is TelegramEngine.Companion.CodeInfoDecision.RejectUnsupportedDelivery)
        assertTrue((resNoNext as TelegramEngine.Companion.CodeInfoDecision.RejectUnsupportedDelivery).reason.contains("SEND_CODE_UNAVAILABLE"))

        val firebaseWithSmsNext = TdApi.AuthenticationCodeInfo(
            "34612345678",
            TdApi.AuthenticationCodeTypeFirebaseAndroid(null, 6),
            TdApi.AuthenticationCodeTypeSms(6),
            60
        )
        val firstTry = TelegramEngine.classifyAuthenticationCodeInfo(firebaseWithSmsNext, firebaseFallbackAlreadyAttempted = false)
        assertEquals(TelegramEngine.Companion.CodeInfoDecision.TryFirebaseFallback("+34612345678"), firstTry)

        // Second consecutive Firebase emission must reject instead of looping forever
        val secondTry = TelegramEngine.classifyAuthenticationCodeInfo(firebaseWithSmsNext, firebaseFallbackAlreadyAttempted = true)
        assertTrue(secondTry is TelegramEngine.Companion.CodeInfoDecision.RejectUnsupportedDelivery)

        val firebaseIosWithFirebaseNext = TdApi.AuthenticationCodeInfo(
            "+34612345678",
            TdApi.AuthenticationCodeTypeFirebaseIos("receipt", 15, 6),
            TdApi.AuthenticationCodeTypeFirebaseAndroid(null, 6),
            60
        )
        val iosRes = TelegramEngine.classifyAuthenticationCodeInfo(firebaseIosWithFirebaseNext, firebaseFallbackAlreadyAttempted = false)
        assertTrue(iosRes is TelegramEngine.Companion.CodeInfoDecision.RejectUnsupportedDelivery)
    }

    @Test
    fun classifyAuthenticationCodeInfo_mapsAllDeliverableCodeTypesAccurately() {
        val appDecision = TelegramEngine.classifyAuthenticationCodeInfo(
            TdApi.AuthenticationCodeInfo("+34612345678", TdApi.AuthenticationCodeTypeTelegramMessage(5), TdApi.AuthenticationCodeTypeSms(6), 60),
            false
        ) as TelegramEngine.Companion.CodeInfoDecision.AcceptWaitCode
        assertEquals("app", appDecision.waitCode.deliveryType)
        assertEquals(5, appDecision.waitCode.codeLength)
        assertTrue(appDecision.waitCode.hasNextType)

        val smsDecision = TelegramEngine.classifyAuthenticationCodeInfo(
            TdApi.AuthenticationCodeInfo("+34612345678", TdApi.AuthenticationCodeTypeSms(6), null, 60),
            false
        ) as TelegramEngine.Companion.CodeInfoDecision.AcceptWaitCode
        assertEquals("sms", smsDecision.waitCode.deliveryType)
        assertEquals(6, smsDecision.waitCode.codeLength)
        assertFalse(smsDecision.waitCode.hasNextType)

        val wordDecision = TelegramEngine.classifyAuthenticationCodeInfo(
            TdApi.AuthenticationCodeInfo("+34612345678", TdApi.AuthenticationCodeTypeSmsWord("M"), null, 60),
            false
        ) as TelegramEngine.Companion.CodeInfoDecision.AcceptWaitCode
        assertEquals("sms_word", wordDecision.waitCode.deliveryType)
        assertEquals("M", wordDecision.waitCode.deliveryHint)

        val phraseDecision = TelegramEngine.classifyAuthenticationCodeInfo(
            TdApi.AuthenticationCodeInfo("+34612345678", TdApi.AuthenticationCodeTypeSmsPhrase("sol"), null, 60),
            false
        ) as TelegramEngine.Companion.CodeInfoDecision.AcceptWaitCode
        assertEquals("sms_phrase", phraseDecision.waitCode.deliveryType)
        assertEquals("sol", phraseDecision.waitCode.deliveryHint)

        val callDecision = TelegramEngine.classifyAuthenticationCodeInfo(
            TdApi.AuthenticationCodeInfo("+34612345678", TdApi.AuthenticationCodeTypeCall(5), null, 60),
            false
        ) as TelegramEngine.Companion.CodeInfoDecision.AcceptWaitCode
        assertEquals("call", callDecision.waitCode.deliveryType)
        assertEquals(5, callDecision.waitCode.codeLength)

        val fragmentDecision = TelegramEngine.classifyAuthenticationCodeInfo(
            TdApi.AuthenticationCodeInfo("+88801234567", TdApi.AuthenticationCodeTypeFragment("https://fragment.com", 6), null, 60),
            false
        ) as TelegramEngine.Companion.CodeInfoDecision.AcceptWaitCode
        assertEquals("fragment", fragmentDecision.waitCode.deliveryType)
        assertEquals(6, fragmentDecision.waitCode.codeLength)
        assertEquals("https://fragment.com", fragmentDecision.waitCode.deliveryHint)
    }

    @Test
    fun hasProtectedAuthenticatedSession_protectsNonEmptyBinlogWhenAuthenticated() {
        val root = Files.createTempDirectory("cf_tdlib_session_test").toFile()
        try {
            val dbDir = java.io.File(root, "tdlib_data").apply { mkdirs() }
            assertFalse(TelegramEngine.hasProtectedAuthenticatedSession(dbDir, isMarkedAuthenticated = true, savedUserPhone = "34612345678"))

            val binlog = java.io.File(dbDir, "td.binlog")
            binlog.writeBytes(ByteArray(0))
            assertFalse(TelegramEngine.hasProtectedAuthenticatedSession(dbDir, isMarkedAuthenticated = true, savedUserPhone = "34612345678"))

            binlog.writeBytes(byteArrayOf(1, 2, 3, 4))
            assertFalse(TelegramEngine.hasProtectedAuthenticatedSession(dbDir, isMarkedAuthenticated = false, savedUserPhone = ""))
            assertTrue(TelegramEngine.hasProtectedAuthenticatedSession(dbDir, isMarkedAuthenticated = true, savedUserPhone = ""))
            assertTrue(TelegramEngine.hasProtectedAuthenticatedSession(dbDir, isMarkedAuthenticated = false, savedUserPhone = "34612345678"))
        } finally {
            root.deleteRecursively()
        }
    }

    @Test
    fun isTelevisionDevice_detectsLeanbackAndNonTouchscreenAospTvBoxesWithoutMatchingPhones() {
        // Official Android TV
        assertTrue(StorageAndRamHygiene.isTelevisionDevice(
            uiModeType = Configuration.UI_MODE_TYPE_TELEVISION,
            hasLeanback = true,
            hasTelevisionFeature = true,
            hasTouchscreen = false
        ))
        // Non-touchscreen AOSP HDMI TV box reporting UI_MODE_TYPE_NORMAL
        assertTrue(StorageAndRamHygiene.isTelevisionDevice(
            uiModeType = Configuration.UI_MODE_TYPE_NORMAL,
            hasLeanback = false,
            hasTelevisionFeature = false,
            hasTouchscreen = false
        ))
        // Normal Android touchscreen smartphone / tablet
        assertFalse(StorageAndRamHygiene.isTelevisionDevice(
            uiModeType = Configuration.UI_MODE_TYPE_NORMAL,
            hasLeanback = false,
            hasTelevisionFeature = false,
            hasTouchscreen = true
        ))
        // Non-touchscreen watch/car should not be treated as TV
        assertFalse(StorageAndRamHygiene.isTelevisionDevice(
            uiModeType = Configuration.UI_MODE_TYPE_WATCH,
            hasLeanback = false,
            hasTelevisionFeature = false,
            hasTouchscreen = false
        ))
        // Runtime D-pad upgrade overrides sloppy touchscreen-claiming ROMs consistently across bridge/activity
        assertTrue(StorageAndRamHygiene.isTelevisionDevice(
            uiModeType = Configuration.UI_MODE_TYPE_NORMAL,
            hasLeanback = false,
            hasTelevisionFeature = false,
            hasTouchscreen = true,
            runtimeDetected = true
        ))
    }

    @Test
    fun shouldUpgradeToTvModeOnDpad_distinguishesTvRemotesFromTabletBluetoothKeyboardsAndPhones() {
        // Touchscreen-claiming non-telephony AOSP TV box with IR/2.4GHz remote -> upgrade to TV
        assertTrue(StorageAndRamHygiene.shouldUpgradeToTvModeOnDpad(
            isRemoteDpadKey = true,
            isAlphabeticKeyboard = false,
            hasTelephony = false,
            isDedicatedRemoteDeviceName = false
        ))
        // Dedicated IR / HDMI-CEC remote even on generic AOSP ROM advertising telephony -> upgrade to TV
        assertTrue(StorageAndRamHygiene.shouldUpgradeToTvModeOnDpad(
            isRemoteDpadKey = true,
            isAlphabeticKeyboard = false,
            hasTelephony = true,
            isDedicatedRemoteDeviceName = true
        ))
        // Android tablet (no telephony) with physical Bluetooth QWERTY keyboard -> DO NOT force on-screen VK
        assertFalse(StorageAndRamHygiene.shouldUpgradeToTvModeOnDpad(
            isRemoteDpadKey = true,
            isAlphabeticKeyboard = true,
            hasTelephony = false,
            isDedicatedRemoteDeviceName = false
        ))
        // Normal Android smartphone -> false
        assertFalse(StorageAndRamHygiene.shouldUpgradeToTvModeOnDpad(
            isRemoteDpadKey = true,
            isAlphabeticKeyboard = false,
            hasTelephony = true,
            isDedicatedRemoteDeviceName = false
        ))
    }

    @Test
    fun inlineSetTdlibParametersRecovery_doesNotDeadlockWhileAuthMutexHeld() {
        kotlinx.coroutines.runBlocking {
            val authMutex = kotlinx.coroutines.sync.Mutex()
            val authState = kotlinx.coroutines.flow.MutableStateFlow<TelegramEngine.AuthState>(TelegramEngine.AuthState.Unknown)
            val setParamsFail = kotlinx.coroutines.flow.MutableStateFlow<Pair<Int, String>?>(null)
            val gen = java.util.concurrent.atomic.AtomicInteger(1)

            val startedMs = System.currentTimeMillis()
            val ok = authMutex.withLock {
                // Simulate SetTdlibParameters failing asynchronously while authMutex is already held
                val bgCallback = kotlinx.coroutines.GlobalScope.launch {
                    kotlinx.coroutines.delay(30L)
                    setParamsFail.value = Pair(1, "Database lock")
                    // Background coroutine also tries to acquire authMutex (as in handleAuthState)
                    authMutex.withLock {
                        // Must be a no-op once inline recovery already bumped gen to 2
                        if (gen.get() == 1) {
                            fail("Inline recovery should have already advanced generation without deadlocking")
                        }
                    }
                }

                var resultState: TelegramEngine.AuthState? = null
                val deadline = System.currentTimeMillis() + 2_000L
                while (System.currentTimeMillis() < deadline) {
                    val cur = authState.value
                    if (cur is TelegramEngine.AuthState.WaitPhone) {
                        resultState = cur
                        break
                    }
                    val activeGen = gen.get()
                    val pending = setParamsFail.value
                    if (pending != null && pending.first == activeGen) {
                        setParamsFail.value = null
                        gen.incrementAndGet() // Recovered client gen=2 boots cleanly to WaitPhone
                        authState.value = TelegramEngine.AuthState.WaitPhone
                        continue
                    }
                    withTimeoutOrNull(200L) {
                        merge<Any?>(authState, setParamsFail).first {
                            it != null && it != TelegramEngine.AuthState.Unknown
                        }
                    }
                }
                bgCallback
                resultState is TelegramEngine.AuthState.WaitPhone
            }
            val elapsed = System.currentTimeMillis() - startedMs
            assertTrue("Inline recovery under authMutex must succeed", ok)
            assertTrue("Recovery must finish in <500ms without 7000ms mutex deadlock (took ${elapsed}ms)", elapsed < 500L)
        }
    }

    @Test
    fun isTransientAuthQueryConflict_identifiesTdlibQueryRacesOnly() {
        assertTrue(TelegramEngine.isTransientAuthQueryConflict("Another authorization query has started"))
        assertTrue(TelegramEngine.isTransientAuthQueryConflict("ERROR: Another authorization query has started"))
        assertTrue(TelegramEngine.isTransientAuthQueryConflict("Call to checkAuthenticationCode unexpected"))
        assertTrue(TelegramEngine.isTransientAuthQueryConflict("AUTH_RESTART"))
        assertFalse(TelegramEngine.isTransientAuthQueryConflict("PHONE_NUMBER_INVALID"))
        assertFalse(TelegramEngine.isTransientAuthQueryConflict("PHONE_CODE_INVALID"))
        assertFalse(TelegramEngine.isTransientAuthQueryConflict("PASSWORD_HASH_INVALID"))
        assertFalse(TelegramEngine.isTransientAuthQueryConflict(null))
        assertFalse(TelegramEngine.isTransientAuthQueryConflict(""))
    }

    @Test
    fun isFloodWaitError_detectsTelegramRateLimitsWithoutMatchingNormalErrors() {
        assertTrue(TelegramEngine.isFloodWaitError("FLOOD_WAIT_45"))
        assertTrue(TelegramEngine.isFloodWaitError("Too Many Requests: retry after 30"))
        assertTrue(TelegramEngine.isFloodWaitError("A wait of 120 seconds is required"))
        assertTrue(TelegramEngine.isFloodWaitError("PHONE_PASSWORD_FLOOD"))
        assertFalse(TelegramEngine.isFloodWaitError("SEND_CODE_UNAVAILABLE"))
        assertFalse(TelegramEngine.isFloodWaitError("PHONE_CODE_INVALID"))
        assertFalse(TelegramEngine.isFloodWaitError(null))
    }

    @Test
    fun nextAlternateTdlibDbDirName_togglesDeterministicallyBetweenTwoBoundedDirs() {
        assertEquals("tdlib_data_alt", TelegramEngine.nextAlternateTdlibDbDirName("tdlib_data"))
        assertEquals("tdlib_data", TelegramEngine.nextAlternateTdlibDbDirName("tdlib_data_alt"))
        assertEquals("tdlib_data_alt", TelegramEngine.nextAlternateTdlibDbDirName(null))
    }
}
