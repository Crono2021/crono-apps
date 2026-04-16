package com.bumptech.glide.load.data;

import java.io.FileOutputStream;
import java.io.OutputStream;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c extends OutputStream {

    /* renamed from: i, reason: collision with root package name */
    public final FileOutputStream f1794i;

    /* renamed from: j, reason: collision with root package name */
    public byte[] f1795j;

    /* renamed from: k, reason: collision with root package name */
    public final e4.f f1796k;

    /* renamed from: l, reason: collision with root package name */
    public int f1797l;

    public c(FileOutputStream fileOutputStream, e4.f fVar) {
        this.f1794i = fileOutputStream;
        this.f1796k = fVar;
        this.f1795j = (byte[]) fVar.d(65536, byte[].class);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        FileOutputStream fileOutputStream = this.f1794i;
        try {
            flush();
            fileOutputStream.close();
            byte[] bArr = this.f1795j;
            if (bArr != null) {
                this.f1796k.h(bArr);
                this.f1795j = null;
            }
        } catch (Throwable th) {
            fileOutputStream.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
        int i9 = this.f1797l;
        FileOutputStream fileOutputStream = this.f1794i;
        if (i9 > 0) {
            fileOutputStream.write(this.f1795j, 0, i9);
            this.f1797l = 0;
        }
        fileOutputStream.flush();
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i9, int i10) {
        int i11 = 0;
        do {
            int i12 = i10 - i11;
            int i13 = i9 + i11;
            int i14 = this.f1797l;
            FileOutputStream fileOutputStream = this.f1794i;
            if (i14 == 0 && i12 >= this.f1795j.length) {
                fileOutputStream.write(bArr, i13, i12);
                return;
            }
            int min = Math.min(i12, this.f1795j.length - i14);
            System.arraycopy(bArr, i13, this.f1795j, this.f1797l, min);
            int i15 = this.f1797l + min;
            this.f1797l = i15;
            i11 += min;
            byte[] bArr2 = this.f1795j;
            if (i15 == bArr2.length && i15 > 0) {
                fileOutputStream.write(bArr2, 0, i15);
                this.f1797l = 0;
            }
        } while (i11 < i10);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public final void write(int i9) {
        byte[] bArr = this.f1795j;
        int i10 = this.f1797l;
        int i11 = i10 + 1;
        this.f1797l = i11;
        bArr[i10] = (byte) i9;
        if (i11 != bArr.length || i11 <= 0) {
            return;
        }
        this.f1794i.write(bArr, 0, i11);
        this.f1797l = 0;
    }
}
