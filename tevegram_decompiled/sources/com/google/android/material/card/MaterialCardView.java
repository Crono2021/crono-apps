package com.google.android.material.card;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.cardview.widget.CardView;
import com.bumptech.glide.c;
import f5.d;
import o5.o;
import s5.b;
import u5.f;
import u5.g;
import u5.j;
import u5.t;
import z5.a;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class MaterialCardView extends CardView implements Checkable, t {

    /* renamed from: s, reason: collision with root package name */
    public static final int[] f1975s = {R.attr.state_checkable};

    /* renamed from: t, reason: collision with root package name */
    public static final int[] f1976t = {R.attr.state_checked};

    /* renamed from: u, reason: collision with root package name */
    public static final int[] f1977u = {2130969545};

    /* renamed from: o, reason: collision with root package name */
    public final d f1978o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f1979p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f1980q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f1981r;

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        super(a.a(context, attributeSet, 2130969296, 2132018212), attributeSet, 2130969296);
        this.f1980q = false;
        this.f1981r = false;
        this.f1979p = true;
        TypedArray f9 = o.f(getContext(), attributeSet, y4.a.f10513s, 2130969296, 2132018212, new int[0]);
        d dVar = new d(this, attributeSet);
        this.f1978o = dVar;
        ColorStateList cardBackgroundColor = super.getCardBackgroundColor();
        g gVar = dVar.f3394c;
        gVar.l(cardBackgroundColor);
        dVar.f3393b.set(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        dVar.j();
        MaterialCardView materialCardView = dVar.f3392a;
        ColorStateList B = com.bumptech.glide.d.B(materialCardView.getContext(), f9, 11);
        dVar.f3404n = B;
        if (B == null) {
            dVar.f3404n = ColorStateList.valueOf(-1);
        }
        dVar.h = f9.getDimensionPixelSize(12, 0);
        boolean z8 = f9.getBoolean(0, false);
        dVar.f3409s = z8;
        materialCardView.setLongClickable(z8);
        dVar.f3402l = com.bumptech.glide.d.B(materialCardView.getContext(), f9, 6);
        dVar.g(com.bumptech.glide.d.E(materialCardView.getContext(), f9, 2));
        dVar.f3397f = f9.getDimensionPixelSize(5, 0);
        dVar.f3396e = f9.getDimensionPixelSize(4, 0);
        dVar.f3398g = f9.getInteger(3, 8388661);
        ColorStateList B2 = com.bumptech.glide.d.B(materialCardView.getContext(), f9, 7);
        dVar.f3401k = B2;
        if (B2 == null) {
            dVar.f3401k = ColorStateList.valueOf(c.v(materialCardView, 2130968808));
        }
        ColorStateList B3 = com.bumptech.glide.d.B(materialCardView.getContext(), f9, 1);
        B3 = B3 == null ? ColorStateList.valueOf(0) : B3;
        g gVar2 = dVar.f3395d;
        gVar2.l(B3);
        int[] iArr = b.f8857a;
        RippleDrawable rippleDrawable = dVar.f3405o;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(dVar.f3401k);
        }
        gVar.k(materialCardView.getCardElevation());
        float f10 = dVar.h;
        ColorStateList colorStateList = dVar.f3404n;
        gVar2.f9084i.f9077j = f10;
        gVar2.invalidateSelf();
        f fVar = gVar2.f9084i;
        if (fVar.f9072d != colorStateList) {
            fVar.f9072d = colorStateList;
            gVar2.onStateChange(gVar2.getState());
        }
        materialCardView.setBackgroundInternal(dVar.d(gVar));
        Drawable c9 = materialCardView.isClickable() ? dVar.c() : gVar2;
        dVar.f3399i = c9;
        materialCardView.setForeground(dVar.d(c9));
        f9.recycle();
    }

    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.f1978o.f3394c.getBounds());
        return rectF;
    }

    public final void b() {
        d dVar;
        RippleDrawable rippleDrawable;
        if (Build.VERSION.SDK_INT <= 26 || (rippleDrawable = (dVar = this.f1978o).f3405o) == null) {
            return;
        }
        Rect bounds = rippleDrawable.getBounds();
        int i9 = bounds.bottom;
        dVar.f3405o.setBounds(bounds.left, bounds.top, bounds.right, i9 - 1);
        dVar.f3405o.setBounds(bounds.left, bounds.top, bounds.right, i9);
    }

    @Override // androidx.cardview.widget.CardView
    public ColorStateList getCardBackgroundColor() {
        return this.f1978o.f3394c.f9084i.f9071c;
    }

    public ColorStateList getCardForegroundColor() {
        return this.f1978o.f3395d.f9084i.f9071c;
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        return this.f1978o.f3400j;
    }

    public int getCheckedIconGravity() {
        return this.f1978o.f3398g;
    }

    public int getCheckedIconMargin() {
        return this.f1978o.f3396e;
    }

    public int getCheckedIconSize() {
        return this.f1978o.f3397f;
    }

    public ColorStateList getCheckedIconTint() {
        return this.f1978o.f3402l;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.f1978o.f3393b.bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.f1978o.f3393b.left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.f1978o.f3393b.right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.f1978o.f3393b.top;
    }

    public float getProgress() {
        return this.f1978o.f3394c.f9084i.f9076i;
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.f1978o.f3394c.g();
    }

    public ColorStateList getRippleColor() {
        return this.f1978o.f3401k;
    }

    public j getShapeAppearanceModel() {
        return this.f1978o.f3403m;
    }

    @Deprecated
    public int getStrokeColor() {
        ColorStateList colorStateList = this.f1978o.f3404n;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.f1978o.f3404n;
    }

    public int getStrokeWidth() {
        return this.f1978o.h;
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f1980q;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bumptech.glide.d.b0(this, this.f1978o.f3394c);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i9) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i9 + 3);
        d dVar = this.f1978o;
        if (dVar != null && dVar.f3409s) {
            View.mergeDrawableStates(onCreateDrawableState, f1975s);
        }
        if (this.f1980q) {
            View.mergeDrawableStates(onCreateDrawableState, f1976t);
        }
        if (this.f1981r) {
            View.mergeDrawableStates(onCreateDrawableState, f1977u);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(this.f1980q);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        d dVar = this.f1978o;
        accessibilityNodeInfo.setCheckable(dVar != null && dVar.f3409s);
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(this.f1980q);
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i9, int i10) {
        super.onMeasure(i9, i10);
        this.f1978o.e(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f1979p) {
            d dVar = this.f1978o;
            if (!dVar.f3408r) {
                Log.i("MaterialCardView", "Setting a custom background is not supported.");
                dVar.f3408r = true;
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(int i9) {
        this.f1978o.f3394c.l(ColorStateList.valueOf(i9));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f9) {
        super.setCardElevation(f9);
        d dVar = this.f1978o;
        dVar.f3394c.k(dVar.f3392a.getCardElevation());
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        g gVar = this.f1978o.f3395d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        gVar.l(colorStateList);
    }

    public void setCheckable(boolean z8) {
        this.f1978o.f3409s = z8;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z8) {
        if (this.f1980q != z8) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        this.f1978o.g(drawable);
    }

    public void setCheckedIconGravity(int i9) {
        d dVar = this.f1978o;
        if (dVar.f3398g != i9) {
            dVar.f3398g = i9;
            MaterialCardView materialCardView = dVar.f3392a;
            dVar.e(materialCardView.getMeasuredWidth(), materialCardView.getMeasuredHeight());
        }
    }

    public void setCheckedIconMargin(int i9) {
        this.f1978o.f3396e = i9;
    }

    public void setCheckedIconMarginResource(int i9) {
        if (i9 != -1) {
            this.f1978o.f3396e = getResources().getDimensionPixelSize(i9);
        }
    }

    public void setCheckedIconResource(int i9) {
        this.f1978o.g(android.support.v4.media.session.b.I(getContext(), i9));
    }

    public void setCheckedIconSize(int i9) {
        this.f1978o.f3397f = i9;
    }

    public void setCheckedIconSizeResource(int i9) {
        if (i9 != 0) {
            this.f1978o.f3397f = getResources().getDimensionPixelSize(i9);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        d dVar = this.f1978o;
        dVar.f3402l = colorStateList;
        Drawable drawable = dVar.f3400j;
        if (drawable != null) {
            g0.b.h(drawable, colorStateList);
        }
    }

    @Override // android.view.View
    public void setClickable(boolean z8) {
        super.setClickable(z8);
        d dVar = this.f1978o;
        if (dVar != null) {
            Drawable drawable = dVar.f3399i;
            MaterialCardView materialCardView = dVar.f3392a;
            Drawable c9 = materialCardView.isClickable() ? dVar.c() : dVar.f3395d;
            dVar.f3399i = c9;
            if (drawable != c9) {
                if (Build.VERSION.SDK_INT < 23 || !(materialCardView.getForeground() instanceof InsetDrawable)) {
                    materialCardView.setForeground(dVar.d(c9));
                } else {
                    ((InsetDrawable) materialCardView.getForeground()).setDrawable(c9);
                }
            }
        }
    }

    public void setDragged(boolean z8) {
        if (this.f1981r != z8) {
            this.f1981r = z8;
            refreshDrawableState();
            b();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f9) {
        super.setMaxCardElevation(f9);
        this.f1978o.k();
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z8) {
        super.setPreventCornerOverlap(z8);
        d dVar = this.f1978o;
        dVar.k();
        dVar.j();
    }

    public void setProgress(float f9) {
        d dVar = this.f1978o;
        dVar.f3394c.m(f9);
        g gVar = dVar.f3395d;
        if (gVar != null) {
            gVar.m(f9);
        }
        g gVar2 = dVar.f3407q;
        if (gVar2 != null) {
            gVar2.m(f9);
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f9) {
        super.setRadius(f9);
        d dVar = this.f1978o;
        c7.b e9 = dVar.f3403m.e();
        e9.c(f9);
        dVar.h(e9.a());
        dVar.f3399i.invalidateSelf();
        if (dVar.i() || (dVar.f3392a.getPreventCornerOverlap() && !dVar.f3394c.j())) {
            dVar.j();
        }
        if (dVar.i()) {
            dVar.k();
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        d dVar = this.f1978o;
        dVar.f3401k = colorStateList;
        int[] iArr = b.f8857a;
        RippleDrawable rippleDrawable = dVar.f3405o;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(colorStateList);
        }
    }

    public void setRippleColorResource(int i9) {
        ColorStateList u3 = a.a.u(getContext(), i9);
        d dVar = this.f1978o;
        dVar.f3401k = u3;
        int[] iArr = b.f8857a;
        RippleDrawable rippleDrawable = dVar.f3405o;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(u3);
        }
    }

    @Override // u5.t
    public void setShapeAppearanceModel(j jVar) {
        setClipToOutline(jVar.d(getBoundsAsRectF()));
        this.f1978o.h(jVar);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        d dVar = this.f1978o;
        if (dVar.f3404n != colorStateList) {
            dVar.f3404n = colorStateList;
            g gVar = dVar.f3395d;
            gVar.f9084i.f9077j = dVar.h;
            gVar.invalidateSelf();
            f fVar = gVar.f9084i;
            if (fVar.f9072d != colorStateList) {
                fVar.f9072d = colorStateList;
                gVar.onStateChange(gVar.getState());
            }
        }
        invalidate();
    }

    public void setStrokeWidth(int i9) {
        d dVar = this.f1978o;
        if (i9 != dVar.h) {
            dVar.h = i9;
            g gVar = dVar.f3395d;
            ColorStateList colorStateList = dVar.f3404n;
            gVar.f9084i.f9077j = i9;
            gVar.invalidateSelf();
            f fVar = gVar.f9084i;
            if (fVar.f9072d != colorStateList) {
                fVar.f9072d = colorStateList;
                gVar.onStateChange(gVar.getState());
            }
        }
        invalidate();
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z8) {
        super.setUseCompatPadding(z8);
        d dVar = this.f1978o;
        dVar.k();
        dVar.j();
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        d dVar = this.f1978o;
        if (dVar != null && dVar.f3409s && isEnabled()) {
            this.f1980q = !this.f1980q;
            refreshDrawableState();
            b();
            dVar.f(this.f1980q, true);
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.f1978o.f3394c.l(colorStateList);
    }

    public void setOnCheckedChangeListener(f5.a aVar) {
    }

    public void setStrokeColor(int i9) {
        setStrokeColor(ColorStateList.valueOf(i9));
    }
}
