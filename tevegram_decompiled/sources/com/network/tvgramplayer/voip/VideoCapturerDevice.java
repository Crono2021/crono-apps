package com.network.tvgramplayer.voip;

import android.util.Log;
import org.webrtc.CapturerObserver;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class VideoCapturerDevice {
    private static final String TAG = "VideoCapturerDevice";
    private long nativePtr;

    public VideoCapturerDevice(boolean z8) {
        Log.d(TAG, "VideoCapturerDevice created, screencast=" + z8);
    }

    private void init(long j5, String str) {
        Log.d(TAG, "init: ptr=" + j5 + ", deviceId=" + str);
        this.nativePtr = j5;
    }

    private static native CapturerObserver nativeGetJavaVideoCapturerObserver(long j5);

    private void onAspectRatioRequested(float f9) {
        Log.d(TAG, "onAspectRatioRequested: aspectRatio=" + f9);
    }

    private void onDestroy() {
        Log.d(TAG, "onDestroy");
        this.nativePtr = 0L;
    }

    private void onStateChanged(long j5, int i9) {
        Log.d(TAG, "onStateChanged: ptr=" + j5 + ", state=" + i9);
    }
}
