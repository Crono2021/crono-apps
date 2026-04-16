package com.google.android.material.timepicker;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import java.util.ArrayList;
import java.util.WeakHashMap;
import n0.c0;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
class ClockHandView extends View {

    /* renamed from: i, reason: collision with root package name */
    public final ValueAnimator f2176i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2177j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f2178k;

    /* renamed from: l, reason: collision with root package name */
    public final int f2179l;

    /* renamed from: m, reason: collision with root package name */
    public final float f2180m;

    /* renamed from: n, reason: collision with root package name */
    public final Paint f2181n;

    /* renamed from: o, reason: collision with root package name */
    public final RectF f2182o;

    /* renamed from: p, reason: collision with root package name */
    public final int f2183p;

    /* renamed from: q, reason: collision with root package name */
    public float f2184q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f2185r;

    /* renamed from: s, reason: collision with root package name */
    public double f2186s;

    /* renamed from: t, reason: collision with root package name */
    public int f2187t;

    /* renamed from: u, reason: collision with root package name */
    public int f2188u;

    public ClockHandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130969298);
        this.f2176i = new ValueAnimator();
        this.f2178k = new ArrayList();
        Paint paint = new Paint();
        this.f2181n = paint;
        this.f2182o = new RectF();
        this.f2188u = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y4.a.h, 2130969298, 2132018292);
        android.support.v4.media.session.b.n0(context, 2130969347, 200);
        android.support.v4.media.session.b.o0(context, 2130969363, z4.a.f10660b);
        this.f2187t = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.f2179l = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.f2183p = getResources().getDimensionPixelSize(2131165764);
        this.f2180m = r4.getDimensionPixelSize(2131165762);
        int color = obtainStyledAttributes.getColor(0, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        a(0.0f);
        ViewConfiguration.get(context).getScaledTouchSlop();
        WeakHashMap weakHashMap = t0.f7209a;
        c0.s(this, 2);
        obtainStyledAttributes.recycle();
    }

    public final void a(float f9) {
        ValueAnimator valueAnimator = this.f2176i;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        float f10 = f9 % 360.0f;
        this.f2184q = f10;
        this.f2186s = Math.toRadians(f10 - 90.0f);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        int i9 = this.f2188u;
        int i10 = this.f2187t;
        if (i9 == 2) {
            i10 = Math.round(i10 * 0.66f);
        }
        float f11 = width;
        float f12 = i10;
        float cos = (((float) Math.cos(this.f2186s)) * f12) + f11;
        float sin = (f12 * ((float) Math.sin(this.f2186s))) + height;
        float f13 = this.f2179l;
        this.f2182o.set(cos - f13, sin - f13, cos + f13, sin + f13);
        ArrayList arrayList = this.f2178k;
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            ClockFaceView clockFaceView = (ClockFaceView) ((d) obj);
            if (Math.abs(clockFaceView.N - f10) > 0.001f) {
                clockFaceView.N = f10;
                clockFaceView.f();
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        int i9 = this.f2188u;
        int i10 = this.f2187t;
        if (i9 == 2) {
            i10 = Math.round(i10 * 0.66f);
        }
        float f9 = width;
        float f10 = i10;
        float cos = (((float) Math.cos(this.f2186s)) * f10) + f9;
        float f11 = height;
        float sin = (f10 * ((float) Math.sin(this.f2186s))) + f11;
        Paint paint = this.f2181n;
        paint.setStrokeWidth(0.0f);
        canvas.drawCircle(cos, sin, this.f2179l, paint);
        double sin2 = Math.sin(this.f2186s);
        paint.setStrokeWidth(this.f2183p);
        canvas.drawLine(f9, f11, width + ((int) (Math.cos(this.f2186s) * r3)), height + ((int) (r3 * sin2)), paint);
        canvas.drawCircle(f9, f11, this.f2180m, paint);
    }

    @Override // android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        super.onLayout(z8, i9, i10, i11, i12);
        if (this.f2176i.isRunning()) {
            return;
        }
        a(this.f2184q);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z8;
        boolean z9;
        int actionMasked = motionEvent.getActionMasked();
        float x6 = motionEvent.getX();
        float y2 = motionEvent.getY();
        boolean z10 = false;
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 2) {
                z8 = this.f2185r;
                if (this.f2177j) {
                    this.f2188u = ((float) Math.hypot((double) (x6 - ((float) (getWidth() / 2))), (double) (y2 - ((float) (getHeight() / 2))))) <= ((float) Math.round(((float) this.f2187t) * 0.66f)) + TypedValue.applyDimension(1, (float) 12, getContext().getResources().getDisplayMetrics()) ? 2 : 1;
                }
            } else {
                z8 = false;
            }
            z9 = false;
        } else {
            this.f2185r = false;
            z8 = false;
            z9 = true;
        }
        boolean z11 = this.f2185r;
        int degrees = (int) Math.toDegrees(Math.atan2(y2 - (getHeight() / 2), x6 - (getWidth() / 2)));
        int i9 = degrees + 90;
        if (i9 < 0) {
            i9 = degrees + 450;
        }
        float f9 = i9;
        boolean z12 = this.f2184q != f9;
        if (!z9 || !z12) {
            if (z12 || z8) {
                a(f9);
            }
            this.f2185r = z11 | z10;
            return true;
        }
        z10 = true;
        this.f2185r = z11 | z10;
        return true;
    }
}
