package com.google.crypto.tink.shaded.protobuf;

import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l extends m {

    /* renamed from: c, reason: collision with root package name */
    public final ByteArrayInputStream f2261c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f2262d;

    /* renamed from: e, reason: collision with root package name */
    public int f2263e;

    /* renamed from: f, reason: collision with root package name */
    public int f2264f;

    /* renamed from: g, reason: collision with root package name */
    public int f2265g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public int f2266i;

    /* renamed from: j, reason: collision with root package name */
    public int f2267j = Integer.MAX_VALUE;

    public l(ByteArrayInputStream byteArrayInputStream) {
        Charset charset = c0.f2207a;
        this.f2261c = byteArrayInputStream;
        this.f2262d = new byte[4096];
        this.f2263e = 0;
        this.f2265g = 0;
        this.f2266i = 0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final String A() {
        int J = J();
        int i9 = this.f2265g;
        int i10 = this.f2263e;
        int i11 = i10 - i9;
        byte[] bArr = this.f2262d;
        if (J <= i11 && J > 0) {
            this.f2265g = i9 + J;
        } else {
            if (J == 0) {
                return "";
            }
            i9 = 0;
            if (J <= i10) {
                N(J);
                this.f2265g = J;
            } else {
                bArr = E(J);
            }
        }
        return s1.f2298a.q(i9, J, bArr);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final int B() {
        if (g()) {
            this.h = 0;
            return 0;
        }
        int J = J();
        this.h = J;
        if ((J >>> 3) != 0) {
            return J;
        }
        throw e0.a();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final int C() {
        return J();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final long D() {
        return K();
    }

    public final byte[] E(int i9) {
        byte[] F = F(i9);
        if (F != null) {
            return F;
        }
        int i10 = this.f2265g;
        int i11 = this.f2263e;
        int i12 = i11 - i10;
        this.f2266i += i11;
        this.f2265g = 0;
        this.f2263e = 0;
        ArrayList G = G(i9 - i12);
        byte[] bArr = new byte[i9];
        System.arraycopy(this.f2262d, i10, bArr, 0, i12);
        int size = G.size();
        int i13 = 0;
        while (i13 < size) {
            Object obj = G.get(i13);
            i13++;
            byte[] bArr2 = (byte[]) obj;
            System.arraycopy(bArr2, 0, bArr, i12, bArr2.length);
            i12 += bArr2.length;
        }
        return bArr;
    }

    public final byte[] F(int i9) {
        if (i9 == 0) {
            return c0.f2208b;
        }
        if (i9 < 0) {
            throw e0.e();
        }
        int i10 = this.f2266i;
        int i11 = this.f2265g;
        int i12 = i10 + i11 + i9;
        if (i12 - Integer.MAX_VALUE > 0) {
            throw new e0("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
        }
        int i13 = this.f2267j;
        if (i12 > i13) {
            O((i13 - i10) - i11);
            throw e0.g();
        }
        int i14 = this.f2263e - i11;
        int i15 = i9 - i14;
        ByteArrayInputStream byteArrayInputStream = this.f2261c;
        if (i15 >= 4096) {
            try {
                if (i15 > byteArrayInputStream.available()) {
                    return null;
                }
            } catch (e0 e9) {
                e9.f2216i = true;
                throw e9;
            }
        }
        byte[] bArr = new byte[i9];
        System.arraycopy(this.f2262d, this.f2265g, bArr, 0, i14);
        this.f2266i += this.f2263e;
        this.f2265g = 0;
        this.f2263e = 0;
        while (i14 < i9) {
            try {
                int read = byteArrayInputStream.read(bArr, i14, i9 - i14);
                if (read == -1) {
                    throw e0.g();
                }
                this.f2266i += read;
                i14 += read;
            } catch (e0 e10) {
                e10.f2216i = true;
                throw e10;
            }
        }
        return bArr;
    }

    public final ArrayList G(int i9) {
        ArrayList arrayList = new ArrayList();
        while (i9 > 0) {
            int min = Math.min(i9, 4096);
            byte[] bArr = new byte[min];
            int i10 = 0;
            while (i10 < min) {
                int read = this.f2261c.read(bArr, i10, min - i10);
                if (read == -1) {
                    throw e0.g();
                }
                this.f2266i += read;
                i10 += read;
            }
            i9 -= min;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    public final int H() {
        int i9 = this.f2265g;
        if (this.f2263e - i9 < 4) {
            N(4);
            i9 = this.f2265g;
        }
        this.f2265g = i9 + 4;
        byte[] bArr = this.f2262d;
        return ((bArr[i9 + 3] & 255) << 24) | (bArr[i9] & 255) | ((bArr[i9 + 1] & 255) << 8) | ((bArr[i9 + 2] & 255) << 16);
    }

    public final long I() {
        int i9 = this.f2265g;
        if (this.f2263e - i9 < 8) {
            N(8);
            i9 = this.f2265g;
        }
        this.f2265g = i9 + 8;
        byte[] bArr = this.f2262d;
        return ((bArr[i9 + 7] & 255) << 56) | (bArr[i9] & 255) | ((bArr[i9 + 1] & 255) << 8) | ((bArr[i9 + 2] & 255) << 16) | ((bArr[i9 + 3] & 255) << 24) | ((bArr[i9 + 4] & 255) << 32) | ((bArr[i9 + 5] & 255) << 40) | ((bArr[i9 + 6] & 255) << 48);
    }

    public final int J() {
        int i9;
        int i10 = this.f2265g;
        int i11 = this.f2263e;
        if (i11 != i10) {
            int i12 = i10 + 1;
            byte[] bArr = this.f2262d;
            byte b9 = bArr[i10];
            if (b9 >= 0) {
                this.f2265g = i12;
                return b9;
            }
            if (i11 - i12 >= 9) {
                int i13 = i10 + 2;
                int i14 = (bArr[i12] << 7) ^ b9;
                if (i14 < 0) {
                    i9 = i14 ^ (-128);
                } else {
                    int i15 = i10 + 3;
                    int i16 = (bArr[i13] << 14) ^ i14;
                    if (i16 >= 0) {
                        i9 = i16 ^ 16256;
                    } else {
                        int i17 = i10 + 4;
                        int i18 = i16 ^ (bArr[i15] << 21);
                        if (i18 < 0) {
                            i9 = (-2080896) ^ i18;
                        } else {
                            i15 = i10 + 5;
                            byte b10 = bArr[i17];
                            int i19 = (i18 ^ (b10 << 28)) ^ 266354560;
                            if (b10 < 0) {
                                i17 = i10 + 6;
                                if (bArr[i15] < 0) {
                                    i15 = i10 + 7;
                                    if (bArr[i17] < 0) {
                                        i17 = i10 + 8;
                                        if (bArr[i15] < 0) {
                                            i15 = i10 + 9;
                                            if (bArr[i17] < 0) {
                                                int i20 = i10 + 10;
                                                if (bArr[i15] >= 0) {
                                                    i13 = i20;
                                                    i9 = i19;
                                                }
                                            }
                                        }
                                    }
                                }
                                i9 = i19;
                            }
                            i9 = i19;
                        }
                        i13 = i17;
                    }
                    i13 = i15;
                }
                this.f2265g = i13;
                return i9;
            }
        }
        return (int) L();
    }

    public final long K() {
        long j5;
        long j9;
        long j10;
        long j11;
        int i9 = this.f2265g;
        int i10 = this.f2263e;
        if (i10 != i9) {
            int i11 = i9 + 1;
            byte[] bArr = this.f2262d;
            byte b9 = bArr[i9];
            if (b9 >= 0) {
                this.f2265g = i11;
                return b9;
            }
            if (i10 - i11 >= 9) {
                int i12 = i9 + 2;
                int i13 = (bArr[i11] << 7) ^ b9;
                if (i13 < 0) {
                    j5 = i13 ^ (-128);
                } else {
                    int i14 = i9 + 3;
                    int i15 = (bArr[i12] << 14) ^ i13;
                    if (i15 >= 0) {
                        j5 = i15 ^ 16256;
                        i12 = i14;
                    } else {
                        int i16 = i9 + 4;
                        int i17 = i15 ^ (bArr[i14] << 21);
                        if (i17 < 0) {
                            j11 = (-2080896) ^ i17;
                        } else {
                            long j12 = i17;
                            i12 = i9 + 5;
                            long j13 = j12 ^ (bArr[i16] << 28);
                            if (j13 >= 0) {
                                j10 = 266354560;
                            } else {
                                i16 = i9 + 6;
                                long j14 = j13 ^ (bArr[i12] << 35);
                                if (j14 < 0) {
                                    j9 = -34093383808L;
                                } else {
                                    i12 = i9 + 7;
                                    j13 = j14 ^ (bArr[i16] << 42);
                                    if (j13 >= 0) {
                                        j10 = 4363953127296L;
                                    } else {
                                        i16 = i9 + 8;
                                        j14 = j13 ^ (bArr[i12] << 49);
                                        if (j14 < 0) {
                                            j9 = -558586000294016L;
                                        } else {
                                            i12 = i9 + 9;
                                            long j15 = (j14 ^ (bArr[i16] << 56)) ^ 71499008037633920L;
                                            if (j15 < 0) {
                                                int i18 = i9 + 10;
                                                if (bArr[i12] >= 0) {
                                                    i12 = i18;
                                                }
                                            }
                                            j5 = j15;
                                        }
                                    }
                                }
                                j11 = j9 ^ j14;
                            }
                            j5 = j10 ^ j13;
                        }
                        i12 = i16;
                        j5 = j11;
                    }
                }
                this.f2265g = i12;
                return j5;
            }
        }
        return L();
    }

    public final long L() {
        long j5 = 0;
        for (int i9 = 0; i9 < 64; i9 += 7) {
            if (this.f2265g == this.f2263e) {
                N(1);
            }
            int i10 = this.f2265g;
            this.f2265g = i10 + 1;
            j5 |= (r3 & Byte.MAX_VALUE) << i9;
            if ((this.f2262d[i10] & 128) == 0) {
                return j5;
            }
        }
        throw e0.d();
    }

    public final void M() {
        int i9 = this.f2263e + this.f2264f;
        this.f2263e = i9;
        int i10 = this.f2266i + i9;
        int i11 = this.f2267j;
        if (i10 <= i11) {
            this.f2264f = 0;
            return;
        }
        int i12 = i10 - i11;
        this.f2264f = i12;
        this.f2263e = i9 - i12;
    }

    public final void N(int i9) {
        if (P(i9)) {
            return;
        }
        if (i9 <= (Integer.MAX_VALUE - this.f2266i) - this.f2265g) {
            throw e0.g();
        }
        throw new e0("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public final void O(int i9) {
        int i10 = this.f2263e;
        int i11 = this.f2265g;
        int i12 = i10 - i11;
        if (i9 <= i12 && i9 >= 0) {
            this.f2265g = i11 + i9;
            return;
        }
        ByteArrayInputStream byteArrayInputStream = this.f2261c;
        if (i9 < 0) {
            throw e0.e();
        }
        int i13 = this.f2266i;
        int i14 = i13 + i11;
        int i15 = i14 + i9;
        int i16 = this.f2267j;
        if (i15 > i16) {
            O((i16 - i13) - i11);
            throw e0.g();
        }
        this.f2266i = i14;
        this.f2263e = 0;
        this.f2265g = 0;
        while (i12 < i9) {
            long j5 = i9 - i12;
            try {
                try {
                    long skip = byteArrayInputStream.skip(j5);
                    if (skip < 0 || skip > j5) {
                        throw new IllegalStateException(byteArrayInputStream.getClass() + "#skip returned invalid result: " + skip + "\nThe InputStream implementation is buggy.");
                    }
                    if (skip == 0) {
                        break;
                    } else {
                        i12 += (int) skip;
                    }
                } catch (e0 e9) {
                    e9.f2216i = true;
                    throw e9;
                }
            } catch (Throwable th) {
                this.f2266i += i12;
                M();
                throw th;
            }
        }
        this.f2266i += i12;
        M();
        if (i12 >= i9) {
            return;
        }
        int i17 = this.f2263e;
        int i18 = i17 - this.f2265g;
        this.f2265g = i17;
        N(1);
        while (true) {
            int i19 = i9 - i18;
            int i20 = this.f2263e;
            if (i19 <= i20) {
                this.f2265g = i19;
                return;
            } else {
                i18 += i20;
                this.f2265g = i20;
                N(1);
            }
        }
    }

    public final boolean P(int i9) {
        ByteArrayInputStream byteArrayInputStream = this.f2261c;
        int i10 = this.f2265g;
        int i11 = i10 + i9;
        int i12 = this.f2263e;
        if (i11 <= i12) {
            throw new IllegalStateException("refillBuffer() called when " + i9 + " bytes were already available in buffer");
        }
        int i13 = this.f2266i;
        if (i9 <= (Integer.MAX_VALUE - i13) - i10 && i13 + i10 + i9 <= this.f2267j) {
            byte[] bArr = this.f2262d;
            if (i10 > 0) {
                if (i12 > i10) {
                    System.arraycopy(bArr, i10, bArr, 0, i12 - i10);
                }
                this.f2266i += i10;
                this.f2263e -= i10;
                this.f2265g = 0;
            }
            int i14 = this.f2263e;
            try {
                int read = byteArrayInputStream.read(bArr, i14, Math.min(bArr.length - i14, (Integer.MAX_VALUE - this.f2266i) - i14));
                if (read == 0 || read < -1 || read > bArr.length) {
                    throw new IllegalStateException(byteArrayInputStream.getClass() + "#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
                }
                if (read > 0) {
                    this.f2263e += read;
                    M();
                    if (this.f2263e >= i9) {
                        return true;
                    }
                    return P(i9);
                }
            } catch (e0 e9) {
                e9.f2216i = true;
                throw e9;
            }
        }
        return false;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final void b(int i9) {
        if (this.h != i9) {
            throw new e0("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final int f() {
        return this.f2266i + this.f2265g;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final boolean g() {
        return this.f2265g == this.f2263e && !P(1);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final void j(int i9) {
        this.f2267j = i9;
        M();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final int l(int i9) {
        if (i9 < 0) {
            throw e0.e();
        }
        int i10 = this.f2266i + this.f2265g + i9;
        int i11 = this.f2267j;
        if (i10 > i11) {
            throw e0.g();
        }
        this.f2267j = i10;
        M();
        return i11;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final boolean m() {
        return K() != 0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final i n() {
        int J = J();
        int i9 = this.f2263e;
        int i10 = this.f2265g;
        int i11 = i9 - i10;
        byte[] bArr = this.f2262d;
        if (J <= i11 && J > 0) {
            i h = j.h(i10, J, bArr);
            this.f2265g += J;
            return h;
        }
        if (J == 0) {
            return j.f2248j;
        }
        byte[] F = F(J);
        if (F != null) {
            return j.h(0, F.length, F);
        }
        int i12 = this.f2265g;
        int i13 = this.f2263e;
        int i14 = i13 - i12;
        this.f2266i += i13;
        this.f2265g = 0;
        this.f2263e = 0;
        ArrayList G = G(J - i14);
        byte[] bArr2 = new byte[J];
        System.arraycopy(bArr, i12, bArr2, 0, i14);
        int size = G.size();
        int i15 = 0;
        while (i15 < size) {
            Object obj = G.get(i15);
            i15++;
            byte[] bArr3 = (byte[]) obj;
            System.arraycopy(bArr3, 0, bArr2, i14, bArr3.length);
            i14 += bArr3.length;
        }
        i iVar = j.f2248j;
        return new i(bArr2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final double o() {
        return Double.longBitsToDouble(I());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final int p() {
        return J();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final int q() {
        return H();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final long r() {
        return I();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final float s() {
        return Float.intBitsToFloat(H());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final int t() {
        return J();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final long u() {
        return K();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final int v() {
        return H();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final long w() {
        return I();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final int x() {
        return m.d(J());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final long y() {
        return m.e(K());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final String z() {
        int J = J();
        byte[] bArr = this.f2262d;
        if (J > 0) {
            int i9 = this.f2263e;
            int i10 = this.f2265g;
            if (J <= i9 - i10) {
                String str = new String(bArr, i10, J, c0.f2207a);
                this.f2265g += J;
                return str;
            }
        }
        if (J == 0) {
            return "";
        }
        if (J > this.f2263e) {
            return new String(E(J), c0.f2207a);
        }
        N(J);
        String str2 = new String(bArr, this.f2265g, J, c0.f2207a);
        this.f2265g += J;
        return str2;
    }
}
