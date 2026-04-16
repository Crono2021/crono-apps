package c2;

import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import b2.t;
import d1.s;
import g1.p;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j implements t, a {

    /* renamed from: q, reason: collision with root package name */
    public int f1581q;

    /* renamed from: r, reason: collision with root package name */
    public SurfaceTexture f1582r;

    /* renamed from: u, reason: collision with root package name */
    public byte[] f1585u;

    /* renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f1573i = new AtomicBoolean();

    /* renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f1574j = new AtomicBoolean(true);

    /* renamed from: k, reason: collision with root package name */
    public final h f1575k = new h();

    /* renamed from: l, reason: collision with root package name */
    public final b2.b f1576l = new b2.b();

    /* renamed from: m, reason: collision with root package name */
    public final f f1577m = new f();

    /* renamed from: n, reason: collision with root package name */
    public final f f1578n = new f();

    /* renamed from: o, reason: collision with root package name */
    public final float[] f1579o = new float[16];

    /* renamed from: p, reason: collision with root package name */
    public final float[] f1580p = new float[16];

    /* renamed from: s, reason: collision with root package name */
    public volatile int f1583s = 0;

    /* renamed from: t, reason: collision with root package name */
    public int f1584t = -1;

    public final void a(float[] fArr) {
        Object d9;
        GLES20.glClear(16384);
        try {
            g1.a.g();
        } catch (g1.g e9) {
            g1.a.q("SceneRenderer", "Failed to draw a frame", e9);
        }
        if (this.f1573i.compareAndSet(true, false)) {
            SurfaceTexture surfaceTexture = this.f1582r;
            surfaceTexture.getClass();
            surfaceTexture.updateTexImage();
            try {
                g1.a.g();
            } catch (g1.g e10) {
                g1.a.q("SceneRenderer", "Failed to draw a frame", e10);
            }
            if (this.f1574j.compareAndSet(true, false)) {
                Matrix.setIdentityM(this.f1579o, 0);
            }
            long timestamp = this.f1582r.getTimestamp();
            f fVar = this.f1577m;
            synchronized (fVar) {
                d9 = fVar.d(timestamp, false);
            }
            Long l4 = (Long) d9;
            if (l4 != null) {
                b2.b bVar = this.f1576l;
                float[] fArr2 = this.f1579o;
                float[] fArr3 = (float[]) ((f) bVar.f1140d).e(l4.longValue());
                if (fArr3 != null) {
                    float[] fArr4 = (float[]) bVar.f1139c;
                    float f9 = fArr3[0];
                    float f10 = -fArr3[1];
                    float f11 = -fArr3[2];
                    float length = Matrix.length(f9, f10, f11);
                    if (length != 0.0f) {
                        Matrix.setRotateM(fArr4, 0, (float) Math.toDegrees(length), f9 / length, f10 / length, f11 / length);
                    } else {
                        Matrix.setIdentityM(fArr4, 0);
                    }
                    if (!bVar.f1137a) {
                        b2.b.e((float[]) bVar.f1138b, (float[]) bVar.f1139c);
                        bVar.f1137a = true;
                    }
                    Matrix.multiplyMM(fArr2, 0, (float[]) bVar.f1138b, 0, (float[]) bVar.f1139c, 0);
                }
            }
            g gVar = (g) this.f1578n.e(timestamp);
            if (gVar != null) {
                h hVar = this.f1575k;
                hVar.getClass();
                if (h.b(gVar)) {
                    hVar.f1565a = gVar.f1560c;
                    hVar.f1566b = new f(gVar.f1558a.f1553a[0]);
                    if (!gVar.f1561d) {
                        new f(gVar.f1559b.f1553a[0]);
                    }
                }
            }
        }
        Matrix.multiplyMM(this.f1580p, 0, fArr, 0, this.f1579o, 0);
        h hVar2 = this.f1575k;
        int i9 = this.f1581q;
        float[] fArr5 = this.f1580p;
        f fVar2 = hVar2.f1566b;
        if (fVar2 == null) {
            return;
        }
        int i10 = hVar2.f1565a;
        GLES20.glUniformMatrix3fv(hVar2.f1569e, 1, false, i10 == 1 ? h.f1563j : i10 == 2 ? h.f1564k : h.f1562i, 0);
        GLES20.glUniformMatrix4fv(hVar2.f1568d, 1, false, fArr5, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i9);
        GLES20.glUniform1i(hVar2.h, 0);
        try {
            g1.a.g();
        } catch (g1.g e11) {
            Log.e("ProjectionRenderer", "Failed to bind uniforms", e11);
        }
        GLES20.glVertexAttribPointer(hVar2.f1570f, 3, 5126, false, 12, (Buffer) fVar2.f1556c);
        try {
            g1.a.g();
        } catch (g1.g e12) {
            Log.e("ProjectionRenderer", "Failed to load position data", e12);
        }
        GLES20.glVertexAttribPointer(hVar2.f1571g, 2, 5126, false, 8, (Buffer) fVar2.f1557d);
        try {
            g1.a.g();
        } catch (g1.g e13) {
            Log.e("ProjectionRenderer", "Failed to load texture data", e13);
        }
        GLES20.glDrawArrays(fVar2.f1555b, 0, fVar2.f1554a);
        try {
            g1.a.g();
        } catch (g1.g e14) {
            Log.e("ProjectionRenderer", "Failed to render", e14);
        }
    }

    public final SurfaceTexture b() {
        try {
            GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
            g1.a.g();
            this.f1575k.a();
            g1.a.g();
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            g1.a.g();
            int i9 = iArr[0];
            g1.a.c(36197, i9);
            this.f1581q = i9;
        } catch (g1.g e9) {
            g1.a.q("SceneRenderer", "Failed to initialize the renderer", e9);
        }
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f1581q);
        this.f1582r = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: c2.i
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                j.this.f1573i.set(true);
            }
        });
        return this.f1582r;
    }

    @Override // c2.a
    public final void c(long j5, float[] fArr) {
        ((f) this.f1576l.f1140d).a(j5, fArr);
    }

    @Override // b2.t
    public final void d(long j5, long j9, s sVar, MediaFormat mediaFormat) {
        ArrayList arrayList;
        int g9;
        this.f1577m.a(j9, Long.valueOf(j5));
        byte[] bArr = sVar.f2564w;
        int i9 = sVar.f2565x;
        byte[] bArr2 = this.f1585u;
        int i10 = this.f1584t;
        this.f1585u = bArr;
        if (i9 == -1) {
            i9 = this.f1583s;
        }
        this.f1584t = i9;
        if (i10 == i9 && Arrays.equals(bArr2, this.f1585u)) {
            return;
        }
        byte[] bArr3 = this.f1585u;
        g gVar = null;
        if (bArr3 != null) {
            int i11 = this.f1584t;
            p pVar = new p(bArr3);
            try {
                pVar.G(4);
                g9 = pVar.g();
                pVar.F(0);
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
            if (g9 == 1886547818) {
                pVar.G(8);
                int i12 = pVar.f3700b;
                int i13 = pVar.f3701c;
                while (i12 < i13) {
                    int g10 = pVar.g() + i12;
                    if (g10 <= i12 || g10 > i13) {
                        break;
                    }
                    int g11 = pVar.g();
                    if (g11 != 2037673328 && g11 != 1836279920) {
                        pVar.F(g10);
                        i12 = g10;
                    }
                    pVar.E(g10);
                    arrayList = android.support.v4.media.session.b.k0(pVar);
                    break;
                }
                arrayList = null;
            } else {
                arrayList = android.support.v4.media.session.b.k0(pVar);
            }
            if (arrayList != null) {
                int size = arrayList.size();
                if (size == 1) {
                    e eVar = (e) arrayList.get(0);
                    gVar = new g(eVar, eVar, i11);
                } else if (size == 2) {
                    gVar = new g((e) arrayList.get(0), (e) arrayList.get(1), i11);
                }
            }
        }
        if (gVar == null || !h.b(gVar)) {
            int i14 = this.f1584t;
            float radians = (float) Math.toRadians(180.0f);
            float radians2 = (float) Math.toRadians(360.0f);
            float f9 = radians / 36;
            float f10 = radians2 / 72;
            float[] fArr = new float[15984];
            float[] fArr2 = new float[10656];
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            for (int i18 = 36; i15 < i18; i18 = 36) {
                float f11 = radians / 2.0f;
                float f12 = (i15 * f9) - f11;
                int i19 = i15 + 1;
                float f13 = (i19 * f9) - f11;
                int i20 = 0;
                while (i20 < 73) {
                    int i21 = i19;
                    float f14 = f13;
                    float f15 = radians;
                    int i22 = i16;
                    int i23 = i17;
                    int i24 = 0;
                    while (i24 < 2) {
                        float f16 = i24 == 0 ? f12 : f14;
                        float f17 = radians2;
                        float f18 = i20 * f10;
                        float f19 = f12;
                        float f20 = f9;
                        double d9 = 50.0f;
                        double d10 = (f18 + 3.1415927f) - (f17 / 2.0f);
                        double d11 = f16;
                        fArr[i22] = -((float) (Math.cos(d11) * Math.sin(d10) * d9));
                        fArr[i22 + 1] = (float) (Math.sin(d11) * d9);
                        int i25 = i22 + 3;
                        fArr[i22 + 2] = (float) (Math.cos(d11) * Math.cos(d10) * d9);
                        fArr2[i23] = f18 / f17;
                        int i26 = i23 + 2;
                        fArr2[i23 + 1] = ((i15 + i24) * f20) / f15;
                        if ((i20 != 0 || i24 != 0) && (i20 != 72 || i24 != 1)) {
                            i22 = i25;
                            i23 = i26;
                            i24++;
                            radians2 = f17;
                            f12 = f19;
                            f9 = f20;
                        }
                        System.arraycopy(fArr, i22, fArr, i25, 3);
                        i22 += 6;
                        System.arraycopy(fArr2, i23, fArr2, i26, 2);
                        i23 += 4;
                        i24++;
                        radians2 = f17;
                        f12 = f19;
                        f9 = f20;
                    }
                    i20++;
                    i16 = i22;
                    i17 = i23;
                    i19 = i21;
                    f13 = f14;
                    radians = f15;
                    radians2 = radians2;
                    f9 = f9;
                }
                i15 = i19;
            }
            e eVar2 = new e(new f(0, fArr, fArr2, 1));
            gVar = new g(eVar2, eVar2, i14);
        }
        this.f1578n.a(j9, gVar);
    }

    @Override // c2.a
    public final void e() {
        this.f1577m.b();
        b2.b bVar = this.f1576l;
        ((f) bVar.f1140d).b();
        bVar.f1137a = false;
        this.f1574j.set(true);
    }
}
