package r;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public float f8477a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f8478b;

    /* renamed from: c, reason: collision with root package name */
    public final RectF f8479c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f8480d;

    /* renamed from: e, reason: collision with root package name */
    public float f8481e;
    public ColorStateList h;

    /* renamed from: i, reason: collision with root package name */
    public PorterDuffColorFilter f8484i;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f8485j;

    /* renamed from: f, reason: collision with root package name */
    public boolean f8482f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f8483g = true;

    /* renamed from: k, reason: collision with root package name */
    public PorterDuff.Mode f8486k = PorterDuff.Mode.SRC_IN;

    public a(ColorStateList colorStateList, float f9) {
        this.f8477a = f9;
        Paint paint = new Paint(5);
        this.f8478b = paint;
        colorStateList = colorStateList == null ? ColorStateList.valueOf(0) : colorStateList;
        this.h = colorStateList;
        paint.setColor(colorStateList.getColorForState(getState(), this.h.getDefaultColor()));
        this.f8479c = new RectF();
        this.f8480d = new Rect();
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public final void b(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        float f9 = rect.left;
        float f10 = rect.top;
        float f11 = rect.right;
        float f12 = rect.bottom;
        RectF rectF = this.f8479c;
        rectF.set(f9, f10, f11, f12);
        Rect rect2 = this.f8480d;
        rect2.set(rect);
        if (this.f8482f) {
            rect2.inset((int) Math.ceil(b.a(this.f8481e, this.f8477a, this.f8483g)), (int) Math.ceil(b.b(this.f8481e, this.f8477a, this.f8483g)));
            rectF.set(rect2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        boolean z8;
        PorterDuffColorFilter porterDuffColorFilter = this.f8484i;
        Paint paint = this.f8478b;
        if (porterDuffColorFilter == null || paint.getColorFilter() != null) {
            z8 = false;
        } else {
            paint.setColorFilter(this.f8484i);
            z8 = true;
        }
        RectF rectF = this.f8479c;
        float f9 = this.f8477a;
        canvas.drawRoundRect(rectF, f9, f9, paint);
        if (z8) {
            paint.setColorFilter(null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        outline.setRoundRect(this.f8480d, this.f8477a);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList = this.f8485j;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        ColorStateList colorStateList2 = this.h;
        return (colorStateList2 != null && colorStateList2.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        b(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        Paint paint = this.f8478b;
        boolean z8 = colorForState != paint.getColor();
        if (z8) {
            paint.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f8485j;
        if (colorStateList2 == null || (mode = this.f8486k) == null) {
            return z8;
        }
        this.f8484i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i9) {
        this.f8478b.setAlpha(i9);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f8478b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        this.f8485j = colorStateList;
        this.f8484i = a(colorStateList, this.f8486k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        this.f8486k = mode;
        this.f8484i = a(this.f8485j, mode);
        invalidateSelf();
    }
}
