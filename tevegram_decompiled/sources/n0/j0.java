package n0;

import android.view.View;
import android.view.WindowInsets;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class j0 {
    public static a2 a(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        a2 g9 = a2.g(null, rootWindowInsets);
        x1 x1Var = g9.f7139a;
        x1Var.p(g9);
        x1Var.d(view.getRootView());
        return g9;
    }

    public static int b(View view) {
        return view.getScrollIndicators();
    }

    public static void c(View view, int i9) {
        view.setScrollIndicators(i9);
    }

    public static void d(View view, int i9, int i10) {
        view.setScrollIndicators(i9, i10);
    }
}
