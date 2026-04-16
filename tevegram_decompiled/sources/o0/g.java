package o0;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class g {
    public static k a(int i9, int i10, int i11, int i12, boolean z8) {
        return new k(AccessibilityNodeInfo.CollectionItemInfo.obtain(i9, i10, i11, i12, z8));
    }

    public static Object b(int i9, float f9, float f10, float f11) {
        return AccessibilityNodeInfo.RangeInfo.obtain(i9, f9, f10, f11);
    }

    public static Bundle c(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getExtras();
    }
}
