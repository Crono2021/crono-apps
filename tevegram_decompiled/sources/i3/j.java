package i3;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j implements h {

    /* renamed from: q, reason: collision with root package name */
    public static final double[] f4512q = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* renamed from: a, reason: collision with root package name */
    public String f4513a;

    /* renamed from: b, reason: collision with root package name */
    public d2.d0 f4514b;

    /* renamed from: c, reason: collision with root package name */
    public final b0 f4515c;

    /* renamed from: d, reason: collision with root package name */
    public final g1.p f4516d;

    /* renamed from: e, reason: collision with root package name */
    public final u f4517e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean[] f4518f = new boolean[4];

    /* renamed from: g, reason: collision with root package name */
    public final i f4519g;
    public long h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f4520i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f4521j;

    /* renamed from: k, reason: collision with root package name */
    public long f4522k;

    /* renamed from: l, reason: collision with root package name */
    public long f4523l;

    /* renamed from: m, reason: collision with root package name */
    public long f4524m;

    /* renamed from: n, reason: collision with root package name */
    public long f4525n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f4526o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f4527p;

    public j(b0 b0Var) {
        this.f4515c = b0Var;
        i iVar = new i();
        iVar.f4511d = new byte[128];
        this.f4519g = iVar;
        if (b0Var != null) {
            this.f4517e = new u(178);
            this.f4516d = new g1.p();
        } else {
            this.f4517e = null;
            this.f4516d = null;
        }
        this.f4523l = -9223372036854775807L;
        this.f4525n = -9223372036854775807L;
    }

    @Override // i3.h
    public final void a() {
        h1.g.a(this.f4518f);
        i iVar = this.f4519g;
        iVar.f4508a = false;
        iVar.f4509b = 0;
        iVar.f4510c = 0;
        u uVar = this.f4517e;
        if (uVar != null) {
            uVar.e();
        }
        this.h = 0L;
        this.f4520i = false;
        this.f4523l = -9223372036854775807L;
        this.f4525n = -9223372036854775807L;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01de  */
    @Override // i3.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(g1.p r23) {
        /*
            Method dump skipped, instructions count: 514
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.j.c(g1.p):void");
    }

    @Override // i3.h
    public final void d(int i9, long j5) {
        this.f4523l = j5;
    }

    @Override // i3.h
    public final void f(d2.o oVar, e0 e0Var) {
        e0Var.a();
        e0Var.b();
        this.f4513a = e0Var.f4484e;
        e0Var.b();
        this.f4514b = oVar.l(e0Var.f4483d, 2);
        b0 b0Var = this.f4515c;
        if (b0Var != null) {
            b0Var.b(oVar, e0Var);
        }
    }

    @Override // i3.h
    public final void e() {
    }
}
