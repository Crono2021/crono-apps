package g6;

import java.util.Objects;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class q extends c {

    /* renamed from: b, reason: collision with root package name */
    public final int f3790b;

    /* renamed from: c, reason: collision with root package name */
    public final j f3791c;

    public q(int i9, j jVar) {
        this.f3790b = i9;
        this.f3791c = jVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return qVar.f3790b == this.f3790b && qVar.f3791c == this.f3791c;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f3790b), this.f3791c);
    }

    public final String toString() {
        return "AesGcmSiv Parameters (variant: " + this.f3791c + ", " + this.f3790b + "-byte key)";
    }
}
