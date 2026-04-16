package v1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class s extends o {

    /* renamed from: e, reason: collision with root package name */
    public static final Object f9398e = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final Object f9399c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f9400d;

    public s(d1.y0 y0Var, Object obj, Object obj2) {
        super(y0Var);
        this.f9399c = obj;
        this.f9400d = obj2;
    }

    @Override // v1.o, d1.y0
    public final int b(Object obj) {
        Object obj2;
        if (f9398e.equals(obj) && (obj2 = this.f9400d) != null) {
            obj = obj2;
        }
        return this.f9357b.b(obj);
    }

    @Override // v1.o, d1.y0
    public final d1.w0 f(int i9, d1.w0 w0Var, boolean z8) {
        this.f9357b.f(i9, w0Var, z8);
        if (g1.w.a(w0Var.f2585b, this.f9400d) && z8) {
            w0Var.f2585b = f9398e;
        }
        return w0Var;
    }

    @Override // v1.o, d1.y0
    public final Object l(int i9) {
        Object l4 = this.f9357b.l(i9);
        return g1.w.a(l4, this.f9400d) ? f9398e : l4;
    }

    @Override // v1.o, d1.y0
    public final d1.x0 m(int i9, d1.x0 x0Var, long j5) {
        this.f9357b.m(i9, x0Var, j5);
        if (g1.w.a(x0Var.f2594a, this.f9399c)) {
            x0Var.f2594a = d1.x0.f2592r;
        }
        return x0Var;
    }
}
