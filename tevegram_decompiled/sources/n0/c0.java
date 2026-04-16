package n0;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeProvider;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class c0 {
    public static AccessibilityNodeProvider a(View view) {
        return view.getAccessibilityNodeProvider();
    }

    public static boolean b(View view) {
        return view.getFitsSystemWindows();
    }

    public static int c(View view) {
        return view.getImportantForAccessibility();
    }

    public static int d(View view) {
        return view.getMinimumHeight();
    }

    public static int e(View view) {
        return view.getMinimumWidth();
    }

    public static ViewParent f(View view) {
        return view.getParentForAccessibility();
    }

    public static int g(View view) {
        return view.getWindowSystemUiVisibility();
    }

    public static boolean h(View view) {
        return view.hasOverlappingRendering();
    }

    public static boolean i(View view) {
        return view.hasTransientState();
    }

    public static boolean j(View view, int i9, Bundle bundle) {
        return view.performAccessibilityAction(i9, bundle);
    }

    public static void k(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void l(View view, int i9, int i10, int i11, int i12) {
        view.postInvalidateOnAnimation(i9, i10, i11, i12);
    }

    public static void m(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void n(View view, Runnable runnable, long j5) {
        view.postOnAnimationDelayed(runnable, j5);
    }

    public static void o(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public static void p(View view) {
        view.requestFitSystemWindows();
    }

    public static void q(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static void r(View view, boolean z8) {
        view.setHasTransientState(z8);
    }

    public static void s(View view, int i9) {
        view.setImportantForAccessibility(i9);
    }
}
