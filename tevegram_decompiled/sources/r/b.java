package r;

import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class b extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public static final double f8487a = Math.cos(Math.toRadians(45.0d));

    public static float a(float f9, float f10, boolean z8) {
        if (!z8) {
            return f9;
        }
        return (float) (((1.0d - f8487a) * f10) + f9);
    }

    public static float b(float f9, float f10, boolean z8) {
        if (!z8) {
            return f9 * 1.5f;
        }
        return (float) (((1.0d - f8487a) * f10) + (f9 * 1.5f));
    }
}
