package com.google.crypto.tink.shaded.protobuf;

import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k extends m {

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f2252c;

    /* renamed from: d, reason: collision with root package name */
    public int f2253d;

    /* renamed from: e, reason: collision with root package name */
    public int f2254e;

    /* renamed from: f, reason: collision with root package name */
    public int f2255f;

    /* renamed from: g, reason: collision with root package name */
    public final int f2256g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public int f2257i = Integer.MAX_VALUE;

    public k(byte[] bArr, int i9, int i10, boolean z8) {
        this.f2252c = bArr;
        this.f2253d = i10 + i9;
        this.f2255f = i9;
        this.f2256g = i9;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final String A() {
        int G = G();
        if (G > 0) {
            int i9 = this.f2253d;
            int i10 = this.f2255f;
            if (G <= i9 - i10) {
                String q4 = s1.f2298a.q(i10, G, this.f2252c);
                this.f2255f += G;
                return q4;
            }
        }
        if (G == 0) {
            return "";
        }
        if (G <= 0) {
            throw e0.e();
        }
        throw e0.g();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final int B() {
        if (g()) {
            this.h = 0;
            return 0;
        }
        int G = G();
        this.h = G;
        if ((G >>> 3) != 0) {
            return G;
        }
        throw e0.a();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final int C() {
        return G();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final long D() {
        return H();
    }

    public final int E() {
        int i9 = this.f2255f;
        if (this.f2253d - i9 < 4) {
            throw e0.g();
        }
        this.f2255f = i9 + 4;
        byte[] bArr = this.f2252c;
        return ((bArr[i9 + 3] & 255) << 24) | (bArr[i9] & 255) | ((bArr[i9 + 1] & 255) << 8) | ((bArr[i9 + 2] & 255) << 16);
    }

    public final long F() {
        int i9 = this.f2255f;
        if (this.f2253d - i9 < 8) {
            throw e0.g();
        }
        this.f2255f = i9 + 8;
        byte[] bArr = this.f2252c;
        return ((bArr[i9 + 7] & 255) << 56) | (bArr[i9] & 255) | ((bArr[i9 + 1] & 255) << 8) | ((bArr[i9 + 2] & 255) << 16) | ((bArr[i9 + 3] & 255) << 24) | ((bArr[i9 + 4] & 255) << 32) | ((bArr[i9 + 5] & 255) << 40) | ((bArr[i9 + 6] & 255) << 48);
    }

    public final int G() {
        int i9;
        int i10 = this.f2255f;
        int i11 = this.f2253d;
        if (i11 != i10) {
            int i12 = i10 + 1;
            byte[] bArr = this.f2252c;
            byte b9 = bArr[i10];
            if (b9 >= 0) {
                this.f2255f = i12;
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
                this.f2255f = i13;
                return i9;
            }
        }
        return (int) I();
    }

    public final long H() {
        long j5;
        long j9;
        long j10;
        long j11;
        int i9 = this.f2255f;
        int i10 = this.f2253d;
        if (i10 != i9) {
            int i11 = i9 + 1;
            byte[] bArr = this.f2252c;
            byte b9 = bArr[i9];
            if (b9 >= 0) {
                this.f2255f = i11;
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
                this.f2255f = i12;
                return j5;
            }
        }
        return I();
    }

    public final long I() {
        long j5 = 0;
        for (int i9 = 0; i9 < 64; i9 += 7) {
            int i10 = this.f2255f;
            if (i10 == this.f2253d) {
                throw e0.g();
            }
            this.f2255f = i10 + 1;
            j5 |= (r3 & Byte.MAX_VALUE) << i9;
            if ((this.f2252c[i10] & 128) == 0) {
                return j5;
            }
        }
        throw e0.d();
    }

    public final void J() {
        int i9 = this.f2253d + this.f2254e;
        this.f2253d = i9;
        int i10 = i9 - this.f2256g;
        int i11 = this.f2257i;
        if (i10 <= i11) {
            this.f2254e = 0;
            return;
        }
        int i12 = i10 - i11;
        this.f2254e = i12;
        this.f2253d = i9 - i12;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final void b(int i9) {
        if (this.h != i9) {
            throw new e0("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final int f() {
        return this.f2255f - this.f2256g;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final boolean g() {
        return this.f2255f == this.f2253d;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final void j(int i9) {
        this.f2257i = i9;
        J();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final int l(int i9) {
        if (i9 < 0) {
            throw e0.e();
        }
        int f9 = f() + i9;
        if (f9 < 0) {
            throw e0.f();
        }
        int i10 = this.f2257i;
        if (f9 > i10) {
            throw e0.g();
        }
        this.f2257i = f9;
        J();
        return i10;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final boolean m() {
        return H() != 0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final i n() {
        byte[] bArr;
        int G = G();
        byte[] bArr2 = this.f2252c;
        if (G > 0) {
            int i9 = this.f2253d;
            int i10 = this.f2255f;
            if (G <= i9 - i10) {
                i h = j.h(i10, G, bArr2);
                this.f2255f += G;
                return h;
            }
        }
        if (G == 0) {
            return j.f2248j;
        }
        if (G > 0) {
            int i11 = this.f2253d;
            int i12 = this.f2255f;
            if (G <= i11 - i12) {
                int i13 = G + i12;
                this.f2255f = i13;
                bArr = Arrays.copyOfRange(bArr2, i12, i13);
                i iVar = j.f2248j;
                return new i(bArr);
            }
        }
        if (G > 0) {
            throw e0.g();
        }
        if (G != 0) {
            throw e0.e();
        }
        bArr = c0.f2208b;
        i iVar2 = j.f2248j;
        return new i(bArr);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final double o() {
        return Double.longBitsToDouble(F());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final int p() {
        return G();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final int q() {
        return E();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final long r() {
        return F();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final float s() {
        return Float.intBitsToFloat(E());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final int t() {
        return G();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final long u() {
        return H();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final int v() {
        return E();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final long w() {
        return F();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final int x() {
        return m.d(G());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final long y() {
        return m.e(H());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.m
    public final String z() {
        int G = G();
        if (G > 0) {
            int i9 = this.f2253d;
            int i10 = this.f2255f;
            if (G <= i9 - i10) {
                String str = new String(this.f2252c, i10, G, c0.f2207a);
                this.f2255f += G;
                return str;
            }
        }
        if (G == 0) {
            return "";
        }
        if (G < 0) {
            throw e0.e();
        }
        throw e0.g();
    }
}
