package d2;

import android.util.Base64;
import d1.j0;
import d1.m0;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f2631a = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f2632b = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f2633c = {1, 2, 3, 6};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f2634d = {48000, 44100, 32000};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f2635e = {24000, 22050, 16000};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f2636f = {2, 1, 2, 3, 3, 4, 4, 5};

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f2637g = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED, 576, 640};
    public static final int[] h = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f2638i = {2002, 2000, 1920, 1601, 1600, 1001, IjkMediaCodecInfo.RANK_MAX, 960, 800, 800, 480, 400, 400, IjkMediaMeta.FF_PROFILE_H264_INTRA};

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f2639j = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f2640k = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f2641l = {64, 112, 128, 192, 224, 256, 384, 448, IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, IjkMediaMeta.FF_PROFILE_H264_INTRA, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f2642m = {8000, 16000, 32000, 64000, 128000, 22050, 44100, 88200, 176400, 352800, 12000, 24000, 48000, 96000, 192000, 384000};

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f2643n = {5, 8, 10, 12};

    /* renamed from: o, reason: collision with root package name */
    public static final int[] f2644o = {6, 9, 12, 15};

    /* renamed from: p, reason: collision with root package name */
    public static final int[] f2645p = {2, 4, 6, 8};

    /* renamed from: q, reason: collision with root package name */
    public static final int[] f2646q = {9, 11, 13, 16};

    /* renamed from: r, reason: collision with root package name */
    public static final int[] f2647r = {5, 8, 10, 12};

    /* renamed from: s, reason: collision with root package name */
    public static final String[] f2648s = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};

    /* renamed from: t, reason: collision with root package name */
    public static final int[] f2649t = {44100, 48000, 32000};

    /* renamed from: u, reason: collision with root package name */
    public static final int[] f2650u = {32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};

    /* renamed from: v, reason: collision with root package name */
    public static final int[] f2651v = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};

    /* renamed from: w, reason: collision with root package name */
    public static final int[] f2652w = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};

    /* renamed from: x, reason: collision with root package name */
    public static final int[] f2653x = {32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};

    /* renamed from: y, reason: collision with root package name */
    public static final int[] f2654y = {8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};

    public static ArrayList a(byte[] bArr) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(((((bArr[11] & 255) << 8) | (bArr[10] & 255)) * 1000000000) / 48000).array());
        arrayList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(80000000L).array());
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x008a, code lost:
    
        if (r8 == r20.f2723f) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0095, code lost:
    
        if ((r19.t() * tv.danmaku.ijk.media.player.IjkMediaCodecInfo.RANK_MAX) == r3) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a4, code lost:
    
        if (r4 == r3) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean b(g1.p r19, d2.q r20, int r21, d1.w r22) {
        /*
            Method dump skipped, instructions count: 196
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.b.b(g1.p, d2.q, int, d1.w):boolean");
    }

    public static void c(String str, boolean z8) {
        if (!z8) {
            throw m0.a(null, str);
        }
    }

    public static void d(long j5, g1.p pVar, d0[] d0VarArr) {
        int i9;
        while (true) {
            if (pVar.a() <= 1) {
                return;
            }
            int i10 = 0;
            while (true) {
                if (pVar.a() == 0) {
                    i9 = -1;
                    break;
                }
                int t8 = pVar.t();
                i10 += t8;
                if (t8 != 255) {
                    i9 = i10;
                    break;
                }
            }
            int i11 = 0;
            while (true) {
                if (pVar.a() == 0) {
                    i11 = -1;
                    break;
                }
                int t9 = pVar.t();
                i11 += t9;
                if (t9 != 255) {
                    break;
                }
            }
            int i12 = pVar.f3700b + i11;
            if (i11 == -1 || i11 > pVar.a()) {
                g1.a.D("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                i12 = pVar.f3701c;
            } else if (i9 == 4 && i11 >= 8) {
                int t10 = pVar.t();
                int z8 = pVar.z();
                int g9 = z8 == 49 ? pVar.g() : 0;
                int t11 = pVar.t();
                if (z8 == 47) {
                    pVar.G(1);
                }
                boolean z9 = t10 == 181 && (z8 == 49 || z8 == 47) && t11 == 3;
                if (z8 == 49) {
                    z9 &= g9 == 1195456820;
                }
                if (z9) {
                    e(j5, pVar, d0VarArr);
                }
            }
            pVar.F(i12);
        }
    }

    public static void e(long j5, g1.p pVar, d0[] d0VarArr) {
        int t8 = pVar.t();
        if ((t8 & 64) != 0) {
            pVar.G(1);
            int i9 = (t8 & 31) * 3;
            int i10 = pVar.f3700b;
            for (d0 d0Var : d0VarArr) {
                pVar.F(i10);
                d0Var.c(i9, pVar);
                g1.a.k(j5 != -9223372036854775807L);
                d0Var.d(j5, 1, i9, 0, null);
            }
        }
    }

    public static int f(int i9, int i10) {
        int i11 = i10 / 2;
        if (i9 < 0 || i9 >= 3 || i10 < 0 || i11 >= 19) {
            return -1;
        }
        int i12 = f2634d[i9];
        if (i12 == 44100) {
            return ((i10 % 2) + h[i11]) * 2;
        }
        int i13 = f2637g[i11];
        return i12 == 32000 ? i13 * 6 : i13 * 4;
    }

    public static void g(int i9, g1.p pVar) {
        pVar.C(7);
        byte[] bArr = pVar.f3699a;
        bArr[0] = -84;
        bArr[1] = 64;
        bArr[2] = -1;
        bArr[3] = -1;
        bArr[4] = (byte) ((i9 >> 16) & 255);
        bArr[5] = (byte) ((i9 >> 8) & 255);
        bArr[6] = (byte) (i9 & 255);
    }

    public static int h(int i9) {
        int i10;
        int i11;
        int i12;
        int i13;
        if ((i9 & (-2097152)) != -2097152 || (i10 = (i9 >>> 19) & 3) == 1 || (i11 = (i9 >>> 17) & 3) == 0 || (i12 = (i9 >>> 12) & 15) == 0 || i12 == 15 || (i13 = (i9 >>> 10) & 3) == 3) {
            return -1;
        }
        int i14 = f2649t[i13];
        if (i10 == 2) {
            i14 /= 2;
        } else if (i10 == 0) {
            i14 /= 4;
        }
        int i15 = (i9 >>> 9) & 1;
        if (i11 == 3) {
            return ((((i10 == 3 ? f2650u[i12 - 1] : f2651v[i12 - 1]) * 12) / i14) + i15) * 4;
        }
        int i16 = i10 == 3 ? i11 == 2 ? f2652w[i12 - 1] : f2653x[i12 - 1] : f2654y[i12 - 1];
        int i17 = IjkMediaMeta.FF_PROFILE_H264_HIGH_444;
        if (i10 == 3) {
            return ((i16 * IjkMediaMeta.FF_PROFILE_H264_HIGH_444) / i14) + i15;
        }
        if (i11 == 1) {
            i17 = 72;
        }
        return ((i17 * i16) / i14) + i15;
    }

    public static a3.g i(byte[] bArr) {
        byte[] bArr2;
        byte b9 = bArr[0];
        if (b9 == Byte.MAX_VALUE || b9 == 100 || b9 == 64 || b9 == 113) {
            return new a3.g(bArr, bArr.length);
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        byte b10 = copyOf[0];
        if (b10 == -2 || b10 == -1 || b10 == 37 || b10 == -14 || b10 == -24) {
            for (int i9 = 0; i9 < copyOf.length - 1; i9 += 2) {
                byte b11 = copyOf[i9];
                int i10 = i9 + 1;
                copyOf[i9] = copyOf[i10];
                copyOf[i10] = b11;
            }
        }
        a3.g gVar = new a3.g(copyOf, copyOf.length);
        if (copyOf[0] == 31) {
            a3.g gVar2 = new a3.g(copyOf, copyOf.length);
            while (gVar2.b() >= 16) {
                gVar2.s(2);
                int i11 = gVar2.i(14) & 16383;
                int min = Math.min(8 - gVar.f106d, 14);
                int i12 = gVar.f106d;
                int i13 = (8 - i12) - min;
                byte[] bArr3 = gVar.f104b;
                int i14 = gVar.f105c;
                byte b12 = (byte) (((65280 >> i12) | ((1 << i13) - 1)) & bArr3[i14]);
                bArr3[i14] = b12;
                int i15 = 14 - min;
                bArr3[i14] = (byte) (b12 | ((i11 >>> i15) << i13));
                int i16 = i14 + 1;
                while (true) {
                    bArr2 = gVar.f104b;
                    if (i15 > 8) {
                        bArr2[i16] = (byte) (i11 >>> (i15 - 8));
                        i15 -= 8;
                        i16++;
                    }
                }
                int i17 = 8 - i15;
                byte b13 = (byte) (bArr2[i16] & ((1 << i17) - 1));
                bArr2[i16] = b13;
                bArr2[i16] = (byte) (((i11 & ((1 << i15) - 1)) << i17) | b13);
                gVar.s(14);
                gVar.a();
            }
        }
        gVar.o(copyOf, copyOf.length);
        return gVar;
    }

    public static long j(byte b9, byte b10) {
        int i9;
        int i10 = b9 & 255;
        int i11 = b9 & 3;
        if (i11 != 0) {
            i9 = 2;
            if (i11 != 1 && i11 != 2) {
                i9 = b10 & 63;
            }
        } else {
            i9 = 1;
        }
        int i12 = i10 >> 3;
        return i9 * (i12 >= 16 ? 2500 << r6 : i12 >= 12 ? 10000 << (i12 & 1) : (i12 & 3) == 3 ? 60000 : 10000 << r6);
    }

    public static int k(a3.g gVar) {
        int i9 = gVar.i(4);
        if (i9 == 15) {
            if (gVar.b() >= 24) {
                return gVar.i(24);
            }
            throw m0.a(null, "AAC header insufficient data");
        }
        if (i9 < 13) {
            return f2631a[i9];
        }
        throw m0.a(null, "AAC header wrong Sampling Frequency Index");
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0085, code lost:
    
        if (r9 != 11) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008c, code lost:
    
        if (r9 != 11) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0091, code lost:
    
        if (r9 != 8) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static b2.l l(a3.g r9) {
        /*
            r0 = 16
            int r1 = r9.i(r0)
            int r0 = r9.i(r0)
            r2 = 65535(0xffff, float:9.1834E-41)
            r3 = 4
            if (r0 != r2) goto L18
            r0 = 24
            int r0 = r9.i(r0)
            r2 = 7
            goto L19
        L18:
            r2 = 4
        L19:
            int r0 = r0 + r2
            r2 = 44097(0xac41, float:6.1793E-41)
            if (r1 != r2) goto L21
            int r0 = r0 + 2
        L21:
            r1 = 2
            int r2 = r9.i(r1)
            r4 = 3
            if (r2 != r4) goto L32
        L29:
            r9.i(r1)
            boolean r2 = r9.h()
            if (r2 != 0) goto L29
        L32:
            r2 = 10
            int r2 = r9.i(r2)
            boolean r5 = r9.h()
            if (r5 == 0) goto L47
            int r5 = r9.i(r4)
            if (r5 <= 0) goto L47
            r9.s(r1)
        L47:
            boolean r5 = r9.h()
            r6 = 44100(0xac44, float:6.1797E-41)
            r7 = 48000(0xbb80, float:6.7262E-41)
            if (r5 == 0) goto L57
            r5 = 48000(0xbb80, float:6.7262E-41)
            goto L5a
        L57:
            r5 = 44100(0xac44, float:6.1797E-41)
        L5a:
            int r9 = r9.i(r3)
            int[] r8 = d2.b.f2638i
            if (r5 != r6) goto L69
            r6 = 13
            if (r9 != r6) goto L69
            r9 = r8[r9]
            goto L97
        L69:
            if (r5 != r7) goto L96
            r6 = 14
            if (r9 >= r6) goto L96
            r6 = r8[r9]
            int r2 = r2 % 5
            r7 = 8
            r8 = 1
            if (r2 == r8) goto L8f
            r8 = 11
            if (r2 == r1) goto L8a
            if (r2 == r4) goto L8f
            if (r2 == r3) goto L81
            goto L94
        L81:
            if (r9 == r4) goto L87
            if (r9 == r7) goto L87
            if (r9 != r8) goto L94
        L87:
            int r9 = r6 + 1
            goto L97
        L8a:
            if (r9 == r7) goto L87
            if (r9 != r8) goto L94
            goto L87
        L8f:
            if (r9 == r4) goto L87
            if (r9 != r7) goto L94
            goto L87
        L94:
            r9 = r6
            goto L97
        L96:
            r9 = 0
        L97:
            b2.l r1 = new b2.l
            r1.<init>(r5, r0, r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.b.l(a3.g):b2.l");
    }

    public static a m(a3.g gVar, boolean z8) {
        int i9 = gVar.i(5);
        if (i9 == 31) {
            i9 = gVar.i(6) + 32;
        }
        int k3 = k(gVar);
        int i10 = gVar.i(4);
        String m9 = androidx.activity.g.m(i9, "mp4a.40.");
        if (i9 == 5 || i9 == 29) {
            k3 = k(gVar);
            int i11 = gVar.i(5);
            if (i11 == 31) {
                i11 = gVar.i(6) + 32;
            }
            i9 = i11;
            if (i9 == 22) {
                i10 = gVar.i(4);
            }
        }
        if (z8) {
            if (i9 != 1 && i9 != 2 && i9 != 3 && i9 != 4 && i9 != 6 && i9 != 7 && i9 != 17) {
                switch (i9) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw m0.c("Unsupported audio object type: " + i9);
                }
            }
            if (gVar.h()) {
                g1.a.D("AacUtil", "Unexpected frameLengthFlag = 1");
            }
            if (gVar.h()) {
                gVar.s(14);
            }
            boolean h9 = gVar.h();
            if (i10 == 0) {
                androidx.fragment.app.a.p();
                return null;
            }
            if (i9 == 6 || i9 == 20) {
                gVar.s(3);
            }
            if (h9) {
                if (i9 == 22) {
                    gVar.s(16);
                }
                if (i9 == 17 || i9 == 19 || i9 == 20 || i9 == 23) {
                    gVar.s(3);
                }
                gVar.s(1);
            }
            switch (i9) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int i12 = gVar.i(2);
                    if (i12 == 2 || i12 == 3) {
                        throw m0.c("Unsupported epConfig: " + i12);
                    }
            }
        }
        int i13 = f2632b[i10];
        if (i13 != -1) {
            return new a(k3, i13, m9);
        }
        throw m0.a(null, null);
    }

    public static int n(a3.g gVar, int[] iArr) {
        int i9 = 0;
        for (int i10 = 0; i10 < 3 && gVar.h(); i10++) {
            i9++;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < i9; i12++) {
            i11 += 1 << iArr[i12];
        }
        return gVar.i(iArr[i9]) + i11;
    }

    public static j0 o(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i9 = 0; i9 < list.size(); i9++) {
            String str = (String) list.get(i9);
            int i10 = g1.w.f3713a;
            String[] split = str.split("=", 2);
            if (split.length != 2) {
                g1.a.D("VorbisUtil", "Failed to parse Vorbis comment: ".concat(str));
            } else if (split[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(o2.a.d(new g1.p(Base64.decode(split[1], 0))));
                } catch (RuntimeException e9) {
                    g1.a.E("VorbisUtil", "Failed to parse vorbis picture", e9);
                }
            } else {
                arrayList.add(new t2.a(split[0], split[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new j0(arrayList);
    }

    public static j0 p(n nVar, boolean z8) {
        m7.c cVar = z8 ? null : q2.h.f8448p;
        g1.p pVar = new g1.p(10);
        j0 j0Var = null;
        int i9 = 0;
        while (true) {
            try {
                nVar.a(0, 10, pVar.f3699a);
                pVar.F(0);
                if (pVar.w() != 4801587) {
                    break;
                }
                pVar.G(3);
                int s8 = pVar.s();
                int i10 = s8 + 10;
                if (j0Var == null) {
                    byte[] bArr = new byte[i10];
                    System.arraycopy(pVar.f3699a, 0, bArr, 0, 10);
                    nVar.a(10, s8, bArr);
                    j0Var = new q2.h(cVar).D0(bArr, i10);
                } else {
                    nVar.p(s8);
                }
                i9 += i10;
            } catch (EOFException unused) {
            }
        }
        nVar.h();
        nVar.p(i9);
        if (j0Var == null || j0Var.f2490i.length == 0) {
            return null;
        }
        return j0Var;
    }

    public static int q(int i9, g1.p pVar) {
        switch (i9) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i9 - 2);
            case 6:
                return pVar.t() + 1;
            case 7:
                return pVar.z() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i9 - 8);
            default:
                return -1;
        }
    }

    public static a5.d r(g1.p pVar) {
        pVar.G(1);
        int w8 = pVar.w();
        long j5 = pVar.f3700b + w8;
        int i9 = w8 / 18;
        long[] jArr = new long[i9];
        long[] jArr2 = new long[i9];
        int i10 = 0;
        while (true) {
            if (i10 >= i9) {
                break;
            }
            long n4 = pVar.n();
            if (n4 == -1) {
                jArr = Arrays.copyOf(jArr, i10);
                jArr2 = Arrays.copyOf(jArr2, i10);
                break;
            }
            jArr[i10] = n4;
            jArr2[i10] = pVar.n();
            pVar.G(2);
            i10++;
        }
        pVar.G((int) (j5 - pVar.f3700b));
        return new a5.d(jArr, 8, jArr2);
    }

    public static a0.b s(g1.p pVar, boolean z8, boolean z9) {
        if (z8) {
            t(3, pVar, false);
        }
        pVar.r((int) pVar.k(), a6.b.f203c);
        long k3 = pVar.k();
        String[] strArr = new String[(int) k3];
        for (int i9 = 0; i9 < k3; i9++) {
            strArr[i9] = pVar.r((int) pVar.k(), a6.b.f203c);
        }
        if (z9 && (pVar.t() & 1) == 0) {
            throw m0.a(null, "framing bit expected to be set");
        }
        return new a0.b(strArr, 16);
    }

    public static boolean t(int i9, g1.p pVar, boolean z8) {
        if (pVar.a() < 7) {
            if (z8) {
                return false;
            }
            throw m0.a(null, "too short header: " + pVar.a());
        }
        if (pVar.t() != i9) {
            if (z8) {
                return false;
            }
            throw m0.a(null, "expected header type " + Integer.toHexString(i9));
        }
        if (pVar.t() == 118 && pVar.t() == 111 && pVar.t() == 114 && pVar.t() == 98 && pVar.t() == 105 && pVar.t() == 115) {
            return true;
        }
        if (z8) {
            return false;
        }
        throw m0.a(null, "expected characters 'vorbis'");
    }
}
