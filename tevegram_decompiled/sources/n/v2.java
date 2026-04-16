package n;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class v2 {

    /* renamed from: a, reason: collision with root package name */
    public int f7073a;

    /* renamed from: b, reason: collision with root package name */
    public int f7074b;

    /* renamed from: c, reason: collision with root package name */
    public int f7075c;

    /* renamed from: d, reason: collision with root package name */
    public int f7076d;

    /* renamed from: e, reason: collision with root package name */
    public int f7077e;

    /* renamed from: f, reason: collision with root package name */
    public int f7078f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f7079g;
    public boolean h;

    public final void a(int i9, int i10) {
        this.f7075c = i9;
        this.f7076d = i10;
        this.h = true;
        if (this.f7079g) {
            if (i10 != Integer.MIN_VALUE) {
                this.f7073a = i10;
            }
            if (i9 != Integer.MIN_VALUE) {
                this.f7074b = i9;
                return;
            }
            return;
        }
        if (i9 != Integer.MIN_VALUE) {
            this.f7073a = i9;
        }
        if (i10 != Integer.MIN_VALUE) {
            this.f7074b = i10;
        }
    }
}
