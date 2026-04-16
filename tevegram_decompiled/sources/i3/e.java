package i3;

import d1.l0;
import java.util.Arrays;
import java.util.Collections;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e implements h {

    /* renamed from: w, reason: collision with root package name */
    public static final byte[] f4458w = {73, 68, 51};

    /* renamed from: a, reason: collision with root package name */
    public final boolean f4459a;

    /* renamed from: d, reason: collision with root package name */
    public final String f4462d;

    /* renamed from: e, reason: collision with root package name */
    public final int f4463e;

    /* renamed from: f, reason: collision with root package name */
    public String f4464f;

    /* renamed from: g, reason: collision with root package name */
    public d2.d0 f4465g;
    public d2.d0 h;

    /* renamed from: l, reason: collision with root package name */
    public boolean f4469l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f4470m;

    /* renamed from: p, reason: collision with root package name */
    public int f4473p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f4474q;

    /* renamed from: s, reason: collision with root package name */
    public int f4476s;

    /* renamed from: u, reason: collision with root package name */
    public d2.d0 f4478u;

    /* renamed from: v, reason: collision with root package name */
    public long f4479v;

    /* renamed from: b, reason: collision with root package name */
    public final a3.g f4460b = new a3.g(new byte[7], 7);

    /* renamed from: c, reason: collision with root package name */
    public final g1.p f4461c = new g1.p(Arrays.copyOf(f4458w, 10));

    /* renamed from: i, reason: collision with root package name */
    public int f4466i = 0;

    /* renamed from: j, reason: collision with root package name */
    public int f4467j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f4468k = 256;

    /* renamed from: n, reason: collision with root package name */
    public int f4471n = -1;

    /* renamed from: o, reason: collision with root package name */
    public int f4472o = -1;

    /* renamed from: r, reason: collision with root package name */
    public long f4475r = -9223372036854775807L;

    /* renamed from: t, reason: collision with root package name */
    public long f4477t = -9223372036854775807L;

    public e(String str, int i9, boolean z8) {
        this.f4459a = z8;
        this.f4462d = str;
        this.f4463e = i9;
    }

    @Override // i3.h
    public final void a() {
        this.f4477t = -9223372036854775807L;
        this.f4470m = false;
        this.f4466i = 0;
        this.f4467j = 0;
        this.f4468k = 256;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i3.h
    public final void c(g1.p pVar) {
        int i9;
        byte b9;
        int i10;
        this.f4465g.getClass();
        int i11 = g1.w.f3713a;
        while (pVar.a() > 0) {
            int i12 = this.f4466i;
            g1.p pVar2 = this.f4461c;
            a3.g gVar = this.f4460b;
            int i13 = 0;
            int i14 = 4;
            int i15 = 1;
            if (i12 == 0) {
                byte[] bArr = pVar.f3699a;
                int i16 = pVar.f3700b;
                int i17 = pVar.f3701c;
                while (true) {
                    if (i16 >= i17) {
                        pVar.F(i16);
                        break;
                    }
                    i9 = i16 + 1;
                    b9 = bArr[i16];
                    int i18 = b9 & 255;
                    if (this.f4468k == 512 && ((65280 | (((byte) i18) & 255 ? 1 : 0) ? 1 : 0) & 65526) == 65520) {
                        if (!this.f4470m) {
                            int i19 = i16 - 1;
                            pVar.F(i16);
                            byte[] bArr2 = gVar.f104b;
                            if (pVar.a() >= i15) {
                                pVar.e(i13, i15, bArr2);
                                gVar.p(i14);
                                int i20 = gVar.i(i15);
                                int i21 = this.f4471n;
                                if (i21 == -1 || i20 == i21) {
                                    if (this.f4472o != -1) {
                                        byte[] bArr3 = gVar.f104b;
                                        if (pVar.a() < i15) {
                                            break;
                                        }
                                        pVar.e(i13, i15, bArr3);
                                        gVar.p(2);
                                        i10 = 4;
                                        if (gVar.i(4) == this.f4472o) {
                                            pVar.F(i9);
                                        }
                                    } else {
                                        i10 = 4;
                                    }
                                    byte[] bArr4 = gVar.f104b;
                                    if (pVar.a() >= i10) {
                                        pVar.e(i13, i10, bArr4);
                                        gVar.p(14);
                                        int i22 = gVar.i(13);
                                        if (i22 >= 7) {
                                            byte[] bArr5 = pVar.f3699a;
                                            int i23 = pVar.f3701c;
                                            int i24 = i19 + i22;
                                            if (i24 >= i23) {
                                                break;
                                            }
                                            byte b10 = bArr5[i24];
                                            if (b10 != -1) {
                                                if (b10 == 73) {
                                                    int i25 = i24 + 1;
                                                    if (i25 != i23) {
                                                        if (bArr5[i25] == 68) {
                                                            int i26 = i24 + 2;
                                                            if (i26 != i23) {
                                                                if (bArr5[i26] == 51) {
                                                                    break;
                                                                }
                                                            } else {
                                                                break;
                                                            }
                                                        }
                                                    } else {
                                                        break;
                                                    }
                                                }
                                            } else {
                                                int i27 = i24 + 1;
                                                if (i27 != i23) {
                                                    byte b11 = bArr5[i27];
                                                    if (((65280 | (b11 & 255 ? 1 : 0) ? 1 : 0) & 65526) == 65520 && ((b11 & 8) >> 3) == i20) {
                                                        break;
                                                    }
                                                } else {
                                                    break;
                                                }
                                            }
                                        }
                                    } else {
                                        break;
                                    }
                                }
                            }
                        } else {
                            break;
                        }
                    }
                    int i28 = this.f4468k;
                    int i29 = i18 | i28;
                    if (i29 == 329) {
                        this.f4468k = 768;
                    } else if (i29 == 511) {
                        this.f4468k = IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED;
                    } else if (i29 == 836) {
                        this.f4468k = 1024;
                    } else {
                        if (i29 == 1075) {
                            this.f4466i = 2;
                            this.f4467j = 3;
                            this.f4476s = 0;
                            pVar2.F(0);
                            pVar.F(i9);
                            break;
                        }
                        if (i28 != 256) {
                            this.f4468k = 256;
                            i13 = 0;
                            i14 = 4;
                            i15 = 1;
                        }
                    }
                    i16 = i9;
                    i13 = 0;
                    i14 = 4;
                    i15 = 1;
                }
                this.f4473p = (b9 & 8) >> 3;
                this.f4469l = (b9 & 1) == 0;
                if (this.f4470m) {
                    this.f4466i = 3;
                    this.f4467j = 0;
                } else {
                    this.f4466i = 1;
                    this.f4467j = 0;
                }
                pVar.F(i9);
            } else if (i12 != 1) {
                if (i12 == 2) {
                    byte[] bArr6 = pVar2.f3699a;
                    int min = Math.min(pVar.a(), 10 - this.f4467j);
                    pVar.e(this.f4467j, min, bArr6);
                    int i30 = this.f4467j + min;
                    this.f4467j = i30;
                    if (i30 == 10) {
                        this.h.c(10, pVar2);
                        pVar2.F(6);
                        d2.d0 d0Var = this.h;
                        int s8 = pVar2.s() + 10;
                        this.f4466i = 4;
                        this.f4467j = 10;
                        this.f4478u = d0Var;
                        this.f4479v = 0L;
                        this.f4476s = s8;
                    }
                } else if (i12 == 3) {
                    int i31 = this.f4469l ? 7 : 5;
                    byte[] bArr7 = gVar.f104b;
                    int min2 = Math.min(pVar.a(), i31 - this.f4467j);
                    pVar.e(this.f4467j, min2, bArr7);
                    int i32 = this.f4467j + min2;
                    this.f4467j = i32;
                    if (i32 == i31) {
                        gVar.p(0);
                        if (this.f4474q) {
                            gVar.s(10);
                        } else {
                            int i33 = gVar.i(2) + 1;
                            if (i33 != 2) {
                                g1.a.D("AdtsReader", "Detected audio object type: " + i33 + ", but assuming AAC LC.");
                                i33 = 2;
                            }
                            gVar.s(5);
                            int i34 = gVar.i(3);
                            int i35 = this.f4472o;
                            byte[] bArr8 = {(byte) (((i33 << 3) & 248) | ((i35 >> 1) & 7)), (byte) (((i34 << 3) & 120) | ((i35 << 7) & 128))};
                            d2.a m9 = d2.b.m(new a3.g(bArr8, 2), false);
                            d1.r rVar = new d1.r();
                            rVar.f2518a = this.f4464f;
                            rVar.f2528l = l0.k("audio/mp4a-latm");
                            rVar.f2525i = m9.f2621a;
                            rVar.f2541y = m9.f2623c;
                            rVar.f2542z = m9.f2622b;
                            rVar.f2530n = Collections.singletonList(bArr8);
                            rVar.f2521d = this.f4462d;
                            rVar.f2523f = this.f4463e;
                            d1.s sVar = new d1.s(rVar);
                            this.f4475r = 1024000000 / sVar.A;
                            this.f4465g.e(sVar);
                            this.f4474q = true;
                        }
                        gVar.s(4);
                        int i36 = gVar.i(13);
                        int i37 = i36 - 7;
                        if (this.f4469l) {
                            i37 = i36 - 9;
                        }
                        d2.d0 d0Var2 = this.f4465g;
                        long j5 = this.f4475r;
                        this.f4466i = 4;
                        this.f4467j = 0;
                        this.f4478u = d0Var2;
                        this.f4479v = j5;
                        this.f4476s = i37;
                    }
                } else {
                    if (i12 != 4) {
                        androidx.fragment.app.a.l();
                        return;
                    }
                    int min3 = Math.min(pVar.a(), this.f4476s - this.f4467j);
                    this.f4478u.c(min3, pVar);
                    int i38 = this.f4467j + min3;
                    this.f4467j = i38;
                    if (i38 == this.f4476s) {
                        g1.a.k(this.f4477t != -9223372036854775807L);
                        this.f4478u.d(this.f4477t, 1, this.f4476s, 0, null);
                        this.f4477t += this.f4479v;
                        this.f4466i = 0;
                        this.f4467j = 0;
                        this.f4468k = 256;
                    }
                }
            } else if (pVar.a() != 0) {
                gVar.f104b[0] = pVar.f3699a[pVar.f3700b];
                gVar.p(2);
                int i39 = gVar.i(4);
                int i40 = this.f4472o;
                if (i40 == -1 || i39 == i40) {
                    if (!this.f4470m) {
                        this.f4470m = true;
                        this.f4471n = this.f4473p;
                        this.f4472o = i39;
                    }
                    this.f4466i = 3;
                    this.f4467j = 0;
                } else {
                    this.f4470m = false;
                    this.f4466i = 0;
                    this.f4467j = 0;
                    this.f4468k = 256;
                }
            }
        }
    }

    @Override // i3.h
    public final void d(int i9, long j5) {
        this.f4477t = j5;
    }

    @Override // i3.h
    public final void f(d2.o oVar, e0 e0Var) {
        e0Var.a();
        e0Var.b();
        this.f4464f = e0Var.f4484e;
        e0Var.b();
        d2.d0 l4 = oVar.l(e0Var.f4483d, 1);
        this.f4465g = l4;
        this.f4478u = l4;
        if (!this.f4459a) {
            this.h = new d2.l();
            return;
        }
        e0Var.a();
        e0Var.b();
        d2.d0 l9 = oVar.l(e0Var.f4483d, 5);
        this.h = l9;
        d1.r rVar = new d1.r();
        e0Var.b();
        rVar.f2518a = e0Var.f4484e;
        rVar.f2528l = l0.k("application/id3");
        androidx.activity.g.v(rVar, l9);
    }

    @Override // i3.h
    public final void e() {
    }
}
