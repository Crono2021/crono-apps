package org.webrtc;

import java.util.concurrent.CountDownLatch;
import org.webrtc.TextureViewRenderer;
import org.webrtc.VideoFrame;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f8047i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f8048j;

    public /* synthetic */ f(Object obj, int i9) {
        this.f8047i = i9;
        this.f8048j = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8047i) {
            case 0:
                ((EglRenderer) this.f8048j).renderFrameOnRenderThread();
                break;
            case 1:
                ((VideoFrame.I420Buffer) this.f8048j).release();
                break;
            case 2:
                ((CountDownLatch) this.f8048j).countDown();
                break;
            case 3:
                ((TextureViewRenderer.TextureEglRenderer) this.f8048j).lambda$onFirstFrameRendered$0();
                break;
            default:
                ((VideoFileRenderer) this.f8048j).lambda$release$3();
                break;
        }
    }
}
