package com.google.android.material.datepicker;

import android.R;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.Calendar;
import o3.d1;
import o3.g0;
import o3.p0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class u extends g0 {

    /* renamed from: d, reason: collision with root package name */
    public final b f2077d;

    /* renamed from: e, reason: collision with root package name */
    public final a0.b f2078e;

    /* renamed from: f, reason: collision with root package name */
    public final int f2079f;

    public u(ContextThemeWrapper contextThemeWrapper, b bVar, a0.b bVar2) {
        q qVar = bVar.f2008i;
        q qVar2 = bVar.f2009j;
        q qVar3 = bVar.f2011l;
        if (qVar.f2061i.compareTo(qVar3.f2061i) > 0) {
            m7.c.n("firstPage cannot be after currentPage");
            throw null;
        }
        if (qVar3.f2061i.compareTo(qVar2.f2061i) > 0) {
            m7.c.n("currentPage cannot be after lastPage");
            throw null;
        }
        this.f2079f = (contextThemeWrapper.getResources().getDimensionPixelSize(2131165843) * r.f2068l) + (o.D(contextThemeWrapper, R.attr.windowFullscreen) ? contextThemeWrapper.getResources().getDimensionPixelSize(2131165843) : 0);
        this.f2077d = bVar;
        this.f2078e = bVar2;
        if (this.f7659a.a()) {
            m7.c.p("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            throw null;
        }
        this.f7660b = true;
    }

    @Override // o3.g0
    public final int a() {
        return this.f2077d.f2014o;
    }

    @Override // o3.g0
    public final long b(int i9) {
        Calendar a9 = y.a(this.f2077d.f2008i.f2061i);
        a9.add(2, i9);
        a9.set(5, 1);
        Calendar a10 = y.a(a9);
        a10.get(2);
        a10.get(1);
        a10.getMaximum(7);
        a10.getActualMaximum(5);
        a10.getTimeInMillis();
        return a10.getTimeInMillis();
    }

    @Override // o3.g0
    public final void d(d1 d1Var, int i9) {
        t tVar = (t) d1Var;
        b bVar = this.f2077d;
        Calendar a9 = y.a(bVar.f2008i.f2061i);
        a9.add(2, i9);
        q qVar = new q(a9);
        tVar.f2075u.setText(qVar.f());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) tVar.f2076v.findViewById(2131362203);
        if (materialCalendarGridView.a() == null || !qVar.equals(materialCalendarGridView.a().f2070i)) {
            new r(qVar, bVar);
            throw null;
        }
        materialCalendarGridView.invalidate();
        materialCalendarGridView.a().getClass();
        throw null;
    }

    @Override // o3.g0
    public final d1 e(ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(2131558514, viewGroup, false);
        if (!o.D(viewGroup.getContext(), R.attr.windowFullscreen)) {
            return new t(linearLayout, false);
        }
        linearLayout.setLayoutParams(new p0(-1, this.f2079f));
        return new t(linearLayout, true);
    }
}
