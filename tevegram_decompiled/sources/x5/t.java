package x5;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.WeakHashMap;
import n.e1;
import n0.d0;
import n0.f0;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class t extends LinearLayout {

    /* renamed from: i, reason: collision with root package name */
    public final TextInputLayout f10202i;

    /* renamed from: j, reason: collision with root package name */
    public final e1 f10203j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f10204k;

    /* renamed from: l, reason: collision with root package name */
    public final CheckableImageButton f10205l;

    /* renamed from: m, reason: collision with root package name */
    public ColorStateList f10206m;

    /* renamed from: n, reason: collision with root package name */
    public PorterDuff.Mode f10207n;

    /* renamed from: o, reason: collision with root package name */
    public int f10208o;

    /* renamed from: p, reason: collision with root package name */
    public ImageView.ScaleType f10209p;

    /* renamed from: q, reason: collision with root package name */
    public View.OnLongClickListener f10210q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f10211r;

    public t(TextInputLayout textInputLayout, androidx.fragment.app.g gVar) {
        super(textInputLayout.getContext());
        CharSequence text;
        Drawable b9;
        this.f10202i = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(2131558451, (ViewGroup) this, false);
        this.f10205l = checkableImageButton;
        if (Build.VERSION.SDK_INT <= 22) {
            Context context = checkableImageButton.getContext();
            int applyDimension = (int) TypedValue.applyDimension(1, 4, checkableImageButton.getContext().getResources().getDisplayMetrics());
            int[] iArr = s5.b.f8857a;
            b9 = s5.a.b(context, applyDimension);
            checkableImageButton.setBackground(b9);
        }
        e1 e1Var = new e1(getContext(), null);
        this.f10203j = e1Var;
        if (com.bumptech.glide.d.L(getContext())) {
            n0.l.g((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), 0);
        }
        View.OnLongClickListener onLongClickListener = this.f10210q;
        checkableImageButton.setOnClickListener(null);
        com.bumptech.glide.d.Z(checkableImageButton, onLongClickListener);
        this.f10210q = null;
        checkableImageButton.setOnLongClickListener(null);
        com.bumptech.glide.d.Z(checkableImageButton, null);
        TypedArray typedArray = (TypedArray) gVar.f729k;
        if (typedArray.hasValue(69)) {
            this.f10206m = com.bumptech.glide.d.C(getContext(), gVar, 69);
        }
        if (typedArray.hasValue(70)) {
            this.f10207n = o5.o.g(typedArray.getInt(70, -1), null);
        }
        if (typedArray.hasValue(66)) {
            b(gVar.Q(66));
            if (typedArray.hasValue(65) && checkableImageButton.getContentDescription() != (text = typedArray.getText(65))) {
                checkableImageButton.setContentDescription(text);
            }
            checkableImageButton.setCheckable(typedArray.getBoolean(64, true));
        }
        int dimensionPixelSize = typedArray.getDimensionPixelSize(67, getResources().getDimensionPixelSize(2131165918));
        if (dimensionPixelSize < 0) {
            m7.c.n("startIconSize cannot be less than 0");
            throw null;
        }
        if (dimensionPixelSize != this.f10208o) {
            this.f10208o = dimensionPixelSize;
            checkableImageButton.setMinimumWidth(dimensionPixelSize);
            checkableImageButton.setMinimumHeight(dimensionPixelSize);
        }
        if (typedArray.hasValue(68)) {
            ImageView.ScaleType k3 = com.bumptech.glide.d.k(typedArray.getInt(68, -1));
            this.f10209p = k3;
            checkableImageButton.setScaleType(k3);
        }
        e1Var.setVisibility(8);
        e1Var.setId(2131362473);
        e1Var.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        WeakHashMap weakHashMap = t0.f7209a;
        f0.f(e1Var, 1);
        android.support.v4.media.session.b.t0(e1Var, typedArray.getResourceId(60, 0));
        if (typedArray.hasValue(61)) {
            e1Var.setTextColor(gVar.O(61));
        }
        CharSequence text2 = typedArray.getText(59);
        this.f10204k = TextUtils.isEmpty(text2) ? null : text2;
        e1Var.setText(text2);
        e();
        addView(checkableImageButton);
        addView(e1Var);
    }

    public final int a() {
        int i9;
        CheckableImageButton checkableImageButton = this.f10205l;
        if (checkableImageButton.getVisibility() == 0) {
            i9 = n0.l.b((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()) + checkableImageButton.getMeasuredWidth();
        } else {
            i9 = 0;
        }
        WeakHashMap weakHashMap = t0.f7209a;
        return d0.f(this.f10203j) + d0.f(this) + i9;
    }

    public final void b(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.f10205l;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = this.f10206m;
            PorterDuff.Mode mode = this.f10207n;
            TextInputLayout textInputLayout = this.f10202i;
            com.bumptech.glide.d.c(textInputLayout, checkableImageButton, colorStateList, mode);
            c(true);
            com.bumptech.glide.d.V(textInputLayout, checkableImageButton, this.f10206m);
            return;
        }
        c(false);
        View.OnLongClickListener onLongClickListener = this.f10210q;
        checkableImageButton.setOnClickListener(null);
        com.bumptech.glide.d.Z(checkableImageButton, onLongClickListener);
        this.f10210q = null;
        checkableImageButton.setOnLongClickListener(null);
        com.bumptech.glide.d.Z(checkableImageButton, null);
        if (checkableImageButton.getContentDescription() != null) {
            checkableImageButton.setContentDescription(null);
        }
    }

    public final void c(boolean z8) {
        CheckableImageButton checkableImageButton = this.f10205l;
        if ((checkableImageButton.getVisibility() == 0) != z8) {
            checkableImageButton.setVisibility(z8 ? 0 : 8);
            d();
            e();
        }
    }

    public final void d() {
        int f9;
        EditText editText = this.f10202i.f2144l;
        if (editText == null) {
            return;
        }
        if (this.f10205l.getVisibility() == 0) {
            f9 = 0;
        } else {
            WeakHashMap weakHashMap = t0.f7209a;
            f9 = d0.f(editText);
        }
        int compoundPaddingTop = editText.getCompoundPaddingTop();
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(2131165787);
        int compoundPaddingBottom = editText.getCompoundPaddingBottom();
        WeakHashMap weakHashMap2 = t0.f7209a;
        d0.k(this.f10203j, f9, compoundPaddingTop, dimensionPixelSize, compoundPaddingBottom);
    }

    public final void e() {
        int i9 = (this.f10204k == null || this.f10211r) ? 8 : 0;
        setVisibility((this.f10205l.getVisibility() == 0 || i9 == 0) ? 0 : 8);
        this.f10203j.setVisibility(i9);
        this.f10202i.q();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i9, int i10) {
        super.onMeasure(i9, i10);
        d();
    }
}
