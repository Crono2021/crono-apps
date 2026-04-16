package g;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class o0 extends l.a implements m.k {

    /* renamed from: k, reason: collision with root package name */
    public final Context f3589k;

    /* renamed from: l, reason: collision with root package name */
    public final m.m f3590l;

    /* renamed from: m, reason: collision with root package name */
    public a5.d f3591m;

    /* renamed from: n, reason: collision with root package name */
    public WeakReference f3592n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ p0 f3593o;

    public o0(p0 p0Var, Context context, a5.d dVar) {
        this.f3593o = p0Var;
        this.f3589k = context;
        this.f3591m = dVar;
        m.m mVar = new m.m(context);
        mVar.f6445t = 1;
        this.f3590l = mVar;
        mVar.f6438m = this;
    }

    @Override // l.a
    public final void a() {
        p0 p0Var = this.f3593o;
        if (p0Var.f3603i != this) {
            return;
        }
        if (p0Var.f3610p) {
            p0Var.f3604j = this;
            p0Var.f3605k = this.f3591m;
        } else {
            this.f3591m.O0(this);
        }
        this.f3591m = null;
        p0Var.a(false);
        ActionBarContextView actionBarContextView = p0Var.f3601f;
        if (actionBarContextView.f412s == null) {
            actionBarContextView.e();
        }
        p0Var.f3598c.setHideOnContentScrollEnabled(p0Var.f3615u);
        p0Var.f3603i = null;
    }

    @Override // l.a
    public final View b() {
        WeakReference weakReference = this.f3592n;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // l.a
    public final m.m c() {
        return this.f3590l;
    }

    @Override // l.a
    public final MenuInflater d() {
        return new l.i(this.f3589k);
    }

    @Override // m.k
    public final boolean e(m.m mVar, MenuItem menuItem) {
        a5.d dVar = this.f3591m;
        if (dVar != null) {
            return ((a0.l) dVar.f174j).q(this, menuItem);
        }
        return false;
    }

    @Override // l.a
    public final CharSequence f() {
        return this.f3593o.f3601f.getSubtitle();
    }

    @Override // l.a
    public final CharSequence g() {
        return this.f3593o.f3601f.getTitle();
    }

    @Override // l.a
    public final void h() {
        if (this.f3593o.f3603i != this) {
            return;
        }
        m.m mVar = this.f3590l;
        mVar.w();
        try {
            this.f3591m.P0(this, mVar);
        } finally {
            mVar.v();
        }
    }

    @Override // l.a
    public final boolean i() {
        return this.f3593o.f3601f.A;
    }

    @Override // m.k
    public final void j(m.m mVar) {
        if (this.f3591m == null) {
            return;
        }
        h();
        n.j jVar = this.f3593o.f3601f.f405l;
        if (jVar != null) {
            jVar.l();
        }
    }

    @Override // l.a
    public final void k(View view) {
        this.f3593o.f3601f.setCustomView(view);
        this.f3592n = new WeakReference(view);
    }

    @Override // l.a
    public final void l(int i9) {
        m(this.f3593o.f3596a.getResources().getString(i9));
    }

    @Override // l.a
    public final void m(CharSequence charSequence) {
        this.f3593o.f3601f.setSubtitle(charSequence);
    }

    @Override // l.a
    public final void n(int i9) {
        o(this.f3593o.f3596a.getResources().getString(i9));
    }

    @Override // l.a
    public final void o(CharSequence charSequence) {
        this.f3593o.f3601f.setTitle(charSequence);
    }

    @Override // l.a
    public final void p(boolean z8) {
        this.f5678j = z8;
        this.f3593o.f3601f.setTitleOptional(z8);
    }
}
