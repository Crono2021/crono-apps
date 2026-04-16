package n;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h0 extends c0 {

    /* renamed from: e, reason: collision with root package name */
    public final g0 f6877e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f6878f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f6879g;
    public PorterDuff.Mode h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f6880i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f6881j;

    public h0(g0 g0Var) {
        super(g0Var);
        this.f6879g = null;
        this.h = null;
        this.f6880i = false;
        this.f6881j = false;
        this.f6877e = g0Var;
    }

    @Override // n.c0
    public final void b(AttributeSet attributeSet, int i9) {
        super.b(attributeSet, 2130969476);
        g0 g0Var = this.f6877e;
        Context context = g0Var.getContext();
        int[] iArr = f.a.f3172g;
        androidx.fragment.app.g g02 = androidx.fragment.app.g.g0(context, attributeSet, iArr, 2130969476);
        TypedArray typedArray = (TypedArray) g02.f729k;
        n0.t0.o(g0Var, g0Var.getContext(), iArr, attributeSet, (TypedArray) g02.f729k, 2130969476);
        Drawable R = g02.R(0);
        if (R != null) {
            g0Var.setThumb(R);
        }
        Drawable Q = g02.Q(1);
        Drawable drawable = this.f6878f;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f6878f = Q;
        if (Q != null) {
            Q.setCallback(g0Var);
            com.bumptech.glide.d.a0(Q, n0.d0.d(g0Var));
            if (Q.isStateful()) {
                Q.setState(g0Var.getDrawableState());
            }
            f();
        }
        g0Var.invalidate();
        if (typedArray.hasValue(3)) {
            this.h = r1.c(typedArray.getInt(3, -1), this.h);
            this.f6881j = true;
        }
        if (typedArray.hasValue(2)) {
            this.f6879g = g02.O(2);
            this.f6880i = true;
        }
        g02.i0();
        f();
    }

    public final void f() {
        Drawable drawable = this.f6878f;
        if (drawable != null) {
            if (this.f6880i || this.f6881j) {
                Drawable f02 = com.bumptech.glide.d.f0(drawable.mutate());
                this.f6878f = f02;
                if (this.f6880i) {
                    g0.b.h(f02, this.f6879g);
                }
                if (this.f6881j) {
                    g0.b.i(this.f6878f, this.h);
                }
                if (this.f6878f.isStateful()) {
                    this.f6878f.setState(this.f6877e.getDrawableState());
                }
            }
        }
    }

    public final void g(Canvas canvas) {
        if (this.f6878f != null) {
            int max = this.f6877e.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f6878f.getIntrinsicWidth();
                int intrinsicHeight = this.f6878f.getIntrinsicHeight();
                int i9 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i10 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f6878f.setBounds(-i9, -i10, i9, i10);
                float width = ((r0.getWidth() - r0.getPaddingLeft()) - r0.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(r0.getPaddingLeft(), r0.getHeight() / 2);
                for (int i11 = 0; i11 <= max; i11++) {
                    this.f6878f.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
