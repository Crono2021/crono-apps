package l7;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.util.Log;
import androidx.fragment.app.r;
import com.network.tvgramplayer.ui.PlayerActivity;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.List;
import java.util.Random;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import o7.h;
import o7.i;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g implements GLSurfaceView.Renderer {
    public long A;
    public float C;
    public float D;
    public float E;
    public float F;
    public float G;
    public float H;
    public float K;
    public int N;
    public float P;
    public int R;
    public int S;
    public int V;
    public int W;
    public FloatBuffer Y;
    public FloatBuffer Z;

    /* renamed from: d0, reason: collision with root package name */
    public float f6315d0;

    /* renamed from: e0, reason: collision with root package name */
    public float f6316e0;

    /* renamed from: f0, reason: collision with root package name */
    public float f6317f0;

    /* renamed from: h0, reason: collision with root package name */
    public FloatBuffer f6319h0;

    /* renamed from: i, reason: collision with root package name */
    public final PlayerActivity f6320i;
    public FloatBuffer i0;

    /* renamed from: j, reason: collision with root package name */
    public int f6321j;

    /* renamed from: k, reason: collision with root package name */
    public int f6322k;

    /* renamed from: l, reason: collision with root package name */
    public int f6323l;

    /* renamed from: m, reason: collision with root package name */
    public long f6324m;

    /* renamed from: n, reason: collision with root package name */
    public int f6325n;

    /* renamed from: q, reason: collision with root package name */
    public float f6328q;

    /* renamed from: r, reason: collision with root package name */
    public float f6329r;

    /* renamed from: s, reason: collision with root package name */
    public float f6330s;

    /* renamed from: t, reason: collision with root package name */
    public float f6331t;

    /* renamed from: w, reason: collision with root package name */
    public d f6334w;

    /* renamed from: y, reason: collision with root package name */
    public d f6336y;

    /* renamed from: o, reason: collision with root package name */
    public final float[] f6326o = new float[256];

    /* renamed from: p, reason: collision with root package name */
    public final float[] f6327p = new float[IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED];

    /* renamed from: u, reason: collision with root package name */
    public c f6332u = c.f6284i;

    /* renamed from: v, reason: collision with root package name */
    public d f6333v = d.f6287i;

    /* renamed from: x, reason: collision with root package name */
    public float f6335x = 1.0f;

    /* renamed from: z, reason: collision with root package name */
    public e f6337z = e.ZOOM_SWIRL;
    public final long B = 10000;
    public final long I = System.currentTimeMillis();
    public float J = 1.0f;
    public final float[] L = {0.0f, 0.0f, 0.0f};
    public final float[] M = {1.0f, 1.0f, 1.0f};
    public int O = 1;
    public final List Q = i.D0(new float[]{0.8333333f, 0.8f, 0.9f, 0.5f, 0.9f, 1.0f}, new float[]{0.041666668f, 0.9f, 0.8f, 0.125f, 0.8f, 1.0f}, new float[]{0.6666667f, 0.7f, 0.6f, 0.7777778f, 0.6f, 0.9f}, new float[]{0.30555555f, 0.8f, 0.5f, 0.3888889f, 0.7f, 1.0f}, new float[]{0.11111111f, 0.7f, 0.4f, 0.16666667f, 0.6f, 0.9f});
    public final int[] T = new int[4];
    public final int[] U = new int[4];
    public final int X = IjkMediaMeta.FF_PROFILE_H264_INTRA;

    /* renamed from: a0, reason: collision with root package name */
    public final float[] f6312a0 = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: b0, reason: collision with root package name */
    public final float[] f6313b0 = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};

    /* renamed from: c0, reason: collision with root package name */
    public float f6314c0 = 1.0f;

    /* renamed from: g0, reason: collision with root package name */
    public final float f6318g0 = 2.5f;

    public g(PlayerActivity playerActivity) {
        this.f6320i = playerActivity;
    }

    public static int a(int i9, int i10) {
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, i9);
        GLES20.glAttachShader(glCreateProgram, i10);
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateProgram;
        }
        Log.e("VisualizerRenderer", "Error linking program: " + GLES20.glGetProgramInfoLog(glCreateProgram));
        GLES20.glDeleteProgram(glCreateProgram);
        return 0;
    }

    public static float[] d(float f9, float f10, float f11) {
        Float valueOf = Float.valueOf(0.0f);
        float f12 = f10 * f11;
        float abs = (1 - Math.abs(((6.0f * f9) % 2.0f) - 1.0f)) * f12;
        float f13 = f11 - f12;
        n7.f fVar = f9 < 0.16666667f ? new n7.f(Float.valueOf(f12), Float.valueOf(abs), valueOf) : f9 < 0.33333334f ? new n7.f(Float.valueOf(abs), Float.valueOf(f12), valueOf) : f9 < 0.5f ? new n7.f(valueOf, Float.valueOf(f12), Float.valueOf(abs)) : f9 < 0.6666667f ? new n7.f(valueOf, Float.valueOf(abs), Float.valueOf(f12)) : f9 < 0.8333333f ? new n7.f(Float.valueOf(abs), valueOf, Float.valueOf(f12)) : new n7.f(Float.valueOf(f12), valueOf, Float.valueOf(abs));
        return new float[]{((Number) fVar.f7486i).floatValue() + f13, ((Number) fVar.f7487j).floatValue() + f13, fVar.f7488k.floatValue() + f13, 1.0f};
    }

    public final void b(int i9, float f9) {
        GLES20.glUseProgram(this.f6323l);
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.f6323l, "aPosition");
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.f6323l, "aTextureCoord");
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f6323l, "uTexture");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.f6323l, "uResolution");
        int glGetUniformLocation3 = GLES20.glGetUniformLocation(this.f6323l, "uDirection");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        FloatBuffer floatBuffer = this.Y;
        if (floatBuffer == null) {
            b8.i.d("vertexBuffer");
            throw null;
        }
        GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 8, (Buffer) floatBuffer);
        GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
        FloatBuffer floatBuffer2 = this.Z;
        if (floatBuffer2 == null) {
            b8.i.d("texCoordBuffer");
            throw null;
        }
        GLES20.glVertexAttribPointer(glGetAttribLocation2, 2, 5126, false, 8, (Buffer) floatBuffer2);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i9);
        GLES20.glUniform1i(glGetUniformLocation, 0);
        GLES20.glUniform2f(glGetUniformLocation2, 512.0f, 512.0f);
        GLES20.glUniform1f(glGetUniformLocation3, f9);
        GLES20.glDrawArrays(5, 0, 4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000b, code lost:
    
        if (r0.capacity() < r2) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(int r2, int r3) {
        /*
            r1 = this;
            java.nio.FloatBuffer r0 = r1.f6319h0
            if (r0 == 0) goto Ld
            r0.getClass()
            int r0 = r0.capacity()
            if (r0 >= r2) goto L21
        Ld:
            int r2 = r2 * 4
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocateDirect(r2)
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteBuffer r2 = r2.order(r0)
            java.nio.FloatBuffer r2 = r2.asFloatBuffer()
            r1.f6319h0 = r2
        L21:
            java.nio.FloatBuffer r2 = r1.i0
            if (r2 == 0) goto L30
            r2.getClass()
            int r2 = r2.capacity()
            if (r2 >= r3) goto L2f
            goto L30
        L2f:
            return
        L30:
            int r3 = r3 * 4
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocateDirect(r3)
            java.nio.ByteOrder r3 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteBuffer r2 = r2.order(r3)
            java.nio.FloatBuffer r2 = r2.asFloatBuffer()
            r1.i0 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l7.g.c(int, int):void");
    }

    public final int e(int i9, int i10) {
        InputStream openRawResource = this.f6320i.getResources().openRawResource(i10);
        openRawResource.getClass();
        String U = com.bumptech.glide.d.U(new BufferedReader(new InputStreamReader(openRawResource, h8.a.f4218a), 8192));
        int glCreateShader = GLES20.glCreateShader(i9);
        GLES20.glShaderSource(glCreateShader, U);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        Log.e("VisualizerRenderer", "Error compiling shader: " + GLES20.glGetShaderInfoLog(glCreateShader));
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }

    public final void f() {
        List d02;
        List d03;
        int ordinal = this.f6332u.ordinal();
        d dVar = d.f6294p;
        d dVar2 = d.f6297s;
        d dVar3 = d.f6296r;
        d dVar4 = d.f6295q;
        if (ordinal == 0) {
            d02 = o7.f.d0(d.values());
        } else if (ordinal != 1) {
            d dVar5 = d.f6289k;
            d dVar6 = d.f6290l;
            if (ordinal == 2) {
                d02 = i.D0(dVar5, d.f6293o, d.f6291m, dVar6);
            } else if (ordinal == 3) {
                d02 = i.D0(dVar3, dVar2, dVar4, d.f6292n);
            } else {
                if (ordinal != 4) {
                    throw new r();
                }
                d02 = i.D0(dVar4, dVar6, dVar5);
            }
        } else {
            d02 = i.D0(dVar, d.f6287i, d.f6288j);
        }
        int ordinal2 = this.f6332u.ordinal();
        if (ordinal2 == 0) {
            d03 = o7.f.d0(e.values());
        } else if (ordinal2 == 1) {
            d03 = i.D0(e.MIRROR, e.ZOOM_OUT, e.WAVES);
        } else if (ordinal2 == 2) {
            d03 = i.D0(e.KALEIDOSCOPE, e.SPIN_PINCH);
        } else if (ordinal2 == 3) {
            d03 = i.D0(e.MODERN_MILK, e.ZOOM_SWIRL, e.TUNNEL_3D);
        } else {
            if (ordinal2 != 4) {
                throw new r();
            }
            d03 = i.D0(e.ORGANIC, e.FRACTAL_FIRE);
        }
        this.f6334w = this.f6333v;
        c8.a aVar = c8.e.f1727i;
        this.f6333v = (d) h.L0(d02);
        this.f6337z = (e) h.L0(d03);
        this.f6335x = 0.0f;
        if (System.currentTimeMillis() % 3 == 0) {
            int ordinal3 = this.f6333v.ordinal();
            if (ordinal3 != 9 && ordinal3 != 10) {
                dVar = (d) h.L0(i.D0(dVar3, dVar2, dVar4));
            }
            this.f6336y = dVar;
        } else {
            this.f6336y = null;
        }
        this.A = System.currentTimeMillis();
        this.f6333v.name();
        this.f6337z.name();
        System.currentTimeMillis();
        Log.i("VisualizerRenderer", "Mode changed to: " + this.f6333v + " in Group " + this.f6332u);
    }

    public final void g(int i9, int i10, int i11, float[] fArr, float[] fArr2, int i12, float f9) {
        c(fArr.length, fArr2.length);
        FloatBuffer floatBuffer = this.f6319h0;
        floatBuffer.getClass();
        floatBuffer.clear();
        floatBuffer.put(fArr);
        floatBuffer.position(0);
        FloatBuffer floatBuffer2 = this.i0;
        floatBuffer2.getClass();
        floatBuffer2.clear();
        floatBuffer2.put(fArr2);
        floatBuffer2.position(0);
        GLES20.glUseProgram(i9);
        int glGetUniformLocation = GLES20.glGetUniformLocation(i9, "uMatrix");
        float[] fArr3 = new float[16];
        Matrix.setIdentityM(fArr3, 0);
        Matrix.rotateM(fArr3, 0, f9 * 45.0f, 1.0f, 1.0f, 0.5f);
        Matrix.scaleM(fArr3, 0, 1.0f / this.J, 1.0f, 1.0f);
        GLES20.glUniformMatrix4fv(glGetUniformLocation, 1, false, fArr3, 0);
        GLES20.glEnableVertexAttribArray(i10);
        GLES20.glVertexAttribPointer(i10, 3, 5126, false, 0, (Buffer) this.f6319h0);
        GLES20.glEnableVertexAttribArray(i11);
        GLES20.glVertexAttribPointer(i11, 4, 5126, false, 0, (Buffer) this.i0);
        GLES20.glLineWidth(4.0f);
        GLES20.glDrawArrays(i12, 0, fArr.length / 3);
        GLES20.glDisableVertexAttribArray(i10);
        GLES20.glDisableVertexAttribArray(i11);
    }

    public final void h(int i9, int i10, float[] fArr, float[] fArr2, int i11) {
        c(fArr.length, fArr2.length);
        FloatBuffer floatBuffer = this.f6319h0;
        floatBuffer.getClass();
        floatBuffer.clear();
        floatBuffer.put(fArr);
        floatBuffer.position(0);
        FloatBuffer floatBuffer2 = this.i0;
        floatBuffer2.getClass();
        floatBuffer2.clear();
        floatBuffer2.put(fArr2);
        floatBuffer2.position(0);
        GLES20.glEnableVertexAttribArray(i9);
        GLES20.glVertexAttribPointer(i9, 2, 5126, false, 0, (Buffer) floatBuffer);
        GLES20.glEnableVertexAttribArray(i10);
        GLES20.glVertexAttribPointer(i10, 4, 5126, false, 0, (Buffer) floatBuffer2);
        GLES20.glDrawArrays(i11, 0, fArr.length / 2);
    }

    public final void i(d dVar, int i9, int i10, float f9, float f10) {
        float[] d9;
        int i11 = 16;
        int i12 = 256;
        float f11 = 0.8f;
        int i13 = 3;
        float f12 = 1.0f;
        switch (dVar.ordinal()) {
            case 7:
                float[] fArr = new float[1024];
                float[] fArr2 = new float[IjkMediaMeta.FF_PROFILE_H264_INTRA];
                System.currentTimeMillis();
                for (int i14 = 0; i14 < 256; i14++) {
                    float f13 = i14 / 256;
                    float f14 = (f13 * 2.0f) - 1.0f;
                    float f15 = this.f6326o[i14] * 1.5f;
                    int i15 = i14 * 4;
                    fArr[i15] = f14;
                    fArr[i15 + 1] = -0.5f;
                    fArr[i15 + 2] = f14;
                    fArr[i15 + 3] = f15 - 0.5f;
                    float[] d10 = d((this.K + f13) % 1.0f, 0.8f, 1.0f);
                    for (int i16 = 0; i16 < 2; i16++) {
                        int i17 = (i16 * 4) + (i14 * 8);
                        fArr2[i17] = d10[0];
                        fArr2[i17 + 1] = d10[1];
                        fArr2[i17 + 2] = d10[2];
                        fArr2[i17 + 3] = f10;
                    }
                }
                GLES20.glLineWidth(2.0f);
                h(i9, i10, fArr, fArr2, 1);
                break;
            case 8:
                float[] fArr3 = new float[1024];
                float[] fArr4 = new float[IjkMediaMeta.FF_PROFILE_H264_INTRA];
                int i18 = 0;
                int i19 = 0;
                int i20 = 0;
                while (true) {
                    if (i18 >= 16) {
                        c(1024, IjkMediaMeta.FF_PROFILE_H264_INTRA);
                        FloatBuffer floatBuffer = this.f6319h0;
                        floatBuffer.getClass();
                        floatBuffer.clear();
                        floatBuffer.put(fArr3);
                        floatBuffer.position(0);
                        GLES20.glVertexAttribPointer(i9, 2, 5126, false, 0, (Buffer) floatBuffer);
                        FloatBuffer floatBuffer2 = this.i0;
                        floatBuffer2.getClass();
                        floatBuffer2.clear();
                        floatBuffer2.put(fArr4);
                        floatBuffer2.position(0);
                        GLES20.glVertexAttribPointer(i10, 4, 5126, false, 0, (Buffer) floatBuffer2);
                        GLES20.glLineWidth(3.0f);
                        GLES20.glDrawArrays(1, 0, IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED);
                        break;
                    } else {
                        int i21 = 0;
                        for (int i22 = 16; i21 < i22; i22 = 16) {
                            float f16 = i22;
                            float f17 = ((i21 / f16) * 2.0f) - 1.0f;
                            float f18 = ((i18 / f16) * 2.0f) - 1.0f;
                            double d11 = f9;
                            float cos = ((float) (Math.cos((f18 * 2.0d) + d11) + Math.sin((f17 * 2.0d) + d11))) * 3.14f;
                            float f19 = (this.E * 0.1f) + 0.05f;
                            fArr3[i19] = f17 / this.J;
                            fArr3[i19 + 1] = f18;
                            int i23 = i19 + 3;
                            double d12 = cos;
                            int i24 = i18;
                            fArr3[i19 + 2] = ((((float) Math.cos(d12)) * f19) + f17) / this.J;
                            i19 += 4;
                            fArr3[i23] = (((float) Math.sin(d12)) * f19) + f18;
                            float[] d13 = d((((i21 + i24) / 32) + this.K) % 1.0f, 0.7f, 0.6f);
                            for (int i25 = 0; i25 < 2; i25++) {
                                fArr4[i20] = d13[0];
                                fArr4[i20 + 1] = d13[1];
                                int i26 = i20 + 3;
                                fArr4[i20 + 2] = d13[2];
                                i20 += 4;
                                fArr4[i26] = f10;
                            }
                            i21++;
                            i18 = i24;
                        }
                        i18++;
                    }
                }
            case 9:
                int i27 = this.f6322k;
                float[] fArr5 = new float[768];
                float[] fArr6 = new float[1024];
                float f20 = (this.E * 0.4f) + 0.5f;
                int i28 = 0;
                int i29 = 0;
                int i30 = 0;
                while (i28 < i11) {
                    float f21 = i11;
                    float f22 = i28 / f21;
                    float f23 = f22 * 3.1415927f;
                    int i31 = i30;
                    int i32 = 0;
                    while (i32 < i11) {
                        float[] fArr7 = fArr5;
                        double d14 = f23;
                        int i33 = i27;
                        float f24 = f20;
                        double d15 = (i32 / f21) * 2.0f * 3.1415927f;
                        float sin = ((float) Math.sin(d14)) * f20 * ((float) Math.cos(d15));
                        float cos2 = f24 * ((float) Math.cos(d14));
                        float sin2 = ((float) Math.sin(d14)) * f24 * ((float) Math.sin(d15));
                        fArr7[i29] = sin;
                        int i34 = i29 + 2;
                        fArr7[i29 + 1] = cos2;
                        i29 += 3;
                        fArr7[i34] = sin2;
                        float[] d16 = d((this.K + f22) % 1.0f, 0.8f, 1.0f);
                        fArr6[i31] = d16[0];
                        fArr6[i31 + 1] = d16[1];
                        int i35 = i31 + 3;
                        fArr6[i31 + 2] = d16[2];
                        i31 += 4;
                        fArr6[i35] = f10;
                        i32++;
                        i27 = i33;
                        fArr5 = fArr7;
                        f20 = f24;
                        i11 = 16;
                    }
                    i28++;
                    i30 = i31;
                    i11 = 16;
                }
                g(i27, i9, i10, fArr5, fArr6, 0, f9);
                break;
            case 10:
                int i36 = this.f6322k;
                float f25 = (this.E * 0.5f) + 0.4f;
                float f26 = -f25;
                float[] fArr8 = {f26, f26, f26, f25, f26, f26, f25, f25, f26, f26, f25, f26, f26, f26, f25, f25, f26, f25, f25, f25, f25, f26, f25, f25};
                int[] iArr = {0, 1, 1, 2, 2, 3, 3, 0, 4, 5, 5, 6, 6, 7, 7, 4, 0, 4, 1, 5, 2, 6, 3, 7};
                float[] fArr9 = new float[72];
                float[] fArr10 = new float[96];
                for (int i37 = 0; i37 < 24; i37++) {
                    int i38 = i37 * 3;
                    int i39 = iArr[i37] * 3;
                    fArr9[i38] = fArr8[i39];
                    fArr9[i38 + 1] = fArr8[i39 + 1];
                    fArr9[i38 + 2] = fArr8[i39 + 2];
                    float[] d17 = d(((i37 / 24) + this.K) % 1.0f, 0.9f, 1.0f);
                    int i40 = i37 * 4;
                    fArr10[i40] = d17[0];
                    fArr10[i40 + 1] = d17[1];
                    fArr10[i40 + 2] = d17[2];
                    fArr10[i40 + 3] = f10;
                }
                g(i36, i9, i10, fArr9, fArr10, 1, f9);
                break;
            case 11:
                float f27 = 1.0f;
                int i41 = this.f6322k;
                float f28 = (this.F * 0.3f) + 0.3f;
                float f29 = -f28;
                float[] fArr11 = {f29, f29, f29, f28, f29, f29, f28, f28, f29, f29, f28, f29, f29, f29, f28, f28, f29, f28, f28, f28, f28, f29, f28, f28, 0.0f, 0.0f, 0.0f};
                int[] iArr2 = {0, 1, 1, 2, 2, 3, 3, 0, 4, 5, 5, 6, 6, 7, 7, 4, 0, 4, 1, 5, 2, 6, 3, 7, 8, 0, 8, 1, 8, 2, 8, 3, 8, 4, 8, 5, 8, 6, 8, 7};
                float[] fArr12 = new float[120];
                float[] fArr13 = new float[160];
                int i42 = 0;
                while (i42 < 40) {
                    int i43 = i42 * 3;
                    int i44 = iArr2[i42] * 3;
                    fArr12[i43] = fArr11[i44];
                    fArr12[i43 + 1] = fArr11[i44 + 1];
                    fArr12[i43 + 2] = fArr11[i44 + 2];
                    float[] d18 = d(((this.G * 0.1f) + ((i42 / 40) + this.K)) % f27, 0.9f, 1.0f);
                    int i45 = i42 * 4;
                    fArr13[i45] = d18[0];
                    fArr13[i45 + 1] = d18[1];
                    fArr13[i45 + 2] = d18[2];
                    fArr13[i45 + 3] = f10;
                    i42++;
                    f27 = 1.0f;
                }
                g(i41, i9, i10, fArr12, fArr13, 1, f9);
                break;
            default:
                float[] fArr14 = new float[IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED];
                float[] fArr15 = new float[1024];
                int i46 = 0;
                while (i46 < i12) {
                    float f30 = i46 / i12;
                    int i47 = i46 * 2;
                    float[] fArr16 = this.f6327p;
                    float f31 = fArr16[i47];
                    if (dVar == d.f6290l) {
                        d9 = new float[i13];
                        float[] fArr17 = this.M;
                        d9[0] = fArr17[0];
                        d9[1] = fArr17[1];
                        d9[2] = fArr17[2];
                    } else {
                        d9 = d((this.K + f30) % f12, f11, (this.G * 0.5f) + 0.5f);
                    }
                    int i48 = i46 * 4;
                    fArr15[i48] = d9[0];
                    fArr15[i48 + 1] = d9[1];
                    fArr15[i48 + 2] = d9[2];
                    fArr15[i48 + 3] = f10;
                    switch (dVar.ordinal()) {
                        case 0:
                            fArr14[i47] = (f30 * 2.0f) - 1.0f;
                            fArr14[i47 + 1] = f31 * 0.5f;
                            break;
                        case 1:
                            float f32 = (f31 * 0.2f) + 0.5f;
                            double d19 = (f30 * 3.1415927f * 2.0d) + f9;
                            fArr14[i47] = (((float) Math.cos(d19)) * f32) / this.J;
                            fArr14[i47 + 1] = ((float) Math.sin(d19)) * f32;
                            break;
                        case 2:
                            float f33 = (f30 * 3.1415927f * 64.0f) + f9;
                            double cos3 = f33 / ((((float) Math.cos(f9 * 0.5f)) * 32.0f) + 64.0f);
                            double d20 = f33;
                            float f34 = f31 * 0.1f;
                            fArr14[i47] = (((((float) Math.sin(d20)) * 0.05f) + (((float) Math.cos(cos3)) * 0.4f)) + f34) / this.J;
                            fArr14[i47 + 1] = (((float) Math.cos(d20)) * 0.05f) + (((float) Math.sin(cos3)) * 0.4f) + f34;
                            break;
                        case 3:
                            fArr14[i47] = (f30 * 2.0f) - 1.0f;
                            fArr14[i47 + 1] = f31 * 0.8f;
                            break;
                        case 4:
                            float f35 = fArr16[i46];
                            float f36 = fArr16[Math.min(i46 + 256, 511)];
                            fArr14[i47] = (f35 * 0.8f) / this.J;
                            fArr14[i47 + 1] = f36 * 0.8f;
                            break;
                        case 5:
                            float f37 = (f31 * 0.1f) + 0.4f;
                            double d21 = (f30 * 3.1415927f * 4.0d) + (i46 % 2 == 0 ? f9 : -f9);
                            fArr14[i47] = (((float) Math.cos(d21)) * f37) / this.J;
                            fArr14[i47 + 1] = ((float) Math.sin(d21)) * f37;
                            break;
                        case 6:
                            double d22 = f30 * 3.1415927f;
                            float sin3 = (f31 * 0.1f) + (((float) Math.sin(10.0d * d22)) * 0.2f) + 0.4f;
                            double d23 = (d22 * 2.0d) + f9;
                            fArr14[i47] = (((float) Math.cos(d23)) * sin3) / this.J;
                            fArr14[i47 + 1] = ((float) Math.sin(d23)) * sin3;
                            break;
                    }
                    i46++;
                    i12 = 256;
                    f11 = 0.8f;
                    f12 = 1.0f;
                    i13 = 3;
                }
                int i49 = f.f6311a[dVar.ordinal()] == 9 ? 0 : 3;
                GLES20.glLineWidth(dVar != d.f6293o ? 5.0f : 2.0f);
                h(i9, i10, fArr14, fArr15, i49);
                break;
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 gl10) {
        long j5;
        String str;
        int[] iArr;
        int[] iArr2;
        String str2;
        String str3;
        int i9;
        String str4;
        String str5;
        String str6;
        int i10;
        int i11 = (this.V + 1) % 2;
        int[] iArr3 = this.T;
        GLES20.glBindFramebuffer(36160, iArr3[i11]);
        int i12 = this.X;
        GLES20.glViewport(0, 0, i12, i12);
        int i13 = this.V;
        int[] iArr4 = this.U;
        int i14 = iArr4[i13];
        int i15 = this.f6321j;
        long j9 = this.I;
        if (i15 == 0) {
            j5 = j9;
            str = "aTextureCoord";
            i9 = i11;
            iArr = iArr3;
            str4 = "aPosition";
            iArr2 = iArr4;
            str2 = "vertexBuffer";
            str3 = "texCoordBuffer";
        } else {
            GLES20.glUseProgram(i15);
            int glGetAttribLocation = GLES20.glGetAttribLocation(this.f6321j, "aPosition");
            int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.f6321j, "aTextureCoord");
            int glGetUniformLocation = GLES20.glGetUniformLocation(this.f6321j, "uTime");
            int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.f6321j, "uBass");
            int glGetUniformLocation3 = GLES20.glGetUniformLocation(this.f6321j, "uMid");
            int glGetUniformLocation4 = GLES20.glGetUniformLocation(this.f6321j, "uTreb");
            j5 = j9;
            int glGetUniformLocation5 = GLES20.glGetUniformLocation(this.f6321j, "uFlash");
            int glGetUniformLocation6 = GLES20.glGetUniformLocation(this.f6321j, "uAspectRatio");
            str = "aTextureCoord";
            int glGetUniformLocation7 = GLES20.glGetUniformLocation(this.f6321j, "uSceneRotation");
            iArr = iArr3;
            int glGetUniformLocation8 = GLES20.glGetUniformLocation(this.f6321j, "uBackgroundRGB");
            iArr2 = iArr4;
            int glGetUniformLocation9 = GLES20.glGetUniformLocation(this.f6321j, "uTexture");
            str2 = "vertexBuffer";
            int glGetUniformLocation10 = GLES20.glGetUniformLocation(this.f6321j, "uNoise");
            str3 = "texCoordBuffer";
            int glGetUniformLocation11 = GLES20.glGetUniformLocation(this.f6321j, "uWarpMode");
            i9 = i11;
            int glGetUniformLocation12 = GLES20.glGetUniformLocation(this.f6321j, "uWarpIntensity");
            str4 = "aPosition";
            int glGetUniformLocation13 = GLES20.glGetUniformLocation(this.f6321j, "uZoom");
            int glGetUniformLocation14 = GLES20.glGetUniformLocation(this.f6321j, "uSlowMo");
            GLES20.glEnableVertexAttribArray(glGetAttribLocation);
            FloatBuffer floatBuffer = this.Y;
            if (floatBuffer == null) {
                b8.i.d(str2);
                throw null;
            }
            GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 8, (Buffer) floatBuffer);
            GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
            FloatBuffer floatBuffer2 = this.Z;
            if (floatBuffer2 == null) {
                b8.i.d(str3);
                throw null;
            }
            GLES20.glVertexAttribPointer(glGetAttribLocation2, 2, 5126, false, 8, (Buffer) floatBuffer2);
            GLES20.glUniform1f(glGetUniformLocation, (System.currentTimeMillis() - j5) / 1000.0f);
            GLES20.glUniform1f(glGetUniformLocation2, this.E);
            GLES20.glUniform1f(glGetUniformLocation3, this.F);
            GLES20.glUniform1f(glGetUniformLocation4, this.G);
            GLES20.glUniform1f(glGetUniformLocation5, this.C);
            GLES20.glUniform1f(glGetUniformLocation6, this.J);
            GLES20.glUniform1f(glGetUniformLocation7, this.H);
            float[] fArr = this.L;
            GLES20.glUniform3f(glGetUniformLocation8, fArr[0], fArr[1], fArr[2]);
            GLES20.glUniform1i(glGetUniformLocation11, this.f6337z.f6310i);
            GLES20.glUniform1f(glGetUniformLocation12, 1.0f);
            GLES20.glUniform1f(glGetUniformLocation13, this.f6314c0);
            GLES20.glUniform1f(glGetUniformLocation14, this.f6317f0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i14);
            GLES20.glUniform1i(glGetUniformLocation9, 0);
            GLES20.glActiveTexture(33986);
            GLES20.glBindTexture(3553, this.W);
            GLES20.glUniform1i(glGetUniformLocation10, 2);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(glGetAttribLocation);
            GLES20.glDisableVertexAttribArray(glGetAttribLocation2);
        }
        int i16 = this.f6322k;
        if (i16 == 0) {
            str6 = str;
            str5 = str4;
        } else {
            GLES20.glUseProgram(i16);
            str5 = str4;
            int glGetAttribLocation3 = GLES20.glGetAttribLocation(this.f6322k, str5);
            int glGetAttribLocation4 = GLES20.glGetAttribLocation(this.f6322k, "aColor");
            float currentTimeMillis = (System.currentTimeMillis() - j5) / 1000.0f;
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(770, 771);
            float f9 = this.f6335x;
            if (f9 < 1.0f) {
                float f10 = f9 + 0.015f;
                this.f6335x = f10;
                if (f10 >= 1.0f) {
                    this.f6335x = 1.0f;
                    this.f6334w = null;
                }
            }
            d dVar = this.f6334w;
            if (dVar != null) {
                str6 = str;
                i(dVar, glGetAttribLocation3, glGetAttribLocation4, currentTimeMillis, 1.0f - this.f6335x);
            } else {
                str6 = str;
            }
            i(this.f6333v, glGetAttribLocation3, glGetAttribLocation4, currentTimeMillis, this.f6335x);
            d dVar2 = this.f6336y;
            if (dVar2 != null) {
                i(dVar2, glGetAttribLocation3, glGetAttribLocation4, currentTimeMillis, this.f6335x * 0.4f);
            }
            GLES20.glDisable(3042);
            GLES20.glDisableVertexAttribArray(glGetAttribLocation3);
            GLES20.glDisableVertexAttribArray(glGetAttribLocation4);
        }
        int i17 = this.f6322k;
        if (i17 == 0) {
            i10 = 0;
        } else {
            GLES20.glUseProgram(i17);
            int glGetAttribLocation5 = GLES20.glGetAttribLocation(this.f6322k, str5);
            int glGetAttribLocation6 = GLES20.glGetAttribLocation(this.f6322k, "aColor");
            int glGetUniformLocation15 = GLES20.glGetUniformLocation(this.f6322k, "uMatrix");
            float[] fArr2 = new float[576];
            float[] fArr3 = new float[1152];
            float currentTimeMillis2 = (System.currentTimeMillis() - j5) / 1000.0f;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            while (true) {
                if (i18 >= 12) {
                    break;
                }
                int i21 = 0;
                for (int i22 = 12; i21 < i22; i22 = 12) {
                    float f11 = i22;
                    float f12 = ((i21 / f11) * 2.0f) - 1.0f;
                    float f13 = ((i18 / f11) * 2.0f) - 1.0f;
                    int i23 = glGetAttribLocation5;
                    fArr2[i19] = f12 / this.J;
                    fArr2[i19 + 1] = f13;
                    int i24 = glGetAttribLocation6;
                    double d9 = currentTimeMillis2;
                    float cos = ((float) (Math.cos((f13 * 1.2d) + d9) + Math.sin((f12 * 1.5d) + d9))) * 3.14f;
                    float f14 = (this.E * 0.05f) + 0.04f;
                    int i25 = i19 + 3;
                    double d10 = cos;
                    fArr2[i19 + 2] = ((((float) Math.cos(d10)) * f14) + f12) / this.J;
                    i19 += 4;
                    fArr2[i25] = (((float) Math.sin(d10)) * f14) + f13;
                    for (int i26 = 0; i26 < 2; i26++) {
                        float[] fArr4 = this.M;
                        fArr3[i20] = fArr4[0] * 0.7f;
                        fArr3[i20 + 1] = fArr4[1] * 0.7f;
                        int i27 = i20 + 3;
                        fArr3[i20 + 2] = fArr4[2] * 0.7f;
                        i20 += 4;
                        fArr3[i27] = 1.0f;
                    }
                    i21++;
                    glGetAttribLocation6 = i24;
                    glGetAttribLocation5 = i23;
                }
                i18++;
            }
            float[] fArr5 = new float[16];
            i10 = 0;
            Matrix.setIdentityM(fArr5, 0);
            GLES20.glUniformMatrix4fv(glGetUniformLocation15, 1, false, fArr5, 0);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(770, 1);
            h(glGetAttribLocation5, glGetAttribLocation6, fArr2, fArr3, 0);
            GLES20.glDisable(3042);
        }
        GLES20.glBindFramebuffer(36160, iArr[2]);
        GLES20.glViewport(i10, i10, IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED, IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED);
        int i28 = iArr2[i9];
        GLES20.glUseProgram(this.f6321j);
        int glGetAttribLocation7 = GLES20.glGetAttribLocation(this.f6321j, str5);
        int glGetAttribLocation8 = GLES20.glGetAttribLocation(this.f6321j, str6);
        GLES20.glEnableVertexAttribArray(glGetAttribLocation7);
        FloatBuffer floatBuffer3 = this.Y;
        if (floatBuffer3 == null) {
            b8.i.d(str2);
            throw null;
        }
        GLES20.glVertexAttribPointer(glGetAttribLocation7, 2, 5126, false, 8, (Buffer) floatBuffer3);
        GLES20.glEnableVertexAttribArray(glGetAttribLocation8);
        FloatBuffer floatBuffer4 = this.Z;
        if (floatBuffer4 == null) {
            b8.i.d(str3);
            throw null;
        }
        GLES20.glVertexAttribPointer(glGetAttribLocation8, 2, 5126, false, 8, (Buffer) floatBuffer4);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i28);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindFramebuffer(36160, iArr[3]);
        b(iArr2[2], 0.0f);
        GLES20.glBindFramebuffer(36160, iArr[2]);
        b(iArr2[3], 1.0f);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(0, 0, this.R, this.S);
        int i29 = iArr2[i9];
        int i30 = iArr2[2];
        GLES20.glUseProgram(this.f6325n);
        int glGetAttribLocation9 = GLES20.glGetAttribLocation(this.f6325n, str5);
        int glGetAttribLocation10 = GLES20.glGetAttribLocation(this.f6325n, str6);
        int glGetUniformLocation16 = GLES20.glGetUniformLocation(this.f6325n, "uScene");
        int glGetUniformLocation17 = GLES20.glGetUniformLocation(this.f6325n, "uBloom");
        int glGetUniformLocation18 = GLES20.glGetUniformLocation(this.f6325n, "uBloomIntensity");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation9);
        FloatBuffer floatBuffer5 = this.Y;
        if (floatBuffer5 == null) {
            b8.i.d(str2);
            throw null;
        }
        GLES20.glVertexAttribPointer(glGetAttribLocation9, 2, 5126, false, 8, (Buffer) floatBuffer5);
        GLES20.glEnableVertexAttribArray(glGetAttribLocation10);
        FloatBuffer floatBuffer6 = this.Z;
        if (floatBuffer6 == null) {
            b8.i.d(str3);
            throw null;
        }
        GLES20.glVertexAttribPointer(glGetAttribLocation10, 2, 5126, false, 8, (Buffer) floatBuffer6);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i29);
        GLES20.glUniform1i(glGetUniformLocation16, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, i30);
        GLES20.glUniform1i(glGetUniformLocation17, 1);
        GLES20.glUniform1f(glGetUniformLocation18, (this.f6331t * 3.5f) + 1.5f);
        GLES20.glDrawArrays(5, 0, 4);
        long currentTimeMillis3 = System.currentTimeMillis();
        if (currentTimeMillis3 - this.f6324m >= 1000) {
            this.f6324m = currentTimeMillis3;
        }
        if (System.currentTimeMillis() - this.A > this.B) {
            f();
        }
        float f15 = this.C * 0.9f;
        this.C = f15;
        if (f15 < 0.01f) {
            this.C = 0.0f;
        }
        this.V = i9;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 gl10, int i9, int i10) {
        int i11;
        GLES20.glViewport(0, 0, i9, i10);
        this.R = i9;
        this.S = i10;
        this.J = i9 / i10;
        int[] iArr = this.T;
        GLES20.glGenFramebuffers(4, iArr, 0);
        int[] iArr2 = this.U;
        GLES20.glGenTextures(4, iArr2, 0);
        int i12 = 0;
        while (true) {
            if (i12 >= 2) {
                break;
            }
            GLES20.glBindTexture(3553, iArr2[i12]);
            int i13 = this.X;
            GLES20.glTexImage2D(3553, 0, 6408, i13, i13, 0, 6408, 5121, null);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLES20.glBindFramebuffer(36160, iArr[i12]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, iArr2[i12], 0);
            GLES20.glClear(16384);
            i12++;
        }
        for (i11 = 2; i11 < 4; i11++) {
            GLES20.glBindTexture(3553, iArr2[i11]);
            GLES20.glTexImage2D(3553, 0, 6408, IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED, IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED, 0, 6408, 5121, null);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glBindFramebuffer(36160, iArr[i11]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, iArr2[i11], 0);
        }
        GLES20.glBindFramebuffer(36160, 0);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        int e9 = e(35633, 2131886085);
        this.f6321j = a(e9, e(35632, 2131886086));
        this.f6322k = a(e(35633, 2131886084), e(35632, 2131886083));
        this.f6323l = a(e9, e(35632, 2131886081));
        this.f6325n = a(e9, e(35632, 2131886080));
        float[] fArr = this.f6312a0;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        this.Y = asFloatBuffer;
        float[] fArr2 = this.f6313b0;
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(fArr2.length * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
        asFloatBuffer2.put(fArr2);
        asFloatBuffer2.position(0);
        this.Z = asFloatBuffer2;
        ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(4096);
        allocateDirect3.order(ByteOrder.nativeOrder());
        this.f6319h0 = allocateDirect3.asFloatBuffer();
        ByteBuffer allocateDirect4 = ByteBuffer.allocateDirect(262144);
        Random random = new Random();
        for (int i9 = 0; i9 < 65536; i9++) {
            allocateDirect4.put((byte) random.nextInt(256));
            allocateDirect4.put((byte) random.nextInt(256));
            allocateDirect4.put((byte) random.nextInt(256));
            allocateDirect4.put((byte) -1);
        }
        allocateDirect4.position(0);
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i10 = iArr[0];
        this.W = i10;
        GLES20.glBindTexture(3553, i10);
        GLES20.glTexImage2D(3553, 0, 6408, 256, 256, 0, 6408, 5121, allocateDirect4);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 10497);
        GLES20.glTexParameteri(3553, 10243, 10497);
    }
}
