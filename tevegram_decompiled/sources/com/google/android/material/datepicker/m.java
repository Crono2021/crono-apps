package com.google.android.material.datepicker;

import android.R;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import n0.t0;
import o3.c0;
import o3.g1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class m<S> extends v {

    /* renamed from: a0, reason: collision with root package name */
    public int f2033a0;

    /* renamed from: b0, reason: collision with root package name */
    public b f2034b0;

    /* renamed from: c0, reason: collision with root package name */
    public q f2035c0;

    /* renamed from: d0, reason: collision with root package name */
    public int f2036d0;

    /* renamed from: e0, reason: collision with root package name */
    public c f2037e0;

    /* renamed from: f0, reason: collision with root package name */
    public RecyclerView f2038f0;

    /* renamed from: g0, reason: collision with root package name */
    public RecyclerView f2039g0;

    /* renamed from: h0, reason: collision with root package name */
    public View f2040h0;
    public View i0;

    /* renamed from: j0, reason: collision with root package name */
    public View f2041j0;

    /* renamed from: k0, reason: collision with root package name */
    public View f2042k0;

    public final void A(q qVar) {
        u uVar = (u) this.f2039g0.getAdapter();
        int g9 = uVar.f2077d.f2008i.g(qVar);
        int g10 = g9 - uVar.f2077d.f2008i.g(this.f2035c0);
        boolean z8 = Math.abs(g10) > 3;
        boolean z9 = g10 > 0;
        this.f2035c0 = qVar;
        if (z8 && z9) {
            this.f2039g0.d0(g9 - 3);
            this.f2039g0.post(new androidx.emoji2.text.j(g9, 1, this));
            return;
        }
        RecyclerView recyclerView = this.f2039g0;
        if (!z8) {
            recyclerView.post(new androidx.emoji2.text.j(g9, 1, this));
        } else {
            recyclerView.d0(g9 + 3);
            this.f2039g0.post(new androidx.emoji2.text.j(g9, 1, this));
        }
    }

    public final void B(int i9) {
        this.f2036d0 = i9;
        if (i9 == 2) {
            this.f2038f0.getLayoutManager().m0(this.f2035c0.f2063k - ((a0) this.f2038f0.getAdapter()).f2007d.f2034b0.f2008i.f2063k);
            this.f2041j0.setVisibility(0);
            this.f2042k0.setVisibility(8);
            this.f2040h0.setVisibility(8);
            this.i0.setVisibility(8);
            return;
        }
        if (i9 == 1) {
            this.f2041j0.setVisibility(8);
            this.f2042k0.setVisibility(0);
            this.f2040h0.setVisibility(0);
            this.i0.setVisibility(0);
            A(this.f2035c0);
        }
    }

    @Override // androidx.fragment.app.s
    public final void m(Bundle bundle) {
        super.m(bundle);
        if (bundle == null) {
            bundle = this.f847n;
        }
        this.f2033a0 = bundle.getInt("THEME_RES_ID_KEY");
        if (bundle.getParcelable("GRID_SELECTOR_KEY") != null) {
            androidx.fragment.app.a.c();
            return;
        }
        this.f2034b0 = (b) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        if (bundle.getParcelable("DAY_VIEW_DECORATOR_KEY") == null) {
            this.f2035c0 = (q) bundle.getParcelable("CURRENT_MONTH_KEY");
        } else {
            androidx.fragment.app.a.c();
        }
    }

    @Override // androidx.fragment.app.s
    public final View n(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        int i9;
        int i10;
        c0 c0Var;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(h(), this.f2033a0);
        this.f2037e0 = new c(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        q qVar = this.f2034b0.f2008i;
        if (o.D(contextThemeWrapper, R.attr.windowFullscreen)) {
            i9 = 2131558517;
            i10 = 1;
        } else {
            i9 = 2131558512;
            i10 = 0;
        }
        View inflate = cloneInContext.inflate(i9, viewGroup, false);
        Resources resources = w().getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(2131165863) + resources.getDimensionPixelOffset(2131165865) + resources.getDimensionPixelSize(2131165864);
        int dimensionPixelSize = resources.getDimensionPixelSize(2131165848);
        int i11 = r.f2068l;
        inflate.setMinimumHeight(dimensionPixelOffset + dimensionPixelSize + (resources.getDimensionPixelOffset(2131165862) * (i11 - 1)) + (resources.getDimensionPixelSize(2131165843) * i11) + resources.getDimensionPixelOffset(2131165840));
        GridView gridView = (GridView) inflate.findViewById(2131362212);
        t0.p(gridView, new g(0));
        int i12 = this.f2034b0.f2012m;
        gridView.setAdapter((ListAdapter) (i12 > 0 ? new e(i12) : new e()));
        gridView.setNumColumns(qVar.f2064l);
        gridView.setEnabled(false);
        this.f2039g0 = (RecyclerView) inflate.findViewById(2131362215);
        this.f2039g0.setLayoutManager(new h(this, i10, i10));
        this.f2039g0.setTag("MONTHS_VIEW_GROUP_TAG");
        u uVar = new u(contextThemeWrapper, this.f2034b0, new a0.b(this, 13));
        this.f2039g0.setAdapter(uVar);
        int integer = contextThemeWrapper.getResources().getInteger(2131427380);
        RecyclerView recyclerView3 = (RecyclerView) inflate.findViewById(2131362218);
        this.f2038f0 = recyclerView3;
        if (recyclerView3 != null) {
            recyclerView3.setHasFixedSize(true);
            this.f2038f0.setLayoutManager(new GridLayoutManager(integer, 0));
            this.f2038f0.setAdapter(new a0(this));
            RecyclerView recyclerView4 = this.f2038f0;
            i iVar = new i();
            y.c(null);
            y.c(null);
            recyclerView4.g(iVar);
        }
        if (inflate.findViewById(2131362205) != null) {
            MaterialButton materialButton = (MaterialButton) inflate.findViewById(2131362205);
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            t0.p(materialButton, new j(this, 0));
            View findViewById = inflate.findViewById(2131362207);
            this.f2040h0 = findViewById;
            findViewById.setTag("NAVIGATION_PREV_TAG");
            View findViewById2 = inflate.findViewById(2131362206);
            this.i0 = findViewById2;
            findViewById2.setTag("NAVIGATION_NEXT_TAG");
            this.f2041j0 = inflate.findViewById(2131362218);
            this.f2042k0 = inflate.findViewById(2131362211);
            B(1);
            materialButton.setText(this.f2035c0.f());
            this.f2039g0.h(new k(this, uVar, materialButton));
            materialButton.setOnClickListener(new l(this, 0));
            this.i0.setOnClickListener(new f(this, uVar, 1));
            this.f2040h0.setOnClickListener(new f(this, uVar, 0));
        }
        if (!o.D(contextThemeWrapper, R.attr.windowFullscreen) && (recyclerView2 = (c0Var = new c0()).f7599a) != (recyclerView = this.f2039g0)) {
            g1 g1Var = c0Var.f7600b;
            if (recyclerView2 != null) {
                ArrayList arrayList = recyclerView2.f1071q0;
                if (arrayList != null) {
                    arrayList.remove(g1Var);
                }
                c0Var.f7599a.setOnFlingListener(null);
            }
            c0Var.f7599a = recyclerView;
            if (recyclerView != null) {
                if (recyclerView.getOnFlingListener() != null) {
                    m7.c.p("An instance of OnFlingListener already set.");
                    return null;
                }
                c0Var.f7599a.h(g1Var);
                c0Var.f7599a.setOnFlingListener(c0Var);
                new Scroller(c0Var.f7599a.getContext(), new DecelerateInterpolator());
                c0Var.f();
            }
        }
        this.f2039g0.d0(uVar.f2077d.f2008i.g(this.f2035c0));
        t0.p(this.f2039g0, new g(1));
        return inflate;
    }

    @Override // androidx.fragment.app.s
    public final void r(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.f2033a0);
        bundle.putParcelable("GRID_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f2034b0);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f2035c0);
    }
}
