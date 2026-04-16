package x5;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f extends u5.g {
    public static final /* synthetic */ int G = 0;
    public e F;

    @Override // u5.g
    public final void e(Canvas canvas) {
        if (this.F.f10117q.isEmpty()) {
            super.e(canvas);
            return;
        }
        canvas.save();
        int i9 = Build.VERSION.SDK_INT;
        e eVar = this.F;
        if (i9 >= 26) {
            canvas.clipOutRect(eVar.f10117q);
        } else {
            canvas.clipRect(eVar.f10117q, Region.Op.DIFFERENCE);
        }
        super.e(canvas);
        canvas.restore();
    }

    @Override // u5.g, android.graphics.drawable.Drawable
    public final Drawable mutate() {
        this.F = new e(this.F);
        return this;
    }

    public final void r(float f9, float f10, float f11, float f12) {
        RectF rectF = this.F.f10117q;
        if (f9 == rectF.left && f10 == rectF.top && f11 == rectF.right && f12 == rectF.bottom) {
            return;
        }
        rectF.set(f9, f10, f11, f12);
        invalidateSelf();
    }
}
