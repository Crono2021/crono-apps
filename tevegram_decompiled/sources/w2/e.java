package w2;

import android.util.Pair;
import d1.l0;
import g1.w;
import v1.q0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f9723a;

    static {
        int i9 = w.f3713a;
        f9723a = "OpusHead".getBytes(a6.b.f203c);
    }

    public static q0 a(int i9, g1.p pVar) {
        pVar.F(i9 + 12);
        pVar.G(1);
        b(pVar);
        pVar.G(2);
        int t8 = pVar.t();
        if ((t8 & 128) != 0) {
            pVar.G(2);
        }
        if ((t8 & 64) != 0) {
            pVar.G(pVar.t());
        }
        if ((t8 & 32) != 0) {
            pVar.G(2);
        }
        pVar.G(1);
        b(pVar);
        String d9 = l0.d(pVar.t());
        if ("audio/mpeg".equals(d9) || "audio/vnd.dts".equals(d9) || "audio/vnd.dts.hd".equals(d9)) {
            return new q0(d9, null, -1L, -1L);
        }
        pVar.G(4);
        long v8 = pVar.v();
        long v9 = pVar.v();
        pVar.G(1);
        int b9 = b(pVar);
        long j5 = v9;
        byte[] bArr = new byte[b9];
        pVar.e(0, b9, bArr);
        if (j5 <= 0) {
            j5 = -1;
        }
        return new q0(d9, bArr, j5, v8 > 0 ? v8 : -1L);
    }

    public static int b(g1.p pVar) {
        int t8 = pVar.t();
        int i9 = t8 & 127;
        while ((t8 & 128) == 128) {
            t8 = pVar.t();
            i9 = (i9 << 7) | (t8 & 127);
        }
        return i9;
    }

    public static h1.c c(g1.p pVar) {
        long n4;
        long n9;
        pVar.F(8);
        if (g5.c.i(pVar.g()) == 0) {
            n4 = pVar.v();
            n9 = pVar.v();
        } else {
            n4 = pVar.n();
            n9 = pVar.n();
        }
        return new h1.c(n4, n9, pVar.v());
    }

    public static Pair d(g1.p pVar, int i9, int i10) {
        Integer num;
        q qVar;
        Pair create;
        int i11;
        int i12;
        Integer num2;
        boolean z8;
        int i13 = pVar.f3700b;
        while (i13 - i9 < i10) {
            pVar.F(i13);
            int g9 = pVar.g();
            d2.b.c("childAtomSize must be positive", g9 > 0);
            if (pVar.g() == 1936289382) {
                int i14 = i13 + 8;
                int i15 = -1;
                Integer num3 = null;
                String str = null;
                int i16 = 0;
                while (i14 - i13 < g9) {
                    pVar.F(i14);
                    int g10 = pVar.g();
                    int g11 = pVar.g();
                    if (g11 == 1718775137) {
                        num3 = Integer.valueOf(pVar.g());
                    } else if (g11 == 1935894637) {
                        pVar.G(4);
                        str = pVar.r(4, a6.b.f203c);
                    } else if (g11 == 1935894633) {
                        i15 = i14;
                        i16 = g10;
                    }
                    i14 += g10;
                }
                byte[] bArr = null;
                if ("cenc".equals(str) || "cbc1".equals(str) || "cens".equals(str) || "cbcs".equals(str)) {
                    d2.b.c("frma atom is mandatory", num3 != null);
                    d2.b.c("schi atom is mandatory", i15 != -1);
                    int i17 = i15 + 8;
                    while (true) {
                        if (i17 - i15 >= i16) {
                            num = num3;
                            qVar = null;
                            break;
                        }
                        pVar.F(i17);
                        int g12 = pVar.g();
                        if (pVar.g() == 1952804451) {
                            int i18 = g5.c.i(pVar.g());
                            pVar.G(1);
                            if (i18 == 0) {
                                pVar.G(1);
                                i12 = 0;
                                i11 = 0;
                            } else {
                                int t8 = pVar.t();
                                i11 = t8 & 15;
                                i12 = (t8 & 240) >> 4;
                            }
                            if (pVar.t() == 1) {
                                num2 = num3;
                                z8 = true;
                            } else {
                                num2 = num3;
                                z8 = false;
                            }
                            int t9 = pVar.t();
                            byte[] bArr2 = new byte[16];
                            pVar.e(0, 16, bArr2);
                            if (z8 && t9 == 0) {
                                int t10 = pVar.t();
                                byte[] bArr3 = new byte[t10];
                                pVar.e(0, t10, bArr3);
                                bArr = bArr3;
                            }
                            num = num2;
                            qVar = new q(z8, str, t9, bArr2, i12, i11, bArr);
                        } else {
                            i17 += g12;
                        }
                    }
                    d2.b.c("tenc atom is mandatory", qVar != null);
                    int i19 = w.f3713a;
                    create = Pair.create(num, qVar);
                } else {
                    create = null;
                }
                if (create != null) {
                    return create;
                }
            }
            i13 += g9;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:504:0x0ac7  */
    /* JADX WARN: Removed duplicated region for block: B:508:0x0ae9  */
    /* JADX WARN: Removed duplicated region for block: B:570:0x0c21  */
    /* JADX WARN: Removed duplicated region for block: B:573:0x0c23  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static c2.f e(g1.p r58, int r59, int r60, java.lang.String r61, d1.n r62, boolean r63) {
        /*
            Method dump skipped, instructions count: 3853
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w2.e.e(g1.p, int, int, java.lang.String, d1.n, boolean):c2.f");
    }

    /* JADX WARN: Code restructure failed: missing block: B:286:0x00dc, code lost:
    
        if (r15 == 0) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x00de, code lost:
    
        r15 = -9223372036854775807L;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:190:0x04e2  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x059b A[ADDED_TO_REGION, LOOP:13: B:232:0x059b->B:235:0x05a5, LOOP_START, PHI: r17
  0x059b: PHI (r17v13 int) = (r17v11 int), (r17v14 int) binds: [B:231:0x0599, B:235:0x05a5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:248:0x05f8  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x05fb  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x058e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x0887 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:347:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0621  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0633  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList f(w2.a r54, d2.s r55, long r56, d1.n r58, boolean r59, boolean r60, a6.c r61) {
        /*
            Method dump skipped, instructions count: 2194
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w2.e.f(w2.a, d2.s, long, d1.n, boolean, boolean, a6.c):java.util.ArrayList");
    }
}
