package i8;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h extends r0 {

    /* renamed from: m, reason: collision with root package name */
    public final f f5271m;

    public h(f fVar) {
        this.f5271m = fVar;
    }

    @Override // a8.l
    public final /* bridge */ /* synthetic */ Object a(Object obj) {
        p((Throwable) obj);
        return n7.g.f7490c;
    }

    @Override // i8.t0
    public final void p(Throwable th) {
        y0 o8 = o();
        f fVar = this.f5271m;
        Throwable q4 = fVar.q(o8);
        if (fVar.w()) {
            r7.c cVar = fVar.f5260l;
            cVar.getClass();
            n8.h hVar = (n8.h) cVar;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = n8.h.f7505p;
            loop0: while (true) {
                Object obj = atomicReferenceFieldUpdater.get(hVar);
                a6.d dVar = n8.a.f7495d;
                if (!b8.i.a(obj, dVar)) {
                    if (!(obj instanceof Throwable)) {
                        while (!atomicReferenceFieldUpdater.compareAndSet(hVar, obj, null)) {
                            if (atomicReferenceFieldUpdater.get(hVar) != obj) {
                                break;
                            }
                        }
                        break loop0;
                    }
                    return;
                }
                while (!atomicReferenceFieldUpdater.compareAndSet(hVar, dVar, q4)) {
                    if (atomicReferenceFieldUpdater.get(hVar) != dVar) {
                        break;
                    }
                }
                return;
            }
        }
        fVar.n(q4);
        if (fVar.w()) {
            return;
        }
        fVar.o();
    }
}
