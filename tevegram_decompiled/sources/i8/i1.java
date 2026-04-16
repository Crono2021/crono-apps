package i8;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i1 implements r7.e, r7.f {

    /* renamed from: i, reason: collision with root package name */
    public static final i1 f5276i = new i1();

    @Override // r7.g
    public final r7.g a(r7.g gVar) {
        gVar.getClass();
        return gVar == r7.h.f8615i ? this : (r7.g) gVar.d(this, new i7.a(2));
    }

    @Override // r7.g
    public final Object d(Object obj, a8.p pVar) {
        return pVar.h(obj, this);
    }

    @Override // r7.g
    public final r7.g e(r7.f fVar) {
        fVar.getClass();
        return b8.i.a(this, fVar) ? r7.h.f8615i : this;
    }

    @Override // r7.g
    public final r7.e h(r7.f fVar) {
        fVar.getClass();
        if (b8.i.a(this, fVar)) {
            return this;
        }
        return null;
    }

    @Override // r7.e
    public final r7.f getKey() {
        return this;
    }
}
