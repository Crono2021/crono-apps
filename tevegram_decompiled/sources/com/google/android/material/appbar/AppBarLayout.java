package com.google.android.material.appbar;

import a5.h;
import a5.i;
import a5.k;
import a5.l;
import android.animation.AnimatorInflater;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import n0.a2;
import n0.c0;
import n0.d0;
import n0.f0;
import n0.i0;
import n0.n;
import n0.t0;
import o5.o;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import u5.g;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class AppBarLayout extends LinearLayout implements a0.c {
    public static final /* synthetic */ int F = 0;
    public final TimeInterpolator A;
    public int[] B;
    public Drawable C;
    public final float D;
    public Behavior E;

    /* renamed from: i, reason: collision with root package name */
    public int f1861i;

    /* renamed from: j, reason: collision with root package name */
    public int f1862j;

    /* renamed from: k, reason: collision with root package name */
    public int f1863k;

    /* renamed from: l, reason: collision with root package name */
    public int f1864l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1865m;

    /* renamed from: n, reason: collision with root package name */
    public int f1866n;

    /* renamed from: o, reason: collision with root package name */
    public a2 f1867o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f1868p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f1869q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f1870r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f1871s;

    /* renamed from: t, reason: collision with root package name */
    public int f1872t;

    /* renamed from: u, reason: collision with root package name */
    public WeakReference f1873u;

    /* renamed from: v, reason: collision with root package name */
    public final ColorStateList f1874v;

    /* renamed from: w, reason: collision with root package name */
    public ValueAnimator f1875w;

    /* renamed from: x, reason: collision with root package name */
    public final ValueAnimator.AnimatorUpdateListener f1876x;

    /* renamed from: y, reason: collision with root package name */
    public final ArrayList f1877y;

    /* renamed from: z, reason: collision with root package name */
    public final long f1878z;

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(z5.a.a(context, attributeSet, 2130968630, 2132018005), attributeSet, 2130968630);
        this.f1862j = -1;
        this.f1863k = -1;
        this.f1864l = -1;
        int i9 = 0;
        this.f1866n = 0;
        this.f1877y = new ArrayList();
        Context context2 = getContext();
        int i10 = 1;
        setOrientation(1);
        if (getOutlineProvider() == ViewOutlineProvider.BACKGROUND) {
            setOutlineProvider(ViewOutlineProvider.BOUNDS);
        }
        Context context3 = getContext();
        TypedArray f9 = o.f(context3, attributeSet, l.f199a, 2130968630, 2132018005, new int[0]);
        try {
            if (f9.hasValue(0)) {
                setStateListAnimator(AnimatorInflater.loadStateListAnimator(context3, f9.getResourceId(0, 0)));
            }
            f9.recycle();
            TypedArray f10 = o.f(context2, attributeSet, y4.a.f10496a, 2130968630, 2132018005, new int[0]);
            Drawable drawable = f10.getDrawable(0);
            WeakHashMap weakHashMap = t0.f7209a;
            c0.q(this, drawable);
            ColorStateList B = com.bumptech.glide.d.B(context2, f10, 6);
            this.f1874v = B;
            ColorStateList backgroundCSL = getBackgroundCSL();
            if (backgroundCSL != null) {
                g gVar = new g();
                gVar.l(backgroundCSL);
                if (B != null) {
                    gVar.setAlpha(this.f1870r ? 255 : 0);
                    gVar.l(B);
                    this.f1876x = new a5.b(this, i10, gVar);
                } else {
                    gVar.i(context2);
                    this.f1876x = new a5.b(this, i9, gVar);
                }
                c0.q(this, gVar);
            }
            this.f1878z = android.support.v4.media.session.b.n0(context2, 2130969351, getResources().getInteger(2131427330));
            this.A = android.support.v4.media.session.b.o0(context2, 2130969369, z4.a.f10659a);
            if (f10.hasValue(4)) {
                d(f10.getBoolean(4, false), false, false);
            }
            if (f10.hasValue(3)) {
                l.a(this, f10.getDimensionPixelSize(3, 0));
            }
            if (Build.VERSION.SDK_INT >= 26) {
                if (f10.hasValue(2)) {
                    setKeyboardNavigationCluster(f10.getBoolean(2, false));
                }
                if (f10.hasValue(1)) {
                    setTouchscreenBlocksFocus(f10.getBoolean(1, false));
                }
            }
            this.D = getResources().getDimension(2131165278);
            this.f1871s = f10.getBoolean(5, false);
            this.f1872t = f10.getResourceId(7, -1);
            setStatusBarForeground(f10.getDrawable(8));
            f10.recycle();
            i0.u(this, new a0.b(this, 2));
        } catch (Throwable th) {
            f9.recycle();
            throw th;
        }
    }

    public static a5.f b(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            a5.f fVar = new a5.f((LinearLayout.LayoutParams) layoutParams);
            fVar.f176a = 1;
            return fVar;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            a5.f fVar2 = new a5.f((ViewGroup.MarginLayoutParams) layoutParams);
            fVar2.f176a = 1;
            return fVar2;
        }
        a5.f fVar3 = new a5.f(layoutParams);
        fVar3.f176a = 1;
        return fVar3;
    }

    private ColorStateList getBackgroundCSL() {
        ColorStateList b9;
        Drawable background = getBackground();
        if (background instanceof ColorDrawable) {
            return ColorStateList.valueOf(((ColorDrawable) background).getColor());
        }
        if (Build.VERSION.SDK_INT < 29) {
            return null;
        }
        b9 = a5.e.b(background);
        return b9;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final a5.f generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        a5.f fVar = new a5.f(context, attributeSet);
        fVar.f176a = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y4.a.f10497b);
        fVar.f176a = obtainStyledAttributes.getInt(1, 0);
        fVar.f177b = obtainStyledAttributes.getInt(0, 0) != 1 ? null : new a5.d(0);
        if (obtainStyledAttributes.hasValue(2)) {
            fVar.f178c = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(2, 0));
        }
        obtainStyledAttributes.recycle();
        return fVar;
    }

    public final void c() {
        Behavior behavior = this.E;
        f A = (behavior == null || this.f1862j == -1 || this.f1866n != 0) ? null : behavior.A(u0.b.f8990j, this);
        this.f1862j = -1;
        this.f1863k = -1;
        this.f1864l = -1;
        if (A != null) {
            Behavior behavior2 = this.E;
            if (behavior2.f1882m != null) {
                return;
            }
            behavior2.f1882m = A;
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a5.f;
    }

    public final void d(boolean z8, boolean z9, boolean z10) {
        this.f1866n = (z8 ? 1 : 2) | (z9 ? 4 : 0) | (z10 ? 8 : 0);
        requestLayout();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.C == null || getTopInset() <= 0) {
            return;
        }
        int save = canvas.save();
        canvas.translate(0.0f, -this.f1861i);
        this.C.draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.C;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    public final boolean e(boolean z8) {
        if (this.f1868p || this.f1870r == z8) {
            return false;
        }
        this.f1870r = z8;
        refreshDrawableState();
        if (!this.f1871s || !(getBackground() instanceof g)) {
            return true;
        }
        if (this.f1874v != null) {
            g(z8 ? 0.0f : 255.0f, z8 ? 255.0f : 0.0f);
            return true;
        }
        float f9 = this.D;
        g(z8 ? 0.0f : f9, z8 ? f9 : 0.0f);
        return true;
    }

    public final boolean f(View view) {
        int i9;
        if (this.f1873u == null && (i9 = this.f1872t) != -1) {
            View findViewById = view != null ? view.findViewById(i9) : null;
            if (findViewById == null && (getParent() instanceof ViewGroup)) {
                findViewById = ((ViewGroup) getParent()).findViewById(this.f1872t);
            }
            if (findViewById != null) {
                this.f1873u = new WeakReference(findViewById);
            }
        }
        WeakReference weakReference = this.f1873u;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null) {
            view = view2;
        }
        if (view != null) {
            return view.canScrollVertically(-1) || view.getScrollY() > 0;
        }
        return false;
    }

    public final void g(float f9, float f10) {
        ValueAnimator valueAnimator = this.f1875w;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f9, f10);
        this.f1875w = ofFloat;
        ofFloat.setDuration(this.f1878z);
        this.f1875w.setInterpolator(this.A);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.f1876x;
        if (animatorUpdateListener != null) {
            this.f1875w.addUpdateListener(animatorUpdateListener);
        }
        this.f1875w.start();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        a5.f fVar = new a5.f(-1, -2);
        fVar.f176a = 1;
        return fVar;
    }

    @Override // a0.c
    public a0.d getBehavior() {
        Behavior behavior = new Behavior();
        this.E = behavior;
        return behavior;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int getDownNestedPreScrollRange() {
        /*
            r9 = this;
            int r0 = r9.f1863k
            r1 = -1
            if (r0 == r1) goto L6
            return r0
        L6:
            int r0 = r9.getChildCount()
            int r0 = r0 + (-1)
            r1 = 0
            r2 = 0
        Le:
            if (r0 < 0) goto L69
            android.view.View r3 = r9.getChildAt(r0)
            int r4 = r3.getVisibility()
            r5 = 8
            if (r4 != r5) goto L1d
            goto L66
        L1d:
            android.view.ViewGroup$LayoutParams r4 = r3.getLayoutParams()
            a5.f r4 = (a5.f) r4
            int r5 = r3.getMeasuredHeight()
            int r6 = r4.f176a
            r7 = r6 & 5
            r8 = 5
            if (r7 != r8) goto L63
            int r7 = r4.topMargin
            int r4 = r4.bottomMargin
            int r7 = r7 + r4
            r4 = r6 & 8
            if (r4 == 0) goto L3f
            java.util.WeakHashMap r4 = n0.t0.f7209a
            int r4 = n0.c0.d(r3)
        L3d:
            int r4 = r4 + r7
            goto L4e
        L3f:
            r4 = r6 & 2
            if (r4 == 0) goto L4c
            java.util.WeakHashMap r4 = n0.t0.f7209a
            int r4 = n0.c0.d(r3)
            int r4 = r5 - r4
            goto L3d
        L4c:
            int r4 = r7 + r5
        L4e:
            if (r0 != 0) goto L61
            java.util.WeakHashMap r6 = n0.t0.f7209a
            boolean r3 = n0.c0.b(r3)
            if (r3 == 0) goto L61
            int r3 = r9.getTopInset()
            int r5 = r5 - r3
            int r4 = java.lang.Math.min(r4, r5)
        L61:
            int r2 = r2 + r4
            goto L66
        L63:
            if (r2 <= 0) goto L66
            goto L69
        L66:
            int r0 = r0 + (-1)
            goto Le
        L69:
            int r0 = java.lang.Math.max(r1, r2)
            r9.f1863k = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.getDownNestedPreScrollRange():int");
    }

    public int getDownNestedScrollRange() {
        int i9 = this.f1864l;
        if (i9 != -1) {
            return i9;
        }
        int childCount = getChildCount();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i10 >= childCount) {
                break;
            }
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                a5.f fVar = (a5.f) childAt.getLayoutParams();
                int measuredHeight = ((LinearLayout.LayoutParams) fVar).topMargin + ((LinearLayout.LayoutParams) fVar).bottomMargin + childAt.getMeasuredHeight();
                int i12 = fVar.f176a;
                if ((i12 & 1) == 0) {
                    break;
                }
                i11 += measuredHeight;
                if ((i12 & 2) != 0) {
                    WeakHashMap weakHashMap = t0.f7209a;
                    i11 -= c0.d(childAt);
                    break;
                }
            }
            i10++;
        }
        int max = Math.max(0, i11);
        this.f1864l = max;
        return max;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.f1872t;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        WeakHashMap weakHashMap = t0.f7209a;
        int d9 = c0.d(this);
        if (d9 == 0) {
            int childCount = getChildCount();
            d9 = childCount >= 1 ? c0.d(getChildAt(childCount - 1)) : 0;
            if (d9 == 0) {
                return getHeight() / 3;
            }
        }
        return (d9 * 2) + topInset;
    }

    public int getPendingAction() {
        return this.f1866n;
    }

    public Drawable getStatusBarForeground() {
        return this.C;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public final int getTopInset() {
        a2 a2Var = this.f1867o;
        if (a2Var != null) {
            return a2Var.d();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i9 = this.f1862j;
        if (i9 != -1) {
            return i9;
        }
        int childCount = getChildCount();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i10 >= childCount) {
                break;
            }
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                a5.f fVar = (a5.f) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i12 = fVar.f176a;
                if ((i12 & 1) == 0) {
                    break;
                }
                int i13 = measuredHeight + ((LinearLayout.LayoutParams) fVar).topMargin + ((LinearLayout.LayoutParams) fVar).bottomMargin + i11;
                if (i10 == 0) {
                    WeakHashMap weakHashMap = t0.f7209a;
                    if (c0.b(childAt)) {
                        i13 -= getTopInset();
                    }
                }
                i11 = i13;
                if ((i12 & 2) != 0) {
                    WeakHashMap weakHashMap2 = t0.f7209a;
                    i11 -= c0.d(childAt);
                    break;
                }
            }
            i10++;
        }
        int max = Math.max(0, i11);
        this.f1862j = max;
        return max;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof g) {
            com.bumptech.glide.d.b0(this, (g) background);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i9) {
        if (this.B == null) {
            this.B = new int[4];
        }
        int[] iArr = this.B;
        int[] onCreateDrawableState = super.onCreateDrawableState(i9 + iArr.length);
        boolean z8 = this.f1869q;
        iArr[0] = z8 ? 2130969548 : -2130969548;
        iArr[1] = (z8 && this.f1870r) ? 2130969549 : -2130969549;
        iArr[2] = z8 ? 2130969544 : -2130969544;
        iArr[3] = (z8 && this.f1870r) ? 2130969543 : -2130969543;
        return View.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WeakReference weakReference = this.f1873u;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f1873u = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        super.onLayout(z8, i9, i10, i11, i12);
        WeakHashMap weakHashMap = t0.f7209a;
        boolean z9 = true;
        if (c0.b(this) && getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt.getVisibility() != 8 && !c0.b(childAt)) {
                int topInset = getTopInset();
                for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                    t0.k(getChildAt(childCount), topInset);
                }
            }
        }
        c();
        this.f1865m = false;
        int childCount2 = getChildCount();
        int i13 = 0;
        while (true) {
            if (i13 >= childCount2) {
                break;
            }
            if (((a5.f) getChildAt(i13).getLayoutParams()).f178c != null) {
                this.f1865m = true;
                break;
            }
            i13++;
        }
        Drawable drawable = this.C;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.f1868p) {
            return;
        }
        if (!this.f1871s) {
            int childCount3 = getChildCount();
            int i14 = 0;
            while (true) {
                if (i14 >= childCount3) {
                    z9 = false;
                    break;
                }
                int i15 = ((a5.f) getChildAt(i14).getLayoutParams()).f176a;
                if ((i15 & 1) == 1 && (i15 & 10) != 0) {
                    break;
                } else {
                    i14++;
                }
            }
        }
        if (this.f1869q != z9) {
            this.f1869q = z9;
            refreshDrawableState();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i9, int i10) {
        super.onMeasure(i9, i10);
        int mode = View.MeasureSpec.getMode(i10);
        if (mode != 1073741824) {
            WeakHashMap weakHashMap = t0.f7209a;
            if (c0.b(this) && getChildCount() > 0) {
                View childAt = getChildAt(0);
                if (childAt.getVisibility() != 8 && !c0.b(childAt)) {
                    int measuredHeight = getMeasuredHeight();
                    if (mode == Integer.MIN_VALUE) {
                        measuredHeight = com.bumptech.glide.c.i(getTopInset() + getMeasuredHeight(), 0, View.MeasureSpec.getSize(i10));
                    } else if (mode == 0) {
                        measuredHeight += getTopInset();
                    }
                    setMeasuredDimension(getMeasuredWidth(), measuredHeight);
                }
            }
        }
        c();
    }

    @Override // android.view.View
    public void setElevation(float f9) {
        super.setElevation(f9);
        Drawable background = getBackground();
        if (background instanceof g) {
            ((g) background).k(f9);
        }
    }

    public void setExpanded(boolean z8) {
        WeakHashMap weakHashMap = t0.f7209a;
        d(z8, f0.c(this), true);
    }

    public void setLiftOnScroll(boolean z8) {
        this.f1871s = z8;
    }

    public void setLiftOnScrollTargetView(View view) {
        this.f1872t = -1;
        if (view != null) {
            this.f1873u = new WeakReference(view);
            return;
        }
        WeakReference weakReference = this.f1873u;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f1873u = null;
    }

    public void setLiftOnScrollTargetViewId(int i9) {
        this.f1872t = i9;
        WeakReference weakReference = this.f1873u;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f1873u = null;
    }

    public void setLiftableOverrideEnabled(boolean z8) {
        this.f1868p = z8;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i9) {
        if (i9 == 1) {
            super.setOrientation(i9);
        } else {
            m7.c.n("AppBarLayout is always vertical and does not support horizontal orientation");
        }
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.C;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.C = mutate;
            boolean z8 = false;
            if (mutate != null) {
                if (mutate.isStateful()) {
                    this.C.setState(getDrawableState());
                }
                Drawable drawable3 = this.C;
                WeakHashMap weakHashMap = t0.f7209a;
                com.bumptech.glide.d.a0(drawable3, d0.d(this));
                this.C.setVisible(getVisibility() == 0, false);
                this.C.setCallback(this);
            }
            if (this.C != null && getTopInset() > 0) {
                z8 = true;
            }
            setWillNotDraw(true ^ z8);
            WeakHashMap weakHashMap2 = t0.f7209a;
            c0.k(this);
        }
    }

    public void setStatusBarForegroundColor(int i9) {
        setStatusBarForeground(new ColorDrawable(i9));
    }

    public void setStatusBarForegroundResource(int i9) {
        setStatusBarForeground(android.support.v4.media.session.b.I(getContext(), i9));
    }

    @Deprecated
    public void setTargetElevation(float f9) {
        l.a(this, f9);
    }

    @Override // android.view.View
    public void setVisibility(int i9) {
        super.setVisibility(i9);
        boolean z8 = i9 == 0;
        Drawable drawable = this.C;
        if (drawable != null) {
            drawable.setVisible(z8, false);
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.C;
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return b(layoutParams);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return b(layoutParams);
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public static class BaseBehavior<T extends AppBarLayout> extends h {

        /* renamed from: j, reason: collision with root package name */
        public int f1879j;

        /* renamed from: k, reason: collision with root package name */
        public int f1880k;

        /* renamed from: l, reason: collision with root package name */
        public ValueAnimator f1881l;

        /* renamed from: m, reason: collision with root package name */
        public f f1882m;

        /* renamed from: n, reason: collision with root package name */
        public WeakReference f1883n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f1884o;

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(0);
            this.f186f = -1;
            this.h = -1;
        }

        public static void D(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i9, int i10, boolean z8) {
            View view;
            boolean z9;
            Drawable foreground;
            Drawable foreground2;
            int abs = Math.abs(i9);
            int childCount = appBarLayout.getChildCount();
            int i11 = 0;
            while (true) {
                if (i11 >= childCount) {
                    view = null;
                    break;
                }
                view = appBarLayout.getChildAt(i11);
                if (abs >= view.getTop() && abs <= view.getBottom()) {
                    break;
                } else {
                    i11++;
                }
            }
            if (view != null) {
                int i12 = ((a5.f) view.getLayoutParams()).f176a;
                if ((i12 & 1) != 0) {
                    WeakHashMap weakHashMap = t0.f7209a;
                    int d9 = c0.d(view);
                    z9 = true;
                    if (i10 > 0) {
                    }
                }
            }
            z9 = false;
            if (appBarLayout.f1871s) {
                z9 = appBarLayout.f(y(coordinatorLayout));
            }
            boolean e9 = appBarLayout.e(z9);
            if (!z8) {
                if (e9) {
                    List list = (List) ((s.h) coordinatorLayout.f550j.f31j).getOrDefault(appBarLayout, null);
                    ArrayList arrayList = coordinatorLayout.f552l;
                    arrayList.clear();
                    if (list != null) {
                        arrayList.addAll(list);
                    }
                    int size = arrayList.size();
                    for (int i13 = 0; i13 < size; i13++) {
                        a0.d dVar = ((a0.g) ((View) arrayList.get(i13)).getLayoutParams()).f10a;
                        if (dVar instanceof ScrollingViewBehavior) {
                            if (((ScrollingViewBehavior) dVar).f192f == 0) {
                                return;
                            }
                        }
                    }
                    return;
                }
                return;
            }
            if (appBarLayout.getBackground() != null) {
                appBarLayout.getBackground().jumpToCurrentState();
            }
            if (Build.VERSION.SDK_INT >= 23) {
                foreground = appBarLayout.getForeground();
                if (foreground != null) {
                    foreground2 = appBarLayout.getForeground();
                    foreground2.jumpToCurrentState();
                }
            }
            if (appBarLayout.getStateListAnimator() != null) {
                appBarLayout.getStateListAnimator().jumpToCurrentState();
            }
        }

        public static View y(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = coordinatorLayout.getChildAt(i9);
                if ((childAt instanceof n) || (childAt instanceof AbsListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        public final f A(Parcelable parcelable, AppBarLayout appBarLayout) {
            int s8 = s();
            int childCount = appBarLayout.getChildCount();
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = appBarLayout.getChildAt(i9);
                int bottom = childAt.getBottom() + s8;
                if (childAt.getTop() + s8 <= 0 && bottom >= 0) {
                    if (parcelable == null) {
                        parcelable = u0.b.f8990j;
                    }
                    f fVar = new f(parcelable);
                    boolean z8 = s8 == 0;
                    fVar.f1902l = z8;
                    fVar.f1901k = !z8 && (-s8) >= appBarLayout.getTotalScrollRange();
                    fVar.f1903m = i9;
                    WeakHashMap weakHashMap = t0.f7209a;
                    fVar.f1905o = bottom == appBarLayout.getTopInset() + c0.d(childAt);
                    fVar.f1904n = bottom / childAt.getHeight();
                    return fVar;
                }
            }
            return null;
        }

        public final void B(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int paddingTop = appBarLayout.getPaddingTop() + appBarLayout.getTopInset();
            int u3 = u() - paddingTop;
            int childCount = appBarLayout.getChildCount();
            int i9 = 0;
            while (true) {
                if (i9 >= childCount) {
                    i9 = -1;
                    break;
                }
                View childAt = appBarLayout.getChildAt(i9);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                a5.f fVar = (a5.f) childAt.getLayoutParams();
                if ((fVar.f176a & 32) == 32) {
                    top -= ((LinearLayout.LayoutParams) fVar).topMargin;
                    bottom += ((LinearLayout.LayoutParams) fVar).bottomMargin;
                }
                int i10 = -u3;
                if (top <= i10 && bottom >= i10) {
                    break;
                } else {
                    i9++;
                }
            }
            if (i9 >= 0) {
                View childAt2 = appBarLayout.getChildAt(i9);
                a5.f fVar2 = (a5.f) childAt2.getLayoutParams();
                int i11 = fVar2.f176a;
                if ((i11 & 17) == 17) {
                    int i12 = -childAt2.getTop();
                    int i13 = -childAt2.getBottom();
                    if (i9 == 0) {
                        WeakHashMap weakHashMap = t0.f7209a;
                        if (c0.b(appBarLayout) && c0.b(childAt2)) {
                            i12 -= appBarLayout.getTopInset();
                        }
                    }
                    if ((i11 & 2) == 2) {
                        WeakHashMap weakHashMap2 = t0.f7209a;
                        i13 += c0.d(childAt2);
                    } else if ((i11 & 5) == 5) {
                        WeakHashMap weakHashMap3 = t0.f7209a;
                        int d9 = c0.d(childAt2) + i13;
                        if (u3 < d9) {
                            i12 = d9;
                        } else {
                            i13 = d9;
                        }
                    }
                    if ((i11 & 32) == 32) {
                        i12 += ((LinearLayout.LayoutParams) fVar2).topMargin;
                        i13 -= ((LinearLayout.LayoutParams) fVar2).bottomMargin;
                    }
                    if (u3 < (i13 + i12) / 2) {
                        i12 = i13;
                    }
                    x(coordinatorLayout, appBarLayout, com.bumptech.glide.c.i(i12 + paddingTop, -appBarLayout.getTotalScrollRange(), 0));
                }
            }
        }

        public final void C(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            View view;
            BaseBehavior<T> baseBehavior;
            t0.m(coordinatorLayout, o0.f.f7552f.a());
            boolean z8 = false;
            t0.i(coordinatorLayout, 0);
            t0.m(coordinatorLayout, o0.f.f7553g.a());
            t0.i(coordinatorLayout, 0);
            if (appBarLayout.getTotalScrollRange() != 0) {
                int childCount = coordinatorLayout.getChildCount();
                int i9 = 0;
                while (true) {
                    if (i9 >= childCount) {
                        view = null;
                        break;
                    }
                    view = coordinatorLayout.getChildAt(i9);
                    if (((a0.g) view.getLayoutParams()).f10a instanceof ScrollingViewBehavior) {
                        break;
                    } else {
                        i9++;
                    }
                }
                View view2 = view;
                if (view2 != null) {
                    int childCount2 = appBarLayout.getChildCount();
                    for (int i10 = 0; i10 < childCount2; i10++) {
                        if (((a5.f) appBarLayout.getChildAt(i10).getLayoutParams()).f176a != 0) {
                            if (t0.c(coordinatorLayout) == null) {
                                t0.p(coordinatorLayout, new b(this));
                            }
                            boolean z9 = true;
                            if (u() != (-appBarLayout.getTotalScrollRange())) {
                                t0.n(coordinatorLayout, o0.f.f7552f, new d(appBarLayout, false));
                                z8 = true;
                            }
                            if (u() != 0) {
                                if (view2.canScrollVertically(-1)) {
                                    int i11 = -appBarLayout.getDownNestedPreScrollRange();
                                    if (i11 != 0) {
                                        baseBehavior = this;
                                        t0.n(coordinatorLayout, o0.f.f7553g, new c(baseBehavior, coordinatorLayout, appBarLayout, view2, i11));
                                    }
                                } else {
                                    baseBehavior = this;
                                    t0.n(coordinatorLayout, o0.f.f7553g, new d(appBarLayout, true));
                                }
                                baseBehavior.f1884o = z9;
                                return;
                            }
                            baseBehavior = this;
                            z9 = z8;
                            baseBehavior.f1884o = z9;
                            return;
                        }
                    }
                }
            }
        }

        @Override // a5.j, a0.d
        public final boolean h(CoordinatorLayout coordinatorLayout, View view, int i9) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            super.h(coordinatorLayout, appBarLayout, i9);
            int pendingAction = appBarLayout.getPendingAction();
            f fVar = this.f1882m;
            if (fVar == null || (pendingAction & 8) != 0) {
                if (pendingAction != 0) {
                    boolean z8 = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        int i10 = -appBarLayout.getUpNestedPreScrollRange();
                        if (z8) {
                            x(coordinatorLayout, appBarLayout, i10);
                        } else {
                            w(coordinatorLayout, appBarLayout, i10);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z8) {
                            x(coordinatorLayout, appBarLayout, 0);
                        } else {
                            w(coordinatorLayout, appBarLayout, 0);
                        }
                    }
                }
            } else if (fVar.f1901k) {
                w(coordinatorLayout, appBarLayout, -appBarLayout.getTotalScrollRange());
            } else if (fVar.f1902l) {
                w(coordinatorLayout, appBarLayout, 0);
            } else {
                View childAt = appBarLayout.getChildAt(fVar.f1903m);
                int i11 = -childAt.getBottom();
                w(coordinatorLayout, appBarLayout, this.f1882m.f1905o ? appBarLayout.getTopInset() + c0.d(childAt) + i11 : Math.round(childAt.getHeight() * this.f1882m.f1904n) + i11);
            }
            appBarLayout.f1866n = 0;
            this.f1882m = null;
            int i12 = com.bumptech.glide.c.i(s(), -appBarLayout.getTotalScrollRange(), 0);
            k kVar = this.f193a;
            if (kVar == null) {
                this.f194b = i12;
            } else if (kVar.f197c != i12) {
                kVar.f197c = i12;
                kVar.a();
            }
            D(coordinatorLayout, appBarLayout, s(), 0, true);
            appBarLayout.f1861i = s();
            if (!appBarLayout.willNotDraw()) {
                WeakHashMap weakHashMap = t0.f7209a;
                c0.k(appBarLayout);
            }
            C(coordinatorLayout, appBarLayout);
            return true;
        }

        @Override // a0.d
        public final boolean i(CoordinatorLayout coordinatorLayout, View view, int i9, int i10, int i11) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (((ViewGroup.MarginLayoutParams) ((a0.g) appBarLayout.getLayoutParams())).height != -2) {
                return false;
            }
            coordinatorLayout.r(appBarLayout, i9, i10, View.MeasureSpec.makeMeasureSpec(0, 0));
            return true;
        }

        @Override // a0.d
        public final /* bridge */ /* synthetic */ void k(CoordinatorLayout coordinatorLayout, View view, View view2, int i9, int i10, int[] iArr, int i11) {
            z(coordinatorLayout, (AppBarLayout) view, view2, i10, iArr);
        }

        @Override // a0.d
        public final void l(CoordinatorLayout coordinatorLayout, View view, int i9, int i10, int i11, int[] iArr) {
            CoordinatorLayout coordinatorLayout2;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (i11 < 0) {
                coordinatorLayout2 = coordinatorLayout;
                iArr[1] = v(coordinatorLayout2, appBarLayout, u() - i11, -appBarLayout.getDownNestedScrollRange(), 0);
            } else {
                coordinatorLayout2 = coordinatorLayout;
            }
            if (i11 == 0) {
                C(coordinatorLayout2, appBarLayout);
            }
        }

        @Override // a0.d
        public final void n(View view, Parcelable parcelable) {
            if (parcelable instanceof f) {
                this.f1882m = (f) parcelable;
            } else {
                this.f1882m = null;
            }
        }

        @Override // a0.d
        public final Parcelable o(View view) {
            AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
            f A = A(absSavedState, (AppBarLayout) view);
            return A == null ? absSavedState : A;
        }

        @Override // a0.d
        public final boolean p(CoordinatorLayout coordinatorLayout, View view, View view2, int i9, int i10) {
            ValueAnimator valueAnimator;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            boolean z8 = (i9 & 2) != 0 && (appBarLayout.f1871s || (appBarLayout.getTotalScrollRange() != 0 && coordinatorLayout.getHeight() - view2.getHeight() <= appBarLayout.getHeight()));
            if (z8 && (valueAnimator = this.f1881l) != null) {
                valueAnimator.cancel();
            }
            this.f1883n = null;
            this.f1880k = i10;
            return z8;
        }

        @Override // a0.d
        public final void q(CoordinatorLayout coordinatorLayout, View view, View view2, int i9) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (this.f1880k == 0 || i9 == 1) {
                B(coordinatorLayout, appBarLayout);
                if (appBarLayout.f1871s) {
                    appBarLayout.e(appBarLayout.f(view2));
                }
            }
            this.f1883n = new WeakReference(view2);
        }

        @Override // a5.h
        public final int u() {
            return s() + this.f1879j;
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x00b2  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x0165  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x0187  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x018e  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0190  */
        @Override // a5.h
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final int v(androidx.coordinatorlayout.widget.CoordinatorLayout r19, android.view.View r20, int r21, int r22, int r23) {
            /*
                Method dump skipped, instructions count: 412
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.v(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int, int, int):int");
        }

        public final void x(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i9) {
            int abs = Math.abs(u() - i9);
            float abs2 = Math.abs(0.0f);
            int round = abs2 > 0.0f ? Math.round((abs / abs2) * 1000.0f) * 3 : (int) (((abs / appBarLayout.getHeight()) + 1.0f) * 150.0f);
            int u3 = u();
            ValueAnimator valueAnimator = this.f1881l;
            if (u3 == i9) {
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.f1881l.cancel();
                return;
            }
            if (valueAnimator == null) {
                ValueAnimator valueAnimator2 = new ValueAnimator();
                this.f1881l = valueAnimator2;
                valueAnimator2.setInterpolator(z4.a.f10663e);
                this.f1881l.addUpdateListener(new a(this, coordinatorLayout, appBarLayout));
            } else {
                valueAnimator.cancel();
            }
            this.f1881l.setDuration(Math.min(round, IjkMediaCodecInfo.RANK_LAST_CHANCE));
            this.f1881l.setIntValues(u3, i9);
            this.f1881l.start();
        }

        /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0031  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void z(androidx.coordinatorlayout.widget.CoordinatorLayout r9, com.google.android.material.appbar.AppBarLayout r10, android.view.View r11, int r12, int[] r13) {
            /*
                r8 = this;
                if (r12 == 0) goto L2c
                if (r12 >= 0) goto L11
                int r0 = r10.getTotalScrollRange()
                int r0 = -r0
                int r1 = r10.getDownNestedPreScrollRange()
                int r1 = r1 + r0
                r7 = r1
            Lf:
                r6 = r0
                goto L19
            L11:
                int r0 = r10.getUpNestedPreScrollRange()
                int r0 = -r0
                r1 = 0
                r7 = 0
                goto Lf
            L19:
                if (r6 == r7) goto L2c
                int r0 = r8.u()
                int r5 = r0 - r12
                r2 = r8
                r3 = r9
                r4 = r10
                int r9 = r2.v(r3, r4, r5, r6, r7)
                r10 = 1
                r13[r10] = r9
                goto L2d
            L2c:
                r4 = r10
            L2d:
                boolean r9 = r4.f1871s
                if (r9 == 0) goto L38
                boolean r9 = r4.f(r11)
                r4.e(r9)
            L38:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.z(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, android.view.View, int, int[]):void");
        }

        public BaseBehavior() {
            this.f186f = -1;
            this.h = -1;
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateDefaultLayoutParams() {
        a5.f fVar = new a5.f(-1, -2);
        fVar.f176a = 1;
        return fVar;
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public static class ScrollingViewBehavior extends i {
        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(0);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y4.a.A);
            this.f192f = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            obtainStyledAttributes.recycle();
        }

        public static AppBarLayout v(ArrayList arrayList) {
            int size = arrayList.size();
            for (int i9 = 0; i9 < size; i9++) {
                View view = (View) arrayList.get(i9);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // a0.d
        public final boolean b(View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // a0.d
        public boolean d(CoordinatorLayout coordinatorLayout, View view, View view2) {
            a0.d dVar = ((a0.g) view2.getLayoutParams()).f10a;
            if (dVar instanceof BaseBehavior) {
                t0.k(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) dVar).f1879j) + this.f191e) - u(view2));
            }
            if (!(view2 instanceof AppBarLayout)) {
                return false;
            }
            AppBarLayout appBarLayout = (AppBarLayout) view2;
            if (!appBarLayout.f1871s) {
                return false;
            }
            appBarLayout.e(appBarLayout.f(view));
            return false;
        }

        @Override // a0.d
        public final void e(CoordinatorLayout coordinatorLayout, View view) {
            if (view instanceof AppBarLayout) {
                t0.m(coordinatorLayout, o0.f.f7552f.a());
                t0.i(coordinatorLayout, 0);
                t0.m(coordinatorLayout, o0.f.f7553g.a());
                t0.i(coordinatorLayout, 0);
                t0.p(coordinatorLayout, null);
            }
        }

        @Override // a0.d
        public final boolean m(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z8) {
            AppBarLayout v8 = v(coordinatorLayout.j(view));
            if (v8 != null) {
                Rect rect2 = new Rect(rect);
                rect2.offset(view.getLeft(), view.getTop());
                int width = coordinatorLayout.getWidth();
                int height = coordinatorLayout.getHeight();
                Rect rect3 = this.f189c;
                rect3.set(0, 0, width, height);
                if (!rect3.contains(rect2)) {
                    v8.d(false, !z8, true);
                    return true;
                }
            }
            return false;
        }

        public ScrollingViewBehavior() {
        }
    }
}
