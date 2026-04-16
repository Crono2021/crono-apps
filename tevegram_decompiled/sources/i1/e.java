package i1;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e extends c {

    /* renamed from: m, reason: collision with root package name */
    public final ContentResolver f4308m;

    /* renamed from: n, reason: collision with root package name */
    public Uri f4309n;

    /* renamed from: o, reason: collision with root package name */
    public AssetFileDescriptor f4310o;

    /* renamed from: p, reason: collision with root package name */
    public FileInputStream f4311p;

    /* renamed from: q, reason: collision with root package name */
    public long f4312q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f4313r;

    public e(Context context) {
        super(false);
        this.f4308m = context.getContentResolver();
    }

    @Override // i1.h
    public final void close() {
        this.f4309n = null;
        try {
            try {
                FileInputStream fileInputStream = this.f4311p;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.f4311p = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f4310o;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e9) {
                        throw new d(e9, 2000);
                    }
                } finally {
                    this.f4310o = null;
                    if (this.f4313r) {
                        this.f4313r = false;
                        l();
                    }
                }
            } catch (IOException e10) {
                throw new d(e10, 2000);
            }
        } catch (Throwable th) {
            this.f4311p = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.f4310o;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.f4310o = null;
                    if (this.f4313r) {
                        this.f4313r = false;
                        l();
                    }
                    throw th;
                } catch (IOException e11) {
                    throw new d(e11, 2000);
                }
            } finally {
                this.f4310o = null;
                if (this.f4313r) {
                    this.f4313r = false;
                    l();
                }
            }
        }
    }

    @Override // i1.h
    public final long f(k kVar) {
        AssetFileDescriptor openAssetFileDescriptor;
        try {
            Uri uri = kVar.f4324a;
            long j5 = kVar.f4329f;
            long j9 = kVar.f4328e;
            Uri normalizeScheme = uri.normalizeScheme();
            this.f4309n = normalizeScheme;
            q();
            boolean equals = "content".equals(normalizeScheme.getScheme());
            ContentResolver contentResolver = this.f4308m;
            if (equals) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT", true);
                openAssetFileDescriptor = contentResolver.openTypedAssetFileDescriptor(normalizeScheme, "*/*", bundle);
            } else {
                openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(normalizeScheme, "r");
            }
            this.f4310o = openAssetFileDescriptor;
            if (openAssetFileDescriptor == null) {
                throw new d(new IOException("Could not open file descriptor for: " + normalizeScheme), 2000);
            }
            long length = openAssetFileDescriptor.getLength();
            FileInputStream fileInputStream = new FileInputStream(openAssetFileDescriptor.getFileDescriptor());
            this.f4311p = fileInputStream;
            if (length != -1 && j9 > length) {
                throw new d(null, 2008);
            }
            long startOffset = openAssetFileDescriptor.getStartOffset();
            long skip = fileInputStream.skip(startOffset + j9) - startOffset;
            if (skip != j9) {
                throw new d(null, 2008);
            }
            if (length == -1) {
                FileChannel channel = fileInputStream.getChannel();
                long size = channel.size();
                if (size == 0) {
                    this.f4312q = -1L;
                } else {
                    long position = size - channel.position();
                    this.f4312q = position;
                    if (position < 0) {
                        throw new d(null, 2008);
                    }
                }
            } else {
                long j10 = length - skip;
                this.f4312q = j10;
                if (j10 < 0) {
                    throw new d(null, 2008);
                }
            }
            if (j5 != -1) {
                long j11 = this.f4312q;
                this.f4312q = j11 == -1 ? j5 : Math.min(j11, j5);
            }
            this.f4313r = true;
            r(kVar);
            return j5 != -1 ? j5 : this.f4312q;
        } catch (d e9) {
            throw e9;
        } catch (IOException e10) {
            throw new d(e10, e10 instanceof FileNotFoundException ? 2005 : 2000);
        }
    }

    @Override // i1.h
    public final Uri m() {
        return this.f4309n;
    }

    @Override // d1.k
    public final int read(byte[] bArr, int i9, int i10) {
        if (i10 == 0) {
            return 0;
        }
        long j5 = this.f4312q;
        if (j5 != 0) {
            if (j5 != -1) {
                try {
                    i10 = (int) Math.min(j5, i10);
                } catch (IOException e9) {
                    throw new d(e9, 2000);
                }
            }
            FileInputStream fileInputStream = this.f4311p;
            int i11 = g1.w.f3713a;
            int read = fileInputStream.read(bArr, i9, i10);
            if (read != -1) {
                long j9 = this.f4312q;
                if (j9 != -1) {
                    this.f4312q = j9 - read;
                }
                c(read);
                return read;
            }
        }
        return -1;
    }
}
