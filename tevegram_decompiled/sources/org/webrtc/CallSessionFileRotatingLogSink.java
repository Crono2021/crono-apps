package org.webrtc;

import org.webrtc.Logging;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class CallSessionFileRotatingLogSink {
    private long nativeSink;

    public CallSessionFileRotatingLogSink(String str, int i9, Logging.Severity severity) {
        if (str != null) {
            this.nativeSink = nativeAddSink(str, i9, severity.ordinal());
        } else {
            m7.c.n("dirPath may not be null.");
            throw null;
        }
    }

    public static byte[] getLogData(String str) {
        if (str != null) {
            return nativeGetLogData(str);
        }
        m7.c.n("dirPath may not be null.");
        return null;
    }

    private static native long nativeAddSink(String str, int i9, int i10);

    private static native void nativeDeleteSink(long j5);

    private static native byte[] nativeGetLogData(String str);

    public void dispose() {
        long j5 = this.nativeSink;
        if (j5 != 0) {
            nativeDeleteSink(j5);
            this.nativeSink = 0L;
        }
    }
}
