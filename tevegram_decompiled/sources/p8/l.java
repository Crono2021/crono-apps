package p8;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l {

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f8297b = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "lastScheduledTask");

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f8298c = AtomicIntegerFieldUpdater.newUpdater(l.class, "producerIndex");

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f8299d = AtomicIntegerFieldUpdater.newUpdater(l.class, "consumerIndex");

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f8300e = AtomicIntegerFieldUpdater.newUpdater(l.class, "blockingTasksInBuffer");

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReferenceArray f8301a = new AtomicReferenceArray(128);
    private volatile int blockingTasksInBuffer;
    private volatile int consumerIndex;
    private volatile Object lastScheduledTask;
    private volatile int producerIndex;

    public final g a(g gVar) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f8298c;
        if (atomicIntegerFieldUpdater.get(this) - f8299d.get(this) == 127) {
            return gVar;
        }
        if (gVar.f8286j.f8287a == 1) {
            f8300e.incrementAndGet(this);
        }
        int i9 = atomicIntegerFieldUpdater.get(this) & 127;
        while (true) {
            AtomicReferenceArray atomicReferenceArray = this.f8301a;
            if (atomicReferenceArray.get(i9) == null) {
                atomicReferenceArray.lazySet(i9, gVar);
                atomicIntegerFieldUpdater.incrementAndGet(this);
                return null;
            }
            Thread.yield();
        }
    }

    public final g b() {
        g gVar;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f8299d;
            int i9 = atomicIntegerFieldUpdater.get(this);
            if (i9 - f8298c.get(this) == 0) {
                return null;
            }
            int i10 = i9 & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i9, i9 + 1) && (gVar = (g) this.f8301a.getAndSet(i10, null)) != null) {
                if (gVar.f8286j.f8287a == 1) {
                    f8300e.decrementAndGet(this);
                }
                return gVar;
            }
        }
    }

    public final g c(int i9, boolean z8) {
        int i10 = i9 & 127;
        AtomicReferenceArray atomicReferenceArray = this.f8301a;
        g gVar = (g) atomicReferenceArray.get(i10);
        if (gVar != null) {
            if ((gVar.f8286j.f8287a == 1) == z8) {
                while (!atomicReferenceArray.compareAndSet(i10, gVar, null)) {
                    if (atomicReferenceArray.get(i10) != gVar) {
                    }
                }
                if (z8) {
                    f8300e.decrementAndGet(this);
                }
                return gVar;
            }
        }
        return null;
    }
}
