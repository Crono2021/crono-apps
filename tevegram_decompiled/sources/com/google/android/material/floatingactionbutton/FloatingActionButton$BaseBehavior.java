package com.google.android.material.floatingactionbutton;

import a0.d;
import a0.g;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import y4.a;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class FloatingActionButton$BaseBehavior<T> extends d {
    public FloatingActionButton$BaseBehavior(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f10504j);
        obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
    }

    @Override // a0.d
    public final boolean a(View view) {
        throw new ClassCastException();
    }

    @Override // a0.d
    public final void c(g gVar) {
        if (gVar.h == 0) {
            gVar.h = 80;
        }
    }

    @Override // a0.d
    public final boolean d(CoordinatorLayout coordinatorLayout, View view, View view2) {
        throw new ClassCastException();
    }

    @Override // a0.d
    public final boolean h(CoordinatorLayout coordinatorLayout, View view, int i9) {
        throw new ClassCastException();
    }

    public FloatingActionButton$BaseBehavior() {
    }
}
