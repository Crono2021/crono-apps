package org.webrtc.audio;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Process;
import androidx.activity.g;
import java.nio.ByteBuffer;
import m7.c;
import n1.f;
import org.telegram.messenger.FileLog;
import org.webrtc.CalledByNative;
import org.webrtc.ContextUtils;
import org.webrtc.Logging;
import org.webrtc.ThreadUtils;
import org.webrtc.audio.JavaAudioDeviceModule;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class WebRtcAudioTrack {
    private static final int AUDIO_TRACK_START = 0;
    private static final int AUDIO_TRACK_STOP = 1;
    private static final long AUDIO_TRACK_THREAD_JOIN_TIMEOUT_MS = 2000;
    private static final int BITS_PER_SAMPLE = 16;
    private static final int BUFFERS_PER_SECOND = 100;
    private static final int CALLBACK_BUFFER_SIZE_MS = 10;
    private static final int DEFAULT_USAGE = getDefaultUsageAttribute();
    private static final String TAG = "WebRtcAudioTrackExternal";
    private AudioAttributes audioAttributes;
    private AudioManager audioManager;
    private AudioTrackThread audioThread;
    private AudioTrack audioTrack;
    private ByteBuffer byteBuffer;
    private Context context;
    private byte[] emptyBytes;
    private JavaAudioDeviceModule.AudioTrackErrorCallback errorCallback;
    private int initialBufferSizeInFrames;
    private long nativeAudioTrack;
    private volatile boolean speakerMute;
    private JavaAudioDeviceModule.AudioTrackStateCallback stateCallback;
    private final ThreadUtils.ThreadChecker threadChecker;
    private boolean useLowLatency;
    private VolumeLogger volumeLogger;

    /* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
    public class AudioTrackThread extends Thread {
        private LowLatencyAudioBufferManager bufferManager;
        private volatile boolean keepAlive;
        private long lastPlaybackHeadPosition;
        private long lastTimestamp;
        private long targetTimeNs;
        private long writtenFrames;

        public AudioTrackThread(String str) {
            super(str);
            this.keepAlive = true;
            this.writtenFrames = 0L;
            this.lastPlaybackHeadPosition = 0L;
            this.lastTimestamp = System.nanoTime();
            this.bufferManager = new LowLatencyAudioBufferManager();
        }

        private int writeBytes(AudioTrack audioTrack, ByteBuffer byteBuffer, int i9) {
            return audioTrack.write(byteBuffer, i9, 0);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(-19);
            g.y(new StringBuilder("AudioTrackThread"), WebRtcAudioUtils.getThreadInfo(), WebRtcAudioTrack.TAG);
            WebRtcAudioTrack.assertTrue(WebRtcAudioTrack.this.audioTrack.getPlayState() == 3);
            WebRtcAudioTrack.this.doAudioTrackStateCallback(0);
            int capacity = WebRtcAudioTrack.this.byteBuffer.capacity();
            int channelCount = WebRtcAudioTrack.this.audioTrack.getChannelCount() * 2;
            int sampleRate = WebRtcAudioTrack.this.audioTrack.getSampleRate();
            this.targetTimeNs = System.nanoTime();
            while (this.keepAlive) {
                WebRtcAudioTrack webRtcAudioTrack = WebRtcAudioTrack.this;
                webRtcAudioTrack.nativeGetPlayoutData(webRtcAudioTrack.nativeAudioTrack, capacity);
                WebRtcAudioTrack.assertTrue(capacity <= WebRtcAudioTrack.this.byteBuffer.remaining());
                if (WebRtcAudioTrack.this.speakerMute) {
                    WebRtcAudioTrack.this.byteBuffer.clear();
                    WebRtcAudioTrack.this.byteBuffer.put(WebRtcAudioTrack.this.emptyBytes);
                    WebRtcAudioTrack.this.byteBuffer.position(0);
                }
                int writeBytes = writeBytes(WebRtcAudioTrack.this.audioTrack, WebRtcAudioTrack.this.byteBuffer, capacity);
                if (writeBytes != capacity) {
                    Logging.e(WebRtcAudioTrack.TAG, "AudioTrack.write played invalid number of bytes: " + writeBytes);
                    if (writeBytes < 0) {
                        this.keepAlive = false;
                        WebRtcAudioTrack.this.reportWebRtcAudioTrackError("AudioTrack.write failed: " + writeBytes);
                    }
                }
                if (WebRtcAudioTrack.this.useLowLatency) {
                    this.bufferManager.maybeAdjustBufferSize(WebRtcAudioTrack.this.audioTrack);
                }
                WebRtcAudioTrack.this.byteBuffer.rewind();
                this.writtenFrames += writeBytes / channelCount;
                long playbackHeadPosition = ((this.writtenFrames - WebRtcAudioTrack.this.audioTrack.getPlaybackHeadPosition()) * 1000) / sampleRate;
                WebRtcAudioTrack.this.byteBuffer.rewind();
                this.targetTimeNs += 10000000;
                long nanoTime = this.targetTimeNs - System.nanoTime();
                if (nanoTime > 0) {
                    try {
                        Thread.sleep(nanoTime / 1000000, (int) (nanoTime % 1000000));
                    } catch (InterruptedException e9) {
                        FileLog.e(e9);
                    }
                } else {
                    this.targetTimeNs = System.nanoTime();
                }
            }
        }

        public void stopThread() {
            Logging.d(WebRtcAudioTrack.TAG, "stopThread");
            this.keepAlive = false;
        }
    }

    @CalledByNative
    public WebRtcAudioTrack(Context context, long j5) {
        ThreadUtils.ThreadChecker threadChecker = new ThreadUtils.ThreadChecker();
        this.threadChecker = threadChecker;
        threadChecker.detachThread();
        this.context = context;
        this.nativeAudioTrack = j5;
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        this.audioManager = audioManager;
        this.audioAttributes = null;
        this.errorCallback = null;
        this.stateCallback = null;
        this.volumeLogger = new VolumeLogger(audioManager);
        this.useLowLatency = false;
        g.y(new StringBuilder("ctor"), WebRtcAudioUtils.getThreadInfo(), TAG);
    }

    @TargetApi(29)
    private static AudioAttributes.Builder applyAttributesOnQOrHigher(AudioAttributes.Builder builder, AudioAttributes audioAttributes) {
        int allowedCapturePolicy;
        AudioAttributes.Builder allowedCapturePolicy2;
        allowedCapturePolicy = audioAttributes.getAllowedCapturePolicy();
        allowedCapturePolicy2 = builder.setAllowedCapturePolicy(allowedCapturePolicy);
        return allowedCapturePolicy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void assertTrue(boolean z8) {
        if (z8) {
            return;
        }
        c.e("Expected condition to be true");
    }

    private int channelCountToConfiguration(int i9) {
        return i9 == 1 ? 4 : 12;
    }

    @TargetApi(21)
    private static AudioTrack createAudioTrackBeforeOreo(int i9, int i10, int i11, AudioAttributes audioAttributes) {
        Logging.d(TAG, "createAudioTrackBeforeOreo");
        logNativeOutputSampleRate(i9);
        return new AudioTrack(getAudioAttributes(audioAttributes), new AudioFormat.Builder().setEncoding(2).setSampleRate(i9).setChannelMask(i10).build(), i11, 1, 0);
    }

    @TargetApi(26)
    private static AudioTrack createAudioTrackOnOreoOrHigher(int i9, int i10, int i11, AudioAttributes audioAttributes) {
        AudioTrack.Builder audioAttributes2;
        AudioTrack.Builder audioFormat;
        AudioTrack.Builder bufferSizeInBytes;
        AudioTrack.Builder performanceMode;
        AudioTrack.Builder transferMode;
        AudioTrack.Builder sessionId;
        AudioTrack build;
        Logging.d(TAG, "createAudioTrackOnOreoOrHigher");
        logNativeOutputSampleRate(i9);
        audioAttributes2 = f.c().setAudioAttributes(getAudioAttributes(audioAttributes));
        audioFormat = audioAttributes2.setAudioFormat(new AudioFormat.Builder().setEncoding(2).setSampleRate(i9).setChannelMask(i10).build());
        bufferSizeInBytes = audioFormat.setBufferSizeInBytes(i11);
        performanceMode = bufferSizeInBytes.setPerformanceMode(1);
        transferMode = performanceMode.setTransferMode(1);
        sessionId = transferMode.setSessionId(0);
        build = sessionId.build();
        return build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doAudioTrackStateCallback(int i9) {
        Logging.d(TAG, "doAudioTrackStateCallback: " + i9);
        JavaAudioDeviceModule.AudioTrackStateCallback audioTrackStateCallback = this.stateCallback;
        if (audioTrackStateCallback != null) {
            if (i9 == 0) {
                audioTrackStateCallback.onWebRtcAudioTrackStart();
            } else if (i9 == 1) {
                audioTrackStateCallback.onWebRtcAudioTrackStop();
            } else {
                Logging.e(TAG, "Invalid audio state");
            }
        }
    }

    @TargetApi(21)
    private static AudioAttributes getAudioAttributes(AudioAttributes audioAttributes) {
        AudioAttributes.Builder contentType = new AudioAttributes.Builder().setUsage(DEFAULT_USAGE).setContentType(1);
        if (audioAttributes != null) {
            if (audioAttributes.getUsage() != 0) {
                contentType.setUsage(audioAttributes.getUsage());
            }
            if (audioAttributes.getContentType() != 0) {
                contentType.setContentType(audioAttributes.getContentType());
            }
            contentType.setFlags(audioAttributes.getFlags());
            if (Build.VERSION.SDK_INT >= 29) {
                contentType = applyAttributesOnQOrHigher(contentType, audioAttributes);
            }
        }
        return contentType.build();
    }

    private static int getDefaultUsageAttribute() {
        return 2;
    }

    private void logBufferCapacityInFrames() {
        int bufferCapacityInFrames;
        if (Build.VERSION.SDK_INT >= 24) {
            StringBuilder sb = new StringBuilder("AudioTrack: buffer capacity in frames: ");
            bufferCapacityInFrames = this.audioTrack.getBufferCapacityInFrames();
            sb.append(bufferCapacityInFrames);
            Logging.d(TAG, sb.toString());
        }
    }

    private void logBufferSizeInFrames() {
        int bufferSizeInFrames;
        if (Build.VERSION.SDK_INT >= 23) {
            StringBuilder sb = new StringBuilder("AudioTrack: buffer size in frames: ");
            bufferSizeInFrames = this.audioTrack.getBufferSizeInFrames();
            sb.append(bufferSizeInFrames);
            Logging.d(TAG, sb.toString());
        }
    }

    private void logMainParameters() {
        Logging.d(TAG, "AudioTrack: session ID: " + this.audioTrack.getAudioSessionId() + ", channels: " + this.audioTrack.getChannelCount() + ", sample rate: " + this.audioTrack.getSampleRate() + ", max gain: " + AudioTrack.getMaxVolume());
    }

    private void logMainParametersExtended() {
        logBufferSizeInFrames();
        logBufferCapacityInFrames();
    }

    private static void logNativeOutputSampleRate(int i9) {
        int nativeOutputSampleRate = AudioTrack.getNativeOutputSampleRate(0);
        Logging.d(TAG, "nativeOutputSampleRate: " + nativeOutputSampleRate);
        if (i9 != nativeOutputSampleRate) {
            Logging.w(TAG, "Unable to use fast mode since requested sample rate is not native");
        }
    }

    private void logUnderrunCount() {
        int underrunCount;
        if (Build.VERSION.SDK_INT >= 24) {
            StringBuilder sb = new StringBuilder("underrun count: ");
            underrunCount = this.audioTrack.getUnderrunCount();
            sb.append(underrunCount);
            Logging.d(TAG, sb.toString());
        }
    }

    private native void nativeCacheDirectBufferAddress(long j5, ByteBuffer byteBuffer);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeGetPlayoutData(long j5, int i9);

    private void releaseAudioResources() {
        Logging.d(TAG, "releaseAudioResources");
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack != null) {
            audioTrack.release();
            this.audioTrack = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportWebRtcAudioTrackError(String str) {
        Logging.e(TAG, "Run-time playback error: " + str);
        WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
        JavaAudioDeviceModule.AudioTrackErrorCallback audioTrackErrorCallback = this.errorCallback;
        if (audioTrackErrorCallback != null) {
            audioTrackErrorCallback.onWebRtcAudioTrackError(str);
        }
    }

    private void reportWebRtcAudioTrackInitError(String str) {
        Logging.e(TAG, "Init playout error: " + str);
        WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
        JavaAudioDeviceModule.AudioTrackErrorCallback audioTrackErrorCallback = this.errorCallback;
        if (audioTrackErrorCallback != null) {
            audioTrackErrorCallback.onWebRtcAudioTrackInitError(str);
        }
    }

    private void reportWebRtcAudioTrackStartError(JavaAudioDeviceModule.AudioTrackStartErrorCode audioTrackStartErrorCode, String str) {
        Logging.e(TAG, "Start playout error: " + audioTrackStartErrorCode + ". " + str);
        WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
        JavaAudioDeviceModule.AudioTrackErrorCallback audioTrackErrorCallback = this.errorCallback;
        if (audioTrackErrorCallback != null) {
            audioTrackErrorCallback.onWebRtcAudioTrackStartError(audioTrackStartErrorCode, str);
        }
    }

    @CalledByNative
    public int GetPlayoutUnderrunCount() {
        int underrunCount;
        if (Build.VERSION.SDK_INT < 24) {
            return -2;
        }
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack == null) {
            return -1;
        }
        underrunCount = audioTrack.getUnderrunCount();
        return underrunCount;
    }

    @CalledByNative
    public int getBufferSizeInFrames() {
        int bufferSizeInFrames;
        if (Build.VERSION.SDK_INT < 23) {
            return -1;
        }
        bufferSizeInFrames = this.audioTrack.getBufferSizeInFrames();
        return bufferSizeInFrames;
    }

    @CalledByNative
    public int getInitialBufferSizeInFrames() {
        return this.initialBufferSizeInFrames;
    }

    @CalledByNative
    public int getStreamMaxVolume() {
        this.threadChecker.checkIsOnValidThread();
        Logging.d(TAG, "getStreamMaxVolume");
        return this.audioManager.getStreamMaxVolume(0);
    }

    @CalledByNative
    public int getStreamVolume() {
        this.threadChecker.checkIsOnValidThread();
        Logging.d(TAG, "getStreamVolume");
        return this.audioManager.getStreamVolume(0);
    }

    @CalledByNative
    public int initPlayout(int i9, int i10, double d9) {
        int bufferSizeInFrames;
        this.threadChecker.checkIsOnValidThread();
        Logging.d(TAG, "initPlayout(sampleRate=" + i9 + ", channels=" + i10 + ", bufferSizeFactor=" + d9 + ")");
        this.byteBuffer = ByteBuffer.allocateDirect((i9 / 100) * i10 * 2);
        StringBuilder sb = new StringBuilder("byteBuffer.capacity: ");
        sb.append(this.byteBuffer.capacity());
        Logging.d(TAG, sb.toString());
        this.emptyBytes = new byte[this.byteBuffer.capacity()];
        nativeCacheDirectBufferAddress(this.nativeAudioTrack, this.byteBuffer);
        int channelCountToConfiguration = channelCountToConfiguration(i10);
        int minBufferSize = (int) (AudioTrack.getMinBufferSize(i9, channelCountToConfiguration, 2) * d9);
        Logging.d(TAG, "minBufferSizeInBytes: " + minBufferSize);
        if (minBufferSize < this.byteBuffer.capacity()) {
            reportWebRtcAudioTrackInitError("AudioTrack.getMinBufferSize returns an invalid value.");
            return -1;
        }
        if (d9 > 1.0d) {
            this.useLowLatency = false;
        }
        if (this.audioTrack != null) {
            reportWebRtcAudioTrackInitError("Conflict with existing AudioTrack.");
            return -1;
        }
        try {
            if (!this.useLowLatency || Build.VERSION.SDK_INT < 26) {
                this.audioTrack = createAudioTrackBeforeOreo(i9, channelCountToConfiguration, minBufferSize, this.audioAttributes);
            } else {
                this.audioTrack = createAudioTrackOnOreoOrHigher(i9, channelCountToConfiguration, minBufferSize, this.audioAttributes);
            }
            AudioTrack audioTrack = this.audioTrack;
            if (audioTrack == null || audioTrack.getState() != 1) {
                reportWebRtcAudioTrackInitError("Initialization of audio track failed.");
                releaseAudioResources();
                return -1;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                bufferSizeInFrames = this.audioTrack.getBufferSizeInFrames();
                this.initialBufferSizeInFrames = bufferSizeInFrames;
            } else {
                this.initialBufferSizeInFrames = -1;
            }
            logMainParameters();
            logMainParametersExtended();
            return minBufferSize;
        } catch (IllegalArgumentException e9) {
            reportWebRtcAudioTrackInitError(e9.getMessage());
            releaseAudioResources();
            return -1;
        }
    }

    public void setSpeakerMute(boolean z8) {
        Logging.w(TAG, "setSpeakerMute(" + z8 + ")");
        this.speakerMute = z8;
    }

    @CalledByNative
    public boolean setStreamVolume(int i9) {
        this.threadChecker.checkIsOnValidThread();
        Logging.d(TAG, "setStreamVolume(" + i9 + ")");
        if (this.audioManager.isVolumeFixed()) {
            Logging.e(TAG, "The device implements a fixed volume policy.");
            return false;
        }
        this.audioManager.setStreamVolume(0, i9, 0);
        return true;
    }

    @CalledByNative
    public boolean startPlayout() {
        this.threadChecker.checkIsOnValidThread();
        VolumeLogger volumeLogger = this.volumeLogger;
        if (volumeLogger != null) {
            volumeLogger.start();
        }
        Logging.d(TAG, "startPlayout");
        assertTrue(this.audioTrack != null);
        assertTrue(this.audioThread == null);
        try {
            this.audioTrack.play();
            if (this.audioTrack.getPlayState() == 3) {
                AudioTrackThread audioTrackThread = new AudioTrackThread("AudioTrackJavaThread");
                this.audioThread = audioTrackThread;
                audioTrackThread.start();
                return true;
            }
            reportWebRtcAudioTrackStartError(JavaAudioDeviceModule.AudioTrackStartErrorCode.AUDIO_TRACK_START_STATE_MISMATCH, "AudioTrack.play failed - incorrect state :" + this.audioTrack.getPlayState());
            releaseAudioResources();
            return false;
        } catch (IllegalStateException e9) {
            reportWebRtcAudioTrackStartError(JavaAudioDeviceModule.AudioTrackStartErrorCode.AUDIO_TRACK_START_EXCEPTION, "AudioTrack.play failed: " + e9.getMessage());
            releaseAudioResources();
            return false;
        }
    }

    @CalledByNative
    public boolean stopPlayout() {
        this.threadChecker.checkIsOnValidThread();
        VolumeLogger volumeLogger = this.volumeLogger;
        if (volumeLogger != null) {
            volumeLogger.stop();
        }
        Logging.d(TAG, "stopPlayout");
        assertTrue(this.audioThread != null);
        logUnderrunCount();
        this.audioThread.stopThread();
        Logging.d(TAG, "Stopping the AudioTrackThread...");
        this.audioThread.interrupt();
        if (!ThreadUtils.joinUninterruptibly(this.audioThread, AUDIO_TRACK_THREAD_JOIN_TIMEOUT_MS)) {
            Logging.e(TAG, "Join of AudioTrackThread timed out.");
            WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
        }
        Logging.d(TAG, "AudioTrackThread has now been stopped.");
        this.audioThread = null;
        if (this.audioTrack != null) {
            Logging.d(TAG, "Calling AudioTrack.stop...");
            try {
                this.audioTrack.stop();
                Logging.d(TAG, "AudioTrack.stop is done.");
                doAudioTrackStateCallback(1);
            } catch (IllegalStateException e9) {
                Logging.e(TAG, "AudioTrack.stop failed: " + e9.getMessage());
            }
        }
        releaseAudioResources();
        return true;
    }

    @CalledByNative
    public WebRtcAudioTrack(long j5) {
        this(ContextUtils.getApplicationContext(), j5);
    }

    public WebRtcAudioTrack(Context context, AudioManager audioManager) {
        this(context, audioManager, null, null, null, false, true);
    }

    public WebRtcAudioTrack(Context context, AudioManager audioManager, AudioAttributes audioAttributes, JavaAudioDeviceModule.AudioTrackErrorCallback audioTrackErrorCallback, JavaAudioDeviceModule.AudioTrackStateCallback audioTrackStateCallback, boolean z8, boolean z9) {
        ThreadUtils.ThreadChecker threadChecker = new ThreadUtils.ThreadChecker();
        this.threadChecker = threadChecker;
        threadChecker.detachThread();
        this.context = context;
        this.audioManager = audioManager;
        this.audioAttributes = audioAttributes;
        this.errorCallback = audioTrackErrorCallback;
        this.stateCallback = audioTrackStateCallback;
        this.volumeLogger = z9 ? new VolumeLogger(audioManager) : null;
        this.useLowLatency = z8;
        this.nativeAudioTrack = 0L;
        g.y(new StringBuilder("ctor"), WebRtcAudioUtils.getThreadInfo(), TAG);
    }
}
