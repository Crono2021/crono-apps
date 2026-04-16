package e4;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import d4.t;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import w4.n;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g implements a {

    /* renamed from: r, reason: collision with root package name */
    public static final Bitmap.Config f3102r = Bitmap.Config.ARGB_8888;

    /* renamed from: i, reason: collision with root package name */
    public final k f3103i;

    /* renamed from: j, reason: collision with root package name */
    public final Set f3104j;

    /* renamed from: k, reason: collision with root package name */
    public final t f3105k;

    /* renamed from: l, reason: collision with root package name */
    public final long f3106l;

    /* renamed from: m, reason: collision with root package name */
    public long f3107m;

    /* renamed from: n, reason: collision with root package name */
    public int f3108n;

    /* renamed from: o, reason: collision with root package name */
    public int f3109o;

    /* renamed from: p, reason: collision with root package name */
    public int f3110p;

    /* renamed from: q, reason: collision with root package name */
    public int f3111q;

    public g(long j5) {
        Bitmap.Config config;
        k kVar = new k();
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        hashSet.add(null);
        if (Build.VERSION.SDK_INT >= 26) {
            config = Bitmap.Config.HARDWARE;
            hashSet.remove(config);
        }
        Set unmodifiableSet = Collections.unmodifiableSet(hashSet);
        this.f3106l = j5;
        this.f3103i = kVar;
        this.f3104j = unmodifiableSet;
        this.f3105k = new t(4);
    }

    public final void a() {
        Log.v("LruBitmapPool", "Hits=" + this.f3108n + ", misses=" + this.f3109o + ", puts=" + this.f3110p + ", evictions=" + this.f3111q + ", currentSize=" + this.f3107m + ", maxSize=" + this.f3106l + "\nStrategy=" + this.f3103i);
    }

    public final synchronized Bitmap b(int i9, int i10, Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap b9;
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                config2 = Bitmap.Config.HARDWARE;
                if (config == config2) {
                    throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
                }
            }
            b9 = this.f3103i.b(i9, i10, config != null ? config : f3102r);
            if (b9 == null) {
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    this.f3103i.getClass();
                    Log.d("LruBitmapPool", "Missing bitmap=".concat(k.c(n.d(config) * i9 * i10, config)));
                }
                this.f3109o++;
            } else {
                this.f3108n++;
                long j5 = this.f3107m;
                this.f3103i.getClass();
                this.f3107m = j5 - n.c(b9);
                this.f3105k.getClass();
                b9.setHasAlpha(true);
                b9.setPremultiplied(true);
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                this.f3103i.getClass();
                Log.v("LruBitmapPool", "Get bitmap=".concat(k.c(n.d(config) * i9 * i10, config)));
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                a();
            }
        } catch (Throwable th) {
            throw th;
        }
        return b9;
    }

    public final synchronized void c(long j5) {
        while (this.f3107m > j5) {
            try {
                k kVar = this.f3103i;
                Bitmap bitmap = (Bitmap) kVar.f3121b.T0();
                if (bitmap != null) {
                    kVar.a(Integer.valueOf(n.c(bitmap)), bitmap);
                }
                if (bitmap == null) {
                    if (Log.isLoggable("LruBitmapPool", 5)) {
                        Log.w("LruBitmapPool", "Size mismatch, resetting");
                        a();
                    }
                    this.f3107m = 0L;
                    return;
                }
                this.f3105k.getClass();
                long j9 = this.f3107m;
                this.f3103i.getClass();
                this.f3107m = j9 - n.c(bitmap);
                this.f3111q++;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Evicting bitmap=");
                    this.f3103i.getClass();
                    sb.append(k.c(n.c(bitmap), bitmap.getConfig()));
                    Log.d("LruBitmapPool", sb.toString());
                }
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    a();
                }
                bitmap.recycle();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // e4.a
    public final Bitmap e(int i9, int i10, Bitmap.Config config) {
        Bitmap b9 = b(i9, i10, config);
        if (b9 != null) {
            return b9;
        }
        if (config == null) {
            config = f3102r;
        }
        return Bitmap.createBitmap(i9, i10, config);
    }

    @Override // e4.a
    public final Bitmap f(int i9, int i10, Bitmap.Config config) {
        Bitmap b9 = b(i9, i10, config);
        if (b9 != null) {
            b9.eraseColor(0);
            return b9;
        }
        if (config == null) {
            config = f3102r;
        }
        return Bitmap.createBitmap(i9, i10, config);
    }

    @Override // e4.a
    public final synchronized void g(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable()) {
                this.f3103i.getClass();
                if (n.c(bitmap) <= this.f3106l && this.f3104j.contains(bitmap.getConfig())) {
                    this.f3103i.getClass();
                    int c9 = n.c(bitmap);
                    this.f3103i.e(bitmap);
                    this.f3105k.getClass();
                    this.f3110p++;
                    this.f3107m += c9;
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        this.f3103i.getClass();
                        Log.v("LruBitmapPool", "Put bitmap in pool=".concat(k.c(n.c(bitmap), bitmap.getConfig())));
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        a();
                    }
                    c(this.f3106l);
                    return;
                }
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                StringBuilder sb = new StringBuilder("Reject bitmap from pool, bitmap: ");
                this.f3103i.getClass();
                sb.append(k.c(n.c(bitmap), bitmap.getConfig()));
                sb.append(", is mutable: ");
                sb.append(bitmap.isMutable());
                sb.append(", is allowed config: ");
                sb.append(this.f3104j.contains(bitmap.getConfig()));
                Log.v("LruBitmapPool", sb.toString());
            }
            bitmap.recycle();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // e4.a
    public final void m(int i9) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i9);
        }
        if (i9 >= 40 || (Build.VERSION.SDK_INT >= 23 && i9 >= 20)) {
            q();
        } else if (i9 >= 20 || i9 == 15) {
            c(this.f3106l / 2);
        }
    }

    @Override // e4.a
    public final void q() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        c(0L);
    }
}
