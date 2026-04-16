package n8;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class d {

    /* renamed from: i, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f7500i = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "_next");

    /* renamed from: j, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f7501j = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "_prev");
    private volatile Object _next;
    private volatile Object _prev;

    public d(k8.l lVar) {
        this._prev = lVar;
    }

    public final void a() {
        f7501j.lazySet(this, null);
    }

    public final d b() {
        Object obj = f7500i.get(this);
        if (obj == a.f7493b) {
            return null;
        }
        return (d) obj;
    }

    public abstract boolean c();

    public final void d() {
        d b9;
        if (b() == null) {
            return;
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7501j;
            d dVar = (d) atomicReferenceFieldUpdater.get(this);
            while (dVar != null && dVar.c()) {
                dVar = (d) atomicReferenceFieldUpdater.get(dVar);
            }
            d b10 = b();
            b10.getClass();
            while (b10.c() && (b9 = b10.b()) != null) {
                b10 = b9;
            }
            while (true) {
                Object obj = atomicReferenceFieldUpdater.get(b10);
                d dVar2 = ((d) obj) == null ? null : dVar;
                while (!atomicReferenceFieldUpdater.compareAndSet(b10, obj, dVar2)) {
                    if (atomicReferenceFieldUpdater.get(b10) != obj) {
                        break;
                    }
                }
            }
            if (dVar != null) {
                f7500i.set(dVar, b10);
            }
            if (!b10.c() || b10.b() == null) {
                if (dVar == null || !dVar.c()) {
                    return;
                }
            }
        }
    }
}
