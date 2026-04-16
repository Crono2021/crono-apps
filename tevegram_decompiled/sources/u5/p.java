package u5;

import android.graphics.Matrix;
import android.graphics.Path;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class p extends q {

    /* renamed from: b, reason: collision with root package name */
    public float f9127b;

    /* renamed from: c, reason: collision with root package name */
    public float f9128c;

    @Override // u5.q
    public final void a(Matrix matrix, Path path) {
        Matrix matrix2 = this.f9129a;
        matrix.invert(matrix2);
        path.transform(matrix2);
        path.lineTo(this.f9127b, this.f9128c);
        path.transform(matrix);
    }
}
