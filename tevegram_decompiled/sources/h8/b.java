package h8;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements Iterator {

    /* renamed from: i, reason: collision with root package name */
    public int f4219i = -1;

    /* renamed from: j, reason: collision with root package name */
    public int f4220j;

    /* renamed from: k, reason: collision with root package name */
    public int f4221k;

    /* renamed from: l, reason: collision with root package name */
    public e8.c f4222l;

    /* renamed from: m, reason: collision with root package name */
    public int f4223m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ c f4224n;

    public b(c cVar) {
        this.f4224n = cVar;
        int j5 = com.bumptech.glide.d.j(0, 0, cVar.f4225a.length());
        this.f4220j = j5;
        this.f4221k = j5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001a, code lost:
    
        if (r7 < r4) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r8 = this;
            h8.c r0 = r8.f4224n
            java.lang.CharSequence r1 = r0.f4225a
            int r2 = r8.f4221k
            r3 = 0
            if (r2 >= 0) goto Lf
            r8.f4219i = r3
            r0 = 0
            r8.f4222l = r0
            return
        Lf:
            int r4 = r0.f4226b
            r5 = -1
            r6 = 1
            if (r4 <= 0) goto L1c
            int r7 = r8.f4223m
            int r7 = r7 + r6
            r8.f4223m = r7
            if (r7 >= r4) goto L22
        L1c:
            int r4 = r1.length()
            if (r2 <= r4) goto L36
        L22:
            e8.c r0 = new e8.c
            int r2 = r8.f4220j
            r1.getClass()
            int r1 = r1.length()
            int r1 = r1 - r6
            r0.<init>(r2, r1, r6)
            r8.f4222l = r0
            r8.f4221k = r5
            goto L7b
        L36:
            h8.n r0 = r0.f4227c
            int r2 = r8.f4221k
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object r0 = r0.h(r1, r2)
            n7.b r0 = (n7.b) r0
            if (r0 != 0) goto L5a
            e8.c r0 = new e8.c
            int r2 = r8.f4220j
            r1.getClass()
            int r1 = r1.length()
            int r1 = r1 - r6
            r0.<init>(r2, r1, r6)
            r8.f4222l = r0
            r8.f4221k = r5
            goto L7b
        L5a:
            java.lang.Object r1 = r0.f7480i
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            java.lang.Object r0 = r0.f7481j
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            int r2 = r8.f4220j
            e8.c r2 = com.bumptech.glide.d.e0(r2, r1)
            r8.f4222l = r2
            int r1 = r1 + r0
            r8.f4220j = r1
            if (r0 != 0) goto L78
            r3 = 1
        L78:
            int r1 = r1 + r3
            r8.f4221k = r1
        L7b:
            r8.f4219i = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h8.b.a():void");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f4219i == -1) {
            a();
        }
        return this.f4219i == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f4219i == -1) {
            a();
        }
        if (this.f4219i == 0) {
            throw new NoSuchElementException();
        }
        e8.c cVar = this.f4222l;
        cVar.getClass();
        this.f4222l = null;
        this.f4219i = -1;
        return cVar;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
