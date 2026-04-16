package com.network.tvgramplayer.voip;

import android.media.AudioRecord;
import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.AudioEffect;
import android.media.audiofx.AutomaticGainControl;
import android.media.audiofx.NoiseSuppressor;
import android.text.TextUtils;
import b2.f0;
import java.nio.ByteBuffer;
import java.util.regex.Pattern;
import m7.c;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class AudioRecordJNI {
    private AcousticEchoCanceler aec;
    private AutomaticGainControl agc;
    private AudioRecord audioRecord;
    private ByteBuffer buffer;
    private int bufferSize;
    private long nativeInst;
    private boolean needResampling = false;
    private NoiseSuppressor ns;
    private boolean running;
    private Thread thread;

    public AudioRecordJNI(long j5) {
        this.nativeInst = j5;
    }

    private int getBufferSize(int i9, int i10) {
        return Math.max(AudioRecord.getMinBufferSize(i10, 16, 2), i9);
    }

    private static boolean isGoodAudioEffect(AudioEffect audioEffect) {
        Pattern makeNonEmptyRegex = makeNonEmptyRegex("adsp_good_impls");
        Pattern makeNonEmptyRegex2 = makeNonEmptyRegex("adsp_good_names");
        AudioEffect.Descriptor descriptor = audioEffect.getDescriptor();
        VLog.d(audioEffect.getClass().getSimpleName() + ": implementor=" + descriptor.implementor + ", name=" + descriptor.name);
        if (makeNonEmptyRegex != null && makeNonEmptyRegex.matcher(descriptor.implementor).find()) {
            return true;
        }
        if (makeNonEmptyRegex2 != null && makeNonEmptyRegex2.matcher(descriptor.name).find()) {
            return true;
        }
        if (audioEffect instanceof AcousticEchoCanceler) {
            Pattern makeNonEmptyRegex3 = makeNonEmptyRegex("aaec_good_impls");
            Pattern makeNonEmptyRegex4 = makeNonEmptyRegex("aaec_good_names");
            if (makeNonEmptyRegex3 != null && makeNonEmptyRegex3.matcher(descriptor.implementor).find()) {
                return true;
            }
            if (makeNonEmptyRegex4 != null && makeNonEmptyRegex4.matcher(descriptor.name).find()) {
                return true;
            }
        }
        if (!(audioEffect instanceof NoiseSuppressor)) {
            return false;
        }
        Pattern makeNonEmptyRegex5 = makeNonEmptyRegex("ans_good_impls");
        Pattern makeNonEmptyRegex6 = makeNonEmptyRegex("ans_good_names");
        if (makeNonEmptyRegex5 == null || !makeNonEmptyRegex5.matcher(descriptor.implementor).find()) {
            return makeNonEmptyRegex6 != null && makeNonEmptyRegex6.matcher(descriptor.name).find();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startThread$0(ByteBuffer byteBuffer) {
        while (this.running) {
            try {
                boolean z8 = this.needResampling;
                AudioRecord audioRecord = this.audioRecord;
                if (z8) {
                    audioRecord.read(byteBuffer, 1764);
                    Resampler.convert44to48(byteBuffer, this.buffer);
                } else {
                    audioRecord.read(this.buffer, 1920);
                }
            } catch (Exception e9) {
                VLog.e(e9);
            }
            if (!this.running) {
                this.audioRecord.stop();
                break;
            }
            nativeCallback(this.buffer);
        }
        VLog.i("audiorecord thread exits");
    }

    private static Pattern makeNonEmptyRegex(String str) {
        String string = Instance.getGlobalServerConfig().getString(str);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return Pattern.compile(string);
        } catch (Exception e9) {
            VLog.e(e9);
            return null;
        }
    }

    private native void nativeCallback(ByteBuffer byteBuffer);

    private void startThread() {
        if (this.thread != null) {
            c.p("thread already started");
            return;
        }
        this.running = true;
        Thread thread = new Thread(new f0(this, 4, this.needResampling ? ByteBuffer.allocateDirect(1764) : null));
        this.thread = thread;
        thread.start();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean tryInit(int r9, int r10) {
        /*
            r8 = this;
            android.media.AudioRecord r0 = r8.audioRecord
            if (r0 == 0) goto L7
            r0.release()     // Catch: java.lang.Exception -> L7
        L7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Trying to initialize AudioRecord with source="
            r0.<init>(r1)
            r0.append(r9)
            java.lang.String r1 = " and sample rate="
            r0.append(r1)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            com.network.tvgramplayer.voip.VLog.i(r0)
            int r0 = r8.bufferSize
            r1 = 48000(0xbb80, float:6.7262E-41)
            int r7 = r8.getBufferSize(r0, r1)
            android.media.AudioRecord r2 = new android.media.AudioRecord     // Catch: java.lang.Exception -> L39
            r5 = 16
            r6 = 2
            r3 = r9
            r4 = r10
            r2.<init>(r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> L36
            r8.audioRecord = r2     // Catch: java.lang.Exception -> L36
            goto L41
        L36:
            r0 = move-exception
        L37:
            r9 = r0
            goto L3c
        L39:
            r0 = move-exception
            r4 = r10
            goto L37
        L3c:
            java.lang.String r10 = "AudioRecord init failed!"
            com.network.tvgramplayer.voip.VLog.e(r10, r9)
        L41:
            r9 = 0
            r10 = 1
            if (r4 == r1) goto L47
            r0 = 1
            goto L48
        L47:
            r0 = 0
        L48:
            r8.needResampling = r0
            android.media.AudioRecord r0 = r8.audioRecord
            if (r0 == 0) goto L55
            int r0 = r0.getState()
            if (r0 != r10) goto L55
            r9 = 1
        L55:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.network.tvgramplayer.voip.AudioRecordJNI.tryInit(int, int):boolean");
    }

    public int getEnabledEffectsMask() {
        AcousticEchoCanceler acousticEchoCanceler = this.aec;
        int i9 = (acousticEchoCanceler == null || !acousticEchoCanceler.getEnabled()) ? 0 : 1;
        NoiseSuppressor noiseSuppressor = this.ns;
        return (noiseSuppressor == null || !noiseSuppressor.getEnabled()) ? i9 : i9 | 2;
    }

    public void init(int i9, int i10, int i11, int i12) {
        if (this.audioRecord != null) {
            c.p("already inited");
            return;
        }
        this.bufferSize = i12;
        boolean tryInit = tryInit(7, 48000);
        boolean z8 = true;
        if (!tryInit) {
            tryInit = tryInit(1, 48000);
        }
        if (!tryInit) {
            tryInit = tryInit(7, 44100);
        }
        if (!tryInit) {
            tryInit = tryInit(1, 44100);
        }
        if (tryInit) {
            try {
                if (AutomaticGainControl.isAvailable()) {
                    AutomaticGainControl create = AutomaticGainControl.create(this.audioRecord.getAudioSessionId());
                    this.agc = create;
                    if (create != null) {
                        create.setEnabled(false);
                    }
                } else {
                    VLog.w("AutomaticGainControl is not available on this device :(");
                }
            } catch (Throwable th) {
                VLog.e("error creating AutomaticGainControl", th);
            }
            try {
                if (NoiseSuppressor.isAvailable()) {
                    NoiseSuppressor create2 = NoiseSuppressor.create(this.audioRecord.getAudioSessionId());
                    this.ns = create2;
                    if (create2 != null) {
                        create2.setEnabled(Instance.getGlobalServerConfig().useSystemNs && isGoodAudioEffect(this.ns));
                    }
                } else {
                    VLog.w("NoiseSuppressor is not available on this device :(");
                }
            } catch (Throwable th2) {
                VLog.e("error creating NoiseSuppressor", th2);
            }
            try {
                if (AcousticEchoCanceler.isAvailable()) {
                    AcousticEchoCanceler create3 = AcousticEchoCanceler.create(this.audioRecord.getAudioSessionId());
                    this.aec = create3;
                    if (create3 != null) {
                        if (!Instance.getGlobalServerConfig().useSystemAec || !isGoodAudioEffect(this.aec)) {
                            z8 = false;
                        }
                        create3.setEnabled(z8);
                    }
                } else {
                    VLog.w("AcousticEchoCanceler is not available on this device");
                }
            } catch (Throwable th3) {
                VLog.e("error creating AcousticEchoCanceler", th3);
            }
            this.buffer = ByteBuffer.allocateDirect(i12);
        }
    }

    public void release() {
        this.running = false;
        Thread thread = this.thread;
        if (thread != null) {
            try {
                thread.join();
            } catch (InterruptedException e9) {
                VLog.e(e9);
            }
            this.thread = null;
        }
        AudioRecord audioRecord = this.audioRecord;
        if (audioRecord != null) {
            audioRecord.release();
            this.audioRecord = null;
        }
        AutomaticGainControl automaticGainControl = this.agc;
        if (automaticGainControl != null) {
            automaticGainControl.release();
            this.agc = null;
        }
        NoiseSuppressor noiseSuppressor = this.ns;
        if (noiseSuppressor != null) {
            noiseSuppressor.release();
            this.ns = null;
        }
        AcousticEchoCanceler acousticEchoCanceler = this.aec;
        if (acousticEchoCanceler != null) {
            acousticEchoCanceler.release();
            this.aec = null;
        }
    }

    public boolean start() {
        AudioRecord audioRecord = this.audioRecord;
        if (audioRecord != null && audioRecord.getState() == 1) {
            try {
                Thread thread = this.thread;
                AudioRecord audioRecord2 = this.audioRecord;
                if (thread != null) {
                    audioRecord2.startRecording();
                } else {
                    if (audioRecord2 == null) {
                        return false;
                    }
                    audioRecord2.startRecording();
                    startThread();
                }
                return true;
            } catch (Exception e9) {
                VLog.e("Error initializing AudioRecord", e9);
            }
        }
        return false;
    }

    public void stop() {
        try {
            AudioRecord audioRecord = this.audioRecord;
            if (audioRecord != null) {
                audioRecord.stop();
            }
        } catch (Exception unused) {
        }
    }
}
