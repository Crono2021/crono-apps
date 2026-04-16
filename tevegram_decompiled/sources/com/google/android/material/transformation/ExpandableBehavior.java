package com.google.android.material.transformation;

import a0.d;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.ArrayList;
import java.util.WeakHashMap;
import n0.f0;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
@Deprecated
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class ExpandableBehavior extends d {
    public ExpandableBehavior() {
    }

    @Override // a0.d
    public abstract boolean b(View view, View view2);

    @Override // a0.d
    public final boolean d(CoordinatorLayout coordinatorLayout, View view, View view2) {
        view2.getClass();
        throw new ClassCastException();
    }

    @Override // a0.d
    public final boolean h(CoordinatorLayout coordinatorLayout, View view, int i9) {
        WeakHashMap weakHashMap = t0.f7209a;
        if (!f0.c(view)) {
            ArrayList j5 = coordinatorLayout.j(view);
            int size = j5.size();
            for (int i10 = 0; i10 < size; i10++) {
                b(view, (View) j5.get(i10));
            }
        }
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
    }
}
