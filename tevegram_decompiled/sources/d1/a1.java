package d1;

import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a1 {

    /* renamed from: a, reason: collision with root package name */
    public final z0 f2353a;

    /* renamed from: b, reason: collision with root package name */
    public final b6.g0 f2354b;

    static {
        g1.w.H(0);
        g1.w.H(1);
    }

    public a1(z0 z0Var, List list) {
        if (!list.isEmpty() && (((Integer) Collections.min(list)).intValue() < 0 || ((Integer) Collections.max(list)).intValue() >= z0Var.f2616a)) {
            throw new IndexOutOfBoundsException();
        }
        this.f2353a = z0Var;
        this.f2354b = b6.g0.m(list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a1.class == obj.getClass()) {
            a1 a1Var = (a1) obj;
            if (this.f2353a.equals(a1Var.f2353a) && this.f2354b.equals(a1Var.f2354b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f2354b.hashCode() * 31) + this.f2353a.hashCode();
    }
}
