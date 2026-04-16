package v;

import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public boolean f9174a;

    /* renamed from: e, reason: collision with root package name */
    public float f9178e;

    /* renamed from: l, reason: collision with root package name */
    public int f9184l;

    /* renamed from: b, reason: collision with root package name */
    public int f9175b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f9176c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f9177d = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f9179f = false;

    /* renamed from: g, reason: collision with root package name */
    public final float[] f9180g = new float[9];
    public final float[] h = new float[9];

    /* renamed from: i, reason: collision with root package name */
    public c[] f9181i = new c[16];

    /* renamed from: j, reason: collision with root package name */
    public int f9182j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f9183k = 0;

    public i(int i9) {
        this.f9184l = i9;
    }

    public final void a(c cVar) {
        int i9 = 0;
        while (true) {
            int i10 = this.f9182j;
            c[] cVarArr = this.f9181i;
            if (i9 >= i10) {
                if (i10 >= cVarArr.length) {
                    this.f9181i = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
                }
                c[] cVarArr2 = this.f9181i;
                int i11 = this.f9182j;
                cVarArr2[i11] = cVar;
                this.f9182j = i11 + 1;
                return;
            }
            if (cVarArr[i9] == cVar) {
                return;
            } else {
                i9++;
            }
        }
    }

    public final void b(c cVar) {
        int i9 = this.f9182j;
        int i10 = 0;
        while (i10 < i9) {
            if (this.f9181i[i10] == cVar) {
                while (i10 < i9 - 1) {
                    c[] cVarArr = this.f9181i;
                    int i11 = i10 + 1;
                    cVarArr[i10] = cVarArr[i11];
                    i10 = i11;
                }
                this.f9182j--;
                return;
            }
            i10++;
        }
    }

    public final void c() {
        this.f9184l = 5;
        this.f9177d = 0;
        this.f9175b = -1;
        this.f9176c = -1;
        this.f9178e = 0.0f;
        this.f9179f = false;
        int i9 = this.f9182j;
        for (int i10 = 0; i10 < i9; i10++) {
            this.f9181i[i10] = null;
        }
        this.f9182j = 0;
        this.f9183k = 0;
        this.f9174a = false;
        Arrays.fill(this.h, 0.0f);
    }

    public final void d(c cVar) {
        int i9 = this.f9182j;
        for (int i10 = 0; i10 < i9; i10++) {
            this.f9181i[i10].h(cVar, false);
        }
        this.f9182j = 0;
    }

    public final String toString() {
        return "" + this.f9175b;
    }
}
