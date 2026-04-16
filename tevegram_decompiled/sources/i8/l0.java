package i8;

import java.lang.reflect.Method;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l0 extends k0 implements z {

    /* renamed from: k, reason: collision with root package name */
    public final ExecutorService f5287k;

    public l0(ExecutorService executorService) {
        Method method;
        this.f5287k = executorService;
        Method method2 = n8.c.f7499a;
        try {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = executorService instanceof ScheduledThreadPoolExecutor ? (ScheduledThreadPoolExecutor) executorService : null;
            if (scheduledThreadPoolExecutor != null && (method = n8.c.f7499a) != null) {
                method.invoke(scheduledThreadPoolExecutor, Boolean.TRUE);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // i8.z
    public final void b(long j5, f fVar) {
        ExecutorService executorService = this.f5287k;
        ScheduledFuture<?> scheduledFuture = null;
        ScheduledExecutorService scheduledExecutorService = executorService instanceof ScheduledExecutorService ? (ScheduledExecutorService) executorService : null;
        if (scheduledExecutorService != null) {
            androidx.fragment.app.d dVar = new androidx.fragment.app.d(this, 7, fVar);
            r7.g gVar = fVar.f5261m;
            try {
                scheduledFuture = scheduledExecutorService.schedule(dVar, j5, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e9) {
                CancellationException cancellationException = new CancellationException("The task was rejected");
                cancellationException.initCause(e9);
                w.b(gVar, cancellationException);
            }
        }
        if (scheduledFuture != null) {
            fVar.u(new e(scheduledFuture, 0));
        } else {
            x.f5324r.b(j5, fVar);
        }
    }

    @Override // i8.s
    public final void c(r7.g gVar, Runnable runnable) {
        try {
            this.f5287k.execute(runnable);
        } catch (RejectedExecutionException e9) {
            CancellationException cancellationException = new CancellationException("The task was rejected");
            cancellationException.initCause(e9);
            w.b(gVar, cancellationException);
            c0.f5251b.c(gVar, runnable);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ExecutorService executorService = this.f5287k;
        if (!t.a.d(executorService)) {
            executorService = null;
        }
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof l0) && ((l0) obj).f5287k == this.f5287k;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f5287k);
    }

    @Override // i8.s
    public final String toString() {
        return this.f5287k.toString();
    }
}
