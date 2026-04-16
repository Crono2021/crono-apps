package o3;

import android.R;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class q extends l0 {
    public static final int[] C = {R.attr.state_pressed};
    public static final int[] D = new int[0];
    public int A;
    public final androidx.activity.j B;

    /* renamed from: a, reason: collision with root package name */
    public final int f7769a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7770b;

    /* renamed from: c, reason: collision with root package name */
    public final StateListDrawable f7771c;

    /* renamed from: d, reason: collision with root package name */
    public final Drawable f7772d;

    /* renamed from: e, reason: collision with root package name */
    public final int f7773e;

    /* renamed from: f, reason: collision with root package name */
    public final int f7774f;

    /* renamed from: g, reason: collision with root package name */
    public final StateListDrawable f7775g;
    public final Drawable h;

    /* renamed from: i, reason: collision with root package name */
    public final int f7776i;

    /* renamed from: j, reason: collision with root package name */
    public final int f7777j;

    /* renamed from: k, reason: collision with root package name */
    public int f7778k;

    /* renamed from: l, reason: collision with root package name */
    public int f7779l;

    /* renamed from: m, reason: collision with root package name */
    public float f7780m;

    /* renamed from: n, reason: collision with root package name */
    public int f7781n;

    /* renamed from: o, reason: collision with root package name */
    public int f7782o;

    /* renamed from: p, reason: collision with root package name */
    public float f7783p;

    /* renamed from: s, reason: collision with root package name */
    public final RecyclerView f7786s;

    /* renamed from: z, reason: collision with root package name */
    public final ValueAnimator f7793z;

    /* renamed from: q, reason: collision with root package name */
    public int f7784q = 0;

    /* renamed from: r, reason: collision with root package name */
    public int f7785r = 0;

    /* renamed from: t, reason: collision with root package name */
    public boolean f7787t = false;

    /* renamed from: u, reason: collision with root package name */
    public boolean f7788u = false;

    /* renamed from: v, reason: collision with root package name */
    public int f7789v = 0;

    /* renamed from: w, reason: collision with root package name */
    public int f7790w = 0;

    /* renamed from: x, reason: collision with root package name */
    public final int[] f7791x = new int[2];

    /* renamed from: y, reason: collision with root package name */
    public final int[] f7792y = new int[2];

    public q(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i9, int i10, int i11) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f7793z = ofFloat;
        this.A = 0;
        androidx.activity.j jVar = new androidx.activity.j(this, 12);
        this.B = jVar;
        i7.d dVar = new i7.d(this, 2);
        this.f7771c = stateListDrawable;
        this.f7772d = drawable;
        this.f7775g = stateListDrawable2;
        this.h = drawable2;
        this.f7773e = Math.max(i9, stateListDrawable.getIntrinsicWidth());
        this.f7774f = Math.max(i9, drawable.getIntrinsicWidth());
        this.f7776i = Math.max(i9, stateListDrawable2.getIntrinsicWidth());
        this.f7777j = Math.max(i9, drawable2.getIntrinsicWidth());
        this.f7769a = i10;
        this.f7770b = i11;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new p(this));
        ofFloat.addUpdateListener(new d5.b(this, 1));
        RecyclerView recyclerView2 = this.f7786s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            ArrayList arrayList = recyclerView2.f1084x;
            o0 o0Var = recyclerView2.f1080v;
            if (o0Var != null) {
                o0Var.c("Cannot remove item decoration during a scroll  or layout");
            }
            arrayList.remove(this);
            if (arrayList.isEmpty()) {
                recyclerView2.setWillNotDraw(recyclerView2.getOverScrollMode() == 2);
            }
            recyclerView2.O();
            recyclerView2.requestLayout();
            RecyclerView recyclerView3 = this.f7786s;
            recyclerView3.f1086y.remove(this);
            if (recyclerView3.f1088z == this) {
                recyclerView3.f1088z = null;
            }
            ArrayList arrayList2 = this.f7786s.f1071q0;
            if (arrayList2 != null) {
                arrayList2.remove(dVar);
            }
            this.f7786s.removeCallbacks(jVar);
        }
        this.f7786s = recyclerView;
        recyclerView.g(this);
        this.f7786s.f1086y.add(this);
        this.f7786s.h(dVar);
    }

    public static int e(float f9, float f10, int[] iArr, int i9, int i10, int i11) {
        int i12 = iArr[1] - iArr[0];
        if (i12 != 0) {
            int i13 = i9 - i11;
            int i14 = (int) (((f10 - f9) / i12) * i13);
            int i15 = i10 + i14;
            if (i15 < i13 && i15 >= 0) {
                return i14;
            }
        }
        return 0;
    }

    @Override // o3.l0
    public final void b(Canvas canvas, RecyclerView recyclerView) {
        int i9 = this.f7784q;
        RecyclerView recyclerView2 = this.f7786s;
        if (i9 != recyclerView2.getWidth() || this.f7785r != recyclerView2.getHeight()) {
            this.f7784q = recyclerView2.getWidth();
            this.f7785r = recyclerView2.getHeight();
            f(0);
            return;
        }
        if (this.A != 0) {
            if (this.f7787t) {
                int i10 = this.f7784q;
                int i11 = this.f7773e;
                int i12 = i10 - i11;
                int i13 = this.f7779l;
                int i14 = this.f7778k;
                int i15 = i13 - (i14 / 2);
                StateListDrawable stateListDrawable = this.f7771c;
                stateListDrawable.setBounds(0, 0, i11, i14);
                int i16 = this.f7774f;
                int i17 = this.f7785r;
                Drawable drawable = this.f7772d;
                drawable.setBounds(0, 0, i16, i17);
                WeakHashMap weakHashMap = n0.t0.f7209a;
                if (n0.d0.d(recyclerView2) == 1) {
                    drawable.draw(canvas);
                    canvas.translate(i11, i15);
                    canvas.scale(-1.0f, 1.0f);
                    stateListDrawable.draw(canvas);
                    canvas.scale(-1.0f, 1.0f);
                    canvas.translate(-i11, -i15);
                } else {
                    canvas.translate(i12, 0.0f);
                    drawable.draw(canvas);
                    canvas.translate(0.0f, i15);
                    stateListDrawable.draw(canvas);
                    canvas.translate(-i12, -i15);
                }
            }
            if (this.f7788u) {
                int i18 = this.f7785r;
                int i19 = this.f7776i;
                int i20 = i18 - i19;
                int i21 = this.f7782o;
                int i22 = this.f7781n;
                int i23 = i21 - (i22 / 2);
                StateListDrawable stateListDrawable2 = this.f7775g;
                stateListDrawable2.setBounds(0, 0, i22, i19);
                int i24 = this.f7784q;
                int i25 = this.f7777j;
                Drawable drawable2 = this.h;
                drawable2.setBounds(0, 0, i24, i25);
                canvas.translate(0.0f, i20);
                drawable2.draw(canvas);
                canvas.translate(i23, 0.0f);
                stateListDrawable2.draw(canvas);
                canvas.translate(-i23, -i20);
            }
        }
    }

    public final boolean c(float f9, float f10) {
        if (f10 < this.f7785r - this.f7776i) {
            return false;
        }
        int i9 = this.f7782o;
        int i10 = this.f7781n;
        return f9 >= ((float) (i9 - (i10 / 2))) && f9 <= ((float) ((i10 / 2) + i9));
    }

    public final boolean d(float f9, float f10) {
        WeakHashMap weakHashMap = n0.t0.f7209a;
        int d9 = n0.d0.d(this.f7786s);
        int i9 = this.f7773e;
        if (d9 == 1) {
            if (f9 > i9) {
                return false;
            }
        } else if (f9 < this.f7784q - i9) {
            return false;
        }
        int i10 = this.f7779l;
        int i11 = this.f7778k / 2;
        return f10 >= ((float) (i10 - i11)) && f10 <= ((float) (i11 + i10));
    }

    public final void f(int i9) {
        androidx.activity.j jVar = this.B;
        StateListDrawable stateListDrawable = this.f7771c;
        if (i9 == 2 && this.f7789v != 2) {
            stateListDrawable.setState(C);
            this.f7786s.removeCallbacks(jVar);
        }
        if (i9 == 0) {
            this.f7786s.invalidate();
        } else {
            g();
        }
        if (this.f7789v == 2 && i9 != 2) {
            stateListDrawable.setState(D);
            this.f7786s.removeCallbacks(jVar);
            this.f7786s.postDelayed(jVar, 1200);
        } else if (i9 == 1) {
            this.f7786s.removeCallbacks(jVar);
            this.f7786s.postDelayed(jVar, 1500);
        }
        this.f7789v = i9;
    }

    public final void g() {
        int i9 = this.A;
        ValueAnimator valueAnimator = this.f7793z;
        if (i9 != 0) {
            if (i9 != 3) {
                return;
            } else {
                valueAnimator.cancel();
            }
        }
        this.A = 1;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        valueAnimator.setDuration(500L);
        valueAnimator.setStartDelay(0L);
        valueAnimator.start();
    }
}
