package n0;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.Objects;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h1 implements View.OnApplyWindowInsetsListener {

    /* renamed from: a, reason: collision with root package name */
    public final e f7162a;

    /* renamed from: b, reason: collision with root package name */
    public a2 f7163b;

    public h1(View view, e eVar) {
        a2 a2Var;
        this.f7162a = eVar;
        a2 h = t0.h(view);
        if (h != null) {
            int i9 = Build.VERSION.SDK_INT;
            a2Var = (i9 >= 30 ? new q1(h) : i9 >= 29 ? new p1(h) : new o1(h)).b();
        } else {
            a2Var = null;
        }
        this.f7163b = a2Var;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        if (!view.isLaidOut()) {
            this.f7163b = a2.g(view, windowInsets);
            return i1.i(view, windowInsets);
        }
        a2 g9 = a2.g(view, windowInsets);
        x1 x1Var = g9.f7139a;
        if (this.f7163b == null) {
            this.f7163b = t0.h(view);
        }
        if (this.f7163b == null) {
            this.f7163b = g9;
            return i1.i(view, windowInsets);
        }
        e j5 = i1.j(view);
        if (j5 != null && Objects.equals((WindowInsets) j5.f7148j, windowInsets)) {
            return i1.i(view, windowInsets);
        }
        a2 a2Var = this.f7163b;
        int i9 = 0;
        for (int i10 = 1; i10 <= 256; i10 <<= 1) {
            if (!x1Var.f(i10).equals(a2Var.f7139a.f(i10))) {
                i9 |= i10;
            }
        }
        if (i9 == 0) {
            return i1.i(view, windowInsets);
        }
        a2 a2Var2 = this.f7163b;
        m1 m1Var = new m1(i9, (i9 & 8) != 0 ? x1Var.f(8).f3196d > a2Var2.f7139a.f(8).f3196d ? i1.f7165e : i1.f7166f : i1.f7167g, 160L);
        m1Var.f7177a.d(0.0f);
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(m1Var.f7177a.a());
        f0.c f9 = x1Var.f(i9);
        f0.c f10 = a2Var2.f7139a.f(i9);
        int min = Math.min(f9.f3193a, f10.f3193a);
        int i11 = f9.f3194b;
        int i12 = f10.f3194b;
        int min2 = Math.min(i11, i12);
        int i13 = f9.f3195c;
        int i14 = f10.f3195c;
        int min3 = Math.min(i13, i14);
        int i15 = f9.f3196d;
        int i16 = i9;
        int i17 = f10.f3196d;
        m1.b bVar = new m1.b(f0.c.b(min, min2, min3, Math.min(i15, i17)), 4, f0.c.b(Math.max(f9.f3193a, f10.f3193a), Math.max(i11, i12), Math.max(i13, i14), Math.max(i15, i17)));
        i1.f(view, windowInsets, false);
        duration.addUpdateListener(new g1(m1Var, g9, a2Var2, i16, view));
        duration.addListener(new a1(m1Var, view, 1));
        u.a(view, new a5.g(view, m1Var, bVar, duration));
        this.f7163b = g9;
        return i1.i(view, windowInsets);
    }
}
