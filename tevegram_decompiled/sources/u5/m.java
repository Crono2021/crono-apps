package u5;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class m extends r {

    /* renamed from: c, reason: collision with root package name */
    public final o f9117c;

    public m(o oVar) {
        this.f9117c = oVar;
    }

    @Override // u5.r
    public final void a(Matrix matrix, t5.a aVar, int i9, Canvas canvas) {
        char c9;
        o oVar = this.f9117c;
        float f9 = oVar.f9125f;
        float f10 = oVar.f9126g;
        RectF rectF = new RectF(oVar.f9121b, oVar.f9122c, oVar.f9123d, oVar.f9124e);
        Paint paint = aVar.f8974b;
        boolean z8 = f10 < 0.0f;
        Path path = aVar.f8979g;
        int[] iArr = t5.a.f8971k;
        if (z8) {
            iArr[0] = 0;
            iArr[1] = aVar.f8978f;
            iArr[2] = aVar.f8977e;
            iArr[3] = aVar.f8976d;
            c9 = 1;
        } else {
            path.rewind();
            c9 = 1;
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f9, f10);
            path.close();
            float f11 = -i9;
            rectF.inset(f11, f11);
            iArr[0] = 0;
            iArr[1] = aVar.f8976d;
            iArr[2] = aVar.f8977e;
            iArr[3] = aVar.f8978f;
        }
        float width = rectF.width() / 2.0f;
        if (width <= 0.0f) {
            return;
        }
        float f12 = 1.0f - (i9 / width);
        float[] fArr = t5.a.f8972l;
        fArr[c9] = f12;
        fArr[2] = ((1.0f - f12) / 2.0f) + f12;
        paint.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), width, iArr, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z8) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, aVar.h);
        }
        canvas.drawArc(rectF, f9, f10, true, paint);
        canvas.restore();
    }
}
