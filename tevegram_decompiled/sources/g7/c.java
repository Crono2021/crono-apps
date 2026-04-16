package g7;

import a8.l;
import android.util.Log;
import n7.g;
import org.drinkless.tdlib.TdApi;
import r7.i;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c implements l {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ e f3814i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f3815j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ i f3816k;

    public c(e eVar, int i9, i iVar) {
        this.f3814i = eVar;
        this.f3815j = i9;
        this.f3816k = iVar;
    }

    @Override // a8.l
    public final Object a(Object obj) {
        TdApi.File file = (TdApi.File) obj;
        if (file == null) {
            Log.e(this.f3814i.f3835e, "❌ tdClient.getFile(" + this.f3815j + ") devolvió NULL (TDLib dio un error o no encontró el FileID)");
        }
        this.f3816k.g(file);
        return g.f7490c;
    }
}
