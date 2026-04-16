package i8;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h1 extends n8.s {

    /* renamed from: m, reason: collision with root package name */
    public final ThreadLocal f5274m;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public h1(r7.g r3, r7.c r4) {
        /*
            r2 = this;
            i8.i1 r0 = i8.i1.f5276i
            r7.e r1 = r3.h(r0)
            if (r1 != 0) goto Ld
            r7.g r0 = r3.a(r0)
            goto Le
        Ld:
            r0 = r3
        Le:
            r2.<init>(r0, r4)
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            r2.f5274m = r0
            r7.g r4 = r4.f()
            r7.d r0 = r7.d.f8614i
            r7.e r4 = r4.h(r0)
            boolean r4 = r4 instanceof i8.s
            if (r4 != 0) goto L31
            r4 = 0
            java.lang.Object r4 = n8.a.k(r3, r4)
            n8.a.f(r3, r4)
            r2.O(r3, r4)
        L31:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i8.h1.<init>(r7.g, r7.c):void");
    }

    public final boolean N() {
        boolean z8 = this.threadLocalIsSet && this.f5274m.get() == null;
        this.f5274m.remove();
        return !z8;
    }

    public final void O(r7.g gVar, Object obj) {
        this.threadLocalIsSet = true;
        this.f5274m.set(new n7.b(gVar, obj));
    }

    @Override // n8.s, i8.y0
    public final void k(Object obj) {
        if (this.threadLocalIsSet) {
            n7.b bVar = (n7.b) this.f5274m.get();
            if (bVar != null) {
                n8.a.f((r7.g) bVar.f7480i, bVar.f7481j);
            }
            this.f5274m.remove();
        }
        Object k3 = w.k(obj);
        r7.c cVar = this.f7531l;
        r7.g f9 = cVar.f();
        Object k9 = n8.a.k(f9, null);
        h1 p5 = k9 != n8.a.f7497f ? w.p(cVar, f9, k9) : null;
        try {
            this.f7531l.g(k3);
            if (p5 == null || p5.N()) {
                n8.a.f(f9, k9);
            }
        } catch (Throwable th) {
            if (p5 == null || p5.N()) {
                n8.a.f(f9, k9);
            }
            throw th;
        }
    }
}
