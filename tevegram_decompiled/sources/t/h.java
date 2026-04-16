package t;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class h implements Future {

    /* renamed from: l, reason: collision with root package name */
    public static final boolean f8908l = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: m, reason: collision with root package name */
    public static final Logger f8909m = Logger.getLogger(h.class.getName());

    /* renamed from: n, reason: collision with root package name */
    public static final com.bumptech.glide.d f8910n;

    /* renamed from: o, reason: collision with root package name */
    public static final Object f8911o;

    /* renamed from: i, reason: collision with root package name */
    public volatile Object f8912i;

    /* renamed from: j, reason: collision with root package name */
    public volatile d f8913j;

    /* renamed from: k, reason: collision with root package name */
    public volatile g f8914k;

    static {
        com.bumptech.glide.d fVar;
        try {
            fVar = new e(AtomicReferenceFieldUpdater.newUpdater(g.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(g.class, g.class, "b"), AtomicReferenceFieldUpdater.newUpdater(h.class, g.class, "k"), AtomicReferenceFieldUpdater.newUpdater(h.class, d.class, "j"), AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "i"));
            th = null;
        } catch (Throwable th) {
            th = th;
            fVar = new f();
        }
        f8910n = fVar;
        if (th != null) {
            f8909m.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f8911o = new Object();
    }

    public static void b(h hVar) {
        g gVar;
        d dVar;
        do {
            gVar = hVar.f8914k;
        } while (!f8910n.f(hVar, gVar, g.f8905c));
        while (gVar != null) {
            Thread thread = gVar.f8906a;
            if (thread != null) {
                gVar.f8906a = null;
                LockSupport.unpark(thread);
            }
            gVar = gVar.f8907b;
        }
        do {
            dVar = hVar.f8913j;
        } while (!f8910n.d(hVar, dVar, d.f8898c));
        d dVar2 = null;
        while (dVar != null) {
            d dVar3 = dVar.f8900b;
            dVar.f8900b = dVar2;
            dVar2 = dVar;
            dVar = dVar3;
        }
        while (dVar2 != null) {
            d dVar4 = dVar2.f8900b;
            Runnable runnable = dVar2.f8899a;
            try {
                throw null;
            } catch (RuntimeException e9) {
                f8909m.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor null", (Throwable) e9);
                dVar2 = dVar4;
            }
        }
    }

    public static Object c(Object obj) {
        if (obj instanceof b) {
            Throwable th = ((b) obj).f8897a;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof c) {
            throw new ExecutionException((Throwable) null);
        }
        if (obj == f8911o) {
            return null;
        }
        return obj;
    }

    public static Object d(h hVar) {
        Object obj;
        boolean z8 = false;
        while (true) {
            try {
                obj = hVar.get();
                break;
            } catch (InterruptedException unused) {
                z8 = true;
            } catch (Throwable th) {
                if (z8) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z8) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    public final void a(StringBuilder sb) {
        try {
            Object d9 = d(this);
            sb.append("SUCCESS, result=[");
            sb.append(d9 == this ? "this future" : String.valueOf(d9));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e9) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e9.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e10) {
            sb.append("FAILURE, cause=[");
            sb.append(e10.getCause());
            sb.append("]");
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z8) {
        Object obj = this.f8912i;
        if (obj != null) {
            return false;
        }
        if (!f8910n.e(this, obj, f8908l ? new b(new CancellationException("Future.cancel() was called."), z8) : z8 ? b.f8895b : b.f8896c)) {
            return false;
        }
        b(this);
        return true;
    }

    public final void e(g gVar) {
        gVar.f8906a = null;
        while (true) {
            g gVar2 = this.f8914k;
            if (gVar2 == g.f8905c) {
                return;
            }
            g gVar3 = null;
            while (gVar2 != null) {
                g gVar4 = gVar2.f8907b;
                if (gVar2.f8906a != null) {
                    gVar3 = gVar2;
                } else if (gVar3 != null) {
                    gVar3.f8907b = gVar4;
                    if (gVar3.f8906a == null) {
                        break;
                    }
                } else if (!f8910n.f(this, gVar2, gVar4)) {
                    break;
                }
                gVar2 = gVar4;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j5, TimeUnit timeUnit) {
        g gVar = g.f8905c;
        long nanos = timeUnit.toNanos(j5);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f8912i;
        if (obj != null) {
            return c(obj);
        }
        long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            g gVar2 = this.f8914k;
            if (gVar2 != gVar) {
                g gVar3 = new g();
                do {
                    com.bumptech.glide.d dVar = f8910n;
                    dVar.R(gVar3, gVar2);
                    if (dVar.f(this, gVar2, gVar3)) {
                        while (true) {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                e(gVar3);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f8912i;
                            if (obj2 != null) {
                                return c(obj2);
                            }
                            long nanoTime2 = nanoTime - System.nanoTime();
                            if (nanoTime2 < 1000) {
                                e(gVar3);
                                nanos = nanoTime2;
                                break;
                            }
                            nanos = nanoTime2;
                        }
                    } else {
                        gVar2 = this.f8914k;
                    }
                } while (gVar2 != gVar);
            }
            return c(this.f8912i);
        }
        while (nanos > 0) {
            Object obj3 = this.f8912i;
            if (obj3 != null) {
                return c(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = nanoTime - System.nanoTime();
        }
        String hVar = toString();
        String obj4 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = obj4.toLowerCase(locale);
        StringBuilder c9 = a.c("Waited ", j5, " ");
        c9.append(timeUnit.toString().toLowerCase(locale));
        String sb = c9.toString();
        if (nanos + 1000 < 0) {
            String concat = sb.concat(" (plus ");
            long j9 = -nanos;
            long convert = timeUnit.convert(j9, TimeUnit.NANOSECONDS);
            long nanos2 = j9 - timeUnit.toNanos(convert);
            boolean z8 = convert == 0 || nanos2 > 1000;
            if (convert > 0) {
                String str = concat + convert + " " + lowerCase;
                if (z8) {
                    str = str.concat(",");
                }
                concat = str.concat(" ");
            }
            if (z8) {
                concat = concat + nanos2 + " nanoseconds ";
            }
            sb = concat.concat("delay)");
        }
        if (isDone()) {
            throw new TimeoutException(sb.concat(" but future completed as timeout expired"));
        }
        throw new TimeoutException(sb + " for " + hVar);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f8912i instanceof b;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f8912i != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.f8912i instanceof b) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                if (this instanceof ScheduledFuture) {
                    str = "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
                } else {
                    str = null;
                }
            } catch (RuntimeException e9) {
                str = "Exception thrown from implementation: " + e9.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append("]");
            } else if (isDone()) {
                a(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        Object obj;
        g gVar = g.f8905c;
        if (!Thread.interrupted()) {
            Object obj2 = this.f8912i;
            if (obj2 != null) {
                return c(obj2);
            }
            g gVar2 = this.f8914k;
            if (gVar2 != gVar) {
                g gVar3 = new g();
                do {
                    com.bumptech.glide.d dVar = f8910n;
                    dVar.R(gVar3, gVar2);
                    if (dVar.f(this, gVar2, gVar3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f8912i;
                            } else {
                                e(gVar3);
                                throw new InterruptedException();
                            }
                        } while (obj == null);
                        return c(obj);
                    }
                    gVar2 = this.f8914k;
                } while (gVar2 != gVar);
            }
            return c(this.f8912i);
        }
        throw new InterruptedException();
    }
}
