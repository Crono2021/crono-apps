package m;

import android.view.ActionProvider;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class p implements ActionProvider.VisibilityListener {

    /* renamed from: a, reason: collision with root package name */
    public final ActionProvider f6473a;

    /* renamed from: b, reason: collision with root package name */
    public i7.x f6474b;

    public p(t tVar, ActionProvider actionProvider) {
        this.f6473a = actionProvider;
    }

    @Override // android.view.ActionProvider.VisibilityListener
    public final void onActionProviderVisibilityChanged(boolean z8) {
        i7.x xVar = this.f6474b;
        if (xVar != null) {
            m mVar = ((o) xVar.f5179j).f6468v;
            mVar.f6441p = true;
            mVar.p(true);
        }
    }
}
