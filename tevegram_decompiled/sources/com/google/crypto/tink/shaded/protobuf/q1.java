package com.google.crypto.tink.shaded.protobuf;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class q1 extends com.bumptech.glide.c {

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f2295p;

    public /* synthetic */ q1(int i9) {
        this.f2295p = i9;
    }

    public static int b0(long j5, byte[] bArr, int i9, int i10) {
        if (i10 == 0) {
            com.bumptech.glide.c cVar = s1.f2298a;
            if (i9 > -12) {
                return -1;
            }
            return i9;
        }
        if (i10 == 1) {
            return s1.c(i9, p1.g(j5, bArr));
        }
        if (i10 == 2) {
            return s1.d(i9, p1.g(j5, bArr), p1.g(j5 + 1, bArr));
        }
        throw new AssertionError();
    }

    @Override // com.bumptech.glide.c
    public final int N(int i9, int i10, byte[] bArr) {
        long j5;
        int i11 = i9;
        byte b9 = -96;
        byte b10 = -62;
        switch (this.f2295p) {
            case 0:
                while (i11 < i10 && bArr[i11] >= 0) {
                    i11++;
                }
                if (i11 < i10) {
                    while (i11 < i10) {
                        int i12 = i11 + 1;
                        byte b11 = bArr[i11];
                        if (b11 < 0) {
                            if (b11 < -32) {
                                if (i12 >= i10) {
                                    return b11;
                                }
                                if (b11 >= -62) {
                                    i11 += 2;
                                    if (bArr[i12] > -65) {
                                    }
                                }
                                return -1;
                            }
                            if (b11 >= -16) {
                                if (i12 >= i10 - 2) {
                                    return s1.a(i12, i10, bArr);
                                }
                                int i13 = i11 + 2;
                                byte b12 = bArr[i12];
                                if (b12 <= -65 && (((b12 + 112) + (b11 << 28)) >> 30) == 0) {
                                    int i14 = i11 + 3;
                                    if (bArr[i13] <= -65) {
                                        i11 += 4;
                                        if (bArr[i14] > -65) {
                                        }
                                    }
                                }
                                return -1;
                            }
                            if (i12 >= i10 - 1) {
                                return s1.a(i12, i10, bArr);
                            }
                            int i15 = i11 + 2;
                            byte b13 = bArr[i12];
                            if (b13 <= -65 && ((b11 != -32 || b13 >= -96) && (b11 != -19 || b13 < -96))) {
                                i11 += 3;
                                if (bArr[i15] > -65) {
                                }
                            }
                            return -1;
                        }
                        i11 = i12;
                    }
                }
                return 0;
            default:
                if ((i11 | i10 | (bArr.length - i10)) < 0) {
                    throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i11), Integer.valueOf(i10)));
                }
                int i16 = 0;
                long j9 = i11;
                int i17 = (int) (i10 - j9);
                if (i17 < 16) {
                    j5 = j9;
                } else {
                    int i18 = 8 - (((int) j9) & 7);
                    j5 = j9;
                    long j10 = j5;
                    while (true) {
                        if (i16 < i18) {
                            long j11 = j10 + 1;
                            if (p1.g(j10, bArr) >= 0) {
                                i16++;
                                j10 = j11;
                            }
                        } else {
                            while (true) {
                                int i19 = i16 + 8;
                                if (i19 <= i17 && (p1.f2286c.h(p1.f2289f + j10, bArr) & (-9187201950435737472L)) == 0) {
                                    j10 += 8;
                                    i16 = i19;
                                }
                            }
                            while (true) {
                                if (i16 < i17) {
                                    long j12 = j10 + 1;
                                    if (p1.g(j10, bArr) >= 0) {
                                        i16++;
                                        j10 = j12;
                                    }
                                } else {
                                    i16 = i17;
                                }
                            }
                        }
                    }
                }
                int i20 = i17 - i16;
                long j13 = j5 + i16;
                while (true) {
                    byte b14 = 0;
                    while (true) {
                        if (i20 > 0) {
                            long j14 = j13 + 1;
                            b14 = p1.g(j13, bArr);
                            if (b14 >= 0) {
                                i20--;
                                j13 = j14;
                            } else {
                                j13 = j14;
                            }
                        }
                    }
                    if (i20 == 0) {
                        return 0;
                    }
                    int i21 = i20 - 1;
                    if (b14 < -32) {
                        if (i21 == 0) {
                            return b14;
                        }
                        i20 -= 2;
                        if (b14 >= b10) {
                            long j15 = j13 + 1;
                            if (p1.g(j13, bArr) <= -65) {
                                j13 = j15;
                                b9 = -96;
                                b10 = -62;
                            }
                        }
                    } else if (b14 < -16) {
                        if (i21 < 2) {
                            return b0(j13, bArr, b14, i21);
                        }
                        i20 -= 3;
                        long j16 = j13 + 1;
                        byte g9 = p1.g(j13, bArr);
                        if (g9 <= -65 && ((b14 != -32 || g9 >= b9) && (b14 != -19 || g9 < b9))) {
                            j13 += 2;
                            if (p1.g(j16, bArr) <= -65) {
                                b9 = -96;
                                b10 = -62;
                            }
                        }
                    } else {
                        if (i21 < 3) {
                            return b0(j13, bArr, b14, i21);
                        }
                        i20 -= 4;
                        long j17 = j13 + 1;
                        byte g10 = p1.g(j13, bArr);
                        if (g10 <= -65 && (((g10 + 112) + (b14 << 28)) >> 30) == 0) {
                            long j18 = j13 + 2;
                            if (p1.g(j17, bArr) <= -65) {
                                j13 += 3;
                                if (p1.g(j18, bArr) <= -65) {
                                    b9 = -96;
                                    b10 = -62;
                                }
                            }
                        }
                    }
                }
                return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0049  */
    @Override // com.bumptech.glide.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String q(int r11, int r12, byte[] r13) {
        /*
            Method dump skipped, instructions count: 358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.q1.q(int, int, byte[]):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:?, code lost:
    
        return r27 + r5;
     */
    @Override // com.bumptech.glide.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int r(java.lang.String r25, byte[] r26, int r27, int r28) {
        /*
            Method dump skipped, instructions count: 606
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.q1.r(java.lang.String, byte[], int, int):int");
    }
}
