package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import d1.k0;
import g.p0;
import java.util.WeakHashMap;
import l.k;
import m.m;
import m.y;
import n.e;
import n.j;
import n.o1;
import n.t3;
import n.y3;
import n0.a2;
import n0.c0;
import n0.g0;
import n0.i0;
import n0.p;
import n0.p1;
import n0.q;
import n0.q1;
import n0.r1;
import n0.t0;
import n0.x1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
@SuppressLint({"UnknownNullness"})
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements p, q {
    public static final int[] J = {2130968579, R.attr.windowContentOverlay};
    public a2 A;
    public a2 B;
    public n.d C;
    public OverScroller D;
    public ViewPropertyAnimator E;
    public final b5.a F;
    public final n.c G;
    public final n.c H;
    public final k0 I;

    /* renamed from: i, reason: collision with root package name */
    public int f420i;

    /* renamed from: j, reason: collision with root package name */
    public int f421j;

    /* renamed from: k, reason: collision with root package name */
    public ContentFrameLayout f422k;

    /* renamed from: l, reason: collision with root package name */
    public ActionBarContainer f423l;

    /* renamed from: m, reason: collision with root package name */
    public o1 f424m;

    /* renamed from: n, reason: collision with root package name */
    public Drawable f425n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f426o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f427p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f428q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f429r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f430s;

    /* renamed from: t, reason: collision with root package name */
    public int f431t;

    /* renamed from: u, reason: collision with root package name */
    public int f432u;

    /* renamed from: v, reason: collision with root package name */
    public final Rect f433v;

    /* renamed from: w, reason: collision with root package name */
    public final Rect f434w;

    /* renamed from: x, reason: collision with root package name */
    public final Rect f435x;

    /* renamed from: y, reason: collision with root package name */
    public a2 f436y;

    /* renamed from: z, reason: collision with root package name */
    public a2 f437z;

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f421j = 0;
        this.f433v = new Rect();
        this.f434w = new Rect();
        this.f435x = new Rect();
        new Rect();
        new Rect();
        new Rect();
        new Rect();
        a2 a2Var = a2.f7138b;
        this.f436y = a2Var;
        this.f437z = a2Var;
        this.A = a2Var;
        this.B = a2Var;
        this.F = new b5.a(this, 1);
        this.G = new n.c(this, 0);
        this.H = new n.c(this, 1);
        i(context);
        this.I = new k0();
    }

    public static boolean g(View view, Rect rect, boolean z8) {
        boolean z9;
        e eVar = (e) view.getLayoutParams();
        int i9 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin;
        int i10 = rect.left;
        if (i9 != i10) {
            ((ViewGroup.MarginLayoutParams) eVar).leftMargin = i10;
            z9 = true;
        } else {
            z9 = false;
        }
        int i11 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
        int i12 = rect.top;
        if (i11 != i12) {
            ((ViewGroup.MarginLayoutParams) eVar).topMargin = i12;
            z9 = true;
        }
        int i13 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
        int i14 = rect.right;
        if (i13 != i14) {
            ((ViewGroup.MarginLayoutParams) eVar).rightMargin = i14;
            z9 = true;
        }
        if (z8) {
            int i15 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
            int i16 = rect.bottom;
            if (i15 != i16) {
                ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = i16;
                return true;
            }
        }
        return z9;
    }

    @Override // n0.p
    public final void a(View view, View view2, int i9, int i10) {
        if (i10 == 0) {
            onNestedScrollAccepted(view, view2, i9);
        }
    }

    @Override // n0.p
    public final void b(View view, int i9) {
        if (i9 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // n0.q
    public final void d(View view, int i9, int i10, int i11, int i12, int i13, int[] iArr) {
        e(view, i9, i10, i11, i12, i13);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i9;
        super.draw(canvas);
        if (this.f425n == null || this.f426o) {
            return;
        }
        if (this.f423l.getVisibility() == 0) {
            i9 = (int) (this.f423l.getTranslationY() + this.f423l.getBottom() + 0.5f);
        } else {
            i9 = 0;
        }
        this.f425n.setBounds(0, i9, getWidth(), this.f425n.getIntrinsicHeight() + i9);
        this.f425n.draw(canvas);
    }

    @Override // n0.p
    public final void e(View view, int i9, int i10, int i11, int i12, int i13) {
        if (i13 == 0) {
            onNestedScroll(view, i9, i10, i11, i12);
        }
    }

    @Override // n0.p
    public final boolean f(View view, View view2, int i9, int i10) {
        return i10 == 0 && onStartNestedScroll(view, view2, i9);
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f423l;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        k0 k0Var = this.I;
        return k0Var.f2493b | k0Var.f2492a;
    }

    public CharSequence getTitle() {
        k();
        return ((y3) this.f424m).f7109a.getTitle();
    }

    public final void h() {
        removeCallbacks(this.G);
        removeCallbacks(this.H);
        ViewPropertyAnimator viewPropertyAnimator = this.E;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final void i(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(J);
        this.f420i = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f425n = drawable;
        setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        this.f426o = context.getApplicationInfo().targetSdkVersion < 19;
        this.D = new OverScroller(context);
    }

    public final void j(int i9) {
        k();
        if (i9 == 2) {
            ((y3) this.f424m).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else if (i9 == 5) {
            ((y3) this.f424m).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else {
            if (i9 != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    public final void k() {
        o1 wrapper;
        if (this.f422k == null) {
            this.f422k = (ContentFrameLayout) findViewById(2131361842);
            this.f423l = (ActionBarContainer) findViewById(2131361843);
            KeyEvent.Callback findViewById = findViewById(2131361841);
            if (findViewById instanceof o1) {
                wrapper = (o1) findViewById;
            } else {
                if (!(findViewById instanceof Toolbar)) {
                    m7.c.p("Can't make a decor toolbar out of ".concat(findViewById.getClass().getSimpleName()));
                    return;
                }
                wrapper = ((Toolbar) findViewById).getWrapper();
            }
            this.f424m = wrapper;
        }
    }

    public final void l(Menu menu, y yVar) {
        k();
        y3 y3Var = (y3) this.f424m;
        Toolbar toolbar = y3Var.f7109a;
        if (y3Var.f7120m == null) {
            y3Var.f7120m = new j(toolbar.getContext());
        }
        j jVar = y3Var.f7120m;
        jVar.f6908m = yVar;
        m mVar = (m) menu;
        if (mVar == null && toolbar.f499i == null) {
            return;
        }
        toolbar.f();
        m mVar2 = toolbar.f499i.f438x;
        if (mVar2 == mVar) {
            return;
        }
        if (mVar2 != null) {
            mVar2.r(toolbar.T);
            mVar2.r(toolbar.U);
        }
        if (toolbar.U == null) {
            toolbar.U = new t3(toolbar);
        }
        jVar.f6920y = true;
        Context context = toolbar.f508r;
        if (mVar != null) {
            mVar.b(jVar, context);
            mVar.b(toolbar.U, toolbar.f508r);
        } else {
            jVar.g(context, null);
            toolbar.U.g(toolbar.f508r, null);
            jVar.d();
            toolbar.U.d();
        }
        toolbar.f499i.setPopupTheme(toolbar.f509s);
        toolbar.f499i.setPresenter(jVar);
        toolbar.T = jVar;
        toolbar.u();
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        k();
        a2 g9 = a2.g(this, windowInsets);
        boolean g10 = g(this.f423l, new Rect(g9.b(), g9.d(), g9.c(), g9.a()), false);
        WeakHashMap weakHashMap = t0.f7209a;
        Rect rect = this.f433v;
        i0.b(this, g9, rect);
        int i9 = rect.left;
        int i10 = rect.top;
        int i11 = rect.right;
        int i12 = rect.bottom;
        x1 x1Var = g9.f7139a;
        a2 l4 = x1Var.l(i9, i10, i11, i12);
        this.f436y = l4;
        boolean z8 = true;
        if (!this.f437z.equals(l4)) {
            this.f437z = this.f436y;
            g10 = true;
        }
        Rect rect2 = this.f434w;
        if (rect2.equals(rect)) {
            z8 = g10;
        } else {
            rect2.set(rect);
        }
        if (z8) {
            requestLayout();
        }
        return x1Var.a().f7139a.c().f7139a.b().f();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        i(getContext());
        WeakHashMap weakHashMap = t0.f7209a;
        g0.c(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i14 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + paddingLeft;
                int i15 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + paddingTop;
                childAt.layout(i14, i15, measuredWidth + i14, measuredHeight + i15);
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i9, int i10) {
        int measuredHeight;
        k();
        measureChildWithMargins(this.f423l, i9, 0, i10, 0);
        e eVar = (e) this.f423l.getLayoutParams();
        int max = Math.max(0, this.f423l.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin);
        int max2 = Math.max(0, this.f423l.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f423l.getMeasuredState());
        WeakHashMap weakHashMap = t0.f7209a;
        boolean z8 = (c0.g(this) & 256) != 0;
        if (z8) {
            measuredHeight = this.f420i;
            if (this.f428q && this.f423l.getTabContainer() != null) {
                measuredHeight += this.f420i;
            }
        } else {
            measuredHeight = this.f423l.getVisibility() != 8 ? this.f423l.getMeasuredHeight() : 0;
        }
        Rect rect = this.f433v;
        Rect rect2 = this.f435x;
        rect2.set(rect);
        a2 a2Var = this.f436y;
        this.A = a2Var;
        if (this.f427p || z8) {
            f0.c b9 = f0.c.b(a2Var.b(), this.A.d() + measuredHeight, this.A.c(), this.A.a());
            a2 a2Var2 = this.A;
            int i11 = Build.VERSION.SDK_INT;
            r1 q1Var = i11 >= 30 ? new q1(a2Var2) : i11 >= 29 ? new p1(a2Var2) : new n0.o1(a2Var2);
            q1Var.g(b9);
            this.A = q1Var.b();
        } else {
            rect2.top += measuredHeight;
            rect2.bottom = rect2.bottom;
            this.A = a2Var.f7139a.l(0, measuredHeight, 0, 0);
        }
        g(this.f422k, rect2, true);
        if (!this.B.equals(this.A)) {
            a2 a2Var3 = this.A;
            this.B = a2Var3;
            ContentFrameLayout contentFrameLayout = this.f422k;
            WindowInsets f9 = a2Var3.f();
            if (f9 != null) {
                WindowInsets a9 = g0.a(contentFrameLayout, f9);
                if (!a9.equals(f9)) {
                    a2.g(contentFrameLayout, a9);
                }
            }
        }
        measureChildWithMargins(this.f422k, i9, 0, i10, 0);
        e eVar2 = (e) this.f422k.getLayoutParams();
        int max3 = Math.max(max, this.f422k.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar2).leftMargin + ((ViewGroup.MarginLayoutParams) eVar2).rightMargin);
        int max4 = Math.max(max2, this.f422k.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f422k.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + max3, getSuggestedMinimumWidth()), i9, combineMeasuredStates2), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + max4, getSuggestedMinimumHeight()), i10, combineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f9, float f10, boolean z8) {
        if (!this.f429r || !z8) {
            return false;
        }
        this.D.fling(0, 0, 0, (int) f10, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.D.getFinalY() > this.f423l.getHeight()) {
            h();
            this.H.run();
        } else {
            h();
            this.G.run();
        }
        this.f430s = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f9, float f10) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i9, int i10, int i11, int i12) {
        int i13 = this.f431t + i10;
        this.f431t = i13;
        setActionBarHideOffset(i13);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i9) {
        p0 p0Var;
        k kVar;
        this.I.f2492a = i9;
        this.f431t = getActionBarHideOffset();
        h();
        n.d dVar = this.C;
        if (dVar == null || (kVar = (p0Var = (p0) dVar).f3613s) == null) {
            return;
        }
        kVar.a();
        p0Var.f3613s = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i9) {
        if ((i9 & 2) == 0 || this.f423l.getVisibility() != 0) {
            return false;
        }
        return this.f429r;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        if (!this.f429r || this.f430s) {
            return;
        }
        if (this.f431t <= this.f423l.getHeight()) {
            h();
            postDelayed(this.G, 600L);
        } else {
            h();
            postDelayed(this.H, 600L);
        }
    }

    @Override // android.view.View
    public final void onWindowSystemUiVisibilityChanged(int i9) {
        super.onWindowSystemUiVisibilityChanged(i9);
        k();
        int i10 = this.f432u ^ i9;
        this.f432u = i9;
        boolean z8 = (i9 & 4) == 0;
        boolean z9 = (i9 & 256) != 0;
        n.d dVar = this.C;
        if (dVar != null) {
            p0 p0Var = (p0) dVar;
            p0Var.f3609o = !z9;
            if (z8 || !z9) {
                if (p0Var.f3610p) {
                    p0Var.f3610p = false;
                    p0Var.f(true);
                }
            } else if (!p0Var.f3610p) {
                p0Var.f3610p = true;
                p0Var.f(true);
            }
        }
        if ((i10 & 256) == 0 || this.C == null) {
            return;
        }
        WeakHashMap weakHashMap = t0.f7209a;
        g0.c(this);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i9) {
        super.onWindowVisibilityChanged(i9);
        this.f421j = i9;
        n.d dVar = this.C;
        if (dVar != null) {
            ((p0) dVar).f3608n = i9;
        }
    }

    public void setActionBarHideOffset(int i9) {
        h();
        this.f423l.setTranslationY(-Math.max(0, Math.min(i9, this.f423l.getHeight())));
    }

    public void setActionBarVisibilityCallback(n.d dVar) {
        this.C = dVar;
        if (getWindowToken() != null) {
            ((p0) this.C).f3608n = this.f421j;
            int i9 = this.f432u;
            if (i9 != 0) {
                onWindowSystemUiVisibilityChanged(i9);
                WeakHashMap weakHashMap = t0.f7209a;
                g0.c(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z8) {
        this.f428q = z8;
    }

    public void setHideOnContentScrollEnabled(boolean z8) {
        if (z8 != this.f429r) {
            this.f429r = z8;
            if (z8) {
                return;
            }
            h();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i9) {
        k();
        y3 y3Var = (y3) this.f424m;
        y3Var.f7112d = i9 != 0 ? android.support.v4.media.session.b.I(y3Var.f7109a.getContext(), i9) : null;
        y3Var.c();
    }

    public void setLogo(int i9) {
        k();
        y3 y3Var = (y3) this.f424m;
        y3Var.f7113e = i9 != 0 ? android.support.v4.media.session.b.I(y3Var.f7109a.getContext(), i9) : null;
        y3Var.c();
    }

    public void setOverlayMode(boolean z8) {
        this.f427p = z8;
        this.f426o = z8 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setWindowCallback(Window.Callback callback) {
        k();
        ((y3) this.f424m).f7118k = callback;
    }

    public void setWindowTitle(CharSequence charSequence) {
        k();
        y3 y3Var = (y3) this.f424m;
        if (y3Var.f7115g) {
            return;
        }
        Toolbar toolbar = y3Var.f7109a;
        y3Var.h = charSequence;
        if ((y3Var.f7110b & 8) != 0) {
            toolbar.setTitle(charSequence);
            if (y3Var.f7115g) {
                t0.q(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        k();
        y3 y3Var = (y3) this.f424m;
        y3Var.f7112d = drawable;
        y3Var.c();
    }

    public void setShowingForActionMode(boolean z8) {
    }

    public void setUiOptions(int i9) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i9, int i10, int[] iArr) {
    }

    @Override // n0.p
    public final void c(View view, int i9, int i10, int[] iArr, int i11) {
    }
}
