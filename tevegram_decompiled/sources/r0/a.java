package r0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f8488a;

    /* renamed from: b, reason: collision with root package name */
    public int f8489b;

    /* renamed from: c, reason: collision with root package name */
    public float f8490c;

    /* renamed from: d, reason: collision with root package name */
    public float f8491d;

    /* renamed from: e, reason: collision with root package name */
    public long f8492e;

    /* renamed from: f, reason: collision with root package name */
    public long f8493f;

    /* renamed from: g, reason: collision with root package name */
    public long f8494g;
    public float h;

    /* renamed from: i, reason: collision with root package name */
    public int f8495i;

    public final float a(long j5) {
        if (j5 < this.f8492e) {
            return 0.0f;
        }
        long j9 = this.f8494g;
        if (j9 < 0 || j5 < j9) {
            return g.b((j5 - r0) / this.f8488a, 0.0f, 1.0f) * 0.5f;
        }
        float f9 = this.h;
        return (g.b((j5 - j9) / this.f8495i, 0.0f, 1.0f) * f9) + (1.0f - f9);
    }
}
