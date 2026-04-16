package p6;

import f6.f;
import java.util.Objects;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final f f8256a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8257b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8258c;

    /* renamed from: d, reason: collision with root package name */
    public final String f8259d;

    public b(f fVar, int i9, String str, String str2) {
        this.f8256a = fVar;
        this.f8257b = i9;
        this.f8258c = str;
        this.f8259d = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f8256a == bVar.f8256a && this.f8257b == bVar.f8257b && this.f8258c.equals(bVar.f8258c) && this.f8259d.equals(bVar.f8259d);
    }

    public final int hashCode() {
        return Objects.hash(this.f8256a, Integer.valueOf(this.f8257b), this.f8258c, this.f8259d);
    }

    public final String toString() {
        return "(status=" + this.f8256a + ", keyId=" + this.f8257b + ", keyType='" + this.f8258c + "', keyPrefix='" + this.f8259d + "')";
    }
}
