package com.google.crypto.tink.shaded.protobuf;

import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class s1 {

    /* renamed from: a, reason: collision with root package name */
    public static final com.bumptech.glide.c f2298a;

    static {
        f2298a = (p1.f2288e && p1.f2287d && !c.a()) ? new q1(1) : new q1(0);
    }

    public static int a(int i9, int i10, byte[] bArr) {
        byte b9 = bArr[i9 - 1];
        int i11 = i10 - i9;
        if (i11 == 0) {
            if (b9 > -12) {
                return -1;
            }
            return b9;
        }
        if (i11 == 1) {
            return c(b9, bArr[i9]);
        }
        if (i11 == 2) {
            return d(b9, bArr[i9], bArr[i9 + 1]);
        }
        throw new AssertionError();
    }

    public static int b(String str) {
        int length = str.length();
        int i9 = 0;
        int i10 = 0;
        while (i10 < length && str.charAt(i10) < 128) {
            i10++;
        }
        int i11 = length;
        while (true) {
            if (i10 >= length) {
                break;
            }
            char charAt = str.charAt(i10);
            if (charAt < 2048) {
                i11 += (127 - charAt) >>> 31;
                i10++;
            } else {
                int length2 = str.length();
                while (i10 < length2) {
                    char charAt2 = str.charAt(i10);
                    if (charAt2 < 2048) {
                        i9 += (127 - charAt2) >>> 31;
                    } else {
                        i9 += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(str, i10) < 65536) {
                                throw new r1(i10, length2);
                            }
                            i10++;
                        }
                    }
                    i10++;
                }
                i11 += i9;
            }
        }
        if (i11 >= length) {
            return i11;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i11 + IjkMediaMeta.AV_CH_WIDE_RIGHT));
    }

    public static int c(int i9, int i10) {
        if (i9 > -12 || i10 > -65) {
            return -1;
        }
        return i9 ^ (i10 << 8);
    }

    public static int d(int i9, int i10, int i11) {
        if (i9 > -12 || i10 > -65 || i11 > -65) {
            return -1;
        }
        return (i9 ^ (i10 << 8)) ^ (i11 << 16);
    }
}
