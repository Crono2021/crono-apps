package p8;

import b8.o;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a extends Thread {

    /* renamed from: q, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f8260q = AtomicIntegerFieldUpdater.newUpdater(a.class, "workerCtl");

    /* renamed from: i, reason: collision with root package name */
    public final l f8261i;
    private volatile int indexInArray;

    /* renamed from: j, reason: collision with root package name */
    public final o f8262j;

    /* renamed from: k, reason: collision with root package name */
    public int f8263k;

    /* renamed from: l, reason: collision with root package name */
    public long f8264l;

    /* renamed from: m, reason: collision with root package name */
    public long f8265m;

    /* renamed from: n, reason: collision with root package name */
    public int f8266n;
    private volatile Object nextParkedWorker;

    /* renamed from: o, reason: collision with root package name */
    public boolean f8267o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ b f8268p;
    private volatile int workerCtl;

    public a(b bVar, int i9) {
        this.f8268p = bVar;
        setDaemon(true);
        this.f8261i = new l();
        this.f8262j = new o();
        this.f8263k = 4;
        this.nextParkedWorker = b.f8272s;
        this.f8266n = c8.e.f1727i.b();
        f(i9);
    }

    public final g a(boolean z8) {
        g e9;
        g e10;
        long j5;
        int i9 = this.f8263k;
        b bVar = this.f8268p;
        g gVar = null;
        l lVar = this.f8261i;
        if (i9 != 1) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = b.f8270q;
            do {
                j5 = atomicLongFieldUpdater.get(bVar);
                if (((int) ((9223367638808264704L & j5) >> 42)) == 0) {
                    lVar.getClass();
                    loop1: while (true) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = l.f8297b;
                        g gVar2 = (g) atomicReferenceFieldUpdater.get(lVar);
                        if (gVar2 != null && gVar2.f8286j.f8287a == 1) {
                            while (!atomicReferenceFieldUpdater.compareAndSet(lVar, gVar2, null)) {
                                if (atomicReferenceFieldUpdater.get(lVar) != gVar2) {
                                    break;
                                }
                            }
                            gVar = gVar2;
                            break loop1;
                        }
                    }
                    int i10 = l.f8299d.get(lVar);
                    int i11 = l.f8298c.get(lVar);
                    while (true) {
                        if (i10 == i11 || l.f8300e.get(lVar) == 0) {
                            break;
                        }
                        i11--;
                        g c9 = lVar.c(i11, true);
                        if (c9 != null) {
                            gVar = c9;
                            break;
                        }
                    }
                    if (gVar != null) {
                        return gVar;
                    }
                    g gVar3 = (g) bVar.f8278n.d();
                    return gVar3 == null ? i(1) : gVar3;
                }
            } while (!b.f8270q.compareAndSet(bVar, j5, j5 - 4398046511104L));
            this.f8263k = 1;
        }
        if (z8) {
            boolean z9 = d(bVar.f8273i * 2) == 0;
            if (z9 && (e10 = e()) != null) {
                return e10;
            }
            lVar.getClass();
            g gVar4 = (g) l.f8297b.getAndSet(lVar, null);
            if (gVar4 == null) {
                gVar4 = lVar.b();
            }
            if (gVar4 != null) {
                return gVar4;
            }
            if (!z9 && (e9 = e()) != null) {
                return e9;
            }
        } else {
            g e11 = e();
            if (e11 != null) {
                return e11;
            }
        }
        return i(3);
    }

    public final int b() {
        return this.indexInArray;
    }

    public final Object c() {
        return this.nextParkedWorker;
    }

    public final int d(int i9) {
        int i10 = this.f8266n;
        int i11 = i10 ^ (i10 << 13);
        int i12 = i11 ^ (i11 >> 17);
        int i13 = i12 ^ (i12 << 5);
        this.f8266n = i13;
        int i14 = i9 - 1;
        return (i14 & i9) == 0 ? i13 & i14 : (i13 & Integer.MAX_VALUE) % i9;
    }

    public final g e() {
        int d9 = d(2);
        b bVar = this.f8268p;
        e eVar = bVar.f8278n;
        e eVar2 = bVar.f8277m;
        if (d9 == 0) {
            g gVar = (g) eVar2.d();
            return gVar != null ? gVar : (g) eVar.d();
        }
        g gVar2 = (g) eVar.d();
        return gVar2 != null ? gVar2 : (g) eVar2.d();
    }

    public final void f(int i9) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8268p.f8276l);
        sb.append("-worker-");
        sb.append(i9 == 0 ? "TERMINATED" : String.valueOf(i9));
        setName(sb.toString());
        this.indexInArray = i9;
    }

    public final void g(Object obj) {
        this.nextParkedWorker = obj;
    }

    public final boolean h(int i9) {
        int i10 = this.f8263k;
        boolean z8 = i10 == 1;
        if (z8) {
            b.f8270q.addAndGet(this.f8268p, 4398046511104L);
        }
        if (i10 != i9) {
            this.f8263k = i9;
        }
        return z8;
    }

    public final g i(int i9) {
        long j5;
        g gVar;
        long j9;
        long j10;
        g gVar2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = b.f8270q;
        b bVar = this.f8268p;
        int i10 = (int) (atomicLongFieldUpdater.get(bVar) & 2097151);
        g gVar3 = null;
        if (i10 < 2) {
            return null;
        }
        int d9 = d(i10);
        int i11 = 0;
        long j11 = Long.MAX_VALUE;
        while (i11 < i10) {
            d9++;
            if (d9 > i10) {
                d9 = 1;
            }
            a aVar = (a) bVar.f8279o.b(d9);
            if (aVar != null && aVar != this) {
                l lVar = aVar.f8261i;
                if (i9 == 3) {
                    gVar = lVar.b();
                    j5 = 0;
                } else {
                    lVar.getClass();
                    int i12 = l.f8299d.get(lVar);
                    int i13 = l.f8298c.get(lVar);
                    boolean z8 = i9 == 1;
                    while (true) {
                        if (i12 == i13) {
                            j5 = 0;
                            break;
                        }
                        j5 = 0;
                        if (!z8 || l.f8300e.get(lVar) != 0) {
                            int i14 = i12 + 1;
                            gVar = lVar.c(i12, z8);
                            if (gVar != null) {
                                break;
                            }
                            i12 = i14;
                        } else {
                            break;
                        }
                    }
                    gVar = gVar3;
                }
                o oVar = this.f8262j;
                if (gVar != null) {
                    oVar.f1525i = gVar;
                    gVar2 = gVar3;
                    j10 = -1;
                    j9 = -1;
                } else {
                    while (true) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = l.f8297b;
                        g gVar4 = (g) atomicReferenceFieldUpdater.get(lVar);
                        if (gVar4 == null) {
                            j9 = -1;
                            break;
                        }
                        j9 = -1;
                        if (((gVar4.f8286j.f8287a == 1 ? 1 : 2) & i9) == 0) {
                            break;
                        }
                        j.f8294f.getClass();
                        l lVar2 = lVar;
                        long nanoTime = System.nanoTime() - gVar4.f8285i;
                        long j12 = j.f8290b;
                        if (nanoTime < j12) {
                            j10 = j12 - nanoTime;
                            gVar2 = null;
                            break;
                        }
                        do {
                            gVar2 = null;
                            if (atomicReferenceFieldUpdater.compareAndSet(lVar2, gVar4, null)) {
                                oVar.f1525i = gVar4;
                                j10 = -1;
                                break;
                            }
                        } while (atomicReferenceFieldUpdater.get(lVar2) == gVar4);
                        lVar = lVar2;
                        gVar3 = null;
                    }
                    j10 = -2;
                    gVar2 = gVar3;
                }
                if (j10 == j9) {
                    g gVar5 = (g) oVar.f1525i;
                    oVar.f1525i = gVar2;
                    return gVar5;
                }
                if (j10 > j5) {
                    j11 = Math.min(j11, j10);
                }
            }
            i11++;
            gVar3 = null;
        }
        if (j11 == Long.MAX_VALUE) {
            j11 = 0;
        }
        this.f8265m = j11;
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x0004, code lost:
    
        continue;
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 392
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p8.a.run():void");
    }
}
