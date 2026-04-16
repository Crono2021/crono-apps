package i7;

import android.util.Log;
import com.network.tvgramplayer.ui.PlayerActivity;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class d3 implements a8.q {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4824i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ PlayerActivity f4825j;

    public /* synthetic */ d3(PlayerActivity playerActivity, int i9) {
        this.f4824i = i9;
        this.f4825j = playerActivity;
    }

    @Override // a8.q
    public final Object c(Object obj, Object obj2, Serializable serializable) {
        float[] fArr;
        float[] fArr2;
        float[][] fArr3;
        int i9;
        int i10;
        long j5;
        char c9;
        float f9;
        float f10;
        float f11;
        float f12;
        int i11 = this.f4824i;
        PlayerActivity playerActivity = this.f4825j;
        switch (i11) {
            case 0:
                short[] sArr = (short[]) obj;
                int intValue = ((Integer) obj2).intValue();
                ((Integer) serializable).getClass();
                int i12 = PlayerActivity.X;
                sArr.getClass();
                a0.l lVar = playerActivity.T;
                float[] fArr4 = (float[]) lVar.f32k;
                float[] fArr5 = (float[]) lVar.f31j;
                if (sArr.length != 0) {
                    int min = Math.min(sArr.length / intValue, IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED);
                    float f13 = 0.0f;
                    for (int i13 = 0; i13 < min; i13++) {
                        float f14 = sArr[i13 * intValue] / 32768.0f;
                        fArr5[i13] = f14;
                        f13 += Math.abs(f14);
                    }
                    l7.a aVar = (l7.a) lVar.f30i;
                    int[] iArr = (int[]) aVar.f6277g;
                    if (iArr != null && (fArr = (float[]) aVar.f6275e) != null && (fArr2 = (float[]) aVar.f6276f) != null && (fArr3 = (float[][]) aVar.h) != null) {
                        float[] fArr6 = (float[]) aVar.f6273c;
                        int i14 = aVar.f6271a;
                        if (fArr6 != null) {
                            for (int i15 = 0; i15 < i14; i15++) {
                                int i16 = iArr[i15];
                                fArr[i15] = i16 < aVar.f6272b ? fArr5[i16] * fArr6[i16] : 0.0f;
                            }
                        } else {
                            for (int i17 = 0; i17 < i14; i17++) {
                                int i18 = iArr[i17];
                                fArr[i17] = i18 < aVar.f6272b ? fArr5[i18] : 0.0f;
                            }
                        }
                        char c10 = 0;
                        Arrays.fill(fArr2, 0, fArr2.length, 0.0f);
                        int i19 = 2;
                        int i20 = 0;
                        while (true) {
                            int i21 = aVar.f6271a;
                            if (i19 <= i21) {
                                float[] fArr7 = fArr3[i20];
                                float f15 = fArr7[c10];
                                float f16 = fArr7[1];
                                int i22 = i19 >> 1;
                                int i23 = 0;
                                float f17 = 1.0f;
                                float f18 = 0.0f;
                                while (i23 < i22) {
                                    e8.c e02 = com.bumptech.glide.d.e0(i23, aVar.f6271a);
                                    e02.getClass();
                                    boolean z8 = i19 > 0;
                                    Integer valueOf = Integer.valueOf(i19);
                                    if (!z8) {
                                        throw new IllegalArgumentException("Step must be positive, was: " + valueOf + '.');
                                    }
                                    int i24 = e02.f3158i;
                                    float f19 = f16;
                                    int i25 = e02.f3159j;
                                    if (e02.f3160k > 0) {
                                        i9 = i19;
                                        i10 = i9;
                                    } else {
                                        i9 = -i19;
                                        i10 = i19;
                                    }
                                    int i26 = new e8.a(i24, i25, i9).f3159j;
                                    if ((i9 > 0 && i24 <= i26) || (i9 < 0 && i26 <= i24)) {
                                        while (true) {
                                            int i27 = i24 + i22;
                                            float f20 = fArr[i27];
                                            float f21 = fArr2[i27];
                                            float f22 = (f17 * f20) - (f18 * f21);
                                            float f23 = (f20 * f18) + (f21 * f17);
                                            fArr[i27] = fArr[i24] - f22;
                                            fArr2[i27] = fArr2[i24] - f23;
                                            fArr[i24] = fArr[i24] + f22;
                                            fArr2[i24] = fArr2[i24] + f23;
                                            if (i24 != i26) {
                                                i24 += i9;
                                            }
                                        }
                                    }
                                    float f24 = (f17 * f15) - (f18 * f19);
                                    f18 = (f17 * f19) + (f18 * f15);
                                    i23++;
                                    f16 = f19;
                                    f17 = f24;
                                    i19 = i10;
                                }
                                i19 <<= 1;
                                i20++;
                                c10 = 0;
                            } else {
                                float[] fArr8 = (float[]) aVar.f6274d;
                                if (fArr8 != null) {
                                    int i28 = i21 / 2;
                                    for (int i29 = 0; i29 < i28; i29++) {
                                        float f25 = fArr8[i29];
                                        float f26 = fArr[i29];
                                        float f27 = fArr2[i29];
                                        fArr4[i29] = f25 * ((float) Math.sqrt((f27 * f27) + (f26 * f26)));
                                    }
                                } else {
                                    int i30 = i21 / 2;
                                    for (int i31 = 0; i31 < i30; i31++) {
                                        float f28 = fArr[i31];
                                        float f29 = fArr2[i31];
                                        fArr4[i31] = (float) Math.sqrt((f29 * f29) + (f28 * f28));
                                    }
                                }
                            }
                        }
                    }
                    d3 d3Var = (d3) lVar.f33l;
                    if (d3Var != null) {
                        d3Var.c(fArr4, fArr5, 0);
                    }
                    if (System.currentTimeMillis() % 2000 < 50) {
                        Log.i("AudioProcessor", "Direct PCM Capture - Amplitude: " + (f13 / IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED));
                    }
                }
                return n7.g.f7490c;
            default:
                float[] fArr9 = (float[]) obj;
                float[] fArr10 = (float[]) obj2;
                ((Integer) serializable).getClass();
                int i32 = PlayerActivity.X;
                fArr9.getClass();
                fArr10.getClass();
                c7.e eVar = playerActivity.E;
                if (eVar == null) {
                    b8.i.d("binding");
                    throw null;
                }
                if (eVar.f1714t.getVisibility() == 0) {
                    l7.g gVar = playerActivity.S;
                    if (gVar == null) {
                        b8.i.d("visualizerRenderer");
                        throw null;
                    }
                    List list = gVar.Q;
                    float f30 = gVar.f6318g0;
                    if (fArr9.length == 0) {
                        j5 = 50;
                    } else {
                        int length = fArr9.length;
                        j5 = 50;
                        gVar.f6328q = length > 8 ? ((float) o7.h.G0(o7.f.c0(fArr9, new e8.c(0, 8, 1)))) * f30 * 1.5f : 0.0f;
                        float G0 = length > 15 ? ((float) o7.h.G0(o7.f.c0(fArr9, new e8.c(0, 15, 1)))) * f30 : 0.0f;
                        gVar.f6329r = G0;
                        gVar.E = G0;
                        if (length > 90) {
                            c9 = 2;
                            f9 = ((float) o7.h.G0(o7.f.c0(fArr9, new e8.c(13, 90, 1)))) * f30 * 0.8f;
                        } else {
                            c9 = 2;
                            f9 = 0.0f;
                        }
                        gVar.F = f9;
                        if (length > 255) {
                            f10 = 0.6f;
                            f11 = ((float) o7.h.G0(o7.f.c0(fArr9, new e8.c(91, 255, 1)))) * f30 * 0.6f;
                        } else {
                            f10 = 0.6f;
                            f11 = 0.0f;
                        }
                        gVar.G = f11;
                        gVar.f6328q = Math.min(1.0f, gVar.f6328q);
                        gVar.f6329r = Math.min(1.0f, gVar.f6329r);
                        gVar.F = Math.min(1.0f, gVar.F);
                        gVar.G = Math.min(1.0f, gVar.G);
                        float f31 = gVar.f6328q;
                        gVar.f6314c0 = ((0.98f - ((gVar.F * 0.02f) + (0.04f * f31))) * 0.08f) + (gVar.f6314c0 * 0.92f);
                        gVar.f6317f0 = ((gVar.f6329r > 0.8f ? 0.5f : 0.0f) * 0.1f) + (gVar.f6317f0 * 0.9f);
                        float f32 = gVar.f6330s;
                        if (f31 <= 2.1f * f32 || f31 <= 0.7f) {
                            f12 = 0.08f;
                            if (f31 > f32 * 1.8f && f31 > 0.5f) {
                                gVar.f6331t = 1.0f;
                                gVar.K = (gVar.K + 0.03f) % 1.0f;
                                gVar.f6316e0 += new Random().nextBoolean() ? 2.4f : -2.4f;
                            }
                        } else {
                            f12 = 0.08f;
                            if (System.currentTimeMillis() - gVar.A > 2000) {
                                gVar.f();
                            }
                        }
                        float f33 = gVar.f6330s * 0.95f;
                        float f34 = gVar.f6328q;
                        gVar.f6330s = (f34 * 0.05f) + f33;
                        gVar.f6331t *= 0.85f;
                        float f35 = gVar.f6315d0 * 0.95f;
                        float f36 = gVar.f6316e0;
                        float f37 = (0.05f * f36) + f35;
                        gVar.f6315d0 = f37;
                        gVar.H += f37;
                        gVar.f6316e0 = f36 * 0.94f;
                        float f38 = gVar.f6329r;
                        float f39 = gVar.D;
                        if (f38 > 1.5f * f39 && f38 > 0.4f) {
                            gVar.C = 1.0f;
                        }
                        gVar.D = (f38 * f12) + (f39 * 0.92f);
                        float f40 = f34 * 0.01f;
                        gVar.K = (gVar.K + ((gVar.f6332u == l7.c.f6285j ? 0.003f : 0.001f) + f40)) % 1.0f;
                        float f41 = f40 + 0.002f + gVar.P;
                        gVar.P = f41;
                        if (f41 >= 1.0f) {
                            gVar.P = 0.0f;
                            int i33 = gVar.O;
                            gVar.N = i33;
                            gVar.O = (i33 + 1) % list.size();
                        }
                        float[] fArr11 = (float[]) list.get(gVar.N);
                        float[] fArr12 = (float[]) list.get(gVar.O);
                        float f42 = fArr11[0];
                        float f43 = gVar.P;
                        float f44 = 1.0f - f43;
                        float f45 = (fArr12[0] * f43) + (f42 * f44);
                        float f46 = (fArr12[1] * f43) + (fArr11[1] * f44);
                        float f47 = (fArr12[c9] * f43) + (fArr11[c9] * f44);
                        float f48 = (fArr12[3] * f43) + (fArr11[3] * f44);
                        float f49 = (fArr12[4] * f43) + (fArr11[4] * f44);
                        float f50 = (fArr12[5] * f43) + (f44 * fArr11[5]);
                        float f51 = ((gVar.E * 0.3f) + 0.2f) * f47;
                        float f52 = ((gVar.G * 0.4f) + f10) * f50;
                        float[] d9 = l7.g.d(f45, f46, f51);
                        float[] fArr13 = gVar.L;
                        fArr13[0] = d9[0];
                        fArr13[1] = d9[1];
                        fArr13[c9] = d9[c9];
                        float[] d10 = l7.g.d(f48, f49, f52);
                        float[] fArr14 = gVar.M;
                        fArr14[0] = d10[0];
                        fArr14[1] = d10[1];
                        fArr14[c9] = d10[c9];
                    }
                    if (fArr10.length != 0) {
                        int length2 = fArr10.length;
                        for (int i34 = 0; i34 < length2; i34++) {
                            gVar.f6327p[i34] = fArr10[i34] * 1.2f;
                        }
                        if (System.currentTimeMillis() % 2000 < j5) {
                            Log.i("VisualizerRenderer", "Renderer Status: Bass=" + gVar.E + ", Mid=" + gVar.F + ", Treb=" + gVar.G + ", Flash=" + gVar.C);
                        }
                    }
                }
                return n7.g.f7490c;
        }
    }
}
