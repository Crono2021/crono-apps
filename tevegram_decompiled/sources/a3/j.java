package a3;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j extends z2.i implements Comparable {

    /* renamed from: t, reason: collision with root package name */
    public long f119t;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        j jVar = (j) obj;
        if (c(4) != jVar.c(4)) {
            return c(4) ? 1 : -1;
        }
        long j5 = this.f5361o - jVar.f5361o;
        if (j5 == 0) {
            j5 = this.f119t - jVar.f119t;
            if (j5 == 0) {
                return 0;
            }
        }
        return j5 > 0 ? 1 : -1;
    }
}
