package m;

import android.view.MenuItem;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class r implements MenuItem.OnActionExpandListener {

    /* renamed from: a, reason: collision with root package name */
    public final MenuItem.OnActionExpandListener f6476a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t f6477b;

    public r(t tVar, MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f6477b = tVar;
        this.f6476a = onActionExpandListener;
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return this.f6476a.onMenuItemActionCollapse(this.f6477b.j(menuItem));
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionExpand(MenuItem menuItem) {
        return this.f6476a.onMenuItemActionExpand(this.f6477b.j(menuItem));
    }
}
