package v1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d implements x, w {

    /* renamed from: i, reason: collision with root package name */
    public final x f9259i;

    /* renamed from: j, reason: collision with root package name */
    public w f9260j;

    /* renamed from: k, reason: collision with root package name */
    public c[] f9261k = new c[0];

    /* renamed from: l, reason: collision with root package name */
    public long f9262l;

    /* renamed from: m, reason: collision with root package name */
    public long f9263m;

    /* renamed from: n, reason: collision with root package name */
    public long f9264n;

    /* renamed from: o, reason: collision with root package name */
    public f f9265o;

    public d(x xVar, boolean z8, long j5, long j9) {
        this.f9259i = xVar;
        this.f9262l = z8 ? j5 : -9223372036854775807L;
        this.f9263m = j5;
        this.f9264n = j9;
    }

    @Override // v1.x0
    public final boolean a() {
        return this.f9259i.a();
    }

    @Override // v1.x0
    public final boolean b(l1.j0 j0Var) {
        return this.f9259i.b(j0Var);
    }

    @Override // v1.w
    public final void c(x xVar) {
        if (this.f9265o != null) {
            return;
        }
        w wVar = this.f9260j;
        wVar.getClass();
        wVar.c(this);
    }

    @Override // v1.w0
    public final void d(x0 x0Var) {
        w wVar = this.f9260j;
        wVar.getClass();
        wVar.d(this);
    }

    public final boolean e() {
        return this.f9262l != -9223372036854775807L;
    }

    @Override // v1.x0
    public final long f() {
        long f9 = this.f9259i.f();
        if (f9 != Long.MIN_VALUE) {
            long j5 = this.f9264n;
            if (j5 == Long.MIN_VALUE || f9 < j5) {
                return f9;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // v1.x
    public final long g() {
        if (e()) {
            long j5 = this.f9262l;
            this.f9262l = -9223372036854775807L;
            long g9 = g();
            return g9 != -9223372036854775807L ? g9 : j5;
        }
        long g10 = this.f9259i.g();
        if (g10 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        g1.a.k(g10 >= this.f9263m);
        long j9 = this.f9264n;
        g1.a.k(j9 == Long.MIN_VALUE || g10 <= j9);
        return g10;
    }

    @Override // v1.x
    public final void h(w wVar, long j5) {
        this.f9260j = wVar;
        this.f9259i.h(this, j5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x011c, code lost:
    
        if (r10 > r2) goto L93;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:58:0x00e2. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:70:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0126  */
    @Override // v1.x
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long i(y1.q[] r15, boolean[] r16, v1.v0[] r17, boolean[] r18, long r19) {
        /*
            Method dump skipped, instructions count: 398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.d.i(y1.q[], boolean[], v1.v0[], boolean[], long):long");
    }

    @Override // v1.x
    public final c1 j() {
        return this.f9259i.j();
    }

    @Override // v1.x
    public final long k(long j5, l1.d1 d1Var) {
        long j9 = this.f9263m;
        if (j5 == j9) {
            return j9;
        }
        long i9 = g1.w.i(d1Var.f5824a, 0L, j5 - j9);
        long j10 = d1Var.f5825b;
        long j11 = this.f9264n;
        long i10 = g1.w.i(j10, 0L, j11 == Long.MIN_VALUE ? Long.MAX_VALUE : j11 - j5);
        if (i9 != d1Var.f5824a || i10 != d1Var.f5825b) {
            d1Var = new l1.d1(i9, i10);
        }
        return this.f9259i.k(j5, d1Var);
    }

    @Override // v1.x0
    public final long m() {
        long m9 = this.f9259i.m();
        if (m9 != Long.MIN_VALUE) {
            long j5 = this.f9264n;
            if (j5 == Long.MIN_VALUE || m9 < j5) {
                return m9;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // v1.x
    public final void n() {
        f fVar = this.f9265o;
        if (fVar != null) {
            throw fVar;
        }
        this.f9259i.n();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0031, code lost:
    
        if (r0 > r7) goto L17;
     */
    @Override // v1.x
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long r(long r7) {
        /*
            r6 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6.f9262l = r0
            v1.c[] r0 = r6.f9261k
            int r1 = r0.length
            r2 = 0
            r3 = 0
        Lc:
            if (r3 >= r1) goto L17
            r4 = r0[r3]
            if (r4 == 0) goto L14
            r4.f9251j = r2
        L14:
            int r3 = r3 + 1
            goto Lc
        L17:
            v1.x r0 = r6.f9259i
            long r0 = r0.r(r7)
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 == 0) goto L33
            long r7 = r6.f9263m
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 < 0) goto L34
            long r7 = r6.f9264n
            r3 = -9223372036854775808
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 == 0) goto L33
            int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r3 > 0) goto L34
        L33:
            r2 = 1
        L34:
            g1.a.k(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.d.r(long):long");
    }

    @Override // v1.x
    public final void s(long j5) {
        this.f9259i.s(j5);
    }

    @Override // v1.x0
    public final void u(long j5) {
        this.f9259i.u(j5);
    }
}
