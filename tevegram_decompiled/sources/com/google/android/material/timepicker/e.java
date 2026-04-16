package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.WeakHashMap;
import n0.c0;
import n0.d0;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class e extends ConstraintLayout {

    /* renamed from: x, reason: collision with root package name */
    public final a7.a f2194x;

    /* renamed from: y, reason: collision with root package name */
    public int f2195y;

    /* renamed from: z, reason: collision with root package name */
    public final u5.g f2196z;

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 2130969298);
        LayoutInflater.from(context).inflate(2131558495, this);
        u5.g gVar = new u5.g();
        this.f2196z = gVar;
        u5.h hVar = new u5.h(0.5f);
        c7.b e9 = gVar.f9084i.f9069a.e();
        e9.f1652f = hVar;
        e9.f1653g = hVar;
        e9.h = hVar;
        e9.f1654i = hVar;
        gVar.setShapeAppearanceModel(e9.a());
        this.f2196z.l(ColorStateList.valueOf(-1));
        u5.g gVar2 = this.f2196z;
        WeakHashMap weakHashMap = t0.f7209a;
        c0.q(this, gVar2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y4.a.f10520z, 2130969298, 0);
        this.f2195y = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f2194x = new a7.a(this, 8);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i9, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i9, layoutParams);
        if (view.getId() == -1) {
            WeakHashMap weakHashMap = t0.f7209a;
            view.setId(d0.a());
        }
        Handler handler = getHandler();
        if (handler != null) {
            a7.a aVar = this.f2194x;
            handler.removeCallbacks(aVar);
            handler.post(aVar);
        }
    }

    public abstract void e();

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        e();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        Handler handler = getHandler();
        if (handler != null) {
            a7.a aVar = this.f2194x;
            handler.removeCallbacks(aVar);
            handler.post(aVar);
        }
    }

    @Override // android.view.View
    public final void setBackgroundColor(int i9) {
        this.f2196z.l(ColorStateList.valueOf(i9));
    }
}
