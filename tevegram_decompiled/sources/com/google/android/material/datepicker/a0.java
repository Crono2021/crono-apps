package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Locale;
import o3.d1;
import o3.g0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a0 extends g0 {

    /* renamed from: d, reason: collision with root package name */
    public final m f2007d;

    public a0(m mVar) {
        this.f2007d = mVar;
    }

    @Override // o3.g0
    public final int a() {
        return this.f2007d.f2034b0.f2013n;
    }

    @Override // o3.g0
    public final void d(d1 d1Var, int i9) {
        m mVar = this.f2007d;
        int i10 = mVar.f2034b0.f2008i.f2063k + i9;
        TextView textView = ((z) d1Var).f2082u;
        textView.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(i10)));
        Context context = textView.getContext();
        textView.setContentDescription(y.b().get(1) == i10 ? String.format(context.getString(2131951798), Integer.valueOf(i10)) : String.format(context.getString(2131951799), Integer.valueOf(i10)));
        c cVar = mVar.f2037e0;
        if (y.b().get(1) == i10) {
            u5.e eVar = cVar.f2016b;
        } else {
            u5.e eVar2 = cVar.f2015a;
        }
        throw null;
    }

    @Override // o3.g0
    public final d1 e(ViewGroup viewGroup) {
        return new z((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(2131558518, viewGroup, false));
    }
}
