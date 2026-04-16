package n7;

import b8.i;
import java.io.Serializable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements Serializable {

    /* renamed from: i, reason: collision with root package name */
    public final Object f7480i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f7481j;

    public b(Object obj, Object obj2) {
        this.f7480i = obj;
        this.f7481j = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return i.a(this.f7480i, bVar.f7480i) && i.a(this.f7481j, bVar.f7481j);
    }

    public final int hashCode() {
        Object obj = this.f7480i;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f7481j;
        return hashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.f7480i + ", " + this.f7481j + ')';
    }
}
