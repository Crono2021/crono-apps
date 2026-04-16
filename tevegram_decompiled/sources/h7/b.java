package h7;

import android.util.Log;
import d1.r0;
import d1.s0;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class b implements Client.ResultHandler, g1.j {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4067i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f4068j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f4069k;

    public /* synthetic */ b(Object obj, int i9, Object obj2) {
        this.f4067i = i9;
        this.f4068j = obj;
        this.f4069k = obj2;
    }

    @Override // g1.j
    public void a(Object obj) {
        s0 s0Var = (s0) this.f4068j;
        s0 s0Var2 = (s0) this.f4069k;
        r0 r0Var = (r0) obj;
        int i9 = this.f4067i;
        r0Var.e(i9);
        r0Var.c(s0Var, s0Var2, i9);
    }

    @Override // org.drinkless.tdlib.Client.ResultHandler
    public void onResult(TdApi.Object object) {
        a8.l lVar = (a8.l) this.f4068j;
        k0 k0Var = (k0) this.f4069k;
        if (!(object instanceof TdApi.File)) {
            lVar.a(null);
            return;
        }
        TdApi.File file = (TdApi.File) object;
        TdApi.LocalFile localFile = file.local;
        boolean z8 = localFile.isDownloadingCompleted;
        int i9 = this.f4067i;
        if (z8) {
            String str = localFile.path;
            str.getClass();
            if (str.length() > 0) {
                Log.d("TdClient", "📂 El archivo " + i9 + " ya estaba descargado.");
                lVar.a(file.local.path);
                return;
            }
        }
        k0Var.f4149t.put(Integer.valueOf(i9), lVar);
        Client client = k0Var.f4141l;
        if (client != null) {
            client.send(new TdApi.DownloadFile(i9, 32, 0L, 0L, true), new androidx.fragment.app.a(27));
        }
    }
}
