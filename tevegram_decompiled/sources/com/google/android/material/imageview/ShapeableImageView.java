package com.google.android.material.imageview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.bumptech.glide.d;
import l1.v0;
import n.y;
import u5.g;
import u5.j;
import u5.k;
import u5.t;
import z5.a;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class ShapeableImageView extends y implements t {
    public final int A;
    public final int B;
    public boolean C;

    /* renamed from: l, reason: collision with root package name */
    public final v0 f2083l;

    /* renamed from: m, reason: collision with root package name */
    public final RectF f2084m;

    /* renamed from: n, reason: collision with root package name */
    public final RectF f2085n;

    /* renamed from: o, reason: collision with root package name */
    public final Paint f2086o;

    /* renamed from: p, reason: collision with root package name */
    public final Paint f2087p;

    /* renamed from: q, reason: collision with root package name */
    public final Path f2088q;

    /* renamed from: r, reason: collision with root package name */
    public ColorStateList f2089r;

    /* renamed from: s, reason: collision with root package name */
    public g f2090s;

    /* renamed from: t, reason: collision with root package name */
    public j f2091t;

    /* renamed from: u, reason: collision with root package name */
    public float f2092u;

    /* renamed from: v, reason: collision with root package name */
    public final Path f2093v;

    /* renamed from: w, reason: collision with root package name */
    public final int f2094w;

    /* renamed from: x, reason: collision with root package name */
    public final int f2095x;

    /* renamed from: y, reason: collision with root package name */
    public final int f2096y;

    /* renamed from: z, reason: collision with root package name */
    public final int f2097z;

    public ShapeableImageView(Context context, AttributeSet attributeSet) {
        super(a.a(context, attributeSet, 0, 2132018269), attributeSet, 0);
        this.f2083l = k.f9114a;
        this.f2088q = new Path();
        this.C = false;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.f2087p = paint;
        paint.setAntiAlias(true);
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f2084m = new RectF();
        this.f2085n = new RectF();
        this.f2093v = new Path();
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, y4.a.C, 0, 2132018269);
        setLayerType(2, null);
        this.f2089r = d.B(context2, obtainStyledAttributes, 9);
        this.f2092u = obtainStyledAttributes.getDimensionPixelSize(10, 0);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f2094w = dimensionPixelSize;
        this.f2095x = dimensionPixelSize;
        this.f2096y = dimensionPixelSize;
        this.f2097z = dimensionPixelSize;
        this.f2094w = obtainStyledAttributes.getDimensionPixelSize(3, dimensionPixelSize);
        this.f2095x = obtainStyledAttributes.getDimensionPixelSize(6, dimensionPixelSize);
        this.f2096y = obtainStyledAttributes.getDimensionPixelSize(4, dimensionPixelSize);
        this.f2097z = obtainStyledAttributes.getDimensionPixelSize(1, dimensionPixelSize);
        this.A = obtainStyledAttributes.getDimensionPixelSize(5, Integer.MIN_VALUE);
        this.B = obtainStyledAttributes.getDimensionPixelSize(2, Integer.MIN_VALUE);
        obtainStyledAttributes.recycle();
        Paint paint2 = new Paint();
        this.f2086o = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        this.f2091t = j.b(context2, attributeSet, 0, 2132018269).a();
        setOutlineProvider(new n5.a(this));
    }

    public final boolean a() {
        return getLayoutDirection() == 1;
    }

    public final void d(int i9, int i10) {
        float paddingLeft = getPaddingLeft();
        float paddingTop = getPaddingTop();
        float paddingRight = i9 - getPaddingRight();
        float paddingBottom = i10 - getPaddingBottom();
        RectF rectF = this.f2084m;
        rectF.set(paddingLeft, paddingTop, paddingRight, paddingBottom);
        j jVar = this.f2091t;
        v0 v0Var = this.f2083l;
        Path path = this.f2088q;
        v0Var.b(jVar, 1.0f, rectF, null, path);
        Path path2 = this.f2093v;
        path2.rewind();
        path2.addPath(path);
        RectF rectF2 = this.f2085n;
        rectF2.set(0.0f, 0.0f, i9, i10);
        path2.addRect(rectF2, Path.Direction.CCW);
    }

    public int getContentPaddingBottom() {
        return this.f2097z;
    }

    public final int getContentPaddingEnd() {
        int i9 = this.B;
        return i9 != Integer.MIN_VALUE ? i9 : a() ? this.f2094w : this.f2096y;
    }

    public int getContentPaddingLeft() {
        int i9 = this.B;
        int i10 = this.A;
        if (i10 != Integer.MIN_VALUE || i9 != Integer.MIN_VALUE) {
            if (a() && i9 != Integer.MIN_VALUE) {
                return i9;
            }
            if (!a() && i10 != Integer.MIN_VALUE) {
                return i10;
            }
        }
        return this.f2094w;
    }

    public int getContentPaddingRight() {
        int i9 = this.B;
        int i10 = this.A;
        if (i10 != Integer.MIN_VALUE || i9 != Integer.MIN_VALUE) {
            if (a() && i10 != Integer.MIN_VALUE) {
                return i10;
            }
            if (!a() && i9 != Integer.MIN_VALUE) {
                return i9;
            }
        }
        return this.f2096y;
    }

    public final int getContentPaddingStart() {
        int i9 = this.A;
        return i9 != Integer.MIN_VALUE ? i9 : a() ? this.f2096y : this.f2094w;
    }

    public int getContentPaddingTop() {
        return this.f2095x;
    }

    @Override // android.view.View
    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    @Override // android.view.View
    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    @Override // android.view.View
    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    @Override // android.view.View
    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    @Override // android.view.View
    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    @Override // android.view.View
    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    public j getShapeAppearanceModel() {
        return this.f2091t;
    }

    public ColorStateList getStrokeColor() {
        return this.f2089r;
    }

    public float getStrokeWidth() {
        return this.f2092u;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f2093v, this.f2087p);
        if (this.f2089r == null) {
            return;
        }
        float f9 = this.f2092u;
        Paint paint = this.f2086o;
        paint.setStrokeWidth(f9);
        int colorForState = this.f2089r.getColorForState(getDrawableState(), this.f2089r.getDefaultColor());
        if (this.f2092u <= 0.0f || colorForState == 0) {
            return;
        }
        paint.setColor(colorForState);
        canvas.drawPath(this.f2088q, paint);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i9, int i10) {
        super.onMeasure(i9, i10);
        if (!this.C && isLayoutDirectionResolved()) {
            this.C = true;
            if (!isPaddingRelative() && this.A == Integer.MIN_VALUE && this.B == Integer.MIN_VALUE) {
                setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
            } else {
                setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
            }
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i9, int i10, int i11, int i12) {
        super.onSizeChanged(i9, i10, i11, i12);
        d(i9, i10);
    }

    @Override // android.view.View
    public final void setPadding(int i9, int i10, int i11, int i12) {
        super.setPadding(getContentPaddingLeft() + i9, getContentPaddingTop() + i10, getContentPaddingRight() + i11, getContentPaddingBottom() + i12);
    }

    @Override // android.view.View
    public final void setPaddingRelative(int i9, int i10, int i11, int i12) {
        super.setPaddingRelative(getContentPaddingStart() + i9, getContentPaddingTop() + i10, getContentPaddingEnd() + i11, getContentPaddingBottom() + i12);
    }

    @Override // u5.t
    public void setShapeAppearanceModel(j jVar) {
        this.f2091t = jVar;
        g gVar = this.f2090s;
        if (gVar != null) {
            gVar.setShapeAppearanceModel(jVar);
        }
        d(getWidth(), getHeight());
        invalidate();
        invalidateOutline();
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.f2089r = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(int i9) {
        setStrokeColor(a.a.u(getContext(), i9));
    }

    public void setStrokeWidth(float f9) {
        if (this.f2092u != f9) {
            this.f2092u = f9;
            invalidate();
        }
    }

    public void setStrokeWidthResource(int i9) {
        setStrokeWidth(getResources().getDimensionPixelSize(i9));
    }
}
