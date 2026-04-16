package i3;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4410a;

    /* renamed from: b, reason: collision with root package name */
    public final a3.g f4411b;

    /* renamed from: c, reason: collision with root package name */
    public final g1.p f4412c;

    /* renamed from: d, reason: collision with root package name */
    public final String f4413d;

    /* renamed from: e, reason: collision with root package name */
    public final int f4414e;

    /* renamed from: f, reason: collision with root package name */
    public String f4415f;

    /* renamed from: g, reason: collision with root package name */
    public d2.d0 f4416g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public int f4417i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f4418j;

    /* renamed from: k, reason: collision with root package name */
    public long f4419k;

    /* renamed from: l, reason: collision with root package name */
    public d1.s f4420l;

    /* renamed from: m, reason: collision with root package name */
    public int f4421m;

    /* renamed from: n, reason: collision with root package name */
    public long f4422n;

    public b(String str, int i9, int i10) {
        this.f4410a = i10;
        switch (i10) {
            case 1:
                a3.g gVar = new a3.g(new byte[16], 16);
                this.f4411b = gVar;
                this.f4412c = new g1.p(gVar.f104b);
                this.h = 0;
                this.f4417i = 0;
                this.f4418j = false;
                this.f4422n = -9223372036854775807L;
                this.f4413d = str;
                this.f4414e = i9;
                break;
            default:
                a3.g gVar2 = new a3.g(new byte[128], 128);
                this.f4411b = gVar2;
                this.f4412c = new g1.p(gVar2.f104b);
                this.h = 0;
                this.f4422n = -9223372036854775807L;
                this.f4413d = str;
                this.f4414e = i9;
                break;
        }
    }

    @Override // i3.h
    public final void a() {
        switch (this.f4410a) {
            case 0:
                this.h = 0;
                this.f4417i = 0;
                this.f4418j = false;
                this.f4422n = -9223372036854775807L;
                break;
            default:
                this.h = 0;
                this.f4417i = 0;
                this.f4418j = false;
                this.f4422n = -9223372036854775807L;
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:171:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x03b4  */
    @Override // i3.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(g1.p r23) {
        /*
            Method dump skipped, instructions count: 1262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.b.c(g1.p):void");
    }

    @Override // i3.h
    public final void d(int i9, long j5) {
        switch (this.f4410a) {
            case 0:
                this.f4422n = j5;
                break;
            default:
                this.f4422n = j5;
                break;
        }
    }

    @Override // i3.h
    public final void e() {
        int i9 = this.f4410a;
    }

    @Override // i3.h
    public final void f(d2.o oVar, e0 e0Var) {
        switch (this.f4410a) {
            case 0:
                e0Var.a();
                e0Var.b();
                this.f4415f = e0Var.f4484e;
                e0Var.b();
                this.f4416g = oVar.l(e0Var.f4483d, 1);
                break;
            default:
                e0Var.a();
                e0Var.b();
                this.f4415f = e0Var.f4484e;
                e0Var.b();
                this.f4416g = oVar.l(e0Var.f4483d, 1);
                break;
        }
    }

    private final void b() {
    }

    private final void g() {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b() {
        this(null, 0, 0);
        this.f4410a = 0;
    }
}
