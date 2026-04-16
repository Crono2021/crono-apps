package d1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    public final long f2591a;

    static {
        new x(new w());
        g1.w.H(0);
        g1.w.H(1);
        g1.w.H(2);
        g1.w.H(3);
        g1.w.H(4);
        g1.w.H(5);
        g1.w.H(6);
    }

    public x(w wVar) {
        int i9 = g1.w.f3713a;
        this.f2591a = wVar.f2583a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof x) && this.f2591a == ((x) obj).f2591a;
    }

    public final int hashCode() {
        long j5 = this.f2591a;
        return ((((int) 0) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 29791;
    }
}
