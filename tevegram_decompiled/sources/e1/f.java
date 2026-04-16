package e1;

import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final int f3030a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3031b;

    /* renamed from: c, reason: collision with root package name */
    public final float f3032c;

    /* renamed from: d, reason: collision with root package name */
    public final float f3033d;

    /* renamed from: e, reason: collision with root package name */
    public final float f3034e;

    /* renamed from: f, reason: collision with root package name */
    public final int f3035f;

    /* renamed from: g, reason: collision with root package name */
    public final int f3036g;
    public final int h;

    /* renamed from: i, reason: collision with root package name */
    public final short[] f3037i;

    /* renamed from: j, reason: collision with root package name */
    public short[] f3038j;

    /* renamed from: k, reason: collision with root package name */
    public int f3039k;

    /* renamed from: l, reason: collision with root package name */
    public short[] f3040l;

    /* renamed from: m, reason: collision with root package name */
    public int f3041m;

    /* renamed from: n, reason: collision with root package name */
    public short[] f3042n;

    /* renamed from: o, reason: collision with root package name */
    public int f3043o;

    /* renamed from: p, reason: collision with root package name */
    public int f3044p;

    /* renamed from: q, reason: collision with root package name */
    public int f3045q;

    /* renamed from: r, reason: collision with root package name */
    public int f3046r;

    /* renamed from: s, reason: collision with root package name */
    public int f3047s;

    /* renamed from: t, reason: collision with root package name */
    public int f3048t;

    /* renamed from: u, reason: collision with root package name */
    public int f3049u;

    /* renamed from: v, reason: collision with root package name */
    public int f3050v;

    public f(int i9, int i10, float f9, float f10, int i11) {
        this.f3030a = i9;
        this.f3031b = i10;
        this.f3032c = f9;
        this.f3033d = f10;
        this.f3034e = i9 / i11;
        this.f3035f = i9 / 400;
        int i12 = i9 / 65;
        this.f3036g = i12;
        int i13 = i12 * 2;
        this.h = i13;
        this.f3037i = new short[i13];
        this.f3038j = new short[i13 * i10];
        this.f3040l = new short[i13 * i10];
        this.f3042n = new short[i13 * i10];
    }

    public static void e(int i9, int i10, short[] sArr, int i11, short[] sArr2, int i12, short[] sArr3, int i13) {
        for (int i14 = 0; i14 < i10; i14++) {
            int i15 = (i11 * i10) + i14;
            int i16 = (i13 * i10) + i14;
            int i17 = (i12 * i10) + i14;
            for (int i18 = 0; i18 < i9; i18++) {
                sArr[i15] = (short) (((sArr3[i16] * i18) + ((i9 - i18) * sArr2[i17])) / i9);
                i15 += i10;
                i17 += i10;
                i16 += i10;
            }
        }
    }

    public final void a(short[] sArr, int i9, int i10) {
        short[] c9 = c(this.f3040l, this.f3041m, i10);
        this.f3040l = c9;
        int i11 = this.f3031b;
        System.arraycopy(sArr, i9 * i11, c9, this.f3041m * i11, i11 * i10);
        this.f3041m += i10;
    }

    public final void b(short[] sArr, int i9, int i10) {
        int i11 = this.h / i10;
        int i12 = this.f3031b;
        int i13 = i10 * i12;
        int i14 = i9 * i12;
        for (int i15 = 0; i15 < i11; i15++) {
            int i16 = 0;
            for (int i17 = 0; i17 < i13; i17++) {
                i16 += sArr[(i15 * i13) + i14 + i17];
            }
            this.f3037i[i15] = (short) (i16 / i13);
        }
    }

    public final short[] c(short[] sArr, int i9, int i10) {
        int length = sArr.length;
        int i11 = this.f3031b;
        int i12 = length / i11;
        return i9 + i10 <= i12 ? sArr : Arrays.copyOf(sArr, (((i12 * 3) / 2) + i10) * i11);
    }

    public final int d(short[] sArr, int i9, int i10, int i11) {
        int i12 = i9 * this.f3031b;
        int i13 = 255;
        int i14 = 1;
        int i15 = 0;
        int i16 = 0;
        while (i10 <= i11) {
            int i17 = 0;
            for (int i18 = 0; i18 < i10; i18++) {
                i17 += Math.abs(sArr[i12 + i18] - sArr[(i12 + i10) + i18]);
            }
            if (i17 * i15 < i14 * i10) {
                i15 = i10;
                i14 = i17;
            }
            if (i17 * i13 > i16 * i10) {
                i13 = i10;
                i16 = i17;
            }
            i10++;
        }
        this.f3049u = i14 / i15;
        this.f3050v = i16 / i13;
        return i15;
    }

    public final void f() {
        float f9;
        float f10;
        float f11;
        double d9;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17 = this.f3041m;
        float f12 = this.f3032c;
        float f13 = this.f3033d;
        float f14 = f12 / f13;
        float f15 = this.f3034e * f13;
        double d10 = f14;
        int i18 = this.f3030a;
        int i19 = 1;
        int i20 = this.f3031b;
        if (d10 > 1.00001d || d10 < 0.99999d) {
            int i21 = this.f3039k;
            int i22 = this.h;
            if (i21 >= i22) {
                int i23 = 0;
                while (true) {
                    int i24 = this.f3046r;
                    if (i24 > 0) {
                        int min = Math.min(i22, i24);
                        a(this.f3038j, i23, min);
                        this.f3046r -= min;
                        i23 += min;
                        f10 = f14;
                        f11 = f15;
                        d9 = d10;
                        f9 = 1.0f;
                    } else {
                        short[] sArr = this.f3038j;
                        int i25 = i18 > 4000 ? i18 / 4000 : 1;
                        f9 = 1.0f;
                        int i26 = this.f3036g;
                        int i27 = this.f3035f;
                        if (i20 == i19 && i25 == i19) {
                            i9 = d(sArr, i23, i27, i26);
                            f10 = f14;
                            f11 = f15;
                            d9 = d10;
                        } else {
                            b(sArr, i23, i25);
                            f10 = f14;
                            f11 = f15;
                            short[] sArr2 = this.f3037i;
                            d9 = d10;
                            int d11 = d(sArr2, 0, i27 / i25, i26 / i25);
                            if (i25 != 1) {
                                int i28 = d11 * i25;
                                int i29 = i25 * 4;
                                int i30 = i28 - i29;
                                int i31 = i28 + i29;
                                if (i30 >= i27) {
                                    i27 = i30;
                                }
                                if (i31 <= i26) {
                                    i26 = i31;
                                }
                                if (i20 == 1) {
                                    i9 = d(sArr, i23, i27, i26);
                                } else {
                                    b(sArr, i23, 1);
                                    i9 = d(sArr2, 0, i27, i26);
                                }
                            } else {
                                i9 = d11;
                            }
                        }
                        int i32 = this.f3049u;
                        int i33 = this.f3050v;
                        if (i32 == 0 || (i10 = this.f3047s) == 0 || i33 > i32 * 3 || i32 * 2 <= this.f3048t * 3) {
                            i10 = i9;
                        }
                        this.f3048t = i32;
                        this.f3047s = i9;
                        short[] sArr3 = this.f3038j;
                        if (d9 > 1.0d) {
                            if (f10 >= 2.0f) {
                                i12 = (int) (i10 / (f10 - 1.0f));
                            } else {
                                this.f3046r = (int) (((2.0f - f10) * i10) / (f10 - 1.0f));
                                i12 = i10;
                            }
                            short[] c9 = c(this.f3040l, this.f3041m, i12);
                            this.f3040l = c9;
                            int i34 = i23 + i10;
                            int i35 = i23;
                            int i36 = i12;
                            e(i36, this.f3031b, c9, this.f3041m, sArr3, i35, sArr3, i34);
                            this.f3041m += i36;
                            i23 = i10 + i36 + i35;
                        } else {
                            int i37 = i23;
                            if (f10 < 0.5f) {
                                i11 = (int) ((i10 * f10) / (1.0f - f10));
                            } else {
                                this.f3046r = (int) ((((2.0f * f10) - 1.0f) * i10) / (1.0f - f10));
                                i11 = i10;
                            }
                            int i38 = i10 + i11;
                            short[] c10 = c(this.f3040l, this.f3041m, i38);
                            this.f3040l = c10;
                            System.arraycopy(sArr3, i37 * i20, c10, this.f3041m * i20, i10 * i20);
                            e(i11, this.f3031b, this.f3040l, this.f3041m + i10, sArr3, i37 + i10, sArr3, i37);
                            this.f3041m += i38;
                            i23 = i37 + i11;
                        }
                    }
                    if (i23 + i22 > i21) {
                        break;
                    }
                    f14 = f10;
                    f15 = f11;
                    d10 = d9;
                    i19 = 1;
                }
                int i39 = this.f3039k - i23;
                short[] sArr4 = this.f3038j;
                System.arraycopy(sArr4, i23 * i20, sArr4, 0, i39 * i20);
                this.f3039k = i39;
                if (f11 != f9 || this.f3041m == i17) {
                }
                int i40 = (int) (i18 / f11);
                while (true) {
                    if (i40 <= 16384 && i18 <= 16384) {
                        break;
                    }
                    i40 /= 2;
                    i18 /= 2;
                }
                int i41 = this.f3041m - i17;
                short[] c11 = c(this.f3042n, this.f3043o, i41);
                this.f3042n = c11;
                System.arraycopy(this.f3040l, i17 * i20, c11, this.f3043o * i20, i41 * i20);
                this.f3041m = i17;
                this.f3043o += i41;
                int i42 = 0;
                while (true) {
                    i13 = this.f3043o;
                    i14 = i13 - 1;
                    if (i42 >= i14) {
                        break;
                    }
                    while (true) {
                        i15 = this.f3044p + 1;
                        int i43 = i15 * i40;
                        i16 = this.f3045q;
                        if (i43 <= i16 * i18) {
                            break;
                        }
                        this.f3040l = c(this.f3040l, this.f3041m, 1);
                        for (int i44 = 0; i44 < i20; i44++) {
                            short[] sArr5 = this.f3040l;
                            int i45 = (this.f3041m * i20) + i44;
                            short[] sArr6 = this.f3042n;
                            int i46 = (i42 * i20) + i44;
                            short s8 = sArr6[i46];
                            short s9 = sArr6[i46 + i20];
                            int i47 = this.f3045q * i18;
                            int i48 = this.f3044p;
                            int i49 = i48 * i40;
                            int i50 = (i48 + 1) * i40;
                            int i51 = i50 - i47;
                            int i52 = i50 - i49;
                            sArr5[i45] = (short) ((((i52 - i51) * s9) + (s8 * i51)) / i52);
                        }
                        this.f3045q++;
                        this.f3041m++;
                    }
                    this.f3044p = i15;
                    if (i15 == i18) {
                        this.f3044p = 0;
                        g1.a.k(i16 == i40);
                        this.f3045q = 0;
                    }
                    i42++;
                }
                if (i14 == 0) {
                    return;
                }
                short[] sArr7 = this.f3042n;
                System.arraycopy(sArr7, i14 * i20, sArr7, 0, (i13 - i14) * i20);
                this.f3043o -= i14;
                return;
            }
        } else {
            a(this.f3038j, 0, this.f3039k);
            this.f3039k = 0;
        }
        f11 = f15;
        f9 = 1.0f;
        if (f11 != f9) {
        }
    }
}
