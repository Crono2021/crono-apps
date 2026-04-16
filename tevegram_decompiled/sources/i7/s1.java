package i7;

import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.network.tvgramplayer.ui.MainActivity;
import com.network.tvgramplayer.ui.PlayerActivity;
import org.drinkless.tdlib.TdApi;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class s1 implements a8.l {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ MainActivity f5102i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Long f5103j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ TdApi.File f5104k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ TdApi.File f5105l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f5106m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f5107n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ String f5108o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ String f5109p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ long f5110q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ String f5111r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ String f5112s;

    public /* synthetic */ s1(MainActivity mainActivity, Long l4, TdApi.File file, TdApi.File file2, String str, String str2, String str3, String str4, long j5, String str5, String str6) {
        this.f5102i = mainActivity;
        this.f5103j = l4;
        this.f5104k = file;
        this.f5105l = file2;
        this.f5106m = str;
        this.f5107n = str2;
        this.f5108o = str3;
        this.f5109p = str4;
        this.f5110q = j5;
        this.f5111r = str5;
        this.f5112s = str6;
    }

    @Override // a8.l
    public final Object a(Object obj) {
        String str = (String) obj;
        MainActivity mainActivity = this.f5102i;
        Toast.makeText(mainActivity, "Video encontrado. Abriendo...", 0).show();
        Intent intent = new Intent(mainActivity, (Class<?>) PlayerActivity.class);
        Long l4 = this.f5103j;
        if ((l4 != null && l4.longValue() == 0) || this.f5104k == null) {
            int i9 = this.f5105l.id;
        }
        String str2 = this.f5106m;
        if (str2 == null) {
            str2 = this.f5107n;
        }
        String encode = Uri.encode(str2);
        String str3 = this.f5108o;
        if (str3 == null) {
            str3 = this.f5109p;
        }
        intent.setData(Uri.parse("tvgram://play?url=" + encode + "&title=" + Uri.encode(str3)));
        long j5 = this.f5110q;
        if (j5 > l1.k.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS) {
            intent.putExtra("EXTRA_POSITION", j5);
        }
        if (str != null) {
            intent.putExtra("EXTRA_PLAYER_CHOICE", str);
        }
        intent.putExtra("EXTRA_CONTEXT_URL", this.f5111r);
        intent.putExtra("EXTRA_CHAT_TYPE", this.f5112s);
        mainActivity.startActivity(intent);
        return n7.g.f7490c;
    }
}
