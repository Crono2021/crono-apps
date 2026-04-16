package org.webrtc;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class AudioTrack extends MediaStreamTrack {
    public AudioTrack(long j5) {
        super(j5);
    }

    private static native void nativeSetVolume(long j5, double d9);

    public long getNativeAudioTrack() {
        return getNativeMediaStreamTrack();
    }

    public void setVolume(double d9) {
        nativeSetVolume(getNativeAudioTrack(), d9);
    }
}
