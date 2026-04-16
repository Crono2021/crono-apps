package n0;

import android.view.ViewGroup;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class l {
    public static int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getLayoutDirection();
    }

    public static int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getMarginEnd();
    }

    public static int c(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getMarginStart();
    }

    public static boolean d(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.isMarginRelative();
    }

    public static void e(ViewGroup.MarginLayoutParams marginLayoutParams, int i9) {
        marginLayoutParams.resolveLayoutDirection(i9);
    }

    public static void f(ViewGroup.MarginLayoutParams marginLayoutParams, int i9) {
        marginLayoutParams.setLayoutDirection(i9);
    }

    public static void g(ViewGroup.MarginLayoutParams marginLayoutParams, int i9) {
        marginLayoutParams.setMarginEnd(i9);
    }

    public static void h(ViewGroup.MarginLayoutParams marginLayoutParams, int i9) {
        marginLayoutParams.setMarginStart(i9);
    }
}
