package x;

import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k extends n {

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f10007k = new int[2];

    public static void m(int[] iArr, int i9, int i10, int i11, int i12, float f9, int i13) {
        int i14 = i10 - i9;
        int i15 = i12 - i11;
        if (i13 != -1) {
            if (i13 == 0) {
                iArr[0] = (int) ((i15 * f9) + 0.5f);
                iArr[1] = i15;
                return;
            } else {
                if (i13 != 1) {
                    return;
                }
                iArr[0] = i14;
                iArr[1] = (int) ((i14 * f9) + 0.5f);
                return;
            }
        }
        int i16 = (int) ((i15 * f9) + 0.5f);
        int i17 = (int) ((i14 / f9) + 0.5f);
        if (i16 <= i14) {
            iArr[0] = i16;
            iArr[1] = i15;
        } else if (i17 <= i15) {
            iArr[0] = i14;
            iArr[1] = i17;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:154:0x0240, code lost:
    
        if (r5 != 1) goto L125;
     */
    /* JADX WARN: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02aa  */
    @Override // x.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(x.e r24) {
        /*
            Method dump skipped, instructions count: 902
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x.k.a(x.e):void");
    }

    @Override // x.n
    public final void d() {
        w.d dVar;
        w.d dVar2;
        w.d dVar3;
        w.d dVar4;
        w.d dVar5 = this.f10013b;
        boolean z8 = dVar5.f9615a;
        h hVar = this.f10016e;
        if (z8) {
            hVar.d(dVar5.l());
        }
        boolean z9 = hVar.f10003j;
        ArrayList arrayList = hVar.f10004k;
        ArrayList arrayList2 = hVar.f10005l;
        g gVar = this.f10019i;
        g gVar2 = this.h;
        if (!z9) {
            w.d dVar6 = this.f10013b;
            int i9 = dVar6.f9620c0[0];
            this.f10015d = i9;
            if (i9 != 3) {
                if (i9 == 4 && (((dVar4 = dVar6.I) != null && dVar4.f9620c0[0] == 1) || dVar4.f9620c0[0] == 4)) {
                    int l4 = dVar4.l();
                    k kVar = dVar4.f9621d;
                    int c9 = (l4 - this.f10013b.f9640x.c()) - this.f10013b.f9642z.c();
                    n.b(gVar2, kVar.h, this.f10013b.f9640x.c());
                    n.b(gVar, kVar.f10019i, -this.f10013b.f9642z.c());
                    hVar.d(c9);
                    return;
                }
                if (i9 == 1) {
                    hVar.d(dVar6.l());
                }
            }
        } else if (this.f10015d == 4 && (((dVar2 = (dVar = this.f10013b).I) != null && dVar2.f9620c0[0] == 1) || dVar2.f9620c0[0] == 4)) {
            n.b(gVar2, dVar2.f9621d.h, dVar.f9640x.c());
            n.b(gVar, dVar2.f9621d.f10019i, -this.f10013b.f9642z.c());
            return;
        }
        if (hVar.f10003j) {
            w.d dVar7 = this.f10013b;
            if (dVar7.f9615a) {
                w.c[] cVarArr = dVar7.F;
                w.c cVar = cVarArr[0];
                w.c cVar2 = cVar.f9611d;
                if (cVar2 != null && cVarArr[1].f9611d != null) {
                    boolean q4 = dVar7.q();
                    w.d dVar8 = this.f10013b;
                    if (q4) {
                        gVar2.f10000f = dVar8.F[0].c();
                        gVar.f10000f = -this.f10013b.F[1].c();
                        return;
                    }
                    g h = n.h(dVar8.F[0]);
                    if (h != null) {
                        n.b(gVar2, h, this.f10013b.F[0].c());
                    }
                    g h9 = n.h(this.f10013b.F[1]);
                    if (h9 != null) {
                        n.b(gVar, h9, -this.f10013b.F[1].c());
                    }
                    gVar2.f9996b = true;
                    gVar.f9996b = true;
                    return;
                }
                if (cVar2 != null) {
                    g h10 = n.h(cVar);
                    if (h10 != null) {
                        n.b(gVar2, h10, this.f10013b.F[0].c());
                        n.b(gVar, gVar2, hVar.f10001g);
                        return;
                    }
                    return;
                }
                w.c cVar3 = cVarArr[1];
                if (cVar3.f9611d != null) {
                    g h11 = n.h(cVar3);
                    if (h11 != null) {
                        n.b(gVar, h11, -this.f10013b.F[1].c());
                        n.b(gVar2, gVar, -hVar.f10001g);
                        return;
                    }
                    return;
                }
                if ((dVar7 instanceof w.i) || dVar7.I == null || dVar7.g(7).f9611d != null) {
                    return;
                }
                w.d dVar9 = this.f10013b;
                n.b(gVar2, dVar9.I.f9621d.h, dVar9.m());
                n.b(gVar, gVar2, hVar.f10001g);
                return;
            }
        }
        if (this.f10015d == 3) {
            w.d dVar10 = this.f10013b;
            int i10 = dVar10.f9626j;
            m mVar = dVar10.f9622e;
            if (i10 == 2) {
                w.d dVar11 = dVar10.I;
                if (dVar11 != null) {
                    h hVar2 = dVar11.f9622e.f10016e;
                    arrayList2.add(hVar2);
                    hVar2.f10004k.add(hVar);
                    hVar.f9996b = true;
                    arrayList.add(gVar2);
                    arrayList.add(gVar);
                }
            } else if (i10 == 3) {
                if (dVar10.f9627k == 3) {
                    gVar2.f9995a = this;
                    gVar.f9995a = this;
                    mVar.h.f9995a = this;
                    mVar.f10019i.f9995a = this;
                    hVar.f9995a = this;
                    if (dVar10.r()) {
                        arrayList2.add(this.f10013b.f9622e.f10016e);
                        this.f10013b.f9622e.f10016e.f10004k.add(hVar);
                        m mVar2 = this.f10013b.f9622e;
                        mVar2.f10016e.f9995a = this;
                        arrayList2.add(mVar2.h);
                        arrayList2.add(this.f10013b.f9622e.f10019i);
                        this.f10013b.f9622e.h.f10004k.add(hVar);
                        this.f10013b.f9622e.f10019i.f10004k.add(hVar);
                    } else {
                        boolean q7 = this.f10013b.q();
                        w.d dVar12 = this.f10013b;
                        if (q7) {
                            dVar12.f9622e.f10016e.f10005l.add(hVar);
                            arrayList.add(this.f10013b.f9622e.f10016e);
                        } else {
                            dVar12.f9622e.f10016e.f10005l.add(hVar);
                        }
                    }
                } else {
                    h hVar3 = mVar.f10016e;
                    arrayList2.add(hVar3);
                    hVar3.f10004k.add(hVar);
                    this.f10013b.f9622e.h.f10004k.add(hVar);
                    this.f10013b.f9622e.f10019i.f10004k.add(hVar);
                    hVar.f9996b = true;
                    arrayList.add(gVar2);
                    arrayList.add(gVar);
                    gVar2.f10005l.add(hVar);
                    gVar.f10005l.add(hVar);
                }
            }
        }
        w.d dVar13 = this.f10013b;
        w.c[] cVarArr2 = dVar13.F;
        w.c cVar4 = cVarArr2[0];
        w.c cVar5 = cVar4.f9611d;
        if (cVar5 != null && cVarArr2[1].f9611d != null) {
            boolean q8 = dVar13.q();
            w.d dVar14 = this.f10013b;
            if (q8) {
                gVar2.f10000f = dVar14.F[0].c();
                gVar.f10000f = -this.f10013b.F[1].c();
                return;
            }
            g h12 = n.h(dVar14.F[0]);
            g h13 = n.h(this.f10013b.F[1]);
            h12.b(this);
            h13.b(this);
            this.f10020j = 4;
            return;
        }
        if (cVar5 != null) {
            g h14 = n.h(cVar4);
            if (h14 != null) {
                n.b(gVar2, h14, this.f10013b.F[0].c());
                c(gVar, gVar2, 1, hVar);
                return;
            }
            return;
        }
        w.c cVar6 = cVarArr2[1];
        if (cVar6.f9611d != null) {
            g h15 = n.h(cVar6);
            if (h15 != null) {
                n.b(gVar, h15, -this.f10013b.F[1].c());
                c(gVar2, gVar, -1, hVar);
                return;
            }
            return;
        }
        if ((dVar13 instanceof w.i) || (dVar3 = dVar13.I) == null) {
            return;
        }
        n.b(gVar2, dVar3.f9621d.h, dVar13.m());
        c(gVar, gVar2, 1, hVar);
    }

    @Override // x.n
    public final void e() {
        g gVar = this.h;
        if (gVar.f10003j) {
            this.f10013b.N = gVar.f10001g;
        }
    }

    @Override // x.n
    public final void f() {
        this.f10014c = null;
        this.h.c();
        this.f10019i.c();
        this.f10016e.c();
        this.f10018g = false;
    }

    @Override // x.n
    public final boolean k() {
        return this.f10015d != 3 || this.f10013b.f9626j == 0;
    }

    public final void n() {
        this.f10018g = false;
        g gVar = this.h;
        gVar.c();
        gVar.f10003j = false;
        g gVar2 = this.f10019i;
        gVar2.c();
        gVar2.f10003j = false;
        this.f10016e.f10003j = false;
    }

    public final String toString() {
        return "HorizontalRun " + this.f10013b.W;
    }
}
