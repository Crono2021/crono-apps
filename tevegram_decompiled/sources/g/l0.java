package g;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l0 {

    /* renamed from: d, reason: collision with root package name */
    public static l0 f3579d;

    /* renamed from: a, reason: collision with root package name */
    public long f3580a;

    /* renamed from: b, reason: collision with root package name */
    public long f3581b;

    /* renamed from: c, reason: collision with root package name */
    public int f3582c;

    public final void a(long j5, double d9, double d10) {
        double d11 = (0.01720197f * ((j5 - 946728000000L) / 8.64E7f)) + 6.24006f;
        double sin = (Math.sin(r3 * 3.0f) * 5.236000106378924E-6d) + (Math.sin(2.0f * r3) * 3.4906598739326E-4d) + (Math.sin(d11) * 0.03341960161924362d) + d11 + 1.796593063d + 3.141592653589793d;
        double sin2 = (Math.sin(2.0d * sin) * (-0.0069d)) + (Math.sin(d11) * 0.0053d) + Math.round((r2 - 9.0E-4f) - r6) + 9.0E-4f + ((-d10) / 360.0d);
        double asin = Math.asin(Math.sin(0.4092797040939331d) * Math.sin(sin));
        double d12 = 0.01745329238474369d * d9;
        double sin3 = (Math.sin(-0.10471975803375244d) - (Math.sin(asin) * Math.sin(d12))) / (Math.cos(asin) * Math.cos(d12));
        if (sin3 >= 1.0d) {
            this.f3582c = 1;
            this.f3580a = -1L;
            this.f3581b = -1L;
        } else {
            if (sin3 <= -1.0d) {
                this.f3582c = 0;
                this.f3580a = -1L;
                this.f3581b = -1L;
                return;
            }
            double acos = (float) (Math.acos(sin3) / 6.283185307179586d);
            this.f3580a = Math.round((sin2 + acos) * 8.64E7d) + 946728000000L;
            long round = Math.round((sin2 - acos) * 8.64E7d) + 946728000000L;
            this.f3581b = round;
            if (round >= j5 || this.f3580a <= j5) {
                this.f3582c = 1;
            } else {
                this.f3582c = 0;
            }
        }
    }
}
