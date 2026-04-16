package d2;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class z {

    /* renamed from: c, reason: collision with root package name */
    public static final z f2755c = new z(0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final long f2756a;

    /* renamed from: b, reason: collision with root package name */
    public final long f2757b;

    public z(long j5, long j9) {
        this.f2756a = j5;
        this.f2757b = j9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && z.class == obj.getClass()) {
            z zVar = (z) obj;
            if (this.f2756a == zVar.f2756a && this.f2757b == zVar.f2757b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.f2756a) * 31) + ((int) this.f2757b);
    }

    public final String toString() {
        return "[timeUs=" + this.f2756a + ", position=" + this.f2757b + "]";
    }
}
