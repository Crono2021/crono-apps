package e0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class p {

    /* renamed from: k, reason: collision with root package name */
    public static final p f3004k;

    /* renamed from: a, reason: collision with root package name */
    public final float f3005a;

    /* renamed from: b, reason: collision with root package name */
    public final float f3006b;

    /* renamed from: c, reason: collision with root package name */
    public final float f3007c;

    /* renamed from: d, reason: collision with root package name */
    public final float f3008d;

    /* renamed from: e, reason: collision with root package name */
    public final float f3009e;

    /* renamed from: f, reason: collision with root package name */
    public final float f3010f;

    /* renamed from: g, reason: collision with root package name */
    public final float[] f3011g;
    public final float h;

    /* renamed from: i, reason: collision with root package name */
    public final float f3012i;

    /* renamed from: j, reason: collision with root package name */
    public final float f3013j;

    static {
        float[] fArr = b.f2976c;
        float n4 = (float) ((b.n() * 63.66197723675813d) / 100.0d);
        float[][] fArr2 = b.f2974a;
        float f9 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f10 = fArr3[0] * f9;
        float f11 = fArr[1];
        float f12 = (fArr3[1] * f11) + f10;
        float f13 = fArr[2];
        float f14 = (fArr3[2] * f13) + f12;
        float[] fArr4 = fArr2[1];
        float f15 = (fArr4[2] * f13) + (fArr4[1] * f11) + (fArr4[0] * f9);
        float[] fArr5 = fArr2[2];
        float f16 = (f13 * fArr5[2]) + (f11 * fArr5[1]) + (f9 * fArr5[0]);
        float f17 = ((double) 1.0f) >= 0.9d ? 0.69f : 0.655f;
        float exp = (1.0f - (((float) Math.exp(((-n4) - 42.0f) / 92.0f)) * 0.2777778f)) * 1.0f;
        double d9 = exp;
        if (d9 > 1.0d) {
            exp = 1.0f;
        } else if (d9 < 0.0d) {
            exp = 0.0f;
        }
        float f18 = 1.0f / ((5.0f * n4) + 1.0f);
        float f19 = f18 * f18 * f18 * f18;
        float f20 = 1.0f - f19;
        float cbrt = (0.1f * f20 * f20 * ((float) Math.cbrt(n4 * 5.0d))) + (f19 * n4);
        float n9 = b.n() / fArr[1];
        double d10 = n9;
        float sqrt = ((float) Math.sqrt(d10)) + 1.48f;
        float pow = 0.725f / ((float) Math.pow(d10, 0.2d));
        float[] fArr6 = {(float) Math.pow(((r2[0] * cbrt) * f14) / 100.0d, 0.42d), (float) Math.pow(((r2[1] * cbrt) * f15) / 100.0d, 0.42d), (float) Math.pow(((r2[2] * cbrt) * f16) / 100.0d, 0.42d)};
        float f21 = fArr6[0];
        float f22 = (f21 * 400.0f) / (f21 + 27.13f);
        float f23 = fArr6[1];
        float f24 = (f23 * 400.0f) / (f23 + 27.13f);
        float f25 = fArr6[2];
        float[] fArr7 = {f22, f24, (400.0f * f25) / (f25 + 27.13f)};
        f3004k = new p(n9, ((fArr7[2] * 0.05f) + (fArr7[0] * 2.0f) + fArr7[1]) * pow, pow, pow, f17, 1.0f, new float[]{(((100.0f / f14) * exp) + 1.0f) - exp, (((100.0f / f15) * exp) + 1.0f) - exp, (((100.0f / f16) * exp) + 1.0f) - exp}, cbrt, (float) Math.pow(cbrt, 0.25d), sqrt);
    }

    public p(float f9, float f10, float f11, float f12, float f13, float f14, float[] fArr, float f15, float f16, float f17) {
        this.f3010f = f9;
        this.f3005a = f10;
        this.f3006b = f11;
        this.f3007c = f12;
        this.f3008d = f13;
        this.f3009e = f14;
        this.f3011g = fArr;
        this.h = f15;
        this.f3012i = f16;
        this.f3013j = f17;
    }
}
