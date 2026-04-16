package o0;

import android.view.accessibility.AccessibilityNodeInfo;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class i {
    public static k a(boolean z8, int i9, int i10, int i11, int i12, boolean z9, String str, String str2) {
        return new k(new AccessibilityNodeInfo.CollectionItemInfo.Builder().setHeading(z8).setColumnIndex(i9).setRowIndex(i10).setColumnSpan(i11).setRowSpan(i12).setSelected(z9).setRowTitle(str).setColumnTitle(str2).build());
    }

    public static l b(AccessibilityNodeInfo accessibilityNodeInfo, int i9, int i10) {
        AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i9, i10);
        if (child != null) {
            return new l((Object) child);
        }
        return null;
    }

    public static String c(Object obj) {
        return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getColumnTitle();
    }

    public static String d(Object obj) {
        return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getRowTitle();
    }

    public static AccessibilityNodeInfo.ExtraRenderingInfo e(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getExtraRenderingInfo();
    }

    public static l f(AccessibilityNodeInfo accessibilityNodeInfo, int i9) {
        AccessibilityNodeInfo parent = accessibilityNodeInfo.getParent(i9);
        if (parent != null) {
            return new l((Object) parent);
        }
        return null;
    }

    public static String g(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getUniqueId();
    }

    public static boolean h(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.isTextSelectable();
    }

    public static void i(AccessibilityNodeInfo accessibilityNodeInfo, boolean z8) {
        accessibilityNodeInfo.setTextSelectable(z8);
    }

    public static void j(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        accessibilityNodeInfo.setUniqueId(str);
    }
}
