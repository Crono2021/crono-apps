package k4;

import android.media.MediaDataSource;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d0 extends MediaDataSource {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ ByteBuffer f5556i;

    public d0(ByteBuffer byteBuffer) {
        this.f5556i = byteBuffer;
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        return this.f5556i.limit();
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long j5, byte[] bArr, int i9, int i10) {
        if (j5 >= this.f5556i.limit()) {
            return -1;
        }
        this.f5556i.position((int) j5);
        int min = Math.min(i10, this.f5556i.remaining());
        this.f5556i.get(bArr, i9, min);
        return min;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
