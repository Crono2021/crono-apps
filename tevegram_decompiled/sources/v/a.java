package v;

import a0.l;
import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements b {

    /* renamed from: b, reason: collision with root package name */
    public final c f9141b;

    /* renamed from: c, reason: collision with root package name */
    public final l f9142c;

    /* renamed from: a, reason: collision with root package name */
    public int f9140a = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f9143d = 8;

    /* renamed from: e, reason: collision with root package name */
    public int[] f9144e = new int[8];

    /* renamed from: f, reason: collision with root package name */
    public int[] f9145f = new int[8];

    /* renamed from: g, reason: collision with root package name */
    public float[] f9146g = new float[8];
    public int h = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f9147i = -1;

    /* renamed from: j, reason: collision with root package name */
    public boolean f9148j = false;

    public a(c cVar, l lVar) {
        this.f9141b = cVar;
        this.f9142c = lVar;
    }

    @Override // v.b
    public final float a(int i9) {
        int i10 = this.h;
        for (int i11 = 0; i10 != -1 && i11 < this.f9140a; i11++) {
            if (i11 == i9) {
                return this.f9146g[i10];
            }
            i10 = this.f9145f[i10];
        }
        return 0.0f;
    }

    @Override // v.b
    public final float b(c cVar, boolean z8) {
        float g9 = g(cVar.f9149a);
        e(cVar.f9149a, z8);
        b bVar = cVar.f9152d;
        int d9 = bVar.d();
        for (int i9 = 0; i9 < d9; i9++) {
            i h = bVar.h(i9);
            f(h, bVar.g(h) * g9, z8);
        }
        return g9;
    }

    @Override // v.b
    public final void c(i iVar, float f9) {
        if (f9 == 0.0f) {
            e(iVar, true);
            return;
        }
        int i9 = this.h;
        c cVar = this.f9141b;
        if (i9 == -1) {
            this.h = 0;
            this.f9146g[0] = f9;
            this.f9144e[0] = iVar.f9175b;
            this.f9145f[0] = -1;
            iVar.f9183k++;
            iVar.a(cVar);
            this.f9140a++;
            if (this.f9148j) {
                return;
            }
            int i10 = this.f9147i + 1;
            this.f9147i = i10;
            int[] iArr = this.f9144e;
            if (i10 >= iArr.length) {
                this.f9148j = true;
                this.f9147i = iArr.length - 1;
                return;
            }
            return;
        }
        int i11 = -1;
        for (int i12 = 0; i9 != -1 && i12 < this.f9140a; i12++) {
            int i13 = this.f9144e[i9];
            int i14 = iVar.f9175b;
            if (i13 == i14) {
                this.f9146g[i9] = f9;
                return;
            }
            if (i13 < i14) {
                i11 = i9;
            }
            i9 = this.f9145f[i9];
        }
        int i15 = this.f9147i;
        int i16 = i15 + 1;
        if (this.f9148j) {
            int[] iArr2 = this.f9144e;
            if (iArr2[i15] != -1) {
                i15 = iArr2.length;
            }
        } else {
            i15 = i16;
        }
        int[] iArr3 = this.f9144e;
        if (i15 >= iArr3.length && this.f9140a < iArr3.length) {
            int i17 = 0;
            while (true) {
                int[] iArr4 = this.f9144e;
                if (i17 >= iArr4.length) {
                    break;
                }
                if (iArr4[i17] == -1) {
                    i15 = i17;
                    break;
                }
                i17++;
            }
        }
        int[] iArr5 = this.f9144e;
        if (i15 >= iArr5.length) {
            i15 = iArr5.length;
            int i18 = this.f9143d * 2;
            this.f9143d = i18;
            this.f9148j = false;
            this.f9147i = i15 - 1;
            this.f9146g = Arrays.copyOf(this.f9146g, i18);
            this.f9144e = Arrays.copyOf(this.f9144e, this.f9143d);
            this.f9145f = Arrays.copyOf(this.f9145f, this.f9143d);
        }
        this.f9144e[i15] = iVar.f9175b;
        this.f9146g[i15] = f9;
        int[] iArr6 = this.f9145f;
        if (i11 != -1) {
            iArr6[i15] = iArr6[i11];
            iArr6[i11] = i15;
        } else {
            iArr6[i15] = this.h;
            this.h = i15;
        }
        iVar.f9183k++;
        iVar.a(cVar);
        int i19 = this.f9140a + 1;
        this.f9140a = i19;
        if (!this.f9148j) {
            this.f9147i++;
        }
        int[] iArr7 = this.f9144e;
        if (i19 >= iArr7.length) {
            this.f9148j = true;
        }
        if (this.f9147i >= iArr7.length) {
            this.f9148j = true;
            this.f9147i = iArr7.length - 1;
        }
    }

    @Override // v.b
    public final void clear() {
        int i9 = this.h;
        for (int i10 = 0; i9 != -1 && i10 < this.f9140a; i10++) {
            i iVar = ((i[]) this.f9142c.f33l)[this.f9144e[i9]];
            if (iVar != null) {
                iVar.b(this.f9141b);
            }
            i9 = this.f9145f[i9];
        }
        this.h = -1;
        this.f9147i = -1;
        this.f9148j = false;
        this.f9140a = 0;
    }

    @Override // v.b
    public final int d() {
        return this.f9140a;
    }

    @Override // v.b
    public final float e(i iVar, boolean z8) {
        int i9 = this.h;
        if (i9 == -1) {
            return 0.0f;
        }
        int i10 = 0;
        int i11 = -1;
        while (i9 != -1 && i10 < this.f9140a) {
            if (this.f9144e[i9] == iVar.f9175b) {
                int i12 = this.h;
                int[] iArr = this.f9145f;
                if (i9 == i12) {
                    this.h = iArr[i9];
                } else {
                    iArr[i11] = iArr[i9];
                }
                if (z8) {
                    iVar.b(this.f9141b);
                }
                iVar.f9183k--;
                this.f9140a--;
                this.f9144e[i9] = -1;
                if (this.f9148j) {
                    this.f9147i = i9;
                }
                return this.f9146g[i9];
            }
            i10++;
            i11 = i9;
            i9 = this.f9145f[i9];
        }
        return 0.0f;
    }

    @Override // v.b
    public final void f(i iVar, float f9, boolean z8) {
        if (f9 <= -0.001f || f9 >= 0.001f) {
            int i9 = this.h;
            c cVar = this.f9141b;
            if (i9 == -1) {
                this.h = 0;
                this.f9146g[0] = f9;
                this.f9144e[0] = iVar.f9175b;
                this.f9145f[0] = -1;
                iVar.f9183k++;
                iVar.a(cVar);
                this.f9140a++;
                if (this.f9148j) {
                    return;
                }
                int i10 = this.f9147i + 1;
                this.f9147i = i10;
                int[] iArr = this.f9144e;
                if (i10 >= iArr.length) {
                    this.f9148j = true;
                    this.f9147i = iArr.length - 1;
                    return;
                }
                return;
            }
            int i11 = -1;
            for (int i12 = 0; i9 != -1 && i12 < this.f9140a; i12++) {
                int i13 = this.f9144e[i9];
                int i14 = iVar.f9175b;
                if (i13 == i14) {
                    float[] fArr = this.f9146g;
                    float f10 = fArr[i9] + f9;
                    if (f10 > -0.001f && f10 < 0.001f) {
                        f10 = 0.0f;
                    }
                    fArr[i9] = f10;
                    if (f10 == 0.0f) {
                        int i15 = this.h;
                        int[] iArr2 = this.f9145f;
                        if (i9 == i15) {
                            this.h = iArr2[i9];
                        } else {
                            iArr2[i11] = iArr2[i9];
                        }
                        if (z8) {
                            iVar.b(cVar);
                        }
                        if (this.f9148j) {
                            this.f9147i = i9;
                        }
                        iVar.f9183k--;
                        this.f9140a--;
                        return;
                    }
                    return;
                }
                if (i13 < i14) {
                    i11 = i9;
                }
                i9 = this.f9145f[i9];
            }
            int i16 = this.f9147i;
            int i17 = i16 + 1;
            if (this.f9148j) {
                int[] iArr3 = this.f9144e;
                if (iArr3[i16] != -1) {
                    i16 = iArr3.length;
                }
            } else {
                i16 = i17;
            }
            int[] iArr4 = this.f9144e;
            if (i16 >= iArr4.length && this.f9140a < iArr4.length) {
                int i18 = 0;
                while (true) {
                    int[] iArr5 = this.f9144e;
                    if (i18 >= iArr5.length) {
                        break;
                    }
                    if (iArr5[i18] == -1) {
                        i16 = i18;
                        break;
                    }
                    i18++;
                }
            }
            int[] iArr6 = this.f9144e;
            if (i16 >= iArr6.length) {
                i16 = iArr6.length;
                int i19 = this.f9143d * 2;
                this.f9143d = i19;
                this.f9148j = false;
                this.f9147i = i16 - 1;
                this.f9146g = Arrays.copyOf(this.f9146g, i19);
                this.f9144e = Arrays.copyOf(this.f9144e, this.f9143d);
                this.f9145f = Arrays.copyOf(this.f9145f, this.f9143d);
            }
            this.f9144e[i16] = iVar.f9175b;
            this.f9146g[i16] = f9;
            int[] iArr7 = this.f9145f;
            if (i11 != -1) {
                iArr7[i16] = iArr7[i11];
                iArr7[i11] = i16;
            } else {
                iArr7[i16] = this.h;
                this.h = i16;
            }
            iVar.f9183k++;
            iVar.a(cVar);
            this.f9140a++;
            if (!this.f9148j) {
                this.f9147i++;
            }
            int i20 = this.f9147i;
            int[] iArr8 = this.f9144e;
            if (i20 >= iArr8.length) {
                this.f9148j = true;
                this.f9147i = iArr8.length - 1;
            }
        }
    }

    @Override // v.b
    public final float g(i iVar) {
        int i9 = this.h;
        for (int i10 = 0; i9 != -1 && i10 < this.f9140a; i10++) {
            if (this.f9144e[i9] == iVar.f9175b) {
                return this.f9146g[i9];
            }
            i9 = this.f9145f[i9];
        }
        return 0.0f;
    }

    @Override // v.b
    public final i h(int i9) {
        int i10 = this.h;
        for (int i11 = 0; i10 != -1 && i11 < this.f9140a; i11++) {
            if (i11 == i9) {
                return ((i[]) this.f9142c.f33l)[this.f9144e[i10]];
            }
            i10 = this.f9145f[i10];
        }
        return null;
    }

    @Override // v.b
    public final boolean i(i iVar) {
        int i9 = this.h;
        if (i9 != -1) {
            for (int i10 = 0; i9 != -1 && i10 < this.f9140a; i10++) {
                if (this.f9144e[i9] == iVar.f9175b) {
                    return true;
                }
                i9 = this.f9145f[i9];
            }
        }
        return false;
    }

    @Override // v.b
    public final void j(float f9) {
        int i9 = this.h;
        for (int i10 = 0; i9 != -1 && i10 < this.f9140a; i10++) {
            float[] fArr = this.f9146g;
            fArr[i9] = fArr[i9] / f9;
            i9 = this.f9145f[i9];
        }
    }

    @Override // v.b
    public final void k() {
        int i9 = this.h;
        for (int i10 = 0; i9 != -1 && i10 < this.f9140a; i10++) {
            float[] fArr = this.f9146g;
            fArr[i9] = fArr[i9] * (-1.0f);
            i9 = this.f9145f[i9];
        }
    }

    public final String toString() {
        int i9 = this.h;
        String str = "";
        for (int i10 = 0; i9 != -1 && i10 < this.f9140a; i10++) {
            str = (str.concat(" -> ") + this.f9146g[i9] + " : ") + ((i[]) this.f9142c.f33l)[this.f9144e[i9]];
            i9 = this.f9145f[i9];
        }
        return str;
    }
}
