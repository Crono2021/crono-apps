package l1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class z0 extends v1.o {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6078c = 0;

    /* renamed from: d, reason: collision with root package name */
    public final Object f6079d;

    public z0(d1.y0 y0Var) {
        super(y0Var);
        this.f6079d = new d1.x0();
    }

    @Override // v1.o, d1.y0
    public d1.w0 f(int i9, d1.w0 w0Var, boolean z8) {
        switch (this.f6078c) {
            case 0:
                d1.y0 y0Var = this.f9357b;
                d1.w0 f9 = y0Var.f(i9, w0Var, z8);
                if (y0Var.m(f9.f2586c, (d1.x0) this.f6079d, 0L).a()) {
                    f9.h(w0Var.f2584a, w0Var.f2585b, w0Var.f2586c, w0Var.f2587d, w0Var.f2588e, d1.c.f2367c, true);
                } else {
                    f9.f2589f = true;
                }
                return f9;
            default:
                return super.f(i9, w0Var, z8);
        }
    }

    @Override // v1.o, d1.y0
    public d1.x0 m(int i9, d1.x0 x0Var, long j5) {
        switch (this.f6078c) {
            case 1:
                super.m(i9, x0Var, j5);
                d1.e0 e0Var = (d1.e0) this.f6079d;
                x0Var.f2596c = e0Var;
                d1.b0 b0Var = e0Var.f2409b;
                x0Var.getClass();
                return x0Var;
            default:
                return super.m(i9, x0Var, j5);
        }
    }

    public z0(d1.y0 y0Var, d1.e0 e0Var) {
        super(y0Var);
        this.f6079d = e0Var;
    }
}
