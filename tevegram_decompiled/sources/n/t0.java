package n;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class t0 extends Spinner {

    /* renamed from: q, reason: collision with root package name */
    public static final int[] f7035q = {R.attr.spinnerMode};

    /* renamed from: i, reason: collision with root package name */
    public final o f7036i;

    /* renamed from: j, reason: collision with root package name */
    public final Context f7037j;

    /* renamed from: k, reason: collision with root package name */
    public final i0 f7038k;

    /* renamed from: l, reason: collision with root package name */
    public SpinnerAdapter f7039l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f7040m;

    /* renamed from: n, reason: collision with root package name */
    public final s0 f7041n;

    /* renamed from: o, reason: collision with root package name */
    public int f7042o;

    /* renamed from: p, reason: collision with root package name */
    public final Rect f7043p;

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0060, code lost:
    
        if (r7 == null) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public t0(android.content.Context r13, android.util.AttributeSet r14) {
        /*
            r12 = this;
            r0 = 2130969530(0x7f0403ba, float:1.7547744E38)
            r12.<init>(r13, r14, r0)
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r12.f7043p = r1
            android.content.Context r1 = r12.getContext()
            n.m3.a(r12, r1)
            int[] r1 = f.a.f3186v
            androidx.fragment.app.g r2 = androidx.fragment.app.g.g0(r13, r14, r1, r0)
            java.lang.Object r3 = r2.f729k
            android.content.res.TypedArray r3 = (android.content.res.TypedArray) r3
            n.o r4 = new n.o
            r4.<init>(r12)
            r12.f7036i = r4
            r4 = 4
            r5 = 0
            int r4 = r3.getResourceId(r4, r5)
            if (r4 == 0) goto L35
            l.d r6 = new l.d
            r6.<init>(r13, r4)
            r12.f7037j = r6
            goto L37
        L35:
            r12.f7037j = r13
        L37:
            r4 = -1
            r6 = 0
            int[] r7 = n.t0.f7035q     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            android.content.res.TypedArray r7 = r13.obtainStyledAttributes(r14, r7, r0, r5)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L57
            boolean r8 = r7.hasValue(r5)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4e
            if (r8 == 0) goto L50
            int r4 = r7.getInt(r5, r5)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4e
            goto L50
        L4a:
            r13 = move-exception
            r6 = r7
            goto Ld5
        L4e:
            r8 = move-exception
            goto L59
        L50:
            r7.recycle()
            goto L63
        L54:
            r13 = move-exception
            goto Ld5
        L57:
            r8 = move-exception
            r7 = r6
        L59:
            java.lang.String r9 = "AppCompatSpinner"
            java.lang.String r10 = "Could not read android:spinnerMode"
            android.util.Log.i(r9, r10, r8)     // Catch: java.lang.Throwable -> L4a
            if (r7 == 0) goto L63
            goto L50
        L63:
            r7 = 2
            r8 = 1
            if (r4 == 0) goto L9d
            if (r4 == r8) goto L6a
            goto Laa
        L6a:
            n.q0 r4 = new n.q0
            android.content.Context r9 = r12.f7037j
            r4.<init>(r12, r9, r14)
            android.content.Context r9 = r12.f7037j
            androidx.fragment.app.g r1 = androidx.fragment.app.g.g0(r9, r14, r1, r0)
            java.lang.Object r9 = r1.f729k
            android.content.res.TypedArray r9 = (android.content.res.TypedArray) r9
            r10 = 3
            r11 = -2
            int r9 = r9.getLayoutDimension(r10, r11)
            r12.f7042o = r9
            android.graphics.drawable.Drawable r9 = r1.Q(r8)
            r4.h(r9)
            java.lang.String r7 = r3.getString(r7)
            r4.L = r7
            r1.i0()
            r12.f7041n = r4
            n.i0 r1 = new n.i0
            r1.<init>(r12, r12, r4)
            r12.f7038k = r1
            goto Laa
        L9d:
            n.m0 r1 = new n.m0
            r1.<init>(r12)
            r12.f7041n = r1
            java.lang.String r4 = r3.getString(r7)
            r1.f6964k = r4
        Laa:
            java.lang.CharSequence[] r1 = r3.getTextArray(r5)
            if (r1 == 0) goto Lc1
            android.widget.ArrayAdapter r3 = new android.widget.ArrayAdapter
            r4 = 17367048(0x1090008, float:2.5162948E-38)
            r3.<init>(r13, r4, r1)
            r13 = 2131558552(0x7f0d0098, float:1.8742423E38)
            r3.setDropDownViewResource(r13)
            r12.setAdapter(r3)
        Lc1:
            r2.i0()
            r12.f7040m = r8
            android.widget.SpinnerAdapter r13 = r12.f7039l
            if (r13 == 0) goto Lcf
            r12.setAdapter(r13)
            r12.f7039l = r6
        Lcf:
            n.o r13 = r12.f7036i
            r13.k(r14, r0)
            return
        Ld5:
            if (r6 == 0) goto Lda
            r6.recycle()
        Lda:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: n.t0.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public final int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i9 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i10 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i9) {
                view = null;
                i9 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i10 = Math.max(i10, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i10;
        }
        Rect rect = this.f7043p;
        drawable.getPadding(rect);
        return rect.left + rect.right + i10;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        o oVar = this.f7036i;
        if (oVar != null) {
            oVar.a();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        s0 s0Var = this.f7041n;
        return s0Var != null ? s0Var.a() : super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        s0 s0Var = this.f7041n;
        return s0Var != null ? s0Var.m() : super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        return this.f7041n != null ? this.f7042o : super.getDropDownWidth();
    }

    public final s0 getInternalPopup() {
        return this.f7041n;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        s0 s0Var = this.f7041n;
        return s0Var != null ? s0Var.d() : super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f7037j;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        s0 s0Var = this.f7041n;
        return s0Var != null ? s0Var.n() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        o oVar = this.f7036i;
        if (oVar != null) {
            return oVar.h();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        o oVar = this.f7036i;
        if (oVar != null) {
            return oVar.i();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        s0 s0Var = this.f7041n;
        if (s0Var == null || !s0Var.b()) {
            return;
        }
        s0Var.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onMeasure(int i9, int i10) {
        super.onMeasure(i9, i10);
        if (this.f7041n == null || View.MeasureSpec.getMode(i9) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i9)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        r0 r0Var = (r0) parcelable;
        super.onRestoreInstanceState(r0Var.getSuperState());
        if (!r0Var.f7020i || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new m.d(this, 2));
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final Parcelable onSaveInstanceState() {
        r0 r0Var = new r0(super.onSaveInstanceState());
        s0 s0Var = this.f7041n;
        r0Var.f7020i = s0Var != null && s0Var.b();
        return r0Var;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        i0 i0Var = this.f7038k;
        if (i0Var == null || !i0Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean performClick() {
        s0 s0Var = this.f7041n;
        if (s0Var == null) {
            return super.performClick();
        }
        if (s0Var.b()) {
            return true;
        }
        s0Var.l(k0.b(this), k0.a(this));
        return true;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f7040m) {
            this.f7039l = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        s0 s0Var = this.f7041n;
        if (s0Var != null) {
            Context context = this.f7037j;
            if (context == null) {
                context = getContext();
            }
            Resources.Theme theme = context.getTheme();
            n0 n0Var = new n0();
            n0Var.f6980i = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                n0Var.f6981j = (ListAdapter) spinnerAdapter;
            }
            if (theme != null && Build.VERSION.SDK_INT >= 23 && a5.c.y(spinnerAdapter)) {
                l0.a(a5.c.n(spinnerAdapter), theme);
            }
            s0Var.o(n0Var);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        o oVar = this.f7036i;
        if (oVar != null) {
            oVar.m();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i9) {
        super.setBackgroundResource(i9);
        o oVar = this.f7036i;
        if (oVar != null) {
            oVar.n(i9);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i9) {
        s0 s0Var = this.f7041n;
        if (s0Var == null) {
            super.setDropDownHorizontalOffset(i9);
        } else {
            s0Var.j(i9);
            s0Var.k(i9);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i9) {
        s0 s0Var = this.f7041n;
        if (s0Var != null) {
            s0Var.i(i9);
        } else {
            super.setDropDownVerticalOffset(i9);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i9) {
        if (this.f7041n != null) {
            this.f7042o = i9;
        } else {
            super.setDropDownWidth(i9);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        s0 s0Var = this.f7041n;
        if (s0Var != null) {
            s0Var.h(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i9) {
        setPopupBackgroundDrawable(android.support.v4.media.session.b.I(getPopupContext(), i9));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        s0 s0Var = this.f7041n;
        if (s0Var != null) {
            s0Var.g(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        o oVar = this.f7036i;
        if (oVar != null) {
            oVar.s(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        o oVar = this.f7036i;
        if (oVar != null) {
            oVar.t(mode);
        }
    }
}
