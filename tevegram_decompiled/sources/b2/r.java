package b2;

import android.content.Context;
import android.opengl.GLSurfaceView;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class r extends GLSurfaceView implements s {

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f1257j = 0;

    /* renamed from: i, reason: collision with root package name */
    public final q f1258i;

    public r(Context context) {
        super(context, null);
        q qVar = new q(this);
        this.f1258i = qVar;
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setRenderer(qVar);
        setRenderMode(0);
    }

    public void setOutputBuffer(j1.j jVar) {
        q qVar = this.f1258i;
        if (qVar.f1255n.getAndSet(jVar) == null) {
            qVar.f1250i.requestRender();
        } else {
            androidx.fragment.app.a.c();
        }
    }

    @Deprecated
    public s getVideoDecoderOutputBufferRenderer() {
        return this;
    }
}
