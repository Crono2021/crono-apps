package com.google.android.material.textfield;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.animation.LinearInterpolator;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c7.b;
import com.bumptech.glide.d;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.WeakHashMap;
import n.e1;
import n.r1;
import n.x2;
import n0.c0;
import n0.d0;
import n0.f0;
import n0.k0;
import n0.t0;
import o5.c;
import o5.o;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import u5.e;
import u5.f;
import u5.g;
import u5.i;
import u5.j;
import v3.h;
import w2.k;
import x5.l;
import x5.p;
import x5.r;
import x5.t;
import x5.u;
import x5.v;
import x5.w;
import x5.x;
import z5.a;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class TextInputLayout extends LinearLayout {
    public static final int[][] I0 = {new int[]{R.attr.state_pressed}, new int[0]};
    public boolean A;
    public int A0;
    public e1 B;
    public boolean B0;
    public ColorStateList C;
    public final c C0;
    public int D;
    public boolean D0;
    public h E;
    public boolean E0;
    public h F;
    public ValueAnimator F0;
    public ColorStateList G;
    public boolean G0;
    public ColorStateList H;
    public boolean H0;
    public ColorStateList I;
    public ColorStateList J;
    public boolean K;
    public CharSequence L;
    public boolean M;
    public g N;
    public g O;
    public StateListDrawable P;
    public boolean Q;
    public g R;
    public g S;
    public j T;
    public boolean U;
    public final int V;
    public int W;

    /* renamed from: a0, reason: collision with root package name */
    public int f2131a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f2132b0;

    /* renamed from: c0, reason: collision with root package name */
    public int f2133c0;

    /* renamed from: d0, reason: collision with root package name */
    public int f2134d0;

    /* renamed from: e0, reason: collision with root package name */
    public int f2135e0;

    /* renamed from: f0, reason: collision with root package name */
    public int f2136f0;

    /* renamed from: g0, reason: collision with root package name */
    public final Rect f2137g0;

    /* renamed from: h0, reason: collision with root package name */
    public final Rect f2138h0;

    /* renamed from: i, reason: collision with root package name */
    public final FrameLayout f2139i;
    public final RectF i0;

    /* renamed from: j, reason: collision with root package name */
    public final t f2140j;

    /* renamed from: j0, reason: collision with root package name */
    public Typeface f2141j0;

    /* renamed from: k, reason: collision with root package name */
    public final l f2142k;

    /* renamed from: k0, reason: collision with root package name */
    public ColorDrawable f2143k0;

    /* renamed from: l, reason: collision with root package name */
    public EditText f2144l;

    /* renamed from: l0, reason: collision with root package name */
    public int f2145l0;

    /* renamed from: m, reason: collision with root package name */
    public CharSequence f2146m;

    /* renamed from: m0, reason: collision with root package name */
    public final LinkedHashSet f2147m0;

    /* renamed from: n, reason: collision with root package name */
    public int f2148n;

    /* renamed from: n0, reason: collision with root package name */
    public ColorDrawable f2149n0;

    /* renamed from: o, reason: collision with root package name */
    public int f2150o;

    /* renamed from: o0, reason: collision with root package name */
    public int f2151o0;

    /* renamed from: p, reason: collision with root package name */
    public int f2152p;

    /* renamed from: p0, reason: collision with root package name */
    public Drawable f2153p0;

    /* renamed from: q, reason: collision with root package name */
    public int f2154q;

    /* renamed from: q0, reason: collision with root package name */
    public ColorStateList f2155q0;

    /* renamed from: r, reason: collision with root package name */
    public final p f2156r;

    /* renamed from: r0, reason: collision with root package name */
    public ColorStateList f2157r0;

    /* renamed from: s, reason: collision with root package name */
    public boolean f2158s;

    /* renamed from: s0, reason: collision with root package name */
    public int f2159s0;

    /* renamed from: t, reason: collision with root package name */
    public int f2160t;

    /* renamed from: t0, reason: collision with root package name */
    public int f2161t0;

    /* renamed from: u, reason: collision with root package name */
    public boolean f2162u;

    /* renamed from: u0, reason: collision with root package name */
    public int f2163u0;

    /* renamed from: v, reason: collision with root package name */
    public w f2164v;

    /* renamed from: v0, reason: collision with root package name */
    public ColorStateList f2165v0;

    /* renamed from: w, reason: collision with root package name */
    public e1 f2166w;

    /* renamed from: w0, reason: collision with root package name */
    public int f2167w0;

    /* renamed from: x, reason: collision with root package name */
    public int f2168x;

    /* renamed from: x0, reason: collision with root package name */
    public int f2169x0;

    /* renamed from: y, reason: collision with root package name */
    public int f2170y;

    /* renamed from: y0, reason: collision with root package name */
    public int f2171y0;

    /* renamed from: z, reason: collision with root package name */
    public CharSequence f2172z;

    /* renamed from: z0, reason: collision with root package name */
    public int f2173z0;

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        super(a.a(context, attributeSet, 2130969658, 2132018015), attributeSet, 2130969658);
        this.f2148n = -1;
        this.f2150o = -1;
        this.f2152p = -1;
        this.f2154q = -1;
        this.f2156r = new p(this);
        this.f2164v = new k(3);
        this.f2137g0 = new Rect();
        this.f2138h0 = new Rect();
        this.i0 = new RectF();
        this.f2147m0 = new LinkedHashSet();
        c cVar = new c(this);
        this.C0 = cVar;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f2139i = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        LinearInterpolator linearInterpolator = z4.a.f10659a;
        cVar.Q = linearInterpolator;
        cVar.h(false);
        cVar.P = linearInterpolator;
        cVar.h(false);
        if (cVar.f7950g != 8388659) {
            cVar.f7950g = 8388659;
            cVar.h(false);
        }
        o.a(context2, attributeSet, 2130969658, 2132018015);
        int[] iArr = y4.a.H;
        o.b(context2, attributeSet, iArr, 2130969658, 2132018015, 22, 20, 40, 45, 49);
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, 2130969658, 2132018015);
        androidx.fragment.app.g gVar = new androidx.fragment.app.g(context2, obtainStyledAttributes);
        t tVar = new t(this, gVar);
        this.f2140j = tVar;
        this.K = obtainStyledAttributes.getBoolean(48, true);
        setHint(obtainStyledAttributes.getText(4));
        this.E0 = obtainStyledAttributes.getBoolean(47, true);
        this.D0 = obtainStyledAttributes.getBoolean(42, true);
        if (obtainStyledAttributes.hasValue(6)) {
            setMinEms(obtainStyledAttributes.getInt(6, -1));
        } else if (obtainStyledAttributes.hasValue(3)) {
            setMinWidth(obtainStyledAttributes.getDimensionPixelSize(3, -1));
        }
        if (obtainStyledAttributes.hasValue(5)) {
            setMaxEms(obtainStyledAttributes.getInt(5, -1));
        } else if (obtainStyledAttributes.hasValue(2)) {
            setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(2, -1));
        }
        this.T = j.b(context2, attributeSet, 2130969658, 2132018015).a();
        this.V = context2.getResources().getDimensionPixelOffset(2131165977);
        this.f2131a0 = obtainStyledAttributes.getDimensionPixelOffset(9, 0);
        this.f2133c0 = obtainStyledAttributes.getDimensionPixelSize(16, context2.getResources().getDimensionPixelSize(2131165978));
        this.f2134d0 = obtainStyledAttributes.getDimensionPixelSize(17, context2.getResources().getDimensionPixelSize(2131165979));
        this.f2132b0 = this.f2133c0;
        float dimension = obtainStyledAttributes.getDimension(13, -1.0f);
        float dimension2 = obtainStyledAttributes.getDimension(12, -1.0f);
        float dimension3 = obtainStyledAttributes.getDimension(10, -1.0f);
        float dimension4 = obtainStyledAttributes.getDimension(11, -1.0f);
        b e9 = this.T.e();
        if (dimension >= 0.0f) {
            e9.f1652f = new u5.a(dimension);
        }
        if (dimension2 >= 0.0f) {
            e9.f1653g = new u5.a(dimension2);
        }
        if (dimension3 >= 0.0f) {
            e9.h = new u5.a(dimension3);
        }
        if (dimension4 >= 0.0f) {
            e9.f1654i = new u5.a(dimension4);
        }
        this.T = e9.a();
        ColorStateList C = d.C(context2, gVar, 7);
        if (C != null) {
            int defaultColor = C.getDefaultColor();
            this.f2167w0 = defaultColor;
            this.f2136f0 = defaultColor;
            if (C.isStateful()) {
                this.f2169x0 = C.getColorForState(new int[]{-16842910}, -1);
                this.f2171y0 = C.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
                this.f2173z0 = C.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            } else {
                this.f2171y0 = this.f2167w0;
                ColorStateList u3 = a.a.u(context2, 2131100348);
                this.f2169x0 = u3.getColorForState(new int[]{-16842910}, -1);
                this.f2173z0 = u3.getColorForState(new int[]{R.attr.state_hovered}, -1);
            }
        } else {
            this.f2136f0 = 0;
            this.f2167w0 = 0;
            this.f2169x0 = 0;
            this.f2171y0 = 0;
            this.f2173z0 = 0;
        }
        if (obtainStyledAttributes.hasValue(1)) {
            ColorStateList O = gVar.O(1);
            this.f2157r0 = O;
            this.f2155q0 = O;
        }
        ColorStateList C2 = d.C(context2, gVar, 14);
        this.f2163u0 = obtainStyledAttributes.getColor(14, 0);
        this.f2159s0 = a.a.t(context2, 2131100375);
        this.A0 = a.a.t(context2, 2131100376);
        this.f2161t0 = a.a.t(context2, 2131100379);
        if (C2 != null) {
            setBoxStrokeColorStateList(C2);
        }
        if (obtainStyledAttributes.hasValue(15)) {
            setBoxStrokeErrorColor(d.C(context2, gVar, 15));
        }
        if (obtainStyledAttributes.getResourceId(49, -1) != -1) {
            setHintTextAppearance(obtainStyledAttributes.getResourceId(49, 0));
        }
        this.I = gVar.O(24);
        this.J = gVar.O(25);
        int resourceId = obtainStyledAttributes.getResourceId(40, 0);
        CharSequence text = obtainStyledAttributes.getText(35);
        int i9 = obtainStyledAttributes.getInt(34, 1);
        boolean z8 = obtainStyledAttributes.getBoolean(36, false);
        int resourceId2 = obtainStyledAttributes.getResourceId(45, 0);
        boolean z9 = obtainStyledAttributes.getBoolean(44, false);
        CharSequence text2 = obtainStyledAttributes.getText(43);
        int resourceId3 = obtainStyledAttributes.getResourceId(57, 0);
        CharSequence text3 = obtainStyledAttributes.getText(56);
        boolean z10 = obtainStyledAttributes.getBoolean(18, false);
        setCounterMaxLength(obtainStyledAttributes.getInt(19, -1));
        this.f2170y = obtainStyledAttributes.getResourceId(22, 0);
        this.f2168x = obtainStyledAttributes.getResourceId(20, 0);
        setBoxBackgroundMode(obtainStyledAttributes.getInt(8, 0));
        setErrorContentDescription(text);
        setErrorAccessibilityLiveRegion(i9);
        setCounterOverflowTextAppearance(this.f2168x);
        setHelperTextTextAppearance(resourceId2);
        setErrorTextAppearance(resourceId);
        setCounterTextAppearance(this.f2170y);
        setPlaceholderText(text3);
        setPlaceholderTextAppearance(resourceId3);
        if (obtainStyledAttributes.hasValue(41)) {
            setErrorTextColor(gVar.O(41));
        }
        if (obtainStyledAttributes.hasValue(46)) {
            setHelperTextColor(gVar.O(46));
        }
        if (obtainStyledAttributes.hasValue(50)) {
            setHintTextColor(gVar.O(50));
        }
        if (obtainStyledAttributes.hasValue(23)) {
            setCounterTextColor(gVar.O(23));
        }
        if (obtainStyledAttributes.hasValue(21)) {
            setCounterOverflowTextColor(gVar.O(21));
        }
        if (obtainStyledAttributes.hasValue(58)) {
            setPlaceholderTextColor(gVar.O(58));
        }
        l lVar = new l(this, gVar);
        this.f2142k = lVar;
        boolean z11 = obtainStyledAttributes.getBoolean(0, true);
        gVar.i0();
        c0.s(this, 2);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26 && i10 >= 26) {
            k0.m(this, 1);
        }
        frameLayout.addView(tVar);
        frameLayout.addView(lVar);
        addView(frameLayout);
        setEnabled(z11);
        setHelperTextEnabled(z9);
        setErrorEnabled(z8);
        setCounterEnabled(z10);
        setHelperText(text2);
    }

    private Drawable getEditTextBoxBackground() {
        EditText editText = this.f2144l;
        if (!(editText instanceof AutoCompleteTextView) || editText.getInputType() != 0) {
            return this.N;
        }
        int v8 = com.bumptech.glide.c.v(this.f2144l, 2130968808);
        int i9 = this.W;
        int[][] iArr = I0;
        if (i9 != 2) {
            if (i9 != 1) {
                return null;
            }
            g gVar = this.N;
            int i10 = this.f2136f0;
            return new RippleDrawable(new ColorStateList(iArr, new int[]{com.bumptech.glide.c.H(0.1f, v8, i10), i10}), gVar, gVar);
        }
        Context context = getContext();
        g gVar2 = this.N;
        TypedValue S = com.bumptech.glide.c.S(context, 2130968848, "TextInputLayout");
        int i11 = S.resourceId;
        int t8 = i11 != 0 ? a.a.t(context, i11) : S.data;
        g gVar3 = new g(gVar2.f9084i.f9069a);
        int H = com.bumptech.glide.c.H(0.1f, v8, t8);
        gVar3.l(new ColorStateList(iArr, new int[]{H, 0}));
        gVar3.setTint(t8);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{H, t8});
        g gVar4 = new g(gVar2.f9084i.f9069a);
        gVar4.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, gVar3, gVar4), gVar2});
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.P == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.P = stateListDrawable;
            stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, getOrCreateOutlinedDropDownMenuBackground());
            this.P.addState(new int[0], f(false));
        }
        return this.P;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.O == null) {
            this.O = f(true);
        }
        return this.O;
    }

    public static void k(ViewGroup viewGroup, boolean z8) {
        int childCount = viewGroup.getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = viewGroup.getChildAt(i9);
            childAt.setEnabled(z8);
            if (childAt instanceof ViewGroup) {
                k((ViewGroup) childAt, z8);
            }
        }
    }

    private void setEditText(EditText editText) {
        if (this.f2144l != null) {
            m7.c.n("We already have an EditText, can only have one");
            return;
        }
        if (getEndIconMode() != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.f2144l = editText;
        int i9 = this.f2148n;
        if (i9 != -1) {
            setMinEms(i9);
        } else {
            setMinWidth(this.f2152p);
        }
        int i10 = this.f2150o;
        if (i10 != -1) {
            setMaxEms(i10);
        } else {
            setMaxWidth(this.f2154q);
        }
        this.Q = false;
        i();
        setTextInputAccessibilityDelegate(new v(this));
        Typeface typeface = this.f2144l.getTypeface();
        c cVar = this.C0;
        cVar.m(typeface);
        float textSize = this.f2144l.getTextSize();
        if (cVar.h != textSize) {
            cVar.h = textSize;
            cVar.h(false);
        }
        float letterSpacing = this.f2144l.getLetterSpacing();
        if (cVar.W != letterSpacing) {
            cVar.W = letterSpacing;
            cVar.h(false);
        }
        int gravity = this.f2144l.getGravity();
        int i11 = (gravity & (-113)) | 48;
        if (cVar.f7950g != i11) {
            cVar.f7950g = i11;
            cVar.h(false);
        }
        if (cVar.f7948f != gravity) {
            cVar.f7948f = gravity;
            cVar.h(false);
        }
        this.f2144l.addTextChangedListener(new x2(this, 1));
        if (this.f2155q0 == null) {
            this.f2155q0 = this.f2144l.getHintTextColors();
        }
        if (this.K) {
            if (TextUtils.isEmpty(this.L)) {
                CharSequence hint = this.f2144l.getHint();
                this.f2146m = hint;
                setHint(hint);
                this.f2144l.setHint((CharSequence) null);
            }
            this.M = true;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            p();
        }
        if (this.f2166w != null) {
            n(this.f2144l.getText());
        }
        r();
        this.f2156r.b();
        this.f2140j.bringToFront();
        l lVar = this.f2142k;
        lVar.bringToFront();
        Iterator it = this.f2147m0.iterator();
        while (it.hasNext()) {
            ((x5.k) it.next()).a(this);
        }
        lVar.m();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        u(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.L)) {
            return;
        }
        this.L = charSequence;
        c cVar = this.C0;
        if (charSequence == null || !TextUtils.equals(cVar.A, charSequence)) {
            cVar.A = charSequence;
            cVar.B = null;
            Bitmap bitmap = cVar.E;
            if (bitmap != null) {
                bitmap.recycle();
                cVar.E = null;
            }
            cVar.h(false);
        }
        if (this.B0) {
            return;
        }
        j();
    }

    private void setPlaceholderTextEnabled(boolean z8) {
        if (this.A == z8) {
            return;
        }
        e1 e1Var = this.B;
        if (!z8) {
            if (e1Var != null) {
                e1Var.setVisibility(8);
            }
            this.B = null;
        } else if (e1Var != null) {
            this.f2139i.addView(e1Var);
            this.B.setVisibility(0);
        }
        this.A = z8;
    }

    public final void a(float f9) {
        c cVar = this.C0;
        if (cVar.f7940b == f9) {
            return;
        }
        int i9 = 2;
        if (this.F0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.F0 = valueAnimator;
            valueAnimator.setInterpolator(android.support.v4.media.session.b.o0(getContext(), 2130969363, z4.a.f10660b));
            this.F0.setDuration(android.support.v4.media.session.b.n0(getContext(), 2130969353, 167));
            this.F0.addUpdateListener(new d5.b(this, i9));
        }
        this.F0.setFloatValues(cVar.f7940b, f9);
        this.F0.start();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i9, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i9, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        FrameLayout frameLayout = this.f2139i;
        frameLayout.addView(view, layoutParams2);
        frameLayout.setLayoutParams(layoutParams);
        t();
        setEditText((EditText) view);
    }

    public final void b() {
        int i9;
        int i10;
        g gVar = this.N;
        if (gVar == null) {
            return;
        }
        j jVar = gVar.f9084i.f9069a;
        j jVar2 = this.T;
        if (jVar != jVar2) {
            gVar.setShapeAppearanceModel(jVar2);
        }
        if (this.W == 2 && (i9 = this.f2132b0) > -1 && (i10 = this.f2135e0) != 0) {
            g gVar2 = this.N;
            gVar2.f9084i.f9077j = i9;
            gVar2.invalidateSelf();
            ColorStateList valueOf = ColorStateList.valueOf(i10);
            f fVar = gVar2.f9084i;
            if (fVar.f9072d != valueOf) {
                fVar.f9072d = valueOf;
                gVar2.onStateChange(gVar2.getState());
            }
        }
        int i11 = this.f2136f0;
        if (this.W == 1) {
            i11 = f0.a.b(this.f2136f0, com.bumptech.glide.c.u(getContext(), 2130968848, 0));
        }
        this.f2136f0 = i11;
        this.N.l(ColorStateList.valueOf(i11));
        g gVar3 = this.R;
        if (gVar3 != null && this.S != null) {
            if (this.f2132b0 > -1 && this.f2135e0 != 0) {
                gVar3.l(this.f2144l.isFocused() ? ColorStateList.valueOf(this.f2159s0) : ColorStateList.valueOf(this.f2135e0));
                this.S.l(ColorStateList.valueOf(this.f2135e0));
            }
            invalidate();
        }
        s();
    }

    public final int c() {
        float d9;
        if (!this.K) {
            return 0;
        }
        int i9 = this.W;
        c cVar = this.C0;
        if (i9 == 0) {
            d9 = cVar.d();
        } else {
            if (i9 != 2) {
                return 0;
            }
            d9 = cVar.d() / 2.0f;
        }
        return (int) d9;
    }

    public final h d() {
        h hVar = new h();
        hVar.f9524k = android.support.v4.media.session.b.n0(getContext(), 2130969355, 87);
        hVar.f9525l = android.support.v4.media.session.b.o0(getContext(), 2130969365, z4.a.f10659a);
        return hVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i9) {
        EditText editText = this.f2144l;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i9);
            return;
        }
        if (this.f2146m != null) {
            boolean z8 = this.M;
            this.M = false;
            CharSequence hint = editText.getHint();
            this.f2144l.setHint(this.f2146m);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i9);
                return;
            } finally {
                this.f2144l.setHint(hint);
                this.M = z8;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i9);
        onProvideAutofillVirtualStructure(viewStructure, i9);
        FrameLayout frameLayout = this.f2139i;
        viewStructure.setChildCount(frameLayout.getChildCount());
        for (int i10 = 0; i10 < frameLayout.getChildCount(); i10++) {
            View childAt = frameLayout.getChildAt(i10);
            ViewStructure newChild = viewStructure.newChild(i10);
            childAt.dispatchProvideAutofillStructure(newChild, i9);
            if (childAt == this.f2144l) {
                newChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.H0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.H0 = false;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        g gVar;
        Canvas canvas2 = canvas;
        super.draw(canvas);
        boolean z8 = this.K;
        c cVar = this.C0;
        if (z8) {
            TextPaint textPaint = cVar.N;
            RectF rectF = cVar.f7946e;
            int save = canvas2.save();
            if (cVar.B != null && rectF.width() > 0.0f && rectF.height() > 0.0f) {
                textPaint.setTextSize(cVar.G);
                float f9 = cVar.f7958p;
                float f10 = cVar.f7959q;
                float f11 = cVar.F;
                if (f11 != 1.0f) {
                    canvas2.scale(f11, f11, f9, f10);
                }
                if (cVar.f7945d0 <= 1 || cVar.C) {
                    canvas2.translate(f9, f10);
                    cVar.Y.draw(canvas2);
                } else {
                    float lineStart = cVar.f7958p - cVar.Y.getLineStart(0);
                    int alpha = textPaint.getAlpha();
                    canvas2.translate(lineStart, f10);
                    float f12 = alpha;
                    textPaint.setAlpha((int) (cVar.f7941b0 * f12));
                    int i9 = Build.VERSION.SDK_INT;
                    if (i9 >= 31) {
                        float f13 = cVar.H;
                        float f14 = cVar.I;
                        float f15 = cVar.J;
                        int i10 = cVar.K;
                        textPaint.setShadowLayer(f13, f14, f15, f0.a.d(i10, (textPaint.getAlpha() * Color.alpha(i10)) / 255));
                    }
                    cVar.Y.draw(canvas2);
                    textPaint.setAlpha((int) (cVar.f7939a0 * f12));
                    if (i9 >= 31) {
                        float f16 = cVar.H;
                        float f17 = cVar.I;
                        float f18 = cVar.J;
                        int i11 = cVar.K;
                        textPaint.setShadowLayer(f16, f17, f18, f0.a.d(i11, (Color.alpha(i11) * textPaint.getAlpha()) / 255));
                    }
                    int lineBaseline = cVar.Y.getLineBaseline(0);
                    CharSequence charSequence = cVar.f7943c0;
                    float f19 = lineBaseline;
                    canvas2.drawText(charSequence, 0, charSequence.length(), 0.0f, f19, textPaint);
                    if (i9 >= 31) {
                        textPaint.setShadowLayer(cVar.H, cVar.I, cVar.J, cVar.K);
                    }
                    String trim = cVar.f7943c0.toString().trim();
                    if (trim.endsWith("…")) {
                        trim = trim.substring(0, trim.length() - 1);
                    }
                    String str = trim;
                    textPaint.setAlpha(alpha);
                    canvas2 = canvas;
                    canvas2.drawText(str, 0, Math.min(cVar.Y.getLineEnd(0), str.length()), 0.0f, f19, (Paint) textPaint);
                }
                canvas2.restoreToCount(save);
            }
        }
        if (this.S == null || (gVar = this.R) == null) {
            return;
        }
        gVar.draw(canvas2);
        if (this.f2144l.isFocused()) {
            Rect bounds = this.S.getBounds();
            Rect bounds2 = this.R.getBounds();
            float f20 = cVar.f7940b;
            int centerX = bounds2.centerX();
            bounds.left = z4.a.c(f20, centerX, bounds2.left);
            bounds.right = z4.a.c(f20, centerX, bounds2.right);
            this.S.draw(canvas2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004f  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void drawableStateChanged() {
        /*
            r4 = this;
            boolean r0 = r4.G0
            if (r0 == 0) goto L5
            return
        L5:
            r0 = 1
            r4.G0 = r0
            super.drawableStateChanged()
            int[] r1 = r4.getDrawableState()
            r2 = 0
            o5.c r3 = r4.C0
            if (r3 == 0) goto L2f
            r3.L = r1
            android.content.res.ColorStateList r1 = r3.f7953k
            if (r1 == 0) goto L20
            boolean r1 = r1.isStateful()
            if (r1 != 0) goto L2a
        L20:
            android.content.res.ColorStateList r1 = r3.f7952j
            if (r1 == 0) goto L2f
            boolean r1 = r1.isStateful()
            if (r1 == 0) goto L2f
        L2a:
            r3.h(r2)
            r1 = 1
            goto L30
        L2f:
            r1 = 0
        L30:
            android.widget.EditText r3 = r4.f2144l
            if (r3 == 0) goto L47
            java.util.WeakHashMap r3 = n0.t0.f7209a
            boolean r3 = n0.f0.c(r4)
            if (r3 == 0) goto L43
            boolean r3 = r4.isEnabled()
            if (r3 == 0) goto L43
            goto L44
        L43:
            r0 = 0
        L44:
            r4.u(r0, r2)
        L47:
            r4.r()
            r4.x()
            if (r1 == 0) goto L52
            r4.invalidate()
        L52:
            r4.G0 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.drawableStateChanged():void");
    }

    public final boolean e() {
        return this.K && !TextUtils.isEmpty(this.L) && (this.N instanceof x5.f);
    }

    public final g f(boolean z8) {
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(2131165952);
        float f9 = z8 ? dimensionPixelOffset : 0.0f;
        EditText editText = this.f2144l;
        float popupElevation = editText instanceof r ? ((r) editText).getPopupElevation() : getResources().getDimensionPixelOffset(2131165554);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(2131165889);
        i iVar = new i();
        i iVar2 = new i();
        i iVar3 = new i();
        i iVar4 = new i();
        int i9 = 0;
        e eVar = new e(i9);
        e eVar2 = new e(i9);
        e eVar3 = new e(i9);
        e eVar4 = new e(i9);
        u5.a aVar = new u5.a(f9);
        u5.a aVar2 = new u5.a(f9);
        u5.a aVar3 = new u5.a(dimensionPixelOffset);
        u5.a aVar4 = new u5.a(dimensionPixelOffset);
        j jVar = new j();
        jVar.f9103a = iVar;
        jVar.f9104b = iVar2;
        jVar.f9105c = iVar3;
        jVar.f9106d = iVar4;
        jVar.f9107e = aVar;
        jVar.f9108f = aVar2;
        jVar.f9109g = aVar4;
        jVar.h = aVar3;
        jVar.f9110i = eVar;
        jVar.f9111j = eVar2;
        jVar.f9112k = eVar3;
        jVar.f9113l = eVar4;
        EditText editText2 = this.f2144l;
        ColorStateList dropDownBackgroundTintList = editText2 instanceof r ? ((r) editText2).getDropDownBackgroundTintList() : null;
        Context context = getContext();
        if (dropDownBackgroundTintList == null) {
            Paint paint = g.E;
            TypedValue S = com.bumptech.glide.c.S(context, 2130968848, g.class.getSimpleName());
            int i10 = S.resourceId;
            dropDownBackgroundTintList = ColorStateList.valueOf(i10 != 0 ? a.a.t(context, i10) : S.data);
        }
        g gVar = new g();
        gVar.i(context);
        gVar.l(dropDownBackgroundTintList);
        gVar.k(popupElevation);
        gVar.setShapeAppearanceModel(jVar);
        f fVar = gVar.f9084i;
        if (fVar.f9075g == null) {
            fVar.f9075g = new Rect();
        }
        gVar.f9084i.f9075g.set(0, dimensionPixelOffset2, 0, dimensionPixelOffset2);
        gVar.invalidateSelf();
        return gVar;
    }

    public final int g(int i9, boolean z8) {
        return ((z8 || getPrefixText() == null) ? (!z8 || getSuffixText() == null) ? this.f2144l.getCompoundPaddingLeft() : this.f2142k.c() : this.f2140j.a()) + i9;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f2144l;
        if (editText == null) {
            return super.getBaseline();
        }
        return c() + getPaddingTop() + editText.getBaseline();
    }

    public g getBoxBackground() {
        int i9 = this.W;
        if (i9 == 1 || i9 == 2) {
            return this.N;
        }
        androidx.fragment.app.a.l();
        return null;
    }

    public int getBoxBackgroundColor() {
        return this.f2136f0;
    }

    public int getBoxBackgroundMode() {
        return this.W;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.f2131a0;
    }

    public float getBoxCornerRadiusBottomEnd() {
        boolean e9 = o.e(this);
        j jVar = this.T;
        RectF rectF = this.i0;
        return e9 ? jVar.h.a(rectF) : jVar.f9109g.a(rectF);
    }

    public float getBoxCornerRadiusBottomStart() {
        boolean e9 = o.e(this);
        j jVar = this.T;
        RectF rectF = this.i0;
        return e9 ? jVar.f9109g.a(rectF) : jVar.h.a(rectF);
    }

    public float getBoxCornerRadiusTopEnd() {
        boolean e9 = o.e(this);
        j jVar = this.T;
        RectF rectF = this.i0;
        return e9 ? jVar.f9107e.a(rectF) : jVar.f9108f.a(rectF);
    }

    public float getBoxCornerRadiusTopStart() {
        boolean e9 = o.e(this);
        j jVar = this.T;
        RectF rectF = this.i0;
        return e9 ? jVar.f9108f.a(rectF) : jVar.f9107e.a(rectF);
    }

    public int getBoxStrokeColor() {
        return this.f2163u0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.f2165v0;
    }

    public int getBoxStrokeWidth() {
        return this.f2133c0;
    }

    public int getBoxStrokeWidthFocused() {
        return this.f2134d0;
    }

    public int getCounterMaxLength() {
        return this.f2160t;
    }

    public CharSequence getCounterOverflowDescription() {
        e1 e1Var;
        if (this.f2158s && this.f2162u && (e1Var = this.f2166w) != null) {
            return e1Var.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.H;
    }

    public ColorStateList getCounterTextColor() {
        return this.G;
    }

    public ColorStateList getCursorColor() {
        return this.I;
    }

    public ColorStateList getCursorErrorColor() {
        return this.J;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.f2155q0;
    }

    public EditText getEditText() {
        return this.f2144l;
    }

    public CharSequence getEndIconContentDescription() {
        return this.f2142k.f10141o.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.f2142k.f10141o.getDrawable();
    }

    public int getEndIconMinSize() {
        return this.f2142k.f10147u;
    }

    public int getEndIconMode() {
        return this.f2142k.f10143q;
    }

    public ImageView.ScaleType getEndIconScaleType() {
        return this.f2142k.f10148v;
    }

    public CheckableImageButton getEndIconView() {
        return this.f2142k.f10141o;
    }

    public CharSequence getError() {
        p pVar = this.f2156r;
        if (pVar.f10178q) {
            return pVar.f10177p;
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.f2156r.f10181t;
    }

    public CharSequence getErrorContentDescription() {
        return this.f2156r.f10180s;
    }

    public int getErrorCurrentTextColors() {
        e1 e1Var = this.f2156r.f10179r;
        if (e1Var != null) {
            return e1Var.getCurrentTextColor();
        }
        return -1;
    }

    public Drawable getErrorIconDrawable() {
        return this.f2142k.f10137k.getDrawable();
    }

    public CharSequence getHelperText() {
        p pVar = this.f2156r;
        if (pVar.f10185x) {
            return pVar.f10184w;
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        e1 e1Var = this.f2156r.f10186y;
        if (e1Var != null) {
            return e1Var.getCurrentTextColor();
        }
        return -1;
    }

    public CharSequence getHint() {
        if (this.K) {
            return this.L;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.C0.d();
    }

    public final int getHintCurrentCollapsedTextColor() {
        c cVar = this.C0;
        return cVar.e(cVar.f7953k);
    }

    public ColorStateList getHintTextColor() {
        return this.f2157r0;
    }

    public w getLengthCounter() {
        return this.f2164v;
    }

    public int getMaxEms() {
        return this.f2150o;
    }

    public int getMaxWidth() {
        return this.f2154q;
    }

    public int getMinEms() {
        return this.f2148n;
    }

    public int getMinWidth() {
        return this.f2152p;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f2142k.f10141o.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f2142k.f10141o.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.A) {
            return this.f2172z;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.D;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.C;
    }

    public CharSequence getPrefixText() {
        return this.f2140j.f10204k;
    }

    public ColorStateList getPrefixTextColor() {
        return this.f2140j.f10203j.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.f2140j.f10203j;
    }

    public j getShapeAppearanceModel() {
        return this.T;
    }

    public CharSequence getStartIconContentDescription() {
        return this.f2140j.f10205l.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.f2140j.f10205l.getDrawable();
    }

    public int getStartIconMinSize() {
        return this.f2140j.f10208o;
    }

    public ImageView.ScaleType getStartIconScaleType() {
        return this.f2140j.f10209p;
    }

    public CharSequence getSuffixText() {
        return this.f2142k.f10150x;
    }

    public ColorStateList getSuffixTextColor() {
        return this.f2142k.f10151y.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.f2142k.f10151y;
    }

    public Typeface getTypeface() {
        return this.f2141j0;
    }

    public final int h(int i9, boolean z8) {
        return i9 - ((z8 || getSuffixText() == null) ? (!z8 || getPrefixText() == null) ? this.f2144l.getCompoundPaddingRight() : this.f2140j.a() : this.f2142k.c());
    }

    public final void i() {
        int i9 = this.W;
        if (i9 == 0) {
            this.N = null;
            this.R = null;
            this.S = null;
        } else if (i9 == 1) {
            this.N = new g(this.T);
            this.R = new g();
            this.S = new g();
        } else {
            if (i9 != 2) {
                throw new IllegalArgumentException(this.W + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
            if (!this.K || (this.N instanceof x5.f)) {
                this.N = new g(this.T);
            } else {
                j jVar = this.T;
                int i10 = x5.f.G;
                if (jVar == null) {
                    jVar = new j();
                }
                x5.e eVar = new x5.e(jVar, new RectF());
                x5.f fVar = new x5.f(eVar);
                fVar.F = eVar;
                this.N = fVar;
            }
            this.R = null;
            this.S = null;
        }
        s();
        x();
        if (this.W == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                this.f2131a0 = getResources().getDimensionPixelSize(2131165783);
            } else if (d.L(getContext())) {
                this.f2131a0 = getResources().getDimensionPixelSize(2131165782);
            }
        }
        if (this.f2144l != null && this.W == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                EditText editText = this.f2144l;
                WeakHashMap weakHashMap = t0.f7209a;
                d0.k(editText, d0.f(editText), getResources().getDimensionPixelSize(2131165781), d0.e(this.f2144l), getResources().getDimensionPixelSize(2131165780));
            } else if (d.L(getContext())) {
                EditText editText2 = this.f2144l;
                WeakHashMap weakHashMap2 = t0.f7209a;
                d0.k(editText2, d0.f(editText2), getResources().getDimensionPixelSize(2131165779), d0.e(this.f2144l), getResources().getDimensionPixelSize(2131165778));
            }
        }
        if (this.W != 0) {
            t();
        }
        EditText editText3 = this.f2144l;
        if (editText3 instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText3;
            if (autoCompleteTextView.getDropDownBackground() == null) {
                int i11 = this.W;
                if (i11 == 2) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
                } else if (i11 == 1) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
                }
            }
        }
    }

    public final void j() {
        float f9;
        float f10;
        float f11;
        RectF rectF;
        float f12;
        int i9;
        float f13;
        int i10;
        if (e()) {
            int width = this.f2144l.getWidth();
            int gravity = this.f2144l.getGravity();
            c cVar = this.C0;
            boolean b9 = cVar.b(cVar.A);
            cVar.C = b9;
            Rect rect = cVar.f7944d;
            if (gravity != 17 && (gravity & 7) != 1) {
                if ((gravity & 8388613) == 8388613 || (gravity & 5) == 5) {
                    if (b9) {
                        i10 = rect.left;
                        f11 = i10;
                    } else {
                        f9 = rect.right;
                        f10 = cVar.Z;
                    }
                } else if (b9) {
                    f9 = rect.right;
                    f10 = cVar.Z;
                } else {
                    i10 = rect.left;
                    f11 = i10;
                }
                float max = Math.max(f11, rect.left);
                rectF = this.i0;
                rectF.left = max;
                rectF.top = rect.top;
                if (gravity != 17 || (gravity & 7) == 1) {
                    f12 = (width / 2.0f) + (cVar.Z / 2.0f);
                } else if ((gravity & 8388613) == 8388613 || (gravity & 5) == 5) {
                    if (cVar.C) {
                        f13 = cVar.Z;
                        f12 = f13 + max;
                    } else {
                        i9 = rect.right;
                        f12 = i9;
                    }
                } else if (cVar.C) {
                    i9 = rect.right;
                    f12 = i9;
                } else {
                    f13 = cVar.Z;
                    f12 = f13 + max;
                }
                rectF.right = Math.min(f12, rect.right);
                rectF.bottom = cVar.d() + rect.top;
                if (rectF.width() > 0.0f || rectF.height() <= 0.0f) {
                }
                float f14 = rectF.left;
                float f15 = this.V;
                rectF.left = f14 - f15;
                rectF.right += f15;
                rectF.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF.height() / 2.0f)) + this.f2132b0);
                x5.f fVar = (x5.f) this.N;
                fVar.getClass();
                fVar.r(rectF.left, rectF.top, rectF.right, rectF.bottom);
                return;
            }
            f9 = width / 2.0f;
            f10 = cVar.Z / 2.0f;
            f11 = f9 - f10;
            float max2 = Math.max(f11, rect.left);
            rectF = this.i0;
            rectF.left = max2;
            rectF.top = rect.top;
            if (gravity != 17) {
            }
            f12 = (width / 2.0f) + (cVar.Z / 2.0f);
            rectF.right = Math.min(f12, rect.right);
            rectF.bottom = cVar.d() + rect.top;
            if (rectF.width() > 0.0f) {
            }
        }
    }

    public final void l(e1 e1Var, int i9) {
        try {
            android.support.v4.media.session.b.t0(e1Var, i9);
        } catch (Exception unused) {
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (e1Var.getTextColors().getDefaultColor() != -65281) {
                return;
            }
            android.support.v4.media.session.b.t0(e1Var, 2132017592);
            e1Var.setTextColor(a.a.t(getContext(), 2131099728));
        }
    }

    public final boolean m() {
        p pVar = this.f2156r;
        return (pVar.f10176o != 1 || pVar.f10179r == null || TextUtils.isEmpty(pVar.f10177p)) ? false : true;
    }

    public final void n(Editable editable) {
        ((k) this.f2164v).getClass();
        int length = editable != null ? editable.length() : 0;
        boolean z8 = this.f2162u;
        int i9 = this.f2160t;
        if (i9 == -1) {
            this.f2166w.setText(String.valueOf(length));
            this.f2166w.setContentDescription(null);
            this.f2162u = false;
        } else {
            this.f2162u = length > i9;
            Context context = getContext();
            this.f2166w.setContentDescription(context.getString(this.f2162u ? 2131951662 : 2131951661, Integer.valueOf(length), Integer.valueOf(this.f2160t)));
            if (z8 != this.f2162u) {
                o();
            }
            String str = l0.b.f5742b;
            Locale locale = Locale.getDefault();
            int i10 = l0.k.f5757a;
            l0.b bVar = l0.j.a(locale) == 1 ? l0.b.f5745e : l0.b.f5744d;
            e1 e1Var = this.f2166w;
            String string = getContext().getString(2131951663, Integer.valueOf(length), Integer.valueOf(this.f2160t));
            bVar.getClass();
            d1.p pVar = l0.i.f5753a;
            e1Var.setText(string != null ? bVar.c(string).toString() : null);
        }
        if (this.f2144l == null || z8 == this.f2162u) {
            return;
        }
        u(false, false);
        x();
        r();
    }

    public final void o() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        e1 e1Var = this.f2166w;
        if (e1Var != null) {
            l(e1Var, this.f2162u ? this.f2168x : this.f2170y);
            if (!this.f2162u && (colorStateList2 = this.G) != null) {
                this.f2166w.setTextColor(colorStateList2);
            }
            if (!this.f2162u || (colorStateList = this.H) == null) {
                return;
            }
            this.f2166w.setTextColor(colorStateList);
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.C0.g(configuration);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        super.onLayout(z8, i9, i10, i11, i12);
        EditText editText = this.f2144l;
        if (editText != null) {
            ThreadLocal threadLocal = o5.d.f7969a;
            int width = editText.getWidth();
            int height = editText.getHeight();
            Rect rect = this.f2137g0;
            rect.set(0, 0, width, height);
            ThreadLocal threadLocal2 = o5.d.f7969a;
            Matrix matrix = (Matrix) threadLocal2.get();
            if (matrix == null) {
                matrix = new Matrix();
                threadLocal2.set(matrix);
            } else {
                matrix.reset();
            }
            o5.d.a(this, editText, matrix);
            ThreadLocal threadLocal3 = o5.d.f7970b;
            RectF rectF = (RectF) threadLocal3.get();
            if (rectF == null) {
                rectF = new RectF();
                threadLocal3.set(rectF);
            }
            rectF.set(rect);
            matrix.mapRect(rectF);
            rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
            g gVar = this.R;
            if (gVar != null) {
                int i13 = rect.bottom;
                gVar.setBounds(rect.left, i13 - this.f2133c0, rect.right, i13);
            }
            g gVar2 = this.S;
            if (gVar2 != null) {
                int i14 = rect.bottom;
                gVar2.setBounds(rect.left, i14 - this.f2134d0, rect.right, i14);
            }
            if (this.K) {
                float textSize = this.f2144l.getTextSize();
                c cVar = this.C0;
                if (cVar.h != textSize) {
                    cVar.h = textSize;
                    cVar.h(false);
                }
                int gravity = this.f2144l.getGravity();
                int i15 = (gravity & (-113)) | 48;
                if (cVar.f7950g != i15) {
                    cVar.f7950g = i15;
                    cVar.h(false);
                }
                if (cVar.f7948f != gravity) {
                    cVar.f7948f = gravity;
                    cVar.h(false);
                }
                if (this.f2144l == null) {
                    androidx.fragment.app.a.l();
                    return;
                }
                boolean e9 = o.e(this);
                int i16 = rect.bottom;
                Rect rect2 = this.f2138h0;
                rect2.bottom = i16;
                int i17 = this.W;
                int i18 = rect.left;
                if (i17 == 1) {
                    rect2.left = g(i18, e9);
                    rect2.top = rect.top + this.f2131a0;
                    rect2.right = h(rect.right, e9);
                } else if (i17 != 2) {
                    rect2.left = g(i18, e9);
                    rect2.top = getPaddingTop();
                    rect2.right = h(rect.right, e9);
                } else {
                    rect2.left = this.f2144l.getPaddingLeft() + i18;
                    rect2.top = rect.top - c();
                    rect2.right = rect.right - this.f2144l.getPaddingRight();
                }
                int i19 = rect2.left;
                int i20 = rect2.top;
                int i21 = rect2.right;
                int i22 = rect2.bottom;
                Rect rect3 = cVar.f7944d;
                if (rect3.left != i19 || rect3.top != i20 || rect3.right != i21 || rect3.bottom != i22) {
                    rect3.set(i19, i20, i21, i22);
                    cVar.M = true;
                }
                if (this.f2144l == null) {
                    androidx.fragment.app.a.l();
                    return;
                }
                TextPaint textPaint = cVar.O;
                textPaint.setTextSize(cVar.h);
                textPaint.setTypeface(cVar.f7963u);
                textPaint.setLetterSpacing(cVar.W);
                float f9 = -textPaint.ascent();
                rect2.left = this.f2144l.getCompoundPaddingLeft() + rect.left;
                rect2.top = (this.W != 1 || this.f2144l.getMinLines() > 1) ? rect.top + this.f2144l.getCompoundPaddingTop() : (int) (rect.centerY() - (f9 / 2.0f));
                rect2.right = rect.right - this.f2144l.getCompoundPaddingRight();
                int compoundPaddingBottom = (this.W != 1 || this.f2144l.getMinLines() > 1) ? rect.bottom - this.f2144l.getCompoundPaddingBottom() : (int) (rect2.top + f9);
                rect2.bottom = compoundPaddingBottom;
                int i23 = rect2.left;
                int i24 = rect2.top;
                int i25 = rect2.right;
                Rect rect4 = cVar.f7942c;
                if (rect4.left != i23 || rect4.top != i24 || rect4.right != i25 || rect4.bottom != compoundPaddingBottom) {
                    rect4.set(i23, i24, i25, compoundPaddingBottom);
                    cVar.M = true;
                }
                cVar.h(false);
                if (!e() || this.B0) {
                    return;
                }
                j();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i9, int i10) {
        EditText editText;
        int max;
        super.onMeasure(i9, i10);
        EditText editText2 = this.f2144l;
        l lVar = this.f2142k;
        boolean z8 = false;
        if (editText2 != null && this.f2144l.getMeasuredHeight() < (max = Math.max(lVar.getMeasuredHeight(), this.f2140j.getMeasuredHeight()))) {
            this.f2144l.setMinimumHeight(max);
            z8 = true;
        }
        boolean q4 = q();
        if (z8 || q4) {
            this.f2144l.post(new u(this, 1));
        }
        if (this.B != null && (editText = this.f2144l) != null) {
            this.B.setGravity(editText.getGravity());
            this.B.setPadding(this.f2144l.getCompoundPaddingLeft(), this.f2144l.getCompoundPaddingTop(), this.f2144l.getCompoundPaddingRight(), this.f2144l.getCompoundPaddingBottom());
        }
        lVar.m();
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof x)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        x xVar = (x) parcelable;
        super.onRestoreInstanceState(xVar.f8991i);
        setError(xVar.f10215k);
        if (xVar.f10216l) {
            post(new u(this, 0));
        }
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onRtlPropertiesChanged(int i9) {
        super.onRtlPropertiesChanged(i9);
        boolean z8 = i9 == 1;
        if (z8 != this.U) {
            u5.c cVar = this.T.f9107e;
            RectF rectF = this.i0;
            float a9 = cVar.a(rectF);
            float a10 = this.T.f9108f.a(rectF);
            float a11 = this.T.h.a(rectF);
            float a12 = this.T.f9109g.a(rectF);
            j jVar = this.T;
            com.bumptech.glide.c cVar2 = jVar.f9103a;
            com.bumptech.glide.c cVar3 = jVar.f9104b;
            com.bumptech.glide.c cVar4 = jVar.f9106d;
            com.bumptech.glide.c cVar5 = jVar.f9105c;
            e eVar = new e(0);
            e eVar2 = new e(0);
            e eVar3 = new e(0);
            e eVar4 = new e(0);
            u5.a aVar = new u5.a(a10);
            u5.a aVar2 = new u5.a(a9);
            u5.a aVar3 = new u5.a(a12);
            u5.a aVar4 = new u5.a(a11);
            j jVar2 = new j();
            jVar2.f9103a = cVar3;
            jVar2.f9104b = cVar2;
            jVar2.f9105c = cVar4;
            jVar2.f9106d = cVar5;
            jVar2.f9107e = aVar;
            jVar2.f9108f = aVar2;
            jVar2.f9109g = aVar4;
            jVar2.h = aVar3;
            jVar2.f9110i = eVar;
            jVar2.f9111j = eVar2;
            jVar2.f9112k = eVar3;
            jVar2.f9113l = eVar4;
            this.U = z8;
            setShapeAppearanceModel(jVar2);
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        x xVar = new x(super.onSaveInstanceState());
        if (m()) {
            xVar.f10215k = getError();
        }
        l lVar = this.f2142k;
        xVar.f10216l = lVar.f10143q != 0 && lVar.f10141o.f2100l;
        return xVar;
    }

    public final void p() {
        Drawable textCursorDrawable;
        Drawable textCursorDrawable2;
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.I;
        if (colorStateList2 == null) {
            Context context = getContext();
            TypedValue Q = com.bumptech.glide.c.Q(context, 2130968807);
            if (Q != null) {
                int i9 = Q.resourceId;
                if (i9 != 0) {
                    colorStateList2 = a.a.u(context, i9);
                } else {
                    int i10 = Q.data;
                    if (i10 != 0) {
                        colorStateList2 = ColorStateList.valueOf(i10);
                    }
                }
            }
            colorStateList2 = null;
        }
        EditText editText = this.f2144l;
        if (editText != null) {
            textCursorDrawable = editText.getTextCursorDrawable();
            if (textCursorDrawable == null) {
                return;
            }
            textCursorDrawable2 = this.f2144l.getTextCursorDrawable();
            if ((m() || (this.f2166w != null && this.f2162u)) && (colorStateList = this.J) != null) {
                colorStateList2 = colorStateList;
            }
            g0.b.h(textCursorDrawable2, colorStateList2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q() {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.q():boolean");
    }

    public final void r() {
        Drawable background;
        e1 e1Var;
        EditText editText = this.f2144l;
        if (editText == null || this.W != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        int[] iArr = r1.f7021a;
        Drawable mutate = background.mutate();
        if (m()) {
            mutate.setColorFilter(n.t.c(getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
        } else if (this.f2162u && (e1Var = this.f2166w) != null) {
            mutate.setColorFilter(n.t.c(e1Var.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            d.h(mutate);
            this.f2144l.refreshDrawableState();
        }
    }

    public final void s() {
        EditText editText = this.f2144l;
        if (editText == null || this.N == null) {
            return;
        }
        if ((this.Q || editText.getBackground() == null) && this.W != 0) {
            EditText editText2 = this.f2144l;
            Drawable editTextBoxBackground = getEditTextBoxBackground();
            WeakHashMap weakHashMap = t0.f7209a;
            c0.q(editText2, editTextBoxBackground);
            this.Q = true;
        }
    }

    public void setBoxBackgroundColor(int i9) {
        if (this.f2136f0 != i9) {
            this.f2136f0 = i9;
            this.f2167w0 = i9;
            this.f2171y0 = i9;
            this.f2173z0 = i9;
            b();
        }
    }

    public void setBoxBackgroundColorResource(int i9) {
        setBoxBackgroundColor(a.a.t(getContext(), i9));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.f2167w0 = defaultColor;
        this.f2136f0 = defaultColor;
        this.f2169x0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f2171y0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.f2173z0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        b();
    }

    public void setBoxBackgroundMode(int i9) {
        if (i9 == this.W) {
            return;
        }
        this.W = i9;
        if (this.f2144l != null) {
            i();
        }
    }

    public void setBoxCollapsedPaddingTop(int i9) {
        this.f2131a0 = i9;
    }

    public void setBoxCornerFamily(int i9) {
        b e9 = this.T.e();
        u5.c cVar = this.T.f9107e;
        e9.f1650d = d.l(i9);
        e9.f1652f = cVar;
        u5.c cVar2 = this.T.f9108f;
        e9.f1651e = d.l(i9);
        e9.f1653g = cVar2;
        u5.c cVar3 = this.T.h;
        e9.f1648b = d.l(i9);
        e9.f1654i = cVar3;
        u5.c cVar4 = this.T.f9109g;
        e9.f1647a = d.l(i9);
        e9.h = cVar4;
        this.T = e9.a();
        b();
    }

    public void setBoxStrokeColor(int i9) {
        if (this.f2163u0 != i9) {
            this.f2163u0 = i9;
            x();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.f2159s0 = colorStateList.getDefaultColor();
            this.A0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.f2161t0 = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            this.f2163u0 = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        } else if (this.f2163u0 != colorStateList.getDefaultColor()) {
            this.f2163u0 = colorStateList.getDefaultColor();
        }
        x();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.f2165v0 != colorStateList) {
            this.f2165v0 = colorStateList;
            x();
        }
    }

    public void setBoxStrokeWidth(int i9) {
        this.f2133c0 = i9;
        x();
    }

    public void setBoxStrokeWidthFocused(int i9) {
        this.f2134d0 = i9;
        x();
    }

    public void setBoxStrokeWidthFocusedResource(int i9) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i9));
    }

    public void setBoxStrokeWidthResource(int i9) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i9));
    }

    public void setCounterEnabled(boolean z8) {
        if (this.f2158s != z8) {
            p pVar = this.f2156r;
            if (z8) {
                e1 e1Var = new e1(getContext(), null);
                this.f2166w = e1Var;
                e1Var.setId(2131362469);
                Typeface typeface = this.f2141j0;
                if (typeface != null) {
                    this.f2166w.setTypeface(typeface);
                }
                this.f2166w.setMaxLines(1);
                pVar.a(this.f2166w, 2);
                n0.l.h((ViewGroup.MarginLayoutParams) this.f2166w.getLayoutParams(), getResources().getDimensionPixelOffset(2131165980));
                o();
                if (this.f2166w != null) {
                    EditText editText = this.f2144l;
                    n(editText != null ? editText.getText() : null);
                }
            } else {
                pVar.g(this.f2166w, 2);
                this.f2166w = null;
            }
            this.f2158s = z8;
        }
    }

    public void setCounterMaxLength(int i9) {
        if (this.f2160t != i9) {
            if (i9 > 0) {
                this.f2160t = i9;
            } else {
                this.f2160t = -1;
            }
            if (!this.f2158s || this.f2166w == null) {
                return;
            }
            EditText editText = this.f2144l;
            n(editText == null ? null : editText.getText());
        }
    }

    public void setCounterOverflowTextAppearance(int i9) {
        if (this.f2168x != i9) {
            this.f2168x = i9;
            o();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.H != colorStateList) {
            this.H = colorStateList;
            o();
        }
    }

    public void setCounterTextAppearance(int i9) {
        if (this.f2170y != i9) {
            this.f2170y = i9;
            o();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.G != colorStateList) {
            this.G = colorStateList;
            o();
        }
    }

    public void setCursorColor(ColorStateList colorStateList) {
        if (this.I != colorStateList) {
            this.I = colorStateList;
            p();
        }
    }

    public void setCursorErrorColor(ColorStateList colorStateList) {
        if (this.J != colorStateList) {
            this.J = colorStateList;
            if (m() || (this.f2166w != null && this.f2162u)) {
                p();
            }
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.f2155q0 = colorStateList;
        this.f2157r0 = colorStateList;
        if (this.f2144l != null) {
            u(false, false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z8) {
        k(this, z8);
        super.setEnabled(z8);
    }

    public void setEndIconActivated(boolean z8) {
        this.f2142k.f10141o.setActivated(z8);
    }

    public void setEndIconCheckable(boolean z8) {
        this.f2142k.f10141o.setCheckable(z8);
    }

    public void setEndIconContentDescription(int i9) {
        l lVar = this.f2142k;
        CharSequence text = i9 != 0 ? lVar.getResources().getText(i9) : null;
        CheckableImageButton checkableImageButton = lVar.f10141o;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
    }

    public void setEndIconDrawable(int i9) {
        l lVar = this.f2142k;
        Drawable I = i9 != 0 ? android.support.v4.media.session.b.I(lVar.getContext(), i9) : null;
        TextInputLayout textInputLayout = lVar.f10135i;
        CheckableImageButton checkableImageButton = lVar.f10141o;
        checkableImageButton.setImageDrawable(I);
        if (I != null) {
            d.c(textInputLayout, checkableImageButton, lVar.f10145s, lVar.f10146t);
            d.V(textInputLayout, checkableImageButton, lVar.f10145s);
        }
    }

    public void setEndIconMinSize(int i9) {
        l lVar = this.f2142k;
        if (i9 < 0) {
            lVar.getClass();
            m7.c.n("endIconSize cannot be less than 0");
        } else if (i9 != lVar.f10147u) {
            lVar.f10147u = i9;
            CheckableImageButton checkableImageButton = lVar.f10141o;
            checkableImageButton.setMinimumWidth(i9);
            checkableImageButton.setMinimumHeight(i9);
            CheckableImageButton checkableImageButton2 = lVar.f10137k;
            checkableImageButton2.setMinimumWidth(i9);
            checkableImageButton2.setMinimumHeight(i9);
        }
    }

    public void setEndIconMode(int i9) {
        this.f2142k.g(i9);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        l lVar = this.f2142k;
        CheckableImageButton checkableImageButton = lVar.f10141o;
        View.OnLongClickListener onLongClickListener = lVar.f10149w;
        checkableImageButton.setOnClickListener(onClickListener);
        d.Z(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        l lVar = this.f2142k;
        lVar.f10149w = onLongClickListener;
        CheckableImageButton checkableImageButton = lVar.f10141o;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        d.Z(checkableImageButton, onLongClickListener);
    }

    public void setEndIconScaleType(ImageView.ScaleType scaleType) {
        l lVar = this.f2142k;
        lVar.f10148v = scaleType;
        lVar.f10141o.setScaleType(scaleType);
        lVar.f10137k.setScaleType(scaleType);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        l lVar = this.f2142k;
        if (lVar.f10145s != colorStateList) {
            lVar.f10145s = colorStateList;
            d.c(lVar.f10135i, lVar.f10141o, colorStateList, lVar.f10146t);
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        l lVar = this.f2142k;
        if (lVar.f10146t != mode) {
            lVar.f10146t = mode;
            d.c(lVar.f10135i, lVar.f10141o, lVar.f10145s, mode);
        }
    }

    public void setEndIconVisible(boolean z8) {
        this.f2142k.h(z8);
    }

    public void setError(CharSequence charSequence) {
        p pVar = this.f2156r;
        if (!pVar.f10178q) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            pVar.f();
            return;
        }
        pVar.c();
        pVar.f10177p = charSequence;
        pVar.f10179r.setText(charSequence);
        int i9 = pVar.f10175n;
        if (i9 != 1) {
            pVar.f10176o = 1;
        }
        pVar.i(i9, pVar.f10176o, pVar.h(pVar.f10179r, charSequence));
    }

    public void setErrorAccessibilityLiveRegion(int i9) {
        p pVar = this.f2156r;
        pVar.f10181t = i9;
        e1 e1Var = pVar.f10179r;
        if (e1Var != null) {
            WeakHashMap weakHashMap = t0.f7209a;
            f0.f(e1Var, i9);
        }
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        p pVar = this.f2156r;
        pVar.f10180s = charSequence;
        e1 e1Var = pVar.f10179r;
        if (e1Var != null) {
            e1Var.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z8) {
        p pVar = this.f2156r;
        TextInputLayout textInputLayout = pVar.h;
        if (pVar.f10178q == z8) {
            return;
        }
        pVar.c();
        if (z8) {
            e1 e1Var = new e1(pVar.f10169g, null);
            pVar.f10179r = e1Var;
            e1Var.setId(2131362470);
            pVar.f10179r.setTextAlignment(5);
            Typeface typeface = pVar.B;
            if (typeface != null) {
                pVar.f10179r.setTypeface(typeface);
            }
            int i9 = pVar.f10182u;
            pVar.f10182u = i9;
            e1 e1Var2 = pVar.f10179r;
            if (e1Var2 != null) {
                pVar.h.l(e1Var2, i9);
            }
            ColorStateList colorStateList = pVar.f10183v;
            pVar.f10183v = colorStateList;
            e1 e1Var3 = pVar.f10179r;
            if (e1Var3 != null && colorStateList != null) {
                e1Var3.setTextColor(colorStateList);
            }
            CharSequence charSequence = pVar.f10180s;
            pVar.f10180s = charSequence;
            e1 e1Var4 = pVar.f10179r;
            if (e1Var4 != null) {
                e1Var4.setContentDescription(charSequence);
            }
            int i10 = pVar.f10181t;
            pVar.f10181t = i10;
            e1 e1Var5 = pVar.f10179r;
            if (e1Var5 != null) {
                WeakHashMap weakHashMap = t0.f7209a;
                f0.f(e1Var5, i10);
            }
            pVar.f10179r.setVisibility(4);
            pVar.a(pVar.f10179r, 0);
        } else {
            pVar.f();
            pVar.g(pVar.f10179r, 0);
            pVar.f10179r = null;
            textInputLayout.r();
            textInputLayout.x();
        }
        pVar.f10178q = z8;
    }

    public void setErrorIconDrawable(int i9) {
        l lVar = this.f2142k;
        lVar.i(i9 != 0 ? android.support.v4.media.session.b.I(lVar.getContext(), i9) : null);
        d.V(lVar.f10135i, lVar.f10137k, lVar.f10138l);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        l lVar = this.f2142k;
        CheckableImageButton checkableImageButton = lVar.f10137k;
        View.OnLongClickListener onLongClickListener = lVar.f10140n;
        checkableImageButton.setOnClickListener(onClickListener);
        d.Z(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        l lVar = this.f2142k;
        lVar.f10140n = onLongClickListener;
        CheckableImageButton checkableImageButton = lVar.f10137k;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        d.Z(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        l lVar = this.f2142k;
        if (lVar.f10138l != colorStateList) {
            lVar.f10138l = colorStateList;
            d.c(lVar.f10135i, lVar.f10137k, colorStateList, lVar.f10139m);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        l lVar = this.f2142k;
        if (lVar.f10139m != mode) {
            lVar.f10139m = mode;
            d.c(lVar.f10135i, lVar.f10137k, lVar.f10138l, mode);
        }
    }

    public void setErrorTextAppearance(int i9) {
        p pVar = this.f2156r;
        pVar.f10182u = i9;
        e1 e1Var = pVar.f10179r;
        if (e1Var != null) {
            pVar.h.l(e1Var, i9);
        }
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        p pVar = this.f2156r;
        pVar.f10183v = colorStateList;
        e1 e1Var = pVar.f10179r;
        if (e1Var == null || colorStateList == null) {
            return;
        }
        e1Var.setTextColor(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z8) {
        if (this.D0 != z8) {
            this.D0 = z8;
            u(false, false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        boolean isEmpty = TextUtils.isEmpty(charSequence);
        p pVar = this.f2156r;
        if (isEmpty) {
            if (pVar.f10185x) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!pVar.f10185x) {
            setHelperTextEnabled(true);
        }
        pVar.c();
        pVar.f10184w = charSequence;
        pVar.f10186y.setText(charSequence);
        int i9 = pVar.f10175n;
        if (i9 != 2) {
            pVar.f10176o = 2;
        }
        pVar.i(i9, pVar.f10176o, pVar.h(pVar.f10186y, charSequence));
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        p pVar = this.f2156r;
        pVar.A = colorStateList;
        e1 e1Var = pVar.f10186y;
        if (e1Var == null || colorStateList == null) {
            return;
        }
        e1Var.setTextColor(colorStateList);
    }

    public void setHelperTextEnabled(boolean z8) {
        p pVar = this.f2156r;
        TextInputLayout textInputLayout = pVar.h;
        if (pVar.f10185x == z8) {
            return;
        }
        pVar.c();
        if (z8) {
            e1 e1Var = new e1(pVar.f10169g, null);
            pVar.f10186y = e1Var;
            e1Var.setId(2131362471);
            pVar.f10186y.setTextAlignment(5);
            Typeface typeface = pVar.B;
            if (typeface != null) {
                pVar.f10186y.setTypeface(typeface);
            }
            pVar.f10186y.setVisibility(4);
            f0.f(pVar.f10186y, 1);
            int i9 = pVar.f10187z;
            pVar.f10187z = i9;
            e1 e1Var2 = pVar.f10186y;
            if (e1Var2 != null) {
                android.support.v4.media.session.b.t0(e1Var2, i9);
            }
            ColorStateList colorStateList = pVar.A;
            pVar.A = colorStateList;
            e1 e1Var3 = pVar.f10186y;
            if (e1Var3 != null && colorStateList != null) {
                e1Var3.setTextColor(colorStateList);
            }
            pVar.a(pVar.f10186y, 1);
            pVar.f10186y.setAccessibilityDelegate(new x5.o(pVar));
        } else {
            pVar.c();
            int i10 = pVar.f10175n;
            if (i10 == 2) {
                pVar.f10176o = 0;
            }
            pVar.i(i10, pVar.f10176o, pVar.h(pVar.f10186y, ""));
            pVar.g(pVar.f10186y, 1);
            pVar.f10186y = null;
            textInputLayout.r();
            textInputLayout.x();
        }
        pVar.f10185x = z8;
    }

    public void setHelperTextTextAppearance(int i9) {
        p pVar = this.f2156r;
        pVar.f10187z = i9;
        e1 e1Var = pVar.f10186y;
        if (e1Var != null) {
            android.support.v4.media.session.b.t0(e1Var, i9);
        }
    }

    public void setHint(int i9) {
        setHint(i9 != 0 ? getResources().getText(i9) : null);
    }

    public void setHintAnimationEnabled(boolean z8) {
        this.E0 = z8;
    }

    public void setHintEnabled(boolean z8) {
        if (z8 != this.K) {
            this.K = z8;
            if (z8) {
                CharSequence hint = this.f2144l.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.L)) {
                        setHint(hint);
                    }
                    this.f2144l.setHint((CharSequence) null);
                }
                this.M = true;
            } else {
                this.M = false;
                if (!TextUtils.isEmpty(this.L) && TextUtils.isEmpty(this.f2144l.getHint())) {
                    this.f2144l.setHint(this.L);
                }
                setHintInternal(null);
            }
            if (this.f2144l != null) {
                t();
            }
        }
    }

    public void setHintTextAppearance(int i9) {
        c cVar = this.C0;
        TextInputLayout textInputLayout = cVar.f7938a;
        r5.d dVar = new r5.d(textInputLayout.getContext(), i9);
        ColorStateList colorStateList = dVar.f8573j;
        if (colorStateList != null) {
            cVar.f7953k = colorStateList;
        }
        float f9 = dVar.f8574k;
        if (f9 != 0.0f) {
            cVar.f7951i = f9;
        }
        ColorStateList colorStateList2 = dVar.f8565a;
        if (colorStateList2 != null) {
            cVar.U = colorStateList2;
        }
        cVar.S = dVar.f8569e;
        cVar.T = dVar.f8570f;
        cVar.R = dVar.f8571g;
        cVar.V = dVar.f8572i;
        r5.a aVar = cVar.f7967y;
        if (aVar != null) {
            aVar.f8559k = true;
        }
        i7.x xVar = new i7.x(cVar, 19);
        dVar.a();
        cVar.f7967y = new r5.a(xVar, dVar.f8577n);
        dVar.c(textInputLayout.getContext(), cVar.f7967y);
        cVar.h(false);
        this.f2157r0 = cVar.f7953k;
        if (this.f2144l != null) {
            u(false, false);
            t();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.f2157r0 != colorStateList) {
            if (this.f2155q0 == null) {
                c cVar = this.C0;
                if (cVar.f7953k != colorStateList) {
                    cVar.f7953k = colorStateList;
                    cVar.h(false);
                }
            }
            this.f2157r0 = colorStateList;
            if (this.f2144l != null) {
                u(false, false);
            }
        }
    }

    public void setLengthCounter(w wVar) {
        this.f2164v = wVar;
    }

    public void setMaxEms(int i9) {
        this.f2150o = i9;
        EditText editText = this.f2144l;
        if (editText == null || i9 == -1) {
            return;
        }
        editText.setMaxEms(i9);
    }

    public void setMaxWidth(int i9) {
        this.f2154q = i9;
        EditText editText = this.f2144l;
        if (editText == null || i9 == -1) {
            return;
        }
        editText.setMaxWidth(i9);
    }

    public void setMaxWidthResource(int i9) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i9));
    }

    public void setMinEms(int i9) {
        this.f2148n = i9;
        EditText editText = this.f2144l;
        if (editText == null || i9 == -1) {
            return;
        }
        editText.setMinEms(i9);
    }

    public void setMinWidth(int i9) {
        this.f2152p = i9;
        EditText editText = this.f2144l;
        if (editText == null || i9 == -1) {
            return;
        }
        editText.setMinWidth(i9);
    }

    public void setMinWidthResource(int i9) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i9));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i9) {
        l lVar = this.f2142k;
        lVar.f10141o.setContentDescription(i9 != 0 ? lVar.getResources().getText(i9) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i9) {
        l lVar = this.f2142k;
        lVar.f10141o.setImageDrawable(i9 != 0 ? android.support.v4.media.session.b.I(lVar.getContext(), i9) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z8) {
        l lVar = this.f2142k;
        if (z8 && lVar.f10143q != 1) {
            lVar.g(1);
        } else if (z8) {
            lVar.getClass();
        } else {
            lVar.g(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        l lVar = this.f2142k;
        lVar.f10145s = colorStateList;
        d.c(lVar.f10135i, lVar.f10141o, colorStateList, lVar.f10146t);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        l lVar = this.f2142k;
        lVar.f10146t = mode;
        d.c(lVar.f10135i, lVar.f10141o, lVar.f10145s, mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.B == null) {
            e1 e1Var = new e1(getContext(), null);
            this.B = e1Var;
            e1Var.setId(2131362472);
            c0.s(this.B, 2);
            h d9 = d();
            this.E = d9;
            d9.f9523j = 67L;
            this.F = d();
            setPlaceholderTextAppearance(this.D);
            setPlaceholderTextColor(this.C);
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.A) {
                setPlaceholderTextEnabled(true);
            }
            this.f2172z = charSequence;
        }
        EditText editText = this.f2144l;
        v(editText != null ? editText.getText() : null);
    }

    public void setPlaceholderTextAppearance(int i9) {
        this.D = i9;
        e1 e1Var = this.B;
        if (e1Var != null) {
            android.support.v4.media.session.b.t0(e1Var, i9);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.C != colorStateList) {
            this.C = colorStateList;
            e1 e1Var = this.B;
            if (e1Var == null || colorStateList == null) {
                return;
            }
            e1Var.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        t tVar = this.f2140j;
        tVar.getClass();
        tVar.f10204k = TextUtils.isEmpty(charSequence) ? null : charSequence;
        tVar.f10203j.setText(charSequence);
        tVar.e();
    }

    public void setPrefixTextAppearance(int i9) {
        android.support.v4.media.session.b.t0(this.f2140j.f10203j, i9);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.f2140j.f10203j.setTextColor(colorStateList);
    }

    public void setShapeAppearanceModel(j jVar) {
        g gVar = this.N;
        if (gVar == null || gVar.f9084i.f9069a == jVar) {
            return;
        }
        this.T = jVar;
        b();
    }

    public void setStartIconCheckable(boolean z8) {
        this.f2140j.f10205l.setCheckable(z8);
    }

    public void setStartIconContentDescription(int i9) {
        setStartIconContentDescription(i9 != 0 ? getResources().getText(i9) : null);
    }

    public void setStartIconDrawable(int i9) {
        setStartIconDrawable(i9 != 0 ? android.support.v4.media.session.b.I(getContext(), i9) : null);
    }

    public void setStartIconMinSize(int i9) {
        t tVar = this.f2140j;
        if (i9 < 0) {
            tVar.getClass();
            m7.c.n("startIconSize cannot be less than 0");
        } else if (i9 != tVar.f10208o) {
            tVar.f10208o = i9;
            CheckableImageButton checkableImageButton = tVar.f10205l;
            checkableImageButton.setMinimumWidth(i9);
            checkableImageButton.setMinimumHeight(i9);
        }
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        t tVar = this.f2140j;
        CheckableImageButton checkableImageButton = tVar.f10205l;
        View.OnLongClickListener onLongClickListener = tVar.f10210q;
        checkableImageButton.setOnClickListener(onClickListener);
        d.Z(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        t tVar = this.f2140j;
        tVar.f10210q = onLongClickListener;
        CheckableImageButton checkableImageButton = tVar.f10205l;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        d.Z(checkableImageButton, onLongClickListener);
    }

    public void setStartIconScaleType(ImageView.ScaleType scaleType) {
        t tVar = this.f2140j;
        tVar.f10209p = scaleType;
        tVar.f10205l.setScaleType(scaleType);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        t tVar = this.f2140j;
        if (tVar.f10206m != colorStateList) {
            tVar.f10206m = colorStateList;
            d.c(tVar.f10202i, tVar.f10205l, colorStateList, tVar.f10207n);
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        t tVar = this.f2140j;
        if (tVar.f10207n != mode) {
            tVar.f10207n = mode;
            d.c(tVar.f10202i, tVar.f10205l, tVar.f10206m, mode);
        }
    }

    public void setStartIconVisible(boolean z8) {
        this.f2140j.c(z8);
    }

    public void setSuffixText(CharSequence charSequence) {
        l lVar = this.f2142k;
        lVar.getClass();
        lVar.f10150x = TextUtils.isEmpty(charSequence) ? null : charSequence;
        lVar.f10151y.setText(charSequence);
        lVar.n();
    }

    public void setSuffixTextAppearance(int i9) {
        android.support.v4.media.session.b.t0(this.f2142k.f10151y, i9);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.f2142k.f10151y.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(v vVar) {
        EditText editText = this.f2144l;
        if (editText != null) {
            t0.p(editText, vVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.f2141j0) {
            this.f2141j0 = typeface;
            this.C0.m(typeface);
            p pVar = this.f2156r;
            if (typeface != pVar.B) {
                pVar.B = typeface;
                e1 e1Var = pVar.f10179r;
                if (e1Var != null) {
                    e1Var.setTypeface(typeface);
                }
                e1 e1Var2 = pVar.f10186y;
                if (e1Var2 != null) {
                    e1Var2.setTypeface(typeface);
                }
            }
            e1 e1Var3 = this.f2166w;
            if (e1Var3 != null) {
                e1Var3.setTypeface(typeface);
            }
        }
    }

    public final void t() {
        if (this.W != 1) {
            FrameLayout frameLayout = this.f2139i;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            int c9 = c();
            if (c9 != layoutParams.topMargin) {
                layoutParams.topMargin = c9;
                frameLayout.requestLayout();
            }
        }
    }

    public final void u(boolean z8, boolean z9) {
        ColorStateList colorStateList;
        e1 e1Var;
        boolean isEnabled = isEnabled();
        EditText editText = this.f2144l;
        boolean z10 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f2144l;
        boolean z11 = editText2 != null && editText2.hasFocus();
        ColorStateList colorStateList2 = this.f2155q0;
        c cVar = this.C0;
        if (colorStateList2 != null) {
            cVar.i(colorStateList2);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.f2155q0;
            int i9 = this.A0;
            if (colorStateList3 != null) {
                i9 = colorStateList3.getColorForState(new int[]{-16842910}, i9);
            }
            cVar.i(ColorStateList.valueOf(i9));
        } else if (m()) {
            e1 e1Var2 = this.f2156r.f10179r;
            cVar.i(e1Var2 != null ? e1Var2.getTextColors() : null);
        } else if (this.f2162u && (e1Var = this.f2166w) != null) {
            cVar.i(e1Var.getTextColors());
        } else if (z11 && (colorStateList = this.f2157r0) != null && cVar.f7953k != colorStateList) {
            cVar.f7953k = colorStateList;
            cVar.h(false);
        }
        l lVar = this.f2142k;
        t tVar = this.f2140j;
        if (z10 || !this.D0 || (isEnabled() && z11)) {
            if (z9 || this.B0) {
                ValueAnimator valueAnimator = this.F0;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.F0.cancel();
                }
                if (z8 && this.E0) {
                    a(1.0f);
                } else {
                    cVar.k(1.0f);
                }
                this.B0 = false;
                if (e()) {
                    j();
                }
                EditText editText3 = this.f2144l;
                v(editText3 != null ? editText3.getText() : null);
                tVar.f10211r = false;
                tVar.e();
                lVar.f10152z = false;
                lVar.n();
                return;
            }
            return;
        }
        if (z9 || !this.B0) {
            ValueAnimator valueAnimator2 = this.F0;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.F0.cancel();
            }
            if (z8 && this.E0) {
                a(0.0f);
            } else {
                cVar.k(0.0f);
            }
            if (e() && !((x5.f) this.N).F.f10117q.isEmpty() && e()) {
                ((x5.f) this.N).r(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.B0 = true;
            e1 e1Var3 = this.B;
            if (e1Var3 != null && this.A) {
                e1Var3.setText((CharSequence) null);
                v3.o.a(this.f2139i, this.F);
                this.B.setVisibility(4);
            }
            tVar.f10211r = true;
            tVar.e();
            lVar.f10152z = true;
            lVar.n();
        }
    }

    public final void v(Editable editable) {
        ((k) this.f2164v).getClass();
        int length = editable != null ? editable.length() : 0;
        FrameLayout frameLayout = this.f2139i;
        if (length != 0 || this.B0) {
            e1 e1Var = this.B;
            if (e1Var == null || !this.A) {
                return;
            }
            e1Var.setText((CharSequence) null);
            v3.o.a(frameLayout, this.F);
            this.B.setVisibility(4);
            return;
        }
        if (this.B == null || !this.A || TextUtils.isEmpty(this.f2172z)) {
            return;
        }
        this.B.setText(this.f2172z);
        v3.o.a(frameLayout, this.E);
        this.B.setVisibility(0);
        this.B.bringToFront();
        announceForAccessibility(this.f2172z);
    }

    public final void w(boolean z8, boolean z9) {
        int defaultColor = this.f2165v0.getDefaultColor();
        int colorForState = this.f2165v0.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.f2165v0.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z8) {
            this.f2135e0 = colorForState2;
        } else if (z9) {
            this.f2135e0 = colorForState;
        } else {
            this.f2135e0 = defaultColor;
        }
    }

    public final void x() {
        e1 e1Var;
        EditText editText;
        EditText editText2;
        if (this.N == null || this.W == 0) {
            return;
        }
        boolean z8 = false;
        boolean z9 = isFocused() || ((editText2 = this.f2144l) != null && editText2.hasFocus());
        if (isHovered() || ((editText = this.f2144l) != null && editText.isHovered())) {
            z8 = true;
        }
        if (!isEnabled()) {
            this.f2135e0 = this.A0;
        } else if (m()) {
            if (this.f2165v0 != null) {
                w(z9, z8);
            } else {
                this.f2135e0 = getErrorCurrentTextColors();
            }
        } else if (!this.f2162u || (e1Var = this.f2166w) == null) {
            if (z9) {
                this.f2135e0 = this.f2163u0;
            } else if (z8) {
                this.f2135e0 = this.f2161t0;
            } else {
                this.f2135e0 = this.f2159s0;
            }
        } else if (this.f2165v0 != null) {
            w(z9, z8);
        } else {
            this.f2135e0 = e1Var.getCurrentTextColor();
        }
        if (Build.VERSION.SDK_INT >= 29) {
            p();
        }
        l lVar = this.f2142k;
        TextInputLayout textInputLayout = lVar.f10135i;
        CheckableImageButton checkableImageButton = lVar.f10141o;
        TextInputLayout textInputLayout2 = lVar.f10135i;
        lVar.l();
        d.V(textInputLayout2, lVar.f10137k, lVar.f10138l);
        d.V(textInputLayout2, checkableImageButton, lVar.f10145s);
        if (lVar.b() instanceof x5.i) {
            if (!textInputLayout.m() || checkableImageButton.getDrawable() == null) {
                d.c(textInputLayout, checkableImageButton, lVar.f10145s, lVar.f10146t);
            } else {
                Drawable mutate = d.f0(checkableImageButton.getDrawable()).mutate();
                g0.b.g(mutate, textInputLayout.getErrorCurrentTextColors());
                checkableImageButton.setImageDrawable(mutate);
            }
        }
        t tVar = this.f2140j;
        d.V(tVar.f10202i, tVar.f10205l, tVar.f10206m);
        if (this.W == 2) {
            int i9 = this.f2132b0;
            if (z9 && isEnabled()) {
                this.f2132b0 = this.f2134d0;
            } else {
                this.f2132b0 = this.f2133c0;
            }
            if (this.f2132b0 != i9 && e() && !this.B0) {
                if (e()) {
                    ((x5.f) this.N).r(0.0f, 0.0f, 0.0f, 0.0f);
                }
                j();
            }
        }
        if (this.W == 1) {
            if (!isEnabled()) {
                this.f2136f0 = this.f2169x0;
            } else if (z8 && !z9) {
                this.f2136f0 = this.f2173z0;
            } else if (z9) {
                this.f2136f0 = this.f2171y0;
            } else {
                this.f2136f0 = this.f2167w0;
            }
        }
        b();
    }

    public void setHint(CharSequence charSequence) {
        if (this.K) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(IjkMediaMeta.FF_PROFILE_H264_INTRA);
        }
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.f2140j.f10205l;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.f2140j.b(drawable);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f2142k.f10141o.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f2142k.f10141o.setImageDrawable(drawable);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.f2142k.f10141o;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.f2142k.i(drawable);
    }

    public void setEndIconDrawable(Drawable drawable) {
        l lVar = this.f2142k;
        TextInputLayout textInputLayout = lVar.f10135i;
        CheckableImageButton checkableImageButton = lVar.f10141o;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            d.c(textInputLayout, checkableImageButton, lVar.f10145s, lVar.f10146t);
            d.V(textInputLayout, checkableImageButton, lVar.f10145s);
        }
    }
}
