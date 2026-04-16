package org.webrtc;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import org.webrtc.EglBase;
import org.webrtc.EglBase10;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
class EglBase10Impl implements EglBase10 {
    private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
    private static final String TAG = "EglBase10Impl";
    private final EGL10 egl;
    private EGLSurface eglBackgroundSurface;
    private EGLConfig eglConfig;
    private EGLContext eglContext;
    private EGLDisplay eglDisplay;
    private EGLSurface eglSurface;

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public static class Context implements EglBase10.Context {
        private final EGL10 egl;
        private final EGLContext eglContext;
        private final EGLConfig eglContextConfig;

        public Context(EGL10 egl10, EGLContext eGLContext, EGLConfig eGLConfig) {
            this.egl = egl10;
            this.eglContext = eGLContext;
            this.eglContextConfig = eGLConfig;
        }

        @Override // org.webrtc.EglBase.Context
        public long getNativeEglContext() {
            EGLContext eglGetCurrentContext = this.egl.eglGetCurrentContext();
            EGLDisplay eglGetCurrentDisplay = this.egl.eglGetCurrentDisplay();
            EGLSurface eglGetCurrentSurface = this.egl.eglGetCurrentSurface(12377);
            EGLSurface eglGetCurrentSurface2 = this.egl.eglGetCurrentSurface(12378);
            if (eglGetCurrentDisplay == EGL10.EGL_NO_DISPLAY) {
                eglGetCurrentDisplay = this.egl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            }
            EGLSurface eGLSurface = null;
            try {
                if (eglGetCurrentContext != this.eglContext) {
                    eGLSurface = this.egl.eglCreatePbufferSurface(eglGetCurrentDisplay, this.eglContextConfig, new int[]{12375, 1, 12374, 1, 12344});
                    if (!this.egl.eglMakeCurrent(eglGetCurrentDisplay, eGLSurface, eGLSurface, this.eglContext)) {
                        throw new RuntimeException("Failed to make temporary EGL surface active: " + this.egl.eglGetError());
                    }
                }
                long nativeGetCurrentNativeEGLContext = EglBase10Impl.nativeGetCurrentNativeEGLContext();
                if (eGLSurface != null) {
                    this.egl.eglMakeCurrent(eglGetCurrentDisplay, eglGetCurrentSurface, eglGetCurrentSurface2, eglGetCurrentContext);
                    this.egl.eglDestroySurface(eglGetCurrentDisplay, eGLSurface);
                }
                return nativeGetCurrentNativeEGLContext;
            } catch (Throwable th) {
                if (0 != 0) {
                    this.egl.eglMakeCurrent(eglGetCurrentDisplay, eglGetCurrentSurface, eglGetCurrentSurface2, eglGetCurrentContext);
                    this.egl.eglDestroySurface(eglGetCurrentDisplay, null);
                }
                throw th;
            }
        }

        @Override // org.webrtc.EglBase10.Context
        public EGLContext getRawContext() {
            return this.eglContext;
        }
    }

    public EglBase10Impl(EGLContext eGLContext, int[] iArr) {
        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
        this.eglSurface = eGLSurface;
        this.eglBackgroundSurface = eGLSurface;
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.egl = egl10;
        EGLDisplay eglDisplay = getEglDisplay();
        this.eglDisplay = eglDisplay;
        this.eglConfig = getEglConfig(egl10, eglDisplay, iArr);
        int b9 = c.b(iArr);
        Logging.d(TAG, "Using OpenGL ES version " + b9);
        this.eglContext = createEglContext(eGLContext, this.eglDisplay, this.eglConfig, b9);
    }

    private void checkIsNotReleased() {
        if (this.eglDisplay == EGL10.EGL_NO_DISPLAY || this.eglContext == EGL10.EGL_NO_CONTEXT || this.eglConfig == null) {
            m7.c.i("This object has been released");
        }
    }

    private EGLContext createEglContext(EGLContext eGLContext, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i9) {
        EGLContext eglCreateContext;
        if (eGLContext != null && eGLContext == EGL10.EGL_NO_CONTEXT) {
            m7.c.i("Invalid sharedContext");
            return null;
        }
        int[] iArr = {EGL_CONTEXT_CLIENT_VERSION, i9, 12344};
        if (eGLContext == null) {
            eGLContext = EGL10.EGL_NO_CONTEXT;
        }
        synchronized (EglBase.lock) {
            eglCreateContext = this.egl.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }
        if (eglCreateContext != EGL10.EGL_NO_CONTEXT) {
            return eglCreateContext;
        }
        m7.c.m(Integer.toHexString(this.egl.eglGetError()), "Failed to create EGL context: 0x");
        return null;
    }

