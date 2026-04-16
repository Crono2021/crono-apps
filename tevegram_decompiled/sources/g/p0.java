package g;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.WeakHashMap;
import n.o1;
import n.y3;
import n0.b1;
import n0.c1;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class p0 implements n.d {

    /* renamed from: y, reason: collision with root package name */
    public static final AccelerateInterpolator f3594y = new AccelerateInterpolator();

    /* renamed from: z, reason: collision with root package name */
    public static final DecelerateInterpolator f3595z = new DecelerateInterpolator();

    /* renamed from: a, reason: collision with root package name */
    public Context f3596a;

    /* renamed from: b, reason: collision with root package name */
    public Context f3597b;

    /* renamed from: c, reason: collision with root package name */
    public ActionBarOverlayLayout f3598c;

    /* renamed from: d, reason: collision with root package name */
    public ActionBarContainer f3599d;

    /* renamed from: e, reason: collision with root package name */
    public o1 f3600e;

    /* renamed from: f, reason: collision with root package name */
    public ActionBarContextView f3601f;

    /* renamed from: g, reason: collision with root package name */
    public final View f3602g;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public o0 f3603i;

    /* renamed from: j, reason: collision with root package name */
    public o0 f3604j;

    /* renamed from: k, reason: collision with root package name */
    public a5.d f3605k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f3606l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f3607m;

    /* renamed from: n, reason: collision with root package name */
    public int f3608n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f3609o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f3610p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f3611q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f3612r;

    /* renamed from: s, reason: collision with root package name */
    public l.k f3613s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f3614t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f3615u;

    /* renamed from: v, reason: collision with root package name */
    public final n0 f3616v;

    /* renamed from: w, reason: collision with root package name */
    public final n0 f3617w;

    /* renamed from: x, reason: collision with root package name */
    public final a0.b f3618x;

    public p0(Activity activity, boolean z8) {
        new ArrayList();
        this.f3607m = new ArrayList();
        this.f3608n = 0;
        this.f3609o = true;
        this.f3612r = true;
        this.f3616v = new n0(this, 0);
        this.f3617w = new n0(this, 1);
        this.f3618x = new a0.b(this, 23);
        View decorView = activity.getWindow().getDecorView();
        c(decorView);
        if (z8) {
            return;
        }
        this.f3602g = decorView.findViewById(R.id.content);
    }

    public final void a(boolean z8) {
        c1 a9;
        c1 i9;
        boolean z9 = this.f3611q;
        if (z8) {
            if (!z9) {
                this.f3611q = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.f3598c;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                f(false);
            }
        } else if (z9) {
            this.f3611q = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f3598c;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            f(false);
        }
        ActionBarContainer actionBarContainer = this.f3599d;
        WeakHashMap weakHashMap = t0.f7209a;
        boolean c9 = n0.f0.c(actionBarContainer);
        o1 o1Var = this.f3600e;
        if (!c9) {
            if (z8) {
                ((y3) o1Var).f7109a.setVisibility(4);
                this.f3601f.setVisibility(0);
                return;
            } else {
                ((y3) o1Var).f7109a.setVisibility(0);
                this.f3601f.setVisibility(8);
                return;
            }
        }
        if (z8) {
            y3 y3Var = (y3) o1Var;
            i9 = t0.a(y3Var.f7109a);
            i9.a(0.0f);
            i9.c(100L);
            i9.d(new l.j(y3Var, 4));
            a9 = this.f3601f.i(0, 200L);
        } else {
            y3 y3Var2 = (y3) o1Var;
            a9 = t0.a(y3Var2.f7109a);
            a9.a(1.0f);
            a9.c(200L);
            a9.d(new l.j(y3Var2, 0));
            i9 = this.f3601f.i(8, 100L);
        }
        l.k kVar = new l.k();
        ArrayList arrayList = kVar.f5731a;
        arrayList.add(i9);
        View view = (View) i9.f7146a.get();
        long duration = view != null ? view.animate().getDuration() : 0L;
        View view2 = (View) a9.f7146a.get();
        if (view2 != null) {
            view2.animate().setStartDelay(duration);
        }
        arrayList.add(a9);
        kVar.b();
    }

    public final Context b() {
        if (this.f3597b == null) {
            TypedValue typedValue = new TypedValue();
            this.f3596a.getTheme().resolveAttribute(2130968586, typedValue, true);
            int i9 = typedValue.resourceId;
            if (i9 != 0) {
                this.f3597b = new ContextThemeWrapper(this.f3596a, i9);
            } else {
                this.f3597b = this.f3596a;
            }
        }
        return this.f3597b;
    }

    public final void c(View view) {
        o1 wrapper;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(2131361991);
        this.f3598c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        KeyEvent.Callback findViewById = view.findViewById(2131361841);
        if (findViewById instanceof o1) {
            wrapper = (o1) findViewById;
        } else {
            if (!(findViewById instanceof Toolbar)) {
                throw new IllegalStateException("Can't make a decor toolbar out of ".concat(findViewById != null ? findViewById.getClass().getSimpleName() : "null"));
            }
            wrapper = ((Toolbar) findViewById).getWrapper();
        }
        this.f3600e = wrapper;
        this.f3601f = (ActionBarContextView) view.findViewById(2131361849);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(2131361843);
        this.f3599d = actionBarContainer;
        o1 o1Var = this.f3600e;
        if (o1Var == null || this.f3601f == null || actionBarContainer == null) {
            m7.c.p(p0.class.getSimpleName().concat(" can only be used with a compatible window decor layout"));
            return;
        }
        Context context = ((y3) o1Var).f7109a.getContext();
        this.f3596a = context;
        if ((((y3) this.f3600e).f7110b & 4) != 0) {
            this.h = true;
        }
        int i9 = context.getApplicationInfo().targetSdkVersion;
        this.f3600e.getClass();
        e(context.getResources().getBoolean(2131034112));
        TypedArray obtainStyledAttributes = this.f3596a.obtainStyledAttributes(null, f.a.f3166a, 2130968581, 0);
        if (obtainStyledAttributes.getBoolean(14, false)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f3598c;
            if (!actionBarOverlayLayout2.f427p) {
                m7.c.p("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
                return;
            } else {
                this.f3615u = true;
                actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
            }
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(12, 0);
        if (dimensionPixelSize != 0) {
            ActionBarContainer actionBarContainer2 = this.f3599d;
            WeakHashMap weakHashMap = t0.f7209a;
            n0.i0.s(actionBarContainer2, dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    public final void d(boolean z8) {
        if (this.h) {
            return;
        }
        int i9 = z8 ? 4 : 0;
        y3 y3Var = (y3) this.f3600e;
        int i10 = y3Var.f7110b;
        this.h = true;
        y3Var.a((i9 & 4) | (i10 & (-5)));
    }

    public final void e(boolean z8) {
        if (z8) {
            this.f3599d.setTabContainer(null);
            ((y3) this.f3600e).getClass();
        } else {
            ((y3) this.f3600e).getClass();
            this.f3599d.setTabContainer(null);
        }
        this.f3600e.getClass();
        ((y3) this.f3600e).f7109a.setCollapsible(false);
        this.f3598c.setHasNonEmbeddedTabs(false);
    }

    public final void f(boolean z8) {
        boolean z9 = this.f3611q || !this.f3610p;
        boolean z10 = this.f3612r;
        int i9 = 2;
        a0.b bVar = this.f3618x;
        View view = this.f3602g;
        if (!z9) {
            if (z10) {
                this.f3612r = false;
                l.k kVar = this.f3613s;
                if (kVar != null) {
                    kVar.a();
                }
                int i10 = this.f3608n;
                n0 n0Var = this.f3616v;
                if (i10 != 0 || (!this.f3614t && !z8)) {
                    n0Var.a();
                    return;
                }
                this.f3599d.setAlpha(1.0f);
                this.f3599d.setTransitioning(true);
                l.k kVar2 = new l.k();
                float f9 = -this.f3599d.getHeight();
                if (z8) {
                    this.f3599d.getLocationInWindow(new int[]{0, 0});
                    f9 -= r13[1];
                }
                c1 a9 = t0.a(this.f3599d);
                a9.e(f9);
                View view2 = (View) a9.f7146a.get();
                if (view2 != null) {
                    b1.a(view2.animate(), bVar != null ? new a5.b(bVar, i9, view2) : null);
                }
                boolean z11 = kVar2.f5735e;
                ArrayList arrayList = kVar2.f5731a;
                if (!z11) {
                    arrayList.add(a9);
                }
                if (this.f3609o && view != null) {
                    c1 a10 = t0.a(view);
                    a10.e(f9);
                    if (!kVar2.f5735e) {
                        arrayList.add(a10);
                    }
                }
                boolean z12 = kVar2.f5735e;
                if (!z12) {
                    kVar2.f5733c = f3594y;
                }
                if (!z12) {
                    kVar2.f5732b = 250L;
                }
                if (!z12) {
                    kVar2.f5734d = n0Var;
                }
                this.f3613s = kVar2;
                kVar2.b();
                return;
            }
            return;
        }
        if (z10) {
            return;
        }
        this.f3612r = true;
        l.k kVar3 = this.f3613s;
        if (kVar3 != null) {
            kVar3.a();
        }
        this.f3599d.setVisibility(0);
        int i11 = this.f3608n;
        n0 n0Var2 = this.f3617w;
        if (i11 == 0 && (this.f3614t || z8)) {
            this.f3599d.setTranslationY(0.0f);
            float f10 = -this.f3599d.getHeight();
            if (z8) {
                this.f3599d.getLocationInWindow(new int[]{0, 0});
                f10 -= r13[1];
            }
            this.f3599d.setTranslationY(f10);
            l.k kVar4 = new l.k();
            c1 a11 = t0.a(this.f3599d);
            a11.e(0.0f);
            View view3 = (View) a11.f7146a.get();
            if (view3 != null) {
                b1.a(view3.animate(), bVar != null ? new a5.b(bVar, i9, view3) : null);
            }
            boolean z13 = kVar4.f5735e;
            ArrayList arrayList2 = kVar4.f5731a;
            if (!z13) {
                arrayList2.add(a11);
            }
            if (this.f3609o && view != null) {
                view.setTranslationY(f10);
                c1 a12 = t0.a(view);
                a12.e(0.0f);
                if (!kVar4.f5735e) {
                    arrayList2.add(a12);
                }
            }
            boolean z14 = kVar4.f5735e;
            if (!z14) {
                kVar4.f5733c = f3595z;
            }
            if (!z14) {
                kVar4.f5732b = 250L;
            }
            if (!z14) {
                kVar4.f5734d = n0Var2;
            }
            this.f3613s = kVar4;
            kVar4.b();
        } else {
            this.f3599d.setAlpha(1.0f);
            this.f3599d.setTranslationY(0.0f);
            if (this.f3609o && view != null) {
                view.setTranslationY(0.0f);
            }
            n0Var2.a();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f3598c;
        if (actionBarOverlayLayout != null) {
            WeakHashMap weakHashMap = t0.f7209a;
            n0.g0.c(actionBarOverlayLayout);
        }
    }

    public p0(Dialog dialog) {
        new ArrayList();
        this.f3607m = new ArrayList();
        this.f3608n = 0;
        this.f3609o = true;
        this.f3612r = true;
        this.f3616v = new n0(this, 0);
        this.f3617w = new n0(this, 1);
        this.f3618x = new a0.b(this, 23);
        c(dialog.getWindow().getDecorView());
    }
}
