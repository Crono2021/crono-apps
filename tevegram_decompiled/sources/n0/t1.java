package n0;

import android.view.WindowInsets;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class t1 extends s1 {

    /* renamed from: m, reason: collision with root package name */
    public f0.c f7216m;

    public t1(a2 a2Var, WindowInsets windowInsets) {
        super(a2Var, windowInsets);
        this.f7216m = null;
    }

    @Override // n0.x1
    public a2 b() {
        return a2.g(null, this.f7204c.consumeStableInsets());
    }

    @Override // n0.x1
    public a2 c() {
        return a2.g(null, this.f7204c.consumeSystemWindowInsets());
    }

    @Override // n0.x1
    public final f0.c h() {
        if (this.f7216m == null) {
            WindowInsets windowInsets = this.f7204c;
            this.f7216m = f0.c.b(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
        }
        return this.f7216m;
    }

    @Override // n0.x1
    public boolean m() {
        return this.f7204c.isConsumed();
    }

    @Override // n0.x1
    public void q(f0.c cVar) {
        this.f7216m = cVar;
    }
}
