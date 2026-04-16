package w;

import d2.w;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g extends i {
    public float A0;
    public float B0;
    public int C0;
    public int D0;
    public int E0;
    public int F0;
    public int G0;
    public int H0;
    public int I0;
    public ArrayList J0;
    public d[] K0;
    public d[] L0;
    public int[] M0;
    public d[] N0;
    public int O0;

    /* renamed from: f0, reason: collision with root package name */
    public int f9674f0;

    /* renamed from: g0, reason: collision with root package name */
    public int f9675g0;

    /* renamed from: h0, reason: collision with root package name */
    public int f9676h0;
    public int i0;

    /* renamed from: j0, reason: collision with root package name */
    public int f9677j0;

    /* renamed from: k0, reason: collision with root package name */
    public int f9678k0;

    /* renamed from: l0, reason: collision with root package name */
    public boolean f9679l0;

    /* renamed from: m0, reason: collision with root package name */
    public int f9680m0;

    /* renamed from: n0, reason: collision with root package name */
    public int f9681n0;

    /* renamed from: o0, reason: collision with root package name */
    public x.b f9682o0;

    /* renamed from: p0, reason: collision with root package name */
    public w f9683p0;

    /* renamed from: q0, reason: collision with root package name */
    public int f9684q0;

    /* renamed from: r0, reason: collision with root package name */
    public int f9685r0;

    /* renamed from: s0, reason: collision with root package name */
    public int f9686s0;

    /* renamed from: t0, reason: collision with root package name */
    public int f9687t0;

    /* renamed from: u0, reason: collision with root package name */
    public int f9688u0;

    /* renamed from: v0, reason: collision with root package name */
    public int f9689v0;

    /* renamed from: w0, reason: collision with root package name */
    public float f9690w0;

    /* renamed from: x0, reason: collision with root package name */
    public float f9691x0;

    /* renamed from: y0, reason: collision with root package name */
    public float f9692y0;

    /* renamed from: z0, reason: collision with root package name */
    public float f9693z0;

    @Override // w.i
    public final void B() {
        for (int i9 = 0; i9 < this.f9700e0; i9++) {
            d dVar = this.f9699d0[i9];
        }
    }

    public final int C(d dVar, int i9) {
        d dVar2;
        if (dVar != null) {
            int[] iArr = dVar.f9620c0;
            if (iArr[1] == 3) {
                int i10 = dVar.f9627k;
                if (i10 != 0) {
                    if (i10 == 2) {
                        int i11 = (int) (dVar.f9634r * i9);
                        if (i11 != dVar.i()) {
                            E(iArr[0], dVar.l(), 1, i11, dVar);
                        }
                        return i11;
                    }
                    dVar2 = dVar;
                    if (i10 == 1) {
                        return dVar2.i();
                    }
                    if (i10 == 3) {
                        return (int) ((dVar2.l() * dVar2.L) + 0.5f);
                    }
                }
            } else {
                dVar2 = dVar;
            }
            return dVar2.i();
        }
        return 0;
    }

    public final int D(d dVar, int i9) {
        d dVar2;
        if (dVar != null) {
            int[] iArr = dVar.f9620c0;
            if (iArr[0] == 3) {
                int i10 = dVar.f9626j;
                if (i10 != 0) {
                    if (i10 == 2) {
                        int i11 = (int) (dVar.f9631o * i9);
                        if (i11 != dVar.l()) {
                            E(1, i11, iArr[1], dVar.i(), dVar);
                        }
                        return i11;
                    }
                    dVar2 = dVar;
                    if (i10 == 1) {
                        return dVar2.l();
                    }
                    if (i10 == 3) {
                        return (int) ((dVar2.i() * dVar2.L) + 0.5f);
                    }
                }
            } else {
                dVar2 = dVar;
            }
            return dVar2.l();
        }
        return 0;
    }

    public final void E(int i9, int i10, int i11, int i12, d dVar) {
        w wVar;
        d dVar2;
        x.b bVar = this.f9682o0;
        while (true) {
            wVar = this.f9683p0;
            if (wVar != null || (dVar2 = this.I) == null) {
                break;
            } else {
                this.f9683p0 = ((e) dVar2).f9646g0;
            }
        }
        bVar.f9974a = i9;
        bVar.f9975b = i11;
        bVar.f9976c = i10;
        bVar.f9977d = i12;
        wVar.a(dVar, bVar);
        dVar.y(bVar.f9978e);
        dVar.v(bVar.f9979f);
        dVar.f9639w = bVar.h;
        int i13 = bVar.f9980g;
        dVar.P = i13;
        dVar.f9639w = i13 > 0;
    }

    @Override // w.d
    public final void a(v.e eVar) {
        d dVar;
        ArrayList arrayList = this.J0;
        super.a(eVar);
        d dVar2 = this.I;
        boolean z8 = dVar2 != null ? ((e) dVar2).f9647h0 : false;
        int i9 = this.G0;
        if (i9 != 0) {
            if (i9 == 1) {
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    ((f) arrayList.get(i10)).b(i10, z8, i10 == size + (-1));
                    i10++;
                }
            } else if (i9 == 2 && this.M0 != null && this.L0 != null && this.K0 != null) {
                for (int i11 = 0; i11 < this.O0; i11++) {
                    this.N0[i11].t();
                }
                int[] iArr = this.M0;
                int i12 = iArr[0];
                int i13 = iArr[1];
                d dVar3 = null;
                for (int i14 = 0; i14 < i12; i14++) {
                    d dVar4 = this.L0[z8 ? (i12 - i14) - 1 : i14];
                    if (dVar4 != null) {
                        c cVar = dVar4.f9640x;
                        if (dVar4.V != 8) {
                            if (i14 == 0) {
                                dVar4.e(cVar, this.f9640x, this.f9677j0);
                                dVar4.X = this.f9684q0;
                                dVar4.S = this.f9690w0;
                            }
                            if (i14 == i12 - 1) {
                                dVar4.e(dVar4.f9642z, this.f9642z, this.f9678k0);
                            }
                            if (i14 > 0) {
                                dVar4.e(cVar, dVar3.f9642z, this.C0);
                                dVar3.e(dVar3.f9642z, cVar, 0);
                            }
                            dVar3 = dVar4;
                        }
                    }
                }
                for (int i15 = 0; i15 < i13; i15++) {
                    d dVar5 = this.K0[i15];
                    if (dVar5 != null) {
                        c cVar2 = dVar5.f9641y;
                        if (dVar5.V != 8) {
                            if (i15 == 0) {
                                dVar5.e(cVar2, this.f9641y, this.f9674f0);
                                dVar5.Y = this.f9685r0;
                                dVar5.T = this.f9691x0;
                            }
                            if (i15 == i13 - 1) {
                                dVar5.e(dVar5.A, this.A, this.f9675g0);
                            }
                            if (i15 > 0) {
                                dVar5.e(cVar2, dVar3.A, this.D0);
                                dVar3.e(dVar3.A, cVar2, 0);
                            }
                            dVar3 = dVar5;
                        }
                    }
                }
                for (int i16 = 0; i16 < i12; i16++) {
                    for (int i17 = 0; i17 < i13; i17++) {
                        int i18 = (i17 * i12) + i16;
                        if (this.I0 == 1) {
                            i18 = (i16 * i13) + i17;
                        }
                        d[] dVarArr = this.N0;
                        if (i18 < dVarArr.length && (dVar = dVarArr[i18]) != null && dVar.V != 8) {
                            d dVar6 = this.L0[i16];
                            d dVar7 = this.K0[i17];
                            if (dVar != dVar6) {
                                dVar.e(dVar.f9640x, dVar6.f9640x, 0);
                                dVar.e(dVar.f9642z, dVar6.f9642z, 0);
                            }
                            if (dVar != dVar7) {
                                dVar.e(dVar.f9641y, dVar7.f9641y, 0);
                                dVar.e(dVar.A, dVar7.A, 0);
                            }
                        }
                    }
                }
            }
        } else if (arrayList.size() > 0) {
            ((f) arrayList.get(0)).b(0, z8, true);
        }
        this.f9679l0 = false;
    }
}
