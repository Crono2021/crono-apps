package y1;

import android.media.Spatializer;
import b6.v0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j implements Spatializer.OnSpatializerStateChangedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f10445a;

    public j(o oVar) {
        this.f10445a = oVar;
    }

    @Override // android.media.Spatializer.OnSpatializerStateChangedListener
    public final void onSpatializerAvailableChanged(Spatializer spatializer, boolean z8) {
        o oVar = this.f10445a;
        v0 v0Var = o.f10473j;
        oVar.e();
    }

    @Override // android.media.Spatializer.OnSpatializerStateChangedListener
    public final void onSpatializerEnabledChanged(Spatializer spatializer, boolean z8) {
        o oVar = this.f10445a;
        v0 v0Var = o.f10473j;
        oVar.e();
    }
}
