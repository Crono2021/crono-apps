package l1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class e implements b1 {

    /* renamed from: j, reason: collision with root package name */
    public final int f5827j;

    /* renamed from: l, reason: collision with root package name */
    public c1 f5829l;

    /* renamed from: m, reason: collision with root package name */
    public int f5830m;

    /* renamed from: n, reason: collision with root package name */
    public m1.x f5831n;

    /* renamed from: o, reason: collision with root package name */
    public g1.r f5832o;

    /* renamed from: p, reason: collision with root package name */
    public int f5833p;

    /* renamed from: q, reason: collision with root package name */
    public v1.v0 f5834q;

    /* renamed from: r, reason: collision with root package name */
    public d1.s[] f5835r;

    /* renamed from: s, reason: collision with root package name */
    public long f5836s;

    /* renamed from: t, reason: collision with root package name */
    public long f5837t;

    /* renamed from: v, reason: collision with root package name */
    public boolean f5839v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f5840w;

    /* renamed from: y, reason: collision with root package name */
    public y1.o f5842y;

    /* renamed from: i, reason: collision with root package name */
    public final Object f5826i = new Object();

    /* renamed from: k, reason: collision with root package name */
    public final a5.d f5828k = new a5.d(28);

    /* renamed from: u, reason: collision with root package name */
    public long f5838u = Long.MIN_VALUE;

    /* renamed from: x, reason: collision with root package name */
    public d1.y0 f5841x = d1.y0.f2610a;

    public e(int i9) {
        this.f5827j = i9;
    }

    public int A() {
        return 0;
    }

    @Override // l1.b1
    public boolean a() {
        return m();
    }

    @Override // l1.b1
    public k0 i() {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final l1.l l(java.lang.Throwable r11, d1.s r12, boolean r13, int r14) {
        /*
            r10 = this;
            r0 = 4
            if (r12 == 0) goto L1a
            boolean r1 = r10.f5840w
            if (r1 != 0) goto L1a
            r1 = 1
            r10.f5840w = r1
            r1 = 0
            int r2 = r10.z(r12)     // Catch: java.lang.Throwable -> L14 l1.l -> L18
            r2 = r2 & 7
            r10.f5840w = r1
            goto L1b
        L14:
            r0 = move-exception
            r10.f5840w = r1
            throw r0
        L18:
            r10.f5840w = r1
        L1a:
            r2 = 4
        L1b:
            java.lang.String r5 = r10.getName()
            int r6 = r10.f5830m
            l1.l r1 = new l1.l
            if (r12 != 0) goto L27
            r8 = 4
            goto L28
        L27:
            r8 = r2
        L28:
            r2 = 1
            r3 = r11
            r7 = r12
            r9 = r13
            r4 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.e.l(java.lang.Throwable, d1.s, boolean, int):l1.l");
    }

    public final boolean m() {
        return this.f5838u == Long.MIN_VALUE;
    }

    public abstract void n();

    public abstract void q(long j5, boolean z8);

    public abstract void v(d1.s[] sVarArr, long j5, long j9);

    public final int w(a5.d dVar, j1.e eVar, int i9) {
        v1.v0 v0Var = this.f5834q;
        v0Var.getClass();
        int r8 = v0Var.r(dVar, eVar, i9);
        if (r8 == -4) {
            if (eVar.c(4)) {
                this.f5838u = Long.MIN_VALUE;
                return this.f5839v ? -4 : -3;
            }
            long j5 = eVar.f5361o + this.f5836s;
            eVar.f5361o = j5;
            this.f5838u = Math.max(this.f5838u, j5);
            return r8;
        }
        if (r8 == -5) {
            d1.s sVar = (d1.s) dVar.f175k;
            sVar.getClass();
            long j9 = sVar.f2558q;
            if (j9 != Long.MAX_VALUE) {
                d1.r a9 = sVar.a();
                a9.f2532p = j9 + this.f5836s;
                dVar.f175k = new d1.s(a9);
            }
        }
        return r8;
    }

    public final void x(d1.s[] sVarArr, v1.v0 v0Var, long j5, long j9, v1.z zVar) {
        g1.a.k(!this.f5839v);
        this.f5834q = v0Var;
        if (this.f5838u == Long.MIN_VALUE) {
            this.f5838u = j5;
        }
        this.f5835r = sVarArr;
        this.f5836s = j9;
        v(sVarArr, j5, j9);
    }

    public final void y() {
        g1.a.k(this.f5833p == 0);
        this.f5828k.o0();
        s();
    }

    public abstract int z(d1.s sVar);

    @Override // l1.b1
    public /* synthetic */ void h() {
    }

    public void p() {
    }

    public void r() {
    }

    public void s() {
    }

    public void t() {
    }

    public void u() {
    }

    @Override // l1.x0
    public void g(int i9, Object obj) {
    }

    @Override // l1.b1
    public /* synthetic */ void k(float f9, float f10) {
    }

    public void o(boolean z8, boolean z9) {
    }
}
