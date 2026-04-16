package com.google.android.material.behavior;

import a0.d;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.support.v4.media.session.b;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.activity.g;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.Iterator;
import java.util.LinkedHashSet;
import z4.a;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends d {

    /* renamed from: b, reason: collision with root package name */
    public int f1907b;

    /* renamed from: c, reason: collision with root package name */
    public int f1908c;

    /* renamed from: d, reason: collision with root package name */
    public TimeInterpolator f1909d;

    /* renamed from: e, reason: collision with root package name */
    public TimeInterpolator f1910e;
    public ViewPropertyAnimator h;

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f1906a = new LinkedHashSet();

    /* renamed from: f, reason: collision with root package name */
    public int f1911f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f1912g = 2;

    public HideBottomViewOnScrollBehavior() {
    }

    @Override // a0.d
    public boolean h(CoordinatorLayout coordinatorLayout, View view, int i9) {
        this.f1911f = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        this.f1907b = b.n0(view.getContext(), 2130969347, 225);
        this.f1908c = b.n0(view.getContext(), 2130969353, 175);
        this.f1909d = b.o0(view.getContext(), 2130969363, a.f10662d);
        this.f1910e = b.o0(view.getContext(), 2130969363, a.f10661c);
        return false;
    }

    @Override // a0.d
    public final void l(CoordinatorLayout coordinatorLayout, View view, int i9, int i10, int i11, int[] iArr) {
        LinkedHashSet linkedHashSet = this.f1906a;
        if (i9 > 0) {
            if (this.f1912g == 1) {
                return;
            }
            ViewPropertyAnimator viewPropertyAnimator = this.h;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                view.clearAnimation();
            }
            this.f1912g = 1;
            Iterator it = linkedHashSet.iterator();
            if (it.hasNext()) {
                throw g.l(it);
            }
            this.h = view.animate().translationY(this.f1911f).setInterpolator(this.f1910e).setDuration(this.f1908c).setListener(new b5.a(this, 0));
            return;
        }
        if (i9 >= 0 || this.f1912g == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator2 = this.h;
        if (viewPropertyAnimator2 != null) {
            viewPropertyAnimator2.cancel();
            view.clearAnimation();
        }
        this.f1912g = 2;
        Iterator it2 = linkedHashSet.iterator();
        if (it2.hasNext()) {
            throw g.l(it2);
        }
        this.h = view.animate().translationY(0).setInterpolator(this.f1909d).setDuration(this.f1907b).setListener(new b5.a(this, 0));
    }

    @Override // a0.d
    public boolean p(CoordinatorLayout coordinatorLayout, View view, View view2, int i9, int i10) {
        return i9 == 2;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
    }
}
