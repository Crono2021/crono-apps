package t3;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e extends Drawable implements Animatable {

    /* renamed from: o, reason: collision with root package name */
    public static final LinearInterpolator f8944o = new LinearInterpolator();

    /* renamed from: p, reason: collision with root package name */
    public static final a1.a f8945p = new a1.a(1);

    /* renamed from: q, reason: collision with root package name */
    public static final int[] f8946q = {-16777216};

    /* renamed from: i, reason: collision with root package name */
    public final d f8947i;

    /* renamed from: j, reason: collision with root package name */
    public float f8948j;

    /* renamed from: k, reason: collision with root package name */
    public final Resources f8949k;

    /* renamed from: l, reason: collision with root package name */
    public final ValueAnimator f8950l;

    /* renamed from: m, reason: collision with root package name */
    public float f8951m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f8952n;

    public e(Context context) {
        context.getClass();
        this.f8949k = context.getResources();
        d dVar = new d();
        this.f8947i = dVar;
        dVar.f8931i = f8946q;
        dVar.a(0);
        dVar.h = 2.5f;
        dVar.f8925b.setStrokeWidth(2.5f);
        invalidateSelf();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new b(this, dVar));
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(f8944o);
        ofFloat.addListener(new c(this, dVar));
        this.f8950l = ofFloat;
    }

    public static void d(float f9, d dVar) {
        if (f9 <= 0.75f) {
            dVar.f8943u = dVar.f8931i[dVar.f8932j];
            return;
        }
        float f10 = (f9 - 0.75f) / 0.25f;
        int[] iArr = dVar.f8931i;
        int i9 = dVar.f8932j;
        int i10 = iArr[i9];
        int i11 = iArr[(i9 + 1) % iArr.length];
        dVar.f8943u = ((((i10 >> 24) & 255) + ((int) ((((i11 >> 24) & 255) - r1) * f10))) << 24) | ((((i10 >> 16) & 255) + ((int) ((((i11 >> 16) & 255) - r3) * f10))) << 16) | ((((i10 >> 8) & 255) + ((int) ((((i11 >> 8) & 255) - r4) * f10))) << 8) | ((i10 & 255) + ((int) (f10 * ((i11 & 255) - r2))));
    }

    public final void a(float f9, d dVar, boolean z8) {
        float f10;
        if (this.f8952n) {
            d(f9, dVar);
            float floor = (float) (Math.floor(dVar.f8935m / 0.8f) + 1.0d);
            float f11 = dVar.f8933k;
            float f12 = dVar.f8934l;
            dVar.f8928e = (((f12 - 0.01f) - f11) * f9) + f11;
            dVar.f8929f = f12;
            float f13 = dVar.f8935m;
            dVar.f8930g = ((floor - f13) * f9) + f13;
            return;
        }
        if (f9 != 1.0f || z8) {
            float f14 = dVar.f8935m;
            a1.a aVar = f8945p;
            float f15 = dVar.f8933k;
            if (f9 < 0.5f) {
                f10 = (aVar.getInterpolation(f9 / 0.5f) * 0.79f) + 0.01f + f15;
            } else {
                float f16 = f15 + 0.79f;
                f15 = f16 - (((1.0f - aVar.getInterpolation((f9 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                f10 = f16;
            }
            float f17 = (0.20999998f * f9) + f14;
            float f18 = (f9 + this.f8951m) * 216.0f;
            dVar.f8928e = f15;
            dVar.f8929f = f10;
            dVar.f8930g = f17;
            this.f8948j = f18;
        }
    }

    public final void b(float f9, float f10, float f11, float f12) {
        float f13 = this.f8949k.getDisplayMetrics().density;
        float f14 = f10 * f13;
        d dVar = this.f8947i;
        dVar.h = f14;
        dVar.f8925b.setStrokeWidth(f14);
        dVar.f8939q = f9 * f13;
        dVar.a(0);
        dVar.f8940r = (int) (f11 * f13);
        dVar.f8941s = (int) (f12 * f13);
    }

    public final void c(int i9) {
        if (i9 == 0) {
            b(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            b(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f8948j, bounds.exactCenterX(), bounds.exactCenterY());
        d dVar = this.f8947i;
        Paint paint = dVar.f8925b;
        RectF rectF = dVar.f8924a;
        float f9 = dVar.f8939q;
        float f10 = (dVar.h / 2.0f) + f9;
        if (f9 <= 0.0f) {
            f10 = (Math.min(bounds.width(), bounds.height()) / 2.0f) - Math.max((dVar.f8940r * dVar.f8938p) / 2.0f, dVar.h / 2.0f);
        }
        rectF.set(bounds.centerX() - f10, bounds.centerY() - f10, bounds.centerX() + f10, bounds.centerY() + f10);
        float f11 = dVar.f8928e;
        float f12 = dVar.f8930g;
        float f13 = (f11 + f12) * 360.0f;
        float f14 = ((dVar.f8929f + f12) * 360.0f) - f13;
        paint.setColor(dVar.f8943u);
        paint.setAlpha(dVar.f8942t);
        float f15 = dVar.h / 2.0f;
        rectF.inset(f15, f15);
        canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, dVar.f8927d);
        float f16 = -f15;
        rectF.inset(f16, f16);
        canvas.drawArc(rectF, f13, f14, false, paint);
        Paint paint2 = dVar.f8926c;
        if (dVar.f8936n) {
            Path path = dVar.f8937o;
            if (path == null) {
                Path path2 = new Path();
                dVar.f8937o = path2;
                path2.setFillType(Path.FillType.EVEN_ODD);
            } else {
                path.reset();
            }
            float min = Math.min(rectF.width(), rectF.height()) / 2.0f;
            float f17 = (dVar.f8940r * dVar.f8938p) / 2.0f;
            dVar.f8937o.moveTo(0.0f, 0.0f);
            dVar.f8937o.lineTo(dVar.f8940r * dVar.f8938p, 0.0f);
            Path path3 = dVar.f8937o;
            float f18 = dVar.f8940r;
            float f19 = dVar.f8938p;
            path3.lineTo((f18 * f19) / 2.0f, dVar.f8941s * f19);
            dVar.f8937o.offset((rectF.centerX() + min) - f17, (dVar.h / 2.0f) + rectF.centerY());
            dVar.f8937o.close();
            paint2.setColor(dVar.f8943u);
            paint2.setAlpha(dVar.f8942t);
            canvas.save();
            canvas.rotate(f13 + f14, rectF.centerX(), rectF.centerY());
            canvas.drawPath(dVar.f8937o, paint2);
            canvas.restore();
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f8947i.f8942t;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.f8950l.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i9) {
        this.f8947i.f8942t = i9;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f8947i.f8925b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        this.f8950l.cancel();
        d dVar = this.f8947i;
        float f9 = dVar.f8928e;
        dVar.f8933k = f9;
        float f10 = dVar.f8929f;
        dVar.f8934l = f10;
        dVar.f8935m = dVar.f8930g;
        if (f10 != f9) {
            this.f8952n = true;
            this.f8950l.setDuration(666L);
            this.f8950l.start();
            return;
        }
        dVar.a(0);
        dVar.f8933k = 0.0f;
        dVar.f8934l = 0.0f;
        dVar.f8935m = 0.0f;
        dVar.f8928e = 0.0f;
        dVar.f8929f = 0.0f;
        dVar.f8930g = 0.0f;
        this.f8950l.setDuration(1332L);
        this.f8950l.start();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f8950l.cancel();
        this.f8948j = 0.0f;
        d dVar = this.f8947i;
        if (dVar.f8936n) {
            dVar.f8936n = false;
        }
        dVar.a(0);
        dVar.f8933k = 0.0f;
        dVar.f8934l = 0.0f;
        dVar.f8935m = 0.0f;
        dVar.f8928e = 0.0f;
        dVar.f8929f = 0.0f;
        dVar.f8930g = 0.0f;
        invalidateSelf();
    }
}
