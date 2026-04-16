package n1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l {

    /* renamed from: d, reason: collision with root package name */
    public static final l f7286d = new d4.j().a();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f7287a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f7288b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f7289c;

    public l(d4.j jVar) {
        this.f7287a = jVar.f2853a;
        this.f7288b = jVar.f2854b;
        this.f7289c = jVar.f2855c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return this.f7287a == lVar.f7287a && this.f7288b == lVar.f7288b && this.f7289c == lVar.f7289c;
    }

    public final int hashCode() {
        return ((this.f7287a ? 1 : 0) << 2) + ((this.f7288b ? 1 : 0) << 1) + (this.f7289c ? 1 : 0);
    }
}
