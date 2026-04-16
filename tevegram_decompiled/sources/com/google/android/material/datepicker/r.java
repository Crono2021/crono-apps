package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Calendar;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class r extends BaseAdapter {

    /* renamed from: l, reason: collision with root package name */
    public static final int f2068l = y.c(null).getMaximum(4);

    /* renamed from: m, reason: collision with root package name */
    public static final int f2069m = (y.c(null).getMaximum(7) + y.c(null).getMaximum(5)) - 1;

    /* renamed from: i, reason: collision with root package name */
    public final q f2070i;

    /* renamed from: j, reason: collision with root package name */
    public c f2071j;

    /* renamed from: k, reason: collision with root package name */
    public final b f2072k;

    public r(q qVar, b bVar) {
        this.f2070i = qVar;
        this.f2072k = bVar;
        throw null;
    }

    public final int a() {
        int i9 = this.f2072k.f2012m;
        q qVar = this.f2070i;
        Calendar calendar = qVar.f2061i;
        int i10 = calendar.get(7);
        if (i9 <= 0) {
            i9 = calendar.getFirstDayOfWeek();
        }
        int i11 = i10 - i9;
        return i11 < 0 ? i11 + qVar.f2064l : i11;
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Long getItem(int i9) {
        if (i9 < a() || i9 > c()) {
            return null;
        }
        int a9 = (i9 - a()) + 1;
        Calendar a10 = y.a(this.f2070i.f2061i);
        a10.set(5, a9);
        return Long.valueOf(a10.getTimeInMillis());
    }

    public final int c() {
        return (a() + this.f2070i.f2065m) - 1;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return f2069m;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i9) {
        return i9 / this.f2070i.f2064l;
    }

    @Override // android.widget.Adapter
    public final View getView(int i9, View view, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        if (this.f2071j == null) {
            this.f2071j = new c(context);
        }
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(2131558509, viewGroup, false);
        }
        int a9 = i9 - a();
        if (a9 >= 0) {
            q qVar = this.f2070i;
            if (a9 < qVar.f2065m) {
                textView.setTag(qVar);
                textView.setText(String.format(textView.getResources().getConfiguration().locale, "%d", Integer.valueOf(a9 + 1)));
                textView.setVisibility(0);
                textView.setEnabled(true);
                if (getItem(i9) == null || textView == null) {
                    return textView;
                }
                textView.getContext();
                y.b().getTimeInMillis();
                throw null;
            }
        }
        textView.setVisibility(8);
        textView.setEnabled(false);
        if (getItem(i9) == null) {
            textView.getContext();
            y.b().getTimeInMillis();
            throw null;
        }
        return textView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return true;
    }
}
