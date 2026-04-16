package i3;

import d1.l0;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g implements h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4500a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f4501b;

    /* renamed from: c, reason: collision with root package name */
    public long f4502c;

    /* renamed from: d, reason: collision with root package name */
    public int f4503d;

    /* renamed from: e, reason: collision with root package name */
    public int f4504e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f4505f;

    /* renamed from: g, reason: collision with root package name */
    public Object f4506g;

    public g(List list) {
        this.f4500a = 0;
        this.f4505f = list;
        this.f4506g = new d2.d0[list.size()];
        this.f4502c = -9223372036854775807L;
    }

    @Override // i3.h
    public final void a() {
        switch (this.f4500a) {
            case 0:
                this.f4501b = false;
                this.f4502c = -9223372036854775807L;
                break;
            default:
                this.f4501b = false;
                this.f4502c = -9223372036854775807L;
                break;
        }
    }

    @Override // i3.h
    public final void c(g1.p pVar) {
        boolean z8;
        boolean z9;
        switch (this.f4500a) {
            case 0:
                if (this.f4501b) {
                    if (this.f4503d == 2) {
                        if (pVar.a() == 0) {
                            z9 = false;
                        } else {
                            if (pVar.t() != 32) {
                                this.f4501b = false;
                            }
                            this.f4503d--;
                            z9 = this.f4501b;
                        }
                        if (!z9) {
                        }
                    }
                    if (this.f4503d == 1) {
                        if (pVar.a() == 0) {
                            z8 = false;
                        } else {
                            if (pVar.t() != 0) {
                                this.f4501b = false;
                            }
                            this.f4503d--;
                            z8 = this.f4501b;
                        }
                        if (!z8) {
                        }
                    }
                    int i9 = pVar.f3700b;
                    int a9 = pVar.a();
                    for (d2.d0 d0Var : (d2.d0[]) this.f4506g) {
                        pVar.F(i9);
                        d0Var.c(a9, pVar);
                    }
                    this.f4504e += a9;
                    break;
                }
                break;
            default:
                g1.p pVar2 = (g1.p) this.f4505f;
                g1.a.l((d2.d0) this.f4506g);
                if (this.f4501b) {
                    int a10 = pVar.a();
                    int i10 = this.f4504e;
                    if (i10 < 10) {
                        int min = Math.min(a10, 10 - i10);
                        System.arraycopy(pVar.f3699a, pVar.f3700b, pVar2.f3699a, this.f4504e, min);
                        if (this.f4504e + min == 10) {
                            pVar2.F(0);
                            if (73 != pVar2.t() || 68 != pVar2.t() || 51 != pVar2.t()) {
                                g1.a.D("Id3Reader", "Discarding invalid ID3 tag");
                                this.f4501b = false;
                                break;
                            } else {
                                pVar2.G(3);
                                this.f4503d = pVar2.s() + 10;
                            }
                        }
                    }
                    int min2 = Math.min(a10, this.f4503d - this.f4504e);
                    ((d2.d0) this.f4506g).c(min2, pVar);
                    this.f4504e += min2;
                    break;
                }
                break;
        }
    }

    @Override // i3.h
    public final void d(int i9, long j5) {
        switch (this.f4500a) {
            case 0:
                if ((i9 & 4) != 0) {
                    this.f4501b = true;
                    this.f4502c = j5;
                    this.f4504e = 0;
                    this.f4503d = 2;
                    break;
                }
                break;
            default:
                if ((i9 & 4) != 0) {
                    this.f4501b = true;
                    this.f4502c = j5;
                    this.f4503d = 0;
                    this.f4504e = 0;
                    break;
                }
                break;
        }
    }

    @Override // i3.h
    public final void e() {
        int i9;
        switch (this.f4500a) {
            case 0:
                if (this.f4501b) {
                    g1.a.k(this.f4502c != -9223372036854775807L);
                    for (d2.d0 d0Var : (d2.d0[]) this.f4506g) {
                        d0Var.d(this.f4502c, 1, this.f4504e, 0, null);
                    }
                    this.f4501b = false;
                    break;
                }
                break;
            default:
                g1.a.l((d2.d0) this.f4506g);
                if (this.f4501b && (i9 = this.f4503d) != 0 && this.f4504e == i9) {
                    g1.a.k(this.f4502c != -9223372036854775807L);
                    ((d2.d0) this.f4506g).d(this.f4502c, 1, this.f4503d, 0, null);
                    this.f4501b = false;
                    break;
                }
                break;
        }
    }

    @Override // i3.h
    public final void f(d2.o oVar, e0 e0Var) {
        switch (this.f4500a) {
            case 0:
                d2.d0[] d0VarArr = (d2.d0[]) this.f4506g;
                for (int i9 = 0; i9 < d0VarArr.length; i9++) {
                    d0 d0Var = (d0) ((List) this.f4505f).get(i9);
                    e0Var.a();
                    e0Var.b();
                    d2.d0 l4 = oVar.l(e0Var.f4483d, 3);
                    d1.r rVar = new d1.r();
                    e0Var.b();
                    rVar.f2518a = e0Var.f4484e;
                    rVar.f2528l = l0.k("application/dvbsubs");
                    rVar.f2530n = Collections.singletonList(d0Var.f4457b);
                    rVar.f2521d = d0Var.f4456a;
                    androidx.activity.g.v(rVar, l4);
                    d0VarArr[i9] = l4;
                }
                break;
            default:
                e0Var.a();
                e0Var.b();
                d2.d0 l9 = oVar.l(e0Var.f4483d, 5);
                this.f4506g = l9;
                d1.r rVar2 = new d1.r();
                e0Var.b();
                rVar2.f2518a = e0Var.f4484e;
                rVar2.f2528l = l0.k("application/id3");
                androidx.activity.g.v(rVar2, l9);
                break;
        }
    }

    public g() {
        this.f4500a = 1;
        this.f4505f = new g1.p(10);
        this.f4502c = -9223372036854775807L;
    }
}
