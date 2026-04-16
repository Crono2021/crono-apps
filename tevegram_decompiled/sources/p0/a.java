package p0;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class a {
    public static Interpolator a(float f9, float f10) {
        return new PathInterpolator(f9, f10);
    }

    public static Interpolator b(float f9, float f10, float f11, float f12) {
        return new PathInterpolator(f9, f10, f11, f12);
    }

    public static Interpolator c(Path path) {
        return new PathInterpolator(path);
    }
}
