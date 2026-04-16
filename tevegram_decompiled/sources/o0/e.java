package o0;

import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import com.google.android.material.internal.CheckableImageButton;
import java.util.WeakHashMap;
import n0.c0;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e implements AccessibilityManager.TouchExplorationStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final d f7550a;

    public e(d dVar) {
        this.f7550a = dVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            return this.f7550a.equals(((e) obj).f7550a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f7550a.hashCode();
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z8) {
        x5.i iVar = (x5.i) ((a3.i) this.f7550a).f118j;
        AutoCompleteTextView autoCompleteTextView = iVar.h;
        if (autoCompleteTextView == null || autoCompleteTextView.getInputType() != 0) {
            return;
        }
        CheckableImageButton checkableImageButton = iVar.f10156d;
        int i9 = z8 ? 2 : 1;
        WeakHashMap weakHashMap = t0.f7209a;
        c0.s(checkableImageButton, i9);
    }
}
