package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;
import n.e4;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class ViewStubCompat extends View {

    /* renamed from: i, reason: collision with root package name */
    public int f517i;

    /* renamed from: j, reason: collision with root package name */
    public int f518j;

    /* renamed from: k, reason: collision with root package name */
    public WeakReference f519k;

    /* renamed from: l, reason: collision with root package name */
    public LayoutInflater f520l;

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f517i = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.a.B, 0, 0);
        this.f518j = obtainStyledAttributes.getResourceId(2, -1);
        this.f517i = obtainStyledAttributes.getResourceId(1, 0);
        setId(obtainStyledAttributes.getResourceId(0, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public final View a() {
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            m7.c.p("ViewStub must have a non-null ViewGroup viewParent");
            return null;
        }
        if (this.f517i == 0) {
            m7.c.n("ViewStub must have a valid layoutResource");
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        LayoutInflater layoutInflater = this.f520l;
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(getContext());
        }
        View inflate = layoutInflater.inflate(this.f517i, viewGroup, false);
        int i9 = this.f518j;
        if (i9 != -1) {
            inflate.setId(i9);
        }
        int indexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(inflate, indexOfChild, layoutParams);
        } else {
            viewGroup.addView(inflate, indexOfChild);
        }
        this.f519k = new WeakReference(inflate);
        return inflate;
    }

    public int getInflatedId() {
        return this.f518j;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f520l;
    }

    public int getLayoutResource() {
        return this.f517i;
    }

    @Override // android.view.View
    public final void onMeasure(int i9, int i10) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i9) {
        this.f518j = i9;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f520l = layoutInflater;
    }

    public void setLayoutResource(int i9) {
        this.f517i = i9;
    }

    @Override // android.view.View
    public void setVisibility(int i9) {
        WeakReference weakReference = this.f519k;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            if (view != null) {
                view.setVisibility(i9);
                return;
            } else {
                m7.c.p("setVisibility called on un-referenced view");
                return;
            }
        }
        super.setVisibility(i9);
        if (i9 == 0 || i9 == 4) {
            a();
        }
    }

    @Override // android.view.View
    public final void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
    }

    public void setOnInflateListener(e4 e4Var) {
    }
}
