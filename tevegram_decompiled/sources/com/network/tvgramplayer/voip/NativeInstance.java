package com.network.tvgramplayer.voip;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import b2.h0;
import com.network.tvgramplayer.voip.Instance;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;
import org.webrtc.ContextUtils;
import org.webrtc.VideoSink;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class NativeInstance {
    private static Context applicationContext;
    private AudioLevelsCallback audioLevelsCallback;
    private RequestBroadcastPartCallback cancelRequestBroadcastPartCallback;
    private Instance.FinalState finalState;
    private boolean isGroup;
    private long nativePtr;
    private Instance.OnRemoteMediaStateUpdatedListener onRemoteMediaStateUpdatedListener;
    private Instance.OnSignalBarsUpdatedListener onSignalBarsUpdatedListener;
    private Instance.OnSignalingDataListener onSignalDataListener;
    private Instance.OnStateUpdatedListener onStateUpdatedListener;
    private PayloadCallback payloadCallback;
    private String persistentStateFilePath;
    private RequestBroadcastPartCallback requestBroadcastPartCallback;
    private RequestCurrentTimeCallback requestCurrentTimeCallback;
    private CountDownLatch stopBarrier;
    private float[] temp = new float[1];
    private VideoSourcesCallback unknownParticipantsCallback;

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public interface AudioLevelsCallback {
        void run(int[] iArr, float[] fArr, boolean[] zArr);
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public interface PayloadCallback {
        void run(int i9, String str);
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public interface RequestBroadcastPartCallback {
        void run(long j5, long j9, int i9, int i10);
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public interface RequestCurrentTimeCallback {
        void run(long j5);
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public static class RequestedParticipant {
        public int audioSsrc;
        public long userId;

        public RequestedParticipant(long j5, int i9) {
            this.userId = j5;
            this.audioSsrc = i9;
        }
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public static class SsrcGroup {
        public String semantics;
        public int[] ssrcs;
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public interface VideoSourcesCallback {
        void run(long j5, int[] iArr);
    }

    static {
        try {
            System.loadLibrary("tmessages.49");
        } catch (Exception e9) {
            e9.printStackTrace();
        }
    }

    public static native long createVideoCapturer(VideoSink videoSink, int i9);

    public static native void destroyVideoCapturer(long j5);

    public static native String[] getAllVersions();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAudioLevelsUpdated$1(int[] iArr, float[] fArr, boolean[] zArr) {
        this.audioLevelsCallback.run(iArr, fArr, zArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onNetworkStateUpdated$0(boolean z8, boolean z9) {
        this.onStateUpdatedListener.onStateUpdated(z8 ? 1 : 0, z9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onParticipantDescriptionsRequired$2(long j5, int[] iArr) {
        this.unknownParticipantsCallback.run(j5, iArr);
    }

    public static NativeInstance make(String str, Instance.Config config, String str2, Instance.Endpoint[] endpointArr, Instance.Proxy proxy, int i9, Instance.EncryptionKey encryptionKey, VideoSink videoSink, long j5, AudioLevelsCallback audioLevelsCallback) {
        NativeInstance nativeInstance = new NativeInstance();
        nativeInstance.persistentStateFilePath = str2;
        nativeInstance.audioLevelsCallback = audioLevelsCallback;
        nativeInstance.nativePtr = makeNativeInstance(str, nativeInstance, config, str2, endpointArr, proxy, i9, encryptionKey, videoSink, j5, 0.5f);
        return nativeInstance;
    }

    public static NativeInstance makeGroup(String str, boolean z8, long j5, boolean z9, boolean z10, PayloadCallback payloadCallback, AudioLevelsCallback audioLevelsCallback, VideoSourcesCallback videoSourcesCallback, RequestBroadcastPartCallback requestBroadcastPartCallback, RequestBroadcastPartCallback requestBroadcastPartCallback2, RequestCurrentTimeCallback requestCurrentTimeCallback, boolean z11, boolean z12) {
        Context context = applicationContext;
        if (context != null) {
            ContextUtils.initialize(context);
        }
        NativeInstance nativeInstance = new NativeInstance();
        nativeInstance.payloadCallback = payloadCallback;
        nativeInstance.audioLevelsCallback = audioLevelsCallback;
        nativeInstance.unknownParticipantsCallback = videoSourcesCallback;
        nativeInstance.requestBroadcastPartCallback = requestBroadcastPartCallback;
        nativeInstance.cancelRequestBroadcastPartCallback = requestBroadcastPartCallback2;
        nativeInstance.requestCurrentTimeCallback = requestCurrentTimeCallback;
        nativeInstance.isGroup = true;
        nativeInstance.nativePtr = makeGroupNativeInstance(nativeInstance, str, z8, j5, z9, z10, z11, z12);
        return nativeInstance;
    }

    private static native long makeGroupNativeInstance(NativeInstance nativeInstance, String str, boolean z8, long j5, boolean z9, boolean z10, boolean z11, boolean z12);

    private static native long makeNativeInstance(String str, NativeInstance nativeInstance, Instance.Config config, String str2, Instance.Endpoint[] endpointArr, Instance.Proxy proxy, int i9, Instance.EncryptionKey encryptionKey, VideoSink videoSink, long j5, float f9);

    private void onAudioLevelsUpdated(int[] iArr, float[] fArr, boolean[] zArr) {
        if (this.isGroup && iArr != null && iArr.length == 0) {
            return;
        }
        runOnUIThread(new a(this, iArr, fArr, zArr, 0));
    }

    private void onCancelRequestBroadcastPart(long j5, int i9, int i10) {
        this.cancelRequestBroadcastPartCallback.run(j5, 0L, 0, 0);
    }

    private void onEmitJoinPayload(String str, int i9) {
        try {
            PayloadCallback payloadCallback = this.payloadCallback;
            if (payloadCallback != null) {
                payloadCallback.run(i9, str);
            }
        } catch (Exception e9) {
            VLog.e(e9);
        }
    }

    private void onNetworkStateUpdated(final boolean z8, final boolean z9) {
        Log.i("NativeInstance", "onNetworkStateUpdated: connected=" + z8 + ", inTransition=" + z9);
        if (this.onStateUpdatedListener != null) {
            runOnUIThread(new Runnable() { // from class: com.network.tvgramplayer.voip.b
                @Override // java.lang.Runnable
                public final void run() {
                    NativeInstance.this.lambda$onNetworkStateUpdated$0(z8, z9);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void onParticipantDescriptionsRequired(long j5, int[] iArr) {
        if (this.unknownParticipantsCallback == null) {
            return;
        }
        runOnUIThread(new h0(this, j5, iArr, 1));
    }

    private void onRemoteMediaStateUpdated(int i9, int i10) {
        Instance.OnRemoteMediaStateUpdatedListener onRemoteMediaStateUpdatedListener = this.onRemoteMediaStateUpdatedListener;
        if (onRemoteMediaStateUpdatedListener != null) {
            onRemoteMediaStateUpdatedListener.onMediaStateUpdated(i9, i10);
        }
    }

    private void onRequestBroadcastPart(long j5, long j9, int i9, int i10) {
        try {
            Log.i("TelegramNTgCallsManager", "NativeInstance.onRequestBroadcastPart called: ts=" + j5 + " ch=" + i9);
            RequestBroadcastPartCallback requestBroadcastPartCallback = this.requestBroadcastPartCallback;
            if (requestBroadcastPartCallback != null) {
                requestBroadcastPartCallback.run(j5, j9, i9, i10);
            } else {
                Log.e("TelegramNTgCallsManager", "requestBroadcastPartCallback is NULL");
            }
        } catch (Exception e9) {
            Log.e("TelegramNTgCallsManager", "Error in onRequestBroadcastPart: " + e9.getMessage());
            e9.printStackTrace();
        }
    }

    private void onSignalBarsUpdated(int i9) {
        Instance.OnSignalBarsUpdatedListener onSignalBarsUpdatedListener = this.onSignalBarsUpdatedListener;
        if (onSignalBarsUpdatedListener != null) {
            onSignalBarsUpdatedListener.onSignalBarsUpdated(i9);
        }
    }

    private void onSignalingData(byte[] bArr) {
        Instance.OnSignalingDataListener onSignalingDataListener = this.onSignalDataListener;
        if (onSignalingDataListener != null) {
            onSignalingDataListener.onSignalingData(bArr);
        }
    }

    private void onStateUpdated(int i9) {
        Log.i("NativeInstance", "onStateUpdated: " + i9);
        Instance.OnStateUpdatedListener onStateUpdatedListener = this.onStateUpdatedListener;
        if (onStateUpdatedListener != null) {
            onStateUpdatedListener.onStateUpdated(i9, false);
        }
    }

    private void onStop(Instance.FinalState finalState) {
        this.finalState = finalState;
        CountDownLatch countDownLatch = this.stopBarrier;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    private void requestCurrentTime(long j5) {
        this.requestCurrentTimeCallback.run(j5);
    }

    private void runOnUIThread(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public static void setContext(Context context) {
        applicationContext = context;
        JNIUtilities.context = context;
    }

    public static native void setVideoStateCapturer(long j5, int i9);

    private native void stopGroupNative();

    private native void stopNative();

    public static native void switchCameraCapturer(long j5, boolean z8);

    public native void activateVideoCapturer(long j5);

    public native long addIncomingVideoOutput(int i9, String str, SsrcGroup[] ssrcGroupArr, VideoSink videoSink, long j5);

    public native void clearVideoCapturer();

    public native String getDebugInfo();

    public native String getLastError();

    public int getPeerCapabilities() {
        return 0;
    }

    public native byte[] getPersistentState();

    public native long getPreferredRelayId();

    public native Instance.TrafficStats getTrafficStats();

    public native String getVersion();

    public native boolean hasVideoCapturer();

    public boolean isGroup() {
        return this.isGroup;
    }

    public native void onMediaDescriptionAvailable(long j5, RequestedParticipant[] requestedParticipantArr);

    public native void onRequestTimeComplete(long j5, long j9);

    public native void onSignalingDataReceive(byte[] bArr);

    public native void onStreamPartAvailable(long j5, ByteBuffer byteBuffer, int i9, long j9, int i10, int i11);

    public native void prepareForStream(boolean z8);

    public native void removeIncomingVideoOutput(long j5);

    public native void resetGroupInstance(boolean z8, boolean z9);

    public native void setAudioOutputGainControlEnabled(boolean z8);

    public native void setBufferSize(int i9);

    public native void setConferenceCallId(long j5);

    public native void setEchoCancellationStrength(int i9);

    public native void setGlobalServerConfig(String str);

    public native void setJoinResponsePayload(String str, boolean z8);

    public native void setMuteMicrophone(boolean z8);

    public native void setNetworkType(int i9);

    public native void setNoiseSuppressionEnabled(boolean z8);

    public void setOnRemoteMediaStateUpdatedListener(Instance.OnRemoteMediaStateUpdatedListener onRemoteMediaStateUpdatedListener) {
        this.onRemoteMediaStateUpdatedListener = onRemoteMediaStateUpdatedListener;
    }

    public void setOnSignalBarsUpdatedListener(Instance.OnSignalBarsUpdatedListener onSignalBarsUpdatedListener) {
        this.onSignalBarsUpdatedListener = onSignalBarsUpdatedListener;
    }

    public void setOnSignalDataListener(Instance.OnSignalingDataListener onSignalingDataListener) {
        this.onSignalDataListener = onSignalingDataListener;
    }

    public void setOnStateUpdatedListener(Instance.OnStateUpdatedListener onStateUpdatedListener) {
        this.onStateUpdatedListener = onStateUpdatedListener;
    }

    public native void setProxyUrl(String str);

    public native void setVideoEndpointQuality(String str, int i9);

    public native void setVideoState(int i9);

    public native void setVolume(int i9, double d9);

    public native void setupOutgoingVideo(VideoSink videoSink, int i9);

    public native void setupOutgoingVideoCreated(long j5);

    public Instance.FinalState stop() {
        this.stopBarrier = new CountDownLatch(1);
        stopNative();
        try {
            this.stopBarrier.await();
        } catch (Exception e9) {
            VLog.e(e9);
        }
        return this.finalState;
    }

    public void stopGroup() {
        stopGroupNative();
    }

    public native void switchCamera(boolean z8);
}
