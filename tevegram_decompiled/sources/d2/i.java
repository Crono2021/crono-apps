package d2;

import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i implements y {

    /* renamed from: a, reason: collision with root package name */
    public final int f2694a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f2695b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f2696c;

    /* renamed from: d, reason: collision with root package name */
    public final long[] f2697d;

    /* renamed from: e, reason: collision with root package name */
    public final long[] f2698e;

    /* renamed from: f, reason: collision with root package name */
    public final long f2699f;

    public i(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f2695b = iArr;
        this.f2696c = jArr;
        this.f2697d = jArr2;
        this.f2698e = jArr3;
        int length = iArr.length;
        this.f2694a = length;
        if (length <= 0) {
            this.f2699f = 0L;
        } else {
            int i9 = length - 1;
            this.f2699f = jArr2[i9] + jArr3[i9];
        }
    }

    @Override // d2.y
    public final boolean e() {
        return true;
    }

    @Override // d2.y
    public final x i(long j5) {
        long[] jArr = this.f2698e;
        int c9 = g1.w.c(j5, jArr, true);
        long j9 = jArr[c9];
        long[] jArr2 = this.f2696c;
        z zVar = new z(j9, jArr2[c9]);
        if (j9 >= j5 || c9 == this.f2694a - 1) {
            return new x(zVar, zVar);
        }
        int i9 = c9 + 1;
        return new x(zVar, new z(jArr[i9], jArr2[i9]));
    }

    @Override // d2.y
    public final long k() {
        return this.f2699f;
    }

    public final String toString() {
        return "ChunkIndex(length=" + this.f2694a + ", sizes=" + Arrays.toString(this.f2695b) + ", offsets=" + Arrays.toString(this.f2696c) + ", timeUs=" + Arrays.toString(this.f2698e) + ", durationsUs=" + Arrays.toString(this.f2697d) + ")";
    }
}
