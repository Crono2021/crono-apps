package com.google.crypto.tink.shaded.protobuf;

import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g1 {

    /* renamed from: f, reason: collision with root package name */
    public static final g1 f2237f = new g1(0, new int[0], new Object[0], false);

    /* renamed from: a, reason: collision with root package name */
    public int f2238a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f2239b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f2240c;

    /* renamed from: d, reason: collision with root package name */
    public int f2241d = -1;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2242e;

    public g1(int i9, int[] iArr, Object[] objArr, boolean z8) {
        this.f2238a = i9;
        this.f2239b = iArr;
        this.f2240c = objArr;
        this.f2242e = z8;
    }

    public static g1 c() {
        return new g1(0, new int[8], new Object[8], true);
    }

    public final void a(int i9) {
        int[] iArr = this.f2239b;
        if (i9 > iArr.length) {
            int i10 = this.f2238a;
            int i11 = (i10 / 2) + i10;
            if (i11 >= i9) {
                i9 = i11;
            }
            if (i9 < 8) {
                i9 = 8;
            }
            this.f2239b = Arrays.copyOf(iArr, i9);
            this.f2240c = Arrays.copyOf(this.f2240c, i9);
        }
    }

    public final int b() {
        int h;
        int j5;
        int d9;
        int i9 = this.f2241d;
        if (i9 != -1) {
            return i9;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < this.f2238a; i11++) {
            int i12 = this.f2239b[i11];
            int i13 = i12 >>> 3;
            int i14 = i12 & 7;
            if (i14 != 0) {
                if (i14 == 1) {
                    ((Long) this.f2240c[i11]).getClass();
                    d9 = n.d(i13);
                } else if (i14 == 2) {
                    d9 = n.a(i13, (j) this.f2240c[i11]);
                } else if (i14 == 3) {
                    h = n.h(i13) * 2;
                    j5 = ((g1) this.f2240c[i11]).b();
                } else {
                    if (i14 != 5) {
                        throw new IllegalStateException(e0.c());
                    }
                    ((Integer) this.f2240c[i11]).getClass();
                    d9 = n.c(i13);
                }
                i10 = d9 + i10;
            } else {
                long longValue = ((Long) this.f2240c[i11]).longValue();
                h = n.h(i13);
                j5 = n.j(longValue);
            }
            i10 = j5 + h + i10;
        }
        this.f2241d = i10;
        return i10;
    }

    public final void d(int i9, Object obj) {
        if (!this.f2242e) {
            androidx.fragment.app.a.p();
            return;
        }
        a(this.f2238a + 1);
        int[] iArr = this.f2239b;
        int i10 = this.f2238a;
        iArr[i10] = i9;
        this.f2240c[i10] = obj;
        this.f2238a = i10 + 1;
    }

    public final void e(n0 n0Var) {
        if (this.f2238a == 0) {
            return;
        }
        n0Var.getClass();
        n nVar = (n) n0Var.f2279a;
        for (int i9 = 0; i9 < this.f2238a; i9++) {
            int i10 = this.f2239b[i9];
            Object obj = this.f2240c[i9];
            int i11 = i10 >>> 3;
            int i12 = i10 & 7;
            if (i12 == 0) {
                nVar.t(i11, ((Long) obj).longValue());
            } else if (i12 == 1) {
                nVar.o(i11, ((Long) obj).longValue());
            } else if (i12 == 2) {
                n0Var.a(i11, (j) obj);
            } else if (i12 == 3) {
                nVar.r(i11, 3);
                ((g1) obj).e(n0Var);
                nVar.r(i11, 4);
            } else {
                if (i12 != 5) {
                    throw new RuntimeException(e0.c());
                }
                nVar.m(i11, ((Integer) obj).intValue());
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof g1)) {
            return false;
        }
        g1 g1Var = (g1) obj;
        int i9 = this.f2238a;
        if (i9 == g1Var.f2238a) {
            int[] iArr = this.f2239b;
            int[] iArr2 = g1Var.f2239b;
            int i10 = 0;
            while (true) {
                if (i10 >= i9) {
                    Object[] objArr = this.f2240c;
                    Object[] objArr2 = g1Var.f2240c;
                    int i11 = this.f2238a;
                    for (int i12 = 0; i12 < i11; i12++) {
                        if (objArr[i12].equals(objArr2[i12])) {
                        }
                    }
                    return true;
                }
                if (iArr[i10] != iArr2[i10]) {
                    break;
                }
                i10++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i9 = this.f2238a;
        int i10 = (527 + i9) * 31;
        int[] iArr = this.f2239b;
        int i11 = 17;
        int i12 = 17;
        for (int i13 = 0; i13 < i9; i13++) {
            i12 = (i12 * 31) + iArr[i13];
        }
        int i14 = (i10 + i12) * 31;
        Object[] objArr = this.f2240c;
        int i15 = this.f2238a;
        for (int i16 = 0; i16 < i15; i16++) {
            i11 = (i11 * 31) + objArr[i16].hashCode();
        }
        return i14 + i11;
    }
}
