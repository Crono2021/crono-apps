package w2;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f9715a;

    /* renamed from: b, reason: collision with root package name */
    public int f9716b;

    /* renamed from: c, reason: collision with root package name */
    public int f9717c;

    /* renamed from: d, reason: collision with root package name */
    public long f9718d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f9719e;

    /* renamed from: f, reason: collision with root package name */
    public final g1.p f9720f;

    /* renamed from: g, reason: collision with root package name */
    public final g1.p f9721g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public int f9722i;

    public c(g1.p pVar, g1.p pVar2, boolean z8) {
        this.f9721g = pVar;
        this.f9720f = pVar2;
        this.f9719e = z8;
        pVar2.F(12);
        this.f9715a = pVar2.x();
        pVar.F(12);
        this.f9722i = pVar.x();
        d2.b.c("first_chunk must be 1", pVar.g() == 1);
        this.f9716b = -1;
    }

    public final boolean a() {
        int i9 = this.f9716b + 1;
        this.f9716b = i9;
        if (i9 == this.f9715a) {
            return false;
        }
        boolean z8 = this.f9719e;
        g1.p pVar = this.f9720f;
        this.f9718d = z8 ? pVar.y() : pVar.v();
        if (this.f9716b == this.h) {
            g1.p pVar2 = this.f9721g;
            this.f9717c = pVar2.x();
            pVar2.G(4);
            int i10 = this.f9722i - 1;
            this.f9722i = i10;
            this.h = i10 > 0 ? pVar2.x() - 1 : -1;
        }
        return true;
    }
}
