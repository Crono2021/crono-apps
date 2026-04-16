package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class s implements k {

    /* renamed from: i, reason: collision with root package name */
    public final Context f650i;

    /* renamed from: j, reason: collision with root package name */
    public final c7.a f651j;

    /* renamed from: k, reason: collision with root package name */
    public final u5.e f652k;

    /* renamed from: l, reason: collision with root package name */
    public final Object f653l = new Object();

    /* renamed from: m, reason: collision with root package name */
    public Handler f654m;

    /* renamed from: n, reason: collision with root package name */
    public ThreadPoolExecutor f655n;

    /* renamed from: o, reason: collision with root package name */
    public ThreadPoolExecutor f656o;

    /* renamed from: p, reason: collision with root package name */
    public com.bumptech.glide.c f657p;

    public s(Context context, c7.a aVar) {
        android.support.v4.media.session.b.r(context, "Context cannot be null");
        this.f650i = context.getApplicationContext();
        this.f651j = aVar;
        this.f652k = t.f658d;
    }

    @Override // androidx.emoji2.text.k
    public final void a(com.bumptech.glide.c cVar) {
        synchronized (this.f653l) {
            this.f657p = cVar;
        }
        c();
    }

    public final void b() {
        synchronized (this.f653l) {
            try {
                this.f657p = null;
                Handler handler = this.f654m;
                if (handler != null) {
                    handler.removeCallbacks(null);
                }
                this.f654m = null;
                ThreadPoolExecutor threadPoolExecutor = this.f656o;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.f655n = null;
                this.f656o = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c() {
        synchronized (this.f653l) {
            try {
                if (this.f657p == null) {
                    return;
                }
                if (this.f655n == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new a("emojiCompat", 0));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    this.f656o = threadPoolExecutor;
                    this.f655n = threadPoolExecutor;
                }
                this.f655n.execute(new a7.a(this, 4));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final k0.g d() {
        try {
            u5.e eVar = this.f652k;
            Context context = this.f650i;
            c7.a aVar = this.f651j;
            eVar.getClass();
            d4.i a9 = k0.b.a(context, aVar);
            int i9 = a9.f2851i;
            if (i9 != 0) {
                throw new RuntimeException("fetchFonts failed (" + i9 + ")");
            }
            k0.g[] gVarArr = (k0.g[]) a9.f2852j;
            if (gVarArr != null && gVarArr.length != 0) {
                return gVarArr[0];
            }
            m7.c.i("fetchFonts failed (empty result)");
            return null;
        } catch (PackageManager.NameNotFoundException e9) {
            m7.c.k("provider not found", e9);
            return null;
        }
    }
}
