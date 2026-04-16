package n8;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f7498a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_consensus");
    private volatile Object _consensus = a.f7492a;

    public abstract void a(Object obj, Object obj2);

    public final Object b(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7498a;
        Object obj2 = atomicReferenceFieldUpdater.get(this);
        a6.d dVar = a.f7492a;
        if (obj2 == dVar) {
            a6.d c9 = c(obj);
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 == dVar) {
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, dVar, c9)) {
                        obj2 = c9;
                        break;
                    }
                    if (atomicReferenceFieldUpdater.get(this) != dVar) {
                        obj2 = atomicReferenceFieldUpdater.get(this);
                        break;
                    }
                }
            }
        }
        a(obj, obj2);
        return obj2;
    }

    public abstract a6.d c(Object obj);

    public final String toString() {
        return getClass().getSimpleName() + '@' + i8.w.f(this);
    }
}
