package u5;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class n extends r {

    /* renamed from: c, reason: collision with root package name */
    public final p f9118c;

    /* renamed from: d, reason: collision with root package name */
    public final float f9119d;

    /* renamed from: e, reason: collision with root package name */
    public final float f9120e;

    public n(p pVar, float f9, float f10) {
        this.f9118c = pVar;
        this.f9119d = f9;
        this.f9120e = f10;
    }

    @Override // u5.r
    public final void a(Matrix matrix, t5.a aVar, int i9, Canvas canvas) {
        p pVar = this.f9118c;
        float f9 = pVar.f9128c;
        float f10 = this.f9120e;
        float f11 = pVar.f9127b;
        float f12 = this.f9119d;
        RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(f9 - f10, f11 - f12), 0.0f);
        Matrix matrix2 = this.f9131a;
        matrix2.set(matrix);
        matrix2.preTranslate(f12, f10);
        matrix2.preRotate(b());
        aVar.getClass();
        rectF.bottom += i9;
        rectF.offset(0.0f, -i9);
        int i10 = aVar.f8978f;
        int[] iArr = t5.a.f8969i;
        iArr[0] = i10;
        iArr[1] = aVar.f8977e;
        iArr[2] = aVar.f8976d;
        Paint paint = aVar.f8975c;
        float f13 = rectF.left;
        paint.setShader(new LinearGradient(f13, rectF.top, f13, rectF.bottom, iArr, t5.a.f8970j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix2);
        canvas.drawRect(rectF, paint);
        canvas.restore();
    }

    public final float b() {
        p pVar = this.f9118c;
        return (float) Math.toDegrees(Math.atan((pVar.f9128c - this.f9120e) / (pVar.f9127b - this.f9119d)));
    }
}
