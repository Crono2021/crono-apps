package w4;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import k4.x;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e extends InputStream {

    /* renamed from: k, reason: collision with root package name */
    public static final ArrayDeque f9934k;

    /* renamed from: i, reason: collision with root package name */
    public x f9935i;

    /* renamed from: j, reason: collision with root package name */
    public IOException f9936j;

    static {
        char[] cArr = n.f9951a;
        f9934k = new ArrayDeque(0);
    }

    public final void a() {
        this.f9936j = null;
        this.f9935i = null;
        ArrayDeque arrayDeque = f9934k;
        synchronized (arrayDeque) {
            arrayDeque.offer(this);
        }
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f9935i.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f9935i.close();
    }

    @Override // java.io.InputStream
    public final void mark(int i9) {
        this.f9935i.mark(i9);
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        this.f9935i.getClass();
        return true;
    }

    @Override // java.io.InputStream
    public final int read() {
        try {
            return this.f9935i.read();
        } catch (IOException e9) {
            this.f9936j = e9;
            throw e9;
        }
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        this.f9935i.reset();
    }

    @Override // java.io.InputStream
    public final long skip(long j5) {
        try {
            return this.f9935i.skip(j5);
        } catch (IOException e9) {
            this.f9936j = e9;
            throw e9;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) {
        try {
            return this.f9935i.read(bArr);
        } catch (IOException e9) {
            this.f9936j = e9;
            throw e9;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i9, int i10) {
        try {
            return this.f9935i.read(bArr, i9, i10);
        } catch (IOException e9) {
            this.f9936j = e9;
            throw e9;
        }
    }
}
