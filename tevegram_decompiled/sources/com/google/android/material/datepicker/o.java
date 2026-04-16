package com.google.android.material.datepicker;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsetsController;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import n0.b2;
import n0.c2;
import n0.d2;
import n0.e1;
import n0.f0;
import n0.f1;
import n0.i0;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class o<S> extends androidx.fragment.app.o {
    public TextView A0;
    public CheckableImageButton B0;
    public u5.g C0;
    public boolean D0;
    public CharSequence E0;
    public CharSequence F0;

    /* renamed from: m0, reason: collision with root package name */
    public final LinkedHashSet f2045m0;

    /* renamed from: n0, reason: collision with root package name */
    public final LinkedHashSet f2046n0;

    /* renamed from: o0, reason: collision with root package name */
    public int f2047o0;

    /* renamed from: p0, reason: collision with root package name */
    public v f2048p0;

    /* renamed from: q0, reason: collision with root package name */
    public b f2049q0;

    /* renamed from: r0, reason: collision with root package name */
    public m f2050r0;

    /* renamed from: s0, reason: collision with root package name */
    public int f2051s0;

    /* renamed from: t0, reason: collision with root package name */
    public CharSequence f2052t0;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f2053u0;

    /* renamed from: v0, reason: collision with root package name */
    public int f2054v0;

    /* renamed from: w0, reason: collision with root package name */
    public int f2055w0;

    /* renamed from: x0, reason: collision with root package name */
    public CharSequence f2056x0;

    /* renamed from: y0, reason: collision with root package name */
    public int f2057y0;

    /* renamed from: z0, reason: collision with root package name */
    public CharSequence f2058z0;

    public o() {
        new LinkedHashSet();
        new LinkedHashSet();
        this.f2045m0 = new LinkedHashSet();
        this.f2046n0 = new LinkedHashSet();
    }

    public static int C(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(2131165841);
        Calendar b9 = y.b();
        b9.set(5, 1);
        Calendar a9 = y.a(b9);
        a9.get(2);
        a9.get(1);
        int maximum = a9.getMaximum(7);
        a9.getActualMaximum(5);
        a9.getTimeInMillis();
        int dimensionPixelSize = resources.getDimensionPixelSize(2131165847) * maximum;
        return ((maximum - 1) * resources.getDimensionPixelOffset(2131165861)) + dimensionPixelSize + (dimensionPixelOffset * 2);
    }

    public static boolean D(Context context, int i9) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(com.bumptech.glide.c.S(context, 2130969290, m.class.getCanonicalName()).data, new int[]{i9});
        boolean z8 = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z8;
    }

    @Override // androidx.fragment.app.o
    public final Dialog A() {
        Context w8 = w();
        w();
        int i9 = this.f2047o0;
        if (i9 == 0) {
            B();
            throw null;
        }
        Dialog dialog = new Dialog(w8, i9);
        Context context = dialog.getContext();
        this.f2053u0 = D(context, R.attr.windowFullscreen);
        this.C0 = new u5.g(context, null, 2130969290, 2132018233);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, y4.a.f10511q, 2130969290, 2132018233);
        int color = obtainStyledAttributes.getColor(1, 0);
        obtainStyledAttributes.recycle();
        this.C0.i(context);
        this.C0.l(ColorStateList.valueOf(color));
        u5.g gVar = this.C0;
        View decorView = dialog.getWindow().getDecorView();
        WeakHashMap weakHashMap = t0.f7209a;
        gVar.k(i0.i(decorView));
        return dialog;
    }

    public final void B() {
        if (this.f847n.getParcelable("DATE_SELECTOR_KEY") == null) {
            return;
        }
        androidx.fragment.app.a.c();
    }

    @Override // androidx.fragment.app.o, androidx.fragment.app.s
    public final void m(Bundle bundle) {
        super.m(bundle);
        if (bundle == null) {
            bundle = this.f847n;
        }
        this.f2047o0 = bundle.getInt("OVERRIDE_THEME_RES_ID");
        if (bundle.getParcelable("DATE_SELECTOR_KEY") != null) {
            androidx.fragment.app.a.c();
            return;
        }
        this.f2049q0 = (b) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        if (bundle.getParcelable("DAY_VIEW_DECORATOR_KEY") != null) {
            androidx.fragment.app.a.c();
            return;
        }
        this.f2051s0 = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.f2052t0 = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.f2054v0 = bundle.getInt("INPUT_MODE_KEY");
        this.f2055w0 = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f2056x0 = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.f2057y0 = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f2058z0 = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
        CharSequence charSequence = this.f2052t0;
        if (charSequence == null) {
            charSequence = w().getResources().getText(this.f2051s0);
        }
        this.E0 = charSequence;
        if (charSequence != null) {
            CharSequence[] split = TextUtils.split(String.valueOf(charSequence), "\n");
            if (split.length > 1) {
                charSequence = split[0];
            }
        } else {
            charSequence = null;
        }
        this.F0 = charSequence;
    }

    @Override // androidx.fragment.app.s
    public final View n(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(this.f2053u0 ? 2131558524 : 2131558523, viewGroup);
        Context context = inflate.getContext();
        if (this.f2053u0) {
            inflate.findViewById(2131362213).setLayoutParams(new LinearLayout.LayoutParams(C(context), -2));
        } else {
            inflate.findViewById(2131362214).setLayoutParams(new LinearLayout.LayoutParams(C(context), -1));
        }
        TextView textView = (TextView) inflate.findViewById(2131362225);
        WeakHashMap weakHashMap = t0.f7209a;
        f0.f(textView, 1);
        this.B0 = (CheckableImageButton) inflate.findViewById(2131362227);
        this.A0 = (TextView) inflate.findViewById(2131362231);
        this.B0.setTag("TOGGLE_BUTTON_TAG");
        CheckableImageButton checkableImageButton = this.B0;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, android.support.v4.media.session.b.I(context, 2131230991));
        int i9 = 0;
        stateListDrawable.addState(new int[0], android.support.v4.media.session.b.I(context, 2131230993));
        checkableImageButton.setImageDrawable(stateListDrawable);
        this.B0.setChecked(this.f2054v0 != 0);
        t0.p(this.B0, null);
        CheckableImageButton checkableImageButton2 = this.B0;
        this.B0.setContentDescription(this.f2054v0 == 1 ? checkableImageButton2.getContext().getString(2131951815) : checkableImageButton2.getContext().getString(2131951817));
        this.B0.setOnClickListener(new n(this, i9));
        B();
        throw null;
    }

    @Override // androidx.fragment.app.o, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.f2045m0.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.o, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.f2046n0.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) this.M;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.o, androidx.fragment.app.s
    public final void r(Bundle bundle) {
        super.r(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f2047o0);
        bundle.putParcelable("DATE_SELECTOR_KEY", null);
        b bVar = this.f2049q0;
        a aVar = new a();
        int i9 = a.f2005b;
        int i10 = a.f2005b;
        long j5 = bVar.f2008i.f2066n;
        long j9 = bVar.f2009j.f2066n;
        aVar.f2006a = Long.valueOf(bVar.f2011l.f2066n);
        int i11 = bVar.f2012m;
        d dVar = bVar.f2010k;
        m mVar = this.f2050r0;
        q qVar = mVar == null ? null : mVar.f2035c0;
        if (qVar != null) {
            aVar.f2006a = Long.valueOf(qVar.f2066n);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("DEEP_COPY_VALIDATOR_KEY", dVar);
        q e9 = q.e(j5);
        q e10 = q.e(j9);
        d dVar2 = (d) bundle2.getParcelable("DEEP_COPY_VALIDATOR_KEY");
        Long l4 = aVar.f2006a;
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", new b(e9, e10, dVar2, l4 == null ? null : q.e(l4.longValue()), i11));
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.f2051s0);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.f2052t0);
        bundle.putInt("INPUT_MODE_KEY", this.f2054v0);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.f2055w0);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.f2056x0);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.f2057y0);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.f2058z0);
    }

    @Override // androidx.fragment.app.o, androidx.fragment.app.s
    public final void s() {
        b2 d2Var;
        b2 d2Var2;
        WindowInsetsController insetsController;
        WindowInsetsController insetsController2;
        super.s();
        Dialog dialog = this.i0;
        if (dialog == null) {
            throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
        }
        Window window = dialog.getWindow();
        if (this.f2053u0) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.C0);
            if (!this.D0) {
                View findViewById = x().findViewById(2131362110);
                Integer valueOf = findViewById.getBackground() instanceof ColorDrawable ? Integer.valueOf(((ColorDrawable) findViewById.getBackground()).getColor()) : null;
                boolean z8 = false;
                boolean z9 = valueOf == null || valueOf.intValue() == 0;
                int u3 = com.bumptech.glide.c.u(window.getContext(), R.attr.colorBackground, -16777216);
                if (z9) {
                    valueOf = Integer.valueOf(u3);
                }
                int i9 = Build.VERSION.SDK_INT;
                if (i9 >= 30) {
                    f1.a(window, false);
                } else {
                    e1.a(window, false);
                }
                int d9 = i9 < 23 ? f0.a.d(com.bumptech.glide.c.u(window.getContext(), R.attr.statusBarColor, -16777216), 128) : 0;
                int d10 = i9 < 27 ? f0.a.d(com.bumptech.glide.c.u(window.getContext(), R.attr.navigationBarColor, -16777216), 128) : 0;
                window.setStatusBarColor(d9);
                window.setNavigationBarColor(d10);
                boolean z10 = com.bumptech.glide.c.D(d9) || (d9 == 0 && com.bumptech.glide.c.D(valueOf.intValue()));
                i7.x xVar = new i7.x(window.getDecorView());
                int i10 = Build.VERSION.SDK_INT;
                if (i10 >= 30) {
                    insetsController2 = window.getInsetsController();
                    d2Var = new b2(insetsController2, xVar);
                    d2Var.f7141j = window;
                } else {
                    d2Var = i10 >= 26 ? new d2(window, xVar) : i10 >= 23 ? new c2(window, xVar) : new b2(window, xVar);
                }
                d2Var.K(z10);
                boolean D = com.bumptech.glide.c.D(u3);
                if (com.bumptech.glide.c.D(d10) || (d10 == 0 && D)) {
                    z8 = true;
                }
                i7.x xVar2 = new i7.x(window.getDecorView());
                int i11 = Build.VERSION.SDK_INT;
                if (i11 >= 30) {
                    insetsController = window.getInsetsController();
                    d2Var2 = new b2(insetsController, xVar2);
                    d2Var2.f7141j = window;
                } else {
                    d2Var2 = i11 >= 26 ? new d2(window, xVar2) : i11 >= 23 ? new c2(window, xVar2) : new b2(window, xVar2);
                }
                d2Var2.J(z8);
                b3.d dVar = new b3.d(findViewById, findViewById.getLayoutParams().height, findViewById.getPaddingTop());
                WeakHashMap weakHashMap = t0.f7209a;
                i0.u(findViewById, dVar);
                this.D0 = true;
            }
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = w().getResources().getDimensionPixelOffset(2131165849);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.C0, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            View decorView = window.getDecorView();
            Dialog dialog2 = this.i0;
            if (dialog2 == null) {
                throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
            }
            decorView.setOnTouchListener(new k5.a(dialog2, rect));
        }
        w();
        int i12 = this.f2047o0;
        if (i12 == 0) {
            B();
            throw null;
        }
        B();
        b bVar = this.f2049q0;
        m mVar = new m();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i12);
        bundle.putParcelable("GRID_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
        bundle.putParcelable("CURRENT_MONTH_KEY", bVar.f2011l);
        mVar.z(bundle);
        this.f2050r0 = mVar;
        v vVar = mVar;
        if (this.f2054v0 == 1) {
            B();
            b bVar2 = this.f2049q0;
            v pVar = new p();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("THEME_RES_ID_KEY", i12);
            bundle2.putParcelable("DATE_SELECTOR_KEY", null);
            bundle2.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar2);
            pVar.z(bundle2);
            vVar = pVar;
        }
        this.f2048p0 = vVar;
        this.A0.setText((this.f2054v0 == 1 && w().getResources().getConfiguration().orientation == 2) ? this.F0 : this.E0);
        B();
        throw null;
    }

    @Override // androidx.fragment.app.o, androidx.fragment.app.s
    public final void t() {
        this.f2048p0.Z.clear();
        super.t();
    }
}
