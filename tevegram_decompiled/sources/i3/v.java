package i3;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class v implements f0 {

    /* renamed from: a, reason: collision with root package name */
    public final h f4663a;

    /* renamed from: b, reason: collision with root package name */
    public final a3.g f4664b = new a3.g(new byte[10], 10);

    /* renamed from: c, reason: collision with root package name */
    public int f4665c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f4666d;

    /* renamed from: e, reason: collision with root package name */
    public g1.u f4667e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f4668f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f4669g;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public int f4670i;

    /* renamed from: j, reason: collision with root package name */
    public int f4671j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f4672k;

    /* renamed from: l, reason: collision with root package name */
    public long f4673l;

    public v(h hVar) {
        this.f4663a = hVar;
    }

    @Override // i3.f0
    public final void a() {
        this.f4665c = 0;
        this.f4666d = 0;
        this.h = false;
        this.f4663a.a();
    }

    @Override // i3.f0
    public final void b(int i9, g1.p pVar) {
        int i10;
        g1.a.l(this.f4667e);
        int i11 = i9 & 1;
        h hVar = this.f4663a;
        int i12 = 2;
        int i13 = 0;
        if (i11 != 0) {
            int i14 = this.f4665c;
            if (i14 != 0 && i14 != 1) {
                if (i14 == 2) {
                    g1.a.D("PesReader", "Unexpected start indicator reading extended header");
                } else {
                    if (i14 != 3) {
                        androidx.fragment.app.a.l();
                        return;
                    }
                    if (this.f4671j != -1) {
                        g1.a.D("PesReader", "Unexpected start indicator: expected " + this.f4671j + " more bytes");
                    }
                    hVar.e();
                }
            }
            this.f4665c = 1;
            this.f4666d = 0;
        }
        int i15 = i9;
        while (pVar.a() > 0) {
            int i16 = this.f4665c;
            if (i16 != 0) {
                a3.g gVar = this.f4664b;
                if (i16 != 1) {
                    if (i16 == i12) {
                        if (c(pVar, gVar.f104b, Math.min(10, this.f4670i)) && c(pVar, null, this.f4670i)) {
                            gVar.p(i13);
                            this.f4673l = -9223372036854775807L;
                            if (this.f4668f) {
                                gVar.s(4);
                                gVar.s(1);
                                gVar.s(1);
                                long i17 = (gVar.i(15) << 15) | (gVar.i(3) << 30) | gVar.i(15);
                                gVar.s(1);
                                if (!this.h && this.f4669g) {
                                    gVar.s(4);
                                    gVar.s(1);
                                    gVar.s(1);
                                    gVar.s(1);
                                    this.f4667e.b((gVar.i(3) << 30) | (gVar.i(15) << 15) | gVar.i(15));
                                    this.h = true;
                                }
                                this.f4673l = this.f4667e.b(i17);
                            }
                            i15 |= this.f4672k ? 4 : 0;
                            hVar.d(i15, this.f4673l);
                            this.f4665c = 3;
                            this.f4666d = 0;
                        }
                    } else {
                        if (i16 != 3) {
                            androidx.fragment.app.a.l();
                            return;
                        }
                        int a9 = pVar.a();
                        int i18 = this.f4671j;
                        int i19 = i18 == -1 ? 0 : a9 - i18;
                        if (i19 > 0) {
                            a9 -= i19;
                            pVar.E(pVar.f3700b + a9);
                        }
                        hVar.c(pVar);
                        int i20 = this.f4671j;
                        if (i20 != -1) {
                            int i21 = i20 - a9;
                            this.f4671j = i21;
                            if (i21 == 0) {
                                hVar.e();
                                this.f4665c = 1;
                                this.f4666d = i13;
                            }
                        }
                    }
                } else if (c(pVar, gVar.f104b, 9)) {
                    gVar.p(0);
                    int i22 = gVar.i(24);
                    if (i22 != 1) {
                        androidx.activity.g.t(i22, "Unexpected start code prefix: ", "PesReader");
                        this.f4671j = -1;
                        i10 = 0;
                    } else {
                        gVar.s(8);
                        int i23 = gVar.i(16);
                        gVar.s(5);
                        this.f4672k = gVar.h();
                        gVar.s(2);
                        this.f4668f = gVar.h();
                        this.f4669g = gVar.h();
                        gVar.s(6);
                        int i24 = gVar.i(8);
                        this.f4670i = i24;
                        if (i23 == 0) {
                            this.f4671j = -1;
                        } else {
                            int i25 = (i23 - 3) - i24;
                            this.f4671j = i25;
                            if (i25 < 0) {
                                g1.a.D("PesReader", "Found negative packet payload size: " + this.f4671j);
                                this.f4671j = -1;
                            }
                        }
                        i10 = 2;
                    }
                    this.f4665c = i10;
                    this.f4666d = 0;
                }
            } else {
                pVar.G(pVar.a());
            }
            i12 = 2;
            i13 = 0;
        }
    }

    public final boolean c(g1.p pVar, byte[] bArr, int i9) {
        int min = Math.min(pVar.a(), i9 - this.f4666d);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            pVar.G(min);
        } else {
            pVar.e(this.f4666d, min, bArr);
        }
        int i10 = this.f4666d + min;
        this.f4666d = i10;
        return i10 == i9;
    }

    @Override // i3.f0
    public final void f(g1.u uVar, d2.o oVar, e0 e0Var) {
        this.f4667e = uVar;
        this.f4663a.f(oVar, e0Var);
    }
}
