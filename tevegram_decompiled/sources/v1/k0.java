package v1;

import java.io.IOException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k0 implements v0 {

    /* renamed from: i, reason: collision with root package name */
    public final int f9323i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ m0 f9324j;

    public k0(m0 m0Var, int i9) {
        this.f9324j = m0Var;
        this.f9323i = i9;
    }

    @Override // v1.v0
    public final boolean b() {
        m0 m0Var = this.f9324j;
        return !m0Var.E() && m0Var.A[this.f9323i].u(m0Var.S);
    }

    @Override // v1.v0
    public final void n() {
        int i9 = this.f9323i;
        m0 m0Var = this.f9324j;
        u0 u0Var = m0Var.A[i9];
        i7.x xVar = u0Var.h;
        if (xVar != null && xVar.C() == 1) {
            o1.b A = u0Var.h.A();
            A.getClass();
            throw A;
        }
        z1.p pVar = m0Var.f9341r;
        int minimumLoadableRetryCount = m0Var.f9335l.getMinimumLoadableRetryCount(m0Var.J);
        IOException iOException = pVar.f10589c;
        if (iOException != null) {
            throw iOException;
        }
        z1.l lVar = pVar.f10588b;
        if (lVar != null) {
            if (minimumLoadableRetryCount == Integer.MIN_VALUE) {
                minimumLoadableRetryCount = lVar.f10574i;
            }
            IOException iOException2 = lVar.f10578m;
            if (iOException2 != null && lVar.f10579n > minimumLoadableRetryCount) {
                throw iOException2;
            }
        }
    }

    @Override // v1.v0
    public final int o(long j5) {
        m0 m0Var = this.f9324j;
        if (m0Var.E()) {
            return 0;
        }
        int i9 = this.f9323i;
        m0Var.A(i9);
        u0 u0Var = m0Var.A[i9];
        int s8 = u0Var.s(j5, m0Var.S);
        u0Var.D(s8);
        if (s8 == 0) {
            m0Var.B(i9);
        }
        return s8;
    }

    @Override // v1.v0
    public final int r(a5.d dVar, j1.e eVar, int i9) {
        m0 m0Var = this.f9324j;
        if (m0Var.E()) {
            return -3;
        }
        int i10 = this.f9323i;
        m0Var.A(i10);
        int y2 = m0Var.A[i10].y(dVar, eVar, i9, m0Var.S);
        if (y2 == -3) {
            m0Var.B(i10);
        }
        return y2;
    }
}
