package org.webrtc;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import i7.i2;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import org.telegram.messenger.FileLog;
import org.webrtc.EglBase;
import org.webrtc.GlGenericDrawer;
import org.webrtc.GlUtil;
import org.webrtc.RendererCommon;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class EglRenderer implements VideoSink {
    private static final long LOG_INTERVAL_SEC = 4;
    private static final String TAG = "EglRenderer";
    private final GlTextureFrameBuffer bitmapTextureFramebuffer;
    private final Matrix drawMatrix;
    private RendererCommon.GlDrawer drawer;
    private EglBase eglBase;
    private final EglSurfaceCreation eglSurfaceBackgroundCreationRunnable;
    private final EglSurfaceCreation eglSurfaceCreationRunnable;
    private volatile ErrorCallback errorCallback;
    public boolean firstFrameRendered;
    private final Object fpsReductionLock;
    private final VideoFrameDrawer frameDrawer;
    private final ArrayList<FrameListenerAndParams> frameListeners;
    private final Object frameLock;
    private int framesDropped;
    private int framesReceived;
    private int framesRendered;
    private final Object handlerLock;
    private float layoutAspectRatio;
    private final Object layoutLock;
    private long minRenderPeriodNs;
    private boolean mirrorHorizontally;
    private boolean mirrorVertically;
    protected final String name;
    private long nextFrameTimeNs;
    private VideoFrame pendingFrame;
    private long renderSwapBufferTimeNs;
    private Handler renderThreadHandler;
    private long renderTimeNs;
    private int rotation;
    private boolean usePresentationTimeStamp;

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public class EglSurfaceCreation implements Runnable {
        private final boolean background;
        private Object surface;

        public EglSurfaceCreation(boolean z8) {
            this.background = z8;
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x002b, code lost:
        
            if (r2.eglBase.hasSurface() == false) goto L18;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public synchronized void run() {
            /*
                r4 = this;
                java.lang.String r0 = "Invalid surface: "
                monitor-enter(r4)
                java.lang.Object r1 = r4.surface     // Catch: java.lang.Throwable -> L20
                if (r1 == 0) goto Laa
                org.webrtc.EglRenderer r1 = org.webrtc.EglRenderer.this     // Catch: java.lang.Throwable -> L20
                org.webrtc.EglBase r1 = org.webrtc.EglRenderer.j(r1)     // Catch: java.lang.Throwable -> L20
                if (r1 == 0) goto Laa
                boolean r1 = r4.background     // Catch: java.lang.Throwable -> L20
                org.webrtc.EglRenderer r2 = org.webrtc.EglRenderer.this
                if (r1 == 0) goto L23
                org.webrtc.EglBase r1 = org.webrtc.EglRenderer.j(r2)     // Catch: java.lang.Throwable -> L20
                boolean r1 = r1.hasBackgroundSurface()     // Catch: java.lang.Throwable -> L20
                if (r1 != 0) goto Laa
                goto L2d
            L20:
                r0 = move-exception
                goto Lac
            L23:
                org.webrtc.EglBase r1 = org.webrtc.EglRenderer.j(r2)     // Catch: java.lang.Throwable -> L20
                boolean r1 = r1.hasSurface()     // Catch: java.lang.Throwable -> L20
                if (r1 != 0) goto Laa
            L2d:
                java.lang.Object r1 = r4.surface     // Catch: java.lang.Throwable -> L20
                boolean r2 = r1 instanceof android.view.Surface     // Catch: java.lang.Throwable -> L20
                if (r2 == 0) goto L41
                org.webrtc.EglRenderer r0 = org.webrtc.EglRenderer.this     // Catch: java.lang.Throwable -> L20
                org.webrtc.EglBase r0 = org.webrtc.EglRenderer.j(r0)     // Catch: java.lang.Throwable -> L20
                java.lang.Object r1 = r4.surface     // Catch: java.lang.Throwable -> L20
                android.view.Surface r1 = (android.view.Surface) r1     // Catch: java.lang.Throwable -> L20
                r0.createSurface(r1)     // Catch: java.lang.Throwable -> L20
                goto L62
            L41:
                boolean r1 = r1 instanceof android.graphics.SurfaceTexture     // Catch: java.lang.Throwable -> L20
                if (r1 == 0) goto L96
                boolean r0 = r4.background     // Catch: java.lang.Throwable -> L20
                org.webrtc.EglRenderer r1 = org.webrtc.EglRenderer.this
                if (r0 == 0) goto L57
                org.webrtc.EglBase r0 = org.webrtc.EglRenderer.j(r1)     // Catch: java.lang.Throwable -> L20
                java.lang.Object r1 = r4.surface     // Catch: java.lang.Throwable -> L20
                android.graphics.SurfaceTexture r1 = (android.graphics.SurfaceTexture) r1     // Catch: java.lang.Throwable -> L20
                r0.createBackgroundSurface(r1)     // Catch: java.lang.Throwable -> L20
                goto L62
            L57:
                org.webrtc.EglBase r0 = org.webrtc.EglRenderer.j(r1)     // Catch: java.lang.Throwable -> L20
                java.lang.Object r1 = r4.surface     // Catch: java.lang.Throwable -> L20
                android.graphics.SurfaceTexture r1 = (android.graphics.SurfaceTexture) r1     // Catch: java.lang.Throwable -> L20
                r0.createSurface(r1)     // Catch: java.lang.Throwable -> L20
            L62:
                boolean r0 = r4.background     // Catch: java.lang.Throwable -> L20
                org.webrtc.EglRenderer r1 = org.webrtc.EglRenderer.this
                r2 = 1
                r3 = 3317(0xcf5, float:4.648E-42)
                if (r0 != 0) goto L76
                org.webrtc.EglBase r0 = org.webrtc.EglRenderer.j(r1)     // Catch: java.lang.Throwable -> L20
                r0.makeCurrent()     // Catch: java.lang.Throwable -> L20
                android.opengl.GLES20.glPixelStorei(r3, r2)     // Catch: java.lang.Throwable -> L20
                goto Laa
            L76:
                org.webrtc.EglBase r0 = org.webrtc.EglRenderer.j(r1)     // Catch: java.lang.Throwable -> L20
                r0.makeBackgroundCurrent()     // Catch: java.lang.Throwable -> L20
                android.opengl.GLES20.glPixelStorei(r3, r2)     // Catch: java.lang.Throwable -> L20
                org.webrtc.EglRenderer r0 = org.webrtc.EglRenderer.this     // Catch: java.lang.Throwable -> L20
                org.webrtc.EglBase r0 = org.webrtc.EglRenderer.j(r0)     // Catch: java.lang.Throwable -> L20
                boolean r0 = r0.hasSurface()     // Catch: java.lang.Throwable -> L20
                if (r0 == 0) goto Laa
                org.webrtc.EglRenderer r0 = org.webrtc.EglRenderer.this     // Catch: java.lang.Throwable -> L20
                org.webrtc.EglBase r0 = org.webrtc.EglRenderer.j(r0)     // Catch: java.lang.Throwable -> L20
                r0.makeCurrent()     // Catch: java.lang.Throwable -> L20
                goto Laa
            L96:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L20
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L20
                r2.<init>(r0)     // Catch: java.lang.Throwable -> L20
                java.lang.Object r0 = r4.surface     // Catch: java.lang.Throwable -> L20
                r2.append(r0)     // Catch: java.lang.Throwable -> L20
                java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L20
                r1.<init>(r0)     // Catch: java.lang.Throwable -> L20
                throw r1     // Catch: java.lang.Throwable -> L20
            Laa:
                monitor-exit(r4)
                return
            Lac:
                monitor-exit(r4)     // Catch: java.lang.Throwable -> L20
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.webrtc.EglRenderer.EglSurfaceCreation.run():void");
        }

        public synchronized void setSurface(Object obj) {
            this.surface = obj;
        }
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public interface ErrorCallback {
        void onGlOutOfMemory();
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public interface FrameListener {
        void onFrame(Bitmap bitmap);
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public static class FrameListenerAndParams {
        public final boolean applyFpsReduction;
        public final RendererCommon.GlDrawer drawer;
        public final FrameListener listener;
        public final float scale;

        public FrameListenerAndParams(FrameListener frameListener, float f9, RendererCommon.GlDrawer glDrawer, boolean z8) {
            this.listener = frameListener;
            this.scale = f9;
            this.drawer = glDrawer;
            this.applyFpsReduction = z8;
        }
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public static class HandlerWithExceptionCallback extends Handler {
        private final Runnable exceptionCallback;

        public HandlerWithExceptionCallback(Looper looper, Runnable runnable) {
            super(looper);
            this.exceptionCallback = runnable;
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            try {
                super.dispatchMessage(message);
            } catch (Exception e9) {
                Logging.e(EglRenderer.TAG, "Exception on EglRenderer thread", e9);
                this.exceptionCallback.run();
                throw e9;
            }
        }
    }

    public EglRenderer(String str, VideoFrameDrawer videoFrameDrawer) {
        this.handlerLock = new Object();
        this.frameListeners = new ArrayList<>();
        this.fpsReductionLock = new Object();
        this.drawMatrix = new Matrix();
        this.frameLock = new Object();
        this.layoutLock = new Object();
        this.bitmapTextureFramebuffer = new GlTextureFrameBuffer(6408);
        this.eglSurfaceCreationRunnable = new EglSurfaceCreation(false);
        this.eglSurfaceBackgroundCreationRunnable = new EglSurfaceCreation(true);
        this.name = str;
        this.frameDrawer = videoFrameDrawer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: clearSurfaceOnRenderThread, reason: merged with bridge method [inline-methods] */
    public void lambda$clearImage$6(float f9, float f10, float f11, float f12) {
        EglBase eglBase = this.eglBase;
        if (eglBase != null && eglBase.hasSurface()) {
            logD("clearSurface");
            GLES20.glClearColor(f9, f10, f11, f12);
            GLES20.glClear(16384);
            this.eglBase.swapBuffers(false);
        }
        EglBase eglBase2 = this.eglBase;
        if (eglBase2 == null || !eglBase2.hasBackgroundSurface()) {
            return;
        }
        this.eglBase.makeBackgroundCurrent();
        logD("clearSurface in background");
        GLES20.glClearColor(f9, f10, f11, f12);
        GLES20.glClear(16384);
        this.eglBase.swapBuffers(true);
        this.eglBase.makeCurrent();
    }

    private void createEglSurfaceInternal(Object obj, boolean z8) {
        if (!z8) {
            this.eglSurfaceCreationRunnable.setSurface(obj);
            postToRenderThread(this.eglSurfaceCreationRunnable);
            return;
        }
        this.eglSurfaceBackgroundCreationRunnable.setSurface(obj);
        synchronized (this.handlerLock) {
            try {
                Handler handler = this.renderThreadHandler;
                if (handler != null) {
                    handler.post(this.eglSurfaceBackgroundCreationRunnable);
                } else {
                    FileLog.d("can't create background surface. render thread is null");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addFrameListener$3(RendererCommon.GlDrawer glDrawer, FrameListener frameListener, float f9, boolean z8) {
        if (glDrawer == null) {
            glDrawer = this.drawer;
        }
        this.frameListeners.add(new FrameListenerAndParams(frameListener, f9, glDrawer, z8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getTexture$7(GlGenericDrawer.TextureCallback textureCallback) {
        this.frameDrawer.getRenderBufferBitmap(this.drawer, this.rotation, textureCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$init$0(EglBase.Context context, int[] iArr) {
        if (context != null) {
            logD("EglBase.create shared context");
            this.eglBase = c.a(context, iArr);
        } else {
            logD("EglBase10.create context");
            int i9 = c.f8036a;
            this.eglBase = new EglBase10Impl(null, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$1(CountDownLatch countDownLatch) {
        synchronized (EglBase.lock) {
            GLES20.glUseProgram(0);
        }
        RendererCommon.GlDrawer glDrawer = this.drawer;
        if (glDrawer != null) {
            glDrawer.release();
            this.drawer = null;
        }
        this.frameDrawer.release();
        this.bitmapTextureFramebuffer.release();
        if (this.eglBase != null) {
            logD("eglBase detach and release.");
            this.eglBase.detachCurrent();
            this.eglBase.release();
            this.eglBase = null;
        }
        this.frameListeners.clear();
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$2(Looper looper) {
        logD("Quitting render thread.");
        looper.quit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$releaseEglSurface$5(boolean z8, Runnable runnable) {
        EglBase eglBase = this.eglBase;
        if (eglBase != null) {
            eglBase.detachCurrent();
            this.eglBase.releaseSurface(z8);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeFrameListener$4(CountDownLatch countDownLatch, FrameListener frameListener) {
        countDownLatch.countDown();
        Iterator<FrameListenerAndParams> it = this.frameListeners.iterator();
        while (it.hasNext()) {
            if (it.next().listener == frameListener) {
                it.remove();
            }
        }
    }

    private void logD(String str) {
        Logging.d(TAG, this.name + str);
    }

    private void logE(String str, Throwable th) {
        Logging.e(TAG, this.name + str, th);
    }

    private void logW(String str) {
        Logging.w(TAG, this.name + str);
    }

    private void notifyCallbacks(VideoFrame videoFrame, boolean z8) {
        if (this.frameListeners.isEmpty()) {
            return;
        }
        this.drawMatrix.reset();
        this.drawMatrix.preTranslate(0.5f, 0.5f);
        this.drawMatrix.preRotate(this.rotation);
        this.drawMatrix.preScale(this.mirrorHorizontally ? -1.0f : 1.0f, this.mirrorVertically ? -1.0f : 1.0f);
        this.drawMatrix.preScale(1.0f, -1.0f);
        this.drawMatrix.preTranslate(-0.5f, -0.5f);
        Iterator<FrameListenerAndParams> it = this.frameListeners.iterator();
        while (it.hasNext()) {
            FrameListenerAndParams next = it.next();
            if (z8 || !next.applyFpsReduction) {
                it.remove();
                int rotatedWidth = (int) (next.scale * videoFrame.getRotatedWidth());
                int rotatedHeight = (int) (next.scale * videoFrame.getRotatedHeight());
                if (rotatedWidth == 0 || rotatedHeight == 0) {
                    next.listener.onFrame(null);
                } else {
                    this.bitmapTextureFramebuffer.setSize(rotatedWidth, rotatedHeight);
                    GLES20.glBindFramebuffer(36160, this.bitmapTextureFramebuffer.getFrameBufferId());
                    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.bitmapTextureFramebuffer.getTextureId(), 0);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                    GLES20.glClear(16384);
                    this.frameDrawer.drawFrame(videoFrame, next.drawer, this.drawMatrix, 0, 0, rotatedWidth, rotatedHeight, false, false);
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(rotatedWidth * rotatedHeight * 4);
                    GLES20.glViewport(0, 0, rotatedWidth, rotatedHeight);
                    GLES20.glReadPixels(0, 0, rotatedWidth, rotatedHeight, 6408, 5121, allocateDirect);
                    GLES20.glBindFramebuffer(36160, 0);
                    GlUtil.checkNoGLES2Error("EglRenderer.notifyCallbacks");
                    Bitmap createBitmap = Bitmap.createBitmap(rotatedWidth, rotatedHeight, Bitmap.Config.ARGB_8888);
                    createBitmap.copyPixelsFromBuffer(allocateDirect);
                    next.listener.onFrame(createBitmap);
                }
            }
        }
    }

    private void postToRenderThread(Runnable runnable) {
        synchronized (this.handlerLock) {
            try {
                Handler handler = this.renderThreadHandler;
                if (handler != null) {
                    handler.post(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void renderFrameOnRenderThread() {
        boolean z8;
        float f9;
        float f10;
        float f11;
        synchronized (this.frameLock) {
            try {
                VideoFrame videoFrame = this.pendingFrame;
                if (videoFrame == null) {
                    return;
                }
                this.pendingFrame = null;
                EglBase eglBase = this.eglBase;
                if (eglBase == null || !eglBase.hasSurface()) {
                    logD("Dropping frame - No surface");
                    videoFrame.release();
                    return;
                }
                synchronized (this.fpsReductionLock) {
                    long j5 = this.minRenderPeriodNs;
                    if (j5 != Long.MAX_VALUE) {
                        if (j5 > 0) {
                            long nanoTime = System.nanoTime();
                            long j9 = this.nextFrameTimeNs;
                            if (nanoTime >= j9) {
                                long j10 = j9 + this.minRenderPeriodNs;
                                this.nextFrameTimeNs = j10;
                                this.nextFrameTimeNs = Math.max(j10, nanoTime);
                            }
                        }
                        z8 = true;
                    }
                    z8 = false;
                }
                System.nanoTime();
                boolean z9 = Math.abs(this.rotation) == 90 || Math.abs(this.rotation) == 270;
                float rotatedHeight = (z9 ? videoFrame.getRotatedHeight() : videoFrame.getRotatedWidth()) / (z9 ? videoFrame.getRotatedWidth() : videoFrame.getRotatedHeight());
                synchronized (this.layoutLock) {
                    f9 = this.layoutAspectRatio;
                    if (f9 == 0.0f) {
                        f9 = rotatedHeight;
                    }
                }
                if (rotatedHeight > f9) {
                    f11 = f9 / rotatedHeight;
                    f10 = 1.0f;
                } else {
                    f10 = rotatedHeight / f9;
                    f11 = 1.0f;
                }
                this.drawMatrix.reset();
                this.drawMatrix.preTranslate(0.5f, 0.5f);
                this.drawMatrix.preRotate(this.rotation);
                this.drawMatrix.preScale(this.mirrorHorizontally ? -1.0f : 1.0f, this.mirrorVertically ? -1.0f : 1.0f);
                this.drawMatrix.preScale(f11, f10);
                this.drawMatrix.preTranslate(-0.5f, -0.5f);
                if (z8) {
                    try {
                        try {
                            this.frameDrawer.drawFrame(videoFrame, this.drawer, this.drawMatrix, 0, 0, this.eglBase.surfaceWidth(), this.eglBase.surfaceHeight(), z9, false);
                            if (this.eglBase.hasBackgroundSurface()) {
                                this.eglBase.makeBackgroundCurrent();
                                this.frameDrawer.drawFrame(videoFrame, this.drawer, this.drawMatrix, 0, 0, this.eglBase.surfaceWidth(), this.eglBase.surfaceHeight(), z9, true);
                                boolean z10 = this.usePresentationTimeStamp;
                                EglBase eglBase2 = this.eglBase;
                                if (z10) {
                                    eglBase2.swapBuffers(videoFrame.getTimestampNs(), true);
                                } else {
                                    eglBase2.swapBuffers(true);
                                }
                                this.eglBase.makeCurrent();
                            }
                            System.nanoTime();
                            boolean z11 = this.usePresentationTimeStamp;
                            EglBase eglBase3 = this.eglBase;
                            if (z11) {
                                eglBase3.swapBuffers(videoFrame.getTimestampNs(), false);
                            } else {
                                eglBase3.swapBuffers(false);
                            }
                            if (!this.firstFrameRendered) {
                                this.firstFrameRendered = true;
                                onFirstFrameRendered();
                            }
                        } catch (GlUtil.GlOutOfMemoryException e9) {
                            logE("Error while drawing frame", e9);
                            ErrorCallback errorCallback = this.errorCallback;
                            if (errorCallback != null) {
                                errorCallback.onGlOutOfMemory();
                            }
                            this.drawer.release();
                            this.frameDrawer.release();
                            this.bitmapTextureFramebuffer.release();
                            videoFrame.release();
                            return;
                        }
                    } catch (Throwable th) {
                        videoFrame.release();
                        throw th;
                    }
                }
                notifyCallbacks(videoFrame, z8);
                videoFrame.release();
            } finally {
            }
        }
    }

    public void addFrameListener(final FrameListener frameListener, final float f9, final RendererCommon.GlDrawer glDrawer, final boolean z8) {
        postToRenderThread(new Runnable() { // from class: org.webrtc.d
            @Override // java.lang.Runnable
            public final void run() {
                EglRenderer.this.lambda$addFrameListener$3(glDrawer, frameListener, f9, z8);
            }
        });
    }

    public void clearImage(final float f9, final float f10, final float f11, final float f12) {
        synchronized (this.handlerLock) {
            try {
                Handler handler = this.renderThreadHandler;
                if (handler == null) {
                    return;
                }
                handler.postAtFrontOfQueue(new Runnable() { // from class: org.webrtc.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        EglRenderer.this.lambda$clearImage$6(f9, f10, f11, f12);
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void createBackgroundSurface(SurfaceTexture surfaceTexture) {
        createEglSurfaceInternal(surfaceTexture, true);
    }

    public void createEglSurface(Surface surface) {
        createEglSurfaceInternal(surface, false);
    }

    public void disableFpsReduction() {
        setFpsReduction(Float.POSITIVE_INFINITY);
    }

    public void getTexture(GlGenericDrawer.TextureCallback textureCallback) {
        synchronized (this.handlerLock) {
            try {
                Handler handler = this.renderThreadHandler;
                if (handler != null) {
                    handler.post(new q(this, 1, textureCallback));
                }
            } catch (Exception e9) {
                FileLog.e(e9);
            }
        }
    }

    public void init(EglBase.Context context, int[] iArr, RendererCommon.GlDrawer glDrawer, boolean z8) {
        synchronized (this.handlerLock) {
            try {
                if (this.renderThreadHandler != null) {
                    throw new IllegalStateException(this.name + "Already initialized");
                }
                logD("Initializing EglRenderer");
                this.drawer = glDrawer;
                this.usePresentationTimeStamp = z8;
                this.firstFrameRendered = false;
                HandlerThread handlerThread = new HandlerThread(this.name + TAG);
                handlerThread.start();
                HandlerWithExceptionCallback handlerWithExceptionCallback = new HandlerWithExceptionCallback(handlerThread.getLooper(), new Runnable() { // from class: org.webrtc.EglRenderer.1
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (EglRenderer.this.handlerLock) {
                            EglRenderer.this.renderThreadHandler = null;
                        }
                    }
                });
                this.renderThreadHandler = handlerWithExceptionCallback;
                handlerWithExceptionCallback.post(new androidx.emoji2.text.m(this, context, iArr, 6));
                this.renderThreadHandler.post(this.eglSurfaceCreationRunnable);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        synchronized (this.handlerLock) {
            try {
                if (this.renderThreadHandler == null) {
                    logD("Dropping frame - Not initialized or already released.");
                    return;
                }
                synchronized (this.frameLock) {
                    try {
                        VideoFrame videoFrame2 = this.pendingFrame;
                        if (videoFrame2 != null) {
                            videoFrame2.release();
                        }
                        this.pendingFrame = videoFrame;
                        videoFrame.retain();
                        this.renderThreadHandler.post(new f(this, 0));
                    } finally {
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void pauseVideo() {
        setFpsReduction(0.0f);
    }

    public void printStackTrace() {
        synchronized (this.handlerLock) {
            try {
                Handler handler = this.renderThreadHandler;
                Thread thread = handler == null ? null : handler.getLooper().getThread();
                if (thread != null) {
                    StackTraceElement[] stackTrace = thread.getStackTrace();
                    if (stackTrace.length > 0) {
                        logW("EglRenderer stack trace:");
                        for (StackTraceElement stackTraceElement : stackTrace) {
                            logW(stackTraceElement.toString());
                        }
                    }
                }
            } finally {
            }
        }
    }

    public void release() {
        logD("Releasing.");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        synchronized (this.handlerLock) {
            try {
                Handler handler = this.renderThreadHandler;
                if (handler == null) {
                    logD("Already released");
                    return;
                }
                handler.postAtFrontOfQueue(new q(this, 2, countDownLatch));
                this.renderThreadHandler.post(new q(this, 3, this.renderThreadHandler.getLooper()));
                this.renderThreadHandler = null;
                ThreadUtils.awaitUninterruptibly(countDownLatch);
                synchronized (this.frameLock) {
                    try {
                        VideoFrame videoFrame = this.pendingFrame;
                        if (videoFrame != null) {
                            videoFrame.release();
                            this.pendingFrame = null;
                        }
                    } finally {
                    }
                }
                logD("Releasing done.");
            } finally {
            }
        }
    }

    public void releaseEglSurface(Runnable runnable, boolean z8) {
        this.eglSurfaceCreationRunnable.setSurface(null);
        synchronized (this.handlerLock) {
            try {
                Handler handler = this.renderThreadHandler;
                if (handler != null) {
                    handler.removeCallbacks(this.eglSurfaceCreationRunnable);
                    this.renderThreadHandler.postAtFrontOfQueue(new i2(this, z8, runnable));
                } else if (runnable != null) {
                    runnable.run();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void removeFrameListener(FrameListener frameListener) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        synchronized (this.handlerLock) {
            try {
                if (this.renderThreadHandler == null) {
                    return;
                }
                if (Thread.currentThread() == this.renderThreadHandler.getLooper().getThread()) {
                    throw new RuntimeException("removeFrameListener must not be called on the render thread.");
                }
                postToRenderThread(new androidx.emoji2.text.m(this, countDownLatch, frameListener, 7));
                ThreadUtils.awaitUninterruptibly(countDownLatch);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setErrorCallback(ErrorCallback errorCallback) {
        this.errorCallback = errorCallback;
    }

    public void setFpsReduction(float f9) {
        logD("setFpsReduction: " + f9);
        synchronized (this.fpsReductionLock) {
            try {
                long j5 = this.minRenderPeriodNs;
                if (f9 <= 0.0f) {
                    this.minRenderPeriodNs = Long.MAX_VALUE;
                } else {
                    this.minRenderPeriodNs = (long) (1000000000 / f9);
                }
                if (this.minRenderPeriodNs != j5) {
                    this.nextFrameTimeNs = System.nanoTime();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setLayoutAspectRatio(float f9) {
        if (this.layoutAspectRatio != f9) {
            synchronized (this.layoutLock) {
                this.layoutAspectRatio = f9;
            }
        }
    }

    public void setMirror(boolean z8) {
        logD("setMirrorHorizontally: " + z8);
        synchronized (this.layoutLock) {
            this.mirrorHorizontally = z8;
        }
    }

    public void setMirrorVertically(boolean z8) {
        logD("setMirrorVertically: " + z8);
        synchronized (this.layoutLock) {
            this.mirrorVertically = z8;
        }
    }

    public void setRotation(int i9) {
        synchronized (this.layoutLock) {
            this.rotation = i9;
        }
    }

    public void createEglSurface(SurfaceTexture surfaceTexture) {
        createEglSurfaceInternal(surfaceTexture, false);
    }

    public void addFrameListener(FrameListener frameListener, float f9, RendererCommon.GlDrawer glDrawer) {
        addFrameListener(frameListener, f9, glDrawer, false);
    }

    public void addFrameListener(FrameListener frameListener, float f9) {
        addFrameListener(frameListener, f9, null, false);
    }

    public void onFirstFrameRendered() {
    }

    public void clearImage() {
        clearImage(0.0f, 0.0f, 0.0f, 0.0f);
        this.firstFrameRendered = false;
    }

    @Override // org.webrtc.VideoSink
    public final /* synthetic */ void setParentSink(VideoSink videoSink) {
    }

    public EglRenderer(String str) {
        this(str, new VideoFrameDrawer());
    }

    public void init(EglBase.Context context, int[] iArr, RendererCommon.GlDrawer glDrawer) {
        init(context, iArr, glDrawer, false);
    }
}
