package l1;

import android.util.Pair;
import java.util.HashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a1 extends d1.y0 {

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f5763k = 0;

    /* renamed from: b, reason: collision with root package name */
    public final int f5764b;

    /* renamed from: c, reason: collision with root package name */
    public final v1.y0 f5765c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5766d;

    /* renamed from: e, reason: collision with root package name */
    public final int f5767e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f5768f;

    /* renamed from: g, reason: collision with root package name */
    public final int[] f5769g;
    public final d1.y0[] h;

    /* renamed from: i, reason: collision with root package name */
    public final Object[] f5770i;

    /* renamed from: j, reason: collision with root package name */
    public final HashMap f5771j;

    public a1(d1.y0[] y0VarArr, Object[] objArr, v1.y0 y0Var) {
        this.f5765c = y0Var;
        this.f5764b = y0Var.f9445b.length;
        int length = y0VarArr.length;
        this.h = y0VarArr;
        this.f5768f = new int[length];
        this.f5769g = new int[length];
        this.f5770i = objArr;
        this.f5771j = new HashMap();
        int length2 = y0VarArr.length;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i9 < length2) {
            d1.y0 y0Var2 = y0VarArr[i9];
            this.h[i12] = y0Var2;
            this.f5769g[i12] = i10;
            this.f5768f[i12] = i11;
            i10 += y0Var2.o();
            i11 += this.h[i12].h();
            this.f5771j.put(objArr[i12], Integer.valueOf(i12));
            i9++;
            i12++;
        }
        this.f5766d = i10;
        this.f5767e = i11;
    }

    @Override // d1.y0
    public final int a(boolean z8) {
        if (this.f5764b != 0) {
            int i9 = 0;
            if (z8) {
                int[] iArr = this.f5765c.f9445b;
                i9 = iArr.length > 0 ? iArr[0] : -1;
            }
            do {
                d1.y0[] y0VarArr = this.h;
                if (!y0VarArr[i9].p()) {
                    return y0VarArr[i9].a(z8) + this.f5769g[i9];
                }
                i9 = q(i9, z8);
            } while (i9 != -1);
        }
        return -1;
    }

    @Override // d1.y0
    public final int b(Object obj) {
        int b9;
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            Object obj2 = pair.first;
            Object obj3 = pair.second;
            Integer num = (Integer) this.f5771j.get(obj2);
            int intValue = num == null ? -1 : num.intValue();
            if (intValue != -1 && (b9 = this.h[intValue].b(obj3)) != -1) {
                return this.f5768f[intValue] + b9;
            }
        }
        return -1;
    }

    @Override // d1.y0
    public final int c(boolean z8) {
        int i9;
        int i10 = this.f5764b;
        if (i10 != 0) {
            if (z8) {
                int[] iArr = this.f5765c.f9445b;
                i9 = iArr.length > 0 ? iArr[iArr.length - 1] : -1;
            } else {
                i9 = i10 - 1;
            }
            do {
                d1.y0[] y0VarArr = this.h;
                if (!y0VarArr[i9].p()) {
                    return y0VarArr[i9].c(z8) + this.f5769g[i9];
                }
                i9 = r(i9, z8);
            } while (i9 != -1);
        }
        return -1;
    }

    @Override // d1.y0
    public final int e(int i9, int i10, boolean z8) {
        int[] iArr = this.f5769g;
        int e9 = g1.w.e(iArr, i9 + 1, false, false);
        int i11 = iArr[e9];
        d1.y0[] y0VarArr = this.h;
        int e10 = y0VarArr[e9].e(i9 - i11, i10 != 2 ? i10 : 0, z8);
        if (e10 != -1) {
            return i11 + e10;
        }
        int q4 = q(e9, z8);
        while (q4 != -1 && y0VarArr[q4].p()) {
            q4 = q(q4, z8);
        }
        if (q4 != -1) {
            return y0VarArr[q4].a(z8) + iArr[q4];
        }
        if (i10 == 2) {
            return a(z8);
        }
        return -1;
    }

    @Override // d1.y0
    public final d1.w0 f(int i9, d1.w0 w0Var, boolean z8) {
        int[] iArr = this.f5768f;
        int e9 = g1.w.e(iArr, i9 + 1, false, false);
        int i10 = this.f5769g[e9];
        this.h[e9].f(i9 - iArr[e9], w0Var, z8);
        w0Var.f2586c += i10;
        if (z8) {
            Object obj = this.f5770i[e9];
            Object obj2 = w0Var.f2585b;
            obj2.getClass();
            w0Var.f2585b = Pair.create(obj, obj2);
        }
        return w0Var;
    }

    @Override // d1.y0
    public final d1.w0 g(Object obj, d1.w0 w0Var) {
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        Integer num = (Integer) this.f5771j.get(obj2);
        int intValue = num == null ? -1 : num.intValue();
        int i9 = this.f5769g[intValue];
        this.h[intValue].g(obj3, w0Var);
        w0Var.f2586c += i9;
        w0Var.f2585b = obj;
        return w0Var;
    }

    @Override // d1.y0
    public final int h() {
        return this.f5767e;
    }

    @Override // d1.y0
    public final int k(int i9, int i10, boolean z8) {
        int[] iArr = this.f5769g;
        int e9 = g1.w.e(iArr, i9 + 1, false, false);
        int i11 = iArr[e9];
        d1.y0[] y0VarArr = this.h;
        int k3 = y0VarArr[e9].k(i9 - i11, i10 != 2 ? i10 : 0, z8);
        if (k3 != -1) {
            return i11 + k3;
        }
        int r8 = r(e9, z8);
        while (r8 != -1 && y0VarArr[r8].p()) {
            r8 = r(r8, z8);
        }
        if (r8 != -1) {
            return y0VarArr[r8].c(z8) + iArr[r8];
        }
        if (i10 == 2) {
            return c(z8);
        }
        return -1;
    }

    @Override // d1.y0
    public final Object l(int i9) {
        int[] iArr = this.f5768f;
        int e9 = g1.w.e(iArr, i9 + 1, false, false);
        return Pair.create(this.f5770i[e9], this.h[e9].l(i9 - iArr[e9]));
    }

    @Override // d1.y0
    public final d1.x0 m(int i9, d1.x0 x0Var, long j5) {
        int[] iArr = this.f5769g;
        int e9 = g1.w.e(iArr, i9 + 1, false, false);
        int i10 = iArr[e9];
        int i11 = this.f5768f[e9];
        this.h[e9].m(i9 - i10, x0Var, j5);
        Object obj = this.f5770i[e9];
        if (!d1.x0.f2592r.equals(x0Var.f2594a)) {
            obj = Pair.create(obj, x0Var.f2594a);
        }
        x0Var.f2594a = obj;
        x0Var.f2607o += i11;
        x0Var.f2608p += i11;
        return x0Var;
    }

    @Override // d1.y0
    public final int o() {
        return this.f5766d;
    }

    public final int q(int i9, boolean z8) {
        if (!z8) {
            if (i9 < this.f5764b - 1) {
                return i9 + 1;
            }
            return -1;
        }
        v1.y0 y0Var = this.f5765c;
        int i10 = y0Var.f9446c[i9] + 1;
        int[] iArr = y0Var.f9445b;
        if (i10 < iArr.length) {
            return iArr[i10];
        }
        return -1;
    }

    public final int r(int i9, boolean z8) {
        if (!z8) {
            if (i9 > 0) {
                return i9 - 1;
            }
            return -1;
        }
        v1.y0 y0Var = this.f5765c;
        int i10 = y0Var.f9446c[i9] - 1;
        if (i10 >= 0) {
            return y0Var.f9445b[i10];
        }
        return -1;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a1(java.util.ArrayList r8, v1.y0 r9) {
        /*
            r7 = this;
            int r0 = r8.size()
            d1.y0[] r0 = new d1.y0[r0]
            int r1 = r8.size()
            r2 = 0
            r3 = 0
            r4 = 0
        Ld:
            if (r4 >= r1) goto L21
            java.lang.Object r5 = r8.get(r4)
            int r4 = r4 + 1
            l1.o0 r5 = (l1.o0) r5
            int r6 = r3 + 1
            d1.y0 r5 = r5.b()
            r0[r3] = r5
            r3 = r6
            goto Ld
        L21:
            int r1 = r8.size()
            java.lang.Object[] r1 = new java.lang.Object[r1]
            int r3 = r8.size()
            r4 = 0
        L2c:
            if (r4 >= r3) goto L40
            java.lang.Object r5 = r8.get(r4)
            int r4 = r4 + 1
            l1.o0 r5 = (l1.o0) r5
            int r6 = r2 + 1
            java.lang.Object r5 = r5.a()
            r1[r2] = r5
            r2 = r6
            goto L2c
        L40:
            r7.<init>(r0, r1, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.a1.<init>(java.util.ArrayList, v1.y0):void");
    }
}
