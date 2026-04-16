package com.google.android.material.theme;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.bumptech.glide.d;
import com.google.android.material.button.MaterialButton;
import g.f0;
import h5.c;
import n.d0;
import n.e1;
import n.n;
import n.p;
import n.q;
import o5.o;
import q5.a;
import r0.b;
import x5.r;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class MaterialComponentsViewInflater extends f0 {
    @Override // g.f0
    public final n a(Context context, AttributeSet attributeSet) {
        return new r(context, attributeSet);
    }

    @Override // g.f0
    public final p b(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }

    @Override // g.f0
    public final q c(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // g.f0
    public final d0 d(Context context, AttributeSet attributeSet) {
        a aVar = new a(z5.a.a(context, attributeSet, 2130969446, 2132018225), attributeSet);
        Context context2 = aVar.getContext();
        TypedArray f9 = o.f(context2, attributeSet, y4.a.f10515u, 2130969446, 2132018225, new int[0]);
        if (f9.hasValue(0)) {
            b.c(aVar, d.B(context2, f9, 0));
        }
        aVar.f8476n = f9.getBoolean(1, false);
        f9.recycle();
        return aVar;
    }

    @Override // g.f0
    public final e1 e(Context context, AttributeSet attributeSet) {
        y5.a aVar = new y5.a(z5.a.a(context, attributeSet, R.attr.textViewStyle, 0), attributeSet, R.attr.textViewStyle);
        Context context2 = aVar.getContext();
        if (com.bumptech.glide.c.R(context2, 2130969634, true)) {
            Resources.Theme theme = context2.getTheme();
            int[] iArr = y4.a.f10518x;
            TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, iArr, R.attr.textViewStyle, 0);
            int f9 = y5.a.f(context2, obtainStyledAttributes, 1, 2);
            obtainStyledAttributes.recycle();
            if (f9 == -1) {
                TypedArray obtainStyledAttributes2 = theme.obtainStyledAttributes(attributeSet, iArr, R.attr.textViewStyle, 0);
                int resourceId = obtainStyledAttributes2.getResourceId(0, -1);
                obtainStyledAttributes2.recycle();
                if (resourceId != -1) {
                    TypedArray obtainStyledAttributes3 = theme.obtainStyledAttributes(resourceId, y4.a.f10517w);
                    int f10 = y5.a.f(aVar.getContext(), obtainStyledAttributes3, 1, 2);
                    obtainStyledAttributes3.recycle();
                    if (f10 >= 0) {
                        aVar.setLineHeight(f10);
                    }
                }
            }
        }
        return aVar;
    }
}
