package i3;

import android.util.SparseArray;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class y implements d2.m {

    /* renamed from: e, reason: collision with root package name */
    public boolean f4693e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f4694f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f4695g;
    public long h;

    /* renamed from: i, reason: collision with root package name */
    public h2.a f4696i;

    /* renamed from: j, reason: collision with root package name */
    public d2.o f4697j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f4698k;

    /* renamed from: a, reason: collision with root package name */
    public final g1.u f4689a = new g1.u(0);

    /* renamed from: c, reason: collision with root package name */
    public final g1.p f4691c = new g1.p(4096);

    /* renamed from: b, reason: collision with root package name */
    public final SparseArray f4690b = new SparseArray();

    /* renamed from: d, reason: collision with root package name */
    public final w f4692d = new w(0);

    @Override // d2.m
    public final void c(long j5, long j9) {
        g1.u uVar = this.f4689a;
        boolean z8 = uVar.e() == -9223372036854775807L;
        if (!z8) {
            long d9 = uVar.d();
            z8 = (d9 == -9223372036854775807L || d9 == 0 || d9 == j9) ? false : true;
        }
        if (z8) {
            uVar.g(j9);
        }
        h2.a aVar = this.f4696i;
        if (aVar != null) {
            aVar.d(j9);
        }
        int i9 = 0;
        while (true) {
            SparseArray sparseArray = this.f4690b;
            if (i9 >= sparseArray.size()) {
                return;
            }
            x xVar = (x) sparseArray.valueAt(i9);
            xVar.f4687f = false;
            xVar.f4682a.a();
            i9++;
        }
    }

    @Override // d2.m
    public final void d(d2.o oVar) {
        this.f4697j = oVar;
    }

    @Override // d2.m
    public final boolean g(d2.n nVar) {
        byte[] bArr = new byte[14];
        d2.j jVar = (d2.j) nVar;
        jVar.n(bArr, 0, 14, false);
        if (442 == (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) && (bArr[4] & 196) == 68 && (bArr[6] & 4) == 4 && (bArr[8] & 4) == 4 && (bArr[9] & 1) == 1 && (bArr[12] & 3) == 3) {
            jVar.c(bArr[13] & 7, false);
            jVar.n(bArr, 0, 3, false);
            if (1 == (((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8) | (bArr[2] & 255))) {
                return true;
            }
        }
        return false;
    }

    @Override // d2.m
    public final int h(d2.n nVar, d1.w wVar) {
        int i9;
        int i10;
        g1.u uVar;
        h hVar;
        long j5;
        long j9;
        g1.a.l(this.f4697j);
        long e9 = nVar.e();
        w wVar2 = this.f4692d;
        if (e9 != -1 && !wVar2.f4677d) {
            g1.u uVar2 = wVar2.f4675b;
            g1.p pVar = wVar2.f4676c;
            if (!wVar2.f4679f) {
                long e10 = nVar.e();
                int min = (int) Math.min(20000L, e10);
                long j10 = e10 - min;
                if (nVar.getPosition() != j10) {
                    wVar.f2583a = j10;
                    return 1;
                }
                pVar.C(min);
                nVar.h();
                nVar.a(0, min, pVar.f3699a);
                int i11 = pVar.f3700b;
                int i12 = pVar.f3701c - 4;
                while (true) {
                    if (i12 < i11) {
                        j9 = -9223372036854775807L;
                        break;
                    }
                    if (w.b(pVar.f3699a, i12) == 442) {
                        pVar.F(i12 + 4);
                        long c9 = w.c(pVar);
                        if (c9 != -9223372036854775807L) {
                            j9 = c9;
                            break;
                        }
                    }
                    i12--;
                }
                wVar2.h = j9;
                wVar2.f4679f = true;
                return 0;
            }
            if (wVar2.h == -9223372036854775807L) {
                wVar2.a(nVar);
                return 0;
            }
            if (wVar2.f4678e) {
                long j11 = wVar2.f4680g;
                if (j11 == -9223372036854775807L) {
                    wVar2.a(nVar);
                    return 0;
                }
                wVar2.f4681i = uVar2.c(wVar2.h) - uVar2.b(j11);
                wVar2.a(nVar);
                return 0;
            }
            int min2 = (int) Math.min(20000L, nVar.e());
            long j12 = 0;
            if (nVar.getPosition() != j12) {
                wVar.f2583a = j12;
                return 1;
            }
            pVar.C(min2);
            nVar.h();
            nVar.a(0, min2, pVar.f3699a);
            int i13 = pVar.f3700b;
            int i14 = pVar.f3701c;
            while (true) {
                if (i13 >= i14 - 3) {
                    j5 = -9223372036854775807L;
                    break;
                }
                if (w.b(pVar.f3699a, i13) == 442) {
                    pVar.F(i13 + 4);
                    long c10 = w.c(pVar);
                    if (c10 != -9223372036854775807L) {
                        j5 = c10;
                        break;
                    }
                }
                i13++;
            }
            wVar2.f4680g = j5;
            wVar2.f4678e = true;
            return 0;
        }
        if (this.f4698k) {
            i9 = 4;
        } else {
            this.f4698k = true;
            long j13 = wVar2.f4681i;
            if (j13 != -9223372036854775807L) {
                g1.u uVar3 = wVar2.f4675b;
                u5.e eVar = new u5.e(26);
                a5.d dVar = new a5.d(uVar3);
                long j14 = 1 + j13;
                i9 = 4;
                h2.a aVar = new h2.a(eVar, dVar, j13, j14, 0L, e9, 188L, IjkMediaCodecInfo.RANK_MAX);
                this.f4696i = aVar;
                this.f4697j.t(aVar.f3895a);
            } else {
                i9 = 4;
                this.f4697j.t(new d2.p(j13));
            }
        }
        h2.a aVar2 = this.f4696i;
        if (aVar2 != null && aVar2.f3897c != null) {
            return aVar2.b(nVar, wVar);
        }
        nVar.h();
        long o8 = e9 != -1 ? e9 - nVar.o() : -1L;
        if (o8 != -1 && o8 < 4) {
            return -1;
        }
        g1.p pVar2 = this.f4691c;
        if (!nVar.n(pVar2.f3699a, 0, i9, true)) {
            return -1;
        }
        pVar2.F(0);
        int g9 = pVar2.g();
        if (g9 == 441) {
            return -1;
        }
        if (g9 == 442) {
            nVar.a(0, 10, pVar2.f3699a);
            pVar2.F(9);
            nVar.i((pVar2.t() & 7) + 14);
            return 0;
        }
        if (g9 == 443) {
            nVar.a(0, 2, pVar2.f3699a);
            pVar2.F(0);
            nVar.i(pVar2.z() + 6);
            return 0;
        }
        if (((g9 & (-256)) >> 8) != 1) {
            nVar.i(1);
            return 0;
        }
        int i15 = g9 & 255;
        SparseArray sparseArray = this.f4690b;
        x xVar = (x) sparseArray.get(i15);
        if (!this.f4693e) {
            if (xVar == null) {
                if (i15 == 189) {
                    hVar = new b();
                    this.f4694f = true;
                    this.h = nVar.getPosition();
                } else if ((g9 & 224) == 192) {
                    hVar = new t(null, 0);
                    this.f4694f = true;
                    this.h = nVar.getPosition();
                } else if ((g9 & 240) == 224) {
                    hVar = new j(null);
                    this.f4695g = true;
                    this.h = nVar.getPosition();
                } else {
                    hVar = null;
                }
                if (hVar != null) {
                    hVar.f(this.f4697j, new e0(i15, 256));
                    xVar = new x(hVar, this.f4689a);
                    sparseArray.put(i15, xVar);
                }
            }
            if (nVar.getPosition() > ((this.f4694f && this.f4695g) ? this.h + IjkMediaMeta.AV_CH_TOP_FRONT_CENTER : 1048576L)) {
                this.f4693e = true;
                this.f4697j.c();
            }
        }
        nVar.a(0, 2, pVar2.f3699a);
        pVar2.F(0);
        int z8 = pVar2.z() + 6;
        if (xVar == null) {
            nVar.i(z8);
            return 0;
        }
        pVar2.C(z8);
        nVar.readFully(pVar2.f3699a, 0, z8);
        pVar2.F(6);
        h hVar2 = xVar.f4682a;
        a3.g gVar = xVar.f4684c;
        pVar2.e(0, 3, gVar.f104b);
        gVar.p(0);
        gVar.s(8);
        xVar.f4685d = gVar.h();
        xVar.f4686e = gVar.h();
        gVar.s(6);
        pVar2.e(0, gVar.i(8), gVar.f104b);
        gVar.p(0);
        g1.u uVar4 = xVar.f4683b;
        xVar.f4688g = 0L;
        if (xVar.f4685d) {
            gVar.s(i9);
            gVar.s(1);
            gVar.s(1);
            long i16 = (gVar.i(3) << 30) | (gVar.i(15) << 15) | gVar.i(15);
            gVar.s(1);
            if (xVar.f4687f || !xVar.f4686e) {
                uVar = uVar4;
                i10 = 0;
            } else {
                gVar.s(i9);
                gVar.s(1);
                uVar = uVar4;
                i10 = 0;
                gVar.s(1);
                gVar.s(1);
                uVar.b((gVar.i(15) << 15) | (gVar.i(3) << 30) | gVar.i(15));
                xVar.f4687f = true;
            }
            xVar.f4688g = uVar.b(i16);
        } else {
            i10 = 0;
        }
        hVar2.d(i9, xVar.f4688g);
        hVar2.c(pVar2);
        hVar2.e();
        pVar2.E(pVar2.f3699a.length);
        return i10;
    }

    @Override // d2.m
    public final d2.m a() {
        return this;
    }

    @Override // d2.m
    public final void release() {
    }
}
