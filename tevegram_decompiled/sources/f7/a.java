package f7;

import a5.d;
import a8.r;
import h7.k0;
import org.drinkless.tdlib.Client;
import org.drinkless.tdlib.TdApi;
import r7.i;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements r {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ boolean f3440i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ boolean f3441j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ d f3442k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ i f3443l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ e7.a f3444m;

    public a(boolean z8, boolean z9, d dVar, i iVar, e7.a aVar) {
        this.f3440i = z8;
        this.f3441j = z9;
        this.f3442k = dVar;
        this.f3443l = iVar;
        this.f3444m = aVar;
    }

    @Override // a8.r
    public final void i(Object obj, Object obj2, Object obj3, Object obj4) {
        TdApi.File file = (TdApi.File) obj;
        String str = (String) obj2;
        Long l4 = (Long) obj3;
        k0 k0Var = (k0) this.f3442k.f174j;
        e7.a aVar = this.f3444m;
        i iVar = this.f3443l;
        if (file == null) {
            if (str == null) {
                str = "ERROR_RESOLVING";
            }
            iVar.g(e7.a.a(aVar, null, 0, str, 0L, 191));
            return;
        }
        if (!this.f3440i && !this.f3441j) {
            int i9 = file.id;
            Client client = k0Var.f4141l;
            if (client != null) {
                client.send(new TdApi.DownloadFile(i9, 32, 0L, 0L, true), new androidx.fragment.app.a(27));
            }
        }
        iVar.g(e7.a.a(aVar, k0Var.f4132b + "/file/" + file.id, 0, null, l4 != null ? l4.longValue() : 0L, 126));
    }
}
