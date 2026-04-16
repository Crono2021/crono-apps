package v1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class d1 extends j {

    /* renamed from: k, reason: collision with root package name */
    public final a f9266k;

    public d1(a aVar) {
        this.f9266k = aVar;
    }

    public void A() {
        z();
    }

    @Override // v1.a
    public final d1.y0 f() {
        return this.f9266k.f();
    }

    @Override // v1.a
    public final d1.e0 g() {
        return this.f9266k.g();
    }

    @Override // v1.a
    public final boolean h() {
        return this.f9266k.h();
    }

    @Override // v1.a
    public final void k(z1.f fVar) {
        this.f9307j = fVar;
        this.f9306i = g1.w.l(null);
        A();
    }

    @Override // v1.a
    public void r(d1.e0 e0Var) {
        this.f9266k.r(e0Var);
    }

    @Override // v1.j
    public final z s(Object obj, z zVar) {
        return x(zVar);
    }

    @Override // v1.j
    public final long t(long j5, Object obj) {
        return j5;
    }

    @Override // v1.j
    public final int u(int i9, Object obj) {
        return i9;
    }

    @Override // v1.j
    public final void v(Object obj, a aVar, d1.y0 y0Var) {
        y(y0Var);
    }

    public abstract void y(d1.y0 y0Var);

    public final void z() {
        w(null, this.f9266k);
    }

    public z x(z zVar) {
        return zVar;
    }
}
