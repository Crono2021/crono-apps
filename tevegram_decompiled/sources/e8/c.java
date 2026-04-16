package e8;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c extends a {

    /* renamed from: l, reason: collision with root package name */
    public static final c f3165l = new c(1, 0, 1);

    @Override // e8.a
    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        if (isEmpty() && ((c) obj).isEmpty()) {
            return true;
        }
        c cVar = (c) obj;
        return this.f3158i == cVar.f3158i && this.f3159j == cVar.f3159j;
    }

    @Override // e8.a
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f3158i * 31) + this.f3159j;
    }

    @Override // e8.a
    public final boolean isEmpty() {
        return this.f3158i > this.f3159j;
    }

    @Override // e8.a
    public final String toString() {
        return this.f3158i + ".." + this.f3159j;
    }
}
