package com.google.crypto.tink.shaded.protobuf;

import java.util.logging.Logger;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class n {

    /* renamed from: e, reason: collision with root package name */
    public static final Logger f2272e = Logger.getLogger(n.class.getName());

    /* renamed from: f, reason: collision with root package name */
    public static final boolean f2273f = p1.f2288e;

    /* renamed from: a, reason: collision with root package name */
    public n0 f2274a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f2275b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2276c;

    /* renamed from: d, reason: collision with root package name */
    public int f2277d;

    public n(byte[] bArr, int i9) {
        if (((bArr.length - i9) | i9) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i9)));
        }
        this.f2275b = bArr;
        this.f2277d = 0;
        this.f2276c = i9;
    }

    public static int a(int i9, j jVar) {
        return b(jVar) + h(i9);
    }

    public static int b(j jVar) {
        int size = jVar.size();
        return i(size) + size;
    }

    public static int c(int i9) {
        return h(i9) + 4;
    }

    public static int d(int i9) {
        return h(i9) + 8;
    }

    public static int e(int i9, a aVar, d1 d1Var) {
        return aVar.b(d1Var) + (h(i9) * 2);
    }

    public static int f(int i9) {
        if (i9 >= 0) {
            return i(i9);
        }
        return 10;
    }

    public static int g(String str) {
        int length;
        try {
            length = s1.b(str);
        } catch (r1 unused) {
            length = str.getBytes(c0.f2207a).length;
        }
        return i(length) + length;
    }

    public static int h(int i9) {
        return i(i9 << 3);
    }

    public static int i(int i9) {
        if ((i9 & (-128)) == 0) {
            return 1;
        }
        if ((i9 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i9) == 0) {
            return 3;
        }
        return (i9 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int j(long j5) {
        int i9;
        if (((-128) & j5) == 0) {
            return 1;
        }
        if (j5 < 0) {
            return 10;
        }
        if (((-34359738368L) & j5) != 0) {
            j5 >>>= 28;
            i9 = 6;
        } else {
            i9 = 2;
        }
        if (((-2097152) & j5) != 0) {
            i9 += 2;
            j5 >>>= 14;
        }
        return (j5 & (-16384)) != 0 ? i9 + 1 : i9;
    }

    public final void k(byte b9) {
        try {
            byte[] bArr = this.f2275b;
            int i9 = this.f2277d;
            this.f2277d = i9 + 1;
            bArr[i9] = b9;
        } catch (IndexOutOfBoundsException e9) {
            throw new b4.c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2277d), Integer.valueOf(this.f2276c), 1), e9);
        }
    }

    public final void l(byte[] bArr, int i9, int i10) {
        try {
            System.arraycopy(bArr, i9, this.f2275b, this.f2277d, i10);
            this.f2277d += i10;
        } catch (IndexOutOfBoundsException e9) {
            throw new b4.c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2277d), Integer.valueOf(this.f2276c), Integer.valueOf(i10)), e9);
        }
    }

    public final void m(int i9, int i10) {
        r(i9, 5);
        n(i10);
    }

    public final void n(int i9) {
        try {
            byte[] bArr = this.f2275b;
            int i10 = this.f2277d;
            int i11 = i10 + 1;
            this.f2277d = i11;
            bArr[i10] = (byte) (i9 & 255);
            int i12 = i10 + 2;
            this.f2277d = i12;
            bArr[i11] = (byte) ((i9 >> 8) & 255);
            int i13 = i10 + 3;
            this.f2277d = i13;
            bArr[i12] = (byte) ((i9 >> 16) & 255);
            this.f2277d = i10 + 4;
            bArr[i13] = (byte) ((i9 >> 24) & 255);
        } catch (IndexOutOfBoundsException e9) {
            throw new b4.c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2277d), Integer.valueOf(this.f2276c), 1), e9);
        }
    }

    public final void o(int i9, long j5) {
        r(i9, 1);
        p(j5);
    }

    public final void p(long j5) {
        try {
            byte[] bArr = this.f2275b;
            int i9 = this.f2277d;
            int i10 = i9 + 1;
            this.f2277d = i10;
            bArr[i9] = (byte) (((int) j5) & 255);
            int i11 = i9 + 2;
            this.f2277d = i11;
            bArr[i10] = (byte) (((int) (j5 >> 8)) & 255);
            int i12 = i9 + 3;
            this.f2277d = i12;
            bArr[i11] = (byte) (((int) (j5 >> 16)) & 255);
            int i13 = i9 + 4;
            this.f2277d = i13;
            bArr[i12] = (byte) (((int) (j5 >> 24)) & 255);
            int i14 = i9 + 5;
            this.f2277d = i14;
            bArr[i13] = (byte) (((int) (j5 >> 32)) & 255);
            int i15 = i9 + 6;
            this.f2277d = i15;
            bArr[i14] = (byte) (((int) (j5 >> 40)) & 255);
            int i16 = i9 + 7;
            this.f2277d = i16;
            bArr[i15] = (byte) (((int) (j5 >> 48)) & 255);
            this.f2277d = i9 + 8;
            bArr[i16] = (byte) (((int) (j5 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e9) {
            throw new b4.c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2277d), Integer.valueOf(this.f2276c), 1), e9);
        }
    }

    public final void q(int i9) {
        if (i9 >= 0) {
            s(i9);
        } else {
            u(i9);
        }
    }

    public final void r(int i9, int i10) {
        s((i9 << 3) | i10);
    }

    public final void s(int i9) {
        while (true) {
            int i10 = i9 & (-128);
            int i11 = this.f2277d;
            byte[] bArr = this.f2275b;
            if (i10 == 0) {
                this.f2277d = i11 + 1;
                bArr[i11] = (byte) i9;
                return;
            } else {
                try {
                    this.f2277d = i11 + 1;
                    bArr[i11] = (byte) ((i9 & 127) | 128);
                    i9 >>>= 7;
                } catch (IndexOutOfBoundsException e9) {
                    throw new b4.c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2277d), Integer.valueOf(this.f2276c), 1), e9);
                }
            }
            throw new b4.c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2277d), Integer.valueOf(this.f2276c), 1), e9);
        }
    }

    public final void t(int i9, long j5) {
        r(i9, 0);
        u(j5);
    }

    public final void u(long j5) {
        boolean z8 = f2273f;
        int i9 = this.f2276c;
        byte[] bArr = this.f2275b;
        if (!z8 || i9 - this.f2277d < 10) {
            while (true) {
                long j9 = j5 & (-128);
                int i10 = this.f2277d;
                if (j9 == 0) {
                    this.f2277d = i10 + 1;
                    bArr[i10] = (byte) j5;
                    return;
                } else {
                    try {
                        this.f2277d = i10 + 1;
                        bArr[i10] = (byte) ((((int) j5) & 127) | 128);
                        j5 >>>= 7;
                    } catch (IndexOutOfBoundsException e9) {
                        throw new b4.c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2277d), Integer.valueOf(i9), 1), e9);
                    }
                }
                throw new b4.c(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2277d), Integer.valueOf(i9), 1), e9);
            }
        }
        while (true) {
            long j10 = j5 & (-128);
            int i11 = this.f2277d;
            if (j10 == 0) {
                this.f2277d = i11 + 1;
                p1.k(bArr, i11, (byte) j5);
                return;
            } else {
                this.f2277d = i11 + 1;
                p1.k(bArr, i11, (byte) ((((int) j5) & 127) | 128));
                j5 >>>= 7;
            }
        }
    }
}
