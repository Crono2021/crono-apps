package k8;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i extends j {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f5669a;

    public i(Throwable th) {
        this.f5669a = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof i) {
            return b8.i.a(this.f5669a, ((i) obj).f5669a);
        }
        return false;
    }

    public final int hashCode() {
        Throwable th = this.f5669a;
        if (th != null) {
            return th.hashCode();
        }
        return 0;
    }

    @Override // k8.j
    public final String toString() {
        return "Closed(" + this.f5669a + ')';
    }
}
