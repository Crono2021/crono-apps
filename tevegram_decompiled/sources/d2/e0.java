package d2;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f2682a = new byte[10];

    /* renamed from: b, reason: collision with root package name */
    public boolean f2683b;

    /* renamed from: c, reason: collision with root package name */
    public int f2684c;

    /* renamed from: d, reason: collision with root package name */
    public long f2685d;

    /* renamed from: e, reason: collision with root package name */
    public int f2686e;

    /* renamed from: f, reason: collision with root package name */
    public int f2687f;

    /* renamed from: g, reason: collision with root package name */
    public int f2688g;

    public final void a(d0 d0Var, c0 c0Var) {
        if (this.f2684c > 0) {
            d0Var.d(this.f2685d, this.f2686e, this.f2687f, this.f2688g, c0Var);
            this.f2684c = 0;
        }
    }

    public final void b(d0 d0Var, long j5, int i9, int i10, int i11, c0 c0Var) {
        if (!(this.f2688g <= i10 + i11)) {
            m7.c.p("TrueHD chunk samples must be contiguous in the sample queue.");
            return;
        }
        if (this.f2683b) {
            int i12 = this.f2684c;
            int i13 = i12 + 1;
            this.f2684c = i13;
            if (i12 == 0) {
                this.f2685d = j5;
                this.f2686e = i9;
                this.f2687f = 0;
            }
            this.f2687f += i10;
            this.f2688g = i11;
            if (i13 >= 16) {
                a(d0Var, c0Var);
            }
        }
    }

    public final void c(n nVar) {
        if (this.f2683b) {
            return;
        }
        byte[] bArr = this.f2682a;
        nVar.a(0, 10, bArr);
        nVar.h();
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111) {
            byte b9 = bArr[7];
            if ((b9 & 254) == 186) {
                r1 = 40 << ((bArr[((b9 & 255) == 187 ? 1 : 0) != 0 ? '\t' : '\b'] >> 4) & 7);
            }
        }
        if (r1 == 0) {
            return;
        }
        this.f2683b = true;
    }
}
