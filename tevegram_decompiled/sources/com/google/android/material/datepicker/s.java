package com.google.android.material.datepicker;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class s implements AdapterView.OnItemClickListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ MaterialCalendarGridView f2073i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ u f2074j;

    public s(u uVar, MaterialCalendarGridView materialCalendarGridView) {
        this.f2074j = uVar;
        this.f2073i = materialCalendarGridView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i9, long j5) {
        MaterialCalendarGridView materialCalendarGridView = this.f2073i;
        r a9 = materialCalendarGridView.a();
        if (i9 < a9.a() || i9 > a9.c()) {
            return;
        }
        if (materialCalendarGridView.a().getItem(i9).longValue() >= ((m) this.f2074j.f2078e.f8j).f2034b0.f2010k.f2017i) {
            throw null;
        }
    }
}
