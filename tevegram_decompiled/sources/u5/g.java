package u5;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import i7.x;
import java.util.BitSet;
import l1.v0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class g extends Drawable implements g0.e, t {
    public static final Paint E;
    public PorterDuffColorFilter A;
    public PorterDuffColorFilter B;
    public final RectF C;
    public boolean D;

    /* renamed from: i, reason: collision with root package name */
    public f f9084i;

    /* renamed from: j, reason: collision with root package name */
    public final r[] f9085j;

    /* renamed from: k, reason: collision with root package name */
    public final r[] f9086k;

    /* renamed from: l, reason: collision with root package name */
    public final BitSet f9087l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f9088m;

    /* renamed from: n, reason: collision with root package name */
    public final Matrix f9089n;

    /* renamed from: o, reason: collision with root package name */
    public final Path f9090o;

    /* renamed from: p, reason: collision with root package name */
    public final Path f9091p;

    /* renamed from: q, reason: collision with root package name */
    public final RectF f9092q;

    /* renamed from: r, reason: collision with root package name */
    public final RectF f9093r;

    /* renamed from: s, reason: collision with root package name */
    public final Region f9094s;

    /* renamed from: t, reason: collision with root package name */
    public final Region f9095t;

    /* renamed from: u, reason: collision with root package name */
    public j f9096u;

    /* renamed from: v, reason: collision with root package name */
    public final Paint f9097v;

    /* renamed from: w, reason: collision with root package name */
    public final Paint f9098w;

    /* renamed from: x, reason: collision with root package name */
    public final t5.a f9099x;

    /* renamed from: y, reason: collision with root package name */
    public final x f9100y;

    /* renamed from: z, reason: collision with root package name */
    public final v0 f9101z;

    static {
        Paint paint = new Paint(1);
        E = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public g(f fVar) {
        this.f9085j = new r[4];
        this.f9086k = new r[4];
        this.f9087l = new BitSet(8);
        this.f9089n = new Matrix();
        this.f9090o = new Path();
        this.f9091p = new Path();
        this.f9092q = new RectF();
        this.f9093r = new RectF();
        this.f9094s = new Region();
        this.f9095t = new Region();
        Paint paint = new Paint(1);
        this.f9097v = paint;
        Paint paint2 = new Paint(1);
        this.f9098w = paint2;
        this.f9099x = new t5.a();
        this.f9101z = Looper.getMainLooper().getThread() == Thread.currentThread() ? k.f9114a : new v0();
        this.C = new RectF();
        this.D = true;
        this.f9084i = fVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        p();
        o(getState());
        this.f9100y = new x(this, 25);
    }

    public final void a(RectF rectF, Path path) {
        f fVar = this.f9084i;
        this.f9101z.b(fVar.f9069a, fVar.f9076i, rectF, this.f9100y, path);
        if (this.f9084i.h != 1.0f) {
            Matrix matrix = this.f9089n;
            matrix.reset();
            float f9 = this.f9084i.h;
            matrix.setScale(f9, f9, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(matrix);
        }
        path.computeBounds(this.C, true);
    }

    public final int b(int i9) {
        int i10;
        f fVar = this.f9084i;
        float f9 = fVar.f9080m + 0.0f + fVar.f9079l;
        m5.a aVar = fVar.f9070b;
        if (aVar == null || !aVar.f6648a || f0.a.d(i9, 255) != aVar.f6651d) {
            return i9;
        }
        float min = (aVar.f6652e <= 0.0f || f9 <= 0.0f) ? 0.0f : Math.min(((((float) Math.log1p(f9 / r4)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        int alpha = Color.alpha(i9);
        int H = com.bumptech.glide.c.H(min, f0.a.d(i9, 255), aVar.f6649b);
        if (min > 0.0f && (i10 = aVar.f6650c) != 0) {
            H = f0.a.b(f0.a.d(i10, m5.a.f6647f), H);
        }
        return f0.a.d(H, alpha);
    }

    public final void c(Canvas canvas) {
        if (this.f9087l.cardinality() > 0) {
            Log.w("g", "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        int i9 = this.f9084i.f9082o;
        Path path = this.f9090o;
        t5.a aVar = this.f9099x;
        if (i9 != 0) {
            canvas.drawPath(path, aVar.f8973a);
        }
        for (int i10 = 0; i10 < 4; i10++) {
            r rVar = this.f9085j[i10];
            int i11 = this.f9084i.f9081n;
            Matrix matrix = r.f9130b;
            rVar.a(matrix, aVar, i11, canvas);
            this.f9086k[i10].a(matrix, aVar, this.f9084i.f9081n, canvas);
        }
        if (this.D) {
            double d9 = 0;
            int sin = (int) (Math.sin(Math.toRadians(d9)) * this.f9084i.f9082o);
            int cos = (int) (Math.cos(Math.toRadians(d9)) * this.f9084i.f9082o);
            canvas.translate(-sin, -cos);
            canvas.drawPath(path, E);
            canvas.translate(sin, cos);
        }
    }

    public final void d(Canvas canvas, Paint paint, Path path, j jVar, RectF rectF) {
        if (!jVar.d(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float a9 = jVar.f9108f.a(rectF) * this.f9084i.f9076i;
            canvas.drawRoundRect(rectF, a9, a9, paint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        PorterDuffColorFilter porterDuffColorFilter = this.A;
        Paint paint = this.f9097v;
        paint.setColorFilter(porterDuffColorFilter);
        int alpha = paint.getAlpha();
        int i9 = this.f9084i.f9078k;
        paint.setAlpha(((i9 + (i9 >>> 7)) * alpha) >>> 8);
        PorterDuffColorFilter porterDuffColorFilter2 = this.B;
        Paint paint2 = this.f9098w;
        paint2.setColorFilter(porterDuffColorFilter2);
        paint2.setStrokeWidth(this.f9084i.f9077j);
        int alpha2 = paint2.getAlpha();
        int i10 = this.f9084i.f9078k;
        paint2.setAlpha(((i10 + (i10 >>> 7)) * alpha2) >>> 8);
        boolean z8 = this.f9088m;
        Path path = this.f9090o;
        if (z8) {
            float f9 = -(h() ? paint2.getStrokeWidth() / 2.0f : 0.0f);
            j jVar = this.f9084i.f9069a;
            c7.b e9 = jVar.e();
            c cVar = jVar.f9107e;
            if (!(cVar instanceof h)) {
                cVar = new b(f9, cVar);
            }
            e9.f1652f = cVar;
            c cVar2 = jVar.f9108f;
            if (!(cVar2 instanceof h)) {
                cVar2 = new b(f9, cVar2);
            }
            e9.f1653g = cVar2;
            c cVar3 = jVar.h;
            if (!(cVar3 instanceof h)) {
                cVar3 = new b(f9, cVar3);
            }
            e9.f1654i = cVar3;
            c cVar4 = jVar.f9109g;
            if (!(cVar4 instanceof h)) {
                cVar4 = new b(f9, cVar4);
            }
            e9.h = cVar4;
            j a9 = e9.a();
            this.f9096u = a9;
            float f10 = this.f9084i.f9076i;
            RectF f11 = f();
            RectF rectF = this.f9093r;
            rectF.set(f11);
            float strokeWidth = h() ? paint2.getStrokeWidth() / 2.0f : 0.0f;
            rectF.inset(strokeWidth, strokeWidth);
            this.f9101z.b(a9, f10, rectF, null, this.f9091p);
            a(f(), path);
            this.f9088m = false;
        }
        f fVar = this.f9084i;
        fVar.getClass();
        if (fVar.f9081n > 0 && !j() && !path.isConvex() && Build.VERSION.SDK_INT < 29) {
            canvas.save();
            double d9 = 0;
            canvas.translate((int) (Math.sin(Math.toRadians(d9)) * this.f9084i.f9082o), (int) (Math.cos(Math.toRadians(d9)) * this.f9084i.f9082o));
            if (this.D) {
                RectF rectF2 = this.C;
                int width = (int) (rectF2.width() - getBounds().width());
                int height = (int) (rectF2.height() - getBounds().height());
                if (width < 0 || height < 0) {
                    m7.c.p("Invalid shadow bounds. Check that the treatments result in a valid path.");
                    return;
                }
                Bitmap createBitmap = Bitmap.createBitmap((this.f9084i.f9081n * 2) + ((int) rectF2.width()) + width, (this.f9084i.f9081n * 2) + ((int) rectF2.height()) + height, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap);
                float f12 = (getBounds().left - this.f9084i.f9081n) - width;
                float f13 = (getBounds().top - this.f9084i.f9081n) - height;
                canvas2.translate(-f12, -f13);
                c(canvas2);
                canvas.drawBitmap(createBitmap, f12, f13, (Paint) null);
                createBitmap.recycle();
                canvas.restore();
            } else {
                c(canvas);
                canvas.restore();
            }
        }
        f fVar2 = this.f9084i;
        Paint.Style style = fVar2.f9083p;
        if (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL) {
            d(canvas, paint, path, fVar2.f9069a, f());
        }
        if (h()) {
            e(canvas);
        }
        paint.setAlpha(alpha);
        paint2.setAlpha(alpha2);
    }

    public void e(Canvas canvas) {
        j jVar = this.f9096u;
        RectF f9 = f();
        RectF rectF = this.f9093r;
        rectF.set(f9);
        boolean h = h();
        Paint paint = this.f9098w;
        float strokeWidth = h ? paint.getStrokeWidth() / 2.0f : 0.0f;
        rectF.inset(strokeWidth, strokeWidth);
        d(canvas, paint, this.f9091p, jVar, rectF);
    }

    public final RectF f() {
        Rect bounds = getBounds();
        RectF rectF = this.f9092q;
        rectF.set(bounds);
        return rectF;
    }

    public final float g() {
        return this.f9084i.f9069a.f9107e.a(f());
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f9084i.f9078k;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f9084i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.f9084i.getClass();
        if (j()) {
            outline.setRoundRect(getBounds(), g() * this.f9084i.f9076i);
            return;
        }
        RectF f9 = f();
        Path path = this.f9090o;
        a(f9, path);
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 30) {
            outline.setPath(path);
            return;
        }
        if (i9 >= 29) {
            try {
                outline.setConvexPath(path);
            } catch (IllegalArgumentException unused) {
            }
        } else if (path.isConvex()) {
            outline.setConvexPath(path);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        Rect rect2 = this.f9084i.f9075g;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        Rect bounds = getBounds();
        Region region = this.f9094s;
        region.set(bounds);
        RectF f9 = f();
        Path path = this.f9090o;
        a(f9, path);
        Region region2 = this.f9095t;
        region2.setPath(path, region);
        region.op(region2, Region.Op.DIFFERENCE);
        return region;
    }

    public final boolean h() {
        Paint.Style style = this.f9084i.f9083p;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f9098w.getStrokeWidth() > 0.0f;
    }

    public final void i(Context context) {
        this.f9084i.f9070b = new m5.a(context);
        q();
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        this.f9088m = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        ColorStateList colorStateList = this.f9084i.f9073e;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        this.f9084i.getClass();
        ColorStateList colorStateList2 = this.f9084i.f9072d;
        if (colorStateList2 != null && colorStateList2.isStateful()) {
            return true;
        }
        ColorStateList colorStateList3 = this.f9084i.f9071c;
        return colorStateList3 != null && colorStateList3.isStateful();
    }

    public final boolean j() {
        return this.f9084i.f9069a.d(f());
    }

    public final void k(float f9) {
        f fVar = this.f9084i;
        if (fVar.f9080m != f9) {
            fVar.f9080m = f9;
            q();
        }
    }

    public final void l(ColorStateList colorStateList) {
        f fVar = this.f9084i;
        if (fVar.f9071c != colorStateList) {
            fVar.f9071c = colorStateList;
            onStateChange(getState());
        }
    }

    public final void m(float f9) {
        f fVar = this.f9084i;
        if (fVar.f9076i != f9) {
            fVar.f9076i = f9;
            this.f9088m = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f9084i = new f(this.f9084i);
        return this;
    }

    public final void n() {
        this.f9099x.a(-12303292);
        this.f9084i.getClass();
        super.invalidateSelf();
    }

    public final boolean o(int[] iArr) {
        boolean z8;
        Paint paint;
        int color;
        int colorForState;
        Paint paint2;
        int color2;
        int colorForState2;
        if (this.f9084i.f9071c == null || color2 == (colorForState2 = this.f9084i.f9071c.getColorForState(iArr, (color2 = (paint2 = this.f9097v).getColor())))) {
            z8 = false;
        } else {
            paint2.setColor(colorForState2);
            z8 = true;
        }
        if (this.f9084i.f9072d == null || color == (colorForState = this.f9084i.f9072d.getColorForState(iArr, (color = (paint = this.f9098w).getColor())))) {
            return z8;
        }
        paint.setColor(colorForState);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.f9088m = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z8 = o(iArr) || p();
        if (z8) {
            invalidateSelf();
        }
        return z8;
    }

    public final boolean p() {
        PorterDuffColorFilter porterDuffColorFilter;
        PorterDuffColorFilter porterDuffColorFilter2 = this.A;
        PorterDuffColorFilter porterDuffColorFilter3 = this.B;
        f fVar = this.f9084i;
        ColorStateList colorStateList = fVar.f9073e;
        PorterDuff.Mode mode = fVar.f9074f;
        if (colorStateList == null || mode == null) {
            int color = this.f9097v.getColor();
            int b9 = b(color);
            porterDuffColorFilter = b9 != color ? new PorterDuffColorFilter(b9, PorterDuff.Mode.SRC_IN) : null;
        } else {
            porterDuffColorFilter = new PorterDuffColorFilter(b(colorStateList.getColorForState(getState(), 0)), mode);
        }
        this.A = porterDuffColorFilter;
        this.f9084i.getClass();
        this.B = null;
        this.f9084i.getClass();
        return (m0.a.a(porterDuffColorFilter2, this.A) && m0.a.a(porterDuffColorFilter3, this.B)) ? false : true;
    }

    public final void q() {
        f fVar = this.f9084i;
        float f9 = fVar.f9080m + 0.0f;
        fVar.f9081n = (int) Math.ceil(0.75f * f9);
        this.f9084i.f9082o = (int) Math.ceil(f9 * 0.25f);
        p();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i9) {
        f fVar = this.f9084i;
        if (fVar.f9078k != i9) {
            fVar.f9078k = i9;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f9084i.getClass();
        super.invalidateSelf();
    }

    @Override // u5.t
    public final void setShapeAppearanceModel(j jVar) {
        this.f9084i.f9069a = jVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i9) {
        setTintList(ColorStateList.valueOf(i9));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f9084i.f9073e = colorStateList;
        p();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        f fVar = this.f9084i;
        if (fVar.f9074f != mode) {
            fVar.f9074f = mode;
            p();
            super.invalidateSelf();
        }
    }

    public g(Context context, AttributeSet attributeSet, int i9, int i10) {
        this(j.b(context, attributeSet, i9, i10).a());
    }

    public g(j jVar) {
        this(new f(jVar));
    }

    public g() {
        this(new j());
    }
}
