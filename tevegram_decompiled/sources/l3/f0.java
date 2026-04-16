package l3;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f0 {
    public int A;
    public int B;
    public int C;
    public int D;
    public StaticLayout E;
    public StaticLayout F;
    public int G;
    public int H;
    public int I;
    public Rect J;

    /* renamed from: a, reason: collision with root package name */
    public final float f6130a;

    /* renamed from: b, reason: collision with root package name */
    public final float f6131b;

    /* renamed from: c, reason: collision with root package name */
    public final float f6132c;

    /* renamed from: d, reason: collision with root package name */
    public final float f6133d;

    /* renamed from: e, reason: collision with root package name */
    public final float f6134e;

    /* renamed from: f, reason: collision with root package name */
    public final TextPaint f6135f;

    /* renamed from: g, reason: collision with root package name */
    public final Paint f6136g;
    public final Paint h;

    /* renamed from: i, reason: collision with root package name */
    public CharSequence f6137i;

    /* renamed from: j, reason: collision with root package name */
    public Layout.Alignment f6138j;

    /* renamed from: k, reason: collision with root package name */
    public Bitmap f6139k;

    /* renamed from: l, reason: collision with root package name */
    public float f6140l;

    /* renamed from: m, reason: collision with root package name */
    public int f6141m;

    /* renamed from: n, reason: collision with root package name */
    public int f6142n;

    /* renamed from: o, reason: collision with root package name */
    public float f6143o;

    /* renamed from: p, reason: collision with root package name */
    public int f6144p;

    /* renamed from: q, reason: collision with root package name */
    public float f6145q;

    /* renamed from: r, reason: collision with root package name */
    public float f6146r;

    /* renamed from: s, reason: collision with root package name */
    public int f6147s;

    /* renamed from: t, reason: collision with root package name */
    public int f6148t;

    /* renamed from: u, reason: collision with root package name */
    public int f6149u;

    /* renamed from: v, reason: collision with root package name */
    public int f6150v;

    /* renamed from: w, reason: collision with root package name */
    public int f6151w;

    /* renamed from: x, reason: collision with root package name */
    public float f6152x;

    /* renamed from: y, reason: collision with root package name */
    public float f6153y;

    /* renamed from: z, reason: collision with root package name */
    public float f6154z;

    public f0(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{R.attr.lineSpacingExtra, R.attr.lineSpacingMultiplier}, 0, 0);
        this.f6134e = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f6133d = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        float round = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.f6130a = round;
        this.f6131b = round;
        this.f6132c = round;
        TextPaint textPaint = new TextPaint();
        this.f6135f = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.f6136g = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.h = paint2;
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
    }

    public final void a(Canvas canvas, boolean z8) {
        Canvas canvas2;
        if (!z8) {
            this.J.getClass();
            this.f6139k.getClass();
            canvas.drawBitmap(this.f6139k, (Rect) null, this.J, this.h);
            return;
        }
        StaticLayout staticLayout = this.E;
        StaticLayout staticLayout2 = this.F;
        if (staticLayout == null || staticLayout2 == null) {
            return;
        }
        int save = canvas.save();
        canvas.translate(this.G, this.H);
        if (Color.alpha(this.f6149u) > 0) {
            int i9 = this.f6149u;
            Paint paint = this.f6136g;
            paint.setColor(i9);
            canvas2 = canvas;
            canvas2.drawRect(-this.I, 0.0f, staticLayout.getWidth() + this.I, staticLayout.getHeight(), paint);
        } else {
            canvas2 = canvas;
        }
        int i10 = this.f6151w;
        TextPaint textPaint = this.f6135f;
        if (i10 == 1) {
            textPaint.setStrokeJoin(Paint.Join.ROUND);
            textPaint.setStrokeWidth(this.f6130a);
            textPaint.setColor(this.f6150v);
            textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            staticLayout2.draw(canvas2);
        } else {
            float f9 = this.f6131b;
            if (i10 == 2) {
                float f10 = this.f6132c;
                textPaint.setShadowLayer(f9, f10, f10, this.f6150v);
            } else if (i10 == 3 || i10 == 4) {
                boolean z9 = i10 == 3;
                int i11 = z9 ? -1 : this.f6150v;
                int i12 = z9 ? this.f6150v : -1;
                float f11 = f9 / 2.0f;
                textPaint.setColor(this.f6147s);
                textPaint.setStyle(Paint.Style.FILL);
                float f12 = -f11;
                textPaint.setShadowLayer(f9, f12, f12, i11);
                staticLayout2.draw(canvas2);
                textPaint.setShadowLayer(f9, f11, f11, i12);
            }
        }
        textPaint.setColor(this.f6147s);
        textPaint.setStyle(Paint.Style.FILL);
        staticLayout.draw(canvas2);
        textPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        canvas2.restoreToCount(save);
    }
}
