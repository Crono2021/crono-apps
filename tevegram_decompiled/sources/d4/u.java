package d4;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class u implements a0 {

    /* renamed from: i, reason: collision with root package name */
    public final boolean f2924i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f2925j;

    /* renamed from: k, reason: collision with root package name */
    public final a0 f2926k;

    /* renamed from: l, reason: collision with root package name */
    public final n f2927l;

    /* renamed from: m, reason: collision with root package name */
    public final b4.f f2928m;

    /* renamed from: n, reason: collision with root package name */
    public int f2929n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f2930o;

    public u(a0 a0Var, boolean z8, boolean z9, b4.f fVar, n nVar) {
        w4.f.c(a0Var, "Argument must not be null");
        this.f2926k = a0Var;
        this.f2924i = z8;
        this.f2925j = z9;
        this.f2928m = fVar;
        w4.f.c(nVar, "Argument must not be null");
        this.f2927l = nVar;
    }

    public final synchronized void a() {
        if (this.f2930o) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f2929n++;
    }

    public final void b() {
        boolean z8;
        synchronized (this) {
            int i9 = this.f2929n;
            if (i9 <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z8 = true;
            int i10 = i9 - 1;
            this.f2929n = i10;
            if (i10 != 0) {
                z8 = false;
            }
        }
        if (z8) {
            this.f2927l.f(this.f2928m, this);
        }
    }

    @Override // d4.a0
    public final Class c() {
        return this.f2926k.c();
    }

    @Override // d4.a0
    public final synchronized void d() {
        if (this.f2929n > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.f2930o) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.f2930o = true;
        if (this.f2925j) {
            this.f2926k.d();
        }
    }

    @Override // d4.a0
    public final Object get() {
        return this.f2926k.get();
    }

    @Override // d4.a0
    public final int getSize() {
        return this.f2926k.getSize();
    }

    public final synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f2924i + ", listener=" + this.f2927l + ", key=" + this.f2928m + ", acquired=" + this.f2929n + ", isRecycled=" + this.f2930o + ", resource=" + this.f2926k + '}';
    }
}
