package n0;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class i0 {
    public static void a(WindowInsets windowInsets, View view) {
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(2131362431);
        if (onApplyWindowInsetsListener != null) {
            onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
        }
    }

    public static a2 b(View view, a2 a2Var, Rect rect) {
        WindowInsets f9 = a2Var.f();
        if (f9 != null) {
            return a2.g(view, view.computeSystemWindowInsets(f9, rect));
        }
        rect.setEmpty();
        return a2Var;
    }

    public static boolean c(View view, float f9, float f10, boolean z8) {
        return view.dispatchNestedFling(f9, f10, z8);
    }

    public static boolean d(View view, float f9, float f10) {
        return view.dispatchNestedPreFling(f9, f10);
    }

    public static boolean e(View view, int i9, int i10, int[] iArr, int[] iArr2) {
        return view.dispatchNestedPreScroll(i9, i10, iArr, iArr2);
    }

    public static boolean f(View view, int i9, int i10, int i11, int i12, int[] iArr) {
        return view.dispatchNestedScroll(i9, i10, i11, i12, iArr);
    }

    public static ColorStateList g(View view) {
        return view.getBackgroundTintList();
    }

    public static PorterDuff.Mode h(View view) {
        return view.getBackgroundTintMode();
    }

    public static float i(View view) {
        return view.getElevation();
    }

    public static a2 j(View view) {
        if (n1.f7181d && view.isAttachedToWindow()) {
            try {
                Object obj = n1.f7178a.get(view.getRootView());
                if (obj != null) {
                    Rect rect = (Rect) n1.f7179b.get(obj);
                    Rect rect2 = (Rect) n1.f7180c.get(obj);
                    if (rect != null && rect2 != null) {
                        int i9 = Build.VERSION.SDK_INT;
                        r1 q1Var = i9 >= 30 ? new q1() : i9 >= 29 ? new p1() : new o1();
                        q1Var.e(f0.c.b(rect.left, rect.top, rect.right, rect.bottom));
                        q1Var.g(f0.c.b(rect2.left, rect2.top, rect2.right, rect2.bottom));
                        a2 b9 = q1Var.b();
                        b9.f7139a.p(b9);
                        b9.f7139a.d(view.getRootView());
                        return b9;
                    }
                }
            } catch (IllegalAccessException e9) {
                Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e9.getMessage(), e9);
            }
        }
        return null;
    }

    public static String k(View view) {
        return view.getTransitionName();
    }

    public static float l(View view) {
        return view.getTranslationZ();
    }

    public static float m(View view) {
        return view.getZ();
    }

    public static boolean n(View view) {
        return view.hasNestedScrollingParent();
    }

    public static boolean o(View view) {
        return view.isImportantForAccessibility();
    }

    public static boolean p(View view) {
        return view.isNestedScrollingEnabled();
    }

    public static void q(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    public static void r(View view, PorterDuff.Mode mode) {
        view.setBackgroundTintMode(mode);
    }

    public static void s(View view, float f9) {
        view.setElevation(f9);
    }

    public static void t(View view, boolean z8) {
        view.setNestedScrollingEnabled(z8);
    }

    public static void u(View view, r rVar) {
        if (Build.VERSION.SDK_INT < 30) {
            view.setTag(2131362423, rVar);
        }
        if (rVar == null) {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(2131362431));
        } else {
            view.setOnApplyWindowInsetsListener(new h0(view, rVar));
        }
    }

    public static void v(View view, String str) {
        view.setTransitionName(str);
    }

    public static void w(View view, float f9) {
        view.setTranslationZ(f9);
    }

    public static void x(View view, float f9) {
        view.setZ(f9);
    }

    public static boolean y(View view, int i9) {
        return view.startNestedScroll(i9);
    }

    public static void z(View view) {
        view.stopNestedScroll();
    }
}
