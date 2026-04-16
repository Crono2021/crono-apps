package k4;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c implements b4.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5551a;

    /* renamed from: b, reason: collision with root package name */
    public final e4.a f5552b;

    public c() {
        this.f5551a = 0;
        this.f5552b = new d4.t(3);
    }

    @Override // b4.k
    public final d4.a0 a(Object obj, int i9, int i10, b4.i iVar) {
        switch (this.f5551a) {
            case 0:
                return c(androidx.emoji2.text.b.f(obj), i9, i10, iVar);
            default:
                return d.b(((a4.d) obj).b(), this.f5552b);
        }
    }

    @Override // b4.k
    public final /* bridge */ /* synthetic */ boolean b(Object obj, b4.i iVar) {
        switch (this.f5551a) {
            case 0:
                androidx.emoji2.text.b.w(obj);
                break;
            default:
                break;
        }
        return true;
    }

    public d c(ImageDecoder.Source source, int i9, int i10, b4.i iVar) {
        Bitmap decodeBitmap;
        decodeBitmap = ImageDecoder.decodeBitmap(source, new j4.b(i9, i10, iVar));
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            Log.v("BitmapImageDecoder", "Decoded [" + decodeBitmap.getWidth() + "x" + decodeBitmap.getHeight() + "] for [" + i9 + "x" + i10 + "]");
        }
        return new d(decodeBitmap, (d4.t) this.f5552b);
    }

    public c(e4.a aVar) {
        this.f5551a = 1;
        this.f5552b = aVar;
    }
}
