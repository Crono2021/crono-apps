package n0;

import android.view.WindowInsets;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class p1 extends r1 {

    /* renamed from: c, reason: collision with root package name */
    public final WindowInsets.Builder f7192c;

    public p1(a2 a2Var) {
        super(a2Var);
        WindowInsets f9 = a2Var.f();
        this.f7192c = f9 != null ? a0.a.h(f9) : a0.a.g();
    }

    @Override // n0.r1
    public a2 b() {
        WindowInsets build;
        a();
        build = this.f7192c.build();
        a2 g9 = a2.g(null, build);
        g9.f7139a.o(this.f7195b);
        return g9;
    }

    @Override // n0.r1
    public void d(f0.c cVar) {
        this.f7192c.setMandatorySystemGestureInsets(cVar.d());
    }

    @Override // n0.r1
    public void e(f0.c cVar) {
        this.f7192c.setStableInsets(cVar.d());
    }

    @Override // n0.r1
    public void f(f0.c cVar) {
        this.f7192c.setSystemGestureInsets(cVar.d());
    }

    @Override // n0.r1
    public void g(f0.c cVar) {
        this.f7192c.setSystemWindowInsets(cVar.d());
    }

    @Override // n0.r1
    public void h(f0.c cVar) {
        this.f7192c.setTappableElementInsets(cVar.d());
    }

    public p1() {
        this.f7192c = a0.a.g();
    }
}
