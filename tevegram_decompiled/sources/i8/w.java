package i8;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class w {

    /* renamed from: a, reason: collision with root package name */
    public static final a6.d f5311a;

    /* renamed from: b, reason: collision with root package name */
    public static final a6.d f5312b;

    /* renamed from: c, reason: collision with root package name */
    public static final a6.d f5313c;

    /* renamed from: d, reason: collision with root package name */
    public static final a6.d f5314d;

    /* renamed from: e, reason: collision with root package name */
    public static final a6.d f5315e;

    /* renamed from: f, reason: collision with root package name */
    public static final a6.d f5316f;

    /* renamed from: g, reason: collision with root package name */
    public static final a6.d f5317g;
    public static final a6.d h;

    /* renamed from: i, reason: collision with root package name */
    public static final e0 f5318i = new e0(false);

    /* renamed from: j, reason: collision with root package name */
    public static final e0 f5319j = new e0(true);

    static {
        int i9 = 3;
        f5311a = new a6.d("RESUME_TOKEN", i9);
        f5312b = new a6.d("REMOVED_TASK", i9);
        f5313c = new a6.d("CLOSED_EMPTY", i9);
        f5314d = new a6.d("COMPLETING_ALREADY", i9);
        f5315e = new a6.d("COMPLETING_WAITING_CHILDREN", i9);
        f5316f = new a6.d("COMPLETING_RETRY", i9);
        f5317g = new a6.d("TOO_LATE_TO_CANCEL", i9);
        h = new a6.d("SEALED", i9);
    }

    public static final n8.e a(r7.g gVar) {
        if (gVar.h(t.f5304j) == null) {
            gVar = gVar.a(new s0());
        }
        return new n8.e(gVar);
    }

    public static final void b(r7.g gVar, CancellationException cancellationException) {
        y0 y0Var = (y0) gVar.h(t.f5304j);
        if (y0Var != null) {
            if (cancellationException == null) {
                cancellationException = new q0(y0Var.n(), null, y0Var);
            }
            y0Var.l(cancellationException);
        }
    }

    public static void c(y0 y0Var) {
        y0Var.l(new q0(y0Var.n(), null, y0Var));
    }

    public static final Object d(long j5, r7.c cVar) {
        n7.g gVar = n7.g.f7490c;
        if (j5 > 0) {
            f fVar = new f(1, com.bumptech.glide.c.C(cVar));
            fVar.s();
            if (j5 < Long.MAX_VALUE) {
                r7.e h9 = fVar.f5261m.h(r7.d.f8614i);
                z zVar = h9 instanceof z ? (z) h9 : null;
                if (zVar == null) {
                    zVar = y.f5330a;
                }
                zVar.b(j5, fVar);
            }
            Object r8 = fVar.r();
            if (r8 == s7.a.f8891i) {
                return r8;
            }
        }
        return gVar;
    }

    public static final r7.g e(r7.g gVar, r7.g gVar2, boolean z8) {
        Boolean bool = Boolean.FALSE;
        p pVar = p.f5293l;
        boolean booleanValue = ((Boolean) gVar.d(bool, pVar)).booleanValue();
        boolean booleanValue2 = ((Boolean) gVar2.d(bool, pVar)).booleanValue();
        if (!booleanValue && !booleanValue2) {
            return gVar.a(gVar2);
        }
        p pVar2 = new p(2, 2);
        r7.h hVar = r7.h.f8615i;
        r7.g gVar3 = (r7.g) gVar.d(hVar, pVar2);
        Object obj = gVar2;
        if (booleanValue2) {
            obj = gVar2.d(hVar, p.f5292k);
        }
        return gVar3.a((r7.g) obj);
    }

    public static final String f(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final f g(r7.c cVar) {
        f fVar;
        f fVar2;
        if (!(cVar instanceof n8.h)) {
            return new f(1, cVar);
        }
        n8.h hVar = (n8.h) cVar;
        a6.d dVar = n8.a.f7495d;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = n8.h.f7505p;
        loop0: while (true) {
            Object obj = atomicReferenceFieldUpdater.get(hVar);
            fVar = null;
            if (obj == null) {
                atomicReferenceFieldUpdater.set(hVar, dVar);
                fVar2 = null;
                break;
            }
            if (obj instanceof f) {
                while (!atomicReferenceFieldUpdater.compareAndSet(hVar, obj, dVar)) {
                    if (atomicReferenceFieldUpdater.get(hVar) != obj) {
                        break;
                    }
                }
                fVar2 = (f) obj;
                break loop0;
            }
            if (obj != dVar && !(obj instanceof Throwable)) {
                h7.o.c(obj, "Inconsistent state ");
                return null;
            }
        }
        if (fVar2 != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f.f5258o;
            Object obj2 = atomicReferenceFieldUpdater2.get(fVar2);
            if (!(obj2 instanceof l) || ((l) obj2).f5285d == null) {
                f.f5257n.set(fVar2, 536870911);
                atomicReferenceFieldUpdater2.set(fVar2, b.f5246i);
                fVar = fVar2;
            } else {
                fVar2.o();
            }
            if (fVar != null) {
                return fVar;
            }
        }
        return new f(2, cVar);
    }

    public static final void h(r7.g gVar, Throwable th) {
        try {
            j8.b bVar = (j8.b) gVar.h(t.f5303i);
            if (bVar != null) {
                bVar.c(th);
            } else {
                n8.a.c(gVar, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                android.support.v4.media.session.b.h(runtimeException, th);
                th = runtimeException;
            }
            n8.a.c(gVar, th);
        }
    }

    public static d1 j(u uVar, r7.g gVar, a8.p pVar, int i9) {
        if ((i9 & 1) != 0) {
            gVar = r7.h.f8615i;
        }
        r7.g e9 = e(uVar.c(), gVar, true);
        p8.d dVar = c0.f5250a;
        if (e9 != dVar && e9.h(r7.d.f8614i) == null) {
            e9 = e9.a(dVar);
        }
        d1 d1Var = new d1(e9, true);
        d1Var.M(1, d1Var, pVar);
        return d1Var;
    }

    public static final Object k(Object obj) {
        if (!(obj instanceof m)) {
            return obj;
        }
        Throwable th = ((m) obj).f5289a;
        th.getClass();
        return new n7.c(th);
    }

    public static final void l(f fVar, r7.c cVar, boolean z8) {
        Object obj = f.f5258o.get(fVar);
        Throwable e9 = fVar.e(obj);
        Object cVar2 = e9 != null ? new n7.c(e9) : fVar.h(obj);
        if (!z8) {
            cVar.g(cVar2);
            return;
        }
        cVar.getClass();
        n8.h hVar = (n8.h) cVar;
        t7.c cVar3 = hVar.f7507m;
        Object obj2 = hVar.f7509o;
        r7.g gVar = cVar3.f8983j;
        gVar.getClass();
        Object k3 = n8.a.k(gVar, obj2);
        h1 p5 = k3 != n8.a.f7497f ? p(cVar3, gVar, k3) : null;
        try {
            cVar3.g(cVar2);
            if (p5 == null || p5.N()) {
                n8.a.f(gVar, k3);
            }
        } catch (Throwable th) {
            if (p5 == null || p5.N()) {
                n8.a.f(gVar, k3);
            }
            throw th;
        }
    }

    public static void m(a8.p pVar) {
        r7.g gVar;
        Thread currentThread = Thread.currentThread();
        f0 a9 = f1.a();
        boolean booleanValue = ((Boolean) a9.d(Boolean.FALSE, p.f5293l)).booleanValue();
        if (booleanValue) {
            r7.h hVar = r7.h.f8615i;
            gVar = (r7.g) (booleanValue ? a9.d(hVar, p.f5292k) : a9);
            hVar.a(gVar);
        } else {
            gVar = a9;
        }
        p8.d dVar = c0.f5250a;
        if (gVar != dVar && gVar.h(r7.d.f8614i) == null) {
            gVar = gVar.a(dVar);
        }
        c cVar = new c(gVar, currentThread, a9);
        cVar.M(1, cVar, pVar);
        f0 f0Var = cVar.f5249m;
        if (f0Var != null) {
            int i9 = f0.f5262n;
            f0Var.k(false);
        }
        while (!Thread.interrupted()) {
            try {
                long l4 = f0Var != null ? f0Var.l() : Long.MAX_VALUE;
                if (!(cVar.w() instanceof n0)) {
                    if (f0Var != null) {
                        int i10 = f0.f5262n;
                        f0Var.i(false);
                    }
                    Object o8 = o(cVar.w());
                    m mVar = o8 instanceof m ? (m) o8 : null;
                    if (mVar != null) {
                        throw mVar.f5289a;
                    }
                    return;
                }
                LockSupport.parkNanos(cVar, l4);
            } catch (Throwable th) {
                if (f0Var != null) {
                    int i11 = f0.f5262n;
                    f0Var.i(false);
                }
                throw th;
            }
        }
        InterruptedException interruptedException = new InterruptedException();
        cVar.l(interruptedException);
        throw interruptedException;
    }

    public static final String n(r7.c cVar) {
        Object cVar2;
        if (cVar instanceof n8.h) {
            return cVar.toString();
        }
        try {
            cVar2 = cVar + '@' + f(cVar);
        } catch (Throwable th) {
            cVar2 = new n7.c(th);
        }
        if (n7.d.a(cVar2) != null) {
            cVar2 = cVar.getClass().getName() + '@' + f(cVar);
        }
        return (String) cVar2;
    }

    public static final Object o(Object obj) {
        n0 n0Var;
        o0 o0Var = obj instanceof o0 ? (o0) obj : null;
        return (o0Var == null || (n0Var = o0Var.f5291a) == null) ? obj : n0Var;
    }

    public static final h1 p(r7.c cVar, r7.g gVar, Object obj) {
        h1 h1Var = null;
        if ((cVar instanceof t7.d) && gVar.h(i1.f5276i) != null) {
            t7.d dVar = (t7.d) cVar;
            while (true) {
                if ((dVar instanceof a0) || (dVar = dVar.b()) == null) {
                    break;
                }
                if (dVar instanceof h1) {
                    h1Var = (h1) dVar;
                    break;
                }
            }
            if (h1Var != null) {
                h1Var.O(gVar, obj);
            }
        }
        return h1Var;
    }

    public static final Object q(r7.g gVar, a8.p pVar, r7.c cVar) {
        r7.g f9 = cVar.f();
        r7.g a9 = !((Boolean) gVar.d(Boolean.FALSE, p.f5293l)).booleanValue() ? f9.a(gVar) : e(f9, gVar, false);
        y0 y0Var = (y0) a9.h(t.f5304j);
        if (y0Var != null && !y0Var.B()) {
            throw y0Var.s();
        }
        if (a9 == f9) {
            n8.s sVar = new n8.s(a9, cVar);
            return a.a.R(sVar, sVar, pVar);
        }
        r7.d dVar = r7.d.f8614i;
        if (b8.i.a(a9.h(dVar), f9.h(dVar))) {
            h1 h1Var = new h1(a9, cVar);
            r7.g gVar2 = h1Var.f5243k;
            Object k3 = n8.a.k(gVar2, null);
            try {
                return a.a.R(h1Var, h1Var, pVar);
            } finally {
                n8.a.f(gVar2, k3);
            }
        }
        a0 a0Var = new a0(a9, cVar);
        com.bumptech.glide.d.c0(pVar, a0Var, a0Var);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = a0.f5244m;
        do {
            int i9 = atomicIntegerFieldUpdater.get(a0Var);
            if (i9 != 0) {
                if (i9 != 2) {
                    m7.c.p("Already suspended");
                    return null;
                }
                Object o8 = o(a0Var.w());
                if (o8 instanceof m) {
                    throw ((m) o8).f5289a;
                }
                return o8;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(a0Var, 0, 1));
        return s7.a.f8891i;
    }
}
