package h2;

import a3.g;
import a3.i;
import b6.g0;
import b6.i0;
import d1.j0;
import d1.m0;
import d1.w;
import d2.d0;
import d2.j;
import d2.m;
import d2.n;
import d2.o;
import d2.q;
import d2.y;
import g1.p;
import java.util.Arrays;
import m7.c;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements m {

    /* renamed from: e, reason: collision with root package name */
    public o f3903e;

    /* renamed from: f, reason: collision with root package name */
    public d0 f3904f;
    public j0 h;

    /* renamed from: i, reason: collision with root package name */
    public q f3906i;

    /* renamed from: j, reason: collision with root package name */
    public int f3907j;

    /* renamed from: k, reason: collision with root package name */
    public int f3908k;

    /* renamed from: l, reason: collision with root package name */
    public a f3909l;

    /* renamed from: m, reason: collision with root package name */
    public int f3910m;

    /* renamed from: n, reason: collision with root package name */
    public long f3911n;

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f3899a = new byte[42];

    /* renamed from: b, reason: collision with root package name */
    public final p f3900b = new p(new byte[32768], 0);

    /* renamed from: c, reason: collision with root package name */
    public final boolean f3901c = false;

    /* renamed from: d, reason: collision with root package name */
    public final w f3902d = new w();

    /* renamed from: g, reason: collision with root package name */
    public int f3905g = 0;

    @Override // d2.m
    public final void c(long j5, long j9) {
        if (j5 == 0) {
            this.f3905g = 0;
        } else {
            a aVar = this.f3909l;
            if (aVar != null) {
                aVar.d(j9);
            }
        }
        this.f3911n = j9 != 0 ? -1L : 0L;
        this.f3910m = 0;
        this.f3900b.C(0);
    }

    @Override // d2.m
    public final void d(o oVar) {
        this.f3903e = oVar;
        this.f3904f = oVar.l(0, 1);
        oVar.c();
    }

    @Override // d2.m
    public final boolean g(n nVar) {
        d2.b.p(nVar, false);
        p pVar = new p(4);
        ((j) nVar).n(pVar.f3699a, 0, 4, false);
        return pVar.v() == 1716281667;
    }

    @Override // d2.m
    public final int h(n nVar, w wVar) {
        q qVar;
        int i9;
        y pVar;
        long j5;
        long j9;
        boolean z8;
        int i10 = this.f3905g;
        if (i10 == 0) {
            boolean z9 = !this.f3901c;
            nVar.h();
            long o8 = nVar.o();
            j0 p5 = d2.b.p(nVar, z9);
            nVar.i((int) (nVar.o() - o8));
            this.h = p5;
            this.f3905g = 1;
            return 0;
        }
        byte[] bArr = this.f3899a;
        if (i10 == 1) {
            nVar.a(0, bArr.length, bArr);
            nVar.h();
            this.f3905g = 2;
            return 0;
        }
        int i11 = 4;
        int i12 = 3;
        if (i10 == 2) {
            p pVar2 = new p(4);
            nVar.readFully(pVar2.f3699a, 0, 4);
            if (pVar2.v() != 1716281667) {
                throw m0.a(null, "Failed to read FLAC stream marker.");
            }
            this.f3905g = 3;
            return 0;
        }
        int i13 = 6;
        if (i10 == 3) {
            q qVar2 = this.f3906i;
            boolean z10 = false;
            while (!z10) {
                nVar.h();
                byte[] bArr2 = new byte[i11];
                g gVar = new g(bArr2, i11);
                nVar.a(0, i11, bArr2);
                boolean h = gVar.h();
                int i14 = gVar.i(r10);
                int i15 = gVar.i(24) + i11;
                if (i14 == 0) {
                    byte[] bArr3 = new byte[38];
                    nVar.readFully(bArr3, 0, 38);
                    qVar2 = new q(bArr3, i11);
                } else {
                    if (qVar2 == null) {
                        c.d();
                        return 0;
                    }
                    j0 j0Var = qVar2.f2728l;
                    if (i14 == i12) {
                        p pVar3 = new p(i15);
                        nVar.readFully(pVar3.f3699a, 0, i15);
                        qVar2 = new q(qVar2.f2718a, qVar2.f2719b, qVar2.f2720c, qVar2.f2721d, qVar2.f2722e, qVar2.f2724g, qVar2.h, qVar2.f2726j, d2.b.r(pVar3), qVar2.f2728l);
                    } else {
                        if (i14 == i11) {
                            p pVar4 = new p(i15);
                            nVar.readFully(pVar4.f3699a, 0, i15);
                            pVar4.G(i11);
                            j0 o9 = d2.b.o(Arrays.asList((String[]) d2.b.s(pVar4, false, false).f8j));
                            if (j0Var != null) {
                                o9 = j0Var.e(o9);
                            }
                            qVar = new q(qVar2.f2718a, qVar2.f2719b, qVar2.f2720c, qVar2.f2721d, qVar2.f2722e, qVar2.f2724g, qVar2.h, qVar2.f2726j, qVar2.f2727k, o9);
                        } else if (i14 == i13) {
                            p pVar5 = new p(i15);
                            nVar.readFully(pVar5.f3699a, 0, i15);
                            pVar5.G(4);
                            j0 j0Var2 = new j0(g0.q(o2.a.d(pVar5)));
                            if (j0Var != null) {
                                j0Var2 = j0Var.e(j0Var2);
                            }
                            qVar = new q(qVar2.f2718a, qVar2.f2719b, qVar2.f2720c, qVar2.f2721d, qVar2.f2722e, qVar2.f2724g, qVar2.h, qVar2.f2726j, qVar2.f2727k, j0Var2);
                        } else {
                            nVar.i(i15);
                        }
                        qVar2 = qVar;
                    }
                }
                int i16 = g1.w.f3713a;
                this.f3906i = qVar2;
                z10 = h;
                i11 = 4;
                i12 = 3;
                r10 = 7;
                i13 = 6;
            }
            this.f3906i.getClass();
            this.f3907j = Math.max(this.f3906i.f2720c, 6);
            d0 d0Var = this.f3904f;
            int i17 = g1.w.f3713a;
            d0Var.e(this.f3906i.c(bArr, this.h));
            this.f3905g = 4;
            return 0;
        }
        long j10 = 0;
        if (i10 == 4) {
            nVar.h();
            p pVar6 = new p(2);
            nVar.a(0, 2, pVar6.f3699a);
            int z11 = pVar6.z();
            if ((z11 >> 2) != 16382) {
                nVar.h();
                throw m0.a(null, "First frame does not start with sync code.");
            }
            nVar.h();
            this.f3908k = z11;
            o oVar = this.f3903e;
            int i18 = g1.w.f3713a;
            long position = nVar.getPosition();
            long e9 = nVar.e();
            this.f3906i.getClass();
            q qVar3 = this.f3906i;
            if (qVar3.f2727k != null) {
                pVar = new d2.p(0, position, qVar3);
                i9 = 0;
            } else if (e9 == -1 || qVar3.f2726j <= 0) {
                i9 = 0;
                pVar = new d2.p(qVar3.b());
            } else {
                int i19 = this.f3908k;
                int i20 = qVar3.f2720c;
                i iVar = new i(qVar3, 2);
                i0 i0Var = new i0(qVar3, i19);
                long b9 = qVar3.b();
                long j11 = qVar3.f2726j;
                int i21 = qVar3.f2721d;
                if (i21 > 0) {
                    i9 = 0;
                    j5 = ((i21 + i20) / 2) + 1;
                } else {
                    i9 = 0;
                    int i22 = qVar3.f2718a;
                    j5 = 64 + (((((i22 != qVar3.f2719b || i22 <= 0) ? IjkMediaMeta.AV_CH_TOP_FRONT_LEFT : i22) * qVar3.f2724g) * qVar3.h) / 8);
                }
                a aVar = new a(iVar, i0Var, b9, j11, position, e9, j5, Math.max(6, i20));
                this.f3909l = aVar;
                pVar = aVar.f3895a;
            }
            oVar.t(pVar);
            this.f3905g = 5;
            return i9;
        }
        if (i10 != 5) {
            androidx.fragment.app.a.l();
            return 0;
        }
        this.f3904f.getClass();
        this.f3906i.getClass();
        a aVar2 = this.f3909l;
        if (aVar2 != null && aVar2.f3897c != null) {
            return aVar2.b(nVar, wVar);
        }
        if (this.f3911n == -1) {
            q qVar4 = this.f3906i;
            nVar.h();
            nVar.p(1);
            byte[] bArr4 = new byte[1];
            nVar.a(0, 1, bArr4);
            boolean z12 = (bArr4[0] & 1) == 1;
            nVar.p(2);
            r10 = z12 ? 7 : 6;
            p pVar7 = new p(r10);
            byte[] bArr5 = pVar7.f3699a;
            int i23 = 0;
            while (i23 < r10) {
                int j12 = nVar.j(i23, r10 - i23, bArr5);
                if (j12 == -1) {
                    break;
                }
                i23 += j12;
            }
            pVar7.E(i23);
            nVar.h();
            try {
                long A = pVar7.A();
                if (!z12) {
                    A *= qVar4.f2719b;
                }
                j10 = A;
            } catch (NumberFormatException unused) {
                r3 = false;
            }
            if (!r3) {
                throw m0.a(null, null);
            }
            this.f3911n = j10;
        } else {
            p pVar8 = this.f3900b;
            int i24 = pVar8.f3701c;
            if (i24 < 32768) {
                int read = nVar.read(pVar8.f3699a, i24, 32768 - i24);
                r3 = read == -1;
                if (!r3) {
                    pVar8.E(i24 + read);
                } else if (pVar8.a() == 0) {
                    long j13 = this.f3911n * 1000000;
                    q qVar5 = this.f3906i;
                    int i25 = g1.w.f3713a;
                    this.f3904f.d(j13 / qVar5.f2722e, 1, this.f3910m, 0, null);
                    return -1;
                }
            } else {
                r3 = false;
            }
            int i26 = pVar8.f3700b;
            int i27 = this.f3910m;
            int i28 = this.f3907j;
            if (i27 < i28) {
                pVar8.G(Math.min(i28 - i27, pVar8.a()));
            }
            this.f3906i.getClass();
            int i29 = pVar8.f3700b;
            while (true) {
                int i30 = pVar8.f3701c - 16;
                w wVar2 = this.f3902d;
                if (i29 <= i30) {
                    pVar8.F(i29);
                    if (d2.b.b(pVar8, this.f3906i, this.f3908k, wVar2)) {
                        pVar8.F(i29);
                        j9 = wVar2.f2583a;
                        break;
                    }
                    i29++;
                } else {
                    if (r3) {
                        while (true) {
                            int i31 = pVar8.f3701c;
                            if (i29 > i31 - this.f3907j) {
                                pVar8.F(i31);
                                break;
                            }
                            pVar8.F(i29);
                            try {
                                z8 = d2.b.b(pVar8, this.f3906i, this.f3908k, wVar2);
                            } catch (IndexOutOfBoundsException unused2) {
                                z8 = false;
                            }
                            if (pVar8.f3700b > pVar8.f3701c) {
                                z8 = false;
                            }
                            if (z8) {
                                pVar8.F(i29);
                                j9 = wVar2.f2583a;
                                break;
                            }
                            i29++;
                        }
                    } else {
                        pVar8.F(i29);
                    }
                    j9 = -1;
                }
            }
            int i32 = pVar8.f3700b - i26;
            pVar8.F(i26);
            this.f3904f.c(i32, pVar8);
            int i33 = this.f3910m + i32;
            this.f3910m = i33;
            if (j9 != -1) {
                long j14 = this.f3911n * 1000000;
                q qVar6 = this.f3906i;
                int i34 = g1.w.f3713a;
                this.f3904f.d(j14 / qVar6.f2722e, 1, i33, 0, null);
                this.f3910m = 0;
                this.f3911n = j9;
            }
            if (pVar8.a() < 16) {
                int a9 = pVar8.a();
                byte[] bArr6 = pVar8.f3699a;
                System.arraycopy(bArr6, pVar8.f3700b, bArr6, 0, a9);
                pVar8.F(0);
                pVar8.E(a9);
            }
        }
        return 0;
    }

    @Override // d2.m
    public final m a() {
        return this;
    }

    @Override // d2.m
    public final void release() {
    }
}
