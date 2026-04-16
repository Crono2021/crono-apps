package n8;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f7520a = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_cur");
    private volatile Object _cur = new n(8, false);

    public final boolean a(Runnable runnable) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7520a;
            n nVar = (n) atomicReferenceFieldUpdater.get(this);
            int a9 = nVar.a(runnable);
            if (a9 == 0) {
                return true;
            }
            if (a9 == 1) {
                n c9 = nVar.c();
                while (!atomicReferenceFieldUpdater.compareAndSet(this, nVar, c9) && atomicReferenceFieldUpdater.get(this) == nVar) {
                }
            } else if (a9 == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7520a;
            n nVar = (n) atomicReferenceFieldUpdater.get(this);
            if (nVar.b()) {
                return;
            }
            n c9 = nVar.c();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, nVar, c9) && atomicReferenceFieldUpdater.get(this) == nVar) {
            }
        }
    }

    public final int c() {
        n nVar = (n) f7520a.get(this);
        nVar.getClass();
        long j5 = n.f7523f.get(nVar);
        return 1073741823 & (((int) ((j5 & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j5)));
    }

    public final Object d() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7520a;
            n nVar = (n) atomicReferenceFieldUpdater.get(this);
            Object d9 = nVar.d();
            if (d9 != n.f7524g) {
                return d9;
            }
            n c9 = nVar.c();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, nVar, c9) && atomicReferenceFieldUpdater.get(this) == nVar) {
            }
        }
    }
}
