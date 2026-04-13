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
    var streamProxy: LocalStreamProxy? = null

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
            is TdApi.UpdateFile -> {
                streamProxy?.onUpdateFile(result)
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

    // ──────────────────────────────────────────────────────────────────────────
    // Nuevas funciones de migración completa a TDLib para Data UI
    // ──────────────────────────────────────────────────────────────────────────

    @JavascriptInterface
    fun searchMovieByPayload(queryId: String, payload: String) {
        val botUsername = "videoclubpacobot"
        Log.i(TAG, "JS requested searchMovieByPayload: $payload")
        
        client?.send(TdApi.SearchPublicChat(botUsername)) { botChatResult ->
            if (botChatResult is TdApi.Chat) {
                val chatId = botChatResult.id
                val inputMessageContent = TdApi.InputMessageText(TdApi.FormattedText("/peli $payload", emptyArray()), null, false)
                client?.send(TdApi.SendMessage(chatId, null, null, null, null, inputMessageContent)) { sendResult ->
                    if (sendResult is TdApi.Message) {
                        CoroutineScope(Dispatchers.IO).launch {
                            kotlinx.coroutines.delay(4000)
                            fetchAndSendVideos(queryId, chatId, 30, sendResult.id)
                        }
                    } else if (sendResult is TdApi.Error) {
                        notifyJSCallbackError(queryId, sendResult.message)
                    }
                }
            } else if (botChatResult is TdApi.Error) {
                notifyJSCallbackError(queryId, "Bot not found: ${botChatResult.message}")
            }
        }
    }

    @JavascriptInterface
    fun getVideoMessages(queryId: String, limit: Int, minId: Long) {
        val botUsername = "videoclubpacobot"
        Log.i(TAG, "JS requested getVideoMessages")
        
        client?.send(TdApi.SearchPublicChat(botUsername)) { botChatResult ->
            if (botChatResult is TdApi.Chat) {
                fetchAndSendVideos(queryId, botChatResult.id, limit, minId)
            } else if (botChatResult is TdApi.Error) {
                 notifyJSCallbackError(queryId, "Bot not found: ${botChatResult.message}")
            }
        }
    }

    @JavascriptInterface
    fun sendBotCommand(queryId: String, payload: String) {
        val botUsername = "videoclubpacobot"
        Log.i(TAG, "JS requested sendBotCommand: $payload")
        client?.send(TdApi.SearchPublicChat(botUsername)) { botChatResult ->
            if (botChatResult is TdApi.Chat) {
                val chatId = botChatResult.id
                val inputMessageContent = TdApi.InputMessageText(TdApi.FormattedText("/start $payload", emptyArray()), null, false)
                client?.send(TdApi.SendMessage(chatId, null, null, null, null, inputMessageContent)) { sendResult ->
                    if (sendResult is TdApi.Message) {
                        CoroutineScope(Dispatchers.IO).launch {
                            kotlinx.coroutines.delay(2500)
                            client?.send(TdApi.GetChatHistory(chatId, 0L, 0, 5, false)) { historyResult ->
                                if (historyResult is TdApi.Messages) {
                                    for (msg in historyResult.messages) {
                                        val replyMarkup = msg.replyMarkup
                                        if (replyMarkup is TdApi.ReplyMarkupInlineKeyboard) {
                                            val buttonsJson = org.json.JSONArray()
                                            for (row in replyMarkup.rows) {
                                                for (btn in row) {
                                                    val btnType = btn.type
                                                    if (btnType is TdApi.InlineKeyboardButtonTypeCallback) {
                                                        val btnJson = org.json.JSONObject()
                                                        btnJson.put("text", btn.text)
                                                        btnJson.put("data", android.util.Base64.encodeToString(btnType.data, android.util.Base64.NO_WRAP))
                                                        btnJson.put("msgId", msg.id)
                                                        buttonsJson.put(btnJson)
                                                    }
                                                }
                                            }
                                            val response = org.json.JSONObject()
                                            response.put("messageId", msg.id)
                                            response.put("buttons", buttonsJson)
                                            val textContent = msg.content
                                            if (textContent is TdApi.MessageText) {
                                                response.put("text", textContent.text.text)
                                            } else {
                                                response.put("text", "...")
                                            }
                                            notifyJSCallbackSuccess(queryId, response.toString())
                                            return@send
                                        }
                                    }
                                    val err = org.json.JSONObject()
                                    err.put("messageId", org.json.JSONObject.NULL)
                                    err.put("buttons", org.json.JSONArray())
                                    err.put("text", "No response from bot")
                                    notifyJSCallbackSuccess(queryId, err.toString())
                                }
                            }
                        }
                    } else if (sendResult is TdApi.Error) {
                        notifyJSCallbackError(queryId, sendResult.message)
                    }
                }
            } else if (botChatResult is TdApi.Error) {
                notifyJSCallbackError(queryId, "Bot not found: ${botChatResult.message}")
            }
        }
    }

    @JavascriptInterface
    fun clickInlineButton(queryId: String, msgId: Long, dataBase64: String) {
        val botUsername = "videoclubpacobot"
        val dataBytes = android.util.Base64.decode(dataBase64, android.util.Base64.DEFAULT)
        client?.send(TdApi.SearchPublicChat(botUsername)) { botChatResult ->
            if (botChatResult is TdApi.Chat) {
                client?.send(TdApi.GetCallbackQueryAnswer(botChatResult.id, msgId, TdApi.CallbackQueryPayloadData(dataBytes))) { answerResult ->
                    if (answerResult is TdApi.Error) {
                        notifyJSCallbackError(queryId, answerResult.message)
                    } else {
                        notifyJSCallbackSuccess(queryId, "{\"success\":true}")
                    }
                }
            } else if (botChatResult is TdApi.Error) {
                notifyJSCallbackError(queryId, "Bot not found: ${botChatResult.message}")
            }
        }
    }

    private fun fetchAndSendVideos(queryId: String, chatId: Long, limit: Int, minId: Long) {
        client?.send(TdApi.GetChatHistory(chatId, 0L, 0, limit, false)) { historyResult ->
            if (historyResult is TdApi.Error) {
                notifyJSCallbackError(queryId, historyResult.message)
                return@send
            }
            if (historyResult is TdApi.Messages) {
                val videosJson = org.json.JSONArray()
                for (msg in historyResult.messages) {
                    if (minId != 0L && msg.id <= minId) continue
                    val content = msg.content
                    if (content is TdApi.MessageDocument || content is TdApi.MessageVideo) {
                        val videoObj = org.json.JSONObject()
                        videoObj.put("msgId", msg.id)
                        videoObj.put("chatId", chatId.toString())
                        videoObj.put("date", msg.date)
                        if (content is TdApi.MessageDocument) {
                            val doc = content.document
                            val isMedia = doc.mimeType.contains("video") || doc.fileName.endsWith(".mp4") || doc.fileName.endsWith(".mkv")
                            if (!isMedia) continue
                            videoObj.put("fileName", doc.fileName)
                            videoObj.put("fileSize", doc.document.size)
                            videoObj.put("mimeType", doc.mimeType)
                            videoObj.put("caption", content.caption.text)
                            videosJson.put(videoObj)
                        } else if (content is TdApi.MessageVideo) {
                            val video = content.video
                            videoObj.put("fileName", video.fileName)
                            videoObj.put("fileSize", video.video.size)
                            videoObj.put("mimeType", video.mimeType)
                            videoObj.put("caption", content.caption.text)
                            videosJson.put(videoObj)
                        }
                    }
                }
                notifyJSCallbackSuccess(queryId, videosJson.toString())
            }
        }
    }

    private fun notifyJSCallbackSuccess(queryId: String, jsonPayload: String) {
        CoroutineScope(Dispatchers.Main).launch {
            // Escape possible single quotes if we wrap in single quotes? We pass raw JSON so we shouldn't quote it if expecting object
            webView.evaluateJavascript("window.onTelegramCallback('$queryId', true, $jsonPayload);", null)
        }
    }

    private fun notifyJSCallbackError(queryId: String, errorMsg: String) {
        CoroutineScope(Dispatchers.Main).launch {
            val safeEscaped = errorMsg.replace("'", "\\'")
            webView.evaluateJavascript("window.onTelegramCallback('$queryId', false, '$safeEscaped');", null)
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
