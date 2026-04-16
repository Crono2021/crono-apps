package com.google.android.material.internal;

import a.a;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bumptech.glide.d;
import com.google.android.material.datepicker.j;
import e0.i;
import g0.b;
import java.util.WeakHashMap;
import m.a0;
import m.o;
import n.b2;
import n0.c0;
import n0.t0;
import o5.f;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class NavigationMenuItemView extends f implements a0 {
    public static final int[] O = {R.attr.state_checked};
    public int D;
    public boolean E;
    public boolean F;
    public final boolean G;
    public final CheckedTextView H;
    public FrameLayout I;
    public o J;
    public ColorStateList K;
    public boolean L;
    public Drawable M;
    public final j N;

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.G = true;
        j jVar = new j(this, 3);
        this.N = jVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(2131558449, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(2131165303));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(2131361997);
        this.H = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        t0.p(checkedTextView, jVar);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.I == null) {
                this.I = (FrameLayout) ((ViewStub) findViewById(2131361996)).inflate();
            }
            this.I.removeAllViews();
            this.I.addView(view);
        }
    }

    @Override // m.a0
    public final void a(o oVar) {
        StateListDrawable stateListDrawable;
        this.J = oVar;
        int i9 = oVar.f6455i;
        if (i9 > 0) {
            setId(i9);
        }
        setVisibility(oVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(2130968808, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(O, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            WeakHashMap weakHashMap = t0.f7209a;
            c0.q(this, stateListDrawable);
        }
        setCheckable(oVar.isCheckable());
        setChecked(oVar.isChecked());
        setEnabled(oVar.isEnabled());
        setTitle(oVar.f6459m);
        setIcon(oVar.getIcon());
        setActionView(oVar.getActionView());
        setContentDescription(oVar.f6471y);
        a.O(this, oVar.f6472z);
        o oVar2 = this.J;
        CharSequence charSequence = oVar2.f6459m;
        CheckedTextView checkedTextView = this.H;
        if (charSequence == null && oVar2.getIcon() == null && this.J.getActionView() != null) {
            checkedTextView.setVisibility(8);
            FrameLayout frameLayout = this.I;
            if (frameLayout != null) {
                b2 b2Var = (b2) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) b2Var).width = -1;
                this.I.setLayoutParams(b2Var);
                return;
            }
            return;
        }
        checkedTextView.setVisibility(0);
        FrameLayout frameLayout2 = this.I;
        if (frameLayout2 != null) {
            b2 b2Var2 = (b2) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) b2Var2).width = -2;
            this.I.setLayoutParams(b2Var2);
        }
    }

    @Override // m.a0
    public o getItemData() {
        return this.J;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i9) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i9 + 1);
        o oVar = this.J;
        if (oVar != null && oVar.isCheckable() && this.J.isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, O);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z8) {
        refreshDrawableState();
        if (this.F != z8) {
            this.F = z8;
            this.N.h(this.H, IjkMediaMeta.FF_PROFILE_H264_INTRA);
        }
    }

    public void setChecked(boolean z8) {
        refreshDrawableState();
        CheckedTextView checkedTextView = this.H;
        checkedTextView.setChecked(z8);
        checkedTextView.setTypeface(checkedTextView.getTypeface(), (z8 && this.G) ? 1 : 0);
    }

    public void setHorizontalPadding(int i9) {
        setPadding(i9, getPaddingTop(), i9, getPaddingBottom());
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.L) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = d.f0(drawable).mutate();
                b.h(drawable, this.K);
            }
            int i9 = this.D;
            drawable.setBounds(0, 0, i9, i9);
        } else if (this.E) {
            if (this.M == null) {
                Resources resources = getResources();
                Resources.Theme theme = getContext().getTheme();
                ThreadLocal threadLocal = e0.o.f3001a;
                Drawable a9 = i.a(resources, 2131231037, theme);
                this.M = a9;
                if (a9 != null) {
                    int i10 = this.D;
                    a9.setBounds(0, 0, i10, i10);
                }
            }
            drawable = this.M;
        }
        r0.o.e(this.H, drawable, null, null, null);
    }

    public void setIconPadding(int i9) {
        this.H.setCompoundDrawablePadding(i9);
    }

    public void setIconSize(int i9) {
        this.D = i9;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.K = colorStateList;
        this.L = colorStateList != null;
        o oVar = this.J;
        if (oVar != null) {
            setIcon(oVar.getIcon());
        }
    }

    public void setMaxLines(int i9) {
        this.H.setMaxLines(i9);
    }

    public void setNeedsEmptyIcon(boolean z8) {
        this.E = z8;
    }

    public void setTextAppearance(int i9) {
        android.support.v4.media.session.b.t0(this.H, i9);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.H.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.H.setText(charSequence);
    }
}
