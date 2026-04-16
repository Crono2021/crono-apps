package k8;

import java.util.concurrent.atomic.AtomicReferenceArray;
import n8.t;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l extends t {

    /* renamed from: m, reason: collision with root package name */
    public final d f5672m;

    /* renamed from: n, reason: collision with root package name */
    public final AtomicReferenceArray f5673n;

    public l(long j5, l lVar, d dVar, int i9) {
        super(j5, lVar, i9);
        this.f5672m = dVar;
        this.f5673n = new AtomicReferenceArray(f.f5649b * 2);
    }

    @Override // n8.t
    public final int f() {
        return f.f5649b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0047, code lost:
    
        m(r5, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x004a, code lost:
    
        if (r0 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x004c, code lost:
    
        r2.getClass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x004f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:?, code lost:
    
        return;
     */
    @Override // n8.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(int r5, r7.g r6) {
        /*
            r4 = this;
            int r6 = k8.f.f5649b
            if (r5 < r6) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            if (r0 == 0) goto La
            int r5 = r5 - r6
        La:
            int r6 = r5 * 2
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r4.f5673n
            r1.get(r6)
        L11:
            java.lang.Object r6 = r4.k(r5)
            boolean r1 = r6 instanceof i8.j1
            k8.d r2 = r4.f5672m
            r3 = 0
            if (r1 != 0) goto L50
            boolean r1 = r6 instanceof k8.p
            if (r1 == 0) goto L21
            goto L50
        L21:
            a6.d r1 = k8.f.f5656j
            if (r6 == r1) goto L47
            a6.d r1 = k8.f.f5657k
            if (r6 != r1) goto L2a
            goto L47
        L2a:
            a6.d r1 = k8.f.f5654g
            if (r6 == r1) goto L11
            a6.d r1 = k8.f.f5653f
            if (r6 != r1) goto L33
            goto L11
        L33:
            a6.d r5 = k8.f.f5655i
            if (r6 == r5) goto L6a
            a6.d r5 = k8.f.f5651d
            if (r6 != r5) goto L3c
            goto L6a
        L3c:
            a6.d r5 = k8.f.f5658l
            if (r6 != r5) goto L41
            goto L6a
        L41:
            java.lang.String r5 = "unexpected state: "
            h7.o.c(r6, r5)
            return
        L47:
            r4.m(r5, r3)
            if (r0 == 0) goto L6a
            r2.getClass()
            return
        L50:
            if (r0 == 0) goto L55
            a6.d r1 = k8.f.f5656j
            goto L57
        L55:
            a6.d r1 = k8.f.f5657k
        L57:
            boolean r6 = r4.j(r6, r5, r1)
            if (r6 == 0) goto L11
            r4.m(r5, r3)
            r6 = r0 ^ 1
            r4.l(r5, r6)
            if (r0 == 0) goto L6a
            r2.getClass()
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k8.l.g(int, r7.g):void");
    }

    public final boolean j(Object obj, int i9, Object obj2) {
        AtomicReferenceArray atomicReferenceArray;
        int i10 = (i9 * 2) + 1;
        do {
            atomicReferenceArray = this.f5673n;
            if (atomicReferenceArray.compareAndSet(i10, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceArray.get(i10) == obj);
        return false;
    }

    public final Object k(int i9) {
        return this.f5673n.get((i9 * 2) + 1);
    }

    public final void l(int i9, boolean z8) {
        if (z8) {
            d dVar = this.f5672m;
            dVar.getClass();
            dVar.B((this.f7533k * f.f5649b) + i9);
        }
        h();
    }

    public final void m(int i9, Object obj) {
        this.f5673n.lazySet(i9 * 2, obj);
    }

    public final void n(int i9, Object obj) {
        this.f5673n.set((i9 * 2) + 1, obj);
    }
}
