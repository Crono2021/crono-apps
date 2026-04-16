package i3;

import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d implements d2.m {

    /* renamed from: c, reason: collision with root package name */
    public final g1.p f4450c;

    /* renamed from: d, reason: collision with root package name */
    public final a3.g f4451d;

    /* renamed from: e, reason: collision with root package name */
    public d2.o f4452e;

    /* renamed from: f, reason: collision with root package name */
    public long f4453f;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f4455i;

    /* renamed from: a, reason: collision with root package name */
    public final e f4448a = new e(null, 0, true);

    /* renamed from: b, reason: collision with root package name */
    public final g1.p f4449b = new g1.p(IjkMediaMeta.FF_PROFILE_H264_INTRA);

    /* renamed from: g, reason: collision with root package name */
    public long f4454g = -1;

    public d(int i9) {
        g1.p pVar = new g1.p(10);
        this.f4450c = pVar;
        byte[] bArr = pVar.f3699a;
        this.f4451d = new a3.g(bArr, bArr.length);
    }

    @Override // d2.m
    public final void c(long j5, long j9) {
        this.h = false;
        this.f4448a.a();
        this.f4453f = j9;
    }

    @Override // d2.m
    public final void d(d2.o oVar) {
        this.f4452e = oVar;
        this.f4448a.f(oVar, new e0(0, 1));
        oVar.c();
    }

    @Override // d2.m
    public final boolean g(d2.n nVar) {
        int i9 = 0;
        while (true) {
            g1.p pVar = this.f4450c;
            nVar.a(0, 10, pVar.f3699a);
            pVar.F(0);
            if (pVar.w() != 4801587) {
                break;
            }
            pVar.G(3);
            int s8 = pVar.s();
            i9 += s8 + 10;
            nVar.p(s8);
        }
        nVar.h();
        nVar.p(i9);
        if (this.f4454g == -1) {
            this.f4454g = i9;
        }
        int i10 = i9;
        int i11 = 0;
        int i12 = 0;
        do {
            g1.p pVar2 = this.f4450c;
            d2.j jVar = (d2.j) nVar;
            jVar.n(pVar2.f3699a, 0, 2, false);
            pVar2.F(0);
            if ((pVar2.z() & 65526) == 65520) {
                i11++;
                if (i11 >= 4 && i12 > 188) {
                    return true;
                }
                jVar.n(pVar2.f3699a, 0, 4, false);
                a3.g gVar = this.f4451d;
                gVar.p(14);
                int i13 = gVar.i(13);
                if (i13 <= 6) {
                    i10++;
                    jVar.f2705n = 0;
                    jVar.c(i10, false);
                } else {
                    jVar.c(i13 - 6, false);
                    i12 += i13;
                }
            } else {
                i10++;
                jVar.f2705n = 0;
                jVar.c(i10, false);
            }
            i11 = 0;
            i12 = 0;
        } while (i10 - i9 < 8192);
        return false;
    }

    @Override // d2.m
    public final int h(d2.n nVar, d1.w wVar) {
        g1.a.l(this.f4452e);
        nVar.e();
        g1.p pVar = this.f4449b;
        int read = nVar.read(pVar.f3699a, 0, IjkMediaMeta.FF_PROFILE_H264_INTRA);
        boolean z8 = read == -1;
        if (!this.f4455i) {
            this.f4452e.t(new d2.p(-9223372036854775807L));
            this.f4455i = true;
        }
        if (z8) {
            return -1;
        }
        pVar.F(0);
        pVar.E(read);
        boolean z9 = this.h;
        e eVar = this.f4448a;
        if (!z9) {
            eVar.f4477t = this.f4453f;
            this.h = true;
        }
        eVar.c(pVar);
        return 0;
    }

    @Override // d2.m
    public final d2.m a() {
        return this;
    }

    @Override // d2.m
    public final void release() {
    }
}
