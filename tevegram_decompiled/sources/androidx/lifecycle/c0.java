package androidx.lifecycle;

import android.os.Handler;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c0 implements s {

    /* renamed from: q, reason: collision with root package name */
    public static final c0 f902q = new c0();

    /* renamed from: i, reason: collision with root package name */
    public int f903i;

    /* renamed from: j, reason: collision with root package name */
    public int f904j;

    /* renamed from: m, reason: collision with root package name */
    public Handler f907m;

    /* renamed from: k, reason: collision with root package name */
    public boolean f905k = true;

    /* renamed from: l, reason: collision with root package name */
    public boolean f906l = true;

    /* renamed from: n, reason: collision with root package name */
    public final u f908n = new u(this);

    /* renamed from: o, reason: collision with root package name */
    public final a7.a f909o = new a7.a(this, 5);

    /* renamed from: p, reason: collision with root package name */
    public final a0.b f910p = new a0.b(this, 9);

    public final void b() {
        int i9 = this.f904j + 1;
        this.f904j = i9;
        if (i9 == 1) {
            if (this.f905k) {
                this.f908n.d(l.ON_RESUME);
                this.f905k = false;
            } else {
                Handler handler = this.f907m;
                handler.getClass();
                handler.removeCallbacks(this.f909o);
            }
        }
    }

    @Override // androidx.lifecycle.s
    public final u g() {
        return this.f908n;
    }
}
