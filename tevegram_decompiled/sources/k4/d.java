package k4;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d implements d4.a0, d4.x {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f5553i = 1;

    /* renamed from: j, reason: collision with root package name */
    public final Object f5554j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f5555k;

    public d(Bitmap bitmap, e4.a aVar) {
        w4.f.c(bitmap, "Bitmap must not be null");
        this.f5554j = bitmap;
        w4.f.c(aVar, "BitmapPool must not be null");
        this.f5555k = aVar;
    }

    public static d b(Bitmap bitmap, e4.a aVar) {
        if (bitmap == null) {
            return null;
        }
        return new d(bitmap, aVar);
    }

    @Override // d4.x
    public final void a() {
        switch (this.f5553i) {
            case 0:
                ((Bitmap) this.f5554j).prepareToDraw();
                break;
            default:
                d4.a0 a0Var = (d4.a0) this.f5555k;
                if (a0Var instanceof d4.x) {
                    ((d4.x) a0Var).a();
                    break;
                }
                break;
        }
    }

    @Override // d4.a0
    public final Class c() {
        switch (this.f5553i) {
            case 0:
                return Bitmap.class;
            default:
                return BitmapDrawable.class;
        }
    }

    @Override // d4.a0
    public final void d() {
        switch (this.f5553i) {
            case 0:
                ((e4.a) this.f5555k).g((Bitmap) this.f5554j);
                break;
            default:
                ((d4.a0) this.f5555k).d();
                break;
        }
    }

    @Override // d4.a0
    public final Object get() {
        switch (this.f5553i) {
            case 0:
                return (Bitmap) this.f5554j;
            default:
                return new BitmapDrawable((Resources) this.f5554j, (Bitmap) ((d4.a0) this.f5555k).get());
        }
    }

    @Override // d4.a0
    public final int getSize() {
        switch (this.f5553i) {
            case 0:
                return w4.n.c((Bitmap) this.f5554j);
            default:
                return ((d4.a0) this.f5555k).getSize();
        }
    }

    public d(Resources resources, d4.a0 a0Var) {
        w4.f.c(resources, "Argument must not be null");
        this.f5554j = resources;
        w4.f.c(a0Var, "Argument must not be null");
        this.f5555k = a0Var;
    }
}
