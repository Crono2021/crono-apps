package i8;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class x extends j0 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: r, reason: collision with root package name */
    public static final x f5324r;

    /* renamed from: s, reason: collision with root package name */
    public static final long f5325s;

    static {
        Long l4;
        x xVar = new x();
        f5324r = xVar;
        xVar.k(false);
        try {
            l4 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l4 = 1000L;
        }
        f5325s = TimeUnit.MILLISECONDS.toNanos(l4.longValue());
    }

    @Override // i8.j0
    public final void n(Runnable runnable) {
        if (debugStatus == 4) {
            throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
        }
        super.n(runnable);
    }

    @Override // i8.j0
    public final Thread p() {
        Thread thread;
        Thread thread2 = _thread;
        if (thread2 != null) {
            return thread2;
        }
        synchronized (this) {
            thread = _thread;
            if (thread == null) {
                thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
                _thread = thread;
                thread.setDaemon(true);
                thread.start();
            }
        }
        return thread;
    }

    @Override // i8.j0
    public final void r(long j5, h0 h0Var) {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean q4;
        f1.f5266a.set(this);
        try {
            synchronized (this) {
                int i9 = debugStatus;
                if (i9 == 2 || i9 == 3) {
                    if (q4) {
                        return;
                    } else {
                        return;
                    }
                }
                debugStatus = 1;
                notifyAll();
                long j5 = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long l4 = l();
                    if (l4 == Long.MAX_VALUE) {
                        long nanoTime = System.nanoTime();
                        if (j5 == Long.MAX_VALUE) {
                            j5 = f5325s + nanoTime;
                        }
                        long j9 = j5 - nanoTime;
                        if (j9 <= 0) {
                            _thread = null;
                            t();
                            if (q()) {
                                return;
                            }
                            p();
                            return;
                        }
                        if (l4 > j9) {
                            l4 = j9;
                        }
                    } else {
                        j5 = Long.MAX_VALUE;
                    }
                    if (l4 > 0) {
                        int i10 = debugStatus;
                        if (i10 == 2 || i10 == 3) {
                            _thread = null;
                            t();
                            if (q()) {
                                return;
                            }
                            p();
                            return;
                        }
                        LockSupport.parkNanos(this, l4);
                    }
                }
            }
        } finally {
            _thread = null;
            t();
            if (!q()) {
                p();
            }
        }
    }

    @Override // i8.j0, i8.f0
    public final void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    public final synchronized void t() {
        int i9 = debugStatus;
        if (i9 == 2 || i9 == 3) {
            debugStatus = 3;
            j0.f5278o.set(this, null);
            j0.f5279p.set(this, null);
            notifyAll();
        }
    }
}
