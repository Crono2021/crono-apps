package w;

import a0.l;
import d2.w;
import java.util.ArrayList;
import java.util.Arrays;
import x.k;
import x.m;
import x.n;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e extends d {

    /* renamed from: d0, reason: collision with root package name */
    public ArrayList f9643d0 = new ArrayList();

    /* renamed from: e0, reason: collision with root package name */
    public final x.c f9644e0 = new x.c(this);

    /* renamed from: f0, reason: collision with root package name */
    public final x.f f9645f0;

    /* renamed from: g0, reason: collision with root package name */
    public w f9646g0;

    /* renamed from: h0, reason: collision with root package name */
    public boolean f9647h0;
    public final v.e i0;

    /* renamed from: j0, reason: collision with root package name */
    public int f9648j0;

    /* renamed from: k0, reason: collision with root package name */
    public int f9649k0;

    /* renamed from: l0, reason: collision with root package name */
    public int f9650l0;

    /* renamed from: m0, reason: collision with root package name */
    public int f9651m0;

    /* renamed from: n0, reason: collision with root package name */
    public b[] f9652n0;

    /* renamed from: o0, reason: collision with root package name */
    public b[] f9653o0;

    /* renamed from: p0, reason: collision with root package name */
    public int f9654p0;

    /* renamed from: q0, reason: collision with root package name */
    public boolean f9655q0;

    /* renamed from: r0, reason: collision with root package name */
    public boolean f9656r0;

    public e() {
        x.f fVar = new x.f();
        fVar.f9989b = true;
        fVar.f9990c = true;
        fVar.f9992e = new ArrayList();
        new ArrayList();
        fVar.f9993f = null;
        fVar.f9994g = new x.b();
        fVar.h = new ArrayList();
        fVar.f9988a = this;
        fVar.f9991d = this;
        this.f9645f0 = fVar;
        this.f9646g0 = null;
        this.f9647h0 = false;
        this.i0 = new v.e();
        this.f9650l0 = 0;
        this.f9651m0 = 0;
        this.f9652n0 = new b[4];
        this.f9653o0 = new b[4];
        this.f9654p0 = 263;
        this.f9655q0 = false;
        this.f9656r0 = false;
    }

    public final void B(d dVar, int i9) {
        if (i9 == 0) {
            int i10 = this.f9650l0 + 1;
            b[] bVarArr = this.f9653o0;
            if (i10 >= bVarArr.length) {
                this.f9653o0 = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
            }
            b[] bVarArr2 = this.f9653o0;
            int i11 = this.f9650l0;
            bVarArr2[i11] = new b(dVar, 0, this.f9647h0);
            this.f9650l0 = i11 + 1;
            return;
        }
        if (i9 == 1) {
            int i12 = this.f9651m0 + 1;
            b[] bVarArr3 = this.f9652n0;
            if (i12 >= bVarArr3.length) {
                this.f9652n0 = (b[]) Arrays.copyOf(bVarArr3, bVarArr3.length * 2);
            }
            b[] bVarArr4 = this.f9652n0;
            int i13 = this.f9651m0;
            bVarArr4[i13] = new b(dVar, 1, this.f9647h0);
            this.f9651m0 = i13 + 1;
        }
    }

    public final void C(v.e eVar) {
        int i9;
        a(eVar);
        int size = this.f9643d0.size();
        char c9 = 0;
        int i10 = 0;
        boolean z8 = false;
        while (true) {
            i9 = 1;
            if (i10 >= size) {
                break;
            }
            d dVar = (d) this.f9643d0.get(i10);
            boolean[] zArr = dVar.H;
            zArr[0] = false;
            zArr[1] = false;
            if (dVar instanceof a) {
                z8 = true;
            }
            i10++;
        }
        if (z8) {
            for (int i11 = 0; i11 < size; i11++) {
                d dVar2 = (d) this.f9643d0.get(i11);
                if (dVar2 instanceof a) {
                    a aVar = (a) dVar2;
                    for (int i12 = 0; i12 < aVar.f9700e0; i12++) {
                        d dVar3 = aVar.f9699d0[i12];
                        int i13 = aVar.f9589f0;
                        if (i13 == 0 || i13 == 1) {
                            dVar3.H[0] = true;
                        } else if (i13 == 2 || i13 == 3) {
                            dVar3.H[1] = true;
                        }
                    }
                }
            }
        }
        for (int i14 = 0; i14 < size; i14++) {
            d dVar4 = (d) this.f9643d0.get(i14);
            dVar4.getClass();
            if ((dVar4 instanceof g) || (dVar4 instanceof h)) {
                dVar4.a(eVar);
            }
        }
        int i15 = 0;
        while (i15 < size) {
            d dVar5 = (d) this.f9643d0.get(i15);
            if (dVar5 instanceof e) {
                int[] iArr = dVar5.f9620c0;
                int i16 = iArr[c9];
                int i17 = iArr[i9];
                if (i16 == 2) {
                    dVar5.w(i9);
                }
                if (i17 == 2) {
                    dVar5.x(i9);
                }
                dVar5.a(eVar);
                if (i16 == 2) {
                    dVar5.w(i16);
                }
                if (i17 == 2) {
                    dVar5.x(i17);
                }
            } else {
                dVar5.h = -1;
                c cVar = dVar5.B;
                int[] iArr2 = dVar5.f9620c0;
                c cVar2 = dVar5.A;
                c cVar3 = dVar5.f9641y;
                c cVar4 = dVar5.f9642z;
                c cVar5 = dVar5.f9640x;
                dVar5.f9625i = -1;
                int[] iArr3 = this.f9620c0;
                if (iArr3[c9] != 2 && iArr2[c9] == 4) {
                    int i18 = cVar5.f9612e;
                    int l4 = l() - cVar4.f9612e;
                    cVar5.f9614g = eVar.j(cVar5);
                    cVar4.f9614g = eVar.j(cVar4);
                    eVar.d(cVar5.f9614g, i18);
                    eVar.d(cVar4.f9614g, l4);
                    dVar5.h = 2;
                    dVar5.N = i18;
                    int i19 = l4 - i18;
                    dVar5.J = i19;
                    int i20 = dVar5.Q;
                    if (i19 < i20) {
                        dVar5.J = i20;
                    }
                }
                if (iArr3[1] != 2 && iArr2[1] == 4) {
                    int i21 = cVar3.f9612e;
                    int i22 = i() - cVar2.f9612e;
                    cVar3.f9614g = eVar.j(cVar3);
                    cVar2.f9614g = eVar.j(cVar2);
                    eVar.d(cVar3.f9614g, i21);
                    eVar.d(cVar2.f9614g, i22);
                    if (dVar5.P > 0 || dVar5.V == 8) {
                        v.i j5 = eVar.j(cVar);
                        cVar.f9614g = j5;
                        eVar.d(j5, dVar5.P + i21);
                    }
                    dVar5.f9625i = 2;
                    dVar5.O = i21;
                    int i23 = i22 - i21;
                    dVar5.K = i23;
                    int i24 = dVar5.R;
                    if (i23 < i24) {
                        dVar5.K = i24;
                    }
                }
                if (!(dVar5 instanceof g) && !(dVar5 instanceof h)) {
                    dVar5.a(eVar);
                }
            }
            i15++;
            c9 = 0;
            i9 = 1;
        }
        if (this.f9650l0 > 0) {
            j.a(this, eVar, 0);
        }
        if (this.f9651m0 > 0) {
            j.a(this, eVar, 1);
        }
    }

    public final boolean D(int i9, boolean z8) {
        boolean z9;
        boolean z10;
        boolean z11;
        x.f fVar = this.f9645f0;
        ArrayList arrayList = fVar.f9992e;
        e eVar = fVar.f9988a;
        int h = eVar.h(0);
        m mVar = eVar.f9622e;
        k kVar = eVar.f9621d;
        int h9 = eVar.h(1);
        int m9 = eVar.m();
        int n4 = eVar.n();
        if (z8 && (h == 2 || h9 == 2)) {
            int size = arrayList.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    z11 = z8;
                    break;
                }
                Object obj = arrayList.get(i10);
                i10++;
                n nVar = (n) obj;
                if (nVar.f10017f == i9 && !nVar.k()) {
                    z11 = false;
                    break;
                }
            }
            if (i9 == 0) {
                if (z11 && h == 2) {
                    eVar.w(1);
                    eVar.y(fVar.d(eVar, 0));
                    kVar.f10016e.d(eVar.l());
                }
            } else if (z11 && h9 == 2) {
                eVar.x(1);
                eVar.v(fVar.d(eVar, 1));
                mVar.f10016e.d(eVar.i());
            }
        }
        int[] iArr = eVar.f9620c0;
        if (i9 == 0) {
            int i11 = iArr[0];
            if (i11 == 1 || i11 == 4) {
                int l4 = eVar.l() + m9;
                kVar.f10019i.d(l4);
                kVar.f10016e.d(l4 - m9);
                z9 = true;
            } else {
                z9 = false;
            }
        } else {
            int i12 = iArr[1];
            if (i12 == 1 || i12 == 4) {
                int i13 = eVar.i() + n4;
                mVar.f10019i.d(i13);
                mVar.f10016e.d(i13 - n4);
                z9 = true;
            }
            z9 = false;
        }
        fVar.g();
        int size2 = arrayList.size();
        int i14 = 0;
        while (i14 < size2) {
            Object obj2 = arrayList.get(i14);
            i14++;
            n nVar2 = (n) obj2;
            if (nVar2.f10017f == i9 && (nVar2.f10013b != eVar || nVar2.f10018g)) {
                nVar2.e();
            }
        }
        int size3 = arrayList.size();
        int i15 = 0;
        while (i15 < size3) {
            Object obj3 = arrayList.get(i15);
            i15++;
            n nVar3 = (n) obj3;
            if (nVar3.f10017f == i9 && (z9 || nVar3.f10013b != eVar)) {
                if (!nVar3.h.f10003j || !nVar3.f10019i.f10003j || (!(nVar3 instanceof x.d) && !nVar3.f10016e.f10003j)) {
                    z10 = false;
                    break;
                }
            }
        }
        z10 = true;
        eVar.w(h);
        eVar.x(h9);
        return z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x010f  */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E() {
        /*
            Method dump skipped, instructions count: 514
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w.e.E():void");
    }

    @Override // w.d
    public final void s() {
        this.i0.r();
        this.f9648j0 = 0;
        this.f9649k0 = 0;
        this.f9643d0.clear();
        super.s();
    }

    @Override // w.d
    public final void u(l lVar) {
        super.u(lVar);
        int size = this.f9643d0.size();
        for (int i9 = 0; i9 < size; i9++) {
            ((d) this.f9643d0.get(i9)).u(lVar);
        }
    }

    @Override // w.d
    public final void z(boolean z8, boolean z9) {
        super.z(z8, z9);
        int size = this.f9643d0.size();
        for (int i9 = 0; i9 < size; i9++) {
            ((d) this.f9643d0.get(i9)).z(z8, z9);
        }
    }
}
