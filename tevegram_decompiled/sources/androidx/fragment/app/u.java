package androidx.fragment.app;

import android.os.Bundle;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class u implements c.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f869a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g.l f870b;

    public /* synthetic */ u(g.l lVar, int i9) {
        this.f869a = i9;
        this.f870b = lVar;
    }

    @Override // c.b
    public final void a() {
        switch (this.f869a) {
            case 0:
                g.l lVar = this.f870b;
                a0.b bVar = lVar.f3577y;
                v vVar = (v) bVar.f8j;
                vVar.f874r.b(vVar, vVar, null);
                Bundle c9 = ((n.s) lVar.f301m.f1859l).c("android:support:fragments");
                if (c9 != null) {
                    ((v) bVar.f8j).f874r.N(c9.getParcelable("android:support:fragments"));
                    break;
                }
                break;
            default:
                g.l lVar2 = this.f870b;
                g.q i9 = lVar2.i();
                i9.a();
                ((n.s) lVar2.f301m.f1859l).c("androidx:appcompat");
                i9.d();
                break;
        }
    }
}
