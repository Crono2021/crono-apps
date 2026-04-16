package m1;

import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import b6.b1;
import b6.g0;
import d1.d1;
import d1.e0;
import d1.f1;
import d1.h0;
import d1.h1;
import d1.j0;
import d1.n0;
import d1.o0;
import d1.p0;
import d1.q0;
import d1.r0;
import d1.s0;
import d1.t0;
import d1.w0;
import d1.x0;
import d1.y0;
import java.io.IOException;
import java.util.List;
import l1.b0;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import v1.d0;
import v1.z;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class q implements r0, d0, o1.e {

    /* renamed from: i, reason: collision with root package name */
    public final g1.r f6551i;

    /* renamed from: j, reason: collision with root package name */
    public final w0 f6552j;

    /* renamed from: k, reason: collision with root package name */
    public final x0 f6553k;

    /* renamed from: l, reason: collision with root package name */
    public final m6.p f6554l;

    /* renamed from: m, reason: collision with root package name */
    public final SparseArray f6555m;

    /* renamed from: n, reason: collision with root package name */
    public g1.m f6556n;

    /* renamed from: o, reason: collision with root package name */
    public t0 f6557o;

    /* renamed from: p, reason: collision with root package name */
    public g1.t f6558p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f6559q;

    public q(g1.r rVar) {
        rVar.getClass();
        this.f6551i = rVar;
        int i9 = g1.w.f3713a;
        Looper myLooper = Looper.myLooper();
        this.f6556n = new g1.m(myLooper == null ? Looper.getMainLooper() : myLooper, rVar, new h7.o(14));
        w0 w0Var = new w0();
        this.f6552j = w0Var;
        this.f6553k = new x0();
        this.f6554l = new m6.p(w0Var);
        this.f6555m = new SparseArray();
    }

    @Override // d1.r0
    public final void A(f1.c cVar) {
        a G = G();
        L(G, 27, new h7.o(G, cVar, 18));
    }

    @Override // d1.r0
    public final void B(h1 h1Var) {
        a K = K();
        L(K, 25, new h7.e(K, 9, h1Var));
    }

    @Override // d1.r0
    public final void C(e0 e0Var, int i9) {
        a G = G();
        L(G, 1, new d(G, e0Var, i9));
    }

    @Override // d1.r0
    public final void E(y0 y0Var, int i9) {
        t0 t0Var = this.f6557o;
        t0Var.getClass();
        m6.p pVar = this.f6554l;
        pVar.f6679d = m6.p.e(t0Var, (g0) pVar.f6677b, (z) pVar.f6680e, (w0) pVar.f6676a);
        pVar.j(t0Var.U());
        a G = G();
        L(G, 0, new d(G, i9, 0));
    }

    @Override // d1.r0
    public final void F(boolean z8) {
        a G = G();
        L(G, 7, new f(G, z8, 0));
    }

    public final a G() {
        return I((z) this.f6554l.f6679d);
    }

    public final a H(y0 y0Var, int i9, z zVar) {
        z zVar2 = y0Var.p() ? null : zVar;
        this.f6551i.getClass();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean z8 = y0Var.equals(this.f6557o.U()) && i9 == this.f6557o.I();
        long j5 = 0;
        if (zVar2 == null || !zVar2.b()) {
            if (z8) {
                j5 = this.f6557o.j();
            } else if (!y0Var.p()) {
                j5 = g1.w.W(y0Var.m(i9, this.f6553k, 0L).f2605m);
            }
        } else if (z8 && this.f6557o.H() == zVar2.f9448b && this.f6557o.N() == zVar2.f9449c) {
            j5 = this.f6557o.getCurrentPosition();
        }
        return new a(elapsedRealtime, y0Var, i9, zVar2, j5, this.f6557o.U(), this.f6557o.I(), (z) this.f6554l.f6679d, this.f6557o.getCurrentPosition(), this.f6557o.k());
    }

    public final a I(z zVar) {
        this.f6557o.getClass();
        y0 y0Var = zVar == null ? null : (y0) ((b1) this.f6554l.f6678c).get(zVar);
        if (zVar != null && y0Var != null) {
            return H(y0Var, y0Var.g(zVar.f9447a, this.f6552j).f2586c, zVar);
        }
        int I = this.f6557o.I();
        y0 U = this.f6557o.U();
        if (I >= U.o()) {
            U = y0.f2610a;
        }
        return H(U, I, null);
    }

    public final a J(int i9, z zVar) {
        this.f6557o.getClass();
        if (zVar != null) {
            return ((y0) ((b1) this.f6554l.f6678c).get(zVar)) != null ? I(zVar) : H(y0.f2610a, i9, zVar);
        }
        y0 U = this.f6557o.U();
        if (i9 >= U.o()) {
            U = y0.f2610a;
        }
        return H(U, i9, null);
    }

    public final a K() {
        return I((z) this.f6554l.f6681f);
    }

    public final void L(a aVar, int i9, g1.j jVar) {
        this.f6555m.put(i9, aVar);
        this.f6556n.e(i9, jVar);
    }

    public final void M(b0 b0Var, Looper looper) {
        g1.a.k(this.f6557o == null || ((g0) this.f6554l.f6677b).isEmpty());
        b0Var.getClass();
        this.f6557o = b0Var;
        this.f6558p = this.f6551i.a(looper, null);
        g1.m mVar = this.f6556n;
        this.f6556n = new g1.m(mVar.f3685d, looper, mVar.f3682a, new h7.e(this, 4, b0Var), mVar.f3689i);
    }

    @Override // v1.d0
    public final void Q(int i9, z zVar, v1.q qVar, v1.v vVar) {
        a J = J(i9, zVar);
        L(J, IjkMediaCodecInfo.RANK_MAX, new h7.o(J, qVar, vVar, 21));
    }

    @Override // v1.d0
    public final void T(int i9, z zVar, v1.q qVar, v1.v vVar, IOException iOException, boolean z8) {
        a J = J(i9, zVar);
        L(J, 1003, new h7.i(J, qVar, vVar, iOException, z8));
    }

    @Override // v1.d0
    public final void V(int i9, z zVar, v1.q qVar, v1.v vVar) {
        a J = J(i9, zVar);
        L(J, 1001, new h7.o(J, qVar, vVar, 23));
    }

    @Override // d1.r0
    public final void a(int i9) {
        a G = G();
        L(G, 6, new d(G, i9, 2));
    }

    @Override // d1.r0
    public final void b(p0 p0Var) {
        a G = G();
        L(G, 13, new h7.o(G, p0Var, 26));
    }

    @Override // d1.r0
    public final void c(final s0 s0Var, final s0 s0Var2, final int i9) {
        if (i9 == 1) {
            this.f6559q = false;
        }
        t0 t0Var = this.f6557o;
        t0Var.getClass();
        m6.p pVar = this.f6554l;
        pVar.f6679d = m6.p.e(t0Var, (g0) pVar.f6677b, (z) pVar.f6680e, (w0) pVar.f6676a);
        final a G = G();
        L(G, 11, new g1.j() { // from class: m1.k
            @Override // g1.j
            public final void a(Object obj) {
                c cVar = (c) obj;
                cVar.getClass();
                cVar.m(i9, s0Var, s0Var2, G);
            }
        });
    }

    @Override // d1.r0
    public final void f(n0 n0Var) {
        z zVar;
        a G = (!(n0Var instanceof l1.l) || (zVar = ((l1.l) n0Var).f5937p) == null) ? G() : I(zVar);
        L(G, 10, new h7.e(G, 7, n0Var));
    }

    @Override // d1.r0
    public final void g(int i9) {
        a G = G();
        L(G, 8, new d(G, i9, 5));
    }

    @Override // d1.r0
    public final void h(boolean z8) {
        a G = G();
        L(G, 3, new f(G, z8, 3));
    }

    @Override // d1.r0
    public final void j(h0 h0Var) {
        a G = G();
        L(G, 14, new h7.o(G, h0Var, 24));
    }

    @Override // d1.r0
    public final void k(boolean z8) {
        a K = K();
        L(K, 23, new f(K, z8, 2));
    }

    @Override // d1.r0
    public final void l(List list) {
        a G = G();
        L(G, 27, new h7.o(G, list, 13));
    }

    @Override // v1.d0
    public final void m(int i9, z zVar, v1.v vVar) {
        a J = J(i9, zVar);
        L(J, 1004, new m(J, vVar, 0));
    }

    @Override // d1.r0
    public final void n(int i9, boolean z8) {
        a G = G();
        L(G, -1, new h7.o(G, z8, i9));
    }

    @Override // v1.d0
    public final void o(int i9, z zVar, v1.v vVar) {
        a J = J(i9, zVar);
        L(J, 1005, new m(J, vVar, 1));
    }

    @Override // d1.r0
    public final void p(final int i9, final boolean z8) {
        final a G = G();
        L(G, 5, new g1.j() { // from class: m1.h
            @Override // g1.j
            public final void a(Object obj) {
                ((c) obj).I(a.this, z8, i9);
            }
        });
    }

    @Override // d1.r0
    public final void q(final float f9) {
        final a K = K();
        L(K, 22, new g1.j() { // from class: m1.e
            @Override // g1.j
            public final void a(Object obj) {
                ((c) obj).v(a.this, f9);
            }
        });
    }

    @Override // d1.r0
    public final void r(f1 f1Var) {
        a G = G();
        L(G, 2, new h7.e(G, 6, f1Var));
    }

    @Override // d1.r0
    public final void s(int i9) {
        a G = G();
        L(G, 4, new d(G, i9, 4));
    }

    @Override // d1.r0
    public final void t(o0 o0Var) {
        a G = G();
        L(G, 12, new h7.e(G, 3, o0Var));
    }

    @Override // d1.r0
    public final void u(n0 n0Var) {
        z zVar;
        a G = (!(n0Var instanceof l1.l) || (zVar = ((l1.l) n0Var).f5937p) == null) ? G() : I(zVar);
        L(G, 10, new h7.o(G, n0Var, 12));
    }

    @Override // d1.r0
    public final void v(d1 d1Var) {
        a G = G();
        L(G, 19, new h7.o(G, d1Var, 25));
    }

    @Override // d1.r0
    public final void w(boolean z8) {
        a G = G();
        L(G, 9, new f(G, z8, 1));
    }

    @Override // d1.r0
    public final void x(final int i9, final int i10) {
        final a K = K();
        L(K, 24, new g1.j() { // from class: m1.l
            @Override // g1.j
            public final void a(Object obj) {
                ((c) obj).r(a.this, i9, i10);
            }
        });
    }

    @Override // v1.d0
    public final void y(int i9, z zVar, v1.q qVar, v1.v vVar) {
        a J = J(i9, zVar);
        L(J, 1002, new h7.o(J, qVar, vVar, 22));
    }

    @Override // d1.r0
    public final void z(j0 j0Var) {
        a G = G();
        L(G, 28, new h7.e(G, 5, j0Var));
    }

    @Override // d1.r0
    public final void i() {
    }

    @Override // d1.r0
    public final void D(q0 q0Var) {
    }

    @Override // d1.r0
    public final void d(boolean z8) {
    }

    @Override // d1.r0
    public final void e(int i9) {
    }
}
