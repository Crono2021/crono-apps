package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import m1.b;
import q.a;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class CardView extends FrameLayout {

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f524n = {R.attr.colorBackground};

    /* renamed from: i, reason: collision with root package name */
    public boolean f525i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f526j;

    /* renamed from: k, reason: collision with root package name */
    public final Rect f527k;

    /* renamed from: l, reason: collision with root package name */
    public final Rect f528l;

    /* renamed from: m, reason: collision with root package name */
    public final b f529m;

    public CardView(Context context, AttributeSet attributeSet, int i9) {
        super(context, attributeSet, i9);
        ColorStateList valueOf;
        Rect rect = new Rect();
        this.f527k = rect;
        this.f528l = new Rect();
        b bVar = new b(this);
        this.f529m = bVar;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f8302a, i9, 2132017439);
        if (obtainStyledAttributes.hasValue(2)) {
            valueOf = obtainStyledAttributes.getColorStateList(2);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f524n);
            int color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            valueOf = ColorStateList.valueOf(fArr[2] > 0.5f ? getResources().getColor(2131099694) : getResources().getColor(2131099693));
        }
        float dimension = obtainStyledAttributes.getDimension(3, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(4, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(5, 0.0f);
        this.f525i = obtainStyledAttributes.getBoolean(7, false);
        this.f526j = obtainStyledAttributes.getBoolean(6, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        rect.left = obtainStyledAttributes.getDimensionPixelSize(10, dimensionPixelSize);
        rect.top = obtainStyledAttributes.getDimensionPixelSize(12, dimensionPixelSize);
        rect.right = obtainStyledAttributes.getDimensionPixelSize(11, dimensionPixelSize);
        rect.bottom = obtainStyledAttributes.getDimensionPixelSize(9, dimensionPixelSize);
        dimension3 = dimension2 > dimension3 ? dimension2 : dimension3;
        obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
        r.a aVar = new r.a(valueOf, dimension);
        bVar.f6510j = aVar;
        setBackgroundDrawable(aVar);
        setClipToOutline(true);
        setElevation(dimension2);
        android.support.v4.media.session.b.s0(bVar, dimension3);
    }

    public ColorStateList getCardBackgroundColor() {
        return ((r.a) this.f529m.f6510j).h;
    }

    public float getCardElevation() {
        return ((CardView) this.f529m.f6511k).getElevation();
    }

    public int getContentPaddingBottom() {
        return this.f527k.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f527k.left;
    }

    public int getContentPaddingRight() {
        return this.f527k.right;
    }

    public int getContentPaddingTop() {
        return this.f527k.top;
    }

    public float getMaxCardElevation() {
        return ((r.a) this.f529m.f6510j).f8481e;
    }

    public boolean getPreventCornerOverlap() {
        return this.f526j;
    }

    public float getRadius() {
        return ((r.a) this.f529m.f6510j).f8477a;
    }

    public boolean getUseCompatPadding() {
        return this.f525i;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i9, int i10) {
        super.onMeasure(i9, i10);
    }

    public void setCardBackgroundColor(int i9) {
        ColorStateList valueOf = ColorStateList.valueOf(i9);
        r.a aVar = (r.a) this.f529m.f6510j;
        if (valueOf == null) {
            aVar.getClass();
            valueOf = ColorStateList.valueOf(0);
        }
        aVar.h = valueOf;
        aVar.f8478b.setColor(valueOf.getColorForState(aVar.getState(), aVar.h.getDefaultColor()));
        aVar.invalidateSelf();
    }

    public void setCardElevation(float f9) {
        ((CardView) this.f529m.f6511k).setElevation(f9);
    }

    public void setMaxCardElevation(float f9) {
        android.support.v4.media.session.b.s0(this.f529m, f9);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i9) {
        super.setMinimumHeight(i9);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i9) {
        super.setMinimumWidth(i9);
    }

    public void setPreventCornerOverlap(boolean z8) {
        if (z8 != this.f526j) {
            this.f526j = z8;
            b bVar = this.f529m;
            android.support.v4.media.session.b.s0(bVar, ((r.a) bVar.f6510j).f8481e);
        }
    }

    public void setRadius(float f9) {
        r.a aVar = (r.a) this.f529m.f6510j;
        if (f9 == aVar.f8477a) {
            return;
        }
        aVar.f8477a = f9;
        aVar.b(null);
        aVar.invalidateSelf();
    }

    public void setUseCompatPadding(boolean z8) {
        if (this.f525i != z8) {
            this.f525i = z8;
            b bVar = this.f529m;
            android.support.v4.media.session.b.s0(bVar, ((r.a) bVar.f6510j).f8481e);
        }
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        r.a aVar = (r.a) this.f529m.f6510j;
        if (colorStateList == null) {
            aVar.getClass();
            colorStateList = ColorStateList.valueOf(0);
        }
        aVar.h = colorStateList;
        aVar.f8478b.setColor(colorStateList.getColorForState(aVar.getState(), aVar.h.getDefaultColor()));
        aVar.invalidateSelf();
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130968738);
    }

    @Override // android.view.View
    public final void setPadding(int i9, int i10, int i11, int i12) {
    }

    @Override // android.view.View
    public final void setPaddingRelative(int i9, int i10, int i11, int i12) {
    }
}
