package n0;

import android.graphics.Insets;
import android.view.View;
import android.view.WindowInsets;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class w1 extends v1 {

    /* renamed from: q, reason: collision with root package name */
    public static final a2 f7226q;

    static {
        WindowInsets windowInsets;
        windowInsets = WindowInsets.CONSUMED;
        f7226q = a2.g(null, windowInsets);
    }

    public w1(a2 a2Var, WindowInsets windowInsets) {
        super(a2Var, windowInsets);
    }

    @Override // n0.s1, n0.x1
    public f0.c f(int i9) {
        Insets insets;
        insets = this.f7204c.getInsets(z1.a(i9));
        return f0.c.c(insets);
    }

    @Override // n0.s1, n0.x1
    public final void d(View view) {
    }
}
