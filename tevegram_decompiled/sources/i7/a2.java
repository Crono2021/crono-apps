package i7;

import android.content.Intent;
import android.util.Log;
import com.network.tvgramplayer.ui.MainActivity;
import com.network.tvgramplayer.ui.MediaExplorerActivity;
import org.drinkless.tdlib.TdApi;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class a2 implements a8.l {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ MainActivity f4756i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ TdApi.File f4757j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f4758k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f4759l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ z1 f4760m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f4761n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ String f4762o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ String f4763p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ String f4764q;

    public /* synthetic */ a2(MainActivity mainActivity, TdApi.File file, String str, String str2, z1 z1Var, String str3, String str4, String str5, String str6) {
        this.f4756i = mainActivity;
        this.f4757j = file;
        this.f4758k = str;
        this.f4759l = str2;
        this.f4760m = z1Var;
        this.f4761n = str3;
        this.f4762o = str4;
        this.f4763p = str5;
        this.f4764q = str6;
    }

    @Override // a8.l
    public final Object a(Object obj) {
        final Long l4 = (Long) obj;
        final MainActivity mainActivity = this.f4756i;
        final TdApi.File file = this.f4757j;
        final String str = this.f4758k;
        final String str2 = this.f4759l;
        final z1 z1Var = this.f4760m;
        final String str3 = this.f4761n;
        final String str4 = this.f4762o;
        final String str5 = this.f4763p;
        final String str6 = this.f4764q;
        mainActivity.runOnUiThread(new Runnable() { // from class: i7.r1
            @Override // java.lang.Runnable
            public final void run() {
                Long l9 = l4;
                MainActivity mainActivity2 = mainActivity;
                if (l9 == null) {
                    mainActivity2.s("> Error Joining Chat.");
                    mainActivity2.U = false;
                    return;
                }
                mainActivity2.s("> Join Success. Verificando opciones...");
                TdApi.File file2 = file;
                boolean z8 = file2 != null;
                boolean a9 = b8.i.a(str, "explorer");
                String str7 = str2;
                if (a9) {
                    Intent intent = new Intent(mainActivity2, (Class<?>) MediaExplorerActivity.class);
                    intent.putExtra("chat_id", l9.longValue());
                    intent.putExtra("chat_title", str7);
                    mainActivity2.startActivity(intent);
                    mainActivity2.U = false;
                    return;
                }
                if (!z8) {
                    mainActivity2.runOnUiThread(new c1(l9.longValue(), mainActivity2, str5, str7, str3, str6, str4));
                } else {
                    Log.i("MainActivity", "✅ Usando archivo ya resuelto de mensaje directo.");
                    z1Var.h(file2, null);
                }
            }
        });
        return n7.g.f7490c;
    }
}
