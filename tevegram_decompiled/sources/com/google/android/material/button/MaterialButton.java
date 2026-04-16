package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import c7.b;
import com.bumptech.glide.d;
import e5.a;
import e5.c;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import n.p;
import n0.d0;
import n0.t0;
import o5.o;
import u5.g;
import u5.j;
import u5.t;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class MaterialButton extends p implements Checkable, t {

    /* renamed from: l, reason: collision with root package name */
    public final c f1950l;

    /* renamed from: m, reason: collision with root package name */
    public final LinkedHashSet f1951m;

    /* renamed from: n, reason: collision with root package name */
    public a f1952n;

    /* renamed from: o, reason: collision with root package name */
    public PorterDuff.Mode f1953o;

    /* renamed from: p, reason: collision with root package name */
    public ColorStateList f1954p;

    /* renamed from: q, reason: collision with root package name */
    public Drawable f1955q;

    /* renamed from: r, reason: collision with root package name */
    public String f1956r;

    /* renamed from: s, reason: collision with root package name */
    public int f1957s;

    /* renamed from: t, reason: collision with root package name */
    public int f1958t;

    /* renamed from: u, reason: collision with root package name */
    public int f1959u;

    /* renamed from: v, reason: collision with root package name */
    public int f1960v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f1961w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f1962x;

    /* renamed from: y, reason: collision with root package name */
    public int f1963y;

    /* renamed from: z, reason: collision with root package name */
    public static final int[] f1949z = {R.attr.state_checkable};
    public static final int[] A = {R.attr.state_checked};

    public MaterialButton(Context context, AttributeSet attributeSet) {
        super(z5.a.a(context, attributeSet, 2130969276, 2132018200), attributeSet, 2130969276);
        this.f1951m = new LinkedHashSet();
        this.f1961w = false;
        this.f1962x = false;
        Context context2 = getContext();
        TypedArray f9 = o.f(context2, attributeSet, y4.a.f10509o, 2130969276, 2132018200, new int[0]);
        this.f1960v = f9.getDimensionPixelSize(12, 0);
        int i9 = f9.getInt(15, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        this.f1953o = o.g(i9, mode);
        this.f1954p = d.B(getContext(), f9, 14);
        this.f1955q = d.E(getContext(), f9, 10);
        this.f1963y = f9.getInteger(11, 1);
        this.f1957s = f9.getDimensionPixelSize(13, 0);
        c cVar = new c(this, j.b(context2, attributeSet, 2130969276, 2132018200).a());
        this.f1950l = cVar;
        cVar.f3127c = f9.getDimensionPixelOffset(1, 0);
        cVar.f3128d = f9.getDimensionPixelOffset(2, 0);
        cVar.f3129e = f9.getDimensionPixelOffset(3, 0);
        cVar.f3130f = f9.getDimensionPixelOffset(4, 0);
        if (f9.hasValue(8)) {
            int dimensionPixelSize = f9.getDimensionPixelSize(8, -1);
            cVar.f3131g = dimensionPixelSize;
            b e9 = cVar.f3126b.e();
            e9.c(dimensionPixelSize);
            cVar.c(e9.a());
            cVar.f3139p = true;
        }
        cVar.h = f9.getDimensionPixelSize(20, 0);
        cVar.f3132i = o.g(f9.getInt(7, -1), mode);
        cVar.f3133j = d.B(getContext(), f9, 6);
        cVar.f3134k = d.B(getContext(), f9, 19);
        cVar.f3135l = d.B(getContext(), f9, 16);
        cVar.f3140q = f9.getBoolean(5, false);
        cVar.f3143t = f9.getDimensionPixelSize(9, 0);
        cVar.f3141r = f9.getBoolean(21, true);
        WeakHashMap weakHashMap = t0.f7209a;
        int f10 = d0.f(this);
        int paddingTop = getPaddingTop();
        int e10 = d0.e(this);
        int paddingBottom = getPaddingBottom();
        if (f9.hasValue(0)) {
            cVar.f3138o = true;
            setSupportBackgroundTintList(cVar.f3133j);
            setSupportBackgroundTintMode(cVar.f3132i);
        } else {
            cVar.e();
        }
        d0.k(this, f10 + cVar.f3127c, paddingTop + cVar.f3129e, e10 + cVar.f3128d, paddingBottom + cVar.f3130f);
        f9.recycle();
        setCompoundDrawablePadding(this.f1960v);
        c(this.f1955q != null);
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        return textAlignment != 1 ? (textAlignment == 6 || textAlignment == 3) ? Layout.Alignment.ALIGN_OPPOSITE : textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER : getGravityTextAlignment();
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & 8388615;
        return gravity != 1 ? (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private int getTextHeight() {
        if (getLineCount() > 1) {
            return getLayout().getHeight();
        }
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextLayoutWidth() {
        int lineCount = getLineCount();
        float f9 = 0.0f;
        for (int i9 = 0; i9 < lineCount; i9++) {
            f9 = Math.max(f9, getLayout().getLineWidth(i9));
        }
        return (int) Math.ceil(f9);
    }

    public final boolean a() {
        c cVar = this.f1950l;
        return (cVar == null || cVar.f3138o) ? false : true;
    }

    public final void b() {
        int i9 = this.f1963y;
        if (i9 == 1 || i9 == 2) {
            r0.o.e(this, this.f1955q, null, null, null);
            return;
        }
        if (i9 == 3 || i9 == 4) {
            r0.o.e(this, null, null, this.f1955q, null);
        } else if (i9 == 16 || i9 == 32) {
            r0.o.e(this, null, this.f1955q, null, null);
        }
    }

    public final void c(boolean z8) {
        Drawable drawable = this.f1955q;
        if (drawable != null) {
            Drawable mutate = d.f0(drawable).mutate();
            this.f1955q = mutate;
            g0.b.h(mutate, this.f1954p);
            PorterDuff.Mode mode = this.f1953o;
            if (mode != null) {
                g0.b.i(this.f1955q, mode);
            }
            int i9 = this.f1957s;
            if (i9 == 0) {
                i9 = this.f1955q.getIntrinsicWidth();
            }
            int i10 = this.f1957s;
            if (i10 == 0) {
                i10 = this.f1955q.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f1955q;
            int i11 = this.f1958t;
            int i12 = this.f1959u;
            drawable2.setBounds(i11, i12, i9 + i11, i10 + i12);
            this.f1955q.setVisible(true, z8);
        }
        if (z8) {
            b();
            return;
        }
        Drawable[] a9 = r0.o.a(this);
        Drawable drawable3 = a9[0];
        Drawable drawable4 = a9[1];
        Drawable drawable5 = a9[2];
        int i13 = this.f1963y;
        if (((i13 == 1 || i13 == 2) && drawable3 != this.f1955q) || (((i13 == 3 || i13 == 4) && drawable5 != this.f1955q) || ((i13 == 16 || i13 == 32) && drawable4 != this.f1955q))) {
            b();
        }
    }

    public final void d(int i9, int i10) {
        if (this.f1955q == null || getLayout() == null) {
            return;
        }
        int i11 = this.f1963y;
        if (i11 != 1 && i11 != 2 && i11 != 3 && i11 != 4) {
            if (i11 == 16 || i11 == 32) {
                this.f1958t = 0;
                if (i11 == 16) {
                    this.f1959u = 0;
                    c(false);
                    return;
                }
                int i12 = this.f1957s;
                if (i12 == 0) {
                    i12 = this.f1955q.getIntrinsicHeight();
                }
                int max = Math.max(0, (((((i10 - getTextHeight()) - getPaddingTop()) - i12) - this.f1960v) - getPaddingBottom()) / 2);
                if (this.f1959u != max) {
                    this.f1959u = max;
                    c(false);
                    return;
                }
                return;
            }
            return;
        }
        this.f1959u = 0;
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        int i13 = this.f1963y;
        if (i13 == 1 || i13 == 3 || ((i13 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i13 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
            this.f1958t = 0;
            c(false);
            return;
        }
        int i14 = this.f1957s;
        if (i14 == 0) {
            i14 = this.f1955q.getIntrinsicWidth();
        }
        int textLayoutWidth = i9 - getTextLayoutWidth();
        WeakHashMap weakHashMap = t0.f7209a;
        int e9 = (((textLayoutWidth - d0.e(this)) - i14) - this.f1960v) - d0.f(this);
        if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
            e9 /= 2;
        }
        if ((d0.d(this) == 1) != (this.f1963y == 4)) {
            e9 = -e9;
        }
        if (this.f1958t != e9) {
            this.f1958t = e9;
            c(false);
        }
    }

    public String getA11yClassName() {
        if (!TextUtils.isEmpty(this.f1956r)) {
            return this.f1956r;
        }
        c cVar = this.f1950l;
        return ((cVar == null || !cVar.f3140q) ? Button.class : CompoundButton.class).getName();
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (a()) {
            return this.f1950l.f3131g;
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f1955q;
    }

    public int getIconGravity() {
        return this.f1963y;
    }

    public int getIconPadding() {
        return this.f1960v;
    }

    public int getIconSize() {
        return this.f1957s;
    }

    public ColorStateList getIconTint() {
        return this.f1954p;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f1953o;
    }

    public int getInsetBottom() {
        return this.f1950l.f3130f;
    }

    public int getInsetTop() {
        return this.f1950l.f3129e;
    }

    public ColorStateList getRippleColor() {
        if (a()) {
            return this.f1950l.f3135l;
        }
        return null;
    }

    public j getShapeAppearanceModel() {
        if (a()) {
            return this.f1950l.f3126b;
        }
        m7.c.p("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
        return null;
    }

    public ColorStateList getStrokeColor() {
        if (a()) {
            return this.f1950l.f3134k;
        }
        return null;
    }

    public int getStrokeWidth() {
        if (a()) {
            return this.f1950l.h;
        }
        return 0;
    }

    @Override // n.p
    public ColorStateList getSupportBackgroundTintList() {
        return a() ? this.f1950l.f3133j : super.getSupportBackgroundTintList();
    }

    @Override // n.p
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return a() ? this.f1950l.f3132i : super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f1961w;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (a()) {
            d.b0(this, this.f1950l.b(false));
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i9) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i9 + 2);
        c cVar = this.f1950l;
        if (cVar != null && cVar.f3140q) {
            View.mergeDrawableStates(onCreateDrawableState, f1949z);
        }
        if (this.f1961w) {
            View.mergeDrawableStates(onCreateDrawableState, A);
        }
        return onCreateDrawableState;
    }

    @Override // n.p, android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(this.f1961w);
    }

    @Override // n.p, android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        c cVar = this.f1950l;
        accessibilityNodeInfo.setCheckable(cVar != null && cVar.f3140q);
        accessibilityNodeInfo.setChecked(this.f1961w);
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // n.p, android.widget.TextView, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        c cVar;
        super.onLayout(z8, i9, i10, i11, i12);
        if (Build.VERSION.SDK_INT == 21 && (cVar = this.f1950l) != null) {
            int i13 = i12 - i10;
            int i14 = i11 - i9;
            g gVar = cVar.f3136m;
            if (gVar != null) {
                gVar.setBounds(cVar.f3127c, cVar.f3129e, i14 - cVar.f3128d, i13 - cVar.f3130f);
            }
        }
        d(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof e5.b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        e5.b bVar = (e5.b) parcelable;
        super.onRestoreInstanceState(bVar.f8991i);
        setChecked(bVar.f3123k);
    }

    @Override // android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        e5.b bVar = new e5.b(super.onSaveInstanceState());
        bVar.f3123k = this.f1961w;
        return bVar;
    }

    @Override // n.p, android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i9, int i10, int i11) {
        super.onTextChanged(charSequence, i9, i10, i11);
        d(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (this.f1950l.f3141r) {
            toggle();
        }
        return super.performClick();
    }

    @Override // android.view.View
    public final void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f1955q != null) {
            if (this.f1955q.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    public void setA11yClassName(String str) {
        this.f1956r = str;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i9) {
        if (!a()) {
            super.setBackgroundColor(i9);
            return;
        }
        c cVar = this.f1950l;
        if (cVar.b(false) != null) {
            cVar.b(false).setTint(i9);
        }
    }

    @Override // n.p, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (!a()) {
            super.setBackgroundDrawable(drawable);
            return;
        }
        if (drawable == getBackground()) {
            getBackground().setState(drawable.getState());
            return;
        }
        Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
        c cVar = this.f1950l;
        cVar.f3138o = true;
        MaterialButton materialButton = cVar.f3125a;
        materialButton.setSupportBackgroundTintList(cVar.f3133j);
        materialButton.setSupportBackgroundTintMode(cVar.f3132i);
        super.setBackgroundDrawable(drawable);
    }

    @Override // n.p, android.view.View
    public void setBackgroundResource(int i9) {
        setBackgroundDrawable(i9 != 0 ? android.support.v4.media.session.b.I(getContext(), i9) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z8) {
        if (a()) {
            this.f1950l.f3140q = z8;
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z8) {
        c cVar = this.f1950l;
        if (cVar == null || !cVar.f3140q || !isEnabled() || this.f1961w == z8) {
            return;
        }
        this.f1961w = z8;
        refreshDrawableState();
        if (getParent() instanceof MaterialButtonToggleGroup) {
            MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) getParent();
            boolean z9 = this.f1961w;
            if (!materialButtonToggleGroup.f1970n) {
                materialButtonToggleGroup.b(getId(), z9);
            }
        }
        if (this.f1962x) {
            return;
        }
        this.f1962x = true;
        Iterator it = this.f1951m.iterator();
        if (it.hasNext()) {
            throw androidx.activity.g.l(it);
        }
        this.f1962x = false;
    }

    public void setCornerRadius(int i9) {
        if (a()) {
            c cVar = this.f1950l;
            if (cVar.f3139p && cVar.f3131g == i9) {
                return;
            }
            cVar.f3131g = i9;
            cVar.f3139p = true;
            b e9 = cVar.f3126b.e();
            e9.c(i9);
            cVar.c(e9.a());
        }
    }

    public void setCornerRadiusResource(int i9) {
        if (a()) {
            setCornerRadius(getResources().getDimensionPixelSize(i9));
        }
    }

    @Override // android.view.View
    public void setElevation(float f9) {
        super.setElevation(f9);
        if (a()) {
            this.f1950l.b(false).k(f9);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f1955q != drawable) {
            this.f1955q = drawable;
            c(true);
            d(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i9) {
        if (this.f1963y != i9) {
            this.f1963y = i9;
            d(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i9) {
        if (this.f1960v != i9) {
            this.f1960v = i9;
            setCompoundDrawablePadding(i9);
        }
    }

    public void setIconResource(int i9) {
        setIcon(i9 != 0 ? android.support.v4.media.session.b.I(getContext(), i9) : null);
    }

    public void setIconSize(int i9) {
        if (i9 < 0) {
            m7.c.n("iconSize cannot be less than 0");
        } else if (this.f1957s != i9) {
            this.f1957s = i9;
            c(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f1954p != colorStateList) {
            this.f1954p = colorStateList;
            c(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f1953o != mode) {
            this.f1953o = mode;
            c(false);
        }
    }

    public void setIconTintResource(int i9) {
        setIconTint(a.a.u(getContext(), i9));
    }

    public void setInsetBottom(int i9) {
        c cVar = this.f1950l;
        cVar.d(cVar.f3129e, i9);
    }

    public void setInsetTop(int i9) {
        c cVar = this.f1950l;
        cVar.d(i9, cVar.f3130f);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(a aVar) {
        this.f1952n = aVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z8) {
        a aVar = this.f1952n;
        if (aVar != null) {
            ((MaterialButtonToggleGroup) ((a0.b) aVar).f8j).invalidate();
        }
        super.setPressed(z8);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (a()) {
            c cVar = this.f1950l;
            MaterialButton materialButton = cVar.f3125a;
            if (cVar.f3135l != colorStateList) {
                cVar.f3135l = colorStateList;
                if (materialButton.getBackground() instanceof RippleDrawable) {
                    ((RippleDrawable) materialButton.getBackground()).setColor(s5.b.a(colorStateList));
                }
            }
        }
    }

    public void setRippleColorResource(int i9) {
        if (a()) {
            setRippleColor(a.a.u(getContext(), i9));
        }
    }

    @Override // u5.t
    public void setShapeAppearanceModel(j jVar) {
        if (a()) {
            this.f1950l.c(jVar);
        } else {
            m7.c.p("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
    }

    public void setShouldDrawSurfaceColorStroke(boolean z8) {
        if (a()) {
            c cVar = this.f1950l;
            cVar.f3137n = z8;
            cVar.f();
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (a()) {
            c cVar = this.f1950l;
            if (cVar.f3134k != colorStateList) {
                cVar.f3134k = colorStateList;
                cVar.f();
            }
        }
    }

    public void setStrokeColorResource(int i9) {
        if (a()) {
            setStrokeColor(a.a.u(getContext(), i9));
        }
    }

    public void setStrokeWidth(int i9) {
        if (a()) {
            c cVar = this.f1950l;
            if (cVar.h != i9) {
                cVar.h = i9;
                cVar.f();
            }
        }
    }

    public void setStrokeWidthResource(int i9) {
        if (a()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i9));
        }
    }

    @Override // n.p
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (!a()) {
            super.setSupportBackgroundTintList(colorStateList);
            return;
        }
        c cVar = this.f1950l;
        if (cVar.f3133j != colorStateList) {
            cVar.f3133j = colorStateList;
            if (cVar.b(false) != null) {
                g0.b.h(cVar.b(false), cVar.f3133j);
            }
        }
    }

    @Override // n.p
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (!a()) {
            super.setSupportBackgroundTintMode(mode);
            return;
        }
        c cVar = this.f1950l;
        if (cVar.f3132i != mode) {
            cVar.f3132i = mode;
            if (cVar.b(false) == null || cVar.f3132i == null) {
                return;
            }
            g0.b.i(cVar.b(false), cVar.f3132i);
        }
    }

    @Override // android.view.View
    public void setTextAlignment(int i9) {
        super.setTextAlignment(i9);
        d(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z8) {
        this.f1950l.f3141r = z8;
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f1961w);
    }
}
