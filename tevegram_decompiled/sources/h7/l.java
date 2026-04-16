package h7;

import android.util.Log;
import com.network.tvgramplayer.telegram.TdClient$ExplorerAction;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class l implements Client.ResultHandler {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4156i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ k0 f4157j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ long f4158k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ n7.a f4159l;

    public /* synthetic */ l(k0 k0Var, long j5, n7.a aVar, int i9) {
        this.f4156i = i9;
        this.f4157j = k0Var;
        this.f4158k = j5;
        this.f4159l = aVar;
    }

    @Override // org.drinkless.tdlib.Client.ResultHandler
    public final void onResult(TdApi.Object object) {
        TdClient$ExplorerAction tdClient$ExplorerAction;
        switch (this.f4156i) {
            case 0:
                c cVar = (c) this.f4159l;
                Client client = this.f4157j.f4141l;
                if (client != null) {
                    client.send(new TdApi.GetChat(this.f4158k), new a3.i(cVar, 4));
                    break;
                }
                break;
            default:
                a8.r rVar = (a8.r) this.f4159l;
                int constructor = object.getConstructor();
                k0 k0Var = this.f4157j;
                long j5 = this.f4158k;
                if (constructor != 505441744) {
                    k0Var.y(j5, false, new r(k0Var, j5, rVar, 3));
                    break;
                } else {
                    TdApi.Message message = (TdApi.Message) object;
                    TdApi.MessageContent messageContent = message.content;
                    k0Var.getClass();
                    TdApi.File f9 = k0.f(messageContent);
                    if (f9 != null) {
                        k0Var.h(j5, new w(rVar, f9, j5, k0Var, 2));
                        break;
                    } else {
                        TdApi.MessageContent messageContent2 = message.content;
                        String str = null;
                        if (messageContent2 != null && (tdClient$ExplorerAction = (TdClient$ExplorerAction) o7.h.I0(k0.e(messageContent2))) != null) {
                            str = tdClient$ExplorerAction.getUrl();
                        }
                        if (str == null) {
                            k0Var.y(j5, false, new r(k0Var, j5, rVar, 2));
                            break;
                        } else {
                            Log.i("TdClient", "🔗 Link detectado en texto (Manual): ".concat(str));
                            k0Var.h(j5, new w(rVar, str, j5, k0Var, 3));
                            break;
                        }
                    }
                }
                break;
        }
    }
}
