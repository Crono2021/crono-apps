package j4;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import b4.h;
import b4.i;
import b4.j;
import k4.o;
import k4.q;
import k4.w;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements ImageDecoder.OnHeaderDecodedListener {

    /* renamed from: a, reason: collision with root package name */
    public final w f5427a = w.a();

    /* renamed from: b, reason: collision with root package name */
    public final int f5428b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5429c;

    /* renamed from: d, reason: collision with root package name */
    public final b4.a f5430d;

    /* renamed from: e, reason: collision with root package name */
    public final o f5431e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f5432f;

    /* renamed from: g, reason: collision with root package name */
    public final j f5433g;

    public b(int i9, int i10, i iVar) {
        this.f5428b = i9;
        this.f5429c = i10;
        this.f5430d = (b4.a) iVar.c(q.f5582f);
        this.f5431e = (o) iVar.c(o.f5580g);
        h hVar = q.f5584i;
        this.f5432f = iVar.c(hVar) != null && ((Boolean) iVar.c(hVar)).booleanValue();
        this.f5433g = (j) iVar.c(q.f5583g);
    }

    @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        Size size;
        ColorSpace colorSpace;
        ColorSpace.Named named;
        ColorSpace colorSpace2;
        ColorSpace colorSpace3;
        ColorSpace colorSpace4;
        boolean isWideGamut;
        ColorSpace.Named unused;
        if (this.f5427a.c(this.f5428b, this.f5429c, this.f5432f, false)) {
            imageDecoder.setAllocator(3);
        } else {
            imageDecoder.setAllocator(1);
        }
        if (this.f5430d == b4.a.f1321j) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener(new a());
        size = imageInfo.getSize();
        int i9 = this.f5428b;
        if (i9 == Integer.MIN_VALUE) {
            i9 = size.getWidth();
        }
        int i10 = this.f5429c;
        if (i10 == Integer.MIN_VALUE) {
            i10 = size.getHeight();
        }
        float b9 = this.f5431e.b(size.getWidth(), size.getHeight(), i9, i10);
        int round = Math.round(size.getWidth() * b9);
        int round2 = Math.round(size.getHeight() * b9);
        if (Log.isLoggable("ImageDecoder", 2)) {
            Log.v("ImageDecoder", "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + round + "x" + round2 + "] scaleFactor: " + b9);
        }
        imageDecoder.setTargetSize(round, round2);
        j jVar = this.f5433g;
        if (jVar != null) {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 < 28) {
                if (i11 >= 26) {
                    unused = ColorSpace.Named.SRGB;
                    colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
                    imageDecoder.setTargetColorSpace(colorSpace);
                    return;
                }
                return;
            }
            if (jVar == j.f1332i) {
                colorSpace3 = imageInfo.getColorSpace();
                if (colorSpace3 != null) {
                    colorSpace4 = imageInfo.getColorSpace();
                    isWideGamut = colorSpace4.isWideGamut();
                    if (isWideGamut) {
                        named = ColorSpace.Named.DISPLAY_P3;
                        colorSpace2 = ColorSpace.get(named);
                        imageDecoder.setTargetColorSpace(colorSpace2);
                    }
                }
            }
            named = ColorSpace.Named.SRGB;
            colorSpace2 = ColorSpace.get(named);
            imageDecoder.setTargetColorSpace(colorSpace2);
        }
    }
}
