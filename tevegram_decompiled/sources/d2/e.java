package d2;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final long f2675a;

    /* renamed from: b, reason: collision with root package name */
    public final long f2676b;

    /* renamed from: c, reason: collision with root package name */
    public final long f2677c;

    /* renamed from: d, reason: collision with root package name */
    public long f2678d = 0;

    /* renamed from: e, reason: collision with root package name */
    public long f2679e;

    /* renamed from: f, reason: collision with root package name */
    public long f2680f;

    /* renamed from: g, reason: collision with root package name */
    public long f2681g;
    public long h;

    public e(long j5, long j9, long j10, long j11, long j12, long j13) {
        this.f2675a = j5;
        this.f2676b = j9;
        this.f2679e = j10;
        this.f2680f = j11;
        this.f2681g = j12;
        this.f2677c = j13;
        this.h = a(j9, 0L, j10, j11, j12, j13);
    }

    public static long a(long j5, long j9, long j10, long j11, long j12, long j13) {
        if (j11 + 1 >= j12 || j9 + 1 >= j10) {
            return j11;
        }
        long j14 = (long) ((j5 - j9) * ((j12 - j11) / (j10 - j9)));
        return g1.w.i(((j14 + j11) - j13) - (j14 / 20), j11, j12 - 1);
    }
}
