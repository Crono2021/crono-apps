package org.webrtc.voiceengine;

import android.annotation.TargetApi;
import android.media.AudioFormat;
import android.media.AudioPlaybackCaptureConfiguration;
import android.media.AudioRecord;
import android.media.projection.MediaProjection;
import android.os.Build;
import android.os.Process;
import androidx.activity.g;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import m7.c;
import n1.e0;
import o5.i;
import org.telegram.messenger.FileLog;
import org.webrtc.Logging;
import org.webrtc.ThreadUtils;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class WebRtcAudioRecord {
    private static final long AUDIO_RECORD_THREAD_JOIN_TIMEOUT_MS = 2000;
    private static final int BITS_PER_SAMPLE = 16;
    private static final int BUFFERS_PER_SECOND = 100;
    private static final int BUFFER_SIZE_FACTOR = 2;
    private static final int CALLBACK_BUFFER_SIZE_MS = 10;
    private static final int DEFAULT_AUDIO_SOURCE;
    public static WebRtcAudioRecord Instance = null;
    private static final String TAG = "WebRtcAudioRecord";
    private static WebRtcAudioRecordSamplesReadyCallback audioSamplesReadyCallback;
    private static int audioSource;
    private static WebRtcAudioRecordErrorCallback errorCallback;
    private static volatile boolean microphoneMute;
    private AudioRecord audioRecord;
    private AudioRecordThread audioThread;
    private ByteBuffer byteBuffer;
    private int captureType;
    private AudioRecord deviceAudioRecord;
    private ByteBuffer deviceByteBuffer;
    private WebRtcAudioEffects effects;
    private byte[] emptyBytes;
    private final long nativeAudioRecord;
    private int requestedSampleRate = 48000;
    private int requestedChannels = 1;

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public enum AudioRecordStartErrorCode {
        AUDIO_RECORD_START_EXCEPTION,
        AUDIO_RECORD_START_STATE_MISMATCH
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public class AudioRecordThread extends Thread {
        private volatile boolean keepAlive;

        public AudioRecordThread(String str) {
            super(str);
            this.keepAlive = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            WebRtcAudioRecord webRtcAudioRecord;
            Process.setThreadPriority(-19);
            Logging.d(WebRtcAudioRecord.TAG, "AudioRecordThread" + WebRtcAudioUtils.getThreadInfo());
            System.nanoTime();
            while (true) {
                boolean z8 = this.keepAlive;
                webRtcAudioRecord = WebRtcAudioRecord.this;
                if (!z8) {
                    try {
                        break;
                    } catch (IllegalStateException e9) {
                        Logging.e(WebRtcAudioRecord.TAG, "AudioRecord.stop failed: " + e9.getMessage());
                        return;
                    }
                }
                int read = webRtcAudioRecord.audioRecord.read(WebRtcAudioRecord.this.byteBuffer, WebRtcAudioRecord.this.byteBuffer.capacity());
                int i9 = 0;
                int read2 = WebRtcAudioRecord.this.deviceAudioRecord != null ? WebRtcAudioRecord.this.deviceAudioRecord.read(WebRtcAudioRecord.this.deviceByteBuffer, WebRtcAudioRecord.this.deviceByteBuffer.capacity()) : 0;
                if (read == WebRtcAudioRecord.this.byteBuffer.capacity()) {
                    if (WebRtcAudioRecord.microphoneMute) {
                        WebRtcAudioRecord.this.byteBuffer.clear();
                        WebRtcAudioRecord.this.byteBuffer.put(WebRtcAudioRecord.this.emptyBytes);
                    }
                    if (read == read2) {
                        WebRtcAudioRecord.this.deviceByteBuffer.position(0);
                        WebRtcAudioRecord.this.byteBuffer.position(0);
                        for (int i10 = 0; i10 < read / 2; i10++) {
                            int i11 = i10 * 2;
                            int i12 = (WebRtcAudioRecord.this.deviceByteBuffer.getShort(i11) / 10) + WebRtcAudioRecord.this.byteBuffer.getShort(i11);
                            if (i12 > 32767) {
                                i12 = 32767;
                            }
                            if (i12 < -32768) {
                                i12 = -32768;
                            }
                            WebRtcAudioRecord.this.byteBuffer.putShort(i11, (short) i12);
                        }
                    }
                    if (this.keepAlive) {
                        try {
                            WebRtcAudioRecord webRtcAudioRecord2 = WebRtcAudioRecord.this;
                            webRtcAudioRecord2.nativeDataIsRecorded(read, webRtcAudioRecord2.nativeAudioRecord);
                        } catch (UnsatisfiedLinkError e10) {
                            FileLog.e(e10);
                            this.keepAlive = false;
                        }
                    }
                    if (WebRtcAudioRecord.audioSamplesReadyCallback != null) {
                        WebRtcAudioRecord.audioSamplesReadyCallback.onWebRtcAudioRecordSamplesReady(new AudioSamples(WebRtcAudioRecord.this.audioRecord, Arrays.copyOf(WebRtcAudioRecord.this.byteBuffer.array(), WebRtcAudioRecord.this.byteBuffer.capacity()), i9));
                    }
                } else {
                    String str = "AudioRecord.read failed: " + read;
                    Logging.e(WebRtcAudioRecord.TAG, str);
                    if (read == -3) {
                        this.keepAlive = false;
                        WebRtcAudioRecord.this.reportWebRtcAudioRecordError(str);
                    }
                }
            }
            if (webRtcAudioRecord.audioRecord != null) {
                WebRtcAudioRecord.this.audioRecord.stop();
            }
        }

        public void stopThread() {
            Logging.d(WebRtcAudioRecord.TAG, "stopThread");
            this.keepAlive = false;
        }
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public interface WebRtcAudioRecordErrorCallback {
        void onWebRtcAudioRecordError(String str);

        void onWebRtcAudioRecordInitError(String str);

        void onWebRtcAudioRecordStartError(AudioRecordStartErrorCode audioRecordStartErrorCode, String str);
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public interface WebRtcAudioRecordSamplesReadyCallback {
        void onWebRtcAudioRecordSamplesReady(AudioSamples audioSamples);
    }

    static {
        int defaultAudioSource = getDefaultAudioSource();
        DEFAULT_AUDIO_SOURCE = defaultAudioSource;
        audioSource = defaultAudioSource;
    }

    public WebRtcAudioRecord(long j5, int i9) {
        Logging.d(TAG, "ctor" + WebRtcAudioUtils.getThreadInfo());
        this.nativeAudioRecord = j5;
        this.effects = WebRtcAudioEffects.create();
        this.captureType = i9;
        if (i9 == 2 && Instance == null) {
            Instance = this;
        }
    }

    private static void assertTrue(boolean z8) {
        if (z8) {
            return;
        }
        c.e("Expected condition to be true");
    }

    private int channelCountToConfiguration(int i9) {
        return i9 == 1 ? 16 : 12;
    }

    private boolean enableBuiltInAEC(boolean z8) {
        Logging.d(TAG, "enableBuiltInAEC(" + z8 + ')');
        WebRtcAudioEffects webRtcAudioEffects = this.effects;
        if (webRtcAudioEffects != null) {
            return webRtcAudioEffects.setAEC(z8);
        }
        Logging.e(TAG, "Built-in AEC is not supported on this platform");
        return false;
    }

    private boolean enableBuiltInNS(boolean z8) {
        Logging.d(TAG, "enableBuiltInNS(" + z8 + ')');
        WebRtcAudioEffects webRtcAudioEffects = this.effects;
        if (webRtcAudioEffects != null) {
            return webRtcAudioEffects.setNS(z8);
        }
        Logging.e(TAG, "Built-in NS is not supported on this platform");
        return false;
    }

    private static int getDefaultAudioSource() {
        return 7;
    }

    private int initRecording(int i9, int i10) {
        WebRtcAudioEffects webRtcAudioEffects;
        if (this.captureType == 1 && Build.VERSION.SDK_INT < 29) {
            return -1;
        }
        this.requestedSampleRate = i9;
        this.requestedChannels = i10;
        Logging.d(TAG, "initRecording(sampleRate=" + i9 + ", channels=" + i10 + ")");
        if (this.audioRecord != null) {
            reportWebRtcAudioRecordInitError("InitRecording called twice without StopRecording.");
            return -1;
        }
        int i11 = i9 / 100;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i10 * 2 * i11);
        this.byteBuffer = allocateDirect;
        allocateDirect.order(ByteOrder.nativeOrder());
        Logging.d(TAG, "byteBuffer.capacity: " + this.byteBuffer.capacity());
        this.emptyBytes = new byte[this.byteBuffer.capacity()];
        nativeCacheDirectBufferAddress(this.byteBuffer, this.nativeAudioRecord);
        int channelCountToConfiguration = channelCountToConfiguration(i10);
        int minBufferSize = AudioRecord.getMinBufferSize(i9, channelCountToConfiguration, 2);
        if (minBufferSize == -1 || minBufferSize == -2) {
            reportWebRtcAudioRecordInitError(g.m(minBufferSize, "AudioRecord.getMinBufferSize failed: "));
            return -1;
        }
        Logging.d(TAG, "AudioRecord.getMinBufferSize: " + minBufferSize);
        int max = Math.max(minBufferSize * 2, this.byteBuffer.capacity());
        Logging.d(TAG, "bufferSizeInBytes: " + max);
        if (this.captureType != 1) {
            try {
                this.audioRecord = new AudioRecord(audioSource, i9, channelCountToConfiguration, 2, max);
            } catch (IllegalArgumentException e9) {
                reportWebRtcAudioRecordInitError("AudioRecord ctor error: " + e9.getMessage());
                releaseAudioResources(false);
                return -1;
            }
        } else if (Build.VERSION.SDK_INT >= 29) {
            return -1;
        }
        AudioRecord audioRecord = this.audioRecord;
        if (audioRecord == null || audioRecord.getState() != 1) {
            reportWebRtcAudioRecordInitError("Failed to create a new AudioRecord instance");
            releaseAudioResources(false);
            return -1;
        }
        if (this.captureType == 0 && (webRtcAudioEffects = this.effects) != null) {
            webRtcAudioEffects.enable(this.audioRecord.getAudioSessionId());
        }
        logMainParameters();
        logMainParametersExtended();
        return i11;
    }

    private void logMainParameters() {
        Logging.d(TAG, "AudioRecord: session ID: " + this.audioRecord.getAudioSessionId() + ", channels: " + this.audioRecord.getChannelCount() + ", sample rate: " + this.audioRecord.getSampleRate());
    }

    private void logMainParametersExtended() {
        int bufferSizeInFrames;
        if (Build.VERSION.SDK_INT >= 23) {
            StringBuilder sb = new StringBuilder("AudioRecord: buffer size in frames: ");
            bufferSizeInFrames = this.audioRecord.getBufferSizeInFrames();
            sb.append(bufferSizeInFrames);
            Logging.d(TAG, sb.toString());
        }
    }

    private native void nativeCacheDirectBufferAddress(ByteBuffer byteBuffer, long j5);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeDataIsRecorded(int i9, long j5);

    private void onDestroy() {
        stopDeviceAudioRecord();
        if (Instance == this) {
            Instance = null;
        }
    }

    private void releaseAudioResources(boolean z8) {
        Logging.d(TAG, "releaseAudioResources " + z8);
        if (z8) {
            AudioRecord audioRecord = this.deviceAudioRecord;
            if (audioRecord != null) {
                audioRecord.release();
                this.deviceAudioRecord = null;
                return;
            }
            return;
        }
        AudioRecord audioRecord2 = this.audioRecord;
        if (audioRecord2 != null) {
            audioRecord2.release();
            this.audioRecord = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportWebRtcAudioRecordError(String str) {
        Logging.e(TAG, "Run-time recording error: " + str);
        WebRtcAudioUtils.logAudioState(TAG);
        WebRtcAudioRecordErrorCallback webRtcAudioRecordErrorCallback = errorCallback;
        if (webRtcAudioRecordErrorCallback != null) {
            webRtcAudioRecordErrorCallback.onWebRtcAudioRecordError(str);
        }
    }

    private void reportWebRtcAudioRecordInitError(String str) {
        Logging.e(TAG, "Init recording error: " + str);
        WebRtcAudioUtils.logAudioState(TAG);
        WebRtcAudioRecordErrorCallback webRtcAudioRecordErrorCallback = errorCallback;
        if (webRtcAudioRecordErrorCallback != null) {
            webRtcAudioRecordErrorCallback.onWebRtcAudioRecordInitError(str);
        }
    }

    private void reportWebRtcAudioRecordStartError(AudioRecordStartErrorCode audioRecordStartErrorCode, String str) {
        Logging.e(TAG, "Start recording error: " + audioRecordStartErrorCode + ". " + str);
        WebRtcAudioUtils.logAudioState(TAG);
        WebRtcAudioRecordErrorCallback webRtcAudioRecordErrorCallback = errorCallback;
        if (webRtcAudioRecordErrorCallback != null) {
            webRtcAudioRecordErrorCallback.onWebRtcAudioRecordStartError(audioRecordStartErrorCode, str);
        }
    }

    public static synchronized void setAudioSource(int i9) {
        synchronized (WebRtcAudioRecord.class) {
            Logging.w(TAG, "Audio source is changed from: " + audioSource + " to " + i9);
            audioSource = i9;
        }
    }

    public static void setErrorCallback(WebRtcAudioRecordErrorCallback webRtcAudioRecordErrorCallback) {
        Logging.d(TAG, "Set error callback");
        errorCallback = webRtcAudioRecordErrorCallback;
    }

    public static void setMicrophoneMute(boolean z8) {
        Logging.w(TAG, "setMicrophoneMute(" + z8 + ")");
        microphoneMute = z8;
    }

    public static void setOnAudioSamplesReady(WebRtcAudioRecordSamplesReadyCallback webRtcAudioRecordSamplesReadyCallback) {
        audioSamplesReadyCallback = webRtcAudioRecordSamplesReadyCallback;
    }

    private boolean startRecording() {
        Logging.d(TAG, "startRecording");
        assertTrue(this.audioRecord != null);
        assertTrue(this.audioThread == null);
        try {
            this.audioRecord.startRecording();
            if (this.audioRecord.getRecordingState() == 3) {
                AudioRecordThread audioRecordThread = new AudioRecordThread("AudioRecordJavaThread");
                this.audioThread = audioRecordThread;
                audioRecordThread.start();
                return true;
            }
            reportWebRtcAudioRecordStartError(AudioRecordStartErrorCode.AUDIO_RECORD_START_STATE_MISMATCH, "AudioRecord.startRecording failed - incorrect state :" + this.audioRecord.getRecordingState());
            return false;
        } catch (IllegalStateException e9) {
            reportWebRtcAudioRecordStartError(AudioRecordStartErrorCode.AUDIO_RECORD_START_EXCEPTION, "AudioRecord.startRecording failed: " + e9.getMessage());
            return false;
        }
    }

    private boolean stopRecording() {
        Logging.d(TAG, "stopRecording");
        assertTrue(this.audioThread != null);
        this.audioThread.stopThread();
        if (!ThreadUtils.joinUninterruptibly(this.audioThread, AUDIO_RECORD_THREAD_JOIN_TIMEOUT_MS)) {
            Logging.e(TAG, "Join of AudioRecordJavaThread timed out");
            WebRtcAudioUtils.logAudioState(TAG);
        }
        this.audioThread = null;
        WebRtcAudioEffects webRtcAudioEffects = this.effects;
        if (webRtcAudioEffects != null) {
            webRtcAudioEffects.release();
        }
        try {
            this.audioRecord.stop();
        } catch (Throwable th) {
            FileLog.e(th);
        }
        releaseAudioResources(false);
        return true;
    }

    @TargetApi(29)
    public void initDeviceAudioRecord(MediaProjection mediaProjection) {
        AudioPlaybackCaptureConfiguration build;
        AudioRecord build2;
        if (Build.VERSION.SDK_INT < 29) {
            return;
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect((this.requestedSampleRate / 100) * this.requestedChannels * 2);
        this.deviceByteBuffer = allocateDirect;
        allocateDirect.order(ByteOrder.nativeOrder());
        int channelCountToConfiguration = channelCountToConfiguration(this.requestedChannels);
        int minBufferSize = AudioRecord.getMinBufferSize(this.requestedSampleRate, channelCountToConfiguration, 2);
        if (minBufferSize == -1 || minBufferSize == -2) {
            reportWebRtcAudioRecordInitError(g.m(minBufferSize, "AudioRecord.getMinBufferSize failed: "));
            return;
        }
        int max = Math.max(minBufferSize * 2, this.deviceByteBuffer.capacity());
        try {
            e0.k();
            AudioPlaybackCaptureConfiguration.Builder c9 = e0.c(mediaProjection);
            c9.addMatchingUsage(1);
            c9.addMatchingUsage(14);
            i.n();
            AudioRecord.Builder h = i.h();
            build = c9.build();
            h.setAudioPlaybackCaptureConfig(build);
            h.setAudioFormat(new AudioFormat.Builder().setChannelMask(channelCountToConfiguration).setSampleRate(this.requestedSampleRate).setEncoding(2).build());
            h.setBufferSizeInBytes(max);
            build2 = h.build();
            this.deviceAudioRecord = build2;
            if (build2 == null || build2.getState() != 1) {
                reportWebRtcAudioRecordInitError("Failed to create a new AudioRecord instance");
                releaseAudioResources(true);
                return;
            }
            try {
                this.deviceAudioRecord.startRecording();
                if (this.deviceAudioRecord.getRecordingState() != 3) {
                    reportWebRtcAudioRecordStartError(AudioRecordStartErrorCode.AUDIO_RECORD_START_STATE_MISMATCH, "AudioRecord.startRecording failed - incorrect state :" + this.deviceAudioRecord.getRecordingState());
                }
            } catch (IllegalStateException e9) {
                reportWebRtcAudioRecordStartError(AudioRecordStartErrorCode.AUDIO_RECORD_START_EXCEPTION, "AudioRecord.startRecording failed: " + e9.getMessage());
            }
        } catch (Throwable th) {
            reportWebRtcAudioRecordInitError("AudioRecord ctor error: " + th.getMessage());
            releaseAudioResources(true);
        }
    }

    @TargetApi(29)
    public void stopDeviceAudioRecord() {
        AudioRecord audioRecord = this.deviceAudioRecord;
        if (audioRecord == null) {
            return;
        }
        try {
            audioRecord.stop();
        } catch (Throwable th) {
            FileLog.e(th);
        }
        releaseAudioResources(true);
    }

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public static class AudioSamples {
        private final int audioFormat;
        private final int channelCount;
        private final byte[] data;
        private final int sampleRate;

        private AudioSamples(AudioRecord audioRecord, byte[] bArr) {
            this.audioFormat = audioRecord.getAudioFormat();
            this.channelCount = audioRecord.getChannelCount();
            this.sampleRate = audioRecord.getSampleRate();
            this.data = bArr;
        }

        public int getAudioFormat() {
            return this.audioFormat;
        }

        public int getChannelCount() {
            return this.channelCount;
        }

        public byte[] getData() {
            return this.data;
        }

        public int getSampleRate() {
            return this.sampleRate;
        }

        public /* synthetic */ AudioSamples(AudioRecord audioRecord, byte[] bArr, int i9) {
            this(audioRecord, bArr);
        }
    }
}
