package n1;

import android.media.AudioPlaybackCaptureConfiguration;
import android.media.MediaCodecInfo;
import android.media.projection.MediaProjection;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract /* synthetic */ class e0 {
    public static /* synthetic */ AudioPlaybackCaptureConfiguration.Builder c(MediaProjection mediaProjection) {
        return new AudioPlaybackCaptureConfiguration.Builder(mediaProjection);
    }

    public static /* synthetic */ MediaCodecInfo.VideoCapabilities.PerformancePoint f() {
        return new MediaCodecInfo.VideoCapabilities.PerformancePoint(1280, 720, 60);
    }

    public static /* synthetic */ MediaCodecInfo.VideoCapabilities.PerformancePoint g(int i9, int i10, int i11) {
        return new MediaCodecInfo.VideoCapabilities.PerformancePoint(i9, i10, i11);
    }

    public static /* bridge */ /* synthetic */ MediaCodecInfo.VideoCapabilities.PerformancePoint h(Object obj) {
        return (MediaCodecInfo.VideoCapabilities.PerformancePoint) obj;
    }

    public static /* synthetic */ void k() {
    }

    public static /* synthetic */ void x() {
    }
}
