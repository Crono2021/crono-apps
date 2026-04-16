package l;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e extends a implements m.k {

    /* renamed from: k, reason: collision with root package name */
    public Context f5685k;

    /* renamed from: l, reason: collision with root package name */
    public ActionBarContextView f5686l;

    /* renamed from: m, reason: collision with root package name */
    public a5.d f5687m;

    /* renamed from: n, reason: collision with root package name */
    public WeakReference f5688n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f5689o;

    /* renamed from: p, reason: collision with root package name */
    public m.m f5690p;

    @Override // l.a
    public final void a() {
        if (this.f5689o) {
            return;
        }
        this.f5689o = true;
        this.f5687m.O0(this);
    }

    @Override // l.a
    public final View b() {
        WeakReference weakReference = this.f5688n;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // l.a
    public final m.m c() {
        return this.f5690p;
    }

    @Override // l.a
    public final MenuInflater d() {
        return new i(this.f5686l.getContext());
    }

    @Override // m.k
    public final boolean e(m.m mVar, MenuItem menuItem) {
        return ((a0.l) this.f5687m.f174j).q(this, menuItem);
    }

    @Override // l.a
    public final CharSequence f() {
        return this.f5686l.getSubtitle();
    }

    @Override // l.a
    public final CharSequence g() {
        return this.f5686l.getTitle();
    }

    @Override // l.a
    public final void h() {
        this.f5687m.P0(this, this.f5690p);
    }

    @Override // l.a
    public final boolean i() {
        return this.f5686l.A;
    }

    @Override // m.k
    public final void j(m.m mVar) {
        h();
        n.j jVar = this.f5686l.f405l;
        if (jVar != null) {
            jVar.l();
        }
    }

    @Override // l.a
    public final void k(View view) {
        this.f5686l.setCustomView(view);
        this.f5688n = view != null ? new WeakReference(view) : null;
    }

    @Override // l.a
    public final void l(int i9) {
        m(this.f5685k.getString(i9));
    }

    @Override // l.a
    public final void m(CharSequence charSequence) {
        this.f5686l.setSubtitle(charSequence);
    }

    @Override // l.a
    public final void n(int i9) {
        o(this.f5685k.getString(i9));
    }

    @Override // l.a
    public final void o(CharSequence charSequence) {
        this.f5686l.setTitle(charSequence);
    }

    @Override // l.a
    public final void p(boolean z8) {
        this.f5678j = z8;
        this.f5686l.setTitleOptional(z8);
    }
}
