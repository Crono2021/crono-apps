package d1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class w0 {

    /* renamed from: a, reason: collision with root package name */
    public Object f2584a;

    /* renamed from: b, reason: collision with root package name */
    public Object f2585b;

    /* renamed from: c, reason: collision with root package name */
    public int f2586c;

    /* renamed from: d, reason: collision with root package name */
    public long f2587d;

    /* renamed from: e, reason: collision with root package name */
    public long f2588e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2589f;

    /* renamed from: g, reason: collision with root package name */
    public c f2590g = c.f2367c;

    static {
        androidx.activity.g.s(0, 1, 2, 3, 4);
    }

    public final long a(int i9, int i10) {
        b a9 = this.f2590g.a(i9);
        if (a9.f2355a != -1) {
            return a9.f2360f[i10];
        }
        return -9223372036854775807L;
    }

    public final int b(long j5) {
        b a9;
        int i9;
        c cVar = this.f2590g;
        long j9 = this.f2587d;
        int i10 = cVar.f2369a;
        if (j5 != Long.MIN_VALUE && (j9 == -9223372036854775807L || j5 < j9)) {
            int i11 = 0;
            while (i11 < i10) {
                cVar.a(i11).getClass();
                cVar.a(i11).getClass();
                if (0 > j5 && ((i9 = (a9 = cVar.a(i11)).f2355a) == -1 || a9.a(-1) < i9)) {
                    break;
                }
                i11++;
            }
            if (i11 < i10) {
                return i11;
            }
        }
        return -1;
    }

    public final int c(long j5) {
        int i9;
        c cVar = this.f2590g;
        int i10 = cVar.f2369a - 1;
        cVar.b(i10);
        while (i10 >= 0 && j5 != Long.MIN_VALUE) {
            cVar.a(i10).getClass();
            if (j5 >= 0) {
                break;
            }
            i10--;
        }
        if (i10 >= 0) {
            b a9 = cVar.a(i10);
            int i11 = a9.f2355a;
            if (i11 != -1) {
                while (i9 < i11) {
                    int i12 = a9.f2359e[i9];
                    i9 = (i12 == 0 || i12 == 1) ? 0 : i9 + 1;
                }
            }
            return i10;
        }
        return -1;
    }

    public final long d(int i9) {
        this.f2590g.a(i9).getClass();
        return 0L;
    }

    public final int e(int i9) {
        return this.f2590g.a(i9).a(-1);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !w0.class.equals(obj.getClass())) {
            return false;
        }
        w0 w0Var = (w0) obj;
        return g1.w.a(this.f2584a, w0Var.f2584a) && g1.w.a(this.f2585b, w0Var.f2585b) && this.f2586c == w0Var.f2586c && this.f2587d == w0Var.f2587d && this.f2588e == w0Var.f2588e && this.f2589f == w0Var.f2589f && g1.w.a(this.f2590g, w0Var.f2590g);
    }

    public final boolean f(int i9) {
        c cVar = this.f2590g;
        if (i9 != cVar.f2369a - 1) {
            return false;
        }
        cVar.b(i9);
        return false;
    }

    public final boolean g(int i9) {
        this.f2590g.a(i9).getClass();
        return false;
    }

    public final void h(Object obj, Object obj2, int i9, long j5, long j9, c cVar, boolean z8) {
        this.f2584a = obj;
        this.f2585b = obj2;
        this.f2586c = i9;
        this.f2587d = j5;
        this.f2588e = j9;
        this.f2590g = cVar;
        this.f2589f = z8;
    }

    public final int hashCode() {
        Object obj = this.f2584a;
        int hashCode = (217 + (obj == null ? 0 : obj.hashCode())) * 31;
        Object obj2 = this.f2585b;
        int hashCode2 = (((hashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.f2586c) * 31;
        long j5 = this.f2587d;
        int i9 = (hashCode2 + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        long j9 = this.f2588e;
        return this.f2590g.hashCode() + ((((i9 + ((int) (j9 ^ (j9 >>> 32)))) * 31) + (this.f2589f ? 1 : 0)) * 31);
    }
}
