package f0;

import android.graphics.Path;
import android.util.Log;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public char f3198a;

    /* renamed from: b, reason: collision with root package name */
    public float[] f3199b;

    public static void a(Path path, float f9, float f10, float f11, float f12, float f13, float f14, float f15, boolean z8, boolean z9) {
        double d9;
        double d10;
        double radians = Math.toRadians(f15);
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);
        double d11 = f9;
        double d12 = f10;
        double d13 = f13;
        double d14 = ((d12 * sin) + (d11 * cos)) / d13;
        double d15 = f14;
        double d16 = ((d12 * cos) + ((-f9) * sin)) / d15;
        double d17 = f12;
        double d18 = ((d17 * sin) + (f11 * cos)) / d13;
        double d19 = ((d17 * cos) + ((-f11) * sin)) / d15;
        double d20 = d14 - d18;
        double d21 = d16 - d19;
        double d22 = (d14 + d18) / 2.0d;
        double d23 = (d16 + d19) / 2.0d;
        double d24 = (d21 * d21) + (d20 * d20);
        if (d24 == 0.0d) {
            Log.w("PathParser", " Points are coincident");
            return;
        }
        double d25 = (1.0d / d24) - 0.25d;
        if (d25 < 0.0d) {
            Log.w("PathParser", "Points are too far apart " + d24);
            float sqrt = (float) (Math.sqrt(d24) / 1.99999d);
            a(path, f9, f10, f11, f12, f13 * sqrt, sqrt * f14, f15, z8, z9);
            return;
        }
        double sqrt2 = Math.sqrt(d25);
        double d26 = sqrt2 * d20;
        double d27 = sqrt2 * d21;
        if (z8 == z9) {
            d9 = d22 - d27;
            d10 = d23 + d26;
        } else {
            d9 = d22 + d27;
            d10 = d23 - d26;
        }
        double atan2 = Math.atan2(d16 - d10, d14 - d9);
        double atan22 = Math.atan2(d19 - d10, d18 - d9) - atan2;
        if (z9 != (atan22 >= 0.0d)) {
            atan22 = atan22 > 0.0d ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
        }
        double d28 = d9 * d13;
        double d29 = d10 * d15;
        double d30 = (d28 * cos) - (d29 * sin);
        double d31 = (d29 * cos) + (d28 * sin);
        int ceil = (int) Math.ceil(Math.abs((atan22 * 4.0d) / 3.141592653589793d));
        double cos2 = Math.cos(radians);
        double sin2 = Math.sin(radians);
        double cos3 = Math.cos(atan2);
        double sin3 = Math.sin(atan2);
        double d32 = d12;
        double d33 = -d13;
        double d34 = d33 * cos2;
        double d35 = d15 * sin2;
        double d36 = (d34 * sin3) - (d35 * cos3);
        double d37 = d33 * sin2;
        double d38 = d15 * cos2;
        double d39 = (cos3 * d38) + (sin3 * d37);
        double d40 = atan22 / ceil;
        double d41 = atan2;
        int i9 = 0;
        while (i9 < ceil) {
            double d42 = d41 + d40;
            double sin4 = Math.sin(d42);
            double cos4 = Math.cos(d42);
            int i10 = ceil;
            double d43 = (((d13 * cos2) * cos4) + d30) - (d35 * sin4);
            double d44 = d37;
            double d45 = (d38 * sin4) + (d13 * sin2 * cos4) + d31;
            double d46 = (d34 * sin4) - (d35 * cos4);
            double d47 = (cos4 * d38) + (sin4 * d44);
            double d48 = d42 - d41;
            double tan = Math.tan(d48 / 2.0d);
            double sqrt3 = ((Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d) * Math.sin(d48)) / 3.0d;
            path.rLineTo(0.0f, 0.0f);
            path.cubicTo((float) ((d36 * sqrt3) + d11), (float) ((d39 * sqrt3) + d32), (float) (d43 - (sqrt3 * d46)), (float) (d45 - (sqrt3 * d47)), (float) d43, (float) d45);
            i9++;
            d11 = d43;
            d32 = d45;
            d30 = d30;
            d41 = d42;
            cos2 = cos2;
            d39 = d47;
            d36 = d46;
            ceil = i10;
            d40 = d40;
            d37 = d44;
        }
    }

    public static void b(f[] fVarArr, Path path) {
        int i9;
        int i10;
        float[] fArr;
        char c9;
        float f9;
        float f10;
        float[] fArr2;
        boolean z8;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        Path path2 = path;
        float[] fArr3 = new float[6];
        char c10 = 0;
        char c11 = 'm';
        int i11 = 0;
        while (i11 < fVarArr.length) {
            f fVar = fVarArr[i11];
            char c12 = fVar.f3198a;
            float[] fArr4 = fVar.f3199b;
            float f20 = fArr3[c10];
            float f21 = fArr3[1];
            float f22 = fArr3[2];
            float f23 = fArr3[3];
            float f24 = fArr3[4];
            float f25 = fArr3[5];
            switch (c12) {
                case 'A':
                case 'a':
                    i9 = 7;
                    break;
                case 'C':
                case 'c':
                    i9 = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i9 = 1;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i9 = 4;
                    break;
                case 'Z':
                case IjkMediaMeta.FF_PROFILE_H264_HIGH_422 /* 122 */:
                    path2.close();
                    path2.moveTo(f24, f25);
                    f20 = f24;
                    f22 = f20;
                    f21 = f25;
                    f23 = f21;
                default:
                    i9 = 2;
                    break;
            }
            float f26 = f21;
            float f27 = f24;
            float f28 = f25;
            float f29 = f20;
            int i12 = 0;
            while (i12 < fArr4.length) {
                if (c12 == 'A') {
                    i10 = i12;
                    fArr = fArr4;
                    float f30 = f26;
                    c9 = c12;
                    int i13 = i10 + 5;
                    int i14 = i10 + 6;
                    a(path, f29, f30, fArr[i13], fArr[i14], fArr[i10], fArr[i10 + 1], fArr[i10 + 2], fArr[i10 + 3] != 0.0f, fArr[i10 + 4] != 0.0f);
                    f22 = fArr[i13];
                    f29 = f22;
                    f9 = fArr[i14];
                    f23 = f9;
                } else if (c12 == 'C') {
                    i10 = i12;
                    c9 = c12;
                    fArr = fArr4;
                    int i15 = i10 + 2;
                    int i16 = i10 + 3;
                    int i17 = i10 + 4;
                    int i18 = i10 + 5;
                    path2.cubicTo(fArr[i10], fArr[i10 + 1], fArr[i15], fArr[i16], fArr[i17], fArr[i18]);
                    float f31 = fArr[i17];
                    float f32 = fArr[i18];
                    f29 = f31;
                    f22 = fArr[i15];
                    f23 = fArr[i16];
                    f9 = f32;
                } else if (c12 != 'H') {
                    if (c12 == 'Q') {
                        i10 = i12;
                        c9 = c12;
                        fArr = fArr4;
                        int i19 = i10 + 1;
                        int i20 = i10 + 2;
                        int i21 = i10 + 3;
                        path2.quadTo(fArr[i10], fArr[i19], fArr[i20], fArr[i21]);
                        f10 = fArr[i10];
                        f23 = fArr[i19];
                        f29 = fArr[i20];
                        f9 = fArr[i21];
                    } else if (c12 == 'V') {
                        i10 = i12;
                        c9 = c12;
                        fArr = fArr4;
                        path2.lineTo(f29, fArr[i10]);
                        f9 = fArr[i10];
                    } else if (c12 != 'a') {
                        if (c12 == 'c') {
                            i10 = i12;
                            int i22 = i10 + 2;
                            int i23 = i10 + 3;
                            int i24 = i10 + 4;
                            int i25 = i10 + 5;
                            path2.rCubicTo(fArr4[i10], fArr4[i10 + 1], fArr4[i22], fArr4[i23], fArr4[i24], fArr4[i25]);
                            float f33 = fArr4[i22] + f29;
                            float f34 = f26 + fArr4[i23];
                            f29 += fArr4[i24];
                            f26 += fArr4[i25];
                            f22 = f33;
                            f23 = f34;
                        } else if (c12 != 'h') {
                            if (c12 != 'q') {
                                if (c12 != 'v') {
                                    if (c12 == 'L') {
                                        i10 = i12;
                                        int i26 = i10 + 1;
                                        path2.lineTo(fArr4[i10], fArr4[i26]);
                                        f15 = fArr4[i10];
                                        f9 = fArr4[i26];
                                    } else if (c12 == 'M') {
                                        i10 = i12;
                                        f15 = fArr4[i10];
                                        f9 = fArr4[i10 + 1];
                                        if (i10 > 0) {
                                            path2.lineTo(f15, f9);
                                        } else {
                                            path2.moveTo(f15, f9);
                                            f29 = f15;
                                            f27 = f29;
                                            f28 = f9;
                                            c9 = c12;
                                            fArr = fArr4;
                                        }
                                    } else if (c12 == 'S') {
                                        i10 = i12;
                                        if (c11 == 'c' || c11 == 's' || c11 == 'C' || c11 == 'S') {
                                            f29 = (f29 * 2.0f) - f22;
                                            f26 = (f26 * 2.0f) - f23;
                                        }
                                        float f35 = f29;
                                        int i27 = i10 + 1;
                                        int i28 = i10 + 2;
                                        int i29 = i10 + 3;
                                        path2.cubicTo(f35, f26, fArr4[i10], fArr4[i27], fArr4[i28], fArr4[i29]);
                                        f10 = fArr4[i10];
                                        f23 = fArr4[i27];
                                        f29 = fArr4[i28];
                                        f9 = fArr4[i29];
                                        c9 = c12;
                                        fArr = fArr4;
                                    } else if (c12 == 'T') {
                                        i10 = i12;
                                        if (c11 == 'q' || c11 == 't' || c11 == 'Q' || c11 == 'T') {
                                            f29 = (f29 * 2.0f) - f22;
                                            f26 = (f26 * 2.0f) - f23;
                                        }
                                        float f36 = f26;
                                        int i30 = i10 + 1;
                                        path2.quadTo(f29, f36, fArr4[i10], fArr4[i30]);
                                        f23 = f36;
                                        c9 = c12;
                                        fArr = fArr4;
                                        f22 = f29;
                                        f29 = fArr4[i10];
                                        f9 = fArr4[i30];
                                    } else if (c12 == 'l') {
                                        i10 = i12;
                                        int i31 = i10 + 1;
                                        path2.rLineTo(fArr4[i10], fArr4[i31]);
                                        f29 += fArr4[i10];
                                        f14 = fArr4[i31];
                                    } else if (c12 == 'm') {
                                        i10 = i12;
                                        float f37 = fArr4[i10];
                                        f29 += f37;
                                        float f38 = fArr4[i10 + 1];
                                        f26 += f38;
                                        if (i10 > 0) {
                                            path2.rLineTo(f37, f38);
                                        } else {
                                            path2.rMoveTo(f37, f38);
                                            fArr = fArr4;
                                            f27 = f29;
                                            f9 = f26;
                                            f28 = f9;
                                            c9 = c12;
                                        }
                                    } else if (c12 == 's') {
                                        if (c11 == 'c' || c11 == 's' || c11 == 'C' || c11 == 'S') {
                                            f16 = f26 - f23;
                                            f17 = f29 - f22;
                                        } else {
                                            f17 = 0.0f;
                                            f16 = 0.0f;
                                        }
                                        int i32 = i12 + 1;
                                        int i33 = i12 + 2;
                                        int i34 = i12 + 3;
                                        i10 = i12;
                                        path2.rCubicTo(f17, f16, fArr4[i12], fArr4[i32], fArr4[i33], fArr4[i34]);
                                        f11 = fArr4[i10] + f29;
                                        f12 = f26 + fArr4[i32];
                                        f29 += fArr4[i33];
                                        f13 = fArr4[i34];
                                    } else if (c12 != 't') {
                                        i10 = i12;
                                    } else {
                                        if (c11 == 'q' || c11 == 't' || c11 == 'Q' || c11 == 'T') {
                                            f18 = f29 - f22;
                                            f19 = f26 - f23;
                                        } else {
                                            f19 = 0.0f;
                                            f18 = 0.0f;
                                        }
                                        int i35 = i12 + 1;
                                        path2.rQuadTo(f18, f19, fArr4[i12], fArr4[i35]);
                                        float f39 = f18 + f29;
                                        float f40 = f26 + f19;
                                        f29 += fArr4[i12];
                                        f26 += fArr4[i35];
                                        f23 = f40;
                                        i10 = i12;
                                        f22 = f39;
                                    }
                                    f29 = f15;
                                    c9 = c12;
                                    fArr = fArr4;
                                } else {
                                    i10 = i12;
                                    path2.rLineTo(0.0f, fArr4[i10]);
                                    f14 = fArr4[i10];
                                }
                                f26 += f14;
                            } else {
                                i10 = i12;
                                int i36 = i10 + 1;
                                int i37 = i10 + 2;
                                int i38 = i10 + 3;
                                path2.rQuadTo(fArr4[i10], fArr4[i36], fArr4[i37], fArr4[i38]);
                                f11 = fArr4[i10] + f29;
                                f12 = f26 + fArr4[i36];
                                f29 += fArr4[i37];
                                f13 = fArr4[i38];
                            }
                            f26 += f13;
                            f22 = f11;
                            f23 = f12;
                        } else {
                            i10 = i12;
                            path2.rLineTo(fArr4[i10], 0.0f);
                            f29 += fArr4[i10];
                        }
                        fArr = fArr4;
                        f9 = f26;
                        c9 = c12;
                    } else {
                        i10 = i12;
                        int i39 = i10 + 5;
                        float f41 = fArr4[i39] + f29;
                        int i40 = i10 + 6;
                        float f42 = fArr4[i40] + f26;
                        float f43 = fArr4[i10];
                        float f44 = fArr4[i10 + 1];
                        float f45 = fArr4[i10 + 2];
                        if (fArr4[i10 + 3] != 0.0f) {
                            fArr2 = fArr4;
                            z8 = true;
                        } else {
                            fArr2 = fArr4;
                            z8 = false;
                        }
                        float f46 = fArr2[i10 + 4];
                        fArr = fArr2;
                        float f47 = f29;
                        boolean z9 = f46 != 0.0f;
                        float f48 = f26;
                        c9 = c12;
                        a(path, f47, f48, f41, f42, f43, f44, f45, z8, z9);
                        f29 = f47 + fArr[i39];
                        f9 = fArr[i40] + f48;
                        f23 = f9;
                        f22 = f29;
                    }
                    f22 = f10;
                } else {
                    i10 = i12;
                    fArr = fArr4;
                    f9 = f26;
                    c9 = c12;
                    path2.lineTo(fArr[i10], f9);
                    f29 = fArr[i10];
                }
                c11 = c9;
                c12 = c11;
                fArr4 = fArr;
                f26 = f9;
                i12 = i10 + i9;
                path2 = path;
            }
            fArr3[0] = f29;
            fArr3[1] = f26;
            fArr3[2] = f22;
            fArr3[3] = f23;
            fArr3[4] = f27;
            fArr3[5] = f28;
            c11 = fVarArr[i11].f3198a;
            i11++;
            path2 = path;
            c10 = 0;
        }
    }
}
