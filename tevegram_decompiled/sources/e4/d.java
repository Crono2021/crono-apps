package e4;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d implements h {

    /* renamed from: a, reason: collision with root package name */
    public final e f3092a;

    /* renamed from: b, reason: collision with root package name */
    public int f3093b;

    /* renamed from: c, reason: collision with root package name */
    public Class f3094c;

    public d(e eVar) {
        this.f3092a = eVar;
    }

    @Override // e4.h
    public final void a() {
        this.f3092a.c(this);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.f3093b == dVar.f3093b && this.f3094c == dVar.f3094c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i9 = this.f3093b * 31;
        Class cls = this.f3094c;
        return i9 + (cls != null ? cls.hashCode() : 0);
    }

    public final String toString() {
        return "Key{size=" + this.f3093b + "array=" + this.f3094c + '}';
    }
}
