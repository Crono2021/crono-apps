package v2;

import d2.x;
import d2.z;
import g1.w;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h implements f {

    /* renamed from: a, reason: collision with root package name */
    public final long f9497a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9498b;

    /* renamed from: c, reason: collision with root package name */
    public final long f9499c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9500d;

    /* renamed from: e, reason: collision with root package name */
    public final long f9501e;

    /* renamed from: f, reason: collision with root package name */
    public final long f9502f;

    /* renamed from: g, reason: collision with root package name */
    public final long[] f9503g;

    public h(long j5, int i9, long j9, int i10, long j10, long[] jArr) {
        this.f9497a = j5;
        this.f9498b = i9;
        this.f9499c = j9;
        this.f9500d = i10;
        this.f9501e = j10;
        this.f9503g = jArr;
        this.f9502f = j10 != -1 ? j5 + j10 : -1L;
    }

    @Override // v2.f
    public final long b() {
        return this.f9502f;
    }

    @Override // d2.y
    public final boolean e() {
        return this.f9503g != null;
    }

    @Override // v2.f
    public final long f(long j5) {
        long j9 = j5 - this.f9497a;
        if (!e() || j9 <= this.f9498b) {
            return 0L;
        }
        long[] jArr = this.f9503g;
        g1.a.l(jArr);
        double d9 = (j9 * 256.0d) / this.f9501e;
        int c9 = w.c((long) d9, jArr, true);
        long j10 = this.f9499c;
        long j11 = (c9 * j10) / 100;
        long j12 = jArr[c9];
        int i9 = c9 + 1;
        long j13 = (j10 * i9) / 100;
        return Math.round((j12 == (c9 == 99 ? 256L : jArr[i9]) ? 0.0d : (d9 - j12) / (r0 - j12)) * (j13 - j11)) + j11;
    }

    @Override // d2.y
    public final x i(long j5) {
        double d9;
        double d10;
        boolean e9 = e();
        int i9 = this.f9498b;
        long j9 = this.f9497a;
        if (!e9) {
            z zVar = new z(0L, j9 + i9);
            return new x(zVar, zVar);
        }
        long i10 = w.i(j5, 0L, this.f9499c);
        double d11 = (i10 * 100.0d) / this.f9499c;
        double d12 = 0.0d;
        if (d11 <= 0.0d) {
            d9 = 256.0d;
        } else if (d11 >= 100.0d) {
            d9 = 256.0d;
            d12 = 256.0d;
        } else {
            int i11 = (int) d11;
            long[] jArr = this.f9503g;
            g1.a.l(jArr);
            double d13 = jArr[i11];
            if (i11 == 99) {
                d9 = 256.0d;
                d10 = 256.0d;
            } else {
                d9 = 256.0d;
                d10 = jArr[i11 + 1];
            }
            d12 = ((d10 - d13) * (d11 - i11)) + d13;
        }
        long j10 = this.f9501e;
        z zVar2 = new z(i10, j9 + w.i(Math.round((d12 / d9) * j10), i9, j10 - 1));
        return new x(zVar2, zVar2);
    }

    @Override // v2.f
    public final int j() {
        return this.f9500d;
    }

    @Override // d2.y
    public final long k() {
        return this.f9499c;
    }
}
