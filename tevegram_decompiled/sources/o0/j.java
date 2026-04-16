package o0;

import android.graphics.Rect;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import java.time.Duration;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class j {
    public static void a(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
        accessibilityNodeInfo.getBoundsInWindow(rect);
    }

    public static CharSequence b(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getContainerTitle();
    }

    public static long c(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getMinDurationBetweenContentChanges().toMillis();
    }

    public static boolean d(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.hasRequestInitialAccessibilityFocus();
    }

    public static boolean e(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.isAccessibilityDataSensitive();
    }

    public static void f(AccessibilityNodeInfo accessibilityNodeInfo, boolean z8) {
        accessibilityNodeInfo.setAccessibilityDataSensitive(z8);
    }

    public static void g(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
        accessibilityNodeInfo.setBoundsInWindow(rect);
    }

    public static void h(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
        accessibilityNodeInfo.setContainerTitle(charSequence);
    }

    public static void i(AccessibilityNodeInfo accessibilityNodeInfo, long j5) {
        accessibilityNodeInfo.setMinDurationBetweenContentChanges(Duration.ofMillis(j5));
    }

    public static void j(AccessibilityNodeInfo accessibilityNodeInfo, View view, boolean z8) {
        accessibilityNodeInfo.setQueryFromAppProcessEnabled(view, z8);
    }

    public static void k(AccessibilityNodeInfo accessibilityNodeInfo, boolean z8) {
        accessibilityNodeInfo.setRequestInitialAccessibilityFocus(z8);
    }
}
