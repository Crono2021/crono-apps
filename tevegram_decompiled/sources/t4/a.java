package t4;

import a0.h;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.util.ArrayList;
import w4.f;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements b {

    /* renamed from: i, reason: collision with root package name */
    public final ImageView f8961i;

    /* renamed from: j, reason: collision with root package name */
    public final c f8962j;

    /* renamed from: k, reason: collision with root package name */
    public Animatable f8963k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f8964l;

    public a(ImageView imageView, int i9) {
        this.f8964l = i9;
        f.c(imageView, "Argument must not be null");
        this.f8961i = imageView;
        this.f8962j = new c(imageView);
    }

    @Override // t4.b
    public final void a(s4.c cVar) {
        this.f8961i.setTag(2131362113, cVar);
    }

    @Override // t4.b
    public final void b(Drawable drawable) {
        l(null);
        this.f8963k = null;
        this.f8961i.setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.manager.h
    public final void c() {
        Animatable animatable = this.f8963k;
        if (animatable != null) {
            animatable.stop();
        }
    }

    @Override // t4.b
    public final void d(s4.f fVar) {
        this.f8962j.f8967b.remove(fVar);
    }

    @Override // t4.b
    public final void e(s4.f fVar) {
        c cVar = this.f8962j;
        ArrayList arrayList = cVar.f8967b;
        View view = cVar.f8966a;
        int paddingRight = view.getPaddingRight() + view.getPaddingLeft();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int a9 = cVar.a(view.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingRight);
        int paddingBottom = view.getPaddingBottom() + view.getPaddingTop();
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        int a10 = cVar.a(view.getHeight(), layoutParams2 != null ? layoutParams2.height : 0, paddingBottom);
        if ((a9 > 0 || a9 == Integer.MIN_VALUE) && (a10 > 0 || a10 == Integer.MIN_VALUE)) {
            fVar.l(a9, a10);
            return;
        }
        if (!arrayList.contains(fVar)) {
            arrayList.add(fVar);
        }
        if (cVar.f8968c == null) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            h hVar = new h(cVar);
            cVar.f8968c = hVar;
            viewTreeObserver.addOnPreDrawListener(hVar);
        }
    }

    @Override // t4.b
    public final void f(Drawable drawable) {
        l(null);
        this.f8963k = null;
        this.f8961i.setImageDrawable(drawable);
    }

    @Override // t4.b
    public final s4.c g() {
        Object tag = this.f8961i.getTag(2131362113);
        if (tag == null) {
            return null;
        }
        if (tag instanceof s4.c) {
            return (s4.c) tag;
        }
        m7.c.n("You must not call setTag() on a view Glide is targeting");
        return null;
    }

    @Override // t4.b
    public final void h(Drawable drawable) {
        c cVar = this.f8962j;
        ViewTreeObserver viewTreeObserver = cVar.f8966a.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(cVar.f8968c);
        }
        cVar.f8968c = null;
        cVar.f8967b.clear();
        Animatable animatable = this.f8963k;
        if (animatable != null) {
            animatable.stop();
        }
        l(null);
        this.f8963k = null;
        this.f8961i.setImageDrawable(drawable);
    }

    @Override // t4.b
    public final void i(Object obj) {
        l(obj);
        if (!(obj instanceof Animatable)) {
            this.f8963k = null;
            return;
        }
        Animatable animatable = (Animatable) obj;
        this.f8963k = animatable;
        animatable.start();
    }

    @Override // com.bumptech.glide.manager.h
    public final void j() {
        Animatable animatable = this.f8963k;
        if (animatable != null) {
            animatable.start();
        }
    }

    public final void l(Object obj) {
        switch (this.f8964l) {
            case 0:
                this.f8961i.setImageBitmap((Bitmap) obj);
                break;
            default:
                this.f8961i.setImageDrawable((Drawable) obj);
                break;
        }
    }

    public final String toString() {
        return "Target for: " + this.f8961i;
    }

    @Override // com.bumptech.glide.manager.h
    public final void k() {
    }
}
