package w5;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bumptech.glide.d;
import java.util.WeakHashMap;
import n0.c0;
import n0.g0;
import n0.i0;
import n0.t0;
import o5.o;
import u5.g;
import u5.j;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class b extends FrameLayout {

    /* renamed from: q, reason: collision with root package name */
    public static final a f9954q = new a();

    /* renamed from: i, reason: collision with root package name */
    public final j f9955i;

    /* renamed from: j, reason: collision with root package name */
    public int f9956j;

    /* renamed from: k, reason: collision with root package name */
    public final float f9957k;

    /* renamed from: l, reason: collision with root package name */
    public final float f9958l;

    /* renamed from: m, reason: collision with root package name */
    public final int f9959m;

    /* renamed from: n, reason: collision with root package name */
    public final int f9960n;

    /* renamed from: o, reason: collision with root package name */
    public ColorStateList f9961o;

    /* renamed from: p, reason: collision with root package name */
    public PorterDuff.Mode f9962p;

    /* JADX WARN: Multi-variable type inference failed */
    public b(Context context, AttributeSet attributeSet) {
        super(z5.a.a(context, attributeSet, 0, 0), attributeSet);
        GradientDrawable gradientDrawable;
        Drawable f02;
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, y4.a.E);
        if (obtainStyledAttributes.hasValue(6)) {
            float dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(6, 0);
            WeakHashMap weakHashMap = t0.f7209a;
            i0.s(this, dimensionPixelSize);
        }
        this.f9956j = obtainStyledAttributes.getInt(2, 0);
        if (obtainStyledAttributes.hasValue(8) || obtainStyledAttributes.hasValue(9)) {
            this.f9955i = j.b(context2, attributeSet, 0, 0).a();
        }
        this.f9957k = obtainStyledAttributes.getFloat(3, 1.0f);
        setBackgroundTintList(d.B(context2, obtainStyledAttributes, 4));
        setBackgroundTintMode(o.g(obtainStyledAttributes.getInt(5, -1), PorterDuff.Mode.SRC_IN));
        this.f9958l = obtainStyledAttributes.getFloat(1, 1.0f);
        this.f9959m = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        this.f9960n = obtainStyledAttributes.getDimensionPixelSize(7, -1);
        obtainStyledAttributes.recycle();
        setOnTouchListener(f9954q);
        setFocusable(true);
        if (getBackground() == null) {
            int H = com.bumptech.glide.c.H(getBackgroundOverlayColorAlpha(), com.bumptech.glide.c.v(this, 2130968848), com.bumptech.glide.c.v(this, 2130968826));
            j jVar = this.f9955i;
            if (jVar != null) {
                int i9 = c.f9963a;
                g gVar = new g(jVar);
                gVar.l(ColorStateList.valueOf(H));
                gradientDrawable = gVar;
            } else {
                Resources resources = getResources();
                int i10 = c.f9963a;
                float dimension = resources.getDimension(2131165964);
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setShape(0);
                gradientDrawable2.setCornerRadius(dimension);
                gradientDrawable2.setColor(H);
                gradientDrawable = gradientDrawable2;
            }
            if (this.f9961o != null) {
                f02 = d.f0(gradientDrawable);
                g0.b.h(f02, this.f9961o);
            } else {
                f02 = d.f0(gradientDrawable);
            }
            WeakHashMap weakHashMap2 = t0.f7209a;
            c0.q(this, f02);
        }
    }

    public float getActionTextColorAlpha() {
        return this.f9958l;
    }

    public int getAnimationMode() {
        return this.f9956j;
    }

    public float getBackgroundOverlayColorAlpha() {
        return this.f9957k;
    }

    public int getMaxInlineActionWidth() {
        return this.f9960n;
    }

    public int getMaxWidth() {
        return this.f9959m;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        WeakHashMap weakHashMap = t0.f7209a;
        g0.c(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        super.onLayout(z8, i9, i10, i11, i12);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i9, int i10) {
        super.onMeasure(i9, i10);
        int i11 = this.f9959m;
        if (i11 <= 0 || getMeasuredWidth() <= i11) {
            return;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i11, 1073741824), i10);
    }

    public void setAnimationMode(int i9) {
        this.f9956j = i9;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable != null && this.f9961o != null) {
            drawable = d.f0(drawable.mutate());
            g0.b.h(drawable, this.f9961o);
            g0.b.i(drawable, this.f9962p);
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        this.f9961o = colorStateList;
        if (getBackground() != null) {
            Drawable f02 = d.f0(getBackground().mutate());
            g0.b.h(f02, colorStateList);
            g0.b.i(f02, this.f9962p);
            if (f02 != getBackground()) {
                super.setBackgroundDrawable(f02);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        this.f9962p = mode;
        if (getBackground() != null) {
            Drawable f02 = d.f0(getBackground().mutate());
            g0.b.i(f02, mode);
            if (f02 != getBackground()) {
                super.setBackgroundDrawable(f02);
            }
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        setOnTouchListener(onClickListener != null ? null : f9954q);
        super.setOnClickListener(onClickListener);
    }

    private void setBaseTransientBottomBar(c cVar) {
    }
}
