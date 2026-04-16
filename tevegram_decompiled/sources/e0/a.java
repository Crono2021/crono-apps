package e0;

import android.graphics.Color;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final float f2968a;

    /* renamed from: b, reason: collision with root package name */
    public final float f2969b;

    /* renamed from: c, reason: collision with root package name */
    public final float f2970c;

    /* renamed from: d, reason: collision with root package name */
    public final float f2971d;

    /* renamed from: e, reason: collision with root package name */
    public final float f2972e;

    /* renamed from: f, reason: collision with root package name */
    public final float f2973f;

    public a(float f9, float f10, float f11, float f12, float f13, float f14) {
        this.f2968a = f9;
        this.f2969b = f10;
        this.f2970c = f11;
        this.f2971d = f12;
        this.f2972e = f13;
        this.f2973f = f14;
    }

    public static a a(int i9) {
        p pVar = p.f3004k;
        float f9 = b.f(Color.red(i9));
        float f10 = b.f(Color.green(i9));
        float f11 = b.f(Color.blue(i9));
        float[][] fArr = b.f2977d;
        float[] fArr2 = fArr[0];
        float f12 = (fArr2[2] * f11) + (fArr2[1] * f10) + (fArr2[0] * f9);
        float[] fArr3 = fArr[1];
        float f13 = (fArr3[2] * f11) + (fArr3[1] * f10) + (fArr3[0] * f9);
        float[] fArr4 = fArr[2];
        float f14 = (f11 * fArr4[2]) + (f10 * fArr4[1]) + (f9 * fArr4[0]);
        float[][] fArr5 = b.f2974a;
        float[] fArr6 = fArr5[0];
        float f15 = (fArr6[2] * f14) + (fArr6[1] * f13) + (fArr6[0] * f12);
        float[] fArr7 = fArr5[1];
        float f16 = (fArr7[2] * f14) + (fArr7[1] * f13) + (fArr7[0] * f12);
        float[] fArr8 = fArr5[2];
        float f17 = (f14 * fArr8[2]) + (f13 * fArr8[1]) + (f12 * fArr8[0]);
        float[] fArr9 = pVar.f3011g;
        float f18 = pVar.f3012i;
        float f19 = pVar.f3008d;
        float f20 = pVar.f3005a;
        float f21 = fArr9[0] * f15;
        float f22 = fArr9[1] * f16;
        float f23 = fArr9[2] * f17;
        float f24 = pVar.h;
        float pow = (float) Math.pow((Math.abs(f21) * f24) / 100.0d, 0.42d);
        float pow2 = (float) Math.pow((Math.abs(f22) * f24) / 100.0d, 0.42d);
        float pow3 = (float) Math.pow((Math.abs(f23) * f24) / 100.0d, 0.42d);
        float signum = ((Math.signum(f21) * 400.0f) * pow) / (pow + 27.13f);
        float signum2 = ((Math.signum(f22) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum3 = ((Math.signum(f23) * 400.0f) * pow3) / (pow3 + 27.13f);
        double d9 = signum3;
        float f25 = ((float) (((signum2 * (-12.0d)) + (signum * 11.0d)) + d9)) / 11.0f;
        float f26 = ((float) ((signum + signum2) - (d9 * 2.0d))) / 9.0f;
        float f27 = signum2 * 20.0f;
        float f28 = ((21.0f * signum3) + ((signum * 20.0f) + f27)) / 20.0f;
        float f29 = (((signum * 40.0f) + f27) + signum3) / 20.0f;
        float atan2 = (((float) Math.atan2(f26, f25)) * 180.0f) / 3.1415927f;
        if (atan2 < 0.0f) {
            atan2 += 360.0f;
        } else if (atan2 >= 360.0f) {
            atan2 -= 360.0f;
        }
        float f30 = (3.1415927f * atan2) / 180.0f;
        float pow4 = ((float) Math.pow((f29 * pVar.f3006b) / f20, pVar.f3013j * f19)) * 100.0f;
        Math.sqrt(pow4 / 100.0f);
        float f31 = f20 + 4.0f;
        float pow5 = ((float) Math.pow(1.64d - Math.pow(0.29d, pVar.f3010f), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos((((((double) atan2) < 20.14d ? 360.0f + atan2 : atan2) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * pVar.f3009e) * pVar.f3007c) * ((float) Math.sqrt((f26 * f26) + (f25 * f25)))) / (f28 + 0.305f), 0.9d)) * ((float) Math.sqrt(pow4 / 100.0d));
        Math.sqrt((r0 * f19) / f31);
        float f32 = (1.7f * pow4) / ((0.007f * pow4) + 1.0f);
        float log = ((float) Math.log((f18 * pow5 * 0.0228f) + 1.0f)) * 43.85965f;
        double d10 = f30;
        return new a(atan2, pow5, pow4, f32, log * ((float) Math.cos(d10)), log * ((float) Math.sin(d10)));
    }

    public static a b(float f9, float f10, float f11) {
        p pVar = p.f3004k;
        float f12 = pVar.f3008d;
        Math.sqrt(f9 / 100.0d);
        float f13 = pVar.f3005a + 4.0f;
        float f14 = pVar.f3012i * f10;
        Math.sqrt(((f10 / ((float) Math.sqrt(r1))) * pVar.f3008d) / f13);
        float f15 = (1.7f * f9) / ((0.007f * f9) + 1.0f);
        float log = ((float) Math.log((f14 * 0.0228d) + 1.0d)) * 43.85965f;
        double d9 = (3.1415927f * f11) / 180.0f;
        return new a(f11, f10, f9, f15, log * ((float) Math.cos(d9)), log * ((float) Math.sin(d9)));
    }

    public final int c(p pVar) {
        float f9;
        float f10 = this.f2969b;
        double d9 = f10;
        float f11 = this.f2970c;
        if (d9 != 0.0d) {
            double d10 = f11;
            if (d10 != 0.0d) {
                f9 = f10 / ((float) Math.sqrt(d10 / 100.0d));
                float f12 = pVar.f3010f;
                float f13 = pVar.h;
                float pow = (float) Math.pow(f9 / Math.pow(1.64d - Math.pow(0.29d, f12), 0.73d), 1.1111111111111112d);
                double d11 = (this.f2968a * 3.1415927f) / 180.0f;
                float cos = ((float) (Math.cos(2.0d + d11) + 3.8d)) * 0.25f;
                float pow2 = pVar.f3005a * ((float) Math.pow(f11 / 100.0d, (1.0d / pVar.f3008d) / pVar.f3013j));
                float f14 = cos * 3846.1538f * pVar.f3009e * pVar.f3007c;
                float f15 = pow2 / pVar.f3006b;
                float sin = (float) Math.sin(d11);
                float cos2 = (float) Math.cos(d11);
                float f16 = (((0.305f + f15) * 23.0f) * pow) / (((pow * 108.0f) * sin) + (((11.0f * pow) * cos2) + (f14 * 23.0f)));
                float f17 = cos2 * f16;
                float f18 = f16 * sin;
                float f19 = f15 * 460.0f;
                float f20 = ((288.0f * f18) + ((451.0f * f17) + f19)) / 1403.0f;
                float f21 = ((f19 - (891.0f * f17)) - (261.0f * f18)) / 1403.0f;
                float f22 = ((f19 - (f17 * 220.0f)) - (f18 * 6300.0f)) / 1403.0f;
                float f23 = 100.0f / f13;
                float signum = Math.signum(f20) * f23 * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f20) * 27.13d) / (400.0d - Math.abs(f20))), 2.380952380952381d));
                float signum2 = Math.signum(f21) * f23 * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f21) * 27.13d) / (400.0d - Math.abs(f21))), 2.380952380952381d));
                float signum3 = Math.signum(f22) * f23 * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f22) * 27.13d) / (400.0d - Math.abs(f22))), 2.380952380952381d));
                float[] fArr = pVar.f3011g;
                float f24 = signum / fArr[0];
                float f25 = signum2 / fArr[1];
                float f26 = signum3 / fArr[2];
                float[][] fArr2 = b.f2975b;
                float[] fArr3 = fArr2[0];
                float f27 = (fArr3[2] * f26) + (fArr3[1] * f25) + (fArr3[0] * f24);
                float[] fArr4 = fArr2[1];
                float f28 = (fArr4[2] * f26) + (fArr4[1] * f25) + (fArr4[0] * f24);
                float[] fArr5 = fArr2[2];
                return f0.a.a(f27, f28, (f26 * fArr5[2]) + (f25 * fArr5[1]) + (f24 * fArr5[0]));
            }
        }
        f9 = 0.0f;
        float f122 = pVar.f3010f;
        float f132 = pVar.h;
        float pow3 = (float) Math.pow(f9 / Math.pow(1.64d - Math.pow(0.29d, f122), 0.73d), 1.1111111111111112d);
        double d112 = (this.f2968a * 3.1415927f) / 180.0f;
        float cos3 = ((float) (Math.cos(2.0d + d112) + 3.8d)) * 0.25f;
        float pow22 = pVar.f3005a * ((float) Math.pow(f11 / 100.0d, (1.0d / pVar.f3008d) / pVar.f3013j));
        float f142 = cos3 * 3846.1538f * pVar.f3009e * pVar.f3007c;
        float f152 = pow22 / pVar.f3006b;
        float sin2 = (float) Math.sin(d112);
        float cos22 = (float) Math.cos(d112);
        float f162 = (((0.305f + f152) * 23.0f) * pow3) / (((pow3 * 108.0f) * sin2) + (((11.0f * pow3) * cos22) + (f142 * 23.0f)));
        float f172 = cos22 * f162;
        float f182 = f162 * sin2;
        float f192 = f152 * 460.0f;
        float f202 = ((288.0f * f182) + ((451.0f * f172) + f192)) / 1403.0f;
        float f212 = ((f192 - (891.0f * f172)) - (261.0f * f182)) / 1403.0f;
        float f222 = ((f192 - (f172 * 220.0f)) - (f182 * 6300.0f)) / 1403.0f;
        float f232 = 100.0f / f132;
        float signum4 = Math.signum(f202) * f232 * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f202) * 27.13d) / (400.0d - Math.abs(f202))), 2.380952380952381d));
        float signum22 = Math.signum(f212) * f232 * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f212) * 27.13d) / (400.0d - Math.abs(f212))), 2.380952380952381d));
        float signum32 = Math.signum(f222) * f232 * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f222) * 27.13d) / (400.0d - Math.abs(f222))), 2.380952380952381d));
        float[] fArr6 = pVar.f3011g;
        float f242 = signum4 / fArr6[0];
        float f252 = signum22 / fArr6[1];
        float f262 = signum32 / fArr6[2];
        float[][] fArr22 = b.f2975b;
        float[] fArr32 = fArr22[0];
        float f272 = (fArr32[2] * f262) + (fArr32[1] * f252) + (fArr32[0] * f242);
        float[] fArr42 = fArr22[1];
        float f282 = (fArr42[2] * f262) + (fArr42[1] * f252) + (fArr42[0] * f242);
        float[] fArr52 = fArr22[2];
        return f0.a.a(f272, f282, (f262 * fArr52[2]) + (f252 * fArr52[1]) + (f242 * fArr52[0]));
    }
}
