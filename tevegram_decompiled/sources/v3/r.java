package v3;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import n.j3;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class r {

    /* renamed from: a, reason: collision with root package name */
    public static final t f9551a;

    /* renamed from: b, reason: collision with root package name */
    public static final j3 f9552b;

    static {
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 29) {
            f9551a = new w();
        } else if (i9 >= 23) {
            f9551a = new v();
        } else if (i9 >= 22) {
            f9551a = new u();
        } else {
            f9551a = new t();
        }
        f9552b = new j3(Float.class, "translationAlpha", 6);
        new j3(Rect.class, "clipBounds", 7);
    }

    public static void a(View view, int i9, int i10, int i11, int i12) {
        f9551a.L(view, i9, i10, i11, i12);
    }
}
