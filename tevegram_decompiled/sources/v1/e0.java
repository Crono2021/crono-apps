package v1;

import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e0 implements y1.q {

    /* renamed from: a, reason: collision with root package name */
    public final y1.q f9271a;

    /* renamed from: b, reason: collision with root package name */
    public final d1.z0 f9272b;

    public e0(y1.q qVar, d1.z0 z0Var) {
        this.f9271a = qVar;
        this.f9272b = z0Var;
    }

    @Override // y1.q
    public final void a(boolean z8) {
        this.f9271a.a(z8);
    }

    @Override // y1.q
    public final boolean b(int i9, long j5) {
        return this.f9271a.b(i9, j5);
    }

    @Override // y1.q
    public final d1.s c(int i9) {
        return this.f9272b.f2619d[this.f9271a.e(i9)];
    }

    @Override // y1.q
    public final void d() {
        this.f9271a.d();
    }

    @Override // y1.q
    public final int e(int i9) {
        return this.f9271a.e(i9);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        return this.f9271a.equals(e0Var.f9271a) && this.f9272b.equals(e0Var.f9272b);
    }

    @Override // y1.q
    public final int f(long j5, List list) {
        return this.f9271a.f(j5, list);
    }

    @Override // y1.q
    public final void g(long j5, long j9, long j10, List list, w1.b[] bVarArr) {
        this.f9271a.g(j5, j9, j10, list, bVarArr);
    }

    @Override // y1.q
    public final void h() {
        this.f9271a.h();
    }

    public final int hashCode() {
        return this.f9271a.hashCode() + ((this.f9272b.hashCode() + 527) * 31);
    }

    @Override // y1.q
    public final int i() {
        return this.f9271a.i();
    }

    @Override // y1.q
    public final d1.z0 j() {
        return this.f9272b;
    }

    @Override // y1.q
    public final d1.s k() {
        return this.f9272b.f2619d[this.f9271a.i()];
    }

    @Override // y1.q
    public final int l() {
        return this.f9271a.l();
    }

    @Override // y1.q
    public final int length() {
        return this.f9271a.length();
    }

    @Override // y1.q
    public final int m() {
        return this.f9271a.m();
    }

    @Override // y1.q
    public final boolean n(int i9, long j5) {
        return this.f9271a.n(i9, j5);
    }

    @Override // y1.q
    public final void o(float f9) {
        this.f9271a.o(f9);
    }

    @Override // y1.q
    public final Object p() {
        return this.f9271a.p();
    }

    @Override // y1.q
    public final void q() {
        this.f9271a.q();
    }

    @Override // y1.q
    public final boolean r(long j5, w1.a aVar, List list) {
        return this.f9271a.r(j5, aVar, list);
    }

    @Override // y1.q
    public final void s() {
        this.f9271a.s();
    }

    @Override // y1.q
    public final int t(int i9) {
        return this.f9271a.t(i9);
    }
}
