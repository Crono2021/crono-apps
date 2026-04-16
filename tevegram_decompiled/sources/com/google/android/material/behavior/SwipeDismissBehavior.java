package com.google.android.material.behavior;

import a0.d;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b5.b;
import java.util.WeakHashMap;
import n0.c0;
import n0.t0;
import o0.f;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class SwipeDismissBehavior<V extends View> extends d {

    /* renamed from: a, reason: collision with root package name */
    public v0.d f1913a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1914b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1915c;

    /* renamed from: d, reason: collision with root package name */
    public int f1916d = 2;

    /* renamed from: e, reason: collision with root package name */
    public float f1917e = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    public float f1918f = 0.5f;

    /* renamed from: g, reason: collision with root package name */
    public final b f1919g = new b(this);

    @Override // a0.d
    public boolean g(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean z8 = this.f1914b;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z8 = coordinatorLayout.o(view, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f1914b = z8;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f1914b = false;
        }
        if (z8) {
            if (this.f1913a == null) {
                this.f1913a = new v0.d(coordinatorLayout.getContext(), coordinatorLayout, this.f1919g);
            }
            if (!this.f1915c && this.f1913a.p(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // a0.d
    public final boolean h(CoordinatorLayout coordinatorLayout, View view, int i9) {
        WeakHashMap weakHashMap = t0.f7209a;
        if (c0.c(view) == 0) {
            c0.s(view, 1);
            t0.m(view, 1048576);
            t0.i(view, 0);
            if (s(view)) {
                t0.n(view, f.f7555j, new a0.b(this, 11));
            }
        }
        return false;
    }

    @Override // a0.d
    public final boolean r(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (this.f1913a == null) {
            return false;
        }
        if (this.f1915c && motionEvent.getActionMasked() == 3) {
            return true;
        }
        this.f1913a.j(motionEvent);
        return true;
    }

    public boolean s(View view) {
        return true;
    }
}
