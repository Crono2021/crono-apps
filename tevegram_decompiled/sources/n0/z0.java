package n0;

import android.view.View;
import android.view.ViewParent;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class z0 {
    public static boolean a(ViewParent viewParent, View view, float f9, float f10, boolean z8) {
        return viewParent.onNestedFling(view, f9, f10, z8);
    }

    public static boolean b(ViewParent viewParent, View view, float f9, float f10) {
        return viewParent.onNestedPreFling(view, f9, f10);
    }

    public static void c(ViewParent viewParent, View view, int i9, int i10, int[] iArr) {
        viewParent.onNestedPreScroll(view, i9, i10, iArr);
    }

    public static void d(ViewParent viewParent, View view, int i9, int i10, int i11, int i12) {
        viewParent.onNestedScroll(view, i9, i10, i11, i12);
    }

    public static void e(ViewParent viewParent, View view, View view2, int i9) {
        viewParent.onNestedScrollAccepted(view, view2, i9);
    }

    public static boolean f(ViewParent viewParent, View view, View view2, int i9) {
        return viewParent.onStartNestedScroll(view, view2, i9);
    }

    public static void g(ViewParent viewParent, View view) {
        viewParent.onStopNestedScroll(view);
    }
}
