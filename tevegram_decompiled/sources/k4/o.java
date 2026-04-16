package k4;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class o {

    /* renamed from: b, reason: collision with root package name */
    public static final o f5575b = new o(2);

    /* renamed from: c, reason: collision with root package name */
    public static final o f5576c = new o(0);

    /* renamed from: d, reason: collision with root package name */
    public static final o f5577d;

    /* renamed from: e, reason: collision with root package name */
    public static final o f5578e;

    /* renamed from: f, reason: collision with root package name */
    public static final o f5579f;

    /* renamed from: g, reason: collision with root package name */
    public static final b4.h f5580g;
    public static final boolean h;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5581a;

    static {
        o oVar = new o(1);
        f5577d = oVar;
        f5578e = new o(3);
        f5579f = oVar;
        f5580g = b4.h.a(oVar, "com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy");
        h = true;
    }

    public /* synthetic */ o(int i9) {
        this.f5581a = i9;
    }

    public final int a(int i9, int i10, int i11, int i12) {
        switch (this.f5581a) {
            case 0:
                if (b(i9, i10, i11, i12) != 1.0f) {
                    break;
                }
                break;
            case 2:
                if (h) {
                }
                break;
        }
        return 2;
    }

    public final float b(int i9, int i10, int i11, int i12) {
        switch (this.f5581a) {
            case 0:
                return Math.min(1.0f, f5575b.b(i9, i10, i11, i12));
            case 1:
                return Math.max(i11 / i9, i12 / i10);
            case 2:
                if (h) {
                    return Math.min(i11 / i9, i12 / i10);
                }
                if (Math.max(i10 / i12, i9 / i11) == 0) {
                    return 1.0f;
                }
                return 1.0f / Integer.highestOneBit(r2);
            default:
                return 1.0f;
        }
    }
}
