package v3;

import android.view.View;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class u extends t {

    /* renamed from: l, reason: collision with root package name */
    public static boolean f9556l = true;

    @Override // a.a
    public void L(View view, int i9, int i10, int i11, int i12) {
        if (f9556l) {
            try {
                view.setLeftTopRightBottom(i9, i10, i11, i12);
            } catch (NoSuchMethodError unused) {
                f9556l = false;
            }
        }
    }
}
