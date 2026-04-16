package r7;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i implements c, t7.d {

    /* renamed from: j, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f8616j = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "result");

    /* renamed from: i, reason: collision with root package name */
    public final c f8617i;
    private volatile Object result;

    public i(c cVar) {
        s7.a aVar = s7.a.f8892j;
        this.f8617i = cVar;
        this.result = aVar;
    }

    public final Object a() {
        Object obj = this.result;
        s7.a aVar = s7.a.f8892j;
        if (obj == aVar) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8616j;
            s7.a aVar2 = s7.a.f8891i;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, aVar, aVar2)) {
                if (atomicReferenceFieldUpdater.get(this) != aVar) {
                    obj = this.result;
                }
            }
            return s7.a.f8891i;
        }
        if (obj == s7.a.f8893k) {
            return s7.a.f8891i;
        }
        if (obj instanceof n7.c) {
            throw ((n7.c) obj).f7482i;
        }
        return obj;
    }

    @Override // t7.d
    public final t7.d b() {
        c cVar = this.f8617i;
        if (cVar instanceof t7.d) {
            return (t7.d) cVar;
        }
        return null;
    }

    @Override // r7.c
    public final g f() {
        return this.f8617i.f();
    }

    @Override // r7.c
    public final void g(Object obj) {
        while (true) {
            Object obj2 = this.result;
            s7.a aVar = s7.a.f8892j;
            if (obj2 == aVar) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8616j;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, aVar, obj)) {
                    if (atomicReferenceFieldUpdater.get(this) != aVar) {
                        break;
                    }
                }
                return;
            }
            s7.a aVar2 = s7.a.f8891i;
            if (obj2 != aVar2) {
                m7.c.p("Already resumed");
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f8616j;
            s7.a aVar3 = s7.a.f8893k;
            while (!atomicReferenceFieldUpdater2.compareAndSet(this, aVar2, aVar3)) {
                if (atomicReferenceFieldUpdater2.get(this) != aVar2) {
                    break;
                }
            }
            this.f8617i.g(obj);
            return;
        }
    }

    public final String toString() {
        return "SafeContinuation for " + this.f8617i;
    }
}
