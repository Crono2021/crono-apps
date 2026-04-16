package androidx.lifecycle;

import android.os.Bundle;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class SavedStateHandleAttacher implements q {

    /* renamed from: i, reason: collision with root package name */
    public final h0 f893i;

    public SavedStateHandleAttacher(h0 h0Var) {
        this.f893i = h0Var;
    }

    @Override // androidx.lifecycle.q
    public final void a(s sVar, l lVar) {
        if (lVar != l.ON_CREATE) {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + lVar).toString());
        }
        sVar.g().f(this);
        h0 h0Var = this.f893i;
        if (h0Var.f918b) {
            return;
        }
        Bundle c9 = h0Var.f917a.c("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundle = new Bundle();
        Bundle bundle2 = h0Var.f919c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (c9 != null) {
            bundle.putAll(c9);
        }
        h0Var.f919c = bundle;
        h0Var.f918b = true;
    }
}
