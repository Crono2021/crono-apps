package v1;

import android.net.Uri;
import android.os.Looper;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class p0 extends a {
    public final i1.g h;

    /* renamed from: i, reason: collision with root package name */
    public final a3.i f9368i;

    /* renamed from: j, reason: collision with root package name */
    public final o1.g f9369j;

    /* renamed from: k, reason: collision with root package name */
    public final z1.g f9370k;

    /* renamed from: l, reason: collision with root package name */
    public final int f9371l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f9372m = true;

    /* renamed from: n, reason: collision with root package name */
    public long f9373n = -9223372036854775807L;

    /* renamed from: o, reason: collision with root package name */
    public boolean f9374o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f9375p;

    /* renamed from: q, reason: collision with root package name */
    public z1.f f9376q;

    /* renamed from: r, reason: collision with root package name */
    public d1.e0 f9377r;

    public p0(d1.e0 e0Var, i1.g gVar, a3.i iVar, o1.g gVar2, z1.g gVar3, int i9) {
        this.f9377r = e0Var;
        this.h = gVar;
        this.f9368i = iVar;
        this.f9369j = gVar2;
        this.f9370k = gVar3;
        this.f9371l = i9;
    }

    @Override // v1.a
    public final x a(z zVar, z1.d dVar, long j5) {
        i1.h a9 = this.h.a();
        z1.f fVar = this.f9376q;
        if (fVar != null) {
            a9.k(fVar);
        }
        d1.b0 b0Var = g().f2409b;
        b0Var.getClass();
        Uri uri = b0Var.f2361a;
        g1.a.l(this.f9239g);
        int i9 = 0;
        return new m0(uri, a9, new androidx.fragment.app.g((d2.k) this.f9368i.f118j), this.f9369j, new o1.d(this.f9236d.f7571c, i9, zVar), this.f9370k, new o1.d(this.f9235c.f7571c, i9, zVar), this, dVar, this.f9371l, g1.w.M(b0Var.f2365e));
    }

    @Override // v1.a
    public final synchronized d1.e0 g() {
        return this.f9377r;
    }

    @Override // v1.a
    public final void k(z1.f fVar) {
        this.f9376q = fVar;
        Looper myLooper = Looper.myLooper();
        myLooper.getClass();
        m1.x xVar = this.f9239g;
        g1.a.l(xVar);
        o1.g gVar = this.f9369j;
        gVar.d(myLooper, xVar);
        gVar.b();
        s();
    }

    @Override // v1.a
    public final void m(x xVar) {
        m0 m0Var = (m0) xVar;
        if (m0Var.D) {
            for (u0 u0Var : m0Var.A) {
                u0Var.j();
                i7.x xVar2 = u0Var.h;
                if (xVar2 != null) {
                    xVar2.K(u0Var.f9416e);
                    u0Var.h = null;
                    u0Var.f9418g = null;
                }
            }
        }
        m0Var.f9341r.c(m0Var);
        m0Var.f9346w.removeCallbacksAndMessages(null);
        m0Var.f9348y = null;
        m0Var.T = true;
    }

    @Override // v1.a
    public final void o() {
        this.f9369j.release();
    }

    @Override // v1.a
    public final synchronized void r(d1.e0 e0Var) {
        this.f9377r = e0Var;
    }

    public final void s() {
        long j5 = this.f9373n;
        boolean z8 = this.f9374o;
        boolean z9 = this.f9375p;
        d1.e0 g9 = g();
        d1.y0 z0Var = new z0(-9223372036854775807L, -9223372036854775807L, j5, j5, 0L, 0L, z8, false, false, null, g9, z9 ? g9.f2410c : null);
        if (this.f9372m) {
            z0Var = new n0(z0Var);
        }
        l(z0Var);
    }

    public final void t(long j5, boolean z8, boolean z9) {
        if (j5 == -9223372036854775807L) {
            j5 = this.f9373n;
        }
        if (!this.f9372m && this.f9373n == j5 && this.f9374o == z8 && this.f9375p == z9) {
            return;
        }
        this.f9373n = j5;
        this.f9374o = z8;
        this.f9375p = z9;
        this.f9372m = false;
        s();
    }

    @Override // v1.a
    public final void i() {
    }
}
