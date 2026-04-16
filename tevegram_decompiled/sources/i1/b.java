package i1;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b extends c {

    /* renamed from: m, reason: collision with root package name */
    public final AssetManager f4290m;

    /* renamed from: n, reason: collision with root package name */
    public Uri f4291n;

    /* renamed from: o, reason: collision with root package name */
    public InputStream f4292o;

    /* renamed from: p, reason: collision with root package name */
    public long f4293p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f4294q;

    public b(Context context) {
        super(false);
        this.f4290m = context.getAssets();
    }

    @Override // i1.h
    public final void close() {
        this.f4291n = null;
        try {
            try {
                InputStream inputStream = this.f4292o;
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e9) {
                throw new a(e9, 2000);
            }
        } finally {
            this.f4292o = null;
            if (this.f4294q) {
                this.f4294q = false;
                l();
            }
        }
    }

    @Override // i1.h
    public final long f(k kVar) {
        try {
            Uri uri = kVar.f4324a;
            long j5 = kVar.f4328e;
            this.f4291n = uri;
            String path = uri.getPath();
            path.getClass();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            q();
            InputStream open = this.f4290m.open(path, 1);
            this.f4292o = open;
            if (open.skip(j5) < j5) {
                throw new a(null, 2008);
            }
            long j9 = kVar.f4329f;
            if (j9 != -1) {
                this.f4293p = j9;
            } else {
                long available = this.f4292o.available();
                this.f4293p = available;
                if (available == 2147483647L) {
                    this.f4293p = -1L;
                }
            }
            this.f4294q = true;
            r(kVar);
            return this.f4293p;
        } catch (a e9) {
            throw e9;
        } catch (IOException e10) {
            throw new a(e10, e10 instanceof FileNotFoundException ? 2005 : 2000);
        }
    }

    @Override // i1.h
    public final Uri m() {
        return this.f4291n;
    }

    @Override // d1.k
    public final int read(byte[] bArr, int i9, int i10) {
        if (i10 == 0) {
            return 0;
        }
        long j5 = this.f4293p;
        if (j5 != 0) {
            if (j5 != -1) {
                try {
                    i10 = (int) Math.min(j5, i10);
                } catch (IOException e9) {
                    throw new a(e9, 2000);
                }
            }
            InputStream inputStream = this.f4292o;
            int i11 = g1.w.f3713a;
            int read = inputStream.read(bArr, i9, i10);
            if (read != -1) {
                long j9 = this.f4293p;
                if (j9 != -1) {
                    this.f4293p = j9 - read;
                }
                c(read);
                return read;
            }
        }
        return -1;
    }
}
