package n0;

import android.os.Build;
import android.view.animation.Interpolator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class m1 {

    /* renamed from: a, reason: collision with root package name */
    public l1 f7177a;

    public m1(int i9, Interpolator interpolator, long j5) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f7177a = new k1(b2.x.k(i9, interpolator, j5));
        } else {
            this.f7177a = new i1(i9, interpolator, j5);
        }
    }
}
