package o3;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f7585a;

    /* renamed from: b, reason: collision with root package name */
    public int f7586b;

    /* renamed from: c, reason: collision with root package name */
    public Object f7587c;

    /* renamed from: d, reason: collision with root package name */
    public int f7588d;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            int i9 = this.f7585a;
            if (i9 != aVar.f7585a) {
                return false;
            }
            if (i9 != 8 || Math.abs(this.f7588d - this.f7586b) != 1 || this.f7588d != aVar.f7586b || this.f7586b != aVar.f7588d) {
                if (this.f7588d != aVar.f7588d || this.f7586b != aVar.f7586b) {
                    return false;
                }
                Object obj2 = this.f7587c;
                Object obj3 = aVar.f7587c;
                if (obj2 != null) {
                    if (!obj2.equals(obj3)) {
                        return false;
                    }
                } else if (obj3 != null) {
                    return false;
                }
            }
        }
        return true;
    }

    public final int hashCode() {
        return (((this.f7585a * 31) + this.f7586b) * 31) + this.f7588d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[");
        int i9 = this.f7585a;
        sb.append(i9 != 1 ? i9 != 2 ? i9 != 4 ? i9 != 8 ? "??" : "mv" : "up" : "rm" : "add");
        sb.append(",s:");
        sb.append(this.f7586b);
        sb.append("c:");
        sb.append(this.f7588d);
        sb.append(",p:");
        sb.append(this.f7587c);
        sb.append("]");
        return sb.toString();
    }
}
