package v1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f0 implements x, w {

    /* renamed from: i, reason: collision with root package name */
    public final x[] f9273i;

    /* renamed from: j, reason: collision with root package name */
    public final IdentityHashMap f9274j;

    /* renamed from: k, reason: collision with root package name */
    public final o4.d f9275k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f9276l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    public final HashMap f9277m = new HashMap();

    /* renamed from: n, reason: collision with root package name */
    public w f9278n;

    /* renamed from: o, reason: collision with root package name */
    public c1 f9279o;

    /* renamed from: p, reason: collision with root package name */
    public x[] f9280p;

    /* renamed from: q, reason: collision with root package name */
    public l f9281q;

    public f0(o4.d dVar, long[] jArr, x... xVarArr) {
        this.f9275k = dVar;
        this.f9273i = xVarArr;
        dVar.getClass();
        b6.e0 e0Var = b6.g0.f1391j;
        b6.w0 w0Var = b6.w0.f1464m;
        this.f9281q = new l(w0Var, w0Var);
        this.f9274j = new IdentityHashMap();
        this.f9280p = new x[0];
        for (int i9 = 0; i9 < xVarArr.length; i9++) {
            long j5 = jArr[i9];
            if (j5 != 0) {
                this.f9273i[i9] = new b1(xVarArr[i9], j5);
            }
        }
    }

    @Override // v1.x0
    public final boolean a() {
        return this.f9281q.a();
    }

    @Override // v1.x0
    public final boolean b(l1.j0 j0Var) {
        ArrayList arrayList = this.f9276l;
        if (arrayList.isEmpty()) {
            return this.f9281q.b(j0Var);
        }
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            ((x) arrayList.get(i9)).b(j0Var);
        }
        return false;
    }

    @Override // v1.w
    public final void c(x xVar) {
        ArrayList arrayList = this.f9276l;
        arrayList.remove(xVar);
        if (arrayList.isEmpty()) {
            x[] xVarArr = this.f9273i;
            int i9 = 0;
            for (x xVar2 : xVarArr) {
                i9 += xVar2.j().f9256a;
            }
            d1.z0[] z0VarArr = new d1.z0[i9];
            int i10 = 0;
            for (int i11 = 0; i11 < xVarArr.length; i11++) {
                c1 j5 = xVarArr[i11].j();
                int i12 = j5.f9256a;
                int i13 = 0;
                while (i13 < i12) {
                    d1.z0 a9 = j5.a(i13);
                    int i14 = a9.f2616a;
                    d1.s[] sVarArr = new d1.s[i14];
                    for (int i15 = 0; i15 < i14; i15++) {
                        d1.s sVar = a9.f2619d[i15];
                        d1.r a10 = sVar.a();
                        StringBuilder sb = new StringBuilder();
                        sb.append(i11);
                        sb.append(":");
                        String str = sVar.f2543a;
                        if (str == null) {
                            str = "";
                        }
                        sb.append(str);
                        a10.f2518a = sb.toString();
                        sVarArr[i15] = new d1.s(a10);
                    }
                    d1.z0 z0Var = new d1.z0(i11 + ":" + a9.f2617b, sVarArr);
                    this.f9277m.put(z0Var, a9);
                    z0VarArr[i10] = z0Var;
                    i13++;
                    i10++;
                }
            }
            this.f9279o = new c1(z0VarArr);
            w wVar = this.f9278n;
            wVar.getClass();
            wVar.c(this);
        }
    }

    @Override // v1.w0
    public final void d(x0 x0Var) {
        w wVar = this.f9278n;
        wVar.getClass();
        wVar.d(this);
    }

    @Override // v1.x0
    public final long f() {
        return this.f9281q.f();
    }

    @Override // v1.x
    public final long g() {
        long j5 = -9223372036854775807L;
        for (x xVar : this.f9280p) {
            long g9 = xVar.g();
            if (g9 != -9223372036854775807L) {
                if (j5 == -9223372036854775807L) {
                    for (x xVar2 : this.f9280p) {
                        if (xVar2 == xVar) {
                            break;
                        }
                        if (xVar2.r(g9) != g9) {
                            m7.c.p("Unexpected child seekToUs result.");
                            return 0L;
                        }
                    }
                    j5 = g9;
                } else if (g9 != j5) {
                    m7.c.p("Conflicting discontinuities.");
                    return 0L;
                }
            } else if (j5 != -9223372036854775807L && xVar.r(j5) != j5) {
                m7.c.p("Unexpected child seekToUs result.");
                return 0L;
            }
        }
        return j5;
    }

    @Override // v1.x
    public final void h(w wVar, long j5) {
        this.f9278n = wVar;
        ArrayList arrayList = this.f9276l;
        x[] xVarArr = this.f9273i;
        Collections.addAll(arrayList, xVarArr);
        for (x xVar : xVarArr) {
            xVar.h(this, j5);
        }
    }

    @Override // v1.x
    public final long i(y1.q[] qVarArr, boolean[] zArr, v0[] v0VarArr, boolean[] zArr2, long j5) {
        IdentityHashMap identityHashMap;
        int[] iArr;
        int[] iArr2 = new int[qVarArr.length];
        int[] iArr3 = new int[qVarArr.length];
        int i9 = 0;
        while (true) {
            int length = qVarArr.length;
            identityHashMap = this.f9274j;
            if (i9 >= length) {
                break;
            }
            v0 v0Var = v0VarArr[i9];
            Integer num = v0Var == null ? null : (Integer) identityHashMap.get(v0Var);
            iArr2[i9] = num == null ? -1 : num.intValue();
            y1.q qVar = qVarArr[i9];
            if (qVar != null) {
                String str = qVar.j().f2617b;
                iArr3[i9] = Integer.parseInt(str.substring(0, str.indexOf(":")));
            } else {
                iArr3[i9] = -1;
            }
            i9++;
        }
        identityHashMap.clear();
        int length2 = qVarArr.length;
        v0[] v0VarArr2 = new v0[length2];
        v0[] v0VarArr3 = new v0[qVarArr.length];
        y1.q[] qVarArr2 = new y1.q[qVarArr.length];
        x[] xVarArr = this.f9273i;
        ArrayList arrayList = new ArrayList(xVarArr.length);
        long j9 = j5;
        int i10 = 0;
        while (i10 < xVarArr.length) {
            int i11 = 0;
            while (i11 < qVarArr.length) {
                v0VarArr3[i11] = iArr2[i11] == i10 ? v0VarArr[i11] : null;
                if (iArr3[i11] == i10) {
                    y1.q qVar2 = qVarArr[i11];
                    qVar2.getClass();
                    iArr = iArr2;
                    d1.z0 z0Var = (d1.z0) this.f9277m.get(qVar2.j());
                    z0Var.getClass();
                    qVarArr2[i11] = new e0(qVar2, z0Var);
                } else {
                    iArr = iArr2;
                    qVarArr2[i11] = null;
                }
                i11++;
                iArr2 = iArr;
            }
            int[] iArr4 = iArr2;
            x[] xVarArr2 = xVarArr;
            int i12 = i10;
            long i13 = xVarArr2[i10].i(qVarArr2, zArr, v0VarArr3, zArr2, j9);
            if (i12 == 0) {
                j9 = i13;
            } else if (i13 != j9) {
                m7.c.p("Children enabled at different positions.");
                return 0L;
            }
            boolean z8 = false;
            for (int i14 = 0; i14 < qVarArr.length; i14++) {
                if (iArr3[i14] == i12) {
                    v0 v0Var2 = v0VarArr3[i14];
                    v0Var2.getClass();
                    v0VarArr2[i14] = v0VarArr3[i14];
                    identityHashMap.put(v0Var2, Integer.valueOf(i12));
                    z8 = true;
                } else if (iArr4[i14] == i12) {
                    g1.a.k(v0VarArr3[i14] == null);
                }
            }
            if (z8) {
                arrayList.add(xVarArr2[i12]);
            }
            i10 = i12 + 1;
            xVarArr = xVarArr2;
            iArr2 = iArr4;
        }
        System.arraycopy(v0VarArr2, 0, v0VarArr, 0, length2);
        this.f9280p = (x[]) arrayList.toArray(new x[0]);
        m7.c cVar = new m7.c(25);
        List p0Var = t.a.d(arrayList) ? new b6.p0(arrayList, cVar) : new b6.q0(arrayList, cVar);
        this.f9275k.getClass();
        this.f9281q = new l(arrayList, p0Var);
        return j9;
    }

    @Override // v1.x
    public final c1 j() {
        c1 c1Var = this.f9279o;
        c1Var.getClass();
        return c1Var;
    }

    @Override // v1.x
    public final long k(long j5, l1.d1 d1Var) {
        x[] xVarArr = this.f9280p;
        return (xVarArr.length > 0 ? xVarArr[0] : this.f9273i[0]).k(j5, d1Var);
    }

    @Override // v1.x0
    public final long m() {
        return this.f9281q.m();
    }

    @Override // v1.x
    public final void n() {
        for (x xVar : this.f9273i) {
            xVar.n();
        }
    }

    @Override // v1.x
    public final long r(long j5) {
        long r8 = this.f9280p[0].r(j5);
        int i9 = 1;
        while (true) {
            x[] xVarArr = this.f9280p;
            if (i9 >= xVarArr.length) {
                return r8;
            }
            if (xVarArr[i9].r(r8) != r8) {
                m7.c.p("Unexpected child seekToUs result.");
                return 0L;
            }
            i9++;
        }
    }

    @Override // v1.x
    public final void s(long j5) {
        for (x xVar : this.f9280p) {
            xVar.s(j5);
        }
    }

    @Override // v1.x0
    public final void u(long j5) {
        this.f9281q.u(j5);
    }
}
