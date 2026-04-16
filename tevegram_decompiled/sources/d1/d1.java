package d1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class d1 {

    /* renamed from: a, reason: collision with root package name */
    public final int f2390a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2391b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2392c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2393d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2394e;

    /* renamed from: f, reason: collision with root package name */
    public final int f2395f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f2396g;
    public final b6.g0 h;

    /* renamed from: i, reason: collision with root package name */
    public final b6.g0 f2397i;

    /* renamed from: j, reason: collision with root package name */
    public final int f2398j;

    /* renamed from: k, reason: collision with root package name */
    public final int f2399k;

    /* renamed from: l, reason: collision with root package name */
    public final b6.g0 f2400l;

    /* renamed from: m, reason: collision with root package name */
    public final b1 f2401m;

    /* renamed from: n, reason: collision with root package name */
    public final b6.g0 f2402n;

    /* renamed from: o, reason: collision with root package name */
    public final int f2403o;

    /* renamed from: p, reason: collision with root package name */
    public final int f2404p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f2405q;

    /* renamed from: r, reason: collision with root package name */
    public final b6.b1 f2406r;

    /* renamed from: s, reason: collision with root package name */
    public final b6.k0 f2407s;

    static {
        new d1(new c1());
        g1.w.H(1);
        g1.w.H(2);
        g1.w.H(3);
        g1.w.H(4);
        androidx.activity.g.s(5, 6, 7, 8, 9);
        androidx.activity.g.s(10, 11, 12, 13, 14);
        androidx.activity.g.s(15, 16, 17, 18, 19);
        androidx.activity.g.s(20, 21, 22, 23, 24);
        androidx.activity.g.s(25, 26, 27, 28, 29);
        g1.w.H(30);
        g1.w.H(31);
    }

    public d1(c1 c1Var) {
        this.f2390a = c1Var.f2372a;
        this.f2391b = c1Var.f2373b;
        this.f2392c = c1Var.f2374c;
        this.f2393d = c1Var.f2375d;
        this.f2394e = c1Var.f2376e;
        this.f2395f = c1Var.f2377f;
        this.f2396g = c1Var.f2378g;
        this.h = c1Var.h;
        this.f2397i = c1Var.f2379i;
        this.f2398j = c1Var.f2380j;
        this.f2399k = c1Var.f2381k;
        this.f2400l = c1Var.f2382l;
        this.f2401m = c1Var.f2383m;
        this.f2402n = c1Var.f2384n;
        this.f2403o = c1Var.f2385o;
        this.f2404p = c1Var.f2386p;
        this.f2405q = c1Var.f2387q;
        this.f2406r = b6.b1.a(c1Var.f2388r);
        this.f2407s = b6.k0.n(c1Var.f2389s);
    }

    public c1 a() {
        c1 c1Var = new c1();
        c1Var.c(this);
        return c1Var;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d1 d1Var = (d1) obj;
        if (this.f2390a != d1Var.f2390a || this.f2391b != d1Var.f2391b || this.f2392c != d1Var.f2392c || this.f2393d != d1Var.f2393d || this.f2396g != d1Var.f2396g || this.f2394e != d1Var.f2394e || this.f2395f != d1Var.f2395f || !this.h.equals(d1Var.h) || !this.f2397i.equals(d1Var.f2397i) || this.f2398j != d1Var.f2398j || this.f2399k != d1Var.f2399k || !this.f2400l.equals(d1Var.f2400l) || !this.f2401m.equals(d1Var.f2401m) || !this.f2402n.equals(d1Var.f2402n) || this.f2403o != d1Var.f2403o || this.f2404p != d1Var.f2404p || this.f2405q != d1Var.f2405q) {
            return false;
        }
        b6.b1 b1Var = d1Var.f2406r;
        b6.b1 b1Var2 = this.f2406r;
        b1Var2.getClass();
        return b6.q.d(b1Var2, b1Var) && this.f2407s.equals(d1Var.f2407s);
    }

    public int hashCode() {
        int hashCode = (this.f2400l.hashCode() + ((((((this.f2397i.hashCode() + ((this.h.hashCode() + ((((((((((((((this.f2390a + 31) * 31) + this.f2391b) * 31) + this.f2392c) * 31) + this.f2393d) * 28629151) + (this.f2396g ? 1 : 0)) * 31) + this.f2394e) * 31) + this.f2395f) * 31)) * 961)) * 961) + this.f2398j) * 31) + this.f2399k) * 31)) * 31;
        this.f2401m.getClass();
        return this.f2407s.hashCode() + ((this.f2406r.hashCode() + ((((((((this.f2402n.hashCode() + ((hashCode + 29791) * 31)) * 31) + this.f2403o) * 31) + this.f2404p) * 31) + (this.f2405q ? 1 : 0)) * 923521)) * 31);
    }
}
