package i8;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class t0 extends n8.k implements d0, n0, a8.l {

    /* renamed from: l, reason: collision with root package name */
    public y0 f5305l;

    @Override // i8.n0
    public final boolean b() {
        return true;
    }

    @Override // i8.d0
    public final void dispose() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        y0 o8 = o();
        while (true) {
            Object w8 = o8.w();
            if (w8 instanceof t0) {
                if (w8 != this) {
                    return;
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = y0.f5331i;
                e0 e0Var = w.f5319j;
                while (!atomicReferenceFieldUpdater2.compareAndSet(o8, w8, e0Var)) {
                    if (atomicReferenceFieldUpdater2.get(o8) != w8) {
                        break;
                    }
                }
                return;
            }
            if (!(w8 instanceof n0) || ((n0) w8).g() == null) {
                return;
            }
            while (true) {
                Object l4 = l();
                if (l4 instanceof n8.q) {
                    return;
                }
                if (l4 == this) {
                    return;
                }
                l4.getClass();
                n8.k kVar = (n8.k) l4;
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = n8.k.f7519k;
                n8.q qVar = (n8.q) atomicReferenceFieldUpdater3.get(kVar);
                if (qVar == null) {
                    qVar = new n8.q(kVar);
                    atomicReferenceFieldUpdater3.lazySet(kVar, qVar);
                }
                do {
                    atomicReferenceFieldUpdater = n8.k.f7517i;
                    if (atomicReferenceFieldUpdater.compareAndSet(this, l4, qVar)) {
                        kVar.j();
                        return;
                    }
                } while (atomicReferenceFieldUpdater.get(this) == l4);
            }
        }
    }

    @Override // i8.n0
    public final z0 g() {
        return null;
    }

    public final y0 o() {
        y0 y0Var = this.f5305l;
        if (y0Var != null) {
            return y0Var;
        }
        b8.i.d("job");
        throw null;
    }

    public abstract void p(Throwable th);

    @Override // n8.k
    public final String toString() {
        return getClass().getSimpleName() + '@' + w.f(this) + "[job@" + w.f(o()) + ']';
    }
}
