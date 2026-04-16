package androidx.lifecycle;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class LifecycleCoroutineScopeImpl implements q, i8.u {

    /* renamed from: i, reason: collision with root package name */
    public final u f889i;

    /* renamed from: j, reason: collision with root package name */
    public final r7.g f890j;

    public LifecycleCoroutineScopeImpl(u uVar, r7.g gVar) {
        gVar.getClass();
        this.f889i = uVar;
        this.f890j = gVar;
        if (uVar.f943d == m.f928i) {
            i8.w.b(gVar, null);
        }
    }

    @Override // androidx.lifecycle.q
    public final void a(s sVar, l lVar) {
        u uVar = this.f889i;
        if (uVar.f943d.compareTo(m.f928i) <= 0) {
            uVar.f(this);
            i8.w.b(this.f890j, null);
        }
    }

    @Override // i8.u
    public final r7.g c() {
        return this.f890j;
    }
}
