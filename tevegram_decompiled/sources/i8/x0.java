package i8;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class x0 extends n8.b {

    /* renamed from: b, reason: collision with root package name */
    public final t0 f5326b;

    /* renamed from: c, reason: collision with root package name */
    public z0 f5327c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ y0 f5328d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ n0 f5329e;

    public x0(t0 t0Var, y0 y0Var, n0 n0Var) {
        this.f5328d = y0Var;
        this.f5329e = n0Var;
        this.f5326b = t0Var;
    }

    @Override // n8.b
    public final void a(Object obj, Object obj2) {
        n8.k kVar = (n8.k) obj;
        boolean z8 = obj2 == null;
        t0 t0Var = this.f5326b;
        n0 n0Var = z8 ? t0Var : this.f5327c;
        if (n0Var != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = n8.k.f7517i;
            while (!atomicReferenceFieldUpdater.compareAndSet(kVar, this, n0Var)) {
                if (atomicReferenceFieldUpdater.get(kVar) != this) {
                    return;
                }
            }
            if (z8) {
                z0 z0Var = this.f5327c;
                z0Var.getClass();
                t0Var.k(z0Var);
            }
        }
    }

    @Override // n8.b
    public final a6.d c(Object obj) {
        if (this.f5328d.w() == this.f5329e) {
            return null;
        }
        return n8.a.f7496e;
    }
}
