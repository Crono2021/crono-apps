package com.google.android.material.chip;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import d1.p;
import g0.f;
import i5.a;
import i5.c;
import i5.d;
import i5.e;
import i7.r3;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Locale;
import java.util.WeakHashMap;
import l0.i;
import l0.k;
import n.q;
import n0.c0;
import n0.d0;
import n0.i0;
import n0.t0;
import o5.g;
import o5.h;
import o5.m;
import o5.o;
import u5.j;
import u5.t;
import z4.b;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class Chip extends q implements d, t, h {
    public static final Rect F = new Rect();
    public static final int[] G = {R.attr.state_selected};
    public static final int[] H = {R.attr.state_checkable};
    public final c A;
    public boolean B;
    public final Rect C;
    public final RectF D;
    public final a E;

    /* renamed from: m, reason: collision with root package name */
    public e f1984m;

    /* renamed from: n, reason: collision with root package name */
    public InsetDrawable f1985n;

    /* renamed from: o, reason: collision with root package name */
    public RippleDrawable f1986o;

    /* renamed from: p, reason: collision with root package name */
    public View.OnClickListener f1987p;

    /* renamed from: q, reason: collision with root package name */
    public CompoundButton.OnCheckedChangeListener f1988q;

    /* renamed from: r, reason: collision with root package name */
    public g f1989r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f1990s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f1991t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f1992u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f1993v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f1994w;

    /* renamed from: x, reason: collision with root package name */
    public int f1995x;

    /* renamed from: y, reason: collision with root package name */
    public int f1996y;

    /* renamed from: z, reason: collision with root package name */
    public CharSequence f1997z;

    public Chip(Context context, AttributeSet attributeSet) {
        super(z5.a.a(context, attributeSet, 2130968774, 2132018214), attributeSet, 2130968774);
        int resourceId;
        int resourceId2;
        int resourceId3;
        this.C = new Rect();
        this.D = new RectF();
        this.E = new a(this, 0);
        Context context2 = getContext();
        if (attributeSet != null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
                Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
                androidx.fragment.app.a.h("Please set left drawable using R.attr#chipIcon.");
                throw null;
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
                androidx.fragment.app.a.h("Please set start drawable using R.attr#chipIcon.");
                throw null;
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
                androidx.fragment.app.a.h("Please set end drawable using R.attr#closeIcon.");
                throw null;
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
                androidx.fragment.app.a.h("Please set end drawable using R.attr#closeIcon.");
                throw null;
            }
            if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
                androidx.fragment.app.a.h("Chip does not support multi-line text");
                throw null;
            }
            if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                Log.w("Chip", "Chip text must be vertically center and start aligned");
            }
        }
        e eVar = new e(context2, attributeSet);
        Context context3 = eVar.f4731m0;
        int[] iArr = y4.a.f10500e;
        TypedArray f9 = o.f(context3, attributeSet, iArr, 2130968774, 2132018214, new int[0]);
        eVar.M0 = f9.hasValue(37);
        Context context4 = eVar.f4731m0;
        ColorStateList B = com.bumptech.glide.d.B(context4, f9, 24);
        if (eVar.F != B) {
            eVar.F = B;
            eVar.onStateChange(eVar.getState());
        }
        ColorStateList B2 = com.bumptech.glide.d.B(context4, f9, 11);
        if (eVar.G != B2) {
            eVar.G = B2;
            eVar.onStateChange(eVar.getState());
        }
        float dimension = f9.getDimension(19, 0.0f);
        if (eVar.H != dimension) {
            eVar.H = dimension;
            eVar.invalidateSelf();
            eVar.y();
        }
        if (f9.hasValue(12)) {
            eVar.E(f9.getDimension(12, 0.0f));
        }
        eVar.J(com.bumptech.glide.d.B(context4, f9, 22));
        eVar.K(f9.getDimension(23, 0.0f));
        eVar.T(com.bumptech.glide.d.B(context4, f9, 36));
        String text = f9.getText(5);
        text = text == null ? "" : text;
        if (!TextUtils.equals(eVar.M, text)) {
            eVar.M = text;
            eVar.f4737s0.f7995d = true;
            eVar.invalidateSelf();
            eVar.y();
        }
        r5.d dVar = (!f9.hasValue(0) || (resourceId3 = f9.getResourceId(0, 0)) == 0) ? null : new r5.d(context4, resourceId3);
        dVar.f8574k = f9.getDimension(1, dVar.f8574k);
        int i9 = Build.VERSION.SDK_INT;
        if (i9 < 23) {
            dVar.f8573j = com.bumptech.glide.d.B(context4, f9, 2);
        }
        eVar.U(dVar);
        int i10 = f9.getInt(3, 0);
        if (i10 == 1) {
            eVar.J0 = TextUtils.TruncateAt.START;
        } else if (i10 == 2) {
            eVar.J0 = TextUtils.TruncateAt.MIDDLE;
        } else if (i10 == 3) {
            eVar.J0 = TextUtils.TruncateAt.END;
        }
        eVar.I(f9.getBoolean(18, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            eVar.I(f9.getBoolean(15, false));
        }
        eVar.F(com.bumptech.glide.d.E(context4, f9, 14));
        if (f9.hasValue(17)) {
            eVar.H(com.bumptech.glide.d.B(context4, f9, 17));
        }
        eVar.G(f9.getDimension(16, -1.0f));
        eVar.Q(f9.getBoolean(31, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            eVar.Q(f9.getBoolean(26, false));
        }
        eVar.L(com.bumptech.glide.d.E(context4, f9, 25));
        eVar.P(com.bumptech.glide.d.B(context4, f9, 30));
        eVar.N(f9.getDimension(28, 0.0f));
        eVar.A(f9.getBoolean(6, false));
        eVar.D(f9.getBoolean(10, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            eVar.D(f9.getBoolean(8, false));
        }
        eVar.B(com.bumptech.glide.d.E(context4, f9, 7));
        if (f9.hasValue(9)) {
            eVar.C(com.bumptech.glide.d.B(context4, f9, 9));
        }
        eVar.f4722c0 = (!f9.hasValue(39) || (resourceId2 = f9.getResourceId(39, 0)) == 0) ? null : b.a(context4, resourceId2);
        eVar.f4723d0 = (!f9.hasValue(33) || (resourceId = f9.getResourceId(33, 0)) == 0) ? null : b.a(context4, resourceId);
        float dimension2 = f9.getDimension(21, 0.0f);
        if (eVar.f4724e0 != dimension2) {
            eVar.f4724e0 = dimension2;
            eVar.invalidateSelf();
            eVar.y();
        }
        eVar.S(f9.getDimension(35, 0.0f));
        eVar.R(f9.getDimension(34, 0.0f));
        float dimension3 = f9.getDimension(41, 0.0f);
        if (eVar.f4727h0 != dimension3) {
            eVar.f4727h0 = dimension3;
            eVar.invalidateSelf();
            eVar.y();
        }
        float dimension4 = f9.getDimension(40, 0.0f);
        if (eVar.i0 != dimension4) {
            eVar.i0 = dimension4;
            eVar.invalidateSelf();
            eVar.y();
        }
        eVar.O(f9.getDimension(29, 0.0f));
        eVar.M(f9.getDimension(27, 0.0f));
        float dimension5 = f9.getDimension(13, 0.0f);
        if (eVar.f4730l0 != dimension5) {
            eVar.f4730l0 = dimension5;
            eVar.invalidateSelf();
            eVar.y();
        }
        eVar.L0 = f9.getDimensionPixelSize(4, Integer.MAX_VALUE);
        f9.recycle();
        o.a(context2, attributeSet, 2130968774, 2132018214);
        o.b(context2, attributeSet, iArr, 2130968774, 2132018214, new int[0]);
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, 2130968774, 2132018214);
        this.f1994w = obtainStyledAttributes.getBoolean(32, false);
        this.f1996y = (int) Math.ceil(obtainStyledAttributes.getDimension(20, (float) Math.ceil(TypedValue.applyDimension(1, 48, getContext().getResources().getDisplayMetrics()))));
        obtainStyledAttributes.recycle();
        setChipDrawable(eVar);
        eVar.k(i0.i(this));
        o.a(context2, attributeSet, 2130968774, 2132018214);
        o.b(context2, attributeSet, iArr, 2130968774, 2132018214, new int[0]);
        TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet, iArr, 2130968774, 2132018214);
        if (i9 < 23) {
            setTextColor(com.bumptech.glide.d.B(context2, obtainStyledAttributes2, 2));
        }
        boolean hasValue = obtainStyledAttributes2.hasValue(37);
        obtainStyledAttributes2.recycle();
        this.A = new c(this, this);
        d();
        if (!hasValue) {
            setOutlineProvider(new i5.b(this));
        }
        setChecked(this.f1990s);
        setText(eVar.M);
        setEllipsize(eVar.J0);
        g();
        if (!this.f1984m.K0) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        f();
        if (this.f1994w) {
            setMinHeight(this.f1996y);
        }
        this.f1995x = d0.d(this);
        super.setOnCheckedChangeListener(new r3(this, 3));
    }

    private RectF getCloseIconTouchBounds() {
        RectF rectF = this.D;
        rectF.setEmpty();
        if (c() && this.f1987p != null) {
            e eVar = this.f1984m;
            Rect bounds = eVar.getBounds();
            rectF.setEmpty();
            if (eVar.X()) {
                float f9 = eVar.f4730l0 + eVar.f4729k0 + eVar.W + eVar.f4728j0 + eVar.i0;
                if (com.bumptech.glide.d.F(eVar) == 0) {
                    float f10 = bounds.right;
                    rectF.right = f10;
                    rectF.left = f10 - f9;
                } else {
                    float f11 = bounds.left;
                    rectF.left = f11;
                    rectF.right = f11 + f9;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
        }
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        int i9 = (int) closeIconTouchBounds.left;
        int i10 = (int) closeIconTouchBounds.top;
        int i11 = (int) closeIconTouchBounds.right;
        int i12 = (int) closeIconTouchBounds.bottom;
        Rect rect = this.C;
        rect.set(i9, i10, i11, i12);
        return rect;
    }

    private r5.d getTextAppearance() {
        e eVar = this.f1984m;
        if (eVar != null) {
            return eVar.f4737s0.f7997f;
        }
        return null;
    }

    private void setCloseIconHovered(boolean z8) {
        if (this.f1992u != z8) {
            this.f1992u = z8;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z8) {
        if (this.f1991t != z8) {
            this.f1991t = z8;
            refreshDrawableState();
        }
    }

    public final void b(int i9) {
        this.f1996y = i9;
        if (!this.f1994w) {
            InsetDrawable insetDrawable = this.f1985n;
            if (insetDrawable == null) {
                int[] iArr = s5.b.f8857a;
                e();
                return;
            } else {
                if (insetDrawable != null) {
                    this.f1985n = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    int[] iArr2 = s5.b.f8857a;
                    e();
                    return;
                }
                return;
            }
        }
        int max = Math.max(0, i9 - ((int) this.f1984m.H));
        int max2 = Math.max(0, i9 - this.f1984m.getIntrinsicWidth());
        if (max2 <= 0 && max <= 0) {
            InsetDrawable insetDrawable2 = this.f1985n;
            if (insetDrawable2 == null) {
                int[] iArr3 = s5.b.f8857a;
                e();
                return;
            } else {
                if (insetDrawable2 != null) {
                    this.f1985n = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    int[] iArr4 = s5.b.f8857a;
                    e();
                    return;
                }
                return;
            }
        }
        int i10 = max2 > 0 ? max2 / 2 : 0;
        int i11 = max > 0 ? max / 2 : 0;
        if (this.f1985n != null) {
            Rect rect = new Rect();
            this.f1985n.getPadding(rect);
            if (rect.top == i11 && rect.bottom == i11 && rect.left == i10 && rect.right == i10) {
                int[] iArr5 = s5.b.f8857a;
                e();
                return;
            }
        }
        if (getMinHeight() != i9) {
            setMinHeight(i9);
        }
        if (getMinWidth() != i9) {
            setMinWidth(i9);
        }
        this.f1985n = new InsetDrawable((Drawable) this.f1984m, i10, i11, i10, i11);
        int[] iArr6 = s5.b.f8857a;
        e();
    }

    public final boolean c() {
        e eVar = this.f1984m;
        if (eVar == null) {
            return false;
        }
        Drawable drawable = eVar.T;
        if (drawable == null) {
            drawable = null;
        } else if (drawable instanceof f) {
            drawable = ((f) drawable).f3649n;
        }
        return drawable != null;
    }

    public final void d() {
        e eVar;
        if (!c() || (eVar = this.f1984m) == null || !eVar.S || this.f1987p == null) {
            t0.p(this, null);
            this.B = false;
        } else {
            t0.p(this, this.A);
            this.B = true;
        }
    }

    @Override // android.view.View
    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        int i9;
        if (!this.B) {
            return super.dispatchHoverEvent(motionEvent);
        }
        c cVar = this.A;
        AccessibilityManager accessibilityManager = cVar.h;
        int i10 = 0;
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action == 7 || action == 9) {
                float x6 = motionEvent.getX();
                float y2 = motionEvent.getY();
                Chip chip = cVar.f4719q;
                if (chip.c() && chip.getCloseIconTouchBounds().contains(x6, y2)) {
                    i10 = 1;
                }
                int i11 = cVar.f9207m;
                if (i11 != i10) {
                    cVar.f9207m = i10;
                    cVar.q(i10, 128);
                    cVar.q(i11, 256);
                    return true;
                }
            } else if (action == 10 && (i9 = cVar.f9207m) != Integer.MIN_VALUE) {
                if (i9 != Integer.MIN_VALUE) {
                    cVar.f9207m = Integer.MIN_VALUE;
                    cVar.q(Integer.MIN_VALUE, 128);
                    cVar.q(i9, 256);
                    return true;
                }
            }
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.B) {
            return super.dispatchKeyEvent(keyEvent);
        }
        c cVar = this.A;
        cVar.getClass();
        boolean z8 = false;
        int i9 = 0;
        z8 = false;
        z8 = false;
        z8 = false;
        z8 = false;
        z8 = false;
        if (keyEvent.getAction() != 1) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                int i10 = 66;
                if (keyCode != 66) {
                    switch (keyCode) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                            if (keyEvent.hasNoModifiers()) {
                                if (keyCode == 19) {
                                    i10 = 33;
                                } else if (keyCode == 21) {
                                    i10 = 17;
                                } else if (keyCode != 22) {
                                    i10 = 130;
                                }
                                int repeatCount = keyEvent.getRepeatCount() + 1;
                                boolean z9 = false;
                                while (i9 < repeatCount && cVar.m(i10, null)) {
                                    i9++;
                                    z9 = true;
                                }
                                z8 = z9;
                                break;
                            }
                            break;
                    }
                }
                if (keyEvent.hasNoModifiers() && keyEvent.getRepeatCount() == 0) {
                    int i11 = cVar.f9206l;
                    if (i11 != Integer.MIN_VALUE) {
                        Chip chip = cVar.f4719q;
                        if (i11 == 0) {
                            chip.performClick();
                        } else if (i11 == 1) {
                            chip.playSoundEffect(0);
                            View.OnClickListener onClickListener = chip.f1987p;
                            if (onClickListener != null) {
                                onClickListener.onClick(chip);
                            }
                            if (chip.B) {
                                chip.A.q(1, 1);
                            }
                        }
                    }
                    z8 = true;
                }
            } else if (keyEvent.hasNoModifiers()) {
                z8 = cVar.m(2, null);
            } else if (keyEvent.hasModifiers(1)) {
                z8 = cVar.m(1, null);
            }
        }
        if (!z8 || cVar.f9206l == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [boolean, int] */
    @Override // n.q, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        int i9;
        super.drawableStateChanged();
        e eVar = this.f1984m;
        boolean z8 = false;
        if (eVar != null && e.x(eVar.T)) {
            e eVar2 = this.f1984m;
            ?? isEnabled = isEnabled();
            int i10 = isEnabled;
            if (this.f1993v) {
                i10 = isEnabled + 1;
            }
            int i11 = i10;
            if (this.f1992u) {
                i11 = i10 + 1;
            }
            int i12 = i11;
            if (this.f1991t) {
                i12 = i11 + 1;
            }
            int i13 = i12;
            if (isChecked()) {
                i13 = i12 + 1;
            }
            int[] iArr = new int[i13];
            if (isEnabled()) {
                iArr[0] = 16842910;
                i9 = 1;
            } else {
                i9 = 0;
            }
            if (this.f1993v) {
                iArr[i9] = 16842908;
                i9++;
            }
            if (this.f1992u) {
                iArr[i9] = 16843623;
                i9++;
            }
            if (this.f1991t) {
                iArr[i9] = 16842919;
                i9++;
            }
            if (isChecked()) {
                iArr[i9] = 16842913;
            }
            if (!Arrays.equals(eVar2.G0, iArr)) {
                eVar2.G0 = iArr;
                if (eVar2.X()) {
                    z8 = eVar2.z(eVar2.getState(), iArr);
                }
            }
        }
        if (z8) {
            invalidate();
        }
    }

    public final void e() {
        this.f1986o = new RippleDrawable(s5.b.a(this.f1984m.L), getBackgroundDrawable(), null);
        this.f1984m.getClass();
        RippleDrawable rippleDrawable = this.f1986o;
        WeakHashMap weakHashMap = t0.f7209a;
        c0.q(this, rippleDrawable);
        f();
    }

    public final void f() {
        e eVar;
        if (TextUtils.isEmpty(getText()) || (eVar = this.f1984m) == null) {
            return;
        }
        int u3 = (int) (eVar.u() + eVar.f4730l0 + eVar.i0);
        e eVar2 = this.f1984m;
        int t8 = (int) (eVar2.t() + eVar2.f4724e0 + eVar2.f4727h0);
        if (this.f1985n != null) {
            Rect rect = new Rect();
            this.f1985n.getPadding(rect);
            t8 += rect.left;
            u3 += rect.right;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        WeakHashMap weakHashMap = t0.f7209a;
        d0.k(this, t8, paddingTop, u3, paddingBottom);
    }

    public final void g() {
        TextPaint paint = getPaint();
        e eVar = this.f1984m;
        if (eVar != null) {
            paint.drawableState = eVar.getState();
        }
        r5.d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.e(getContext(), paint, this.E);
        }
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.f1997z)) {
            return this.f1997z;
        }
        e eVar = this.f1984m;
        if (eVar == null || !eVar.Y) {
            return isClickable() ? "android.widget.Button" : "android.view.View";
        }
        ViewParent parent = getParent();
        return ((parent instanceof ChipGroup) && ((ChipGroup) parent).f2001p.f7935d) ? "android.widget.RadioButton" : "android.widget.Button";
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f1985n;
        return insetDrawable == null ? this.f1984m : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        e eVar = this.f1984m;
        if (eVar != null) {
            return eVar.f4720a0;
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        e eVar = this.f1984m;
        if (eVar != null) {
            return eVar.f4721b0;
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        e eVar = this.f1984m;
        if (eVar != null) {
            return eVar.G;
        }
        return null;
    }

    public float getChipCornerRadius() {
        e eVar = this.f1984m;
        if (eVar != null) {
            return Math.max(0.0f, eVar.v());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f1984m;
    }

    public float getChipEndPadding() {
        e eVar = this.f1984m;
        if (eVar != null) {
            return eVar.f4730l0;
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        Drawable drawable;
        e eVar = this.f1984m;
        if (eVar == null || (drawable = eVar.O) == null) {
            return null;
        }
        return drawable instanceof f ? ((f) drawable).f3649n : drawable;
    }

    public float getChipIconSize() {
        e eVar = this.f1984m;
        if (eVar != null) {
            return eVar.Q;
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        e eVar = this.f1984m;
        if (eVar != null) {
            return eVar.P;
        }
        return null;
    }

    public float getChipMinHeight() {
        e eVar = this.f1984m;
        if (eVar != null) {
            return eVar.H;
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        e eVar = this.f1984m;
        if (eVar != null) {
            return eVar.f4724e0;
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        e eVar = this.f1984m;
        if (eVar != null) {
            return eVar.J;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        e eVar = this.f1984m;
        if (eVar != null) {
            return eVar.K;
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        Drawable drawable;
        e eVar = this.f1984m;
        if (eVar == null || (drawable = eVar.T) == null) {
            return null;
        }
        return drawable instanceof f ? ((f) drawable).f3649n : drawable;
    }

    public CharSequence getCloseIconContentDescription() {
        e eVar = this.f1984m;
        if (eVar != null) {
            return eVar.X;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        e eVar = this.f1984m;
        if (eVar != null) {
            return eVar.f4729k0;
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        e eVar = this.f1984m;
        if (eVar != null) {
            return eVar.W;
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        e eVar = this.f1984m;
        if (eVar != null) {
            return eVar.f4728j0;
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        e eVar = this.f1984m;
        if (eVar != null) {
            return eVar.V;
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        e eVar = this.f1984m;
        if (eVar != null) {
            return eVar.J0;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final void getFocusedRect(Rect rect) {
        if (this.B) {
            c cVar = this.A;
            if (cVar.f9206l == 1 || cVar.f9205k == 1) {
                rect.set(getCloseIconTouchBoundsInt());
                return;
            }
        }
        super.getFocusedRect(rect);
    }

    public b getHideMotionSpec() {
        e eVar = this.f1984m;
        if (eVar != null) {
            return eVar.f4723d0;
        }
        return null;
    }

    public float getIconEndPadding() {
        e eVar = this.f1984m;
        if (eVar != null) {
            return eVar.f4726g0;
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        e eVar = this.f1984m;
        if (eVar != null) {
            return eVar.f4725f0;
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        e eVar = this.f1984m;
        if (eVar != null) {
            return eVar.L;
        }
        return null;
    }

    public j getShapeAppearanceModel() {
        return this.f1984m.f9084i.f9069a;
    }

    public b getShowMotionSpec() {
        e eVar = this.f1984m;
        if (eVar != null) {
            return eVar.f4722c0;
        }
        return null;
    }

    public float getTextEndPadding() {
        e eVar = this.f1984m;
        if (eVar != null) {
            return eVar.i0;
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        e eVar = this.f1984m;
        if (eVar != null) {
            return eVar.f4727h0;
        }
        return 0.0f;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bumptech.glide.d.b0(this, this.f1984m);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i9) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i9 + 2);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, G);
        }
        e eVar = this.f1984m;
        if (eVar != null && eVar.Y) {
            View.mergeDrawableStates(onCreateDrawableState, H);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean z8, int i9, Rect rect) {
        super.onFocusChanged(z8, i9, rect);
        if (this.B) {
            c cVar = this.A;
            int i10 = cVar.f9206l;
            if (i10 != Integer.MIN_VALUE) {
                cVar.j(i10);
            }
            if (z8) {
                cVar.m(i9, rect);
            }
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i9;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        e eVar = this.f1984m;
        int i10 = 0;
        accessibilityNodeInfo.setCheckable(eVar != null && eVar.Y);
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            if (chipGroup.f7973k) {
                int i11 = 0;
                while (true) {
                    if (i10 >= chipGroup.getChildCount()) {
                        i11 = -1;
                        break;
                    }
                    View childAt = chipGroup.getChildAt(i10);
                    if ((childAt instanceof Chip) && chipGroup.getChildAt(i10).getVisibility() == 0) {
                        if (((Chip) childAt) == this) {
                            break;
                        } else {
                            i11++;
                        }
                    }
                    i10++;
                }
                i9 = i11;
            } else {
                i9 = -1;
            }
            Object tag = getTag(2131362331);
            accessibilityNodeInfo.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(!(tag instanceof Integer) ? -1 : ((Integer) tag).intValue(), 1, i9, 1, false, isChecked()));
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public final PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i9) {
        return (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) ? PointerIcon.getSystemIcon(getContext(), 1002) : super.onResolvePointerIcon(motionEvent, i9);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRtlPropertiesChanged(int i9) {
        super.onRtlPropertiesChanged(i9);
        if (this.f1995x != i9) {
            this.f1995x = i9;
            f();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
    
        if (r0 != 3) goto L28;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L4a
            if (r0 == r2) goto L2c
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L45
            goto L50
        L21:
            boolean r0 = r5.f1991t
            if (r0 == 0) goto L50
            if (r1 != 0) goto L2a
            r5.setCloseIconPressed(r3)
        L2a:
            r0 = 1
            goto L51
        L2c:
            boolean r0 = r5.f1991t
            if (r0 == 0) goto L45
            r5.playSoundEffect(r3)
            android.view.View$OnClickListener r0 = r5.f1987p
            if (r0 == 0) goto L3a
            r0.onClick(r5)
        L3a:
            boolean r0 = r5.B
            if (r0 == 0) goto L43
            i5.c r0 = r5.A
            r0.q(r2, r2)
        L43:
            r0 = 1
            goto L46
        L45:
            r0 = 0
        L46:
            r5.setCloseIconPressed(r3)
            goto L51
        L4a:
            if (r1 == 0) goto L50
            r5.setCloseIconPressed(r2)
            goto L2a
        L50:
            r0 = 0
        L51:
            if (r0 != 0) goto L5b
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L5a
            goto L5b
        L5a:
            return r3
        L5b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAccessibilityClassName(CharSequence charSequence) {
        this.f1997z = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f1986o) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i9) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // n.q, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f1986o) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // n.q, android.view.View
    public void setBackgroundResource(int i9) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z8) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.A(z8);
        }
    }

    public void setCheckableResource(int i9) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.A(eVar.f4731m0.getResources().getBoolean(i9));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z8) {
        e eVar = this.f1984m;
        if (eVar == null) {
            this.f1990s = z8;
        } else if (eVar.Y) {
            super.setChecked(z8);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.B(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z8) {
        setCheckedIconVisible(z8);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i9) {
        setCheckedIconVisible(i9);
    }

    public void setCheckedIconResource(int i9) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.B(android.support.v4.media.session.b.I(eVar.f4731m0, i9));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.C(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i9) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.C(a.a.u(eVar.f4731m0, i9));
        }
    }

    public void setCheckedIconVisible(int i9) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.D(eVar.f4731m0.getResources().getBoolean(i9));
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        e eVar = this.f1984m;
        if (eVar == null || eVar.G == colorStateList) {
            return;
        }
        eVar.G = colorStateList;
        eVar.onStateChange(eVar.getState());
    }

    public void setChipBackgroundColorResource(int i9) {
        ColorStateList u3;
        e eVar = this.f1984m;
        if (eVar == null || eVar.G == (u3 = a.a.u(eVar.f4731m0, i9))) {
            return;
        }
        eVar.G = u3;
        eVar.onStateChange(eVar.getState());
    }

    @Deprecated
    public void setChipCornerRadius(float f9) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.E(f9);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i9) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.E(eVar.f4731m0.getResources().getDimension(i9));
        }
    }

    public void setChipDrawable(e eVar) {
        e eVar2 = this.f1984m;
        if (eVar2 != eVar) {
            if (eVar2 != null) {
                eVar2.I0 = new WeakReference(null);
            }
            this.f1984m = eVar;
            eVar.K0 = false;
            eVar.I0 = new WeakReference(this);
            b(this.f1996y);
        }
    }

    public void setChipEndPadding(float f9) {
        e eVar = this.f1984m;
        if (eVar == null || eVar.f4730l0 == f9) {
            return;
        }
        eVar.f4730l0 = f9;
        eVar.invalidateSelf();
        eVar.y();
    }

    public void setChipEndPaddingResource(int i9) {
        e eVar = this.f1984m;
        if (eVar != null) {
            float dimension = eVar.f4731m0.getResources().getDimension(i9);
            if (eVar.f4730l0 != dimension) {
                eVar.f4730l0 = dimension;
                eVar.invalidateSelf();
                eVar.y();
            }
        }
    }

    public void setChipIcon(Drawable drawable) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.F(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z8) {
        setChipIconVisible(z8);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i9) {
        setChipIconVisible(i9);
    }

    public void setChipIconResource(int i9) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.F(android.support.v4.media.session.b.I(eVar.f4731m0, i9));
        }
    }

    public void setChipIconSize(float f9) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.G(f9);
        }
    }

    public void setChipIconSizeResource(int i9) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.G(eVar.f4731m0.getResources().getDimension(i9));
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.H(colorStateList);
        }
    }

    public void setChipIconTintResource(int i9) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.H(a.a.u(eVar.f4731m0, i9));
        }
    }

    public void setChipIconVisible(int i9) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.I(eVar.f4731m0.getResources().getBoolean(i9));
        }
    }

    public void setChipMinHeight(float f9) {
        e eVar = this.f1984m;
        if (eVar == null || eVar.H == f9) {
            return;
        }
        eVar.H = f9;
        eVar.invalidateSelf();
        eVar.y();
    }

    public void setChipMinHeightResource(int i9) {
        e eVar = this.f1984m;
        if (eVar != null) {
            float dimension = eVar.f4731m0.getResources().getDimension(i9);
            if (eVar.H != dimension) {
                eVar.H = dimension;
                eVar.invalidateSelf();
                eVar.y();
            }
        }
    }

    public void setChipStartPadding(float f9) {
        e eVar = this.f1984m;
        if (eVar == null || eVar.f4724e0 == f9) {
            return;
        }
        eVar.f4724e0 = f9;
        eVar.invalidateSelf();
        eVar.y();
    }

    public void setChipStartPaddingResource(int i9) {
        e eVar = this.f1984m;
        if (eVar != null) {
            float dimension = eVar.f4731m0.getResources().getDimension(i9);
            if (eVar.f4724e0 != dimension) {
                eVar.f4724e0 = dimension;
                eVar.invalidateSelf();
                eVar.y();
            }
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.J(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i9) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.J(a.a.u(eVar.f4731m0, i9));
        }
    }

    public void setChipStrokeWidth(float f9) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.K(f9);
        }
    }

    public void setChipStrokeWidthResource(int i9) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.K(eVar.f4731m0.getResources().getDimension(i9));
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i9) {
        setText(getResources().getString(i9));
    }

    public void setCloseIcon(Drawable drawable) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.L(drawable);
        }
        d();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        e eVar = this.f1984m;
        if (eVar == null || eVar.X == charSequence) {
            return;
        }
        String str = l0.b.f5742b;
        Locale locale = Locale.getDefault();
        int i9 = k.f5757a;
        l0.b bVar = l0.j.a(locale) == 1 ? l0.b.f5745e : l0.b.f5744d;
        bVar.getClass();
        p pVar = i.f5753a;
        eVar.X = bVar.c(charSequence);
        eVar.invalidateSelf();
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z8) {
        setCloseIconVisible(z8);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i9) {
        setCloseIconVisible(i9);
    }

    public void setCloseIconEndPadding(float f9) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.M(f9);
        }
    }

    public void setCloseIconEndPaddingResource(int i9) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.M(eVar.f4731m0.getResources().getDimension(i9));
        }
    }

    public void setCloseIconResource(int i9) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.L(android.support.v4.media.session.b.I(eVar.f4731m0, i9));
        }
        d();
    }

    public void setCloseIconSize(float f9) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.N(f9);
        }
    }

    public void setCloseIconSizeResource(int i9) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.N(eVar.f4731m0.getResources().getDimension(i9));
        }
    }

    public void setCloseIconStartPadding(float f9) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.O(f9);
        }
    }

    public void setCloseIconStartPaddingResource(int i9) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.O(eVar.f4731m0.getResources().getDimension(i9));
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.P(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i9) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.P(a.a.u(eVar.f4731m0, i9));
        }
    }

    public void setCloseIconVisible(int i9) {
        setCloseIconVisible(getResources().getBoolean(i9));
    }

    @Override // n.q, android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            androidx.fragment.app.a.h("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        } else {
            androidx.fragment.app.a.h("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // n.q, android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            androidx.fragment.app.a.h("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        } else {
            androidx.fragment.app.a.h("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i9, int i10, int i11, int i12) {
        if (i9 != 0) {
            androidx.fragment.app.a.h("Please set start drawable using R.attr#chipIcon.");
        } else if (i11 == 0) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(i9, i10, i11, i12);
        } else {
            androidx.fragment.app.a.h("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i9, int i10, int i11, int i12) {
        if (i9 != 0) {
            androidx.fragment.app.a.h("Please set start drawable using R.attr#chipIcon.");
        } else if (i11 == 0) {
            super.setCompoundDrawablesWithIntrinsicBounds(i9, i10, i11, i12);
        } else {
            androidx.fragment.app.a.h("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.view.View
    public void setElevation(float f9) {
        super.setElevation(f9);
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.k(f9);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f1984m == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            androidx.fragment.app.a.h("Text within a chip are not allowed to scroll.");
            return;
        }
        super.setEllipsize(truncateAt);
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.J0 = truncateAt;
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z8) {
        this.f1994w = z8;
        b(this.f1996y);
    }

    @Override // android.widget.TextView
    public void setGravity(int i9) {
        if (i9 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i9);
        }
    }

    public void setHideMotionSpec(b bVar) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.f4723d0 = bVar;
        }
    }

    public void setHideMotionSpecResource(int i9) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.f4723d0 = b.a(eVar.f4731m0, i9);
        }
    }

    public void setIconEndPadding(float f9) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.R(f9);
        }
    }

    public void setIconEndPaddingResource(int i9) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.R(eVar.f4731m0.getResources().getDimension(i9));
        }
    }

    public void setIconStartPadding(float f9) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.S(f9);
        }
    }

    public void setIconStartPaddingResource(int i9) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.S(eVar.f4731m0.getResources().getDimension(i9));
        }
    }

    @Override // o5.h
    public void setInternalOnCheckedChangeListener(g gVar) {
        this.f1989r = gVar;
    }

    @Override // android.view.View
    public void setLayoutDirection(int i9) {
        if (this.f1984m == null) {
            return;
        }
        super.setLayoutDirection(i9);
    }

    @Override // android.widget.TextView
    public void setLines(int i9) {
        if (i9 <= 1) {
            super.setLines(i9);
        } else {
            androidx.fragment.app.a.h("Chip does not support multi-line text");
        }
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i9) {
        if (i9 <= 1) {
            super.setMaxLines(i9);
        } else {
            androidx.fragment.app.a.h("Chip does not support multi-line text");
        }
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i9) {
        super.setMaxWidth(i9);
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.L0 = i9;
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i9) {
        if (i9 <= 1) {
            super.setMinLines(i9);
        } else {
            androidx.fragment.app.a.h("Chip does not support multi-line text");
        }
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f1988q = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f1987p = onClickListener;
        d();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.T(colorStateList);
        }
        this.f1984m.getClass();
        e();
    }

    public void setRippleColorResource(int i9) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.T(a.a.u(eVar.f4731m0, i9));
            this.f1984m.getClass();
            e();
        }
    }

    @Override // u5.t
    public void setShapeAppearanceModel(j jVar) {
        this.f1984m.setShapeAppearanceModel(jVar);
    }

    public void setShowMotionSpec(b bVar) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.f4722c0 = bVar;
        }
    }

    public void setShowMotionSpecResource(int i9) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.f4722c0 = b.a(eVar.f4731m0, i9);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z8) {
        if (z8) {
            super.setSingleLine(z8);
        } else {
            androidx.fragment.app.a.h("Chip does not support multi-line text");
        }
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        e eVar = this.f1984m;
        if (eVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(eVar.K0 ? null : charSequence, bufferType);
        e eVar2 = this.f1984m;
        if (eVar2 == null || TextUtils.equals(eVar2.M, charSequence)) {
            return;
        }
        eVar2.M = charSequence;
        eVar2.f4737s0.f7995d = true;
        eVar2.invalidateSelf();
        eVar2.y();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i9) {
        super.setTextAppearance(context, i9);
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.U(new r5.d(eVar.f4731m0, i9));
        }
        g();
    }

    public void setTextAppearanceResource(int i9) {
        setTextAppearance(getContext(), i9);
    }

    public void setTextEndPadding(float f9) {
        e eVar = this.f1984m;
        if (eVar == null || eVar.i0 == f9) {
            return;
        }
        eVar.i0 = f9;
        eVar.invalidateSelf();
        eVar.y();
    }

    public void setTextEndPaddingResource(int i9) {
        e eVar = this.f1984m;
        if (eVar != null) {
            float dimension = eVar.f4731m0.getResources().getDimension(i9);
            if (eVar.i0 != dimension) {
                eVar.i0 = dimension;
                eVar.invalidateSelf();
                eVar.y();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i9, float f9) {
        super.setTextSize(i9, f9);
        e eVar = this.f1984m;
        if (eVar != null) {
            float applyDimension = TypedValue.applyDimension(i9, f9, getResources().getDisplayMetrics());
            m mVar = eVar.f4737s0;
            r5.d dVar = mVar.f7997f;
            if (dVar != null) {
                dVar.f8574k = applyDimension;
                mVar.f7992a.setTextSize(applyDimension);
                eVar.y();
                eVar.invalidateSelf();
            }
        }
        g();
    }

    public void setTextStartPadding(float f9) {
        e eVar = this.f1984m;
        if (eVar == null || eVar.f4727h0 == f9) {
            return;
        }
        eVar.f4727h0 = f9;
        eVar.invalidateSelf();
        eVar.y();
    }

    public void setTextStartPaddingResource(int i9) {
        e eVar = this.f1984m;
        if (eVar != null) {
            float dimension = eVar.f4731m0.getResources().getDimension(i9);
            if (eVar.f4727h0 != dimension) {
                eVar.f4727h0 = dimension;
                eVar.invalidateSelf();
                eVar.y();
            }
        }
    }

    public void setCloseIconVisible(boolean z8) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.Q(z8);
        }
        d();
    }

    public void setCheckedIconVisible(boolean z8) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.D(z8);
        }
    }

    public void setChipIconVisible(boolean z8) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.I(z8);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            androidx.fragment.app.a.h("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            androidx.fragment.app.a.h("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            androidx.fragment.app.a.h("Please set left drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            androidx.fragment.app.a.h("Please set right drawable using R.attr#closeIcon.");
        }
    }

    public void setTextAppearance(r5.d dVar) {
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.U(dVar);
        }
        g();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i9) {
        super.setTextAppearance(i9);
        e eVar = this.f1984m;
        if (eVar != null) {
            eVar.U(new r5.d(eVar.f4731m0, i9));
        }
        g();
    }
}
