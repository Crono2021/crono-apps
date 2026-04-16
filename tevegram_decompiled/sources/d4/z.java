package d4;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class z implements a0, x4.b {

    /* renamed from: m, reason: collision with root package name */
    public static final x.c f2942m = x4.c.a(20, new t(1));

    /* renamed from: i, reason: collision with root package name */
    public final x4.d f2943i = new x4.d();

    /* renamed from: j, reason: collision with root package name */
    public a0 f2944j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f2945k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f2946l;

    public final synchronized void a() {
        this.f2943i.a();
        if (!this.f2945k) {
            throw new IllegalStateException("Already unlocked");
        }
        this.f2945k = false;
        if (this.f2946l) {
            d();
        }
    }

    @Override // x4.b
    public final x4.d b() {
        return this.f2943i;
    }

    @Override // d4.a0
    public final Class c() {
        return this.f2944j.c();
    }

    @Override // d4.a0
    public final synchronized void d() {
        this.f2943i.a();
        this.f2946l = true;
        if (!this.f2945k) {
            this.f2944j.d();
            this.f2944j = null;
            f2942m.a(this);
        }
    }

    @Override // d4.a0
    public final Object get() {
        return this.f2944j.get();
    }

    @Override // d4.a0
    public final int getSize() {
        return this.f2944j.getSize();
    }
}
