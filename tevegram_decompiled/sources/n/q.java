package n;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.CheckBox;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class q extends CheckBox implements r0.u, r0.v {

    /* renamed from: i, reason: collision with root package name */
    public final s f7010i;

    /* renamed from: j, reason: collision with root package name */
    public final o f7011j;

    /* renamed from: k, reason: collision with root package name */
    public final b1 f7012k;

    /* renamed from: l, reason: collision with root package name */
    public w f7013l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(Context context, AttributeSet attributeSet, int i9) {
        super(context, attributeSet, i9);
        n3.a(context);
        m3.a(this, getContext());
        s sVar = new s(this);
        this.f7010i = sVar;
        sVar.d(attributeSet, i9);
        o oVar = new o(this);
        this.f7011j = oVar;
        oVar.k(attributeSet, i9);
        b1 b1Var = new b1(this);
        this.f7012k = b1Var;
        b1Var.f(attributeSet, i9);
        getEmojiTextViewHelper().b(attributeSet, i9);
    }

    private w getEmojiTextViewHelper() {
        if (this.f7013l == null) {
            this.f7013l = new w(this);
        }
        return this.f7013l;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        o oVar = this.f7011j;
        if (oVar != null) {
            oVar.a();
        }
        b1 b1Var = this.f7012k;
        if (b1Var != null) {
            b1Var.b();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        s sVar = this.f7010i;
        if (sVar != null) {
            sVar.getClass();
        }
        return compoundPaddingLeft;
    }

    public ColorStateList getSupportBackgroundTintList() {
        o oVar = this.f7011j;
        if (oVar != null) {
            return oVar.h();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        o oVar = this.f7011j;
        if (oVar != null) {
            return oVar.i();
        }
        return null;
    }

    @Override // r0.u
    public ColorStateList getSupportButtonTintList() {
        s sVar = this.f7010i;
        if (sVar != null) {
            return (ColorStateList) sVar.f7025a;
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        s sVar = this.f7010i;
        if (sVar != null) {
            return (PorterDuff.Mode) sVar.f7026b;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f7012k.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f7012k.e();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z8) {
        super.setAllCaps(z8);
        getEmojiTextViewHelper().c(z8);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        o oVar = this.f7011j;
        if (oVar != null) {
            oVar.m();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i9) {
        super.setBackgroundResource(i9);
        o oVar = this.f7011j;
        if (oVar != null) {
            oVar.n(i9);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        s sVar = this.f7010i;
        if (sVar != null) {
            if (sVar.f7029e) {
                sVar.f7029e = false;
            } else {
                sVar.f7029e = true;
                sVar.a();
            }
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        b1 b1Var = this.f7012k;
        if (b1Var != null) {
            b1Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        b1 b1Var = this.f7012k;
        if (b1Var != null) {
            b1Var.b();
        }
    }

    public void setEmojiCompatEnabled(boolean z8) {
        getEmojiTextViewHelper().d(z8);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        o oVar = this.f7011j;
        if (oVar != null) {
            oVar.s(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        o oVar = this.f7011j;
        if (oVar != null) {
            oVar.t(mode);
        }
    }

    @Override // r0.u
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        s sVar = this.f7010i;
        if (sVar != null) {
            sVar.f7025a = colorStateList;
            sVar.f7027c = true;
            sVar.a();
        }
    }

    @Override // r0.u
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        s sVar = this.f7010i;
        if (sVar != null) {
            sVar.f7026b = mode;
            sVar.f7028d = true;
            sVar.a();
        }
    }

    @Override // r0.v
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        b1 b1Var = this.f7012k;
        b1Var.l(colorStateList);
        b1Var.b();
    }

    @Override // r0.v
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        b1 b1Var = this.f7012k;
        b1Var.m(mode);
        b1Var.b();
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i9) {
        setButtonDrawable(android.support.v4.media.session.b.I(getContext(), i9));
    }

    public q(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130968744);
    }
}
