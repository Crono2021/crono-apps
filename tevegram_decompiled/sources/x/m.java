package x;

import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class m extends n {

    /* renamed from: k, reason: collision with root package name */
    public g f10010k;

    /* renamed from: l, reason: collision with root package name */
    public a f10011l;

    @Override // x.e
    public final void a(e eVar) {
        float f9;
        float f10;
        float f11;
        int i9;
        if (v.h.a(this.f10020j) == 3) {
            w.d dVar = this.f10013b;
            l(dVar.f9641y, dVar.A, 1);
            return;
        }
        h hVar = this.f10016e;
        if (hVar.f9997c && !hVar.f10003j && this.f10015d == 3) {
            w.d dVar2 = this.f10013b;
            int i10 = dVar2.f9627k;
            if (i10 == 2) {
                w.d dVar3 = dVar2.I;
                if (dVar3 != null) {
                    if (dVar3.f9622e.f10016e.f10003j) {
                        hVar.d((int) ((r5.f10001g * dVar2.f9634r) + 0.5f));
                    }
                }
            } else if (i10 == 3) {
                h hVar2 = dVar2.f9621d.f10016e;
                if (hVar2.f10003j) {
                    int i11 = dVar2.M;
                    if (i11 == -1) {
                        f9 = hVar2.f10001g;
                        f10 = dVar2.L;
                    } else if (i11 == 0) {
                        f11 = hVar2.f10001g * dVar2.L;
                        i9 = (int) (f11 + 0.5f);
                        hVar.d(i9);
                    } else if (i11 != 1) {
                        i9 = 0;
                        hVar.d(i9);
                    } else {
                        f9 = hVar2.f10001g;
                        f10 = dVar2.L;
                    }
                    f11 = f9 / f10;
                    i9 = (int) (f11 + 0.5f);
                    hVar.d(i9);
                }
            }
        }
        g gVar = this.h;
        boolean z8 = gVar.f9997c;
        ArrayList arrayList = gVar.f10005l;
        if (z8) {
            g gVar2 = this.f10019i;
            boolean z9 = gVar2.f9997c;
            ArrayList arrayList2 = gVar2.f10005l;
            if (z9) {
                if (gVar.f10003j && gVar2.f10003j && hVar.f10003j) {
                    return;
                }
                if (!hVar.f10003j && this.f10015d == 3) {
                    w.d dVar4 = this.f10013b;
                    if (dVar4.f9626j == 0 && !dVar4.r()) {
                        g gVar3 = (g) arrayList.get(0);
                        g gVar4 = (g) arrayList2.get(0);
                        int i12 = gVar3.f10001g + gVar.f10000f;
                        int i13 = gVar4.f10001g + gVar2.f10000f;
                        gVar.d(i12);
                        gVar2.d(i13);
                        hVar.d(i13 - i12);
                        return;
                    }
                }
                if (!hVar.f10003j && this.f10015d == 3 && this.f10012a == 1 && arrayList.size() > 0 && arrayList2.size() > 0) {
                    g gVar5 = (g) arrayList.get(0);
                    int i14 = (((g) arrayList2.get(0)).f10001g + gVar2.f10000f) - (gVar5.f10001g + gVar.f10000f);
                    int i15 = hVar.f10006m;
                    if (i14 < i15) {
                        hVar.d(i14);
                    } else {
                        hVar.d(i15);
                    }
                }
                if (hVar.f10003j && arrayList.size() > 0 && arrayList2.size() > 0) {
                    g gVar6 = (g) arrayList.get(0);
                    g gVar7 = (g) arrayList2.get(0);
                    int i16 = gVar6.f10001g;
                    int i17 = gVar.f10000f + i16;
                    int i18 = gVar7.f10001g;
                    int i19 = gVar2.f10000f + i18;
                    float f12 = this.f10013b.T;
                    if (gVar6 == gVar7) {
                        f12 = 0.5f;
                    } else {
                        i16 = i17;
                        i18 = i19;
                    }
                    gVar.d((int) ((((i18 - i16) - hVar.f10001g) * f12) + i16 + 0.5f));
                    gVar2.d(gVar.f10001g + hVar.f10001g);
                }
            }
        }
    }

    @Override // x.n
    public final void d() {
        w.d dVar;
        w.d dVar2;
        w.d dVar3;
        w.d dVar4;
        g gVar = this.f10010k;
        w.d dVar5 = this.f10013b;
        boolean z8 = dVar5.f9615a;
        h hVar = this.f10016e;
        if (z8) {
            hVar.d(dVar5.i());
        }
        boolean z9 = hVar.f10003j;
        ArrayList arrayList = hVar.f10004k;
        ArrayList arrayList2 = hVar.f10005l;
        g gVar2 = this.f10019i;
        g gVar3 = this.h;
        if (!z9) {
            w.d dVar6 = this.f10013b;
            this.f10015d = dVar6.f9620c0[1];
            if (dVar6.f9639w) {
                this.f10011l = new a(this);
            }
            int i9 = this.f10015d;
            if (i9 != 3) {
                if (i9 == 4 && (dVar4 = this.f10013b.I) != null) {
                    m mVar = dVar4.f9622e;
                    if (dVar4.f9620c0[1] == 1) {
                        int i10 = (dVar4.i() - this.f10013b.f9641y.c()) - this.f10013b.A.c();
                        n.b(gVar3, mVar.h, this.f10013b.f9641y.c());
                        n.b(gVar2, mVar.f10019i, -this.f10013b.A.c());
                        hVar.d(i10);
                        return;
                    }
                }
                if (i9 == 1) {
                    hVar.d(this.f10013b.i());
                }
            }
        } else if (this.f10015d == 4 && (dVar2 = (dVar = this.f10013b).I) != null) {
            m mVar2 = dVar2.f9622e;
            if (dVar2.f9620c0[1] == 1) {
                n.b(gVar3, mVar2.h, dVar.f9641y.c());
                n.b(gVar2, mVar2.f10019i, -this.f10013b.A.c());
                return;
            }
        }
        boolean z10 = hVar.f10003j;
        if (z10) {
            w.d dVar7 = this.f10013b;
            if (dVar7.f9615a) {
                w.c[] cVarArr = dVar7.F;
                w.c cVar = cVarArr[2];
                w.c cVar2 = cVar.f9611d;
                if (cVar2 != null && cVarArr[3].f9611d != null) {
                    boolean r8 = dVar7.r();
                    w.d dVar8 = this.f10013b;
                    if (r8) {
                        gVar3.f10000f = dVar8.F[2].c();
                        gVar2.f10000f = -this.f10013b.F[3].c();
                    } else {
                        g h = n.h(dVar8.F[2]);
                        if (h != null) {
                            n.b(gVar3, h, this.f10013b.F[2].c());
                        }
                        g h9 = n.h(this.f10013b.F[3]);
                        if (h9 != null) {
                            n.b(gVar2, h9, -this.f10013b.F[3].c());
                        }
                        gVar3.f9996b = true;
                        gVar2.f9996b = true;
                    }
                    w.d dVar9 = this.f10013b;
                    if (dVar9.f9639w) {
                        n.b(gVar, gVar3, dVar9.P);
                        return;
                    }
                    return;
                }
                if (cVar2 != null) {
                    g h10 = n.h(cVar);
                    if (h10 != null) {
                        n.b(gVar3, h10, this.f10013b.F[2].c());
                        n.b(gVar2, gVar3, hVar.f10001g);
                        w.d dVar10 = this.f10013b;
                        if (dVar10.f9639w) {
                            n.b(gVar, gVar3, dVar10.P);
                            return;
                        }
                        return;
                    }
                    return;
                }
                w.c cVar3 = cVarArr[3];
                if (cVar3.f9611d != null) {
                    g h11 = n.h(cVar3);
                    if (h11 != null) {
                        n.b(gVar2, h11, -this.f10013b.F[3].c());
                        n.b(gVar3, gVar2, -hVar.f10001g);
                    }
                    w.d dVar11 = this.f10013b;
                    if (dVar11.f9639w) {
                        n.b(gVar, gVar3, dVar11.P);
                        return;
                    }
                    return;
                }
                w.c cVar4 = cVarArr[4];
                if (cVar4.f9611d != null) {
                    g h12 = n.h(cVar4);
                    if (h12 != null) {
                        n.b(gVar, h12, 0);
                        n.b(gVar3, gVar, -this.f10013b.P);
                        n.b(gVar2, gVar3, hVar.f10001g);
                        return;
                    }
                    return;
                }
                if ((dVar7 instanceof w.i) || dVar7.I == null || dVar7.g(7).f9611d != null) {
                    return;
                }
                w.d dVar12 = this.f10013b;
                n.b(gVar3, dVar12.I.f9622e.h, dVar12.n());
                n.b(gVar2, gVar3, hVar.f10001g);
                w.d dVar13 = this.f10013b;
                if (dVar13.f9639w) {
                    n.b(gVar, gVar3, dVar13.P);
                    return;
                }
                return;
            }
        }
        if (z10 || this.f10015d != 3) {
            hVar.b(this);
        } else {
            w.d dVar14 = this.f10013b;
            int i11 = dVar14.f9627k;
            if (i11 == 2) {
                w.d dVar15 = dVar14.I;
                if (dVar15 != null) {
                    h hVar2 = dVar15.f9622e.f10016e;
                    arrayList2.add(hVar2);
                    hVar2.f10004k.add(hVar);
                    hVar.f9996b = true;
                    arrayList.add(gVar3);
                    arrayList.add(gVar2);
                }
            } else if (i11 == 3 && !dVar14.r()) {
                w.d dVar16 = this.f10013b;
                if (dVar16.f9626j != 3) {
                    h hVar3 = dVar16.f9621d.f10016e;
                    arrayList2.add(hVar3);
                    hVar3.f10004k.add(hVar);
                    hVar.f9996b = true;
                    arrayList.add(gVar3);
                    arrayList.add(gVar2);
                }
            }
        }
        w.d dVar17 = this.f10013b;
        w.c[] cVarArr2 = dVar17.F;
        w.c cVar5 = cVarArr2[2];
        w.c cVar6 = cVar5.f9611d;
        if (cVar6 != null && cVarArr2[3].f9611d != null) {
            boolean r9 = dVar17.r();
            w.d dVar18 = this.f10013b;
            if (r9) {
                gVar3.f10000f = dVar18.F[2].c();
                gVar2.f10000f = -this.f10013b.F[3].c();
            } else {
                g h13 = n.h(dVar18.F[2]);
                g h14 = n.h(this.f10013b.F[3]);
                h13.b(this);
                h14.b(this);
                this.f10020j = 4;
            }
            if (this.f10013b.f9639w) {
                c(gVar, gVar3, 1, this.f10011l);
            }
        } else if (cVar6 != null) {
            g h15 = n.h(cVar5);
            if (h15 != null) {
                n.b(gVar3, h15, this.f10013b.F[2].c());
                c(gVar2, gVar3, 1, hVar);
                if (this.f10013b.f9639w) {
                    c(gVar, gVar3, 1, this.f10011l);
                }
                if (this.f10015d == 3) {
                    w.d dVar19 = this.f10013b;
                    if (dVar19.L > 0.0f) {
                        k kVar = dVar19.f9621d;
                        if (kVar.f10015d == 3) {
                            kVar.f10016e.f10004k.add(hVar);
                            arrayList2.add(this.f10013b.f9621d.f10016e);
                            hVar.f9995a = this;
                        }
                    }
                }
            }
        } else {
            w.c cVar7 = cVarArr2[3];
            if (cVar7.f9611d != null) {
                g h16 = n.h(cVar7);
                if (h16 != null) {
                    n.b(gVar2, h16, -this.f10013b.F[3].c());
                    c(gVar3, gVar2, -1, hVar);
                    if (this.f10013b.f9639w) {
                        c(gVar, gVar3, 1, this.f10011l);
                    }
                }
            } else {
                w.c cVar8 = cVarArr2[4];
                if (cVar8.f9611d != null) {
                    g h17 = n.h(cVar8);
                    if (h17 != null) {
                        n.b(gVar, h17, 0);
                        c(gVar3, gVar, -1, this.f10011l);
                        c(gVar2, gVar3, 1, hVar);
                    }
                } else if (!(dVar17 instanceof w.i) && (dVar3 = dVar17.I) != null) {
                    n.b(gVar3, dVar3.f9622e.h, dVar17.n());
                    c(gVar2, gVar3, 1, hVar);
                    if (this.f10013b.f9639w) {
                        c(gVar, gVar3, 1, this.f10011l);
                    }
                    if (this.f10015d == 3) {
                        w.d dVar20 = this.f10013b;
                        if (dVar20.L > 0.0f) {
                            k kVar2 = dVar20.f9621d;
                            if (kVar2.f10015d == 3) {
                                kVar2.f10016e.f10004k.add(hVar);
                                arrayList2.add(this.f10013b.f9621d.f10016e);
                                hVar.f9995a = this;
                            }
                        }
                    }
                }
            }
        }
        if (arrayList2.size() == 0) {
            hVar.f9997c = true;
        }
    }

    @Override // x.n
    public final void e() {
        g gVar = this.h;
        if (gVar.f10003j) {
            this.f10013b.O = gVar.f10001g;
        }
    }

    @Override // x.n
    public final void f() {
        this.f10014c = null;
        this.h.c();
        this.f10019i.c();
        this.f10010k.c();
        this.f10016e.c();
        this.f10018g = false;
    }

    @Override // x.n
    public final boolean k() {
        return this.f10015d != 3 || this.f10013b.f9627k == 0;
    }

    public final void m() {
        this.f10018g = false;
        g gVar = this.h;
        gVar.c();
        gVar.f10003j = false;
        g gVar2 = this.f10019i;
        gVar2.c();
        gVar2.f10003j = false;
        g gVar3 = this.f10010k;
        gVar3.c();
        gVar3.f10003j = false;
        this.f10016e.f10003j = false;
    }

    public final String toString() {
        return "VerticalRun " + this.f10013b.W;
    }
}
