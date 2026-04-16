package z1;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l extends Handler implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final int f10574i;

    /* renamed from: j, reason: collision with root package name */
    public final m f10575j;

    /* renamed from: k, reason: collision with root package name */
    public final long f10576k;

    /* renamed from: l, reason: collision with root package name */
    public k f10577l;

    /* renamed from: m, reason: collision with root package name */
    public IOException f10578m;

    /* renamed from: n, reason: collision with root package name */
    public int f10579n;

    /* renamed from: o, reason: collision with root package name */
    public Thread f10580o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f10581p;

    /* renamed from: q, reason: collision with root package name */
    public volatile boolean f10582q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ p f10583r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(p pVar, Looper looper, m mVar, k kVar, int i9, long j5) {
        super(looper);
        this.f10583r = pVar;
        this.f10575j = mVar;
        this.f10577l = kVar;
        this.f10574i = i9;
        this.f10576k = j5;
    }

    public final void a(boolean z8) {
        this.f10582q = z8;
        this.f10578m = null;
        if (hasMessages(0)) {
            this.f10581p = true;
            removeMessages(0);
            if (!z8) {
                sendEmptyMessage(1);
            }
        } else {
            synchronized (this) {
                try {
                    this.f10581p = true;
                    this.f10575j.b();
                    Thread thread = this.f10580o;
                    if (thread != null) {
                        thread.interrupt();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (z8) {
            this.f10583r.f10588b = null;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            k kVar = this.f10577l;
            kVar.getClass();
            kVar.q(this.f10575j, elapsedRealtime, elapsedRealtime - this.f10576k, true);
            this.f10577l = null;
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.f10582q) {
            return;
        }
        int i9 = message.what;
        if (i9 == 0) {
            this.f10578m = null;
            p pVar = this.f10583r;
            ExecutorService executorService = pVar.f10587a;
            l lVar = pVar.f10588b;
            lVar.getClass();
            executorService.execute(lVar);
            return;
        }
        if (i9 == 3) {
            throw ((Error) message.obj);
        }
        this.f10583r.f10588b = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j5 = elapsedRealtime - this.f10576k;
        k kVar = this.f10577l;
        kVar.getClass();
        if (this.f10581p) {
            kVar.q(this.f10575j, elapsedRealtime, j5, false);
            return;
        }
        int i10 = message.what;
        if (i10 == 1) {
            try {
                kVar.e(this.f10575j, elapsedRealtime, j5);
                return;
            } catch (RuntimeException e9) {
                g1.a.q("LoadTask", "Unexpected exception handling load completed", e9);
                this.f10583r.f10589c = new o(e9);
                return;
            }
        }
        if (i10 != 2) {
            return;
        }
        IOException iOException = (IOException) message.obj;
        this.f10578m = iOException;
        int i11 = this.f10579n + 1;
        this.f10579n = i11;
        j3.f p5 = kVar.p(this.f10575j, elapsedRealtime, j5, iOException, i11);
        int i12 = p5.f5420a;
        if (i12 == 3) {
            this.f10583r.f10589c = this.f10578m;
            return;
        }
        if (i12 != 2) {
            if (i12 == 1) {
                this.f10579n = 1;
            }
            long j9 = p5.f5421b;
            if (j9 == -9223372036854775807L) {
                j9 = Math.min((this.f10579n - 1) * IjkMediaCodecInfo.RANK_MAX, 5000);
            }
            p pVar2 = this.f10583r;
            g1.a.k(pVar2.f10588b == null);
            pVar2.f10588b = this;
            if (j9 > 0) {
                sendEmptyMessageDelayed(0, j9);
            } else {
                this.f10578m = null;
                pVar2.f10587a.execute(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z8;
        try {
            synchronized (this) {
                z8 = this.f10581p;
                this.f10580o = Thread.currentThread();
            }
            if (!z8) {
                g1.a.b("load:".concat(this.f10575j.getClass().getSimpleName()));
                try {
                    this.f10575j.a();
                    g1.a.r();
                } catch (Throwable th) {
                    g1.a.r();
                    throw th;
                }
            }
            synchronized (this) {
                this.f10580o = null;
                Thread.interrupted();
            }
            if (this.f10582q) {
                return;
            }
            sendEmptyMessage(1);
        } catch (IOException e9) {
            if (this.f10582q) {
                return;
            }
            obtainMessage(2, e9).sendToTarget();
        } catch (Exception e10) {
            if (this.f10582q) {
                return;
            }
            g1.a.q("LoadTask", "Unexpected exception loading stream", e10);
            obtainMessage(2, new o(e10)).sendToTarget();
        } catch (OutOfMemoryError e11) {
            if (this.f10582q) {
                return;
            }
            g1.a.q("LoadTask", "OutOfMemory error loading stream", e11);
            obtainMessage(2, new o(e11)).sendToTarget();
        } catch (Error e12) {
            if (!this.f10582q) {
                g1.a.q("LoadTask", "Unexpected error loading stream", e12);
                obtainMessage(3, e12).sendToTarget();
            }
            throw e12;
        }
    }
}
