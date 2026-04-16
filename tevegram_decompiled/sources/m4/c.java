package m4;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.m;
import d4.a0;
import d4.x;
import o4.h;
import w4.f;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c implements a0, x {

    /* renamed from: i, reason: collision with root package name */
    public final Drawable f6643i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f6644j;

    public c(Drawable drawable, int i9) {
        this.f6644j = i9;
        f.c(drawable, "Argument must not be null");
        this.f6643i = drawable;
    }

    @Override // d4.x
    public void a() {
        switch (this.f6644j) {
            case 1:
                ((h) ((o4.c) this.f6643i).f7890i.f7889b).f7922l.prepareToDraw();
                break;
            default:
                Drawable drawable = this.f6643i;
                if (!(drawable instanceof BitmapDrawable)) {
                    if (drawable instanceof o4.c) {
                        ((h) ((o4.c) drawable).f7890i.f7889b).f7922l.prepareToDraw();
                        break;
                    }
                } else {
                    ((BitmapDrawable) drawable).getBitmap().prepareToDraw();
                    break;
                }
                break;
        }
    }

    @Override // d4.a0
    public final Class c() {
        switch (this.f6644j) {
            case 0:
                return this.f6643i.getClass();
            default:
                return o4.c.class;
        }
    }

    @Override // d4.a0
    public final void d() {
        e4.f fVar;
        e4.f fVar2;
        e4.f fVar3;
        switch (this.f6644j) {
            case 0:
                break;
            default:
                o4.c cVar = (o4.c) this.f6643i;
                cVar.stop();
                cVar.f7893l = true;
                h hVar = (h) cVar.f7890i.f7889b;
                m mVar = hVar.f7915d;
                hVar.f7914c.clear();
                Bitmap bitmap = hVar.f7922l;
                if (bitmap != null) {
                    hVar.f7916e.g(bitmap);
                    hVar.f7922l = null;
                }
                hVar.f7917f = false;
                o4.f fVar4 = hVar.f7919i;
                if (fVar4 != null) {
                    mVar.l(fVar4);
                    hVar.f7919i = null;
                }
                o4.f fVar5 = hVar.f7921k;
                if (fVar5 != null) {
                    mVar.l(fVar5);
                    hVar.f7921k = null;
                }
                o4.f fVar6 = hVar.f7923m;
                if (fVar6 != null) {
                    mVar.l(fVar6);
                    hVar.f7923m = null;
                }
                a4.d dVar = hVar.f7912a;
                m1.b bVar = dVar.f153c;
                dVar.f161l = null;
                byte[] bArr = dVar.f158i;
                if (bArr != null && (fVar3 = (e4.f) bVar.f6511k) != null) {
                    fVar3.h(bArr);
                }
                int[] iArr = dVar.f159j;
                if (iArr != null && (fVar2 = (e4.f) bVar.f6511k) != null) {
                    fVar2.h(iArr);
                }
                Bitmap bitmap2 = dVar.f162m;
                if (bitmap2 != null) {
                    ((e4.a) bVar.f6510j).g(bitmap2);
                }
                dVar.f162m = null;
                dVar.f154d = null;
                dVar.f168s = null;
                byte[] bArr2 = dVar.f155e;
                if (bArr2 != null && (fVar = (e4.f) bVar.f6511k) != null) {
                    fVar.h(bArr2);
                }
                hVar.f7920j = true;
                break;
        }
    }

    @Override // d4.a0
    public final Object get() {
        Drawable drawable = this.f6643i;
        Drawable.ConstantState constantState = drawable.getConstantState();
        return constantState == null ? drawable : constantState.newDrawable();
    }

    @Override // d4.a0
    public final int getSize() {
        switch (this.f6644j) {
            case 0:
                Drawable drawable = this.f6643i;
                return Math.max(1, drawable.getIntrinsicHeight() * drawable.getIntrinsicWidth() * 4);
            default:
                h hVar = (h) ((o4.c) this.f6643i).f7890i.f7889b;
                a4.d dVar = hVar.f7912a;
                return (dVar.f159j.length * 4) + dVar.f154d.limit() + dVar.f158i.length + hVar.f7924n;
        }
    }

    private final void b() {
    }
}
