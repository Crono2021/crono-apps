package p8;

import h7.o;
import i8.w;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import n8.r;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements Executor, Closeable {

    /* renamed from: p, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f8269p = AtomicLongFieldUpdater.newUpdater(b.class, "parkedWorkersStack");

    /* renamed from: q, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f8270q = AtomicLongFieldUpdater.newUpdater(b.class, "controlState");

    /* renamed from: r, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f8271r = AtomicIntegerFieldUpdater.newUpdater(b.class, "_isTerminated");

    /* renamed from: s, reason: collision with root package name */
    public static final a6.d f8272s = new a6.d("NOT_IN_STACK", 3);
    private volatile int _isTerminated;
    private volatile long controlState;

    /* renamed from: i, reason: collision with root package name */
    public final int f8273i;

    /* renamed from: j, reason: collision with root package name */
    public final int f8274j;

    /* renamed from: k, reason: collision with root package name */
    public final long f8275k;

    /* renamed from: l, reason: collision with root package name */
    public final String f8276l;

    /* renamed from: m, reason: collision with root package name */
    public final e f8277m;

    /* renamed from: n, reason: collision with root package name */
    public final e f8278n;

    /* renamed from: o, reason: collision with root package name */
    public final r f8279o;
    private volatile long parkedWorkersStack;

    public b(int i9, long j5, String str, int i10) {
        this.f8273i = i9;
        this.f8274j = i10;
        this.f8275k = j5;
        this.f8276l = str;
        if (i9 < 1) {
            o.d("Core pool size ", i9, " should be at least 1");
            throw null;
        }
        if (i10 < i9) {
            throw new IllegalArgumentException(("Max pool size " + i10 + " should be greater than or equals to core pool size " + i9).toString());
        }
        if (i10 > 2097150) {
            o.d("Max pool size ", i10, " should not exceed maximal supported number of threads 2097150");
            throw null;
        }
        if (j5 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j5 + " must be positive").toString());
        }
        this.f8277m = new e();
        this.f8278n = new e();
        this.f8279o = new r((i9 + 1) * 2);
        this.controlState = i9 << 42;
        this._isTerminated = 0;
    }

    public static /* synthetic */ void c(b bVar, Runnable runnable, int i9) {
        bVar.b(runnable, j.f8295g, (i9 & 4) == 0);
    }

    public final int a() {
        synchronized (this.f8279o) {
            try {
                if (f8271r.get(this) != 0) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = f8270q;
                long j5 = atomicLongFieldUpdater.get(this);
                int i9 = (int) (j5 & 2097151);
                int i10 = i9 - ((int) ((j5 & 4398044413952L) >> 21));
                if (i10 < 0) {
                    i10 = 0;
                }
                if (i10 >= this.f8273i) {
                    return 0;
                }
                if (i9 >= this.f8274j) {
                    return 0;
                }
                int i11 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i11 <= 0 || this.f8279o.b(i11) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                a aVar = new a(this, i11);
                this.f8279o.c(i11, aVar);
                if (i11 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i12 = i10 + 1;
                aVar.start();
                return i12;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(Runnable runnable, h hVar, boolean z8) {
        g iVar;
        int i9;
        j.f8294f.getClass();
        long nanoTime = System.nanoTime();
        if (runnable instanceof g) {
            iVar = (g) runnable;
            iVar.f8285i = nanoTime;
            iVar.f8286j = hVar;
        } else {
            iVar = new i(runnable, nanoTime, hVar);
        }
        boolean z9 = false;
        boolean z10 = iVar.f8286j.f8287a == 1;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f8270q;
        long addAndGet = z10 ? atomicLongFieldUpdater.addAndGet(this, 2097152L) : 0L;
        Thread currentThread = Thread.currentThread();
        a aVar = currentThread instanceof a ? (a) currentThread : null;
        if (aVar == null || !aVar.f8268p.equals(this)) {
            aVar = null;
        }
        if (aVar != null && (i9 = aVar.f8263k) != 5 && (iVar.f8286j.f8287a != 0 || i9 != 2)) {
            aVar.f8267o = true;
            l lVar = aVar.f8261i;
            if (z8) {
                iVar = lVar.a(iVar);
            } else {
                lVar.getClass();
                g gVar = (g) l.f8297b.getAndSet(lVar, iVar);
                iVar = gVar == null ? null : lVar.a(gVar);
            }
        }
        if (iVar != null) {
            if (!(iVar.f8286j.f8287a == 1 ? this.f8278n.a(iVar) : this.f8277m.a(iVar))) {
                throw new RejectedExecutionException(androidx.activity.g.o(new StringBuilder(), this.f8276l, " was terminated"));
            }
        }
        if (z8 && aVar != null) {
            z9 = true;
        }
        if (z10) {
            if (z9 || f() || e(addAndGet)) {
                return;
            }
            f();
            return;
        }
        if (z9 || f() || e(atomicLongFieldUpdater.get(this))) {
            return;
        }
        f();
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0086, code lost:
    
        if (r1 == null) goto L39;
     */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void close() {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = p8.b.f8271r
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r1 = r0 instanceof p8.a
            r3 = 0
            if (r1 == 0) goto L17
            p8.a r0 = (p8.a) r0
            goto L18
        L17:
            r0 = r3
        L18:
            if (r0 == 0) goto L23
            p8.b r1 = r0.f8268p
            boolean r1 = r1.equals(r8)
            if (r1 == 0) goto L23
            goto L24
        L23:
            r0 = r3
        L24:
            n8.r r1 = r8.f8279o
            monitor-enter(r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = p8.b.f8270q     // Catch: java.lang.Throwable -> Lc0
            long r4 = r4.get(r8)     // Catch: java.lang.Throwable -> Lc0
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r5 = (int) r4
            monitor-exit(r1)
            if (r2 > r5) goto L76
            r1 = 1
        L36:
            n8.r r4 = r8.f8279o
            java.lang.Object r4 = r4.b(r1)
            r4.getClass()
            p8.a r4 = (p8.a) r4
            if (r4 == r0) goto L71
        L43:
            boolean r6 = r4.isAlive()
            if (r6 == 0) goto L52
            java.util.concurrent.locks.LockSupport.unpark(r4)
            r6 = 10000(0x2710, double:4.9407E-320)
            r4.join(r6)
            goto L43
        L52:
            p8.l r4 = r4.f8261i
            p8.e r6 = r8.f8278n
            r4.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = p8.l.f8297b
            java.lang.Object r7 = r7.getAndSet(r4, r3)
            p8.g r7 = (p8.g) r7
            if (r7 == 0) goto L66
            r6.a(r7)
        L66:
            p8.g r7 = r4.b()
            if (r7 != 0) goto L6d
            goto L71
        L6d:
            r6.a(r7)
            goto L66
        L71:
            if (r1 == r5) goto L76
            int r1 = r1 + 1
            goto L36
        L76:
            p8.e r1 = r8.f8278n
            r1.b()
            p8.e r1 = r8.f8277m
            r1.b()
        L80:
            if (r0 == 0) goto L88
            p8.g r1 = r0.a(r2)
            if (r1 != 0) goto Laf
        L88:
            p8.e r1 = r8.f8277m
            java.lang.Object r1 = r1.d()
            p8.g r1 = (p8.g) r1
            if (r1 != 0) goto Laf
            p8.e r1 = r8.f8278n
            java.lang.Object r1 = r1.d()
            p8.g r1 = (p8.g) r1
            if (r1 != 0) goto Laf
            if (r0 == 0) goto La2
            r1 = 5
            r0.h(r1)
        La2:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = p8.b.f8269p
            r1 = 0
            r0.set(r8, r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = p8.b.f8270q
            r0.set(r8, r1)
            return
        Laf:
            r1.run()     // Catch: java.lang.Throwable -> Lb3
            goto L80
        Lb3:
            r1 = move-exception
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            java.lang.Thread$UncaughtExceptionHandler r4 = r3.getUncaughtExceptionHandler()
            r4.uncaughtException(r3, r1)
            goto L80
        Lc0:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p8.b.close():void");
    }

    public final void d(a aVar, int i9, int i10) {
        while (true) {
            long j5 = f8269p.get(this);
            int i11 = (int) (2097151 & j5);
            long j9 = (2097152 + j5) & (-2097152);
            if (i11 == i9) {
                if (i10 == 0) {
                    Object c9 = aVar.c();
                    while (true) {
                        if (c9 == f8272s) {
                            i11 = -1;
                            break;
                        }
                        if (c9 == null) {
                            i11 = 0;
                            break;
                        }
                        a aVar2 = (a) c9;
                        i11 = aVar2.b();
                        if (i11 != 0) {
                            break;
                        } else {
                            c9 = aVar2.c();
                        }
                    }
                } else {
                    i11 = i10;
                }
            }
            if (i11 >= 0) {
                if (f8269p.compareAndSet(this, j5, j9 | i11)) {
                    return;
                }
            }
        }
    }

    public final boolean e(long j5) {
        int i9 = ((int) (2097151 & j5)) - ((int) ((j5 & 4398044413952L) >> 21));
        if (i9 < 0) {
            i9 = 0;
        }
        int i10 = this.f8273i;
        if (i9 < i10) {
            int a9 = a();
            if (a9 == 1 && i10 > 1) {
                a();
            }
            if (a9 > 0) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        c(this, runnable, 6);
    }

    public final boolean f() {
        a6.d dVar;
        int i9;
        while (true) {
            long j5 = f8269p.get(this);
            a aVar = (a) this.f8279o.b((int) (2097151 & j5));
            if (aVar == null) {
                aVar = null;
            } else {
                long j9 = (2097152 + j5) & (-2097152);
                Object c9 = aVar.c();
                while (true) {
                    dVar = f8272s;
                    if (c9 == dVar) {
                        i9 = -1;
                        break;
                    }
                    if (c9 == null) {
                        i9 = 0;
                        break;
                    }
                    a aVar2 = (a) c9;
                    i9 = aVar2.b();
                    if (i9 != 0) {
                        break;
                    }
                    c9 = aVar2.c();
                }
                if (i9 >= 0) {
                    if (f8269p.compareAndSet(this, j5, i9 | j9)) {
                        aVar.g(dVar);
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            if (aVar == null) {
                return false;
            }
            if (a.f8260q.compareAndSet(aVar, -1, 0)) {
                LockSupport.unpark(aVar);
                return true;
            }
        }
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        r rVar = this.f8279o;
        int a9 = rVar.a();
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 1; i14 < a9; i14++) {
            a aVar = (a) rVar.b(i14);
            if (aVar != null) {
                l lVar = aVar.f8261i;
                lVar.getClass();
                int i15 = l.f8297b.get(lVar) != null ? (l.f8298c.get(lVar) - l.f8299d.get(lVar)) + 1 : l.f8298c.get(lVar) - l.f8299d.get(lVar);
                int a10 = v.h.a(aVar.f8263k);
                if (a10 == 0) {
                    i9++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i15);
                    sb.append('c');
                    arrayList.add(sb.toString());
                } else if (a10 == 1) {
                    i10++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i15);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (a10 == 2) {
                    i11++;
                } else if (a10 == 3) {
                    i12++;
                    if (i15 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(i15);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else if (a10 == 4) {
                    i13++;
                }
            }
        }
        long j5 = f8270q.get(this);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.f8276l);
        sb4.append('@');
        sb4.append(w.f(this));
        sb4.append("[Pool Size {core = ");
        int i16 = this.f8273i;
        sb4.append(i16);
        sb4.append(", max = ");
        sb4.append(this.f8274j);
        sb4.append("}, Worker States {CPU = ");
        sb4.append(i9);
        sb4.append(", blocking = ");
        sb4.append(i10);
        sb4.append(", parked = ");
        sb4.append(i11);
        sb4.append(", dormant = ");
        sb4.append(i12);
        sb4.append(", terminated = ");
        sb4.append(i13);
        sb4.append("}, running workers queues = ");
        sb4.append(arrayList);
        sb4.append(", global CPU queue size = ");
        sb4.append(this.f8277m.c());
        sb4.append(", global blocking queue size = ");
        sb4.append(this.f8278n.c());
        sb4.append(", Control State {created workers= ");
        sb4.append((int) (2097151 & j5));
        sb4.append(", blocking tasks = ");
        sb4.append((int) ((4398044413952L & j5) >> 21));
        sb4.append(", CPUs acquired = ");
        sb4.append(i16 - ((int) ((j5 & 9223367638808264704L) >> 42)));
        sb4.append("}]");
        return sb4.toString();
    }
}
