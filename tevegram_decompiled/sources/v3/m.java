package v3;

import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class m extends l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s.d f9540a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f9541b;

    public m(n nVar, s.d dVar) {
        this.f9541b = nVar;
        this.f9540a = dVar;
    }

    @Override // v3.j
    public final void b(k kVar) {
        ((ArrayList) this.f9540a.getOrDefault(this.f9541b.f9543j, null)).remove(kVar);
        kVar.u(this);
    }
}
