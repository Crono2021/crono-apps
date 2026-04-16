package i3;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class m implements h {

    /* renamed from: l, reason: collision with root package name */
    public static final float[] f4541l = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    public final b0 f4542a;

    /* renamed from: b, reason: collision with root package name */
    public final g1.p f4543b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean[] f4544c = new boolean[4];

    /* renamed from: d, reason: collision with root package name */
    public final k f4545d;

    /* renamed from: e, reason: collision with root package name */
    public final u f4546e;

    /* renamed from: f, reason: collision with root package name */
    public l f4547f;

    /* renamed from: g, reason: collision with root package name */
    public long f4548g;
    public String h;

    /* renamed from: i, reason: collision with root package name */
    public d2.d0 f4549i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f4550j;

    /* renamed from: k, reason: collision with root package name */
    public long f4551k;

    public m(b0 b0Var) {
        this.f4542a = b0Var;
        k kVar = new k();
        kVar.f4533e = new byte[128];
        this.f4545d = kVar;
        this.f4551k = -9223372036854775807L;
        this.f4546e = new u(178);
        this.f4543b = new g1.p();
    }

    @Override // i3.h
    public final void a() {
        h1.g.a(this.f4544c);
        k kVar = this.f4545d;
        kVar.f4529a = false;
        kVar.f4531c = 0;
        kVar.f4530b = 0;
        l lVar = this.f4547f;
        if (lVar != null) {
            lVar.f4535b = false;
            lVar.f4536c = false;
            lVar.f4537d = false;
            lVar.f4538e = -1;
        }
        u uVar = this.f4546e;
        if (uVar != null) {
            uVar.e();
        }
        this.f4548g = 0L;
        this.f4551k = -9223372036854775807L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x013d  */
    @Override // i3.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(g1.p r26) {
        /*
            Method dump skipped, instructions count: 667
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.m.c(g1.p):void");
    }

    @Override // i3.h
    public final void d(int i9, long j5) {
        this.f4551k = j5;
    }

    @Override // i3.h
    public final void f(d2.o oVar, e0 e0Var) {
        e0Var.a();
        e0Var.b();
        this.h = e0Var.f4484e;
        e0Var.b();
        d2.d0 l4 = oVar.l(e0Var.f4483d, 2);
        this.f4549i = l4;
        this.f4547f = new l(l4);
        this.f4542a.b(oVar, e0Var);
    }

    @Override // i3.h
    public final void e() {
    }
}
