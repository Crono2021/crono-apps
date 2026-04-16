package d7;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b extends com.bumptech.glide.c {

    /* renamed from: p, reason: collision with root package name */
    public final e7.a f2966p;

    public b(e7.a aVar) {
        this.f2966p = aVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && this.f2966p.equals(((b) obj).f2966p);
    }

    public final int hashCode() {
        return this.f2966p.hashCode();
    }

    public final String toString() {
        return "Play(videoItem=" + this.f2966p + ")";
    }
}
