package org.webrtc.audio;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioRecordingConfiguration;
import android.media.AudioTimestamp;
import android.os.Build;
import android.os.Process;
import androidx.activity.g;
import j0.j;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import m7.c;
import o5.i;
import org.webrtc.CalledByNative;
import org.webrtc.ContextUtils;
import org.webrtc.Logging;
import org.webrtc.ThreadUtils;
import org.webrtc.audio.JavaAudioDeviceModule;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class WebRtcAudioRecord {
    private static final int AUDIO_RECORD_START = 0;
    private static final int AUDIO_RECORD_STOP = 1;
    private static final long AUDIO_RECORD_THREAD_JOIN_TIMEOUT_MS = 2000;
    private static final int BUFFERS_PER_SECOND = 100;
    private static final int BUFFER_SIZE_FACTOR = 2;
    private static final int CALLBACK_BUFFER_SIZE_MS = 10;
    private static final int CHECK_REC_STATUS_DELAY_MS = 100;
    public static final int DEFAULT_AUDIO_FORMAT = 2;
    public static final int DEFAULT_AUDIO_SOURCE = 7;
    private static final String TAG = "WebRtcAudioRecordExternal";
    private static final AtomicInteger nextSchedulerId = new AtomicInteger(0);
    private int audioFormat;
    private AudioManager audioManager;
    private AudioRecord audioRecord;
    private JavaAudioDeviceModule.SamplesReadyCallback audioSamplesReadyCallback;
    private int audioSource;
    private final AtomicReference<Boolean> audioSourceMatchesRecordingSessionRef;
    private AudioRecordThread audioThread;
    private ByteBuffer byteBuffer;
    private Context context;
    private WebRtcAudioEffects effects;
    private byte[] emptyBytes;
    private JavaAudioDeviceModule.AudioRecordErrorCallback errorCallback;
    private ScheduledExecutorService executor;
    private ScheduledFuture<String> future;
    private boolean isAcousticEchoCancelerSupported;
    private boolean isNoiseSuppressorSupported;
    private volatile boolean microphoneMute;
    private long nativeAudioRecord;
    private AudioDeviceInfo preferredDevice;
    private JavaAudioDeviceModule.AudioRecordStateCallback stateCallback;

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
            long j5;
            int timestamp;
            Process.setThreadPriority(-19);
            g.y(new StringBuilder("AudioRecordThread"), WebRtcAudioUtils.getThreadInfo(), WebRtcAudioRecord.TAG);
            WebRtcAudioRecord.assertTrue(WebRtcAudioRecord.this.audioRecord.getRecordingState() == 3);
            WebRtcAudioRecord.this.doAudioRecordStateCallback(0);
            System.nanoTime();
            AudioTimestamp audioTimestamp = Build.VERSION.SDK_INT >= 24 ? new AudioTimestamp() : null;
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
                if (read == WebRtcAudioRecord.this.byteBuffer.capacity()) {
                    if (WebRtcAudioRecord.this.microphoneMute) {
                        WebRtcAudioRecord.this.byteBuffer.clear();
                        WebRtcAudioRecord.this.byteBuffer.put(WebRtcAudioRecord.this.emptyBytes);
                    }
                    if (this.keepAlive) {
                        if (Build.VERSION.SDK_INT >= 24) {
                            timestamp = WebRtcAudioRecord.this.audioRecord.getTimestamp(audioTimestamp, 0);
                            if (timestamp == 0) {
                                j5 = audioTimestamp.nanoTime;
                                long j9 = j5;
                                WebRtcAudioRecord webRtcAudioRecord2 = WebRtcAudioRecord.this;
                                webRtcAudioRecord2.nativeDataIsRecorded(webRtcAudioRecord2.nativeAudioRecord, read, j9);
                            }
                        }
                        j5 = 0;
                        long j92 = j5;
                        WebRtcAudioRecord webRtcAudioRecord22 = WebRtcAudioRecord.this;
                        webRtcAudioRecord22.nativeDataIsRecorded(webRtcAudioRecord22.nativeAudioRecord, read, j92);
                    }
                    if (WebRtcAudioRecord.this.audioSamplesReadyCallback != null) {
                        WebRtcAudioRecord.this.audioSamplesReadyCallback.onWebRtcAudioRecordSamplesReady(new JavaAudioDeviceModule.AudioSamples(WebRtcAudioRecord.this.audioRecord.getAudioFormat(), WebRtcAudioRecord.this.audioRecord.getChannelCount(), WebRtcAudioRecord.this.audioRecord.getSampleRate(), Arrays.copyOfRange(WebRtcAudioRecord.this.byteBuffer.array(), WebRtcAudioRecord.this.byteBuffer.arrayOffset(), WebRtcAudioRecord.this.byteBuffer.arrayOffset() + WebRtcAudioRecord.this.byteBuffer.capacity())));
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
                WebRtcAudioRecord.this.doAudioRecordStateCallback(1);
            }
        }

        public void stopThread() {
            Logging.d(WebRtcAudioRecord.TAG, "stopThread");
            this.keepAlive = false;
        }
    }

    public WebRtcAudioRecord(Context context, ScheduledExecutorService scheduledExecutorService, AudioManager audioManager, int i9, int i10, JavaAudioDeviceModule.AudioRecordErrorCallback audioRecordErrorCallback, JavaAudioDeviceModule.AudioRecordStateCallback audioRecordStateCallback, JavaAudioDeviceModule.SamplesReadyCallback samplesReadyCallback, boolean z8, boolean z9) {
        this.audioSourceMatchesRecordingSessionRef = new AtomicReference<>();
        if (z8 && !WebRtcAudioEffects.isAcousticEchoCancelerSupported()) {
            c.n("HW AEC not supported");
            throw null;
        }
        if (z9 && !WebRtcAudioEffects.isNoiseSuppressorSupported()) {
            c.n("HW NS not supported");
            throw null;
        }
        this.context = context;
        this.executor = scheduledExecutorService;
        this.audioManager = audioManager;
        this.audioSource = i9;
        this.audioFormat = i10;
        this.errorCallback = audioRecordErrorCallback;
        this.stateCallback = audioRecordStateCallback;
        this.audioSamplesReadyCallback = samplesReadyCallback;
        this.isAcousticEchoCancelerSupported = z8;
        this.isNoiseSuppressorSupported = z9;
        this.nativeAudioRecord = 0L;
        this.effects = new WebRtcAudioEffects();
        g.y(new StringBuilder("ctor"), WebRtcAudioUtils.getThreadInfo(), TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void assertTrue(boolean z8) {
        if (z8) {
            return;
        }
        c.e("Expected condition to be true");
    }

    private static String audioStateToString(int i9) {
        return i9 != 0 ? i9 != 1 ? "INVALID" : "STOP" : "START";
    }

    private int channelCountToConfiguration(int i9) {
        return i9 == 1 ? 16 : 12;
    }

    @TargetApi(24)
    private static boolean checkDeviceMatch(AudioDeviceInfo audioDeviceInfo, AudioDeviceInfo audioDeviceInfo2) {
        int id;
        int id2;
        int type;
        int type2;
        id = audioDeviceInfo.getId();
        id2 = audioDeviceInfo2.getId();
        if (id != id2) {
            return false;
        }
        type = audioDeviceInfo.getType();
        type2 = audioDeviceInfo2.getType();
        return type == type2;
    }

    private static AudioRecord createAudioRecordOnLowerThanM(int i9, int i10, int i11, int i12, int i13) {
        Logging.d(TAG, "createAudioRecordOnLowerThanM");
        return new AudioRecord(i9, i10, i11, i12, i13);
    }

    @TargetApi(23)
    private static AudioRecord createAudioRecordOnMOrHigher(int i9, int i10, int i11, int i12, int i13) {
        AudioRecord.Builder audioSource;
        AudioRecord.Builder audioFormat;
        AudioRecord.Builder bufferSizeInBytes;
        AudioRecord build;
        Logging.d(TAG, "createAudioRecordOnMOrHigher");
        audioSource = i.h().setAudioSource(i9);
        audioFormat = audioSource.setAudioFormat(new AudioFormat.Builder().setEncoding(i12).setSampleRate(i10).setChannelMask(i11).build());
        bufferSizeInBytes = audioFormat.setBufferSizeInBytes(i13);
        build = bufferSizeInBytes.build();
        return build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doAudioRecordStateCallback(int i9) {
        g.y(new StringBuilder("doAudioRecordStateCallback: "), audioStateToString(i9), TAG);
        JavaAudioDeviceModule.AudioRecordStateCallback audioRecordStateCallback = this.stateCallback;
        if (audioRecordStateCallback != null) {
            if (i9 == 0) {
                audioRecordStateCallback.onWebRtcAudioRecordStart();
            } else if (i9 == 1) {
                audioRecordStateCallback.onWebRtcAudioRecordStop();
            } else {
                Logging.e(TAG, "Invalid audio state");
            }
        }
    }

    private static int getBytesPerSample(int i9) {
        int i10 = 1;
        if (i9 != 1 && i9 != 2) {
            if (i9 != 3) {
                i10 = 4;
                if (i9 != 4) {
                    if (i9 != 13) {
                        c.n(g.m(i9, "Bad audio format "));
                        return 0;
                    }
                }
            }
            return i10;
        }
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$scheduleLogRecordingConfigurationsTask$0(AudioRecord audioRecord) {
        if (this.audioRecord == audioRecord) {
            logRecordingConfigurations(audioRecord, true);
            return "Scheduled task is done";
        }
        Logging.d(TAG, "audio record has changed");
        return "Scheduled task is done";
    }

    @TargetApi(24)
    private static boolean logActiveRecordingConfigs(int i9, List<AudioRecordingConfiguration> list) {
        int clientAudioSource;
        int clientAudioSessionId;
        AudioFormat format;
        int channelCount;
        int channelIndexMask;
        AudioFormat clientFormat;
        int channelCount2;
        int channelIndexMask2;
        AudioDeviceInfo audioDevice;
        boolean isSource;
        int type;
        int id;
        assertTrue(!list.isEmpty());
        Iterator<AudioRecordingConfiguration> it = list.iterator();
        Logging.d(TAG, "AudioRecordingConfigurations: ");
        while (it.hasNext()) {
            AudioRecordingConfiguration i10 = j.i(it.next());
            StringBuilder sb = new StringBuilder("  client audio source=");
            clientAudioSource = i10.getClientAudioSource();
            sb.append(WebRtcAudioUtils.audioSourceToString(clientAudioSource));
            sb.append(", client session id=");
            clientAudioSessionId = i10.getClientAudioSessionId();
            sb.append(clientAudioSessionId);
            sb.append(" (");
            sb.append(i9);
            sb.append(")\n  Device AudioFormat: channel count=");
            format = i10.getFormat();
            channelCount = format.getChannelCount();
            sb.append(channelCount);
            sb.append(", channel index mask=");
            channelIndexMask = format.getChannelIndexMask();
            sb.append(channelIndexMask);
            sb.append(", channel mask=");
            sb.append(WebRtcAudioUtils.channelMaskToString(format.getChannelMask()));
            sb.append(", encoding=");
            sb.append(WebRtcAudioUtils.audioEncodingToString(format.getEncoding()));
            sb.append(", sample rate=");
            sb.append(format.getSampleRate());
            sb.append("\n  Client AudioFormat: channel count=");
            clientFormat = i10.getClientFormat();
            channelCount2 = clientFormat.getChannelCount();
            sb.append(channelCount2);
            sb.append(", channel index mask=");
            channelIndexMask2 = clientFormat.getChannelIndexMask();
            sb.append(channelIndexMask2);
            sb.append(", channel mask=");
            sb.append(WebRtcAudioUtils.channelMaskToString(clientFormat.getChannelMask()));
            sb.append(", encoding=");
            sb.append(WebRtcAudioUtils.audioEncodingToString(clientFormat.getEncoding()));
            sb.append(", sample rate=");
            sb.append(clientFormat.getSampleRate());
            sb.append("\n");
            audioDevice = i10.getAudioDevice();
            if (audioDevice != null) {
                isSource = audioDevice.isSource();
                assertTrue(isSource);
                sb.append("  AudioDevice: type=");
                type = audioDevice.getType();
                sb.append(WebRtcAudioUtils.deviceTypeToString(type));
                sb.append(", id=");
                id = audioDevice.getId();
                sb.append(id);
            }
            Logging.d(TAG, sb.toString());
        }
        return true;
    }

    private void logMainParameters() {
        Logging.d(TAG, "AudioRecord: session ID: " + this.audioRecord.getAudioSessionId() + ", channels: " + this.audioRecord.getChannelCount() + ", sample rate: " + this.audioRecord.getSampleRate());
    }

    @TargetApi(23)
    private void logMainParametersExtended() {
        int bufferSizeInFrames;
        if (Build.VERSION.SDK_INT >= 23) {
            StringBuilder sb = new StringBuilder("AudioRecord: buffer size in frames: ");
            bufferSizeInFrames = this.audioRecord.getBufferSizeInFrames();
            sb.append(bufferSizeInFrames);
            Logging.d(TAG, sb.toString());
        }
    }

    @TargetApi(24)
    private int logRecordingConfigurations(AudioRecord audioRecord, boolean z8) {
        List activeRecordingConfigurations;
        AudioFormat format;
        AudioDeviceInfo routedDevice;
        if (Build.VERSION.SDK_INT < 24) {
            Logging.w(TAG, "AudioManager#getActiveRecordingConfigurations() requires N or higher");
            return 0;
        }
        if (audioRecord == null) {
            return 0;
        }
        activeRecordingConfigurations = this.audioManager.getActiveRecordingConfigurations();
        int size = activeRecordingConfigurations.size();
        Logging.d(TAG, "Number of active recording sessions: " + size);
        if (size > 0) {
            logActiveRecordingConfigs(audioRecord.getAudioSessionId(), activeRecordingConfigurations);
            if (z8) {
                AtomicReference<Boolean> atomicReference = this.audioSourceMatchesRecordingSessionRef;
                int audioSource = audioRecord.getAudioSource();
                int audioSessionId = audioRecord.getAudioSessionId();
                format = audioRecord.getFormat();
                routedDevice = audioRecord.getRoutedDevice();
                atomicReference.set(Boolean.valueOf(verifyAudioConfig(audioSource, audioSessionId, format, routedDevice, activeRecordingConfigurations)));
            }
        }
        return size;
    }

    private native void nativeCacheDirectBufferAddress(long j5, ByteBuffer byteBuffer);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeDataIsRecorded(long j5, int i9, long j9);

    public static ScheduledExecutorService newDefaultScheduler() {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        return Executors.newScheduledThreadPool(0, new ThreadFactory() { // from class: org.webrtc.audio.WebRtcAudioRecord.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
                newThread.setName("WebRtcAudioRecordScheduler-" + WebRtcAudioRecord.nextSchedulerId.getAndIncrement() + "-" + atomicInteger.getAndIncrement());
                return newThread;
            }
        });
    }

    private void releaseAudioResources() {
        Logging.d(TAG, "releaseAudioResources");
        AudioRecord audioRecord = this.audioRecord;
        if (audioRecord != null) {
            audioRecord.release();
            this.audioRecord = null;
        }
        this.audioSourceMatchesRecordingSessionRef.set(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportWebRtcAudioRecordError(String str) {
        Logging.e(TAG, "Run-time recording error: " + str);
        WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
        JavaAudioDeviceModule.AudioRecordErrorCallback audioRecordErrorCallback = this.errorCallback;
        if (audioRecordErrorCallback != null) {
            audioRecordErrorCallback.onWebRtcAudioRecordError(str);
        }
    }

    private void reportWebRtcAudioRecordInitError(String str) {
        Logging.e(TAG, "Init recording error: " + str);
        WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
        logRecordingConfigurations(this.audioRecord, false);
        JavaAudioDeviceModule.AudioRecordErrorCallback audioRecordErrorCallback = this.errorCallback;
        if (audioRecordErrorCallback != null) {
            audioRecordErrorCallback.onWebRtcAudioRecordInitError(str);
        }
    }

    private void reportWebRtcAudioRecordStartError(JavaAudioDeviceModule.AudioRecordStartErrorCode audioRecordStartErrorCode, String str) {
        Logging.e(TAG, "Start recording error: " + audioRecordStartErrorCode + ". " + str);
        WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
        logRecordingConfigurations(this.audioRecord, false);
        JavaAudioDeviceModule.AudioRecordErrorCallback audioRecordErrorCallback = this.errorCallback;
        if (audioRecordErrorCallback != null) {
            audioRecordErrorCallback.onWebRtcAudioRecordStartError(audioRecordStartErrorCode, str);
        }
    }

    private void scheduleLogRecordingConfigurationsTask(final AudioRecord audioRecord) {
        Logging.d(TAG, "scheduleLogRecordingConfigurationsTask");
        if (Build.VERSION.SDK_INT < 24) {
            return;
        }
        Callable callable = new Callable() { // from class: org.webrtc.audio.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                String lambda$scheduleLogRecordingConfigurationsTask$0;
                lambda$scheduleLogRecordingConfigurationsTask$0 = WebRtcAudioRecord.this.lambda$scheduleLogRecordingConfigurationsTask$0(audioRecord);
                return lambda$scheduleLogRecordingConfigurationsTask$0;
            }
        };
        ScheduledFuture<String> scheduledFuture = this.future;
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            this.future.cancel(true);
        }
        this.future = this.executor.schedule(callable, 100L, TimeUnit.MILLISECONDS);
    }

    @TargetApi(24)
    private static boolean verifyAudioConfig(int i9, int i10, AudioFormat audioFormat, AudioDeviceInfo audioDeviceInfo, List<AudioRecordingConfiguration> list) {
        AudioDeviceInfo audioDevice;
        int clientAudioSource;
        int clientAudioSessionId;
        AudioFormat clientFormat;
        AudioFormat clientFormat2;
        AudioFormat clientFormat3;
        AudioFormat clientFormat4;
        int channelIndexMask;
        int channelIndexMask2;
        AudioFormat format;
        AudioFormat format2;
        AudioFormat format3;
        AudioFormat format4;
        int channelIndexMask3;
        assertTrue(!list.isEmpty());
        Iterator<AudioRecordingConfiguration> it = list.iterator();
        while (it.hasNext()) {
            AudioRecordingConfiguration i11 = j.i(it.next());
            audioDevice = i11.getAudioDevice();
            if (audioDevice != null) {
                clientAudioSource = i11.getClientAudioSource();
                if (clientAudioSource == i9) {
                    clientAudioSessionId = i11.getClientAudioSessionId();
                    if (clientAudioSessionId == i10) {
                        clientFormat = i11.getClientFormat();
                        if (clientFormat.getEncoding() == audioFormat.getEncoding()) {
                            clientFormat2 = i11.getClientFormat();
                            if (clientFormat2.getSampleRate() == audioFormat.getSampleRate()) {
                                clientFormat3 = i11.getClientFormat();
                                if (clientFormat3.getChannelMask() == audioFormat.getChannelMask()) {
                                    clientFormat4 = i11.getClientFormat();
                                    channelIndexMask = clientFormat4.getChannelIndexMask();
                                    channelIndexMask2 = audioFormat.getChannelIndexMask();
                                    if (channelIndexMask == channelIndexMask2) {
                                        format = i11.getFormat();
                                        if (format.getEncoding() != 0) {
                                            format2 = i11.getFormat();
                                            if (format2.getSampleRate() > 0) {
                                                format3 = i11.getFormat();
                                                if (format3.getChannelMask() == 0) {
                                                    format4 = i11.getFormat();
                                                    channelIndexMask3 = format4.getChannelIndexMask();
                                                    if (channelIndexMask3 == 0) {
                                                        continue;
                                                    }
                                                }
                                                if (checkDeviceMatch(audioDevice, audioDeviceInfo)) {
                                                    Logging.d(TAG, "verifyAudioConfig: PASS");
                                                    return true;
                                                }
                                            } else {
                                                continue;
                                            }
                                        } else {
                                            continue;
                                        }
                                    } else {
                                        continue;
                                    }
                                } else {
                                    continue;
                                }
                            } else {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
        Logging.e(TAG, "verifyAudioConfig: FAILED");
        return false;
    }

    @CalledByNative
    public boolean enableBuiltInAEC(boolean z8) {
        Logging.d(TAG, "enableBuiltInAEC(" + z8 + ")");
        return this.effects.setAEC(z8);
    }

    @CalledByNative
    public boolean enableBuiltInNS(boolean z8) {
        Logging.d(TAG, "enableBuiltInNS(" + z8 + ")");
        return this.effects.setNS(z8);
    }

    @CalledByNative
    public int initRecording(int i9, int i10) {
        Logging.d(TAG, "initRecording(sampleRate=" + i9 + ", channels=" + i10 + ")");
        if (this.audioRecord != null) {
            reportWebRtcAudioRecordInitError("InitRecording called twice without StopRecording.");
            return -1;
        }
        int i11 = i9 / 100;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(getBytesPerSample(this.audioFormat) * i10 * i11);
        this.byteBuffer = allocateDirect;
        if (!allocateDirect.hasArray()) {
            reportWebRtcAudioRecordInitError("ByteBuffer does not have backing array.");
            return -1;
        }
        Logging.d(TAG, "byteBuffer.capacity: " + this.byteBuffer.capacity());
        this.emptyBytes = new byte[this.byteBuffer.capacity()];
        nativeCacheDirectBufferAddress(this.nativeAudioRecord, this.byteBuffer);
        int channelCountToConfiguration = channelCountToConfiguration(i10);
        int minBufferSize = AudioRecord.getMinBufferSize(i9, channelCountToConfiguration, this.audioFormat);
        if (minBufferSize == -1 || minBufferSize == -2) {
            reportWebRtcAudioRecordInitError(g.m(minBufferSize, "AudioRecord.getMinBufferSize failed: "));
            return -1;
        }
        Logging.d(TAG, "AudioRecord.getMinBufferSize: " + minBufferSize);
        int max = Math.max(minBufferSize * 2, this.byteBuffer.capacity());
        Logging.d(TAG, "bufferSizeInBytes: " + max);
        try {
            int i12 = Build.VERSION.SDK_INT;
            int i13 = this.audioSource;
            if (i12 >= 23) {
                this.audioRecord = createAudioRecordOnMOrHigher(i13, i9, channelCountToConfiguration, this.audioFormat, max);
                this.audioSourceMatchesRecordingSessionRef.set(null);
                AudioDeviceInfo audioDeviceInfo = this.preferredDevice;
                if (audioDeviceInfo != null) {
                    setPreferredDevice(audioDeviceInfo);
                }
            } else {
                this.audioRecord = createAudioRecordOnLowerThanM(i13, i9, channelCountToConfiguration, this.audioFormat, max);
                this.audioSourceMatchesRecordingSessionRef.set(null);
            }
            AudioRecord audioRecord = this.audioRecord;
            if (audioRecord == null || audioRecord.getState() != 1) {
                reportWebRtcAudioRecordInitError("Creation or initialization of audio recorder failed.");
                releaseAudioResources();
                return -1;
            }
            this.effects.enable(this.audioRecord.getAudioSessionId());
            logMainParameters();
            logMainParametersExtended();
            int logRecordingConfigurations = logRecordingConfigurations(this.audioRecord, false);
            if (logRecordingConfigurations != 0) {
                Logging.w(TAG, "Potential microphone conflict. Active sessions: " + logRecordingConfigurations);
            }
            return i11;
        } catch (IllegalArgumentException e9) {
            e = e9;
            reportWebRtcAudioRecordInitError(e.getMessage());
            releaseAudioResources();
            return -1;
        } catch (UnsupportedOperationException e10) {
            e = e10;
            reportWebRtcAudioRecordInitError(e.getMessage());
            releaseAudioResources();
            return -1;
        }
    }

    @CalledByNative
    public boolean isAcousticEchoCancelerSupported() {
        return this.isAcousticEchoCancelerSupported;
    }

    @CalledByNative
    public boolean isAudioConfigVerified() {
        return this.audioSourceMatchesRecordingSessionRef.get() != null;
    }

    @CalledByNative
    public boolean isAudioSourceMatchingRecordingSession() {
        Boolean bool = this.audioSourceMatchesRecordingSessionRef.get();
        if (bool != null) {
            return bool.booleanValue();
        }
        Logging.w(TAG, "Audio configuration has not yet been verified");
        return false;
    }

    @CalledByNative
    public boolean isNoiseSuppressorSupported() {
        return this.isNoiseSuppressorSupported;
    }

    public void setMicrophoneMute(boolean z8) {
        Logging.w(TAG, "setMicrophoneMute(" + z8 + ")");
        this.microphoneMute = z8;
    }

    public boolean setNoiseSuppressorEnabled(boolean z8) {
        if (!WebRtcAudioEffects.isNoiseSuppressorSupported()) {
            Logging.e(TAG, "Noise suppressor is not supported.");
            return false;
        }
        Logging.w(TAG, "SetNoiseSuppressorEnabled(" + z8 + ")");
        return this.effects.toggleNS(z8);
    }

    @TargetApi(23)
    public void setPreferredDevice(AudioDeviceInfo audioDeviceInfo) {
        Integer num;
        boolean preferredDevice;
        int id;
        StringBuilder sb = new StringBuilder("setPreferredDevice ");
        if (audioDeviceInfo != null) {
            id = audioDeviceInfo.getId();
            num = Integer.valueOf(id);
        } else {
            num = null;
        }
        sb.append(num);
        Logging.d(TAG, sb.toString());
        this.preferredDevice = audioDeviceInfo;
        AudioRecord audioRecord = this.audioRecord;
        if (audioRecord != null) {
            preferredDevice = audioRecord.setPreferredDevice(audioDeviceInfo);
            if (preferredDevice) {
                return;
            }
            Logging.e(TAG, "setPreferredDevice failed");
        }
    }

    @CalledByNative
    public boolean startRecording() {
        Logging.d(TAG, "startRecording");
        assertTrue(this.audioRecord != null);
        assertTrue(this.audioThread == null);
        try {
            this.audioRecord.startRecording();
            if (this.audioRecord.getRecordingState() != 3) {
                reportWebRtcAudioRecordStartError(JavaAudioDeviceModule.AudioRecordStartErrorCode.AUDIO_RECORD_START_STATE_MISMATCH, "AudioRecord.startRecording failed - incorrect state: " + this.audioRecord.getRecordingState());
                return false;
            }
            AudioRecordThread audioRecordThread = new AudioRecordThread("AudioRecordJavaThread");
            this.audioThread = audioRecordThread;
            audioRecordThread.start();
            scheduleLogRecordingConfigurationsTask(this.audioRecord);
            return true;
        } catch (IllegalStateException e9) {
            reportWebRtcAudioRecordStartError(JavaAudioDeviceModule.AudioRecordStartErrorCode.AUDIO_RECORD_START_EXCEPTION, "AudioRecord.startRecording failed: " + e9.getMessage());
            return false;
        }
    }

    @CalledByNative
    public boolean stopRecording() {
        Logging.d(TAG, "stopRecording");
        assertTrue(this.audioThread != null);
        ScheduledFuture<String> scheduledFuture = this.future;
        if (scheduledFuture != null) {
            if (!scheduledFuture.isDone()) {
                this.future.cancel(true);
            }
            this.future = null;
        }
        this.audioThread.stopThread();
        if (!ThreadUtils.joinUninterruptibly(this.audioThread, AUDIO_RECORD_THREAD_JOIN_TIMEOUT_MS)) {
            Logging.e(TAG, "Join of AudioRecordJavaThread timed out");
            WebRtcAudioUtils.logAudioState(TAG, this.context, this.audioManager);
        }
        this.audioThread = null;
        this.effects.release();
        releaseAudioResources();
        return true;
    }

    @CalledByNative
    public WebRtcAudioRecord(Context context, long j5) {
        this.audioSourceMatchesRecordingSessionRef = new AtomicReference<>();
        this.context = context;
        this.nativeAudioRecord = j5;
        this.audioManager = (AudioManager) context.getSystemService("audio");
        this.executor = newDefaultScheduler();
        this.audioSource = 7;
        this.audioFormat = 2;
        this.isAcousticEchoCancelerSupported = WebRtcAudioEffects.isAcousticEchoCancelerSupported();
        this.isNoiseSuppressorSupported = WebRtcAudioEffects.isNoiseSuppressorSupported();
        this.effects = new WebRtcAudioEffects();
        g.y(new StringBuilder("ctor"), WebRtcAudioUtils.getThreadInfo(), TAG);
    }

    public WebRtcAudioRecord(Context context, AudioManager audioManager) {
        this(context, newDefaultScheduler(), audioManager, 7, 2, null, null, null, WebRtcAudioEffects.isAcousticEchoCancelerSupported(), WebRtcAudioEffects.isNoiseSuppressorSupported());
    }

    @CalledByNative
    public WebRtcAudioRecord(long j5, int i9) {
        this(ContextUtils.getApplicationContext(), j5);
    }
}
