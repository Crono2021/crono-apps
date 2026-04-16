package v2;

import d2.w;
import d2.x;
import d2.y;
import d2.z;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements f, y {

    /* renamed from: a, reason: collision with root package name */
    public final long f9464a;

    /* renamed from: b, reason: collision with root package name */
    public final long f9465b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9466c;

    /* renamed from: d, reason: collision with root package name */
    public final long f9467d;

    /* renamed from: e, reason: collision with root package name */
    public final int f9468e;

    /* renamed from: f, reason: collision with root package name */
    public final long f9469f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f9470g;
    public final int h;

    public a(long j5, long j9, w wVar, boolean z8) {
        int i9 = wVar.f2750e;
        int i10 = wVar.f2747b;
        this.f9464a = j5;
        this.f9465b = j9;
        this.f9466c = i10 == -1 ? 1 : i10;
        this.f9468e = i9;
        this.f9470g = z8;
        if (j5 == -1) {
            this.f9467d = -1L;
            this.f9469f = -9223372036854775807L;
        } else {
            long j10 = j5 - j9;
            this.f9467d = j10;
            this.f9469f = (Math.max(0L, j10) * 8000000) / i9;
        }
        this.h = wVar.f2750e;
    }

    @Override // v2.f
    public final long b() {
        return -1L;
    }

    @Override // d2.y
    public final boolean e() {
        return this.f9467d != -1 || this.f9470g;
    }

    @Override // v2.f
    public final long f(long j5) {
        return (Math.max(0L, j5 - this.f9465b) * 8000000) / this.f9468e;
    }

    @Override // d2.y
    public final x i(long j5) {
        long j9 = this.f9465b;
        long j10 = this.f9467d;
        if (j10 == -1 && !this.f9470g) {
            z zVar = new z(0L, j9);
            return new x(zVar, zVar);
        }
        int i9 = this.f9468e;
        long j11 = this.f9466c;
        long j12 = (((i9 * j5) / 8000000) / j11) * j11;
        if (j10 != -1) {
            j12 = Math.min(j12, j10 - j11);
        }
        long max = Math.max(j12, 0L) + j9;
        long max2 = (Math.max(0L, max - j9) * 8000000) / i9;
        z zVar2 = new z(max2, max);
        if (j10 != -1 && max2 < j5) {
            long j13 = max + j11;
            if (j13 < this.f9464a) {
                return new x(zVar2, new z((Math.max(0L, j13 - j9) * 8000000) / i9, j13));
            }
        }
        return new x(zVar2, zVar2);
    }

    @Override // v2.f
    public final int j() {
        return this.h;
    }

    @Override // d2.y
    public final long k() {
        return this.f9469f;
    }
}
