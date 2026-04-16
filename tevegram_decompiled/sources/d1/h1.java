package d1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h1 {

    /* renamed from: e, reason: collision with root package name */
    public static final h1 f2473e = new h1(1.0f, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f2474a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2475b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2476c;

    /* renamed from: d, reason: collision with root package name */
    public final float f2477d;

    static {
        g1.w.H(0);
        g1.w.H(1);
        g1.w.H(2);
        g1.w.H(3);
    }

    public h1(float f9, int i9, int i10, int i11) {
        this.f2474a = i9;
        this.f2475b = i10;
        this.f2476c = i11;
        this.f2477d = f9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h1) {
            h1 h1Var = (h1) obj;
            if (this.f2474a == h1Var.f2474a && this.f2475b == h1Var.f2475b && this.f2476c == h1Var.f2476c && this.f2477d == h1Var.f2477d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToRawIntBits(this.f2477d) + ((((((217 + this.f2474a) * 31) + this.f2475b) * 31) + this.f2476c) * 31);
    }
}
