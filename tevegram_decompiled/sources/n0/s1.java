package n0;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class s1 extends x1 {
    public static boolean h = false;

    /* renamed from: i, reason: collision with root package name */
    public static Method f7200i;

    /* renamed from: j, reason: collision with root package name */
    public static Class f7201j;

    /* renamed from: k, reason: collision with root package name */
    public static Field f7202k;

    /* renamed from: l, reason: collision with root package name */
    public static Field f7203l;

    /* renamed from: c, reason: collision with root package name */
    public final WindowInsets f7204c;

    /* renamed from: d, reason: collision with root package name */
    public f0.c[] f7205d;

    /* renamed from: e, reason: collision with root package name */
    public f0.c f7206e;

    /* renamed from: f, reason: collision with root package name */
    public a2 f7207f;

    /* renamed from: g, reason: collision with root package name */
    public f0.c f7208g;

    public s1(a2 a2Var, WindowInsets windowInsets) {
        super(a2Var);
        this.f7206e = null;
        this.f7204c = windowInsets;
    }

    @SuppressLint({"WrongConstant"})
    private f0.c r(int i9, boolean z8) {
        f0.c cVar = f0.c.f3192e;
        for (int i10 = 1; i10 <= 256; i10 <<= 1) {
            if ((i9 & i10) != 0) {
                cVar = f0.c.a(cVar, s(i10, z8));
            }
        }
        return cVar;
    }

    private f0.c t() {
        a2 a2Var = this.f7207f;
        return a2Var != null ? a2Var.f7139a.h() : f0.c.f3192e;
    }

    private f0.c u(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            androidx.fragment.app.a.h("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            return null;
        }
        if (!h) {
            v();
        }
        Method method = f7200i;
        if (method != null && f7201j != null && f7202k != null) {
            try {
                Object invoke = method.invoke(view, null);
                if (invoke == null) {
                    Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                    return null;
                }
                Rect rect = (Rect) f7202k.get(f7203l.get(invoke));
                if (rect != null) {
                    return f0.c.b(rect.left, rect.top, rect.right, rect.bottom);
                }
            } catch (ReflectiveOperationException e9) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e9.getMessage(), e9);
            }
        }
        return null;
    }

    @SuppressLint({"PrivateApi"})
    private static void v() {
        try {
            f7200i = View.class.getDeclaredMethod("getViewRootImpl", null);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            f7201j = cls;
            f7202k = cls.getDeclaredField("mVisibleInsets");
            f7203l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
            f7202k.setAccessible(true);
            f7203l.setAccessible(true);
        } catch (ReflectiveOperationException e9) {
            Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e9.getMessage(), e9);
        }
        h = true;
    }

    @Override // n0.x1
    public void d(View view) {
        f0.c u3 = u(view);
        if (u3 == null) {
            u3 = f0.c.f3192e;
        }
        w(u3);
    }

    @Override // n0.x1
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return Objects.equals(this.f7208g, ((s1) obj).f7208g);
        }
        return false;
    }

    @Override // n0.x1
    public f0.c f(int i9) {
        return r(i9, false);
    }

    @Override // n0.x1
    public final f0.c j() {
        if (this.f7206e == null) {
            WindowInsets windowInsets = this.f7204c;
            this.f7206e = f0.c.b(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        }
        return this.f7206e;
    }

    @Override // n0.x1
    public a2 l(int i9, int i10, int i11, int i12) {
        a2 g9 = a2.g(null, this.f7204c);
        int i13 = Build.VERSION.SDK_INT;
        r1 q1Var = i13 >= 30 ? new q1(g9) : i13 >= 29 ? new p1(g9) : new o1(g9);
        q1Var.g(a2.e(j(), i9, i10, i11, i12));
        q1Var.e(a2.e(h(), i9, i10, i11, i12));
        return q1Var.b();
    }

    @Override // n0.x1
    public boolean n() {
        return this.f7204c.isRound();
    }

    @Override // n0.x1
    public void o(f0.c[] cVarArr) {
        this.f7205d = cVarArr;
    }

    @Override // n0.x1
    public void p(a2 a2Var) {
        this.f7207f = a2Var;
    }

    public f0.c s(int i9, boolean z8) {
        f0.c h9;
        int i10;
        if (i9 == 1) {
            return z8 ? f0.c.b(0, Math.max(t().f3194b, j().f3194b), 0, 0) : f0.c.b(0, j().f3194b, 0, 0);
        }
        if (i9 == 2) {
            if (z8) {
                f0.c t8 = t();
                f0.c h10 = h();
                return f0.c.b(Math.max(t8.f3193a, h10.f3193a), 0, Math.max(t8.f3195c, h10.f3195c), Math.max(t8.f3196d, h10.f3196d));
            }
            f0.c j5 = j();
            a2 a2Var = this.f7207f;
            h9 = a2Var != null ? a2Var.f7139a.h() : null;
            int i11 = j5.f3196d;
            if (h9 != null) {
                i11 = Math.min(i11, h9.f3196d);
            }
            return f0.c.b(j5.f3193a, 0, j5.f3195c, i11);
        }
        f0.c cVar = f0.c.f3192e;
        if (i9 == 8) {
            f0.c[] cVarArr = this.f7205d;
            h9 = cVarArr != null ? cVarArr[com.bumptech.glide.d.K(8)] : null;
            if (h9 != null) {
                return h9;
            }
            f0.c j9 = j();
            f0.c t9 = t();
            int i12 = j9.f3196d;
            if (i12 > t9.f3196d) {
                return f0.c.b(0, 0, 0, i12);
            }
            f0.c cVar2 = this.f7208g;
            if (cVar2 != null && !cVar2.equals(cVar) && (i10 = this.f7208g.f3196d) > t9.f3196d) {
                return f0.c.b(0, 0, 0, i10);
            }
        } else {
            if (i9 == 16) {
                return i();
            }
            if (i9 == 32) {
                return g();
            }
            if (i9 == 64) {
                return k();
            }
            if (i9 == 128) {
                a2 a2Var2 = this.f7207f;
                i e9 = a2Var2 != null ? a2Var2.f7139a.e() : e();
                if (e9 != null) {
                    int i13 = Build.VERSION.SDK_INT;
                    return f0.c.b(i13 >= 28 ? h.d(e9.f7164a) : 0, i13 >= 28 ? h.f(e9.f7164a) : 0, i13 >= 28 ? h.e(e9.f7164a) : 0, i13 >= 28 ? h.c(e9.f7164a) : 0);
                }
            }
        }
        return cVar;
    }

    public void w(f0.c cVar) {
        this.f7208g = cVar;
    }
}
