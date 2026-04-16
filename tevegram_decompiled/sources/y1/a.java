package y1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final long f10390a;

    /* renamed from: b, reason: collision with root package name */
    public final long f10391b;

    public a(long j5, long j9) {
        this.f10390a = j5;
        this.f10391b = j9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f10390a == aVar.f10390a && this.f10391b == aVar.f10391b;
    }

    public final int hashCode() {
        return (((int) this.f10390a) * 31) + ((int) this.f10391b);
    }
}
