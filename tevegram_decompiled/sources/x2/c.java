package x2;

import d1.s;
import d2.q;
import g1.p;
import java.util.Arrays;
import v1.q0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c extends i {

    /* renamed from: n, reason: collision with root package name */
    public q f10055n;

    /* renamed from: o, reason: collision with root package name */
    public q0 f10056o;

    @Override // x2.i
    public final long b(p pVar) {
        byte[] bArr = pVar.f3699a;
        if (bArr[0] != -1) {
            return -1L;
        }
        int i9 = (bArr[2] & 255) >> 4;
        if (i9 == 6 || i9 == 7) {
            pVar.G(4);
            pVar.A();
        }
        int q4 = d2.b.q(i9, pVar);
        pVar.F(0);
        return q4;
    }

    @Override // x2.i
    public final boolean c(p pVar, long j5, m1.b bVar) {
        byte[] bArr = pVar.f3699a;
        q qVar = this.f10055n;
        if (qVar == null) {
            q qVar2 = new q(bArr, 17);
            this.f10055n = qVar2;
            bVar.f6510j = qVar2.c(Arrays.copyOfRange(bArr, 9, pVar.f3701c), null);
            return true;
        }
        byte b9 = bArr[0];
        if ((b9 & Byte.MAX_VALUE) != 3) {
            if (b9 != -1) {
                return true;
            }
            q0 q0Var = this.f10056o;
            if (q0Var != null) {
                q0Var.f9380i = j5;
                bVar.f6511k = q0Var;
            }
            ((s) bVar.f6510j).getClass();
            return false;
        }
        a5.d r8 = d2.b.r(pVar);
        q qVar3 = new q(qVar.f2718a, qVar.f2719b, qVar.f2720c, qVar.f2721d, qVar.f2722e, qVar.f2724g, qVar.h, qVar.f2726j, r8, qVar.f2728l);
        this.f10055n = qVar3;
        q0 q0Var2 = new q0();
        q0Var2.f9382k = qVar3;
        q0Var2.f9383l = r8;
        q0Var2.f9380i = -1L;
        q0Var2.f9381j = -1L;
        this.f10056o = q0Var2;
        return true;
    }

    @Override // x2.i
    public final void d(boolean z8) {
        super.d(z8);
        if (z8) {
            this.f10055n = null;
            this.f10056o = null;
        }
    }
}
