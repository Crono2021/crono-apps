package m6;

import java.util.Objects;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final Class f6672a;

    /* renamed from: b, reason: collision with root package name */
    public final Class f6673b;

    public n(Class cls, Class cls2) {
        this.f6672a = cls;
        this.f6673b = cls2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return nVar.f6672a.equals(this.f6672a) && nVar.f6673b.equals(this.f6673b);
    }

    public final int hashCode() {
        return Objects.hash(this.f6672a, this.f6673b);
    }

    public final String toString() {
        return this.f6672a.getSimpleName() + " with primitive type: " + this.f6673b.getSimpleName();
    }
}
