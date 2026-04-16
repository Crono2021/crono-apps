package n7;

import b8.i;
import java.io.Serializable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c implements Serializable {

    /* renamed from: i, reason: collision with root package name */
    public final Throwable f7482i;

    public c(Throwable th) {
        th.getClass();
        this.f7482i = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            return i.a(this.f7482i, ((c) obj).f7482i);
        }
        return false;
    }

    public final int hashCode() {
        return this.f7482i.hashCode();
    }

    public final String toString() {
        return "Failure(" + this.f7482i + ')';
    }
}
