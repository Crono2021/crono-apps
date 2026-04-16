package l1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final z1.d f5911a;

    /* renamed from: b, reason: collision with root package name */
    public final long f5912b;

    /* renamed from: c, reason: collision with root package name */
    public final long f5913c;

    /* renamed from: d, reason: collision with root package name */
    public final long f5914d;

    /* renamed from: e, reason: collision with root package name */
    public final long f5915e;

    /* renamed from: f, reason: collision with root package name */
    public final int f5916f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f5917g;
    public final long h;

    /* renamed from: i, reason: collision with root package name */
    public int f5918i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f5919j;

    public i(z1.d dVar, int i9, int i10, int i11, int i12, boolean z8) {
        a(i11, 0, "bufferForPlaybackMs", "0");
        a(i12, 0, "bufferForPlaybackAfterRebufferMs", "0");
        a(i9, i11, "minBufferMs", "bufferForPlaybackMs");
        a(i9, i12, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        a(i10, i9, "maxBufferMs", "minBufferMs");
        a(0, 0, "backBufferDurationMs", "0");
        this.f5911a = dVar;
        this.f5912b = g1.w.M(i9);
        this.f5913c = g1.w.M(i10);
        this.f5914d = g1.w.M(i11);
        this.f5915e = g1.w.M(i12);
        this.f5916f = -1;
        this.f5918i = 13107200;
        this.f5917g = z8;
        this.h = g1.w.M(0);
    }

    public static void a(int i9, int i10, String str, String str2) {
        g1.a.e(str + " cannot be less than " + str2, i9 >= i10);
    }

    public final void b(boolean z8) {
        int i9 = this.f5916f;
        if (i9 == -1) {
            i9 = 13107200;
        }
        this.f5918i = i9;
        this.f5919j = false;
        if (z8) {
            z1.d dVar = this.f5911a;
            synchronized (dVar) {
                if (dVar.f10542a) {
                    dVar.a(0);
                }
            }
        }
    }

    public final boolean c(long j5, float f9) {
        int i9;
        long j9 = this.f5913c;
        z1.d dVar = this.f5911a;
        synchronized (dVar) {
            i9 = dVar.f10545d * dVar.f10543b;
        }
        boolean z8 = true;
        boolean z9 = i9 >= this.f5918i;
        long j10 = this.f5912b;
        if (f9 > 1.0f) {
            j10 = Math.min(g1.w.w(j10, f9), j9);
        }
        if (j5 < Math.max(j10, 500000L)) {
            if (!this.f5917g && z9) {
                z8 = false;
            }
            this.f5919j = z8;
            if (!z8 && j5 < 500000) {
                g1.a.D("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j5 >= j9 || z9) {
            this.f5919j = false;
        }
        return this.f5919j;
    }
}
