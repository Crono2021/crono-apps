package i8;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class a extends y0 implements r7.c, u {

    /* renamed from: k, reason: collision with root package name */
    public final r7.g f5243k;

    public a(r7.g gVar, boolean z8) {
        super(z8);
        z((y0) gVar.h(t.f5304j));
        this.f5243k = gVar.a(this);
    }

    @Override // i8.y0
    public final void G(Object obj) {
        if (obj instanceof m) {
            m.f5288b.get((m) obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void M(int i9, a aVar, a8.p pVar) {
        int a9 = v.h.a(i9);
        if (a9 == 0) {
            com.bumptech.glide.d.c0(pVar, aVar, this);
            return;
        }
        if (a9 != 1) {
            if (a9 == 2) {
                com.bumptech.glide.c.C(((t7.a) pVar).j(aVar, this)).g(n7.g.f7490c);
                return;
            }
            if (a9 != 3) {
                throw new androidx.fragment.app.r();
            }
            try {
                r7.g gVar = this.f5243k;
                Object k3 = n8.a.k(gVar, null);
                try {
                    b8.r.a(2, pVar);
                    Object h = pVar.h(aVar, this);
                    if (h != s7.a.f8891i) {
                        g(h);
                    }
                } finally {
                    n8.a.f(gVar, k3);
                }
            } catch (Throwable th) {
                g(new n7.c(th));
            }
        }
    }

    @Override // i8.u
    public final r7.g c() {
        return this.f5243k;
    }

    @Override // r7.c
    public final r7.g f() {
        return this.f5243k;
    }

    @Override // r7.c
    public final void g(Object obj) {
        Throwable a9 = n7.d.a(obj);
        if (a9 != null) {
            obj = new m(a9, false);
        }
        Object D = D(obj);
        if (D == w.f5315e) {
            return;
        }
        k(D);
    }

    @Override // i8.y0
    public final String n() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    @Override // i8.y0
    public final void y(androidx.fragment.app.r rVar) {
        w.h(this.f5243k, rVar);
    }
}
