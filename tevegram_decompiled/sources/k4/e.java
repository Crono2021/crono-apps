package k4;

import android.content.Context;
import android.graphics.Bitmap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class e implements b4.m {
    @Override // b4.m
    public final d4.a0 a(Context context, d4.a0 a0Var, int i9, int i10) {
        if (!w4.n.i(i9, i10)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i9 + " or height: " + i10 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        e4.a aVar = com.bumptech.glide.b.a(context).f1731i;
        Bitmap bitmap = (Bitmap) a0Var.get();
        if (i9 == Integer.MIN_VALUE) {
            i9 = bitmap.getWidth();
        }
        if (i10 == Integer.MIN_VALUE) {
            i10 = bitmap.getHeight();
        }
        Bitmap c9 = c(aVar, bitmap, i9, i10);
        return bitmap.equals(c9) ? a0Var : d.b(c9, aVar);
    }

    public abstract Bitmap c(e4.a aVar, Bitmap bitmap, int i9, int i10);
}
