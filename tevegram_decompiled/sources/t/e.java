package t;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e extends com.bumptech.glide.d {

    /* renamed from: f, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f8901f;

    /* renamed from: g, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f8902g;
    public final AtomicReferenceFieldUpdater h;

    /* renamed from: i, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f8903i;

    /* renamed from: j, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f8904j;

    public e(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        this.f8901f = atomicReferenceFieldUpdater;
        this.f8902g = atomicReferenceFieldUpdater2;
        this.h = atomicReferenceFieldUpdater3;
        this.f8903i = atomicReferenceFieldUpdater4;
        this.f8904j = atomicReferenceFieldUpdater5;
    }

    @Override // com.bumptech.glide.d
    public final void R(g gVar, g gVar2) {
        this.f8902g.lazySet(gVar, gVar2);
    }

    @Override // com.bumptech.glide.d
    public final void S(g gVar, Thread thread) {
        this.f8901f.lazySet(gVar, thread);
    }

    @Override // com.bumptech.glide.d
    public final boolean d(h hVar, d dVar, d dVar2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f8903i;
            if (atomicReferenceFieldUpdater.compareAndSet(hVar, dVar, dVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(hVar) == dVar);
        return false;
    }

    @Override // com.bumptech.glide.d
    public final boolean e(h hVar, Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f8904j;
            if (atomicReferenceFieldUpdater.compareAndSet(hVar, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(hVar) == obj);
        return false;
    }

    @Override // com.bumptech.glide.d
    public final boolean f(h hVar, g gVar, g gVar2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.h;
            if (atomicReferenceFieldUpdater.compareAndSet(hVar, gVar, gVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(hVar) == gVar);
        return false;
    }
}
