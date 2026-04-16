package o4;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c extends Drawable implements Animatable {

    /* renamed from: i, reason: collision with root package name */
    public final b f7890i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f7891j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f7892k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f7893l;

    /* renamed from: n, reason: collision with root package name */
    public int f7895n;

    /* renamed from: p, reason: collision with root package name */
    public boolean f7897p;

    /* renamed from: q, reason: collision with root package name */
    public Paint f7898q;

    /* renamed from: r, reason: collision with root package name */
    public Rect f7899r;

    /* renamed from: m, reason: collision with root package name */
    public boolean f7894m = true;

    /* renamed from: o, reason: collision with root package name */
    public final int f7896o = -1;

    public c(b bVar) {
        this.f7890i = bVar;
    }

    public final void a() {
        w4.f.a("You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.", !this.f7893l);
        h hVar = (h) this.f7890i.f7889b;
        if (hVar.f7912a.f161l.f139c == 1) {
            invalidateSelf();
            return;
        }
        if (this.f7891j) {
            return;
        }
        this.f7891j = true;
        ArrayList arrayList = hVar.f7914c;
        if (hVar.f7920j) {
            m7.c.p("Cannot subscribe to a cleared frame loader");
            return;
        }
        if (arrayList.contains(this)) {
            m7.c.p("Cannot subscribe twice in a row");
            return;
        }
        boolean isEmpty = arrayList.isEmpty();
        arrayList.add(this);
        if (isEmpty && !hVar.f7917f) {
            hVar.f7917f = true;
            hVar.f7920j = false;
            hVar.a();
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (this.f7893l) {
            return;
        }
        if (this.f7897p) {
            int intrinsicWidth = getIntrinsicWidth();
            int intrinsicHeight = getIntrinsicHeight();
            Rect bounds = getBounds();
            if (this.f7899r == null) {
                this.f7899r = new Rect();
            }
            Gravity.apply(119, intrinsicWidth, intrinsicHeight, bounds, this.f7899r);
            this.f7897p = false;
        }
        h hVar = (h) this.f7890i.f7889b;
        f fVar = hVar.f7919i;
        Bitmap bitmap = fVar != null ? fVar.f7909o : hVar.f7922l;
        if (this.f7899r == null) {
            this.f7899r = new Rect();
        }
        Rect rect = this.f7899r;
        if (this.f7898q == null) {
            this.f7898q = new Paint(2);
        }
        canvas.drawBitmap(bitmap, (Rect) null, rect, this.f7898q);
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f7890i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return ((h) this.f7890i.f7889b).f7926p;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return ((h) this.f7890i.f7889b).f7925o;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.f7891j;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f7897p = true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i9) {
        if (this.f7898q == null) {
            this.f7898q = new Paint(2);
        }
        this.f7898q.setAlpha(i9);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.f7898q == null) {
            this.f7898q = new Paint(2);
        }
        this.f7898q.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z8, boolean z9) {
        w4.f.a("Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.", !this.f7893l);
        this.f7894m = z8;
        if (!z8) {
            this.f7891j = false;
            h hVar = (h) this.f7890i.f7889b;
            ArrayList arrayList = hVar.f7914c;
            arrayList.remove(this);
            if (arrayList.isEmpty()) {
                hVar.f7917f = false;
            }
        } else if (this.f7892k) {
            a();
        }
        return super.setVisible(z8, z9);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        this.f7892k = true;
        this.f7895n = 0;
        if (this.f7894m) {
            a();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f7892k = false;
        this.f7891j = false;
        h hVar = (h) this.f7890i.f7889b;
        ArrayList arrayList = hVar.f7914c;
        arrayList.remove(this);
        if (arrayList.isEmpty()) {
            hVar.f7917f = false;
        }
    }
}
