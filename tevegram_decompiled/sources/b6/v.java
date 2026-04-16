package b6;

import java.io.Serializable;
import java.util.Comparator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class v extends v0 implements Serializable {

    /* renamed from: i, reason: collision with root package name */
    public final Comparator f1463i;

    public v(Comparator comparator) {
        this.f1463i = comparator;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return this.f1463i.compare(obj, obj2);
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v) {
            return this.f1463i.equals(((v) obj).f1463i);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1463i.hashCode();
    }

    public final String toString() {
        return this.f1463i.toString();
    }
}
