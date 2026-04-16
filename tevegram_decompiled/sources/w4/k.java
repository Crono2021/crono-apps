package w4;

import java.io.FilterInputStream;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k extends FilterInputStream {

    /* renamed from: i, reason: collision with root package name */
    public int f9946i;

    public k(e eVar) {
        super(eVar);
        this.f9946i = Integer.MIN_VALUE;
    }

    public final long a(long j5) {
        int i9 = this.f9946i;
        if (i9 == 0) {
            return -1L;
        }
        return (i9 == Integer.MIN_VALUE || j5 <= ((long) i9)) ? j5 : i9;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() {
        int i9 = this.f9946i;
        return i9 == Integer.MIN_VALUE ? super.available() : Math.min(i9, super.available());
    }

    public final void b(long j5) {
        int i9 = this.f9946i;
        if (i9 == Integer.MIN_VALUE || j5 == -1) {
            return;
        }
        this.f9946i = (int) (i9 - j5);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i9) {
        super.mark(i9);
        this.f9946i = i9;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() {
        if (a(1L) == -1) {
            return -1;
        }
        int read = super.read();
        b(1L);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        super.reset();
        this.f9946i = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j5) {
        long a9 = a(j5);
        if (a9 == -1) {
            return 0L;
        }
        long skip = super.skip(a9);
        b(skip);
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i9, int i10) {
        int a9 = (int) a(i10);
        if (a9 == -1) {
            return -1;
        }
        int read = super.read(bArr, i9, a9);
        b(read);
        return read;
    }
}
