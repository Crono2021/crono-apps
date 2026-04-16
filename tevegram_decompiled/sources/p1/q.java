package p1;

import d1.i0;
import d1.j0;
import java.util.Map;
import v1.u0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class q extends u0 {
    public final Map H;
    public d1.n I;

    public q(z1.d dVar, o1.g gVar, o1.d dVar2, Map map) {
        super(dVar, gVar, dVar2);
        this.H = map;
    }

    @Override // v1.u0
    public final d1.s m(d1.s sVar) {
        d1.n nVar;
        d1.n nVar2 = this.I;
        if (nVar2 == null) {
            nVar2 = sVar.f2557p;
        }
        if (nVar2 != null && (nVar = (d1.n) this.H.get(nVar2.f2505k)) != null) {
            nVar2 = nVar;
        }
        j0 j0Var = sVar.f2552k;
        j0 j0Var2 = null;
        if (j0Var != null) {
            i0[] i0VarArr = j0Var.f2490i;
            int length = i0VarArr.length;
            int i9 = 0;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    i10 = -1;
                    break;
                }
                i0 i0Var = i0VarArr[i10];
                if ((i0Var instanceof q2.l) && "com.apple.streaming.transportStreamTimestamp".equals(((q2.l) i0Var).f8459j)) {
                    break;
                }
                i10++;
            }
            if (i10 != -1) {
                if (length != 1) {
                    i0[] i0VarArr2 = new i0[length - 1];
                    while (i9 < length) {
                        if (i9 != i10) {
                            i0VarArr2[i9 < i10 ? i9 : i9 - 1] = i0VarArr[i9];
                        }
                        i9++;
                    }
                    j0Var2 = new j0(i0VarArr2);
                }
            }
            if (nVar2 == sVar.f2557p || j0Var != sVar.f2552k) {
                d1.r a9 = sVar.a();
                a9.f2531o = nVar2;
                a9.f2526j = j0Var;
                sVar = new d1.s(a9);
            }
            return super.m(sVar);
        }
        j0Var = j0Var2;
        if (nVar2 == sVar.f2557p) {
        }
        d1.r a92 = sVar.a();
        a92.f2531o = nVar2;
        a92.f2526j = j0Var;
        sVar = new d1.s(a92);
        return super.m(sVar);
    }
}
