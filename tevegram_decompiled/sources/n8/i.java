package n8;

import i8.z;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i extends i8.s implements z {

    /* renamed from: p, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f7510p = AtomicIntegerFieldUpdater.newUpdater(i.class, "runningWorkers");

    /* renamed from: k, reason: collision with root package name */
    public final i8.s f7511k;

    /* renamed from: l, reason: collision with root package name */
    public final int f7512l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ z f7513m;

    /* renamed from: n, reason: collision with root package name */
    public final l f7514n;

    /* renamed from: o, reason: collision with root package name */
    public final Object f7515o;
    private volatile int runningWorkers;

    /* JADX WARN: Multi-variable type inference failed */
    public i(i8.s sVar, int i9) {
        this.f7511k = sVar;
        this.f7512l = i9;
        z zVar = sVar instanceof z ? (z) sVar : null;
        this.f7513m = zVar == null ? i8.y.f5330a : zVar;
        this.f7514n = new l();
        this.f7515o = new Object();
    }

    @Override // i8.z
    public final void b(long j5, i8.f fVar) {
        this.f7513m.b(j5, fVar);
    }

    @Override // i8.s
    public final void c(r7.g gVar, Runnable runnable) {
        Runnable i9;
        this.f7514n.a(runnable);
        if (f7510p.get(this) >= this.f7512l || !j() || (i9 = i()) == null) {
            return;
        }
        this.f7511k.c(this, new androidx.fragment.app.d(this, i9, 11, false));
    }

    @Override // i8.s
    public final void f(r7.g gVar, Runnable runnable) {
        Runnable i9;
        this.f7514n.a(runnable);
        if (f7510p.get(this) >= this.f7512l || !j() || (i9 = i()) == null) {
            return;
        }
        this.f7511k.f(this, new androidx.fragment.app.d(this, i9, 11, false));
    }

    public final Runnable i() {
        while (true) {
            Runnable runnable = (Runnable) this.f7514n.d();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.f7515o) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f7510p;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.f7514n.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    public final boolean j() {
        synchronized (this.f7515o) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f7510p;
            if (atomicIntegerFieldUpdater.get(this) >= this.f7512l) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }
}
