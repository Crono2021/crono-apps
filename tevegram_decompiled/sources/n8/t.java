package n8;

import i8.b1;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class t extends d implements b1 {

    /* renamed from: l, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f7532l = AtomicIntegerFieldUpdater.newUpdater(t.class, "cleanedAndPointers");
    private volatile int cleanedAndPointers;

    /* renamed from: k, reason: collision with root package name */
    public final long f7533k;

    public t(long j5, k8.l lVar, int i9) {
        super(lVar);
        this.f7533k = j5;
        this.cleanedAndPointers = i9 << 16;
    }

    @Override // n8.d
    public final boolean c() {
        return f7532l.get(this) == f() && b() != null;
    }

    public final boolean e() {
        return f7532l.addAndGet(this, -65536) == f() && b() != null;
    }

    public abstract int f();

    public abstract void g(int i9, r7.g gVar);

    public final void h() {
        if (f7532l.incrementAndGet(this) == k8.f.f5649b) {
            d();
        }
    }

    public final boolean i() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i9;
        do {
            atomicIntegerFieldUpdater = f7532l;
            i9 = atomicIntegerFieldUpdater.get(this);
            if (i9 == f() && b() != null) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i9, 65536 + i9));
        return true;
    }
}
