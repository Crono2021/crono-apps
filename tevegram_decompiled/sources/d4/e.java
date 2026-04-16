package d4;

import java.security.MessageDigest;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e implements b4.f {

    /* renamed from: b, reason: collision with root package name */
    public final b4.f f2825b;

    /* renamed from: c, reason: collision with root package name */
    public final b4.f f2826c;

    public e(b4.f fVar, b4.f fVar2) {
        this.f2825b = fVar;
        this.f2826c = fVar2;
    }

    @Override // b4.f
    public final void b(MessageDigest messageDigest) {
        this.f2825b.b(messageDigest);
        this.f2826c.b(messageDigest);
    }

    @Override // b4.f
    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.f2825b.equals(eVar.f2825b) && this.f2826c.equals(eVar.f2826c)) {
                return true;
            }
        }
        return false;
    }

    @Override // b4.f
    public final int hashCode() {
        return this.f2826c.hashCode() + (this.f2825b.hashCode() * 31);
    }

    public final String toString() {
        return "DataCacheKey{sourceKey=" + this.f2825b + ", signature=" + this.f2826c + '}';
    }
}
