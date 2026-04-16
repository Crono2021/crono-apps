package a6;

import java.io.Serializable;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f implements e, Serializable {

    /* renamed from: i, reason: collision with root package name */
    public final List f209i;

    public f(List list) {
        this.f209i = list;
    }

    @Override // a6.e
    public final boolean apply(Object obj) {
        int i9 = 0;
        while (true) {
            List list = this.f209i;
            if (i9 >= list.size()) {
                return true;
            }
            if (!((e) list.get(i9)).apply(obj)) {
                return false;
            }
            i9++;
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.f209i.equals(((f) obj).f209i);
        }
        return false;
    }

    public final int hashCode() {
        return this.f209i.hashCode() + 306654252;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Predicates.and(");
        boolean z8 = true;
        for (Object obj : this.f209i) {
            if (!z8) {
                sb.append(',');
            }
            sb.append(obj);
            z8 = false;
        }
        sb.append(')');
        return sb.toString();
    }
}
