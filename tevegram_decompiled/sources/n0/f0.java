package n0;

import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class f0 {
    public static int a(View view) {
        return view.getAccessibilityLiveRegion();
    }

    public static boolean b(View view) {
        return view.isAttachedToWindow();
    }

    public static boolean c(View view) {
        return view.isLaidOut();
    }

    public static boolean d(View view) {
        return view.isLayoutDirectionResolved();
    }

    public static void e(ViewParent viewParent, View view, View view2, int i9) {
        viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i9);
    }

    public static void f(View view, int i9) {
        view.setAccessibilityLiveRegion(i9);
    }

    public static void g(AccessibilityEvent accessibilityEvent, int i9) {
        accessibilityEvent.setContentChangeTypes(i9);
    }
}
