package org.webrtc.audio;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public interface AudioDeviceModule {
    long getNativeAudioDeviceModulePointer();

    void release();

    void setMicrophoneMute(boolean z8);

    boolean setNoiseSuppressorEnabled(boolean z8);

    boolean setPreferredMicrophoneFieldDimension(float f9);

    void setSpeakerMute(boolean z8);
}
