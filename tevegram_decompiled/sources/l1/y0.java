package l1;

import android.os.Looper;
import android.os.SystemClock;
import java.util.concurrent.TimeoutException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class y0 {

    /* renamed from: a, reason: collision with root package name */
    public final x0 f6066a;

    /* renamed from: b, reason: collision with root package name */
    public final h0 f6067b;

    /* renamed from: c, reason: collision with root package name */
    public final g1.r f6068c;

    /* renamed from: d, reason: collision with root package name */
    public int f6069d;

    /* renamed from: e, reason: collision with root package name */
    public Object f6070e;

    /* renamed from: f, reason: collision with root package name */
    public final Looper f6071f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f6072g;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f6073i;

    public y0(h0 h0Var, x0 x0Var, d1.y0 y0Var, int i9, g1.r rVar, Looper looper) {
        this.f6067b = h0Var;
        this.f6066a = x0Var;
        this.f6071f = looper;
        this.f6068c = rVar;
    }

    public final synchronized void a(long j5) {
        boolean z8;
        g1.a.k(this.f6072g);
        g1.a.k(this.f6071f.getThread() != Thread.currentThread());
        this.f6068c.getClass();
        long elapsedRealtime = SystemClock.elapsedRealtime() + j5;
        while (true) {
            z8 = this.f6073i;
            if (z8 || j5 <= 0) {
                break;
            }
            this.f6068c.getClass();
            wait(j5);
            this.f6068c.getClass();
            j5 = elapsedRealtime - SystemClock.elapsedRealtime();
        }
        if (!z8) {
            throw new TimeoutException("Message delivery timed out.");
        }
    }

    public final synchronized void b(boolean z8) {
        this.h = z8 | this.h;
        this.f6073i = true;
        notifyAll();
    }

    public final void c() {
        g1.a.k(!this.f6072g);
        this.f6072g = true;
        h0 h0Var = this.f6067b;
        synchronized (h0Var) {
            if (!h0Var.G && h0Var.f5902r.getThread().isAlive()) {
                h0Var.f5900p.a(14, this).b();
                return;
            }
            g1.a.D("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            b(false);
        }
    }
}
