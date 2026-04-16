package g1;

import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.Handler;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d implements SurfaceTexture.OnFrameAvailableListener, Runnable {

    /* renamed from: o, reason: collision with root package name */
    public static final int[] f3661o = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344};

    /* renamed from: i, reason: collision with root package name */
    public final Handler f3662i;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f3663j = new int[1];

    /* renamed from: k, reason: collision with root package name */
    public EGLDisplay f3664k;

    /* renamed from: l, reason: collision with root package name */
    public EGLContext f3665l;

    /* renamed from: m, reason: collision with root package name */
    public EGLSurface f3666m;

    /* renamed from: n, reason: collision with root package name */
    public SurfaceTexture f3667n;

    public d(Handler handler) {
        this.f3662i = handler;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f3662i.post(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        SurfaceTexture surfaceTexture = this.f3667n;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.updateTexImage();
            } catch (RuntimeException unused) {
            }
        }
    }
}
