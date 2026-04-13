package com.cineflix.android

import android.content.Context
import android.util.Log
import android.webkit.JavascriptInterface
import android.webkit.WebView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.drinkless.tdlib.Client
import org.drinkless.tdlib.TdApi
import java.io.File

class TelegramManager(private val context: Context, private val webView: WebView) {

    private val TAG = "TelegramManager"
    private var client: Client? = null
    var authorizationState: TdApi.AuthorizationState? = null

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

    private fun handleResult(result: TdApi.Object) {
        when (result) {
            is TdApi.UpdateAuthorizationState -> {
                Log.i(TAG, "Auth state updated: ${result.authorizationState.javaClass.simpleName}")
                authorizationState = result.authorizationState
                handleAuthState(result.authorizationState)
            }
            is TdApi.Error -> {
                Log.e(TAG, "Receive error: ${result.code} - ${result.message}")
                notifyJS("onTelegramError", "'${result.message}'")
            }
            is TdApi.Ok -> {
                // Generics OK
            }
            else -> {
                // Other TDLib events
            }
        }
    }

    private fun handleAuthState(state: TdApi.AuthorizationState) {
        when (state) {
            is TdApi.AuthorizationStateWaitTdlibParameters -> {
                Log.i(TAG, "Sending TDLib parameters...")
                val dbPath = File(context.filesDir, "tdlib_data").absolutePath
                
                // Emulamos exactamente a Tevegram: API_ID y API_HASH
                val parameters = TdApi.SetTdlibParameters(
                    false, // useTestDc
                    dbPath, // databaseDirectory
                    dbPath, // filesDirectory
                    null, // encryptionKey
                    true, // useFileDatabase
                    true, // useChatInfoDatabase
                    true, // useMessageDatabase
                    true, // useSecretChats
                    36374374, // apiId
                    "8000603d2523b8a22df55c9476d9c64a", // apiHash
                    "en", // systemLanguageCode
                    "Android", // deviceModel
                    "1.0", // systemVersion
                    "Cineflix" // applicationVersion
                )
                client?.send(parameters) { res -> Log.i(TAG, "SetTdlibParameters result: ${res.javaClass.simpleName}") }
            }
            is TdApi.AuthorizationStateWaitPhoneNumber -> {
                Log.i(TAG, "Waiting for phone number...")
                notifyJS("onTelegramAuthStateChanged", "'WAIT_PHONE'")
            }
            is TdApi.AuthorizationStateWaitCode -> {
                Log.i(TAG, "Waiting for code...")
                notifyJS("onTelegramAuthStateChanged", "'WAIT_CODE'")
            }
            is TdApi.AuthorizationStateWaitPassword -> {
                Log.i(TAG, "Waiting for password...")
                notifyJS("onTelegramAuthStateChanged", "'WAIT_PASSWORD'")
            }
            is TdApi.AuthorizationStateReady -> {
                Log.i(TAG, "TDLib is READY \uD83D\uDE80")
                notifyJS("onTelegramAuthStateChanged", "'READY'")
            }
            is TdApi.AuthorizationStateLoggingOut -> {
                Log.i(TAG, "Logging out...")
            }
            is TdApi.AuthorizationStateClosed -> {
                Log.i(TAG, "TDLib closed.")
                client = null
                initClient() // Restart if closed
            }
        }
    }

    // ──────────────────────────────────────────────────────────────────────────
    // Interfaz para JavaScript (llamadas desde la UI web)
    // ──────────────────────────────────────────────────────────────────────────

    @JavascriptInterface
    fun requestAuthState() {
        val stateName = when (authorizationState) {
            is TdApi.AuthorizationStateWaitPhoneNumber -> "WAIT_PHONE"
            is TdApi.AuthorizationStateWaitCode -> "WAIT_CODE"
            is TdApi.AuthorizationStateWaitPassword -> "WAIT_PASSWORD"
            is TdApi.AuthorizationStateReady -> "READY"
            else -> "UNKNOWN"
        }
        notifyJS("onTelegramAuthStateChanged", "'$stateName'")
    }

    @JavascriptInterface
    fun loginWithPhone(phone: String) {
        Log.i(TAG, "JS requested login with phone: $phone")
        client?.send(TdApi.SetAuthenticationPhoneNumber(phone, null)) { result ->
            if (result is TdApi.Error) notifyJS("onTelegramError", "'${result.message}'")
        }
    }

    @JavascriptInterface
    fun signInWithCode(code: String) {
        Log.i(TAG, "JS requested login with code")
        client?.send(TdApi.CheckAuthenticationCode(code)) { result ->
            if (result is TdApi.Error) notifyJS("onTelegramError", "'${result.message}'")
        }
    }

    @JavascriptInterface
    fun signInWithPassword(password: String) {
        Log.i(TAG, "JS requested login with password")
        client?.send(TdApi.CheckAuthenticationPassword(password)) { result ->
            if (result is TdApi.Error) notifyJS("onTelegramError", "'${result.message}'")
        }
    }

    @JavascriptInterface
    fun logOut() {
        Log.i(TAG, "JS requested logout")
        client?.send(TdApi.LogOut()) { result ->
             Log.i(TAG, "Logout result: ${result.javaClass.simpleName}")
             notifyJS("onTelegramAuthStateChanged", "'LOGGED_OUT'")
        }
    }

    // Método seguro para llamar a JS
    private fun notifyJS(functionName: String, args: String) {
        CoroutineScope(Dispatchers.Main).launch {
            webView.evaluateJavascript("window.$functionName && window.$functionName($args);", null)
        }
    }

    fun getClient(): Client? = client
}
