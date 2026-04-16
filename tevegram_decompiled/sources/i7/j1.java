package i7;

import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.network.tvgramplayer.data.HistoryItem;
import com.network.tvgramplayer.ui.MainActivity;
import com.network.tvgramplayer.ui.PlayerActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j1 extends t7.h implements a8.p {

    /* renamed from: m, reason: collision with root package name */
    public Intent f4923m;

    /* renamed from: n, reason: collision with root package name */
    public int f4924n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f4925o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ n.q f4926p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ MainActivity f4927q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ e7.a f4928r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ String f4929s;

    /* renamed from: t, reason: collision with root package name */
    public final /* synthetic */ Uri f4930t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j1(int i9, n.q qVar, MainActivity mainActivity, e7.a aVar, String str, Uri uri, r7.c cVar) {
        super(2, cVar);
        this.f4925o = i9;
        this.f4926p = qVar;
        this.f4927q = mainActivity;
        this.f4928r = aVar;
        this.f4929s = str;
        this.f4930t = uri;
    }

    @Override // a8.p
    public final Object h(Object obj, Object obj2) {
        return ((j1) j((i8.u) obj, (r7.c) obj2)).k(n7.g.f7490c);
    }

    @Override // t7.a
    public final r7.c j(Object obj, r7.c cVar) {
        return new j1(this.f4925o, this.f4926p, this.f4927q, this.f4928r, this.f4929s, this.f4930t, cVar);
    }

    @Override // t7.a
    public final Object k(Object obj) {
        Intent intent;
        Uri parse;
        Object j5;
        int i9 = this.f4924n;
        MainActivity mainActivity = this.f4927q;
        if (i9 == 0) {
            com.bumptech.glide.c.V(obj);
            boolean z8 = this.f4925o == 1;
            if (this.f4926p.isChecked()) {
                k7.a aVar = mainActivity.K;
                if (aVar == null) {
                    b8.i.d("settings");
                    throw null;
                }
                aVar.f5628b.edit().putBoolean("use_external_player", z8).apply();
            }
            e7.a aVar2 = this.f4928r;
            if (z8) {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setDataAndType(Uri.parse(aVar2.f3151a), "video/*");
                try {
                    mainActivity.startActivity(intent2);
                } catch (Exception unused) {
                    Toast.makeText(mainActivity, "No hay reproductor externo disponible", 0).show();
                }
                return n7.g.f7490c;
            }
            String str = aVar2.f3152b;
            if (str == null) {
                str = "Video Externo";
            }
            HistoryItem historyItem = new HistoryItem(0L, this.f4929s, str, null, null, false, 0L, 0L, null, null, "play", 1016, null);
            a0.l lVar = mainActivity.G;
            if (lVar == null) {
                b8.i.d("historyManager");
                throw null;
            }
            lVar.b(historyItem);
            intent = new Intent(mainActivity, (Class<?>) PlayerActivity.class);
            String str2 = this.f4929s;
            if (h8.m.f0(str2, "tvgram://", false)) {
                parse = this.f4930t;
            } else {
                parse = Uri.parse("tvgram://play?url=" + Uri.encode(str2));
            }
            intent.setData(parse);
            intent.putExtra("EXTRA_CONTEXT_URL", str2);
            a0.l lVar2 = mainActivity.G;
            if (lVar2 == null) {
                b8.i.d("historyManager");
                throw null;
            }
            this.f4923m = intent;
            this.f4924n = 1;
            j5 = lVar2.j(str2, this);
            s7.a aVar3 = s7.a.f8891i;
            if (j5 == aVar3) {
                return aVar3;
            }
        } else {
            if (i9 != 1) {
                m7.c.p("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            intent = this.f4923m;
            com.bumptech.glide.c.V(obj);
            j5 = obj;
        }
        HistoryItem historyItem2 = (HistoryItem) j5;
        long positionMs = historyItem2 != null ? historyItem2.getPositionMs() : 0L;
        if (positionMs > 10000) {
            intent.putExtra("EXTRA_POSITION", positionMs);
        }
        mainActivity.startActivity(intent);
        return n7.g.f7490c;
    }
}
