package n;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class c2 extends ViewGroup {

    /* renamed from: i, reason: collision with root package name */
    public boolean f6819i;

    /* renamed from: j, reason: collision with root package name */
    public int f6820j;

    /* renamed from: k, reason: collision with root package name */
    public int f6821k;

    /* renamed from: l, reason: collision with root package name */
    public int f6822l;

    /* renamed from: m, reason: collision with root package name */
    public int f6823m;

    /* renamed from: n, reason: collision with root package name */
    public int f6824n;

    /* renamed from: o, reason: collision with root package name */
    public float f6825o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f6826p;

    /* renamed from: q, reason: collision with root package name */
    public int[] f6827q;

    /* renamed from: r, reason: collision with root package name */
    public int[] f6828r;

    /* renamed from: s, reason: collision with root package name */
    public Drawable f6829s;

    /* renamed from: t, reason: collision with root package name */
    public int f6830t;

    /* renamed from: u, reason: collision with root package name */
    public int f6831u;

    /* renamed from: v, reason: collision with root package name */
    public int f6832v;

    /* renamed from: w, reason: collision with root package name */
    public int f6833w;

    public c2(Context context, AttributeSet attributeSet, int i9) {
        super(context, attributeSet, i9);
        this.f6819i = true;
        this.f6820j = -1;
        this.f6821k = 0;
        this.f6823m = 8388659;
        int[] iArr = f.a.f3178n;
        androidx.fragment.app.g g02 = androidx.fragment.app.g.g0(context, attributeSet, iArr, i9);
        n0.t0.o(this, context, iArr, attributeSet, (TypedArray) g02.f729k, i9);
        TypedArray typedArray = (TypedArray) g02.f729k;
        int i10 = typedArray.getInt(1, -1);
        if (i10 >= 0) {
            setOrientation(i10);
        }
        int i11 = typedArray.getInt(0, -1);
        if (i11 >= 0) {
            setGravity(i11);
        }
        boolean z8 = typedArray.getBoolean(2, true);
        if (!z8) {
            setBaselineAligned(z8);
        }
        this.f6825o = typedArray.getFloat(4, -1.0f);
        this.f6820j = typedArray.getInt(3, -1);
        this.f6826p = typedArray.getBoolean(7, false);
        setDividerDrawable(g02.Q(5));
        this.f6832v = typedArray.getInt(8, 0);
        this.f6833w = typedArray.getDimensionPixelSize(6, 0);
        g02.i0();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b2;
    }

    public final void d(Canvas canvas, int i9) {
        this.f6829s.setBounds(getPaddingLeft() + this.f6833w, i9, (getWidth() - getPaddingRight()) - this.f6833w, this.f6831u + i9);
        this.f6829s.draw(canvas);
    }

    public final void e(Canvas canvas, int i9) {
        this.f6829s.setBounds(i9, getPaddingTop() + this.f6833w, this.f6830t + i9, (getHeight() - getPaddingBottom()) - this.f6833w);
        this.f6829s.draw(canvas);
    }

    @Override // android.view.ViewGroup
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public b2 generateDefaultLayoutParams() {
        int i9 = this.f6822l;
        if (i9 == 0) {
            return new b2(-2, -2);
        }
        if (i9 == 1) {
            return new b2(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public b2 generateLayoutParams(AttributeSet attributeSet) {
        return new b2(getContext(), attributeSet);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i9;
        if (this.f6820j < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i10 = this.f6820j;
        if (childCount <= i10) {
            m7.c.i("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
            return 0;
        }
        View childAt = getChildAt(i10);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f6820j == 0) {
                return -1;
            }
            m7.c.i("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            return 0;
        }
        int i11 = this.f6821k;
        if (this.f6822l == 1 && (i9 = this.f6823m & 112) != 48) {
            if (i9 == 16) {
                i11 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f6824n) / 2;
            } else if (i9 == 80) {
                i11 = ((getBottom() - getTop()) - getPaddingBottom()) - this.f6824n;
            }
        }
        return i11 + ((LinearLayout.LayoutParams) ((b2) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f6820j;
    }

    public Drawable getDividerDrawable() {
        return this.f6829s;
    }

    public int getDividerPadding() {
        return this.f6833w;
    }

    public int getDividerWidth() {
        return this.f6830t;
    }

    public int getGravity() {
        return this.f6823m;
    }

    public int getOrientation() {
        return this.f6822l;
    }

    public int getShowDividers() {
        return this.f6832v;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f6825o;
    }

    @Override // android.view.ViewGroup
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public b2 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new b2(layoutParams);
    }

    public final boolean i(int i9) {
        if (i9 == 0) {
            return (this.f6832v & 1) != 0;
        }
        int childCount = getChildCount();
        int i10 = this.f6832v;
        if (i9 == childCount) {
            return (i10 & 4) != 0;
        }
        if ((i10 & 2) != 0) {
            for (int i11 = i9 - 1; i11 >= 0; i11--) {
                if (getChildAt(i11).getVisibility() != 8) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int right;
        int left;
        int i9;
        if (this.f6829s == null) {
            return;
        }
        int i10 = 0;
        if (this.f6822l == 1) {
            int virtualChildCount = getVirtualChildCount();
            while (i10 < virtualChildCount) {
                View childAt = getChildAt(i10);
                if (childAt != null && childAt.getVisibility() != 8 && i(i10)) {
                    d(canvas, (childAt.getTop() - ((LinearLayout.LayoutParams) ((b2) childAt.getLayoutParams())).topMargin) - this.f6831u);
                }
                i10++;
            }
            if (i(virtualChildCount)) {
                View childAt2 = getChildAt(virtualChildCount - 1);
                d(canvas, childAt2 == null ? (getHeight() - getPaddingBottom()) - this.f6831u : childAt2.getBottom() + ((LinearLayout.LayoutParams) ((b2) childAt2.getLayoutParams())).bottomMargin);
                return;
            }
            return;
        }
        int virtualChildCount2 = getVirtualChildCount();
        boolean a9 = f4.a(this);
        while (i10 < virtualChildCount2) {
            View childAt3 = getChildAt(i10);
            if (childAt3 != null && childAt3.getVisibility() != 8 && i(i10)) {
                b2 b2Var = (b2) childAt3.getLayoutParams();
                e(canvas, a9 ? childAt3.getRight() + ((LinearLayout.LayoutParams) b2Var).rightMargin : (childAt3.getLeft() - ((LinearLayout.LayoutParams) b2Var).leftMargin) - this.f6830t);
            }
            i10++;
        }
        if (i(virtualChildCount2)) {
            View childAt4 = getChildAt(virtualChildCount2 - 1);
            if (childAt4 != null) {
                b2 b2Var2 = (b2) childAt4.getLayoutParams();
                if (a9) {
                    left = childAt4.getLeft() - ((LinearLayout.LayoutParams) b2Var2).leftMargin;
                    i9 = this.f6830t;
                    right = left - i9;
                } else {
                    right = childAt4.getRight() + ((LinearLayout.LayoutParams) b2Var2).rightMargin;
                }
            } else if (a9) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i9 = this.f6830t;
                right = left - i9;
            }
            e(canvas, right);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x018d  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r23, int r24, int r25, int r26, int r27) {
        /*
            Method dump skipped, instructions count: 457
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n.c2.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:223:0x04ed  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0531  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x053b  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x051b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0143  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r39, int r40) {
        /*
            Method dump skipped, instructions count: 2131
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n.c2.onMeasure(int, int):void");
    }

    public void setBaselineAligned(boolean z8) {
        this.f6819i = z8;
    }

    public void setBaselineAlignedChildIndex(int i9) {
        if (i9 >= 0 && i9 < getChildCount()) {
            this.f6820j = i9;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f6829s) {
            return;
        }
        this.f6829s = drawable;
        if (drawable != null) {
            this.f6830t = drawable.getIntrinsicWidth();
            this.f6831u = drawable.getIntrinsicHeight();
        } else {
            this.f6830t = 0;
            this.f6831u = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i9) {
        this.f6833w = i9;
    }

    public void setGravity(int i9) {
        if (this.f6823m != i9) {
            if ((8388615 & i9) == 0) {
                i9 |= 8388611;
            }
            if ((i9 & 112) == 0) {
                i9 |= 48;
            }
            this.f6823m = i9;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i9) {
        int i10 = i9 & 8388615;
        int i11 = this.f6823m;
        if ((8388615 & i11) != i10) {
            this.f6823m = i10 | ((-8388616) & i11);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z8) {
        this.f6826p = z8;
    }

    public void setOrientation(int i9) {
        if (this.f6822l != i9) {
            this.f6822l = i9;
            requestLayout();
        }
    }

    public void setShowDividers(int i9) {
        if (i9 != this.f6832v) {
            requestLayout();
        }
        this.f6832v = i9;
    }

    public void setVerticalGravity(int i9) {
        int i10 = i9 & 112;
        int i11 = this.f6823m;
        if ((i11 & 112) != i10) {
            this.f6823m = i10 | (i11 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f9) {
        this.f6825o = Math.max(0.0f, f9);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
