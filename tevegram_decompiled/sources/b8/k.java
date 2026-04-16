package b8;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k implements d {

    /* renamed from: a, reason: collision with root package name */
    public final Class f1521a;

    public k(Class cls) {
        this.f1521a = cls;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof k) {
            return this.f1521a.equals(((k) obj).f1521a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1521a.hashCode();
    }

    public final String toString() {
        return this.f1521a + " (Kotlin reflection is not available)";
    }
}
