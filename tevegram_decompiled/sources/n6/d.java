package n6;

import java.util.Objects;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d extends g6.c {

    /* renamed from: b, reason: collision with root package name */
    public final int f7456b;

    /* renamed from: c, reason: collision with root package name */
    public final int f7457c;

    /* renamed from: d, reason: collision with root package name */
    public final c f7458d;

    public d(int i9, int i10, c cVar) {
        this.f7456b = i9;
        this.f7457c = i10;
        this.f7458d = cVar;
    }

    public final int b() {
        c cVar = c.f7445f;
        int i9 = this.f7457c;
        c cVar2 = this.f7458d;
        if (cVar2 == cVar) {
            return i9;
        }
        if (cVar2 == c.f7442c) {
            return i9 + 5;
        }
        if (cVar2 == c.f7443d) {
            return i9 + 5;
        }
        if (cVar2 == c.f7444e) {
            return i9 + 5;
        }
        m7.c.p("Unknown variant");
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return dVar.f7456b == this.f7456b && dVar.b() == b() && dVar.f7458d == this.f7458d;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f7456b), Integer.valueOf(this.f7457c), this.f7458d);
    }

    public final String toString() {
        return "AES-CMAC Parameters (variant: " + this.f7458d + ", " + this.f7457c + "-byte tags, and " + this.f7456b + "-byte key)";
    }
}
