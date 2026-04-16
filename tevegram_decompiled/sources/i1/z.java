package i1;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class z extends c {

    /* renamed from: m, reason: collision with root package name */
    public final Context f4367m;

    /* renamed from: n, reason: collision with root package name */
    public k f4368n;

    /* renamed from: o, reason: collision with root package name */
    public AssetFileDescriptor f4369o;

    /* renamed from: p, reason: collision with root package name */
    public FileInputStream f4370p;

    /* renamed from: q, reason: collision with root package name */
    public long f4371q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f4372r;

    public z(Context context) {
        super(false);
        this.f4367m = context.getApplicationContext();
    }

    @Deprecated
    public static Uri buildRawResourceUri(int i9) {
        return Uri.parse("rawresource:///" + i9);
    }

    @Override // i1.h
    public final void close() {
        this.f4368n = null;
        try {
            try {
                FileInputStream fileInputStream = this.f4370p;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.f4370p = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f4369o;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e9) {
                        throw new y(null, e9, 2000);
                    }
                } finally {
                    this.f4369o = null;
                    if (this.f4372r) {
                        this.f4372r = false;
                        l();
                    }
                }
            } catch (IOException e10) {
                throw new y(null, e10, 2000);
            }
        } catch (Throwable th) {
            this.f4370p = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.f4369o;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.f4369o = null;
                    if (this.f4372r) {
                        this.f4372r = false;
                        l();
                    }
                    throw th;
                } catch (IOException e11) {
                    throw new y(null, e11, 2000);
                }
            } finally {
                this.f4369o = null;
                if (this.f4372r) {
                    this.f4372r = false;
                    l();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x004a, code lost:
    
        if (r7.matches("\\d+") != false) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0196  */
    @Override // i1.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long f(i1.k r20) {
        /*
            Method dump skipped, instructions count: 443
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i1.z.f(i1.k):long");
    }

    @Override // i1.h
    public final Uri m() {
        k kVar = this.f4368n;
        if (kVar != null) {
            return kVar.f4324a;
        }
        return null;
    }

    @Override // d1.k
    public final int read(byte[] bArr, int i9, int i10) {
        if (i10 == 0) {
            return 0;
        }
        long j5 = this.f4371q;
        if (j5 != 0) {
            if (j5 != -1) {
                try {
                    i10 = (int) Math.min(j5, i10);
                } catch (IOException e9) {
                    throw new y(null, e9, 2000);
                }
            }
            FileInputStream fileInputStream = this.f4370p;
            int i11 = g1.w.f3713a;
            int read = fileInputStream.read(bArr, i9, i10);
            long j9 = this.f4371q;
            if (read != -1) {
                if (j9 != -1) {
                    this.f4371q = j9 - read;
                }
                c(read);
                return read;
            }
            if (j9 != -1) {
                throw new y("End of stream reached having not read sufficient data.", new EOFException(), 2000);
            }
        }
        return -1;
    }
}
