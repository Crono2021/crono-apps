package i8;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class f extends b0 implements t7.d, j1, r7.c {

    /* renamed from: n, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f5257n = AtomicIntegerFieldUpdater.newUpdater(f.class, "_decisionAndIndex");

    /* renamed from: o, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f5258o = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_state");

    /* renamed from: p, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f5259p = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_parentHandle");
    private volatile int _decisionAndIndex;
    private volatile Object _parentHandle;
    private volatile Object _state;

    /* renamed from: l, reason: collision with root package name */
    public final r7.c f5260l;

    /* renamed from: m, reason: collision with root package name */
    public final r7.g f5261m;

    public f(int i9, r7.c cVar) {
        super(i9);
        this.f5260l = cVar;
        this.f5261m = cVar.f();
        this._decisionAndIndex = 536870911;
        this._state = b.f5246i;
    }

    public static Object C(b1 b1Var, Object obj, int i9, a8.l lVar) {
        if (obj instanceof m) {
            return obj;
        }
        if (i9 != 1 && i9 != 2) {
            return obj;
        }
        if (lVar != null || (b1Var instanceof e)) {
            return new l(obj, b1Var instanceof e ? (e) b1Var : null, lVar, (CancellationException) null, 16);
        }
        return obj;
    }

    public static void x(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    public final void A(Object obj, int i9, a8.l lVar) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5258o;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof b1) {
                Object C = C((b1) obj2, obj, i9, lVar);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, C)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                if (!w()) {
                    o();
                }
                p(i9);
                return;
            }
            if (obj2 instanceof g) {
                g gVar = (g) obj2;
                if (g.f5267c.compareAndSet(gVar, 0, 1)) {
                    if (lVar != null) {
                        l(lVar, gVar.f5289a);
                        return;
                    }
                    return;
                }
            }
            h7.o.c(obj, "Already resumed, but proposed with update ");
            return;
        }
    }

    public final void B(s sVar) {
        n7.g gVar = n7.g.f7490c;
        r7.c cVar = this.f5260l;
        n8.h hVar = cVar instanceof n8.h ? (n8.h) cVar : null;
        A(gVar, (hVar != null ? hVar.f7506l : null) == sVar ? 4 : this.f5247k, null);
    }

    @Override // i8.j1
    public final void a(n8.t tVar, int i9) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i10;
        do {
            atomicIntegerFieldUpdater = f5257n;
            i10 = atomicIntegerFieldUpdater.get(this);
            if ((i10 & 536870911) != 536870911) {
                m7.c.p("invokeOnCancellation should be called at most once");
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, ((i10 >> 29) << 29) + i9));
        v(tVar);
    }

    @Override // t7.d
    public final t7.d b() {
        r7.c cVar = this.f5260l;
        if (cVar instanceof t7.d) {
            return (t7.d) cVar;
        }
        return null;
    }

    @Override // i8.b0
    public final void c(Object obj, CancellationException cancellationException) {
        CancellationException cancellationException2;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5258o;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof b1) {
                m7.c.p("Not completed");
                return;
            }
            if (obj2 instanceof m) {
                return;
            }
            if (!(obj2 instanceof l)) {
                cancellationException2 = cancellationException;
                l lVar = new l(obj2, (e) null, (a8.l) null, cancellationException2, 14);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, lVar)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                return;
            }
            l lVar2 = (l) obj2;
            if (lVar2.f5286e != null) {
                m7.c.p("Must be called at most once");
                return;
            }
            l a9 = l.a(lVar2, null, cancellationException, 15);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, a9)) {
                if (atomicReferenceFieldUpdater.get(this) != obj2) {
                    cancellationException2 = cancellationException;
                }
            }
            e eVar = lVar2.f5283b;
            if (eVar != null) {
                k(eVar, cancellationException);
            }
            a8.l lVar3 = lVar2.f5284c;
            if (lVar3 != null) {
                l(lVar3, cancellationException);
                return;
            }
            return;
            cancellationException = cancellationException2;
        }
    }

    @Override // i8.b0
    public final r7.c d() {
        return this.f5260l;
    }

    @Override // i8.b0
    public final Throwable e(Object obj) {
        Throwable e9 = super.e(obj);
        if (e9 != null) {
            return e9;
        }
        return null;
    }

    @Override // r7.c
    public final r7.g f() {
        return this.f5261m;
    }

    @Override // r7.c
    public final void g(Object obj) {
        Throwable a9 = n7.d.a(obj);
        if (a9 != null) {
            obj = new m(a9, false);
        }
        A(obj, this.f5247k, null);
    }

    @Override // i8.b0
    public final Object h(Object obj) {
        return obj instanceof l ? ((l) obj).f5282a : obj;
    }

    @Override // i8.b0
    public final Object j() {
        return f5258o.get(this);
    }

    public final void k(e eVar, Throwable th) {
        try {
            eVar.b(th);
        } catch (Throwable th2) {
            w.h(this.f5261m, new androidx.fragment.app.r("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void l(a8.l lVar, Throwable th) {
        try {
            lVar.a(th);
        } catch (Throwable th2) {
            w.h(this.f5261m, new androidx.fragment.app.r("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public final void m(n8.t tVar, Throwable th) {
        r7.g gVar = this.f5261m;
        int i9 = f5257n.get(this) & 536870911;
        if (i9 == 536870911) {
            m7.c.p("The index for Segment.onCancellation(..) is broken");
            return;
        }
        try {
            tVar.g(i9, gVar);
        } catch (Throwable th2) {
            w.h(gVar, new androidx.fragment.app.r("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void n(Throwable th) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5258o;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof b1) {
                g gVar = new g(this, th, (obj instanceof e) || (obj instanceof n8.t));
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, gVar)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                b1 b1Var = (b1) obj;
                if (b1Var instanceof e) {
                    k((e) obj, th);
                } else if (b1Var instanceof n8.t) {
                    m((n8.t) obj, th);
                }
                if (!w()) {
                    o();
                }
                p(this.f5247k);
                return;
            }
            return;
        }
    }

    public final void o() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5259p;
        d0 d0Var = (d0) atomicReferenceFieldUpdater.get(this);
        if (d0Var == null) {
            return;
        }
        d0Var.dispose();
        atomicReferenceFieldUpdater.set(this, a1.f5245i);
    }

    public final void p(int i9) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i10;
        do {
            atomicIntegerFieldUpdater = f5257n;
            i10 = atomicIntegerFieldUpdater.get(this);
            int i11 = i10 >> 29;
            if (i11 != 0) {
                if (i11 != 1) {
                    m7.c.p("Already resumed");
                    return;
                }
                boolean z8 = i9 == 4;
                r7.c cVar = this.f5260l;
                if (!z8 && (cVar instanceof n8.h)) {
                    boolean z9 = i9 == 1 || i9 == 2;
                    int i12 = this.f5247k;
                    if (z9 == (i12 == 1 || i12 == 2)) {
                        n8.h hVar = (n8.h) cVar;
                        s sVar = hVar.f7506l;
                        r7.g gVar = hVar.f7507m.f8983j;
                        gVar.getClass();
                        if (sVar.g()) {
                            sVar.c(gVar, this);
                            return;
                        }
                        f0 a9 = f1.a();
                        if (a9.f5263k >= IjkMediaMeta.AV_CH_WIDE_RIGHT) {
                            a9.j(this);
                            return;
                        }
                        a9.k(true);
                        try {
                            w.l(this, cVar, true);
                            do {
                            } while (a9.m());
                        } finally {
                            try {
                                return;
                            } finally {
                            }
                        }
                        return;
                    }
                }
                w.l(this, cVar, z8);
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, 1073741824 + (536870911 & i10)));
    }

    public Throwable q(y0 y0Var) {
        return y0Var.s();
    }

    public final Object r() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i9;
        y0 y0Var;
        boolean w8 = w();
        do {
            atomicIntegerFieldUpdater = f5257n;
            i9 = atomicIntegerFieldUpdater.get(this);
            int i10 = i9 >> 29;
            if (i10 != 0) {
                if (i10 != 2) {
                    m7.c.p("Already suspended");
                    return null;
                }
                if (w8) {
                    z();
                }
                Object obj = f5258o.get(this);
                if (obj instanceof m) {
                    throw ((m) obj).f5289a;
                }
                int i11 = this.f5247k;
                if ((i11 != 1 && i11 != 2) || (y0Var = (y0) this.f5261m.h(t.f5304j)) == null || y0Var.B()) {
                    return h(obj);
                }
                CancellationException s8 = y0Var.s();
                c(obj, s8);
                throw s8;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i9, 536870912 + (536870911 & i9)));
        if (((d0) f5259p.get(this)) == null) {
            t();
        }
        if (w8) {
            z();
        }
        return s7.a.f8891i;
    }

    public final void s() {
        d0 t8 = t();
        if (t8 == null || (f5258o.get(this) instanceof b1)) {
            return;
        }
        t8.dispose();
        f5259p.set(this, a1.f5245i);
    }

    public final d0 t() {
        d0 A;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        y0 y0Var = (y0) this.f5261m.h(t.f5304j);
        if (y0Var == null) {
            return null;
        }
        A = y0Var.A((r5 & 1) == 0, (r5 & 2) != 0, new h(this));
        do {
            atomicReferenceFieldUpdater = f5259p;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, A)) {
                break;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        return A;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(y());
        sb.append('(');
        sb.append(w.n(this.f5260l));
        sb.append("){");
        Object obj = f5258o.get(this);
        sb.append(obj instanceof b1 ? "Active" : obj instanceof g ? "Cancelled" : "Completed");
        sb.append("}@");
        sb.append(w.f(this));
        return sb.toString();
    }

    public final void u(a8.l lVar) {
        v(lVar instanceof e ? (e) lVar : new e(lVar, 2));
    }

    public final void v(b1 b1Var) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5258o;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof b) {
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, b1Var)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                return;
            }
            boolean z8 = true;
            if (obj instanceof e ? true : obj instanceof n8.t) {
                x(b1Var, obj);
                throw null;
            }
            if (obj instanceof m) {
                m mVar = (m) obj;
                if (!m.f5288b.compareAndSet(mVar, 0, 1)) {
                    x(b1Var, obj);
                    throw null;
                }
                if (obj instanceof g) {
                    Throwable th = mVar.f5289a;
                    if (b1Var instanceof e) {
                        k((e) b1Var, th);
                        return;
                    } else {
                        b1Var.getClass();
                        m((n8.t) b1Var, th);
                        return;
                    }
                }
                return;
            }
            if (obj instanceof l) {
                l lVar = (l) obj;
                if (lVar.f5283b != null) {
                    x(b1Var, obj);
                    throw null;
                }
                if (b1Var instanceof n8.t) {
                    return;
                }
                b1Var.getClass();
                e eVar = (e) b1Var;
                Throwable th2 = lVar.f5286e;
                if (th2 != null) {
                    k(eVar, th2);
                    return;
                }
                l a9 = l.a(lVar, eVar, null, 29);
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj, a9)) {
                        break;
                    } else if (atomicReferenceFieldUpdater.get(this) != obj) {
                        z8 = false;
                        break;
                    }
                }
                if (z8) {
                    return;
                }
            } else {
                if (b1Var instanceof n8.t) {
                    return;
                }
                b1Var.getClass();
                l lVar2 = new l(obj, (e) b1Var, (a8.l) null, (CancellationException) null, 28);
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, obj, lVar2)) {
                        break;
                    } else if (atomicReferenceFieldUpdater.get(this) != obj) {
                        z8 = false;
                        break;
                    }
                }
                if (z8) {
                    return;
                }
            }
        }
    }

    public final boolean w() {
        if (this.f5247k != 2) {
            return false;
        }
        r7.c cVar = this.f5260l;
        cVar.getClass();
        return n8.h.f7505p.get((n8.h) cVar) != null;
    }

    public String y() {
        return "CancellableContinuation";
    }

    public final void z() {
        r7.c cVar = this.f5260l;
        Throwable th = null;
        n8.h hVar = cVar instanceof n8.h ? (n8.h) cVar : null;
        if (hVar != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = n8.h.f7505p;
            loop0: while (true) {
                Object obj = atomicReferenceFieldUpdater.get(hVar);
                a6.d dVar = n8.a.f7495d;
                if (obj == dVar) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(hVar, dVar, this)) {
                        if (atomicReferenceFieldUpdater.get(hVar) != dVar) {
                            break;
                        }
                    }
                    break loop0;
                } else {
                    if (!(obj instanceof Throwable)) {
                        h7.o.c(obj, "Inconsistent state ");
                        return;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(hVar, obj, null)) {
                        if (atomicReferenceFieldUpdater.get(hVar) != obj) {
                            m7.c.n("Failed requirement.");
                            return;
                        }
                    }
                    th = (Throwable) obj;
                }
            }
            if (th == null) {
                return;
            }
            o();
            n(th);
        }
    }
}
