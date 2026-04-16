package o5;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import com.google.android.material.textfield.TextInputLayout;
import java.util.WeakHashMap;
import n0.c0;
import n0.d0;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c {
    public CharSequence A;
    public CharSequence B;
    public boolean C;
    public Bitmap E;
    public float F;
    public float G;
    public float H;
    public float I;
    public float J;
    public int K;
    public int[] L;
    public boolean M;
    public final TextPaint N;
    public final TextPaint O;
    public TimeInterpolator P;
    public TimeInterpolator Q;
    public float R;
    public float S;
    public float T;
    public ColorStateList U;
    public float V;
    public float W;
    public float X;
    public StaticLayout Y;
    public float Z;

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f7938a;

    /* renamed from: a0, reason: collision with root package name */
    public float f7939a0;

    /* renamed from: b, reason: collision with root package name */
    public float f7940b;

    /* renamed from: b0, reason: collision with root package name */
    public float f7941b0;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f7942c;

    /* renamed from: c0, reason: collision with root package name */
    public CharSequence f7943c0;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f7944d;

    /* renamed from: e, reason: collision with root package name */
    public final RectF f7946e;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f7952j;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f7953k;

    /* renamed from: l, reason: collision with root package name */
    public float f7954l;

    /* renamed from: m, reason: collision with root package name */
    public float f7955m;

    /* renamed from: n, reason: collision with root package name */
    public float f7956n;

    /* renamed from: o, reason: collision with root package name */
    public float f7957o;

    /* renamed from: p, reason: collision with root package name */
    public float f7958p;

    /* renamed from: q, reason: collision with root package name */
    public float f7959q;

    /* renamed from: r, reason: collision with root package name */
    public Typeface f7960r;

    /* renamed from: s, reason: collision with root package name */
    public Typeface f7961s;

    /* renamed from: t, reason: collision with root package name */
    public Typeface f7962t;

    /* renamed from: u, reason: collision with root package name */
    public Typeface f7963u;

    /* renamed from: v, reason: collision with root package name */
    public Typeface f7964v;

    /* renamed from: w, reason: collision with root package name */
    public Typeface f7965w;

    /* renamed from: x, reason: collision with root package name */
    public Typeface f7966x;

    /* renamed from: y, reason: collision with root package name */
    public r5.a f7967y;

    /* renamed from: f, reason: collision with root package name */
    public int f7948f = 16;

    /* renamed from: g, reason: collision with root package name */
    public int f7950g = 16;
    public float h = 15.0f;

    /* renamed from: i, reason: collision with root package name */
    public float f7951i = 15.0f;

    /* renamed from: z, reason: collision with root package name */
    public final TextUtils.TruncateAt f7968z = TextUtils.TruncateAt.END;
    public final boolean D = true;

    /* renamed from: d0, reason: collision with root package name */
    public final int f7945d0 = 1;

    /* renamed from: e0, reason: collision with root package name */
    public final float f7947e0 = 1.0f;

    /* renamed from: f0, reason: collision with root package name */
    public final int f7949f0 = k.f7978l;

    public c(TextInputLayout textInputLayout) {
        this.f7938a = textInputLayout;
        TextPaint textPaint = new TextPaint(129);
        this.N = textPaint;
        this.O = new TextPaint(textPaint);
        this.f7944d = new Rect();
        this.f7942c = new Rect();
        this.f7946e = new RectF();
        g(textInputLayout.getContext().getResources().getConfiguration());
    }

    public static int a(float f9, int i9, int i10) {
        float f10 = 1.0f - f9;
        return Color.argb(Math.round((Color.alpha(i10) * f9) + (Color.alpha(i9) * f10)), Math.round((Color.red(i10) * f9) + (Color.red(i9) * f10)), Math.round((Color.green(i10) * f9) + (Color.green(i9) * f10)), Math.round((Color.blue(i10) * f9) + (Color.blue(i9) * f10)));
    }

    public static float f(float f9, float f10, float f11, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f11 = timeInterpolator.getInterpolation(f11);
        }
        return z4.a.a(f9, f10, f11);
    }

    public final boolean b(CharSequence charSequence) {
        WeakHashMap weakHashMap = t0.f7209a;
        boolean z8 = d0.d(this.f7938a) == 1;
        if (this.D) {
            return (z8 ? l0.i.f5756d : l0.i.f5755c).d(charSequence, charSequence.length());
        }
        return z8;
    }

    public final void c(float f9, boolean z8) {
        float f10;
        float f11;
        Typeface typeface;
        boolean z9;
        StaticLayout staticLayout;
        Layout.Alignment alignment;
        if (this.A == null) {
            return;
        }
        float width = this.f7944d.width();
        float width2 = this.f7942c.width();
        if (Math.abs(f9 - 1.0f) < 1.0E-5f) {
            f10 = this.f7951i;
            f11 = this.V;
            this.F = 1.0f;
            typeface = this.f7960r;
        } else {
            float f12 = this.h;
            float f13 = this.W;
            Typeface typeface2 = this.f7963u;
            if (Math.abs(f9 - 0.0f) < 1.0E-5f) {
                this.F = 1.0f;
            } else {
                this.F = f(this.h, this.f7951i, f9, this.Q) / this.h;
            }
            float f14 = this.f7951i / this.h;
            width = (!z8 && width2 * f14 > width) ? Math.min(width / f14, width2) : width2;
            f10 = f12;
            f11 = f13;
            typeface = typeface2;
        }
        TextPaint textPaint = this.N;
        if (width > 0.0f) {
            boolean z10 = this.G != f10;
            boolean z11 = this.X != f11;
            boolean z12 = this.f7966x != typeface;
            StaticLayout staticLayout2 = this.Y;
            z9 = z10 || z11 || (staticLayout2 != null && (width > ((float) staticLayout2.getWidth()) ? 1 : (width == ((float) staticLayout2.getWidth()) ? 0 : -1)) != 0) || z12 || this.M;
            this.G = f10;
            this.X = f11;
            this.f7966x = typeface;
            this.M = false;
            textPaint.setLinearText(this.F != 1.0f);
        } else {
            z9 = false;
        }
        if (this.B == null || z9) {
            textPaint.setTextSize(this.G);
            textPaint.setTypeface(this.f7966x);
            textPaint.setLetterSpacing(this.X);
            boolean b9 = b(this.A);
            this.C = b9;
            int i9 = this.f7945d0;
            if (i9 <= 1 || b9) {
                i9 = 1;
            }
            try {
                if (i9 == 1) {
                    alignment = Layout.Alignment.ALIGN_NORMAL;
                } else {
                    int absoluteGravity = Gravity.getAbsoluteGravity(this.f7948f, b9 ? 1 : 0) & 7;
                    if (absoluteGravity != 1) {
                        boolean z13 = this.C;
                        alignment = absoluteGravity != 5 ? z13 ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : z13 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE;
                    } else {
                        alignment = Layout.Alignment.ALIGN_CENTER;
                    }
                }
                k kVar = new k(this.A, textPaint, (int) width);
                kVar.f7991k = this.f7968z;
                kVar.f7990j = b9;
                kVar.f7986e = alignment;
                kVar.f7989i = false;
                kVar.f7987f = i9;
                kVar.f7988g = this.f7947e0;
                kVar.h = this.f7949f0;
                staticLayout = kVar.a();
            } catch (j e9) {
                Log.e("CollapsingTextHelper", e9.getCause().getMessage(), e9);
                staticLayout = null;
            }
            staticLayout.getClass();
            this.Y = staticLayout;
            this.B = staticLayout.getText();
        }
    }

    public final float d() {
        float f9 = this.f7951i;
        TextPaint textPaint = this.O;
        textPaint.setTextSize(f9);
        textPaint.setTypeface(this.f7960r);
        textPaint.setLetterSpacing(this.V);
        return -textPaint.ascent();
    }

    public final int e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.L;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public final void g(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.f7962t;
            if (typeface != null) {
                this.f7961s = android.support.v4.media.session.b.c0(configuration, typeface);
            }
            Typeface typeface2 = this.f7965w;
            if (typeface2 != null) {
                this.f7964v = android.support.v4.media.session.b.c0(configuration, typeface2);
            }
            Typeface typeface3 = this.f7961s;
            if (typeface3 == null) {
                typeface3 = this.f7962t;
            }
            this.f7960r = typeface3;
            Typeface typeface4 = this.f7964v;
            if (typeface4 == null) {
                typeface4 = this.f7965w;
            }
            this.f7963u = typeface4;
            h(true);
        }
    }

    public final void h(boolean z8) {
        float measureText;
        StaticLayout staticLayout;
        TextInputLayout textInputLayout = this.f7938a;
        if ((textInputLayout.getHeight() <= 0 || textInputLayout.getWidth() <= 0) && !z8) {
            return;
        }
        c(1.0f, z8);
        CharSequence charSequence = this.B;
        TextPaint textPaint = this.N;
        if (charSequence != null && (staticLayout = this.Y) != null) {
            this.f7943c0 = TextUtils.ellipsize(charSequence, textPaint, staticLayout.getWidth(), this.f7968z);
        }
        CharSequence charSequence2 = this.f7943c0;
        if (charSequence2 != null) {
            this.Z = textPaint.measureText(charSequence2, 0, charSequence2.length());
        } else {
            this.Z = 0.0f;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(this.f7950g, this.C ? 1 : 0);
        int i9 = absoluteGravity & 112;
        Rect rect = this.f7944d;
        if (i9 == 48) {
            this.f7955m = rect.top;
        } else if (i9 != 80) {
            this.f7955m = rect.centerY() - ((textPaint.descent() - textPaint.ascent()) / 2.0f);
        } else {
            this.f7955m = textPaint.ascent() + rect.bottom;
        }
        int i10 = absoluteGravity & 8388615;
        if (i10 == 1) {
            this.f7957o = rect.centerX() - (this.Z / 2.0f);
        } else if (i10 != 5) {
            this.f7957o = rect.left;
        } else {
            this.f7957o = rect.right - this.Z;
        }
        c(0.0f, z8);
        float height = this.Y != null ? r1.getHeight() : 0.0f;
        StaticLayout staticLayout2 = this.Y;
        if (staticLayout2 == null || this.f7945d0 <= 1) {
            CharSequence charSequence3 = this.B;
            measureText = charSequence3 != null ? textPaint.measureText(charSequence3, 0, charSequence3.length()) : 0.0f;
        } else {
            measureText = staticLayout2.getWidth();
        }
        StaticLayout staticLayout3 = this.Y;
        if (staticLayout3 != null) {
            staticLayout3.getLineCount();
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(this.f7948f, this.C ? 1 : 0);
        int i11 = absoluteGravity2 & 112;
        Rect rect2 = this.f7942c;
        if (i11 == 48) {
            this.f7954l = rect2.top;
        } else if (i11 != 80) {
            this.f7954l = rect2.centerY() - (height / 2.0f);
        } else {
            this.f7954l = textPaint.descent() + (rect2.bottom - height);
        }
        int i12 = absoluteGravity2 & 8388615;
        if (i12 == 1) {
            this.f7956n = rect2.centerX() - (measureText / 2.0f);
        } else if (i12 != 5) {
            this.f7956n = rect2.left;
        } else {
            this.f7956n = rect2.right - measureText;
        }
        Bitmap bitmap = this.E;
        if (bitmap != null) {
            bitmap.recycle();
            this.E = null;
        }
        l(this.f7940b);
        float f9 = this.f7940b;
        float f10 = f(rect2.left, rect.left, f9, this.P);
        RectF rectF = this.f7946e;
        rectF.left = f10;
        rectF.top = f(this.f7954l, this.f7955m, f9, this.P);
        rectF.right = f(rect2.right, rect.right, f9, this.P);
        rectF.bottom = f(rect2.bottom, rect.bottom, f9, this.P);
        this.f7958p = f(this.f7956n, this.f7957o, f9, this.P);
        this.f7959q = f(this.f7954l, this.f7955m, f9, this.P);
        l(f9);
        a1.a aVar = z4.a.f10660b;
        this.f7939a0 = 1.0f - f(0.0f, 1.0f, 1.0f - f9, aVar);
        WeakHashMap weakHashMap = t0.f7209a;
        c0.k(textInputLayout);
        this.f7941b0 = f(1.0f, 0.0f, f9, aVar);
        c0.k(textInputLayout);
        ColorStateList colorStateList = this.f7953k;
        ColorStateList colorStateList2 = this.f7952j;
        if (colorStateList != colorStateList2) {
            textPaint.setColor(a(f9, e(colorStateList2), e(this.f7953k)));
        } else {
            textPaint.setColor(e(colorStateList));
        }
        float f11 = this.V;
        float f12 = this.W;
        if (f11 != f12) {
            textPaint.setLetterSpacing(f(f12, f11, f9, aVar));
        } else {
            textPaint.setLetterSpacing(f11);
        }
        this.H = z4.a.a(0.0f, this.R, f9);
        this.I = z4.a.a(0.0f, this.S, f9);
        this.J = z4.a.a(0.0f, this.T, f9);
        int a9 = a(f9, 0, e(this.U));
        this.K = a9;
        textPaint.setShadowLayer(this.H, this.I, this.J, a9);
        c0.k(textInputLayout);
    }

    public final void i(ColorStateList colorStateList) {
        if (this.f7953k == colorStateList && this.f7952j == colorStateList) {
            return;
        }
        this.f7953k = colorStateList;
        this.f7952j = colorStateList;
        h(false);
    }

    public final boolean j(Typeface typeface) {
        r5.a aVar = this.f7967y;
        if (aVar != null) {
            aVar.f8559k = true;
        }
        if (this.f7962t == typeface) {
            return false;
        }
        this.f7962t = typeface;
        Typeface c02 = android.support.v4.media.session.b.c0(this.f7938a.getContext().getResources().getConfiguration(), typeface);
        this.f7961s = c02;
        if (c02 == null) {
            c02 = this.f7962t;
        }
        this.f7960r = c02;
        return true;
    }

    public final void k(float f9) {
        if (f9 < 0.0f) {
            f9 = 0.0f;
        } else if (f9 > 1.0f) {
            f9 = 1.0f;
        }
        if (f9 != this.f7940b) {
            this.f7940b = f9;
            float f10 = this.f7942c.left;
            Rect rect = this.f7944d;
            float f11 = f(f10, rect.left, f9, this.P);
            RectF rectF = this.f7946e;
            rectF.left = f11;
            rectF.top = f(this.f7954l, this.f7955m, f9, this.P);
            rectF.right = f(r2.right, rect.right, f9, this.P);
            rectF.bottom = f(r2.bottom, rect.bottom, f9, this.P);
            this.f7958p = f(this.f7956n, this.f7957o, f9, this.P);
            this.f7959q = f(this.f7954l, this.f7955m, f9, this.P);
            l(f9);
            a1.a aVar = z4.a.f10660b;
            this.f7939a0 = 1.0f - f(0.0f, 1.0f, 1.0f - f9, aVar);
            WeakHashMap weakHashMap = t0.f7209a;
            TextInputLayout textInputLayout = this.f7938a;
            c0.k(textInputLayout);
            this.f7941b0 = f(1.0f, 0.0f, f9, aVar);
            c0.k(textInputLayout);
            ColorStateList colorStateList = this.f7953k;
            ColorStateList colorStateList2 = this.f7952j;
            TextPaint textPaint = this.N;
            if (colorStateList != colorStateList2) {
                textPaint.setColor(a(f9, e(colorStateList2), e(this.f7953k)));
            } else {
                textPaint.setColor(e(colorStateList));
            }
            float f12 = this.V;
            float f13 = this.W;
            if (f12 != f13) {
                textPaint.setLetterSpacing(f(f13, f12, f9, aVar));
            } else {
                textPaint.setLetterSpacing(f12);
            }
            this.H = z4.a.a(0.0f, this.R, f9);
            this.I = z4.a.a(0.0f, this.S, f9);
            this.J = z4.a.a(0.0f, this.T, f9);
            int a9 = a(f9, 0, e(this.U));
            this.K = a9;
            textPaint.setShadowLayer(this.H, this.I, this.J, a9);
            c0.k(textInputLayout);
        }
    }

    public final void l(float f9) {
        c(f9, false);
        WeakHashMap weakHashMap = t0.f7209a;
        c0.k(this.f7938a);
    }

    public final void m(Typeface typeface) {
        boolean z8;
        boolean j5 = j(typeface);
        if (this.f7965w != typeface) {
            this.f7965w = typeface;
            Typeface c02 = android.support.v4.media.session.b.c0(this.f7938a.getContext().getResources().getConfiguration(), typeface);
            this.f7964v = c02;
            if (c02 == null) {
                c02 = this.f7965w;
            }
            this.f7963u = c02;
            z8 = true;
        } else {
            z8 = false;
        }
        if (j5 || z8) {
            h(false);
        }
    }
}
