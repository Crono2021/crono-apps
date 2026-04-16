package v1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class q0 implements x2.g {

    /* renamed from: i, reason: collision with root package name */
    public long f9380i;

    /* renamed from: j, reason: collision with root package name */
    public long f9381j;

    /* renamed from: k, reason: collision with root package name */
    public Object f9382k;

    /* renamed from: l, reason: collision with root package name */
    public Object f9383l;

    public q0(long j5, int i9) {
        g1.a.k(((z1.a) this.f9382k) == null);
        this.f9380i = j5;
        this.f9381j = j5 + i9;
    }

    @Override // x2.g
    public d2.y e() {
        g1.a.k(this.f9380i != -1);
        return new d2.p(0, this.f9380i, (d2.q) this.f9382k);
    }

    @Override // x2.g
    public long f(d2.n nVar) {
        long j5 = this.f9381j;
        if (j5 < 0) {
            return -1L;
        }
        long j9 = -(j5 + 2);
        this.f9381j = -1L;
        return j9;
    }

    @Override // x2.g
    public void p(long j5) {
        long[] jArr = (long[]) ((a5.d) this.f9383l).f174j;
        this.f9381j = jArr[g1.w.c(j5, jArr, true)];
    }

    public q0(String str, byte[] bArr, long j5, long j9) {
        this.f9382k = str;
        this.f9383l = bArr;
        this.f9380i = j5;
        this.f9381j = j9;
    }
}
