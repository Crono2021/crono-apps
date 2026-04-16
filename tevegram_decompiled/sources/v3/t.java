package v3;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class t extends a.a {

    /* renamed from: i, reason: collision with root package name */
    public static boolean f9553i = true;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f9554j = true;

    /* renamed from: k, reason: collision with root package name */
    public static boolean f9555k = true;

    public float Z(View view) {
        float transitionAlpha;
        if (f9553i) {
            try {
                transitionAlpha = view.getTransitionAlpha();
                return transitionAlpha;
            } catch (NoSuchMethodError unused) {
                f9553i = false;
            }
        }
        return view.getAlpha();
    }

    public void a0(View view, float f9) {
        if (f9553i) {
            try {
                view.setTransitionAlpha(f9);
                return;
            } catch (NoSuchMethodError unused) {
                f9553i = false;
            }
        }
        view.setAlpha(f9);
    }

    public void b0(View view, Matrix matrix) {
        if (f9554j) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f9554j = false;
            }
        }
    }

    public void c0(ViewGroup viewGroup, Matrix matrix) {
        if (f9555k) {
            try {
                viewGroup.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f9555k = false;
            }
        }
    }
}
