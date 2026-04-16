package n8;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class k {

    /* renamed from: i, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f7517i = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_next");

    /* renamed from: j, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f7518j = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_prev");

    /* renamed from: k, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f7519k = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_removedRef");
    private volatile Object _next = this;
    private volatile Object _prev = this;
    private volatile Object _removedRef;

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003e, code lost:
    
        r6 = ((n8.q) r6).f7530a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0046, code lost:
    
        if (r5.compareAndSet(r4, r3, r6) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004e, code lost:
    
        if (r5.get(r4) == r3) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final n8.k j() {
        /*
            r9 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = n8.k.f7518j
            java.lang.Object r1 = r0.get(r9)
            n8.k r1 = (n8.k) r1
            r2 = 0
            r3 = r1
        La:
            r4 = r2
        Lb:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = n8.k.f7517i
            java.lang.Object r6 = r5.get(r3)
            if (r6 != r9) goto L24
            if (r1 != r3) goto L16
            goto L2d
        L16:
            boolean r2 = r0.compareAndSet(r9, r1, r3)
            if (r2 == 0) goto L1d
            goto L2d
        L1d:
            java.lang.Object r2 = r0.get(r9)
            if (r2 == r1) goto L16
            goto L0
        L24:
            boolean r7 = r9.n()
            if (r7 == 0) goto L2b
            return r2
        L2b:
            if (r6 != 0) goto L2e
        L2d:
            return r3
        L2e:
            boolean r7 = r6 instanceof n8.b
            if (r7 == 0) goto L38
            n8.b r6 = (n8.b) r6
            r6.b(r3)
            goto L0
        L38:
            boolean r7 = r6 instanceof n8.q
            if (r7 == 0) goto L58
            if (r4 == 0) goto L51
            n8.q r6 = (n8.q) r6
            n8.k r6 = r6.f7530a
        L42:
            boolean r7 = r5.compareAndSet(r4, r3, r6)
            if (r7 == 0) goto L4a
            r3 = r4
            goto La
        L4a:
            java.lang.Object r7 = r5.get(r4)
            if (r7 == r3) goto L42
            goto L0
        L51:
            java.lang.Object r3 = r0.get(r3)
            n8.k r3 = (n8.k) r3
            goto Lb
        L58:
            r6.getClass()
            r4 = r6
            n8.k r4 = (n8.k) r4
            r8 = r4
            r4 = r3
            r3 = r8
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: n8.k.j():n8.k");
    }

    public final void k(k kVar) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7518j;
            k kVar2 = (k) atomicReferenceFieldUpdater.get(kVar);
            if (l() != kVar) {
                return;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(kVar, kVar2, this)) {
                if (atomicReferenceFieldUpdater.get(kVar) != kVar2) {
                    break;
                }
            }
            if (n()) {
                kVar.j();
                return;
            }
            return;
        }
    }

    public final Object l() {
        while (true) {
            Object obj = f7517i.get(this);
            if (!(obj instanceof b)) {
                return obj;
            }
            ((b) obj).b(this);
        }
    }

    public final k m() {
        Object l4 = l();
        q qVar = l4 instanceof q ? (q) l4 : null;
        if (qVar != null) {
            return qVar.f7530a;
        }
        l4.getClass();
        return (k) l4;
    }

    public boolean n() {
        return l() instanceof q;
    }

    public String toString() {
        return new j(this) + '@' + i8.w.f(this);
    }
}
