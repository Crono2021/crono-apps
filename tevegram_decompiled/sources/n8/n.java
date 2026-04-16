package n8;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class n {

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f7522e = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "_next");

    /* renamed from: f, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f7523f = AtomicLongFieldUpdater.newUpdater(n.class, "_state");

    /* renamed from: g, reason: collision with root package name */
    public static final a6.d f7524g = new a6.d("REMOVE_FROZEN", 3);
    private volatile Object _next;
    private volatile long _state;

    /* renamed from: a, reason: collision with root package name */
    public final int f7525a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f7526b;

    /* renamed from: c, reason: collision with root package name */
    public final int f7527c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReferenceArray f7528d;

    public n(int i9, boolean z8) {
        this.f7525a = i9;
        this.f7526b = z8;
        int i10 = i9 - 1;
        this.f7527c = i10;
        this.f7528d = new AtomicReferenceArray(i9);
        if (i10 > 1073741823) {
            m7.c.p("Check failed.");
            throw null;
        }
        if ((i9 & i10) == 0) {
            return;
        }
        m7.c.p("Check failed.");
        throw null;
    }

    public final int a(Object obj) {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f7523f;
            long j5 = atomicLongFieldUpdater.get(this);
            if ((3458764513820540928L & j5) != 0) {
                return (2305843009213693952L & j5) != 0 ? 2 : 1;
            }
            int i9 = (int) (1073741823 & j5);
            int i10 = (int) ((1152921503533105152L & j5) >> 30);
            int i11 = this.f7527c;
            if (((i10 + 2) & i11) == (i9 & i11)) {
                return 1;
            }
            boolean z8 = this.f7526b;
            AtomicReferenceArray atomicReferenceArray = this.f7528d;
            if (z8 || atomicReferenceArray.get(i10 & i11) == null) {
                if (f7523f.compareAndSet(this, j5, ((-1152921503533105153L) & j5) | (((i10 + 1) & 1073741823) << 30))) {
                    atomicReferenceArray.set(i10 & i11, obj);
                    n nVar = this;
                    while ((atomicLongFieldUpdater.get(nVar) & 1152921504606846976L) != 0) {
                        nVar = nVar.c();
                        AtomicReferenceArray atomicReferenceArray2 = nVar.f7528d;
                        int i12 = nVar.f7527c & i10;
                        Object obj2 = atomicReferenceArray2.get(i12);
                        if ((obj2 instanceof m) && ((m) obj2).f7521a == i10) {
                            atomicReferenceArray2.set(i12, obj);
                        } else {
                            nVar = null;
                        }
                        if (nVar == null) {
                            return 0;
                        }
                    }
                    return 0;
                }
            } else {
                int i13 = this.f7525a;
                if (i13 < 1024 || ((i10 - i9) & 1073741823) > (i13 >> 1)) {
                    return 1;
                }
            }
        }
    }

    public final boolean b() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j5;
        do {
            atomicLongFieldUpdater = f7523f;
            j5 = atomicLongFieldUpdater.get(this);
            if ((j5 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j5) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j5, 2305843009213693952L | j5));
        return true;
    }

    public final n c() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j5;
        n nVar;
        while (true) {
            atomicLongFieldUpdater = f7523f;
            j5 = atomicLongFieldUpdater.get(this);
            if ((j5 & 1152921504606846976L) != 0) {
                nVar = this;
                break;
            }
            long j9 = 1152921504606846976L | j5;
            nVar = this;
            if (atomicLongFieldUpdater.compareAndSet(nVar, j5, j9)) {
                j5 = j9;
                break;
            }
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7522e;
            n nVar2 = (n) atomicReferenceFieldUpdater.get(this);
            if (nVar2 != null) {
                return nVar2;
            }
            n nVar3 = new n(nVar.f7525a * 2, nVar.f7526b);
            int i9 = (int) (1073741823 & j5);
            int i10 = (int) ((1152921503533105152L & j5) >> 30);
            while (true) {
                int i11 = nVar.f7527c;
                int i12 = i9 & i11;
                if (i12 == (i11 & i10)) {
                    break;
                }
                Object obj = nVar.f7528d.get(i12);
                if (obj == null) {
                    obj = new m(i9);
                }
                nVar3.f7528d.set(nVar3.f7527c & i9, obj);
                i9++;
            }
            atomicLongFieldUpdater.set(nVar3, (-1152921504606846977L) & j5);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, nVar3) && atomicReferenceFieldUpdater.get(this) == null) {
            }
        }
    }

    public final Object d() {
        n nVar = this;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f7523f;
            long j5 = atomicLongFieldUpdater.get(nVar);
            if ((j5 & 1152921504606846976L) != 0) {
                return f7524g;
            }
            int i9 = (int) (j5 & 1073741823);
            int i10 = (int) ((1152921503533105152L & j5) >> 30);
            int i11 = nVar.f7527c;
            int i12 = i9 & i11;
            if ((i10 & i11) == i12) {
                break;
            }
            AtomicReferenceArray atomicReferenceArray = nVar.f7528d;
            Object obj = atomicReferenceArray.get(i12);
            boolean z8 = nVar.f7526b;
            if (obj == null) {
                if (z8) {
                    break;
                }
            } else {
                if (obj instanceof m) {
                    break;
                }
                long j9 = (i9 + 1) & 1073741823;
                if (f7523f.compareAndSet(nVar, j5, (j5 & (-1073741824)) | j9)) {
                    atomicReferenceArray.set(i12, null);
                    return obj;
                }
                nVar = this;
                if (z8) {
                    while (true) {
                        long j10 = atomicLongFieldUpdater.get(nVar);
                        int i13 = (int) (j10 & 1073741823);
                        if ((j10 & 1152921504606846976L) != 0) {
                            nVar = nVar.c();
                        } else {
                            n nVar2 = nVar;
                            if (f7523f.compareAndSet(nVar2, j10, (j10 & (-1073741824)) | j9)) {
                                nVar2.f7528d.set(i13 & nVar2.f7527c, null);
                                nVar = null;
                            } else {
                                nVar = nVar2;
                            }
                        }
                        if (nVar == null) {
                            return obj;
                        }
                    }
                }
            }
        }
        return null;
    }
}
