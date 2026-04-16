package k4;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.security.MessageDigest;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h extends e {

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f5568b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(b4.f.f1325a);

    @Override // b4.f
    public final void b(MessageDigest messageDigest) {
        messageDigest.update(f5568b);
    }

    @Override // k4.e
    public final Bitmap c(e4.a aVar, Bitmap bitmap, int i9, int i10) {
        float width;
        float height;
        Paint paint = z.f5610a;
        if (bitmap.getWidth() == i9 && bitmap.getHeight() == i10) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float f9 = 0.0f;
        if (bitmap.getWidth() * i10 > bitmap.getHeight() * i9) {
            width = i10 / bitmap.getHeight();
            f9 = (i9 - (bitmap.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = i9 / bitmap.getWidth();
            height = (i10 - (bitmap.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (f9 + 0.5f), (int) (height + 0.5f));
        Bitmap f10 = aVar.f(i9, i10, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        f10.setHasAlpha(bitmap.hasAlpha());
        z.a(bitmap, f10, matrix);
        return f10;
    }

    @Override // b4.f
    public final boolean equals(Object obj) {
        return obj instanceof h;
    }

    @Override // b4.f
    public final int hashCode() {
        return -599754482;
    }
}
