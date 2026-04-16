package y0;

import android.media.MediaDataSource;
import java.io.IOException;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a extends MediaDataSource {

    /* renamed from: i, reason: collision with root package name */
    public long f10347i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ f f10348j;

    public a(f fVar) {
        this.f10348j = fVar;
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        return -1L;
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long j5, byte[] bArr, int i9, int i10) {
        if (i10 == 0) {
            return 0;
        }
        if (j5 >= 0) {
            try {
                long j9 = this.f10347i;
                if (j9 != j5) {
                    if (j9 < 0 || j5 < j9 + this.f10348j.f10351i.available()) {
                        this.f10348j.b(j5);
                        this.f10347i = j5;
                    }
                }
                if (i10 > this.f10348j.f10351i.available()) {
                    i10 = this.f10348j.f10351i.available();
                }
                int read = this.f10348j.read(bArr, i9, i10);
                if (read >= 0) {
                    this.f10347i += read;
                    return read;
                }
            } catch (IOException unused) {
            }
            this.f10347i = -1L;
            return -1;
        }
        return -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
