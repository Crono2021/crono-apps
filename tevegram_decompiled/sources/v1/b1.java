package v1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b1 implements x, w {

    /* renamed from: i, reason: collision with root package name */
    public final x f9247i;

    /* renamed from: j, reason: collision with root package name */
    public final long f9248j;

    /* renamed from: k, reason: collision with root package name */
    public w f9249k;

    public b1(x xVar, long j5) {
        this.f9247i = xVar;
        this.f9248j = j5;
    }

    @Override // v1.x0
    public final boolean a() {
        return this.f9247i.a();
    }

    @Override // v1.x0
    public final boolean b(l1.j0 j0Var) {
        l1.i0 i0Var = new l1.i0();
        long j5 = j0Var.f5929a;
        i0Var.f5921b = j0Var.f5930b;
        i0Var.f5922c = j0Var.f5931c;
        i0Var.f5920a = j5 - this.f9248j;
        return this.f9247i.b(new l1.j0(i0Var));
    }

    @Override // v1.w
    public final void c(x xVar) {
        w wVar = this.f9249k;
        wVar.getClass();
        wVar.c(this);
    }

    @Override // v1.w0
    public final void d(x0 x0Var) {
        w wVar = this.f9249k;
        wVar.getClass();
        wVar.d(this);
    }

    @Override // v1.x0
    public final long f() {
        long f9 = this.f9247i.f();
        if (f9 == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return f9 + this.f9248j;
    }

    @Override // v1.x
    public final long g() {
        long g9 = this.f9247i.g();
        if (g9 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return g9 + this.f9248j;
    }

    @Override // v1.x
    public final void h(w wVar, long j5) {
        this.f9249k = wVar;
        this.f9247i.h(this, j5 - this.f9248j);
    }

    @Override // v1.x
    public final long i(y1.q[] qVarArr, boolean[] zArr, v0[] v0VarArr, boolean[] zArr2, long j5) {
        v0[] v0VarArr2 = new v0[v0VarArr.length];
        int i9 = 0;
        while (true) {
            v0 v0Var = null;
            if (i9 >= v0VarArr.length) {
                break;
            }
            a1 a1Var = (a1) v0VarArr[i9];
            if (a1Var != null) {
                v0Var = a1Var.f9240i;
            }
            v0VarArr2[i9] = v0Var;
            i9++;
        }
        x xVar = this.f9247i;
        long j9 = this.f9248j;
        long i10 = xVar.i(qVarArr, zArr, v0VarArr2, zArr2, j5 - j9);
        for (int i11 = 0; i11 < v0VarArr.length; i11++) {
            v0 v0Var2 = v0VarArr2[i11];
            if (v0Var2 == null) {
                v0VarArr[i11] = null;
            } else {
                v0 v0Var3 = v0VarArr[i11];
                if (v0Var3 == null || ((a1) v0Var3).f9240i != v0Var2) {
                    v0VarArr[i11] = new a1(v0Var2, j9);
                }
            }
        }
        return i10 + j9;
    }

    @Override // v1.x
    public final c1 j() {
        return this.f9247i.j();
    }

    @Override // v1.x
    public final long k(long j5, l1.d1 d1Var) {
        long j9 = this.f9248j;
        return this.f9247i.k(j5 - j9, d1Var) + j9;
    }

    @Override // v1.x0
    public final long m() {
        long m9 = this.f9247i.m();
        if (m9 == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return m9 + this.f9248j;
    }

    @Override // v1.x
    public final void n() {
        this.f9247i.n();
    }

    @Override // v1.x
    public final long r(long j5) {
        long j9 = this.f9248j;
        return this.f9247i.r(j5 - j9) + j9;
    }

    @Override // v1.x
    public final void s(long j5) {
        this.f9247i.s(j5 - this.f9248j);
    }

    @Override // v1.x0
    public final void u(long j5) {
        this.f9247i.u(j5 - this.f9248j);
    }
}
