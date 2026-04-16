package androidx.fragment.app;

import android.os.Handler;
import android.view.View;
import android.view.Window;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class v extends android.support.v4.media.session.b implements androidx.lifecycle.m0, androidx.lifecycle.s, k0 {

    /* renamed from: o, reason: collision with root package name */
    public final g.l f871o;

    /* renamed from: p, reason: collision with root package name */
    public final g.l f872p;

    /* renamed from: q, reason: collision with root package name */
    public final Handler f873q;

    /* renamed from: r, reason: collision with root package name */
    public final h0 f874r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ g.l f875s;

    public v(g.l lVar) {
        this.f875s = lVar;
        Handler handler = new Handler();
        this.f874r = new h0();
        this.f871o = lVar;
        this.f872p = lVar;
        this.f873q = handler;
    }

    @Override // android.support.v4.media.session.b
    public final View e0(int i9) {
        return this.f875s.findViewById(i9);
    }

    @Override // androidx.lifecycle.m0
    public final androidx.lifecycle.l0 f() {
        return this.f875s.f();
    }

    @Override // android.support.v4.media.session.b
    public final boolean f0() {
        Window window = this.f875s.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }

    @Override // androidx.lifecycle.s
    public final androidx.lifecycle.u g() {
        return this.f875s.f3578z;
    }

    @Override // androidx.fragment.app.k0
    public final void e() {
    }
}
