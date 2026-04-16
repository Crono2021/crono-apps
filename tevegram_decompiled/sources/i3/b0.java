package i3;

import d1.l0;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4423a;

    /* renamed from: b, reason: collision with root package name */
    public final List f4424b;

    /* renamed from: c, reason: collision with root package name */
    public final d2.d0[] f4425c;

    public b0(int i9, List list) {
        this.f4423a = i9;
        switch (i9) {
            case 1:
                this.f4424b = list;
                this.f4425c = new d2.d0[list.size()];
                break;
            default:
                this.f4424b = list;
                this.f4425c = new d2.d0[list.size()];
                break;
        }
    }

    public void a(long j5, g1.p pVar) {
        if (pVar.a() < 9) {
            return;
        }
        int g9 = pVar.g();
        int g10 = pVar.g();
        int t8 = pVar.t();
        if (g9 == 434 && g10 == 1195456820 && t8 == 3) {
            d2.b.e(j5, pVar, this.f4425c);
        }
    }

    public final void b(d2.o oVar, e0 e0Var) {
        switch (this.f4423a) {
            case 0:
                int i9 = 0;
                while (true) {
                    d2.d0[] d0VarArr = this.f4425c;
                    if (i9 >= d0VarArr.length) {
                        break;
                    } else {
                        e0Var.a();
                        e0Var.b();
                        d2.d0 l4 = oVar.l(e0Var.f4483d, 3);
                        d1.s sVar = (d1.s) this.f4424b.get(i9);
                        String str = sVar.f2554m;
                        g1.a.e("Invalid closed caption MIME type provided: " + str, "application/cea-608".equals(str) || "application/cea-708".equals(str));
                        String str2 = sVar.f2543a;
                        if (str2 == null) {
                            e0Var.b();
                            str2 = e0Var.f4484e;
                        }
                        d1.r rVar = new d1.r();
                        rVar.f2518a = str2;
                        rVar.f2528l = l0.k(str);
                        rVar.f2522e = sVar.f2547e;
                        rVar.f2521d = sVar.f2546d;
                        rVar.D = sVar.E;
                        rVar.f2530n = sVar.f2556o;
                        androidx.activity.g.v(rVar, l4);
                        d0VarArr[i9] = l4;
                        i9++;
                    }
                }
                break;
            default:
                int i10 = 0;
                while (true) {
                    d2.d0[] d0VarArr2 = this.f4425c;
                    if (i10 >= d0VarArr2.length) {
                        break;
                    } else {
                        e0Var.a();
                        e0Var.b();
                        d2.d0 l9 = oVar.l(e0Var.f4483d, 3);
                        d1.s sVar2 = (d1.s) this.f4424b.get(i10);
                        String str3 = sVar2.f2554m;
                        g1.a.e("Invalid closed caption MIME type provided: " + str3, "application/cea-608".equals(str3) || "application/cea-708".equals(str3));
                        d1.r rVar2 = new d1.r();
                        e0Var.b();
                        rVar2.f2518a = e0Var.f4484e;
                        rVar2.f2528l = l0.k(str3);
                        rVar2.f2522e = sVar2.f2547e;
                        rVar2.f2521d = sVar2.f2546d;
                        rVar2.D = sVar2.E;
                        rVar2.f2530n = sVar2.f2556o;
                        androidx.activity.g.v(rVar2, l9);
                        d0VarArr2[i10] = l9;
                        i10++;
                    }
                }
                break;
        }
    }
}
