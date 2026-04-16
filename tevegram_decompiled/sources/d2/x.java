package d2;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public final z f2753a;

    /* renamed from: b, reason: collision with root package name */
    public final z f2754b;

    public x(z zVar, z zVar2) {
        this.f2753a = zVar;
        this.f2754b = zVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && x.class == obj.getClass()) {
            x xVar = (x) obj;
            if (this.f2753a.equals(xVar.f2753a) && this.f2754b.equals(xVar.f2754b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f2754b.hashCode() + (this.f2753a.hashCode() * 31);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("[");
        z zVar = this.f2753a;
        sb.append(zVar);
        z zVar2 = this.f2754b;
        if (zVar.equals(zVar2)) {
            str = "";
        } else {
            str = ", " + zVar2;
        }
        return androidx.activity.g.o(sb, str, "]");
    }
}
