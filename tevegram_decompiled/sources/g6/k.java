package g6;

import java.util.Objects;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k extends c {

    /* renamed from: b, reason: collision with root package name */
    public final int f3774b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3775c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3776d;

    /* renamed from: e, reason: collision with root package name */
    public final j f3777e;

    public k(int i9, int i10, int i11, j jVar) {
        this.f3774b = i9;
        this.f3775c = i10;
        this.f3776d = i11;
        this.f3777e = jVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return kVar.f3774b == this.f3774b && kVar.f3775c == this.f3775c && kVar.f3776d == this.f3776d && kVar.f3777e == this.f3777e;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f3774b), Integer.valueOf(this.f3775c), Integer.valueOf(this.f3776d), this.f3777e);
    }

    public final String toString() {
        return "AesEax Parameters (variant: " + this.f3777e + ", " + this.f3775c + "-byte IV, " + this.f3776d + "-byte tag, and " + this.f3774b + "-byte key)";
    }
}
