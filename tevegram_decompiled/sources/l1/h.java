package l1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final long f5880a;

    /* renamed from: b, reason: collision with root package name */
    public final long f5881b;

    /* renamed from: c, reason: collision with root package name */
    public long f5882c = -9223372036854775807L;

    /* renamed from: d, reason: collision with root package name */
    public long f5883d = -9223372036854775807L;

    /* renamed from: f, reason: collision with root package name */
    public long f5885f = -9223372036854775807L;

    /* renamed from: g, reason: collision with root package name */
    public long f5886g = -9223372036854775807L;

    /* renamed from: j, reason: collision with root package name */
    public float f5888j = 0.97f;

    /* renamed from: i, reason: collision with root package name */
    public float f5887i = 1.03f;

    /* renamed from: k, reason: collision with root package name */
    public float f5889k = 1.0f;

    /* renamed from: l, reason: collision with root package name */
    public long f5890l = -9223372036854775807L;

    /* renamed from: e, reason: collision with root package name */
    public long f5884e = -9223372036854775807L;
    public long h = -9223372036854775807L;

    /* renamed from: m, reason: collision with root package name */
    public long f5891m = -9223372036854775807L;

    /* renamed from: n, reason: collision with root package name */
    public long f5892n = -9223372036854775807L;

    public h(long j5, long j9) {
        this.f5880a = j5;
        this.f5881b = j9;
    }

    public final void a() {
        long j5;
        long j9 = this.f5882c;
        if (j9 != -9223372036854775807L) {
            j5 = this.f5883d;
            if (j5 == -9223372036854775807L) {
                long j10 = this.f5885f;
                if (j10 != -9223372036854775807L && j9 < j10) {
                    j9 = j10;
                }
                j5 = this.f5886g;
                if (j5 == -9223372036854775807L || j9 <= j5) {
                    j5 = j9;
                }
            }
        } else {
            j5 = -9223372036854775807L;
        }
        if (this.f5884e == j5) {
            return;
        }
        this.f5884e = j5;
        this.h = j5;
        this.f5891m = -9223372036854775807L;
        this.f5892n = -9223372036854775807L;
        this.f5890l = -9223372036854775807L;
    }
}
