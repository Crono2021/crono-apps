package x2;

import d2.y;
import g1.w;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements g {

    /* renamed from: i, reason: collision with root package name */
    public final f f10043i;

    /* renamed from: j, reason: collision with root package name */
    public final long f10044j;

    /* renamed from: k, reason: collision with root package name */
    public final long f10045k;

    /* renamed from: l, reason: collision with root package name */
    public final i f10046l;

    /* renamed from: m, reason: collision with root package name */
    public int f10047m;

    /* renamed from: n, reason: collision with root package name */
    public long f10048n;

    /* renamed from: o, reason: collision with root package name */
    public long f10049o;

    /* renamed from: p, reason: collision with root package name */
    public long f10050p;

    /* renamed from: q, reason: collision with root package name */
    public long f10051q;

    /* renamed from: r, reason: collision with root package name */
    public long f10052r;

    /* renamed from: s, reason: collision with root package name */
    public long f10053s;

    /* renamed from: t, reason: collision with root package name */
    public long f10054t;

    public b(i iVar, long j5, long j9, long j10, long j11, boolean z8) {
        g1.a.f(j5 >= 0 && j9 > j5);
        this.f10046l = iVar;
        this.f10044j = j5;
        this.f10045k = j9;
        if (j10 == j9 - j5 || z8) {
            this.f10048n = j11;
            this.f10047m = 4;
        } else {
            this.f10047m = 0;
        }
        this.f10043i = new f();
    }

    @Override // x2.g
    public final y e() {
        if (this.f10048n != 0) {
            return new a(this);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00c4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c5  */
    @Override // x2.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long f(d2.n r28) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.b.f(d2.n):long");
    }

    @Override // x2.g
    public final void p(long j5) {
        this.f10050p = w.i(j5, 0L, this.f10048n - 1);
        this.f10047m = 2;
        this.f10051q = this.f10044j;
        this.f10052r = this.f10045k;
        this.f10053s = 0L;
        this.f10054t = this.f10048n;
    }
}
