package m;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements h0.a {

    /* renamed from: i, reason: collision with root package name */
    public CharSequence f6358i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f6359j;

    /* renamed from: k, reason: collision with root package name */
    public Intent f6360k;

    /* renamed from: l, reason: collision with root package name */
    public char f6361l;

    /* renamed from: m, reason: collision with root package name */
    public int f6362m;

    /* renamed from: n, reason: collision with root package name */
    public char f6363n;

    /* renamed from: o, reason: collision with root package name */
    public int f6364o;

    /* renamed from: p, reason: collision with root package name */
    public Drawable f6365p;

    /* renamed from: q, reason: collision with root package name */
    public Context f6366q;

    /* renamed from: r, reason: collision with root package name */
    public CharSequence f6367r;

    /* renamed from: s, reason: collision with root package name */
    public CharSequence f6368s;

    /* renamed from: t, reason: collision with root package name */
    public ColorStateList f6369t;

    /* renamed from: u, reason: collision with root package name */
    public PorterDuff.Mode f6370u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f6371v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f6372w;

    /* renamed from: x, reason: collision with root package name */
    public int f6373x;

    @Override // h0.a
    public final h0.a a(p pVar) {
        throw new UnsupportedOperationException();
    }

    @Override // h0.a
    public final p b() {
        return null;
    }

    public final void c() {
        Drawable drawable = this.f6365p;
        if (drawable != null) {
            if (this.f6371v || this.f6372w) {
                Drawable f02 = com.bumptech.glide.d.f0(drawable);
                this.f6365p = f02;
                Drawable mutate = f02.mutate();
                this.f6365p = mutate;
                if (this.f6371v) {
                    g0.b.h(mutate, this.f6369t);
                }
                if (this.f6372w) {
                    g0.b.i(this.f6365p, this.f6370u);
                }
            }
        }
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        return null;
    }

    @Override // h0.a, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f6364o;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f6363n;
    }

    @Override // h0.a, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f6367r;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        return this.f6365p;
    }

    @Override // h0.a, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f6369t;
    }

    @Override // h0.a, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f6370u;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f6360k;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return R.id.home;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // h0.a, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f6362m;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f6361l;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f6358i;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f6359j;
        return charSequence != null ? charSequence : this.f6358i;
    }

    @Override // h0.a, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f6368s;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.f6373x & 1) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.f6373x & 2) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.f6373x & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        return (this.f6373x & 8) == 0;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // h0.a, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c9, int i9) {
        this.f6363n = Character.toLowerCase(c9);
        this.f6364o = KeyEvent.normalizeMetaState(i9);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z8) {
        this.f6373x = (z8 ? 1 : 0) | (this.f6373x & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z8) {
        this.f6373x = (z8 ? 2 : 0) | (this.f6373x & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setContentDescription(CharSequence charSequence) {
        this.f6367r = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z8) {
        this.f6373x = (z8 ? 16 : 0) | (this.f6373x & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i9) {
        this.f6365p = d0.c.b(this.f6366q, i9);
        c();
        return this;
    }

    @Override // h0.a, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f6369t = colorStateList;
        this.f6371v = true;
        c();
        return this;
    }

    @Override // h0.a, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f6370u = mode;
        this.f6372w = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f6360k = intent;
        return this;
    }

    @Override // h0.a, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c9, int i9) {
        this.f6361l = c9;
        this.f6362m = KeyEvent.normalizeMetaState(i9);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // h0.a, android.view.MenuItem
    public final MenuItem setShortcut(char c9, char c10, int i9, int i10) {
        this.f6361l = c9;
        this.f6362m = KeyEvent.normalizeMetaState(i9);
        this.f6363n = Character.toLowerCase(c10);
        this.f6364o = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i9) {
        this.f6358i = this.f6366q.getResources().getString(i9);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f6359j = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTooltipText(CharSequence charSequence) {
        this.f6368s = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z8) {
        this.f6373x = (this.f6373x & 8) | (z8 ? 0 : 8);
        return this;
    }

    @Override // h0.a, android.view.MenuItem
    public final h0.a setContentDescription(CharSequence charSequence) {
        this.f6367r = charSequence;
        return this;
    }

    @Override // h0.a, android.view.MenuItem
    public final h0.a setTooltipText(CharSequence charSequence) {
        this.f6368s = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i9) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c9) {
        this.f6361l = c9;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f6365p = drawable;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c9) {
        this.f6363n = Character.toLowerCase(c9);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f6358i = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c9, char c10) {
        this.f6361l = c9;
        this.f6363n = Character.toLowerCase(c10);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i9) {
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i9) {
        return this;
    }
}
