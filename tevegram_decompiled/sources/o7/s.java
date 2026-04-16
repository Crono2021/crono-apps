package o7;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final int f8016a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f8017b;

    public s(int i9, Object obj) {
        this.f8016a = i9;
        this.f8017b = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f8016a == sVar.f8016a && b8.i.a(this.f8017b, sVar.f8017b);
    }

    public final int hashCode() {
        int i9 = this.f8016a * 31;
        Object obj = this.f8017b;
        return i9 + (obj == null ? 0 : obj.hashCode());
    }

    public final String toString() {
        return "IndexedValue(index=" + this.f8016a + ", value=" + this.f8017b + ')';
    }
}
