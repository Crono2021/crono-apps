package v1;

import android.net.Uri;
import android.os.Handler;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class m0 implements x, d2.o, z1.k, z1.n, t0 {
    public static final Map U;
    public static final d1.s V;
    public u0[] A;
    public l0[] B;
    public boolean C;
    public boolean D;
    public boolean E;
    public a0.l F;
    public d2.y G;
    public long H;
    public boolean I;
    public int J;
    public boolean K;
    public boolean L;
    public int M;
    public boolean N;
    public long O;
    public long P;
    public boolean Q;
    public int R;
    public boolean S;
    public boolean T;

    /* renamed from: i, reason: collision with root package name */
    public final Uri f9332i;

    /* renamed from: j, reason: collision with root package name */
    public final i1.h f9333j;

    /* renamed from: k, reason: collision with root package name */
    public final o1.g f9334k;

    /* renamed from: l, reason: collision with root package name */
    public final z1.g f9335l;

    /* renamed from: m, reason: collision with root package name */
    public final o1.d f9336m;

    /* renamed from: n, reason: collision with root package name */
    public final o1.d f9337n;

    /* renamed from: o, reason: collision with root package name */
    public final p0 f9338o;

    /* renamed from: p, reason: collision with root package name */
    public final z1.d f9339p;

    /* renamed from: q, reason: collision with root package name */
    public final long f9340q;

    /* renamed from: r, reason: collision with root package name */
    public final z1.p f9341r = new z1.p("ProgressiveMediaPeriod");

    /* renamed from: s, reason: collision with root package name */
    public final androidx.fragment.app.g f9342s;

    /* renamed from: t, reason: collision with root package name */
    public final d2.f0 f9343t;

    /* renamed from: u, reason: collision with root package name */
    public final h0 f9344u;

    /* renamed from: v, reason: collision with root package name */
    public final h0 f9345v;

    /* renamed from: w, reason: collision with root package name */
    public final Handler f9346w;

    /* renamed from: x, reason: collision with root package name */
    public final boolean f9347x;

    /* renamed from: y, reason: collision with root package name */
    public w f9348y;

    /* renamed from: z, reason: collision with root package name */
    public p2.b f9349z;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("Icy-MetaData", "1");
        U = Collections.unmodifiableMap(hashMap);
        d1.r rVar = new d1.r();
        rVar.f2518a = "icy";
        rVar.f2528l = d1.l0.k("application/x-icy");
        V = new d1.s(rVar);
    }

    public m0(Uri uri, i1.h hVar, androidx.fragment.app.g gVar, o1.g gVar2, o1.d dVar, z1.g gVar3, o1.d dVar2, p0 p0Var, z1.d dVar3, int i9, long j5) {
        this.f9332i = uri;
        this.f9333j = hVar;
        this.f9334k = gVar2;
        this.f9337n = dVar;
        this.f9335l = gVar3;
        this.f9336m = dVar2;
        this.f9338o = p0Var;
        this.f9339p = dVar3;
        this.f9340q = i9;
        this.f9342s = gVar;
        this.H = j5;
        this.f9347x = j5 != -9223372036854775807L;
        this.f9343t = new d2.f0();
        this.f9344u = new h0(this, 1);
        this.f9345v = new h0(this, 2);
        this.f9346w = g1.w.l(null);
        this.B = new l0[0];
        this.A = new u0[0];
        this.P = -9223372036854775807L;
        this.J = 1;
    }

    public final void A(int i9) {
        v();
        a0.l lVar = this.F;
        boolean[] zArr = (boolean[]) lVar.f33l;
        if (zArr[i9]) {
            return;
        }
        d1.s sVar = ((c1) lVar.f30i).a(i9).f2619d[0];
        this.f9336m.a(new v(1, d1.l0.g(sVar.f2554m), sVar, 0, null, g1.w.W(this.O), -9223372036854775807L));
        zArr[i9] = true;
    }

    public final void B(int i9) {
        v();
        boolean[] zArr = (boolean[]) this.F.f31j;
        if (this.Q && zArr[i9] && !this.A[i9].u(false)) {
            this.P = 0L;
            this.Q = false;
            this.L = true;
            this.O = 0L;
            this.R = 0;
            for (u0 u0Var : this.A) {
                u0Var.z(false);
            }
            w wVar = this.f9348y;
            wVar.getClass();
            wVar.d(this);
        }
    }

    public final u0 C(l0 l0Var) {
        int length = this.A.length;
        for (int i9 = 0; i9 < length; i9++) {
            if (l0Var.equals(this.B[i9])) {
                return this.A[i9];
            }
        }
        o1.g gVar = this.f9334k;
        gVar.getClass();
        u0 u0Var = new u0(this.f9339p, gVar, this.f9337n);
        u0Var.f9417f = this;
        int i10 = length + 1;
        l0[] l0VarArr = (l0[]) Arrays.copyOf(this.B, i10);
        l0VarArr[length] = l0Var;
        int i11 = g1.w.f3713a;
        this.B = l0VarArr;
        u0[] u0VarArr = (u0[]) Arrays.copyOf(this.A, i10);
        u0VarArr[length] = u0Var;
        this.A = u0VarArr;
        return u0Var;
    }

    public final void D() {
        j0 j0Var = new j0(this, this.f9332i, this.f9333j, this.f9342s, this, this.f9343t);
        if (this.D) {
            g1.a.k(y());
            long j5 = this.H;
            if (j5 != -9223372036854775807L && this.P > j5) {
                this.S = true;
                this.P = -9223372036854775807L;
                return;
            }
            d2.y yVar = this.G;
            yVar.getClass();
            long j9 = yVar.i(this.P).f2753a.f2757b;
            long j10 = this.P;
            j0Var.f9314g.f2583a = j9;
            j0Var.f9316j = j10;
            j0Var.f9315i = true;
            j0Var.f9319m = false;
            for (u0 u0Var : this.A) {
                u0Var.f9430t = this.P;
            }
            this.P = -9223372036854775807L;
        }
        this.R = w();
        this.f9341r.d(j0Var, this, this.f9335l.getMinimumLoadableRetryCount(this.J));
        this.f9336m.h(new q(j0Var.f9317k), 1, -1, null, 0, null, j0Var.f9316j, this.H);
    }

    public final boolean E() {
        return this.L || y();
    }

    @Override // v1.x0
    public final boolean a() {
        boolean z8;
        if (!this.f9341r.b()) {
            return false;
        }
        d2.f0 f0Var = this.f9343t;
        synchronized (f0Var) {
            z8 = f0Var.f2689a;
        }
        return z8;
    }

    @Override // v1.x0
    public final boolean b(l1.j0 j0Var) {
        if (this.S) {
            return false;
        }
        z1.p pVar = this.f9341r;
        if (pVar.f10589c != null || this.Q) {
            return false;
        }
        if (this.D && this.M == 0) {
            return false;
        }
        boolean b9 = this.f9343t.b();
        if (pVar.b()) {
            return b9;
        }
        D();
        return true;
    }

    @Override // d2.o
    public final void c() {
        this.C = true;
        this.f9346w.post(this.f9344u);
    }

    @Override // z1.n
    public final void d() {
        for (u0 u0Var : this.A) {
            u0Var.z(true);
            i7.x xVar = u0Var.h;
            if (xVar != null) {
                xVar.K(u0Var.f9416e);
                u0Var.h = null;
                u0Var.f9418g = null;
            }
        }
        androidx.fragment.app.g gVar = this.f9342s;
        d2.m mVar = (d2.m) gVar.f729k;
        if (mVar != null) {
            mVar.release();
            gVar.f729k = null;
        }
        gVar.f730l = null;
    }

    @Override // z1.k
    public final void e(z1.m mVar, long j5, long j9) {
        d2.y yVar;
        j0 j0Var = (j0) mVar;
        if (this.H == -9223372036854775807L && (yVar = this.G) != null) {
            boolean e9 = yVar.e();
            long x6 = x(true);
            long j10 = x6 == Long.MIN_VALUE ? 0L : x6 + 10000;
            this.H = j10;
            this.f9338o.t(j10, e9, this.I);
        }
        i1.a0 a0Var = j0Var.f9310c;
        long j11 = j0Var.f9308a;
        Uri uri = a0Var.f4289k;
        q qVar = new q(j9);
        this.f9335l.onLoadTaskConcluded(j11);
        this.f9336m.d(qVar, 1, -1, null, 0, null, j0Var.f9316j, this.H);
        this.S = true;
        w wVar = this.f9348y;
        wVar.getClass();
        wVar.d(this);
    }

    @Override // v1.x0
    public final long f() {
        return m();
    }

    @Override // v1.x
    public final long g() {
        if (!this.L) {
            return -9223372036854775807L;
        }
        if (!this.S && w() <= this.R) {
            return -9223372036854775807L;
        }
        this.L = false;
        return this.O;
    }

    @Override // v1.x
    public final void h(w wVar, long j5) {
        this.f9348y = wVar;
        this.f9343t.b();
        D();
    }

    @Override // v1.x
    public final long i(y1.q[] qVarArr, boolean[] zArr, v0[] v0VarArr, boolean[] zArr2, long j5) {
        y1.q qVar;
        v();
        a0.l lVar = this.F;
        c1 c1Var = (c1) lVar.f30i;
        boolean[] zArr3 = (boolean[]) lVar.f32k;
        int i9 = this.M;
        int i10 = 0;
        for (int i11 = 0; i11 < qVarArr.length; i11++) {
            v0 v0Var = v0VarArr[i11];
            if (v0Var != null && (qVarArr[i11] == null || !zArr[i11])) {
                int i12 = ((k0) v0Var).f9323i;
                g1.a.k(zArr3[i12]);
                this.M--;
                zArr3[i12] = false;
                v0VarArr[i11] = null;
            }
        }
        boolean z8 = !this.f9347x && (!this.K ? j5 == 0 : i9 != 0);
        for (int i13 = 0; i13 < qVarArr.length; i13++) {
            if (v0VarArr[i13] == null && (qVar = qVarArr[i13]) != null) {
                g1.a.k(qVar.length() == 1);
                g1.a.k(qVar.e(0) == 0);
                int indexOf = c1Var.f9257b.indexOf(qVar.j());
                if (indexOf < 0) {
                    indexOf = -1;
                }
                g1.a.k(!zArr3[indexOf]);
                this.M++;
                zArr3[indexOf] = true;
                v0VarArr[i13] = new k0(this, indexOf);
                zArr2[i13] = true;
                if (!z8) {
                    u0 u0Var = this.A[indexOf];
                    z8 = (u0Var.q() == 0 || u0Var.C(j5, true)) ? false : true;
                }
            }
        }
        if (this.M == 0) {
            this.Q = false;
            this.L = false;
            z1.p pVar = this.f9341r;
            boolean b9 = pVar.b();
            u0[] u0VarArr = this.A;
            if (b9) {
                int length = u0VarArr.length;
                while (i10 < length) {
                    u0VarArr[i10].j();
                    i10++;
                }
                pVar.a();
            } else {
                for (u0 u0Var2 : u0VarArr) {
                    u0Var2.z(false);
                }
            }
        } else if (z8) {
            j5 = r(j5);
            while (i10 < v0VarArr.length) {
                if (v0VarArr[i10] != null) {
                    zArr2[i10] = true;
                }
                i10++;
            }
        }
        this.K = true;
        return j5;
    }

    @Override // v1.x
    public final c1 j() {
        v();
        return (c1) this.F.f30i;
    }

    @Override // v1.x
    public final long k(long j5, l1.d1 d1Var) {
        v();
        if (!this.G.e()) {
            return 0L;
        }
        d2.x i9 = this.G.i(j5);
        return d1Var.a(j5, i9.f2753a.f2756a, i9.f2754b.f2756a);
    }

    @Override // d2.o
    public final d2.d0 l(int i9, int i10) {
        return C(new l0(i9, false));
    }

    @Override // v1.x0
    public final long m() {
        long j5;
        boolean z8;
        v();
        if (this.S || this.M == 0) {
            return Long.MIN_VALUE;
        }
        if (y()) {
            return this.P;
        }
        if (this.E) {
            int length = this.A.length;
            j5 = Long.MAX_VALUE;
            for (int i9 = 0; i9 < length; i9++) {
                a0.l lVar = this.F;
                if (((boolean[]) lVar.f31j)[i9] && ((boolean[]) lVar.f32k)[i9]) {
                    u0 u0Var = this.A[i9];
                    synchronized (u0Var) {
                        z8 = u0Var.f9433w;
                    }
                    if (!z8) {
                        j5 = Math.min(j5, this.A[i9].n());
                    }
                }
            }
        } else {
            j5 = Long.MAX_VALUE;
        }
        if (j5 == Long.MAX_VALUE) {
            j5 = x(false);
        }
        return j5 == Long.MIN_VALUE ? this.O : j5;
    }

    @Override // v1.x
    public final void n() {
        int minimumLoadableRetryCount = this.f9335l.getMinimumLoadableRetryCount(this.J);
        z1.p pVar = this.f9341r;
        IOException iOException = pVar.f10589c;
        if (iOException != null) {
            throw iOException;
        }
        z1.l lVar = pVar.f10588b;
        if (lVar != null) {
            if (minimumLoadableRetryCount == Integer.MIN_VALUE) {
                minimumLoadableRetryCount = lVar.f10574i;
            }
            IOException iOException2 = lVar.f10578m;
            if (iOException2 != null && lVar.f10579n > minimumLoadableRetryCount) {
                throw iOException2;
            }
        }
        if (this.S && !this.D) {
            throw d1.m0.a(null, "Loading finished before preparation is complete.");
        }
    }

    @Override // v1.t0
    public final void o() {
        this.f9346w.post(this.f9344u);
    }

    @Override // z1.k
    public final j3.f p(z1.m mVar, long j5, long j9, IOException iOException, int i9) {
        j3.f fVar;
        d2.y yVar;
        j0 j0Var = (j0) mVar;
        Uri uri = j0Var.f9310c.f4289k;
        q qVar = new q(j9);
        g1.w.W(j0Var.f9316j);
        g1.w.W(this.H);
        z1.j jVar = new z1.j(iOException, i9);
        z1.g gVar = this.f9335l;
        long retryDelayMsFor = gVar.getRetryDelayMsFor(jVar);
        if (retryDelayMsFor == -9223372036854775807L) {
            fVar = z1.p.f10586f;
        } else {
            int w8 = w();
            int i10 = w8 > this.R ? 1 : 0;
            if (this.N || !((yVar = this.G) == null || yVar.k() == -9223372036854775807L)) {
                this.R = w8;
            } else if (!this.D || E()) {
                this.L = this.D;
                this.O = 0L;
                this.R = 0;
                for (u0 u0Var : this.A) {
                    u0Var.z(false);
                }
                j0Var.f9314g.f2583a = 0L;
                j0Var.f9316j = 0L;
                j0Var.f9315i = true;
                j0Var.f9319m = false;
            } else {
                this.Q = true;
                fVar = z1.p.f10585e;
            }
            fVar = new j3.f(i10, retryDelayMsFor);
        }
        int i11 = fVar.f5420a;
        boolean z8 = i11 == 0 || i11 == 1;
        j3.f fVar2 = fVar;
        this.f9336m.f(qVar, 1, -1, null, 0, null, j0Var.f9316j, this.H, iOException, !z8);
        if (!z8) {
            gVar.onLoadTaskConcluded(j0Var.f9308a);
        }
        return fVar2;
    }

    @Override // z1.k
    public final void q(z1.m mVar, long j5, long j9, boolean z8) {
        j0 j0Var = (j0) mVar;
        i1.a0 a0Var = j0Var.f9310c;
        long j10 = j0Var.f9308a;
        Uri uri = a0Var.f4289k;
        q qVar = new q(j9);
        this.f9335l.onLoadTaskConcluded(j10);
        this.f9336m.b(qVar, 1, -1, null, 0, null, j0Var.f9316j, this.H);
        if (z8) {
            return;
        }
        for (u0 u0Var : this.A) {
            u0Var.z(false);
        }
        if (this.M > 0) {
            w wVar = this.f9348y;
            wVar.getClass();
            wVar.d(this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0050, code lost:
    
        if (r0 != false) goto L38;
     */
    @Override // v1.x
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long r(long r7) {
        /*
            r6 = this;
            r6.v()
            a0.l r0 = r6.F
            java.lang.Object r0 = r0.f31j
            boolean[] r0 = (boolean[]) r0
            d2.y r1 = r6.G
            boolean r1 = r1.e()
            if (r1 == 0) goto L12
            goto L14
        L12:
            r7 = 0
        L14:
            r1 = 0
            r6.L = r1
            r6.O = r7
            boolean r2 = r6.y()
            if (r2 == 0) goto L22
            r6.P = r7
            return r7
        L22:
            int r2 = r6.J
            r3 = 7
            if (r2 == r3) goto L53
            v1.u0[] r2 = r6.A
            int r2 = r2.length
            r3 = 0
        L2b:
            if (r3 >= r2) goto L4f
            v1.u0[] r4 = r6.A
            r4 = r4[r3]
            boolean r5 = r6.f9347x
            if (r5 == 0) goto L3c
            int r5 = r4.f9427q
            boolean r4 = r4.B(r5)
            goto L40
        L3c:
            boolean r4 = r4.C(r7, r1)
        L40:
            if (r4 != 0) goto L4c
            boolean r4 = r0[r3]
            if (r4 != 0) goto L4a
            boolean r4 = r6.E
            if (r4 != 0) goto L4c
        L4a:
            r0 = 0
            goto L50
        L4c:
            int r3 = r3 + 1
            goto L2b
        L4f:
            r0 = 1
        L50:
            if (r0 == 0) goto L53
            goto L83
        L53:
            r6.Q = r1
            r6.P = r7
            r6.S = r1
            z1.p r0 = r6.f9341r
            boolean r2 = r0.b()
            if (r2 == 0) goto L72
            v1.u0[] r2 = r6.A
            int r3 = r2.length
        L64:
            if (r1 >= r3) goto L6e
            r4 = r2[r1]
            r4.j()
            int r1 = r1 + 1
            goto L64
        L6e:
            r0.a()
            return r7
        L72:
            r2 = 0
            r0.f10589c = r2
            v1.u0[] r0 = r6.A
            int r2 = r0.length
            r3 = 0
        L79:
            if (r3 >= r2) goto L83
            r4 = r0[r3]
            r4.z(r1)
            int r3 = r3 + 1
            goto L79
        L83:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.m0.r(long):long");
    }

    @Override // v1.x
    public final void s(long j5) {
        if (this.f9347x) {
            return;
        }
        v();
        if (y()) {
            return;
        }
        boolean[] zArr = (boolean[]) this.F.f32k;
        int length = this.A.length;
        for (int i9 = 0; i9 < length; i9++) {
            this.A[i9].i(j5, zArr[i9]);
        }
    }

    @Override // d2.o
    public final void t(d2.y yVar) {
        this.f9346w.post(new b2.f0(this, 17, yVar));
    }

    public final void v() {
        g1.a.k(this.D);
        this.F.getClass();
        this.G.getClass();
    }

    public final int w() {
        int i9 = 0;
        for (u0 u0Var : this.A) {
            i9 += u0Var.f9427q + u0Var.f9426p;
        }
        return i9;
    }

    public final long x(boolean z8) {
        int i9;
        long j5 = Long.MIN_VALUE;
        while (i9 < this.A.length) {
            if (!z8) {
                a0.l lVar = this.F;
                lVar.getClass();
                i9 = ((boolean[]) lVar.f32k)[i9] ? 0 : i9 + 1;
            }
            j5 = Math.max(j5, this.A[i9].n());
        }
        return j5;
    }

    public final boolean y() {
        return this.P != -9223372036854775807L;
    }

    public final void z() {
        if (this.T || this.D || !this.C || this.G == null) {
            return;
        }
        for (u0 u0Var : this.A) {
            if (u0Var.t() == null) {
                return;
            }
        }
        this.f9343t.a();
        int length = this.A.length;
        d1.z0[] z0VarArr = new d1.z0[length];
        boolean[] zArr = new boolean[length];
        for (int i9 = 0; i9 < length; i9++) {
            d1.s t8 = this.A[i9].t();
            t8.getClass();
            String str = t8.f2554m;
            boolean h = d1.l0.h(str);
            boolean z8 = h || d1.l0.j(str);
            zArr[i9] = z8;
            this.E = z8 | this.E;
            p2.b bVar = this.f9349z;
            if (bVar != null) {
                int i10 = bVar.f8238i;
                if (h || this.B[i9].f9328b) {
                    d1.j0 j0Var = t8.f2552k;
                    d1.j0 j0Var2 = j0Var == null ? new d1.j0(bVar) : j0Var.d(bVar);
                    d1.r a9 = t8.a();
                    a9.f2526j = j0Var2;
                    t8 = new d1.s(a9);
                }
                if (h && t8.f2549g == -1 && t8.h == -1 && i10 != -1) {
                    d1.r a10 = t8.a();
                    a10.f2524g = i10;
                    t8 = new d1.s(a10);
                }
            }
            int j5 = this.f9334k.j(t8);
            d1.r a11 = t8.a();
            a11.H = j5;
            z0VarArr[i9] = new d1.z0(Integer.toString(i9), new d1.s(a11));
        }
        c1 c1Var = new c1(z0VarArr);
        a0.l lVar = new a0.l();
        lVar.f30i = c1Var;
        lVar.f31j = zArr;
        int i11 = c1Var.f9256a;
        lVar.f32k = new boolean[i11];
        lVar.f33l = new boolean[i11];
        this.F = lVar;
        this.D = true;
        w wVar = this.f9348y;
        wVar.getClass();
        wVar.c(this);
    }

    @Override // v1.x0
    public final void u(long j5) {
    }
}
