package v3;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class w extends v {
    @Override // v3.u, a.a
    public final void L(View view, int i9, int i10, int i11, int i12) {
        view.setLeftTopRightBottom(i9, i10, i11, i12);
    }

    @Override // v3.v, a.a
    public final void P(View view, int i9) {
        view.setTransitionVisibility(i9);
    }

    @Override // v3.t
    public final float Z(View view) {
        float transitionAlpha;
        transitionAlpha = view.getTransitionAlpha();
        return transitionAlpha;
    }

    @Override // v3.t
    public final void a0(View view, float f9) {
        view.setTransitionAlpha(f9);
    }

    @Override // v3.t
    public final void b0(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // v3.t
    public final void c0(ViewGroup viewGroup, Matrix matrix) {
        viewGroup.transformMatrixToLocal(matrix);
    }
}
