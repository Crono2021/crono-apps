package i8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class y0 implements r7.e {

    /* renamed from: i, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f5331i = AtomicReferenceFieldUpdater.newUpdater(y0.class, Object.class, "_state");

    /* renamed from: j, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f5332j = AtomicReferenceFieldUpdater.newUpdater(y0.class, Object.class, "_parentHandle");
    private volatile Object _parentHandle;
    private volatile Object _state;

    public y0(boolean z8) {
        this._state = z8 ? w.f5319j : w.f5318i;
    }

    public static j E(n8.k kVar) {
        while (kVar.n()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = n8.k.f7518j;
            n8.k j5 = kVar.j();
            if (j5 == null) {
                Object obj = atomicReferenceFieldUpdater.get(kVar);
                while (true) {
                    kVar = (n8.k) obj;
                    if (!kVar.n()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(kVar);
                }
            } else {
                kVar = j5;
            }
        }
        while (true) {
            kVar = kVar.m();
            if (!kVar.n()) {
                if (kVar instanceof j) {
                    return (j) kVar;
                }
                if (kVar instanceof z0) {
                    return null;
                }
            }
        }
    }

    public static String K(Object obj) {
        if (!(obj instanceof w0)) {
            return obj instanceof n0 ? ((n0) obj).b() ? "Active" : "New" : obj instanceof m ? "Cancelled" : "Completed";
        }
        w0 w0Var = (w0) obj;
        return w0Var.d() ? "Cancelling" : w0Var.e() ? "Completing" : "Active";
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00af, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final i8.d0 A(boolean r9, boolean r10, i8.t0 r11) {
        /*
            Method dump skipped, instructions count: 196
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i8.y0.A(boolean, boolean, i8.t0):i8.d0");
    }

    public boolean B() {
        Object w8 = w();
        return (w8 instanceof n0) && ((n0) w8).b();
    }

    public boolean C() {
        return this instanceof c;
    }

    public final Object D(Object obj) {
        Object L;
        do {
            L = L(w(), obj);
            if (L == w.f5314d) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                m mVar = obj instanceof m ? (m) obj : null;
                throw new IllegalStateException(str, mVar != null ? mVar.f5289a : null);
            }
        } while (L == w.f5316f);
        return L;
    }

    public final void F(z0 z0Var, Throwable th) {
        Object l4 = z0Var.l();
        l4.getClass();
        androidx.fragment.app.r rVar = null;
        for (n8.k kVar = (n8.k) l4; !kVar.equals(z0Var); kVar = kVar.m()) {
            if (kVar instanceof r0) {
                t0 t0Var = (t0) kVar;
                try {
                    t0Var.p(th);
                } catch (Throwable th2) {
                    if (rVar != null) {
                        android.support.v4.media.session.b.h(rVar, th2);
                    } else {
                        rVar = new androidx.fragment.app.r("Exception in completion handler " + t0Var + " for " + this, th2);
                    }
                }
            }
        }
        if (rVar != null) {
            y(rVar);
        }
        m(th);
    }

    public final void I(t0 t0Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        z0 z0Var = new z0();
        t0Var.getClass();
        n8.k.f7518j.lazySet(z0Var, t0Var);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = n8.k.f7517i;
        atomicReferenceFieldUpdater2.lazySet(z0Var, t0Var);
        loop0: while (true) {
            if (t0Var.l() == t0Var) {
                while (!atomicReferenceFieldUpdater2.compareAndSet(t0Var, t0Var, z0Var)) {
                    if (atomicReferenceFieldUpdater2.get(t0Var) != t0Var) {
                        break;
                    }
                }
                z0Var.k(t0Var);
                break loop0;
            }
            break;
        }
        n8.k m9 = t0Var.m();
        do {
            atomicReferenceFieldUpdater = f5331i;
            if (atomicReferenceFieldUpdater.compareAndSet(this, t0Var, m9)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == t0Var);
    }

    public final int J(Object obj) {
        boolean z8 = obj instanceof e0;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5331i;
        if (z8) {
            if (((e0) obj).f5256i) {
                return 0;
            }
            e0 e0Var = w.f5319j;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, e0Var)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    return -1;
                }
            }
            return 1;
        }
        if (!(obj instanceof m0)) {
            return 0;
        }
        z0 z0Var = ((m0) obj).f5290i;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, z0Var)) {
            if (atomicReferenceFieldUpdater.get(this) != obj) {
                return -1;
            }
        }
        return 1;
    }

    /* JADX WARN: Incorrect condition in loop: B:60:0x00ce */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object L(java.lang.Object r7, java.lang.Object r8) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i8.y0.L(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    @Override // r7.g
    public final r7.g a(r7.g gVar) {
        gVar.getClass();
        return gVar == r7.h.f8615i ? this : (r7.g) gVar.d(this, new i7.a(2));
    }

    @Override // r7.g
    public final Object d(Object obj, a8.p pVar) {
        return pVar.h(obj, this);
    }

    @Override // r7.g
    public final r7.g e(r7.f fVar) {
        fVar.getClass();
        return b8.i.a(t.f5304j, fVar) ? r7.h.f8615i : this;
    }

    @Override // r7.e
    public final r7.f getKey() {
        return t.f5304j;
    }

    @Override // r7.g
    public final r7.e h(r7.f fVar) {
        fVar.getClass();
        if (b8.i.a(t.f5304j, fVar)) {
            return this;
        }
        return null;
    }

    public final boolean i(n0 n0Var, z0 z0Var, t0 t0Var) {
        n8.k j5;
        x0 x0Var = new x0(t0Var, this, n0Var);
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = n8.k.f7518j;
            j5 = z0Var.j();
            if (j5 == null) {
                Object obj = atomicReferenceFieldUpdater.get(z0Var);
                while (true) {
                    j5 = (n8.k) obj;
                    if (!j5.n()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(j5);
                }
            }
            n8.k.f7518j.lazySet(t0Var, j5);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = n8.k.f7517i;
            atomicReferenceFieldUpdater2.lazySet(t0Var, z0Var);
            x0Var.f5327c = z0Var;
            while (!atomicReferenceFieldUpdater2.compareAndSet(j5, z0Var, x0Var)) {
                if (atomicReferenceFieldUpdater2.get(j5) != z0Var) {
                    break;
                }
            }
        }
        return x0Var.b(j5) == null;
    }

    public void k(Object obj) {
        j(obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0036, code lost:
    
        if (r0 == i8.w.f5315e) goto L72;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean l(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i8.y0.l(java.lang.Object):boolean");
    }

    public final boolean m(Throwable th) {
        if (C()) {
            return true;
        }
        boolean z8 = th instanceof CancellationException;
        i iVar = (i) f5332j.get(this);
        return (iVar == null || iVar == a1.f5245i) ? z8 : iVar.f(th) || z8;
    }

    public String n() {
        return "Job was cancelled";
    }

    public boolean o(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return l(th) && t();
    }

    public final void p(n0 n0Var, Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5332j;
        i iVar = (i) atomicReferenceFieldUpdater.get(this);
        if (iVar != null) {
            iVar.dispose();
            atomicReferenceFieldUpdater.set(this, a1.f5245i);
        }
        androidx.fragment.app.r rVar = null;
        m mVar = obj instanceof m ? (m) obj : null;
        Throwable th = mVar != null ? mVar.f5289a : null;
        if (n0Var instanceof t0) {
            try {
                ((t0) n0Var).p(th);
                return;
            } catch (Throwable th2) {
                y(new androidx.fragment.app.r("Exception in completion handler " + n0Var + " for " + this, th2));
                return;
            }
        }
        z0 g9 = n0Var.g();
        if (g9 != null) {
            Object l4 = g9.l();
            l4.getClass();
            for (n8.k kVar = (n8.k) l4; !kVar.equals(g9); kVar = kVar.m()) {
                if (kVar instanceof t0) {
                    t0 t0Var = (t0) kVar;
                    try {
                        t0Var.p(th);
                    } catch (Throwable th3) {
                        if (rVar != null) {
                            android.support.v4.media.session.b.h(rVar, th3);
                        } else {
                            rVar = new androidx.fragment.app.r("Exception in completion handler " + t0Var + " for " + this, th3);
                        }
                    }
                }
            }
            if (rVar != null) {
                y(rVar);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Throwable] */
    public final Throwable q(Object obj) {
        CancellationException cancellationException;
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        y0 y0Var = (y0) obj;
        Object w8 = y0Var.w();
        if (w8 instanceof w0) {
            cancellationException = ((w0) w8).c();
        } else if (w8 instanceof m) {
            cancellationException = ((m) w8).f5289a;
        } else {
            if (w8 instanceof n0) {
                h7.o.c(w8, "Cannot be cancelling child in this state: ");
                return null;
            }
            cancellationException = null;
        }
        CancellationException cancellationException2 = cancellationException instanceof CancellationException ? cancellationException : null;
        return cancellationException2 == null ? new q0("Parent job is ".concat(K(w8)), cancellationException, y0Var) : cancellationException2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object r(w0 w0Var, Object obj) {
        Throwable th = null;
        m mVar = obj instanceof m ? (m) obj : null;
        Throwable th2 = mVar != null ? mVar.f5289a : null;
        synchronized (w0Var) {
            w0Var.d();
            ArrayList f9 = w0Var.f(th2);
            if (!f9.isEmpty()) {
                int size = f9.size();
                int i9 = 0;
                while (true) {
                    if (i9 >= size) {
                        break;
                    }
                    Object obj2 = f9.get(i9);
                    i9++;
                    if (!(((Throwable) obj2) instanceof CancellationException)) {
                        th = obj2;
                        break;
                    }
                }
                th = th;
                if (th == null) {
                    th = (Throwable) f9.get(0);
                }
            } else if (w0Var.d()) {
                th = new q0(n(), null, this);
            }
            if (th != null && f9.size() > 1) {
                Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(f9.size()));
                int size2 = f9.size();
                int i10 = 0;
                while (i10 < size2) {
                    Object obj3 = f9.get(i10);
                    i10++;
                    Throwable th3 = (Throwable) obj3;
                    if (th3 != th && th3 != th && !(th3 instanceof CancellationException) && newSetFromMap.add(th3)) {
                        android.support.v4.media.session.b.h(th, th3);
                    }
                }
            }
        }
        if (th != null && th != th2) {
            obj = new m(th, false);
        }
        if (th != null && (m(th) || x(th))) {
            obj.getClass();
            m.f5288b.compareAndSet((m) obj, 0, 1);
        }
        G(obj);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5331i;
        Object o0Var = obj instanceof n0 ? new o0((n0) obj) : obj;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, w0Var, o0Var) && atomicReferenceFieldUpdater.get(this) == w0Var) {
        }
        p(w0Var, obj);
        return obj;
    }

    public final CancellationException s() {
        CancellationException cancellationException;
        Object w8 = w();
        if (w8 instanceof w0) {
            Throwable c9 = ((w0) w8).c();
            if (c9 == null) {
                h7.o.c(this, "Job is still new or active: ");
                return null;
            }
            String concat = getClass().getSimpleName().concat(" is cancelling");
            cancellationException = c9 instanceof CancellationException ? (CancellationException) c9 : null;
            return cancellationException == null ? new q0(concat, c9, this) : cancellationException;
        }
        if (w8 instanceof n0) {
            h7.o.c(this, "Job is still new or active: ");
            return null;
        }
        if (!(w8 instanceof m)) {
            return new q0(getClass().getSimpleName().concat(" has completed normally"), null, this);
        }
        Throwable th = ((m) w8).f5289a;
        cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        return cancellationException == null ? new q0(n(), th, this) : cancellationException;
    }

    public boolean t() {
        return true;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName() + '{' + K(w()) + '}');
        sb.append('@');
        sb.append(w.f(this));
        return sb.toString();
    }

    public boolean u() {
        return this instanceof k;
    }

    public final z0 v(n0 n0Var) {
        z0 g9 = n0Var.g();
        if (g9 != null) {
            return g9;
        }
        if (n0Var instanceof e0) {
            return new z0();
        }
        if (n0Var instanceof t0) {
            I((t0) n0Var);
            return null;
        }
        h7.o.c(n0Var, "State should have list: ");
        return null;
    }

    public final Object w() {
        while (true) {
            Object obj = f5331i.get(this);
            if (!(obj instanceof n8.b)) {
                return obj;
            }
            ((n8.b) obj).b(this);
        }
    }

    public boolean x(Throwable th) {
        return false;
    }

    public final void z(y0 y0Var) {
        int J;
        d0 A;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5332j;
        a1 a1Var = a1.f5245i;
        if (y0Var == null) {
            atomicReferenceFieldUpdater.set(this, a1Var);
            return;
        }
        do {
            J = y0Var.J(y0Var.w());
            if (J == 0) {
                break;
            }
        } while (J != 1);
        A = y0Var.A((r5 & 1) == 0, (r5 & 2) != 0, new j(this));
        i iVar = (i) A;
        atomicReferenceFieldUpdater.set(this, iVar);
        if (w() instanceof n0) {
            return;
        }
        iVar.dispose();
        atomicReferenceFieldUpdater.set(this, a1Var);
    }

    public void H() {
    }

    public void G(Object obj) {
    }

    public void j(Object obj) {
    }

    public void y(androidx.fragment.app.r rVar) {
        throw rVar;
    }
}
