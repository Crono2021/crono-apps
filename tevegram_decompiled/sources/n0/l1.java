package n0;

import android.view.animation.Interpolator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class l1 {

    /* renamed from: a, reason: collision with root package name */
    public final int f7173a;

    /* renamed from: b, reason: collision with root package name */
    public float f7174b;

    /* renamed from: c, reason: collision with root package name */
    public final Interpolator f7175c;

    /* renamed from: d, reason: collision with root package name */
    public final long f7176d;

    public l1(int i9, Interpolator interpolator, long j5) {
        this.f7173a = i9;
        this.f7175c = interpolator;
        this.f7176d = j5;
    }

    public long a() {
        return this.f7176d;
    }

    public float b() {
        float f9 = this.f7174b;
        Interpolator interpolator = this.f7175c;
        return interpolator != null ? interpolator.getInterpolation(f9) : f9;
    }

    public int c() {
        return this.f7173a;
    }

    public void d(float f9) {
        this.f7174b = f9;
    }
}
