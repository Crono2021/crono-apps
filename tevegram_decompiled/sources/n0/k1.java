package n0;

import android.view.WindowInsetsAnimation;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k1 extends l1 {

    /* renamed from: e, reason: collision with root package name */
    public final WindowInsetsAnimation f7172e;

    public k1(WindowInsetsAnimation windowInsetsAnimation) {
        super(0, null, 0L);
        this.f7172e = windowInsetsAnimation;
    }

    @Override // n0.l1
    public final long a() {
        long durationMillis;
        durationMillis = this.f7172e.getDurationMillis();
        return durationMillis;
    }

    @Override // n0.l1
    public final float b() {
        float interpolatedFraction;
        interpolatedFraction = this.f7172e.getInterpolatedFraction();
        return interpolatedFraction;
    }

    @Override // n0.l1
    public final int c() {
        int typeMask;
        typeMask = this.f7172e.getTypeMask();
        return typeMask;
    }

    @Override // n0.l1
    public final void d(float f9) {
        this.f7172e.setFraction(f9);
    }
}
