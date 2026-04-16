package s1;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public interface k {
    void b(int i9, j1.a aVar, long j5, int i10);

    void d(long j5, int i9, int i10, int i11);

    int e(MediaCodec.BufferInfo bufferInfo);

    void flush();

    ByteBuffer getInputBuffer(int i9);

    ByteBuffer getOutputBuffer(int i9);

    MediaFormat getOutputFormat();

    void h(b2.m mVar, Handler handler);

    void i(int i9);

    void o(Surface surface);

    void r(int i9, long j5);

    void release();

    void releaseOutputBuffer(int i9, boolean z8);

    int s();

    void setParameters(Bundle bundle);
}
