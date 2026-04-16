package v1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class r implements x, w {

    /* renamed from: i, reason: collision with root package name */
    public final z f9384i;

    /* renamed from: j, reason: collision with root package name */
    public final long f9385j;

    /* renamed from: k, reason: collision with root package name */
    public final z1.d f9386k;

    /* renamed from: l, reason: collision with root package name */
    public a f9387l;

    /* renamed from: m, reason: collision with root package name */
    public x f9388m;

    /* renamed from: n, reason: collision with root package name */
    public w f9389n;

    /* renamed from: o, reason: collision with root package name */
    public long f9390o = -9223372036854775807L;

    public r(z zVar, z1.d dVar, long j5) {
        this.f9384i = zVar;
        this.f9386k = dVar;
        this.f9385j = j5;
    }

    @Override // v1.x0
    public final boolean a() {
        x xVar = this.f9388m;
        return xVar != null && xVar.a();
    }

    @Override // v1.x0
    public final boolean b(l1.j0 j0Var) {
        x xVar = this.f9388m;
        return xVar != null && xVar.b(j0Var);
    }

    @Override // v1.w
    public final void c(x xVar) {
        w wVar = this.f9389n;
        int i9 = g1.w.f3713a;
        wVar.c(this);
    }

    @Override // v1.w0
    public final void d(x0 x0Var) {
        w wVar = this.f9389n;
        int i9 = g1.w.f3713a;
        wVar.d(this);
    }

    public final void e(z zVar) {
        long j5 = this.f9390o;
        if (j5 == -9223372036854775807L) {
            j5 = this.f9385j;
        }
        a aVar = this.f9387l;
        aVar.getClass();
        x a9 = aVar.a(zVar, this.f9386k, j5);
        this.f9388m = a9;
        if (this.f9389n != null) {
            a9.h(this, j5);
        }
    }

    @Override // v1.x0
    public final long f() {
        x xVar = this.f9388m;
        int i9 = g1.w.f3713a;
        return xVar.f();
    }

    @Override // v1.x
    public final long g() {
        x xVar = this.f9388m;
        int i9 = g1.w.f3713a;
        return xVar.g();
    }

    @Override // v1.x
    public final void h(w wVar, long j5) {
        this.f9389n = wVar;
        x xVar = this.f9388m;
        if (xVar != null) {
            long j9 = this.f9390o;
            if (j9 == -9223372036854775807L) {
                j9 = this.f9385j;
            }
            xVar.h(this, j9);
        }
    }

    @Override // v1.x
    public final long i(y1.q[] qVarArr, boolean[] zArr, v0[] v0VarArr, boolean[] zArr2, long j5) {
        long j9 = this.f9390o;
        long j10 = (j9 == -9223372036854775807L || j5 != this.f9385j) ? j5 : j9;
        this.f9390o = -9223372036854775807L;
        x xVar = this.f9388m;
        int i9 = g1.w.f3713a;
        return xVar.i(qVarArr, zArr, v0VarArr, zArr2, j10);
    }

    @Override // v1.x
    public final c1 j() {
        x xVar = this.f9388m;
        int i9 = g1.w.f3713a;
        return xVar.j();
    }

    @Override // v1.x
    public final long k(long j5, l1.d1 d1Var) {
        x xVar = this.f9388m;
        int i9 = g1.w.f3713a;
        return xVar.k(j5, d1Var);
    }

    @Override // v1.x0
    public final long m() {
        x xVar = this.f9388m;
        int i9 = g1.w.f3713a;
        return xVar.m();
    }

    @Override // v1.x
    public final void n() {
        x xVar = this.f9388m;
        if (xVar != null) {
            xVar.n();
            return;
        }
        a aVar = this.f9387l;
        if (aVar != null) {
            aVar.i();
        }
    }

    @Override // v1.x
    public final long r(long j5) {
        x xVar = this.f9388m;
        int i9 = g1.w.f3713a;
        return xVar.r(j5);
    }

    @Override // v1.x
    public final void s(long j5) {
        x xVar = this.f9388m;
        int i9 = g1.w.f3713a;
        xVar.s(j5);
    }

    @Override // v1.x0
    public final void u(long j5) {
        x xVar = this.f9388m;
        int i9 = g1.w.f3713a;
        xVar.u(j5);
    }
}
