package u2;

import d2.n;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e {

    /* renamed from: d, reason: collision with root package name */
    public static final long[] f9060d = {128, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f9061a = new byte[8];

    /* renamed from: b, reason: collision with root package name */
    public int f9062b;

    /* renamed from: c, reason: collision with root package name */
    public int f9063c;

    public static long a(int i9, boolean z8, byte[] bArr) {
        long j5 = bArr[0] & 255;
        if (z8) {
            j5 &= ~f9060d[i9 - 1];
        }
        for (int i10 = 1; i10 < i9; i10++) {
            j5 = (j5 << 8) | (bArr[i10] & 255);
        }
        return j5;
    }

    public final long b(n nVar, boolean z8, boolean z9, int i9) {
        int i10;
        int i11 = this.f9062b;
        byte[] bArr = this.f9061a;
        if (i11 == 0) {
            if (!nVar.d(bArr, 0, 1, z8)) {
                return -1L;
            }
            int i12 = bArr[0] & 255;
            int i13 = 0;
            while (true) {
                if (i13 >= 8) {
                    i10 = -1;
                    break;
                }
                if ((f9060d[i13] & i12) != 0) {
                    i10 = i13 + 1;
                    break;
                }
                i13++;
            }
            this.f9063c = i10;
            if (i10 == -1) {
                m7.c.p("No valid varint length mask found");
                return 0L;
            }
            this.f9062b = 1;
        }
        int i14 = this.f9063c;
        if (i14 > i9) {
            this.f9062b = 0;
            return -2L;
        }
        if (i14 != 1) {
            nVar.readFully(bArr, 1, i14 - 1);
        }
        this.f9062b = 0;
        return a(this.f9063c, z9, bArr);
    }
}
