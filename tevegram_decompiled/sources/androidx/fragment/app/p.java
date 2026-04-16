package androidx.fragment.app;

import android.view.View;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class p extends android.support.v4.media.session.b {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ s f823o;

    public p(s sVar) {
        this.f823o = sVar;
    }

    @Override // android.support.v4.media.session.b
    public final View e0(int i9) {
        s sVar = this.f823o;
        View view = sVar.M;
        if (view != null) {
            return view.findViewById(i9);
        }
        a.f(sVar, " does not have a view", "Fragment ");
        return null;
    }

    @Override // android.support.v4.media.session.b
    public final boolean f0() {
        return this.f823o.M != null;
    }
}
