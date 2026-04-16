package x5;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.Filterable;
import android.widget.ListAdapter;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Locale;
import n.k2;
import n.o0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class r extends n.n {

    /* renamed from: m, reason: collision with root package name */
    public final k2 f10191m;

    /* renamed from: n, reason: collision with root package name */
    public final AccessibilityManager f10192n;

    /* renamed from: o, reason: collision with root package name */
    public final Rect f10193o;

    /* renamed from: p, reason: collision with root package name */
    public final int f10194p;

    /* renamed from: q, reason: collision with root package name */
    public final float f10195q;

    /* renamed from: r, reason: collision with root package name */
    public ColorStateList f10196r;

    /* renamed from: s, reason: collision with root package name */
    public int f10197s;

    /* renamed from: t, reason: collision with root package name */
    public ColorStateList f10198t;

    public r(Context context, AttributeSet attributeSet) {
        super(z5.a.a(context, attributeSet, 2130968638, 0), attributeSet);
        this.f10193o = new Rect();
        Context context2 = getContext();
        TypedArray f9 = o5.o.f(context2, attributeSet, y4.a.f10508n, 2130968638, 2132017940, new int[0]);
        if (f9.hasValue(0) && f9.getInt(0, 0) == 0) {
            setKeyListener(null);
        }
        this.f10194p = f9.getResourceId(3, 2131558508);
        this.f10195q = f9.getDimensionPixelOffset(1, 2131165887);
        if (f9.hasValue(2)) {
            this.f10196r = ColorStateList.valueOf(f9.getColor(2, 0));
        }
        this.f10197s = f9.getColor(4, 0);
        this.f10198t = com.bumptech.glide.d.B(context2, f9, 5);
        this.f10192n = (AccessibilityManager) context2.getSystemService("accessibility");
        k2 k2Var = new k2(context2, null, 2130969253, 0);
        this.f10191m = k2Var;
        k2Var.G = true;
        k2Var.H.setFocusable(true);
        k2Var.f6938w = this;
        k2Var.H.setInputMethodMode(2);
        k2Var.o(getAdapter());
        k2Var.f6939x = new o0(this, 2);
        if (f9.hasValue(6)) {
            setSimpleItems(f9.getResourceId(6, 0));
        }
        f9.recycle();
    }

    public static void a(r rVar, Object obj) {
        rVar.setText(rVar.convertSelectionToString(obj), false);
    }

    public final TextInputLayout b() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    @Override // android.widget.AutoCompleteTextView
    public final void dismissDropDown() {
        AccessibilityManager accessibilityManager = this.f10192n;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            super.dismissDropDown();
        } else {
            this.f10191m.dismiss();
        }
    }

    public ColorStateList getDropDownBackgroundTintList() {
        return this.f10196r;
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout b9 = b();
        return (b9 == null || !b9.M) ? super.getHint() : b9.getHint();
    }

    public float getPopupElevation() {
        return this.f10195q;
    }

    public int getSimpleItemSelectedColor() {
        return this.f10197s;
    }

    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.f10198t;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout b9 = b();
        if (b9 != null && b9.M && super.getHint() == null) {
            String str = Build.MANUFACTURER;
            if ((str != null ? str.toLowerCase(Locale.ENGLISH) : "").equals("meizu")) {
                setHint("");
            }
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f10191m.dismiss();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i9, int i10) {
        super.onMeasure(i9, i10);
        if (View.MeasureSpec.getMode(i9) == Integer.MIN_VALUE) {
            int measuredWidth = getMeasuredWidth();
            ListAdapter adapter = getAdapter();
            TextInputLayout b9 = b();
            int i11 = 0;
            if (adapter != null && b9 != null) {
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
                int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
                k2 k2Var = this.f10191m;
                int min = Math.min(adapter.getCount(), Math.max(0, !k2Var.H.isShowing() ? -1 : k2Var.f6926k.getSelectedItemPosition()) + 15);
                View view = null;
                int i12 = 0;
                for (int max = Math.max(0, min - 15); max < min; max++) {
                    int itemViewType = adapter.getItemViewType(max);
                    if (itemViewType != i11) {
                        view = null;
                        i11 = itemViewType;
                    }
                    view = adapter.getView(max, view, b9);
                    if (view.getLayoutParams() == null) {
                        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    }
                    view.measure(makeMeasureSpec, makeMeasureSpec2);
                    i12 = Math.max(i12, view.getMeasuredWidth());
                }
                Drawable background = k2Var.H.getBackground();
                if (background != null) {
                    Rect rect = this.f10193o;
                    background.getPadding(rect);
                    i12 += rect.left + rect.right;
                }
                i11 = b9.getEndIconView().getMeasuredWidth() + i12;
            }
            setMeasuredDimension(Math.min(Math.max(measuredWidth, i11), View.MeasureSpec.getSize(i9)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onWindowFocusChanged(boolean z8) {
        AccessibilityManager accessibilityManager = this.f10192n;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            super.onWindowFocusChanged(z8);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t8) {
        super.setAdapter(t8);
        this.f10191m.o(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundDrawable(Drawable drawable) {
        super.setDropDownBackgroundDrawable(drawable);
        k2 k2Var = this.f10191m;
        if (k2Var != null) {
            k2Var.h(drawable);
        }
    }

    public void setDropDownBackgroundTint(int i9) {
        setDropDownBackgroundTintList(ColorStateList.valueOf(i9));
    }

    public void setDropDownBackgroundTintList(ColorStateList colorStateList) {
        this.f10196r = colorStateList;
        Drawable dropDownBackground = getDropDownBackground();
        if (dropDownBackground instanceof u5.g) {
            ((u5.g) dropDownBackground).l(this.f10196r);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        super.setOnItemSelectedListener(onItemSelectedListener);
        this.f10191m.f6940y = getOnItemSelectedListener();
    }

    @Override // android.widget.TextView
    public void setRawInputType(int i9) {
        super.setRawInputType(i9);
        TextInputLayout b9 = b();
        if (b9 != null) {
            b9.s();
        }
    }

    public void setSimpleItemSelectedColor(int i9) {
        this.f10197s = i9;
        if (getAdapter() instanceof q) {
            ((q) getAdapter()).a();
        }
    }

    public void setSimpleItemSelectedRippleColor(ColorStateList colorStateList) {
        this.f10198t = colorStateList;
        if (getAdapter() instanceof q) {
            ((q) getAdapter()).a();
        }
    }

    public void setSimpleItems(String[] strArr) {
        setAdapter(new q(this, getContext(), this.f10194p, strArr));
    }

    @Override // android.widget.AutoCompleteTextView
    public final void showDropDown() {
        AccessibilityManager accessibilityManager = this.f10192n;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            super.showDropDown();
        } else {
            this.f10191m.c();
        }
    }

    public void setSimpleItems(int i9) {
        setSimpleItems(getResources().getStringArray(i9));
    }
}
