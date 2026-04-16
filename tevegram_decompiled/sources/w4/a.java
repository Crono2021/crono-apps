package w4;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a extends InputStream {

    /* renamed from: i, reason: collision with root package name */
    public final ByteBuffer f9928i;

    /* renamed from: j, reason: collision with root package name */
    public int f9929j = -1;

    public a(ByteBuffer byteBuffer) {
        this.f9928i = byteBuffer;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f9928i.remaining();
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int i9) {
        this.f9929j = this.f9928i.position();
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i9, int i10) {
        ByteBuffer byteBuffer = this.f9928i;
        if (!byteBuffer.hasRemaining()) {
            return -1;
        }
        int min = Math.min(i10, byteBuffer.remaining());
        byteBuffer.get(bArr, i9, min);
        return min;
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        int i9 = this.f9929j;
        if (i9 == -1) {
            throw new IOException("Cannot reset to unset mark position");
        }
        this.f9928i.position(i9);
    }

    @Override // java.io.InputStream
    public final long skip(long j5) {
        ByteBuffer byteBuffer = this.f9928i;
        if (!byteBuffer.hasRemaining()) {
            return -1L;
        }
        long min = Math.min(j5, byteBuffer.remaining());
        byteBuffer.position((int) (byteBuffer.position() + min));
        return min;
    }

    @Override // java.io.InputStream
    public final int read() {
        ByteBuffer byteBuffer = this.f9928i;
        if (byteBuffer.hasRemaining()) {
            return byteBuffer.get() & 255;
        }
        return -1;
    }
}
