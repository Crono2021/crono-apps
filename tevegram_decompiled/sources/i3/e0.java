package i3;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f4480a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4481b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4482c;

    /* renamed from: d, reason: collision with root package name */
    public int f4483d;

    /* renamed from: e, reason: collision with root package name */
    public String f4484e;

    public e0(int i9, int i10, int i11) {
        String str;
        if (i9 != Integer.MIN_VALUE) {
            str = i9 + "/";
        } else {
            str = "";
        }
        this.f4480a = str;
        this.f4481b = i10;
        this.f4482c = i11;
        this.f4483d = Integer.MIN_VALUE;
        this.f4484e = "";
    }

    public final void a() {
        int i9 = this.f4483d;
        this.f4483d = i9 == Integer.MIN_VALUE ? this.f4481b : i9 + this.f4482c;
        this.f4484e = this.f4480a + this.f4483d;
    }

    public final void b() {
        if (this.f4483d != Integer.MIN_VALUE) {
            return;
        }
        m7.c.p("generateNewId() must be called before retrieving ids.");
    }

    public e0(int i9, int i10) {
        this(Integer.MIN_VALUE, i9, i10);
    }
}
