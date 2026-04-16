package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.WeakHashMap;
import n0.a2;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class FragmentContainerView extends FrameLayout {

    /* renamed from: i, reason: collision with root package name */
    public ArrayList f669i;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f670j;

    /* renamed from: k, reason: collision with root package name */
    public View.OnApplyWindowInsetsListener f671k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f672l;

    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        String str;
        this.f672l = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z0.a.f10535b);
            if (classAttribute == null) {
                classAttribute = obtainStyledAttributes.getString(0);
                str = "android:name";
            } else {
                str = "class";
            }
            obtainStyledAttributes.recycle();
            if (classAttribute == null || isInEditMode()) {
                return;
            }
            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + "\"");
        }
    }

    public final void a(View view) {
        ArrayList arrayList = this.f670j;
        if (arrayList == null || !arrayList.contains(view)) {
            return;
        }
        if (this.f669i == null) {
            this.f669i = new ArrayList();
        }
        this.f669i.add(view);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i9, ViewGroup.LayoutParams layoutParams) {
        Object tag = view.getTag(2131362108);
        if ((tag instanceof s ? (s) tag : null) != null) {
            super.addView(view, i9, layoutParams);
        } else {
            a.f(view, " is not associated with a Fragment.", "Views added to a FragmentContainerView must be associated with a Fragment. View ");
        }
    }

    @Override // android.view.ViewGroup
    public final boolean addViewInLayout(View view, int i9, ViewGroup.LayoutParams layoutParams, boolean z8) {
        Object tag = view.getTag(2131362108);
        if ((tag instanceof s ? (s) tag : null) != null) {
            return super.addViewInLayout(view, i9, layoutParams, z8);
        }
        a.f(view, " is not associated with a Fragment.", "Views added to a FragmentContainerView must be associated with a Fragment. View ");
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        a2 a2Var;
        a2 g9 = a2.g(null, windowInsets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f671k;
        if (onApplyWindowInsetsListener != null) {
            a2Var = a2.g(null, onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets));
        } else {
            WeakHashMap weakHashMap = n0.t0.f7209a;
            WindowInsets f9 = g9.f();
            if (f9 != null) {
                WindowInsets b9 = n0.g0.b(this, f9);
                if (!b9.equals(f9)) {
                    g9 = a2.g(this, b9);
                }
            }
            a2Var = g9;
        }
        if (!a2Var.f7139a.m()) {
            int childCount = getChildCount();
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = getChildAt(i9);
                WeakHashMap weakHashMap2 = n0.t0.f7209a;
                WindowInsets f10 = a2Var.f();
                if (f10 != null) {
                    WindowInsets a9 = n0.g0.a(childAt, f10);
                    if (!a9.equals(f10)) {
                        a2.g(childAt, a9);
                    }
                }
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        if (this.f672l && this.f669i != null) {
            for (int i9 = 0; i9 < this.f669i.size(); i9++) {
                super.drawChild(canvas, (View) this.f669i.get(i9), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j5) {
        ArrayList arrayList;
        if (!this.f672l || (arrayList = this.f669i) == null || arrayList.size() <= 0 || !this.f669i.contains(view)) {
            return super.drawChild(canvas, view, j5);
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public final void endViewTransition(View view) {
        ArrayList arrayList = this.f670j;
        if (arrayList != null) {
            arrayList.remove(view);
            ArrayList arrayList2 = this.f669i;
            if (arrayList2 != null && arrayList2.remove(view)) {
                this.f672l = true;
            }
        }
        super.endViewTransition(view);
    }

    @Override // android.view.ViewGroup
    public final void removeAllViewsInLayout() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            a(getChildAt(childCount));
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup
    public final void removeDetachedView(View view, boolean z8) {
        if (z8) {
            a(view);
        }
        super.removeDetachedView(view, z8);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int i9) {
        a(getChildAt(i9));
        super.removeViewAt(i9);
    }

    @Override // android.view.ViewGroup
    public final void removeViewInLayout(View view) {
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViews(int i9, int i10) {
        for (int i11 = i9; i11 < i9 + i10; i11++) {
            a(getChildAt(i11));
        }
        super.removeViews(i9, i10);
    }

    @Override // android.view.ViewGroup
    public final void removeViewsInLayout(int i9, int i10) {
        for (int i11 = i9; i11 < i9 + i10; i11++) {
            a(getChildAt(i11));
        }
        super.removeViewsInLayout(i9, i10);
    }

    public void setDrawDisappearingViewsLast(boolean z8) {
        this.f672l = z8;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.f671k = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public final void startViewTransition(View view) {
        if (view.getParent() == this) {
            if (this.f670j == null) {
                this.f670j = new ArrayList();
            }
            this.f670j.add(view);
        }
        super.startViewTransition(view);
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        return windowInsets;
    }
}
