package i3;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final d2.d0 f4534a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f4535b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4536c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4537d;

    /* renamed from: e, reason: collision with root package name */
    public int f4538e;

    /* renamed from: f, reason: collision with root package name */
    public int f4539f;

    /* renamed from: g, reason: collision with root package name */
    public long f4540g;
    public long h;

    public l(d2.d0 d0Var) {
        this.f4534a = d0Var;
    }

    public final void a(int i9, int i10, byte[] bArr) {
        if (this.f4536c) {
            int i11 = this.f4539f;
            int i12 = (i9 + 1) - i11;
            if (i12 >= i10) {
                this.f4539f = (i10 - i9) + i11;
            } else {
                this.f4537d = ((bArr[i12] & 192) >> 6) == 0;
                this.f4536c = false;
            }
        }
    }
}
