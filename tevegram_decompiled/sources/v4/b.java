package v4;

import b4.f;
import java.security.MessageDigest;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements f {

    /* renamed from: b, reason: collision with root package name */
    public final Object f9575b;

    public b(Object obj) {
        w4.f.c(obj, "Argument must not be null");
        this.f9575b = obj;
    }

    @Override // b4.f
    public final void b(MessageDigest messageDigest) {
        messageDigest.update(this.f9575b.toString().getBytes(f.f1325a));
    }

    @Override // b4.f
    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.f9575b.equals(((b) obj).f9575b);
        }
        return false;
    }

    @Override // b4.f
    public final int hashCode() {
        return this.f9575b.hashCode();
    }

    public final String toString() {
        return "ObjectKey{object=" + this.f9575b + '}';
    }
}
