package i8;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e0 implements n0 {

    /* renamed from: i, reason: collision with root package name */
    public final boolean f5256i;

    public e0(boolean z8) {
        this.f5256i = z8;
    }

    @Override // i8.n0
    public final boolean b() {
        return this.f5256i;
    }

    @Override // i8.n0
    public final z0 g() {
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Empty{");
        sb.append(this.f5256i ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
