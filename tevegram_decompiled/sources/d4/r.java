package d4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class r implements x4.b {
    public static final u5.e D = new u5.e(29);
    public u A;
    public k B;
    public volatile boolean C;

    /* renamed from: k, reason: collision with root package name */
    public final n f2899k;

    /* renamed from: l, reason: collision with root package name */
    public final m0.c f2900l;

    /* renamed from: n, reason: collision with root package name */
    public final n f2902n;

    /* renamed from: o, reason: collision with root package name */
    public final g4.e f2903o;

    /* renamed from: p, reason: collision with root package name */
    public final g4.e f2904p;

    /* renamed from: q, reason: collision with root package name */
    public final g4.e f2905q;

    /* renamed from: s, reason: collision with root package name */
    public s f2907s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f2908t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f2909u;

    /* renamed from: v, reason: collision with root package name */
    public a0 f2910v;

    /* renamed from: w, reason: collision with root package name */
    public int f2911w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f2912x;

    /* renamed from: y, reason: collision with root package name */
    public w f2913y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f2914z;

    /* renamed from: i, reason: collision with root package name */
    public final q f2897i = new q(new ArrayList(2), 0);

    /* renamed from: j, reason: collision with root package name */
    public final x4.d f2898j = new x4.d();

    /* renamed from: r, reason: collision with root package name */
    public final AtomicInteger f2906r = new AtomicInteger();

    /* renamed from: m, reason: collision with root package name */
    public final u5.e f2901m = D;

    public r(g4.e eVar, g4.e eVar2, g4.e eVar3, g4.e eVar4, n nVar, n nVar2, x.c cVar) {
        this.f2903o = eVar;
        this.f2904p = eVar2;
        this.f2905q = eVar4;
        this.f2902n = nVar;
        this.f2899k = nVar2;
        this.f2900l = cVar;
    }

    public final synchronized void a(s4.f fVar, Executor executor) {
        try {
            this.f2898j.a();
            ((ArrayList) this.f2897i.f2896j).add(new p(fVar, executor));
            if (this.f2912x) {
                e(1);
                executor.execute(new o(this, fVar, 1));
            } else if (this.f2914z) {
                e(1);
                executor.execute(new o(this, fVar, 0));
            } else {
                w4.f.a("Cannot add callbacks to a cancelled EngineJob", !this.C);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // x4.b
    public final x4.d b() {
        return this.f2898j;
    }

    public final void c() {
        if (f()) {
            return;
        }
        this.C = true;
        k kVar = this.B;
        kVar.I = true;
        g gVar = kVar.G;
        if (gVar != null) {
            gVar.cancel();
        }
        n nVar = this.f2902n;
        s sVar = this.f2907s;
        synchronized (nVar) {
            HashMap hashMap = nVar.f2883a.f1767a;
            if (equals(hashMap.get(sVar))) {
                hashMap.remove(sVar);
            }
        }
    }

    public final void d() {
        u uVar;
        synchronized (this) {
            try {
                this.f2898j.a();
                w4.f.a("Not yet complete!", f());
                int decrementAndGet = this.f2906r.decrementAndGet();
                w4.f.a("Can't decrement below 0", decrementAndGet >= 0);
                if (decrementAndGet == 0) {
                    uVar = this.A;
                    i();
                } else {
                    uVar = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (uVar != null) {
            uVar.b();
        }
    }

    public final synchronized void e(int i9) {
        u uVar;
        w4.f.a("Not yet complete!", f());
        if (this.f2906r.getAndAdd(i9) == 0 && (uVar = this.A) != null) {
            uVar.a();
        }
    }

    public final boolean f() {
        return this.f2914z || this.f2912x || this.C;
    }

    public final void g() {
        synchronized (this) {
            try {
                this.f2898j.a();
                if (this.C) {
                    i();
                    return;
                }
                if (((ArrayList) this.f2897i.f2896j).isEmpty()) {
                    throw new IllegalStateException("Received an exception without any callbacks to notify");
                }
                if (this.f2914z) {
                    throw new IllegalStateException("Already failed once");
                }
                this.f2914z = true;
                s sVar = this.f2907s;
                q qVar = this.f2897i;
                qVar.getClass();
                ArrayList arrayList = new ArrayList((ArrayList) qVar.f2896j);
                e(arrayList.size() + 1);
                this.f2902n.e(this, sVar, null);
                int size = arrayList.size();
                int i9 = 0;
                while (i9 < size) {
                    Object obj = arrayList.get(i9);
                    i9++;
                    p pVar = (p) obj;
                    pVar.f2894b.execute(new o(this, pVar.f2893a, 0));
                }
                d();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void h() {
        synchronized (this) {
            try {
                this.f2898j.a();
                if (this.C) {
                    this.f2910v.d();
                    i();
                    return;
                }
                if (((ArrayList) this.f2897i.f2896j).isEmpty()) {
                    throw new IllegalStateException("Received a resource without any callbacks to notify");
                }
                if (this.f2912x) {
                    throw new IllegalStateException("Already have resource");
                }
                u5.e eVar = this.f2901m;
                a0 a0Var = this.f2910v;
                boolean z8 = this.f2908t;
                s sVar = this.f2907s;
                n nVar = this.f2899k;
                eVar.getClass();
                this.A = new u(a0Var, z8, true, sVar, nVar);
                this.f2912x = true;
                q qVar = this.f2897i;
                qVar.getClass();
                ArrayList arrayList = new ArrayList((ArrayList) qVar.f2896j);
                e(arrayList.size() + 1);
                this.f2902n.e(this, this.f2907s, this.A);
                int size = arrayList.size();
                int i9 = 0;
                while (i9 < size) {
                    Object obj = arrayList.get(i9);
                    i9++;
                    p pVar = (p) obj;
                    pVar.f2894b.execute(new o(this, pVar.f2893a, 1));
                }
                d();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void i() {
        if (this.f2907s == null) {
            throw new IllegalArgumentException();
        }
        ((ArrayList) this.f2897i.f2896j).clear();
        this.f2907s = null;
        this.A = null;
        this.f2910v = null;
        this.f2914z = false;
        this.C = false;
        this.f2912x = false;
        this.B.m();
        this.B = null;
        this.f2913y = null;
        this.f2911w = 0;
        this.f2900l.a(this);
    }

    public final synchronized void j(s4.f fVar) {
        try {
            this.f2898j.a();
            ((ArrayList) this.f2897i.f2896j).remove(new p(fVar, w4.f.f9938b));
            if (((ArrayList) this.f2897i.f2896j).isEmpty()) {
                c();
                if (!this.f2912x) {
                    if (this.f2914z) {
                    }
                }
                if (this.f2906r.get() == 0) {
                    i();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void k(k kVar) {
        g4.e eVar;
        this.B = kVar;
        int h = kVar.h(1);
        if (h != 2 && h != 3) {
            eVar = this.f2909u ? this.f2905q : this.f2904p;
            eVar.execute(kVar);
        }
        eVar = this.f2903o;
        eVar.execute(kVar);
    }
}
