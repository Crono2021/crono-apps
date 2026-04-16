package com.bumptech.glide.load.data;

import java.io.FilterInputStream;
import java.io.InputStream;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j extends FilterInputStream {

    /* renamed from: k, reason: collision with root package name */
    public static final byte[] f1802k = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};

    /* renamed from: l, reason: collision with root package name */
    public static final int f1803l = 31;

    /* renamed from: i, reason: collision with root package name */
    public final byte f1804i;

    /* renamed from: j, reason: collision with root package name */
    public int f1805j;

    public j(InputStream inputStream, int i9) {
        super(inputStream);
        if (i9 < -1 || i9 > 8) {
            m7.c.n(androidx.activity.g.m(i9, "Cannot add invalid orientation: "));
            throw null;
        }
        this.f1804i = (byte) i9;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void mark(int i9) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i9, int i10) {
        int i11;
        int i12 = this.f1805j;
        int i13 = f1803l;
        if (i12 > i13) {
            i11 = super.read(bArr, i9, i10);
        } else if (i12 == i13) {
            bArr[i9] = this.f1804i;
            i11 = 1;
        } else if (i12 < 2) {
            i11 = super.read(bArr, i9, 2 - i12);
        } else {
            int min = Math.min(i13 - i12, i10);
            System.arraycopy(f1802k, this.f1805j - 2, bArr, i9, min);
            i11 = min;
        }
        if (i11 > 0) {
            this.f1805j += i11;
        }
        return i11;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j5) {
        long skip = super.skip(j5);
        if (skip > 0) {
            this.f1805j = (int) (this.f1805j + skip);
        }
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() {
        int read;
        int i9;
        int i10 = this.f1805j;
        if (i10 < 2 || i10 > (i9 = f1803l)) {
            read = super.read();
        } else if (i10 == i9) {
            read = this.f1804i;
        } else {
            read = f1802k[i10 - 2] & 255;
        }
        if (read != -1) {
            this.f1805j++;
        }
        return read;
    }
}
