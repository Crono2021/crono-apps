package z6;

import b3.d;
import n1.u;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final int[][] f10677a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* renamed from: b, reason: collision with root package name */
    public static final int[][] f10678b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* renamed from: c, reason: collision with root package name */
    public static final int[][] f10679c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, IjkMediaMeta.FF_PROFILE_H264_HIGH_10, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, IjkMediaMeta.FF_PROFILE_H264_HIGH_422, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, IjkMediaMeta.FF_PROFILE_H264_HIGH_10, 136, 162}, new int[]{6, 26, 54, 82, IjkMediaMeta.FF_PROFILE_H264_HIGH_10, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};

    /* renamed from: d, reason: collision with root package name */
    public static final int[][] f10680d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    public static int a(d dVar, boolean z8) {
        int i9 = dVar.f1286j;
        int i10 = dVar.f1287k;
        int i11 = z8 ? i10 : i9;
        if (!z8) {
            i9 = i10;
        }
        byte[][] bArr = (byte[][]) dVar.f1288l;
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            byte b9 = -1;
            int i14 = 0;
            for (int i15 = 0; i15 < i9; i15++) {
                byte b10 = z8 ? bArr[i13][i15] : bArr[i15][i13];
                if (b10 == b9) {
                    i14++;
                } else {
                    if (i14 >= 5) {
                        i12 += i14 - 2;
                    }
                    b9 = b10;
                    i14 = 1;
                }
            }
            if (i14 >= 5) {
                i12 = (i14 - 2) + i12;
            }
        }
        return i12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0231  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(v6.a r29, int r30, y6.b r31, int r32, b3.d r33) {
        /*
            Method dump skipped, instructions count: 700
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z6.c.b(v6.a, int, y6.b, int, b3.d):void");
    }

    public static int c(int i9, int i10) {
        if (i10 == 0) {
            m7.c.n("0 polynomial");
            return 0;
        }
        int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i10);
        int i11 = 32 - numberOfLeadingZeros;
        int i12 = i9 << (31 - numberOfLeadingZeros);
        while (32 - Integer.numberOfLeadingZeros(i12) >= i11) {
            i12 ^= i10 << ((32 - Integer.numberOfLeadingZeros(i12)) - i11);
        }
        return i12;
    }

    public static void d(int i9, int i10, d dVar) {
        for (int i11 = 0; i11 < 8; i11++) {
            int i12 = i9 + i11;
            if (!g(dVar.a(i12, i10))) {
                throw new u();
            }
            dVar.b(i12, i10, 0);
        }
    }

    public static void e(int i9, int i10, d dVar) {
        for (int i11 = 0; i11 < 7; i11++) {
            int[] iArr = f10677a[i11];
            for (int i12 = 0; i12 < 7; i12++) {
                dVar.b(i9 + i12, i10 + i11, iArr[i12]);
            }
        }
    }

    public static void f(int i9, int i10, d dVar) {
        for (int i11 = 0; i11 < 7; i11++) {
            int i12 = i10 + i11;
            if (!g(dVar.a(i9, i12))) {
                throw new u();
            }
            dVar.b(i9, i12, 0);
        }
    }

    public static boolean g(int i9) {
        return i9 == -1;
    }
}
