package v1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a1 implements v0 {

    /* renamed from: i, reason: collision with root package name */
    public final v0 f9240i;

    /* renamed from: j, reason: collision with root package name */
    public final long f9241j;

    public a1(v0 v0Var, long j5) {
        this.f9240i = v0Var;
        this.f9241j = j5;
    }

    @Override // v1.v0
    public final boolean b() {
        return this.f9240i.b();
    }

    @Override // v1.v0
    public final void n() {
        this.f9240i.n();
    }

    @Override // v1.v0
    public final int o(long j5) {
        return this.f9240i.o(j5 - this.f9241j);
    }

    @Override // v1.v0
    public final int r(a5.d dVar, j1.e eVar, int i9) {
        int r8 = this.f9240i.r(dVar, eVar, i9);
        if (r8 == -4) {
            eVar.f5361o += this.f9241j;
        }
        return r8;
    }
}
