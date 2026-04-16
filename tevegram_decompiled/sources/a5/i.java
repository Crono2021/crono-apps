package a5;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.search.SearchBar$ScrollingViewBehavior;
import java.util.WeakHashMap;
import n0.a2;
import n0.c0;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class i extends j {

    /* renamed from: c, reason: collision with root package name */
    public final Rect f189c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f190d;

    /* renamed from: e, reason: collision with root package name */
    public int f191e;

    /* renamed from: f, reason: collision with root package name */
    public int f192f;

    public i() {
        this.f189c = new Rect();
        this.f190d = new Rect();
        this.f191e = 0;
    }

    @Override // a0.d
    public final boolean i(CoordinatorLayout coordinatorLayout, View view, int i9, int i10, int i11) {
        AppBarLayout v8;
        a2 lastWindowInsets;
        int i12 = view.getLayoutParams().height;
        if ((i12 != -1 && i12 != -2) || (v8 = AppBarLayout.ScrollingViewBehavior.v(coordinatorLayout.j(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i11);
        if (size > 0) {
            WeakHashMap weakHashMap = t0.f7209a;
            if (c0.b(v8) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
                size += lastWindowInsets.a() + lastWindowInsets.d();
            }
        } else {
            size = coordinatorLayout.getHeight();
        }
        int totalScrollRange = v8.getTotalScrollRange() + size;
        int measuredHeight = v8.getMeasuredHeight();
        if (this instanceof SearchBar$ScrollingViewBehavior) {
            view.setTranslationY(-measuredHeight);
        } else {
            view.setTranslationY(0.0f);
            totalScrollRange -= measuredHeight;
        }
        coordinatorLayout.r(view, i9, i10, View.MeasureSpec.makeMeasureSpec(totalScrollRange, i12 == -1 ? 1073741824 : Integer.MIN_VALUE));
        return true;
    }

    @Override // a5.j
    public final void t(CoordinatorLayout coordinatorLayout, View view, int i9) {
        AppBarLayout v8 = AppBarLayout.ScrollingViewBehavior.v(coordinatorLayout.j(view));
        if (v8 == null) {
            coordinatorLayout.q(view, i9);
            this.f191e = 0;
            return;
        }
        a0.g gVar = (a0.g) view.getLayoutParams();
        int paddingLeft = coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) gVar).leftMargin;
        int bottom = v8.getBottom() + ((ViewGroup.MarginLayoutParams) gVar).topMargin;
        int width = (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) gVar).rightMargin;
        int bottom2 = ((v8.getBottom() + coordinatorLayout.getHeight()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) gVar).bottomMargin;
        Rect rect = this.f189c;
        rect.set(paddingLeft, bottom, width, bottom2);
        a2 lastWindowInsets = coordinatorLayout.getLastWindowInsets();
        if (lastWindowInsets != null) {
            WeakHashMap weakHashMap = t0.f7209a;
            if (c0.b(coordinatorLayout) && !c0.b(view)) {
                rect.left = lastWindowInsets.b() + rect.left;
                rect.right -= lastWindowInsets.c();
            }
        }
        int i10 = gVar.f12c;
        int i11 = i10 == 0 ? 8388659 : i10;
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        Rect rect2 = this.f190d;
        n0.j.b(i11, measuredWidth, measuredHeight, rect, rect2, i9);
        int u3 = u(v8);
        view.layout(rect2.left, rect2.top - u3, rect2.right, rect2.bottom - u3);
        this.f191e = rect2.top - v8.getBottom();
    }

    public final int u(View view) {
        int i9;
        if (this.f192f == 0) {
            return 0;
        }
        float f9 = 0.0f;
        if (view instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int totalScrollRange = appBarLayout.getTotalScrollRange();
            int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
            a0.d dVar = ((a0.g) appBarLayout.getLayoutParams()).f10a;
            int u3 = dVar instanceof AppBarLayout.BaseBehavior ? ((AppBarLayout.BaseBehavior) dVar).u() : 0;
            if ((downNestedPreScrollRange == 0 || totalScrollRange + u3 > downNestedPreScrollRange) && (i9 = totalScrollRange - downNestedPreScrollRange) != 0) {
                f9 = (u3 / i9) + 1.0f;
            }
        }
        int i10 = this.f192f;
        return com.bumptech.glide.c.i((int) (f9 * i10), 0, i10);
    }

    public i(int i9) {
        super(0);
        this.f189c = new Rect();
        this.f190d = new Rect();
        this.f191e = 0;
    }
}
