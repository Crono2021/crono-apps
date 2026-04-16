package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import d4.t;
import i7.x;
import m.b0;
import m.l;
import m.o;
import n.b2;
import n.c2;
import n.f;
import n.f4;
import n.i;
import n.j;
import n.k;
import n.m;
import n.r3;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class ActionMenuView extends c2 implements l, b0 {
    public boolean A;
    public j B;
    public r3 C;
    public boolean D;
    public int E;
    public final int F;
    public final int G;
    public m H;

    /* renamed from: x, reason: collision with root package name */
    public m.m f438x;

    /* renamed from: y, reason: collision with root package name */
    public Context f439y;

    /* renamed from: z, reason: collision with root package name */
    public int f440z;

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        setBaselineAligned(false);
        float f9 = context.getResources().getDisplayMetrics().density;
        this.F = (int) (56.0f * f9);
        this.G = (int) (f9 * 4.0f);
        this.f439y = context;
        this.f440z = 0;
    }

    public static n.l j() {
        n.l lVar = new n.l(-2, -2);
        lVar.f6942a = false;
        ((LinearLayout.LayoutParams) lVar).gravity = 16;
        return lVar;
    }

    public static n.l k(ViewGroup.LayoutParams layoutParams) {
        n.l lVar;
        if (layoutParams == null) {
            return j();
        }
        if (layoutParams instanceof n.l) {
            n.l lVar2 = (n.l) layoutParams;
            lVar = new n.l(lVar2);
            lVar.f6942a = lVar2.f6942a;
        } else {
            lVar = new n.l(layoutParams);
        }
        if (((LinearLayout.LayoutParams) lVar).gravity <= 0) {
            ((LinearLayout.LayoutParams) lVar).gravity = 16;
        }
        return lVar;
    }

    @Override // m.b0
    public final void b(m.m mVar) {
        this.f438x = mVar;
    }

    @Override // m.l
    public final boolean c(o oVar) {
        return this.f438x.q(oVar, null, 0);
    }

    @Override // n.c2, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof n.l;
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // n.c2
    /* renamed from: f */
    public final /* bridge */ /* synthetic */ b2 generateDefaultLayoutParams() {
        return j();
    }

    @Override // n.c2
    /* renamed from: g */
    public final b2 generateLayoutParams(AttributeSet attributeSet) {
        return new n.l(getContext(), attributeSet);
    }

    @Override // n.c2, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return j();
    }

    @Override // n.c2, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new n.l(getContext(), attributeSet);
    }

    public Menu getMenu() {
        if (this.f438x == null) {
            Context context = getContext();
            m.m mVar = new m.m(context);
            this.f438x = mVar;
            mVar.f6438m = new x(this, 6);
            j jVar = new j(context);
            this.B = jVar;
            jVar.f6915t = true;
            jVar.f6916u = true;
            jVar.f6908m = new t(27);
            this.f438x.b(jVar, this.f439y);
            j jVar2 = this.B;
            jVar2.f6911p = this;
            this.f438x = jVar2.f6906k;
        }
        return this.f438x;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        j jVar = this.B;
        i iVar = jVar.f6912q;
        if (iVar != null) {
            return iVar.getDrawable();
        }
        if (jVar.f6914s) {
            return jVar.f6913r;
        }
        return null;
    }

    public int getPopupTheme() {
        return this.f440z;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // n.c2
    /* renamed from: h */
    public final /* bridge */ /* synthetic */ b2 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return k(layoutParams);
    }

    public final boolean l(int i9) {
        boolean z8 = false;
        if (i9 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i9 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i9);
        if (i9 < getChildCount() && (childAt instanceof k)) {
            z8 = ((k) childAt).b();
        }
        return (i9 <= 0 || !(childAt2 instanceof k)) ? z8 : ((k) childAt2).c() | z8;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        j jVar = this.B;
        if (jVar != null) {
            jVar.d();
            if (this.B.e()) {
                this.B.c();
                this.B.l();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j jVar = this.B;
        if (jVar != null) {
            jVar.c();
            f fVar = jVar.B;
            if (fVar == null || !fVar.b()) {
                return;
            }
            fVar.f6491i.dismiss();
        }
    }

    @Override // n.c2, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        int width;
        int i13;
        if (!this.D) {
            super.onLayout(z8, i9, i10, i11, i12);
            return;
        }
        int childCount = getChildCount();
        int i14 = (i12 - i10) / 2;
        int dividerWidth = getDividerWidth();
        int i15 = i11 - i9;
        int paddingRight = (i15 - getPaddingRight()) - getPaddingLeft();
        boolean a9 = f4.a(this);
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                n.l lVar = (n.l) childAt.getLayoutParams();
                if (lVar.f6942a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (l(i18)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a9) {
                        i13 = getPaddingLeft() + ((LinearLayout.LayoutParams) lVar).leftMargin;
                        width = i13 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) lVar).rightMargin;
                        i13 = width - measuredWidth;
                    }
                    int i19 = i14 - (measuredHeight / 2);
                    childAt.layout(i13, i19, width, measuredHeight + i19);
                    paddingRight -= measuredWidth;
                    i16 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) lVar).leftMargin) + ((LinearLayout.LayoutParams) lVar).rightMargin;
                    l(i18);
                    i17++;
                }
            }
        }
        if (childCount == 1 && i16 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i20 = (i15 / 2) - (measuredWidth2 / 2);
            int i21 = i14 - (measuredHeight2 / 2);
            childAt2.layout(i20, i21, measuredWidth2 + i20, measuredHeight2 + i21);
            return;
        }
        int i22 = i17 - (i16 ^ 1);
        int max = Math.max(0, i22 > 0 ? paddingRight / i22 : 0);
        if (a9) {
            int width2 = getWidth() - getPaddingRight();
            for (int i23 = 0; i23 < childCount; i23++) {
                View childAt3 = getChildAt(i23);
                n.l lVar2 = (n.l) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !lVar2.f6942a) {
                    int i24 = width2 - ((LinearLayout.LayoutParams) lVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i25 = i14 - (measuredHeight3 / 2);
                    childAt3.layout(i24 - measuredWidth3, i25, i24, measuredHeight3 + i25);
                    width2 = i24 - ((measuredWidth3 + ((LinearLayout.LayoutParams) lVar2).leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i26 = 0; i26 < childCount; i26++) {
            View childAt4 = getChildAt(i26);
            n.l lVar3 = (n.l) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !lVar3.f6942a) {
                int i27 = paddingLeft + ((LinearLayout.LayoutParams) lVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i28 = i14 - (measuredHeight4 / 2);
                childAt4.layout(i27, i28, i27 + measuredWidth4, measuredHeight4 + i28);
                paddingLeft = measuredWidth4 + ((LinearLayout.LayoutParams) lVar3).rightMargin + max + i27;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v41 */
    @Override // n.c2, android.view.View
    public final void onMeasure(int i9, int i10) {
        int i11;
        int i12;
        ?? r11;
        int i13;
        int i14;
        m.m mVar;
        boolean z8 = this.D;
        boolean z9 = View.MeasureSpec.getMode(i9) == 1073741824;
        this.D = z9;
        if (z8 != z9) {
            this.E = 0;
        }
        int size = View.MeasureSpec.getSize(i9);
        if (this.D && (mVar = this.f438x) != null && size != this.E) {
            this.E = size;
            mVar.p(true);
        }
        int childCount = getChildCount();
        if (!this.D || childCount <= 0) {
            for (int i15 = 0; i15 < childCount; i15++) {
                n.l lVar = (n.l) getChildAt(i15).getLayoutParams();
                ((LinearLayout.LayoutParams) lVar).rightMargin = 0;
                ((LinearLayout.LayoutParams) lVar).leftMargin = 0;
            }
            super.onMeasure(i9, i10);
            return;
        }
        int mode = View.MeasureSpec.getMode(i10);
        int size2 = View.MeasureSpec.getSize(i9);
        int size3 = View.MeasureSpec.getSize(i10);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, paddingBottom, -2);
        int i16 = size2 - paddingRight;
        int i17 = this.F;
        int i18 = i16 / i17;
        int i19 = i16 % i17;
        if (i18 == 0) {
            setMeasuredDimension(i16, 0);
            return;
        }
        int i20 = (i19 / i18) + i17;
        int childCount2 = getChildCount();
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        boolean z10 = false;
        int i25 = 0;
        long j5 = 0;
        while (true) {
            i11 = this.G;
            if (i24 >= childCount2) {
                break;
            }
            View childAt = getChildAt(i24);
            int i26 = size3;
            int i27 = paddingBottom;
            if (childAt.getVisibility() == 8) {
                i13 = i20;
            } else {
                boolean z11 = childAt instanceof ActionMenuItemView;
                i22++;
                if (z11) {
                    childAt.setPadding(i11, 0, i11, 0);
                }
                n.l lVar2 = (n.l) childAt.getLayoutParams();
                lVar2.f6947f = false;
                lVar2.f6944c = 0;
                lVar2.f6943b = 0;
                lVar2.f6945d = false;
                ((LinearLayout.LayoutParams) lVar2).leftMargin = 0;
                ((LinearLayout.LayoutParams) lVar2).rightMargin = 0;
                lVar2.f6946e = z11 && !TextUtils.isEmpty(((ActionMenuItemView) childAt).getText());
                int i28 = lVar2.f6942a ? 1 : i18;
                n.l lVar3 = (n.l) childAt.getLayoutParams();
                int i29 = i18;
                i13 = i20;
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childMeasureSpec) - i27, View.MeasureSpec.getMode(childMeasureSpec));
                ActionMenuItemView actionMenuItemView = z11 ? (ActionMenuItemView) childAt : null;
                boolean z12 = (actionMenuItemView == null || TextUtils.isEmpty(actionMenuItemView.getText())) ? false : true;
                boolean z13 = z12;
                if (i28 <= 0 || (z12 && i28 < 2)) {
                    i14 = 0;
                } else {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i13 * i28, Integer.MIN_VALUE), makeMeasureSpec);
                    int measuredWidth = childAt.getMeasuredWidth();
                    i14 = measuredWidth / i13;
                    if (measuredWidth % i13 != 0) {
                        i14++;
                    }
                    if (z13 && i14 < 2) {
                        i14 = 2;
                    }
                }
                lVar3.f6945d = !lVar3.f6942a && z13;
                lVar3.f6943b = i14;
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i14 * i13, 1073741824), makeMeasureSpec);
                i23 = Math.max(i23, i14);
                if (lVar2.f6945d) {
                    i25++;
                }
                if (lVar2.f6942a) {
                    z10 = true;
                }
                i18 = i29 - i14;
                i21 = Math.max(i21, childAt.getMeasuredHeight());
                if (i14 == 1) {
                    j5 |= 1 << i24;
                }
            }
            i24++;
            size3 = i26;
            paddingBottom = i27;
            i20 = i13;
        }
        int i30 = size3;
        int i31 = i18;
        int i32 = i20;
        boolean z14 = z10 && i22 == 2;
        int i33 = i31;
        boolean z15 = false;
        while (i25 > 0 && i33 > 0) {
            int i34 = Integer.MAX_VALUE;
            long j9 = 0;
            int i35 = 0;
            int i36 = 0;
            while (i36 < childCount2) {
                int i37 = i21;
                n.l lVar4 = (n.l) getChildAt(i36).getLayoutParams();
                boolean z16 = z14;
                if (lVar4.f6945d) {
                    int i38 = lVar4.f6943b;
                    if (i38 < i34) {
                        j9 = 1 << i36;
                        i34 = i38;
                        i35 = 1;
                    } else if (i38 == i34) {
                        j9 |= 1 << i36;
                        i35++;
                    }
                }
                i36++;
                z14 = z16;
                i21 = i37;
            }
            i12 = i21;
            boolean z17 = z14;
            j5 |= j9;
            if (i35 > i33) {
                break;
            }
            int i39 = i34 + 1;
            int i40 = 0;
            while (i40 < childCount2) {
                View childAt2 = getChildAt(i40);
                n.l lVar5 = (n.l) childAt2.getLayoutParams();
                boolean z18 = z10;
                long j10 = 1 << i40;
                if ((j9 & j10) != 0) {
                    if (z17 && lVar5.f6946e) {
                        r11 = 1;
                        r11 = 1;
                        if (i33 == 1) {
                            childAt2.setPadding(i11 + i32, 0, i11, 0);
                        }
                    } else {
                        r11 = 1;
                    }
                    lVar5.f6943b += r11;
                    lVar5.f6947f = r11;
                    i33--;
                } else if (lVar5.f6943b == i39) {
                    j5 |= j10;
                }
                i40++;
                z10 = z18;
            }
            z14 = z17;
            i21 = i12;
            z15 = true;
        }
        i12 = i21;
        boolean z19 = !z10 && i22 == 1;
        if (i33 > 0 && j5 != 0 && (i33 < i22 - 1 || z19 || i23 > 1)) {
            float bitCount = Long.bitCount(j5);
            if (!z19) {
                if ((j5 & 1) != 0 && !((n.l) getChildAt(0).getLayoutParams()).f6946e) {
                    bitCount -= 0.5f;
                }
                int i41 = childCount2 - 1;
                if ((j5 & (1 << i41)) != 0 && !((n.l) getChildAt(i41).getLayoutParams()).f6946e) {
                    bitCount -= 0.5f;
                }
            }
            int i42 = bitCount > 0.0f ? (int) ((i33 * i32) / bitCount) : 0;
            boolean z20 = z15;
            for (int i43 = 0; i43 < childCount2; i43++) {
                if ((j5 & (1 << i43)) != 0) {
                    View childAt3 = getChildAt(i43);
                    n.l lVar6 = (n.l) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        lVar6.f6944c = i42;
                        lVar6.f6947f = true;
                        if (i43 == 0 && !lVar6.f6946e) {
                            ((LinearLayout.LayoutParams) lVar6).leftMargin = (-i42) / 2;
                        }
                        z20 = true;
                    } else if (lVar6.f6942a) {
                        lVar6.f6944c = i42;
                        lVar6.f6947f = true;
                        ((LinearLayout.LayoutParams) lVar6).rightMargin = (-i42) / 2;
                        z20 = true;
                    } else {
                        if (i43 != 0) {
                            ((LinearLayout.LayoutParams) lVar6).leftMargin = i42 / 2;
                        }
                        if (i43 != childCount2 - 1) {
                            ((LinearLayout.LayoutParams) lVar6).rightMargin = i42 / 2;
                        }
                    }
                }
            }
            z15 = z20;
        }
        if (z15) {
            for (int i44 = 0; i44 < childCount2; i44++) {
                View childAt4 = getChildAt(i44);
                n.l lVar7 = (n.l) childAt4.getLayoutParams();
                if (lVar7.f6947f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((lVar7.f6943b * i32) + lVar7.f6944c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i16, mode != 1073741824 ? i12 : i30);
    }

    public void setExpandedActionViewsExclusive(boolean z8) {
        this.B.f6920y = z8;
    }

    public void setOnMenuItemClickListener(m mVar) {
        this.H = mVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        j jVar = this.B;
        i iVar = jVar.f6912q;
        if (iVar != null) {
            iVar.setImageDrawable(drawable);
        } else {
            jVar.f6914s = true;
            jVar.f6913r = drawable;
        }
    }

    public void setOverflowReserved(boolean z8) {
        this.A = z8;
    }

    public void setPopupTheme(int i9) {
        if (this.f440z != i9) {
            this.f440z = i9;
            if (i9 == 0) {
                this.f439y = getContext();
            } else {
                this.f439y = new ContextThemeWrapper(getContext(), i9);
            }
        }
    }

    public void setPresenter(j jVar) {
        this.B = jVar;
        jVar.f6911p = this;
        this.f438x = jVar.f6906k;
    }

    @Override // n.c2, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return k(layoutParams);
    }
}
