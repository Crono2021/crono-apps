package l1;

import android.content.Context;
import android.os.Looper;
import com.network.tvgramplayer.player.PlayerManager$setupPlayer$renderersFactory$1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final Context f5978a;

    /* renamed from: b, reason: collision with root package name */
    public final g1.r f5979b;

    /* renamed from: c, reason: collision with root package name */
    public final m f5980c;

    /* renamed from: d, reason: collision with root package name */
    public final n f5981d;

    /* renamed from: e, reason: collision with root package name */
    public a6.h f5982e;

    /* renamed from: f, reason: collision with root package name */
    public a6.h f5983f;

    /* renamed from: g, reason: collision with root package name */
    public final n f5984g;
    public final Looper h;

    /* renamed from: i, reason: collision with root package name */
    public d1.g f5985i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f5986j;

    /* renamed from: k, reason: collision with root package name */
    public final int f5987k;

    /* renamed from: l, reason: collision with root package name */
    public int f5988l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f5989m;

    /* renamed from: n, reason: collision with root package name */
    public final d1 f5990n;

    /* renamed from: o, reason: collision with root package name */
    public final long f5991o;

    /* renamed from: p, reason: collision with root package name */
    public final long f5992p;

    /* renamed from: q, reason: collision with root package name */
    public final h f5993q;

    /* renamed from: r, reason: collision with root package name */
    public final long f5994r;

    /* renamed from: s, reason: collision with root package name */
    public final long f5995s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f5996t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f5997u;

    public o(Context context, PlayerManager$setupPlayer$renderersFactory$1 playerManager$setupPlayer$renderersFactory$1) {
        int i9 = 2;
        m mVar = new m(playerManager$setupPlayer$renderersFactory$1, i9);
        n nVar = new n(context, 0);
        n nVar2 = new n(context, 1);
        b2.c cVar = new b2.c(1);
        n nVar3 = new n(context, i9);
        context.getClass();
        this.f5978a = context;
        this.f5980c = mVar;
        this.f5981d = nVar;
        this.f5982e = nVar2;
        this.f5983f = cVar;
        this.f5984g = nVar3;
        int i10 = g1.w.f3713a;
        Looper myLooper = Looper.myLooper();
        this.h = myLooper == null ? Looper.getMainLooper() : myLooper;
        this.f5985i = d1.g.f2423c;
        this.f5987k = 1;
        this.f5988l = 0;
        this.f5989m = true;
        this.f5990n = d1.f5823c;
        this.f5991o = k.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS;
        this.f5992p = 15000L;
        this.f5993q = new h(g1.w.M(20L), g1.w.M(500L));
        this.f5979b = g1.r.f3705a;
        this.f5994r = 500L;
        this.f5995s = 2000L;
        this.f5996t = true;
    }
}
