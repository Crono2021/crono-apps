package n1;

import b6.k1;
import java.util.Set;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d {

    /* renamed from: d, reason: collision with root package name */
    public static final d f7243d;

    /* renamed from: a, reason: collision with root package name */
    public final int f7244a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7245b;

    /* renamed from: c, reason: collision with root package name */
    public final b6.k0 f7246c;

    static {
        d dVar;
        if (g1.w.f3713a >= 33) {
            b6.j0 j0Var = new b6.j0();
            for (int i9 = 1; i9 <= 10; i9++) {
                j0Var.a(Integer.valueOf(g1.w.p(i9)));
            }
            dVar = new d(2, j0Var.f());
        } else {
            dVar = new d(2, 10);
        }
        f7243d = dVar;
    }

    public d(int i9, Set set) {
        this.f7244a = i9;
        b6.k0 n4 = b6.k0.n(set);
        this.f7246c = n4;
        k1 it = n4.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i10 = Math.max(i10, Integer.bitCount(((Integer) it.next()).intValue()));
        }
        this.f7245b = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f7244a == dVar.f7244a && this.f7245b == dVar.f7245b && g1.w.a(this.f7246c, dVar.f7246c);
    }

    public final int hashCode() {
        int i9 = ((this.f7244a * 31) + this.f7245b) * 31;
        b6.k0 k0Var = this.f7246c;
        return i9 + (k0Var == null ? 0 : k0Var.hashCode());
    }

    public final String toString() {
        return "AudioProfile[format=" + this.f7244a + ", maxChannelCount=" + this.f7245b + ", channelMasks=" + this.f7246c + "]";
    }

    public d(int i9, int i10) {
        this.f7244a = i9;
        this.f7245b = i10;
        this.f7246c = null;
    }
}
