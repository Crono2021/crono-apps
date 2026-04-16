package i3;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a0 implements f0 {

    /* renamed from: a, reason: collision with root package name */
    public final z f4404a;

    /* renamed from: b, reason: collision with root package name */
    public final g1.p f4405b = new g1.p(32);

    /* renamed from: c, reason: collision with root package name */
    public int f4406c;

    /* renamed from: d, reason: collision with root package name */
    public int f4407d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f4408e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f4409f;

    public a0(z zVar) {
        this.f4404a = zVar;
    }

    @Override // i3.f0
    public final void a() {
        this.f4409f = true;
    }

    @Override // i3.f0
    public final void b(int i9, g1.p pVar) {
        boolean z8 = (i9 & 1) != 0;
        int t8 = z8 ? pVar.f3700b + pVar.t() : -1;
        if (this.f4409f) {
            if (!z8) {
                return;
            }
            this.f4409f = false;
            pVar.F(t8);
            this.f4407d = 0;
        }
        while (pVar.a() > 0) {
            int i10 = this.f4407d;
            g1.p pVar2 = this.f4405b;
            if (i10 < 3) {
                if (i10 == 0) {
                    int t9 = pVar.t();
                    pVar.F(pVar.f3700b - 1);
                    if (t9 == 255) {
                        this.f4409f = true;
                        return;
                    }
                }
                int min = Math.min(pVar.a(), 3 - this.f4407d);
                pVar.e(this.f4407d, min, pVar2.f3699a);
                int i11 = this.f4407d + min;
                this.f4407d = i11;
                if (i11 == 3) {
                    pVar2.F(0);
                    pVar2.E(3);
                    pVar2.G(1);
                    int t10 = pVar2.t();
                    int t11 = pVar2.t();
                    this.f4408e = (t10 & 128) != 0;
                    int i12 = (((t10 & 15) << 8) | t11) + 3;
                    this.f4406c = i12;
                    byte[] bArr = pVar2.f3699a;
                    if (bArr.length < i12) {
                        pVar2.b(Math.min(4098, Math.max(i12, bArr.length * 2)));
                    }
                }
            } else {
                int min2 = Math.min(pVar.a(), this.f4406c - this.f4407d);
                pVar.e(this.f4407d, min2, pVar2.f3699a);
                int i13 = this.f4407d + min2;
                this.f4407d = i13;
                int i14 = this.f4406c;
                if (i13 != i14) {
                    continue;
                } else {
                    if (!this.f4408e) {
                        pVar2.E(i14);
                    } else {
                        if (g1.w.k(0, i14, -1, pVar2.f3699a) != 0) {
                            this.f4409f = true;
                            return;
                        }
                        pVar2.E(this.f4406c - 4);
                    }
                    pVar2.F(0);
                    this.f4404a.c(pVar2);
                    this.f4407d = 0;
                }
            }
        }
    }

    @Override // i3.f0
    public final void f(g1.u uVar, d2.o oVar, e0 e0Var) {
        this.f4404a.f(uVar, oVar, e0Var);
        this.f4409f = true;
    }
}
