package g1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class q {

    /* renamed from: c, reason: collision with root package name */
    public static final q f3702c = new q(-1, -1);

    /* renamed from: a, reason: collision with root package name */
    public final int f3703a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3704b;

    static {
        new q(0, 0);
    }

    public q(int i9, int i10) {
        a.f((i9 == -1 || i9 >= 0) && (i10 == -1 || i10 >= 0));
        this.f3703a = i9;
        this.f3704b = i10;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof q) {
            q qVar = (q) obj;
            if (this.f3703a == qVar.f3703a && this.f3704b == qVar.f3704b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i9 = this.f3703a;
        return ((i9 >>> 16) | (i9 << 16)) ^ this.f3704b;
    }

    public final String toString() {
        return this.f3703a + "x" + this.f3704b;
    }
}
