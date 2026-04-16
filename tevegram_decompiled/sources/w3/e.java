package w3;

import android.animation.TypeEvaluator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e implements TypeEvaluator {

    /* renamed from: a, reason: collision with root package name */
    public f0.f[] f9866a;

    @Override // android.animation.TypeEvaluator
    public final Object evaluate(float f9, Object obj, Object obj2) {
        f0.f[] fVarArr = (f0.f[]) obj;
        f0.f[] fVarArr2 = (f0.f[]) obj2;
        if (!a.a.e(fVarArr, fVarArr2)) {
            m7.c.n("Can't interpolate between two incompatible pathData");
            return null;
        }
        if (!a.a.e(this.f9866a, fVarArr)) {
            this.f9866a = a.a.p(fVarArr);
        }
        int i9 = 0;
        while (true) {
            int length = fVarArr.length;
            f0.f[] fVarArr3 = this.f9866a;
            if (i9 >= length) {
                return fVarArr3;
            }
            f0.f fVar = fVarArr3[i9];
            f0.f fVar2 = fVarArr[i9];
            f0.f fVar3 = fVarArr2[i9];
            fVar.getClass();
            fVar.f3198a = fVar2.f3198a;
            int i10 = 0;
            while (true) {
                float[] fArr = fVar2.f3199b;
                if (i10 < fArr.length) {
                    fVar.f3199b[i10] = (fVar3.f3199b[i10] * f9) + ((1.0f - f9) * fArr[i10]);
                    i10++;
                }
            }
            i9++;
        }
    }
}
