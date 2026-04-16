package c2;

import android.opengl.GLES20;
import android.util.Log;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h {

    /* renamed from: i, reason: collision with root package name */
    public static final float[] f1562i = {1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: j, reason: collision with root package name */
    public static final float[] f1563j = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: k, reason: collision with root package name */
    public static final float[] f1564k = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    public int f1565a;

    /* renamed from: b, reason: collision with root package name */
    public f f1566b;

    /* renamed from: c, reason: collision with root package name */
    public g1.e f1567c;

    /* renamed from: d, reason: collision with root package name */
    public int f1568d;

    /* renamed from: e, reason: collision with root package name */
    public int f1569e;

    /* renamed from: f, reason: collision with root package name */
    public int f1570f;

    /* renamed from: g, reason: collision with root package name */
    public int f1571g;
    public int h;

    public static boolean b(g gVar) {
        e eVar = gVar.f1558a;
        e eVar2 = gVar.f1559b;
        f[] fVarArr = eVar.f1553a;
        if (fVarArr.length == 1 && fVarArr[0].f1554a == 0) {
            f[] fVarArr2 = eVar2.f1553a;
            if (fVarArr2.length == 1 && fVarArr2[0].f1554a == 0) {
                return true;
            }
        }
        return false;
    }

    public final void a() {
        try {
            g1.e eVar = new g1.e("uniform mat4 uMvpMatrix;\nuniform mat3 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec2 aTexCoords;\nvarying vec2 vTexCoords;\n// Standard transformation.\nvoid main() {\n  gl_Position = uMvpMatrix * aPosition;\n  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;\n}\n", "// This is required since the texture data is GL_TEXTURE_EXTERNAL_OES.\n#extension GL_OES_EGL_image_external : require\nprecision mediump float;\n// Standard texture rendering shader.\nuniform samplerExternalOES uTexture;\nvarying vec2 vTexCoords;\nvoid main() {\n  gl_FragColor = texture2D(uTexture, vTexCoords);\n}\n");
            this.f1567c = eVar;
            this.f1568d = GLES20.glGetUniformLocation(eVar.f3668i, "uMvpMatrix");
            this.f1569e = GLES20.glGetUniformLocation(this.f1567c.f3668i, "uTexMatrix");
            this.f1570f = this.f1567c.b("aPosition");
            this.f1571g = this.f1567c.b("aTexCoords");
            this.h = GLES20.glGetUniformLocation(this.f1567c.f3668i, "uTexture");
        } catch (g1.g e9) {
            Log.e("ProjectionRenderer", "Failed to initialize the program", e9);
        }
    }
}
