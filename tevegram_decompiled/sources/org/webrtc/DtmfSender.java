package org.webrtc;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class DtmfSender {
    private long nativeDtmfSender;

    public DtmfSender(long j5) {
        this.nativeDtmfSender = j5;
    }

    private void checkDtmfSenderExists() {
        if (this.nativeDtmfSender != 0) {
            return;
        }
        m7.c.p("DtmfSender has been disposed.");
    }

    private static native boolean nativeCanInsertDtmf(long j5);

    private static native int nativeDuration(long j5);

    private static native boolean nativeInsertDtmf(long j5, String str, int i9, int i10);

    private static native int nativeInterToneGap(long j5);

    private static native String nativeTones(long j5);

    public boolean canInsertDtmf() {
        checkDtmfSenderExists();
        return nativeCanInsertDtmf(this.nativeDtmfSender);
    }

    public void dispose() {
        checkDtmfSenderExists();
        JniCommon.nativeReleaseRef(this.nativeDtmfSender);
        this.nativeDtmfSender = 0L;
    }

    public int duration() {
        checkDtmfSenderExists();
        return nativeDuration(this.nativeDtmfSender);
    }

    public boolean insertDtmf(String str, int i9, int i10) {
        checkDtmfSenderExists();
        return nativeInsertDtmf(this.nativeDtmfSender, str, i9, i10);
    }

    public int interToneGap() {
        checkDtmfSenderExists();
        return nativeInterToneGap(this.nativeDtmfSender);
    }

    public String tones() {
        checkDtmfSenderExists();
        return nativeTones(this.nativeDtmfSender);
    }
}
