package org.webrtc;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
interface MediaCodecWrapper {
    void configure(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i9);

    Surface createInputSurface();

    int dequeueInputBuffer(long j5);

    int dequeueOutputBuffer(MediaCodec.BufferInfo bufferInfo, long j5);

    void flush();

    MediaCodecInfo getCodecInfo();

    ByteBuffer getInputBuffer(int i9);

    MediaFormat getInputFormat();

    ByteBuffer getOutputBuffer(int i9);

    MediaFormat getOutputFormat();

    MediaFormat getOutputFormat(int i9);

    void queueInputBuffer(int i9, int i10, int i11, long j5, int i12);

    void release();

    void releaseOutputBuffer(int i9, boolean z8);

    void setParameters(Bundle bundle);

    void start();

    void stop();
}
