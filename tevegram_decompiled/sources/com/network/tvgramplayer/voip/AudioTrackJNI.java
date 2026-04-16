package com.network.tvgramplayer.voip;

import android.media.AudioTrack;
import androidx.activity.g;
import java.nio.ByteBuffer;
import m7.c;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class AudioTrackJNI {
    private AudioTrack audioTrack;
    private byte[] buffer = new byte[1920];
    private long nativeInst;
    private boolean needResampling;
    private boolean running;
    private Thread thread;

    public AudioTrackJNI(long j5) {
        this.nativeInst = j5;
    }

    private int getBufferSize(int i9, int i10) {
        return Math.max(AudioTrack.getMinBufferSize(i10, 4, 2), i9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startThread$0() {
        try {
            this.audioTrack.play();
            ByteBuffer allocateDirect = this.needResampling ? ByteBuffer.allocateDirect(1920) : null;
            ByteBuffer allocateDirect2 = this.needResampling ? ByteBuffer.allocateDirect(1764) : null;
            while (this.running) {
                try {
                    boolean z8 = this.needResampling;
                    byte[] bArr = this.buffer;
                    if (z8) {
                        nativeCallback(bArr);
                        allocateDirect.rewind();
                        allocateDirect.put(this.buffer);
                        Resampler.convert48to44(allocateDirect, allocateDirect2);
                        allocateDirect2.rewind();
                        allocateDirect2.get(this.buffer, 0, 1764);
                        this.audioTrack.write(this.buffer, 0, 1764);
                    } else {
                        nativeCallback(bArr);
                        this.audioTrack.write(this.buffer, 0, 1920);
                    }
                } catch (Exception e9) {
                    VLog.e(e9);
                }
                if (!this.running) {
                    this.audioTrack.stop();
                    break;
                }
                continue;
            }
            VLog.i("audiotrack thread exits");
        } catch (Exception e10) {
            VLog.e("error starting AudioTrack", e10);
        }
    }

    private native void nativeCallback(byte[] bArr);

    private void startThread() {
        if (this.thread != null) {
            c.p("thread already started");
            return;
        }
        this.running = true;
        Thread thread = new Thread(new a7.a(this, 9));
        this.thread = thread;
        thread.start();
    }

    public void init(int i9, int i10, int i11, int i12) {
        if (this.audioTrack != null) {
            c.p("already inited");
            return;
        }
        AudioTrack audioTrack = new AudioTrack(0, 48000, i11 == 1 ? 4 : 12, 2, getBufferSize(i12, 48000), 1);
        this.audioTrack = audioTrack;
        if (audioTrack.getState() != 1) {
            VLog.w("Error initializing AudioTrack with 48k, trying 44.1k with resampling");
            try {
                this.audioTrack.release();
            } catch (Throwable unused) {
            }
            int bufferSize = getBufferSize(i12 * 6, 44100);
            VLog.d(g.m(bufferSize, "buffer size: "));
            this.audioTrack = new AudioTrack(0, 44100, i11 == 1 ? 4 : 12, 2, bufferSize, 1);
            this.needResampling = true;
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
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack != null) {
            audioTrack.release();
            this.audioTrack = null;
        }
    }

    public void start() {
        if (this.thread == null) {
            startThread();
        } else {
            this.audioTrack.play();
        }
    }

    public void stop() {
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack != null) {
            try {
                audioTrack.stop();
            } catch (Exception unused) {
            }
        }
    }
}
