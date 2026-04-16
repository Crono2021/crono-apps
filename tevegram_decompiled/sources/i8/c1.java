package i8;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c1 extends t0 {

    /* renamed from: m, reason: collision with root package name */
    public final u0 f5252m;

    public c1(u0 u0Var) {
        this.f5252m = u0Var;
    }

    @Override // a8.l
    public final /* bridge */ /* synthetic */ Object a(Object obj) {
        p((Throwable) obj);
        return n7.g.f7490c;
    }

    @Override // i8.t0
    public final void p(Throwable th) {
        Object w8 = o().w();
        boolean z8 = w8 instanceof m;
        u0 u0Var = this.f5252m;
        if (!z8) {
            u0Var.g(w.o(w8));
            return;
        }
        Throwable th2 = ((m) w8).f5289a;
        th2.getClass();
        u0Var.g(new n7.c(th2));
    }
}
