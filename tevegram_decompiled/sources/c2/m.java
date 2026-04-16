package c2;

import android.content.Context;
import android.graphics.PointF;
import android.opengl.Matrix;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class m extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, c {

    /* renamed from: k, reason: collision with root package name */
    public final k f1611k;

    /* renamed from: m, reason: collision with root package name */
    public final GestureDetector f1613m;

    /* renamed from: i, reason: collision with root package name */
    public final PointF f1609i = new PointF();

    /* renamed from: j, reason: collision with root package name */
    public final PointF f1610j = new PointF();

    /* renamed from: l, reason: collision with root package name */
    public final float f1612l = 25.0f;

    /* renamed from: n, reason: collision with root package name */
    public volatile float f1614n = 3.1415927f;

    public m(Context context, k kVar) {
        this.f1611k = kVar;
        this.f1613m = new GestureDetector(context, this);
    }

    @Override // c2.c
    public final void a(float[] fArr, float f9) {
        this.f1614n = -f9;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        this.f1609i.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f9, float f10) {
        float x6 = (motionEvent2.getX() - this.f1609i.x) / this.f1612l;
        float y2 = motionEvent2.getY();
        PointF pointF = this.f1609i;
        float f11 = (y2 - pointF.y) / this.f1612l;
        pointF.set(motionEvent2.getX(), motionEvent2.getY());
        double d9 = this.f1614n;
        float cos = (float) Math.cos(d9);
        float sin = (float) Math.sin(d9);
        PointF pointF2 = this.f1610j;
        pointF2.x -= (cos * x6) - (sin * f11);
        float f12 = (cos * f11) + (sin * x6) + pointF2.y;
        pointF2.y = f12;
        pointF2.y = Math.max(-45.0f, Math.min(45.0f, f12));
        k kVar = this.f1611k;
        PointF pointF3 = this.f1610j;
        synchronized (kVar) {
            float f13 = pointF3.y;
            kVar.f1592o = f13;
            Matrix.setRotateM(kVar.f1590m, 0, -f13, (float) Math.cos(kVar.f1593p), (float) Math.sin(kVar.f1593p), 0.0f);
            Matrix.setRotateM(kVar.f1591n, 0, -pointF3.x, 0.0f, 1.0f, 0.0f);
        }
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        return this.f1611k.f1596s.performClick();
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f1613m.onTouchEvent(motionEvent);
    }
}
