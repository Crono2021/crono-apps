package v1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c1 {

    /* renamed from: d, reason: collision with root package name */
    public static final c1 f9255d = new c1(new d1.z0[0]);

    /* renamed from: a, reason: collision with root package name */
    public final int f9256a;

    /* renamed from: b, reason: collision with root package name */
    public final b6.w0 f9257b;

    /* renamed from: c, reason: collision with root package name */
    public int f9258c;

    static {
        g1.w.H(0);
    }

    public c1(d1.z0... z0VarArr) {
        b6.w0 n4 = b6.g0.n(z0VarArr);
        this.f9257b = n4;
        this.f9256a = z0VarArr.length;
        int i9 = 0;
        while (i9 < n4.f1466l) {
            int i10 = i9 + 1;
            for (int i11 = i10; i11 < n4.f1466l; i11++) {
                if (((d1.z0) n4.get(i9)).equals(n4.get(i11))) {
                    g1.a.q("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i9 = i10;
        }
    }

    public final d1.z0 a(int i9) {
        return (d1.z0) this.f9257b.get(i9);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c1.class != obj.getClass()) {
            return false;
        }
        c1 c1Var = (c1) obj;
        return this.f9256a == c1Var.f9256a && this.f9257b.equals(c1Var.f9257b);
    }

    public final int hashCode() {
        if (this.f9258c == 0) {
            this.f9258c = this.f9257b.hashCode();
        }
        return this.f9258c;
    }
}
