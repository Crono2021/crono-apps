package d1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g {

    /* renamed from: c, reason: collision with root package name */
    public static final g f2423c = new g(0);

    /* renamed from: a, reason: collision with root package name */
    public final int f2424a;

    /* renamed from: b, reason: collision with root package name */
    public a0.b f2425b;

    static {
        androidx.activity.g.s(0, 1, 2, 3, 4);
    }

    public g(int i9) {
        this.f2424a = i9;
    }

    public final a0.b a() {
        if (this.f2425b == null) {
            this.f2425b = new a0.b(this);
        }
        return this.f2425b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && g.class == obj.getClass() && this.f2424a == ((g) obj).f2424a;
    }

    public final int hashCode() {
        return (((((527 + this.f2424a) * 961) + 1) * 31) + 1) * 31;
    }
}
