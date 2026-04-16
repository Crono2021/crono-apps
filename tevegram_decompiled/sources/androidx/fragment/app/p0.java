package androidx.fragment.app;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class p0 implements androidx.lifecycle.h, p3.d, androidx.lifecycle.m0 {

    /* renamed from: i, reason: collision with root package name */
    public final androidx.lifecycle.l0 f824i;

    /* renamed from: j, reason: collision with root package name */
    public androidx.lifecycle.u f825j = null;

    /* renamed from: k, reason: collision with root package name */
    public com.bumptech.glide.manager.s f826k = null;

    public p0(androidx.lifecycle.l0 l0Var) {
        this.f824i = l0Var;
    }

    @Override // p3.d
    public final n.s a() {
        d();
        return (n.s) this.f826k.f1859l;
    }

    public final void b(androidx.lifecycle.l lVar) {
        this.f825j.d(lVar);
    }

    @Override // androidx.lifecycle.h
    public final b1.b c() {
        return b1.a.f1131j;
    }

    public final void d() {
        if (this.f825j == null) {
            this.f825j = new androidx.lifecycle.u(this);
            this.f826k = new com.bumptech.glide.manager.s(this);
        }
    }

    @Override // androidx.lifecycle.m0
    public final androidx.lifecycle.l0 f() {
        d();
        return this.f824i;
    }

    @Override // androidx.lifecycle.s
    public final androidx.lifecycle.u g() {
        d();
        return this.f825j;
    }
}
