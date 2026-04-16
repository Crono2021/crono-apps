package n;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class y extends ImageView {

    /* renamed from: i, reason: collision with root package name */
    public final o f7104i;

    /* renamed from: j, reason: collision with root package name */
    public final g1.o f7105j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f7106k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(Context context, AttributeSet attributeSet, int i9) {
        super(context, attributeSet, i9);
        n3.a(context);
        this.f7106k = false;
        m3.a(this, getContext());
        o oVar = new o(this);
        this.f7104i = oVar;
        oVar.k(attributeSet, i9);
        g1.o oVar2 = new g1.o(this);
        this.f7105j = oVar2;
        oVar2.f(attributeSet, i9);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        o oVar = this.f7104i;
        if (oVar != null) {
            oVar.a();
        }
        g1.o oVar2 = this.f7105j;
        if (oVar2 != null) {
            oVar2.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        o oVar = this.f7104i;
        if (oVar != null) {
            return oVar.h();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        o oVar = this.f7104i;
        if (oVar != null) {
            return oVar.i();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        o3 o3Var;
        g1.o oVar = this.f7105j;
        if (oVar == null || (o3Var = (o3) oVar.f3694k) == null) {
            return null;
        }
        return o3Var.f6991a;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        o3 o3Var;
        g1.o oVar = this.f7105j;
        if (oVar == null || (o3Var = (o3) oVar.f3694k) == null) {
            return null;
        }
        return o3Var.f6992b;
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean hasOverlappingRendering() {
        return !(((ImageView) this.f7105j.f3693j).getBackground() instanceof RippleDrawable) && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        o oVar = this.f7104i;
        if (oVar != null) {
            oVar.m();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i9) {
        super.setBackgroundResource(i9);
        o oVar = this.f7104i;
        if (oVar != null) {
            oVar.n(i9);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        g1.o oVar = this.f7105j;
        if (oVar != null) {
            oVar.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        g1.o oVar = this.f7105j;
        if (oVar != null && drawable != null && !this.f7106k) {
            oVar.f3692i = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        if (oVar != null) {
            oVar.b();
            if (this.f7106k) {
                return;
            }
            ImageView imageView = (ImageView) oVar.f3693j;
            if (imageView.getDrawable() != null) {
                imageView.getDrawable().setLevel(oVar.f3692i);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i9) {
        super.setImageLevel(i9);
        this.f7106k = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i9) {
        g1.o oVar = this.f7105j;
        if (oVar != null) {
            ImageView imageView = (ImageView) oVar.f3693j;
            if (i9 != 0) {
                Drawable I = android.support.v4.media.session.b.I(imageView.getContext(), i9);
                if (I != null) {
                    r1.a(I);
                }
                imageView.setImageDrawable(I);
            } else {
                imageView.setImageDrawable(null);
            }
            oVar.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        g1.o oVar = this.f7105j;
        if (oVar != null) {
            oVar.b();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        o oVar = this.f7104i;
        if (oVar != null) {
            oVar.s(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        o oVar = this.f7104i;
        if (oVar != null) {
            oVar.t(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        g1.o oVar = this.f7105j;
        if (oVar != null) {
            if (((o3) oVar.f3694k) == null) {
                oVar.f3694k = new o3();
            }
            o3 o3Var = (o3) oVar.f3694k;
            o3Var.f6991a = colorStateList;
            o3Var.f6994d = true;
            oVar.b();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        g1.o oVar = this.f7105j;
        if (oVar != null) {
            if (((o3) oVar.f3694k) == null) {
                oVar.f3694k = new o3();
            }
            o3 o3Var = (o3) oVar.f3694k;
            o3Var.f6992b = mode;
            o3Var.f6993c = true;
            oVar.b();
        }
    }
}
