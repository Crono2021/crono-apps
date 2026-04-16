package h7;

import android.util.Log;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class d implements Client.ResultHandler {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4079i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ a8.l f4080j;

    public /* synthetic */ d(k0 k0Var, a8.l lVar) {
        this.f4079i = 5;
        this.f4080j = lVar;
    }

    @Override // org.drinkless.tdlib.Client.ResultHandler
    public final void onResult(TdApi.Object object) {
        switch (this.f4079i) {
            case 0:
                boolean z8 = object instanceof TdApi.FoundChatMessages;
                a8.l lVar = this.f4080j;
                if (!z8) {
                    lVar.a(o7.p.f8013i);
                    break;
                } else {
                    TdApi.Message[] messageArr = ((TdApi.FoundChatMessages) object).messages;
                    messageArr.getClass();
                    lVar.a(o7.f.d0(messageArr));
                    break;
                }
            case 1:
                boolean z9 = object instanceof TdApi.Chat;
                a8.l lVar2 = this.f4080j;
                if (!z9) {
                    lVar2.a(null);
                    break;
                } else {
                    lVar2.a(object);
                    break;
                }
            case 2:
                boolean z10 = object instanceof TdApi.Supergroup;
                a8.l lVar3 = this.f4080j;
                if (!z10) {
                    lVar3.a(Boolean.FALSE);
                    break;
                } else {
                    lVar3.a(Boolean.valueOf(((TdApi.Supergroup) object).isForum));
                    break;
                }
            case 3:
                boolean z11 = object instanceof TdApi.VideoChatStreams;
                a8.l lVar4 = this.f4080j;
                if (!z11) {
                    if (!(object instanceof TdApi.Error)) {
                        Log.e("TdClient", "❌ GetVideoChatStreams UNEXPECTED: " + (object != null ? object.getClass().getSimpleName() : null));
                        lVar4.a(null);
                        break;
                    } else {
                        TdApi.Error error = (TdApi.Error) object;
                        Log.e("TdClient", "❌ GetVideoChatStreams ERROR: " + error.message + " (code " + error.code + ")");
                        lVar4.a(null);
                        break;
                    }
                } else {
                    Log.i("TdClient", "📥 GetVideoChatStreams SUCCESS: " + ((TdApi.VideoChatStreams) object).streams.length + " streams");
                    lVar4.a(object);
                    break;
                }
            case 4:
                boolean z12 = object instanceof TdApi.Message;
                a8.l lVar5 = this.f4080j;
                if (!z12) {
                    TdApi.Error error2 = object instanceof TdApi.Error ? (TdApi.Error) object : null;
                    Log.e("TdClient", "❌ Error al subir lista: " + (error2 != null ? error2.message : null));
                    lVar5.a(Boolean.FALSE);
                    break;
                } else {
                    Log.i("TdClient", "✅ Archivo de lista subido con éxito a Mensajes Guardados.");
                    lVar5.a(Boolean.TRUE);
                    break;
                }
            case 5:
                object.getClass();
                k0.n(object, this.f4080j);
                break;
            default:
                this.f4080j.a(Boolean.valueOf(object instanceof TdApi.Ok));
                break;
        }
    }

    public /* synthetic */ d(int i9, a8.l lVar) {
        this.f4079i = i9;
        this.f4080j = lVar;
    }
}
