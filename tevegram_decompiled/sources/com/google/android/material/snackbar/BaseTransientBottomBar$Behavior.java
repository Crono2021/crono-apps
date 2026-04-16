package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import d.a;
import o4.d;
import w5.b;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class BaseTransientBottomBar$Behavior extends SwipeDismissBehavior<View> {
    public final d h;

    public BaseTransientBottomBar$Behavior() {
        d dVar = new d(20);
        this.f1917e = Math.min(Math.max(0.0f, 0.1f), 1.0f);
        this.f1918f = Math.min(Math.max(0.0f, 0.6f), 1.0f);
        this.f1916d = 0;
        this.h = dVar;
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior, a0.d
    public final boolean g(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        this.h.getClass();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                if (a.f2342b == null) {
                    a.f2342b = new a(2);
                }
                synchronized (a.f2342b.f2343a) {
                }
            }
        } else if (coordinatorLayout.o(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
            if (a.f2342b == null) {
                a.f2342b = new a(2);
            }
            a.f2342b.c();
        }
        return super.g(coordinatorLayout, view, motionEvent);
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior
    public final boolean s(View view) {
        this.h.getClass();
        return view instanceof b;
    }
}
