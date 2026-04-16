package k4;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import java.io.File;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b0 implements b4.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5550a;

    public /* synthetic */ b0(int i9) {
        this.f5550a = i9;
    }

    @Override // b4.k
    public final d4.a0 a(Object obj, int i9, int i10, b4.i iVar) {
        switch (this.f5550a) {
            case 0:
                return new a0((Bitmap) obj, 0);
            case 1:
                Drawable drawable = (Drawable) obj;
                if (drawable != null) {
                    return new m4.c(drawable, 0);
                }
                return null;
            default:
                return new a0((File) obj);
        }
    }

    @Override // b4.k
    public final /* bridge */ /* synthetic */ boolean b(Object obj, b4.i iVar) {
        switch (this.f5550a) {
            case 0:
                break;
            case 1:
                break;
            default:
                break;
        }
        return true;
    }
}
