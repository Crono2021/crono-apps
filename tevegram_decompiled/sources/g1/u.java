package g1;

import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public long f3709a;

    /* renamed from: b, reason: collision with root package name */
    public long f3710b;

    /* renamed from: c, reason: collision with root package name */
    public long f3711c;

    /* renamed from: d, reason: collision with root package name */
    public final ThreadLocal f3712d = new ThreadLocal();

    public u(long j5) {
        g(j5);
    }

    public final synchronized long a(long j5) {
        if (j5 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        try {
            if (!f()) {
                long j9 = this.f3709a;
                if (j9 == 9223372036854775806L) {
                    Long l4 = (Long) this.f3712d.get();
                    l4.getClass();
                    j9 = l4.longValue();
                }
                this.f3710b = j9 - j5;
                notifyAll();
            }
            this.f3711c = j5;
            return j5 + this.f3710b;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized long b(long j5) {
        if (j5 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        try {
            long j9 = this.f3711c;
            if (j9 != -9223372036854775807L) {
                long j10 = (j9 * 90000) / 1000000;
                long j11 = (IjkMediaMeta.AV_CH_WIDE_RIGHT + j10) / IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT;
                long j12 = ((j11 - 1) * IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT) + j5;
                long j13 = (j11 * IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT) + j5;
                j5 = Math.abs(j12 - j10) < Math.abs(j13 - j10) ? j12 : j13;
            }
            return a((j5 * 1000000) / 90000);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized long c(long j5) {
        long j9;
        if (j5 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j10 = this.f3711c;
        if (j10 != -9223372036854775807L) {
            long j11 = (j10 * 90000) / 1000000;
            long j12 = j11 / IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT;
            Long.signum(j12);
            long j13 = (j12 * IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT) + j5;
            j9 = ((j12 + 1) * IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT) + j5;
            if (j13 >= j11) {
                j9 = j13;
            }
        } else {
            j9 = j5;
        }
        return a((j9 * 1000000) / 90000);
    }

    public final synchronized long d() {
        long j5;
        j5 = this.f3709a;
        if (j5 == Long.MAX_VALUE || j5 == 9223372036854775806L) {
            j5 = -9223372036854775807L;
        }
        return j5;
    }

    public final synchronized long e() {
        return this.f3710b;
    }

    public final synchronized boolean f() {
        return this.f3710b != -9223372036854775807L;
    }

    public final synchronized void g(long j5) {
        this.f3709a = j5;
        this.f3710b = j5 == Long.MAX_VALUE ? 0L : -9223372036854775807L;
        this.f3711c = -9223372036854775807L;
    }

    public final synchronized void h(long j5, boolean z8) {
        try {
            a.k(this.f3709a == 9223372036854775806L);
            if (f()) {
                return;
            }
            if (z8) {
                this.f3712d.set(Long.valueOf(j5));
            } else {
                while (!f()) {
                    wait();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
