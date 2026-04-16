package l1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c1 {

    /* renamed from: c, reason: collision with root package name */
    public static final c1 f5809c = new c1(0, false);

    /* renamed from: a, reason: collision with root package name */
    public final int f5810a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f5811b;

    public c1(int i9, boolean z8) {
        this.f5810a = i9;
        this.f5811b = z8;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c1.class != obj.getClass()) {
            return false;
        }
        c1 c1Var = (c1) obj;
        return this.f5810a == c1Var.f5810a && this.f5811b == c1Var.f5811b;
    }

    public final int hashCode() {
        return (this.f5810a << 1) + (this.f5811b ? 1 : 0);
    }
}
