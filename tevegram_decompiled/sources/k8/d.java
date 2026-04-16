package k8;

import d1.u;
import i8.j1;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import n8.t;
import o7.s;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class d implements h {

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f5638c = AtomicLongFieldUpdater.newUpdater(d.class, "sendersAndCloseStatus");

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f5639d = AtomicLongFieldUpdater.newUpdater(d.class, "receivers");

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f5640e = AtomicLongFieldUpdater.newUpdater(d.class, "bufferEnd");

    /* renamed from: f, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f5641f = AtomicLongFieldUpdater.newUpdater(d.class, "completedExpandBuffersAndPauseFlag");

    /* renamed from: g, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f5642g = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "sendSegment");
    public static final AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "receiveSegment");

    /* renamed from: i, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f5643i = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "bufferEndSegment");

    /* renamed from: j, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f5644j = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "_closeCause");

    /* renamed from: k, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f5645k = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "closeHandler");
    private volatile Object _closeCause;

    /* renamed from: b, reason: collision with root package name */
    public final int f5646b;
    private volatile long bufferEnd;
    private volatile Object bufferEndSegment;
    private volatile Object closeHandler;
    private volatile long completedExpandBuffersAndPauseFlag;
    private volatile Object receiveSegment;
    private volatile long receivers;
    private volatile Object sendSegment;
    private volatile long sendersAndCloseStatus;

    public d(int i9) {
        this.f5646b = i9;
        if (i9 < 0) {
            h7.o.d("Invalid channel capacity: ", i9, ", should be >=0");
            throw null;
        }
        l lVar = f.f5648a;
        this.bufferEnd = i9 != 0 ? i9 != Integer.MAX_VALUE ? i9 : Long.MAX_VALUE : 0L;
        this.completedExpandBuffersAndPauseFlag = f5640e.get(this);
        l lVar2 = new l(0L, null, this, 3);
        this.sendSegment = lVar2;
        this.receiveSegment = lVar2;
        if (r()) {
            lVar2 = f.f5648a;
            lVar2.getClass();
        }
        this.bufferEndSegment = lVar2;
        this._closeCause = f.f5665s;
    }

    public static final l c(d dVar, long j5, l lVar) {
        Object a9;
        d dVar2;
        l lVar2 = f.f5648a;
        e eVar = e.f5647q;
        loop0: while (true) {
            a9 = n8.a.a(j5, lVar);
            if (!n8.a.d(a9)) {
                t b9 = n8.a.b(a9);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5642g;
                    t tVar = (t) atomicReferenceFieldUpdater.get(dVar);
                    if (tVar.f7533k >= b9.f7533k) {
                        break loop0;
                    }
                    if (!b9.i()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(dVar, tVar, b9)) {
                        if (atomicReferenceFieldUpdater.get(dVar) != tVar) {
                            if (b9.e()) {
                                b9.d();
                            }
                        }
                    }
                    if (tVar.e()) {
                        tVar.d();
                    }
                }
            } else {
                break;
            }
        }
        boolean d9 = n8.a.d(a9);
        AtomicLongFieldUpdater atomicLongFieldUpdater = f5639d;
        if (d9) {
            dVar.h();
            if (lVar.f7533k * f.f5649b < atomicLongFieldUpdater.get(dVar)) {
                lVar.a();
                return null;
            }
        } else {
            l lVar3 = (l) n8.a.b(a9);
            long j9 = lVar3.f7533k;
            if (j9 <= j5) {
                return lVar3;
            }
            long j10 = f.f5649b * j9;
            while (true) {
                long j11 = f5638c.get(dVar);
                long j12 = 1152921504606846975L & j11;
                if (j12 >= j10) {
                    dVar2 = dVar;
                    break;
                }
                dVar2 = dVar;
                if (f5638c.compareAndSet(dVar2, j11, (((int) (j11 >> 60)) << 60) + j12)) {
                    break;
                }
                dVar = dVar2;
            }
            if (j9 * f.f5649b < atomicLongFieldUpdater.get(dVar2)) {
                lVar3.a();
            }
        }
        return null;
    }

    public static final void d(d dVar, s sVar, i8.f fVar) {
        fVar.g(new n7.c(dVar.m()));
    }

    public static final int e(d dVar, l lVar, int i9, Object obj, long j5, Object obj2, boolean z8) {
        lVar.m(i9, obj);
        if (z8) {
            return dVar.A(lVar, i9, obj, j5, obj2, z8);
        }
        Object k3 = lVar.k(i9);
        if (k3 == null) {
            if (dVar.f(j5)) {
                if (lVar.j(null, i9, f.f5651d)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (lVar.j(null, i9, obj2)) {
                    return 2;
                }
            }
        } else if (k3 instanceof j1) {
            lVar.m(i9, null);
            if (dVar.x(k3, obj)) {
                lVar.n(i9, f.f5655i);
                return 0;
            }
            a6.d dVar2 = f.f5657k;
            if (lVar.f5673n.getAndSet((i9 * 2) + 1, dVar2) == dVar2) {
                return 5;
            }
            lVar.l(i9, true);
            return 5;
        }
        return dVar.A(lVar, i9, obj, j5, obj2, z8);
    }

    public static void o(d dVar) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f5641f;
        if ((atomicLongFieldUpdater.addAndGet(dVar, 1L) & 4611686018427387904L) != 0) {
            while ((atomicLongFieldUpdater.get(dVar) & 4611686018427387904L) != 0) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object u(k8.d r13, t7.c r14) {
        /*
            boolean r0 = r14 instanceof k8.b
            if (r0 == 0) goto L14
            r0 = r14
            k8.b r0 = (k8.b) r0
            int r1 = r0.f5634n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f5634n = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            k8.b r0 = new k8.b
            r0.<init>(r13, r14)
            goto L12
        L1a:
            java.lang.Object r14 = r6.f5632l
            int r0 = r6.f5634n
            r1 = 1
            if (r0 == 0) goto L32
            if (r0 != r1) goto L2b
            com.bumptech.glide.c.V(r14)
            k8.k r14 = (k8.k) r14
            java.lang.Object r13 = r14.f5671a
            return r13
        L2b:
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            m7.c.p(r13)
            r13 = 0
            return r13
        L32:
            com.bumptech.glide.c.V(r14)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r14 = k8.d.h
            java.lang.Object r14 = r14.get(r13)
            k8.l r14 = (k8.l) r14
        L3d:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = k8.d.f5638c
            long r2 = r0.get(r13)
            boolean r0 = r13.p(r2, r1)
            if (r0 == 0) goto L53
            java.lang.Throwable r13 = r13.l()
            k8.i r14 = new k8.i
            r14.<init>(r13)
            return r14
        L53:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = k8.d.f5639d
            long r4 = r0.getAndIncrement(r13)
            int r0 = k8.f.f5649b
            long r2 = (long) r0
            long r7 = r4 / r2
            long r2 = r4 % r2
            int r3 = (int) r2
            long r9 = r14.f7533k
            int r0 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r0 == 0) goto L70
            k8.l r0 = r13.k(r7, r14)
            if (r0 != 0) goto L6e
            goto L3d
        L6e:
            r2 = r0
            goto L71
        L70:
            r2 = r14
        L71:
            r12 = 0
            r7 = r13
            r8 = r2
            r9 = r3
            r10 = r4
            java.lang.Object r13 = r7.z(r8, r9, r10, r12)
            a6.d r14 = k8.f.f5659m
            if (r13 == r14) goto La5
            a6.d r14 = k8.f.f5661o
            if (r13 != r14) goto L90
            long r13 = r7.n()
            int r0 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r0 >= 0) goto L8d
            r2.a()
        L8d:
            r14 = r2
            r13 = r7
            goto L3d
        L90:
            a6.d r14 = k8.f.f5660n
            if (r13 != r14) goto La1
            r6.f5634n = r1
            r1 = r7
            java.lang.Object r13 = r1.v(r2, r3, r4, r6)
            s7.a r14 = s7.a.f8891i
            if (r13 != r14) goto La0
            return r14
        La0:
            return r13
        La1:
            r2.a()
            return r13
        La5:
            java.lang.String r13 = "unexpected"
            m7.c.p(r13)
            r13 = 0
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.d.u(k8.d, t7.c):java.lang.Object");
    }

    public static boolean y(Object obj) {
        if (obj instanceof i8.f) {
            return f.a((i8.f) obj, n7.g.f7490c, null);
        }
        h7.o.c(obj, "Unexpected waiter: ");
        return false;
    }

    public final int A(l lVar, int i9, Object obj, long j5, Object obj2, boolean z8) {
        while (true) {
            Object k3 = lVar.k(i9);
            if (k3 == null) {
                if (!f(j5) || z8) {
                    if (z8) {
                        if (lVar.j(null, i9, f.f5656j)) {
                            lVar.h();
                            return 4;
                        }
                    } else {
                        if (obj2 == null) {
                            return 3;
                        }
                        if (lVar.j(null, i9, obj2)) {
                            return 2;
                        }
                    }
                } else if (lVar.j(null, i9, f.f5651d)) {
                    break;
                }
            } else {
                if (k3 != f.f5652e) {
                    a6.d dVar = f.f5657k;
                    if (k3 == dVar) {
                        lVar.m(i9, null);
                        return 5;
                    }
                    if (k3 == f.h) {
                        lVar.m(i9, null);
                        return 5;
                    }
                    if (k3 == f.f5658l) {
                        lVar.m(i9, null);
                        h();
                        return 4;
                    }
                    lVar.m(i9, null);
                    if (k3 instanceof p) {
                        k3 = ((p) k3).f5676a;
                    }
                    if (x(k3, obj)) {
                        lVar.n(i9, f.f5655i);
                        return 0;
                    }
                    if (lVar.f5673n.getAndSet((i9 * 2) + 1, dVar) != dVar) {
                        lVar.l(i9, true);
                    }
                    return 5;
                }
                if (lVar.j(k3, i9, f.f5651d)) {
                    break;
                }
            }
        }
        return 1;
    }

    public final void B(long j5) {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        d dVar = this;
        if (dVar.r()) {
            return;
        }
        while (true) {
            atomicLongFieldUpdater = f5640e;
            if (atomicLongFieldUpdater.get(dVar) > j5) {
                break;
            } else {
                dVar = this;
            }
        }
        int i9 = f.f5650c;
        int i10 = 0;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = f5641f;
            if (i10 < i9) {
                long j9 = atomicLongFieldUpdater.get(dVar);
                if (j9 == (4611686018427387903L & atomicLongFieldUpdater2.get(dVar)) && j9 == atomicLongFieldUpdater.get(dVar)) {
                    return;
                } else {
                    i10++;
                }
            } else {
                while (true) {
                    long j10 = atomicLongFieldUpdater2.get(dVar);
                    if (atomicLongFieldUpdater2.compareAndSet(dVar, j10, (j10 & 4611686018427387903L) + 4611686018427387904L)) {
                        break;
                    } else {
                        dVar = this;
                    }
                }
                while (true) {
                    long j11 = atomicLongFieldUpdater.get(dVar);
                    long j12 = atomicLongFieldUpdater2.get(dVar);
                    long j13 = j12 & 4611686018427387903L;
                    boolean z8 = (j12 & 4611686018427387904L) != 0;
                    if (j11 == j13 && j11 == atomicLongFieldUpdater.get(dVar)) {
                        break;
                    }
                    if (z8) {
                        dVar = this;
                    } else {
                        dVar = this;
                        atomicLongFieldUpdater2.compareAndSet(dVar, j12, 4611686018427387904L + j13);
                    }
                }
                while (true) {
                    long j14 = atomicLongFieldUpdater2.get(dVar);
                    if (atomicLongFieldUpdater2.compareAndSet(dVar, j14, j14 & 4611686018427387903L)) {
                        return;
                    } else {
                        dVar = this;
                    }
                }
            }
        }
    }

    @Override // k8.h
    public Object a(Object obj) {
        n7.g gVar = n7.g.f7490c;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f5638c;
        boolean z8 = false;
        long j5 = 1152921504606846975L;
        boolean z9 = p(atomicLongFieldUpdater.get(this), false) ? false : !f(r1 & 1152921504606846975L);
        j jVar = k.f5670b;
        if (z9) {
            return jVar;
        }
        Object obj2 = f.f5656j;
        l lVar = (l) f5642g.get(this);
        while (true) {
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j9 = andIncrement & j5;
            boolean p5 = p(andIncrement, z8);
            int i9 = f.f5649b;
            long j10 = i9;
            long j11 = j9 / j10;
            int i10 = (int) (j9 % j10);
            if (lVar.f7533k != j11) {
                l c9 = c(this, j11, lVar);
                if (c9 != null) {
                    lVar = c9;
                } else {
                    if (p5) {
                        return new i(m());
                    }
                    z8 = false;
                    j5 = 1152921504606846975L;
                }
            }
            int e9 = e(this, lVar, i10, obj, j9, obj2, p5);
            if (e9 == 0) {
                lVar.a();
                return gVar;
            }
            if (e9 == 1) {
                return gVar;
            }
            if (e9 == 2) {
                if (p5) {
                    lVar.h();
                    return new i(m());
                }
                j1 j1Var = obj2 instanceof j1 ? (j1) obj2 : null;
                if (j1Var != null) {
                    j1Var.a(lVar, i10 + i9);
                }
                lVar.h();
                return jVar;
            }
            if (e9 == 3) {
                m7.c.p("unexpected");
                return null;
            }
            if (e9 == 4) {
                if (j9 < f5639d.get(this)) {
                    lVar.a();
                }
                return new i(m());
            }
            if (e9 == 5) {
                lVar.a();
            }
            z8 = false;
            j5 = 1152921504606846975L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x014a A[RETURN] */
    @Override // k8.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(o7.s r24, m8.a r25) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.d.b(o7.s, m8.a):java.lang.Object");
    }

    public final boolean f(long j5) {
        return j5 < f5640e.get(this) || j5 < f5639d.get(this) + ((long) this.f5646b);
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x008e, code lost:
    
        r1 = (k8.l) ((n8.d) n8.d.f7501j.get(r1));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final k8.l g(long r14) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.d.g(long):k8.l");
    }

    public final void h() {
        p(f5638c.get(this), false);
    }

    public final void i(long j5) {
        l lVar = (l) h.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f5639d;
            long j9 = atomicLongFieldUpdater.get(this);
            if (j5 < Math.max(this.f5646b + j9, f5640e.get(this))) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j9, 1 + j9)) {
                long j10 = f.f5649b;
                long j11 = j9 / j10;
                int i9 = (int) (j9 % j10);
                if (lVar.f7533k != j11) {
                    l k3 = k(j11, lVar);
                    if (k3 != null) {
                        lVar = k3;
                    }
                }
                l lVar2 = lVar;
                if (z(lVar2, i9, j9, null) != f.f5661o) {
                    lVar2.a();
                } else if (j9 < n()) {
                    lVar2.a();
                }
                lVar = lVar2;
            }
        }
    }

    public final void j() {
        Object a9;
        if (r()) {
            return;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5643i;
        l lVar = (l) atomicReferenceFieldUpdater.get(this);
        loop0: while (true) {
            long andIncrement = f5640e.getAndIncrement(this);
            long j5 = andIncrement / f.f5649b;
            if (n() <= andIncrement) {
                if (lVar.f7533k < j5 && lVar.b() != null) {
                    s(j5, lVar);
                }
                o(this);
                return;
            }
            if (lVar.f7533k != j5) {
                e eVar = e.f5647q;
                while (true) {
                    a9 = n8.a.a(j5, lVar);
                    if (!n8.a.d(a9)) {
                        t b9 = n8.a.b(a9);
                        while (true) {
                            t tVar = (t) atomicReferenceFieldUpdater.get(this);
                            if (tVar.f7533k >= b9.f7533k) {
                                break;
                            }
                            if (!b9.i()) {
                                break;
                            }
                            while (!atomicReferenceFieldUpdater.compareAndSet(this, tVar, b9)) {
                                if (atomicReferenceFieldUpdater.get(this) != tVar) {
                                    if (b9.e()) {
                                        b9.d();
                                    }
                                }
                            }
                            if (tVar.e()) {
                                tVar.d();
                            }
                        }
                    } else {
                        break;
                    }
                }
                l lVar2 = null;
                if (n8.a.d(a9)) {
                    h();
                    s(j5, lVar);
                    o(this);
                } else {
                    l lVar3 = (l) n8.a.b(a9);
                    long j9 = lVar3.f7533k;
                    if (j9 > j5) {
                        long j10 = j9 * f.f5649b;
                        if (f5640e.compareAndSet(this, 1 + andIncrement, j10)) {
                            AtomicLongFieldUpdater atomicLongFieldUpdater = f5641f;
                            if ((atomicLongFieldUpdater.addAndGet(this, j10 - andIncrement) & 4611686018427387904L) != 0) {
                                while ((atomicLongFieldUpdater.get(this) & 4611686018427387904L) != 0) {
                                }
                            }
                        } else {
                            o(this);
                        }
                    } else {
                        lVar2 = lVar3;
                    }
                }
                if (lVar2 == null) {
                    continue;
                } else {
                    lVar = lVar2;
                }
            }
            int i9 = (int) (andIncrement % f.f5649b);
            Object k3 = lVar.k(i9);
            boolean z8 = k3 instanceof j1;
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = f5639d;
            if (!z8 || andIncrement < atomicLongFieldUpdater2.get(this) || !lVar.j(k3, i9, f.f5654g)) {
                while (true) {
                    Object k9 = lVar.k(i9);
                    if (!(k9 instanceof j1)) {
                        if (k9 != f.f5656j) {
                            if (k9 != null) {
                                if (k9 == f.f5651d || k9 == f.h || k9 == f.f5655i || k9 == f.f5657k || k9 == f.f5658l) {
                                    break loop0;
                                } else if (k9 != f.f5653f) {
                                    h7.o.c(k9, "Unexpected cell state: ");
                                    return;
                                }
                            } else if (lVar.j(k9, i9, f.f5652e)) {
                                break loop0;
                            }
                        } else {
                            break;
                        }
                    } else if (andIncrement < atomicLongFieldUpdater2.get(this)) {
                        if (lVar.j(k9, i9, new p((j1) k9))) {
                            break loop0;
                        }
                    } else if (lVar.j(k9, i9, f.f5654g)) {
                        if (y(k9)) {
                            lVar.n(i9, f.f5651d);
                            break;
                        } else {
                            lVar.n(i9, f.f5656j);
                            lVar.h();
                        }
                    }
                }
            } else if (y(k3)) {
                lVar.n(i9, f.f5651d);
                break;
            } else {
                lVar.n(i9, f.f5656j);
                lVar.h();
                o(this);
            }
        }
        o(this);
    }

    public final l k(long j5, l lVar) {
        Object a9;
        long j9;
        l lVar2 = f.f5648a;
        e eVar = e.f5647q;
        loop0: while (true) {
            a9 = n8.a.a(j5, lVar);
            if (!n8.a.d(a9)) {
                t b9 = n8.a.b(a9);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = h;
                    t tVar = (t) atomicReferenceFieldUpdater.get(this);
                    if (tVar.f7533k >= b9.f7533k) {
                        break loop0;
                    }
                    if (!b9.i()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, tVar, b9)) {
                        if (atomicReferenceFieldUpdater.get(this) != tVar) {
                            if (b9.e()) {
                                b9.d();
                            }
                        }
                    }
                    if (tVar.e()) {
                        tVar.d();
                    }
                }
            } else {
                break;
            }
        }
        if (n8.a.d(a9)) {
            h();
            if (lVar.f7533k * f.f5649b < n()) {
                lVar.a();
                return null;
            }
        } else {
            l lVar3 = (l) n8.a.b(a9);
            long j10 = lVar3.f7533k;
            if (!r() && j5 <= f5640e.get(this) / f.f5649b) {
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f5643i;
                    t tVar2 = (t) atomicReferenceFieldUpdater2.get(this);
                    if (tVar2.f7533k >= j10 || !lVar3.i()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater2.compareAndSet(this, tVar2, lVar3)) {
                        if (atomicReferenceFieldUpdater2.get(this) != tVar2) {
                            if (lVar3.e()) {
                                lVar3.d();
                            }
                        }
                    }
                    if (tVar2.e()) {
                        tVar2.d();
                    }
                }
            }
            if (j10 <= j5) {
                return lVar3;
            }
            long j11 = j10 * f.f5649b;
            do {
                j9 = f5639d.get(this);
                if (j9 >= j11) {
                    break;
                }
            } while (!f5639d.compareAndSet(this, j9, j11));
            if (j10 * f.f5649b < n()) {
                lVar3.a();
            }
        }
        return null;
    }

    public final Throwable l() {
        return (Throwable) f5644j.get(this);
    }

    public final Throwable m() {
        Throwable l4 = l();
        return l4 == null ? new u("Channel was closed") : l4;
    }

    public final long n() {
        return f5638c.get(this) & 1152921504606846975L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:84:0x00a4, code lost:
    
        r1 = (k8.l) ((n8.d) n8.d.f7501j.get(r1));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean p(long r15, boolean r17) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.d.p(long, boolean):boolean");
    }

    public boolean q() {
        return false;
    }

    public final boolean r() {
        long j5 = f5640e.get(this);
        return j5 == 0 || j5 == Long.MAX_VALUE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0011, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s(long r6, k8.l r8) {
        /*
            r5 = this;
        L0:
            long r0 = r8.f7533k
            int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r2 >= 0) goto L11
            n8.d r0 = r8.b()
            k8.l r0 = (k8.l) r0
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r8 = r0
            goto L0
        L11:
            boolean r6 = r8.c()
            if (r6 == 0) goto L22
            n8.d r6 = r8.b()
            k8.l r6 = (k8.l) r6
            if (r6 != 0) goto L20
            goto L22
        L20:
            r8 = r6
            goto L11
        L22:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = k8.d.f5643i
            java.lang.Object r7 = r6.get(r5)
            n8.t r7 = (n8.t) r7
            long r0 = r7.f7533k
            long r2 = r8.f7533k
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L33
            goto L49
        L33:
            boolean r0 = r8.i()
            if (r0 != 0) goto L3a
            goto L11
        L3a:
            boolean r0 = r6.compareAndSet(r5, r7, r8)
            if (r0 == 0) goto L4a
            boolean r6 = r7.e()
            if (r6 == 0) goto L49
            r7.d()
        L49:
            return
        L4a:
            java.lang.Object r0 = r6.get(r5)
            if (r0 == r7) goto L3a
            boolean r6 = r8.e()
            if (r6 == 0) goto L22
            r8.d()
            goto L22
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.d.s(long, k8.l):void");
    }

    public final Object t(s sVar, m8.a aVar) {
        i8.f fVar = new i8.f(1, com.bumptech.glide.c.C(aVar));
        fVar.s();
        fVar.g(new n7.c(m()));
        Object r8 = fVar.r();
        return r8 == s7.a.f8891i ? r8 : n7.g.f7490c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:97:0x01aa, code lost:
    
        r3 = (k8.l) r3.b();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 496
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.d.toString():java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v(k8.l r10, int r11, long r12, t7.c r14) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.d.v(k8.l, int, long, t7.c):java.lang.Object");
    }

    public final void w(j1 j1Var, boolean z8) {
        Throwable m9;
        if (j1Var instanceof i8.f) {
            r7.c cVar = (r7.c) j1Var;
            if (z8) {
                m9 = l();
                if (m9 == null) {
                    m9 = new m("Channel was closed");
                }
            } else {
                m9 = m();
            }
            cVar.g(new n7.c(m9));
            return;
        }
        if (j1Var instanceof o) {
            ((o) j1Var).f5675i.g(new k(new i(l())));
            return;
        }
        if (!(j1Var instanceof a)) {
            h7.o.c(j1Var, "Unexpected waiter: ");
            return;
        }
        a aVar = (a) j1Var;
        i8.f fVar = aVar.f5630j;
        fVar.getClass();
        aVar.f5630j = null;
        aVar.f5629i = f.f5658l;
        Throwable l4 = aVar.f5631k.l();
        if (l4 == null) {
            fVar.g(Boolean.FALSE);
        } else {
            fVar.g(new n7.c(l4));
        }
    }

    public final boolean x(Object obj, Object obj2) {
        if (obj instanceof o) {
            return f.a(((o) obj).f5675i, new k(obj2), null);
        }
        if (!(obj instanceof a)) {
            if (obj instanceof i8.f) {
                return f.a((i8.f) obj, obj2, null);
            }
            h7.o.c(obj, "Unexpected receiver type: ");
            return false;
        }
        a aVar = (a) obj;
        i8.f fVar = aVar.f5630j;
        fVar.getClass();
        aVar.f5630j = null;
        aVar.f5629i = obj2;
        Boolean bool = Boolean.TRUE;
        aVar.f5631k.getClass();
        return f.a(fVar, bool, null);
    }

    public final Object z(l lVar, int i9, long j5, Object obj) {
        Object k3 = lVar.k(i9);
        AtomicReferenceArray atomicReferenceArray = lVar.f5673n;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f5638c;
        if (k3 == null) {
            if (j5 >= (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return f.f5660n;
                }
                if (lVar.j(k3, i9, obj)) {
                    j();
                    return f.f5659m;
                }
            }
        } else if (k3 == f.f5651d && lVar.j(k3, i9, f.f5655i)) {
            j();
            Object obj2 = atomicReferenceArray.get(i9 * 2);
            lVar.m(i9, null);
            return obj2;
        }
        while (true) {
            Object k9 = lVar.k(i9);
            if (k9 == null || k9 == f.f5652e) {
                if (j5 < (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                    if (lVar.j(k9, i9, f.h)) {
                        j();
                        return f.f5661o;
                    }
                } else {
                    if (obj == null) {
                        return f.f5660n;
                    }
                    if (lVar.j(k9, i9, obj)) {
                        j();
                        return f.f5659m;
                    }
                }
            } else if (k9 != f.f5651d) {
                a6.d dVar = f.f5656j;
                if (k9 == dVar) {
                    return f.f5661o;
                }
                if (k9 == f.h) {
                    return f.f5661o;
                }
                if (k9 == f.f5658l) {
                    j();
                    return f.f5661o;
                }
                if (k9 != f.f5654g && lVar.j(k9, i9, f.f5653f)) {
                    boolean z8 = k9 instanceof p;
                    if (z8) {
                        k9 = ((p) k9).f5676a;
                    }
                    if (y(k9)) {
                        lVar.n(i9, f.f5655i);
                        j();
                        Object obj3 = atomicReferenceArray.get(i9 * 2);
                        lVar.m(i9, null);
                        return obj3;
                    }
                    lVar.n(i9, dVar);
                    lVar.h();
                    if (z8) {
                        j();
                    }
                    return f.f5661o;
                }
            } else if (lVar.j(k9, i9, f.f5655i)) {
                j();
                Object obj4 = atomicReferenceArray.get(i9 * 2);
                lVar.m(i9, null);
                return obj4;
            }
        }
    }
}
