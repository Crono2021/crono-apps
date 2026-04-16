package d2;

import d1.l0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a0 implements m {

    /* renamed from: a, reason: collision with root package name */
    public final int f2624a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2625b;

    /* renamed from: c, reason: collision with root package name */
    public final String f2626c;

    /* renamed from: d, reason: collision with root package name */
    public int f2627d;

    /* renamed from: e, reason: collision with root package name */
    public int f2628e;

    /* renamed from: f, reason: collision with root package name */
    public o f2629f;

    /* renamed from: g, reason: collision with root package name */
    public d0 f2630g;

    public a0(int i9, int i10, String str) {
        this.f2624a = i9;
        this.f2625b = i10;
        this.f2626c = str;
    }

    @Override // d2.m
    public final void c(long j5, long j9) {
        if (j5 == 0 || this.f2628e == 1) {
            this.f2628e = 1;
            this.f2627d = 0;
        }
    }

    @Override // d2.m
    public final void d(o oVar) {
        this.f2629f = oVar;
        d0 l4 = oVar.l(1024, 4);
        this.f2630g = l4;
        d1.r rVar = new d1.r();
        rVar.f2528l = l0.k(this.f2626c);
        androidx.activity.g.v(rVar, l4);
        this.f2629f.c();
        this.f2629f.t(new b0());
        this.f2628e = 1;
    }

    @Override // d2.m
    public final boolean g(n nVar) {
        int i9 = this.f2625b;
        int i10 = this.f2624a;
        g1.a.k((i10 == -1 || i9 == -1) ? false : true);
        g1.p pVar = new g1.p(i9);
        ((j) nVar).n(pVar.f3699a, 0, i9, false);
        return pVar.z() == i10;
    }

    @Override // d2.m
    public final int h(n nVar, d1.w wVar) {
        int i9 = this.f2628e;
        if (i9 != 1) {
            if (i9 == 2) {
                return -1;
            }
            androidx.fragment.app.a.l();
            return 0;
        }
        d0 d0Var = this.f2630g;
        d0Var.getClass();
        int a9 = d0Var.a(nVar, 1024, true);
        if (a9 != -1) {
            this.f2627d += a9;
            return 0;
        }
        this.f2628e = 2;
        this.f2630g.d(0L, 1, this.f2627d, 0, null);
        this.f2627d = 0;
        return 0;
    }

    @Override // d2.m
    public final m a() {
        return this;
    }

    @Override // d2.m
    public final void release() {
    }
}
