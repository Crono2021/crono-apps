package l1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j implements k0 {

    /* renamed from: i, reason: collision with root package name */
    public final e1 f5923i;

    /* renamed from: j, reason: collision with root package name */
    public final h0 f5924j;

    /* renamed from: k, reason: collision with root package name */
    public b1 f5925k;

    /* renamed from: l, reason: collision with root package name */
    public k0 f5926l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f5927m = true;

    /* renamed from: n, reason: collision with root package name */
    public boolean f5928n;

    public j(h0 h0Var, g1.r rVar) {
        this.f5924j = h0Var;
        this.f5923i = new e1(rVar);
    }

    @Override // l1.k0
    public final boolean c() {
        if (this.f5927m) {
            this.f5923i.getClass();
            return false;
        }
        k0 k0Var = this.f5926l;
        k0Var.getClass();
        return k0Var.c();
    }

    @Override // l1.k0
    public final d1.o0 d() {
        k0 k0Var = this.f5926l;
        return k0Var != null ? k0Var.d() : this.f5923i.f5854m;
    }

    @Override // l1.k0
    public final void e(d1.o0 o0Var) {
        k0 k0Var = this.f5926l;
        if (k0Var != null) {
            k0Var.e(o0Var);
            o0Var = this.f5926l.d();
        }
        this.f5923i.e(o0Var);
    }

    @Override // l1.k0
    public final long j() {
        if (this.f5927m) {
            return this.f5923i.j();
        }
        k0 k0Var = this.f5926l;
        k0Var.getClass();
        return k0Var.j();
    }
}
