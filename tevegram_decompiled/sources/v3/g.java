package v3;

import android.view.View;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g extends l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9515a;

    /* renamed from: b, reason: collision with root package name */
    public Object f9516b;

    public /* synthetic */ g(Object obj, int i9) {
        this.f9515a = i9;
        this.f9516b = obj;
    }

    @Override // v3.l, v3.j
    public void a() {
        switch (this.f9515a) {
            case 2:
                a aVar = (a) this.f9516b;
                if (!aVar.H) {
                    aVar.D();
                    aVar.H = true;
                    break;
                }
                break;
        }
    }

    @Override // v3.j
    public final void b(k kVar) {
        switch (this.f9515a) {
            case 0:
                View view = (View) this.f9516b;
                t tVar = r.f9551a;
                tVar.a0(view, 1.0f);
                tVar.getClass();
                kVar.u(this);
                break;
            case 1:
                ((k) this.f9516b).w();
                kVar.u(this);
                break;
            default:
                a aVar = (a) this.f9516b;
                int i9 = aVar.G - 1;
                aVar.G = i9;
                if (i9 == 0) {
                    aVar.H = false;
                    aVar.l();
                }
                kVar.u(this);
                break;
        }
    }

    public /* synthetic */ g() {
        this.f9515a = 2;
    }
}
