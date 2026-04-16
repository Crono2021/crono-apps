package i1;

import java.io.InputStream;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j extends InputStream {

    /* renamed from: i, reason: collision with root package name */
    public final h f4319i;

    /* renamed from: j, reason: collision with root package name */
    public final k f4320j;

    /* renamed from: l, reason: collision with root package name */
    public boolean f4322l = false;

    /* renamed from: m, reason: collision with root package name */
    public boolean f4323m = false;

    /* renamed from: k, reason: collision with root package name */
    public final byte[] f4321k = new byte[1];

    public j(h hVar, k kVar) {
        this.f4319i = hVar;
        this.f4320j = kVar;
    }

    public final void a() {
        if (this.f4322l) {
            return;
        }
        this.f4319i.f(this.f4320j);
        this.f4322l = true;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f4323m) {
            return;
        }
        this.f4319i.close();
        this.f4323m = true;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i9, int i10) {
        g1.a.k(!this.f4323m);
        a();
        int read = this.f4319i.read(bArr, i9, i10);
        if (read == -1) {
            return -1;
        }
        return read;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public final int read() {
        byte[] bArr = this.f4321k;
        if (read(bArr, 0, bArr.length) == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }
}
