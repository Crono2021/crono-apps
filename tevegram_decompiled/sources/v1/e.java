package v1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e extends o {

    /* renamed from: c, reason: collision with root package name */
    public final long f9267c;

    /* renamed from: d, reason: collision with root package name */
    public final long f9268d;

    /* renamed from: e, reason: collision with root package name */
    public final long f9269e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f9270f;

    public e(d1.y0 y0Var, long j5, long j9) {
        super(y0Var);
        boolean z8 = false;
        if (y0Var.h() != 1) {
            throw new f(0);
        }
        d1.x0 m9 = y0Var.m(0, new d1.x0(), 0L);
        long max = Math.max(0L, j5);
        if (!m9.f2604l && max != 0 && !m9.h) {
            throw new f(1);
        }
        long max2 = j9 == Long.MIN_VALUE ? m9.f2606n : Math.max(0L, j9);
        long j10 = m9.f2606n;
        if (j10 != -9223372036854775807L) {
            max2 = max2 > j10 ? j10 : max2;
            if (max > max2) {
                throw new f(2);
            }
        }
        this.f9267c = max;
        this.f9268d = max2;
        this.f9269e = max2 != -9223372036854775807L ? max2 - max : -9223372036854775807L;
        if (m9.f2601i && (max2 == -9223372036854775807L || (j10 != -9223372036854775807L && max2 == j10))) {
            z8 = true;
        }
        this.f9270f = z8;
    }

    @Override // v1.o, d1.y0
    public final d1.w0 f(int i9, d1.w0 w0Var, boolean z8) {
        this.f9357b.f(0, w0Var, z8);
        long j5 = w0Var.f2588e - this.f9267c;
        long j9 = this.f9269e;
        w0Var.h(w0Var.f2584a, w0Var.f2585b, 0, j9 != -9223372036854775807L ? j9 - j5 : -9223372036854775807L, j5, d1.c.f2367c, false);
        return w0Var;
    }

    @Override // v1.o, d1.y0
    public final d1.x0 m(int i9, d1.x0 x0Var, long j5) {
        this.f9357b.m(0, x0Var, 0L);
        long j9 = x0Var.f2609q;
        long j10 = this.f9267c;
        x0Var.f2609q = j9 + j10;
        x0Var.f2606n = this.f9269e;
        x0Var.f2601i = this.f9270f;
        long j11 = x0Var.f2605m;
        if (j11 != -9223372036854775807L) {
            long max = Math.max(j11, j10);
            x0Var.f2605m = max;
            long j12 = this.f9268d;
            if (j12 != -9223372036854775807L) {
                max = Math.min(max, j12);
            }
            x0Var.f2605m = max - j10;
        }
        long W = g1.w.W(j10);
        long j13 = x0Var.f2598e;
        if (j13 != -9223372036854775807L) {
            x0Var.f2598e = j13 + W;
        }
        long j14 = x0Var.f2599f;
        if (j14 != -9223372036854775807L) {
            x0Var.f2599f = j14 + W;
        }
        return x0Var;
    }
}
