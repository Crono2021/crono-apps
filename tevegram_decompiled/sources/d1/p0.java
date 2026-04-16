package d1;

import android.util.SparseBooleanArray;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class p0 {

    /* renamed from: a, reason: collision with root package name */
    public final q f2515a;

    static {
        new SparseBooleanArray();
        g1.a.k(!false);
        g1.w.H(0);
    }

    public p0(q qVar) {
        this.f2515a = qVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p0) {
            return this.f2515a.equals(((p0) obj).f2515a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2515a.hashCode();
    }
}
