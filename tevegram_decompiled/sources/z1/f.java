package z1;

import android.content.Context;
import android.os.Handler;
import b2.f0;
import b6.b1;
import b6.g0;
import b6.w0;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f {

    /* renamed from: n, reason: collision with root package name */
    public static final w0 f10549n = g0.p(4300000L, 3200000L, 2400000L, 1700000L, 860000L);

    /* renamed from: o, reason: collision with root package name */
    public static final w0 f10550o = g0.p(1500000L, 980000L, 750000L, 520000L, 290000L);

    /* renamed from: p, reason: collision with root package name */
    public static final w0 f10551p = g0.p(2000000L, 1300000L, 1000000L, 860000L, 610000L);

    /* renamed from: q, reason: collision with root package name */
    public static final w0 f10552q = g0.p(2500000L, 1700000L, 1200000L, 970000L, 680000L);

    /* renamed from: r, reason: collision with root package name */
    public static final w0 f10553r = g0.p(4700000L, 2800000L, 2100000L, 1700000L, 980000L);

    /* renamed from: s, reason: collision with root package name */
    public static final w0 f10554s = g0.p(2700000L, 2000000L, 1600000L, 1300000L, 1000000L);

    /* renamed from: t, reason: collision with root package name */
    public static f f10555t;

    /* renamed from: a, reason: collision with root package name */
    public final b1 f10556a;

    /* renamed from: b, reason: collision with root package name */
    public final c f10557b = new c();

    /* renamed from: c, reason: collision with root package name */
    public final g1.r f10558c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f10559d;

    /* renamed from: e, reason: collision with root package name */
    public final t f10560e;

    /* renamed from: f, reason: collision with root package name */
    public int f10561f;

    /* renamed from: g, reason: collision with root package name */
    public long f10562g;
    public long h;

    /* renamed from: i, reason: collision with root package name */
    public long f10563i;

    /* renamed from: j, reason: collision with root package name */
    public long f10564j;

    /* renamed from: k, reason: collision with root package name */
    public long f10565k;

    /* renamed from: l, reason: collision with root package name */
    public long f10566l;

    /* renamed from: m, reason: collision with root package name */
    public int f10567m;

    public f(Context context, Map map, int i9, g1.r rVar, boolean z8) {
        this.f10556a = b1.a(map);
        this.f10560e = new t(i9);
        this.f10558c = rVar;
        this.f10559d = z8;
        if (context == null) {
            this.f10567m = 0;
            this.f10565k = a(0);
            return;
        }
        g1.o c9 = g1.o.c(context);
        int d9 = c9.d();
        this.f10567m = d9;
        this.f10565k = a(d9);
        e eVar = new e(this);
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) c9.f3694k;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() == null) {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
        copyOnWriteArrayList.add(new WeakReference(eVar));
        ((Handler) c9.f3693j).post(new f0(c9, 7, eVar));
    }

    public final long a(int i9) {
        Integer valueOf = Integer.valueOf(i9);
        b1 b1Var = this.f10556a;
        Long l4 = (Long) b1Var.get(valueOf);
        if (l4 == null) {
            l4 = (Long) b1Var.get(0);
        }
        if (l4 == null) {
            l4 = 1000000L;
        }
        return l4.longValue();
    }

    public final void b(int i9, long j5, long j9) {
        int i10;
        long j10;
        long j11;
        if (i9 == 0 && j5 == 0 && j9 == this.f10566l) {
            return;
        }
        this.f10566l = j9;
        Iterator it = ((CopyOnWriteArrayList) this.f10557b.f10541a).iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.f10540c) {
                i10 = i9;
                j10 = j5;
                j11 = j9;
            } else {
                i10 = i9;
                j10 = j5;
                j11 = j9;
                bVar.f10538a.post(new n1.p(bVar, i10, j10, j11, 1));
            }
            i9 = i10;
            j5 = j10;
            j9 = j11;
        }
    }
}
