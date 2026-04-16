package n0;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a2 {

    /* renamed from: b, reason: collision with root package name */
    public static final a2 f7138b;

    /* renamed from: a, reason: collision with root package name */
    public final x1 f7139a;

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            f7138b = w1.f7226q;
        } else {
            f7138b = x1.f7234b;
        }
    }

    public a2(WindowInsets windowInsets) {
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 30) {
            this.f7139a = new w1(this, windowInsets);
            return;
        }
        if (i9 >= 29) {
            this.f7139a = new v1(this, windowInsets);
        } else if (i9 >= 28) {
            this.f7139a = new u1(this, windowInsets);
        } else {
            this.f7139a = new t1(this, windowInsets);
        }
    }

    public static f0.c e(f0.c cVar, int i9, int i10, int i11, int i12) {
        int max = Math.max(0, cVar.f3193a - i9);
        int max2 = Math.max(0, cVar.f3194b - i10);
        int max3 = Math.max(0, cVar.f3195c - i11);
        int max4 = Math.max(0, cVar.f3196d - i12);
        return (max == i9 && max2 == i10 && max3 == i11 && max4 == i12) ? cVar : f0.c.b(max, max2, max3, max4);
    }

    public static a2 g(View view, WindowInsets windowInsets) {
        windowInsets.getClass();
        a2 a2Var = new a2(windowInsets);
        if (view != null) {
            WeakHashMap weakHashMap = t0.f7209a;
            if (f0.b(view)) {
                a2 h = t0.h(view);
                x1 x1Var = a2Var.f7139a;
                x1Var.p(h);
                x1Var.d(view.getRootView());
            }
        }
        return a2Var;
    }

    public final int a() {
        return this.f7139a.j().f3196d;
    }

    public final int b() {
        return this.f7139a.j().f3193a;
    }

    public final int c() {
        return this.f7139a.j().f3195c;
    }

    public final int d() {
        return this.f7139a.j().f3194b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a2) {
            return m0.a.a(this.f7139a, ((a2) obj).f7139a);
        }
        return false;
    }

    public final WindowInsets f() {
        x1 x1Var = this.f7139a;
        if (x1Var instanceof s1) {
            return ((s1) x1Var).f7204c;
        }
        return null;
    }

    public final int hashCode() {
        x1 x1Var = this.f7139a;
        if (x1Var == null) {
            return 0;
        }
        return x1Var.hashCode();
    }

    public a2() {
        this.f7139a = new x1(this);
    }
}
