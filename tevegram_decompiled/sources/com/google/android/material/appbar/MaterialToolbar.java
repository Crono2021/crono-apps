package com.google.android.material.appbar;

import a0.k;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.WeakHashMap;
import m.m;
import n0.c0;
import n0.i0;
import n0.t0;
import o5.o;
import u5.g;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class MaterialToolbar extends Toolbar {
    public static final ImageView.ScaleType[] i0 = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: d0, reason: collision with root package name */
    public Integer f1885d0;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f1886e0;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f1887f0;

    /* renamed from: g0, reason: collision with root package name */
    public ImageView.ScaleType f1888g0;

    /* renamed from: h0, reason: collision with root package name */
    public Boolean f1889h0;

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        super(z5.a.a(context, attributeSet, 2130969706, 2132018300), attributeSet, 0);
        Context context2 = getContext();
        TypedArray f9 = o.f(context2, attributeSet, y4.a.f10519y, 2130969706, 2132018300, new int[0]);
        if (f9.hasValue(2)) {
            setNavigationIconTint(f9.getColor(2, -1));
        }
        this.f1886e0 = f9.getBoolean(4, false);
        this.f1887f0 = f9.getBoolean(3, false);
        int i9 = f9.getInt(1, -1);
        if (i9 >= 0) {
            ImageView.ScaleType[] scaleTypeArr = i0;
            if (i9 < scaleTypeArr.length) {
                this.f1888g0 = scaleTypeArr[i9];
            }
        }
        if (f9.hasValue(0)) {
            this.f1889h0 = Boolean.valueOf(f9.getBoolean(0, false));
        }
        f9.recycle();
        Drawable background = getBackground();
        if (background == null || (background instanceof ColorDrawable)) {
            g gVar = new g();
            gVar.l(ColorStateList.valueOf(background != null ? ((ColorDrawable) background).getColor() : 0));
            gVar.i(context2);
            WeakHashMap weakHashMap = t0.f7209a;
            gVar.k(i0.i(this));
            c0.q(this, gVar);
        }
    }

    public ImageView.ScaleType getLogoScaleType() {
        return this.f1888g0;
    }

    public Integer getNavigationIconTint() {
        return this.f1885d0;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public final void m(int i9) {
        Menu menu = getMenu();
        boolean z8 = menu instanceof m;
        if (z8) {
            ((m) menu).w();
        }
        super.m(i9);
        if (z8) {
            ((m) menu).v();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof g) {
            com.bumptech.glide.d.b0(this, (g) background);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        ImageView imageView;
        Drawable drawable;
        super.onLayout(z8, i9, i10, i11, i12);
        k kVar = o.f8000c;
        int i13 = 0;
        ImageView imageView2 = null;
        if (this.f1886e0 || this.f1887f0) {
            ArrayList d9 = o.d(this, getTitle());
            TextView textView = d9.isEmpty() ? null : (TextView) Collections.min(d9, kVar);
            ArrayList d10 = o.d(this, getSubtitle());
            TextView textView2 = d10.isEmpty() ? null : (TextView) Collections.max(d10, kVar);
            if (textView != null || textView2 != null) {
                int measuredWidth = getMeasuredWidth();
                int i14 = measuredWidth / 2;
                int paddingLeft = getPaddingLeft();
                int paddingRight = measuredWidth - getPaddingRight();
                for (int i15 = 0; i15 < getChildCount(); i15++) {
                    View childAt = getChildAt(i15);
                    if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                        if (childAt.getRight() < i14 && childAt.getRight() > paddingLeft) {
                            paddingLeft = childAt.getRight();
                        }
                        if (childAt.getLeft() > i14 && childAt.getLeft() < paddingRight) {
                            paddingRight = childAt.getLeft();
                        }
                    }
                }
                Pair pair = new Pair(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
                if (this.f1886e0 && textView != null) {
                    v(textView, pair);
                }
                if (this.f1887f0 && textView2 != null) {
                    v(textView2, pair);
                }
            }
        }
        Drawable logo = getLogo();
        if (logo != null) {
            while (true) {
                if (i13 >= getChildCount()) {
                    break;
                }
                View childAt2 = getChildAt(i13);
                if ((childAt2 instanceof ImageView) && (drawable = (imageView = (ImageView) childAt2).getDrawable()) != null && drawable.getConstantState() != null && drawable.getConstantState().equals(logo.getConstantState())) {
                    imageView2 = imageView;
                    break;
                }
                i13++;
            }
        }
        if (imageView2 != null) {
            Boolean bool = this.f1889h0;
            if (bool != null) {
                imageView2.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.f1888g0;
            if (scaleType != null) {
                imageView2.setScaleType(scaleType);
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f9) {
        super.setElevation(f9);
        Drawable background = getBackground();
        if (background instanceof g) {
            ((g) background).k(f9);
        }
    }

    public void setLogoAdjustViewBounds(boolean z8) {
        Boolean bool = this.f1889h0;
        if (bool == null || bool.booleanValue() != z8) {
            this.f1889h0 = Boolean.valueOf(z8);
            requestLayout();
        }
    }

    public void setLogoScaleType(ImageView.ScaleType scaleType) {
        if (this.f1888g0 != scaleType) {
            this.f1888g0 = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null && this.f1885d0 != null) {
            drawable = com.bumptech.glide.d.f0(drawable.mutate());
            g0.b.g(drawable, this.f1885d0.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(int i9) {
        this.f1885d0 = Integer.valueOf(i9);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z8) {
        if (this.f1887f0 != z8) {
            this.f1887f0 = z8;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z8) {
        if (this.f1886e0 != z8) {
            this.f1886e0 = z8;
            requestLayout();
        }
    }

    public final void v(TextView textView, Pair pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = textView.getMeasuredWidth();
        int i9 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i10 = measuredWidth2 + i9;
        int max = Math.max(Math.max(((Integer) pair.first).intValue() - i9, 0), Math.max(i10 - ((Integer) pair.second).intValue(), 0));
        if (max > 0) {
            i9 += max;
            i10 -= max;
            textView.measure(View.MeasureSpec.makeMeasureSpec(i10 - i9, 1073741824), textView.getMeasuredHeightAndState());
        }
        textView.layout(i9, textView.getTop(), i10, textView.getBottom());
    }
}
