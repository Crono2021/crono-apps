package v1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class o0 implements y {

    /* renamed from: a, reason: collision with root package name */
    public final i1.g f9358a;

    /* renamed from: b, reason: collision with root package name */
    public final a3.i f9359b;

    /* renamed from: c, reason: collision with root package name */
    public final d.a f9360c;

    /* renamed from: d, reason: collision with root package name */
    public z1.g f9361d;

    /* renamed from: e, reason: collision with root package name */
    public final int f9362e;

    public o0(i1.g gVar, d2.k kVar) {
        a3.i iVar = new a3.i(kVar, 23);
        d.a aVar = new d.a(1);
        z1.g gVar2 = new z1.g();
        this.f9358a = gVar;
        this.f9359b = iVar;
        this.f9360c = aVar;
        this.f9361d = gVar2;
        this.f9362e = 1048576;
    }

    @Override // v1.y
    public final y b(z1.g gVar) {
        g1.a.j(gVar, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
        this.f9361d = gVar;
        return this;
    }

    @Override // v1.y
    public final a d(d1.e0 e0Var) {
        e0Var.f2409b.getClass();
        return new p0(e0Var, this.f9358a, this.f9359b, this.f9360c.b(e0Var), this.f9361d, this.f9362e);
    }

    @Override // v1.y
    public final y a() {
        return this;
    }

    @Override // v1.y
    public final y c(z2.c cVar) {
        return this;
    }
}
