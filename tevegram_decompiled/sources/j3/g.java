package j3;

import d2.x;
import d2.y;
import d2.z;
import g1.w;
import java.math.RoundingMode;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g implements y {

    /* renamed from: a, reason: collision with root package name */
    public final e f5422a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5423b;

    /* renamed from: c, reason: collision with root package name */
    public final long f5424c;

    /* renamed from: d, reason: collision with root package name */
    public final long f5425d;

    /* renamed from: e, reason: collision with root package name */
    public final long f5426e;

    public g(e eVar, int i9, long j5, long j9) {
        this.f5422a = eVar;
        this.f5423b = i9;
        this.f5424c = j5;
        long j10 = (j9 - j5) / eVar.f5417d;
        this.f5425d = j10;
        this.f5426e = a(j10);
    }

    public final long a(long j5) {
        long j9 = j5 * this.f5423b;
        long j10 = this.f5422a.f5416c;
        int i9 = w.f3713a;
        return w.S(j9, 1000000L, j10, RoundingMode.FLOOR);
    }

    @Override // d2.y
    public final boolean e() {
        return true;
    }

    @Override // d2.y
    public final x i(long j5) {
        e eVar = this.f5422a;
        long j9 = this.f5425d - 1;
        long i9 = w.i((eVar.f5416c * j5) / (this.f5423b * 1000000), 0L, j9);
        int i10 = eVar.f5417d;
        long j10 = this.f5424c;
        long a9 = a(i9);
        z zVar = new z(a9, (i10 * i9) + j10);
        if (a9 >= j5 || i9 == j9) {
            return new x(zVar, zVar);
        }
        long j11 = i9 + 1;
        return new x(zVar, new z(a(j11), (i10 * j11) + j10));
    }

    @Override // d2.y
    public final long k() {
        return this.f5426e;
    }
}
