package o0;

import android.view.accessibility.AccessibilityRecord;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class o {
    public static int a(AccessibilityRecord accessibilityRecord) {
        return accessibilityRecord.getMaxScrollX();
    }

    public static int b(AccessibilityRecord accessibilityRecord) {
        return accessibilityRecord.getMaxScrollY();
    }

    public static void c(AccessibilityRecord accessibilityRecord, int i9) {
        accessibilityRecord.setMaxScrollX(i9);
    }

    public static void d(AccessibilityRecord accessibilityRecord, int i9) {
        accessibilityRecord.setMaxScrollY(i9);
    }
}
