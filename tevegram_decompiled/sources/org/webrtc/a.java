package org.webrtc;

import org.webrtc.Camera2Session;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class a implements VideoSink {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f8029i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f8030j;

    public /* synthetic */ a(Object obj, int i9) {
        this.f8029i = i9;
        this.f8030j = obj;
    }

    @Override // org.webrtc.VideoSink
    public final void onFrame(VideoFrame videoFrame) {
        switch (this.f8029i) {
            case 0:
                ((Camera1Session) this.f8030j).lambda$listenForTextureFrames$0(videoFrame);
                break;
            case 1:
                ((Camera2Session.CaptureSessionCallback) this.f8030j).lambda$onConfigured$0(videoFrame);
                break;
            default:
                ((VideoSource) this.f8030j).lambda$setVideoProcessor$1(videoFrame);
                break;
        }
    }

    @Override // org.webrtc.VideoSink
    public final /* synthetic */ void setParentSink(VideoSink videoSink) {
        int i9 = this.f8029i;
    }

    private final /* synthetic */ void a(VideoSink videoSink) {
    }

    private final /* synthetic */ void b(VideoSink videoSink) {
    }

    private final /* synthetic */ void c(VideoSink videoSink) {
    }
}
