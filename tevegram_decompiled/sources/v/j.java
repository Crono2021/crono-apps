package v;

import a0.l;
import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j implements b {

    /* renamed from: a, reason: collision with root package name */
    public int f9185a = 16;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f9186b = new int[16];

    /* renamed from: c, reason: collision with root package name */
    public int[] f9187c = new int[16];

    /* renamed from: d, reason: collision with root package name */
    public int[] f9188d = new int[16];

    /* renamed from: e, reason: collision with root package name */
    public float[] f9189e = new float[16];

    /* renamed from: f, reason: collision with root package name */
    public int[] f9190f = new int[16];

    /* renamed from: g, reason: collision with root package name */
    public int[] f9191g = new int[16];
    public int h = 0;

    /* renamed from: i, reason: collision with root package name */
    public int f9192i = -1;

    /* renamed from: j, reason: collision with root package name */
    public final d f9193j;

    /* renamed from: k, reason: collision with root package name */
    public final l f9194k;

    public j(d dVar, l lVar) {
        this.f9193j = dVar;
        this.f9194k = lVar;
        clear();
    }

    @Override // v.b
    public final float a(int i9) {
        int i10 = this.h;
        int i11 = this.f9192i;
        for (int i12 = 0; i12 < i10; i12++) {
            if (i12 == i9) {
                return this.f9189e[i11];
            }
            i11 = this.f9191g[i11];
            if (i11 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // v.b
    public final float b(c cVar, boolean z8) {
        float g9 = g(cVar.f9149a);
        e(cVar.f9149a, z8);
        j jVar = (j) cVar.f9152d;
        int i9 = jVar.h;
        int i10 = 0;
        int i11 = 0;
        while (i10 < i9) {
            int i12 = jVar.f9188d[i11];
            if (i12 != -1) {
                f(((i[]) this.f9194k.f33l)[i12], jVar.f9189e[i11] * g9, z8);
                i10++;
            }
            i11++;
        }
        return g9;
    }

    @Override // v.b
    public final void c(i iVar, float f9) {
        if (f9 > -0.001f && f9 < 0.001f) {
            e(iVar, true);
            return;
        }
        int i9 = 0;
        if (this.h == 0) {
            m(0, iVar, f9);
            l(iVar, 0);
            this.f9192i = 0;
            return;
        }
        int n4 = n(iVar);
        if (n4 != -1) {
            this.f9189e[n4] = f9;
            return;
        }
        int i10 = this.h + 1;
        int i11 = this.f9185a;
        if (i10 >= i11) {
            int i12 = i11 * 2;
            this.f9188d = Arrays.copyOf(this.f9188d, i12);
            this.f9189e = Arrays.copyOf(this.f9189e, i12);
            this.f9190f = Arrays.copyOf(this.f9190f, i12);
            this.f9191g = Arrays.copyOf(this.f9191g, i12);
            this.f9187c = Arrays.copyOf(this.f9187c, i12);
            for (int i13 = this.f9185a; i13 < i12; i13++) {
                this.f9188d[i13] = -1;
                this.f9187c[i13] = -1;
            }
            this.f9185a = i12;
        }
        int i14 = this.h;
        int i15 = this.f9192i;
        int i16 = -1;
        for (int i17 = 0; i17 < i14; i17++) {
            int i18 = this.f9188d[i15];
            int i19 = iVar.f9175b;
            if (i18 == i19) {
                this.f9189e[i15] = f9;
                return;
            }
            if (i18 < i19) {
                i16 = i15;
            }
            i15 = this.f9191g[i15];
            if (i15 == -1) {
                break;
            }
        }
        while (true) {
            if (i9 >= this.f9185a) {
                i9 = -1;
                break;
            } else if (this.f9188d[i9] == -1) {
                break;
            } else {
                i9++;
            }
        }
        m(i9, iVar, f9);
        int[] iArr = this.f9190f;
        if (i16 != -1) {
            iArr[i9] = i16;
            int[] iArr2 = this.f9191g;
            iArr2[i9] = iArr2[i16];
            iArr2[i16] = i9;
        } else {
            iArr[i9] = -1;
            int i20 = this.h;
            int[] iArr3 = this.f9191g;
            if (i20 > 0) {
                iArr3[i9] = this.f9192i;
                this.f9192i = i9;
            } else {
                iArr3[i9] = -1;
            }
        }
        int i21 = this.f9191g[i9];
        if (i21 != -1) {
            iArr[i21] = i9;
        }
        l(iVar, i9);
    }

    @Override // v.b
    public final void clear() {
        int i9 = this.h;
        for (int i10 = 0; i10 < i9; i10++) {
            i h = h(i10);
            if (h != null) {
                h.b(this.f9193j);
            }
        }
        for (int i11 = 0; i11 < this.f9185a; i11++) {
            this.f9188d[i11] = -1;
            this.f9187c[i11] = -1;
        }
        for (int i12 = 0; i12 < 16; i12++) {
            this.f9186b[i12] = -1;
        }
        this.h = 0;
        this.f9192i = -1;
    }

    @Override // v.b
    public final int d() {
        return this.h;
    }

    @Override // v.b
    public final float e(i iVar, boolean z8) {
        int[] iArr;
        int i9;
        int n4 = n(iVar);
        if (n4 == -1) {
            return 0.0f;
        }
        int i10 = iVar.f9175b;
        int i11 = i10 % 16;
        int[] iArr2 = this.f9186b;
        int i12 = iArr2[i11];
        if (i12 != -1) {
            if (this.f9188d[i12] == i10) {
                int[] iArr3 = this.f9187c;
                iArr2[i11] = iArr3[i12];
                iArr3[i12] = -1;
            } else {
                while (true) {
                    iArr = this.f9187c;
                    i9 = iArr[i12];
                    if (i9 == -1 || this.f9188d[i9] == i10) {
                        break;
                    }
                    i12 = i9;
                }
                if (i9 != -1 && this.f9188d[i9] == i10) {
                    iArr[i12] = iArr[i9];
                    iArr[i9] = -1;
                }
            }
        }
        float f9 = this.f9189e[n4];
        if (this.f9192i == n4) {
            this.f9192i = this.f9191g[n4];
        }
        this.f9188d[n4] = -1;
        int[] iArr4 = this.f9190f;
        int i13 = iArr4[n4];
        if (i13 != -1) {
            int[] iArr5 = this.f9191g;
            iArr5[i13] = iArr5[n4];
        }
        int i14 = this.f9191g[n4];
        if (i14 != -1) {
            iArr4[i14] = iArr4[n4];
        }
        this.h--;
        iVar.f9183k--;
        if (z8) {
            iVar.b(this.f9193j);
        }
        return f9;
    }

    @Override // v.b
    public final void f(i iVar, float f9, boolean z8) {
        if (f9 <= -0.001f || f9 >= 0.001f) {
            int n4 = n(iVar);
            if (n4 == -1) {
                c(iVar, f9);
                return;
            }
            float[] fArr = this.f9189e;
            float f10 = fArr[n4] + f9;
            fArr[n4] = f10;
            if (f10 <= -0.001f || f10 >= 0.001f) {
                return;
            }
            fArr[n4] = 0.0f;
            e(iVar, z8);
        }
    }

    @Override // v.b
    public final float g(i iVar) {
        int n4 = n(iVar);
        if (n4 != -1) {
            return this.f9189e[n4];
        }
        return 0.0f;
    }

    @Override // v.b
    public final i h(int i9) {
        int i10 = this.h;
        if (i10 == 0) {
            return null;
        }
        int i11 = this.f9192i;
        for (int i12 = 0; i12 < i10; i12++) {
            if (i12 == i9 && i11 != -1) {
                return ((i[]) this.f9194k.f33l)[this.f9188d[i11]];
            }
            i11 = this.f9191g[i11];
            if (i11 == -1) {
                return null;
            }
        }
        return null;
    }

    @Override // v.b
    public final boolean i(i iVar) {
        return n(iVar) != -1;
    }

    @Override // v.b
    public final void j(float f9) {
        int i9 = this.h;
        int i10 = this.f9192i;
        for (int i11 = 0; i11 < i9; i11++) {
            float[] fArr = this.f9189e;
            fArr[i10] = fArr[i10] / f9;
            i10 = this.f9191g[i10];
            if (i10 == -1) {
                return;
            }
        }
    }

    @Override // v.b
    public final void k() {
        int i9 = this.h;
        int i10 = this.f9192i;
        for (int i11 = 0; i11 < i9; i11++) {
            float[] fArr = this.f9189e;
            fArr[i10] = fArr[i10] * (-1.0f);
            i10 = this.f9191g[i10];
            if (i10 == -1) {
                return;
            }
        }
    }

    public final void l(i iVar, int i9) {
        int[] iArr;
        int i10 = iVar.f9175b % 16;
        int[] iArr2 = this.f9186b;
        int i11 = iArr2[i10];
        if (i11 == -1) {
            iArr2[i10] = i9;
        } else {
            while (true) {
                iArr = this.f9187c;
                int i12 = iArr[i11];
                if (i12 == -1) {
                    break;
                } else {
                    i11 = i12;
                }
            }
            iArr[i11] = i9;
        }
        this.f9187c[i9] = -1;
    }

    public final void m(int i9, i iVar, float f9) {
        this.f9188d[i9] = iVar.f9175b;
        this.f9189e[i9] = f9;
        this.f9190f[i9] = -1;
        this.f9191g[i9] = -1;
        iVar.a(this.f9193j);
        iVar.f9183k++;
        this.h++;
    }

    public final int n(i iVar) {
        if (this.h != 0) {
            int i9 = iVar.f9175b;
            int i10 = this.f9186b[i9 % 16];
            if (i10 != -1) {
                if (this.f9188d[i10] == i9) {
                    return i10;
                }
                do {
                    i10 = this.f9187c[i10];
                    if (i10 == -1) {
                        break;
                    }
                } while (this.f9188d[i10] != i9);
                if (i10 != -1 && this.f9188d[i10] == i9) {
                    return i10;
                }
            }
        }
        return -1;
    }

    public final String toString() {
        String str = hashCode() + " { ";
        int i9 = this.h;
        for (int i10 = 0; i10 < i9; i10++) {
            i h = h(i10);
            if (h != null) {
                String str2 = str + h + " = " + a(i10) + " ";
                int n4 = n(h);
                String concat = str2.concat("[p: ");
                int i11 = this.f9190f[n4];
                l lVar = this.f9194k;
                String concat2 = (i11 != -1 ? concat + ((i[]) lVar.f33l)[this.f9188d[this.f9190f[n4]]] : concat.concat("none")).concat(", n: ");
                str = (this.f9191g[n4] != -1 ? concat2 + ((i[]) lVar.f33l)[this.f9188d[this.f9191g[n4]]] : concat2.concat("none")).concat("]");
            }
        }
        return str + " }";
    }
}
