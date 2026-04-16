package g1;

import b6.k0;
import java.nio.charset.Charset;
import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class p {

    /* renamed from: d, reason: collision with root package name */
    public static final char[] f3696d = {'\r', '\n'};

    /* renamed from: e, reason: collision with root package name */
    public static final char[] f3697e = {'\n'};

    /* renamed from: f, reason: collision with root package name */
    public static final k0 f3698f = k0.m(5, a6.b.f201a, a6.b.f203c, a6.b.f206f, a6.b.f204d, a6.b.f205e);

    /* renamed from: a, reason: collision with root package name */
    public byte[] f3699a;

    /* renamed from: b, reason: collision with root package name */
    public int f3700b;

    /* renamed from: c, reason: collision with root package name */
    public int f3701c;

    public p(int i9) {
        this.f3699a = new byte[i9];
        this.f3701c = i9;
    }

    public final long A() {
        int i9;
        int i10;
        long j5 = this.f3699a[this.f3700b];
        int i11 = 7;
        while (true) {
            if (i11 < 0) {
                break;
            }
            if (((1 << i11) & j5) != 0) {
                i11--;
            } else if (i11 < 6) {
                j5 &= r6 - 1;
                i10 = 7 - i11;
            } else if (i11 == 7) {
                i10 = 1;
            }
        }
        i10 = 0;
        if (i10 == 0) {
            throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j5);
        }
        for (i9 = 1; i9 < i10; i9++) {
            if ((this.f3699a[this.f3700b + i9] & 192) != 128) {
                throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j5);
            }
            j5 = (j5 << 6) | (r3 & 63);
        }
        this.f3700b += i10;
        return j5;
    }

    public final Charset B() {
        if (a() >= 3) {
            byte[] bArr = this.f3699a;
            int i9 = this.f3700b;
            if (bArr[i9] == -17 && bArr[i9 + 1] == -69 && bArr[i9 + 2] == -65) {
                this.f3700b = i9 + 3;
                return a6.b.f203c;
            }
        }
        if (a() < 2) {
            return null;
        }
        byte[] bArr2 = this.f3699a;
        int i10 = this.f3700b;
        byte b9 = bArr2[i10];
        if (b9 == -2 && bArr2[i10 + 1] == -1) {
            this.f3700b = i10 + 2;
            return a6.b.f204d;
        }
        if (b9 != -1 || bArr2[i10 + 1] != -2) {
            return null;
        }
        this.f3700b = i10 + 2;
        return a6.b.f205e;
    }

    public final void C(int i9) {
        byte[] bArr = this.f3699a;
        if (bArr.length < i9) {
            bArr = new byte[i9];
        }
        D(bArr, i9);
    }

    public final void D(byte[] bArr, int i9) {
        this.f3699a = bArr;
        this.f3701c = i9;
        this.f3700b = 0;
    }

    public final void E(int i9) {
        a.f(i9 >= 0 && i9 <= this.f3699a.length);
        this.f3701c = i9;
    }

    public final void F(int i9) {
        a.f(i9 >= 0 && i9 <= this.f3701c);
        this.f3700b = i9;
    }

    public final void G(int i9) {
        F(this.f3700b + i9);
    }

    public final int a() {
        return this.f3701c - this.f3700b;
    }

    public final void b(int i9) {
        byte[] bArr = this.f3699a;
        if (i9 > bArr.length) {
            this.f3699a = Arrays.copyOf(bArr, i9);
        }
    }

    public final char c(Charset charset) {
        a.e("Unsupported charset: " + charset, f3698f.contains(charset));
        return (char) (d(charset) >> 16);
    }

    public final int d(Charset charset) {
        byte b9;
        int i9;
        byte b10;
        byte b11;
        if ((charset.equals(a6.b.f203c) || charset.equals(a6.b.f201a)) && a() >= 1) {
            long j5 = this.f3699a[this.f3700b] & 255;
            char c9 = (char) j5;
            com.bumptech.glide.c.e(j5, "Out of range: %s", ((long) c9) == j5);
            b9 = (byte) c9;
            i9 = 1;
        } else {
            i9 = 2;
            if ((charset.equals(a6.b.f206f) || charset.equals(a6.b.f204d)) && a() >= 2) {
                byte[] bArr = this.f3699a;
                int i10 = this.f3700b;
                b10 = bArr[i10];
                b11 = bArr[i10 + 1];
            } else {
                if (!charset.equals(a6.b.f205e) || a() < 2) {
                    return 0;
                }
                byte[] bArr2 = this.f3699a;
                int i11 = this.f3700b;
                b10 = bArr2[i11 + 1];
                b11 = bArr2[i11];
            }
            b9 = (byte) ((char) ((b11 & 255) | (b10 << 8)));
        }
        long j9 = b9;
        char c10 = (char) j9;
        com.bumptech.glide.c.e(j9, "Out of range: %s", ((long) c10) == j9);
        return (c10 << 16) + i9;
    }

    public final void e(int i9, int i10, byte[] bArr) {
        System.arraycopy(this.f3699a, this.f3700b, bArr, i9, i10);
        this.f3700b += i10;
    }

    public final char f(Charset charset, char[] cArr) {
        int d9 = d(charset);
        if (d9 != 0) {
            char c9 = (char) (d9 >> 16);
            for (char c10 : cArr) {
                if (c10 == c9) {
                    this.f3700b += d9 & 65535;
                    return c9;
                }
            }
        }
        return (char) 0;
    }

    public final int g() {
        byte[] bArr = this.f3699a;
        int i9 = this.f3700b;
        int i10 = i9 + 1;
        this.f3700b = i10;
        int i11 = (bArr[i9] & 255) << 24;
        int i12 = i9 + 2;
        this.f3700b = i12;
        int i13 = ((bArr[i10] & 255) << 16) | i11;
        int i14 = i9 + 3;
        this.f3700b = i14;
        int i15 = i13 | ((bArr[i12] & 255) << 8);
        this.f3700b = i9 + 4;
        return (bArr[i14] & 255) | i15;
    }

    public final String h(Charset charset) {
        int i9;
        a.e("Unsupported charset: " + charset, f3698f.contains(charset));
        if (a() == 0) {
            return null;
        }
        Charset charset2 = a6.b.f201a;
        if (!charset.equals(charset2)) {
            B();
        }
        if (charset.equals(a6.b.f203c) || charset.equals(charset2)) {
            i9 = 1;
        } else {
            if (!charset.equals(a6.b.f206f) && !charset.equals(a6.b.f205e) && !charset.equals(a6.b.f204d)) {
                androidx.fragment.app.a.n(charset, "Unsupported charset: ");
                return null;
            }
            i9 = 2;
        }
        int i10 = this.f3700b;
        while (true) {
            int i11 = this.f3701c;
            if (i10 >= i11 - (i9 - 1)) {
                i10 = i11;
                break;
            }
            if ((charset.equals(a6.b.f203c) || charset.equals(a6.b.f201a)) && w.K(this.f3699a[i10])) {
                break;
            }
            if (charset.equals(a6.b.f206f) || charset.equals(a6.b.f204d)) {
                byte[] bArr = this.f3699a;
                if (bArr[i10] == 0 && w.K(bArr[i10 + 1])) {
                    break;
                }
            }
            if (charset.equals(a6.b.f205e)) {
                byte[] bArr2 = this.f3699a;
                if (bArr2[i10 + 1] == 0 && w.K(bArr2[i10])) {
                    break;
                }
            }
            i10 += i9;
        }
        String r8 = r(i10 - this.f3700b, charset);
        if (this.f3700b != this.f3701c && f(charset, f3696d) == '\r') {
            f(charset, f3697e);
        }
        return r8;
    }

    public final int i() {
        byte[] bArr = this.f3699a;
        int i9 = this.f3700b;
        int i10 = i9 + 1;
        this.f3700b = i10;
        int i11 = bArr[i9] & 255;
        int i12 = i9 + 2;
        this.f3700b = i12;
        int i13 = ((bArr[i10] & 255) << 8) | i11;
        int i14 = i9 + 3;
        this.f3700b = i14;
        int i15 = i13 | ((bArr[i12] & 255) << 16);
        this.f3700b = i9 + 4;
        return ((bArr[i14] & 255) << 24) | i15;
    }

    public final long j() {
        byte[] bArr = this.f3699a;
        int i9 = this.f3700b;
        this.f3700b = i9 + 1;
        this.f3700b = i9 + 2;
        this.f3700b = i9 + 3;
        long j5 = (bArr[i9] & 255) | ((bArr[r2] & 255) << 8) | ((bArr[r7] & 255) << 16);
        this.f3700b = i9 + 4;
        long j9 = j5 | ((bArr[r8] & 255) << 24);
        this.f3700b = i9 + 5;
        long j10 = j9 | ((bArr[r7] & 255) << 32);
        this.f3700b = i9 + 6;
        long j11 = j10 | ((bArr[r8] & 255) << 40);
        this.f3700b = i9 + 7;
        long j12 = j11 | ((bArr[r7] & 255) << 48);
        this.f3700b = i9 + 8;
        return ((bArr[r8] & 255) << 56) | j12;
    }

    public final long k() {
        byte[] bArr = this.f3699a;
        int i9 = this.f3700b;
        this.f3700b = i9 + 1;
        this.f3700b = i9 + 2;
        long j5 = (bArr[i9] & 255) | ((bArr[r2] & 255) << 8);
        this.f3700b = i9 + 3;
        long j9 = j5 | ((bArr[r7] & 255) << 16);
        this.f3700b = i9 + 4;
        return ((bArr[r2] & 255) << 24) | j9;
    }

    public final int l() {
        int i9 = i();
        if (i9 >= 0) {
            return i9;
        }
        m7.c.p(androidx.activity.g.m(i9, "Top bit not zero: "));
        return 0;
    }

    public final int m() {
        byte[] bArr = this.f3699a;
        int i9 = this.f3700b;
        int i10 = i9 + 1;
        this.f3700b = i10;
        int i11 = bArr[i9] & 255;
        this.f3700b = i9 + 2;
        return ((bArr[i10] & 255) << 8) | i11;
    }

    public final long n() {
        byte[] bArr = this.f3699a;
        int i9 = this.f3700b;
        this.f3700b = i9 + 1;
        this.f3700b = i9 + 2;
        long j5 = ((bArr[i9] & 255) << 56) | ((bArr[r2] & 255) << 48);
        this.f3700b = i9 + 3;
        long j9 = j5 | ((bArr[r7] & 255) << 40);
        this.f3700b = i9 + 4;
        long j10 = j9 | ((bArr[r2] & 255) << 32);
        this.f3700b = i9 + 5;
        long j11 = j10 | ((bArr[r7] & 255) << 24);
        this.f3700b = i9 + 6;
        long j12 = j11 | ((bArr[r2] & 255) << 16);
        this.f3700b = i9 + 7;
        long j13 = j12 | ((bArr[r7] & 255) << 8);
        this.f3700b = i9 + 8;
        return (bArr[r2] & 255) | j13;
    }

    public final String o() {
        if (a() == 0) {
            return null;
        }
        int i9 = this.f3700b;
        while (i9 < this.f3701c && this.f3699a[i9] != 0) {
            i9++;
        }
        byte[] bArr = this.f3699a;
        int i10 = this.f3700b;
        int i11 = w.f3713a;
        String str = new String(bArr, i10, i9 - i10, a6.b.f203c);
        this.f3700b = i9;
        if (i9 < this.f3701c) {
            this.f3700b = i9 + 1;
        }
        return str;
    }

    public final String p(int i9) {
        if (i9 == 0) {
            return "";
        }
        int i10 = this.f3700b;
        int i11 = (i10 + i9) - 1;
        int i12 = (i11 >= this.f3701c || this.f3699a[i11] != 0) ? i9 : i9 - 1;
        byte[] bArr = this.f3699a;
        int i13 = w.f3713a;
        String str = new String(bArr, i10, i12, a6.b.f203c);
        this.f3700b += i9;
        return str;
    }

    public final short q() {
        byte[] bArr = this.f3699a;
        int i9 = this.f3700b;
        int i10 = i9 + 1;
        this.f3700b = i10;
        int i11 = (bArr[i9] & 255) << 8;
        this.f3700b = i9 + 2;
        return (short) ((bArr[i10] & 255) | i11);
    }

    public final String r(int i9, Charset charset) {
        String str = new String(this.f3699a, this.f3700b, i9, charset);
        this.f3700b += i9;
        return str;
    }

    public final int s() {
        return (t() << 21) | (t() << 14) | (t() << 7) | t();
    }

    public final int t() {
        byte[] bArr = this.f3699a;
        int i9 = this.f3700b;
        this.f3700b = i9 + 1;
        return bArr[i9] & 255;
    }

    public final int u() {
        byte[] bArr = this.f3699a;
        int i9 = this.f3700b;
        int i10 = i9 + 1;
        this.f3700b = i10;
        int i11 = (bArr[i9] & 255) << 8;
        this.f3700b = i9 + 2;
        int i12 = (bArr[i10] & 255) | i11;
        this.f3700b = i9 + 4;
        return i12;
    }

    public final long v() {
        byte[] bArr = this.f3699a;
        int i9 = this.f3700b;
        this.f3700b = i9 + 1;
        this.f3700b = i9 + 2;
        long j5 = ((bArr[i9] & 255) << 24) | ((bArr[r2] & 255) << 16);
        this.f3700b = i9 + 3;
        long j9 = j5 | ((bArr[r7] & 255) << 8);
        this.f3700b = i9 + 4;
        return (bArr[r2] & 255) | j9;
    }

    public final int w() {
        byte[] bArr = this.f3699a;
        int i9 = this.f3700b;
        int i10 = i9 + 1;
        this.f3700b = i10;
        int i11 = (bArr[i9] & 255) << 16;
        int i12 = i9 + 2;
        this.f3700b = i12;
        int i13 = ((bArr[i10] & 255) << 8) | i11;
        this.f3700b = i9 + 3;
        return (bArr[i12] & 255) | i13;
    }

    public final int x() {
        int g9 = g();
        if (g9 >= 0) {
            return g9;
        }
        m7.c.p(androidx.activity.g.m(g9, "Top bit not zero: "));
        return 0;
    }

    public final long y() {
        long n4 = n();
        if (n4 >= 0) {
            return n4;
        }
        throw new IllegalStateException("Top bit not zero: " + n4);
    }

    public final int z() {
        byte[] bArr = this.f3699a;
        int i9 = this.f3700b;
        int i10 = i9 + 1;
        this.f3700b = i10;
        int i11 = (bArr[i9] & 255) << 8;
        this.f3700b = i9 + 2;
        return (bArr[i10] & 255) | i11;
    }

    public p() {
        this.f3699a = w.f3718f;
    }

    public p(byte[] bArr) {
        this.f3699a = bArr;
        this.f3701c = bArr.length;
    }

    public p(byte[] bArr, int i9) {
        this.f3699a = bArr;
        this.f3701c = i9;
    }
}
