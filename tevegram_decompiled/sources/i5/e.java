package i5;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.google.android.material.chip.Chip;
import i7.x;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import l1.v0;
import o5.l;
import o5.m;
import u5.j;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e extends u5.g implements Drawable.Callback, l {
    public static final int[] N0 = {R.attr.state_enabled};
    public static final ShapeDrawable O0 = new ShapeDrawable(new OvalShape());
    public int A0;
    public int B0;
    public ColorFilter C0;
    public PorterDuffColorFilter D0;
    public ColorStateList E0;
    public ColorStateList F;
    public PorterDuff.Mode F0;
    public ColorStateList G;
    public int[] G0;
    public float H;
    public ColorStateList H0;
    public float I;
    public WeakReference I0;
    public ColorStateList J;
    public TextUtils.TruncateAt J0;
    public float K;
    public boolean K0;
    public ColorStateList L;
    public int L0;
    public CharSequence M;
    public boolean M0;
    public boolean N;
    public Drawable O;
    public ColorStateList P;
    public float Q;
    public boolean R;
    public boolean S;
    public Drawable T;
    public RippleDrawable U;
    public ColorStateList V;
    public float W;
    public SpannableStringBuilder X;
    public boolean Y;
    public boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    public Drawable f4720a0;

    /* renamed from: b0, reason: collision with root package name */
    public ColorStateList f4721b0;

    /* renamed from: c0, reason: collision with root package name */
    public z4.b f4722c0;

    /* renamed from: d0, reason: collision with root package name */
    public z4.b f4723d0;

    /* renamed from: e0, reason: collision with root package name */
    public float f4724e0;

    /* renamed from: f0, reason: collision with root package name */
    public float f4725f0;

    /* renamed from: g0, reason: collision with root package name */
    public float f4726g0;

    /* renamed from: h0, reason: collision with root package name */
    public float f4727h0;
    public float i0;

    /* renamed from: j0, reason: collision with root package name */
    public float f4728j0;

    /* renamed from: k0, reason: collision with root package name */
    public float f4729k0;

    /* renamed from: l0, reason: collision with root package name */
    public float f4730l0;

    /* renamed from: m0, reason: collision with root package name */
    public final Context f4731m0;

    /* renamed from: n0, reason: collision with root package name */
    public final Paint f4732n0;

    /* renamed from: o0, reason: collision with root package name */
    public final Paint.FontMetrics f4733o0;

    /* renamed from: p0, reason: collision with root package name */
    public final RectF f4734p0;

    /* renamed from: q0, reason: collision with root package name */
    public final PointF f4735q0;

    /* renamed from: r0, reason: collision with root package name */
    public final Path f4736r0;

    /* renamed from: s0, reason: collision with root package name */
    public final m f4737s0;

    /* renamed from: t0, reason: collision with root package name */
    public int f4738t0;

    /* renamed from: u0, reason: collision with root package name */
    public int f4739u0;

    /* renamed from: v0, reason: collision with root package name */
    public int f4740v0;

    /* renamed from: w0, reason: collision with root package name */
    public int f4741w0;

    /* renamed from: x0, reason: collision with root package name */
    public int f4742x0;

    /* renamed from: y0, reason: collision with root package name */
    public int f4743y0;

    /* renamed from: z0, reason: collision with root package name */
    public boolean f4744z0;

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130968774, 2132018214);
        this.I = -1.0f;
        this.f4732n0 = new Paint(1);
        this.f4733o0 = new Paint.FontMetrics();
        this.f4734p0 = new RectF();
        this.f4735q0 = new PointF();
        this.f4736r0 = new Path();
        this.B0 = 255;
        this.F0 = PorterDuff.Mode.SRC_IN;
        this.I0 = new WeakReference(null);
        i(context);
        this.f4731m0 = context;
        m mVar = new m(this);
        this.f4737s0 = mVar;
        this.M = "";
        mVar.f7992a.density = context.getResources().getDisplayMetrics().density;
        int[] iArr = N0;
        setState(iArr);
        if (!Arrays.equals(this.G0, iArr)) {
            this.G0 = iArr;
            if (X()) {
                z(getState(), iArr);
            }
        }
        this.K0 = true;
        int[] iArr2 = s5.b.f8857a;
        O0.setTint(-1);
    }

    public static void Y(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public static boolean w(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean x(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public final void A(boolean z8) {
        if (this.Y != z8) {
            this.Y = z8;
            float t8 = t();
            if (!z8 && this.f4744z0) {
                this.f4744z0 = false;
            }
            float t9 = t();
            invalidateSelf();
            if (t8 != t9) {
                y();
            }
        }
    }

    public final void B(Drawable drawable) {
        if (this.f4720a0 != drawable) {
            float t8 = t();
            this.f4720a0 = drawable;
            float t9 = t();
            Y(this.f4720a0);
            r(this.f4720a0);
            invalidateSelf();
            if (t8 != t9) {
                y();
            }
        }
    }

    public final void C(ColorStateList colorStateList) {
        Drawable drawable;
        if (this.f4721b0 != colorStateList) {
            this.f4721b0 = colorStateList;
            if (this.Z && (drawable = this.f4720a0) != null && this.Y) {
                g0.b.h(drawable, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void D(boolean z8) {
        if (this.Z != z8) {
            boolean V = V();
            this.Z = z8;
            boolean V2 = V();
            if (V != V2) {
                Drawable drawable = this.f4720a0;
                if (V2) {
                    r(drawable);
                } else {
                    Y(drawable);
                }
                invalidateSelf();
                y();
            }
        }
    }

    public final void E(float f9) {
        if (this.I != f9) {
            this.I = f9;
            c7.b e9 = this.f9084i.f9069a.e();
            e9.c(f9);
            setShapeAppearanceModel(e9.a());
        }
    }

    public final void F(Drawable drawable) {
        Drawable drawable2 = this.O;
        if (drawable2 == null) {
            drawable2 = null;
        } else if (drawable2 instanceof g0.f) {
            drawable2 = ((g0.f) drawable2).f3649n;
        }
        if (drawable2 != drawable) {
            float t8 = t();
            this.O = drawable != null ? com.bumptech.glide.d.f0(drawable).mutate() : null;
            float t9 = t();
            Y(drawable2);
            if (W()) {
                r(this.O);
            }
            invalidateSelf();
            if (t8 != t9) {
                y();
            }
        }
    }

    public final void G(float f9) {
        if (this.Q != f9) {
            float t8 = t();
            this.Q = f9;
            float t9 = t();
            invalidateSelf();
            if (t8 != t9) {
                y();
            }
        }
    }

    public final void H(ColorStateList colorStateList) {
        this.R = true;
        if (this.P != colorStateList) {
            this.P = colorStateList;
            if (W()) {
                g0.b.h(this.O, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void I(boolean z8) {
        if (this.N != z8) {
            boolean W = W();
            this.N = z8;
            boolean W2 = W();
            if (W != W2) {
                Drawable drawable = this.O;
                if (W2) {
                    r(drawable);
                } else {
                    Y(drawable);
                }
                invalidateSelf();
                y();
            }
        }
    }

    public final void J(ColorStateList colorStateList) {
        if (this.J != colorStateList) {
            this.J = colorStateList;
            if (this.M0) {
                u5.f fVar = this.f9084i;
                if (fVar.f9072d != colorStateList) {
                    fVar.f9072d = colorStateList;
                    onStateChange(getState());
                }
            }
            onStateChange(getState());
        }
    }

    public final void K(float f9) {
        if (this.K != f9) {
            this.K = f9;
            this.f4732n0.setStrokeWidth(f9);
            if (this.M0) {
                this.f9084i.f9077j = f9;
                invalidateSelf();
            }
            invalidateSelf();
        }
    }

    public final void L(Drawable drawable) {
        Drawable drawable2 = this.T;
        if (drawable2 == null) {
            drawable2 = null;
        } else if (drawable2 instanceof g0.f) {
            drawable2 = ((g0.f) drawable2).f3649n;
        }
        if (drawable2 != drawable) {
            float u3 = u();
            this.T = drawable != null ? com.bumptech.glide.d.f0(drawable).mutate() : null;
            int[] iArr = s5.b.f8857a;
            this.U = new RippleDrawable(s5.b.a(this.L), this.T, O0);
            float u6 = u();
            Y(drawable2);
            if (X()) {
                r(this.T);
            }
            invalidateSelf();
            if (u3 != u6) {
                y();
            }
        }
    }

    public final void M(float f9) {
        if (this.f4729k0 != f9) {
            this.f4729k0 = f9;
            invalidateSelf();
            if (X()) {
                y();
            }
        }
    }

    public final void N(float f9) {
        if (this.W != f9) {
            this.W = f9;
            invalidateSelf();
            if (X()) {
                y();
            }
        }
    }

    public final void O(float f9) {
        if (this.f4728j0 != f9) {
            this.f4728j0 = f9;
            invalidateSelf();
            if (X()) {
                y();
            }
        }
    }

    public final void P(ColorStateList colorStateList) {
        if (this.V != colorStateList) {
            this.V = colorStateList;
            if (X()) {
                g0.b.h(this.T, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void Q(boolean z8) {
        if (this.S != z8) {
            boolean X = X();
            this.S = z8;
            boolean X2 = X();
            if (X != X2) {
                Drawable drawable = this.T;
                if (X2) {
                    r(drawable);
                } else {
                    Y(drawable);
                }
                invalidateSelf();
                y();
            }
        }
    }

    public final void R(float f9) {
        if (this.f4726g0 != f9) {
            float t8 = t();
            this.f4726g0 = f9;
            float t9 = t();
            invalidateSelf();
            if (t8 != t9) {
                y();
            }
        }
    }

    public final void S(float f9) {
        if (this.f4725f0 != f9) {
            float t8 = t();
            this.f4725f0 = f9;
            float t9 = t();
            invalidateSelf();
            if (t8 != t9) {
                y();
            }
        }
    }

    public final void T(ColorStateList colorStateList) {
        if (this.L != colorStateList) {
            this.L = colorStateList;
            this.H0 = null;
            onStateChange(getState());
        }
    }

    public final void U(r5.d dVar) {
        m mVar = this.f4737s0;
        a aVar = mVar.f7993b;
        TextPaint textPaint = mVar.f7992a;
        if (mVar.f7997f != dVar) {
            mVar.f7997f = dVar;
            if (dVar != null) {
                Context context = this.f4731m0;
                dVar.f(context, textPaint, aVar);
                l lVar = (l) mVar.f7996e.get();
                if (lVar != null) {
                    textPaint.drawableState = lVar.getState();
                }
                dVar.e(context, textPaint, aVar);
                mVar.f7995d = true;
            }
            l lVar2 = (l) mVar.f7996e.get();
            if (lVar2 != null) {
                e eVar = (e) lVar2;
                eVar.y();
                eVar.invalidateSelf();
                eVar.onStateChange(lVar2.getState());
            }
        }
    }

    public final boolean V() {
        return this.Z && this.f4720a0 != null && this.f4744z0;
    }

    public final boolean W() {
        return this.N && this.O != null;
    }

    public final boolean X() {
        return this.S && this.T != null;
    }

    @Override // u5.g, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i9;
        Canvas canvas2;
        int i10;
        int i11;
        int saveLayerAlpha;
        Rect bounds = getBounds();
        if (bounds.isEmpty() || (i9 = this.B0) == 0) {
            return;
        }
        if (i9 < 255) {
            float f9 = bounds.left;
            float f10 = bounds.top;
            float f11 = bounds.right;
            float f12 = bounds.bottom;
            if (Build.VERSION.SDK_INT > 21) {
                canvas2 = canvas;
                saveLayerAlpha = canvas2.saveLayerAlpha(f9, f10, f11, f12, i9);
            } else {
                canvas2 = canvas;
                saveLayerAlpha = canvas2.saveLayerAlpha(f9, f10, f11, f12, i9, 31);
            }
            i10 = saveLayerAlpha;
        } else {
            canvas2 = canvas;
            i10 = 0;
        }
        boolean z8 = this.M0;
        Paint paint = this.f4732n0;
        RectF rectF = this.f4734p0;
        if (!z8) {
            paint.setColor(this.f4738t0);
            paint.setStyle(Paint.Style.FILL);
            rectF.set(bounds);
            canvas2.drawRoundRect(rectF, v(), v(), paint);
        }
        if (!this.M0) {
            paint.setColor(this.f4739u0);
            paint.setStyle(Paint.Style.FILL);
            ColorFilter colorFilter = this.C0;
            if (colorFilter == null) {
                colorFilter = this.D0;
            }
            paint.setColorFilter(colorFilter);
            rectF.set(bounds);
            canvas2.drawRoundRect(rectF, v(), v(), paint);
        }
        if (this.M0) {
            super.draw(canvas);
        }
        if (this.K > 0.0f && !this.M0) {
            paint.setColor(this.f4741w0);
            paint.setStyle(Paint.Style.STROKE);
            if (!this.M0) {
                ColorFilter colorFilter2 = this.C0;
                if (colorFilter2 == null) {
                    colorFilter2 = this.D0;
                }
                paint.setColorFilter(colorFilter2);
            }
            float f13 = bounds.left;
            float f14 = this.K / 2.0f;
            rectF.set(f13 + f14, bounds.top + f14, bounds.right - f14, bounds.bottom - f14);
            float f15 = this.I - (this.K / 2.0f);
            canvas2.drawRoundRect(rectF, f15, f15, paint);
        }
        paint.setColor(this.f4742x0);
        paint.setStyle(Paint.Style.FILL);
        rectF.set(bounds);
        if (this.M0) {
            RectF rectF2 = new RectF(bounds);
            u5.f fVar = this.f9084i;
            j jVar = fVar.f9069a;
            float f16 = fVar.f9076i;
            x xVar = this.f9100y;
            v0 v0Var = this.f9101z;
            Path path = this.f4736r0;
            v0Var.b(jVar, f16, rectF2, xVar, path);
            d(canvas2, paint, path, this.f9084i.f9069a, f());
        } else {
            canvas2.drawRoundRect(rectF, v(), v(), paint);
        }
        if (W()) {
            s(bounds, rectF);
            float f17 = rectF.left;
            float f18 = rectF.top;
            canvas2.translate(f17, f18);
            this.O.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.O.draw(canvas2);
            canvas2.translate(-f17, -f18);
        }
        if (V()) {
            s(bounds, rectF);
            float f19 = rectF.left;
            float f20 = rectF.top;
            canvas2.translate(f19, f20);
            this.f4720a0.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.f4720a0.draw(canvas2);
            canvas2.translate(-f19, -f20);
        }
        if (this.K0 && this.M != null) {
            PointF pointF = this.f4735q0;
            pointF.set(0.0f, 0.0f);
            Paint.Align align = Paint.Align.LEFT;
            CharSequence charSequence = this.M;
            m mVar = this.f4737s0;
            if (charSequence != null) {
                float t8 = t() + this.f4724e0 + this.f4727h0;
                if (com.bumptech.glide.d.F(this) == 0) {
                    pointF.x = bounds.left + t8;
                } else {
                    pointF.x = bounds.right - t8;
                    align = Paint.Align.RIGHT;
                }
                float centerY = bounds.centerY();
                TextPaint textPaint = mVar.f7992a;
                Paint.FontMetrics fontMetrics = this.f4733o0;
                textPaint.getFontMetrics(fontMetrics);
                pointF.y = centerY - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f);
            }
            rectF.setEmpty();
            if (this.M != null) {
                float t9 = t() + this.f4724e0 + this.f4727h0;
                float u3 = u() + this.f4730l0 + this.i0;
                int F = com.bumptech.glide.d.F(this);
                int i12 = bounds.left;
                if (F == 0) {
                    rectF.left = i12 + t9;
                    rectF.right = bounds.right - u3;
                } else {
                    rectF.left = i12 + u3;
                    rectF.right = bounds.right - t9;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
            r5.d dVar = mVar.f7997f;
            TextPaint textPaint2 = mVar.f7992a;
            if (dVar != null) {
                textPaint2.drawableState = getState();
                mVar.f7997f.e(this.f4731m0, textPaint2, mVar.f7993b);
            }
            textPaint2.setTextAlign(align);
            boolean z9 = Math.round(mVar.a(this.M.toString())) > Math.round(rectF.width());
            if (z9) {
                int save = canvas2.save();
                canvas2.clipRect(rectF);
                i11 = save;
            } else {
                i11 = 0;
            }
            CharSequence charSequence2 = this.M;
            if (z9 && this.J0 != null) {
                charSequence2 = TextUtils.ellipsize(charSequence2, textPaint2, rectF.width(), this.J0);
            }
            canvas.drawText(charSequence2, 0, charSequence2.length(), pointF.x, pointF.y, textPaint2);
            canvas2 = canvas;
            if (z9) {
                canvas2.restoreToCount(i11);
            }
        }
        if (X()) {
            rectF.setEmpty();
            if (X()) {
                float f21 = this.f4730l0 + this.f4729k0;
                if (com.bumptech.glide.d.F(this) == 0) {
                    float f22 = bounds.right - f21;
                    rectF.right = f22;
                    rectF.left = f22 - this.W;
                } else {
                    float f23 = bounds.left + f21;
                    rectF.left = f23;
                    rectF.right = f23 + this.W;
                }
                float exactCenterY = bounds.exactCenterY();
                float f24 = this.W;
                float f25 = exactCenterY - (f24 / 2.0f);
                rectF.top = f25;
                rectF.bottom = f25 + f24;
            }
            float f26 = rectF.left;
            float f27 = rectF.top;
            canvas2.translate(f26, f27);
            this.T.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            int[] iArr = s5.b.f8857a;
            this.U.setBounds(this.T.getBounds());
            this.U.jumpToCurrentState();
            this.U.draw(canvas2);
            canvas2.translate(-f26, -f27);
        }
        if (this.B0 < 255) {
            canvas2.restoreToCount(i10);
        }
    }

    @Override // u5.g, android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.B0;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.C0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.H;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.min(Math.round(u() + this.f4737s0.a(this.M.toString()) + t() + this.f4724e0 + this.f4727h0 + this.i0 + this.f4730l0), this.L0);
    }

    @Override // u5.g, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // u5.g, android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        Outline outline2;
        if (this.M0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline2 = outline;
            outline2.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.H, this.I);
        } else {
            outline.setRoundRect(bounds, this.I);
            outline2 = outline;
        }
        outline2.setAlpha(this.B0 / 255.0f);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // u5.g, android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        if (w(this.F) || w(this.G) || w(this.J)) {
            return true;
        }
        r5.d dVar = this.f4737s0.f7997f;
        if (dVar == null || (colorStateList = dVar.f8573j) == null || !colorStateList.isStateful()) {
            return (this.Z && this.f4720a0 != null && this.Y) || x(this.O) || x(this.f4720a0) || w(this.E0);
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i9) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i9);
        if (W()) {
            onLayoutDirectionChanged |= com.bumptech.glide.d.a0(this.O, i9);
        }
        if (V()) {
            onLayoutDirectionChanged |= com.bumptech.glide.d.a0(this.f4720a0, i9);
        }
        if (X()) {
            onLayoutDirectionChanged |= com.bumptech.glide.d.a0(this.T, i9);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i9) {
        boolean onLevelChange = super.onLevelChange(i9);
        if (W()) {
            onLevelChange |= this.O.setLevel(i9);
        }
        if (V()) {
            onLevelChange |= this.f4720a0.setLevel(i9);
        }
        if (X()) {
            onLevelChange |= this.T.setLevel(i9);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    @Override // u5.g, android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        if (this.M0) {
            super.onStateChange(iArr);
        }
        return z(iArr, this.G0);
    }

    public final void r(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        com.bumptech.glide.d.a0(drawable, com.bumptech.glide.d.F(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.T) {
            if (drawable.isStateful()) {
                drawable.setState(this.G0);
            }
            g0.b.h(drawable, this.V);
            return;
        }
        Drawable drawable2 = this.O;
        if (drawable == drawable2 && this.R) {
            g0.b.h(drawable2, this.P);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    public final void s(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (W() || V()) {
            float f9 = this.f4724e0 + this.f4725f0;
            Drawable drawable = this.f4744z0 ? this.f4720a0 : this.O;
            float f10 = this.Q;
            if (f10 <= 0.0f && drawable != null) {
                f10 = drawable.getIntrinsicWidth();
            }
            if (com.bumptech.glide.d.F(this) == 0) {
                float f11 = rect.left + f9;
                rectF.left = f11;
                rectF.right = f11 + f10;
            } else {
                float f12 = rect.right - f9;
                rectF.right = f12;
                rectF.left = f12 - f10;
            }
            Drawable drawable2 = this.f4744z0 ? this.f4720a0 : this.O;
            float f13 = this.Q;
            if (f13 <= 0.0f && drawable2 != null) {
                f13 = (float) Math.ceil(TypedValue.applyDimension(1, 24, this.f4731m0.getResources().getDisplayMetrics()));
                if (drawable2.getIntrinsicHeight() <= f13) {
                    f13 = drawable2.getIntrinsicHeight();
                }
            }
            float exactCenterY = rect.exactCenterY() - (f13 / 2.0f);
            rectF.top = exactCenterY;
            rectF.bottom = exactCenterY + f13;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j5) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j5);
        }
    }

    @Override // u5.g, android.graphics.drawable.Drawable
    public final void setAlpha(int i9) {
        if (this.B0 != i9) {
            this.B0 = i9;
            invalidateSelf();
        }
    }

    @Override // u5.g, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.C0 != colorFilter) {
            this.C0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // u5.g, android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        if (this.E0 != colorStateList) {
            this.E0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // u5.g, android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        if (this.F0 != mode) {
            this.F0 = mode;
            ColorStateList colorStateList = this.E0;
            this.D0 = (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z8, boolean z9) {
        boolean visible = super.setVisible(z8, z9);
        if (W()) {
            visible |= this.O.setVisible(z8, z9);
        }
        if (V()) {
            visible |= this.f4720a0.setVisible(z8, z9);
        }
        if (X()) {
            visible |= this.T.setVisible(z8, z9);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public final float t() {
        if (!W() && !V()) {
            return 0.0f;
        }
        float f9 = this.f4725f0;
        Drawable drawable = this.f4744z0 ? this.f4720a0 : this.O;
        float f10 = this.Q;
        if (f10 <= 0.0f && drawable != null) {
            f10 = drawable.getIntrinsicWidth();
        }
        return f10 + f9 + this.f4726g0;
    }

    public final float u() {
        if (X()) {
            return this.f4728j0 + this.W + this.f4729k0;
        }
        return 0.0f;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final float v() {
        return this.M0 ? g() : this.I;
    }

    public final void y() {
        d dVar = (d) this.I0.get();
        if (dVar != null) {
            Chip chip = (Chip) dVar;
            chip.b(chip.f1996y);
            chip.requestLayout();
            chip.invalidateOutline();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean z(int[] r9, int[] r10) {
        /*
            Method dump skipped, instructions count: 343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i5.e.z(int[], int[]):boolean");
    }
}
