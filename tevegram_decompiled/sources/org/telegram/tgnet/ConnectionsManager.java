package org.telegram.tgnet;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class ConnectionsManager {
    public static int getInitFlags() {
        return 0;
    }

    public static native void native_applyDatacenterAddress(int i9, int i10, String str, int i11);

    public static native void native_applyDnsConfig(int i9, long j5, String str, int i10);

    public static native void native_bindRequestToGuid(int i9, int i10, int i11);

    public static native void native_cancelRequest(int i9, int i10, boolean z8);

    public static native void native_cancelRequestsForGuid(int i9, int i10);

    public static native long native_checkProxy(int i9, String str, int i10, String str2, String str3, String str4, RequestTimeDelegate requestTimeDelegate);

    public static native void native_cleanUp(int i9, boolean z8);

    public static native void native_discardConnection(int i9, int i10, int i11);

    public static native void native_failNotRunningRequest(int i9, int i10);

    public static native int native_getConnectionState(int i9);

    public static native long native_getCurrentAuthKeyId(int i9);

    public static native int native_getCurrentDatacenterId(int i9);

    public static native int native_getCurrentPingTime(int i9);

    public static native int native_getCurrentTime(int i9);

    public static native long native_getCurrentTimeMillis(int i9);

    public static native int native_getTimeDifference(int i9);

    public static native void native_init(int i9, int i10, int i11, int i12, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i13, long j5, boolean z8, boolean z9, boolean z10, int i14, int i15);

    public static native boolean native_isGoodPrime(byte[] bArr, int i9);

    public static native int native_isTestBackend(int i9);

    public static native void native_moveDatacenter(int i9, int i10);

    public static native void native_onHostNameResolved(String str, long j5, String str2);

    public static native void native_pauseNetwork(int i9);

    public static native void native_receivedCaptchaResult(int i9, int[] iArr, String str);

    public static native void native_receivedIntegrityCheckClassic(int i9, int i10, String str, String str2);

    public static native void native_resumeNetwork(int i9, boolean z8);

    public static native void native_sendRequest(int i9, long j5, int i10, int i11, int i12, boolean z8, int i13);

    public static native void native_setIpStrategy(int i9, byte b9);

    public static native void native_setJava(boolean z8);

    public static native void native_setLangCode(int i9, String str);

    public static native void native_setNetworkAvailable(int i9, boolean z8, int i10, boolean z9);

    public static native void native_setProxySettings(int i9, String str, int i10, String str2, String str3, String str4);

    public static native void native_setPushConnectionEnabled(int i9, boolean z8);

    public static native void native_setRegId(int i9, String str);

    public static native void native_setSystemLangCode(int i9, String str);

    public static native void native_setUserId(int i9, long j5);

    public static native void native_switchBackend(int i9, boolean z8);

    public static native void native_updateDcSettings(int i9);

    public static void onProxyError() {
    }

    public static void onInternalPushReceived(int i9) {
    }

    public static void onLogout(int i9) {
    }

    public static void onSessionCreated(int i9) {
    }

    public static void onUpdate(int i9) {
    }

    public static void getHostByName(String str, long j5) {
    }

    public static void onConnectionStateChanged(int i9, int i10) {
    }

    public static void onRequestNewServerIpAndPort(int i9, int i10) {
    }

    public static void onRequestQuickAck(int i9, int i10) {
    }

    public static void onRequestWriteToSocket(int i9, int i10) {
    }

    public static void onUpdateConfig(long j5, int i9) {
    }

    public static void onBytesReceived(int i9, int i10, int i11) {
    }

    public static void onBytesSent(int i9, int i10, int i11) {
    }

    public static void onPremiumFloodWait(int i9, int i10, boolean z8) {
    }

    public static void onRequestClear(int i9, int i10, boolean z8) {
    }

    public static void onUnparsedMessageReceived(long j5, int i9, long j9) {
    }

    public static void onCaptchaCheck(int i9, int i10, String str, String str2) {
    }

    public static void onIntegrityCheckClassic(int i9, int i10, String str, String str2) {
    }

    public static void onRequestComplete(int i9, int i10, long j5, int i11, String str, int i12, long j9, long j10, int i13) {
    }
}
