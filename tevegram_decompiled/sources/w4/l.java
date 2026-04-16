package w4;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public Class f9947a;

    /* renamed from: b, reason: collision with root package name */
    public Class f9948b;

    /* renamed from: c, reason: collision with root package name */
    public Class f9949c;

    public l(Class cls, Class cls2, Class cls3) {
        this.f9947a = cls;
        this.f9948b = cls2;
        this.f9949c = cls3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return this.f9947a.equals(lVar.f9947a) && this.f9948b.equals(lVar.f9948b) && n.b(this.f9949c, lVar.f9949c);
    }

    public final int hashCode() {
        int hashCode = (this.f9948b.hashCode() + (this.f9947a.hashCode() * 31)) * 31;
        Class cls = this.f9949c;
        return hashCode + (cls != null ? cls.hashCode() : 0);
    }

    public final String toString() {
        return "MultiClassKey{first=" + this.f9947a + ", second=" + this.f9948b + '}';
    }
}
