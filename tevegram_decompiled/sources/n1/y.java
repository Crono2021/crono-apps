package n1;

import android.media.AudioTrack;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public final x f7395a;

    /* renamed from: b, reason: collision with root package name */
    public int f7396b;

    /* renamed from: c, reason: collision with root package name */
    public long f7397c;

    /* renamed from: d, reason: collision with root package name */
    public long f7398d;

    /* renamed from: e, reason: collision with root package name */
    public long f7399e;

    /* renamed from: f, reason: collision with root package name */
    public long f7400f;

    public y(AudioTrack audioTrack) {
        if (g1.w.f3713a >= 19) {
            this.f7395a = new x(audioTrack);
            a();
        } else {
            this.f7395a = null;
            b(3);
        }
    }

    public final void a() {
        if (this.f7395a != null) {
            b(0);
        }
    }

    public final void b(int i9) {
        this.f7396b = i9;
        if (i9 == 0) {
            this.f7399e = 0L;
            this.f7400f = -1L;
            this.f7397c = System.nanoTime() / 1000;
            this.f7398d = 10000L;
            return;
        }
        if (i9 == 1) {
            this.f7398d = 10000L;
            return;
        }
        if (i9 == 2 || i9 == 3) {
            this.f7398d = 10000000L;
        } else if (i9 == 4) {
            this.f7398d = 500000L;
        } else {
            androidx.fragment.app.a.l();
        }
    }
}
