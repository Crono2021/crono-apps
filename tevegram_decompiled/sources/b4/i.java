package b4;

import java.security.MessageDigest;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i implements f {

    /* renamed from: b, reason: collision with root package name */
    public final w4.c f1331b = new w4.c();

    @Override // b4.f
    public final void b(MessageDigest messageDigest) {
        int i9 = 0;
        while (true) {
            w4.c cVar = this.f1331b;
            if (i9 >= cVar.f8653k) {
                return;
            }
            h hVar = (h) cVar.h(i9);
            Object l4 = this.f1331b.l(i9);
            g gVar = hVar.f1328b;
            if (hVar.f1330d == null) {
                hVar.f1330d = hVar.f1329c.getBytes(f.f1325a);
            }
            gVar.d(hVar.f1330d, l4, messageDigest);
            i9++;
        }
    }

    public final Object c(h hVar) {
        w4.c cVar = this.f1331b;
        return cVar.containsKey(hVar) ? cVar.getOrDefault(hVar, null) : hVar.f1327a;
    }

    @Override // b4.f
    public final boolean equals(Object obj) {
        if (obj instanceof i) {
            return this.f1331b.equals(((i) obj).f1331b);
        }
        return false;
    }

    @Override // b4.f
    public final int hashCode() {
        return this.f1331b.hashCode();
    }

    public final String toString() {
        return "Options{values=" + this.f1331b + '}';
    }
}
