package org.webrtc.audio;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.util.Log;
import androidx.activity.g;
import org.webrtc.CalledByNative;
import org.webrtc.ContextUtils;
import org.webrtc.Logging;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class WebRtcAudioManager {
    private static final int BITS_PER_SAMPLE = 16;
    private static final int DEFAULT_FRAME_PER_BUFFER = 256;
    private static final int DEFAULT_SAMPLE_RATE_HZ = 16000;
    private static final String TAG = "WebRtcAudioManagerExternal";
    private boolean initialized = false;
    private long nativeAudioManager;

    static {
        Logging.d(TAG, "WebRtcAudioManager loaded");
        Log.d(TAG, "WebRtcAudioManager loaded (static)");
    }

    @CalledByNative
    public WebRtcAudioManager(long j5) {
        Logging.d(TAG, "WebRtcAudioManager ctor, nativeAudioManager=" + j5);
        Log.d(TAG, "WebRtcAudioManager ctor (Log.d), nativeAudioManager=" + j5);
        this.nativeAudioManager = j5;
    }

    @CalledByNative
    public static AudioManager getAudioManager(Context context) {
        return (AudioManager) context.getSystemService("audio");
    }

    @CalledByNative
    public static int getInputBufferSize(Context context, AudioManager audioManager, int i9, int i10) {
        return isLowLatencyInputSupported(context) ? getLowLatencyFramesPerBuffer(audioManager) : getMinInputFrameSize(i9, i10);
    }

    private static int getLowLatencyFramesPerBuffer(AudioManager audioManager) {
        String property = audioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER");
        return property == null ? DEFAULT_FRAME_PER_BUFFER : Integer.parseInt(property);
    }

    private static int getMinInputFrameSize(int i9, int i10) {
        return AudioRecord.getMinBufferSize(i9, i10 == 1 ? 16 : 12, 2) / (i10 * 2);
    }

    private static int getMinOutputFrameSize(int i9, int i10) {
        return AudioTrack.getMinBufferSize(i9, i10 == 1 ? 4 : 12, 2) / (i10 * 2);
    }

    @CalledByNative
    public static int getOutputBufferSize(Context context, AudioManager audioManager, int i9, int i10) {
        return isLowLatencyOutputSupported(context) ? getLowLatencyFramesPerBuffer(audioManager) : getMinOutputFrameSize(i9, i10);
    }

    @CalledByNative
    public static int getSampleRate(AudioManager audioManager) {
        if (WebRtcAudioUtils.runningOnEmulator()) {
            Logging.d(TAG, "Running emulator, overriding sample rate to 8 kHz.");
            return 8000;
        }
        int sampleRateForApiLevel = getSampleRateForApiLevel(audioManager);
        Logging.d(TAG, "Sample rate is set to " + sampleRateForApiLevel + " Hz");
        return sampleRateForApiLevel;
    }

    private static int getSampleRateForApiLevel(AudioManager audioManager) {
        String property = audioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
        return property == null ? DEFAULT_SAMPLE_RATE_HZ : Integer.parseInt(property);
    }

    @CalledByNative
    public static boolean isLowLatencyInputSupported(Context context) {
        return isLowLatencyOutputSupported(context);
    }

    @CalledByNative
    public static boolean isLowLatencyOutputSupported(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
    }

    private native void nativeCacheAudioParameters(int i9, int i10, int i11, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, int i12, int i13, long j5);

    @CalledByNative
    public void dispose() {
        g.y(new StringBuilder("dispose"), WebRtcAudioUtils.getThreadInfo(), TAG);
        this.initialized = false;
    }

    @CalledByNative
    public boolean init() {
        String str;
        Logging.d(TAG, "init" + WebRtcAudioUtils.getThreadInfo());
        Log.d(TAG, "init (Log.d) " + WebRtcAudioUtils.getThreadInfo());
        if (this.initialized) {
            Logging.d(TAG, "Already initialized");
            Log.d(TAG, "Already initialized (Log.d)");
            return true;
        }
        try {
            Context applicationContext = ContextUtils.getApplicationContext();
            if (applicationContext == null) {
                Logging.e(TAG, "Context is null in init!");
                Log.e(TAG, "Context is null in init! (Log.d)");
                return false;
            }
            AudioManager audioManager = getAudioManager(applicationContext);
            int sampleRate = getSampleRate(audioManager);
            int outputBufferSize = getOutputBufferSize(applicationContext, audioManager, sampleRate, 2);
            int inputBufferSize = getInputBufferSize(applicationContext, audioManager, sampleRate, 1);
            Logging.d(TAG, "Calling nativeCacheAudioParameters with sampleRate=" + sampleRate + " outputBufferSize=" + outputBufferSize + " inputBufferSize=" + inputBufferSize);
            StringBuilder sb = new StringBuilder("Calling nativeCacheAudioParameters (Log.d) with sampleRate=");
            sb.append(sampleRate);
            Log.d(TAG, sb.toString());
            try {
                nativeCacheAudioParameters(sampleRate, 2, 1, false, false, false, isLowLatencyOutputSupported(applicationContext), isLowLatencyInputSupported(applicationContext), false, false, outputBufferSize, inputBufferSize, this.nativeAudioManager);
                this.initialized = true;
                str = TAG;
            } catch (Exception e9) {
                e = e9;
                str = TAG;
            }
            try {
                Logging.d(str, "init done");
                Log.d(str, "init done (Log.d)");
                return true;
            } catch (Exception e10) {
                e = e10;
                Logging.e(str, "Exception in init: " + e.getMessage());
                Log.e(str, "Exception in init (Log.d): " + e.getMessage());
                e.printStackTrace();
                return false;
            }
        } catch (Exception e11) {
            e = e11;
            str = TAG;
        }
    }

    @CalledByNative
    public boolean isCommunicationModeEnabled() {
        Context applicationContext = ContextUtils.getApplicationContext();
        return applicationContext != null && getAudioManager(applicationContext).getMode() == 3;
    }

    @CalledByNative
    public boolean isDeviceBlacklistedForOpenSLESUsage() {
        return false;
    }
}
