package p1;

import android.os.SystemClock;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g extends y1.c {

    /* renamed from: g, reason: collision with root package name */
    public int f8111g;

    @Override // y1.q
    public final void g(long j5, long j9, long j10, List list, w1.b[] bVarArr) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (b(this.f8111g, elapsedRealtime)) {
            for (int i9 = this.f10407b - 1; i9 >= 0; i9--) {
                if (!b(i9, elapsedRealtime)) {
                    this.f8111g = i9;
                    return;
                }
            }
            androidx.fragment.app.a.l();
        }
    }

    @Override // y1.q
    public final int l() {
        return 0;
    }

    @Override // y1.q
    public final int m() {
        return this.f8111g;
    }

    @Override // y1.q
    public final Object p() {
        return null;
    }
}