    private void createSurfaceInternal(Object obj, boolean z8) {
        if (!(obj instanceof SurfaceHolder) && !(obj instanceof SurfaceTexture)) {
            m7.c.p("Input must be either a SurfaceHolder or SurfaceTexture");
            return;
        }
        checkIsNotReleased();
        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
        if (z8) {
            if (this.eglBackgroundSurface != eGLSurface) {
                m7.c.i("Already has an EGLSurface");
                return;
            }
            EGLSurface eglCreateWindowSurface = this.egl.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, obj, new int[]{12344});
            this.eglBackgroundSurface = eglCreateWindowSurface;
            if (eglCreateWindowSurface != eGLSurface) {
                return;
            }
            m7.c.m(Integer.toHexString(this.egl.eglGetError()), "Failed to create window surface: 0x");
            return;
        }
        if (this.eglSurface != eGLSurface) {
            m7.c.i("Already has an EGLSurface");
            return;
        }
        EGLSurface eglCreateWindowSurface2 = this.egl.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, obj, new int[]{12344});
        this.eglSurface = eglCreateWindowSurface2;
        if (eglCreateWindowSurface2 != eGLSurface) {
            return;
        }
        m7.c.m(Integer.toHexString(this.egl.eglGetError()), "Failed to create window surface: 0x");
    }

    private static EGLConfig getEglConfig(EGL10 egl10, EGLDisplay eGLDisplay, int[] iArr) {
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr2 = new int[1];
        if (!egl10.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, 1, iArr2)) {
            m7.c.m(Integer.toHexString(egl10.eglGetError()), "eglChooseConfig failed: 0x");
            return null;
        }
        if (iArr2[0] <= 0) {
            m7.c.i("Unable to find any matching EGL config");
            return null;
        }
        EGLConfig eGLConfig = eGLConfigArr[0];
        if (eGLConfig != null) {
            return eGLConfig;
        }
        m7.c.i("eglChooseConfig returned null");
        return null;
    }

    private EGLDisplay getEglDisplay() {
        EGLDisplay eglGetDisplay = this.egl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        EGL10 egl10 = this.egl;
        if (eglGetDisplay == EGL10.EGL_NO_DISPLAY) {
            m7.c.m(Integer.toHexString(egl10.eglGetError()), "Unable to get EGL10 display: 0x");
            return null;
        }
        if (egl10.eglInitialize(eglGetDisplay, new int[2])) {
            return eglGetDisplay;
        }
        m7.c.m(Integer.toHexString(this.egl.eglGetError()), "Unable to initialize EGL10: 0x");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native long nativeGetCurrentNativeEGLContext();

    @Override // org.webrtc.EglBase
    public void createBackgroundSurface(SurfaceTexture surfaceTexture) {
        createSurfaceInternal(surfaceTexture, true);
    }

    @Override // org.webrtc.EglBase
    public void createDummyPbufferSurface() {
        createPbufferSurface(1, 1);
    }

    @Override // org.webrtc.EglBase
    public void createPbufferSurface(int i9, int i10) {
        checkIsNotReleased();
        EGLSurface eGLSurface = this.eglSurface;
        EGLSurface eGLSurface2 = EGL10.EGL_NO_SURFACE;
        if (eGLSurface != eGLSurface2) {
            m7.c.i("Already has an EGLSurface");
            return;
        }
        EGLSurface eglCreatePbufferSurface = this.egl.eglCreatePbufferSurface(this.eglDisplay, this.eglConfig, new int[]{12375, i9, 12374, i10, 12344});
        this.eglSurface = eglCreatePbufferSurface;
        if (eglCreatePbufferSurface != eGLSurface2) {
            return;
        }
        StringBuilder q4 = androidx.activity.g.q("Failed to create pixel buffer surface with size ", i9, "x", i10, ": 0x");
        q4.append(Integer.toHexString(this.egl.eglGetError()));
        throw new RuntimeException(q4.toString());
    }

    @Override // org.webrtc.EglBase
    public void createSurface(Surface surface) {
        createSurfaceInternal(new FakeSurfaceHolder(this, surface), false);
    }

    @Override // org.webrtc.EglBase
    public void detachCurrent() {
        synchronized (EglBase.lock) {
            try {
                EGL10 egl10 = this.egl;
                EGLDisplay eGLDisplay = this.eglDisplay;
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                if (!egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT)) {
                    throw new RuntimeException("eglDetachCurrent failed: 0x" + Integer.toHexString(this.egl.eglGetError()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.webrtc.EglBase
    public EglBase.Context getEglBaseContext() {
        return new Context(this.egl, this.eglContext, this.eglConfig);
    }

    @Override // org.webrtc.EglBase
    public boolean hasBackgroundSurface() {
        return this.eglBackgroundSurface != EGL10.EGL_NO_SURFACE;
    }

    @Override // org.webrtc.EglBase
    public boolean hasSurface() {
        return this.eglSurface != EGL10.EGL_NO_SURFACE;
    }

    @Override // org.webrtc.EglBase
    public void makeBackgroundCurrent() {
        checkIsNotReleased();
        if (this.eglBackgroundSurface == EGL10.EGL_NO_SURFACE) {
            m7.c.i("No EGLSurface - can't make current");
            return;
        }
        synchronized (EglBase.lock) {
            try {
                EGL10 egl10 = this.egl;
                EGLDisplay eGLDisplay = this.eglDisplay;
                EGLSurface eGLSurface = this.eglBackgroundSurface;
                if (!egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.eglContext)) {
                    throw new RuntimeException("eglMakeCurrent failed: 0x" + Integer.toHexString(this.egl.eglGetError()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.webrtc.EglBase
    public void makeCurrent() {
        checkIsNotReleased();
        if (this.eglSurface == EGL10.EGL_NO_SURFACE) {
            m7.c.i("No EGLSurface - can't make current");
            return;
        }
        synchronized (EglBase.lock) {
            try {
                EGL10 egl10 = this.egl;
                EGLDisplay eGLDisplay = this.eglDisplay;
                EGLSurface eGLSurface = this.eglSurface;
                if (!egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.eglContext)) {
                    throw new RuntimeException("eglMakeCurrent failed: 0x" + Integer.toHexString(this.egl.eglGetError()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.webrtc.EglBase
    public void release() {
        checkIsNotReleased();
        releaseSurface(false);
        releaseSurface(true);
        detachCurrent();
        this.egl.eglDestroyContext(this.eglDisplay, this.eglContext);
        this.egl.eglTerminate(this.eglDisplay);
        this.eglContext = EGL10.EGL_NO_CONTEXT;
        this.eglDisplay = EGL10.EGL_NO_DISPLAY;
        this.eglConfig = null;
    }

    @Override // org.webrtc.EglBase
    public void releaseSurface(boolean z8) {
        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
        if (z8) {
            EGLSurface eGLSurface2 = this.eglBackgroundSurface;
            if (eGLSurface2 != eGLSurface) {
                this.egl.eglDestroySurface(this.eglDisplay, eGLSurface2);
                this.eglBackgroundSurface = eGLSurface;
                return;
            }
            return;
        }
        EGLSurface eGLSurface3 = this.eglSurface;
        if (eGLSurface3 != eGLSurface) {
            this.egl.eglDestroySurface(this.eglDisplay, eGLSurface3);
            this.eglSurface = eGLSurface;
        }
    }

    @Override // org.webrtc.EglBase
    public int surfaceHeight() {
        int[] iArr = new int[1];
        this.egl.eglQuerySurface(this.eglDisplay, this.eglSurface, 12374, iArr);
        return iArr[0];
    }

    @Override // org.webrtc.EglBase
    public int surfaceWidth() {
        int[] iArr = new int[1];
        this.egl.eglQuerySurface(this.eglDisplay, this.eglSurface, 12375, iArr);
        return iArr[0];
    }

    @Override // org.webrtc.EglBase
    public void swapBuffers(boolean z8) {
        EGLSurface eGLSurface = z8 ? this.eglBackgroundSurface : this.eglSurface;
        checkIsNotReleased();
        if (eGLSurface == EGL10.EGL_NO_SURFACE) {
            m7.c.i("No EGLSurface - can't swap buffers");
        } else {
            synchronized (EglBase.lock) {
                this.egl.eglSwapBuffers(this.eglDisplay, eGLSurface);
            }
        }
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public class FakeSurfaceHolder implements SurfaceHolder {
        private final Surface surface;

        public FakeSurfaceHolder(EglBase10Impl eglBase10Impl, Surface surface) {
            this.surface = surface;
        }

        @Override // android.view.SurfaceHolder
        public Surface getSurface() {
            return this.surface;
        }

        @Override // android.view.SurfaceHolder
        public Rect getSurfaceFrame() {
            return null;
        }

        @Override // android.view.SurfaceHolder
        public boolean isCreating() {
            return false;
        }

        @Override // android.view.SurfaceHolder
        public Canvas lockCanvas() {
            return null;
        }

        @Override // android.view.SurfaceHolder
        public Canvas lockCanvas(Rect rect) {
            return null;
        }

        @Override // android.view.SurfaceHolder
        public void setSizeFromLayout() {
        }

        @Override // android.view.SurfaceHolder
        public void addCallback(SurfaceHolder.Callback callback) {
        }

        @Override // android.view.SurfaceHolder
        public void removeCallback(SurfaceHolder.Callback callback) {
        }

        @Override // android.view.SurfaceHolder
        public void setFormat(int i9) {
        }

        @Override // android.view.SurfaceHolder
        public void setKeepScreenOn(boolean z8) {
        }

        @Override // android.view.SurfaceHolder
        @Deprecated
        public void setType(int i9) {
        }

        @Override // android.view.SurfaceHolder
        public void unlockCanvasAndPost(Canvas canvas) {
        }

        @Override // android.view.SurfaceHolder
        public void setFixedSize(int i9, int i10) {
        }
    }

    @Override // org.webrtc.EglBase
    public void createSurface(SurfaceTexture surfaceTexture) {
        createSurfaceInternal(surfaceTexture, false);
    }

    @Override // org.webrtc.EglBase
    public void swapBuffers(long j5, boolean z8) {
        swapBuffers(z8);
    }
}
