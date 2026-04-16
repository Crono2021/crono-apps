package z4;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final LinearInterpolator f10659a = new LinearInterpolator();

    /* renamed from: b, reason: collision with root package name */
    public static final a1.a f10660b = new a1.a(1);

    /* renamed from: c, reason: collision with root package name */
    public static final a1.a f10661c = new a1.a(0);

    /* renamed from: d, reason: collision with root package name */
    public static final a1.a f10662d = new a1.a(a1.a.f38e);

    /* renamed from: e, reason: collision with root package name */
    public static final DecelerateInterpolator f10663e = new DecelerateInterpolator();

    public static float a(float f9, float f10, float f11) {
        return ((f10 - f9) * f11) + f9;
    }

    public static float b(float f9, float f10, float f11, float f12, float f13) {
        return f13 <= f11 ? f9 : f13 >= f12 ? f10 : a(f9, f10, (f13 - f11) / (f12 - f11));
    }

    public static int c(float f9, int i9, int i10) {
        return Math.round(f9 * (i10 - i9)) + i9;
    }
}
