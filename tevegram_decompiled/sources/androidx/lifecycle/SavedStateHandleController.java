package androidx.lifecycle;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class SavedStateHandleController implements q {

    /* renamed from: i, reason: collision with root package name */
    public boolean f894i;

    @Override // androidx.lifecycle.q
    public final void a(s sVar, l lVar) {
        if (lVar == l.ON_DESTROY) {
            this.f894i = false;
            sVar.g().f(this);
        }
    }
}
