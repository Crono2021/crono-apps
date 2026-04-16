package m;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class o implements h0.a {
    public int G;
    public View H;
    public p I;
    public MenuItem.OnActionExpandListener J;

    /* renamed from: i, reason: collision with root package name */
    public final int f6455i;

    /* renamed from: j, reason: collision with root package name */
    public final int f6456j;

    /* renamed from: k, reason: collision with root package name */
    public final int f6457k;

    /* renamed from: l, reason: collision with root package name */
    public final int f6458l;

    /* renamed from: m, reason: collision with root package name */
    public CharSequence f6459m;

    /* renamed from: n, reason: collision with root package name */
    public CharSequence f6460n;

    /* renamed from: o, reason: collision with root package name */
    public Intent f6461o;

    /* renamed from: p, reason: collision with root package name */
    public char f6462p;

    /* renamed from: r, reason: collision with root package name */
    public char f6464r;

    /* renamed from: t, reason: collision with root package name */
    public Drawable f6466t;

    /* renamed from: v, reason: collision with root package name */
    public final m f6468v;

    /* renamed from: w, reason: collision with root package name */
    public f0 f6469w;

    /* renamed from: x, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f6470x;

    /* renamed from: y, reason: collision with root package name */
    public CharSequence f6471y;

    /* renamed from: z, reason: collision with root package name */
    public CharSequence f6472z;

    /* renamed from: q, reason: collision with root package name */
    public int f6463q = 4096;

    /* renamed from: s, reason: collision with root package name */
    public int f6465s = 4096;

    /* renamed from: u, reason: collision with root package name */
    public int f6467u = 0;
    public ColorStateList A = null;
    public PorterDuff.Mode B = null;
    public boolean C = false;
    public boolean D = false;
    public boolean E = false;
    public int F = 16;
    public boolean K = false;

    public o(m mVar, int i9, int i10, int i11, int i12, CharSequence charSequence, int i13) {
        this.f6468v = mVar;
        this.f6455i = i10;
        this.f6456j = i9;
        this.f6457k = i11;
        this.f6458l = i12;
        this.f6459m = charSequence;
        this.G = i13;
    }

    public static void c(StringBuilder sb, int i9, int i10, String str) {
        if ((i9 & i10) == i10) {
            sb.append(str);
        }
    }

    @Override // h0.a
    public final h0.a a(p pVar) {
        this.H = null;
        this.I = pVar;
        this.f6468v.p(true);
        p pVar2 = this.I;
        if (pVar2 != null) {
            pVar2.f6474b = new i7.x(this, 3);
            pVar2.f6473a.setVisibilityListener(pVar2);
        }
        return this;
    }

    @Override // h0.a
    public final p b() {
        return this.I;
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        if ((this.G & 8) == 0) {
            return false;
        }
        if (this.H == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.J;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f6468v.d(this);
        }
        return false;
    }

    public final Drawable d(Drawable drawable) {
        if (drawable != null && this.E && (this.C || this.D)) {
            drawable = com.bumptech.glide.d.f0(drawable).mutate();
            if (this.C) {
                g0.b.h(drawable, this.A);
            }
            if (this.D) {
                g0.b.i(drawable, this.B);
            }
            this.E = false;
        }
        return drawable;
    }

    public final boolean e() {
        p pVar;
        if ((this.G & 8) != 0) {
            if (this.H == null && (pVar = this.I) != null) {
                this.H = pVar.f6473a.onCreateActionView(this);
            }
            if (this.H != null) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        if (!e()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.J;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f6468v.f(this);
        }
        return false;
    }

    public final void f(boolean z8) {
        int i9 = this.F;
        if (z8) {
            this.F = i9 | 32;
        } else {
            this.F = i9 & (-33);
        }
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        View view = this.H;
        if (view != null) {
            return view;
        }
        p pVar = this.I;
        if (pVar == null) {
            return null;
        }
        View onCreateActionView = pVar.f6473a.onCreateActionView(this);
        this.H = onCreateActionView;
        return onCreateActionView;
    }

    @Override // h0.a, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f6465s;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f6464r;
    }

    @Override // h0.a, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f6471y;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.f6456j;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        Drawable drawable = this.f6466t;
        if (drawable != null) {
            return d(drawable);
        }
        int i9 = this.f6467u;
        if (i9 == 0) {
            return null;
        }
        Drawable I = android.support.v4.media.session.b.I(this.f6468v.f6434i, i9);
        this.f6467u = 0;
        this.f6466t = I;
        return d(I);
    }

    @Override // h0.a, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.A;
    }

    @Override // h0.a, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.B;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f6461o;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return this.f6455i;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // h0.a, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f6463q;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f6462p;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.f6457k;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.f6469w;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f6459m;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f6460n;
        return charSequence != null ? charSequence : this.f6459m;
    }

    @Override // h0.a, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f6472z;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return this.f6469w != null;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.K;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.F & 1) == 1;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.F & 2) == 2;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.F & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        p pVar = this.I;
        return (pVar == null || !pVar.f6473a.overridesItemVisibility()) ? (this.F & 8) == 0 : (this.F & 8) == 0 && this.I.f6473a.isVisible();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i9) {
        int i10;
        m mVar = this.f6468v;
        Context context = mVar.f6434i;
        View inflate = LayoutInflater.from(context).inflate(i9, (ViewGroup) new LinearLayout(context), false);
        this.H = inflate;
        this.I = null;
        if (inflate != null && inflate.getId() == -1 && (i10 = this.f6455i) > 0) {
            inflate.setId(i10);
        }
        mVar.f6444s = true;
        mVar.p(true);
        return this;
    }

    @Override // h0.a, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c9, int i9) {
        if (this.f6464r == c9 && this.f6465s == i9) {
            return this;
        }
        this.f6464r = Character.toLowerCase(c9);
        this.f6465s = KeyEvent.normalizeMetaState(i9);
        this.f6468v.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z8) {
        int i9 = this.F;
        int i10 = (z8 ? 1 : 0) | (i9 & (-2));
        this.F = i10;
        if (i9 != i10) {
            this.f6468v.p(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z8) {
        int i9 = this.F;
        int i10 = i9 & 4;
        m mVar = this.f6468v;
        if (i10 == 0) {
            int i11 = (i9 & (-3)) | (z8 ? 2 : 0);
            this.F = i11;
            if (i9 != i11) {
                mVar.p(false);
            }
            return this;
        }
        ArrayList arrayList = mVar.f6439n;
        int size = arrayList.size();
        mVar.w();
        for (int i12 = 0; i12 < size; i12++) {
            o oVar = (o) arrayList.get(i12);
            if (oVar.f6456j == this.f6456j && (oVar.F & 4) != 0 && oVar.isCheckable()) {
                boolean z9 = oVar == this;
                int i13 = oVar.F;
                int i14 = (z9 ? 2 : 0) | (i13 & (-3));
                oVar.F = i14;
                if (i13 != i14) {
                    oVar.f6468v.p(false);
                }
            }
        }
        mVar.v();
        return this;
    }

    @Override // h0.a, android.view.MenuItem
    public final h0.a setContentDescription(CharSequence charSequence) {
        this.f6471y = charSequence;
        this.f6468v.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z8) {
        int i9 = this.F;
        if (z8) {
            this.F = i9 | 16;
        } else {
            this.F = i9 & (-17);
        }
        this.f6468v.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i9) {
        this.f6466t = null;
        this.f6467u = i9;
        this.E = true;
        this.f6468v.p(false);
        return this;
    }

    @Override // h0.a, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.A = colorStateList;
        this.C = true;
        this.E = true;
        this.f6468v.p(false);
        return this;
    }

    @Override // h0.a, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.B = mode;
        this.D = true;
        this.E = true;
        this.f6468v.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f6461o = intent;
        return this;
    }

    @Override // h0.a, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c9, int i9) {
        if (this.f6462p == c9 && this.f6463q == i9) {
            return this;
        }
        this.f6462p = c9;
        this.f6463q = KeyEvent.normalizeMetaState(i9);
        this.f6468v.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.J = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f6470x = onMenuItemClickListener;
        return this;
    }

    @Override // h0.a, android.view.MenuItem
    public final MenuItem setShortcut(char c9, char c10, int i9, int i10) {
        this.f6462p = c9;
        this.f6463q = KeyEvent.normalizeMetaState(i9);
        this.f6464r = Character.toLowerCase(c10);
        this.f6465s = KeyEvent.normalizeMetaState(i10);
        this.f6468v.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i9) {
        int i10 = i9 & 3;
        if (i10 != 0 && i10 != 1 && i10 != 2) {
            m7.c.n("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
            return;
        }
        this.G = i9;
        m mVar = this.f6468v;
        mVar.f6444s = true;
        mVar.p(true);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i9) {
        setShowAsAction(i9);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f6459m = charSequence;
        this.f6468v.p(false);
        f0 f0Var = this.f6469w;
        if (f0Var != null) {
            f0Var.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f6460n = charSequence;
        this.f6468v.p(false);
        return this;
    }

    @Override // h0.a, android.view.MenuItem
    public final h0.a setTooltipText(CharSequence charSequence) {
        this.f6472z = charSequence;
        this.f6468v.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z8) {
        int i9 = this.F;
        int i10 = (z8 ? 0 : 8) | (i9 & (-9));
        this.F = i10;
        if (i9 != i10) {
            m mVar = this.f6468v;
            mVar.f6441p = true;
            mVar.p(true);
        }
        return this;
    }

    public final String toString() {
        CharSequence charSequence = this.f6459m;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f6467u = 0;
        this.f6466t = drawable;
        this.E = true;
        this.f6468v.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i9) {
        setTitle(this.f6468v.f6434i.getString(i9));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c9) {
        if (this.f6462p == c9) {
            return this;
        }
        this.f6462p = c9;
        this.f6468v.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c9, char c10) {
        this.f6462p = c9;
        this.f6464r = Character.toLowerCase(c10);
        this.f6468v.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c9) {
        if (this.f6464r == c9) {
            return this;
        }
        this.f6464r = Character.toLowerCase(c9);
        this.f6468v.p(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        int i9;
        this.H = view;
        this.I = null;
        if (view != null && view.getId() == -1 && (i9 = this.f6455i) > 0) {
            view.setId(i9);
        }
        m mVar = this.f6468v;
        mVar.f6444s = true;
        mVar.p(true);
        return this;
    }
}
