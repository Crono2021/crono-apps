package org.webrtc;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.TextureView;
import android.view.View;
import java.util.concurrent.CountDownLatch;
import org.webrtc.EglBase;
import org.webrtc.EglRenderer;
import org.webrtc.GlGenericDrawer;
import org.webrtc.RendererCommon;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class TextureViewRenderer extends TextureView implements TextureView.SurfaceTextureListener, VideoSink, RendererCommon.RendererEvents {
    private static final String TAG = "TextureViewRenderer";
    private TextureView backgroundRenderer;
    private int cameraRotation;
    private final TextureEglRenderer eglRenderer;
    private boolean enableFixedSize;
    private boolean isCamera;
    private int maxTextureSize;
    private boolean mirror;
    private OrientationHelper orientationHelper;
    private VideoSink parentSink;
    private RendererCommon.RendererEvents rendererEvents;
    private final String resourceName;
    private boolean rotateTextureWithScreen;
    public int rotatedFrameHeight;
    public int rotatedFrameWidth;
    private int screenRotation;
    private int surfaceHeight;
    private int surfaceWidth;
    int textureRotation;
    Runnable updateScreenRunnable;
    boolean useCameraRotation;
    private int videoHeight;
    private final RendererCommon.VideoLayoutMeasure videoLayoutMeasure;
    private int videoWidth;

    public TextureViewRenderer(Context context) {
        super(context);
        this.videoLayoutMeasure = new RendererCommon.VideoLayoutMeasure();
        String resourceName = getResourceName();
        this.resourceName = resourceName;
        this.eglRenderer = new TextureEglRenderer(resourceName);
        setSurfaceTextureListener(this);
    }

    private String getResourceName() {
        try {
            return getResources().getResourceEntryName(getId());
        } catch (Resources.NotFoundException unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onFrameResolutionChanged$0(int i9, int i10, int i11, int i12) {
        this.updateScreenRunnable = null;
        this.videoWidth = i9;
        this.videoHeight = i10;
        this.rotatedFrameWidth = i11;
        this.rotatedFrameHeight = i12;
        updateSurfaceSize();
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateVideoSizes$1(int i9, int i10) {
        this.updateScreenRunnable = null;
        this.rotatedFrameWidth = i9;
        this.rotatedFrameHeight = i10;
        updateSurfaceSize();
        requestLayout();
    }

    private void logD(String str) {
        Logging.d(TAG, this.resourceName + ": " + str);
    }

    private void onRotationChanged() {
        int i9;
        int i10 = this.useCameraRotation ? OrientationHelper.cameraOrientation : 0;
        boolean z8 = this.mirror;
        if (z8) {
            i10 = 360 - i10;
        }
        int i11 = -i10;
        if (this.useCameraRotation) {
            int i12 = this.screenRotation;
            if (i12 == 1) {
                i9 = z8 ? 90 : -90;
            } else if (i12 == 3) {
                i9 = z8 ? 270 : -270;
            }
            i11 += i9;
        }
        this.eglRenderer.setRotation(i11);
        this.eglRenderer.setMirror(this.mirror);
    }

    private void postOrRun(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }

    private void updateSurfaceSize() {
        ThreadUtils.checkIsOnMainThread();
        if (!this.enableFixedSize || this.rotatedFrameWidth == 0 || this.rotatedFrameHeight == 0 || getWidth() == 0 || getHeight() == 0) {
            this.surfaceHeight = 0;
            this.surfaceWidth = 0;
            return;
        }
        float width = getWidth() / getHeight();
        int i9 = this.rotatedFrameWidth;
        int i10 = this.rotatedFrameHeight;
        if (i9 / i10 > width) {
            i9 = (int) (i10 * width);
        } else {
            i10 = (int) (i10 / width);
        }
        int min = Math.min(getWidth(), i9);
        int min2 = Math.min(getHeight(), i10);
        logD("updateSurfaceSize. Layout size: " + getWidth() + "x" + getHeight() + ", frame size: " + this.rotatedFrameWidth + "x" + this.rotatedFrameHeight + ", requested surface size: " + min + "x" + min2 + ", old surface size: " + this.surfaceWidth + "x" + this.surfaceHeight);
        if (min == this.surfaceWidth && min2 == this.surfaceHeight) {
            return;
        }
        this.surfaceWidth = min;
        this.surfaceHeight = min2;
    }

    private void updateVideoSizes() {
        int i9;
        int i10;
        int i11 = this.videoHeight;
        if (i11 == 0 || (i9 = this.videoWidth) == 0) {
            return;
        }
        if (!this.rotateTextureWithScreen) {
            int i12 = this.textureRotation - OrientationHelper.cameraOrientation;
            int i13 = (i12 == 0 || i12 == 180 || i12 == -180) ? this.videoWidth : this.videoHeight;
            i11 = (i12 == 0 || i12 == 180 || i12 == -180) ? this.videoHeight : this.videoWidth;
            i10 = i13;
        } else if (this.useCameraRotation) {
            int i14 = this.screenRotation;
            i10 = i14 == 0 ? i11 : i9;
            if (i14 == 0) {
                i11 = i9;
            }
        } else {
            int i15 = this.textureRotation;
            int i16 = (i15 == 0 || i15 == 180 || i15 == -180) ? i9 : i11;
            if (i15 != 0 && i15 != 180 && i15 != -180) {
                i11 = i9;
            }
            i10 = i16;
        }
        if (this.rotatedFrameWidth == i10 && this.rotatedFrameHeight == i11) {
            return;
        }
        synchronized (this.eglRenderer.layoutLock) {
            try {
                Runnable runnable = this.updateScreenRunnable;
                if (runnable != null) {
                    removeCallbacks(runnable);
                }
                o oVar = new o(this, i10, i11, 2);
                this.updateScreenRunnable = oVar;
                postOrRun(oVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void addFrameListener(EglRenderer.FrameListener frameListener, float f9, RendererCommon.GlDrawer glDrawer) {
        this.eglRenderer.addFrameListener(frameListener, f9, glDrawer);
    }

    public void clearFirstFrame() {
        TextureEglRenderer textureEglRenderer = this.eglRenderer;
        textureEglRenderer.firstFrameRendered = false;
        textureEglRenderer.isFirstFrameRendered = false;
    }

    public void clearImage() {
        this.eglRenderer.clearImage();
        this.eglRenderer.isFirstFrameRendered = false;
    }

    public void createBackgroundSurface(SurfaceTexture surfaceTexture) {
        this.eglRenderer.createBackgroundSurface(surfaceTexture);
    }

    public void disableFpsReduction() {
        this.eglRenderer.disableFpsReduction();
    }

    public void getRenderBufferBitmap(GlGenericDrawer.TextureCallback textureCallback) {
        this.eglRenderer.getTexture(textureCallback);
    }

    public void init(EglBase.Context context, RendererCommon.RendererEvents rendererEvents, int[] iArr, RendererCommon.GlDrawer glDrawer) {
        ThreadUtils.checkIsOnMainThread();
        this.rendererEvents = rendererEvents;
        this.rotatedFrameWidth = 0;
        this.rotatedFrameHeight = 0;
        this.eglRenderer.init(context, this, iArr, glDrawer);
    }

    public boolean isFirstFrameRendered() {
        return this.eglRenderer.isFirstFrameRendered;
    }

    @Override // org.webrtc.RendererCommon.RendererEvents
    public void onFirstFrameRendered() {
        RendererCommon.RendererEvents rendererEvents = this.rendererEvents;
        if (rendererEvents != null) {
            rendererEvents.onFirstFrameRendered();
        }
    }

    @Override // org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        this.eglRenderer.onFrame(videoFrame);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
    
        if (r10 == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
    
        r10 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x003b, code lost:
    
        if (r10 != (-180)) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0059, code lost:
    
        if (r10 != (-180)) goto L16;
     */
    @Override // org.webrtc.RendererCommon.RendererEvents
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onFrameResolutionChanged(final int r8, final int r9, int r10) {
        /*
            r7 = this;
            org.webrtc.RendererCommon$RendererEvents r0 = r7.rendererEvents
            if (r0 == 0) goto L7
            r0.onFrameResolutionChanged(r8, r9, r10)
        L7:
            r7.textureRotation = r10
            boolean r0 = r7.rotateTextureWithScreen
            boolean r1 = r7.isCamera
            r2 = -180(0xffffffffffffff4c, float:NaN)
            r3 = 180(0xb4, float:2.52E-43)
            if (r0 == 0) goto L3e
            if (r1 == 0) goto L18
            r7.onRotationChanged()
        L18:
            boolean r10 = r7.useCameraRotation
            if (r10 == 0) goto L2b
            int r10 = r7.screenRotation
            if (r10 != 0) goto L22
            r0 = r9
            goto L23
        L22:
            r0 = r8
        L23:
            if (r10 != 0) goto L27
        L25:
            r10 = r8
            goto L28
        L27:
            r10 = r9
        L28:
            r6 = r10
            r5 = r0
            goto L5c
        L2b:
            int r10 = r7.textureRotation
            if (r10 == 0) goto L36
            if (r10 == r3) goto L36
            if (r10 != r2) goto L34
            goto L36
        L34:
            r0 = r9
            goto L37
        L36:
            r0 = r8
        L37:
            if (r10 == 0) goto L27
            if (r10 == r3) goto L27
            if (r10 != r2) goto L25
            goto L27
        L3e:
            if (r1 == 0) goto L48
            org.webrtc.TextureViewRenderer$TextureEglRenderer r0 = r7.eglRenderer
            int r1 = org.webrtc.OrientationHelper.cameraRotation
            int r1 = -r1
            r0.setRotation(r1)
        L48:
            int r0 = org.webrtc.OrientationHelper.cameraOrientation
            int r10 = r10 - r0
            if (r10 == 0) goto L54
            if (r10 == r3) goto L54
            if (r10 != r2) goto L52
            goto L54
        L52:
            r0 = r9
            goto L55
        L54:
            r0 = r8
        L55:
            if (r10 == 0) goto L27
            if (r10 == r3) goto L27
            if (r10 != r2) goto L25
            goto L27
        L5c:
            org.webrtc.TextureViewRenderer$TextureEglRenderer r10 = r7.eglRenderer
            java.lang.Object r10 = org.webrtc.TextureViewRenderer.TextureEglRenderer.o(r10)
            monitor-enter(r10)
            java.lang.Runnable r0 = r7.updateScreenRunnable     // Catch: java.lang.Throwable -> L81
            if (r0 == 0) goto L6f
            r7.removeCallbacks(r0)     // Catch: java.lang.Throwable -> L6b
            goto L6f
        L6b:
            r0 = move-exception
            r8 = r0
            r2 = r7
            goto L84
        L6f:
            org.webrtc.s r1 = new org.webrtc.s     // Catch: java.lang.Throwable -> L81
            r2 = r7
            r3 = r8
            r4 = r9
            r1.<init>()     // Catch: java.lang.Throwable -> L7e
            r2.updateScreenRunnable = r1     // Catch: java.lang.Throwable -> L7e
            r7.postOrRun(r1)     // Catch: java.lang.Throwable -> L7e
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L7e
            return
        L7e:
            r0 = move-exception
        L7f:
            r8 = r0
            goto L84
        L81:
            r0 = move-exception
            r2 = r7
            goto L7f
        L84:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L7e
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.webrtc.TextureViewRenderer.onFrameResolutionChanged(int, int, int):void");
    }

    @Override // android.view.View
    public void onMeasure(int i9, int i10) {
        ThreadUtils.checkIsOnMainThread();
        if (!this.isCamera && this.rotateTextureWithScreen) {
            updateVideoSizes();
        }
        int i11 = this.maxTextureSize;
        RendererCommon.VideoLayoutMeasure videoLayoutMeasure = this.videoLayoutMeasure;
        Point measure = i11 > 0 ? videoLayoutMeasure.measure(this.isCamera, View.MeasureSpec.makeMeasureSpec(Math.min(i11, View.MeasureSpec.getSize(i9)), View.MeasureSpec.getMode(i9)), View.MeasureSpec.makeMeasureSpec(Math.min(this.maxTextureSize, View.MeasureSpec.getSize(i10)), View.MeasureSpec.getMode(i10)), this.rotatedFrameWidth, this.rotatedFrameHeight) : videoLayoutMeasure.measure(this.isCamera, i9, i10, this.rotatedFrameWidth, this.rotatedFrameHeight);
        setMeasuredDimension(measure.x, measure.y);
        if (this.rotatedFrameWidth != 0 && this.rotatedFrameHeight != 0) {
            this.eglRenderer.setLayoutAspectRatio(getMeasuredWidth() / getMeasuredHeight());
        }
        updateSurfaceSize();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i9, int i10) {
        ThreadUtils.checkIsOnMainThread();
        this.surfaceHeight = 0;
        this.surfaceWidth = 0;
        updateSurfaceSize();
        this.eglRenderer.onSurfaceTextureAvailable(surfaceTexture, i9, i10);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.eglRenderer.onSurfaceTextureDestroyed(surfaceTexture);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i9, int i10) {
        this.surfaceWidth = i9;
        this.surfaceHeight = i10;
        this.eglRenderer.onSurfaceTextureSizeChanged(surfaceTexture, i9, i10);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.eglRenderer.onSurfaceTextureUpdated(surfaceTexture);
    }

    public void pauseVideo() {
        this.eglRenderer.pauseVideo();
    }

    public void release() {
        this.eglRenderer.release();
        OrientationHelper orientationHelper = this.orientationHelper;
        if (orientationHelper != null) {
            orientationHelper.stop();
        }
    }

    public void removeFrameListener(EglRenderer.FrameListener frameListener) {
        this.eglRenderer.removeFrameListener(frameListener);
    }

    public void setBackgroundRenderer(TextureView textureView) {
        this.backgroundRenderer = textureView;
        if (textureView != null) {
            textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: org.webrtc.TextureViewRenderer.1
                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i9, int i10) {
                    TextureViewRenderer.this.createBackgroundSurface(surfaceTexture);
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                    ThreadUtils.checkIsOnMainThread();
                    TextureViewRenderer.this.eglRenderer.releaseEglSurface(null, true);
                    return false;
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                }

                @Override // android.view.TextureView.SurfaceTextureListener
                public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i9, int i10) {
                }
            });
        } else {
            ThreadUtils.checkIsOnMainThread();
            this.eglRenderer.releaseEglSurface(null, true);
        }
    }

    public void setEnableHardwareScaler(boolean z8) {
        ThreadUtils.checkIsOnMainThread();
        this.enableFixedSize = z8;
        updateSurfaceSize();
    }

    public void setFpsReduction(float f9) {
        this.eglRenderer.setFpsReduction(f9);
    }

    public void setIsCamera(boolean z8) {
        this.isCamera = z8;
        if (z8) {
            return;
        }
        OrientationHelper orientationHelper = new OrientationHelper() { // from class: org.webrtc.TextureViewRenderer.2
            @Override // org.webrtc.OrientationHelper
            public void onOrientationUpdate(int i9) {
                if (TextureViewRenderer.this.isCamera) {
                    return;
                }
                TextureViewRenderer.this.updateRotation();
            }
        };
        this.orientationHelper = orientationHelper;
        orientationHelper.start();
    }

    public void setMaxTextureSize(int i9) {
        this.maxTextureSize = i9;
    }

    public void setMirror(boolean z8) {
        if (this.mirror != z8) {
            this.mirror = z8;
            if (this.rotateTextureWithScreen) {
                onRotationChanged();
            } else {
                this.eglRenderer.setMirror(z8);
            }
            updateSurfaceSize();
            requestLayout();
        }
    }

    @Override // org.webrtc.VideoSink
    public void setParentSink(VideoSink videoSink) {
        this.parentSink = videoSink;
    }

    public void setRotateTextureWithScreen(boolean z8) {
        if (this.rotateTextureWithScreen != z8) {
            this.rotateTextureWithScreen = z8;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setRotation(float f9) {
        super.setRotation(f9);
    }

    @Override // android.view.View
    public void setRotationX(float f9) {
        super.setRotationX(f9);
    }

    @Override // android.view.View
    public void setRotationY(float f9) {
        super.setRotationY(f9);
    }

    public void setScalingType(RendererCommon.ScalingType scalingType) {
        ThreadUtils.checkIsOnMainThread();
        this.videoLayoutMeasure.setScalingType(scalingType);
        requestLayout();
    }

    public void setScreenRotation(int i9) {
        this.screenRotation = i9;
        onRotationChanged();
        updateVideoSizes();
    }

    public void setUseCameraRotation(boolean z8) {
        if (this.useCameraRotation != z8) {
            this.useCameraRotation = z8;
            onRotationChanged();
            updateVideoSizes();
        }
    }

    public void updateRotation() {
        View view;
        float f9;
        float f10;
        if (this.orientationHelper == null || this.rotatedFrameWidth == 0 || this.rotatedFrameHeight == 0 || (view = (View) getParent()) == null) {
            return;
        }
        int orientation = this.orientationHelper.getOrientation();
        float measuredWidth = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        float measuredWidth2 = view.getMeasuredWidth();
        float measuredHeight2 = view.getMeasuredHeight();
        if (orientation == 90 || orientation == 270) {
            f9 = measuredWidth;
            f10 = measuredHeight;
        } else {
            f10 = measuredWidth;
            f9 = measuredHeight;
        }
        float max = f10 < f9 ? Math.max(f10 / measuredWidth, f9 / measuredHeight) : Math.min(f10 / measuredWidth, f9 / measuredHeight);
        float f11 = f10 * max;
        float f12 = f9 * max;
        if (Math.abs((f11 / f12) - (measuredWidth2 / measuredHeight2)) < 0.1f) {
            max *= Math.max(measuredWidth2 / f11, measuredHeight2 / f12);
        }
        if (orientation == 270) {
            orientation = -90;
        }
        animate().scaleX(max).scaleY(max).rotation(-orientation).setDuration(180L).start();
    }

    public void addFrameListener(EglRenderer.FrameListener frameListener, float f9) {
        this.eglRenderer.addFrameListener(frameListener, f9);
    }

    public void setScalingType(RendererCommon.ScalingType scalingType, RendererCommon.ScalingType scalingType2) {
        ThreadUtils.checkIsOnMainThread();
        this.videoLayoutMeasure.setScalingType(scalingType, scalingType2);
        requestLayout();
    }

    public void init(EglBase.Context context, RendererCommon.RendererEvents rendererEvents) {
        init(context, rendererEvents, EglBase.CONFIG_PLAIN, new GlRectDrawer());
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public static class TextureEglRenderer extends EglRenderer implements TextureView.SurfaceTextureListener {
        private static final String TAG = "TextureEglRenderer";
        private float currentFps;
        private int frameRotation;
        private int framesInLastSecond;
        private boolean isFirstFrameRendered;
        private boolean isRenderingPaused;
        private long lastFpsLogTime;
        private final Object layoutLock;
        private RendererCommon.RendererEvents rendererEvents;
        private int rotatedFrameHeight;
        private int rotatedFrameWidth;

        public TextureEglRenderer(String str) {
            super(str);
            this.layoutLock = new Object();
            this.lastFpsLogTime = 0L;
            this.framesInLastSecond = 0;
            this.currentFps = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onFirstFrameRendered$0() {
            this.isFirstFrameRendered = true;
            this.rendererEvents.onFirstFrameRendered();
        }

        private void logD(String str) {
            Logging.d(TAG, this.name + ": " + str);
        }

        private void updateFrameDimensionsAndReportEvents(VideoFrame videoFrame) {
            synchronized (this.layoutLock) {
                try {
                    if (this.isRenderingPaused) {
                        return;
                    }
                    if (this.rotatedFrameWidth != videoFrame.getRotatedWidth() || this.rotatedFrameHeight != videoFrame.getRotatedHeight() || this.frameRotation != videoFrame.getRotation()) {
                        logD("Reporting frame resolution changed to " + videoFrame.getBuffer().getWidth() + "x" + videoFrame.getBuffer().getHeight() + " with rotation " + videoFrame.getRotation());
                        RendererCommon.RendererEvents rendererEvents = this.rendererEvents;
                        if (rendererEvents != null) {
                            rendererEvents.onFrameResolutionChanged(videoFrame.getBuffer().getWidth(), videoFrame.getBuffer().getHeight(), videoFrame.getRotation());
                        }
                        this.rotatedFrameWidth = videoFrame.getRotatedWidth();
                        this.rotatedFrameHeight = videoFrame.getRotatedHeight();
                        this.frameRotation = videoFrame.getRotation();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // org.webrtc.EglRenderer
        public void disableFpsReduction() {
            synchronized (this.layoutLock) {
                this.isRenderingPaused = false;
            }
            super.disableFpsReduction();
        }

        public void init(EglBase.Context context, RendererCommon.RendererEvents rendererEvents, int[] iArr, RendererCommon.GlDrawer glDrawer) {
            ThreadUtils.checkIsOnMainThread();
            this.rendererEvents = rendererEvents;
            synchronized (this.layoutLock) {
                this.isFirstFrameRendered = false;
                this.rotatedFrameWidth = 0;
                this.rotatedFrameHeight = 0;
                this.frameRotation = 0;
            }
            super.init(context, iArr, glDrawer);
        }

        @Override // org.webrtc.EglRenderer
        public void onFirstFrameRendered() {
            new Handler(Looper.getMainLooper()).post(new f(this, 3));
        }

        @Override // org.webrtc.EglRenderer, org.webrtc.VideoSink
        public void onFrame(VideoFrame videoFrame) {
            updateFrameDimensionsAndReportEvents(videoFrame);
            long currentTimeMillis = System.currentTimeMillis();
            int i9 = this.framesInLastSecond + 1;
            this.framesInLastSecond = i9;
            if (currentTimeMillis - this.lastFpsLogTime >= 1000) {
                float f9 = (i9 * 1000.0f) / (currentTimeMillis - r4);
                this.currentFps = f9;
                logD("RENDER FPS: ".concat(String.format("%.1f", Float.valueOf(f9))));
                this.framesInLastSecond = 0;
                this.lastFpsLogTime = currentTimeMillis;
            }
            super.onFrame(videoFrame);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i9, int i10) {
            ThreadUtils.checkIsOnMainThread();
            createEglSurface(surfaceTexture);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            ThreadUtils.checkIsOnMainThread();
            CountDownLatch countDownLatch = new CountDownLatch(1);
            releaseEglSurface(new f(countDownLatch, 2), false);
            ThreadUtils.awaitUninterruptibly(countDownLatch);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i9, int i10) {
            ThreadUtils.checkIsOnMainThread();
            logD("surfaceChanged: size: " + i9 + "x" + i10);
        }

        @Override // org.webrtc.EglRenderer
        public void pauseVideo() {
            synchronized (this.layoutLock) {
                this.isRenderingPaused = true;
            }
            super.pauseVideo();
        }

        @Override // org.webrtc.EglRenderer
        public void setFpsReduction(float f9) {
            synchronized (this.layoutLock) {
                this.isRenderingPaused = f9 == 0.0f;
            }
            super.setFpsReduction(f9);
        }

        @Override // org.webrtc.EglRenderer
        public void init(EglBase.Context context, int[] iArr, RendererCommon.GlDrawer glDrawer) {
            init(context, (RendererCommon.RendererEvents) null, iArr, glDrawer);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }
}
