package i8;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a0 extends n8.s {

    /* renamed from: m, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f5244m = AtomicIntegerFieldUpdater.newUpdater(a0.class, "_decision");
    private volatile int _decision;

    @Override // n8.s, i8.y0
    public final void j(Object obj) {
        k(obj);
    }

    @Override // n8.s, i8.y0
    public final void k(Object obj) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        do {
            atomicIntegerFieldUpdater = f5244m;
            int i9 = atomicIntegerFieldUpdater.get(this);
            if (i9 != 0) {
                if (i9 != 1) {
                    m7.c.p("Already resumed");
                    return;
                } else {
                    n8.a.g(w.k(obj), com.bumptech.glide.c.C(this.f7531l));
                    return;
                }
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, 0, 2));
    }
}
