package androidx.fragment.app;

import android.app.Dialog;
import android.view.View;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class n extends android.support.v4.media.session.b {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ p f798o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ o f799p;

    public n(o oVar, p pVar) {
        this.f799p = oVar;
        this.f798o = pVar;
    }

    @Override // android.support.v4.media.session.b
    public final View e0(int i9) {
        p pVar = this.f798o;
        if (pVar.f0()) {
            return pVar.e0(i9);
        }
        Dialog dialog = this.f799p.i0;
        if (dialog != null) {
            return dialog.findViewById(i9);
        }
        return null;
    }

    @Override // android.support.v4.media.session.b
    public final boolean f0() {
        return this.f798o.f0() || this.f799p.f815l0;
    }
}
