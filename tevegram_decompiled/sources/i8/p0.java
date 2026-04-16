package i8;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class p0 extends r0 {

    /* renamed from: n, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f5295n = AtomicIntegerFieldUpdater.newUpdater(p0.class, "_invoked");
    private volatile int _invoked;

    /* renamed from: m, reason: collision with root package name */
    public final t0 f5296m;

    public p0(t0 t0Var) {
        this.f5296m = t0Var;
    }

    @Override // a8.l
    public final /* bridge */ /* synthetic */ Object a(Object obj) {
        p((Throwable) obj);
        return n7.g.f7490c;
    }

    @Override // i8.t0
    public final void p(Throwable th) {
        if (f5295n.compareAndSet(this, 0, 1)) {
            this.f5296m.a(th);
        }
    }
}
