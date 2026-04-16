package com.google.android.material.timepicker;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import n0.t0;
import y.k;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
class ClockFaceView extends e implements d {
    public final ClockHandView A;
    public final Rect B;
    public final RectF C;
    public final Rect D;
    public final SparseArray E;
    public final c F;
    public final int[] G;
    public final float[] H;
    public final int I;
    public final int J;
    public final int K;
    public final int L;
    public final String[] M;
    public float N;
    public final ColorStateList O;

    public ClockFaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.B = new Rect();
        this.C = new RectF();
        this.D = new Rect();
        SparseArray sparseArray = new SparseArray();
        this.E = sparseArray;
        this.H = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y4.a.f10502g, 2130969298, 2132018292);
        Resources resources = getResources();
        ColorStateList B = com.bumptech.glide.d.B(context, obtainStyledAttributes, 1);
        this.O = B;
        LayoutInflater.from(context).inflate(2131558494, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(2131362180);
        this.A = clockHandView;
        this.I = resources.getDimensionPixelSize(2131165763);
        int colorForState = B.getColorForState(new int[]{R.attr.state_selected}, B.getDefaultColor());
        this.G = new int[]{colorForState, colorForState, B.getDefaultColor()};
        clockHandView.f2178k.add(this);
        int defaultColor = a.a.u(context, 2131100323).getDefaultColor();
        ColorStateList B2 = com.bumptech.glide.d.B(context, obtainStyledAttributes, 0);
        setBackgroundColor(B2 != null ? B2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new b(this));
        setFocusable(true);
        obtainStyledAttributes.recycle();
        this.F = new c(this);
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        this.M = strArr;
        LayoutInflater from = LayoutInflater.from(getContext());
        int size = sparseArray.size();
        boolean z8 = false;
        for (int i9 = 0; i9 < Math.max(this.M.length, size); i9++) {
            TextView textView = (TextView) sparseArray.get(i9);
            if (i9 >= this.M.length) {
                removeView(textView);
                sparseArray.remove(i9);
            } else {
                if (textView == null) {
                    textView = (TextView) from.inflate(2131558493, (ViewGroup) this, false);
                    sparseArray.put(i9, textView);
                    addView(textView);
                }
                textView.setText(this.M[i9]);
                textView.setTag(2131362196, Integer.valueOf(i9));
                int i10 = (i9 / 12) + 1;
                textView.setTag(2131362181, Integer.valueOf(i10));
                z8 = i10 > 1 ? true : z8;
                t0.p(textView, this.F);
                textView.setTextColor(this.O);
            }
        }
        ClockHandView clockHandView2 = this.A;
        if (clockHandView2.f2177j && !z8) {
            clockHandView2.f2188u = 1;
        }
        clockHandView2.f2177j = z8;
        clockHandView2.invalidate();
        this.J = resources.getDimensionPixelSize(2131165791);
        this.K = resources.getDimensionPixelSize(2131165792);
        this.L = resources.getDimensionPixelSize(2131165770);
    }

    @Override // com.google.android.material.timepicker.e
    public final void e() {
        k kVar = new k();
        kVar.b(this);
        HashMap hashMap = new HashMap();
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getId() != 2131361964 && !"skip".equals(childAt.getTag())) {
                int i10 = (Integer) childAt.getTag(2131362181);
                if (i10 == null) {
                    i10 = 1;
                }
                if (!hashMap.containsKey(i10)) {
                    hashMap.put(i10, new ArrayList());
                }
                ((List) hashMap.get(i10)).add(childAt);
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            List list = (List) entry.getValue();
            int intValue = ((Integer) entry.getKey()).intValue();
            int i11 = this.f2195y;
            if (intValue == 2) {
                i11 = Math.round(i11 * 0.66f);
            }
            Iterator it = list.iterator();
            float f9 = 0.0f;
            while (it.hasNext()) {
                int id = ((View) it.next()).getId();
                Integer valueOf = Integer.valueOf(id);
                HashMap hashMap2 = kVar.f10336c;
                if (!hashMap2.containsKey(valueOf)) {
                    hashMap2.put(Integer.valueOf(id), new y.f());
                }
                y.g gVar = ((y.f) hashMap2.get(Integer.valueOf(id))).f10274d;
                gVar.f10307w = 2131361964;
                gVar.f10308x = i11;
                gVar.f10309y = f9;
                f9 += 360.0f / list.size();
            }
        }
        kVar.a(this);
        setConstraintSet(null);
        requestLayout();
        int i12 = 0;
        while (true) {
            SparseArray sparseArray = this.E;
            if (i12 >= sparseArray.size()) {
                return;
            }
            ((TextView) sparseArray.get(i12)).setVisibility(0);
            i12++;
        }
    }

    public final void f() {
        SparseArray sparseArray;
        Rect rect;
        RectF rectF;
        RectF rectF2 = this.A.f2182o;
        float f9 = Float.MAX_VALUE;
        TextView textView = null;
        int i9 = 0;
        while (true) {
            sparseArray = this.E;
            int size = sparseArray.size();
            rect = this.B;
            rectF = this.C;
            if (i9 >= size) {
                break;
            }
            TextView textView2 = (TextView) sparseArray.get(i9);
            if (textView2 != null) {
                textView2.getHitRect(rect);
                rectF.set(rect);
                rectF.union(rectF2);
                float height = rectF.height() * rectF.width();
                if (height < f9) {
                    textView = textView2;
                    f9 = height;
                }
            }
            i9++;
        }
        for (int i10 = 0; i10 < sparseArray.size(); i10++) {
            TextView textView3 = (TextView) sparseArray.get(i10);
            if (textView3 != null) {
                textView3.setSelected(textView3 == textView);
                textView3.getHitRect(rect);
                rectF.set(rect);
                textView3.getLineBounds(0, this.D);
                rectF.inset(r8.left, r8.top);
                textView3.getPaint().setShader(!RectF.intersects(rectF2, rectF) ? null : new RadialGradient(rectF2.centerX() - rectF.left, rectF2.centerY() - rectF.top, 0.5f * rectF2.width(), this.G, this.H, Shader.TileMode.CLAMP));
                textView3.invalidate();
            }
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(1, this.M.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        super.onLayout(z8, i9, i10, i11, i12);
        f();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int i9, int i10) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int max = (int) (this.L / Math.max(Math.max(this.J / displayMetrics.heightPixels, this.K / displayMetrics.widthPixels), 1.0f));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(max, 1073741824);
        setMeasuredDimension(max, max);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }
}
