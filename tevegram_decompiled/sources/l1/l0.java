package l1;

import android.media.Spatializer;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import d1.f1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l0 {

    /* renamed from: a, reason: collision with root package name */
    public final Object f5939a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f5940b;

    /* renamed from: c, reason: collision with root package name */
    public final v1.v0[] f5941c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f5942d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f5943e;

    /* renamed from: f, reason: collision with root package name */
    public m0 f5944f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f5945g;
    public final boolean[] h;

    /* renamed from: i, reason: collision with root package name */
    public final e[] f5946i;

    /* renamed from: j, reason: collision with root package name */
    public final y1.o f5947j;

    /* renamed from: k, reason: collision with root package name */
    public final v0 f5948k;

    /* renamed from: l, reason: collision with root package name */
    public l0 f5949l;

    /* renamed from: m, reason: collision with root package name */
    public v1.c1 f5950m;

    /* renamed from: n, reason: collision with root package name */
    public y1.t f5951n;

    /* renamed from: o, reason: collision with root package name */
    public long f5952o;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [v1.d] */
    public l0(e[] eVarArr, long j5, y1.o oVar, z1.d dVar, v0 v0Var, m0 m0Var, y1.t tVar) {
        this.f5946i = eVarArr;
        this.f5952o = j5;
        this.f5947j = oVar;
        this.f5948k = v0Var;
        v1.z zVar = m0Var.f5955a;
        this.f5940b = zVar.f9447a;
        this.f5944f = m0Var;
        this.f5950m = v1.c1.f9255d;
        this.f5951n = tVar;
        this.f5941c = new v1.v0[eVarArr.length];
        this.h = new boolean[eVarArr.length];
        long j9 = m0Var.f5956b;
        long j10 = m0Var.f5958d;
        v0Var.getClass();
        Object obj = zVar.f9447a;
        int i9 = a1.f5763k;
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        v1.z a9 = zVar.a(pair.second);
        u0 u0Var = (u0) ((HashMap) v0Var.f6036e).get(obj2);
        u0Var.getClass();
        ((HashSet) v0Var.h).add(u0Var);
        t0 t0Var = (t0) ((HashMap) v0Var.f6037f).get(u0Var);
        if (t0Var != null) {
            t0Var.f6021a.d(t0Var.f6022b);
        }
        u0Var.f6027c.add(a9);
        v1.r a10 = u0Var.f6025a.a(a9, dVar, j9);
        ((IdentityHashMap) v0Var.f6035d).put(a10, u0Var);
        v0Var.d();
        this.f5939a = j10 != -9223372036854775807L ? new v1.d(a10, true, 0L, j10) : a10;
    }

    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.Object, v1.x] */
    public final long a(y1.t tVar, long j5, boolean z8, boolean[] zArr) {
        e[] eVarArr;
        v1.v0[] v0VarArr;
        int i9 = 0;
        while (true) {
            boolean z9 = true;
            if (i9 >= tVar.f10491a) {
                break;
            }
            if (z8 || !tVar.a(this.f5951n, i9)) {
                z9 = false;
            }
            this.h[i9] = z9;
            i9++;
        }
        int i10 = 0;
        while (true) {
            eVarArr = this.f5946i;
            int length = eVarArr.length;
            v0VarArr = this.f5941c;
            if (i10 >= length) {
                break;
            }
            if (eVarArr[i10].f5827j == -2) {
                v0VarArr[i10] = null;
            }
            i10++;
        }
        b();
        this.f5951n = tVar;
        c();
        long i11 = this.f5939a.i(tVar.f10493c, this.h, this.f5941c, zArr, j5);
        for (int i12 = 0; i12 < eVarArr.length; i12++) {
            if (eVarArr[i12].f5827j == -2 && this.f5951n.b(i12)) {
                v0VarArr[i12] = new o4.d(16);
            }
        }
        this.f5943e = false;
        for (int i13 = 0; i13 < v0VarArr.length; i13++) {
            if (v0VarArr[i13] != null) {
                g1.a.k(tVar.b(i13));
                if (eVarArr[i13].f5827j != -2) {
                    this.f5943e = true;
                }
            } else {
                g1.a.k(tVar.f10493c[i13] == null);
            }
        }
        return i11;
    }

    public final void b() {
        if (this.f5949l != null) {
            return;
        }
        int i9 = 0;
        while (true) {
            y1.t tVar = this.f5951n;
            if (i9 >= tVar.f10491a) {
                return;
            }
            boolean b9 = tVar.b(i9);
            y1.q qVar = this.f5951n.f10493c[i9];
            if (b9 && qVar != null) {
                qVar.h();
            }
            i9++;
        }
    }

    public final void c() {
        if (this.f5949l != null) {
            return;
        }
        int i9 = 0;
        while (true) {
            y1.t tVar = this.f5951n;
            if (i9 >= tVar.f10491a) {
                return;
            }
            boolean b9 = tVar.b(i9);
            y1.q qVar = this.f5951n.f10493c[i9];
            if (b9 && qVar != null) {
                qVar.d();
            }
            i9++;
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, v1.x0] */
    public final long d() {
        if (!this.f5942d) {
            return this.f5944f.f5956b;
        }
        long m9 = this.f5943e ? this.f5939a.m() : Long.MIN_VALUE;
        return m9 == Long.MIN_VALUE ? this.f5944f.f5959e : m9;
    }

    public final long e() {
        return this.f5944f.f5956b + this.f5952o;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, v1.x0] */
    public final boolean f() {
        if (this.f5942d) {
            return !this.f5943e || this.f5939a.m() == Long.MIN_VALUE;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, v1.x] */
    public final void g() {
        b();
        ?? r02 = this.f5939a;
        try {
            boolean z8 = r02 instanceof v1.d;
            v0 v0Var = this.f5948k;
            if (z8) {
                v0Var.h(((v1.d) r02).f9259i);
            } else {
                v0Var.h(r02);
            }
        } catch (RuntimeException e9) {
            g1.a.q("MediaPeriodHolder", "Period release failed.", e9);
        }
    }

    /* JADX WARN: Type inference failed for: r12v0, types: [int[], java.io.Serializable, java.lang.Object] */
    public final y1.t h(float f9, d1.y0 y0Var) {
        y1.i iVar;
        boolean z8;
        String str;
        z1.f fVar;
        b6.w0 l4;
        Object[] objArr;
        boolean z9;
        b6.w0 w0Var;
        y1.q bVar;
        int[] iArr;
        int i9;
        Object obj;
        y1.p pVar;
        int i10;
        d1.z0 z0Var;
        v1.c1 c1Var;
        b2.b bVar2;
        int[] iArr2;
        y1.o oVar = this.f5947j;
        e[] eVarArr = this.f5946i;
        v1.c1 c1Var2 = this.f5950m;
        oVar.getClass();
        int[] iArr3 = new int[eVarArr.length + 1];
        int length = eVarArr.length + 1;
        d1.z0[][] z0VarArr = new d1.z0[length][];
        int[][][] iArr4 = new int[eVarArr.length + 1][][];
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = c1Var2.f9256a;
            z0VarArr[i11] = new d1.z0[i12];
            iArr4[i11] = new int[i12][];
        }
        int length2 = eVarArr.length;
        ?? r12 = new int[length2];
        for (int i13 = 0; i13 < length2; i13++) {
            r12[i13] = eVarArr[i13].A();
        }
        int i14 = 0;
        while (i14 < c1Var2.f9256a) {
            d1.z0 a9 = c1Var2.a(i14);
            boolean z10 = a9.f2618c == 5;
            int length3 = eVarArr.length;
            int i15 = 0;
            int i16 = 0;
            boolean z11 = true;
            while (i15 < eVarArr.length) {
                e eVar = eVarArr[i15];
                v1.c1 c1Var3 = c1Var2;
                int i17 = 0;
                for (int i18 = 0; i18 < a9.f2616a; i18++) {
                    i17 = Math.max(i17, eVar.z(a9.f2619d[i18]) & 7);
                }
                boolean z12 = iArr3[i15] == 0;
                if (i17 > i16 || (i17 == i16 && z10 && !z11 && z12)) {
                    i16 = i17;
                    z11 = z12;
                    length3 = i15;
                }
                i15++;
                c1Var2 = c1Var3;
            }
            v1.c1 c1Var4 = c1Var2;
            if (length3 == eVarArr.length) {
                iArr2 = new int[a9.f2616a];
            } else {
                e eVar2 = eVarArr[length3];
                int[] iArr5 = new int[a9.f2616a];
                for (int i19 = 0; i19 < a9.f2616a; i19++) {
                    iArr5[i19] = eVar2.z(a9.f2619d[i19]);
                }
                iArr2 = iArr5;
            }
            int i20 = iArr3[length3];
            z0VarArr[length3][i20] = a9;
            iArr4[length3][i20] = iArr2;
            iArr3[length3] = i20 + 1;
            i14++;
            c1Var2 = c1Var4;
        }
        v1.c1[] c1VarArr = new v1.c1[eVarArr.length];
        String[] strArr = new String[eVarArr.length];
        int[] iArr6 = new int[eVarArr.length];
        for (int i21 = 0; i21 < eVarArr.length; i21++) {
            int i22 = iArr3[i21];
            c1VarArr[i21] = new v1.c1((d1.z0[]) g1.w.O(i22, z0VarArr[i21]));
            iArr4[i21] = (int[][]) g1.w.O(i22, iArr4[i21]);
            strArr[i21] = eVarArr[i21].getName();
            iArr6[i21] = eVarArr[i21].f5827j;
        }
        y1.s sVar = new y1.s(iArr6, c1VarArr, r12, iArr4, new v1.c1((d1.z0[]) g1.w.O(iArr3[eVarArr.length], z0VarArr[eVarArr.length])));
        synchronized (oVar.f10477c) {
            try {
                iVar = oVar.f10481g;
                if (iVar.f10442x && g1.w.f3713a >= 32 && (bVar2 = oVar.h) != null) {
                    Looper myLooper = Looper.myLooper();
                    g1.a.l(myLooper);
                    if (((y1.j) bVar2.f1140d) == null && ((Handler) bVar2.f1139c) == null) {
                        bVar2.f1140d = new y1.j(oVar);
                        Handler handler = new Handler(myLooper);
                        bVar2.f1139c = handler;
                        ((Spatializer) bVar2.f1138b).addOnSpatializerStateChangedListener(new n1.m0(handler), (y1.j) bVar2.f1140d);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        int i23 = sVar.f10485a;
        y1.p[] pVarArr = new y1.p[i23];
        iVar.f2401m.getClass();
        int i24 = 2;
        Pair i25 = y1.o.i(2, sVar, iArr4, new h7.e(iVar, 11, (Object) r12), new a3.d(11));
        int i26 = 4;
        Pair i27 = i25 == null ? y1.o.i(4, sVar, iArr4, new a3.i(iVar, 25), new a3.d(9)) : null;
        if (i27 != null) {
            pVarArr[((Integer) i27.second).intValue()] = (y1.p) i27.first;
        } else if (i25 != null) {
            pVarArr[((Integer) i25.second).intValue()] = (y1.p) i25.first;
        }
        int i28 = 0;
        while (true) {
            if (i28 >= sVar.f10485a) {
                z8 = false;
                break;
            }
            if (2 == iArr6[i28] && c1VarArr[i28].f9256a > 0) {
                z8 = true;
                break;
            }
            i28++;
        }
        Pair i29 = y1.o.i(1, sVar, iArr4, new h7.s(oVar, iVar, z8, r12), new a3.d(10));
        if (i29 != null) {
            pVarArr[((Integer) i29.second).intValue()] = (y1.p) i29.first;
        }
        if (i29 == null) {
            str = null;
        } else {
            y1.p pVar2 = (y1.p) i29.first;
            str = pVar2.f10483a.f2619d[pVar2.f10484b[0]].f2546d;
        }
        int i30 = 3;
        Pair i31 = y1.o.i(3, sVar, iArr4, new h7.e(iVar, 12, str), new a3.d(12));
        if (i31 != null) {
            pVarArr[((Integer) i31.second).intValue()] = (y1.p) i31.first;
        }
        int i32 = 0;
        while (i32 < i23) {
            int i33 = iArr6[i32];
            if (i33 == i24 || i33 == 1 || i33 == i30 || i33 == i26) {
                i10 = i32;
            } else {
                v1.c1 c1Var5 = c1VarArr[i32];
                int[][] iArr7 = iArr4[i32];
                d1.z0 z0Var2 = null;
                int i34 = 0;
                int i35 = 0;
                y1.g gVar = null;
                while (i34 < c1Var5.f9256a) {
                    d1.z0 a10 = c1Var5.a(i34);
                    int[] iArr8 = iArr7[i34];
                    y1.g gVar2 = gVar;
                    int i36 = i35;
                    d1.z0 z0Var3 = z0Var2;
                    int i37 = 0;
                    while (i37 < a10.f2616a) {
                        int i38 = i32;
                        if (y1.o.d(iArr8[i37], iVar.f10443y)) {
                            z0Var = a10;
                            y1.g gVar3 = new y1.g(a10.f2619d[i37], iArr8[i37]);
                            if (gVar2 != null) {
                                c1Var = c1Var5;
                                if (b6.y.f1469a.c(gVar3.f10430j, gVar2.f10430j).c(gVar3.f10429i, gVar2.f10429i).e() <= 0) {
                                }
                            } else {
                                c1Var = c1Var5;
                            }
                            gVar2 = gVar3;
                            i36 = i37;
                            z0Var3 = z0Var;
                        } else {
                            z0Var = a10;
                            c1Var = c1Var5;
                        }
                        i37++;
                        i32 = i38;
                        a10 = z0Var;
                        c1Var5 = c1Var;
                    }
                    i34++;
                    z0Var2 = z0Var3;
                    i35 = i36;
                    gVar = gVar2;
                }
                i10 = i32;
                pVarArr[i10] = z0Var2 == null ? null : new y1.p(0, z0Var2, new int[]{i35});
            }
            i32 = i10 + 1;
            i24 = 2;
            i26 = 4;
            i30 = 3;
        }
        Object obj2 = null;
        int i39 = sVar.f10485a;
        v1.c1[] c1VarArr2 = sVar.f10487c;
        HashMap hashMap = new HashMap();
        for (int i40 = 0; i40 < i39; i40++) {
            y1.o.a(c1VarArr2[i40], iVar, hashMap);
        }
        y1.o.a(sVar.f10490f, iVar, hashMap);
        for (int i41 = 0; i41 < i39; i41++) {
            d1.a1 a1Var = (d1.a1) hashMap.get(Integer.valueOf(sVar.f10486b[i41]));
            if (a1Var != null) {
                d1.z0 z0Var4 = a1Var.f2353a;
                b6.g0 g0Var = a1Var.f2354b;
                if (!g0Var.isEmpty()) {
                    int indexOf = c1VarArr2[i41].f9257b.indexOf(z0Var4);
                    if (indexOf < 0) {
                        indexOf = -1;
                    }
                    if (indexOf != -1) {
                        pVar = new y1.p(0, z0Var4, a.a.T(g0Var));
                        pVarArr[i41] = pVar;
                    }
                }
                pVar = null;
                pVarArr[i41] = pVar;
            }
        }
        int i42 = sVar.f10485a;
        for (int i43 = 0; i43 < i42; i43++) {
            v1.c1 c1Var6 = sVar.f10487c[i43];
            Map map = (Map) iVar.A.get(i43);
            if (map != null && map.containsKey(c1Var6)) {
                Map map2 = (Map) iVar.A.get(i43);
                if (map2 != null && map2.get(c1Var6) != null) {
                    androidx.fragment.app.a.c();
                    return null;
                }
                pVarArr[i43] = null;
            }
        }
        for (int i44 = 0; i44 < i23; i44++) {
            int i45 = sVar.f10486b[i44];
            if (iVar.B.get(i44) || iVar.f2407s.contains(Integer.valueOf(i45))) {
                pVarArr[i44] = null;
            }
        }
        o4.d dVar = oVar.f10479e;
        z1.f fVar2 = oVar.f10476b;
        g1.a.l(fVar2);
        dVar.getClass();
        ArrayList arrayList = new ArrayList();
        int i46 = 0;
        while (i46 < pVarArr.length) {
            y1.p pVar3 = pVarArr[i46];
            if (pVar3 == null || pVar3.f10484b.length <= 1) {
                obj = obj2;
                arrayList.add(obj);
            } else {
                b6.e0 e0Var = b6.g0.f1391j;
                b6.d0 d0Var = new b6.d0();
                d0Var.a(new y1.a(0L, 0L));
                arrayList.add(d0Var);
                obj = obj2;
            }
            i46++;
            obj2 = obj;
        }
        int length4 = pVarArr.length;
        long[][] jArr = new long[length4][];
        for (int i47 = 0; i47 < pVarArr.length; i47++) {
            y1.p pVar4 = pVarArr[i47];
            if (pVar4 == null) {
                jArr[i47] = new long[0];
            } else {
                int[] iArr9 = pVar4.f10484b;
                jArr[i47] = new long[iArr9.length];
                for (int i48 = 0; i48 < iArr9.length; i48++) {
                    long j5 = pVar4.f10483a.f2619d[iArr9[i48]].f2550i;
                    long[] jArr2 = jArr[i47];
                    if (j5 == -1) {
                        j5 = 0;
                    }
                    jArr2[i48] = j5;
                }
                Arrays.sort(jArr[i47]);
            }
        }
        int[] iArr10 = new int[length4];
        long[] jArr3 = new long[length4];
        for (int i49 = 0; i49 < length4; i49++) {
            long[] jArr4 = jArr[i49];
            jArr3[i49] = jArr4.length == 0 ? 0L : jArr4[0];
        }
        y1.b.u(arrayList, jArr3);
        b6.q.b(2, "expectedValuesPerKey");
        TreeMap treeMap = new TreeMap(b6.u0.f1460j);
        b6.s0 s0Var = new b6.s0();
        b6.t0 t0Var = new b6.t0(treeMap);
        t0Var.f1449n = s0Var;
        int i50 = 0;
        loop19: while (true) {
            if (i50 < length4) {
                long[] jArr5 = jArr[i50];
                if (jArr5.length <= 1) {
                    fVar = fVar2;
                    i9 = length4;
                    iArr = iArr10;
                } else {
                    int length5 = jArr5.length;
                    double[] dArr = new double[length5];
                    int i51 = 0;
                    while (true) {
                        long[] jArr6 = jArr[i50];
                        fVar = fVar2;
                        double d9 = 0.0d;
                        if (i51 >= jArr6.length) {
                            break;
                        }
                        int i52 = length4;
                        int[] iArr11 = iArr10;
                        long j9 = jArr6[i51];
                        if (j9 != -1) {
                            d9 = Math.log(j9);
                        }
                        dArr[i51] = d9;
                        i51++;
                        length4 = i52;
                        iArr10 = iArr11;
                        fVar2 = fVar;
                    }
                    int i53 = length4;
                    iArr = iArr10;
                    int i54 = length5 - 1;
                    double d10 = dArr[i54] - dArr[0];
                    int i55 = 0;
                    while (i55 < i54) {
                        double d11 = dArr[i55];
                        i55++;
                        Double valueOf = Double.valueOf(d10 == 0.0d ? 1.0d : (((d11 + dArr[i55]) * 0.5d) - dArr[0]) / d10);
                        int i56 = i53;
                        Integer valueOf2 = Integer.valueOf(i50);
                        double d12 = d10;
                        Map map3 = t0Var.f1447l;
                        Collection collection = (Collection) map3.get(valueOf);
                        if (collection == null) {
                            Collection c9 = t0Var.c();
                            if (!c9.add(valueOf2)) {
                                m7.c.e("New Collection violated the Collection spec");
                                l4 = null;
                                break loop19;
                            }
                            t0Var.f1448m++;
                            map3.put(valueOf, c9);
                        } else if (collection.add(valueOf2)) {
                            t0Var.f1448m++;
                        }
                        i53 = i56;
                        d10 = d12;
                    }
                    i9 = i53;
                }
                i50++;
                iArr10 = iArr;
                length4 = i9;
                fVar2 = fVar;
            } else {
                fVar = fVar2;
                int[] iArr12 = iArr10;
                b6.n nVar = t0Var.f1425j;
                if (nVar == null) {
                    nVar = new b6.n(0, t0Var);
                    t0Var.f1425j = nVar;
                }
                b6.g0 m9 = b6.g0.m(nVar);
                for (int i57 = 0; i57 < m9.size(); i57++) {
                    int intValue = ((Integer) m9.get(i57)).intValue();
                    int i58 = iArr12[intValue] + 1;
                    iArr12[intValue] = i58;
                    jArr3[intValue] = jArr[intValue][i58];
                    y1.b.u(arrayList, jArr3);
                }
                for (int i59 = 0; i59 < pVarArr.length; i59++) {
                    if (arrayList.get(i59) != null) {
                        jArr3[i59] = jArr3[i59] * 2;
                    }
                }
                y1.b.u(arrayList, jArr3);
                b6.q.b(4, "initialCapacity");
                Object[] objArr2 = new Object[4];
                int i60 = 0;
                int i61 = 0;
                boolean z13 = false;
                while (i60 < arrayList.size()) {
                    b6.d0 d0Var2 = (b6.d0) arrayList.get(i60);
                    b6.w0 f10 = d0Var2 == null ? b6.w0.f1464m : d0Var2.f();
                    f10.getClass();
                    int i62 = i61 + 1;
                    if (objArr2.length < i62) {
                        objArr = Arrays.copyOf(objArr2, b6.a0.d(objArr2.length, i62));
                    } else if (z13) {
                        objArr = (Object[]) objArr2.clone();
                    } else {
                        objArr2[i61] = f10;
                        i60++;
                        i61++;
                    }
                    objArr2 = objArr;
                    z13 = false;
                    objArr2[i61] = f10;
                    i60++;
                    i61++;
                }
                l4 = b6.g0.l(i61, objArr2);
            }
        }
        y1.q[] qVarArr = new y1.q[pVarArr.length];
        for (int i63 = 0; i63 < pVarArr.length; i63++) {
            y1.p pVar5 = pVarArr[i63];
            if (pVar5 != null) {
                int[] iArr13 = pVar5.f10484b;
                if (iArr13.length != 0) {
                    int length6 = iArr13.length;
                    d1.z0 z0Var5 = pVar5.f10483a;
                    if (length6 == 1) {
                        bVar = new y1.r(z0Var5, new int[]{iArr13[0]});
                    } else {
                        long j10 = 25000;
                        bVar = new y1.b(z0Var5, iArr13, fVar, 10000, j10, j10, (b6.g0) l4.get(i63));
                    }
                    qVarArr[i63] = bVar;
                }
            }
        }
        c1[] c1VarArr3 = new c1[i23];
        for (int i64 = 0; i64 < i23; i64++) {
            c1VarArr3[i64] = (iVar.B.get(i64) || iVar.f2407s.contains(Integer.valueOf(sVar.f10486b[i64])) || (sVar.f10486b[i64] != -2 && qVarArr[i64] == null)) ? null : c1.f5809c;
        }
        iVar.f2401m.getClass();
        Pair create = Pair.create(c1VarArr3, qVarArr);
        y1.q[] qVarArr2 = (y1.q[]) create.second;
        List[] listArr = new List[qVarArr2.length];
        for (int i65 = 0; i65 < qVarArr2.length; i65++) {
            y1.q qVar = qVarArr2[i65];
            if (qVar != null) {
                w0Var = b6.g0.q(qVar);
            } else {
                b6.e0 e0Var2 = b6.g0.f1391j;
                w0Var = b6.w0.f1464m;
            }
            listArr[i65] = w0Var;
        }
        b6.d0 d0Var3 = new b6.d0();
        int i66 = 0;
        while (true) {
            int i67 = sVar.f10485a;
            v1.c1[] c1VarArr4 = sVar.f10487c;
            if (i66 >= i67) {
                break;
            }
            v1.c1 c1Var7 = c1VarArr4[i66];
            List list = listArr[i66];
            int i68 = 0;
            while (i68 < c1Var7.f9256a) {
                d1.z0 a11 = c1Var7.a(i68);
                int i69 = c1VarArr4[i66].a(i68).f2616a;
                int[] iArr14 = new int[i69];
                int i70 = 0;
                for (int i71 = 0; i71 < i69; i71++) {
                    if ((sVar.f10489e[i66][i68][i71] & 7) == 4) {
                        iArr14[i70] = i71;
                        i70++;
                    }
                }
                int[] copyOf = Arrays.copyOf(iArr14, i70);
                List[] listArr2 = listArr;
                int i72 = 0;
                boolean z14 = false;
                int i73 = 0;
                int i74 = 16;
                String str2 = null;
                while (i72 < copyOf.length) {
                    String str3 = c1VarArr4[i66].a(i68).f2619d[copyOf[i72]].f2554m;
                    int i75 = i73 + 1;
                    if (i73 == 0) {
                        str2 = str3;
                    } else {
                        z14 = (!g1.w.a(str2, str3)) | z14;
                    }
                    i74 = Math.min(i74, sVar.f10489e[i66][i68][i72] & 24);
                    i72++;
                    i73 = i75;
                }
                if (z14) {
                    i74 = Math.min(i74, sVar.f10488d[i66]);
                }
                boolean z15 = i74 != 0;
                int i76 = a11.f2616a;
                int[] iArr15 = new int[i76];
                boolean[] zArr = new boolean[i76];
                for (int i77 = 0; i77 < a11.f2616a; i77++) {
                    iArr15[i77] = sVar.f10489e[i66][i68][i77] & 7;
                    int i78 = 0;
                    while (true) {
                        if (i78 >= list.size()) {
                            z9 = false;
                            break;
                        }
                        y1.q qVar2 = (y1.q) list.get(i78);
                        if (qVar2.j().equals(a11) && qVar2.t(i77) != -1) {
                            z9 = true;
                            break;
                        }
                        i78++;
                    }
                    zArr[i77] = z9;
                }
                d0Var3.a(new d1.e1(a11, z15, iArr15, zArr));
                i68++;
                listArr = listArr2;
            }
            i66++;
        }
        v1.c1 c1Var8 = sVar.f10490f;
        for (int i79 = 0; i79 < c1Var8.f9256a; i79++) {
            d1.z0 a12 = c1Var8.a(i79);
            int[] iArr16 = new int[a12.f2616a];
            Arrays.fill(iArr16, 0);
            d0Var3.a(new d1.e1(a12, false, iArr16, new boolean[a12.f2616a]));
        }
        y1.t tVar = new y1.t((c1[]) create.first, (y1.q[]) create.second, new f1(d0Var3.f()), sVar);
        for (y1.q qVar3 : tVar.f10493c) {
            if (qVar3 != null) {
                qVar3.o(f9);
            }
        }
        return tVar;
    }

    public final void i() {
        Object obj = this.f5939a;
        if (obj instanceof v1.d) {
            long j5 = this.f5944f.f5958d;
            if (j5 == -9223372036854775807L) {
                j5 = Long.MIN_VALUE;
            }
            v1.d dVar = (v1.d) obj;
            dVar.f9263m = 0L;
            dVar.f9264n = j5;
        }
    }
}
