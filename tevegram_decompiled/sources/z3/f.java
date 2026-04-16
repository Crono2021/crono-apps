package z3;

import java.io.Closeable;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f implements Closeable {

    /* renamed from: i, reason: collision with root package name */
    public final FileInputStream f10653i;

    /* renamed from: j, reason: collision with root package name */
    public final Charset f10654j;

    /* renamed from: k, reason: collision with root package name */
    public byte[] f10655k;

    /* renamed from: l, reason: collision with root package name */
    public int f10656l;

    /* renamed from: m, reason: collision with root package name */
    public int f10657m;

    public f(FileInputStream fileInputStream, Charset charset) {
        if (charset == null) {
            throw null;
        }
        if (!charset.equals(g.f10658a)) {
            m7.c.n("Unsupported encoding");
            throw null;
        }
        this.f10653i = fileInputStream;
        this.f10654j = charset;
        this.f10655k = new byte[8192];
    }

    public final String a() {
        int i9;
        synchronized (this.f10653i) {
            try {
                byte[] bArr = this.f10655k;
                if (bArr == null) {
                    throw new IOException("LineReader is closed");
                }
                if (this.f10656l >= this.f10657m) {
                    int read = this.f10653i.read(bArr, 0, bArr.length);
                    if (read == -1) {
                        throw new EOFException();
                    }
                    this.f10656l = 0;
                    this.f10657m = read;
                }
                for (int i10 = this.f10656l; i10 != this.f10657m; i10++) {
                    byte[] bArr2 = this.f10655k;
                    if (bArr2[i10] == 10) {
                        int i11 = this.f10656l;
                        if (i10 != i11) {
                            i9 = i10 - 1;
                            if (bArr2[i9] == 13) {
                                String str = new String(bArr2, i11, i9 - i11, this.f10654j.name());
                                this.f10656l = i10 + 1;
                                return str;
                            }
                        }
                        i9 = i10;
                        String str2 = new String(bArr2, i11, i9 - i11, this.f10654j.name());
                        this.f10656l = i10 + 1;
                        return str2;
                    }
                }
                e eVar = new e(this, (this.f10657m - this.f10656l) + 80);
                while (true) {
                    byte[] bArr3 = this.f10655k;
                    int i12 = this.f10656l;
                    eVar.write(bArr3, i12, this.f10657m - i12);
                    this.f10657m = -1;
                    FileInputStream fileInputStream = this.f10653i;
                    byte[] bArr4 = this.f10655k;
                    int read2 = fileInputStream.read(bArr4, 0, bArr4.length);
                    if (read2 == -1) {
                        throw new EOFException();
                    }
                    this.f10656l = 0;
                    this.f10657m = read2;
                    for (int i13 = 0; i13 != this.f10657m; i13++) {
                        byte[] bArr5 = this.f10655k;
                        if (bArr5[i13] == 10) {
                            int i14 = this.f10656l;
                            if (i13 != i14) {
                                eVar.write(bArr5, i14, i13 - i14);
                            }
                            this.f10656l = i13 + 1;
                            return eVar.toString();
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.f10653i) {
            try {
                if (this.f10655k != null) {
                    this.f10655k = null;
                    this.f10653i.close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
