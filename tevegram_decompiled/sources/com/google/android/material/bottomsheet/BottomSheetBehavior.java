package com.google.android.material.bottomsheet;

import a0.d;
import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.PathInterpolator;
import androidx.activity.h;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b2.l;
import d1.p;
import d4.i;
import d5.b;
import d5.c;
import d5.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;
import n0.c0;
import n0.d0;
import n0.f0;
import n0.g0;
import n0.h1;
import n0.i0;
import n0.i1;
import n0.j1;
import n0.t0;
import o0.f;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import u5.g;
import u5.j;
import y4.a;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class BottomSheetBehavior<V extends View> extends d {
    public final e A;
    public final ValueAnimator B;
    public final int C;
    public int D;
    public int E;
    public final float F;
    public int G;
    public final float H;
    public boolean I;
    public boolean J;
    public final boolean K;
    public int L;
    public v0.d M;
    public boolean N;
    public int O;
    public boolean P;
    public final float Q;
    public int R;
    public int S;
    public int T;
    public WeakReference U;
    public WeakReference V;
    public final ArrayList W;
    public VelocityTracker X;
    public int Y;
    public int Z;

    /* renamed from: a, reason: collision with root package name */
    public final int f1920a;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f1921a0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1922b;

    /* renamed from: b0, reason: collision with root package name */
    public HashMap f1923b0;

    /* renamed from: c, reason: collision with root package name */
    public final float f1924c;

    /* renamed from: c0, reason: collision with root package name */
    public final SparseIntArray f1925c0;

    /* renamed from: d, reason: collision with root package name */
    public final int f1926d;

    /* renamed from: d0, reason: collision with root package name */
    public final c f1927d0;

    /* renamed from: e, reason: collision with root package name */
    public int f1928e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1929f;

    /* renamed from: g, reason: collision with root package name */
    public int f1930g;
    public final int h;

    /* renamed from: i, reason: collision with root package name */
    public final g f1931i;

    /* renamed from: j, reason: collision with root package name */
    public final ColorStateList f1932j;

    /* renamed from: k, reason: collision with root package name */
    public final int f1933k;

    /* renamed from: l, reason: collision with root package name */
    public final int f1934l;

    /* renamed from: m, reason: collision with root package name */
    public int f1935m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f1936n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f1937o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f1938p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f1939q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f1940r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f1941s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f1942t;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f1943u;

    /* renamed from: v, reason: collision with root package name */
    public int f1944v;

    /* renamed from: w, reason: collision with root package name */
    public int f1945w;

    /* renamed from: x, reason: collision with root package name */
    public final boolean f1946x;

    /* renamed from: y, reason: collision with root package name */
    public final j f1947y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f1948z;

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i9;
        int i10 = 0;
        this.f1920a = 0;
        this.f1922b = true;
        this.f1933k = -1;
        this.f1934l = -1;
        this.A = new e(this);
        this.F = 0.5f;
        this.H = -1.0f;
        this.K = true;
        this.L = 4;
        this.Q = 0.1f;
        this.W = new ArrayList();
        this.Z = -1;
        this.f1925c0 = new SparseIntArray();
        this.f1927d0 = new c(this, i10);
        this.h = context.getResources().getDimensionPixelSize(2131165918);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f10498c);
        if (obtainStyledAttributes.hasValue(3)) {
            this.f1932j = com.bumptech.glide.d.B(context, obtainStyledAttributes, 3);
        }
        if (obtainStyledAttributes.hasValue(21)) {
            this.f1947y = j.b(context, attributeSet, 2130968701, 2132018007).a();
        }
        j jVar = this.f1947y;
        if (jVar != null) {
            g gVar = new g(jVar);
            this.f1931i = gVar;
            gVar.i(context);
            ColorStateList colorStateList = this.f1932j;
            if (colorStateList != null) {
                this.f1931i.l(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
                this.f1931i.setTint(typedValue.data);
            }
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(t(), 1.0f);
        this.B = ofFloat;
        ofFloat.setDuration(500L);
        this.B.addUpdateListener(new b(this, i10));
        this.H = obtainStyledAttributes.getDimension(2, -1.0f);
        if (obtainStyledAttributes.hasValue(0)) {
            this.f1933k = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.f1934l = obtainStyledAttributes.getDimensionPixelSize(1, -1);
        }
        TypedValue peekValue = obtainStyledAttributes.peekValue(9);
        if (peekValue == null || (i9 = peekValue.data) != -1) {
            B(obtainStyledAttributes.getDimensionPixelSize(9, -1));
        } else {
            B(i9);
        }
        boolean z8 = obtainStyledAttributes.getBoolean(8, false);
        if (this.I != z8) {
            this.I = z8;
            if (!z8 && this.L == 5) {
                C(4);
            }
            G();
        }
        this.f1936n = obtainStyledAttributes.getBoolean(13, false);
        boolean z9 = obtainStyledAttributes.getBoolean(6, true);
        if (this.f1922b != z9) {
            this.f1922b = z9;
            if (this.U != null) {
                s();
            }
            D((this.f1922b && this.L == 6) ? 3 : this.L);
            H(this.L, true);
            G();
        }
        this.J = obtainStyledAttributes.getBoolean(12, false);
        this.K = obtainStyledAttributes.getBoolean(4, true);
        this.f1920a = obtainStyledAttributes.getInt(10, 0);
        float f9 = obtainStyledAttributes.getFloat(7, 0.5f);
        if (f9 <= 0.0f || f9 >= 1.0f) {
            m7.c.n("ratio must be a float value between 0 and 1");
            throw null;
        }
        this.F = f9;
        if (this.U != null) {
            this.E = (int) ((1.0f - f9) * this.T);
        }
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(5);
        if (peekValue2 == null || peekValue2.type != 16) {
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(5, 0);
            if (dimensionPixelOffset < 0) {
                m7.c.n("offset must be greater than or equal to 0");
                throw null;
            }
            this.C = dimensionPixelOffset;
            H(this.L, true);
        } else {
            int i11 = peekValue2.data;
            if (i11 < 0) {
                m7.c.n("offset must be greater than or equal to 0");
                throw null;
            }
            this.C = i11;
            H(this.L, true);
        }
        this.f1926d = obtainStyledAttributes.getInt(11, 500);
        this.f1937o = obtainStyledAttributes.getBoolean(17, false);
        this.f1938p = obtainStyledAttributes.getBoolean(18, false);
        this.f1939q = obtainStyledAttributes.getBoolean(19, false);
        this.f1940r = obtainStyledAttributes.getBoolean(20, true);
        this.f1941s = obtainStyledAttributes.getBoolean(14, false);
        this.f1942t = obtainStyledAttributes.getBoolean(15, false);
        this.f1943u = obtainStyledAttributes.getBoolean(16, false);
        this.f1946x = obtainStyledAttributes.getBoolean(23, true);
        obtainStyledAttributes.recycle();
        this.f1924c = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public static View w(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        WeakHashMap weakHashMap = t0.f7209a;
        if (i0.p(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View w8 = w(viewGroup.getChildAt(i9));
            if (w8 != null) {
                return w8;
            }
        }
        return null;
    }

    public static int x(int i9, int i10, int i11, int i12) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i9, i10, i12);
        if (i11 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i11), 1073741824);
        }
        if (size != 0) {
            i11 = Math.min(size, i11);
        }
        return View.MeasureSpec.makeMeasureSpec(i11, Integer.MIN_VALUE);
    }

    public final boolean A() {
        WeakReference weakReference = this.U;
        if (weakReference != null && weakReference.get() != null) {
            int[] iArr = new int[2];
            ((View) this.U.get()).getLocationOnScreen(iArr);
            if (iArr[1] == 0) {
                return true;
            }
        }
        return false;
    }

    public final void B(int i9) {
        boolean z8 = this.f1929f;
        if (i9 == -1) {
            if (z8) {
                return;
            } else {
                this.f1929f = true;
            }
        } else {
            if (!z8 && this.f1928e == i9) {
                return;
            }
            this.f1929f = false;
            this.f1928e = Math.max(0, i9);
        }
        J();
    }

    public final void C(int i9) {
        if (i9 == 1 || i9 == 2) {
            throw new IllegalArgumentException(androidx.activity.g.o(new StringBuilder("STATE_"), i9 == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
        }
        if (!this.I && i9 == 5) {
            Log.w("BottomSheetBehavior", "Cannot set state: " + i9);
            return;
        }
        int i10 = (i9 == 6 && this.f1922b && z(i9) <= this.D) ? 3 : i9;
        WeakReference weakReference = this.U;
        if (weakReference == null || weakReference.get() == null) {
            D(i9);
            return;
        }
        View view = (View) this.U.get();
        h hVar = new h(this, view, i10);
        ViewParent parent = view.getParent();
        if (parent != null && parent.isLayoutRequested()) {
            WeakHashMap weakHashMap = t0.f7209a;
            if (f0.b(view)) {
                view.post(hVar);
                return;
            }
        }
        hVar.run();
    }

    public final void D(int i9) {
        if (this.L == i9) {
            return;
        }
        this.L = i9;
        if (i9 != 4 && i9 != 3 && i9 != 6) {
            boolean z8 = this.I;
        }
        WeakReference weakReference = this.U;
        if (weakReference == null || ((View) weakReference.get()) == null) {
            return;
        }
        if (i9 == 3) {
            I(true);
        } else if (i9 == 6 || i9 == 5 || i9 == 4) {
            I(false);
        }
        H(i9, true);
        ArrayList arrayList = this.W;
        if (arrayList.size() <= 0) {
            G();
        } else {
            arrayList.get(0).getClass();
            androidx.fragment.app.a.c();
        }
    }

    public final boolean E(View view, float f9) {
        if (this.J) {
            return true;
        }
        if (view.getTop() < this.G) {
            return false;
        }
        return Math.abs(((f9 * this.Q) + ((float) view.getTop())) - ((float) this.G)) / ((float) u()) > 0.5f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
    
        if (r3 != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
    
        if (r1.o(r3.getLeft(), r0) != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0032, code lost:
    
        D(2);
        H(r4, true);
        r2.A.a(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003f, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void F(android.view.View r3, int r4, boolean r5) {
        /*
            r2 = this;
            int r0 = r2.z(r4)
            v0.d r1 = r2.M
            if (r1 == 0) goto L40
            if (r5 == 0) goto L15
            int r3 = r3.getLeft()
            boolean r3 = r1.o(r3, r0)
            if (r3 == 0) goto L40
            goto L32
        L15:
            int r5 = r3.getLeft()
            r1.f9229r = r3
            r3 = -1
            r1.f9215c = r3
            r3 = 0
            boolean r3 = r1.h(r5, r0, r3, r3)
            if (r3 != 0) goto L30
            int r5 = r1.f9213a
            if (r5 != 0) goto L30
            android.view.View r5 = r1.f9229r
            if (r5 == 0) goto L30
            r5 = 0
            r1.f9229r = r5
        L30:
            if (r3 == 0) goto L40
        L32:
            r3 = 2
            r2.D(r3)
            r3 = 1
            r2.H(r4, r3)
            d5.e r3 = r2.A
            r3.a(r4)
            return
        L40:
            r2.D(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.F(android.view.View, int, boolean):void");
    }

    public final void G() {
        View view;
        int i9;
        WeakReference weakReference = this.U;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        t0.m(view, 524288);
        t0.i(view, 0);
        t0.m(view, 262144);
        t0.i(view, 0);
        t0.m(view, 1048576);
        t0.i(view, 0);
        SparseIntArray sparseIntArray = this.f1925c0;
        int i10 = sparseIntArray.get(0, -1);
        if (i10 != -1) {
            t0.m(view, i10);
            t0.i(view, 0);
            sparseIntArray.delete(0);
        }
        if (!this.f1922b && this.L != 6) {
            String string = view.getResources().getString(2131951649);
            i iVar = new i(this, r5);
            ArrayList e9 = t0.e(view);
            int i11 = 0;
            while (true) {
                if (i11 >= e9.size()) {
                    int i12 = -1;
                    int i13 = 0;
                    while (true) {
                        int[] iArr = t0.f7213e;
                        if (i13 >= iArr.length || i12 != -1) {
                            break;
                        }
                        int i14 = iArr[i13];
                        boolean z8 = true;
                        for (int i15 = 0; i15 < e9.size(); i15++) {
                            z8 &= ((f) e9.get(i15)).a() != i14;
                        }
                        if (z8) {
                            i12 = i14;
                        }
                        i13++;
                    }
                    i9 = i12;
                } else {
                    if (TextUtils.equals(string, ((AccessibilityNodeInfo.AccessibilityAction) ((f) e9.get(i11)).f7558a).getLabel())) {
                        i9 = ((f) e9.get(i11)).a();
                        break;
                    }
                    i11++;
                }
            }
            if (i9 != -1) {
                f fVar = new f(null, i9, string, iVar, null);
                View.AccessibilityDelegate c9 = t0.c(view);
                n0.c cVar = c9 == null ? null : c9 instanceof n0.a ? ((n0.a) c9).f7130a : new n0.c(c9);
                if (cVar == null) {
                    cVar = new n0.c();
                }
                t0.p(view, cVar);
                t0.m(view, fVar.a());
                t0.e(view).add(fVar);
                t0.i(view, 0);
            }
            sparseIntArray.put(0, i9);
        }
        if (this.I) {
            int i16 = 5;
            if (this.L != 5) {
                t0.n(view, f.f7555j, new i(this, i16));
            }
        }
        int i17 = this.L;
        int i18 = 4;
        int i19 = 3;
        if (i17 == 3) {
            t0.n(view, f.f7554i, new i(this, this.f1922b ? 4 : 6));
            return;
        }
        if (i17 == 4) {
            t0.n(view, f.h, new i(this, this.f1922b ? 3 : 6));
        } else {
            if (i17 != 6) {
                return;
            }
            t0.n(view, f.f7554i, new i(this, i18));
            t0.n(view, f.h, new i(this, i19));
        }
    }

    public final void H(int i9, boolean z8) {
        g gVar;
        if (i9 == 2) {
            return;
        }
        boolean z9 = this.L == 3 && (this.f1946x || A());
        if (this.f1948z == z9 || (gVar = this.f1931i) == null) {
            return;
        }
        this.f1948z = z9;
        ValueAnimator valueAnimator = this.B;
        if (!z8 || valueAnimator == null) {
            if (valueAnimator != null && valueAnimator.isRunning()) {
                valueAnimator.cancel();
            }
            gVar.m(this.f1948z ? t() : 1.0f);
            return;
        }
        if (valueAnimator.isRunning()) {
            valueAnimator.reverse();
        } else {
            valueAnimator.setFloatValues(gVar.f9084i.f9076i, z9 ? t() : 1.0f);
            valueAnimator.start();
        }
    }

    public final void I(boolean z8) {
        WeakReference weakReference = this.U;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = ((View) weakReference.get()).getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z8) {
                if (this.f1923b0 != null) {
                    return;
                } else {
                    this.f1923b0 = new HashMap(childCount);
                }
            }
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = coordinatorLayout.getChildAt(i9);
                if (childAt != this.U.get() && z8) {
                    this.f1923b0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                }
            }
            if (z8) {
                return;
            }
            this.f1923b0 = null;
        }
    }

    public final void J() {
        View view;
        if (this.U != null) {
            s();
            if (this.L != 4 || (view = (View) this.U.get()) == null) {
                return;
            }
            view.requestLayout();
        }
    }

    @Override // a0.d
    public final void c(a0.g gVar) {
        this.U = null;
        this.M = null;
    }

    @Override // a0.d
    public final void f() {
        this.U = null;
        this.M = null;
    }

    @Override // a0.d
    public final boolean g(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int i9;
        v0.d dVar;
        if (!view.isShown() || !this.K) {
            this.N = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.Y = -1;
            this.Z = -1;
            VelocityTracker velocityTracker = this.X;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.X = null;
            }
        }
        if (this.X == null) {
            this.X = VelocityTracker.obtain();
        }
        this.X.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x6 = (int) motionEvent.getX();
            this.Z = (int) motionEvent.getY();
            if (this.L != 2) {
                WeakReference weakReference = this.V;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && coordinatorLayout.o(view2, x6, this.Z)) {
                    this.Y = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f1921a0 = true;
                }
            }
            this.N = this.Y == -1 && !coordinatorLayout.o(view, x6, this.Z);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f1921a0 = false;
            this.Y = -1;
            if (this.N) {
                this.N = false;
                return false;
            }
        }
        if (this.N || (dVar = this.M) == null || !dVar.p(motionEvent)) {
            WeakReference weakReference2 = this.V;
            View view3 = weakReference2 != null ? (View) weakReference2.get() : null;
            if (actionMasked != 2 || view3 == null || this.N || this.L == 1 || coordinatorLayout.o(view3, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.M == null || (i9 = this.Z) == -1 || Math.abs(i9 - motionEvent.getY()) <= this.M.f9214b) {
                return false;
            }
        }
        return true;
    }

    @Override // a0.d
    public final boolean h(CoordinatorLayout coordinatorLayout, View view, int i9) {
        WeakHashMap weakHashMap = t0.f7209a;
        if (c0.b(coordinatorLayout) && !c0.b(view)) {
            view.setFitsSystemWindows(true);
        }
        if (this.U == null) {
            this.f1930g = coordinatorLayout.getResources().getDimensionPixelSize(2131165293);
            int i10 = Build.VERSION.SDK_INT;
            boolean z8 = (i10 < 29 || this.f1936n || this.f1929f) ? false : true;
            if (this.f1937o || this.f1938p || this.f1939q || this.f1941s || this.f1942t || this.f1943u || z8) {
                p pVar = new p(this, z8);
                int f9 = d0.f(view);
                view.getPaddingTop();
                int e9 = d0.e(view);
                int paddingBottom = view.getPaddingBottom();
                l lVar = new l();
                lVar.f1212a = f9;
                lVar.f1213b = e9;
                lVar.f1214c = paddingBottom;
                i0.u(view, new m1.b(pVar, 13, lVar));
                if (f0.b(view)) {
                    g0.c(view);
                } else {
                    view.addOnAttachStateChangeListener(new o5.p());
                }
            }
            n0.e eVar = new n0.e(view);
            if (i10 >= 30) {
                view.setWindowInsetsAnimationCallback(new j1(eVar));
            } else {
                PathInterpolator pathInterpolator = i1.f7165e;
                Object tag = view.getTag(2131362423);
                View.OnApplyWindowInsetsListener h1Var = new h1(view, eVar);
                view.setTag(2131362431, h1Var);
                if (tag == null) {
                    view.setOnApplyWindowInsetsListener(h1Var);
                }
            }
            this.U = new WeakReference(view);
            Context context = view.getContext();
            android.support.v4.media.session.b.o0(context, 2130969368, p0.a.b(0.0f, 0.0f, 0.0f, 1.0f));
            android.support.v4.media.session.b.n0(context, 2130969351, IjkMediaCodecInfo.RANK_SECURE);
            android.support.v4.media.session.b.n0(context, 2130969356, 150);
            android.support.v4.media.session.b.n0(context, 2130969355, 100);
            Resources resources = view.getResources();
            resources.getDimension(2131165391);
            resources.getDimension(2131165392);
            g gVar = this.f1931i;
            if (gVar != null) {
                c0.q(view, gVar);
                float f10 = this.H;
                if (f10 == -1.0f) {
                    f10 = i0.i(view);
                }
                gVar.k(f10);
            } else {
                ColorStateList colorStateList = this.f1932j;
                if (colorStateList != null) {
                    t0.r(view, colorStateList);
                }
            }
            G();
            if (c0.c(view) == 0) {
                c0.s(view, 1);
            }
        }
        if (this.M == null) {
            this.M = new v0.d(coordinatorLayout.getContext(), coordinatorLayout, this.f1927d0);
        }
        int top = view.getTop();
        coordinatorLayout.q(view, i9);
        this.S = coordinatorLayout.getWidth();
        this.T = coordinatorLayout.getHeight();
        int height = view.getHeight();
        this.R = height;
        int i11 = this.T;
        int i12 = i11 - height;
        int i13 = this.f1945w;
        if (i12 < i13) {
            boolean z9 = this.f1940r;
            int i14 = this.f1934l;
            if (z9) {
                if (i14 != -1) {
                    i11 = Math.min(i11, i14);
                }
                this.R = i11;
            } else {
                int i15 = i11 - i13;
                if (i14 != -1) {
                    i15 = Math.min(i15, i14);
                }
                this.R = i15;
            }
        }
        this.D = Math.max(0, this.T - this.R);
        this.E = (int) ((1.0f - this.F) * this.T);
        s();
        int i16 = this.L;
        if (i16 == 3) {
            t0.k(view, y());
        } else if (i16 == 6) {
            t0.k(view, this.E);
        } else if (this.I && i16 == 5) {
            t0.k(view, this.T);
        } else if (i16 == 4) {
            t0.k(view, this.G);
        } else if (i16 == 1 || i16 == 2) {
            t0.k(view, top - view.getTop());
        }
        H(this.L, false);
        this.V = new WeakReference(w(view));
        ArrayList arrayList = this.W;
        if (arrayList.size() <= 0) {
            return true;
        }
        arrayList.get(0).getClass();
        androidx.fragment.app.a.c();
        return false;
    }

    @Override // a0.d
    public final boolean i(CoordinatorLayout coordinatorLayout, View view, int i9, int i10, int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(x(i9, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i10, this.f1933k, marginLayoutParams.width), x(i11, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, this.f1934l, marginLayoutParams.height));
        return true;
    }

    @Override // a0.d
    public final boolean j(View view) {
        WeakReference weakReference = this.V;
        return (weakReference == null || view != weakReference.get() || this.L == 3) ? false : true;
    }

    @Override // a0.d
    public final void k(CoordinatorLayout coordinatorLayout, View view, View view2, int i9, int i10, int[] iArr, int i11) {
        if (i11 == 1) {
            return;
        }
        WeakReference weakReference = this.V;
        if (view2 != (weakReference != null ? (View) weakReference.get() : null)) {
            return;
        }
        int top = view.getTop();
        int i12 = top - i10;
        if (i10 > 0) {
            if (i12 < y()) {
                int y2 = top - y();
                iArr[1] = y2;
                t0.k(view, -y2);
                D(3);
            } else {
                if (!this.K) {
                    return;
                }
                iArr[1] = i10;
                t0.k(view, -i10);
                D(1);
            }
        } else if (i10 < 0 && !view2.canScrollVertically(-1)) {
            int i13 = this.G;
            if (i12 > i13 && !this.I) {
                int i14 = top - i13;
                iArr[1] = i14;
                t0.k(view, -i14);
                D(4);
            } else {
                if (!this.K) {
                    return;
                }
                iArr[1] = i10;
                t0.k(view, -i10);
                D(1);
            }
        }
        v(view.getTop());
        this.O = i10;
        this.P = true;
    }

    @Override // a0.d
    public final void n(View view, Parcelable parcelable) {
        d5.d dVar = (d5.d) parcelable;
        int i9 = this.f1920a;
        if (i9 != 0) {
            if (i9 == -1 || (i9 & 1) == 1) {
                this.f1928e = dVar.f2952l;
            }
            if (i9 == -1 || (i9 & 2) == 2) {
                this.f1922b = dVar.f2953m;
            }
            if (i9 == -1 || (i9 & 4) == 4) {
                this.I = dVar.f2954n;
            }
            if (i9 == -1 || (i9 & 8) == 8) {
                this.J = dVar.f2955o;
            }
        }
        int i10 = dVar.f2951k;
        if (i10 == 1 || i10 == 2) {
            this.L = 4;
        } else {
            this.L = i10;
        }
    }

    @Override // a0.d
    public final Parcelable o(View view) {
        AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
        return new d5.d(this);
    }

    @Override // a0.d
    public final boolean p(CoordinatorLayout coordinatorLayout, View view, View view2, int i9, int i10) {
        this.O = 0;
        this.P = false;
        return (i9 & 2) != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
    
        if (r4.getTop() <= r2.E) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0071, code lost:
    
        if (java.lang.Math.abs(r3 - r2.D) < java.lang.Math.abs(r3 - r2.G)) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0080, code lost:
    
        if (r3 < java.lang.Math.abs(r3 - r2.G)) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0090, code lost:
    
        if (java.lang.Math.abs(r3 - r1) < java.lang.Math.abs(r3 - r2.G)) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ac, code lost:
    
        if (java.lang.Math.abs(r3 - r2.E) < java.lang.Math.abs(r3 - r2.G)) goto L50;
     */
    @Override // a0.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q(androidx.coordinatorlayout.widget.CoordinatorLayout r3, android.view.View r4, android.view.View r5, int r6) {
        /*
            r2 = this;
            int r3 = r4.getTop()
            int r6 = r2.y()
            r0 = 3
            if (r3 != r6) goto Lf
            r2.D(r0)
            return
        Lf:
            java.lang.ref.WeakReference r3 = r2.V
            if (r3 == 0) goto Lb5
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto Lb5
            boolean r3 = r2.P
            if (r3 != 0) goto L1f
            goto Lb5
        L1f:
            int r3 = r2.O
            r5 = 6
            if (r3 <= 0) goto L34
            boolean r3 = r2.f1922b
            if (r3 == 0) goto L2a
            goto Laf
        L2a:
            int r3 = r4.getTop()
            int r6 = r2.E
            if (r3 <= r6) goto Laf
            goto Lae
        L34:
            boolean r3 = r2.I
            if (r3 == 0) goto L55
            android.view.VelocityTracker r3 = r2.X
            if (r3 != 0) goto L3e
            r3 = 0
            goto L4d
        L3e:
            r6 = 1000(0x3e8, float:1.401E-42)
            float r1 = r2.f1924c
            r3.computeCurrentVelocity(r6, r1)
            android.view.VelocityTracker r3 = r2.X
            int r6 = r2.Y
            float r3 = r3.getYVelocity(r6)
        L4d:
            boolean r3 = r2.E(r4, r3)
            if (r3 == 0) goto L55
            r0 = 5
            goto Laf
        L55:
            int r3 = r2.O
            r6 = 4
            if (r3 != 0) goto L93
            int r3 = r4.getTop()
            boolean r1 = r2.f1922b
            if (r1 == 0) goto L74
            int r5 = r2.D
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            int r1 = r2.G
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r5 >= r3) goto L97
            goto Laf
        L74:
            int r1 = r2.E
            if (r3 >= r1) goto L83
            int r6 = r2.G
            int r6 = r3 - r6
            int r6 = java.lang.Math.abs(r6)
            if (r3 >= r6) goto Lae
            goto Laf
        L83:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.G
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L97
            goto Lae
        L93:
            boolean r3 = r2.f1922b
            if (r3 == 0) goto L99
        L97:
            r0 = 4
            goto Laf
        L99:
            int r3 = r4.getTop()
            int r0 = r2.E
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.G
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L97
        Lae:
            r0 = 6
        Laf:
            r3 = 0
            r2.F(r4, r0, r3)
            r2.P = r3
        Lb5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.q(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    @Override // a0.d
    public final boolean r(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        int i9 = this.L;
        if (i9 == 1 && actionMasked == 0) {
            return true;
        }
        v0.d dVar = this.M;
        if (dVar != null && (this.K || i9 == 1)) {
            dVar.j(motionEvent);
        }
        if (actionMasked == 0) {
            this.Y = -1;
            this.Z = -1;
            VelocityTracker velocityTracker = this.X;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.X = null;
            }
        }
        if (this.X == null) {
            this.X = VelocityTracker.obtain();
        }
        this.X.addMovement(motionEvent);
        if (this.M != null && ((this.K || this.L == 1) && actionMasked == 2 && !this.N)) {
            float abs = Math.abs(this.Z - motionEvent.getY());
            v0.d dVar2 = this.M;
            if (abs > dVar2.f9214b) {
                dVar2.b(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.N;
    }

    public final void s() {
        int u3 = u();
        boolean z8 = this.f1922b;
        int i9 = this.T;
        if (z8) {
            this.G = Math.max(i9 - u3, this.D);
        } else {
            this.G = i9 - u3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0023, code lost:
    
        r0 = r0.getRootWindowInsets();
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float t() {
        /*
            r5 = this;
            u5.g r0 = r5.f1931i
            r1 = 0
            if (r0 == 0) goto L6f
            java.lang.ref.WeakReference r0 = r5.U
            if (r0 == 0) goto L6f
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L6f
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 31
            if (r0 < r2) goto L6f
            java.lang.ref.WeakReference r0 = r5.U
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            boolean r2 = r5.A()
            if (r2 == 0) goto L6f
            android.view.WindowInsets r0 = a5.c.m(r0)
            if (r0 == 0) goto L6f
            u5.g r2 = r5.f1931i
            float r2 = r2.g()
            android.view.RoundedCorner r3 = d5.a.l(r0)
            if (r3 == 0) goto L44
            int r3 = d5.a.b(r3)
            float r3 = (float) r3
            int r4 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r4 <= 0) goto L44
            int r4 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r4 <= 0) goto L44
            float r3 = r3 / r2
            goto L45
        L44:
            r3 = 0
        L45:
            u5.g r2 = r5.f1931i
            u5.f r4 = r2.f9084i
            u5.j r4 = r4.f9069a
            u5.c r4 = r4.f9108f
            android.graphics.RectF r2 = r2.f()
            float r2 = r4.a(r2)
            android.view.RoundedCorner r0 = d5.a.x(r0)
            if (r0 == 0) goto L6a
            int r0 = d5.a.b(r0)
            float r0 = (float) r0
            int r4 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r4 <= 0) goto L6a
            int r4 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r4 <= 0) goto L6a
            float r1 = r0 / r2
        L6a:
            float r0 = java.lang.Math.max(r3, r1)
            return r0
        L6f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.t():float");
    }

    public final int u() {
        int i9;
        return this.f1929f ? Math.min(Math.max(this.f1930g, this.T - ((this.S * 9) / 16)), this.R) + this.f1944v : (this.f1936n || this.f1937o || (i9 = this.f1935m) <= 0) ? this.f1928e + this.f1944v : Math.max(this.f1928e, i9 + this.h);
    }

    public final void v(int i9) {
        if (((View) this.U.get()) != null) {
            ArrayList arrayList = this.W;
            if (arrayList.isEmpty()) {
                return;
            }
            int i10 = this.G;
            if (i9 <= i10 && i10 != y()) {
                y();
            }
            if (arrayList.size() <= 0) {
                return;
            }
            arrayList.get(0).getClass();
            androidx.fragment.app.a.c();
        }
    }

    public final int y() {
        if (this.f1922b) {
            return this.D;
        }
        return Math.max(this.C, this.f1940r ? 0 : this.f1945w);
    }

    public final int z(int i9) {
        if (i9 == 3) {
            return y();
        }
        if (i9 == 4) {
            return this.G;
        }
        if (i9 == 5) {
            return this.T;
        }
        if (i9 == 6) {
            return this.E;
        }
        m7.c.n(androidx.activity.g.m(i9, "Invalid state to get top offset: "));
        return 0;
    }

    public BottomSheetBehavior() {
        this.f1920a = 0;
        this.f1922b = true;
        this.f1933k = -1;
        this.f1934l = -1;
        this.A = new e(this);
        this.F = 0.5f;
        this.H = -1.0f;
        this.K = true;
        this.L = 4;
        this.Q = 0.1f;
        this.W = new ArrayList();
        this.Z = -1;
        this.f1925c0 = new SparseIntArray();
        this.f1927d0 = new c(this, 0);
    }

    @Override // a0.d
    public final void l(CoordinatorLayout coordinatorLayout, View view, int i9, int i10, int i11, int[] iArr) {
    }
}
