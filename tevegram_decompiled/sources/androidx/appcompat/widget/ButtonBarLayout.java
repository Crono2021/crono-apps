package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.WeakHashMap;
import n0.c0;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* renamed from: i, reason: collision with root package name */
    public boolean f442i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f443j;

    /* renamed from: k, reason: collision with root package name */
    public int f444k;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f444k = -1;
        int[] iArr = f.a.f3175k;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        t0.o(this, context, iArr, attributeSet, obtainStyledAttributes, 0);
        this.f442i = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            setStacked(this.f442i);
        }
    }

    private void setStacked(boolean z8) {
        if (this.f443j != z8) {
            if (!z8 || this.f442i) {
                this.f443j = z8;
                setOrientation(z8 ? 1 : 0);
                setGravity(z8 ? 8388613 : 80);
                View findViewById = findViewById(2131362369);
                if (findViewById != null) {
                    findViewById.setVisibility(z8 ? 8 : 4);
                }
                for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
                    bringChildToFront(getChildAt(childCount));
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i9, int i10) {
        int i11;
        boolean z8;
        int i12;
        int size = View.MeasureSpec.getSize(i9);
        int i13 = 0;
        if (this.f442i) {
            if (size > this.f444k && this.f443j) {
                setStacked(false);
            }
            this.f444k = size;
        }
        if (this.f443j || View.MeasureSpec.getMode(i9) != 1073741824) {
            i11 = i9;
            z8 = false;
        } else {
            i11 = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z8 = true;
        }
        super.onMeasure(i11, i10);
        if (this.f442i && !this.f443j && (getMeasuredWidthAndState() & (-16777216)) == 16777216) {
            setStacked(true);
            z8 = true;
        }
        if (z8) {
            super.onMeasure(i9, i10);
        }
        int childCount = getChildCount();
        int i14 = 0;
        while (true) {
            i12 = -1;
            if (i14 >= childCount) {
                i14 = -1;
                break;
            } else if (getChildAt(i14).getVisibility() == 0) {
                break;
            } else {
                i14++;
            }
        }
        if (i14 >= 0) {
            View childAt = getChildAt(i14);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + getPaddingTop() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (this.f443j) {
                int i15 = i14 + 1;
                int childCount2 = getChildCount();
                while (true) {
                    if (i15 >= childCount2) {
                        break;
                    }
                    if (getChildAt(i15).getVisibility() == 0) {
                        i12 = i15;
                        break;
                    }
                    i15++;
                }
                i13 = i12 >= 0 ? getChildAt(i12).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f)) + measuredHeight : measuredHeight;
            } else {
                i13 = getPaddingBottom() + measuredHeight;
            }
        }
        WeakHashMap weakHashMap = t0.f7209a;
        if (c0.d(this) != i13) {
            setMinimumHeight(i13);
            if (i10 == 0) {
                super.onMeasure(i9, i10);
            }
        }
    }

    public void setAllowStacking(boolean z8) {
        if (this.f442i != z8) {
            this.f442i = z8;
            if (!z8 && this.f443j) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
