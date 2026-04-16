package n;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i0 extends a2 {

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ q0 f6890r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ t0 f6891s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(t0 t0Var, t0 t0Var2, q0 q0Var) {
        super(t0Var2);
        this.f6891s = t0Var;
        this.f6890r = q0Var;
    }

    @Override // n.a2
    public final m.d0 b() {
        return this.f6890r;
    }

    @Override // n.a2
    public final boolean c() {
        t0 t0Var = this.f6891s;
        if (t0Var.getInternalPopup().b()) {
            return true;
        }
        t0Var.f7041n.l(k0.b(t0Var), k0.a(t0Var));
        return true;
    }
}
