package n;

import android.view.View;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final f f6875i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ j f6876j;

    public h(j jVar, f fVar) {
        this.f6876j = jVar;
        this.f6875i = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m.k kVar;
        j jVar = this.f6876j;
        m.m mVar = jVar.f6906k;
        if (mVar != null && (kVar = mVar.f6438m) != null) {
            kVar.j(mVar);
        }
        View view = (View) jVar.f6911p;
        if (view != null && view.getWindowToken() != null) {
            f fVar = this.f6875i;
            if (!fVar.b()) {
                if (fVar.f6488e != null) {
                    fVar.d(0, 0, false, false);
                }
            }
            jVar.A = fVar;
        }
        jVar.C = null;
    }
}
