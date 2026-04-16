package k4;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class x extends FilterInputStream {

    /* renamed from: i, reason: collision with root package name */
    public volatile byte[] f5604i;

    /* renamed from: j, reason: collision with root package name */
    public int f5605j;

    /* renamed from: k, reason: collision with root package name */
    public int f5606k;

    /* renamed from: l, reason: collision with root package name */
    public int f5607l;

    /* renamed from: m, reason: collision with root package name */
    public int f5608m;

    /* renamed from: n, reason: collision with root package name */
    public final e4.f f5609n;

    public x(InputStream inputStream, e4.f fVar) {
        super(inputStream);
        this.f5607l = -1;
        this.f5609n = fVar;
        this.f5604i = (byte[]) fVar.d(65536, byte[].class);
    }

    public static void c() {
        throw new IOException("BufferedInputStream is closed");
    }

    public final int a(InputStream inputStream, byte[] bArr) {
        int i9 = this.f5607l;
        if (i9 != -1) {
            int i10 = this.f5608m - i9;
            int i11 = this.f5606k;
            if (i10 < i11) {
                if (i9 == 0 && i11 > bArr.length && this.f5605j == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i11) {
                        i11 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f5609n.d(i11, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f5604i = bArr2;
                    this.f5609n.h(bArr);
                    bArr = bArr2;
                } else if (i9 > 0) {
                    System.arraycopy(bArr, i9, bArr, 0, bArr.length - i9);
                }
                int i12 = this.f5608m - this.f5607l;
                this.f5608m = i12;
                this.f5607l = 0;
                this.f5605j = 0;
                int read = inputStream.read(bArr, i12, bArr.length - i12);
                int i13 = this.f5608m;
                if (read > 0) {
                    i13 += read;
                }
                this.f5605j = i13;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.f5607l = -1;
            this.f5608m = 0;
            this.f5605j = read2;
        }
        return read2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int available() {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f5604i == null || inputStream == null) {
            c();
            throw null;
        }
        return (this.f5605j - this.f5608m) + inputStream.available();
    }

    public final synchronized void b() {
        if (this.f5604i != null) {
            this.f5609n.h(this.f5604i);
            this.f5604i = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f5604i != null) {
            this.f5609n.h(this.f5604i);
            this.f5604i = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i9) {
        this.f5606k = Math.max(this.f5606k, i9);
        this.f5607l = this.f5608m;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] bArr, int i9, int i10) {
        int i11;
        int i12;
        byte[] bArr2 = this.f5604i;
        if (bArr2 == null) {
            c();
            throw null;
        }
        if (i10 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            c();
            throw null;
        }
        int i13 = this.f5608m;
        int i14 = this.f5605j;
        if (i13 < i14) {
            int i15 = i14 - i13;
            if (i15 >= i10) {
                i15 = i10;
            }
            System.arraycopy(bArr2, i13, bArr, i9, i15);
            this.f5608m += i15;
            if (i15 == i10 || inputStream.available() == 0) {
                return i15;
            }
            i9 += i15;
            i11 = i10 - i15;
        } else {
            i11 = i10;
        }
        while (true) {
            if (this.f5607l == -1 && i11 >= bArr2.length) {
                i12 = inputStream.read(bArr, i9, i11);
                if (i12 == -1) {
                    return i11 != i10 ? i10 - i11 : -1;
                }
            } else {
                if (a(inputStream, bArr2) == -1) {
                    return i11 != i10 ? i10 - i11 : -1;
                }
                if (bArr2 != this.f5604i && (bArr2 = this.f5604i) == null) {
                    c();
                    throw null;
                }
                int i16 = this.f5605j;
                int i17 = this.f5608m;
                i12 = i16 - i17;
                if (i12 >= i11) {
                    i12 = i11;
                }
                System.arraycopy(bArr2, i17, bArr, i9, i12);
                this.f5608m += i12;
            }
            i11 -= i12;
            if (i11 == 0) {
                return i10;
            }
            if (inputStream.available() == 0) {
                return i10 - i11;
            }
            i9 += i12;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        if (this.f5604i == null) {
            throw new IOException("Stream is closed");
        }
        int i9 = this.f5607l;
        if (-1 == i9) {
            throw new b4.c("Mark has been invalidated, pos: " + this.f5608m + " markLimit: " + this.f5606k);
        }
        this.f5608m = i9;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized long skip(long j5) {
        if (j5 < 1) {
            return 0L;
        }
        byte[] bArr = this.f5604i;
        if (bArr == null) {
            c();
            throw null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            c();
            throw null;
        }
        int i9 = this.f5605j;
        int i10 = this.f5608m;
        if (i9 - i10 >= j5) {
            this.f5608m = (int) (i10 + j5);
            return j5;
        }
        long j9 = i9 - i10;
        this.f5608m = i9;
        if (this.f5607l == -1 || j5 > this.f5606k) {
            long skip = inputStream.skip(j5 - j9);
            if (skip > 0) {
                this.f5607l = -1;
            }
            return j9 + skip;
        }
        if (a(inputStream, bArr) == -1) {
            return j9;
        }
        int i11 = this.f5605j;
        int i12 = this.f5608m;
        if (i11 - i12 >= j5 - j9) {
            this.f5608m = (int) ((i12 + j5) - j9);
            return j5;
        }
        long j10 = (j9 + i11) - i12;
        this.f5608m = i11;
        return j10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read() {
        byte[] bArr = this.f5604i;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr != null && inputStream != null) {
            if (this.f5608m >= this.f5605j && a(inputStream, bArr) == -1) {
                return -1;
            }
            if (bArr != this.f5604i && (bArr = this.f5604i) == null) {
                c();
                throw null;
            }
            int i9 = this.f5605j;
            int i10 = this.f5608m;
            if (i9 - i10 <= 0) {
                return -1;
            }
            this.f5608m = i10 + 1;
            return bArr[i10] & 255;
        }
        c();
        throw null;
    }
}
