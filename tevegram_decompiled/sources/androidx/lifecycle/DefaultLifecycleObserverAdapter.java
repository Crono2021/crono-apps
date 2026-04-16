package androidx.lifecycle;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class DefaultLifecycleObserverAdapter implements q {

    /* renamed from: i, reason: collision with root package name */
    public final d f887i;

    /* renamed from: j, reason: collision with root package name */
    public final q f888j;

    public DefaultLifecycleObserverAdapter(d dVar, q qVar) {
        this.f887i = dVar;
        this.f888j = qVar;
    }

    @Override // androidx.lifecycle.q
    public final void a(s sVar, l lVar) {
        int i9 = e.f911a[lVar.ordinal()];
        if (i9 == 3) {
            this.f887i.b();
        } else if (i9 == 7) {
            m7.c.n("ON_ANY must not been send by anybody");
            return;
        }
        q qVar = this.f888j;
        if (qVar != null) {
            qVar.a(sVar, lVar);
        }
    }
}
