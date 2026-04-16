package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.emoji2.text.l;
import androidx.fragment.app.g;
import java.util.WeakHashMap;
import n.b1;
import n.f4;
import n.j3;
import n.k3;
import n.l3;
import n.m3;
import n.r1;
import n.w;
import n0.f0;
import n0.t0;
import n0.y;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class SwitchCompat extends CompoundButton {

    /* renamed from: c0, reason: collision with root package name */
    public static final j3 f474c0 = new j3(Float.class, "thumbPos", 0);

    /* renamed from: d0, reason: collision with root package name */
    public static final int[] f475d0 = {R.attr.state_checked};
    public boolean A;
    public int B;
    public final int C;
    public float D;
    public float E;
    public final VelocityTracker F;
    public final int G;
    public float H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public boolean P;
    public final TextPaint Q;
    public final ColorStateList R;
    public StaticLayout S;
    public StaticLayout T;
    public final k.a U;
    public ObjectAnimator V;
    public w W;

    /* renamed from: a0, reason: collision with root package name */
    public l3 f476a0;

    /* renamed from: b0, reason: collision with root package name */
    public final Rect f477b0;

    /* renamed from: i, reason: collision with root package name */
    public Drawable f478i;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f479j;

    /* renamed from: k, reason: collision with root package name */
    public PorterDuff.Mode f480k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f481l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f482m;

    /* renamed from: n, reason: collision with root package name */
    public Drawable f483n;

    /* renamed from: o, reason: collision with root package name */
    public ColorStateList f484o;

    /* renamed from: p, reason: collision with root package name */
    public PorterDuff.Mode f485p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f486q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f487r;

    /* renamed from: s, reason: collision with root package name */
    public int f488s;

    /* renamed from: t, reason: collision with root package name */
    public int f489t;

    /* renamed from: u, reason: collision with root package name */
    public int f490u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f491v;

    /* renamed from: w, reason: collision with root package name */
    public CharSequence f492w;

    /* renamed from: x, reason: collision with root package name */
    public CharSequence f493x;

    /* renamed from: y, reason: collision with root package name */
    public CharSequence f494y;

    /* renamed from: z, reason: collision with root package name */
    public CharSequence f495z;

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130969575);
        int resourceId;
        this.f479j = null;
        this.f480k = null;
        this.f481l = false;
        this.f482m = false;
        this.f484o = null;
        this.f485p = null;
        this.f486q = false;
        this.f487r = false;
        this.F = VelocityTracker.obtain();
        this.P = true;
        this.f477b0 = new Rect();
        m3.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.Q = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = f.a.f3187w;
        g g02 = g.g0(context, attributeSet, iArr, 2130969575);
        TypedArray typedArray = (TypedArray) g02.f729k;
        t0.o(this, context, iArr, attributeSet, typedArray, 2130969575);
        Drawable Q = g02.Q(2);
        this.f478i = Q;
        if (Q != null) {
            Q.setCallback(this);
        }
        Drawable Q2 = g02.Q(11);
        this.f483n = Q2;
        if (Q2 != null) {
            Q2.setCallback(this);
        }
        setTextOnInternal(typedArray.getText(0));
        setTextOffInternal(typedArray.getText(1));
        this.A = typedArray.getBoolean(3, true);
        this.f488s = typedArray.getDimensionPixelSize(8, 0);
        this.f489t = typedArray.getDimensionPixelSize(5, 0);
        this.f490u = typedArray.getDimensionPixelSize(6, 0);
        this.f491v = typedArray.getBoolean(4, false);
        ColorStateList O = g02.O(9);
        if (O != null) {
            this.f479j = O;
            this.f481l = true;
        }
        PorterDuff.Mode c9 = r1.c(typedArray.getInt(10, -1), null);
        if (this.f480k != c9) {
            this.f480k = c9;
            this.f482m = true;
        }
        if (this.f481l || this.f482m) {
            a();
        }
        ColorStateList O2 = g02.O(12);
        if (O2 != null) {
            this.f484o = O2;
            this.f486q = true;
        }
        PorterDuff.Mode c10 = r1.c(typedArray.getInt(13, -1), null);
        if (this.f485p != c10) {
            this.f485p = c10;
            this.f487r = true;
        }
        if (this.f486q || this.f487r) {
            b();
        }
        int resourceId2 = typedArray.getResourceId(7, 0);
        if (resourceId2 != 0) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(resourceId2, f.a.f3188x);
            ColorStateList colorStateList = (!obtainStyledAttributes.hasValue(3) || (resourceId = obtainStyledAttributes.getResourceId(3, 0)) == 0 || (colorStateList = a.a.u(context, resourceId)) == null) ? obtainStyledAttributes.getColorStateList(3) : colorStateList;
            if (colorStateList != null) {
                this.R = colorStateList;
            } else {
                this.R = getTextColors();
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            if (dimensionPixelSize != 0) {
                float f9 = dimensionPixelSize;
                if (f9 != textPaint.getTextSize()) {
                    textPaint.setTextSize(f9);
                    requestLayout();
                }
            }
            int i9 = obtainStyledAttributes.getInt(1, -1);
            int i10 = obtainStyledAttributes.getInt(2, -1);
            Typeface typeface = i9 != 1 ? i9 != 2 ? i9 != 3 ? null : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF;
            if (i10 > 0) {
                Typeface defaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i10) : Typeface.create(typeface, i10);
                setSwitchTypeface(defaultFromStyle);
                int i11 = (~(defaultFromStyle != null ? defaultFromStyle.getStyle() : 0)) & i10;
                textPaint.setFakeBoldText((i11 & 1) != 0);
                textPaint.setTextSkewX((2 & i11) != 0 ? -0.25f : 0.0f);
            } else {
                textPaint.setFakeBoldText(false);
                textPaint.setTextSkewX(0.0f);
                setSwitchTypeface(typeface);
            }
            if (obtainStyledAttributes.getBoolean(14, false)) {
                Context context2 = getContext();
                k.a aVar = new k.a();
                aVar.f5504i = context2.getResources().getConfiguration().locale;
                this.U = aVar;
            } else {
                this.U = null;
            }
            setTextOnInternal(this.f492w);
            setTextOffInternal(this.f494y);
            obtainStyledAttributes.recycle();
        }
        new b1(this).f(attributeSet, 2130969575);
        g02.i0();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.C = viewConfiguration.getScaledTouchSlop();
        this.G = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().b(attributeSet, 2130969575);
        refreshDrawableState();
        setChecked(isChecked());
    }

    private w getEmojiTextViewHelper() {
        if (this.W == null) {
            this.W = new w(this);
        }
        return this.W;
    }

    private boolean getTargetCheckedState() {
        return this.H > 0.5f;
    }

    private int getThumbOffset() {
        boolean a9 = f4.a(this);
        float f9 = this.H;
        if (a9) {
            f9 = 1.0f - f9;
        }
        return (int) ((f9 * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f483n;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.f477b0;
        drawable.getPadding(rect);
        Drawable drawable2 = this.f478i;
        Rect b9 = drawable2 != null ? r1.b(drawable2) : r1.f7023c;
        return ((((this.I - this.K) - rect.left) - rect.right) - b9.left) - b9.right;
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.f494y = charSequence;
        TransformationMethod Y = ((com.bumptech.glide.c) getEmojiTextViewHelper().f7081b.f5179j).Y(this.U);
        if (Y != null) {
            charSequence = Y.getTransformation(charSequence, this);
        }
        this.f495z = charSequence;
        this.T = null;
        if (this.A) {
            d();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.f492w = charSequence;
        TransformationMethod Y = ((com.bumptech.glide.c) getEmojiTextViewHelper().f7081b.f5179j).Y(this.U);
        if (Y != null) {
            charSequence = Y.getTransformation(charSequence, this);
        }
        this.f493x = charSequence;
        this.S = null;
        if (this.A) {
            d();
        }
    }

    public final void a() {
        Drawable drawable = this.f478i;
        if (drawable != null) {
            if (this.f481l || this.f482m) {
                Drawable mutate = com.bumptech.glide.d.f0(drawable).mutate();
                this.f478i = mutate;
                if (this.f481l) {
                    g0.b.h(mutate, this.f479j);
                }
                if (this.f482m) {
                    g0.b.i(this.f478i, this.f480k);
                }
                if (this.f478i.isStateful()) {
                    this.f478i.setState(getDrawableState());
                }
            }
        }
    }

    public final void b() {
        Drawable drawable = this.f483n;
        if (drawable != null) {
            if (this.f486q || this.f487r) {
                Drawable mutate = com.bumptech.glide.d.f0(drawable).mutate();
                this.f483n = mutate;
                if (this.f486q) {
                    g0.b.h(mutate, this.f484o);
                }
                if (this.f487r) {
                    g0.b.i(this.f483n, this.f485p);
                }
                if (this.f483n.isStateful()) {
                    this.f483n.setState(getDrawableState());
                }
            }
        }
    }

    public final void c() {
        setTextOnInternal(this.f492w);
        setTextOffInternal(this.f494y);
        requestLayout();
    }

    public final void d() {
        if (this.f476a0 == null && ((com.bumptech.glide.c) this.W.f7081b.f5179j).E() && l.f624j != null) {
            l a9 = l.a();
            int b9 = a9.b();
            if (b9 == 3 || b9 == 0) {
                l3 l3Var = new l3(this);
                this.f476a0 = l3Var;
                a9.f(l3Var);
            }
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i9;
        int i10;
        int i11 = this.L;
        int i12 = this.M;
        int i13 = this.N;
        int i14 = this.O;
        int thumbOffset = getThumbOffset() + i11;
        Drawable drawable = this.f478i;
        Rect b9 = drawable != null ? r1.b(drawable) : r1.f7023c;
        Drawable drawable2 = this.f483n;
        Rect rect = this.f477b0;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i15 = rect.left;
            thumbOffset += i15;
            if (b9 != null) {
                int i16 = b9.left;
                if (i16 > i15) {
                    i11 += i16 - i15;
                }
                int i17 = b9.top;
                int i18 = rect.top;
                i9 = i17 > i18 ? (i17 - i18) + i12 : i12;
                int i19 = b9.right;
                int i20 = rect.right;
                if (i19 > i20) {
                    i13 -= i19 - i20;
                }
                int i21 = b9.bottom;
                int i22 = rect.bottom;
                if (i21 > i22) {
                    i10 = i14 - (i21 - i22);
                    this.f483n.setBounds(i11, i9, i13, i10);
                }
            } else {
                i9 = i12;
            }
            i10 = i14;
            this.f483n.setBounds(i11, i9, i13, i10);
        }
        Drawable drawable3 = this.f478i;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i23 = thumbOffset - rect.left;
            int i24 = thumbOffset + this.K + rect.right;
            this.f478i.setBounds(i23, i12, i24, i14);
            Drawable background = getBackground();
            if (background != null) {
                g0.b.f(background, i23, i12, i24, i14);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableHotspotChanged(float f9, float f10) {
        super.drawableHotspotChanged(f9, f10);
        Drawable drawable = this.f478i;
        if (drawable != null) {
            g0.b.e(drawable, f9, f10);
        }
        Drawable drawable2 = this.f483n;
        if (drawable2 != null) {
            g0.b.e(drawable2, f9, f10);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f478i;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.f483n;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!f4.a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.I;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f490u : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (f4.a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.I;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f490u : compoundPaddingRight;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return android.support.v4.media.session.b.A0(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.A;
    }

    public boolean getSplitTrack() {
        return this.f491v;
    }

    public int getSwitchMinWidth() {
        return this.f489t;
    }

    public int getSwitchPadding() {
        return this.f490u;
    }

    public CharSequence getTextOff() {
        return this.f494y;
    }

    public CharSequence getTextOn() {
        return this.f492w;
    }

    public Drawable getThumbDrawable() {
        return this.f478i;
    }

    public final float getThumbPosition() {
        return this.H;
    }

    public int getThumbTextPadding() {
        return this.f488s;
    }

    public ColorStateList getThumbTintList() {
        return this.f479j;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f480k;
    }

    public Drawable getTrackDrawable() {
        return this.f483n;
    }

    public ColorStateList getTrackTintList() {
        return this.f484o;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f485p;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f478i;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f483n;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.V;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.V.end();
        this.V = null;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i9) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i9 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f475d0);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Drawable drawable = this.f483n;
        Rect rect = this.f477b0;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i9 = this.M;
        int i10 = this.O;
        int i11 = i9 + rect.top;
        int i12 = i10 - rect.bottom;
        Drawable drawable2 = this.f478i;
        if (drawable != null) {
            if (!this.f491v || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect b9 = r1.b(drawable2);
                drawable2.copyBounds(rect);
                rect.left += b9.left;
                rect.right -= b9.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        StaticLayout staticLayout = getTargetCheckedState() ? this.S : this.T;
        if (staticLayout != null) {
            int[] drawableState = getDrawableState();
            TextPaint textPaint = this.Q;
            ColorStateList colorStateList = this.R;
            if (colorStateList != null) {
                textPaint.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            textPaint.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (staticLayout.getWidth() / 2), ((i11 + i12) / 2) - (staticLayout.getHeight() / 2));
            staticLayout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.f492w : this.f494y;
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(text);
            sb.append(' ');
            sb.append(charSequence);
            accessibilityNodeInfo.setText(sb);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        int i13;
        int width;
        int i14;
        int i15;
        int i16;
        super.onLayout(z8, i9, i10, i11, i12);
        int i17 = 0;
        if (this.f478i != null) {
            Drawable drawable = this.f483n;
            Rect rect = this.f477b0;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect b9 = r1.b(this.f478i);
            i13 = Math.max(0, b9.left - rect.left);
            i17 = Math.max(0, b9.right - rect.right);
        } else {
            i13 = 0;
        }
        if (f4.a(this)) {
            i14 = getPaddingLeft() + i13;
            width = ((this.I + i14) - i13) - i17;
        } else {
            width = (getWidth() - getPaddingRight()) - i17;
            i14 = (width - this.I) + i13 + i17;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int height = ((getHeight() + getPaddingTop()) - getPaddingBottom()) / 2;
            int i18 = this.J;
            int i19 = height - (i18 / 2);
            i15 = i18 + i19;
            i16 = i19;
        } else if (gravity != 80) {
            i16 = getPaddingTop();
            i15 = this.J + i16;
        } else {
            i15 = getHeight() - getPaddingBottom();
            i16 = i15 - this.J;
        }
        this.L = i14;
        this.M = i16;
        this.O = i15;
        this.N = width;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i9, int i10) {
        int i11;
        int i12;
        int i13 = 0;
        if (this.A) {
            StaticLayout staticLayout = this.S;
            TextPaint textPaint = this.Q;
            if (staticLayout == null) {
                CharSequence charSequence = this.f493x;
                this.S = new StaticLayout(charSequence, textPaint, charSequence != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
            if (this.T == null) {
                CharSequence charSequence2 = this.f495z;
                this.T = new StaticLayout(charSequence2, textPaint, charSequence2 != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence2, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            }
        }
        Drawable drawable = this.f478i;
        Rect rect = this.f477b0;
        if (drawable != null) {
            drawable.getPadding(rect);
            i11 = (this.f478i.getIntrinsicWidth() - rect.left) - rect.right;
            i12 = this.f478i.getIntrinsicHeight();
        } else {
            i11 = 0;
            i12 = 0;
        }
        this.K = Math.max(this.A ? (this.f488s * 2) + Math.max(this.S.getWidth(), this.T.getWidth()) : 0, i11);
        Drawable drawable2 = this.f483n;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i13 = this.f483n.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i14 = rect.left;
        int i15 = rect.right;
        Drawable drawable3 = this.f478i;
        if (drawable3 != null) {
            Rect b9 = r1.b(drawable3);
            i14 = Math.max(i14, b9.left);
            i15 = Math.max(i15, b9.right);
        }
        boolean z8 = this.P;
        int i16 = this.f489t;
        if (z8) {
            i16 = Math.max(i16, (this.K * 2) + i14 + i15);
        }
        int max = Math.max(i13, i12);
        this.I = i16;
        this.J = max;
        super.onMeasure(i9, i10);
        if (getMeasuredHeight() < max) {
            setMeasuredDimension(getMeasuredWidthAndState(), max);
        }
    }

    @Override // android.view.View
    public final void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f492w : this.f494y;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0015, code lost:
    
        if (r1 != 3) goto L82;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z8) {
        super.setAllCaps(z8);
        getEmojiTextViewHelper().c(z8);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z8) {
        super.setChecked(z8);
        boolean isChecked = isChecked();
        if (isChecked) {
            if (Build.VERSION.SDK_INT >= 30) {
                Object obj = this.f492w;
                if (obj == null) {
                    obj = getResources().getString(2131951623);
                }
                Object obj2 = obj;
                WeakHashMap weakHashMap = t0.f7209a;
                new y(2131362427, CharSequence.class, 64, 30, 2).d(this, obj2);
            }
        } else if (Build.VERSION.SDK_INT >= 30) {
            Object obj3 = this.f494y;
            if (obj3 == null) {
                obj3 = getResources().getString(2131951622);
            }
            Object obj4 = obj3;
            WeakHashMap weakHashMap2 = t0.f7209a;
            new y(2131362427, CharSequence.class, 64, 30, 2).d(this, obj4);
        }
        if (getWindowToken() != null) {
            WeakHashMap weakHashMap3 = t0.f7209a;
            if (f0.c(this)) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f474c0, isChecked ? 1.0f : 0.0f);
                this.V = ofFloat;
                ofFloat.setDuration(250L);
                k3.a(this.V, true);
                this.V.start();
                return;
            }
        }
        ObjectAnimator objectAnimator = this.V;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        setThumbPosition(isChecked ? 1.0f : 0.0f);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(android.support.v4.media.session.b.C0(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z8) {
        getEmojiTextViewHelper().d(z8);
        setTextOnInternal(this.f492w);
        setTextOffInternal(this.f494y);
        requestLayout();
    }

    public final void setEnforceSwitchWidth(boolean z8) {
        this.P = z8;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setShowText(boolean z8) {
        if (this.A != z8) {
            this.A = z8;
            requestLayout();
            if (z8) {
                d();
            }
        }
    }

    public void setSplitTrack(boolean z8) {
        this.f491v = z8;
        invalidate();
    }

    public void setSwitchMinWidth(int i9) {
        this.f489t = i9;
        requestLayout();
    }

    public void setSwitchPadding(int i9) {
        this.f490u = i9;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        TextPaint textPaint = this.Q;
        if ((textPaint.getTypeface() == null || textPaint.getTypeface().equals(typeface)) && (textPaint.getTypeface() != null || typeface == null)) {
            return;
        }
        textPaint.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setTextOff(CharSequence charSequence) {
        setTextOffInternal(charSequence);
        requestLayout();
        if (isChecked() || Build.VERSION.SDK_INT < 30) {
            return;
        }
        Object obj = this.f494y;
        if (obj == null) {
            obj = getResources().getString(2131951622);
        }
        WeakHashMap weakHashMap = t0.f7209a;
        new y(2131362427, CharSequence.class, 64, 30, 2).d(this, obj);
    }

    public void setTextOn(CharSequence charSequence) {
        setTextOnInternal(charSequence);
        requestLayout();
        if (!isChecked() || Build.VERSION.SDK_INT < 30) {
            return;
        }
        Object obj = this.f492w;
        if (obj == null) {
            obj = getResources().getString(2131951623);
        }
        WeakHashMap weakHashMap = t0.f7209a;
        new y(2131362427, CharSequence.class, 64, 30, 2).d(this, obj);
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f478i;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f478i = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbPosition(float f9) {
        this.H = f9;
        invalidate();
    }

    public void setThumbResource(int i9) {
        setThumbDrawable(android.support.v4.media.session.b.I(getContext(), i9));
    }

    public void setThumbTextPadding(int i9) {
        this.f488s = i9;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f479j = colorStateList;
        this.f481l = true;
        a();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f480k = mode;
        this.f482m = true;
        a();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f483n;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f483n = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i9) {
        setTrackDrawable(android.support.v4.media.session.b.I(getContext(), i9));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f484o = colorStateList;
        this.f486q = true;
        b();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f485p = mode;
        this.f487r = true;
        b();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public final void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f478i || drawable == this.f483n;
    }
}
