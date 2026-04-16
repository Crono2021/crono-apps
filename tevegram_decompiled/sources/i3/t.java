package i3;

import d1.l0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class t implements h {

    /* renamed from: a, reason: collision with root package name */
    public final g1.p f4645a;

    /* renamed from: b, reason: collision with root package name */
    public final d2.w f4646b;

    /* renamed from: c, reason: collision with root package name */
    public final String f4647c;

    /* renamed from: d, reason: collision with root package name */
    public final int f4648d;

    /* renamed from: e, reason: collision with root package name */
    public d2.d0 f4649e;

    /* renamed from: f, reason: collision with root package name */
    public String f4650f;

    /* renamed from: g, reason: collision with root package name */
    public int f4651g = 0;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f4652i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f4653j;

    /* renamed from: k, reason: collision with root package name */
    public long f4654k;

    /* renamed from: l, reason: collision with root package name */
    public int f4655l;

    /* renamed from: m, reason: collision with root package name */
    public long f4656m;

    public t(String str, int i9) {
        g1.p pVar = new g1.p(4);
        this.f4645a = pVar;
        pVar.f3699a[0] = -1;
        this.f4646b = new d2.w();
        this.f4656m = -9223372036854775807L;
        this.f4647c = str;
        this.f4648d = i9;
    }

    @Override // i3.h
    public final void a() {
        this.f4651g = 0;
        this.h = 0;
        this.f4653j = false;
        this.f4656m = -9223372036854775807L;
    }

    @Override // i3.h
    public final void c(g1.p pVar) {
        g1.a.l(this.f4649e);
        while (pVar.a() > 0) {
            int i9 = this.f4651g;
            g1.p pVar2 = this.f4645a;
            if (i9 == 0) {
                byte[] bArr = pVar.f3699a;
                int i10 = pVar.f3700b;
                int i11 = pVar.f3701c;
                while (true) {
                    if (i10 >= i11) {
                        pVar.F(i11);
                        break;
                    }
                    byte b9 = bArr[i10];
                    boolean z8 = (b9 & 255) == 255;
                    boolean z9 = this.f4653j && (b9 & 224) == 224;
                    this.f4653j = z8;
                    if (z9) {
                        pVar.F(i10 + 1);
                        this.f4653j = false;
                        pVar2.f3699a[1] = bArr[i10];
                        this.h = 2;
                        this.f4651g = 1;
                        break;
                    }
                    i10++;
                }
            } else if (i9 == 1) {
                int min = Math.min(pVar.a(), 4 - this.h);
                pVar.e(this.h, min, pVar2.f3699a);
                int i12 = this.h + min;
                this.h = i12;
                if (i12 >= 4) {
                    pVar2.F(0);
                    int g9 = pVar2.g();
                    d2.w wVar = this.f4646b;
                    if (wVar.b(g9)) {
                        this.f4655l = wVar.f2747b;
                        if (!this.f4652i) {
                            this.f4654k = (wVar.f2751f * 1000000) / wVar.f2748c;
                            d1.r rVar = new d1.r();
                            rVar.f2518a = this.f4650f;
                            rVar.f2528l = l0.k((String) wVar.f2752g);
                            rVar.f2529m = 4096;
                            rVar.f2541y = wVar.f2749d;
                            rVar.f2542z = wVar.f2748c;
                            rVar.f2521d = this.f4647c;
                            rVar.f2523f = this.f4648d;
                            this.f4649e.e(new d1.s(rVar));
                            this.f4652i = true;
                        }
                        pVar2.F(0);
                        this.f4649e.c(4, pVar2);
                        this.f4651g = 2;
                    } else {
                        this.h = 0;
                        this.f4651g = 1;
                    }
                }
            } else {
                if (i9 != 2) {
                    androidx.fragment.app.a.l();
                    return;
                }
                int min2 = Math.min(pVar.a(), this.f4655l - this.h);
                this.f4649e.c(min2, pVar);
                int i13 = this.h + min2;
                this.h = i13;
                if (i13 >= this.f4655l) {
                    g1.a.k(this.f4656m != -9223372036854775807L);
                    this.f4649e.d(this.f4656m, 1, this.f4655l, 0, null);
                    this.f4656m += this.f4654k;
                    this.h = 0;
                    this.f4651g = 0;
                }
            }
        }
    }

    @Override // i3.h
    public final void d(int i9, long j5) {
        this.f4656m = j5;
    }

    @Override // i3.h
    public final void f(d2.o oVar, e0 e0Var) {
        e0Var.a();
        e0Var.b();
        this.f4650f = e0Var.f4484e;
        e0Var.b();
        this.f4649e = oVar.l(e0Var.f4483d, 1);
    }

    @Override // i3.h
    public final void e() {
    }
}
