package com.network.tvgramplayer.player;

import android.media.AudioTrack;
import android.util.Log;
import android.view.Surface;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class RawPlayerJNI {
    public static final RawPlayerJNI INSTANCE = new RawPlayerJNI();
    private static final String TAG = "RawPlayerJNI";

    static {
        try {
            System.loadLibrary("tmessages.49");
            Log.i(TAG, "✅ Native library tmessages.49 loaded successfully");
        } catch (Exception e9) {
            Log.e(TAG, "❌ Failed to load native library tmessages.49", e9);
        }
    }

    private RawPlayerJNI() {
    }

    public final native void nativeFeedData(long j5, boolean z8, byte[] bArr, long j9);

    public final native void nativeFeedDataPull(long j5, boolean z8, byte[] bArr, long j9);

    public final native void nativeFlush(long j5);

    public final native void nativeFlushPull(long j5);

    public final native long nativeInit(Surface surface);

    public final native long nativeInitPull(Surface surface);

    public final native boolean nativePing(long j5);

    public final native boolean nativePingPull(long j5);

    public final native void nativeRelease(long j5);

    public final native void nativeReleasePull(long j5);

    public final native void nativeSetAdaptiveBufferEnabledPull(long j5, boolean z8);

    public final native void nativeSetAudioOffset(long j5, int i9);

    public final native void nativeSetAudioTrack(long j5, AudioTrack audioTrack);

    public final native void nativeSetAudioTrackPull(long j5, AudioTrack audioTrack);

    public final native void nativeSetMultithreaded(long j5, boolean z8);

    public final native void nativeSetMultithreadedPull(long j5, boolean z8);

    public final native void nativeSetPlayerModePull(long j5, int i9);

    public final native void nativeSetSmartSyncEnabled(long j5, boolean z8);

    public final native void nativeSetSmartSyncEnabledPull(long j5, boolean z8);

    public final native void nativeSetSyncMode(long j5, int i9);

    public final native void nativeSetSyncModePull(long j5, int i9);

    public final native void nativeSetSyncSettingsPull(long j5, int i9, int i10, int i11, boolean z8);

    public final native void nativeSetSyncThreadEnabled(long j5, boolean z8);

    public final native void nativeSetSyncThreadEnabledPull(long j5, boolean z8);
}
