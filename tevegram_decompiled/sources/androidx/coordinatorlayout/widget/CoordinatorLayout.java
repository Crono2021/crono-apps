package androidx.coordinatorlayout.widget;

import a0.b;
import a0.c;
import a0.d;
import a0.f;
import a0.g;
import a0.h;
import a0.j;
import a0.k;
import a0.l;
import a0.m;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import d1.k0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;
import m0.e;
import n0.a2;
import n0.c0;
import n0.d0;
import n0.f0;
import n0.g0;
import n0.i0;
import n0.p;
import n0.q;
import n0.t0;
import z.a;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class CoordinatorLayout extends ViewGroup implements p, q {
    public static final String B;
    public static final Class[] C;
    public static final ThreadLocal D;
    public static final k E;
    public static final e F;
    public final k0 A;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f549i;

    /* renamed from: j, reason: collision with root package name */
    public final l f550j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f551k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f552l;

    /* renamed from: m, reason: collision with root package name */
    public final int[] f553m;

    /* renamed from: n, reason: collision with root package name */
    public final int[] f554n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f555o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f556p;

    /* renamed from: q, reason: collision with root package name */
    public final int[] f557q;

    /* renamed from: r, reason: collision with root package name */
    public View f558r;

    /* renamed from: s, reason: collision with root package name */
    public View f559s;

    /* renamed from: t, reason: collision with root package name */
    public h f560t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f561u;

    /* renamed from: v, reason: collision with root package name */
    public a2 f562v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f563w;

    /* renamed from: x, reason: collision with root package name */
    public Drawable f564x;

    /* renamed from: y, reason: collision with root package name */
    public ViewGroup.OnHierarchyChangeListener f565y;

    /* renamed from: z, reason: collision with root package name */
    public b f566z;

    static {
        Package r02 = CoordinatorLayout.class.getPackage();
        B = r02 != null ? r02.getName() : null;
        E = new k(0);
        C = new Class[]{Context.class, AttributeSet.class};
        D = new ThreadLocal();
        F = new e(12);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130968889);
        this.f549i = new ArrayList();
        this.f550j = new l(0);
        this.f551k = new ArrayList();
        this.f552l = new ArrayList();
        this.f553m = new int[2];
        this.f554n = new int[2];
        this.A = new k0();
        int[] iArr = a.f10532a;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 2130968889, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, 2130968889, 0);
        }
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            int[] intArray = resources.getIntArray(resourceId);
            this.f557q = intArray;
            float f9 = resources.getDisplayMetrics().density;
            int length = intArray.length;
            for (int i9 = 0; i9 < length; i9++) {
                this.f557q[i9] = (int) (r1[i9] * f9);
            }
        }
        this.f564x = obtainStyledAttributes.getDrawable(1);
        obtainStyledAttributes.recycle();
        x();
        super.setOnHierarchyChangeListener(new f(this));
        WeakHashMap weakHashMap = t0.f7209a;
        if (c0.c(this) == 0) {
            c0.s(this, 1);
        }
    }

    public static Rect g() {
        Rect rect = (Rect) F.b();
        return rect == null ? new Rect() : rect;
    }

    public static void l(int i9, Rect rect, Rect rect2, g gVar, int i10, int i11) {
        int i12 = gVar.f12c;
        if (i12 == 0) {
            i12 = 17;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i12, i9);
        int i13 = gVar.f13d;
        if ((i13 & 7) == 0) {
            i13 |= 8388611;
        }
        if ((i13 & 112) == 0) {
            i13 |= 48;
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i13, i9);
        int i14 = absoluteGravity & 7;
        int i15 = absoluteGravity & 112;
        int i16 = absoluteGravity2 & 7;
        int i17 = absoluteGravity2 & 112;
        int width = i16 != 1 ? i16 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int height = i17 != 16 ? i17 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i14 == 1) {
            width -= i10 / 2;
        } else if (i14 != 5) {
            width -= i10;
        }
        if (i15 == 16) {
            height -= i11 / 2;
        } else if (i15 != 80) {
            height -= i11;
        }
        rect2.set(width, height, i10 + width, i11 + height);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static g n(View view) {
        g gVar = (g) view.getLayoutParams();
        if (!gVar.f11b) {
            if (view instanceof c) {
                d behavior = ((c) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                d dVar = gVar.f10a;
                if (dVar != behavior) {
                    if (dVar != null) {
                        dVar.f();
                    }
                    gVar.f10a = behavior;
                    gVar.f11b = true;
                    if (behavior != null) {
                        behavior.c(gVar);
                    }
                }
                gVar.f11b = true;
                return gVar;
            }
            a0.e eVar = null;
            for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                eVar = (a0.e) cls.getAnnotation(a0.e.class);
                if (eVar != null) {
                    break;
                }
            }
            if (eVar != null) {
                try {
                    d dVar2 = (d) eVar.value().getDeclaredConstructor(null).newInstance(null);
                    d dVar3 = gVar.f10a;
                    if (dVar3 != dVar2) {
                        if (dVar3 != null) {
                            dVar3.f();
                        }
                        gVar.f10a = dVar2;
                        gVar.f11b = true;
                        if (dVar2 != null) {
                            dVar2.c(gVar);
                        }
                    }
                } catch (Exception e9) {
                    Log.e("CoordinatorLayout", "Default behavior class " + eVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e9);
                }
            }
            gVar.f11b = true;
        }
        return gVar;
    }

    public static void v(View view, int i9) {
        g gVar = (g) view.getLayoutParams();
        int i10 = gVar.f17i;
        if (i10 != i9) {
            t0.j(view, i9 - i10);
            gVar.f17i = i9;
        }
    }

    public static void w(View view, int i9) {
        g gVar = (g) view.getLayoutParams();
        int i10 = gVar.f18j;
        if (i10 != i9) {
            t0.k(view, i9 - i10);
            gVar.f18j = i9;
        }
    }

    @Override // n0.p
    public final void a(View view, View view2, int i9, int i10) {
        k0 k0Var = this.A;
        if (i10 == 1) {
            k0Var.f2493b = i9;
        } else {
            k0Var.f2492a = i9;
        }
        this.f559s = view2;
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            ((g) getChildAt(i11).getLayoutParams()).getClass();
        }
    }

    @Override // n0.p
    public final void b(View view, int i9) {
        k0 k0Var = this.A;
        if (i9 == 1) {
            k0Var.f2493b = 0;
        } else {
            k0Var.f2492a = 0;
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            g gVar = (g) childAt.getLayoutParams();
            if (gVar.a(i9)) {
                d dVar = gVar.f10a;
                if (dVar != null) {
                    dVar.q(this, childAt, view, i9);
                }
                if (i9 == 0) {
                    gVar.f21m = false;
                } else if (i9 == 1) {
                    gVar.f22n = false;
                }
                gVar.f23o = false;
            }
        }
        this.f559s = null;
    }

    @Override // n0.p
    public final void c(View view, int i9, int i10, int[] iArr, int i11) {
        d dVar;
        int childCount = getChildCount();
        boolean z8 = false;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                g gVar = (g) childAt.getLayoutParams();
                if (gVar.a(i11) && (dVar = gVar.f10a) != null) {
                    int[] iArr2 = this.f553m;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    dVar.k(this, childAt, view, i9, i10, iArr2, i11);
                    i12 = i9 > 0 ? Math.max(i12, iArr2[0]) : Math.min(i12, iArr2[0]);
                    i13 = i10 > 0 ? Math.max(i13, iArr2[1]) : Math.min(i13, iArr2[1]);
                    z8 = true;
                }
            }
        }
        iArr[0] = i12;
        iArr[1] = i13;
        if (z8) {
            p(1);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof g) && super.checkLayoutParams(layoutParams);
    }

    @Override // n0.q
    public final void d(View view, int i9, int i10, int i11, int i12, int i13, int[] iArr) {
        d dVar;
        int childCount = getChildCount();
        int i14 = 0;
        int i15 = 0;
        boolean z8 = false;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8) {
                g gVar = (g) childAt.getLayoutParams();
                if (gVar.a(i13) && (dVar = gVar.f10a) != null) {
                    int[] iArr2 = this.f553m;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    dVar.l(this, childAt, i10, i11, i12, iArr2);
                    i14 = i11 > 0 ? Math.max(i14, iArr2[0]) : Math.min(i14, iArr2[0]);
                    i15 = i12 > 0 ? Math.max(i15, iArr2[1]) : Math.min(i15, iArr2[1]);
                    z8 = true;
                }
            }
        }
        iArr[0] = iArr[0] + i14;
        iArr[1] = iArr[1] + i15;
        if (z8) {
            p(1);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j5) {
        d dVar = ((g) view.getLayoutParams()).f10a;
        if (dVar != null) {
            dVar.getClass();
        }
        return super.drawChild(canvas, view, j5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f564x;
        if ((drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState)) {
            invalidate();
        }
    }

    @Override // n0.p
    public final void e(View view, int i9, int i10, int i11, int i12, int i13) {
        d(view, i9, i10, i11, i12, 0, this.f554n);
    }

    @Override // n0.p
    public final boolean f(View view, View view2, int i9, int i10) {
        View view3;
        int i11;
        int i12;
        int childCount = getChildCount();
        int i13 = 0;
        boolean z8 = false;
        while (i13 < childCount) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() == 8) {
                view3 = view;
                i11 = i9;
                i12 = i10;
            } else {
                g gVar = (g) childAt.getLayoutParams();
                d dVar = gVar.f10a;
                if (dVar != null) {
                    view3 = view;
                    i11 = i9;
                    i12 = i10;
                    boolean p5 = dVar.p(this, childAt, view3, i11, i12);
                    z8 |= p5;
                    if (i12 == 0) {
                        gVar.f21m = p5;
                    } else if (i12 == 1) {
                        gVar.f22n = p5;
                    }
                } else {
                    view3 = view;
                    i11 = i9;
                    i12 = i10;
                    if (i12 == 0) {
                        gVar.f21m = false;
                    } else if (i12 == 1) {
                        gVar.f22n = false;
                    }
                }
            }
            i13++;
            view = view3;
            i9 = i11;
            i10 = i12;
        }
        return z8;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new g();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof g ? new g((g) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new g((ViewGroup.MarginLayoutParams) layoutParams) : new g(layoutParams);
    }

    public final List<View> getDependencySortedChildren() {
        t();
        return Collections.unmodifiableList(this.f549i);
    }

    public final a2 getLastWindowInsets() {
        return this.f562v;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        k0 k0Var = this.A;
        return k0Var.f2493b | k0Var.f2492a;
    }

    public Drawable getStatusBarBackground() {
        return this.f564x;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingRight() + getPaddingLeft());
    }

    public final void h(g gVar, Rect rect, int i9, int i10) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) gVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i9) - ((ViewGroup.MarginLayoutParams) gVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) gVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i10) - ((ViewGroup.MarginLayoutParams) gVar).bottomMargin));
        rect.set(max, max2, i9 + max, i10 + max2);
    }

    public final void i(View view, Rect rect, boolean z8) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z8) {
            k(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public final ArrayList j(View view) {
        s.h hVar = (s.h) this.f550j.f31j;
        int i9 = hVar.f8653k;
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < i9; i10++) {
            ArrayList arrayList2 = (ArrayList) hVar.l(i10);
            if (arrayList2 != null && arrayList2.contains(view)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(hVar.h(i10));
            }
        }
        ArrayList arrayList3 = this.f552l;
        arrayList3.clear();
        if (arrayList != null) {
            arrayList3.addAll(arrayList);
        }
        return arrayList3;
    }

    public final void k(View view, Rect rect) {
        ThreadLocal threadLocal = m.f34a;
        rect.set(0, 0, view.getWidth(), view.getHeight());
        ThreadLocal threadLocal2 = m.f34a;
        Matrix matrix = (Matrix) threadLocal2.get();
        if (matrix == null) {
            matrix = new Matrix();
            threadLocal2.set(matrix);
        } else {
            matrix.reset();
        }
        m.a(this, view, matrix);
        ThreadLocal threadLocal3 = m.f35b;
        RectF rectF = (RectF) threadLocal3.get();
        if (rectF == null) {
            rectF = new RectF();
            threadLocal3.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    public final int m(int i9) {
        int[] iArr = this.f557q;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i9);
            return 0;
        }
        if (i9 >= 0 && i9 < iArr.length) {
            return iArr[i9];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i9 + " out of range for " + this);
        return 0;
    }

    public final boolean o(View view, int i9, int i10) {
        e eVar = F;
        Rect g9 = g();
        k(view, g9);
        try {
            return g9.contains(i9, i10);
        } finally {
            g9.setEmpty();
            eVar.a(g9);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        u(false);
        if (this.f561u) {
            if (this.f560t == null) {
                this.f560t = new h(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.f560t);
        }
        if (this.f562v == null) {
            WeakHashMap weakHashMap = t0.f7209a;
            if (c0.b(this)) {
                g0.c(this);
            }
        }
        this.f556p = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u(false);
        if (this.f561u && this.f560t != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f560t);
        }
        View view = this.f559s;
        if (view != null) {
            b(view, 0);
        }
        this.f556p = false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f563w || this.f564x == null) {
            return;
        }
        a2 a2Var = this.f562v;
        int d9 = a2Var != null ? a2Var.d() : 0;
        if (d9 > 0) {
            this.f564x.setBounds(0, 0, getWidth(), d9);
            this.f564x.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            u(true);
        }
        boolean s8 = s(motionEvent, 0);
        if (actionMasked != 1 && actionMasked != 3) {
            return s8;
        }
        u(true);
        return s8;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        d dVar;
        WeakHashMap weakHashMap = t0.f7209a;
        int d9 = d0.d(this);
        ArrayList arrayList = this.f549i;
        int size = arrayList.size();
        for (int i13 = 0; i13 < size; i13++) {
            View view = (View) arrayList.get(i13);
            if (view.getVisibility() != 8 && ((dVar = ((g) view.getLayoutParams()).f10a) == null || !dVar.h(this, view, d9))) {
                q(view, d9);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0189  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r27, int r28) {
        /*
            Method dump skipped, instructions count: 498
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f9, float f10, boolean z8) {
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                g gVar = (g) childAt.getLayoutParams();
                if (gVar.a(0)) {
                    d dVar = gVar.f10a;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f9, float f10) {
        d dVar;
        int childCount = getChildCount();
        boolean z8 = false;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                g gVar = (g) childAt.getLayoutParams();
                if (gVar.a(0) && (dVar = gVar.f10a) != null) {
                    z8 |= dVar.j(view);
                }
            }
        }
        return z8;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i9, int i10, int[] iArr) {
        c(view, i9, i10, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i9, int i10, int i11, int i12) {
        e(view, i9, i10, i11, i12, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i9) {
        a(view, view2, i9, 0);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof j)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        j jVar = (j) parcelable;
        super.onRestoreInstanceState(jVar.f8991i);
        SparseArray sparseArray = jVar.f28k;
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            int id = childAt.getId();
            d dVar = n(childAt).f10a;
            if (id != -1 && dVar != null && (parcelable2 = (Parcelable) sparseArray.get(id)) != null) {
                dVar.n(childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable o8;
        j jVar = new j(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            int id = childAt.getId();
            d dVar = ((g) childAt.getLayoutParams()).f10a;
            if (id != -1 && dVar != null && (o8 = dVar.o(childAt)) != null) {
                sparseArray.append(id, o8);
            }
        }
        jVar.f28k = sparseArray;
        return jVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i9) {
        return f(view, view2, i9, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        b(view, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:
    
        if (r3 != false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r1.getActionMasked()
            android.view.View r3 = r0.f558r
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L17
            boolean r3 = r0.s(r1, r4)
            if (r3 == 0) goto L15
            goto L18
        L15:
            r6 = 0
            goto L2a
        L17:
            r3 = 0
        L18:
            android.view.View r6 = r0.f558r
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            a0.g r6 = (a0.g) r6
            a0.d r6 = r6.f10a
            if (r6 == 0) goto L15
            android.view.View r7 = r0.f558r
            boolean r6 = r6.r(r0, r7, r1)
        L2a:
            android.view.View r7 = r0.f558r
            r8 = 0
            if (r7 != 0) goto L35
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L48
        L35:
            if (r3 == 0) goto L48
            long r9 = android.os.SystemClock.uptimeMillis()
            r15 = 0
            r16 = 0
            r13 = 3
            r14 = 0
            r11 = r9
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L48:
            if (r8 == 0) goto L4d
            r8.recycle()
        L4d:
            if (r2 == r4) goto L54
            r1 = 3
            if (r2 != r1) goto L53
            goto L54
        L53:
            return r6
        L54:
            r0.u(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p(int i9) {
        int i10;
        Rect rect;
        int i11;
        ArrayList arrayList;
        boolean z8;
        boolean z9;
        boolean z10;
        int width;
        int i12;
        int i13;
        int i14;
        int height;
        int i15;
        int i16;
        int i17;
        ArrayList arrayList2;
        g gVar;
        int i18;
        int i19;
        Rect rect2;
        int i20;
        View view;
        d dVar;
        WeakHashMap weakHashMap = t0.f7209a;
        int d9 = d0.d(this);
        ArrayList arrayList3 = this.f549i;
        int size = arrayList3.size();
        Rect g9 = g();
        Rect g10 = g();
        Rect g11 = g();
        int i21 = 0;
        while (true) {
            e eVar = F;
            if (i21 >= size) {
                Rect rect3 = g11;
                g9.setEmpty();
                eVar.a(g9);
                g10.setEmpty();
                eVar.a(g10);
                rect3.setEmpty();
                eVar.a(rect3);
                return;
            }
            View view2 = (View) arrayList3.get(i21);
            g gVar2 = (g) view2.getLayoutParams();
            if (i9 != 0 || view2.getVisibility() != 8) {
                int i22 = 0;
                while (i22 < i21) {
                    if (gVar2.f20l == ((View) arrayList3.get(i22))) {
                        g gVar3 = (g) view2.getLayoutParams();
                        if (gVar3.f19k != null) {
                            Rect g12 = g();
                            Rect g13 = g();
                            g gVar4 = gVar2;
                            Rect g14 = g();
                            k(gVar3.f19k, g12);
                            i(view2, g13, false);
                            int measuredWidth = view2.getMeasuredWidth();
                            View view3 = view2;
                            int measuredHeight = view3.getMeasuredHeight();
                            arrayList2 = arrayList3;
                            gVar = gVar4;
                            i18 = i22;
                            d9 = d9;
                            i20 = i21;
                            view = view3;
                            l(d9, g12, g14, gVar3, measuredWidth, measuredHeight);
                            i19 = size;
                            rect2 = g11;
                            boolean z11 = (g14.left == g13.left && g14.top == g13.top) ? false : true;
                            h(gVar3, g14, measuredWidth, measuredHeight);
                            int i23 = g14.left - g13.left;
                            int i24 = g14.top - g13.top;
                            if (i23 != 0) {
                                t0.j(view, i23);
                            }
                            if (i24 != 0) {
                                t0.k(view, i24);
                            }
                            if (z11 && (dVar = gVar3.f10a) != null) {
                                dVar.d(this, view, gVar3.f19k);
                            }
                            g12.setEmpty();
                            eVar.a(g12);
                            g13.setEmpty();
                            eVar.a(g13);
                            g14.setEmpty();
                            eVar.a(g14);
                            i22 = i18 + 1;
                            gVar2 = gVar;
                            view2 = view;
                            arrayList3 = arrayList2;
                            size = i19;
                            i21 = i20;
                            g11 = rect2;
                        }
                    }
                    arrayList2 = arrayList3;
                    gVar = gVar2;
                    i18 = i22;
                    i19 = size;
                    rect2 = g11;
                    i20 = i21;
                    view = view2;
                    i22 = i18 + 1;
                    gVar2 = gVar;
                    view2 = view;
                    arrayList3 = arrayList2;
                    size = i19;
                    i21 = i20;
                    g11 = rect2;
                }
                ArrayList arrayList4 = arrayList3;
                g gVar5 = gVar2;
                int i25 = size;
                Rect rect4 = g11;
                i10 = i21;
                View view4 = view2;
                i(view4, g10, true);
                if (gVar5.f16g != 0 && !g10.isEmpty()) {
                    int absoluteGravity = Gravity.getAbsoluteGravity(gVar5.f16g, d9);
                    int i26 = absoluteGravity & 112;
                    if (i26 == 48) {
                        g9.top = Math.max(g9.top, g10.bottom);
                    } else if (i26 == 80) {
                        g9.bottom = Math.max(g9.bottom, getHeight() - g10.top);
                    }
                    int i27 = absoluteGravity & 7;
                    if (i27 == 3) {
                        g9.left = Math.max(g9.left, g10.right);
                    } else if (i27 == 5) {
                        g9.right = Math.max(g9.right, getWidth() - g10.left);
                    }
                }
                if (gVar5.h != 0 && view4.getVisibility() == 0) {
                    WeakHashMap weakHashMap2 = t0.f7209a;
                    if (f0.c(view4) && view4.getWidth() > 0 && view4.getHeight() > 0) {
                        g gVar6 = (g) view4.getLayoutParams();
                        d dVar2 = gVar6.f10a;
                        Rect g15 = g();
                        Rect g16 = g();
                        g16.set(view4.getLeft(), view4.getTop(), view4.getRight(), view4.getBottom());
                        if (dVar2 == null || !dVar2.a(view4)) {
                            g15.set(g16);
                        } else if (!g16.contains(g15)) {
                            throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + g15.toShortString() + " | Bounds:" + g16.toShortString());
                        }
                        g16.setEmpty();
                        eVar.a(g16);
                        if (g15.isEmpty()) {
                            g15.setEmpty();
                            eVar.a(g15);
                        } else {
                            int absoluteGravity2 = Gravity.getAbsoluteGravity(gVar6.h, d9);
                            if ((absoluteGravity2 & 48) != 48 || (i16 = (g15.top - ((ViewGroup.MarginLayoutParams) gVar6).topMargin) - gVar6.f18j) >= (i17 = g9.top)) {
                                z9 = false;
                            } else {
                                w(view4, i17 - i16);
                                z9 = true;
                            }
                            if ((absoluteGravity2 & 80) == 80 && (height = ((getHeight() - g15.bottom) - ((ViewGroup.MarginLayoutParams) gVar6).bottomMargin) + gVar6.f18j) < (i15 = g9.bottom)) {
                                w(view4, height - i15);
                                z9 = true;
                            }
                            if (!z9) {
                                w(view4, 0);
                            }
                            if ((absoluteGravity2 & 3) != 3 || (i13 = (g15.left - ((ViewGroup.MarginLayoutParams) gVar6).leftMargin) - gVar6.f17i) >= (i14 = g9.left)) {
                                z10 = false;
                            } else {
                                v(view4, i14 - i13);
                                z10 = true;
                            }
                            if ((absoluteGravity2 & 5) == 5 && (width = ((getWidth() - g15.right) - ((ViewGroup.MarginLayoutParams) gVar6).rightMargin) + gVar6.f17i) < (i12 = g9.right)) {
                                v(view4, width - i12);
                                z10 = true;
                            }
                            if (!z10) {
                                v(view4, 0);
                            }
                            g15.setEmpty();
                            eVar.a(g15);
                        }
                    }
                }
                if (i9 != 2) {
                    rect = rect4;
                    rect.set(((g) view4.getLayoutParams()).f24p);
                    if (rect.equals(g10)) {
                        arrayList = arrayList4;
                        i11 = i25;
                    } else {
                        ((g) view4.getLayoutParams()).f24p.set(g10);
                    }
                } else {
                    rect = rect4;
                }
                int i28 = i10 + 1;
                i11 = i25;
                while (true) {
                    arrayList = arrayList4;
                    if (i28 >= i11) {
                        break;
                    }
                    View view5 = (View) arrayList.get(i28);
                    g gVar7 = (g) view5.getLayoutParams();
                    d dVar3 = gVar7.f10a;
                    if (dVar3 != null && dVar3.b(view5, view4)) {
                        if (i9 == 0 && gVar7.f23o) {
                            gVar7.f23o = false;
                        } else {
                            if (i9 != 2) {
                                z8 = dVar3.d(this, view5, view4);
                            } else {
                                dVar3.e(this, view4);
                                z8 = true;
                            }
                            if (i9 == 1) {
                                gVar7.f23o = z8;
                            }
                        }
                    }
                    i28++;
                    arrayList4 = arrayList;
                }
            } else {
                arrayList = arrayList3;
                i11 = size;
                rect = g11;
                i10 = i21;
            }
            i21 = i10 + 1;
            g11 = rect;
            size = i11;
            arrayList3 = arrayList;
        }
    }

    public final void q(View view, int i9) {
        Rect g9;
        Rect g10;
        g gVar = (g) view.getLayoutParams();
        View view2 = gVar.f19k;
        if (view2 == null && gVar.f15f != -1) {
            m7.c.p("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
            return;
        }
        e eVar = F;
        if (view2 != null) {
            g9 = g();
            g10 = g();
            try {
                k(view2, g9);
                g gVar2 = (g) view.getLayoutParams();
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                l(i9, g9, g10, gVar2, measuredWidth, measuredHeight);
                h(gVar2, g10, measuredWidth, measuredHeight);
                view.layout(g10.left, g10.top, g10.right, g10.bottom);
                return;
            } finally {
                g9.setEmpty();
                eVar.a(g9);
                g10.setEmpty();
                eVar.a(g10);
            }
        }
        int i10 = gVar.f14e;
        if (i10 < 0) {
            g gVar3 = (g) view.getLayoutParams();
            g9 = g();
            g9.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) gVar3).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) gVar3).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) gVar3).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) gVar3).bottomMargin);
            if (this.f562v != null) {
                WeakHashMap weakHashMap = t0.f7209a;
                if (c0.b(this) && !c0.b(view)) {
                    g9.left = this.f562v.b() + g9.left;
                    g9.top = this.f562v.d() + g9.top;
                    g9.right -= this.f562v.c();
                    g9.bottom -= this.f562v.a();
                }
            }
            g10 = g();
            int i11 = gVar3.f12c;
            if ((i11 & 7) == 0) {
                i11 |= 8388611;
            }
            if ((i11 & 112) == 0) {
                i11 |= 48;
            }
            n0.j.b(i11, view.getMeasuredWidth(), view.getMeasuredHeight(), g9, g10, i9);
            view.layout(g10.left, g10.top, g10.right, g10.bottom);
            return;
        }
        g gVar4 = (g) view.getLayoutParams();
        int i12 = gVar4.f12c;
        if (i12 == 0) {
            i12 = 8388661;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i12, i9);
        int i13 = absoluteGravity & 7;
        int i14 = absoluteGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth2 = view.getMeasuredWidth();
        int measuredHeight2 = view.getMeasuredHeight();
        if (i9 == 1) {
            i10 = width - i10;
        }
        int m9 = m(i10) - measuredWidth2;
        if (i13 == 1) {
            m9 += measuredWidth2 / 2;
        } else if (i13 == 5) {
            m9 += measuredWidth2;
        }
        int i15 = i14 != 16 ? i14 != 80 ? 0 : measuredHeight2 : measuredHeight2 / 2;
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) gVar4).leftMargin, Math.min(m9, ((width - getPaddingRight()) - measuredWidth2) - ((ViewGroup.MarginLayoutParams) gVar4).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) gVar4).topMargin, Math.min(i15, ((height - getPaddingBottom()) - measuredHeight2) - ((ViewGroup.MarginLayoutParams) gVar4).bottomMargin));
        view.layout(max, max2, measuredWidth2 + max, measuredHeight2 + max2);
    }

    public final void r(View view, int i9, int i10, int i11) {
        measureChildWithMargins(view, i9, i10, i11, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z8) {
        d dVar = ((g) view.getLayoutParams()).f10a;
        if (dVar == null || !dVar.m(this, view, rect, z8)) {
            return super.requestChildRectangleOnScreen(view, rect, z8);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z8) {
        super.requestDisallowInterceptTouchEvent(z8);
        if (!z8 || this.f555o) {
            return;
        }
        u(false);
        this.f555o = true;
    }

    public final boolean s(MotionEvent motionEvent, int i9) {
        int actionMasked = motionEvent.getActionMasked();
        ArrayList arrayList = this.f551k;
        arrayList.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i10 = childCount - 1; i10 >= 0; i10--) {
            arrayList.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i10) : i10));
        }
        k kVar = E;
        if (kVar != null) {
            Collections.sort(arrayList, kVar);
        }
        int size = arrayList.size();
        MotionEvent motionEvent2 = null;
        boolean z8 = false;
        for (int i11 = 0; i11 < size; i11++) {
            View view = (View) arrayList.get(i11);
            d dVar = ((g) view.getLayoutParams()).f10a;
            if (z8 && actionMasked != 0) {
                if (dVar != null) {
                    if (motionEvent2 == null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    }
                    if (i9 == 0) {
                        dVar.g(this, view, motionEvent2);
                    } else if (i9 == 1) {
                        dVar.r(this, view, motionEvent2);
                    }
                }
            } else if (!z8 && dVar != null) {
                if (i9 == 0) {
                    z8 = dVar.g(this, view, motionEvent);
                } else if (i9 == 1) {
                    z8 = dVar.r(this, view, motionEvent);
                }
                if (z8) {
                    this.f558r = view;
                }
            }
        }
        arrayList.clear();
        return z8;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z8) {
        super.setFitsSystemWindows(z8);
        x();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f565y = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.f564x;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.f564x = mutate;
            if (mutate != null) {
                if (mutate.isStateful()) {
                    this.f564x.setState(getDrawableState());
                }
                Drawable drawable3 = this.f564x;
                WeakHashMap weakHashMap = t0.f7209a;
                com.bumptech.glide.d.a0(drawable3, d0.d(this));
                this.f564x.setVisible(getVisibility() == 0, false);
                this.f564x.setCallback(this);
            }
            WeakHashMap weakHashMap2 = t0.f7209a;
            c0.k(this);
        }
    }

    public void setStatusBarBackgroundColor(int i9) {
        setStatusBarBackground(new ColorDrawable(i9));
    }

    public void setStatusBarBackgroundResource(int i9) {
        setStatusBarBackground(i9 != 0 ? d0.c.b(getContext(), i9) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i9) {
        super.setVisibility(i9);
        boolean z8 = i9 == 0;
        Drawable drawable = this.f564x;
        if (drawable == null || drawable.isVisible() == z8) {
            return;
        }
        this.f564x.setVisible(z8, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00f5, code lost:
    
        if ((android.view.Gravity.getAbsoluteGravity(r8.h, r12) & r13) == r13) goto L72;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t() {
        /*
            Method dump skipped, instructions count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.t():void");
    }

    public final void u(boolean z8) {
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            d dVar = ((g) childAt.getLayoutParams()).f10a;
            if (dVar != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z8) {
                    dVar.g(this, childAt, obtain);
                } else {
                    dVar.r(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            ((g) getChildAt(i10).getLayoutParams()).getClass();
        }
        this.f558r = null;
        this.f555o = false;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f564x;
    }

    public final void x() {
        WeakHashMap weakHashMap = t0.f7209a;
        if (!c0.b(this)) {
            i0.u(this, null);
            return;
        }
        if (this.f566z == null) {
            this.f566z = new b(this, 0);
        }
        i0.u(this, this.f566z);
        setSystemUiVisibility(1280);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new g(getContext(), attributeSet);
    }
}
