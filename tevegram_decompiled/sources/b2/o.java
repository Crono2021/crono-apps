package b2;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.Locale;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class o extends HandlerThread implements Handler.Callback {

    /* renamed from: i, reason: collision with root package name */
    public g1.d f1238i;

    /* renamed from: j, reason: collision with root package name */
    public Handler f1239j;

    /* renamed from: k, reason: collision with root package name */
    public Error f1240k;

    /* renamed from: l, reason: collision with root package name */
    public RuntimeException f1241l;

    /* renamed from: m, reason: collision with root package name */
    public p f1242m;

    public final void a(int i9) {
        EGLSurface eglCreatePbufferSurface;
        this.f1238i.getClass();
        g1.d dVar = this.f1238i;
        int[] iArr = dVar.f3663j;
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        g1.a.h("eglGetDisplay failed", eglGetDisplay != null);
        int[] iArr2 = new int[2];
        g1.a.h("eglInitialize failed", EGL14.eglInitialize(eglGetDisplay, iArr2, 0, iArr2, 1));
        dVar.f3664k = eglGetDisplay;
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr3 = new int[1];
        boolean eglChooseConfig = EGL14.eglChooseConfig(eglGetDisplay, g1.d.f3661o, 0, eGLConfigArr, 0, 1, iArr3, 0);
        boolean z8 = eglChooseConfig && iArr3[0] > 0 && eGLConfigArr[0] != null;
        Object[] objArr = {Boolean.valueOf(eglChooseConfig), Integer.valueOf(iArr3[0]), eGLConfigArr[0]};
        int i10 = g1.w.f3713a;
        g1.a.h(String.format(Locale.US, "eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", objArr), z8);
        EGLConfig eGLConfig = eGLConfigArr[0];
        EGLContext eglCreateContext = EGL14.eglCreateContext(dVar.f3664k, eGLConfig, EGL14.EGL_NO_CONTEXT, i9 == 0 ? new int[]{12440, 2, 12344} : new int[]{12440, 2, 12992, 1, 12344}, 0);
        g1.a.h("eglCreateContext failed", eglCreateContext != null);
        dVar.f3665l = eglCreateContext;
        EGLDisplay eGLDisplay = dVar.f3664k;
        if (i9 == 1) {
            eglCreatePbufferSurface = EGL14.EGL_NO_SURFACE;
        } else {
            eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, i9 == 2 ? new int[]{12375, 1, 12374, 1, 12992, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
            g1.a.h("eglCreatePbufferSurface failed", eglCreatePbufferSurface != null);
        }
        g1.a.h("eglMakeCurrent failed", EGL14.eglMakeCurrent(eGLDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext));
        dVar.f3666m = eglCreatePbufferSurface;
        GLES20.glGenTextures(1, iArr, 0);
        g1.a.g();
        SurfaceTexture surfaceTexture = new SurfaceTexture(iArr[0]);
        dVar.f3667n = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(dVar);
        SurfaceTexture surfaceTexture2 = this.f1238i.f3667n;
        surfaceTexture2.getClass();
        this.f1242m = new p(this, surfaceTexture2, i9 != 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b() {
        this.f1238i.getClass();
        g1.d dVar = this.f1238i;
        dVar.f3662i.removeCallbacks(dVar);
        try {
            SurfaceTexture surfaceTexture = dVar.f3667n;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                GLES20.glDeleteTextures(1, dVar.f3663j, 0);
            }
        } finally {
            EGLDisplay eGLDisplay = dVar.f3664k;
            if (eGLDisplay != null && !eGLDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
                EGLDisplay eGLDisplay2 = dVar.f3664k;
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            }
            EGLSurface eGLSurface2 = dVar.f3666m;
            if (eGLSurface2 != null && !eGLSurface2.equals(EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(dVar.f3664k, dVar.f3666m);
            }
            EGLContext eGLContext = dVar.f3665l;
            if (eGLContext != null) {
                EGL14.eglDestroyContext(dVar.f3664k, eGLContext);
            }
            if (g1.w.f3713a >= 19) {
                EGL14.eglReleaseThread();
            }
            EGLDisplay eGLDisplay3 = dVar.f3664k;
            if (eGLDisplay3 != null && !eGLDisplay3.equals(EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglTerminate(dVar.f3664k);
            }
            dVar.f3664k = null;
            dVar.f3665l = null;
            dVar.f3666m = null;
            dVar.f3667n = null;
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i9 = message.what;
        try {
            if (i9 == 1) {
                try {
                    a(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                    return true;
                } catch (g1.g e9) {
                    g1.a.q("PlaceholderSurface", "Failed to initialize placeholder surface", e9);
                    this.f1241l = new IllegalStateException(e9);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e10) {
                    g1.a.q("PlaceholderSurface", "Failed to initialize placeholder surface", e10);
                    this.f1240k = e10;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e11) {
                    g1.a.q("PlaceholderSurface", "Failed to initialize placeholder surface", e11);
                    this.f1241l = e11;
                    synchronized (this) {
                        notify();
                    }
                }
            } else if (i9 == 2) {
                try {
                    b();
                    return true;
                } catch (Throwable th) {
                    try {
                        g1.a.q("PlaceholderSurface", "Failed to release placeholder surface", th);
                        return true;
                    } finally {
                        quit();
                    }
                }
            }
            return true;
        } catch (Throwable th2) {
            synchronized (this) {
                notify();
                throw th2;
            }
        }
    }
}
