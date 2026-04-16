package k8;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k {

    /* renamed from: b, reason: collision with root package name */
    public static final j f5670b = new j();

    /* renamed from: a, reason: collision with root package name */
    public final Object f5671a;

    public final boolean equals(Object obj) {
        if (obj instanceof k) {
            return b8.i.a(this.f5671a, ((k) obj).f5671a);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f5671a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.f5671a;
        if (obj instanceof i) {
            return ((i) obj).toString();
        }
        return "Value(" + obj + ')';
    }
}
