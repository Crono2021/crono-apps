package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final u5.e f2015a;

    /* renamed from: b, reason: collision with root package name */
    public final u5.e f2016b;

    public c(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(com.bumptech.glide.c.S(context, 2130969290, m.class.getCanonicalName()).data, y4.a.f10511q);
        u5.e.b(context, obtainStyledAttributes.getResourceId(4, 0));
        u5.e.b(context, obtainStyledAttributes.getResourceId(2, 0));
        u5.e.b(context, obtainStyledAttributes.getResourceId(3, 0));
        u5.e.b(context, obtainStyledAttributes.getResourceId(5, 0));
        ColorStateList B = com.bumptech.glide.d.B(context, obtainStyledAttributes, 7);
        this.f2015a = u5.e.b(context, obtainStyledAttributes.getResourceId(9, 0));
        u5.e.b(context, obtainStyledAttributes.getResourceId(8, 0));
        this.f2016b = u5.e.b(context, obtainStyledAttributes.getResourceId(10, 0));
        new Paint().setColor(B.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
