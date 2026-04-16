package org.webrtc;

import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class RtpSender {
    private MediaStreamTrack cachedTrack;
    private final DtmfSender dtmfSender;
    private long nativeRtpSender;
    private boolean ownsTrack = true;

    @CalledByNative
    public RtpSender(long j5) {
        this.nativeRtpSender = j5;
        this.cachedTrack = MediaStreamTrack.createMediaStreamTrack(nativeGetTrack(j5));
        if (!nativeGetMediaType(j5).equalsIgnoreCase("audio")) {
            this.dtmfSender = null;
        } else {
            long nativeGetDtmfSender = nativeGetDtmfSender(j5);
            this.dtmfSender = nativeGetDtmfSender != 0 ? new DtmfSender(nativeGetDtmfSender) : null;
        }
    }

    private void checkRtpSenderExists() {
        if (this.nativeRtpSender != 0) {
            return;
        }
        m7.c.p("RtpSender has been disposed.");
    }

    private static native long nativeGetDtmfSender(long j5);

    private static native String nativeGetId(long j5);

    private static native String nativeGetMediaType(long j5);

    private static native RtpParameters nativeGetParameters(long j5);

    private static native List<String> nativeGetStreams(long j5);

    private static native long nativeGetTrack(long j5);

    private static native void nativeSetFrameEncryptor(long j5, long j9);

    private static native boolean nativeSetParameters(long j5, RtpParameters rtpParameters);

    private static native void nativeSetStreams(long j5, List<String> list);

    private static native boolean nativeSetTrack(long j5, long j9);

    public void dispose() {
        checkRtpSenderExists();
        DtmfSender dtmfSender = this.dtmfSender;
        if (dtmfSender != null) {
            dtmfSender.dispose();
        }
        MediaStreamTrack mediaStreamTrack = this.cachedTrack;
        if (mediaStreamTrack != null && this.ownsTrack) {
            mediaStreamTrack.dispose();
        }
        JniCommon.nativeReleaseRef(this.nativeRtpSender);
        this.nativeRtpSender = 0L;
    }

    public DtmfSender dtmf() {
        return this.dtmfSender;
    }

    public long getNativeRtpSender() {
        checkRtpSenderExists();
        return this.nativeRtpSender;
    }

    public RtpParameters getParameters() {
        checkRtpSenderExists();
        return nativeGetParameters(this.nativeRtpSender);
    }

    public List<String> getStreams() {
        checkRtpSenderExists();
        return nativeGetStreams(this.nativeRtpSender);
    }

    public String id() {
        checkRtpSenderExists();
        return nativeGetId(this.nativeRtpSender);
    }

    public void setFrameEncryptor(FrameEncryptor frameEncryptor) {
        checkRtpSenderExists();
        nativeSetFrameEncryptor(this.nativeRtpSender, frameEncryptor.getNativeFrameEncryptor());
    }

    public boolean setParameters(RtpParameters rtpParameters) {
        checkRtpSenderExists();
        return nativeSetParameters(this.nativeRtpSender, rtpParameters);
    }

    public void setStreams(List<String> list) {
        checkRtpSenderExists();
        nativeSetStreams(this.nativeRtpSender, list);
    }

    public boolean setTrack(MediaStreamTrack mediaStreamTrack, boolean z8) {
        checkRtpSenderExists();
        if (!nativeSetTrack(this.nativeRtpSender, mediaStreamTrack == null ? 0L : mediaStreamTrack.getNativeMediaStreamTrack())) {
            return false;
        }
        MediaStreamTrack mediaStreamTrack2 = this.cachedTrack;
        if (mediaStreamTrack2 != null && this.ownsTrack) {
            mediaStreamTrack2.dispose();
        }
        this.cachedTrack = mediaStreamTrack;
        this.ownsTrack = z8;
        return true;
    }

    public MediaStreamTrack track() {
        return this.cachedTrack;
    }
}
