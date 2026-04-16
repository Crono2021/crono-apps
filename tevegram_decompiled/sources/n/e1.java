package n;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class e1 extends TextView implements r0.v {

    /* renamed from: i, reason: collision with root package name */
    public final o f6850i;

    /* renamed from: j, reason: collision with root package name */
    public final b1 f6851j;

    /* renamed from: k, reason: collision with root package name */
    public final c0 f6852k;

    /* renamed from: l, reason: collision with root package name */
    public w f6853l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f6854m;

    /* renamed from: n, reason: collision with root package name */
    public i7.x f6855n;

    /* renamed from: o, reason: collision with root package name */
    public Future f6856o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e1(Context context, AttributeSet attributeSet, int i9) {
        super(context, attributeSet, i9);
        n3.a(context);
        this.f6854m = false;
        this.f6855n = null;
        m3.a(this, getContext());
        o oVar = new o(this);
        this.f6850i = oVar;
        oVar.k(attributeSet, i9);
        b1 b1Var = new b1(this);
        this.f6851j = b1Var;
        b1Var.f(attributeSet, i9);
        b1Var.b();
        c0 c0Var = new c0();
        c0Var.f6817b = this;
        this.f6852k = c0Var;
        getEmojiTextViewHelper().b(attributeSet, i9);
    }

    private w getEmojiTextViewHelper() {
        if (this.f6853l == null) {
            this.f6853l = new w(this);
        }
        return this.f6853l;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        o oVar = this.f6850i;
        if (oVar != null) {
            oVar.a();
        }
        b1 b1Var = this.f6851j;
        if (b1Var != null) {
            b1Var.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (f4.f6864b) {
            return super.getAutoSizeMaxTextSize();
        }
        b1 b1Var = this.f6851j;
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
        b1 b1Var = this.f6851j;
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
        b1 b1Var = this.f6851j;
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
        b1 b1Var = this.f6851j;
        return b1Var != null ? b1Var.f6796i.f6955f : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (f4.f6864b) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        b1 b1Var = this.f6851j;
        if (b1Var != null) {
            return b1Var.f6796i.f6950a;
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return android.support.v4.media.session.b.A0(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
    }

    public c1 getSuperCaller() {
        if (this.f6855n == null) {
            int i9 = Build.VERSION.SDK_INT;
            if (i9 >= 28) {
                this.f6855n = new d1(this);
            } else if (i9 >= 26) {
                this.f6855n = new i7.x(this, 7);
            }
        }
        return this.f6855n;
    }

    public ColorStateList getSupportBackgroundTintList() {
        o oVar = this.f6850i;
        if (oVar != null) {
            return oVar.h();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        o oVar = this.f6850i;
        if (oVar != null) {
            return oVar.i();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f6851j.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f6851j.e();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        Future future = this.f6856o;
        if (future != null) {
            try {
                this.f6856o = null;
                if (future.get() != null) {
                    throw new ClassCastException();
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    throw null;
                }
                android.support.v4.media.session.b.R(this);
                throw null;
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        c0 c0Var;
        if (Build.VERSION.SDK_INT >= 28 || (c0Var = this.f6852k) == null) {
            return super.getTextClassifier();
        }
        TextClassifier textClassifier = (TextClassifier) c0Var.f6818c;
        return textClassifier == null ? u0.a((TextView) c0Var.f6817b) : textClassifier;
    }

    public l0.f getTextMetricsParamsCompat() {
        return android.support.v4.media.session.b.R(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f6851j.getClass();
        b1.h(editorInfo, onCreateInputConnection, this);
        com.bumptech.glide.d.O(editorInfo, onCreateInputConnection, this);
        return onCreateInputConnection;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        super.onLayout(z8, i9, i10, i11, i12);
        b1 b1Var = this.f6851j;
        if (b1Var == null || f4.f6864b) {
            return;
        }
        b1Var.f6796i.a();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i9, int i10) {
        Future future = this.f6856o;
        if (future != null) {
            try {
                this.f6856o = null;
                if (future.get() != null) {
                    throw new ClassCastException();
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    throw null;
                }
                android.support.v4.media.session.b.R(this);
                throw null;
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        super.onMeasure(i9, i10);
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i9, int i10, int i11) {
        super.onTextChanged(charSequence, i9, i10, i11);
        b1 b1Var = this.f6851j;
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
        b1 b1Var = this.f6851j;
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
        b1 b1Var = this.f6851j;
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
        b1 b1Var = this.f6851j;
        if (b1Var != null) {
            b1Var.k(i9);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        o oVar = this.f6850i;
        if (oVar != null) {
            oVar.m();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i9) {
        super.setBackgroundResource(i9);
        o oVar = this.f6850i;
        if (oVar != null) {
            oVar.n(i9);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        b1 b1Var = this.f6851j;
        if (b1Var != null) {
            b1Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        b1 b1Var = this.f6851j;
        if (b1Var != null) {
            b1Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i9, int i10, int i11, int i12) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i9 != 0 ? android.support.v4.media.session.b.I(context, i9) : null, i10 != 0 ? android.support.v4.media.session.b.I(context, i10) : null, i11 != 0 ? android.support.v4.media.session.b.I(context, i11) : null, i12 != 0 ? android.support.v4.media.session.b.I(context, i12) : null);
        b1 b1Var = this.f6851j;
        if (b1Var != null) {
            b1Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i9, int i10, int i11, int i12) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i9 != 0 ? android.support.v4.media.session.b.I(context, i9) : null, i10 != 0 ? android.support.v4.media.session.b.I(context, i10) : null, i11 != 0 ? android.support.v4.media.session.b.I(context, i11) : null, i12 != 0 ? android.support.v4.media.session.b.I(context, i12) : null);
        b1 b1Var = this.f6851j;
        if (b1Var != null) {
            b1Var.b();
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

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i9) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().r(i9);
        } else {
            android.support.v4.media.session.b.q0(this, i9);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i9) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().g(i9);
        } else {
            android.support.v4.media.session.b.r0(this, i9);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i9) {
        android.support.v4.media.session.b.p(i9);
        if (i9 != getPaint().getFontMetricsInt(null)) {
            setLineSpacing(i9 - r0, 1.0f);
        }
    }

    public void setPrecomputedText(l0.g gVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            throw null;
        }
        android.support.v4.media.session.b.R(this);
        throw null;
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        o oVar = this.f6850i;
        if (oVar != null) {
            oVar.s(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        o oVar = this.f6850i;
        if (oVar != null) {
            oVar.t(mode);
        }
    }

    @Override // r0.v
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        b1 b1Var = this.f6851j;
        b1Var.l(colorStateList);
        b1Var.b();
    }

    @Override // r0.v
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        b1 b1Var = this.f6851j;
        b1Var.m(mode);
        b1Var.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i9) {
        super.setTextAppearance(context, i9);
        b1 b1Var = this.f6851j;
        if (b1Var != null) {
            b1Var.g(context, i9);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        c0 c0Var;
        if (Build.VERSION.SDK_INT >= 28 || (c0Var = this.f6852k) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            c0Var.f6818c = textClassifier;
        }
    }

    public void setTextFuture(Future<l0.g> future) {
        this.f6856o = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(l0.f fVar) {
        TextDirectionHeuristic textDirectionHeuristic;
        TextDirectionHeuristic textDirectionHeuristic2 = fVar.f5749b;
        TextPaint textPaint = fVar.f5748a;
        TextDirectionHeuristic textDirectionHeuristic3 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        int i9 = 1;
        if (textDirectionHeuristic2 != textDirectionHeuristic3 && textDirectionHeuristic2 != (textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
            if (textDirectionHeuristic2 == TextDirectionHeuristics.ANYRTL_LTR) {
                i9 = 2;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LTR) {
                i9 = 3;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.RTL) {
                i9 = 4;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LOCALE) {
                i9 = 5;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic) {
                i9 = 6;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic3) {
                i9 = 7;
            }
        }
        r0.o.h(this, i9);
        if (Build.VERSION.SDK_INT >= 23) {
            getPaint().set(textPaint);
            r0.p.e(this, fVar.f5750c);
            r0.p.h(this, fVar.f5751d);
        } else {
            float textScaleX = textPaint.getTextScaleX();
            getPaint().set(textPaint);
            if (textScaleX == getTextScaleX()) {
                setTextScaleX((textScaleX / 2.0f) + 1.0f);
            }
            setTextScaleX(textScaleX);
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i9, float f9) {
        boolean z8 = f4.f6864b;
        if (z8) {
            super.setTextSize(i9, f9);
            return;
        }
        b1 b1Var = this.f6851j;
        if (b1Var != null) {
            l1 l1Var = b1Var.f6796i;
            if (z8 || l1Var.f()) {
                return;
            }
            l1Var.g(i9, f9);
        }
    }

    @Override // android.widget.TextView
    public final void setTypeface(Typeface typeface, int i9) {
        Typeface typeface2;
        if (this.f6854m) {
            return;
        }
        if (typeface == null || i9 <= 0) {
            typeface2 = null;
        } else {
            Context context = getContext();
            android.support.v4.media.session.b bVar = f0.g.f3200a;
            if (context == null) {
                m7.c.n("Context cannot be null");
                return;
            }
            typeface2 = Typeface.create(typeface, i9);
        }
        this.f6854m = true;
        if (typeface2 != null) {
            typeface = typeface2;
        }
        try {
            super.setTypeface(typeface, i9);
        } finally {
            this.f6854m = false;
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        b1 b1Var = this.f6851j;
        if (b1Var != null) {
            b1Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        b1 b1Var = this.f6851j;
        if (b1Var != null) {
            b1Var.b();
        }
    }

    public e1(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }
}
