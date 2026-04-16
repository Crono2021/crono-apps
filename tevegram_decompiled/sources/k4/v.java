package k4;

import android.graphics.Bitmap;
import java.security.MessageDigest;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class v extends e {

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f5596b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(b4.f.f1325a);

    @Override // b4.f
    public final void b(MessageDigest messageDigest) {
        messageDigest.update(f5596b);
    }

    @Override // k4.e
    public final Bitmap c(e4.a aVar, Bitmap bitmap, int i9, int i10) {
        return z.b(aVar, bitmap, i9, i10);
    }

    @Override // b4.f
    public final boolean equals(Object obj) {
        return obj instanceof v;
    }

    @Override // b4.f
    public final int hashCode() {
        return 1572326941;
    }
}
