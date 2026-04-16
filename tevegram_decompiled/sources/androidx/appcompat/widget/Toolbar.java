package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.fragment.app.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import l.i;
import m.m;
import m.o;
import n.e1;
import n.f4;
import n.j;
import n.o1;
import n.q3;
import n.r3;
import n.s3;
import n.t3;
import n.u3;
import n.v2;
import n.v3;
import n.w3;
import n.x;
import n.x3;
import n.y;
import n.y3;
import n0.d0;
import n0.f0;
import n0.l;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class Toolbar extends ViewGroup {
    public int A;
    public v2 B;
    public int C;
    public int D;
    public final int E;
    public CharSequence F;
    public CharSequence G;
    public ColorStateList H;
    public ColorStateList I;
    public boolean J;
    public boolean K;
    public final ArrayList L;
    public final ArrayList M;
    public final int[] N;
    public final m1.b O;
    public ArrayList P;
    public v3 Q;
    public final r3 R;
    public y3 S;
    public j T;
    public t3 U;
    public boolean V;
    public OnBackInvokedCallback W;

    /* renamed from: a0, reason: collision with root package name */
    public OnBackInvokedDispatcher f496a0;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f497b0;

    /* renamed from: c0, reason: collision with root package name */
    public final androidx.activity.j f498c0;

    /* renamed from: i, reason: collision with root package name */
    public ActionMenuView f499i;

    /* renamed from: j, reason: collision with root package name */
    public e1 f500j;

    /* renamed from: k, reason: collision with root package name */
    public e1 f501k;

    /* renamed from: l, reason: collision with root package name */
    public x f502l;

    /* renamed from: m, reason: collision with root package name */
    public y f503m;

    /* renamed from: n, reason: collision with root package name */
    public final Drawable f504n;

    /* renamed from: o, reason: collision with root package name */
    public final CharSequence f505o;

    /* renamed from: p, reason: collision with root package name */
    public x f506p;

    /* renamed from: q, reason: collision with root package name */
    public View f507q;

    /* renamed from: r, reason: collision with root package name */
    public Context f508r;

    /* renamed from: s, reason: collision with root package name */
    public int f509s;

    /* renamed from: t, reason: collision with root package name */
    public int f510t;

    /* renamed from: u, reason: collision with root package name */
    public int f511u;

    /* renamed from: v, reason: collision with root package name */
    public final int f512v;

    /* renamed from: w, reason: collision with root package name */
    public final int f513w;

    /* renamed from: x, reason: collision with root package name */
    public int f514x;

    /* renamed from: y, reason: collision with root package name */
    public int f515y;

    /* renamed from: z, reason: collision with root package name */
    public int f516z;

    public Toolbar(Context context, AttributeSet attributeSet, int i9) {
        super(context, attributeSet, 2130969706);
        this.E = 8388627;
        this.L = new ArrayList();
        this.M = new ArrayList();
        this.N = new int[2];
        this.O = new m1.b(new q3(this, 1));
        this.P = new ArrayList();
        this.R = new r3(this);
        this.f498c0 = new androidx.activity.j(this, 11);
        Context context2 = getContext();
        int[] iArr = f.a.f3189y;
        g g02 = g.g0(context2, attributeSet, iArr, 2130969706);
        t0.o(this, context, iArr, attributeSet, (TypedArray) g02.f729k, 2130969706);
        TypedArray typedArray = (TypedArray) g02.f729k;
        this.f510t = typedArray.getResourceId(28, 0);
        this.f511u = typedArray.getResourceId(19, 0);
        this.E = typedArray.getInteger(0, 8388627);
        this.f512v = typedArray.getInteger(2, 48);
        int dimensionPixelOffset = typedArray.getDimensionPixelOffset(22, 0);
        dimensionPixelOffset = typedArray.hasValue(27) ? typedArray.getDimensionPixelOffset(27, dimensionPixelOffset) : dimensionPixelOffset;
        this.A = dimensionPixelOffset;
        this.f516z = dimensionPixelOffset;
        this.f515y = dimensionPixelOffset;
        this.f514x = dimensionPixelOffset;
        int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(25, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.f514x = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = typedArray.getDimensionPixelOffset(24, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.f515y = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = typedArray.getDimensionPixelOffset(26, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.f516z = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = typedArray.getDimensionPixelOffset(23, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.A = dimensionPixelOffset5;
        }
        this.f513w = typedArray.getDimensionPixelSize(13, -1);
        int dimensionPixelOffset6 = typedArray.getDimensionPixelOffset(9, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = typedArray.getDimensionPixelOffset(5, Integer.MIN_VALUE);
        int dimensionPixelSize = typedArray.getDimensionPixelSize(7, 0);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(8, 0);
        d();
        v2 v2Var = this.B;
        v2Var.h = false;
        if (dimensionPixelSize != Integer.MIN_VALUE) {
            v2Var.f7077e = dimensionPixelSize;
            v2Var.f7073a = dimensionPixelSize;
        }
        if (dimensionPixelSize2 != Integer.MIN_VALUE) {
            v2Var.f7078f = dimensionPixelSize2;
            v2Var.f7074b = dimensionPixelSize2;
        }
        if (dimensionPixelOffset6 != Integer.MIN_VALUE || dimensionPixelOffset7 != Integer.MIN_VALUE) {
            v2Var.a(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.C = typedArray.getDimensionPixelOffset(10, Integer.MIN_VALUE);
        this.D = typedArray.getDimensionPixelOffset(6, Integer.MIN_VALUE);
        this.f504n = g02.Q(4);
        this.f505o = typedArray.getText(3);
        CharSequence text = typedArray.getText(21);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = typedArray.getText(18);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.f508r = getContext();
        setPopupTheme(typedArray.getResourceId(17, 0));
        Drawable Q = g02.Q(16);
        if (Q != null) {
            setNavigationIcon(Q);
        }
        CharSequence text3 = typedArray.getText(15);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable Q2 = g02.Q(11);
        if (Q2 != null) {
            setLogo(Q2);
        }
        CharSequence text4 = typedArray.getText(12);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        if (typedArray.hasValue(29)) {
            setTitleTextColor(g02.O(29));
        }
        if (typedArray.hasValue(20)) {
            setSubtitleTextColor(g02.O(20));
        }
        if (typedArray.hasValue(14)) {
            m(typedArray.getResourceId(14, 0));
        }
        g02.i0();
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i9 = 0; i9 < menu.size(); i9++) {
            arrayList.add(menu.getItem(i9));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new i(getContext());
    }

    public static u3 h() {
        u3 u3Var = new u3(-2, -2);
        u3Var.f7062b = 0;
        u3Var.f7061a = 8388627;
        return u3Var;
    }

    public static u3 i(ViewGroup.LayoutParams layoutParams) {
        boolean z8 = layoutParams instanceof u3;
        if (z8) {
            u3 u3Var = (u3) layoutParams;
            u3 u3Var2 = new u3(u3Var);
            u3Var2.f7062b = 0;
            u3Var2.f7062b = u3Var.f7062b;
            return u3Var2;
        }
        if (z8) {
            u3 u3Var3 = new u3((u3) layoutParams);
            u3Var3.f7062b = 0;
            return u3Var3;
        }
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            u3 u3Var4 = new u3(layoutParams);
            u3Var4.f7062b = 0;
            return u3Var4;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        u3 u3Var5 = new u3(marginLayoutParams);
        u3Var5.f7062b = 0;
        ((ViewGroup.MarginLayoutParams) u3Var5).leftMargin = marginLayoutParams.leftMargin;
        ((ViewGroup.MarginLayoutParams) u3Var5).topMargin = marginLayoutParams.topMargin;
        ((ViewGroup.MarginLayoutParams) u3Var5).rightMargin = marginLayoutParams.rightMargin;
        ((ViewGroup.MarginLayoutParams) u3Var5).bottomMargin = marginLayoutParams.bottomMargin;
        return u3Var5;
    }

    public static int k(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return l.b(marginLayoutParams) + l.c(marginLayoutParams);
    }

    public static int l(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public final void a(int i9, ArrayList arrayList) {
        WeakHashMap weakHashMap = t0.f7209a;
        boolean z8 = d0.d(this) == 1;
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i9, d0.d(this));
        arrayList.clear();
        if (!z8) {
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getChildAt(i10);
                u3 u3Var = (u3) childAt.getLayoutParams();
                if (u3Var.f7062b == 0 && t(childAt)) {
                    int i11 = u3Var.f7061a;
                    WeakHashMap weakHashMap2 = t0.f7209a;
                    int d9 = d0.d(this);
                    int absoluteGravity2 = Gravity.getAbsoluteGravity(i11, d9) & 7;
                    if (absoluteGravity2 != 1 && absoluteGravity2 != 3 && absoluteGravity2 != 5) {
                        absoluteGravity2 = d9 == 1 ? 5 : 3;
                    }
                    if (absoluteGravity2 == absoluteGravity) {
                        arrayList.add(childAt);
                    }
                }
            }
            return;
        }
        for (int i12 = childCount - 1; i12 >= 0; i12--) {
            View childAt2 = getChildAt(i12);
            u3 u3Var2 = (u3) childAt2.getLayoutParams();
            if (u3Var2.f7062b == 0 && t(childAt2)) {
                int i13 = u3Var2.f7061a;
                WeakHashMap weakHashMap3 = t0.f7209a;
                int d10 = d0.d(this);
                int absoluteGravity3 = Gravity.getAbsoluteGravity(i13, d10) & 7;
                if (absoluteGravity3 != 1 && absoluteGravity3 != 3 && absoluteGravity3 != 5) {
                    absoluteGravity3 = d10 == 1 ? 5 : 3;
                }
                if (absoluteGravity3 == absoluteGravity) {
                    arrayList.add(childAt2);
                }
            }
        }
    }

    public final void b(View view, boolean z8) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        u3 h = layoutParams == null ? h() : !checkLayoutParams(layoutParams) ? i(layoutParams) : (u3) layoutParams;
        h.f7062b = 1;
        if (!z8 || this.f507q == null) {
            addView(view, h);
        } else {
            view.setLayoutParams(h);
            this.M.add(view);
        }
    }

    public final void c() {
        if (this.f506p == null) {
            x xVar = new x(getContext(), null, 2130969705);
            this.f506p = xVar;
            xVar.setImageDrawable(this.f504n);
            this.f506p.setContentDescription(this.f505o);
            u3 h = h();
            h.f7061a = (this.f512v & 112) | 8388611;
            h.f7062b = 2;
            this.f506p.setLayoutParams(h);
            this.f506p.setOnClickListener(new com.google.android.material.datepicker.l(this, 4));
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof u3);
    }

    public final void d() {
        if (this.B == null) {
            v2 v2Var = new v2();
            v2Var.f7073a = 0;
            v2Var.f7074b = 0;
            v2Var.f7075c = Integer.MIN_VALUE;
            v2Var.f7076d = Integer.MIN_VALUE;
            v2Var.f7077e = 0;
            v2Var.f7078f = 0;
            v2Var.f7079g = false;
            v2Var.h = false;
            this.B = v2Var;
        }
    }

    public final void e() {
        f();
        ActionMenuView actionMenuView = this.f499i;
        if (actionMenuView.f438x == null) {
            m mVar = (m) actionMenuView.getMenu();
            if (this.U == null) {
                this.U = new t3(this);
            }
            this.f499i.setExpandedActionViewsExclusive(true);
            mVar.b(this.U, this.f508r);
            u();
        }
    }

    public final void f() {
        if (this.f499i == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext(), null);
            this.f499i = actionMenuView;
            actionMenuView.setPopupTheme(this.f509s);
            this.f499i.setOnMenuItemClickListener(this.R);
            ActionMenuView actionMenuView2 = this.f499i;
            r3 r3Var = new r3(this);
            actionMenuView2.getClass();
            actionMenuView2.C = r3Var;
            u3 h = h();
            h.f7061a = (this.f512v & 112) | 8388613;
            this.f499i.setLayoutParams(h);
            b(this.f499i, false);
        }
    }

    public final void g() {
        if (this.f502l == null) {
            this.f502l = new x(getContext(), null, 2130969705);
            u3 h = h();
            h.f7061a = (this.f512v & 112) | 8388611;
            this.f502l.setLayoutParams(h);
        }
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return h();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        u3 u3Var = new u3(context, attributeSet);
        u3Var.f7061a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.a.f3167b);
        u3Var.f7061a = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
        u3Var.f7062b = 0;
        return u3Var;
    }

    public CharSequence getCollapseContentDescription() {
        x xVar = this.f506p;
        if (xVar != null) {
            return xVar.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        x xVar = this.f506p;
        if (xVar != null) {
            return xVar.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        v2 v2Var = this.B;
        if (v2Var != null) {
            return v2Var.f7079g ? v2Var.f7073a : v2Var.f7074b;
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i9 = this.D;
        return i9 != Integer.MIN_VALUE ? i9 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        v2 v2Var = this.B;
        if (v2Var != null) {
            return v2Var.f7073a;
        }
        return 0;
    }

    public int getContentInsetRight() {
        v2 v2Var = this.B;
        if (v2Var != null) {
            return v2Var.f7074b;
        }
        return 0;
    }

    public int getContentInsetStart() {
        v2 v2Var = this.B;
        if (v2Var != null) {
            return v2Var.f7079g ? v2Var.f7074b : v2Var.f7073a;
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i9 = this.C;
        return i9 != Integer.MIN_VALUE ? i9 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        m mVar;
        ActionMenuView actionMenuView = this.f499i;
        return (actionMenuView == null || (mVar = actionMenuView.f438x) == null || !mVar.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.D, 0));
    }

    public int getCurrentContentInsetLeft() {
        WeakHashMap weakHashMap = t0.f7209a;
        return d0.d(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        WeakHashMap weakHashMap = t0.f7209a;
        return d0.d(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.C, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        y yVar = this.f503m;
        if (yVar != null) {
            return yVar.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        y yVar = this.f503m;
        if (yVar != null) {
            return yVar.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        e();
        return this.f499i.getMenu();
    }

    public View getNavButtonView() {
        return this.f502l;
    }

    public CharSequence getNavigationContentDescription() {
        x xVar = this.f502l;
        if (xVar != null) {
            return xVar.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        x xVar = this.f502l;
        if (xVar != null) {
            return xVar.getDrawable();
        }
        return null;
    }

    public j getOuterActionMenuPresenter() {
        return this.T;
    }

    public Drawable getOverflowIcon() {
        e();
        return this.f499i.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.f508r;
    }

    public int getPopupTheme() {
        return this.f509s;
    }

    public CharSequence getSubtitle() {
        return this.G;
    }

    public final TextView getSubtitleTextView() {
        return this.f501k;
    }

    public CharSequence getTitle() {
        return this.F;
    }

    public int getTitleMarginBottom() {
        return this.A;
    }

    public int getTitleMarginEnd() {
        return this.f515y;
    }

    public int getTitleMarginStart() {
        return this.f514x;
    }

    public int getTitleMarginTop() {
        return this.f516z;
    }

    public final TextView getTitleTextView() {
        return this.f500j;
    }

    public o1 getWrapper() {
        Drawable drawable;
        if (this.S == null) {
            y3 y3Var = new y3();
            y3Var.f7121n = 0;
            y3Var.f7109a = this;
            y3Var.h = getTitle();
            y3Var.f7116i = getSubtitle();
            y3Var.f7115g = y3Var.h != null;
            y3Var.f7114f = getNavigationIcon();
            g g02 = g.g0(getContext(), null, f.a.f3166a, 2130968581);
            TypedArray typedArray = (TypedArray) g02.f729k;
            y3Var.f7122o = g02.Q(15);
            CharSequence text = typedArray.getText(27);
            if (!TextUtils.isEmpty(text)) {
                y3Var.f7115g = true;
                y3Var.h = text;
                if ((y3Var.f7110b & 8) != 0) {
                    setTitle(text);
                    if (y3Var.f7115g) {
                        t0.q(getRootView(), text);
                    }
                }
            }
            CharSequence text2 = typedArray.getText(25);
            if (!TextUtils.isEmpty(text2)) {
                y3Var.f7116i = text2;
                if ((y3Var.f7110b & 8) != 0) {
                    setSubtitle(text2);
                }
            }
            Drawable Q = g02.Q(20);
            if (Q != null) {
                y3Var.f7113e = Q;
                y3Var.c();
            }
            Drawable Q2 = g02.Q(17);
            if (Q2 != null) {
                y3Var.f7112d = Q2;
                y3Var.c();
            }
            if (y3Var.f7114f == null && (drawable = y3Var.f7122o) != null) {
                y3Var.f7114f = drawable;
                if ((y3Var.f7110b & 4) != 0) {
                    setNavigationIcon(drawable);
                } else {
                    setNavigationIcon((Drawable) null);
                }
            }
            y3Var.a(typedArray.getInt(10, 0));
            int resourceId = typedArray.getResourceId(9, 0);
            if (resourceId != 0) {
                View inflate = LayoutInflater.from(getContext()).inflate(resourceId, (ViewGroup) this, false);
                View view = y3Var.f7111c;
                if (view != null && (y3Var.f7110b & 16) != 0) {
                    removeView(view);
                }
                y3Var.f7111c = inflate;
                if (inflate != null && (y3Var.f7110b & 16) != 0) {
                    addView(inflate);
                }
                y3Var.a(y3Var.f7110b | 16);
            }
            int layoutDimension = typedArray.getLayoutDimension(13, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                layoutParams.height = layoutDimension;
                setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = typedArray.getDimensionPixelOffset(7, -1);
            int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(3, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                int max = Math.max(dimensionPixelOffset, 0);
                int max2 = Math.max(dimensionPixelOffset2, 0);
                d();
                this.B.a(max, max2);
            }
            int resourceId2 = typedArray.getResourceId(28, 0);
            if (resourceId2 != 0) {
                Context context = getContext();
                this.f510t = resourceId2;
                e1 e1Var = this.f500j;
                if (e1Var != null) {
                    e1Var.setTextAppearance(context, resourceId2);
                }
            }
            int resourceId3 = typedArray.getResourceId(26, 0);
            if (resourceId3 != 0) {
                Context context2 = getContext();
                this.f511u = resourceId3;
                e1 e1Var2 = this.f501k;
                if (e1Var2 != null) {
                    e1Var2.setTextAppearance(context2, resourceId3);
                }
            }
            int resourceId4 = typedArray.getResourceId(22, 0);
            if (resourceId4 != 0) {
                setPopupTheme(resourceId4);
            }
            g02.i0();
            if (2131951617 != y3Var.f7121n) {
                y3Var.f7121n = 2131951617;
                if (TextUtils.isEmpty(getNavigationContentDescription())) {
                    int i9 = y3Var.f7121n;
                    y3Var.f7117j = i9 != 0 ? getContext().getString(i9) : null;
                    y3Var.b();
                }
            }
            y3Var.f7117j = getNavigationContentDescription();
            setNavigationOnClickListener(new x3(y3Var));
            this.S = y3Var;
        }
        return this.S;
    }

    public final int j(View view, int i9) {
        u3 u3Var = (u3) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i10 = i9 > 0 ? (measuredHeight - i9) / 2 : 0;
        int i11 = u3Var.f7061a & 112;
        if (i11 != 16 && i11 != 48 && i11 != 80) {
            i11 = this.E & 112;
        }
        if (i11 == 48) {
            return getPaddingTop() - i10;
        }
        if (i11 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) u3Var).bottomMargin) - i10;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i12 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i13 = ((ViewGroup.MarginLayoutParams) u3Var).topMargin;
        if (i12 < i13) {
            i12 = i13;
        } else {
            int i14 = (((height - paddingBottom) - measuredHeight) - i12) - paddingTop;
            int i15 = ((ViewGroup.MarginLayoutParams) u3Var).bottomMargin;
            if (i14 < i15) {
                i12 = Math.max(0, i12 - (i15 - i14));
            }
        }
        return paddingTop + i12;
    }

    public void m(int i9) {
        getMenuInflater().inflate(i9, getMenu());
    }

    public final void n() {
        ArrayList arrayList = this.P;
        int size = arrayList.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList.get(i9);
            i9++;
            getMenu().removeItem(((MenuItem) obj).getItemId());
        }
        getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        getMenuInflater();
        Iterator it = ((CopyOnWriteArrayList) this.O.f6511k).iterator();
        if (it.hasNext()) {
            throw androidx.activity.g.l(it);
        }
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.P = currentMenuItems2;
    }

    public final boolean o(View view) {
        return view.getParent() == this || this.M.contains(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        u();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f498c0);
        u();
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.K = false;
        }
        if (!this.K) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.K = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.K = false;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0285 A[LOOP:0: B:44:0x0283->B:45:0x0285, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x029d A[LOOP:1: B:48:0x029b->B:49:0x029d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x02bc A[LOOP:2: B:52:0x02ba->B:53:0x02bc, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x030f A[LOOP:3: B:61:0x030d->B:62:0x030f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x020e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 800
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public final void onMeasure(int i9, int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        boolean a9 = f4.a(this);
        int i18 = !a9 ? 1 : 0;
        int i19 = 0;
        if (t(this.f502l)) {
            s(this.f502l, i9, 0, i10, this.f513w);
            i11 = k(this.f502l) + this.f502l.getMeasuredWidth();
            i12 = Math.max(0, l(this.f502l) + this.f502l.getMeasuredHeight());
            i13 = View.combineMeasuredStates(0, this.f502l.getMeasuredState());
        } else {
            i11 = 0;
            i12 = 0;
            i13 = 0;
        }
        if (t(this.f506p)) {
            s(this.f506p, i9, 0, i10, this.f513w);
            i11 = k(this.f506p) + this.f506p.getMeasuredWidth();
            i12 = Math.max(i12, l(this.f506p) + this.f506p.getMeasuredHeight());
            i13 = View.combineMeasuredStates(i13, this.f506p.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = Math.max(currentContentInsetStart, i11);
        int max2 = Math.max(0, currentContentInsetStart - i11);
        int[] iArr = this.N;
        iArr[a9 ? 1 : 0] = max2;
        if (t(this.f499i)) {
            s(this.f499i, i9, max, i10, this.f513w);
            i14 = k(this.f499i) + this.f499i.getMeasuredWidth();
            i12 = Math.max(i12, l(this.f499i) + this.f499i.getMeasuredHeight());
            i13 = View.combineMeasuredStates(i13, this.f499i.getMeasuredState());
        } else {
            i14 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max3 = max + Math.max(currentContentInsetEnd, i14);
        iArr[i18] = Math.max(0, currentContentInsetEnd - i14);
        if (t(this.f507q)) {
            max3 += r(this.f507q, i9, max3, i10, 0, iArr);
            i12 = Math.max(i12, l(this.f507q) + this.f507q.getMeasuredHeight());
            i13 = View.combineMeasuredStates(i13, this.f507q.getMeasuredState());
        }
        if (t(this.f503m)) {
            max3 += r(this.f503m, i9, max3, i10, 0, iArr);
            i12 = Math.max(i12, l(this.f503m) + this.f503m.getMeasuredHeight());
            i13 = View.combineMeasuredStates(i13, this.f503m.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i20 = 0; i20 < childCount; i20++) {
            View childAt = getChildAt(i20);
            if (((u3) childAt.getLayoutParams()).f7062b == 0 && t(childAt)) {
                max3 += r(childAt, i9, max3, i10, 0, iArr);
                int max4 = Math.max(i12, l(childAt) + childAt.getMeasuredHeight());
                i13 = View.combineMeasuredStates(i13, childAt.getMeasuredState());
                i12 = max4;
            } else {
                max3 = max3;
            }
        }
        int i21 = max3;
        int i22 = this.f516z + this.A;
        int i23 = this.f514x + this.f515y;
        if (t(this.f500j)) {
            r(this.f500j, i9, i21 + i23, i10, i22, iArr);
            int k3 = k(this.f500j) + this.f500j.getMeasuredWidth();
            i17 = l(this.f500j) + this.f500j.getMeasuredHeight();
            i15 = View.combineMeasuredStates(i13, this.f500j.getMeasuredState());
            i16 = k3;
        } else {
            i15 = i13;
            i16 = 0;
            i17 = 0;
        }
        if (t(this.f501k)) {
            i16 = Math.max(i16, r(this.f501k, i9, i21 + i23, i10, i22 + i17, iArr));
            i17 += l(this.f501k) + this.f501k.getMeasuredHeight();
            i15 = View.combineMeasuredStates(i15, this.f501k.getMeasuredState());
        }
        int max5 = Math.max(i12, i17);
        int paddingRight = getPaddingRight() + getPaddingLeft() + i21 + i16;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + max5;
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i9, (-16777216) & i15);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i10, i15 << 16);
        if (this.V) {
            int childCount2 = getChildCount();
            for (int i24 = 0; i24 < childCount2; i24++) {
                View childAt2 = getChildAt(i24);
                if (!t(childAt2) || childAt2.getMeasuredWidth() <= 0 || childAt2.getMeasuredHeight() <= 0) {
                }
            }
            setMeasuredDimension(resolveSizeAndState, i19);
        }
        i19 = resolveSizeAndState2;
        setMeasuredDimension(resolveSizeAndState, i19);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof w3)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        w3 w3Var = (w3) parcelable;
        super.onRestoreInstanceState(w3Var.f8991i);
        ActionMenuView actionMenuView = this.f499i;
        m mVar = actionMenuView != null ? actionMenuView.f438x : null;
        int i9 = w3Var.f7083k;
        if (i9 != 0 && this.U != null && mVar != null && (findItem = mVar.findItem(i9)) != null) {
            findItem.expandActionView();
        }
        if (w3Var.f7084l) {
            androidx.activity.j jVar = this.f498c0;
            removeCallbacks(jVar);
            post(jVar);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i9) {
        super.onRtlPropertiesChanged(i9);
        d();
        v2 v2Var = this.B;
        boolean z8 = i9 == 1;
        if (z8 == v2Var.f7079g) {
            return;
        }
        v2Var.f7079g = z8;
        if (!v2Var.h) {
            v2Var.f7073a = v2Var.f7077e;
            v2Var.f7074b = v2Var.f7078f;
            return;
        }
        if (z8) {
            int i10 = v2Var.f7076d;
            if (i10 == Integer.MIN_VALUE) {
                i10 = v2Var.f7077e;
            }
            v2Var.f7073a = i10;
            int i11 = v2Var.f7075c;
            if (i11 == Integer.MIN_VALUE) {
                i11 = v2Var.f7078f;
            }
            v2Var.f7074b = i11;
            return;
        }
        int i12 = v2Var.f7075c;
        if (i12 == Integer.MIN_VALUE) {
            i12 = v2Var.f7077e;
        }
        v2Var.f7073a = i12;
        int i13 = v2Var.f7076d;
        if (i13 == Integer.MIN_VALUE) {
            i13 = v2Var.f7078f;
        }
        v2Var.f7074b = i13;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        j jVar;
        o oVar;
        w3 w3Var = new w3(super.onSaveInstanceState());
        t3 t3Var = this.U;
        if (t3Var != null && (oVar = t3Var.f7058j) != null) {
            w3Var.f7083k = oVar.f6455i;
        }
        ActionMenuView actionMenuView = this.f499i;
        w3Var.f7084l = (actionMenuView == null || (jVar = actionMenuView.B) == null || !jVar.e()) ? false : true;
        return w3Var;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.J = false;
        }
        if (!this.J) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.J = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.J = false;
        return true;
    }

    public final int p(View view, int i9, int i10, int[] iArr) {
        u3 u3Var = (u3) view.getLayoutParams();
        int i11 = ((ViewGroup.MarginLayoutParams) u3Var).leftMargin - iArr[0];
        int max = Math.max(0, i11) + i9;
        iArr[0] = Math.max(0, -i11);
        int j5 = j(view, i10);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, j5, max + measuredWidth, view.getMeasuredHeight() + j5);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) u3Var).rightMargin + max;
    }

    public final int q(View view, int i9, int i10, int[] iArr) {
        u3 u3Var = (u3) view.getLayoutParams();
        int i11 = ((ViewGroup.MarginLayoutParams) u3Var).rightMargin - iArr[1];
        int max = i9 - Math.max(0, i11);
        iArr[1] = Math.max(0, -i11);
        int j5 = j(view, i10);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, j5, max, view.getMeasuredHeight() + j5);
        return max - (measuredWidth + ((ViewGroup.MarginLayoutParams) u3Var).leftMargin);
    }

    public final int r(View view, int i9, int i10, int i11, int i12, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i13 = marginLayoutParams.leftMargin - iArr[0];
        int i14 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i14) + Math.max(0, i13);
        iArr[0] = Math.max(0, -i13);
        iArr[1] = Math.max(0, -i14);
        view.measure(ViewGroup.getChildMeasureSpec(i9, getPaddingRight() + getPaddingLeft() + max + i10, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i11, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i12, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    public final void s(View view, int i9, int i10, int i11, int i12) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i9, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i10, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i11, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i12 >= 0) {
            if (mode != 0) {
                i12 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i12);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public void setBackInvokedCallbackEnabled(boolean z8) {
        if (this.f497b0 != z8) {
            this.f497b0 = z8;
            u();
        }
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            c();
        }
        x xVar = this.f506p;
        if (xVar != null) {
            xVar.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            c();
            this.f506p.setImageDrawable(drawable);
        } else {
            x xVar = this.f506p;
            if (xVar != null) {
                xVar.setImageDrawable(this.f504n);
            }
        }
    }

    public void setCollapsible(boolean z8) {
        this.V = z8;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i9) {
        if (i9 < 0) {
            i9 = Integer.MIN_VALUE;
        }
        if (i9 != this.D) {
            this.D = i9;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i9) {
        if (i9 < 0) {
            i9 = Integer.MIN_VALUE;
        }
        if (i9 != this.C) {
            this.C = i9;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(Drawable drawable) {
        y yVar = this.f503m;
        if (drawable != null) {
            if (yVar == null) {
                this.f503m = new y(getContext(), null, 0);
            }
            if (!o(this.f503m)) {
                b(this.f503m, true);
            }
        } else if (yVar != null && o(yVar)) {
            removeView(this.f503m);
            this.M.remove(this.f503m);
        }
        y yVar2 = this.f503m;
        if (yVar2 != null) {
            yVar2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.f503m == null) {
            this.f503m = new y(getContext(), null, 0);
        }
        y yVar = this.f503m;
        if (yVar != null) {
            yVar.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        x xVar = this.f502l;
        if (xVar != null) {
            xVar.setContentDescription(charSequence);
            a.a.O(this.f502l, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            if (!o(this.f502l)) {
                b(this.f502l, true);
            }
        } else {
            x xVar = this.f502l;
            if (xVar != null && o(xVar)) {
                removeView(this.f502l);
                this.M.remove(this.f502l);
            }
        }
        x xVar2 = this.f502l;
        if (xVar2 != null) {
            xVar2.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        g();
        this.f502l.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(v3 v3Var) {
        this.Q = v3Var;
    }

    public void setOverflowIcon(Drawable drawable) {
        e();
        this.f499i.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i9) {
        if (this.f509s != i9) {
            this.f509s = i9;
            if (i9 == 0) {
                this.f508r = getContext();
            } else {
                this.f508r = new ContextThemeWrapper(getContext(), i9);
            }
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        boolean isEmpty = TextUtils.isEmpty(charSequence);
        e1 e1Var = this.f501k;
        if (!isEmpty) {
            if (e1Var == null) {
                Context context = getContext();
                e1 e1Var2 = new e1(context, null);
                this.f501k = e1Var2;
                e1Var2.setSingleLine();
                this.f501k.setEllipsize(TextUtils.TruncateAt.END);
                int i9 = this.f511u;
                if (i9 != 0) {
                    this.f501k.setTextAppearance(context, i9);
                }
                ColorStateList colorStateList = this.I;
                if (colorStateList != null) {
                    this.f501k.setTextColor(colorStateList);
                }
            }
            if (!o(this.f501k)) {
                b(this.f501k, true);
            }
        } else if (e1Var != null && o(e1Var)) {
            removeView(this.f501k);
            this.M.remove(this.f501k);
        }
        e1 e1Var3 = this.f501k;
        if (e1Var3 != null) {
            e1Var3.setText(charSequence);
        }
        this.G = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.I = colorStateList;
        e1 e1Var = this.f501k;
        if (e1Var != null) {
            e1Var.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        boolean isEmpty = TextUtils.isEmpty(charSequence);
        e1 e1Var = this.f500j;
        if (!isEmpty) {
            if (e1Var == null) {
                Context context = getContext();
                e1 e1Var2 = new e1(context, null);
                this.f500j = e1Var2;
                e1Var2.setSingleLine();
                this.f500j.setEllipsize(TextUtils.TruncateAt.END);
                int i9 = this.f510t;
                if (i9 != 0) {
                    this.f500j.setTextAppearance(context, i9);
                }
                ColorStateList colorStateList = this.H;
                if (colorStateList != null) {
                    this.f500j.setTextColor(colorStateList);
                }
            }
            if (!o(this.f500j)) {
                b(this.f500j, true);
            }
        } else if (e1Var != null && o(e1Var)) {
            removeView(this.f500j);
            this.M.remove(this.f500j);
        }
        e1 e1Var3 = this.f500j;
        if (e1Var3 != null) {
            e1Var3.setText(charSequence);
        }
        this.F = charSequence;
    }

    public void setTitleMarginBottom(int i9) {
        this.A = i9;
        requestLayout();
    }

    public void setTitleMarginEnd(int i9) {
        this.f515y = i9;
        requestLayout();
    }

    public void setTitleMarginStart(int i9) {
        this.f514x = i9;
        requestLayout();
    }

    public void setTitleMarginTop(int i9) {
        this.f516z = i9;
        requestLayout();
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.H = colorStateList;
        e1 e1Var = this.f500j;
        if (e1Var != null) {
            e1Var.setTextColor(colorStateList);
        }
    }

    public final boolean t(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public final void u() {
        boolean z8;
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher a9 = s3.a(this);
            t3 t3Var = this.U;
            int i9 = 0;
            if (t3Var != null && t3Var.f7058j != null && a9 != null) {
                WeakHashMap weakHashMap = t0.f7209a;
                if (f0.b(this) && this.f497b0) {
                    z8 = true;
                    if (!z8 && this.f496a0 == null) {
                        if (this.W == null) {
                            this.W = s3.b(new q3(this, i9));
                        }
                        s3.c(a9, this.W);
                        this.f496a0 = a9;
                        return;
                    }
                    if (!z8 || (onBackInvokedDispatcher = this.f496a0) == null) {
                    }
                    s3.d(onBackInvokedDispatcher, this.W);
                    this.f496a0 = null;
                    return;
                }
            }
            z8 = false;
            if (!z8) {
            }
            if (z8) {
            }
        }
    }

    public void setSubtitleTextColor(int i9) {
        setSubtitleTextColor(ColorStateList.valueOf(i9));
    }

    public void setTitleTextColor(int i9) {
        setTitleTextColor(ColorStateList.valueOf(i9));
    }

    public void setCollapseContentDescription(int i9) {
        setCollapseContentDescription(i9 != 0 ? getContext().getText(i9) : null);
    }

    public void setCollapseIcon(int i9) {
        setCollapseIcon(android.support.v4.media.session.b.I(getContext(), i9));
    }

    public void setNavigationContentDescription(int i9) {
        setNavigationContentDescription(i9 != 0 ? getContext().getText(i9) : null);
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return i(layoutParams);
    }

    public void setLogoDescription(int i9) {
        setLogoDescription(getContext().getText(i9));
    }

    public void setNavigationIcon(int i9) {
        setNavigationIcon(android.support.v4.media.session.b.I(getContext(), i9));
    }

    public void setLogo(int i9) {
        setLogo(android.support.v4.media.session.b.I(getContext(), i9));
    }

    public void setSubtitle(int i9) {
        setSubtitle(getContext().getText(i9));
    }

    public void setTitle(int i9) {
        setTitle(getContext().getText(i9));
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
