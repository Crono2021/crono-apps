package v1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f9327a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f9328b;

    public l0(int i9, boolean z8) {
        this.f9327a = i9;
        this.f9328b = z8;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l0.class != obj.getClass()) {
            return false;
        }
        l0 l0Var = (l0) obj;
        return this.f9327a == l0Var.f9327a && this.f9328b == l0Var.f9328b;
    }

    public final int hashCode() {
        return (this.f9327a * 31) + (this.f9328b ? 1 : 0);
    }
}
