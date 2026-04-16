package com.google.android.material.sidesheet;

import a0.d;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.support.v4.media.session.b;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import d5.c;
import d5.e;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import n0.c0;
import n0.f0;
import n0.i0;
import n0.t0;
import o0.f;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import u5.g;
import u5.j;
import y4.a;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class SideSheetBehavior<V extends View> extends d {

    /* renamed from: a, reason: collision with root package name */
    public b f2105a;

    /* renamed from: b, reason: collision with root package name */
    public final g f2106b;

    /* renamed from: c, reason: collision with root package name */
    public final ColorStateList f2107c;

    /* renamed from: d, reason: collision with root package name */
    public final j f2108d;

    /* renamed from: e, reason: collision with root package name */
    public final e f2109e;

    /* renamed from: f, reason: collision with root package name */
    public final float f2110f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f2111g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public v0.d f2112i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2113j;

    /* renamed from: k, reason: collision with root package name */
    public final float f2114k;

    /* renamed from: l, reason: collision with root package name */
    public int f2115l;

    /* renamed from: m, reason: collision with root package name */
    public int f2116m;

    /* renamed from: n, reason: collision with root package name */
    public int f2117n;

    /* renamed from: o, reason: collision with root package name */
    public int f2118o;

    /* renamed from: p, reason: collision with root package name */
    public WeakReference f2119p;

    /* renamed from: q, reason: collision with root package name */
    public WeakReference f2120q;

    /* renamed from: r, reason: collision with root package name */
    public final int f2121r;

    /* renamed from: s, reason: collision with root package name */
    public VelocityTracker f2122s;

    /* renamed from: t, reason: collision with root package name */
    public int f2123t;

    /* renamed from: u, reason: collision with root package name */
    public final LinkedHashSet f2124u;

    /* renamed from: v, reason: collision with root package name */
    public final c f2125v;

    public SideSheetBehavior(Context context, AttributeSet attributeSet) {
        this.f2109e = new e(this);
        this.f2111g = true;
        this.h = 5;
        this.f2114k = 0.1f;
        this.f2121r = -1;
        this.f2124u = new LinkedHashSet();
        this.f2125v = new c(this, 1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.D);
        if (obtainStyledAttributes.hasValue(3)) {
            this.f2107c = com.bumptech.glide.d.B(context, obtainStyledAttributes, 3);
        }
        if (obtainStyledAttributes.hasValue(6)) {
            this.f2108d = j.b(context, attributeSet, 0, 2132018151).a();
        }
        if (obtainStyledAttributes.hasValue(5)) {
            int resourceId = obtainStyledAttributes.getResourceId(5, -1);
            this.f2121r = resourceId;
            WeakReference weakReference = this.f2120q;
            if (weakReference != null) {
                weakReference.clear();
            }
            this.f2120q = null;
            WeakReference weakReference2 = this.f2119p;
            if (weakReference2 != null) {
                View view = (View) weakReference2.get();
                if (resourceId != -1) {
                    WeakHashMap weakHashMap = t0.f7209a;
                    if (f0.c(view)) {
                        view.requestLayout();
                    }
                }
            }
        }
        j jVar = this.f2108d;
        if (jVar != null) {
            g gVar = new g(jVar);
            this.f2106b = gVar;
            gVar.i(context);
            ColorStateList colorStateList = this.f2107c;
            if (colorStateList != null) {
                this.f2106b.l(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
                this.f2106b.setTint(typedValue.data);
            }
        }
        this.f2110f = obtainStyledAttributes.getDimension(2, -1.0f);
        this.f2111g = obtainStyledAttributes.getBoolean(4, true);
        obtainStyledAttributes.recycle();
        ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    @Override // a0.d
    public final void c(a0.g gVar) {
        this.f2119p = null;
        this.f2112i = null;
    }

    @Override // a0.d
    public final void f() {
        this.f2119p = null;
        this.f2112i = null;
    }

    @Override // a0.d
    public final boolean g(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        v0.d dVar;
        VelocityTracker velocityTracker;
        if ((!view.isShown() && t0.d(view) == null) || !this.f2111g) {
            this.f2113j = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && (velocityTracker = this.f2122s) != null) {
            velocityTracker.recycle();
            this.f2122s = null;
        }
        if (this.f2122s == null) {
            this.f2122s = VelocityTracker.obtain();
        }
        this.f2122s.addMovement(motionEvent);
        if (actionMasked == 0) {
            this.f2123t = (int) motionEvent.getX();
        } else if ((actionMasked == 1 || actionMasked == 3) && this.f2113j) {
            this.f2113j = false;
            return false;
        }
        return (this.f2113j || (dVar = this.f2112i) == null || !dVar.p(motionEvent)) ? false : true;
    }

    @Override // a0.d
    public final boolean h(CoordinatorLayout coordinatorLayout, View view, int i9) {
        View view2;
        View view3;
        int O;
        int i10;
        View findViewById;
        WeakHashMap weakHashMap = t0.f7209a;
        int i11 = 1;
        if (c0.b(coordinatorLayout) && !c0.b(view)) {
            view.setFitsSystemWindows(true);
        }
        WeakReference weakReference = this.f2119p;
        g gVar = this.f2106b;
        int i12 = 0;
        if (weakReference == null) {
            this.f2119p = new WeakReference(view);
            Context context = view.getContext();
            b.o0(context, 2130969368, p0.a.b(0.0f, 0.0f, 0.0f, 1.0f));
            b.n0(context, 2130969351, IjkMediaCodecInfo.RANK_SECURE);
            b.n0(context, 2130969356, 150);
            b.n0(context, 2130969355, 100);
            Resources resources = view.getResources();
            resources.getDimension(2131165396);
            resources.getDimension(2131165395);
            resources.getDimension(2131165397);
            if (gVar != null) {
                c0.q(view, gVar);
                float f9 = this.f2110f;
                if (f9 == -1.0f) {
                    f9 = i0.i(view);
                }
                gVar.k(f9);
            } else {
                ColorStateList colorStateList = this.f2107c;
                if (colorStateList != null) {
                    t0.r(view, colorStateList);
                }
            }
            int i13 = this.h == 5 ? 4 : 0;
            if (view.getVisibility() != i13) {
                view.setVisibility(i13);
            }
            v();
            if (c0.c(view) == 0) {
                c0.s(view, 1);
            }
            if (t0.d(view) == null) {
                t0.q(view, view.getResources().getString(2131951838));
            }
        }
        int i14 = Gravity.getAbsoluteGravity(((a0.g) view.getLayoutParams()).f12c, i9) == 3 ? 1 : 0;
        b bVar = this.f2105a;
        if (bVar == null || bVar.Q() != i14) {
            a0.g gVar2 = null;
            j jVar = this.f2108d;
            if (i14 == 0) {
                this.f2105a = new v5.a(this, i11);
                if (jVar != null) {
                    WeakReference weakReference2 = this.f2119p;
                    if (weakReference2 != null && (view3 = (View) weakReference2.get()) != null && (view3.getLayoutParams() instanceof a0.g)) {
                        gVar2 = (a0.g) view3.getLayoutParams();
                    }
                    if (gVar2 == null || ((ViewGroup.MarginLayoutParams) gVar2).rightMargin <= 0) {
                        c7.b e9 = jVar.e();
                        e9.f1653g = new u5.a(0.0f);
                        e9.h = new u5.a(0.0f);
                        j a9 = e9.a();
                        if (gVar != null) {
                            gVar.setShapeAppearanceModel(a9);
                        }
                    }
                }
            } else {
                if (i14 != 1) {
                    throw new IllegalArgumentException("Invalid sheet edge position value: " + i14 + ". Must be 0 or 1.");
                }
                this.f2105a = new v5.a(this, i12);
                if (jVar != null) {
                    WeakReference weakReference3 = this.f2119p;
                    if (weakReference3 != null && (view2 = (View) weakReference3.get()) != null && (view2.getLayoutParams() instanceof a0.g)) {
                        gVar2 = (a0.g) view2.getLayoutParams();
                    }
                    if (gVar2 == null || ((ViewGroup.MarginLayoutParams) gVar2).leftMargin <= 0) {
                        c7.b e10 = jVar.e();
                        e10.f1652f = new u5.a(0.0f);
                        e10.f1654i = new u5.a(0.0f);
                        j a10 = e10.a();
                        if (gVar != null) {
                            gVar.setShapeAppearanceModel(a10);
                        }
                    }
                }
            }
        }
        if (this.f2112i == null) {
            this.f2112i = new v0.d(coordinatorLayout.getContext(), coordinatorLayout, this.f2125v);
        }
        int O2 = this.f2105a.O(view);
        coordinatorLayout.q(view, i9);
        this.f2116m = coordinatorLayout.getWidth();
        this.f2117n = this.f2105a.P(coordinatorLayout);
        this.f2115l = view.getWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        this.f2118o = marginLayoutParams != null ? this.f2105a.l(marginLayoutParams) : 0;
        int i15 = this.h;
        if (i15 == 1 || i15 == 2) {
            O = O2 - this.f2105a.O(view);
        } else if (i15 == 3) {
            O = 0;
        } else {
            if (i15 != 5) {
                throw new IllegalStateException("Unexpected value: " + this.h);
            }
            O = this.f2105a.K();
        }
        t0.j(view, O);
        if (this.f2120q == null && (i10 = this.f2121r) != -1 && (findViewById = coordinatorLayout.findViewById(i10)) != null) {
            this.f2120q = new WeakReference(findViewById);
        }
        Iterator it = this.f2124u.iterator();
        while (it.hasNext()) {
            if (it.next() != null) {
                androidx.fragment.app.a.c();
                return false;
            }
        }
        return true;
    }

    @Override // a0.d
    public final boolean i(CoordinatorLayout coordinatorLayout, View view, int i9, int i10, int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i9, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i10, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i11, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
        return true;
    }

    @Override // a0.d
    public final void n(View view, Parcelable parcelable) {
        int i9 = ((v5.b) parcelable).f9578k;
        if (i9 == 1 || i9 == 2) {
            i9 = 5;
        }
        this.h = i9;
    }

    @Override // a0.d
    public final Parcelable o(View view) {
        AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
        return new v5.b(this);
    }

    @Override // a0.d
    public final boolean r(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.h == 1 && actionMasked == 0) {
            return true;
        }
        if (t()) {
            this.f2112i.j(motionEvent);
        }
        if (actionMasked == 0 && (velocityTracker = this.f2122s) != null) {
            velocityTracker.recycle();
            this.f2122s = null;
        }
        if (this.f2122s == null) {
            this.f2122s = VelocityTracker.obtain();
        }
        this.f2122s.addMovement(motionEvent);
        if (t() && actionMasked == 2 && !this.f2113j && t()) {
            float abs = Math.abs(this.f2123t - motionEvent.getX());
            v0.d dVar = this.f2112i;
            if (abs > dVar.f9214b) {
                dVar.b(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.f2113j;
    }

    public final void s(int i9) {
        View view;
        if (this.h == i9) {
            return;
        }
        this.h = i9;
        WeakReference weakReference = this.f2119p;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        int i10 = this.h == 5 ? 4 : 0;
        if (view.getVisibility() != i10) {
            view.setVisibility(i10);
        }
        Iterator it = this.f2124u.iterator();
        if (it.hasNext()) {
            throw androidx.activity.g.l(it);
        }
        v();
    }

    public final boolean t() {
        if (this.f2112i != null) {
            return this.f2111g || this.h == 1;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002b, code lost:
    
        if (r1.o(r0, r3.getTop()) != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x004b, code lost:
    
        s(2);
        r2.f2109e.a(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0054, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
    
        if (r3 != false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u(android.view.View r3, int r4, boolean r5) {
        /*
            r2 = this;
            r0 = 3
            if (r4 == r0) goto L17
            r0 = 5
            if (r4 != r0) goto Ld
            android.support.v4.media.session.b r0 = r2.f2105a
            int r0 = r0.K()
            goto L1d
        Ld:
            java.lang.String r3 = "Invalid state to get outer edge offset: "
            java.lang.String r3 = androidx.activity.g.m(r4, r3)
            m7.c.n(r3)
            return
        L17:
            android.support.v4.media.session.b r0 = r2.f2105a
            int r0 = r0.J()
        L1d:
            v0.d r1 = r2.f2112i
            if (r1 == 0) goto L55
            if (r5 == 0) goto L2e
            int r3 = r3.getTop()
            boolean r3 = r1.o(r0, r3)
            if (r3 == 0) goto L55
            goto L4b
        L2e:
            int r5 = r3.getTop()
            r1.f9229r = r3
            r3 = -1
            r1.f9215c = r3
            r3 = 0
            boolean r3 = r1.h(r0, r5, r3, r3)
            if (r3 != 0) goto L49
            int r5 = r1.f9213a
            if (r5 != 0) goto L49
            android.view.View r5 = r1.f9229r
            if (r5 == 0) goto L49
            r5 = 0
            r1.f9229r = r5
        L49:
            if (r3 == 0) goto L55
        L4b:
            r3 = 2
            r2.s(r3)
            d5.e r3 = r2.f2109e
            r3.a(r4)
            return
        L55:
            r2.s(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.sidesheet.SideSheetBehavior.u(android.view.View, int, boolean):void");
    }

    public final void v() {
        View view;
        WeakReference weakReference = this.f2119p;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        t0.m(view, 262144);
        t0.i(view, 0);
        t0.m(view, 1048576);
        t0.i(view, 0);
        int i9 = 5;
        if (this.h != 5) {
            t0.n(view, f.f7555j, new h7.c0(this, i9));
        }
        int i10 = 3;
        if (this.h != 3) {
            t0.n(view, f.h, new h7.c0(this, i10));
        }
    }

    public SideSheetBehavior() {
        this.f2109e = new e(this);
        this.f2111g = true;
        this.h = 5;
        this.f2114k = 0.1f;
        this.f2121r = -1;
        this.f2124u = new LinkedHashSet();
        this.f2125v = new c(this, 1);
    }
}
