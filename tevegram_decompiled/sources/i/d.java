package i;

import android.animation.TimeInterpolator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d implements TimeInterpolator {

    /* renamed from: a, reason: collision with root package name */
    public int[] f4263a;

    /* renamed from: b, reason: collision with root package name */
    public int f4264b;

    /* renamed from: c, reason: collision with root package name */
    public int f4265c;

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f9) {
        int i9 = (int) ((f9 * this.f4265c) + 0.5f);
        int i10 = this.f4264b;
        int[] iArr = this.f4263a;
        int i11 = 0;
        while (i11 < i10) {
            int i12 = iArr[i11];
            if (i9 < i12) {
                break;
            }
            i9 -= i12;
            i11++;
        }
        return (i11 / i10) + (i11 < i10 ? i9 / this.f4265c : 0.0f);
    }
}
