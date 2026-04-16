package r7;

import a8.p;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class a implements e {

    /* renamed from: i, reason: collision with root package name */
    public final f f8611i;

    public a(f fVar) {
        this.f8611i = fVar;
    }

    @Override // r7.g
    public final g a(g gVar) {
        gVar.getClass();
        return gVar == h.f8615i ? this : (g) gVar.d(this, new i7.a(2));
    }

    @Override // r7.g
    public final Object d(Object obj, p pVar) {
        return pVar.h(obj, this);
    }

    @Override // r7.g
    public g e(f fVar) {
        fVar.getClass();
        return b8.i.a(getKey(), fVar) ? h.f8615i : this;
    }

    @Override // r7.e
    public final f getKey() {
        return this.f8611i;
    }

    @Override // r7.g
    public e h(f fVar) {
        fVar.getClass();
        if (b8.i.a(getKey(), fVar)) {
            return this;
        }
        return null;
    }
}
