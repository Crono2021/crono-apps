package i8;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class u0 extends f {

    /* renamed from: q, reason: collision with root package name */
    public final k f5306q;

    public u0(r7.c cVar, k kVar) {
        super(1, cVar);
        this.f5306q = kVar;
    }

    @Override // i8.f
    public final Throwable q(y0 y0Var) {
        Throwable c9;
        Object w8 = this.f5306q.w();
        return (!(w8 instanceof w0) || (c9 = ((w0) w8).c()) == null) ? w8 instanceof m ? ((m) w8).f5289a : y0Var.s() : c9;
    }

    @Override // i8.f
    public final String y() {
        return "AwaitContinuation";
    }
}
