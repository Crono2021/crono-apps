package w2;

import d2.d0;
import g1.w;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final d0 f9731a;

    /* renamed from: d, reason: collision with root package name */
    public s f9734d;

    /* renamed from: e, reason: collision with root package name */
    public f f9735e;

    /* renamed from: f, reason: collision with root package name */
    public int f9736f;

    /* renamed from: g, reason: collision with root package name */
    public int f9737g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public int f9738i;

    /* renamed from: l, reason: collision with root package name */
    public boolean f9741l;

    /* renamed from: b, reason: collision with root package name */
    public final r f9732b = new r();

    /* renamed from: c, reason: collision with root package name */
    public final g1.p f9733c = new g1.p();

    /* renamed from: j, reason: collision with root package name */
    public final g1.p f9739j = new g1.p(1);

    /* renamed from: k, reason: collision with root package name */
    public final g1.p f9740k = new g1.p();

    public h(d0 d0Var, s sVar, f fVar) {
        this.f9731a = d0Var;
        this.f9734d = sVar;
        this.f9735e = fVar;
        this.f9734d = sVar;
        this.f9735e = fVar;
        d0Var.e(sVar.f9838a.f9812f);
        d();
    }

    public final q a() {
        if (!this.f9741l) {
            return null;
        }
        r rVar = this.f9732b;
        f fVar = rVar.f9822a;
        int i9 = w.f3713a;
        int i10 = fVar.f9724a;
        q qVar = rVar.f9833m;
        if (qVar == null) {
            qVar = this.f9734d.f9838a.f9816k[i10];
        }
        if (qVar == null || !qVar.f9817a) {
            return null;
        }
        return qVar;
    }

    public final boolean b() {
        this.f9736f++;
        if (!this.f9741l) {
            return false;
        }
        int i9 = this.f9737g + 1;
        this.f9737g = i9;
        int[] iArr = this.f9732b.f9828g;
        int i10 = this.h;
        if (i9 != iArr[i10]) {
            return true;
        }
        this.h = i10 + 1;
        this.f9737g = 0;
        return false;
    }

    public final int c(int i9, int i10) {
        g1.p pVar;
        q a9 = a();
        if (a9 == null) {
            return 0;
        }
        int i11 = a9.f9820d;
        r rVar = this.f9732b;
        if (i11 != 0) {
            pVar = rVar.f9834n;
        } else {
            byte[] bArr = a9.f9821e;
            int i12 = w.f3713a;
            int length = bArr.length;
            g1.p pVar2 = this.f9740k;
            pVar2.D(bArr, length);
            i11 = bArr.length;
            pVar = pVar2;
        }
        boolean z8 = rVar.f9831k && rVar.f9832l[this.f9736f];
        boolean z9 = z8 || i10 != 0;
        g1.p pVar3 = this.f9739j;
        pVar3.f3699a[0] = (byte) ((z9 ? 128 : 0) | i11);
        pVar3.F(0);
        d0 d0Var = this.f9731a;
        d0Var.f(pVar3, 1, 1);
        d0Var.f(pVar, i11, 1);
        if (!z9) {
            return i11 + 1;
        }
        g1.p pVar4 = this.f9733c;
        if (!z8) {
            pVar4.C(8);
            byte[] bArr2 = pVar4.f3699a;
            bArr2[0] = 0;
            bArr2[1] = 1;
            bArr2[2] = (byte) 0;
            bArr2[3] = (byte) (i10 & 255);
            bArr2[4] = (byte) ((i9 >> 24) & 255);
            bArr2[5] = (byte) ((i9 >> 16) & 255);
            bArr2[6] = (byte) ((i9 >> 8) & 255);
            bArr2[7] = (byte) (i9 & 255);
            d0Var.f(pVar4, 8, 1);
            return i11 + 9;
        }
        g1.p pVar5 = rVar.f9834n;
        int z10 = pVar5.z();
        pVar5.G(-2);
        int i13 = (z10 * 6) + 2;
        if (i10 != 0) {
            pVar4.C(i13);
            byte[] bArr3 = pVar4.f3699a;
            pVar5.e(0, i13, bArr3);
            int i14 = (((bArr3[2] & 255) << 8) | (bArr3[3] & 255)) + i10;
            bArr3[2] = (byte) ((i14 >> 8) & 255);
            bArr3[3] = (byte) (i14 & 255);
        } else {
            pVar4 = pVar5;
        }
        d0Var.f(pVar4, i13, 1);
        return i11 + 1 + i13;
    }

    public final void d() {
        r rVar = this.f9732b;
        rVar.f9825d = 0;
        rVar.f9836p = 0L;
        rVar.f9837q = false;
        rVar.f9831k = false;
        rVar.f9835o = false;
        rVar.f9833m = null;
        this.f9736f = 0;
        this.h = 0;
        this.f9737g = 0;
        this.f9738i = 0;
        this.f9741l = false;
    }
}
