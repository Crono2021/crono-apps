package com.google.android.material.datepicker;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Locale;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e extends BaseAdapter {

    /* renamed from: l, reason: collision with root package name */
    public static final int f2018l;

    /* renamed from: i, reason: collision with root package name */
    public final Calendar f2019i;

    /* renamed from: j, reason: collision with root package name */
    public final int f2020j;

    /* renamed from: k, reason: collision with root package name */
    public final int f2021k;

    static {
        f2018l = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public e() {
        Calendar c9 = y.c(null);
        this.f2019i = c9;
        this.f2020j = c9.getMaximum(7);
        this.f2021k = c9.getFirstDayOfWeek();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f2020j;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i9) {
        int i10 = this.f2020j;
        if (i9 >= i10) {
            return null;
        }
        int i11 = i9 + this.f2021k;
        if (i11 > i10) {
            i11 -= i10;
        }
        return Integer.valueOf(i11);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i9) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public final View getView(int i9, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(2131558510, viewGroup, false);
        }
        int i10 = i9 + this.f2021k;
        int i11 = this.f2020j;
        if (i10 > i11) {
            i10 -= i11;
        }
        Calendar calendar = this.f2019i;
        calendar.set(7, i10);
        textView.setText(calendar.getDisplayName(7, f2018l, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(2131951792), calendar.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }

    public e(int i9) {
        Calendar c9 = y.c(null);
        this.f2019i = c9;
        this.f2020j = c9.getMaximum(7);
        this.f2021k = i9;
    }
}
