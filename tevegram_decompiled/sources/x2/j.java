package x2;

import b6.g0;
import d1.j0;
import d1.l0;
import d1.m0;
import d1.r;
import d1.s;
import d2.f0;
import d2.w;
import g1.p;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j extends i {

    /* renamed from: n, reason: collision with root package name */
    public g1.e f10087n;

    /* renamed from: o, reason: collision with root package name */
    public int f10088o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f10089p;

    /* renamed from: q, reason: collision with root package name */
    public w f10090q;

    /* renamed from: r, reason: collision with root package name */
    public a0.b f10091r;

    @Override // x2.i
    public final void a(long j5) {
        this.f10081g = j5;
        this.f10089p = j5 != 0;
        w wVar = this.f10090q;
        this.f10088o = wVar != null ? wVar.f2750e : 0;
    }

    @Override // x2.i
    public final long b(p pVar) {
        byte b9 = pVar.f3699a[0];
        if ((b9 & 1) == 1) {
            return -1L;
        }
        g1.e eVar = this.f10087n;
        g1.a.l(eVar);
        boolean z8 = ((f0[]) eVar.f3672m)[(b9 >> 1) & (255 >>> (8 - eVar.f3668i))].f2689a;
        w wVar = (w) eVar.f3669j;
        int i9 = !z8 ? wVar.f2750e : wVar.f2751f;
        long j5 = this.f10089p ? (this.f10088o + i9) / 4 : 0;
        byte[] bArr = pVar.f3699a;
        int length = bArr.length;
        int i10 = pVar.f3701c + 4;
        if (length < i10) {
            byte[] copyOf = Arrays.copyOf(bArr, i10);
            pVar.D(copyOf, copyOf.length);
        } else {
            pVar.E(i10);
        }
        byte[] bArr2 = pVar.f3699a;
        int i11 = pVar.f3701c;
        bArr2[i11 - 4] = (byte) (j5 & 255);
        bArr2[i11 - 3] = (byte) ((j5 >>> 8) & 255);
        bArr2[i11 - 2] = (byte) ((j5 >>> 16) & 255);
        bArr2[i11 - 1] = (byte) ((j5 >>> 24) & 255);
        this.f10089p = true;
        this.f10088o = i9;
        return j5;
    }

    @Override // x2.i
    public final boolean c(p pVar, long j5, m1.b bVar) {
        g1.e eVar;
        if (this.f10087n != null) {
            ((s) bVar.f6510j).getClass();
            return false;
        }
        w wVar = this.f10090q;
        int i9 = 4;
        if (wVar == null) {
            d2.b.t(1, pVar, false);
            pVar.l();
            int t8 = pVar.t();
            int l4 = pVar.l();
            int i10 = pVar.i();
            if (i10 <= 0) {
                i10 = -1;
            }
            int i11 = pVar.i();
            int i12 = i11 > 0 ? i11 : -1;
            pVar.i();
            int t9 = pVar.t();
            int pow = (int) Math.pow(2.0d, t9 & 15);
            int pow2 = (int) Math.pow(2.0d, (t9 & 240) >> 4);
            pVar.t();
            byte[] copyOf = Arrays.copyOf(pVar.f3699a, pVar.f3701c);
            w wVar2 = new w();
            wVar2.f2746a = t8;
            wVar2.f2747b = l4;
            wVar2.f2748c = i10;
            wVar2.f2749d = i12;
            wVar2.f2750e = pow;
            wVar2.f2751f = pow2;
            wVar2.f2752g = copyOf;
            this.f10090q = wVar2;
        } else {
            a0.b bVar2 = this.f10091r;
            if (bVar2 == null) {
                this.f10091r = d2.b.s(pVar, true, true);
            } else {
                int i13 = pVar.f3701c;
                byte[] bArr = new byte[i13];
                System.arraycopy(pVar.f3699a, 0, bArr, 0, i13);
                int i14 = wVar.f2746a;
                int i15 = 5;
                d2.b.t(5, pVar, false);
                int t10 = pVar.t() + 1;
                a3.g gVar = new a3.g(pVar.f3699a);
                gVar.s(pVar.f3700b * 8);
                int i16 = 0;
                while (true) {
                    int i17 = 16;
                    if (i16 >= t10) {
                        int i18 = 6;
                        int i19 = gVar.i(6) + 1;
                        for (int i20 = 0; i20 < i19; i20++) {
                            if (gVar.i(16) != 0) {
                                throw m0.a(null, "placeholder of time domain transforms not zeroed out");
                            }
                        }
                        int i21 = 1;
                        int i22 = gVar.i(6) + 1;
                        int i23 = 0;
                        while (true) {
                            int i24 = 3;
                            if (i23 < i22) {
                                int i25 = gVar.i(i17);
                                if (i25 == 0) {
                                    int i26 = 8;
                                    gVar.s(8);
                                    gVar.s(16);
                                    gVar.s(16);
                                    gVar.s(6);
                                    gVar.s(8);
                                    int i27 = gVar.i(4) + 1;
                                    int i28 = 0;
                                    while (i28 < i27) {
                                        gVar.s(i26);
                                        i28++;
                                        i26 = 8;
                                    }
                                } else {
                                    if (i25 != i21) {
                                        throw m0.a(null, "floor type greater than 1 not decodable: " + i25);
                                    }
                                    int i29 = gVar.i(5);
                                    int[] iArr = new int[i29];
                                    int i30 = -1;
                                    for (int i31 = 0; i31 < i29; i31++) {
                                        int i32 = gVar.i(i9);
                                        iArr[i31] = i32;
                                        if (i32 > i30) {
                                            i30 = i32;
                                        }
                                    }
                                    int i33 = i30 + 1;
                                    int[] iArr2 = new int[i33];
                                    int i34 = 0;
                                    while (i34 < i33) {
                                        iArr2[i34] = gVar.i(i24) + 1;
                                        int i35 = gVar.i(2);
                                        int i36 = 8;
                                        if (i35 > 0) {
                                            gVar.s(8);
                                        }
                                        int[] iArr3 = iArr2;
                                        int i37 = 0;
                                        for (int i38 = 1; i37 < (i38 << i35); i38 = 1) {
                                            gVar.s(i36);
                                            i37++;
                                            i36 = 8;
                                        }
                                        i34++;
                                        iArr2 = iArr3;
                                        i24 = 3;
                                    }
                                    int[] iArr4 = iArr2;
                                    gVar.s(2);
                                    int i39 = gVar.i(4);
                                    int i40 = 0;
                                    int i41 = 0;
                                    for (int i42 = 0; i42 < i29; i42++) {
                                        i40 += iArr4[iArr[i42]];
                                        while (i41 < i40) {
                                            gVar.s(i39);
                                            i41++;
                                        }
                                    }
                                }
                                i23++;
                                i18 = 6;
                                i9 = 4;
                                i17 = 16;
                                i21 = 1;
                            } else {
                                int i43 = gVar.i(i18) + 1;
                                int i44 = 0;
                                while (i44 < i43) {
                                    if (gVar.i(16) > 2) {
                                        throw m0.a(null, "residueType greater than 2 is not decodable");
                                    }
                                    gVar.s(24);
                                    gVar.s(24);
                                    gVar.s(24);
                                    int i45 = gVar.i(i18) + 1;
                                    int i46 = 8;
                                    gVar.s(8);
                                    int[] iArr5 = new int[i45];
                                    for (int i47 = 0; i47 < i45; i47++) {
                                        iArr5[i47] = ((gVar.h() ? gVar.i(5) : 0) * 8) + gVar.i(3);
                                    }
                                    int i48 = 0;
                                    while (i48 < i45) {
                                        int i49 = 0;
                                        while (i49 < i46) {
                                            if ((iArr5[i48] & (1 << i49)) != 0) {
                                                gVar.s(i46);
                                            }
                                            i49++;
                                            i46 = 8;
                                        }
                                        i48++;
                                        i46 = 8;
                                    }
                                    i44++;
                                    i18 = 6;
                                }
                                int i50 = gVar.i(i18) + 1;
                                for (int i51 = 0; i51 < i50; i51++) {
                                    int i52 = gVar.i(16);
                                    if (i52 != 0) {
                                        g1.a.p("VorbisUtil", "mapping type other than 0 not supported: " + i52);
                                    } else {
                                        int i53 = gVar.h() ? gVar.i(4) + 1 : 1;
                                        if (gVar.h()) {
                                            int i54 = gVar.i(8) + 1;
                                            for (int i55 = 0; i55 < i54; i55++) {
                                                int i56 = i14 - 1;
                                                int i57 = 0;
                                                for (int i58 = i56; i58 > 0; i58 >>>= 1) {
                                                    i57++;
                                                }
                                                gVar.s(i57);
                                                int i59 = 0;
                                                while (i56 > 0) {
                                                    i59++;
                                                    i56 >>>= 1;
                                                }
                                                gVar.s(i59);
                                            }
                                        }
                                        if (gVar.i(2) != 0) {
                                            throw m0.a(null, "to reserved bits must be zero after mapping coupling steps");
                                        }
                                        if (i53 > 1) {
                                            for (int i60 = 0; i60 < i14; i60++) {
                                                gVar.s(4);
                                            }
                                        }
                                        for (int i61 = 0; i61 < i53; i61++) {
                                            gVar.s(8);
                                            gVar.s(8);
                                            gVar.s(8);
                                        }
                                    }
                                }
                                int i62 = gVar.i(6);
                                int i63 = i62 + 1;
                                f0[] f0VarArr = new f0[i63];
                                for (int i64 = 0; i64 < i63; i64++) {
                                    boolean h = gVar.h();
                                    gVar.i(16);
                                    gVar.i(16);
                                    gVar.i(8);
                                    f0 f0Var = new f0();
                                    f0Var.f2689a = h;
                                    f0VarArr[i64] = f0Var;
                                }
                                if (!gVar.h()) {
                                    throw m0.a(null, "framing bit after modes not set as expected");
                                }
                                int i65 = 0;
                                while (i62 > 0) {
                                    i65++;
                                    i62 >>>= 1;
                                }
                                eVar = new g1.e(wVar, bVar2, bArr, f0VarArr, i65);
                            }
                        }
                    } else {
                        if (gVar.i(24) != 5653314) {
                            throw m0.a(null, "expected code book to start with [0x56, 0x43, 0x42] at " + ((gVar.f106d * 8) + gVar.f107e));
                        }
                        int i66 = gVar.i(16);
                        int i67 = gVar.i(24);
                        if (gVar.h()) {
                            gVar.s(i15);
                            int i68 = 0;
                            while (i68 < i67) {
                                int i69 = 0;
                                for (int i70 = i67 - i68; i70 > 0; i70 >>>= 1) {
                                    i69++;
                                }
                                i68 += gVar.i(i69);
                            }
                        } else {
                            boolean h9 = gVar.h();
                            for (int i71 = 0; i71 < i67; i71++) {
                                if (!h9) {
                                    gVar.s(i15);
                                } else if (gVar.h()) {
                                    gVar.s(i15);
                                }
                            }
                        }
                        int i72 = gVar.i(4);
                        if (i72 > 2) {
                            throw m0.a(null, "lookup type greater than 2 not decodable: " + i72);
                        }
                        if (i72 == 1 || i72 == 2) {
                            gVar.s(32);
                            gVar.s(32);
                            int i73 = gVar.i(4) + 1;
                            gVar.s(1);
                            gVar.s((int) ((i72 == 1 ? i66 != 0 ? (long) Math.floor(Math.pow(i67, 1.0d / i66)) : 0L : i67 * i66) * i73));
                        }
                        i16++;
                        i15 = 5;
                    }
                }
            }
        }
        eVar = null;
        this.f10087n = eVar;
        if (eVar == null) {
            return true;
        }
        w wVar3 = (w) eVar.f3669j;
        ArrayList arrayList = new ArrayList();
        arrayList.add((byte[]) wVar3.f2752g);
        arrayList.add((byte[]) eVar.f3671l);
        j0 o8 = d2.b.o(g0.n((String[]) ((a0.b) eVar.f3670k).f8j));
        r rVar = new r();
        rVar.f2528l = l0.k("audio/vorbis");
        rVar.f2524g = wVar3.f2749d;
        rVar.h = wVar3.f2748c;
        rVar.f2541y = wVar3.f2746a;
        rVar.f2542z = wVar3.f2747b;
        rVar.f2530n = arrayList;
        rVar.f2526j = o8;
        bVar.f6510j = new s(rVar);
        return true;
    }

    @Override // x2.i
    public final void d(boolean z8) {
        super.d(z8);
        if (z8) {
            this.f10087n = null;
            this.f10090q = null;
            this.f10091r = null;
        }
        this.f10088o = 0;
        this.f10089p = false;
    }
}
