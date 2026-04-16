package v3;

import android.os.Build;
import android.view.View;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class v extends u {

    /* renamed from: m, reason: collision with root package name */
    public static boolean f9557m = true;

    @Override // a.a
    public void P(View view, int i9) {
        if (Build.VERSION.SDK_INT == 28) {
            super.P(view, i9);
        } else if (f9557m) {
            try {
                view.setTransitionVisibility(i9);
            } catch (NoSuchMethodError unused) {
                f9557m = false;
            }
        }
    }
}
