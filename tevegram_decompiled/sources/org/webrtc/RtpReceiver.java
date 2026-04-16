package org.webrtc;

import org.webrtc.MediaStreamTrack;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class RtpReceiver {
    private MediaStreamTrack cachedTrack;
    private long nativeObserver;
    private long nativeRtpReceiver;

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public interface Observer {
        @CalledByNative("Observer")
        void onFirstPacketReceived(MediaStreamTrack.MediaType mediaType);
    }

    @CalledByNative
    public RtpReceiver(long j5) {
        this.nativeRtpReceiver = j5;
        this.cachedTrack = MediaStreamTrack.createMediaStreamTrack(nativeGetTrack(j5));
    }

    private void checkRtpReceiverExists() {
        if (this.nativeRtpReceiver != 0) {
            return;
        }
        m7.c.p("RtpReceiver has been disposed.");
    }

    private static native String nativeGetId(long j5);

    private static native RtpParameters nativeGetParameters(long j5);

    private static native long nativeGetTrack(long j5);

    private static native void nativeSetFrameDecryptor(long j5, long j9);

    private static native long nativeSetObserver(long j5, Observer observer);

    private static native void nativeUnsetObserver(long j5, long j9);

    public void SetObserver(Observer observer) {
        checkRtpReceiverExists();
        long j5 = this.nativeObserver;
        if (j5 != 0) {
            nativeUnsetObserver(this.nativeRtpReceiver, j5);
        }
        this.nativeObserver = nativeSetObserver(this.nativeRtpReceiver, observer);
    }

    @CalledByNative
    public void dispose() {
        checkRtpReceiverExists();
        this.cachedTrack.dispose();
        long j5 = this.nativeObserver;
        if (j5 != 0) {
            nativeUnsetObserver(this.nativeRtpReceiver, j5);
            this.nativeObserver = 0L;
        }
        JniCommon.nativeReleaseRef(this.nativeRtpReceiver);
        this.nativeRtpReceiver = 0L;
    }

    public long getNativeRtpReceiver() {
        checkRtpReceiverExists();
        return this.nativeRtpReceiver;
    }

    public RtpParameters getParameters() {
        checkRtpReceiverExists();
        return nativeGetParameters(this.nativeRtpReceiver);
    }

    public String id() {
        checkRtpReceiverExists();
        return nativeGetId(this.nativeRtpReceiver);
    }

    public void setFrameDecryptor(FrameDecryptor frameDecryptor) {
        checkRtpReceiverExists();
        nativeSetFrameDecryptor(this.nativeRtpReceiver, frameDecryptor.getNativeFrameDecryptor());
    }

    public MediaStreamTrack track() {
        return this.cachedTrack;
    }
}
