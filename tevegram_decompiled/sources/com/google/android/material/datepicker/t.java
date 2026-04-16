package com.google.android.material.datepicker;

import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.WeakHashMap;
import n0.t0;
import o3.d1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class t extends d1 {

    /* renamed from: u, reason: collision with root package name */
    public final TextView f2075u;

    /* renamed from: v, reason: collision with root package name */
    public final MaterialCalendarGridView f2076v;

    public t(LinearLayout linearLayout, boolean z8) {
        super(linearLayout);
        TextView textView = (TextView) linearLayout.findViewById(2131362208);
        this.f2075u = textView;
        WeakHashMap weakHashMap = t0.f7209a;
        new n0.y(2131362421, Boolean.class, 0, 28, 3).d(textView, Boolean.TRUE);
        this.f2076v = (MaterialCalendarGridView) linearLayout.findViewById(2131362203);
        if (z8) {
            return;
        }
        textView.setVisibility(8);
    }
}
