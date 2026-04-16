package i3;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class r implements h {

    /* renamed from: a, reason: collision with root package name */
    public final b0 f4611a;

    /* renamed from: b, reason: collision with root package name */
    public String f4612b;

    /* renamed from: c, reason: collision with root package name */
    public d2.d0 f4613c;

    /* renamed from: d, reason: collision with root package name */
    public q f4614d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f4615e;

    /* renamed from: l, reason: collision with root package name */
    public long f4621l;

    /* renamed from: f, reason: collision with root package name */
    public final boolean[] f4616f = new boolean[3];

    /* renamed from: g, reason: collision with root package name */
    public final u f4617g = new u(32);
    public final u h = new u(33);

    /* renamed from: i, reason: collision with root package name */
    public final u f4618i = new u(34);

    /* renamed from: j, reason: collision with root package name */
    public final u f4619j = new u(39);

    /* renamed from: k, reason: collision with root package name */
    public final u f4620k = new u(40);

    /* renamed from: m, reason: collision with root package name */
    public long f4622m = -9223372036854775807L;

    /* renamed from: n, reason: collision with root package name */
    public final g1.p f4623n = new g1.p();

    public r(b0 b0Var) {
        this.f4611a = b0Var;
    }

    @Override // i3.h
    public final void a() {
        this.f4621l = 0L;
        this.f4622m = -9223372036854775807L;
        h1.g.a(this.f4616f);
        this.f4617g.e();
        this.h.e();
        this.f4618i.e();
        this.f4619j.e();
        this.f4620k.e();
        q qVar = this.f4614d;
        if (qVar != null) {
            qVar.f4604f = false;
            qVar.f4605g = false;
            qVar.h = false;
            qVar.f4606i = false;
            qVar.f4607j = false;
        }
    }

    public final void b(int i9, int i10, byte[] bArr) {
        q qVar = this.f4614d;
        if (qVar.f4604f) {
            int i11 = qVar.f4602d;
            int i12 = (i9 + 2) - i11;
            if (i12 < i10) {
                qVar.f4605g = (bArr[i12] & 128) != 0;
                qVar.f4604f = false;
            } else {
                qVar.f4602d = (i10 - i9) + i11;
            }
        }
        if (!this.f4615e) {
            this.f4617g.a(i9, i10, bArr);
            this.h.a(i9, i10, bArr);
            this.f4618i.a(i9, i10, bArr);
        }
        this.f4619j.a(i9, i10, bArr);
        this.f4620k.a(i9, i10, bArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0258 A[SYNTHETIC] */
    @Override // i3.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(g1.p r41) {
        /*
            Method dump skipped, instructions count: 621
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.r.c(g1.p):void");
    }

    @Override // i3.h
    public final void d(int i9, long j5) {
        this.f4622m = j5;
    }

    @Override // i3.h
    public final void f(d2.o oVar, e0 e0Var) {
        e0Var.a();
        e0Var.b();
        this.f4612b = e0Var.f4484e;
        e0Var.b();
        d2.d0 l4 = oVar.l(e0Var.f4483d, 2);
        this.f4613c = l4;
        this.f4614d = new q(l4);
        this.f4611a.b(oVar, e0Var);
    }

    @Override // i3.h
    public final void e() {
    }
}
