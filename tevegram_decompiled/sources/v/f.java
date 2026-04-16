package v;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f implements Comparable {

    /* renamed from: i, reason: collision with root package name */
    public i f9169i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ g f9170j;

    public f(g gVar) {
        this.f9170j = gVar;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f9169i.f9175b - ((i) obj).f9175b;
    }

    public final String toString() {
        String str = "[ ";
        if (this.f9169i != null) {
            for (int i9 = 0; i9 < 9; i9++) {
                str = str + this.f9169i.h[i9] + " ";
            }
        }
        return str + "] " + this.f9169i;
    }
}
