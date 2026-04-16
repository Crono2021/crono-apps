package n;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class p extends Button implements r0.v {

    /* renamed from: i, reason: collision with root package name */
    public final o f6995i;

    /* renamed from: j, reason: collision with root package name */
    public final b1 f6996j;

    /* renamed from: k, reason: collision with root package name */
    public w f6997k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(Context context, AttributeSet attributeSet, int i9) {
        super(context, attributeSet, i9);
        n3.a(context);
        m3.a(this, getContext());
        o oVar = new o(this);
        this.f6995i = oVar;
        oVar.k(attributeSet, i9);
        b1 b1Var = new b1(this);
        this.f6996j = b1Var;
        b1Var.f(attributeSet, i9);
        b1Var.b();
        getEmojiTextViewHelper().b(attributeSet, i9);
    }

    private w getEmojiTextViewHelper() {
        if (this.f6997k == null) {
            this.f6997k = new w(this);
        }
        return this.f6997k;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        o oVar = this.f6995i;
        if (oVar != null) {
            oVar.a();
        }
        b1 b1Var = this.f6996j;
        if (b1Var != null) {
            b1Var.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (f4.f6864b) {
            return super.getAutoSizeMaxTextSize();
        }
        b1 b1Var = this.f6996j;
        if (b1Var != null) {
            return Math.round(b1Var.f6796i.f6954e);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (f4.f6864b) {
            return super.getAutoSizeMinTextSize();
        }
        b1 b1Var = this.f6996j;
        if (b1Var != null) {
            return Math.round(b1Var.f6796i.f6953d);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (f4.f6864b) {
            return super.getAutoSizeStepGranularity();
        }
        b1 b1Var = this.f6996j;
        if (b1Var != null) {
            return Math.round(b1Var.f6796i.f6952c);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (f4.f6864b) {
            return super.getAutoSizeTextAvailableSizes();
        }
        b1 b1Var = this.f6996j;
        return b1Var != null ? b1Var.f6796i.f6955f : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (f4.f6864b) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        b1 b1Var = this.f6996j;
        if (b1Var != null) {
            return b1Var.f6796i.f6950a;
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return android.support.v4.media.session.b.A0(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        o oVar = this.f6995i;
        if (oVar != null) {
            return oVar.h();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        o oVar = this.f6995i;
        if (oVar != null) {
            return oVar.i();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f6996j.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f6996j.e();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        super.onLayout(z8, i9, i10, i11, i12);
        b1 b1Var = this.f6996j;
        if (b1Var == null || f4.f6864b) {
            return;
        }
        b1Var.f6796i.a();
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i9, int i10, int i11) {
        super.onTextChanged(charSequence, i9, i10, i11);
        b1 b1Var = this.f6996j;
        if (b1Var != null) {
            l1 l1Var = b1Var.f6796i;
            if (f4.f6864b || !l1Var.f()) {
                return;
            }
            l1Var.a();
        }
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z8) {
        super.setAllCaps(z8);
        getEmojiTextViewHelper().c(z8);
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithConfiguration(int i9, int i10, int i11, int i12) {
        if (f4.f6864b) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i9, i10, i11, i12);
            return;
        }
        b1 b1Var = this.f6996j;
        if (b1Var != null) {
            b1Var.i(i9, i10, i11, i12);
        }
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i9) {
        if (f4.f6864b) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i9);
            return;
        }
        b1 b1Var = this.f6996j;
        if (b1Var != null) {
            b1Var.j(iArr, i9);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i9) {
        if (f4.f6864b) {
            super.setAutoSizeTextTypeWithDefaults(i9);
            return;
        }
        b1 b1Var = this.f6996j;
        if (b1Var != null) {
            b1Var.k(i9);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        o oVar = this.f6995i;
        if (oVar != null) {
            oVar.m();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i9) {
        super.setBackgroundResource(i9);
        o oVar = this.f6995i;
        if (oVar != null) {
            oVar.n(i9);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(android.support.v4.media.session.b.C0(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z8) {
        getEmojiTextViewHelper().d(z8);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportAllCaps(boolean z8) {
        b1 b1Var = this.f6996j;
        if (b1Var != null) {
            b1Var.f6789a.setAllCaps(z8);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        o oVar = this.f6995i;
        if (oVar != null) {
            oVar.s(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        o oVar = this.f6995i;
        if (oVar != null) {
            oVar.t(mode);
        }
    }

    @Override // r0.v
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        b1 b1Var = this.f6996j;
        b1Var.l(colorStateList);
        b1Var.b();
    }

    @Override // r0.v
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        b1 b1Var = this.f6996j;
        b1Var.m(mode);
        b1Var.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i9) {
        super.setTextAppearance(context, i9);
        b1 b1Var = this.f6996j;
        if (b1Var != null) {
            b1Var.g(context, i9);
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i9, float f9) {
        boolean z8 = f4.f6864b;
        if (z8) {
            super.setTextSize(i9, f9);
            return;
        }
        b1 b1Var = this.f6996j;
        if (b1Var != null) {
            l1 l1Var = b1Var.f6796i;
            if (z8 || l1Var.f()) {
                return;
            }
            l1Var.g(i9, f9);
        }
    }
}
