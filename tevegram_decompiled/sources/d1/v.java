package d1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public final String f2581a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2582b;

    static {
        g1.w.H(0);
        g1.w.H(1);
    }

    public v(String str, String str2) {
        this.f2581a = g1.w.N(str);
        this.f2582b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && v.class == obj.getClass()) {
            v vVar = (v) obj;
            if (g1.w.a(this.f2581a, vVar.f2581a) && g1.w.a(this.f2582b, vVar.f2582b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.f2582b.hashCode() * 31;
        String str = this.f2581a;
        return hashCode + (str != null ? str.hashCode() : 0);
    }
}
