package n0;

import android.graphics.Rect;
import android.view.Gravity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class j {
    public static void a(int i9, int i10, int i11, Rect rect, int i12, int i13, Rect rect2, int i14) {
        Gravity.apply(i9, i10, i11, rect, i12, i13, rect2, i14);
    }

    public static void b(int i9, int i10, int i11, Rect rect, Rect rect2, int i12) {
        Gravity.apply(i9, i10, i11, rect, rect2, i12);
    }

    public static void c(int i9, Rect rect, Rect rect2, int i10) {
        Gravity.applyDisplay(i9, rect, rect2, i10);
    }
}
