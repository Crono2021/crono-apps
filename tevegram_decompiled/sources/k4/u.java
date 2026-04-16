package k4;

import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class u implements b4.e {
    @Override // b4.e
    public final ImageHeaderParser$ImageType a(ByteBuffer byteBuffer) {
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    @Override // b4.e
    public final int b(ByteBuffer byteBuffer, e4.f fVar) {
        AtomicReference atomicReference = w4.b.f9930a;
        return c(new w4.a(byteBuffer), fVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0018 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:? A[RETURN, SYNTHETIC] */
    @Override // b4.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int c(java.io.InputStream r1, e4.f r2) {
        /*
            r0 = this;
            y0.g r2 = new y0.g
            r2.<init>(r1)
            java.lang.String r1 = "Orientation"
            y0.c r1 = r2.c(r1)
            if (r1 != 0) goto Le
            goto L15
        Le:
            java.nio.ByteOrder r2 = r2.f10385f     // Catch: java.lang.NumberFormatException -> L15
            int r1 = r1.e(r2)     // Catch: java.lang.NumberFormatException -> L15
            goto L16
        L15:
            r1 = 1
        L16:
            if (r1 != 0) goto L19
            r1 = -1
        L19:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: k4.u.c(java.io.InputStream, e4.f):int");
    }

    @Override // b4.e
    public final ImageHeaderParser$ImageType d(InputStream inputStream) {
        return ImageHeaderParser$ImageType.UNKNOWN;
    }
}
