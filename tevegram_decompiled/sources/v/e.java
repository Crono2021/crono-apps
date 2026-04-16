package v;

import a0.l;
import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e {

    /* renamed from: o, reason: collision with root package name */
    public static int f9154o = 1000;

    /* renamed from: p, reason: collision with root package name */
    public static boolean f9155p = true;

    /* renamed from: b, reason: collision with root package name */
    public final g f9157b;

    /* renamed from: e, reason: collision with root package name */
    public c[] f9160e;

    /* renamed from: k, reason: collision with root package name */
    public final l f9165k;

    /* renamed from: n, reason: collision with root package name */
    public c f9168n;

    /* renamed from: a, reason: collision with root package name */
    public int f9156a = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f9158c = 32;

    /* renamed from: d, reason: collision with root package name */
    public int f9159d = 32;

    /* renamed from: f, reason: collision with root package name */
    public boolean f9161f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean[] f9162g = new boolean[32];
    public int h = 1;

    /* renamed from: i, reason: collision with root package name */
    public int f9163i = 0;

    /* renamed from: j, reason: collision with root package name */
    public int f9164j = 32;

    /* renamed from: l, reason: collision with root package name */
    public i[] f9166l = new i[f9154o];

    /* renamed from: m, reason: collision with root package name */
    public int f9167m = 0;

    public e() {
        this.f9160e = null;
        this.f9160e = new c[32];
        q();
        l lVar = new l();
        lVar.f30i = new m0.d();
        lVar.f31j = new m0.d();
        lVar.f32k = new m0.d();
        lVar.f33l = new i[32];
        this.f9165k = lVar;
        g gVar = new g(lVar);
        gVar.f9171f = new i[128];
        gVar.f9172g = new i[128];
        gVar.h = 0;
        gVar.f9173i = new f(gVar);
        this.f9157b = gVar;
        if (f9155p) {
            this.f9168n = new d(lVar);
        } else {
            this.f9168n = new c(lVar);
        }
    }

    public static int m(Object obj) {
        i iVar = ((w.c) obj).f9614g;
        if (iVar != null) {
            return (int) (iVar.f9178e + 0.5f);
        }
        return 0;
    }

    public final i a(int i9) {
        i iVar = (i) ((m0.d) this.f9165k.f32k).b();
        if (iVar == null) {
            iVar = new i(i9);
            iVar.f9184l = i9;
        } else {
            iVar.c();
            iVar.f9184l = i9;
        }
        int i10 = this.f9167m;
        int i11 = f9154o;
        if (i10 >= i11) {
            int i12 = i11 * 2;
            f9154o = i12;
            this.f9166l = (i[]) Arrays.copyOf(this.f9166l, i12);
        }
        i[] iVarArr = this.f9166l;
        int i13 = this.f9167m;
        this.f9167m = i13 + 1;
        iVarArr[i13] = iVar;
        return iVar;
    }

    public final void b(i iVar, i iVar2, int i9, float f9, i iVar3, i iVar4, int i10, int i11) {
        c k3 = k();
        if (iVar2 == iVar3) {
            k3.f9152d.c(iVar, 1.0f);
            k3.f9152d.c(iVar4, 1.0f);
            k3.f9152d.c(iVar2, -2.0f);
        } else {
            b bVar = k3.f9152d;
            if (f9 == 0.5f) {
                bVar.c(iVar, 1.0f);
                k3.f9152d.c(iVar2, -1.0f);
                k3.f9152d.c(iVar3, -1.0f);
                k3.f9152d.c(iVar4, 1.0f);
                if (i9 > 0 || i10 > 0) {
                    k3.f9150b = (-i9) + i10;
                }
            } else if (f9 <= 0.0f) {
                bVar.c(iVar, -1.0f);
                k3.f9152d.c(iVar2, 1.0f);
                k3.f9150b = i9;
            } else if (f9 >= 1.0f) {
                bVar.c(iVar4, -1.0f);
                k3.f9152d.c(iVar3, 1.0f);
                k3.f9150b = -i10;
            } else {
                float f10 = 1.0f - f9;
                bVar.c(iVar, f10 * 1.0f);
                k3.f9152d.c(iVar2, f10 * (-1.0f));
                k3.f9152d.c(iVar3, (-1.0f) * f9);
                k3.f9152d.c(iVar4, 1.0f * f9);
                if (i9 > 0 || i10 > 0) {
                    k3.f9150b = (i10 * f9) + ((-i9) * f10);
                }
            }
        }
        if (i11 != 8) {
            k3.a(this, i11);
        }
        c(k3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x00bc, code lost:
    
        if (r4.f9183k <= 1) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00be, code lost:
    
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00c0, code lost:
    
        r12 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00ca, code lost:
    
        if (r4.f9183k <= 1) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00e1, code lost:
    
        if (r4.f9183k <= 1) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00e3, code lost:
    
        r14 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x00e5, code lost:
    
        r14 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x00ef, code lost:
    
        if (r4.f9183k <= 1) goto L67;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(v.c r18) {
        /*
            Method dump skipped, instructions count: 420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v.e.c(v.c):void");
    }

    public final void d(i iVar, int i9) {
        int i10 = iVar.f9176c;
        if (i10 == -1) {
            iVar.f9178e = i9;
            iVar.f9179f = true;
            int i11 = iVar.f9182j;
            for (int i12 = 0; i12 < i11; i12++) {
                iVar.f9181i[i12].g(iVar, false);
            }
            iVar.f9182j = 0;
            return;
        }
        if (i10 == -1) {
            c k3 = k();
            k3.f9149a = iVar;
            float f9 = i9;
            iVar.f9178e = f9;
            k3.f9150b = f9;
            k3.f9153e = true;
            c(k3);
            return;
        }
        c cVar = this.f9160e[i10];
        if (cVar.f9153e) {
            cVar.f9150b = i9;
            return;
        }
        if (cVar.f9152d.d() == 0) {
            cVar.f9153e = true;
            cVar.f9150b = i9;
            return;
        }
        c k9 = k();
        if (i9 < 0) {
            k9.f9150b = i9 * (-1);
            k9.f9152d.c(iVar, 1.0f);
        } else {
            k9.f9150b = i9;
            k9.f9152d.c(iVar, -1.0f);
        }
        c(k9);
    }

    public final void e(i iVar, i iVar2, int i9, int i10) {
        boolean z8 = false;
        if (i10 == 8 && iVar2.f9179f && iVar.f9176c == -1) {
            iVar.f9178e = iVar2.f9178e + i9;
            iVar.f9179f = true;
            int i11 = iVar.f9182j;
            for (int i12 = 0; i12 < i11; i12++) {
                iVar.f9181i[i12].g(iVar, false);
            }
            iVar.f9182j = 0;
            return;
        }
        c k3 = k();
        if (i9 != 0) {
            if (i9 < 0) {
                i9 *= -1;
                z8 = true;
            }
            k3.f9150b = i9;
        }
        b bVar = k3.f9152d;
        if (z8) {
            bVar.c(iVar, 1.0f);
            k3.f9152d.c(iVar2, -1.0f);
        } else {
            bVar.c(iVar, -1.0f);
            k3.f9152d.c(iVar2, 1.0f);
        }
        if (i10 != 8) {
            k3.a(this, i10);
        }
        c(k3);
    }

    public final void f(i iVar, i iVar2, int i9, int i10) {
        c k3 = k();
        i l4 = l();
        l4.f9177d = 0;
        k3.b(iVar, iVar2, l4, i9);
        if (i10 != 8) {
            k3.f9152d.c(i(i10), (int) (k3.f9152d.g(l4) * (-1.0f)));
        }
        c(k3);
    }

    public final void g(i iVar, i iVar2, int i9, int i10) {
        c k3 = k();
        i l4 = l();
        l4.f9177d = 0;
        k3.c(iVar, iVar2, l4, i9);
        if (i10 != 8) {
            k3.f9152d.c(i(i10), (int) (k3.f9152d.g(l4) * (-1.0f)));
        }
        c(k3);
    }

    public final void h(c cVar) {
        boolean z8 = f9155p;
        c[] cVarArr = this.f9160e;
        int i9 = this.f9163i;
        l lVar = this.f9165k;
        if (z8) {
            c cVar2 = cVarArr[i9];
            if (cVar2 != null) {
                ((m0.d) lVar.f30i).c(cVar2);
            }
        } else {
            c cVar3 = cVarArr[i9];
            if (cVar3 != null) {
                ((m0.d) lVar.f31j).c(cVar3);
            }
        }
        c[] cVarArr2 = this.f9160e;
        int i10 = this.f9163i;
        cVarArr2[i10] = cVar;
        i iVar = cVar.f9149a;
        iVar.f9176c = i10;
        this.f9163i = i10 + 1;
        iVar.d(cVar);
    }

    public final i i(int i9) {
        if (this.h + 1 >= this.f9159d) {
            n();
        }
        i a9 = a(4);
        float[] fArr = a9.h;
        int i10 = this.f9156a + 1;
        this.f9156a = i10;
        this.h++;
        a9.f9175b = i10;
        a9.f9177d = i9;
        ((i[]) this.f9165k.f33l)[i10] = a9;
        g gVar = this.f9157b;
        gVar.f9173i.f9169i = a9;
        Arrays.fill(fArr, 0.0f);
        fArr[a9.f9177d] = 1.0f;
        gVar.i(a9);
        return a9;
    }

    public final i j(Object obj) {
        if (obj == null) {
            return null;
        }
        if (this.h + 1 >= this.f9159d) {
            n();
        }
        if (!(obj instanceof w.c)) {
            return null;
        }
        w.c cVar = (w.c) obj;
        i iVar = cVar.f9614g;
        if (iVar == null) {
            cVar.i();
            iVar = cVar.f9614g;
        }
        int i9 = iVar.f9175b;
        l lVar = this.f9165k;
        if (i9 != -1 && i9 <= this.f9156a && ((i[]) lVar.f33l)[i9] != null) {
            return iVar;
        }
        if (i9 != -1) {
            iVar.c();
        }
        int i10 = this.f9156a + 1;
        this.f9156a = i10;
        this.h++;
        iVar.f9175b = i10;
        iVar.f9184l = 1;
        ((i[]) lVar.f33l)[i10] = iVar;
        return iVar;
    }

    public final c k() {
        boolean z8 = f9155p;
        l lVar = this.f9165k;
        if (z8) {
            c cVar = (c) ((m0.d) lVar.f30i).b();
            if (cVar == null) {
                return new d(lVar);
            }
            cVar.f9149a = null;
            cVar.f9152d.clear();
            cVar.f9150b = 0.0f;
            cVar.f9153e = false;
            return cVar;
        }
        c cVar2 = (c) ((m0.d) lVar.f31j).b();
        if (cVar2 == null) {
            return new c(lVar);
        }
        cVar2.f9149a = null;
        cVar2.f9152d.clear();
        cVar2.f9150b = 0.0f;
        cVar2.f9153e = false;
        return cVar2;
    }

    public final i l() {
        if (this.h + 1 >= this.f9159d) {
            n();
        }
        i a9 = a(3);
        int i9 = this.f9156a + 1;
        this.f9156a = i9;
        this.h++;
        a9.f9175b = i9;
        ((i[]) this.f9165k.f33l)[i9] = a9;
        return a9;
    }

    public final void n() {
        int i9 = this.f9158c * 2;
        this.f9158c = i9;
        this.f9160e = (c[]) Arrays.copyOf(this.f9160e, i9);
        l lVar = this.f9165k;
        lVar.f33l = (i[]) Arrays.copyOf((i[]) lVar.f33l, this.f9158c);
        int i10 = this.f9158c;
        this.f9162g = new boolean[i10];
        this.f9159d = i10;
        this.f9164j = i10;
    }

    public final void o(g gVar) {
        l lVar;
        int i9 = 0;
        while (true) {
            if (i9 >= this.f9163i) {
                break;
            }
            c cVar = this.f9160e[i9];
            int i10 = 1;
            if (cVar.f9149a.f9184l != 1) {
                float f9 = 0.0f;
                if (cVar.f9150b < 0.0f) {
                    boolean z8 = false;
                    int i11 = 0;
                    while (!z8) {
                        i11 += i10;
                        float f10 = Float.MAX_VALUE;
                        int i12 = 0;
                        int i13 = -1;
                        int i14 = -1;
                        int i15 = 0;
                        while (true) {
                            int i16 = this.f9163i;
                            lVar = this.f9165k;
                            if (i12 >= i16) {
                                break;
                            }
                            c cVar2 = this.f9160e[i12];
                            if (cVar2.f9149a.f9184l != i10 && !cVar2.f9153e && cVar2.f9150b < f9) {
                                int i17 = 1;
                                while (i17 < this.h) {
                                    i iVar = ((i[]) lVar.f33l)[i17];
                                    float g9 = cVar2.f9152d.g(iVar);
                                    if (g9 > f9) {
                                        for (int i18 = 0; i18 < 9; i18++) {
                                            float f11 = iVar.f9180g[i18] / g9;
                                            if ((f11 < f10 && i18 == i15) || i18 > i15) {
                                                i15 = i18;
                                                f10 = f11;
                                                i13 = i12;
                                                i14 = i17;
                                            }
                                        }
                                    }
                                    i17++;
                                    f9 = 0.0f;
                                }
                            }
                            i12++;
                            f9 = 0.0f;
                            i10 = 1;
                        }
                        if (i13 != -1) {
                            c cVar3 = this.f9160e[i13];
                            cVar3.f9149a.f9176c = -1;
                            cVar3.f(((i[]) lVar.f33l)[i14]);
                            i iVar2 = cVar3.f9149a;
                            iVar2.f9176c = i13;
                            iVar2.d(cVar3);
                        } else {
                            z8 = true;
                        }
                        if (i11 > this.h / 2) {
                            z8 = true;
                        }
                        f9 = 0.0f;
                        i10 = 1;
                    }
                }
            }
            i9++;
        }
        p(gVar);
        for (int i19 = 0; i19 < this.f9163i; i19++) {
            c cVar4 = this.f9160e[i19];
            cVar4.f9149a.f9178e = cVar4.f9150b;
        }
    }

    public final void p(c cVar) {
        for (int i9 = 0; i9 < this.h; i9++) {
            this.f9162g[i9] = false;
        }
        boolean z8 = false;
        int i10 = 0;
        while (!z8) {
            i10++;
            if (i10 >= this.h * 2) {
                return;
            }
            i iVar = cVar.f9149a;
            if (iVar != null) {
                this.f9162g[iVar.f9175b] = true;
            }
            i d9 = cVar.d(this.f9162g);
            if (d9 != null) {
                boolean[] zArr = this.f9162g;
                int i11 = d9.f9175b;
                if (zArr[i11]) {
                    return;
                } else {
                    zArr[i11] = true;
                }
            }
            if (d9 != null) {
                float f9 = Float.MAX_VALUE;
                int i12 = -1;
                for (int i13 = 0; i13 < this.f9163i; i13++) {
                    c cVar2 = this.f9160e[i13];
                    if (cVar2.f9149a.f9184l != 1 && !cVar2.f9153e && cVar2.f9152d.i(d9)) {
                        float g9 = cVar2.f9152d.g(d9);
                        if (g9 < 0.0f) {
                            float f10 = (-cVar2.f9150b) / g9;
                            if (f10 < f9) {
                                i12 = i13;
                                f9 = f10;
                            }
                        }
                    }
                }
                if (i12 > -1) {
                    c cVar3 = this.f9160e[i12];
                    cVar3.f9149a.f9176c = -1;
                    cVar3.f(d9);
                    i iVar2 = cVar3.f9149a;
                    iVar2.f9176c = i12;
                    iVar2.d(cVar3);
                }
            } else {
                z8 = true;
            }
        }
    }

    public final void q() {
        boolean z8 = f9155p;
        l lVar = this.f9165k;
        int i9 = 0;
        if (z8) {
            while (true) {
                c[] cVarArr = this.f9160e;
                if (i9 >= cVarArr.length) {
                    return;
                }
                c cVar = cVarArr[i9];
                if (cVar != null) {
                    ((m0.d) lVar.f30i).c(cVar);
                }
                this.f9160e[i9] = null;
                i9++;
            }
        } else {
            while (true) {
                c[] cVarArr2 = this.f9160e;
                if (i9 >= cVarArr2.length) {
                    return;
                }
                c cVar2 = cVarArr2[i9];
                if (cVar2 != null) {
                    ((m0.d) lVar.f31j).c(cVar2);
                }
                this.f9160e[i9] = null;
                i9++;
            }
        }
    }

    public final void r() {
        l lVar;
        int i9 = 0;
        while (true) {
            lVar = this.f9165k;
            i[] iVarArr = (i[]) lVar.f33l;
            if (i9 >= iVarArr.length) {
                break;
            }
            i iVar = iVarArr[i9];
            if (iVar != null) {
                iVar.c();
            }
            i9++;
        }
        m0.d dVar = (m0.d) lVar.f32k;
        i[] iVarArr2 = this.f9166l;
        int i10 = this.f9167m;
        dVar.getClass();
        if (i10 > iVarArr2.length) {
            i10 = iVarArr2.length;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            i iVar2 = iVarArr2[i11];
            int i12 = dVar.f6498k;
            Object[] objArr = dVar.f6497j;
            if (i12 < objArr.length) {
                objArr[i12] = iVar2;
                dVar.f6498k = i12 + 1;
            }
        }
        this.f9167m = 0;
        Arrays.fill((i[]) lVar.f33l, (Object) null);
        this.f9156a = 0;
        g gVar = this.f9157b;
        gVar.h = 0;
        gVar.f9150b = 0.0f;
        this.h = 1;
        for (int i13 = 0; i13 < this.f9163i; i13++) {
            this.f9160e[i13].getClass();
        }
        q();
        this.f9163i = 0;
        if (f9155p) {
            this.f9168n = new d(lVar);
        } else {
            this.f9168n = new c(lVar);
        }
    }
}
