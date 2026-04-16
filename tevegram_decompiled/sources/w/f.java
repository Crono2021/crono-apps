package w;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public int f9657a;

    /* renamed from: d, reason: collision with root package name */
    public c f9660d;

    /* renamed from: e, reason: collision with root package name */
    public c f9661e;

    /* renamed from: f, reason: collision with root package name */
    public c f9662f;

    /* renamed from: g, reason: collision with root package name */
    public c f9663g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public int f9664i;

    /* renamed from: j, reason: collision with root package name */
    public int f9665j;

    /* renamed from: k, reason: collision with root package name */
    public int f9666k;

    /* renamed from: q, reason: collision with root package name */
    public int f9672q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ g f9673r;

    /* renamed from: b, reason: collision with root package name */
    public d f9658b = null;

    /* renamed from: c, reason: collision with root package name */
    public int f9659c = 0;

    /* renamed from: l, reason: collision with root package name */
    public int f9667l = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f9668m = 0;

    /* renamed from: n, reason: collision with root package name */
    public int f9669n = 0;

    /* renamed from: o, reason: collision with root package name */
    public int f9670o = 0;

    /* renamed from: p, reason: collision with root package name */
    public int f9671p = 0;

    public f(g gVar, int i9, c cVar, c cVar2, c cVar3, c cVar4, int i10) {
        this.f9673r = gVar;
        this.h = 0;
        this.f9664i = 0;
        this.f9665j = 0;
        this.f9666k = 0;
        this.f9672q = 0;
        this.f9657a = i9;
        this.f9660d = cVar;
        this.f9661e = cVar2;
        this.f9662f = cVar3;
        this.f9663g = cVar4;
        this.h = gVar.f9677j0;
        this.f9664i = gVar.f9674f0;
        this.f9665j = gVar.f9678k0;
        this.f9666k = gVar.f9675g0;
        this.f9672q = i10;
    }

    public final void a(d dVar) {
        int i9 = this.f9657a;
        int i10 = this.f9672q;
        g gVar = this.f9673r;
        if (i9 == 0) {
            int D = gVar.D(dVar, i10);
            if (dVar.f9620c0[0] == 3) {
                this.f9671p++;
                D = 0;
            }
            this.f9667l = D + (dVar.V != 8 ? gVar.C0 : 0) + this.f9667l;
            int C = gVar.C(dVar, this.f9672q);
            if (this.f9658b == null || this.f9659c < C) {
                this.f9658b = dVar;
                this.f9659c = C;
                this.f9668m = C;
            }
        } else {
            int D2 = gVar.D(dVar, i10);
            int C2 = gVar.C(dVar, this.f9672q);
            if (dVar.f9620c0[1] == 3) {
                this.f9671p++;
                C2 = 0;
            }
            this.f9668m = C2 + (dVar.V != 8 ? gVar.D0 : 0) + this.f9668m;
            if (this.f9658b == null || this.f9659c < D2) {
                this.f9658b = dVar;
                this.f9659c = D2;
                this.f9667l = D2;
            }
        }
        this.f9670o++;
    }

    public final void b(int i9, boolean z8, boolean z9) {
        g gVar;
        int i10;
        int i11;
        d dVar;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17 = this.f9670o;
        int i18 = 0;
        while (true) {
            gVar = this.f9673r;
            if (i18 >= i17 || (i16 = this.f9669n + i18) >= gVar.O0) {
                break;
            }
            d dVar2 = gVar.N0[i16];
            if (dVar2 != null) {
                dVar2.t();
            }
            i18++;
        }
        if (i17 == 0 || this.f9658b == null) {
            return;
        }
        boolean z10 = z9 && i9 == 0;
        int i19 = -1;
        int i20 = -1;
        for (int i21 = 0; i21 < i17; i21++) {
            int i22 = this.f9669n + (z8 ? (i17 - 1) - i21 : i21);
            if (i22 >= gVar.O0) {
                break;
            }
            if (gVar.N0[i22].V == 0) {
                if (i19 == -1) {
                    i19 = i21;
                }
                i20 = i21;
            }
        }
        int i23 = this.f9657a;
        d dVar3 = this.f9658b;
        if (i23 != 0) {
            dVar3.X = gVar.f9684q0;
            c cVar = dVar3.f9640x;
            c cVar2 = dVar3.f9642z;
            int i24 = this.h;
            if (i9 > 0) {
                i24 += gVar.C0;
            }
            if (z8) {
                cVar2.a(this.f9662f, i24);
                if (z9) {
                    cVar.a(this.f9660d, this.f9665j);
                }
                if (i9 > 0) {
                    this.f9662f.f9609b.f9640x.a(cVar2, 0);
                }
            } else {
                cVar.a(this.f9660d, i24);
                if (z9) {
                    cVar2.a(this.f9662f, this.f9665j);
                }
                if (i9 > 0) {
                    this.f9660d.f9609b.f9642z.a(cVar, 0);
                }
            }
            d dVar4 = null;
            int i25 = 0;
            while (i25 < i17) {
                int i26 = this.f9669n + i25;
                if (i26 >= gVar.O0) {
                    return;
                }
                d dVar5 = gVar.N0[i26];
                if (i25 == 0) {
                    dVar5.e(dVar5.f9641y, this.f9661e, this.f9664i);
                    int i27 = gVar.f9685r0;
                    float f9 = gVar.f9691x0;
                    if (this.f9669n == 0) {
                        i11 = gVar.f9687t0;
                        i10 = -1;
                        if (i11 != -1) {
                            f9 = gVar.f9693z0;
                            i27 = i11;
                            dVar5.Y = i27;
                            dVar5.T = f9;
                        }
                    } else {
                        i10 = -1;
                    }
                    if (z9 && (i11 = gVar.f9689v0) != i10) {
                        f9 = gVar.B0;
                        i27 = i11;
                    }
                    dVar5.Y = i27;
                    dVar5.T = f9;
                }
                if (i25 == i17 - 1) {
                    dVar5.e(dVar5.A, this.f9663g, this.f9666k);
                }
                if (dVar4 != null) {
                    c cVar3 = dVar4.A;
                    c cVar4 = dVar5.f9641y;
                    cVar4.a(cVar3, gVar.D0);
                    if (i25 == i19) {
                        int i28 = this.f9664i;
                        if (cVar4.f()) {
                            cVar4.f9613f = i28;
                        }
                    }
                    cVar3.a(cVar4, 0);
                    if (i25 == i20 + 1) {
                        int i29 = this.f9666k;
                        if (cVar3.f()) {
                            cVar3.f9613f = i29;
                        }
                    }
                }
                if (dVar5 != dVar3) {
                    int i30 = gVar.E0;
                    if (!z8) {
                        if (i30 == 0) {
                            dVar5.f9640x.a(cVar, 0);
                        } else if (i30 == 1) {
                            dVar5.f9642z.a(cVar2, 0);
                        } else if (i30 == 2) {
                            if (z10) {
                                dVar5.f9640x.a(this.f9660d, this.h);
                                dVar5.f9642z.a(this.f9662f, this.f9665j);
                            } else {
                                dVar5.f9640x.a(cVar, 0);
                                dVar5.f9642z.a(cVar2, 0);
                            }
                        }
                        i25++;
                        dVar4 = dVar5;
                    } else if (i30 == 0) {
                        dVar5.f9642z.a(cVar2, 0);
                    } else if (i30 == 1) {
                        dVar5.f9640x.a(cVar, 0);
                    } else if (i30 == 2) {
                        dVar5.f9640x.a(cVar, 0);
                        dVar5.f9642z.a(cVar2, 0);
                    }
                }
                i25++;
                dVar4 = dVar5;
            }
            return;
        }
        dVar3.Y = gVar.f9685r0;
        c cVar5 = dVar3.A;
        c cVar6 = dVar3.f9641y;
        int i31 = this.f9664i;
        if (i9 > 0) {
            i31 += gVar.D0;
        }
        cVar6.a(this.f9661e, i31);
        if (z9) {
            cVar5.a(this.f9663g, this.f9666k);
        }
        if (i9 > 0) {
            this.f9661e.f9609b.A.a(cVar6, 0);
        }
        if (gVar.F0 == 3 && !dVar3.f9639w) {
            for (int i32 = 0; i32 < i17; i32++) {
                int i33 = this.f9669n + (z8 ? (i17 - 1) - i32 : i32);
                if (i33 >= gVar.O0) {
                    break;
                }
                dVar = gVar.N0[i33];
                if (dVar.f9639w) {
                    break;
                }
            }
        }
        dVar = dVar3;
        d dVar6 = null;
        int i34 = 0;
        while (i34 < i17) {
            int i35 = z8 ? (i17 - 1) - i34 : i34;
            int i36 = this.f9669n + i35;
            if (i36 >= gVar.O0) {
                return;
            }
            d dVar7 = gVar.N0[i36];
            if (i34 == 0) {
                dVar7.e(dVar7.f9640x, this.f9660d, this.h);
            }
            if (i35 == 0) {
                int i37 = gVar.f9684q0;
                float f10 = gVar.f9690w0;
                if (this.f9669n == 0) {
                    i15 = gVar.f9686s0;
                    i12 = i37;
                    i13 = -1;
                    if (i15 != -1) {
                        f10 = gVar.f9692y0;
                        i14 = i15;
                        dVar7.X = i14;
                        dVar7.S = f10;
                    }
                } else {
                    i12 = i37;
                    i13 = -1;
                }
                if (!z9 || (i15 = gVar.f9688u0) == i13) {
                    i14 = i12;
                    dVar7.X = i14;
                    dVar7.S = f10;
                } else {
                    f10 = gVar.A0;
                    i14 = i15;
                    dVar7.X = i14;
                    dVar7.S = f10;
                }
            }
            if (i34 == i17 - 1) {
                dVar7.e(dVar7.f9642z, this.f9662f, this.f9665j);
            }
            if (dVar6 != null) {
                c cVar7 = dVar6.f9642z;
                c cVar8 = dVar7.f9640x;
                cVar8.a(cVar7, gVar.C0);
                if (i34 == i19) {
                    int i38 = this.h;
                    if (cVar8.f()) {
                        cVar8.f9613f = i38;
                    }
                }
                cVar7.a(cVar8, 0);
                if (i34 == i20 + 1) {
                    int i39 = this.f9665j;
                    if (cVar7.f()) {
                        cVar7.f9613f = i39;
                    }
                }
            }
            if (dVar7 != dVar3) {
                int i40 = gVar.F0;
                if (i40 == 3 && dVar.f9639w && dVar7 != dVar && dVar7.f9639w) {
                    dVar7.B.a(dVar.B, 0);
                } else if (i40 == 0) {
                    dVar7.f9641y.a(cVar6, 0);
                } else if (i40 == 1) {
                    dVar7.A.a(cVar5, 0);
                } else if (z10) {
                    dVar7.f9641y.a(this.f9661e, this.f9664i);
                    dVar7.A.a(this.f9663g, this.f9666k);
                } else {
                    dVar7.f9641y.a(cVar6, 0);
                    dVar7.A.a(cVar5, 0);
                }
            }
            i34++;
            dVar6 = dVar7;
        }
    }

    public final int c() {
        int i9 = this.f9657a;
        int i10 = this.f9668m;
        return i9 == 1 ? i10 - this.f9673r.D0 : i10;
    }

    public final int d() {
        int i9 = this.f9657a;
        int i10 = this.f9667l;
        return i9 == 0 ? i10 - this.f9673r.C0 : i10;
    }

    public final void e(int i9) {
        g gVar;
        int i10;
        int i11 = this.f9671p;
        if (i11 == 0) {
            return;
        }
        int i12 = this.f9670o;
        int i13 = i9 / i11;
        int i14 = 0;
        while (true) {
            gVar = this.f9673r;
            if (i14 >= i12 || (i10 = this.f9669n + i14) >= gVar.O0) {
                break;
            }
            d dVar = gVar.N0[i10];
            if (this.f9657a == 0) {
                if (dVar != null) {
                    int[] iArr = dVar.f9620c0;
                    if (iArr[0] == 3 && dVar.f9626j == 0) {
                        gVar.E(1, i13, iArr[1], dVar.i(), dVar);
                    }
                }
            } else if (dVar != null) {
                int[] iArr2 = dVar.f9620c0;
                if (iArr2[1] == 3 && dVar.f9627k == 0) {
                    int i15 = i13;
                    gVar.E(iArr2[0], dVar.l(), 1, i15, dVar);
                    i13 = i15;
                }
            }
            i14++;
        }
        this.f9667l = 0;
        this.f9668m = 0;
        this.f9658b = null;
        this.f9659c = 0;
        int i16 = this.f9670o;
        for (int i17 = 0; i17 < i16; i17++) {
            int i18 = this.f9669n + i17;
            if (i18 >= gVar.O0) {
                return;
            }
            d dVar2 = gVar.N0[i18];
            if (this.f9657a == 0) {
                int l4 = dVar2.l();
                int i19 = gVar.C0;
                if (dVar2.V == 8) {
                    i19 = 0;
                }
                this.f9667l = l4 + i19 + this.f9667l;
                int C = gVar.C(dVar2, this.f9672q);
                if (this.f9658b == null || this.f9659c < C) {
                    this.f9658b = dVar2;
                    this.f9659c = C;
                    this.f9668m = C;
                }
            } else {
                int D = gVar.D(dVar2, this.f9672q);
                int C2 = gVar.C(dVar2, this.f9672q);
                int i20 = gVar.D0;
                if (dVar2.V == 8) {
                    i20 = 0;
                }
                this.f9668m = C2 + i20 + this.f9668m;
                if (this.f9658b == null || this.f9659c < D) {
                    this.f9658b = dVar2;
                    this.f9659c = D;
                    this.f9667l = D;
                }
            }
        }
    }

    public final void f(int i9, c cVar, c cVar2, c cVar3, c cVar4, int i10, int i11, int i12, int i13, int i14) {
        this.f9657a = i9;
        this.f9660d = cVar;
        this.f9661e = cVar2;
        this.f9662f = cVar3;
        this.f9663g = cVar4;
        this.h = i10;
        this.f9664i = i11;
        this.f9665j = i12;
        this.f9666k = i13;
        this.f9672q = i14;
    }
}
