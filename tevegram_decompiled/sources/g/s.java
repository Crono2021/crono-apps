package g;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import n.f4;
import n.n1;
import n0.a2;
import n0.o1;
import n0.p1;
import n0.q1;
import n0.r1;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class s implements n0.r, n1, m.y {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f3630i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ c0 f3631j;

    public /* synthetic */ s(c0 c0Var, int i9) {
        this.f3630i = i9;
        this.f3631j = c0Var;
    }

    @Override // m.y
    public void a(m.m mVar, boolean z8) {
        b0 b0Var;
        switch (this.f3630i) {
            case 2:
                this.f3631j.r(mVar);
                break;
            default:
                m.m k3 = mVar.k();
                int i9 = 0;
                boolean z9 = k3 != mVar;
                if (z9) {
                    mVar = k3;
                }
                c0 c0Var = this.f3631j;
                b0[] b0VarArr = c0Var.T;
                int length = b0VarArr != null ? b0VarArr.length : 0;
                while (true) {
                    if (i9 >= length) {
                        b0Var = null;
                    } else {
                        b0Var = b0VarArr[i9];
                        if (b0Var == null || b0Var.h != mVar) {
                            i9++;
                        }
                    }
                }
                if (b0Var != null) {
                    if (!z9) {
                        c0Var.s(b0Var, z8);
                        break;
                    } else {
                        c0Var.q(b0Var.f3452a, b0Var, k3);
                        c0Var.s(b0Var, true);
                        break;
                    }
                }
                break;
        }
    }

    @Override // n0.r
    public a2 c(View view, a2 a2Var) {
        boolean z8;
        a2 a2Var2;
        boolean z9;
        int d9 = a2Var.d();
        c0 c0Var = this.f3631j;
        Context context = c0Var.f3488s;
        int d10 = a2Var.d();
        ActionBarContextView actionBarContextView = c0Var.D;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z8 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) c0Var.D.getLayoutParams();
            if (c0Var.D.isShown()) {
                if (c0Var.f3482k0 == null) {
                    c0Var.f3482k0 = new Rect();
                    c0Var.f3483l0 = new Rect();
                }
                Rect rect = c0Var.f3482k0;
                Rect rect2 = c0Var.f3483l0;
                rect.set(a2Var.b(), a2Var.d(), a2Var.c(), a2Var.a());
                ViewGroup viewGroup = c0Var.I;
                Method method = f4.f6863a;
                if (method != null) {
                    try {
                        method.invoke(viewGroup, rect, rect2);
                    } catch (Exception e9) {
                        Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e9);
                    }
                }
                int i9 = rect.top;
                int i10 = rect.left;
                int i11 = rect.right;
                a2 h = t0.h(c0Var.I);
                int b9 = h == null ? 0 : h.b();
                int c9 = h == null ? 0 : h.c();
                if (marginLayoutParams.topMargin == i9 && marginLayoutParams.leftMargin == i10 && marginLayoutParams.rightMargin == i11) {
                    z9 = false;
                } else {
                    marginLayoutParams.topMargin = i9;
                    marginLayoutParams.leftMargin = i10;
                    marginLayoutParams.rightMargin = i11;
                    z9 = true;
                }
                if (i9 <= 0 || c0Var.K != null) {
                    View view2 = c0Var.K;
                    if (view2 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                        int i12 = marginLayoutParams2.height;
                        int i13 = marginLayoutParams.topMargin;
                        if (i12 != i13 || marginLayoutParams2.leftMargin != b9 || marginLayoutParams2.rightMargin != c9) {
                            marginLayoutParams2.height = i13;
                            marginLayoutParams2.leftMargin = b9;
                            marginLayoutParams2.rightMargin = c9;
                            c0Var.K.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view3 = new View(context);
                    c0Var.K = view3;
                    view3.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = b9;
                    layoutParams.rightMargin = c9;
                    c0Var.I.addView(c0Var.K, -1, layoutParams);
                }
                View view4 = c0Var.K;
                z8 = view4 != null;
                if (z8 && view4.getVisibility() != 0) {
                    View view5 = c0Var.K;
                    view5.setBackgroundColor((n0.c0.g(view5) & 8192) != 0 ? a.a.t(context, 2131099654) : a.a.t(context, 2131099653));
                }
                if (!c0Var.P && z8) {
                    d10 = 0;
                }
            } else {
                if (marginLayoutParams.topMargin != 0) {
                    marginLayoutParams.topMargin = 0;
                    z9 = true;
                } else {
                    z9 = false;
                }
                z8 = false;
            }
            if (z9) {
                c0Var.D.setLayoutParams(marginLayoutParams);
            }
        }
        View view6 = c0Var.K;
        if (view6 != null) {
            view6.setVisibility(z8 ? 0 : 8);
        }
        if (d9 != d10) {
            int b10 = a2Var.b();
            int c10 = a2Var.c();
            int a9 = a2Var.a();
            int i14 = Build.VERSION.SDK_INT;
            r1 q1Var = i14 >= 30 ? new q1(a2Var) : i14 >= 29 ? new p1(a2Var) : new o1(a2Var);
            q1Var.g(f0.c.b(b10, d10, c10, a9));
            a2Var2 = q1Var.b();
        } else {
            a2Var2 = a2Var;
        }
        WeakHashMap weakHashMap = t0.f7209a;
        WindowInsets f9 = a2Var2.f();
        if (f9 == null) {
            return a2Var2;
        }
        WindowInsets b11 = n0.g0.b(view, f9);
        return !b11.equals(f9) ? a2.g(view, b11) : a2Var2;
    }

    @Override // m.y
    public boolean l(m.m mVar) {
        Window.Callback callback;
        switch (this.f3630i) {
            case 2:
                Window.Callback callback2 = this.f3631j.f3489t.getCallback();
                if (callback2 != null) {
                    callback2.onMenuOpened(108, mVar);
                    break;
                }
                break;
            default:
                if (mVar == mVar.k()) {
                    c0 c0Var = this.f3631j;
                    if (c0Var.N && (callback = c0Var.f3489t.getCallback()) != null && !c0Var.Y) {
                        callback.onMenuOpened(108, mVar);
                        break;
                    }
                }
                break;
        }
        return true;
    }
}
