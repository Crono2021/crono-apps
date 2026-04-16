package r5;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import android.util.TypedValue;
import e0.o;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final ColorStateList f8565a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8566b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8567c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8568d;

    /* renamed from: e, reason: collision with root package name */
    public final float f8569e;

    /* renamed from: f, reason: collision with root package name */
    public final float f8570f;

    /* renamed from: g, reason: collision with root package name */
    public final float f8571g;
    public final boolean h;

    /* renamed from: i, reason: collision with root package name */
    public final float f8572i;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f8573j;

    /* renamed from: k, reason: collision with root package name */
    public float f8574k;

    /* renamed from: l, reason: collision with root package name */
    public final int f8575l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f8576m = false;

    /* renamed from: n, reason: collision with root package name */
    public Typeface f8577n;

    public d(Context context, int i9) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i9, y4.a.F);
        this.f8574k = obtainStyledAttributes.getDimension(0, 0.0f);
        this.f8573j = com.bumptech.glide.d.B(context, obtainStyledAttributes, 3);
        com.bumptech.glide.d.B(context, obtainStyledAttributes, 4);
        com.bumptech.glide.d.B(context, obtainStyledAttributes, 5);
        this.f8567c = obtainStyledAttributes.getInt(2, 0);
        this.f8568d = obtainStyledAttributes.getInt(1, 1);
        int i10 = obtainStyledAttributes.hasValue(12) ? 12 : 10;
        this.f8575l = obtainStyledAttributes.getResourceId(i10, 0);
        this.f8566b = obtainStyledAttributes.getString(i10);
        obtainStyledAttributes.getBoolean(14, false);
        this.f8565a = com.bumptech.glide.d.B(context, obtainStyledAttributes, 6);
        this.f8569e = obtainStyledAttributes.getFloat(7, 0.0f);
        this.f8570f = obtainStyledAttributes.getFloat(8, 0.0f);
        this.f8571g = obtainStyledAttributes.getFloat(9, 0.0f);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i9, y4.a.f10517w);
        this.h = obtainStyledAttributes2.hasValue(0);
        this.f8572i = obtainStyledAttributes2.getFloat(0, 0.0f);
        obtainStyledAttributes2.recycle();
    }

    public final void a() {
        String str;
        Typeface typeface = this.f8577n;
        int i9 = this.f8567c;
        if (typeface == null && (str = this.f8566b) != null) {
            this.f8577n = Typeface.create(str, i9);
        }
        if (this.f8577n == null) {
            int i10 = this.f8568d;
            if (i10 == 1) {
                this.f8577n = Typeface.SANS_SERIF;
            } else if (i10 == 2) {
                this.f8577n = Typeface.SERIF;
            } else if (i10 != 3) {
                this.f8577n = Typeface.DEFAULT;
            } else {
                this.f8577n = Typeface.MONOSPACE;
            }
            this.f8577n = Typeface.create(this.f8577n, i9);
        }
    }

    public final Typeface b(Context context) {
        if (this.f8576m) {
            return this.f8577n;
        }
        if (!context.isRestricted()) {
            try {
                int i9 = this.f8575l;
                ThreadLocal threadLocal = o.f3001a;
                Typeface b9 = context.isRestricted() ? null : o.b(context, i9, new TypedValue(), 0, null, false, false);
                this.f8577n = b9;
                if (b9 != null) {
                    this.f8577n = Typeface.create(b9, this.f8567c);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e9) {
                Log.d("TextAppearance", "Error loading font " + this.f8566b, e9);
            }
        }
        a();
        this.f8576m = true;
        return this.f8577n;
    }

    public final void c(Context context, a.a aVar) {
        if (d(context)) {
            b(context);
        } else {
            a();
        }
        int i9 = this.f8575l;
        if (i9 == 0) {
            this.f8576m = true;
        }
        if (this.f8576m) {
            aVar.E(this.f8577n, true);
            return;
        }
        try {
            b bVar = new b(this, aVar);
            ThreadLocal threadLocal = o.f3001a;
            if (context.isRestricted()) {
                bVar.a(-4);
            } else {
                o.b(context, i9, new TypedValue(), 0, bVar, false, false);
            }
        } catch (Resources.NotFoundException unused) {
            this.f8576m = true;
            aVar.D(1);
        } catch (Exception e9) {
            Log.d("TextAppearance", "Error loading font " + this.f8566b, e9);
            this.f8576m = true;
            aVar.D(-3);
        }
    }

    public final boolean d(Context context) {
        Typeface typeface = null;
        int i9 = this.f8575l;
        if (i9 != 0) {
            ThreadLocal threadLocal = o.f3001a;
            if (!context.isRestricted()) {
                typeface = o.b(context, i9, new TypedValue(), 0, null, false, true);
            }
        }
        return typeface != null;
    }

    public final void e(Context context, TextPaint textPaint, a.a aVar) {
        f(context, textPaint, aVar);
        ColorStateList colorStateList = this.f8573j;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        ColorStateList colorStateList2 = this.f8565a;
        textPaint.setShadowLayer(this.f8571g, this.f8569e, this.f8570f, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public final void f(Context context, TextPaint textPaint, a.a aVar) {
        if (d(context)) {
            g(context, textPaint, b(context));
            return;
        }
        a();
        g(context, textPaint, this.f8577n);
        c(context, new c(this, context, textPaint, aVar));
    }

    public final void g(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface c02 = android.support.v4.media.session.b.c0(context.getResources().getConfiguration(), typeface);
        if (c02 != null) {
            typeface = c02;
        }
        textPaint.setTypeface(typeface);
        int i9 = (~typeface.getStyle()) & this.f8567c;
        textPaint.setFakeBoldText((i9 & 1) != 0);
        textPaint.setTextSkewX((i9 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f8574k);
        if (this.h) {
            textPaint.setLetterSpacing(this.f8572i);
        }
    }
}
