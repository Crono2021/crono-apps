package n8;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class j extends b8.c implements a8.a, f8.a {

    /* renamed from: o, reason: collision with root package name */
    public final boolean f7516o;

    public j(k kVar) {
        super(kVar, i8.w.class, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;", true);
        this.f7516o = false;
    }

    @Override // a8.a
    public final Object d() {
        return this.f1511j.getClass().getSimpleName();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            return b().equals(jVar.b()) && this.f1513l.equals(jVar.f1513l) && this.f1514m.equals(jVar.f1514m) && b8.i.a(this.f1511j, jVar.f1511j);
        }
        if (obj instanceof j) {
            return obj.equals(f());
        }
        return false;
    }

    public final f8.a f() {
        if (this.f7516o) {
            return this;
        }
        f8.a aVar = this.f1510i;
        if (aVar != null) {
            return aVar;
        }
        b8.p.f1526a.getClass();
        this.f1510i = this;
        return this;
    }

    public final int hashCode() {
        return this.f1514m.hashCode() + androidx.activity.g.k(b().hashCode() * 31, 31, this.f1513l);
    }

    public final String toString() {
        f8.a f9 = f();
        return f9 != this ? f9.toString() : androidx.activity.g.o(new StringBuilder("property "), this.f1513l, " (Kotlin reflection is not available)");
    }
}
