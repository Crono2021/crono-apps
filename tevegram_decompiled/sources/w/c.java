package w;

import java.util.HashSet;
import java.util.Iterator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    public final d f9609b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9610c;

    /* renamed from: d, reason: collision with root package name */
    public c f9611d;

    /* renamed from: g, reason: collision with root package name */
    public v.i f9614g;

    /* renamed from: a, reason: collision with root package name */
    public HashSet f9608a = null;

    /* renamed from: e, reason: collision with root package name */
    public int f9612e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f9613f = -1;

    public c(d dVar, int i9) {
        this.f9609b = dVar;
        this.f9610c = i9;
    }

    public final void a(c cVar, int i9) {
        b(cVar, i9, -1, false);
    }

    public final boolean b(c cVar, int i9, int i10, boolean z8) {
        if (cVar == null) {
            h();
            return true;
        }
        if (!z8 && !g(cVar)) {
            return false;
        }
        this.f9611d = cVar;
        if (cVar.f9608a == null) {
            cVar.f9608a = new HashSet();
        }
        this.f9611d.f9608a.add(this);
        if (i9 > 0) {
            this.f9612e = i9;
        } else {
            this.f9612e = 0;
        }
        this.f9613f = i10;
        return true;
    }

    public final int c() {
        c cVar;
        if (this.f9609b.V == 8) {
            return 0;
        }
        int i9 = this.f9613f;
        return (i9 <= -1 || (cVar = this.f9611d) == null || cVar.f9609b.V != 8) ? this.f9612e : i9;
    }

    public final c d() {
        int i9 = this.f9610c;
        int a9 = v.h.a(i9);
        d dVar = this.f9609b;
        switch (a9) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
                return dVar.f9642z;
            case 2:
                return dVar.A;
            case 3:
                return dVar.f9640x;
            case 4:
                return dVar.f9641y;
            default:
                m7.c.e(t.a.e(i9));
                return null;
        }
    }

    public final boolean e() {
        HashSet hashSet = this.f9608a;
        if (hashSet == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((c) it.next()).d().f()) {
                return true;
            }
        }
        return false;
    }

    public final boolean f() {
        return this.f9611d != null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:10:0x005c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(w.c r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 != 0) goto L4
            goto L5e
        L4:
            w.d r1 = r9.f9609b
            int r9 = r9.f9610c
            r2 = 6
            int r3 = r8.f9610c
            r4 = 1
            if (r9 != r3) goto L1b
            if (r3 != r2) goto L5c
            boolean r9 = r1.f9639w
            if (r9 == 0) goto L5e
            w.d r9 = r8.f9609b
            boolean r9 = r9.f9639w
            if (r9 != 0) goto L5c
            goto L5e
        L1b:
            int r5 = v.h.a(r3)
            r6 = 8
            r7 = 9
            switch(r5) {
                case 0: goto L5e;
                case 1: goto L4a;
                case 2: goto L36;
                case 3: goto L4a;
                case 4: goto L36;
                case 5: goto L5e;
                case 6: goto L2f;
                case 7: goto L5e;
                case 8: goto L5e;
                default: goto L26;
            }
        L26:
            java.lang.String r9 = t.a.e(r3)
            m7.c.e(r9)
            r9 = 0
            return r9
        L2f:
            if (r9 == r2) goto L5e
            if (r9 == r6) goto L5e
            if (r9 == r7) goto L5e
            goto L5c
        L36:
            r2 = 3
            if (r9 == r2) goto L3f
            r2 = 5
            if (r9 != r2) goto L3d
            goto L3f
        L3d:
            r2 = 0
            goto L40
        L3f:
            r2 = 1
        L40:
            boolean r1 = r1 instanceof w.h
            if (r1 == 0) goto L49
            if (r2 != 0) goto L5c
            if (r9 != r7) goto L5e
            goto L5c
        L49:
            return r2
        L4a:
            r2 = 2
            if (r9 == r2) goto L53
            r2 = 4
            if (r9 != r2) goto L51
            goto L53
        L51:
            r2 = 0
            goto L54
        L53:
            r2 = 1
        L54:
            boolean r1 = r1 instanceof w.h
            if (r1 == 0) goto L5d
            if (r2 != 0) goto L5c
            if (r9 != r6) goto L5e
        L5c:
            return r4
        L5d:
            return r2
        L5e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: w.c.g(w.c):boolean");
    }

    public final void h() {
        HashSet hashSet;
        c cVar = this.f9611d;
        if (cVar != null && (hashSet = cVar.f9608a) != null) {
            hashSet.remove(this);
        }
        this.f9611d = null;
        this.f9612e = 0;
        this.f9613f = -1;
    }

    public final void i() {
        v.i iVar = this.f9614g;
        if (iVar == null) {
            this.f9614g = new v.i(1);
        } else {
            iVar.c();
        }
    }

    public final String toString() {
        return this.f9609b.W + ":" + t.a.e(this.f9610c);
    }
}
