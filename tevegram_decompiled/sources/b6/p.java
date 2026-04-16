package b6;

import java.io.Serializable;
import java.util.Arrays;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class p extends v0 implements Serializable {

    /* renamed from: i, reason: collision with root package name */
    public final a6.c f1429i;

    /* renamed from: j, reason: collision with root package name */
    public final v0 f1430j;

    public p(a6.c cVar, v0 v0Var) {
        this.f1429i = cVar;
        this.f1430j = v0Var;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        a6.c cVar = this.f1429i;
        return this.f1430j.compare(cVar.apply(obj), cVar.apply(obj2));
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f1429i.equals(pVar.f1429i) && this.f1430j.equals(pVar.f1430j);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f1429i, this.f1430j});
    }

    public final String toString() {
        return this.f1430j + ".onResultOf(" + this.f1429i + ")";
    }
}
