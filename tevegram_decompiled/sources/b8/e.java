package b8;

import a8.s;
import a8.t;
import a8.u;
import a8.v;
import a8.w;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e implements d {

    /* renamed from: a, reason: collision with root package name */
    public final Class f1516a;

    static {
        int i9 = 0;
        List D0 = o7.i.D0(a8.a.class, a8.l.class, a8.p.class, a8.q.class, a8.r.class, s.class, t.class, u.class, v.class, w.class, a8.b.class, a8.c.class, a8.d.class, a8.e.class, a8.f.class, a8.g.class, a8.h.class, a8.i.class, a8.j.class, a8.k.class, a8.m.class, a8.n.class, a8.o.class);
        ArrayList arrayList = new ArrayList(o7.j.E0(D0));
        for (Object obj : D0) {
            int i10 = i9 + 1;
            if (i9 < 0) {
                throw new ArithmeticException("Index overflow has happened.");
            }
            arrayList.add(new n7.b((Class) obj, Integer.valueOf(i9)));
            i9 = i10;
        }
        o7.t.c0(arrayList);
    }

    public e(Class cls) {
        this.f1516a = cls;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof e) && z7.a.b(this).equals(z7.a.b((e) obj));
    }

    public final int hashCode() {
        return z7.a.b(this).hashCode();
    }

    public final String toString() {
        return this.f1516a + " (Kotlin reflection is not available)";
    }
}
