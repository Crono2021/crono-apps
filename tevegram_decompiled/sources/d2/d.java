package d2;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d implements y {

    /* renamed from: a, reason: collision with root package name */
    public final f f2669a;

    /* renamed from: b, reason: collision with root package name */
    public final long f2670b;

    /* renamed from: c, reason: collision with root package name */
    public final long f2671c;

    /* renamed from: d, reason: collision with root package name */
    public final long f2672d;

    /* renamed from: e, reason: collision with root package name */
    public final long f2673e;

    /* renamed from: f, reason: collision with root package name */
    public final long f2674f;

    public d(f fVar, long j5, long j9, long j10, long j11, long j12) {
        this.f2669a = fVar;
        this.f2670b = j5;
        this.f2671c = j9;
        this.f2672d = j10;
        this.f2673e = j11;
        this.f2674f = j12;
    }

    @Override // d2.y
    public final boolean e() {
        return true;
    }

    @Override // d2.y
    public final x i(long j5) {
        z zVar = new z(j5, e.a(this.f2669a.e(j5), 0L, this.f2671c, this.f2672d, this.f2673e, this.f2674f));
        return new x(zVar, zVar);
    }

    @Override // d2.y
    public final long k() {
        return this.f2670b;
    }
}
