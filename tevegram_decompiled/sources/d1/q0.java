package d1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class q0 {

    /* renamed from: a, reason: collision with root package name */
    public final q f2517a;

    public q0(q qVar) {
        this.f2517a = qVar;
    }

    public final boolean a(int... iArr) {
        for (int i9 : iArr) {
            if (this.f2517a.f2516a.get(i9)) {
                return true;
            }
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q0) {
            return this.f2517a.equals(((q0) obj).f2517a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2517a.hashCode();
    }
}
