package d1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f1 {

    /* renamed from: b, reason: collision with root package name */
    public static final f1 f2421b;

    /* renamed from: a, reason: collision with root package name */
    public final b6.g0 f2422a;

    static {
        b6.e0 e0Var = b6.g0.f1391j;
        f2421b = new f1(b6.w0.f1464m);
        g1.w.H(0);
    }

    public f1(b6.w0 w0Var) {
        this.f2422a = b6.g0.m(w0Var);
    }

    public final boolean a(int i9) {
        int i10 = 0;
        while (true) {
            b6.g0 g0Var = this.f2422a;
            if (i10 >= g0Var.size()) {
                return false;
            }
            e1 e1Var = (e1) g0Var.get(i10);
            boolean[] zArr = e1Var.f2418e;
            int length = zArr.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                if (!zArr[i11]) {
                    i11++;
                } else if (e1Var.f2415b.f2618c == i9) {
                    return true;
                }
            }
            i10++;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f1.class != obj.getClass()) {
            return false;
        }
        return this.f2422a.equals(((f1) obj).f2422a);
    }

    public final int hashCode() {
        return this.f2422a.hashCode();
    }
}
