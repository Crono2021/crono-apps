package i8;

import java.util.concurrent.locks.LockSupport;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c extends a {

    /* renamed from: l, reason: collision with root package name */
    public final Thread f5248l;

    /* renamed from: m, reason: collision with root package name */
    public final f0 f5249m;

    public c(r7.g gVar, Thread thread, f0 f0Var) {
        super(gVar, true);
        this.f5248l = thread;
        this.f5249m = f0Var;
    }

    @Override // i8.y0
    public final void j(Object obj) {
        Thread currentThread = Thread.currentThread();
        Thread thread = this.f5248l;
        if (b8.i.a(currentThread, thread)) {
            return;
        }
        LockSupport.unpark(thread);
    }
}
