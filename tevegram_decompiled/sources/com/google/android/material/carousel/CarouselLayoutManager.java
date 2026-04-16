package com.google.android.material.carousel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.activity.g;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.w;
import d4.t;
import g5.a;
import g5.b;
import g5.c;
import g5.d;
import java.util.List;
import o3.o0;
import o3.p0;
import o3.y0;
import o3.z0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class CarouselLayoutManager extends o0 implements y0 {

    /* renamed from: p, reason: collision with root package name */
    public int f1982p;

    /* renamed from: q, reason: collision with root package name */
    public c f1983q;

    @SuppressLint({"UnknownNullness"})
    public CarouselLayoutManager(Context context, AttributeSet attributeSet, int i9, int i10) {
        new a();
        D0(o0.G(context, attributeSet, i9, i10).f7743a);
        k0();
    }

    public static t z0(List list, float f9, boolean z8) {
        float f10 = Float.MAX_VALUE;
        float f11 = Float.MAX_VALUE;
        float f12 = Float.MAX_VALUE;
        float f13 = -3.4028235E38f;
        int i9 = -1;
        int i10 = -1;
        int i11 = -1;
        int i12 = -1;
        for (int i13 = 0; i13 < list.size(); i13++) {
            ((d) list.get(i13)).getClass();
            float abs = Math.abs(0.0f - f9);
            if (0.0f <= f9 && abs <= f10) {
                i9 = i13;
                f10 = abs;
            }
            if (0.0f > f9 && abs <= f11) {
                i11 = i13;
                f11 = abs;
            }
            if (0.0f <= f12) {
                i10 = i13;
                f12 = 0.0f;
            }
            if (0.0f > f13) {
                i12 = i13;
                f13 = 0.0f;
            }
        }
        if (i9 == -1) {
            i9 = i10;
        }
        if (i11 == -1) {
            i11 = i12;
        }
        return new t((d) list.get(i9), (d) list.get(i11));
    }

    public final boolean A0() {
        return this.f1983q.f3748j == 0;
    }

    public final boolean B0() {
        return A0() && A() == 1;
    }

    public final int C0(int i9, l7.a aVar, z0 z0Var) {
        if (v() == 0 || i9 == 0) {
            return 0;
        }
        int i10 = this.f1982p;
        int i11 = i10 + i9;
        if (i11 < 0 || i11 > 0) {
            i9 = 0 - i10;
        }
        this.f1982p = i10 + i9;
        B0();
        throw null;
    }

    public final void D0(int i9) {
        b bVar;
        if (i9 != 0 && i9 != 1) {
            m7.c.n(g.m(i9, "invalid orientation:"));
            return;
        }
        c(null);
        c cVar = this.f1983q;
        if (cVar == null || i9 != cVar.f3748j) {
            if (i9 == 0) {
                bVar = new b(this, 1);
            } else {
                if (i9 != 1) {
                    m7.c.n("invalid orientation");
                    return;
                }
                bVar = new b(this, 0);
            }
            this.f1983q = bVar;
            k0();
        }
    }

    @Override // o3.o0
    public final void R(AccessibilityEvent accessibilityEvent) {
        super.R(accessibilityEvent);
        if (v() > 0) {
            accessibilityEvent.setFromIndex(o0.F(u(0)));
            accessibilityEvent.setToIndex(o0.F(u(v() - 1)));
        }
    }

    @Override // o3.y0
    public final PointF a(int i9) {
        return null;
    }

    @Override // o3.o0
    public final void a0(l7.a aVar, z0 z0Var) {
        if (z0Var.b() <= 0) {
            f0(aVar);
            return;
        }
        B0();
        View view = aVar.k(0, Long.MAX_VALUE).f7618a;
        m7.c.p("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    @Override // o3.o0
    public final void b0(z0 z0Var) {
        if (v() == 0) {
            return;
        }
        o0.F(u(0));
    }

    @Override // o3.o0
    public final boolean d() {
        return A0();
    }

    @Override // o3.o0
    public final boolean e() {
        return !A0();
    }

    @Override // o3.o0
    public final int j(z0 z0Var) {
        throw null;
    }

    @Override // o3.o0
    public final boolean j0(RecyclerView recyclerView, View view, Rect rect, boolean z8, boolean z9) {
        return false;
    }

    @Override // o3.o0
    public final int k(z0 z0Var) {
        return this.f1982p;
    }

    @Override // o3.o0
    public final int l(z0 z0Var) {
        return 0 - 0;
    }

    @Override // o3.o0
    public final int l0(int i9, l7.a aVar, z0 z0Var) {
        if (A0()) {
            C0(i9, aVar, z0Var);
        }
        return 0;
    }

    @Override // o3.o0
    public final int m(z0 z0Var) {
        throw null;
    }

    @Override // o3.o0
    public final int n(z0 z0Var) {
        return this.f1982p;
    }

    @Override // o3.o0
    public final int n0(int i9, l7.a aVar, z0 z0Var) {
        if (e()) {
            C0(i9, aVar, z0Var);
        }
        return 0;
    }

    @Override // o3.o0
    public final int o(z0 z0Var) {
        return 0 - 0;
    }

    @Override // o3.o0
    public final p0 r() {
        return new p0(-2, -2);
    }

    @Override // o3.o0
    public final void w0(RecyclerView recyclerView, int i9) {
        w wVar = new w(this, recyclerView.getContext());
        wVar.f7853a = i9;
        x0(wVar);
    }

    @Override // o3.o0
    public final void y(View view, Rect rect) {
        super.y(view, rect);
        rect.centerX();
        throw null;
    }

    public CarouselLayoutManager() {
        new a();
        k0();
        D0(0);
    }

    @Override // o3.o0
    public final void m0(int i9) {
    }
}
