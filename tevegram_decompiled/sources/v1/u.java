package v1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class u extends d1 {

    /* renamed from: l, reason: collision with root package name */
    public final boolean f9404l;

    /* renamed from: m, reason: collision with root package name */
    public final d1.x0 f9405m;

    /* renamed from: n, reason: collision with root package name */
    public final d1.w0 f9406n;

    /* renamed from: o, reason: collision with root package name */
    public s f9407o;

    /* renamed from: p, reason: collision with root package name */
    public r f9408p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f9409q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f9410r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f9411s;

    public u(a aVar, boolean z8) {
        super(aVar);
        this.f9404l = z8 && aVar.h();
        this.f9405m = new d1.x0();
        this.f9406n = new d1.w0();
        d1.y0 f9 = aVar.f();
        if (f9 == null) {
            this.f9407o = new s(new t(aVar.g()), d1.x0.f2592r, s.f9398e);
        } else {
            this.f9407o = new s(f9, null, null);
            this.f9411s = true;
        }
    }

    @Override // v1.d1
    public final void A() {
        if (this.f9404l) {
            return;
        }
        this.f9409q = true;
        z();
    }

    @Override // v1.a
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public final r a(z zVar, z1.d dVar, long j5) {
        r rVar = new r(zVar, dVar, j5);
        g1.a.k(rVar.f9387l == null);
        rVar.f9387l = this.f9266k;
        if (!this.f9410r) {
            this.f9408p = rVar;
            if (!this.f9409q) {
                this.f9409q = true;
                z();
            }
            return rVar;
        }
        Object obj = zVar.f9447a;
        if (this.f9407o.f9400d != null && obj.equals(s.f9398e)) {
            obj = this.f9407o.f9400d;
        }
        rVar.e(zVar.a(obj));
        return rVar;
    }

    public final void C(long j5) {
        r rVar = this.f9408p;
        int b9 = this.f9407o.b(rVar.f9384i.f9447a);
        if (b9 == -1) {
            return;
        }
        s sVar = this.f9407o;
        d1.w0 w0Var = this.f9406n;
        sVar.f(b9, w0Var, false);
        long j9 = w0Var.f2587d;
        if (j9 != -9223372036854775807L && j5 >= j9) {
            j5 = Math.max(0L, j9 - 1);
        }
        rVar.f9390o = j5;
    }

    @Override // v1.a
    public final void m(x xVar) {
        r rVar = (r) xVar;
        if (rVar.f9388m != null) {
            a aVar = rVar.f9387l;
            aVar.getClass();
            aVar.m(rVar.f9388m);
        }
        if (xVar == this.f9408p) {
            this.f9408p = null;
        }
    }

    @Override // v1.j, v1.a
    public final void o() {
        this.f9410r = false;
        this.f9409q = false;
        super.o();
    }

    @Override // v1.d1, v1.a
    public final void r(d1.e0 e0Var) {
        if (this.f9411s) {
            s sVar = this.f9407o;
            this.f9407o = new s(new l1.z0(this.f9407o.f9357b, e0Var), sVar.f9399c, sVar.f9400d);
        } else {
            this.f9407o = new s(new t(e0Var), d1.x0.f2592r, s.f9398e);
        }
        this.f9266k.r(e0Var);
    }

    @Override // v1.d1
    public final z x(z zVar) {
        Object obj = zVar.f9447a;
        Object obj2 = this.f9407o.f9400d;
        if (obj2 != null && obj2.equals(obj)) {
            obj = s.f9398e;
        }
        return zVar.a(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00c9  */
    @Override // v1.d1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y(d1.y0 r12) {
        /*
            Method dump skipped, instructions count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.u.y(d1.y0):void");
    }

    @Override // v1.j, v1.a
    public final void i() {
    }
}
