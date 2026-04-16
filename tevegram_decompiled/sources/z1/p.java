package z1;

import android.os.Looper;
import android.os.SystemClock;
import g1.w;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class p {

    /* renamed from: d, reason: collision with root package name */
    public static final j3.f f10584d = new j3.f(0, -9223372036854775807L);

    /* renamed from: e, reason: collision with root package name */
    public static final j3.f f10585e = new j3.f(2, -9223372036854775807L);

    /* renamed from: f, reason: collision with root package name */
    public static final j3.f f10586f = new j3.f(3, -9223372036854775807L);

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f10587a;

    /* renamed from: b, reason: collision with root package name */
    public l f10588b;

    /* renamed from: c, reason: collision with root package name */
    public IOException f10589c;

    public p(String str) {
        String concat = "ExoPlayer:Loader:".concat(str);
        int i9 = w.f3713a;
        this.f10587a = Executors.newSingleThreadExecutor(new androidx.emoji2.text.a(concat, 1));
    }

    public final void a() {
        l lVar = this.f10588b;
        g1.a.l(lVar);
        lVar.a(false);
    }

    public final boolean b() {
        return this.f10588b != null;
    }

    public final void c(n nVar) {
        l lVar = this.f10588b;
        if (lVar != null) {
            lVar.a(true);
        }
        ExecutorService executorService = this.f10587a;
        if (nVar != null) {
            executorService.execute(new androidx.activity.j(nVar, 16));
        }
        executorService.shutdown();
    }

    public final long d(m mVar, k kVar, int i9) {
        Looper myLooper = Looper.myLooper();
        g1.a.l(myLooper);
        this.f10589c = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        l lVar = new l(this, myLooper, mVar, kVar, i9, elapsedRealtime);
        g1.a.k(this.f10588b == null);
        this.f10588b = lVar;
        lVar.f10578m = null;
        this.f10587a.execute(lVar);
        return elapsedRealtime;
    }
}
