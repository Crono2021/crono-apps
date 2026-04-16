package h4;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final String f3989a;

    public j(String str) {
        this.f3989a = str;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f3989a.equals(((j) obj).f3989a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f3989a.hashCode();
    }

    public final String toString() {
        return androidx.activity.g.o(new StringBuilder("StringHeaderFactory{value='"), this.f3989a, "'}");
    }
}
