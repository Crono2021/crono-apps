package b8;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class h extends c implements g, f8.a, n7.a {

    /* renamed from: o, reason: collision with root package name */
    public final int f1517o;

    /* renamed from: p, reason: collision with root package name */
    public final int f1518p;

    public h(int i9, Object obj, Class cls, String str, String str2, int i10, int i11) {
        super(obj, cls, str, str2, (i10 & 1) == 1);
        this.f1517o = i9;
        this.f1518p = 0;
    }

    @Override // b8.g
    public final int e() {
        return this.f1517o;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            return this.f1513l.equals(hVar.f1513l) && this.f1514m.equals(hVar.f1514m) && this.f1518p == hVar.f1518p && this.f1517o == hVar.f1517o && i.a(this.f1511j, hVar.f1511j) && b().equals(hVar.b());
        }
        if (!(obj instanceof h)) {
            return false;
        }
        f8.a aVar = this.f1510i;
        if (aVar == null) {
            f();
            this.f1510i = this;
            aVar = this;
        }
        return obj.equals(aVar);
    }

    public final f8.a f() {
        p.f1526a.getClass();
        return this;
    }

    public final int hashCode() {
        b();
        return this.f1514m.hashCode() + androidx.activity.g.k(b().hashCode() * 31, 31, this.f1513l);
    }

    public final String toString() {
        f8.a aVar = this.f1510i;
        if (aVar == null) {
            f();
            this.f1510i = this;
            aVar = this;
        }
        if (aVar != this) {
            return aVar.toString();
        }
        String str = this.f1513l;
        return "<init>".equals(str) ? "constructor (Kotlin reflection is not available)" : androidx.activity.g.n("function ", str, " (Kotlin reflection is not available)");
    }
}
