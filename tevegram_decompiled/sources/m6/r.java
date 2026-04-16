package m6;

import java.util.Objects;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final Class f6683a;

    /* renamed from: b, reason: collision with root package name */
    public final t6.a f6684b;

    public r(Class cls, t6.a aVar) {
        this.f6683a = cls;
        this.f6684b = aVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return rVar.f6683a.equals(this.f6683a) && rVar.f6684b.equals(this.f6684b);
    }

    public final int hashCode() {
        return Objects.hash(this.f6683a, this.f6684b);
    }

    public final String toString() {
        return this.f6683a.getSimpleName() + ", object identifier: " + this.f6684b;
    }
}
