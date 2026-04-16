package o0;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class m extends AccessibilityNodeProvider {

    /* renamed from: a, reason: collision with root package name */
    public final i7.x f7566a;

    public m(i7.x xVar) {
        this.f7566a = xVar;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i9) {
        l x6 = this.f7566a.x(i9);
        if (x6 == null) {
            return null;
        }
        return x6.f7564a;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final List findAccessibilityNodeInfosByText(String str, int i9) {
        this.f7566a.getClass();
        return null;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo findFocus(int i9) {
        l y2 = this.f7566a.y(i9);
        if (y2 == null) {
            return null;
        }
        return y2.f7564a;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final boolean performAction(int i9, int i10, Bundle bundle) {
        return this.f7566a.J(i9, i10, bundle);
    }
}
