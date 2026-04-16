package n6;

import java.util.Objects;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j extends g6.c {

    /* renamed from: b, reason: collision with root package name */
    public final int f7466b;

    /* renamed from: c, reason: collision with root package name */
    public final int f7467c;

    /* renamed from: d, reason: collision with root package name */
    public final c f7468d;

    /* renamed from: e, reason: collision with root package name */
    public final c f7469e;

    public j(int i9, int i10, c cVar, c cVar2) {
        this.f7466b = i9;
        this.f7467c = i10;
        this.f7468d = cVar;
        this.f7469e = cVar2;
    }

    public final int b() {
        c cVar = c.f7453o;
        int i9 = this.f7467c;
        c cVar2 = this.f7468d;
        if (cVar2 == cVar) {
            return i9;
        }
        if (cVar2 == c.f7450l) {
            return i9 + 5;
        }
        if (cVar2 == c.f7451m) {
            return i9 + 5;
        }
        if (cVar2 == c.f7452n) {
            return i9 + 5;
        }
        m7.c.p("Unknown variant");
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return jVar.f7466b == this.f7466b && jVar.b() == b() && jVar.f7468d == this.f7468d && jVar.f7469e == this.f7469e;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f7466b), Integer.valueOf(this.f7467c), this.f7468d, this.f7469e);
    }

    public final String toString() {
        return "HMAC Parameters (variant: " + this.f7468d + ", hashType: " + this.f7469e + ", " + this.f7467c + "-byte tags, and " + this.f7466b + "-byte key)";
    }
}
