package com.network.tvgramplayer.voip;

import android.content.Context;
import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.NoiseSuppressor;
import android.os.SystemClock;
import java.io.File;
import m7.c;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class VoIPController {
    public static final int DATA_SAVING_ALWAYS = 2;
    public static final int DATA_SAVING_MOBILE = 1;
    public static final int DATA_SAVING_NEVER = 0;
    public static final int DATA_SAVING_ROAMING = 3;
    public static final int ERROR_AUDIO_IO = 3;
    public static final int ERROR_CONNECTION_SERVICE = -5;
    public static final int ERROR_INCOMPATIBLE = 1;
    public static final int ERROR_INSECURE_UPGRADE = -4;
    public static final int ERROR_LOCALIZED = -3;
    public static final int ERROR_PEER_OUTDATED = -1;
    public static final int ERROR_PRIVACY = -2;
    public static final int ERROR_TIMEOUT = 2;
    public static final int ERROR_UNKNOWN = 0;
    public static final int NET_TYPE_3G = 3;
    public static final int NET_TYPE_DIALUP = 10;
    public static final int NET_TYPE_EDGE = 2;
    public static final int NET_TYPE_ETHERNET = 7;
    public static final int NET_TYPE_GPRS = 1;
    public static final int NET_TYPE_HSPA = 4;
    public static final int NET_TYPE_LTE = 5;
    public static final int NET_TYPE_OTHER_HIGH_SPEED = 8;
    public static final int NET_TYPE_OTHER_LOW_SPEED = 9;
    public static final int NET_TYPE_OTHER_MOBILE = 11;
    public static final int NET_TYPE_UNKNOWN = 0;
    public static final int NET_TYPE_WIFI = 6;
    public static final int STATE_ESTABLISHED = 3;
    public static final int STATE_FAILED = 4;
    public static final int STATE_RECONNECTING = 5;
    public static final int STATE_WAIT_INIT = 1;
    public static final int STATE_WAIT_INIT_ACK = 2;
    protected long callStartTime;
    private Context context;
    protected ConnectionStateListener listener;
    protected long nativeInst;

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public interface ConnectionStateListener {
        void onConnectionStateChanged(int i9, boolean z8);

        void onSignalBarCountChanged(int i9);
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public static class Stats {
        public long bytesRecvdMobile;
        public long bytesRecvdWifi;
        public long bytesSentMobile;
        public long bytesSentWifi;

        public String toString() {
            return "Stats{bytesRecvdMobile=" + this.bytesRecvdMobile + ", bytesSentWifi=" + this.bytesSentWifi + ", bytesRecvdWifi=" + this.bytesRecvdWifi + ", bytesSentMobile=" + this.bytesSentMobile + '}';
        }
    }

    public VoIPController(Context context) {
        this.context = context;
        this.nativeInst = nativeInit(new File(context.getFilesDir(), "voip_persistent_state.json").getAbsolutePath());
    }

    public static native int getConnectionMaxLayer();

    private String getLogFilePath(long j5) {
        File file = new File(this.context.getExternalFilesDir(null), "logs");
        file.mkdirs();
        return new File(file, j5 + ".log").getAbsolutePath();
    }

    public static String getVersion() {
        return nativeGetVersion();
    }

    private void handleSignalBarsChange(int i9) {
        ConnectionStateListener connectionStateListener = this.listener;
        if (connectionStateListener != null) {
            connectionStateListener.onSignalBarCountChanged(i9);
        }
    }

    private void handleStateChange(int i9) {
        if (i9 == 3 && this.callStartTime == 0) {
            this.callStartTime = SystemClock.elapsedRealtime();
        }
        ConnectionStateListener connectionStateListener = this.listener;
        if (connectionStateListener != null) {
            connectionStateListener.onConnectionStateChanged(i9, false);
        }
    }

    private native void nativeConnect(long j5);

    private native void nativeDebugCtl(long j5, int i9, int i10);

    private native String nativeGetDebugLog(long j5);

    private native String nativeGetDebugString(long j5);

    private native int nativeGetLastError(long j5);

    private native int nativeGetPeerCapabilities(long j5);

    private native long nativeGetPreferredRelayID(long j5);

    private native void nativeGetStats(long j5, Stats stats);

    private static native String nativeGetVersion();

    private native long nativeInit(String str);

    private static native boolean nativeNeedRate(long j5);

    private native void nativeRelease(long j5);

    private native void nativeRequestCallUpgrade(long j5);

    private native void nativeSetAudioOutputGainControlEnabled(long j5, boolean z8);

    private native void nativeSetConfig(long j5, double d9, double d10, int i9, boolean z8, boolean z9, boolean z10, String str, String str2, boolean z11);

    private native void nativeSetEchoCancellationStrength(long j5, int i9);

    private native void nativeSetEncryptionKey(long j5, byte[] bArr, boolean z8);

    private native void nativeSetMicMute(long j5, boolean z8);

    private static native void nativeSetNativeBufferSize(int i9);

    private native void nativeSetNetworkType(long j5, int i9);

    private native void nativeSetProxy(long j5, String str, int i9, String str2, String str3);

    private native void nativeStart(long j5);

    public static void setNativeBufferSize(int i9) {
        nativeSetNativeBufferSize(i9);
    }

    public void connect() {
        ensureNativeInstance();
        nativeConnect(this.nativeInst);
    }

    public void debugCtl(int i9, int i10) {
        ensureNativeInstance();
        nativeDebugCtl(this.nativeInst, i9, i10);
    }

    public void ensureNativeInstance() {
        if (this.nativeInst != 0) {
            return;
        }
        c.p("Native instance is not valid");
    }

    public long getCallDuration() {
        return SystemClock.elapsedRealtime() - this.callStartTime;
    }

    public String getDebugLog() {
        ensureNativeInstance();
        return nativeGetDebugLog(this.nativeInst);
    }

    public String getDebugString() {
        ensureNativeInstance();
        return nativeGetDebugString(this.nativeInst);
    }

    public int getLastError() {
        ensureNativeInstance();
        return nativeGetLastError(this.nativeInst);
    }

    public int getPeerCapabilities() {
        ensureNativeInstance();
        return nativeGetPeerCapabilities(this.nativeInst);
    }

    public long getPreferredRelayID() {
        ensureNativeInstance();
        return nativeGetPreferredRelayID(this.nativeInst);
    }

    public void getStats(Stats stats) {
        ensureNativeInstance();
        if (stats != null) {
            nativeGetStats(this.nativeInst, stats);
        } else {
            c.o("You're not supposed to pass null here");
        }
    }

    public boolean needRate() {
        ensureNativeInstance();
        return nativeNeedRate(this.nativeInst);
    }

    public void release() {
        ensureNativeInstance();
        nativeRelease(this.nativeInst);
        this.nativeInst = 0L;
    }

    public void requestCallUpgrade() {
        ensureNativeInstance();
        nativeRequestCallUpgrade(this.nativeInst);
    }

    public void setAudioOutputGainControlEnabled(boolean z8) {
        ensureNativeInstance();
        nativeSetAudioOutputGainControlEnabled(this.nativeInst, z8);
    }

    public void setConfig(double d9, double d10, int i9, long j5) {
        boolean z8;
        ensureNativeInstance();
        boolean z9 = false;
        try {
            z8 = AcousticEchoCanceler.isAvailable();
            try {
                z9 = NoiseSuppressor.isAvailable();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            z8 = false;
        }
        nativeSetConfig(this.nativeInst, d9, d10, i9, !z8, !z9, true, getLogFilePath(j5), null, false);
    }

    public void setConnectionStateListener(ConnectionStateListener connectionStateListener) {
        this.listener = connectionStateListener;
    }

    public void setEchoCancellationStrength(int i9) {
        ensureNativeInstance();
        nativeSetEchoCancellationStrength(this.nativeInst, i9);
    }

    public void setEncryptionKey(byte[] bArr, boolean z8) {
        if (bArr.length != 256) {
            androidx.fragment.app.a.d(bArr.length, "key length must be exactly 256 bytes but is ");
        } else {
            ensureNativeInstance();
            nativeSetEncryptionKey(this.nativeInst, bArr, z8);
        }
    }

    public void setMicMute(boolean z8) {
        ensureNativeInstance();
        nativeSetMicMute(this.nativeInst, z8);
    }

    public void setNetworkType(int i9) {
        ensureNativeInstance();
        nativeSetNetworkType(this.nativeInst, i9);
    }

    public void setProxy(String str, int i9, String str2, String str3) {
        ensureNativeInstance();
        if (str != null) {
            nativeSetProxy(this.nativeInst, str, i9, str2, str3);
        } else {
            c.o("address can't be null");
        }
    }

    public void start() {
        ensureNativeInstance();
        nativeStart(this.nativeInst);
    }
}
