package v1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g0 extends j {

    /* renamed from: r, reason: collision with root package name */
    public static final d1.e0 f9290r;

    /* renamed from: k, reason: collision with root package name */
    public final a[] f9291k;

    /* renamed from: l, reason: collision with root package name */
    public final d1.y0[] f9292l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f9293m;

    /* renamed from: n, reason: collision with root package name */
    public final o4.d f9294n;

    /* renamed from: o, reason: collision with root package name */
    public int f9295o;

    /* renamed from: p, reason: collision with root package name */
    public long[][] f9296p;

    /* renamed from: q, reason: collision with root package name */
    public b4.c f9297q;

    static {
        d1.w wVar = new d1.w();
        b6.e0 e0Var = b6.g0.f1391j;
        b6.w0 w0Var = b6.w0.f1464m;
        List list = Collections.EMPTY_LIST;
        b6.w0 w0Var2 = b6.w0.f1464m;
        d1.z zVar = new d1.z();
        f9290r = new d1.e0("MergingMediaSource", new d1.y(wVar), null, new d1.a0(zVar), d1.h0.f2449y, d1.c0.f2371a);
    }

    public g0(a... aVarArr) {
        o4.d dVar = new o4.d(15);
        this.f9291k = aVarArr;
        this.f9294n = dVar;
        this.f9293m = new ArrayList(Arrays.asList(aVarArr));
        this.f9295o = -1;
        this.f9292l = new d1.y0[aVarArr.length];
        this.f9296p = new long[0][];
        new HashMap();
        b6.q.b(8, "expectedKeys");
        b6.q.b(2, "expectedValuesPerKey");
        new b6.t0(b6.u.a(8)).f1449n = new b6.s0();
    }

    @Override // v1.a
    public final x a(z zVar, z1.d dVar, long j5) {
        a[] aVarArr = this.f9291k;
        int length = aVarArr.length;
        x[] xVarArr = new x[length];
        d1.y0[] y0VarArr = this.f9292l;
        int b9 = y0VarArr[0].b(zVar.f9447a);
        for (int i9 = 0; i9 < length; i9++) {
            xVarArr[i9] = aVarArr[i9].a(zVar.a(y0VarArr[i9].l(b9)), dVar, j5 - this.f9296p[b9][i9]);
        }
        return new f0(this.f9294n, this.f9296p[b9], xVarArr);
    }

    @Override // v1.a
    public final d1.e0 g() {
        a[] aVarArr = this.f9291k;
        return aVarArr.length > 0 ? aVarArr[0].g() : f9290r;
    }

    @Override // v1.j, v1.a
    public final void i() {
        b4.c cVar = this.f9297q;
        if (cVar != null) {
            throw cVar;
        }
        super.i();
    }

    @Override // v1.a
    public final void k(z1.f fVar) {
        this.f9307j = fVar;
        this.f9306i = g1.w.l(null);
        int i9 = 0;
        while (true) {
            a[] aVarArr = this.f9291k;
            if (i9 >= aVarArr.length) {
                return;
            }
            w(Integer.valueOf(i9), aVarArr[i9]);
            i9++;
        }
    }

    @Override // v1.a
    public final void m(x xVar) {
        f0 f0Var = (f0) xVar;
        int i9 = 0;
        while (true) {
            a[] aVarArr = this.f9291k;
            if (i9 >= aVarArr.length) {
                return;
            }
            a aVar = aVarArr[i9];
            x xVar2 = f0Var.f9273i[i9];
            if (xVar2 instanceof b1) {
                xVar2 = ((b1) xVar2).f9247i;
            }
            aVar.m(xVar2);
            i9++;
        }
    }

    @Override // v1.j, v1.a
    public final void o() {
        super.o();
        Arrays.fill(this.f9292l, (Object) null);
        this.f9295o = -1;
        this.f9297q = null;
        ArrayList arrayList = this.f9293m;
        arrayList.clear();
        Collections.addAll(arrayList, this.f9291k);
    }

    @Override // v1.a
    public final void r(d1.e0 e0Var) {
        this.f9291k[0].r(e0Var);
    }

    @Override // v1.j
    public final z s(Object obj, z zVar) {
        if (((Integer) obj).intValue() == 0) {
            return zVar;
        }
        return null;
    }

    @Override // v1.j
    public final void v(Object obj, a aVar, d1.y0 y0Var) {
        Integer num = (Integer) obj;
        if (this.f9297q != null) {
            return;
        }
        if (this.f9295o == -1) {
            this.f9295o = y0Var.h();
        } else if (y0Var.h() != this.f9295o) {
            this.f9297q = new b4.c();
            return;
        }
        int length = this.f9296p.length;
        d1.y0[] y0VarArr = this.f9292l;
        if (length == 0) {
            this.f9296p = (long[][]) Array.newInstance((Class<?>) Long.TYPE, this.f9295o, y0VarArr.length);
        }
        ArrayList arrayList = this.f9293m;
        arrayList.remove(aVar);
        y0VarArr[num.intValue()] = y0Var;
        if (arrayList.isEmpty()) {
            l(y0VarArr[0]);
        }
    }
}
