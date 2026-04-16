package t7;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class c extends a {

    /* renamed from: j, reason: collision with root package name */
    public final r7.g f8983j;

    /* renamed from: k, reason: collision with root package name */
    public transient r7.c f8984k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(r7.c cVar) {
        super(cVar);
        r7.g f9 = cVar != null ? cVar.f() : null;
        this.f8983j = f9;
    }

    @Override // r7.c
    public final r7.g f() {
        r7.g gVar = this.f8983j;
        gVar.getClass();
        return gVar;
    }

    @Override // t7.a
    public final void l() {
        r7.c cVar = this.f8984k;
        if (cVar != null && cVar != this) {
            r7.g gVar = this.f8983j;
            gVar.getClass();
            r7.e h = gVar.h(r7.d.f8614i);
            h.getClass();
            n8.h hVar = (n8.h) cVar;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = n8.h.f7505p;
            while (atomicReferenceFieldUpdater.get(hVar) == n8.a.f7495d) {
            }
            Object obj = atomicReferenceFieldUpdater.get(hVar);
            i8.f fVar = obj instanceof i8.f ? (i8.f) obj : null;
            if (fVar != null) {
                fVar.o();
            }
        }
        this.f8984k = b.f8982i;
    }
}
