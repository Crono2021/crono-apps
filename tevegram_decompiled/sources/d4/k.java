package d4;

import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k implements f, Runnable, Comparable, x4.b {
    public Object A;
    public Thread B;
    public b4.f C;
    public b4.f D;
    public Object E;
    public com.bumptech.glide.load.data.e F;
    public volatile g G;
    public volatile boolean H;
    public volatile boolean I;
    public boolean J;
    public int K;
    public int L;
    public int M;

    /* renamed from: l, reason: collision with root package name */
    public final c.a f2859l;

    /* renamed from: m, reason: collision with root package name */
    public final m0.c f2860m;

    /* renamed from: p, reason: collision with root package name */
    public com.bumptech.glide.e f2863p;

    /* renamed from: q, reason: collision with root package name */
    public b4.f f2864q;

    /* renamed from: r, reason: collision with root package name */
    public com.bumptech.glide.g f2865r;

    /* renamed from: s, reason: collision with root package name */
    public s f2866s;

    /* renamed from: t, reason: collision with root package name */
    public int f2867t;

    /* renamed from: u, reason: collision with root package name */
    public int f2868u;

    /* renamed from: v, reason: collision with root package name */
    public m f2869v;

    /* renamed from: w, reason: collision with root package name */
    public b4.i f2870w;

    /* renamed from: x, reason: collision with root package name */
    public r f2871x;

    /* renamed from: y, reason: collision with root package name */
    public int f2872y;

    /* renamed from: z, reason: collision with root package name */
    public long f2873z;

    /* renamed from: i, reason: collision with root package name */
    public final h f2856i = new h();

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f2857j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public final x4.d f2858k = new x4.d();

    /* renamed from: n, reason: collision with root package name */
    public final androidx.fragment.app.g f2861n = new androidx.fragment.app.g(5, false);

    /* renamed from: o, reason: collision with root package name */
    public final j f2862o = new j();

    public k(c.a aVar, x.c cVar) {
        this.f2859l = aVar;
        this.f2860m = cVar;
    }

    @Override // d4.f
    public final void a(b4.f fVar, Object obj, com.bumptech.glide.load.data.e eVar, int i9, b4.f fVar2) {
        this.C = fVar;
        this.E = obj;
        this.F = eVar;
        this.M = i9;
        this.D = fVar2;
        this.J = fVar != this.f2856i.a().get(0);
        if (Thread.currentThread() == this.B) {
            f();
            return;
        }
        this.L = 3;
        r rVar = this.f2871x;
        (rVar.f2909u ? rVar.f2905q : rVar.f2904p).execute(this);
    }

    @Override // x4.b
    public final x4.d b() {
        return this.f2858k;
    }

    @Override // d4.f
    public final void c(b4.f fVar, Exception exc, com.bumptech.glide.load.data.e eVar, int i9) {
        eVar.b();
        w wVar = new w("Fetching data failed", Collections.singletonList(exc));
        Class a9 = eVar.a();
        wVar.f2935j = fVar;
        wVar.f2936k = i9;
        wVar.f2937l = a9;
        this.f2857j.add(wVar);
        if (Thread.currentThread() == this.B) {
            o();
            return;
        }
        this.L = 2;
        r rVar = this.f2871x;
        (rVar.f2909u ? rVar.f2905q : rVar.f2904p).execute(this);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        k kVar = (k) obj;
        int ordinal = this.f2865r.ordinal() - kVar.f2865r.ordinal();
        return ordinal == 0 ? this.f2872y - kVar.f2872y : ordinal;
    }

    public final a0 d(com.bumptech.glide.load.data.e eVar, Object obj, int i9) {
        if (obj == null) {
            return null;
        }
        try {
            int i10 = w4.h.f9940b;
            long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            a0 e9 = e(i9, obj);
            if (Log.isLoggable("DecodeJob", 2)) {
                i("Decoded result " + e9, elapsedRealtimeNanos, null);
            }
            return e9;
        } finally {
            eVar.b();
        }
    }

    public final a0 e(int i9, Object obj) {
        Class<?> cls = obj.getClass();
        h hVar = this.f2856i;
        y c9 = hVar.c(cls);
        b4.i iVar = this.f2870w;
        if (Build.VERSION.SDK_INT >= 26) {
            boolean z8 = i9 == 4 || hVar.f2850r;
            b4.h hVar2 = k4.q.f5584i;
            Boolean bool = (Boolean) iVar.c(hVar2);
            if (bool == null || (bool.booleanValue() && !z8)) {
                iVar = new b4.i();
                w4.c cVar = this.f2870w.f1331b;
                w4.c cVar2 = iVar.f1331b;
                cVar2.i(cVar);
                cVar2.put(hVar2, Boolean.valueOf(z8));
            }
        }
        b4.i iVar2 = iVar;
        com.bumptech.glide.load.data.g h = this.f2863p.b().h(obj);
        try {
            return c9.a(this.f2867t, this.f2868u, iVar2, h, new i(this, i9));
        } finally {
            h.b();
        }
    }

    public final void f() {
        a0 a0Var;
        if (Log.isLoggable("DecodeJob", 2)) {
            i("Retrieved data", this.f2873z, "data: " + this.E + ", cache key: " + this.C + ", fetcher: " + this.F);
        }
        z zVar = null;
        try {
            a0Var = d(this.F, this.E, this.M);
        } catch (w e9) {
            b4.f fVar = this.D;
            int i9 = this.M;
            e9.f2935j = fVar;
            e9.f2936k = i9;
            e9.f2937l = null;
            this.f2857j.add(e9);
            a0Var = null;
        }
        if (a0Var == null) {
            o();
            return;
        }
        int i10 = this.M;
        if (a0Var instanceof x) {
            ((x) a0Var).a();
        }
        boolean z8 = true;
        if (((z) this.f2861n.f730l) != null) {
            zVar = (z) z.f2942m.b();
            zVar.f2946l = false;
            zVar.f2945k = true;
            zVar.f2944j = a0Var;
            a0Var = zVar;
        }
        q();
        r rVar = this.f2871x;
        synchronized (rVar) {
            rVar.f2910v = a0Var;
            rVar.f2911w = i10;
        }
        rVar.h();
        this.K = 5;
        try {
            androidx.fragment.app.g gVar = this.f2861n;
            if (((z) gVar.f730l) == null) {
                z8 = false;
            }
            if (z8) {
                try {
                    this.f2859l.a().o((b4.f) gVar.f728j, new androidx.fragment.app.g((b4.l) gVar.f729k, (z) gVar.f730l, this.f2870w, 4));
                    ((z) gVar.f730l).a();
                } catch (Throwable th) {
                    ((z) gVar.f730l).a();
                    throw th;
                }
            }
            k();
        } finally {
            if (zVar != null) {
                zVar.a();
            }
        }
    }

    public final g g() {
        int a9 = v.h.a(this.K);
        h hVar = this.f2856i;
        if (a9 == 1) {
            return new b0(hVar, this);
        }
        if (a9 == 2) {
            return new d(hVar.a(), hVar, this);
        }
        if (a9 == 3) {
            return new e0(hVar, this);
        }
        if (a9 == 5) {
            return null;
        }
        m7.c.p("Unrecognized stage: ".concat(androidx.activity.g.D(this.K)));
        return null;
    }

    public final int h(int i9) {
        boolean z8;
        boolean z9;
        int a9 = v.h.a(i9);
        if (a9 == 0) {
            switch (this.f2869v.f2882a) {
                case 0:
                case 1:
                    z8 = false;
                    break;
                default:
                    z8 = true;
                    break;
            }
            if (z8) {
                return 2;
            }
            return h(2);
        }
        if (a9 != 1) {
            if (a9 == 2) {
                return 4;
            }
            if (a9 == 3 || a9 == 5) {
                return 6;
            }
            m7.c.n("Unrecognized stage: ".concat(androidx.activity.g.D(i9)));
            return 0;
        }
        switch (this.f2869v.f2882a) {
            case 0:
                z9 = false;
                break;
            case 1:
            default:
                z9 = true;
                break;
        }
        if (z9) {
            return 3;
        }
        return h(3);
    }

    public final void i(String str, long j5, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(w4.h.a(j5));
        sb.append(", load key: ");
        sb.append(this.f2866s);
        sb.append(str2 != null ? ", ".concat(str2) : "");
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v("DecodeJob", sb.toString());
    }

    public final void j() {
        q();
        w wVar = new w("Failed to load resource", new ArrayList(this.f2857j));
        r rVar = this.f2871x;
        synchronized (rVar) {
            rVar.f2913y = wVar;
        }
        rVar.g();
        l();
    }

    public final void k() {
        boolean b9;
        j jVar = this.f2862o;
        synchronized (jVar) {
            jVar.f2854b = true;
            b9 = jVar.b();
        }
        if (b9) {
            n();
        }
    }

    public final void l() {
        boolean b9;
        j jVar = this.f2862o;
        synchronized (jVar) {
            jVar.f2855c = true;
            b9 = jVar.b();
        }
        if (b9) {
            n();
        }
    }

    public final void m() {
        boolean b9;
        j jVar = this.f2862o;
        synchronized (jVar) {
            jVar.f2853a = true;
            b9 = jVar.b();
        }
        if (b9) {
            n();
        }
    }

    public final void n() {
        j jVar = this.f2862o;
        synchronized (jVar) {
            jVar.f2854b = false;
            jVar.f2853a = false;
            jVar.f2855c = false;
        }
        androidx.fragment.app.g gVar = this.f2861n;
        gVar.f728j = null;
        gVar.f729k = null;
        gVar.f730l = null;
        h hVar = this.f2856i;
        hVar.f2836c = null;
        hVar.f2837d = null;
        hVar.f2846n = null;
        hVar.f2840g = null;
        hVar.f2843k = null;
        hVar.f2841i = null;
        hVar.f2847o = null;
        hVar.f2842j = null;
        hVar.f2848p = null;
        hVar.f2834a.clear();
        hVar.f2844l = false;
        hVar.f2835b.clear();
        hVar.f2845m = false;
        this.H = false;
        this.f2863p = null;
        this.f2864q = null;
        this.f2870w = null;
        this.f2865r = null;
        this.f2866s = null;
        this.f2871x = null;
        this.K = 0;
        this.G = null;
        this.B = null;
        this.C = null;
        this.E = null;
        this.M = 0;
        this.F = null;
        this.f2873z = 0L;
        this.I = false;
        this.A = null;
        this.f2857j.clear();
        this.f2860m.a(this);
    }

    public final void o() {
        this.B = Thread.currentThread();
        int i9 = w4.h.f9940b;
        this.f2873z = SystemClock.elapsedRealtimeNanos();
        boolean z8 = false;
        while (!this.I && this.G != null && !(z8 = this.G.b())) {
            this.K = h(this.K);
            this.G = g();
            if (this.K == 4) {
                this.L = 2;
                r rVar = this.f2871x;
                (rVar.f2909u ? rVar.f2905q : rVar.f2904p).execute(this);
                return;
            }
        }
        if ((this.K == 6 || this.I) && !z8) {
            j();
        }
    }

    public final void p() {
        int a9 = v.h.a(this.L);
        if (a9 == 0) {
            this.K = h(1);
            this.G = g();
            o();
        } else if (a9 == 1) {
            o();
        } else if (a9 == 2) {
            f();
        } else {
            int i9 = this.L;
            m7.c.p("Unrecognized run reason: ".concat(i9 != 1 ? i9 != 2 ? i9 != 3 ? "null" : "DECODE_DATA" : "SWITCH_TO_SOURCE_SERVICE" : "INITIALIZE"));
        }
    }

    public final void q() {
        Throwable th;
        this.f2858k.a();
        if (!this.H) {
            this.H = true;
            return;
        }
        if (this.f2857j.isEmpty()) {
            th = null;
        } else {
            ArrayList arrayList = this.f2857j;
            th = (Throwable) arrayList.get(arrayList.size() - 1);
        }
        throw new IllegalStateException("Already notified", th);
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.bumptech.glide.load.data.e eVar = this.F;
        try {
            try {
                if (this.I) {
                    j();
                    if (eVar != null) {
                        eVar.b();
                        return;
                    }
                    return;
                }
                p();
                if (eVar != null) {
                    eVar.b();
                }
            } catch (Throwable th) {
                if (eVar != null) {
                    eVar.b();
                }
                throw th;
            }
        } catch (c e9) {
            throw e9;
        } catch (Throwable th2) {
            if (Log.isLoggable("DecodeJob", 3)) {
                Log.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.I + ", stage: " + androidx.activity.g.D(this.K), th2);
            }
            if (this.K != 5) {
                this.f2857j.add(th2);
                j();
            }
            if (!this.I) {
                throw th2;
            }
            throw th2;
        }
    }
}
