package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class p<S> extends v {

    /* renamed from: a0, reason: collision with root package name */
    public int f2059a0;

    /* renamed from: b0, reason: collision with root package name */
    public b f2060b0;

    @Override // androidx.fragment.app.s
    public final void m(Bundle bundle) {
        super.m(bundle);
        if (bundle == null) {
            bundle = this.f847n;
        }
        this.f2059a0 = bundle.getInt("THEME_RES_ID_KEY");
        if (bundle.getParcelable("DATE_SELECTOR_KEY") == null) {
            this.f2060b0 = (b) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        } else {
            androidx.fragment.app.a.c();
        }
    }

    @Override // androidx.fragment.app.s
    public final View n(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        layoutInflater.cloneInContext(new ContextThemeWrapper(h(), this.f2059a0));
        throw null;
    }

    @Override // androidx.fragment.app.s
    public final void r(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.f2059a0);
        bundle.putParcelable("DATE_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f2060b0);
    }
}
