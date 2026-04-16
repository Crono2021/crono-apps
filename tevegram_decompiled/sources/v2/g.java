package v2;

import d2.x;
import d2.z;
import g1.w;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g implements f {

    /* renamed from: a, reason: collision with root package name */
    public final long[] f9492a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f9493b;

    /* renamed from: c, reason: collision with root package name */
    public final long f9494c;

    /* renamed from: d, reason: collision with root package name */
    public final long f9495d;

    /* renamed from: e, reason: collision with root package name */
    public final int f9496e;

    public g(long[] jArr, long[] jArr2, long j5, long j9, int i9) {
        this.f9492a = jArr;
        this.f9493b = jArr2;
        this.f9494c = j5;
        this.f9495d = j9;
        this.f9496e = i9;
    }

    @Override // v2.f
    public final long b() {
        return this.f9495d;
    }

    @Override // d2.y
    public final boolean e() {
        return true;
    }

    @Override // v2.f
    public final long f(long j5) {
        return this.f9492a[w.c(j5, this.f9493b, true)];
    }

    @Override // d2.y
    public final x i(long j5) {
        long[] jArr = this.f9492a;
        int c9 = w.c(j5, jArr, true);
        long j9 = jArr[c9];
        long[] jArr2 = this.f9493b;
        z zVar = new z(j9, jArr2[c9]);
        if (j9 >= j5 || c9 == jArr.length - 1) {
            return new x(zVar, zVar);
        }
        int i9 = c9 + 1;
        return new x(zVar, new z(jArr[i9], jArr2[i9]));
    }

    @Override // v2.f
    public final int j() {
        return this.f9496e;
    }

    @Override // d2.y
    public final long k() {
        return this.f9494c;
    }
}
