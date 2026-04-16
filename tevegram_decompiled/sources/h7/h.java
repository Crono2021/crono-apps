package h7;

import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4098i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ k0 f4099j;

    public /* synthetic */ h(k0 k0Var, int i9) {
        this.f4098i = i9;
        this.f4099j = k0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4098i) {
            case 0:
                k0 k0Var = this.f4099j;
                long j5 = new k7.a(k0Var.f4131a).f5628b.getLong("vod_cache_size", 629145600L);
                long j9 = 1024;
                k0.r("🛠️ Optimizing Storage (Background) with limit: " + ((j5 / j9) / j9) + " MB");
                Client client = k0Var.f4141l;
                if (client != null) {
                    client.send(new TdApi.OptimizeStorage(j5, 604800, -1, -1, null, new long[0], new long[0], false, -1), new o(k0Var, 0));
                    break;
                }
                break;
            case 1:
                Toast.makeText(this.f4099j.f4131a, "Caché de Telegram borrada", 0).show();
                break;
            case 2:
                k0 k0Var2 = this.f4099j;
                l8.d dVar = k0Var2.f4150u;
                Collection values = k0Var2.f4152w.values();
                values.getClass();
                dVar.e(o7.h.O0(values, new a0.k(6)));
                k0Var2.C = false;
                break;
            default:
                k0 k0Var3 = this.f4099j;
                Collection values2 = k0Var3.f4154y.values();
                values2.getClass();
                List Q0 = o7.h.Q0(values2);
                ArrayList arrayList = new ArrayList();
                for (Object obj : Q0) {
                    TdApi.ChatType chatType = ((TdApi.Chat) obj).type;
                    if ((chatType instanceof TdApi.ChatTypeBasicGroup) || (chatType instanceof TdApi.ChatTypeSupergroup)) {
                        arrayList.add(obj);
                    }
                }
                k0Var3.f4155z.e(o7.h.O0(arrayList, new a0.k(5)));
                k0Var3.D = false;
                break;
        }
    }
}
