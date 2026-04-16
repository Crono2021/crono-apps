package u5;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class o extends q {
    public static final RectF h = new RectF();

    /* renamed from: b, reason: collision with root package name */
    public final float f9121b;

    /* renamed from: c, reason: collision with root package name */
    public final float f9122c;

    /* renamed from: d, reason: collision with root package name */
    public final float f9123d;

    /* renamed from: e, reason: collision with root package name */
    public final float f9124e;

    /* renamed from: f, reason: collision with root package name */
    public float f9125f;

    /* renamed from: g, reason: collision with root package name */
    public float f9126g;

    public o(float f9, float f10, float f11, float f12) {
        this.f9121b = f9;
        this.f9122c = f10;
        this.f9123d = f11;
        this.f9124e = f12;
    }

    @Override // u5.q
    public final void a(Matrix matrix, Path path) {
        Matrix matrix2 = this.f9129a;
        matrix.invert(matrix2);
        path.transform(matrix2);
        float f9 = this.f9123d;
        float f10 = this.f9124e;
        RectF rectF = h;
        rectF.set(this.f9121b, this.f9122c, f9, f10);
        path.arcTo(rectF, this.f9125f, this.f9126g, false);
        path.transform(matrix);
    }
}
