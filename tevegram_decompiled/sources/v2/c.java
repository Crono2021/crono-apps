package v2;

import android.util.Pair;
import d2.x;
import d2.z;
import g1.w;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c implements f {

    /* renamed from: a, reason: collision with root package name */
    public final long[] f9471a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f9472b;

    /* renamed from: c, reason: collision with root package name */
    public final long f9473c;

    public c(long j5, long[] jArr, long[] jArr2) {
        this.f9471a = jArr;
        this.f9472b = jArr2;
        this.f9473c = j5 == -9223372036854775807L ? w.M(jArr2[jArr2.length - 1]) : j5;
    }

    public static Pair a(long j5, long[] jArr, long[] jArr2) {
        int c9 = w.c(j5, jArr, true);
        long j9 = jArr[c9];
        long j10 = jArr2[c9];
        int i9 = c9 + 1;
        if (i9 == jArr.length) {
            return Pair.create(Long.valueOf(j9), Long.valueOf(j10));
        }
        return Pair.create(Long.valueOf(j5), Long.valueOf(((long) ((jArr[i9] == j9 ? 0.0d : (j5 - j9) / (r6 - j9)) * (jArr2[i9] - j10))) + j10));
    }

    @Override // v2.f
    public final long b() {
        return -1L;
    }

    @Override // d2.y
    public final boolean e() {
        return true;
    }

    @Override // v2.f
    public final long f(long j5) {
        return w.M(((Long) a(j5, this.f9471a, this.f9472b).second).longValue());
    }

    @Override // d2.y
    public final x i(long j5) {
        Pair a9 = a(w.W(w.i(j5, 0L, this.f9473c)), this.f9472b, this.f9471a);
        z zVar = new z(w.M(((Long) a9.first).longValue()), ((Long) a9.second).longValue());
        return new x(zVar, zVar);
    }

    @Override // v2.f
    public final int j() {
        return -2147483647;
    }

    @Override // d2.y
    public final long k() {
        return this.f9473c;
    }
}
