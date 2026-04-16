package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import java.util.WeakHashMap;
import n.w2;
import n0.c0;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* renamed from: i, reason: collision with root package name */
    public boolean f393i;

    /* renamed from: j, reason: collision with root package name */
    public View f394j;

    /* renamed from: k, reason: collision with root package name */
    public View f395k;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f396l;

    /* renamed from: m, reason: collision with root package name */
    public Drawable f397m;

    /* renamed from: n, reason: collision with root package name */
    public Drawable f398n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f399o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f400p;

    /* renamed from: q, reason: collision with root package name */
    public final int f401q;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        n.b bVar = new n.b(this);
        WeakHashMap weakHashMap = t0.f7209a;
        c0.q(this, bVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.a.f3166a);
        boolean z8 = false;
        this.f396l = obtainStyledAttributes.getDrawable(0);
        this.f397m = obtainStyledAttributes.getDrawable(2);
        this.f401q = obtainStyledAttributes.getDimensionPixelSize(13, -1);
        if (getId() == 2131362376) {
            this.f399o = true;
            this.f398n = obtainStyledAttributes.getDrawable(1);
        }
        obtainStyledAttributes.recycle();
        if (!this.f399o ? !(this.f396l != null || this.f397m != null) : this.f398n == null) {
            z8 = true;
        }
        setWillNotDraw(z8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f396l;
        if (drawable != null && drawable.isStateful()) {
            this.f396l.setState(getDrawableState());
        }
        Drawable drawable2 = this.f397m;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f397m.setState(getDrawableState());
        }
        Drawable drawable3 = this.f398n;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f398n.setState(getDrawableState());
    }

    public View getTabContainer() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f396l;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f397m;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f398n;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f394j = findViewById(2131361841);
        this.f395k = findViewById(2131361849);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f393i || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        super.onLayout(z8, i9, i10, i11, i12);
        boolean z9 = true;
        if (this.f399o) {
            Drawable drawable = this.f398n;
            if (drawable != null) {
                drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z9 = false;
            }
        } else {
            if (this.f396l == null) {
                z9 = false;
            } else if (this.f394j.getVisibility() == 0) {
                this.f396l.setBounds(this.f394j.getLeft(), this.f394j.getTop(), this.f394j.getRight(), this.f394j.getBottom());
            } else {
                View view = this.f395k;
                if (view == null || view.getVisibility() != 0) {
                    this.f396l.setBounds(0, 0, 0, 0);
                } else {
                    this.f396l.setBounds(this.f395k.getLeft(), this.f395k.getTop(), this.f395k.getRight(), this.f395k.getBottom());
                }
            }
            this.f400p = false;
        }
        if (z9) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i9, int i10) {
        int i11;
        if (this.f394j == null && View.MeasureSpec.getMode(i10) == Integer.MIN_VALUE && (i11 = this.f401q) >= 0) {
            i10 = View.MeasureSpec.makeMeasureSpec(Math.min(i11, View.MeasureSpec.getSize(i10)), Integer.MIN_VALUE);
        }
        super.onMeasure(i9, i10);
        if (this.f394j == null) {
            return;
        }
        View.MeasureSpec.getMode(i10);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f396l;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f396l);
        }
        this.f396l = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f394j;
            if (view != null) {
                this.f396l.setBounds(view.getLeft(), this.f394j.getTop(), this.f394j.getRight(), this.f394j.getBottom());
            }
        }
        boolean z8 = false;
        if (!this.f399o ? !(this.f396l != null || this.f397m != null) : this.f398n == null) {
            z8 = true;
        }
        setWillNotDraw(z8);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f398n;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f398n);
        }
        this.f398n = drawable;
        boolean z8 = this.f399o;
        boolean z9 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (z8 && (drawable2 = this.f398n) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!z8 ? !(this.f396l != null || this.f397m != null) : this.f398n == null) {
            z9 = true;
        }
        setWillNotDraw(z9);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2 = this.f397m;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f397m);
        }
        this.f397m = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f400p && this.f397m != null) {
                throw null;
            }
        }
        boolean z8 = false;
        if (!this.f399o ? !(this.f396l != null || this.f397m != null) : this.f398n == null) {
            z8 = true;
        }
        setWillNotDraw(z8);
        invalidate();
        invalidateOutline();
    }

    public void setTransitioning(boolean z8) {
        this.f393i = z8;
        setDescendantFocusability(z8 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i9) {
        super.setVisibility(i9);
        boolean z8 = i9 == 0;
        Drawable drawable = this.f396l;
        if (drawable != null) {
            drawable.setVisible(z8, false);
        }
        Drawable drawable2 = this.f397m;
        if (drawable2 != null) {
            drawable2.setVisible(z8, false);
        }
        Drawable drawable3 = this.f398n;
        if (drawable3 != null) {
            drawable3.setVisible(z8, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i9) {
        if (i9 != 0) {
            return super.startActionModeForChild(view, callback, i9);
        }
        return null;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        Drawable drawable2 = this.f396l;
        boolean z8 = this.f399o;
        if (drawable == drawable2 && !z8) {
            return true;
        }
        if (drawable == this.f397m && this.f400p) {
            return true;
        }
        return (drawable == this.f398n && z8) || super.verifyDrawable(drawable);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public void setTabContainer(w2 w2Var) {
    }
}
