package h7;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.network.tvgramplayer.TvgramApplication;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class f implements Client.ResultHandler {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4089i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ k0 f4090j;

    public /* synthetic */ f(k0 k0Var, int i9) {
        this.f4089i = i9;
        this.f4090j = k0Var;
    }

    @Override // org.drinkless.tdlib.Client.ResultHandler
    public final void onResult(TdApi.Object object) {
        final k0 k0Var;
        Client client;
        a8.l lVar;
        Client client2;
        switch (this.f4089i) {
            case 0:
                if (object instanceof TdApi.Chat) {
                    final TdApi.Chat chat = (TdApi.Chat) object;
                    TdApi.VideoChat videoChat = chat.videoChat;
                    if ((videoChat == null || videoChat.groupCallId != 0) && (client = (k0Var = this.f4090j).f4141l) != null) {
                        final int i9 = 1;
                        client.send(new TdApi.GetGroupCall(videoChat.groupCallId), new Client.ResultHandler() { // from class: h7.g
                            @Override // org.drinkless.tdlib.Client.ResultHandler
                            public final void onResult(TdApi.Object object2) {
                                switch (i9) {
                                    case 0:
                                        if (object2 instanceof TdApi.GroupCall) {
                                            TdApi.GroupCall groupCall = (TdApi.GroupCall) object2;
                                            if (groupCall.isActive) {
                                                TdApi.Chat chat2 = chat;
                                                long j5 = chat2.id;
                                                int i10 = groupCall.id;
                                                String str = groupCall.title;
                                                str.getClass();
                                                k0Var.B(j5, i10, true, str, groupCall.participantCount, chat2);
                                                break;
                                            }
                                        }
                                        break;
                                    default:
                                        if (object2 instanceof TdApi.GroupCall) {
                                            TdApi.GroupCall groupCall2 = (TdApi.GroupCall) object2;
                                            if (groupCall2.isActive) {
                                                TdApi.Chat chat3 = chat;
                                                long j9 = chat3.id;
                                                int i11 = groupCall2.id;
                                                String str2 = groupCall2.title;
                                                str2.getClass();
                                                k0Var.B(j9, i11, true, str2, groupCall2.participantCount, chat3);
                                                break;
                                            }
                                        }
                                        break;
                                }
                            }
                        });
                        break;
                    }
                }
                break;
            case 1:
                if (object instanceof TdApi.Chat) {
                    k0 k0Var2 = this.f4090j;
                    k0Var2.f4154y.put(Long.valueOf(((TdApi.Chat) object).id), object);
                    k0Var2.A();
                    break;
                }
                break;
            case 2:
                if (object instanceof TdApi.Chat) {
                    k0 k0Var3 = this.f4090j;
                    k0Var3.f4154y.put(Long.valueOf(((TdApi.Chat) object).id), object);
                    k0Var3.A();
                    break;
                }
                break;
            case 3:
                if (object instanceof TdApi.Chat) {
                    k0 k0Var4 = this.f4090j;
                    k0Var4.f4154y.put(Long.valueOf(((TdApi.Chat) object).id), object);
                    k0Var4.A();
                    break;
                }
                break;
            case 4:
                Log.i("TVGram", "Caché de Telegram borrada vía OptimizeStorage");
                new Handler(Looper.getMainLooper()).post(new h(this.f4090j, 1));
                break;
            case 5:
                int constructor = object.getConstructor();
                if (constructor != -1679978726) {
                    if (constructor != -722616727) {
                        k0.r("ℹ️ SetTdlibParameters result: ".concat(object.getClass().getSimpleName()));
                        break;
                    } else {
                        k0.r("✅ SetTdlibParameters ACCEPTED");
                        break;
                    }
                } else {
                    TdApi.Error error = (TdApi.Error) object;
                    k0.r("❌ SetTdlibParameters FAILED: [" + error.code + "] " + error.message);
                    this.f4090j.f4136f.e("TDLib Init Error: " + error.message);
                    break;
                }
            case 6:
                if (object.getConstructor() == 1823626565) {
                    long j5 = ((TdApi.User) object).id;
                    this.f4090j.f4139j = j5;
                    Log.i("TdClient", "✅ Usuario identificado: " + j5);
                    break;
                }
                break;
            case 7:
                if (object instanceof TdApi.Error) {
                    TdApi.Error error2 = (TdApi.Error) object;
                    this.f4090j.f4136f.e("Error: " + error2.message);
                    Log.e("TdClient", "sendPassword error: " + error2.message);
                    break;
                }
                break;
            case 8:
                if (object instanceof TdApi.Error) {
                    TdApi.Error error3 = (TdApi.Error) object;
                    this.f4090j.f4136f.e("Error: " + error3.message);
                    Log.e("TdClient", "sendCode error: " + error3.message);
                    break;
                }
                break;
            case 9:
                if (object instanceof TdApi.Error) {
                    TdApi.Error error4 = (TdApi.Error) object;
                    this.f4090j.f4136f.e("Error QR: " + error4.message);
                    Log.e("TdClient", "requestQrLogin error: " + error4.message);
                    break;
                }
                break;
            case 10:
                if (object instanceof TdApi.Error) {
                    TdApi.Error error5 = (TdApi.Error) object;
                    this.f4090j.f4136f.e("Error: " + error5.message);
                    Log.e("TdClient", "sendPhone error: " + error5.message);
                    break;
                }
                break;
            default:
                final k0 k0Var5 = this.f4090j;
                ConcurrentHashMap concurrentHashMap = k0Var5.f4152w;
                switch (object.getConstructor()) {
                    case TdApi.UpdateChatLastMessage.CONSTRUCTOR /* -923244537 */:
                        TdApi.UpdateChatLastMessage updateChatLastMessage = (TdApi.UpdateChatLastMessage) object;
                        Client client3 = k0Var5.f4141l;
                        if (client3 != null) {
                            client3.send(new TdApi.GetChat(updateChatLastMessage.chatId), new f(k0Var5, 2));
                            break;
                        }
                        break;
                    case TdApi.UpdateChatPhoto.CONSTRUCTOR /* -324713921 */:
                        TdApi.UpdateChatPhoto updateChatPhoto = (TdApi.UpdateChatPhoto) object;
                        Client client4 = k0Var5.f4141l;
                        if (client4 != null) {
                            client4.send(new TdApi.GetChat(updateChatPhoto.chatId), new f(k0Var5, 3));
                            break;
                        }
                        break;
                    case TdApi.UpdateChatPosition.CONSTRUCTOR /* -8979849 */:
                        TdApi.UpdateChatPosition updateChatPosition = (TdApi.UpdateChatPosition) object;
                        Client client5 = k0Var5.f4141l;
                        if (client5 != null) {
                            client5.send(new TdApi.GetChat(updateChatPosition.chatId), new f(k0Var5, 1));
                            break;
                        }
                        break;
                    case TdApi.UpdateFile.CONSTRUCTOR /* 114132831 */:
                        TdApi.UpdateFile updateFile = (TdApi.UpdateFile) object;
                        TdApi.File file = updateFile.file;
                        TdApi.LocalFile localFile = file.local;
                        if (localFile.isDownloadingCompleted) {
                            String str = localFile.path;
                            str.getClass();
                            if (str.length() > 0 && (lVar = (a8.l) k0Var5.f4149t.remove(Integer.valueOf(file.id))) != null) {
                                Log.i("TdClient", "📩 Descarga finalizada para archivo " + file.id + ": " + file.local.path);
                                lVar.a(file.local.path);
                            }
                        }
                        String str2 = file.local.path;
                        str2.getClass();
                        if (str2.length() > 0) {
                            for (Object obj : concurrentHashMap.entrySet()) {
                                obj.getClass();
                                Object value = ((Map.Entry) obj).getValue();
                                value.getClass();
                                i0 i0Var = (i0) value;
                                String str3 = i0Var.f4118f;
                                if (str3 == null || str3.length() == 0) {
                                    Client client6 = k0Var5.f4141l;
                                    if (client6 != null) {
                                        client6.send(new TdApi.GetChat(i0Var.f4113a), new e(i0Var, 0, k0Var5));
                                    }
                                }
                            }
                        }
                        k0Var5.f4142m.e(updateFile);
                        break;
                    case TdApi.UpdateMessageContent.CONSTRUCTOR /* 506903332 */:
                        TdApi.UpdateMessageContent updateMessageContent = (TdApi.UpdateMessageContent) object;
                        if (updateMessageContent.newContent instanceof TdApi.MessageVideoChatStarted) {
                            Log.i("TdClient", "¡EL LIVE HA EMPEZADO! ChatID: " + updateMessageContent.chatId);
                            Client client7 = k0Var5.f4141l;
                            if (client7 != null) {
                                client7.send(new TdApi.GetChat(updateMessageContent.chatId), new f(k0Var5, 0));
                                break;
                            }
                        }
                        break;
                    case TdApi.UpdateChatVideoChat.CONSTRUCTOR /* 637226150 */:
                        TdApi.UpdateChatVideoChat updateChatVideoChat = (TdApi.UpdateChatVideoChat) object;
                        int i10 = updateChatVideoChat.videoChat.groupCallId;
                        if (i10 != 0) {
                            Client client8 = k0Var5.f4141l;
                            if (client8 != null) {
                                client8.send(new TdApi.GetGroupCall(i10), new e(k0Var5, updateChatVideoChat));
                                break;
                            }
                        } else {
                            k0Var5.B(updateChatVideoChat.chatId, 0, false, "", 0, null);
                            break;
                        }
                        break;
                    case TdApi.UpdateGroupCall.CONSTRUCTOR /* 808603136 */:
                        TdApi.UpdateGroupCall updateGroupCall = (TdApi.UpdateGroupCall) object;
                        Set<Long> keySet = concurrentHashMap.keySet();
                        keySet.getClass();
                        for (Long l4 : keySet) {
                            i0 i0Var2 = (i0) concurrentHashMap.get(l4);
                            if (i0Var2 != null && i0Var2.f4114b == updateGroupCall.groupCall.id) {
                                l4.getClass();
                                long longValue = l4.longValue();
                                TdApi.GroupCall groupCall = updateGroupCall.groupCall;
                                int i11 = groupCall.id;
                                boolean z8 = groupCall.isActive;
                                String str4 = groupCall.title;
                                str4.getClass();
                                k0Var5.B(longValue, i11, z8, str4, updateGroupCall.groupCall.participantCount, null);
                            }
                        }
                        break;
                    case TdApi.UpdateAuthorizationState.CONSTRUCTOR /* 1622347490 */:
                        TdApi.AuthorizationState authorizationState = ((TdApi.UpdateAuthorizationState) object).authorizationState;
                        authorizationState.getClass();
                        TvgramApplication tvgramApplication = k0Var5.f4131a;
                        l8.d dVar = k0Var5.f4134d;
                        k0.r("Auth transition: ".concat(authorizationState.getClass().getSimpleName()));
                        switch (authorizationState.getConstructor()) {
                            case TdApi.AuthorizationStateReady.CONSTRUCTOR /* -1834871737 */:
                                Log.i("TdClient", "State: READY");
                                dVar.e("READY");
                                k0Var5.f4136f.e(null);
                                Client client9 = k0Var5.f4141l;
                                if (client9 != null) {
                                    client9.send(new TdApi.GetMe(), new f(k0Var5, 6));
                                    break;
                                }
                                break;
                            case TdApi.AuthorizationStateWaitCode.CONSTRUCTOR /* 52643073 */:
                                Log.i("TdClient", "State: WaitCode");
                                dVar.e("WAIT_CODE");
                                break;
                            case TdApi.AuthorizationStateWaitPassword.CONSTRUCTOR /* 112238030 */:
                                Log.i("TdClient", "State: WaitPassword");
                                dVar.e("WAIT_PASSWORD");
                                break;
                            case TdApi.AuthorizationStateLoggingOut.CONSTRUCTOR /* 154449270 */:
                                dVar.e("LOGGING_OUT");
                                break;
                            case TdApi.AuthorizationStateWaitPhoneNumber.CONSTRUCTOR /* 306402531 */:
                                Log.i("TdClient", "State: WaitPhoneNumber");
                                dVar.e("WAIT_PHONE");
                                break;
                            case TdApi.AuthorizationStateClosing.CONSTRUCTOR /* 445855311 */:
                                dVar.e("CLOSING");
                                break;
                            case TdApi.AuthorizationStateWaitOtherDeviceConfirmation.CONSTRUCTOR /* 860166378 */:
                                TdApi.AuthorizationStateWaitOtherDeviceConfirmation authorizationStateWaitOtherDeviceConfirmation = (TdApi.AuthorizationStateWaitOtherDeviceConfirmation) authorizationState;
                                Log.i("TdClient", "State: WaitOtherDeviceConfirmation (QR Link: " + authorizationStateWaitOtherDeviceConfirmation.link + ")");
                                k0Var5.h.e(authorizationStateWaitOtherDeviceConfirmation.link);
                                dVar.e("WAIT_QR");
                                break;
                            case TdApi.AuthorizationStateWaitTdlibParameters.CONSTRUCTOR /* 904720988 */:
                                k0.r("State: WaitTdlibParameters - preparing to send...");
                                try {
                                    String str5 = "";
                                    String string = new k7.a(tvgramApplication).f5628b.getString("storage_path", "");
                                    if (string != null) {
                                        str5 = string;
                                    }
                                    String concat = str5.length() > 0 ? str5.concat("/tdlib/files") : tvgramApplication.getFilesDir().getAbsolutePath() + "/tdlib/files";
                                    String concat2 = str5.length() > 0 ? str5.concat("/tdlib") : tvgramApplication.getFilesDir().getAbsolutePath() + "/tdlib";
                                    Log.i("TdClient", "📂 Using Files Dir: ".concat(concat));
                                    byte[] bytes = k0Var5.j().getBytes(h8.a.f4218a);
                                    bytes.getClass();
                                    TdApi.SetTdlibParameters setTdlibParameters = new TdApi.SetTdlibParameters(false, concat2, concat, bytes, true, true, true, true, 36374374, "8000603d2523b8a22df55c9476d9c64a", "en", "Android", "1.0", "1.0");
                                    k0.r("Sending SetTdlibParameters (API_ID: 36374374)...");
                                    Client client10 = k0Var5.f4141l;
                                    if (client10 != null) {
                                        client10.send(setTdlibParameters, new f(k0Var5, 5));
                                        break;
                                    }
                                } catch (Exception e9) {
                                    k0.r("💥 Runtime exception in parameters: " + e9.getMessage());
                                    Log.e("TdClient", "Error during SetTdlibParameters: " + e9.getMessage());
                                    e9.printStackTrace();
                                    return;
                                }
                                break;
                            case TdApi.AuthorizationStateClosed.CONSTRUCTOR /* 1526047584 */:
                                dVar.e("CLOSED");
                                k0Var5.o();
                                break;
                        }
                    case TdApi.UpdateNewChat.CONSTRUCTOR /* 2075757773 */:
                        final TdApi.Chat chat2 = ((TdApi.UpdateNewChat) object).chat;
                        k0Var5.f4154y.put(Long.valueOf(chat2.id), chat2);
                        k0Var5.A();
                        TdApi.VideoChat videoChat2 = chat2.videoChat;
                        if ((videoChat2 == null || videoChat2.groupCallId != 0) && (client2 = k0Var5.f4141l) != null) {
                            final int i12 = 0;
                            client2.send(new TdApi.GetGroupCall(videoChat2.groupCallId), new Client.ResultHandler() { // from class: h7.g
                                @Override // org.drinkless.tdlib.Client.ResultHandler
                                public final void onResult(TdApi.Object object2) {
                                    switch (i12) {
                                        case 0:
                                            if (object2 instanceof TdApi.GroupCall) {
                                                TdApi.GroupCall groupCall2 = (TdApi.GroupCall) object2;
                                                if (groupCall2.isActive) {
                                                    TdApi.Chat chat22 = chat2;
                                                    long j52 = chat22.id;
                                                    int i102 = groupCall2.id;
                                                    String str6 = groupCall2.title;
                                                    str6.getClass();
                                                    k0Var5.B(j52, i102, true, str6, groupCall2.participantCount, chat22);
                                                    break;
                                                }
                                            }
                                            break;
                                        default:
                                            if (object2 instanceof TdApi.GroupCall) {
                                                TdApi.GroupCall groupCall22 = (TdApi.GroupCall) object2;
                                                if (groupCall22.isActive) {
                                                    TdApi.Chat chat3 = chat2;
                                                    long j9 = chat3.id;
                                                    int i112 = groupCall22.id;
                                                    String str22 = groupCall22.title;
                                                    str22.getClass();
                                                    k0Var5.B(j9, i112, true, str22, groupCall22.participantCount, chat3);
                                                    break;
                                                }
                                            }
                                            break;
                                    }
                                }
                            });
                            break;
                        }
                        break;
                }
        }
    }
}
