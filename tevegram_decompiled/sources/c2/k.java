package c2;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import b2.f0;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k implements GLSurfaceView.Renderer, c {

    /* renamed from: i, reason: collision with root package name */
    public final j f1586i;

    /* renamed from: l, reason: collision with root package name */
    public final float[] f1589l;

    /* renamed from: m, reason: collision with root package name */
    public final float[] f1590m;

    /* renamed from: n, reason: collision with root package name */
    public final float[] f1591n;

    /* renamed from: o, reason: collision with root package name */
    public float f1592o;

    /* renamed from: p, reason: collision with root package name */
    public float f1593p;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ l f1596s;

    /* renamed from: j, reason: collision with root package name */
    public final float[] f1587j = new float[16];

    /* renamed from: k, reason: collision with root package name */
    public final float[] f1588k = new float[16];

    /* renamed from: q, reason: collision with root package name */
    public final float[] f1594q = new float[16];

    /* renamed from: r, reason: collision with root package name */
    public final float[] f1595r = new float[16];

    public k(l lVar, j jVar) {
        this.f1596s = lVar;
        float[] fArr = new float[16];
        this.f1589l = fArr;
        float[] fArr2 = new float[16];
        this.f1590m = fArr2;
        float[] fArr3 = new float[16];
        this.f1591n = fArr3;
        this.f1586i = jVar;
        Matrix.setIdentityM(fArr, 0);
        Matrix.setIdentityM(fArr2, 0);
        Matrix.setIdentityM(fArr3, 0);
        this.f1593p = 3.1415927f;
    }

    @Override // c2.c
    public final synchronized void a(float[] fArr, float f9) {
        float[] fArr2 = this.f1589l;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        float f10 = -f9;
        this.f1593p = f10;
        Matrix.setRotateM(this.f1590m, 0, -this.f1592o, (float) Math.cos(f10), (float) Math.sin(this.f1593p), 0.0f);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 gl10) {
        synchronized (this) {
            Matrix.multiplyMM(this.f1595r, 0, this.f1589l, 0, this.f1591n, 0);
            Matrix.multiplyMM(this.f1594q, 0, this.f1590m, 0, this.f1595r, 0);
        }
        Matrix.multiplyMM(this.f1588k, 0, this.f1587j, 0, this.f1594q, 0);
        this.f1586i.a(this.f1588k);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 gl10, int i9, int i10) {
        GLES20.glViewport(0, 0, i9, i10);
        float f9 = i9 / i10;
        Matrix.perspectiveM(this.f1587j, 0, f9 > 1.0f ? (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / f9)) * 2.0d) : 90.0f, f9, 0.1f, 100.0f);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        l lVar = this.f1596s;
        lVar.f1602m.post(new f0(lVar, 3, this.f1586i.b()));
    }
}
