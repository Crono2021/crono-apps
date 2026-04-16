package y0;

import java.io.InputStream;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f extends b {
    public f(InputStream inputStream) {
        super(inputStream);
        if (inputStream.markSupported()) {
            this.f10351i.mark(Integer.MAX_VALUE);
        } else {
            m7.c.n("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
            throw null;
        }
    }

    public final void b(long j5) {
        int i9 = this.f10353k;
        if (i9 > j5) {
            this.f10353k = 0;
            this.f10351i.reset();
        } else {
            j5 -= i9;
        }
        a((int) j5);
    }

    public f(byte[] bArr) {
        super(bArr);
        this.f10351i.mark(Integer.MAX_VALUE);
    }
}
