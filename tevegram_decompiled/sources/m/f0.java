package m;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f0 extends m implements SubMenu {
    public final m H;
    public final o I;

    public f0(Context context, m mVar, o oVar) {
        super(context);
        this.H = mVar;
        this.I = oVar;
    }

    @Override // m.m
    public final boolean d(o oVar) {
        return this.H.d(oVar);
    }

    @Override // m.m
    public final boolean e(m mVar, MenuItem menuItem) {
        return super.e(mVar, menuItem) || this.H.e(mVar, menuItem);
    }

    @Override // m.m
    public final boolean f(o oVar) {
        return this.H.f(oVar);
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return this.I;
    }

    @Override // m.m
    public final String j() {
        o oVar = this.I;
        int i9 = oVar != null ? oVar.f6455i : 0;
        if (i9 == 0) {
            return null;
        }
        return androidx.activity.g.m(i9, "android:menu:actionviewstates:");
    }

    @Override // m.m
    public final m k() {
        return this.H.k();
    }

    @Override // m.m
    public final boolean m() {
        return this.H.m();
    }

    @Override // m.m
    public final boolean n() {
        return this.H.n();
    }

    @Override // m.m
    public final boolean o() {
        return this.H.o();
    }

    @Override // m.m, android.view.Menu
    public final void setGroupDividerEnabled(boolean z8) {
        this.H.setGroupDividerEnabled(z8);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable drawable) {
        u(0, null, 0, drawable, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        u(0, charSequence, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        u(0, null, 0, null, view);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        this.I.setIcon(drawable);
        return this;
    }

    @Override // m.m, android.view.Menu
    public final void setQwertyMode(boolean z8) {
        this.H.setQwertyMode(z8);
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i9) {
        this.I.setIcon(i9);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i9) {
        u(0, null, i9, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i9) {
        u(i9, null, 0, null, null);
        return this;
    }
}
