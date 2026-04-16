package k4;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import java.io.File;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a0 implements d4.a0 {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f5545i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f5546j;

    public a0(byte[] bArr) {
        this.f5545i = 1;
        w4.f.c(bArr, "Argument must not be null");
        this.f5546j = bArr;
    }

    @Override // d4.a0
    public final Class c() {
        switch (this.f5545i) {
            case 0:
                return Bitmap.class;
            case 1:
                return byte[].class;
            case 2:
                return Drawable.class;
            default:
                return ((File) this.f5546j).getClass();
        }
    }

    @Override // d4.a0
    public final void d() {
        switch (this.f5545i) {
            case 2:
                ((AnimatedImageDrawable) this.f5546j).stop();
                ((AnimatedImageDrawable) this.f5546j).clearAnimationCallbacks();
                break;
        }
    }

    @Override // d4.a0
    public final Object get() {
        switch (this.f5545i) {
            case 0:
                return (Bitmap) this.f5546j;
            case 1:
                return (byte[]) this.f5546j;
            case 2:
                return (AnimatedImageDrawable) this.f5546j;
            default:
                return (File) this.f5546j;
        }
    }

    @Override // d4.a0
    public final int getSize() {
        int intrinsicWidth;
        int intrinsicHeight;
        switch (this.f5545i) {
            case 0:
                return w4.n.c((Bitmap) this.f5546j);
            case 1:
                return ((byte[]) this.f5546j).length;
            case 2:
                intrinsicWidth = ((AnimatedImageDrawable) this.f5546j).getIntrinsicWidth();
                intrinsicHeight = ((AnimatedImageDrawable) this.f5546j).getIntrinsicHeight();
                return w4.n.d(Bitmap.Config.ARGB_8888) * intrinsicHeight * intrinsicWidth * 2;
            default:
                return 1;
        }
    }

    public /* synthetic */ a0(Object obj, int i9) {
        this.f5545i = i9;
        this.f5546j = obj;
    }

    public a0(File file) {
        this.f5545i = 3;
        w4.f.c(file, "Argument must not be null");
        this.f5546j = file;
    }

    private final void a() {
    }

    private final void b() {
    }

    private final void e() {
    }
}
