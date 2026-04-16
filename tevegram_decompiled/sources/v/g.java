package v;

import a0.k;
import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g extends c {

    /* renamed from: f, reason: collision with root package name */
    public i[] f9171f;

    /* renamed from: g, reason: collision with root package name */
    public i[] f9172g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public f f9173i;

    @Override // v.c
    public final i d(boolean[] zArr) {
        int i9 = -1;
        for (int i10 = 0; i10 < this.h; i10++) {
            i[] iVarArr = this.f9171f;
            i iVar = iVarArr[i10];
            if (!zArr[iVar.f9175b]) {
                f fVar = this.f9173i;
                fVar.f9169i = iVar;
                int i11 = 8;
                if (i9 == -1) {
                    while (i11 >= 0) {
                        float f9 = fVar.f9169i.h[i11];
                        if (f9 <= 0.0f) {
                            if (f9 < 0.0f) {
                                i9 = i10;
                                break;
                            }
                            i11--;
                        }
                    }
                } else {
                    i iVar2 = iVarArr[i9];
                    while (true) {
                        if (i11 >= 0) {
                            float f10 = iVar2.h[i11];
                            float f11 = fVar.f9169i.h[i11];
                            if (f11 == f10) {
                                i11--;
                            } else if (f11 >= f10) {
                            }
                        }
                    }
                }
            }
        }
        if (i9 == -1) {
            return null;
        }
        return this.f9171f[i9];
    }

    @Override // v.c
    public final void h(c cVar, boolean z8) {
        i iVar = cVar.f9149a;
        if (iVar == null) {
            return;
        }
        float[] fArr = iVar.h;
        b bVar = cVar.f9152d;
        int d9 = bVar.d();
        for (int i9 = 0; i9 < d9; i9++) {
            i h = bVar.h(i9);
            float a9 = bVar.a(i9);
            f fVar = this.f9173i;
            fVar.f9169i = h;
            if (h.f9174a) {
                boolean z9 = true;
                for (int i10 = 0; i10 < 9; i10++) {
                    float[] fArr2 = fVar.f9169i.h;
                    float f9 = (fArr[i10] * a9) + fArr2[i10];
                    fArr2[i10] = f9;
                    if (Math.abs(f9) < 1.0E-4f) {
                        fVar.f9169i.h[i10] = 0.0f;
                    } else {
                        z9 = false;
                    }
                }
                if (z9) {
                    fVar.f9170j.j(fVar.f9169i);
                }
            } else {
                for (int i11 = 0; i11 < 9; i11++) {
                    float f10 = fArr[i11];
                    if (f10 != 0.0f) {
                        float f11 = f10 * a9;
                        if (Math.abs(f11) < 1.0E-4f) {
                            f11 = 0.0f;
                        }
                        fVar.f9169i.h[i11] = f11;
                    } else {
                        fVar.f9169i.h[i11] = 0.0f;
                    }
                }
                i(h);
            }
            this.f9150b = (cVar.f9150b * a9) + this.f9150b;
        }
        j(iVar);
    }

    public final void i(i iVar) {
        int i9;
        i[] iVarArr;
        int i10 = this.h + 1;
        i[] iVarArr2 = this.f9171f;
        if (i10 > iVarArr2.length) {
            i[] iVarArr3 = (i[]) Arrays.copyOf(iVarArr2, iVarArr2.length * 2);
            this.f9171f = iVarArr3;
            this.f9172g = (i[]) Arrays.copyOf(iVarArr3, iVarArr3.length * 2);
        }
        i[] iVarArr4 = this.f9171f;
        int i11 = this.h;
        iVarArr4[i11] = iVar;
        int i12 = i11 + 1;
        this.h = i12;
        if (i12 > 1 && iVarArr4[i11].f9175b > iVar.f9175b) {
            int i13 = 0;
            while (true) {
                i9 = this.h;
                iVarArr = this.f9172g;
                if (i13 >= i9) {
                    break;
                }
                iVarArr[i13] = this.f9171f[i13];
                i13++;
            }
            Arrays.sort(iVarArr, 0, i9, new k(13));
            for (int i14 = 0; i14 < this.h; i14++) {
                this.f9171f[i14] = this.f9172g[i14];
            }
        }
        iVar.f9174a = true;
        iVar.a(this);
    }

    public final void j(i iVar) {
        int i9 = 0;
        while (i9 < this.h) {
            if (this.f9171f[i9] == iVar) {
                while (true) {
                    int i10 = this.h;
                    if (i9 >= i10 - 1) {
                        this.h = i10 - 1;
                        iVar.f9174a = false;
                        return;
                    } else {
                        i[] iVarArr = this.f9171f;
                        int i11 = i9 + 1;
                        iVarArr[i9] = iVarArr[i11];
                        i9 = i11;
                    }
                }
            } else {
                i9++;
            }
        }
    }

    @Override // v.c
    public final String toString() {
        f fVar = this.f9173i;
        String str = " goal -> (" + this.f9150b + ") : ";
        for (int i9 = 0; i9 < this.h; i9++) {
            fVar.f9169i = this.f9171f[i9];
            str = str + fVar + " ";
        }
        return str;
    }
}
