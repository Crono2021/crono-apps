package b6;

import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class o {

    /* renamed from: i, reason: collision with root package name */
    public transient Set f1424i;

    /* renamed from: j, reason: collision with root package name */
    public transient n f1425j;

    /* renamed from: k, reason: collision with root package name */
    public transient Map f1426k;

    public abstract Map a();

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o) {
            return ((t0) this).a().equals(((t0) ((o) obj)).a());
        }
        return false;
    }

    public final int hashCode() {
        return a().hashCode();
    }

    public final String toString() {
        return a().toString();
    }
}
