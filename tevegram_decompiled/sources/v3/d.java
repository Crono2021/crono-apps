package v3;

import android.view.ViewGroup;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d extends l {

    /* renamed from: a, reason: collision with root package name */
    public boolean f9506a = false;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f9507b;

    public d(ViewGroup viewGroup) {
        this.f9507b = viewGroup;
    }

    @Override // v3.j
    public final void b(k kVar) {
        if (!this.f9506a) {
            com.bumptech.glide.d.d0(this.f9507b, false);
        }
        kVar.u(this);
    }

    @Override // v3.l, v3.j
    public final void c() {
        com.bumptech.glide.d.d0(this.f9507b, false);
    }

    @Override // v3.l, v3.j
    public final void d() {
        com.bumptech.glide.d.d0(this.f9507b, true);
    }

    @Override // v3.l, v3.j
    public final void e() {
        com.bumptech.glide.d.d0(this.f9507b, false);
        this.f9506a = true;
    }
}
