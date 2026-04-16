package m6;

import java.util.Objects;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final Class f6685a;

    /* renamed from: b, reason: collision with root package name */
    public final Class f6686b;

    public s(Class cls, Class cls2) {
        this.f6685a = cls;
        this.f6686b = cls2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return sVar.f6685a.equals(this.f6685a) && sVar.f6686b.equals(this.f6686b);
    }

    public final int hashCode() {
        return Objects.hash(this.f6685a, this.f6686b);
    }

    public final String toString() {
        return this.f6685a.getSimpleName() + " with serialization type: " + this.f6686b.getSimpleName();
    }
}
