package b2;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class q implements GLSurfaceView.Renderer {

    /* renamed from: p, reason: collision with root package name */
    public static final String[] f1248p = {"y_tex", "u_tex", "v_tex"};

    /* renamed from: q, reason: collision with root package name */
    public static final FloatBuffer f1249q = g1.a.n(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});

    /* renamed from: i, reason: collision with root package name */
    public final r f1250i;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f1251j = new int[3];

    /* renamed from: k, reason: collision with root package name */
    public final int[] f1252k = new int[3];

    /* renamed from: l, reason: collision with root package name */
    public final int[] f1253l = new int[3];

    /* renamed from: m, reason: collision with root package name */
    public final int[] f1254m = new int[3];

    /* renamed from: n, reason: collision with root package name */
    public final AtomicReference f1255n = new AtomicReference();

    /* renamed from: o, reason: collision with root package name */
    public g1.e f1256o;

    public q(r rVar) {
        this.f1250i = rVar;
        for (int i9 = 0; i9 < 3; i9++) {
            int[] iArr = this.f1253l;
            this.f1254m[i9] = -1;
            iArr[i9] = -1;
        }
    }

    public final void a() {
        int[] iArr = this.f1251j;
        try {
            GLES20.glGenTextures(3, iArr, 0);
            for (int i9 = 0; i9 < 3; i9++) {
                g1.e eVar = this.f1256o;
                GLES20.glUniform1i(GLES20.glGetUniformLocation(eVar.f3668i, f1248p[i9]), i9);
                GLES20.glActiveTexture(33984 + i9);
                g1.a.c(3553, iArr[i9]);
            }
            g1.a.g();
        } catch (g1.g e9) {
            Log.e("VideoDecoderGLSV", "Failed to set up the textures", e9);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 gl10) {
        if (this.f1255n.getAndSet(null) == null) {
            return;
        }
        androidx.fragment.app.a.c();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 gl10, int i9, int i10) {
        GLES20.glViewport(0, 0, i9, i10);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        int[] iArr = this.f1252k;
        try {
            g1.e eVar = new g1.e("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
            this.f1256o = eVar;
            GLES20.glVertexAttribPointer(eVar.b("in_pos"), 2, 5126, false, 0, (Buffer) f1249q);
            iArr[0] = this.f1256o.b("in_tc_y");
            iArr[1] = this.f1256o.b("in_tc_u");
            iArr[2] = this.f1256o.b("in_tc_v");
            GLES20.glGetUniformLocation(this.f1256o.f3668i, "mColorConversion");
            g1.a.g();
            a();
            g1.a.g();
        } catch (g1.g e9) {
            Log.e("VideoDecoderGLSV", "Failed to set up the textures and program", e9);
        }
    }
}
