package f4;

import android.util.Log;
import b4.i;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d implements a {

    /* renamed from: j, reason: collision with root package name */
    public final File f3376j;

    /* renamed from: m, reason: collision with root package name */
    public z3.d f3379m;

    /* renamed from: l, reason: collision with root package name */
    public final a5.d f3378l = new a5.d(12);

    /* renamed from: k, reason: collision with root package name */
    public final long f3377k = 262144000;

    /* renamed from: i, reason: collision with root package name */
    public final a5.d f3375i = new a5.d(13);

    public d(File file) {
        this.f3376j = file;
    }

    public final synchronized z3.d a() {
        try {
            if (this.f3379m == null) {
                this.f3379m = z3.d.h(this.f3376j, this.f3377k);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f3379m;
    }

    @Override // f4.a
    public final void o(b4.f fVar, androidx.fragment.app.g gVar) {
        b bVar;
        boolean z8;
        String J0 = this.f3375i.J0(fVar);
        a5.d dVar = this.f3378l;
        synchronized (dVar) {
            try {
                bVar = (b) ((HashMap) dVar.f174j).get(J0);
                if (bVar == null) {
                    bVar = ((c) dVar.f175k).a();
                    ((HashMap) dVar.f174j).put(J0, bVar);
                }
                bVar.f3373b++;
            } catch (Throwable th) {
                throw th;
            }
        }
        bVar.f3372a.lock();
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + J0 + " for for Key: " + fVar);
            }
            try {
                z3.d a9 = a();
                if (a9.f(J0) == null) {
                    b2.b d9 = a9.d(J0);
                    if (d9 == null) {
                        throw new IllegalStateException("Had two simultaneous puts for: ".concat(J0));
                    }
                    try {
                        if (((b4.b) gVar.f728j).s(gVar.f729k, d9.f(), (i) gVar.f730l)) {
                            z3.d.a((z3.d) d9.f1140d, d9, true);
                            d9.f1137a = true;
                        }
                        if (!z8) {
                            try {
                                d9.c();
                            } catch (IOException unused) {
                            }
                        }
                    } finally {
                        if (!d9.f1137a) {
                            try {
                                d9.c();
                            } catch (IOException unused2) {
                            }
                        }
                    }
                }
            } catch (IOException e9) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e9);
                }
            }
        } finally {
            this.f3378l.S0(J0);
        }
    }

    @Override // f4.a
    public final File r(b4.f fVar) {
        String J0 = this.f3375i.J0(fVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + J0 + " for for Key: " + fVar);
        }
        try {
            z1.c f9 = a().f(J0);
            if (f9 != null) {
                return ((File[]) f9.f10541a)[0];
            }
            return null;
        } catch (IOException e9) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e9);
            return null;
        }
    }
}
