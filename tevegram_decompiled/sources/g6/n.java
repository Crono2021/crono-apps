package g6;

import java.util.Objects;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class n extends c {

    /* renamed from: b, reason: collision with root package name */
    public final int f3782b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3783c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3784d;

    /* renamed from: e, reason: collision with root package name */
    public final j f3785e;

    public n(int i9, int i10, int i11, j jVar) {
        this.f3782b = i9;
        this.f3783c = i10;
        this.f3784d = i11;
        this.f3785e = jVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return nVar.f3782b == this.f3782b && nVar.f3783c == this.f3783c && nVar.f3784d == this.f3784d && nVar.f3785e == this.f3785e;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f3782b), Integer.valueOf(this.f3783c), Integer.valueOf(this.f3784d), this.f3785e);
    }

    public final String toString() {
        return "AesGcm Parameters (variant: " + this.f3785e + ", " + this.f3783c + "-byte IV, " + this.f3784d + "-byte tag, and " + this.f3782b + "-byte key)";
    }
}
