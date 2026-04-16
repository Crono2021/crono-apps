package n;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class q0 extends k2 implements s0 {
    public CharSequence L;
    public n0 M;
    public final Rect N;
    public int O;
    public final /* synthetic */ t0 P;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(t0 t0Var, Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130969530, 0);
        this.P = t0Var;
        this.N = new Rect();
        this.f6938w = t0Var;
        this.G = true;
        this.H.setFocusable(true);
        this.f6939x = new o0(this, 0);
    }

    @Override // n.s0
    public final void g(CharSequence charSequence) {
        this.L = charSequence;
    }

    @Override // n.s0
    public final void j(int i9) {
        this.O = i9;
    }

    @Override // n.s0
    public final void l(int i9, int i10) {
        ViewTreeObserver viewTreeObserver;
        a0 a0Var = this.H;
        boolean isShowing = a0Var.isShowing();
        s();
        a0Var.setInputMethodMode(2);
        c();
        x1 x1Var = this.f6926k;
        x1Var.setChoiceMode(1);
        k0.d(x1Var, i9);
        k0.c(x1Var, i10);
        t0 t0Var = this.P;
        int selectedItemPosition = t0Var.getSelectedItemPosition();
        x1 x1Var2 = this.f6926k;
        if (a0Var.isShowing() && x1Var2 != null) {
            x1Var2.setListSelectionHidden(false);
            x1Var2.setSelection(selectedItemPosition);
            if (x1Var2.getChoiceMode() != 0) {
                x1Var2.setItemChecked(selectedItemPosition, true);
            }
        }
        if (isShowing || (viewTreeObserver = t0Var.getViewTreeObserver()) == null) {
            return;
        }
        m.d dVar = new m.d(this, 3);
        viewTreeObserver.addOnGlobalLayoutListener(dVar);
        a0Var.setOnDismissListener(new p0(this, dVar));
    }

    @Override // n.s0
    public final CharSequence n() {
        return this.L;
    }

    @Override // n.k2, n.s0
    public final void o(ListAdapter listAdapter) {
        super.o(listAdapter);
        this.M = (n0) listAdapter;
    }

    public final void s() {
        int i9;
        a0 a0Var = this.H;
        Drawable background = a0Var.getBackground();
        t0 t0Var = this.P;
        Rect rect = t0Var.f7043p;
        if (background != null) {
            background.getPadding(rect);
            i9 = f4.a(t0Var) ? rect.right : -rect.left;
        } else {
            i9 = 0;
            rect.right = 0;
            rect.left = 0;
        }
        int paddingLeft = t0Var.getPaddingLeft();
        int paddingRight = t0Var.getPaddingRight();
        int width = t0Var.getWidth();
        int i10 = t0Var.f7042o;
        if (i10 == -2) {
            int a9 = t0Var.a(this.M, a0Var.getBackground());
            int i11 = (t0Var.getContext().getResources().getDisplayMetrics().widthPixels - rect.left) - rect.right;
            if (a9 > i11) {
                a9 = i11;
            }
            r(Math.max(a9, (width - paddingLeft) - paddingRight));
        } else if (i10 == -1) {
            r((width - paddingLeft) - paddingRight);
        } else {
            r(i10);
        }
        this.f6929n = f4.a(t0Var) ? (((width - paddingRight) - this.f6928m) - this.O) + i9 : paddingLeft + this.O + i9;
    }
}
