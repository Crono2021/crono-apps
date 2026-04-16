package org.webrtc;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public interface EglBase {
    public static final int[] CONFIG_PIXEL_BUFFER;
    public static final int[] CONFIG_PIXEL_RGBA_BUFFER;
    public static final int[] CONFIG_PLAIN;
    public static final int[] CONFIG_RECORDABLE;
    public static final int[] CONFIG_RGBA;
    public static final int EGL_OPENGL_ES2_BIT = 4;
    public static final int EGL_OPENGL_ES3_BIT = 64;
    public static final int EGL_RECORDABLE_ANDROID = 12610;
    public static final Object lock = new Object();

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public static class ConfigBuilder {
        private boolean hasAlphaChannel;
        private boolean isRecordable;
        private int openGlesVersion = 2;
        private boolean supportsPixelBuffer;

        public int[] createConfigAttributes() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(12324);
            arrayList.add(8);
            arrayList.add(12323);
            arrayList.add(8);
            arrayList.add(12322);
            arrayList.add(8);
            if (this.hasAlphaChannel) {
                arrayList.add(12321);
                arrayList.add(8);
            }
            int i9 = this.openGlesVersion;
            if (i9 == 2 || i9 == 3) {
                arrayList.add(12352);
                arrayList.add(Integer.valueOf(this.openGlesVersion == 3 ? 64 : 4));
            }
            if (this.supportsPixelBuffer) {
                arrayList.add(12339);
                arrayList.add(1);
            }
            if (this.isRecordable) {
                arrayList.add(Integer.valueOf(EglBase.EGL_RECORDABLE_ANDROID));
                arrayList.add(1);
            }
            arrayList.add(12344);
            int[] iArr = new int[arrayList.size()];
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                iArr[i10] = ((Integer) arrayList.get(i10)).intValue();
            }
            return iArr;
        }

        public ConfigBuilder setHasAlphaChannel(boolean z8) {
            this.hasAlphaChannel = z8;
            return this;
        }

        public ConfigBuilder setIsRecordable(boolean z8) {
            this.isRecordable = z8;
            return this;
        }

        public ConfigBuilder setOpenGlesVersion(int i9) {
            if (i9 >= 1 && i9 <= 3) {
                this.openGlesVersion = i9;
                return this;
            }
            throw new IllegalArgumentException("OpenGL ES version " + i9 + " not supported");
        }

        public ConfigBuilder setSupportsPixelBuffer(boolean z8) {
            this.supportsPixelBuffer = z8;
            return this;
        }
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public interface Context {
        public static final long NO_CONTEXT = 0;

        long getNativeEglContext();
    }

    static {
        int i9 = c.f8036a;
        CONFIG_PLAIN = new ConfigBuilder().createConfigAttributes();
        CONFIG_RGBA = new ConfigBuilder().setHasAlphaChannel(true).createConfigAttributes();
        CONFIG_PIXEL_BUFFER = new ConfigBuilder().setSupportsPixelBuffer(true).createConfigAttributes();
        CONFIG_PIXEL_RGBA_BUFFER = new ConfigBuilder().setHasAlphaChannel(true).setSupportsPixelBuffer(true).createConfigAttributes();
        CONFIG_RECORDABLE = new ConfigBuilder().setIsRecordable(true).createConfigAttributes();
    }

    void createBackgroundSurface(SurfaceTexture surfaceTexture);

    void createDummyPbufferSurface();

    void createPbufferSurface(int i9, int i10);

    void createSurface(SurfaceTexture surfaceTexture);

    void createSurface(Surface surface);

    void detachCurrent();

    Context getEglBaseContext();

    boolean hasBackgroundSurface();

    boolean hasSurface();

    void makeBackgroundCurrent();

    void makeCurrent();

    void release();

    void releaseSurface(boolean z8);

    int surfaceHeight();

    int surfaceWidth();

    void swapBuffers(long j5, boolean z8);

    void swapBuffers(boolean z8);
}
