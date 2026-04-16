package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.datepicker.l;
import java.util.WeakHashMap;
import m.b0;
import m.m;
import n.f;
import n.f4;
import n.j;
import n0.c0;
import n0.c1;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class ActionBarContextView extends ViewGroup {
    public boolean A;
    public final int B;

    /* renamed from: i, reason: collision with root package name */
    public final n.a f402i;

    /* renamed from: j, reason: collision with root package name */
    public final Context f403j;

    /* renamed from: k, reason: collision with root package name */
    public ActionMenuView f404k;

    /* renamed from: l, reason: collision with root package name */
    public j f405l;

    /* renamed from: m, reason: collision with root package name */
    public int f406m;

    /* renamed from: n, reason: collision with root package name */
    public c1 f407n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f408o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f409p;

    /* renamed from: q, reason: collision with root package name */
    public CharSequence f410q;

    /* renamed from: r, reason: collision with root package name */
    public CharSequence f411r;

    /* renamed from: s, reason: collision with root package name */
    public View f412s;

    /* renamed from: t, reason: collision with root package name */
    public View f413t;

    /* renamed from: u, reason: collision with root package name */
    public View f414u;

    /* renamed from: v, reason: collision with root package name */
    public LinearLayout f415v;

    /* renamed from: w, reason: collision with root package name */
    public TextView f416w;

    /* renamed from: x, reason: collision with root package name */
    public TextView f417x;

    /* renamed from: y, reason: collision with root package name */
    public final int f418y;

    /* renamed from: z, reason: collision with root package name */
    public final int f419z;

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130968604);
        int resourceId;
        this.f402i = new n.a(this);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(2130968578, typedValue, true) || typedValue.resourceId == 0) {
            this.f403j = context;
        } else {
            this.f403j = new ContextThemeWrapper(context, typedValue.resourceId);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.a.f3169d, 2130968604, 0);
        Drawable drawable = (!obtainStyledAttributes.hasValue(0) || (resourceId = obtainStyledAttributes.getResourceId(0, 0)) == 0) ? obtainStyledAttributes.getDrawable(0) : android.support.v4.media.session.b.I(context, resourceId);
        WeakHashMap weakHashMap = t0.f7209a;
        c0.q(this, drawable);
        this.f418y = obtainStyledAttributes.getResourceId(5, 0);
        this.f419z = obtainStyledAttributes.getResourceId(4, 0);
        this.f406m = obtainStyledAttributes.getLayoutDimension(3, 0);
        this.B = obtainStyledAttributes.getResourceId(2, 2131558405);
        obtainStyledAttributes.recycle();
    }

    public static int f(View view, int i9, int i10) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i9, Integer.MIN_VALUE), i10);
        return Math.max(0, i9 - view.getMeasuredWidth());
    }

    public static int g(View view, int i9, int i10, int i11, boolean z8) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i12 = ((i11 - measuredHeight) / 2) + i10;
        if (z8) {
            view.layout(i9 - measuredWidth, i12, i9, measuredHeight + i12);
        } else {
            view.layout(i9, i12, i9 + measuredWidth, measuredHeight + i12);
        }
        return z8 ? -measuredWidth : measuredWidth;
    }

    public final void c(l.a aVar) {
        View view = this.f412s;
        if (view == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(this.B, (ViewGroup) this, false);
            this.f412s = inflate;
            addView(inflate);
        } else if (view.getParent() == null) {
            addView(this.f412s);
        }
        View findViewById = this.f412s.findViewById(2131361856);
        this.f413t = findViewById;
        findViewById.setOnClickListener(new l(aVar, 3));
        m c9 = aVar.c();
        j jVar = this.f405l;
        if (jVar != null) {
            jVar.c();
            f fVar = jVar.B;
            if (fVar != null && fVar.b()) {
                fVar.f6491i.dismiss();
            }
        }
        j jVar2 = new j(getContext());
        this.f405l = jVar2;
        jVar2.f6915t = true;
        jVar2.f6916u = true;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        c9.b(this.f405l, this.f403j);
        j jVar3 = this.f405l;
        b0 b0Var = jVar3.f6911p;
        if (b0Var == null) {
            b0 b0Var2 = (b0) jVar3.f6907l.inflate(jVar3.f6909n, (ViewGroup) this, false);
            jVar3.f6911p = b0Var2;
            b0Var2.b(jVar3.f6906k);
            jVar3.d();
        }
        b0 b0Var3 = jVar3.f6911p;
        if (b0Var != b0Var3) {
            ((ActionMenuView) b0Var3).setPresenter(jVar3);
        }
        ActionMenuView actionMenuView = (ActionMenuView) b0Var3;
        this.f404k = actionMenuView;
        WeakHashMap weakHashMap = t0.f7209a;
        c0.q(actionMenuView, null);
        addView(this.f404k, layoutParams);
    }

    public final void d() {
        if (this.f415v == null) {
            LayoutInflater.from(getContext()).inflate(2131558400, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f415v = linearLayout;
            this.f416w = (TextView) linearLayout.findViewById(2131361847);
            this.f417x = (TextView) this.f415v.findViewById(2131361846);
            int i9 = this.f418y;
            if (i9 != 0) {
                this.f416w.setTextAppearance(getContext(), i9);
            }
            int i10 = this.f419z;
            if (i10 != 0) {
                this.f417x.setTextAppearance(getContext(), i10);
            }
        }
        this.f416w.setText(this.f410q);
        this.f417x.setText(this.f411r);
        boolean isEmpty = TextUtils.isEmpty(this.f410q);
        boolean isEmpty2 = TextUtils.isEmpty(this.f411r);
        this.f417x.setVisibility(!isEmpty2 ? 0 : 8);
        this.f415v.setVisibility((isEmpty && isEmpty2) ? 8 : 0);
        if (this.f415v.getParent() == null) {
            addView(this.f415v);
        }
    }

    public final void e() {
        removeAllViews();
        this.f414u = null;
        this.f404k = null;
        this.f405l = null;
        View view = this.f413t;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public int getAnimatedVisibility() {
        return this.f407n != null ? this.f402i.f6774b : getVisibility();
    }

    public int getContentHeight() {
        return this.f406m;
    }

    public CharSequence getSubtitle() {
        return this.f411r;
    }

    public CharSequence getTitle() {
        return this.f410q;
    }

    @Override // android.view.View
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public final void setVisibility(int i9) {
        if (i9 != getVisibility()) {
            c1 c1Var = this.f407n;
            if (c1Var != null) {
                c1Var.b();
            }
            super.setVisibility(i9);
        }
    }

    public final c1 i(int i9, long j5) {
        c1 c1Var = this.f407n;
        if (c1Var != null) {
            c1Var.b();
        }
        n.a aVar = this.f402i;
        if (i9 != 0) {
            c1 a9 = t0.a(this);
            a9.a(0.0f);
            a9.c(j5);
            aVar.f6775c.f407n = a9;
            aVar.f6774b = i9;
            a9.d(aVar);
            return a9;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        c1 a10 = t0.a(this);
        a10.a(1.0f);
        a10.c(j5);
        aVar.f6775c.f407n = a10;
        aVar.f6774b = i9;
        a10.d(aVar);
        return a10;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, f.a.f3166a, 2130968581, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(13, 0));
        obtainStyledAttributes.recycle();
        j jVar = this.f405l;
        if (jVar != null) {
            Configuration configuration2 = jVar.f6905j.getResources().getConfiguration();
            int i9 = configuration2.screenWidthDp;
            int i10 = configuration2.screenHeightDp;
            jVar.f6919x = (configuration2.smallestScreenWidthDp > 600 || i9 > 600 || (i9 > 960 && i10 > 720) || (i9 > 720 && i10 > 960)) ? 5 : (i9 >= 500 || (i9 > 640 && i10 > 480) || (i9 > 480 && i10 > 640)) ? 4 : i9 >= 360 ? 3 : 2;
            m mVar = jVar.f6906k;
            if (mVar != null) {
                mVar.p(true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j jVar = this.f405l;
        if (jVar != null) {
            jVar.c();
            f fVar = this.f405l.B;
            if (fVar == null || !fVar.b()) {
                return;
            }
            fVar.f6491i.dismiss();
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f409p = false;
        }
        if (!this.f409p) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f409p = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.f409p = false;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        boolean a9 = f4.a(this);
        int paddingRight = a9 ? (i11 - i9) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i12 - i10) - getPaddingTop()) - getPaddingBottom();
        View view = this.f412s;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f412s.getLayoutParams();
            int i13 = a9 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i14 = a9 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int i15 = a9 ? paddingRight - i13 : paddingRight + i13;
            int g9 = g(this.f412s, i15, paddingTop, paddingTop2, a9) + i15;
            paddingRight = a9 ? g9 - i14 : g9 + i14;
        }
        LinearLayout linearLayout = this.f415v;
        if (linearLayout != null && this.f414u == null && linearLayout.getVisibility() != 8) {
            paddingRight += g(this.f415v, paddingRight, paddingTop, paddingTop2, a9);
        }
        View view2 = this.f414u;
        if (view2 != null) {
            g(view2, paddingRight, paddingTop, paddingTop2, a9);
        }
        int paddingLeft = a9 ? getPaddingLeft() : (i11 - i9) - getPaddingRight();
        ActionMenuView actionMenuView = this.f404k;
        if (actionMenuView != null) {
            g(actionMenuView, paddingLeft, paddingTop, paddingTop2, !a9);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i9, int i10) {
        if (View.MeasureSpec.getMode(i9) != 1073741824) {
            m7.c.p(getClass().getSimpleName().concat(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)"));
            return;
        }
        if (View.MeasureSpec.getMode(i10) == 0) {
            m7.c.p(getClass().getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
            return;
        }
        int size = View.MeasureSpec.getSize(i9);
        int i11 = this.f406m;
        if (i11 <= 0) {
            i11 = View.MeasureSpec.getSize(i10);
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int i12 = i11 - paddingBottom;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i12, Integer.MIN_VALUE);
        View view = this.f412s;
        if (view != null) {
            int f9 = f(view, paddingLeft, makeMeasureSpec);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f412s.getLayoutParams();
            paddingLeft = f9 - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f404k;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = f(this.f404k, paddingLeft, makeMeasureSpec);
        }
        LinearLayout linearLayout = this.f415v;
        if (linearLayout != null && this.f414u == null) {
            if (this.A) {
                this.f415v.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                int measuredWidth = this.f415v.getMeasuredWidth();
                boolean z8 = measuredWidth <= paddingLeft;
                if (z8) {
                    paddingLeft -= measuredWidth;
                }
                this.f415v.setVisibility(z8 ? 0 : 8);
            } else {
                paddingLeft = f(linearLayout, paddingLeft, makeMeasureSpec);
            }
        }
        View view2 = this.f414u;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i13 = layoutParams.width;
            int i14 = i13 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i13 >= 0) {
                paddingLeft = Math.min(i13, paddingLeft);
            }
            int i15 = layoutParams.height;
            int i16 = i15 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i15 >= 0) {
                i12 = Math.min(i15, i12);
            }
            this.f414u.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i14), View.MeasureSpec.makeMeasureSpec(i12, i16));
        }
        if (this.f406m > 0) {
            setMeasuredDimension(size, i11);
            return;
        }
        int childCount = getChildCount();
        int i17 = 0;
        for (int i18 = 0; i18 < childCount; i18++) {
            int measuredHeight = getChildAt(i18).getMeasuredHeight() + paddingBottom;
            if (measuredHeight > i17) {
                i17 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i17);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f408o = false;
        }
        if (!this.f408o) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f408o = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.f408o = false;
        return true;
    }

    public void setContentHeight(int i9) {
        this.f406m = i9;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f414u;
        if (view2 != null) {
            removeView(view2);
        }
        this.f414u = view;
        if (view != null && (linearLayout = this.f415v) != null) {
            removeView(linearLayout);
            this.f415v = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f411r = charSequence;
        d();
    }

    public void setTitle(CharSequence charSequence) {
        this.f410q = charSequence;
        d();
        t0.q(this, charSequence);
    }

    public void setTitleOptional(boolean z8) {
        if (z8 != this.A) {
            requestLayout();
        }
        this.A = z8;
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
