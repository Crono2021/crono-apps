package org.webrtc;

import org.webrtc.VideoFrame;
import org.webrtc.VideoProcessor;
import org.webrtc.VideoSource;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
class NativeAndroidVideoTrackSource {
    private final long nativeAndroidVideoTrackSource;

    public NativeAndroidVideoTrackSource(long j5) {
        this.nativeAndroidVideoTrackSource = j5;
    }

    @CalledByNative
    public static VideoProcessor.FrameAdaptationParameters createFrameAdaptationParameters(int i9, int i10, int i11, int i12, int i13, int i14, long j5, boolean z8) {
        return new VideoProcessor.FrameAdaptationParameters(i9, i10, i11, i12, i13, i14, j5, z8);
    }

    private static native VideoProcessor.FrameAdaptationParameters nativeAdaptFrame(long j5, int i9, int i10, int i11, long j9);

    private static native void nativeAdaptOutputFormat(long j5, int i9, int i10, Integer num, int i11, int i12, Integer num2, Integer num3);

    private static native void nativeOnFrameCaptured(long j5, int i9, long j9, VideoFrame.Buffer buffer);

    private static native void nativeSetIsScreencast(long j5, boolean z8);

    private static native void nativeSetState(long j5, boolean z8);

    public VideoProcessor.FrameAdaptationParameters adaptFrame(VideoFrame videoFrame) {
        return nativeAdaptFrame(this.nativeAndroidVideoTrackSource, videoFrame.getBuffer().getWidth(), videoFrame.getBuffer().getHeight(), videoFrame.getRotation(), videoFrame.getTimestampNs());
    }

    public void adaptOutputFormat(VideoSource.AspectRatio aspectRatio, Integer num, VideoSource.AspectRatio aspectRatio2, Integer num2, Integer num3) {
        nativeAdaptOutputFormat(this.nativeAndroidVideoTrackSource, aspectRatio.width, aspectRatio.height, num, aspectRatio2.width, aspectRatio2.height, num2, num3);
    }

    public void onFrameCaptured(VideoFrame videoFrame) {
        nativeOnFrameCaptured(this.nativeAndroidVideoTrackSource, videoFrame.getRotation(), videoFrame.getTimestampNs(), videoFrame.getBuffer());
    }

    public void setIsScreencast(boolean z8) {
        nativeSetIsScreencast(this.nativeAndroidVideoTrackSource, z8);
    }

    public void setState(boolean z8) {
        nativeSetState(this.nativeAndroidVideoTrackSource, z8);
    }
}
