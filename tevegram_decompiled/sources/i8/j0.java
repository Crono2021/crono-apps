package i8;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class j0 extends f0 implements z {

    /* renamed from: o, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f5278o = AtomicReferenceFieldUpdater.newUpdater(j0.class, Object.class, "_queue");

    /* renamed from: p, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f5279p = AtomicReferenceFieldUpdater.newUpdater(j0.class, Object.class, "_delayed");

    /* renamed from: q, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f5280q = AtomicIntegerFieldUpdater.newUpdater(j0.class, "_isCompleted");
    private volatile Object _delayed;
    private volatile int _isCompleted = 0;
    private volatile Object _queue;

    @Override // i8.z
    public final void b(long j5, f fVar) {
        long j9 = j5 > 0 ? j5 >= 9223372036854L ? Long.MAX_VALUE : 1000000 * j5 : 0L;
        if (j9 < 4611686018427387903L) {
            long nanoTime = System.nanoTime();
            g0 g0Var = new g0(this, j9 + nanoTime, fVar);
            s(nanoTime, g0Var);
            fVar.u(new e(g0Var, 1));
        }
    }

    @Override // i8.s
    public final void c(r7.g gVar, Runnable runnable) {
        n(runnable);
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x00cf, code lost:
    
        if ((((int) (1073741823 & r6)) == ((int) ((r6 & 1152921503533105152L) >> 30))) == false) goto L89;
     */
    @Override // i8.f0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long l() {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i8.j0.l():long");
    }

    public void n(Runnable runnable) {
        if (!o(runnable)) {
            x.f5324r.n(runnable);
            return;
        }
        Thread p5 = p();
        if (Thread.currentThread() != p5) {
            LockSupport.unpark(p5);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0062, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean o(java.lang.Runnable r7) {
        /*
            r6 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = i8.j0.f5278o
            java.lang.Object r1 = r0.get(r6)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = i8.j0.f5280q
            int r2 = r2.get(r6)
            r3 = 0
            if (r2 == 0) goto L10
            return r3
        L10:
            r2 = 1
            if (r1 != 0) goto L22
        L13:
            r1 = 0
            boolean r1 = r0.compareAndSet(r6, r1, r7)
            if (r1 == 0) goto L1b
            goto L62
        L1b:
            java.lang.Object r1 = r0.get(r6)
            if (r1 == 0) goto L13
            goto L0
        L22:
            boolean r4 = r1 instanceof n8.n
            if (r4 == 0) goto L47
            r4 = r1
            n8.n r4 = (n8.n) r4
            int r5 = r4.a(r7)
            if (r5 == 0) goto L62
            if (r5 == r2) goto L35
            r0 = 2
            if (r5 == r0) goto L4b
            goto L0
        L35:
            n8.n r3 = r4.c()
        L39:
            boolean r2 = r0.compareAndSet(r6, r1, r3)
            if (r2 == 0) goto L40
            goto L0
        L40:
            java.lang.Object r2 = r0.get(r6)
            if (r2 == r1) goto L39
            goto L0
        L47:
            a6.d r4 = i8.w.f5313c
            if (r1 != r4) goto L4c
        L4b:
            return r3
        L4c:
            n8.n r3 = new n8.n
            r4 = 8
            r3.<init>(r4, r2)
            r4 = r1
            java.lang.Runnable r4 = (java.lang.Runnable) r4
            r3.a(r4)
            r3.a(r7)
        L5c:
            boolean r4 = r0.compareAndSet(r6, r1, r3)
            if (r4 == 0) goto L63
        L62:
            return r2
        L63:
            java.lang.Object r4 = r0.get(r6)
            if (r4 == r1) goto L5c
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: i8.j0.o(java.lang.Runnable):boolean");
    }

    public abstract Thread p();

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:
    
        if ((n8.x.f7540b.get(r0) == 0) == false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q() {
        /*
            r7 = this;
            o7.e r0 = r7.f5265m
            r1 = 1
            if (r0 == 0) goto La
            boolean r0 = r0.isEmpty()
            goto Lb
        La:
            r0 = 1
        Lb:
            r2 = 0
            if (r0 != 0) goto Lf
            goto L54
        Lf:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = i8.j0.f5279p
            java.lang.Object r0 = r0.get(r7)
            i8.i0 r0 = (i8.i0) r0
            if (r0 == 0) goto L27
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r3 = n8.x.f7540b
            int r0 = r3.get(r0)
            if (r0 != 0) goto L23
            r0 = 1
            goto L24
        L23:
            r0 = 0
        L24:
            if (r0 != 0) goto L27
            goto L54
        L27:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = i8.j0.f5278o
            java.lang.Object r0 = r0.get(r7)
            if (r0 != 0) goto L30
            goto L53
        L30:
            boolean r3 = r0 instanceof n8.n
            if (r3 == 0) goto L4f
            n8.n r0 = (n8.n) r0
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = n8.n.f7523f
            long r3 = r3.get(r0)
            r5 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r5 = r5 & r3
            int r0 = (int) r5
            r5 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r3 = r3 & r5
            r5 = 30
            long r3 = r3 >> r5
            int r4 = (int) r3
            if (r0 != r4) goto L4e
            return r1
        L4e:
            return r2
        L4f:
            a6.d r3 = i8.w.f5313c
            if (r0 != r3) goto L54
        L53:
            return r1
        L54:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: i8.j0.q():boolean");
    }

    public void r(long j5, h0 h0Var) {
        x.f5324r.s(j5, h0Var);
    }

    public final void s(long j5, h0 h0Var) {
        int b9;
        Thread p5;
        int i9 = f5280q.get(this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5279p;
        if (i9 != 0) {
            b9 = 1;
        } else {
            i0 i0Var = (i0) atomicReferenceFieldUpdater.get(this);
            if (i0Var == null) {
                i0 i0Var2 = new i0();
                i0Var2.f5275c = j5;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, null, i0Var2) && atomicReferenceFieldUpdater.get(this) == null) {
                }
                Object obj = atomicReferenceFieldUpdater.get(this);
                obj.getClass();
                i0Var = (i0) obj;
            }
            b9 = h0Var.b(j5, i0Var, this);
        }
        if (b9 == 0) {
            i0 i0Var3 = (i0) atomicReferenceFieldUpdater.get(this);
            if ((i0Var3 != null ? i0Var3.b() : null) != h0Var || Thread.currentThread() == (p5 = p())) {
                return;
            }
            LockSupport.unpark(p5);
            return;
        }
        if (b9 == 1) {
            r(j5, h0Var);
        } else {
            if (b9 == 2) {
                return;
            }
            m7.c.p("unexpected result");
        }
    }

    @Override // i8.f0
    public void shutdown() {
        h0 d9;
        f1.f5266a.set(null);
        f5280q.set(this, 1);
        a6.d dVar = w.f5313c;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5278o;
        loop0: while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj != null) {
                if (!(obj instanceof n8.n)) {
                    if (obj != dVar) {
                        n8.n nVar = new n8.n(8, true);
                        nVar.a((Runnable) obj);
                        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, nVar)) {
                            if (atomicReferenceFieldUpdater.get(this) != obj) {
                                break;
                            }
                        }
                        break loop0;
                    }
                    break;
                }
                ((n8.n) obj).b();
                break;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, dVar)) {
                if (atomicReferenceFieldUpdater.get(this) != null) {
                    break;
                }
            }
            break loop0;
        }
        while (l() <= 0) {
        }
        long nanoTime = System.nanoTime();
        while (true) {
            i0 i0Var = (i0) f5279p.get(this);
            if (i0Var == null) {
                return;
            }
            synchronized (i0Var) {
                d9 = n8.x.f7540b.get(i0Var) > 0 ? i0Var.d(0) : null;
            }
            if (d9 == null) {
                return;
            } else {
                r(nanoTime, d9);
            }
        }
    }
}
