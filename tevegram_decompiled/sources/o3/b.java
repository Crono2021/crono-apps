package o3;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final i7.x f7590a;

    /* renamed from: b, reason: collision with root package name */
    public int f7591b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f7592c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f7593d = -1;

    /* renamed from: e, reason: collision with root package name */
    public Object f7594e = null;

    public b(i7.x xVar) {
        this.f7590a = xVar;
    }

    public final void a() {
        g0 g0Var = (g0) this.f7590a.f5179j;
        int i9 = this.f7591b;
        if (i9 == 0) {
            return;
        }
        if (i9 == 1) {
            g0Var.f7659a.e(this.f7592c, this.f7593d);
        } else if (i9 == 2) {
            g0Var.f7659a.f(this.f7592c, this.f7593d);
        } else if (i9 == 3) {
            g0Var.f7659a.d(this.f7592c, this.f7593d, this.f7594e);
        }
        this.f7594e = null;
        this.f7591b = 0;
    }

    public final void b(int i9, int i10, Object obj) {
        int i11;
        int i12;
        int i13;
        if (this.f7591b == 3 && i9 <= (i12 = this.f7593d + (i11 = this.f7592c)) && (i13 = i9 + i10) >= i11 && this.f7594e == obj) {
            this.f7592c = Math.min(i9, i11);
            this.f7593d = Math.max(i12, i13) - this.f7592c;
            return;
        }
        a();
        this.f7592c = i9;
        this.f7593d = i10;
        this.f7594e = obj;
        this.f7591b = 3;
    }

    public final void c(int i9, int i10) {
        a();
        ((g0) this.f7590a.f5179j).f7659a.c(i9, i10);
    }
}
