package w4;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d extends FilterInputStream {

    /* renamed from: i, reason: collision with root package name */
    public final long f9932i;

    /* renamed from: j, reason: collision with root package name */
    public int f9933j;

    public d(InputStream inputStream, long j5) {
        super(inputStream);
        this.f9932i = j5;
    }

    public final void a(int i9) {
        int i10 = this.f9933j;
        if (i9 >= 0) {
            this.f9933j = i10 + i9;
            return;
        }
        long j5 = this.f9932i;
        if (j5 - i10 <= 0) {
            return;
        }
        StringBuilder c9 = t.a.c("Failed to read all expected data, expected: ", j5, ", but read: ");
        c9.append(this.f9933j);
        throw new IOException(c9.toString());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int available() {
        return (int) Math.max(this.f9932i - this.f9933j, ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read() {
        int read;
        read = super.read();
        a(read >= 0 ? 1 : -1);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] bArr, int i9, int i10) {
        int read;
        read = super.read(bArr, i9, i10);
        a(read);
        return read;
    }
}
