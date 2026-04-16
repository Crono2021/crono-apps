package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.activity.g;
import androidx.emoji2.text.h;
import i3.u;
import java.util.ArrayList;
import java.util.List;
import l7.a;
import m7.c;
import o3.d1;
import o3.n0;
import o3.o;
import o3.o0;
import o3.p0;
import o3.r;
import o3.w;
import o3.x;
import o3.y;
import o3.y0;
import o3.z;
import o3.z0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class LinearLayoutManager extends o0 implements y0 {
    public final u A;
    public final w B;
    public final int C;
    public final int[] D;

    /* renamed from: p, reason: collision with root package name */
    public int f1036p;

    /* renamed from: q, reason: collision with root package name */
    public x f1037q;

    /* renamed from: r, reason: collision with root package name */
    public h f1038r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f1039s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f1040t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f1041u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f1042v;

    /* renamed from: w, reason: collision with root package name */
    public final boolean f1043w;

    /* renamed from: x, reason: collision with root package name */
    public int f1044x;

    /* renamed from: y, reason: collision with root package name */
    public int f1045y;

    /* renamed from: z, reason: collision with root package name */
    public y f1046z;

    @SuppressLint({"UnknownNullness"})
    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i9, int i10) {
        this.f1036p = 1;
        this.f1040t = false;
        this.f1041u = false;
        this.f1042v = false;
        this.f1043w = true;
        this.f1044x = -1;
        this.f1045y = Integer.MIN_VALUE;
        this.f1046z = null;
        this.A = new u();
        this.B = new w();
        this.C = 2;
        this.D = new int[2];
        n0 G = o0.G(context, attributeSet, i9, i10);
        Y0(G.f7743a);
        boolean z8 = G.f7745c;
        c(null);
        if (z8 != this.f1040t) {
            this.f1040t = z8;
            k0();
        }
        Z0(G.f7746d);
    }

    public void A0(z0 z0Var, x xVar, r rVar) {
        int i9 = xVar.f7835d;
        if (i9 < 0 || i9 >= z0Var.b()) {
            return;
        }
        rVar.b(i9, Math.max(0, xVar.f7838g));
    }

    public final int B0(z0 z0Var) {
        if (v() == 0) {
            return 0;
        }
        F0();
        h hVar = this.f1038r;
        boolean z8 = !this.f1043w;
        return o.d(z0Var, hVar, I0(z8), H0(z8), this, this.f1043w);
    }

    public final int C0(z0 z0Var) {
        if (v() == 0) {
            return 0;
        }
        F0();
        h hVar = this.f1038r;
        boolean z8 = !this.f1043w;
        return o.e(z0Var, hVar, I0(z8), H0(z8), this, this.f1043w, this.f1041u);
    }

    public final int D0(z0 z0Var) {
        if (v() == 0) {
            return 0;
        }
        F0();
        h hVar = this.f1038r;
        boolean z8 = !this.f1043w;
        return o.f(z0Var, hVar, I0(z8), H0(z8), this, this.f1043w);
    }

    public final int E0(int i9) {
        return i9 != 1 ? i9 != 2 ? i9 != 17 ? i9 != 33 ? i9 != 66 ? (i9 == 130 && this.f1036p == 1) ? 1 : Integer.MIN_VALUE : this.f1036p == 0 ? 1 : Integer.MIN_VALUE : this.f1036p == 1 ? -1 : Integer.MIN_VALUE : this.f1036p == 0 ? -1 : Integer.MIN_VALUE : (this.f1036p != 1 && R0()) ? -1 : 1 : (this.f1036p != 1 && R0()) ? 1 : -1;
    }

    public final void F0() {
        if (this.f1037q == null) {
            x xVar = new x();
            xVar.f7832a = true;
            xVar.h = 0;
            xVar.f7839i = 0;
            xVar.f7841k = null;
            this.f1037q = xVar;
        }
    }

    public final int G0(a aVar, x xVar, z0 z0Var, boolean z8) {
        int i9;
        int i10 = xVar.f7834c;
        int i11 = xVar.f7838g;
        if (i11 != Integer.MIN_VALUE) {
            if (i10 < 0) {
                xVar.f7838g = i11 + i10;
            }
            U0(aVar, xVar);
        }
        int i12 = xVar.f7834c + xVar.h;
        while (true) {
            if ((!xVar.f7842l && i12 <= 0) || (i9 = xVar.f7835d) < 0 || i9 >= z0Var.b()) {
                break;
            }
            w wVar = this.B;
            wVar.f7827a = 0;
            wVar.f7828b = false;
            wVar.f7829c = false;
            wVar.f7830d = false;
            S0(aVar, z0Var, xVar, wVar);
            if (!wVar.f7828b) {
                int i13 = xVar.f7833b;
                int i14 = wVar.f7827a;
                xVar.f7833b = (xVar.f7837f * i14) + i13;
                if (!wVar.f7829c || xVar.f7841k != null || !z0Var.f7874g) {
                    xVar.f7834c -= i14;
                    i12 -= i14;
                }
                int i15 = xVar.f7838g;
                if (i15 != Integer.MIN_VALUE) {
                    int i16 = i15 + i14;
                    xVar.f7838g = i16;
                    int i17 = xVar.f7834c;
                    if (i17 < 0) {
                        xVar.f7838g = i16 + i17;
                    }
                    U0(aVar, xVar);
                }
                if (z8 && wVar.f7830d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i10 - xVar.f7834c;
    }

    public final View H0(boolean z8) {
        return this.f1041u ? L0(0, v(), z8) : L0(v() - 1, -1, z8);
    }

    public final View I0(boolean z8) {
        return this.f1041u ? L0(v() - 1, -1, z8) : L0(0, v(), z8);
    }

    @Override // o3.o0
    public final boolean J() {
        return true;
    }

    public final int J0() {
        View L0 = L0(v() - 1, -1, false);
        if (L0 == null) {
            return -1;
        }
        return o0.F(L0);
    }

    public final View K0(int i9, int i10) {
        int i11;
        int i12;
        F0();
        if (i10 <= i9 && i10 >= i9) {
            return u(i9);
        }
        if (this.f1038r.e(u(i9)) < this.f1038r.k()) {
            i11 = 16644;
            i12 = 16388;
        } else {
            i11 = 4161;
            i12 = 4097;
        }
        return this.f1036p == 0 ? this.f7750c.j(i9, i10, i11, i12) : this.f7751d.j(i9, i10, i11, i12);
    }

    public final View L0(int i9, int i10, boolean z8) {
        F0();
        int i11 = z8 ? 24579 : 320;
        return this.f1036p == 0 ? this.f7750c.j(i9, i10, i11, 320) : this.f7751d.j(i9, i10, i11, 320);
    }

    public View M0(a aVar, z0 z0Var, boolean z8, boolean z9) {
        int i9;
        int i10;
        int i11;
        F0();
        int v8 = v();
        if (z9) {
            i10 = v() - 1;
            i9 = -1;
            i11 = -1;
        } else {
            i9 = v8;
            i10 = 0;
            i11 = 1;
        }
        int b9 = z0Var.b();
        int k3 = this.f1038r.k();
        int g9 = this.f1038r.g();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (i10 != i9) {
            View u3 = u(i10);
            int F = o0.F(u3);
            int e9 = this.f1038r.e(u3);
            int b10 = this.f1038r.b(u3);
            if (F >= 0 && F < b9) {
                if (!((p0) u3.getLayoutParams()).f7765a.h()) {
                    boolean z10 = b10 <= k3 && e9 < k3;
                    boolean z11 = e9 >= g9 && b10 > g9;
                    if (!z10 && !z11) {
                        return u3;
                    }
                    if (z8) {
                        if (!z11) {
                            if (view != null) {
                            }
                            view = u3;
                        }
                        view2 = u3;
                    } else {
                        if (!z10) {
                            if (view != null) {
                            }
                            view = u3;
                        }
                        view2 = u3;
                    }
                } else if (view3 == null) {
                    view3 = u3;
                }
            }
            i10 += i11;
        }
        return view != null ? view : view2 != null ? view2 : view3;
    }

    public final int N0(int i9, a aVar, z0 z0Var, boolean z8) {
        int g9;
        int g10 = this.f1038r.g() - i9;
        if (g10 <= 0) {
            return 0;
        }
        int i10 = -X0(-g10, aVar, z0Var);
        int i11 = i9 + i10;
        if (!z8 || (g9 = this.f1038r.g() - i11) <= 0) {
            return i10;
        }
        this.f1038r.o(g9);
        return g9 + i10;
    }

    public final int O0(int i9, a aVar, z0 z0Var, boolean z8) {
        int k3;
        int k9 = i9 - this.f1038r.k();
        if (k9 <= 0) {
            return 0;
        }
        int i10 = -X0(k9, aVar, z0Var);
        int i11 = i9 + i10;
        if (!z8 || (k3 = i11 - this.f1038r.k()) <= 0) {
            return i10;
        }
        this.f1038r.o(-k3);
        return i10 - k3;
    }

    public final View P0() {
        return u(this.f1041u ? 0 : v() - 1);
    }

    @Override // o3.o0
    public View Q(View view, int i9, a aVar, z0 z0Var) {
        int E0;
        W0();
        if (v() != 0 && (E0 = E0(i9)) != Integer.MIN_VALUE) {
            F0();
            a1(E0, (int) (this.f1038r.l() * 0.33333334f), false, z0Var);
            x xVar = this.f1037q;
            xVar.f7838g = Integer.MIN_VALUE;
            xVar.f7832a = false;
            G0(aVar, xVar, z0Var, true);
            boolean z8 = this.f1041u;
            View K0 = E0 == -1 ? z8 ? K0(v() - 1, -1) : K0(0, v()) : z8 ? K0(0, v()) : K0(v() - 1, -1);
            View Q0 = E0 == -1 ? Q0() : P0();
            if (!Q0.hasFocusable()) {
                return K0;
            }
            if (K0 != null) {
                return Q0;
            }
        }
        return null;
    }

    public final View Q0() {
        return u(this.f1041u ? v() - 1 : 0);
    }

    @Override // o3.o0
    public final void R(AccessibilityEvent accessibilityEvent) {
        super.R(accessibilityEvent);
        if (v() > 0) {
            View L0 = L0(0, v(), false);
            accessibilityEvent.setFromIndex(L0 == null ? -1 : o0.F(L0));
            accessibilityEvent.setToIndex(J0());
        }
    }

    public final boolean R0() {
        return A() == 1;
    }

    public void S0(a aVar, z0 z0Var, x xVar, w wVar) {
        int d9;
        int i9;
        int i10;
        int i11;
        int C;
        View b9 = xVar.b(aVar);
        if (b9 == null) {
            wVar.f7828b = true;
            return;
        }
        p0 p0Var = (p0) b9.getLayoutParams();
        List list = xVar.f7841k;
        boolean z8 = this.f1041u;
        int i12 = xVar.f7837f;
        if (list == null) {
            if (z8 == (i12 == -1)) {
                b(b9, -1, false);
            } else {
                b(b9, 0, false);
            }
        } else {
            if (z8 == (i12 == -1)) {
                b(b9, -1, true);
            } else {
                b(b9, 0, true);
            }
        }
        p0 p0Var2 = (p0) b9.getLayoutParams();
        Rect K = this.f7749b.K(b9);
        int i13 = K.left + K.right;
        int i14 = K.top + K.bottom;
        int w8 = o0.w(this.f7760n, this.f7758l, D() + C() + ((ViewGroup.MarginLayoutParams) p0Var2).leftMargin + ((ViewGroup.MarginLayoutParams) p0Var2).rightMargin + i13, ((ViewGroup.MarginLayoutParams) p0Var2).width, d());
        int w9 = o0.w(this.f7761o, this.f7759m, B() + E() + ((ViewGroup.MarginLayoutParams) p0Var2).topMargin + ((ViewGroup.MarginLayoutParams) p0Var2).bottomMargin + i14, ((ViewGroup.MarginLayoutParams) p0Var2).height, e());
        if (t0(b9, w8, w9, p0Var2)) {
            b9.measure(w8, w9);
        }
        wVar.f7827a = this.f1038r.c(b9);
        if (this.f1036p == 1) {
            if (R0()) {
                i11 = this.f7760n - D();
                C = i11 - this.f1038r.d(b9);
            } else {
                C = C();
                i11 = this.f1038r.d(b9) + C;
            }
            int i15 = xVar.f7837f;
            i10 = xVar.f7833b;
            int i16 = wVar.f7827a;
            if (i15 == -1) {
                int i17 = C;
                d9 = i10;
                i10 -= i16;
                i9 = i17;
            } else {
                i9 = C;
                d9 = i16 + i10;
            }
        } else {
            int E = E();
            d9 = this.f1038r.d(b9) + E;
            int i18 = xVar.f7837f;
            int i19 = xVar.f7833b;
            int i20 = wVar.f7827a;
            if (i18 == -1) {
                i9 = i19 - i20;
                i11 = i19;
                i10 = E;
            } else {
                int i21 = i19 + i20;
                i9 = i19;
                i10 = E;
                i11 = i21;
            }
        }
        o0.L(b9, i9, i10, i11, d9);
        if (p0Var.f7765a.h() || p0Var.f7765a.k()) {
            wVar.f7829c = true;
        }
        wVar.f7830d = b9.hasFocusable();
    }

    public final void U0(a aVar, x xVar) {
        if (!xVar.f7832a || xVar.f7842l) {
            return;
        }
        int i9 = xVar.f7838g;
        int i10 = xVar.f7839i;
        if (xVar.f7837f == -1) {
            int v8 = v();
            if (i9 < 0) {
                return;
            }
            int f9 = (this.f1038r.f() - i9) + i10;
            if (this.f1041u) {
                for (int i11 = 0; i11 < v8; i11++) {
                    View u3 = u(i11);
                    if (this.f1038r.e(u3) < f9 || this.f1038r.n(u3) < f9) {
                        V0(aVar, 0, i11);
                        return;
                    }
                }
                return;
            }
            int i12 = v8 - 1;
            for (int i13 = i12; i13 >= 0; i13--) {
                View u6 = u(i13);
                if (this.f1038r.e(u6) < f9 || this.f1038r.n(u6) < f9) {
                    V0(aVar, i12, i13);
                    return;
                }
            }
            return;
        }
        if (i9 < 0) {
            return;
        }
        int i14 = i9 - i10;
        int v9 = v();
        if (!this.f1041u) {
            for (int i15 = 0; i15 < v9; i15++) {
                View u8 = u(i15);
                if (this.f1038r.b(u8) > i14 || this.f1038r.m(u8) > i14) {
                    V0(aVar, 0, i15);
                    return;
                }
            }
            return;
        }
        int i16 = v9 - 1;
        for (int i17 = i16; i17 >= 0; i17--) {
            View u9 = u(i17);
            if (this.f1038r.b(u9) > i14 || this.f1038r.m(u9) > i14) {
                V0(aVar, i16, i17);
                return;
            }
        }
    }

    public final void V0(a aVar, int i9, int i10) {
        if (i9 == i10) {
            return;
        }
        if (i10 <= i9) {
            while (i9 > i10) {
                View u3 = u(i9);
                i0(i9);
                aVar.h(u3);
                i9--;
            }
            return;
        }
        for (int i11 = i10 - 1; i11 >= i9; i11--) {
            View u6 = u(i11);
            i0(i11);
            aVar.h(u6);
        }
    }

    public final void W0() {
        if (this.f1036p == 1 || !R0()) {
            this.f1041u = this.f1040t;
        } else {
            this.f1041u = !this.f1040t;
        }
    }

    public final int X0(int i9, a aVar, z0 z0Var) {
        if (v() != 0 && i9 != 0) {
            F0();
            this.f1037q.f7832a = true;
            int i10 = i9 > 0 ? 1 : -1;
            int abs = Math.abs(i9);
            a1(i10, abs, true, z0Var);
            x xVar = this.f1037q;
            int G0 = G0(aVar, xVar, z0Var, false) + xVar.f7838g;
            if (G0 >= 0) {
                if (abs > G0) {
                    i9 = i10 * G0;
                }
                this.f1038r.o(-i9);
                this.f1037q.f7840j = i9;
                return i9;
            }
        }
        return 0;
    }

    public final void Y0(int i9) {
        if (i9 != 0 && i9 != 1) {
            c.n(g.m(i9, "invalid orientation:"));
            return;
        }
        c(null);
        if (i9 != this.f1036p || this.f1038r == null) {
            h a9 = h.a(this, i9);
            this.f1038r = a9;
            this.A.f4662f = a9;
            this.f1036p = i9;
            k0();
        }
    }

    public void Z0(boolean z8) {
        c(null);
        if (this.f1042v == z8) {
            return;
        }
        this.f1042v = z8;
        k0();
    }

    @Override // o3.y0
    public final PointF a(int i9) {
        if (v() == 0) {
            return null;
        }
        int i10 = (i9 < o0.F(u(0))) != this.f1041u ? -1 : 1;
        return this.f1036p == 0 ? new PointF(i10, 0.0f) : new PointF(0.0f, i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v14 */
    @Override // o3.o0
    public void a0(a aVar, z0 z0Var) {
        View view;
        View view2;
        View M0;
        int i9;
        int e9;
        int i10;
        int i11;
        ?? r42;
        List list;
        int i12;
        int i13;
        int N0;
        int i14;
        View q4;
        int e10;
        int i15;
        int i16;
        int i17 = -1;
        if (!(this.f1046z == null && this.f1044x == -1) && z0Var.b() == 0) {
            f0(aVar);
            return;
        }
        y yVar = this.f1046z;
        if (yVar != null && (i16 = yVar.f7850i) >= 0) {
            this.f1044x = i16;
        }
        F0();
        this.f1037q.f7832a = false;
        W0();
        RecyclerView recyclerView = this.f7749b;
        if (recyclerView == null || (view = recyclerView.getFocusedChild()) == null || ((ArrayList) this.f7748a.f730l).contains(view)) {
            view = null;
        }
        u uVar = this.A;
        if (!uVar.f4661e || this.f1044x != -1 || this.f1046z != null) {
            uVar.e();
            uVar.f4660d = this.f1041u ^ this.f1042v;
            if (!z0Var.f7874g && (i9 = this.f1044x) != -1) {
                if (i9 < 0 || i9 >= z0Var.b()) {
                    this.f1044x = -1;
                    this.f1045y = Integer.MIN_VALUE;
                } else {
                    int i18 = this.f1044x;
                    uVar.f4658b = i18;
                    y yVar2 = this.f1046z;
                    if (yVar2 != null && yVar2.f7850i >= 0) {
                        boolean z8 = yVar2.f7852k;
                        uVar.f4660d = z8;
                        h hVar = this.f1038r;
                        if (z8) {
                            uVar.f4659c = hVar.g() - this.f1046z.f7851j;
                        } else {
                            uVar.f4659c = hVar.k() + this.f1046z.f7851j;
                        }
                    } else if (this.f1045y == Integer.MIN_VALUE) {
                        View q7 = q(i18);
                        if (q7 == null) {
                            if (v() > 0) {
                                uVar.f4660d = (this.f1044x < o0.F(u(0))) == this.f1041u;
                            }
                            uVar.b();
                        } else if (this.f1038r.c(q7) > this.f1038r.l()) {
                            uVar.b();
                        } else {
                            int e11 = this.f1038r.e(q7) - this.f1038r.k();
                            h hVar2 = this.f1038r;
                            if (e11 < 0) {
                                uVar.f4659c = hVar2.k();
                                uVar.f4660d = false;
                            } else if (hVar2.g() - this.f1038r.b(q7) < 0) {
                                uVar.f4659c = this.f1038r.g();
                                uVar.f4660d = true;
                            } else {
                                boolean z9 = uVar.f4660d;
                                h hVar3 = this.f1038r;
                                if (z9) {
                                    int b9 = hVar3.b(q7);
                                    h hVar4 = this.f1038r;
                                    e9 = (Integer.MIN_VALUE == hVar4.f617a ? 0 : hVar4.l() - hVar4.f617a) + b9;
                                } else {
                                    e9 = hVar3.e(q7);
                                }
                                uVar.f4659c = e9;
                            }
                        }
                    } else {
                        boolean z10 = this.f1041u;
                        uVar.f4660d = z10;
                        h hVar5 = this.f1038r;
                        if (z10) {
                            uVar.f4659c = hVar5.g() - this.f1045y;
                        } else {
                            uVar.f4659c = hVar5.k() + this.f1045y;
                        }
                    }
                    uVar.f4661e = true;
                }
            }
            if (v() != 0) {
                RecyclerView recyclerView2 = this.f7749b;
                if (recyclerView2 == null || (view2 = recyclerView2.getFocusedChild()) == null || ((ArrayList) this.f7748a.f730l).contains(view2)) {
                    view2 = null;
                }
                if (view2 != null) {
                    p0 p0Var = (p0) view2.getLayoutParams();
                    if (!p0Var.f7765a.h() && p0Var.f7765a.b() >= 0 && p0Var.f7765a.b() < z0Var.b()) {
                        uVar.c(view2, o0.F(view2));
                        uVar.f4661e = true;
                    }
                }
                boolean z11 = this.f1039s;
                boolean z12 = this.f1042v;
                if (z11 == z12 && (M0 = M0(aVar, z0Var, uVar.f4660d, z12)) != null) {
                    int F = o0.F(M0);
                    boolean z13 = uVar.f4660d;
                    h hVar6 = (h) uVar.f4662f;
                    if (z13) {
                        int b10 = hVar6.b(M0);
                        h hVar7 = (h) uVar.f4662f;
                        uVar.f4659c = (Integer.MIN_VALUE == hVar7.f617a ? 0 : hVar7.l() - hVar7.f617a) + b10;
                    } else {
                        uVar.f4659c = hVar6.e(M0);
                    }
                    uVar.f4658b = F;
                    if (!z0Var.f7874g && y0()) {
                        int e12 = this.f1038r.e(M0);
                        int b11 = this.f1038r.b(M0);
                        int k3 = this.f1038r.k();
                        int g9 = this.f1038r.g();
                        boolean z14 = b11 <= k3 && e12 < k3;
                        boolean z15 = e12 >= g9 && b11 > g9;
                        if (z14 || z15) {
                            if (uVar.f4660d) {
                                k3 = g9;
                            }
                            uVar.f4659c = k3;
                        }
                    }
                    uVar.f4661e = true;
                }
            }
            uVar.b();
            uVar.f4658b = this.f1042v ? z0Var.b() - 1 : 0;
            uVar.f4661e = true;
        } else if (view != null && (this.f1038r.e(view) >= this.f1038r.g() || this.f1038r.b(view) <= this.f1038r.k())) {
            uVar.c(view, o0.F(view));
        }
        x xVar = this.f1037q;
        xVar.f7837f = xVar.f7840j >= 0 ? 1 : -1;
        int[] iArr = this.D;
        iArr[0] = 0;
        iArr[1] = 0;
        z0(z0Var, iArr);
        int k9 = this.f1038r.k() + Math.max(0, iArr[0]);
        int h = this.f1038r.h() + Math.max(0, iArr[1]);
        if (z0Var.f7874g && (i14 = this.f1044x) != -1 && this.f1045y != Integer.MIN_VALUE && (q4 = q(i14)) != null) {
            boolean z16 = this.f1041u;
            h hVar8 = this.f1038r;
            if (z16) {
                i15 = hVar8.g() - this.f1038r.b(q4);
                e10 = this.f1045y;
            } else {
                e10 = hVar8.e(q4) - this.f1038r.k();
                i15 = this.f1045y;
            }
            int i19 = i15 - e10;
            if (i19 > 0) {
                k9 += i19;
            } else {
                h -= i19;
            }
        }
        boolean z17 = uVar.f4660d;
        boolean z18 = this.f1041u;
        if (!z17 ? !z18 : z18) {
            i17 = 1;
        }
        T0(aVar, z0Var, uVar, i17);
        p(aVar);
        this.f1037q.f7842l = this.f1038r.i() == 0 && this.f1038r.f() == 0;
        this.f1037q.getClass();
        this.f1037q.f7839i = 0;
        boolean z19 = uVar.f4660d;
        int i20 = uVar.f4658b;
        if (z19) {
            c1(i20, uVar.f4659c);
            x xVar2 = this.f1037q;
            xVar2.h = k9;
            G0(aVar, xVar2, z0Var, false);
            x xVar3 = this.f1037q;
            i11 = xVar3.f7833b;
            int i21 = xVar3.f7835d;
            int i22 = xVar3.f7834c;
            if (i22 > 0) {
                h += i22;
            }
            b1(uVar.f4658b, uVar.f4659c);
            x xVar4 = this.f1037q;
            xVar4.h = h;
            xVar4.f7835d += xVar4.f7836e;
            G0(aVar, xVar4, z0Var, false);
            x xVar5 = this.f1037q;
            i10 = xVar5.f7833b;
            int i23 = xVar5.f7834c;
            if (i23 > 0) {
                c1(i21, i11);
                x xVar6 = this.f1037q;
                xVar6.h = i23;
                G0(aVar, xVar6, z0Var, false);
                i11 = this.f1037q.f7833b;
            }
        } else {
            b1(i20, uVar.f4659c);
            x xVar7 = this.f1037q;
            xVar7.h = h;
            G0(aVar, xVar7, z0Var, false);
            x xVar8 = this.f1037q;
            i10 = xVar8.f7833b;
            int i24 = xVar8.f7835d;
            int i25 = xVar8.f7834c;
            if (i25 > 0) {
                k9 += i25;
            }
            c1(uVar.f4658b, uVar.f4659c);
            x xVar9 = this.f1037q;
            xVar9.h = k9;
            xVar9.f7835d += xVar9.f7836e;
            G0(aVar, xVar9, z0Var, false);
            x xVar10 = this.f1037q;
            int i26 = xVar10.f7833b;
            int i27 = xVar10.f7834c;
            if (i27 > 0) {
                b1(i24, i10);
                x xVar11 = this.f1037q;
                xVar11.h = i27;
                G0(aVar, xVar11, z0Var, false);
                i10 = this.f1037q.f7833b;
            }
            i11 = i26;
        }
        if (v() > 0) {
            if (this.f1041u ^ this.f1042v) {
                int N02 = N0(i10, aVar, z0Var, true);
                i12 = i11 + N02;
                i13 = i10 + N02;
                N0 = O0(i12, aVar, z0Var, false);
            } else {
                int O0 = O0(i11, aVar, z0Var, true);
                i12 = i11 + O0;
                i13 = i10 + O0;
                N0 = N0(i13, aVar, z0Var, false);
            }
            i11 = i12 + N0;
            i10 = i13 + N0;
        }
        if (z0Var.f7877k && v() != 0 && !z0Var.f7874g && y0()) {
            List list2 = (List) aVar.f6276f;
            int size = list2.size();
            int F2 = o0.F(u(0));
            int i28 = 0;
            int i29 = 0;
            for (int i30 = 0; i30 < size; i30++) {
                d1 d1Var = (d1) list2.get(i30);
                boolean h9 = d1Var.h();
                View view3 = d1Var.f7618a;
                if (!h9) {
                    boolean z20 = d1Var.b() < F2;
                    boolean z21 = this.f1041u;
                    h hVar9 = this.f1038r;
                    if (z20 != z21) {
                        i28 += hVar9.c(view3);
                    } else {
                        i29 += hVar9.c(view3);
                    }
                }
            }
            this.f1037q.f7841k = list2;
            if (i28 > 0) {
                c1(o0.F(Q0()), i11);
                x xVar12 = this.f1037q;
                xVar12.h = i28;
                r42 = 0;
                xVar12.f7834c = 0;
                xVar12.a(null);
                G0(aVar, this.f1037q, z0Var, false);
            } else {
                r42 = 0;
            }
            if (i29 > 0) {
                b1(o0.F(P0()), i10);
                x xVar13 = this.f1037q;
                xVar13.h = i29;
                xVar13.f7834c = r42;
                list = null;
                xVar13.a(null);
                G0(aVar, this.f1037q, z0Var, r42);
            } else {
                list = null;
            }
            this.f1037q.f7841k = list;
        }
        if (z0Var.f7874g) {
            uVar.e();
        } else {
            h hVar10 = this.f1038r;
            hVar10.f617a = hVar10.l();
        }
        this.f1039s = this.f1042v;
    }

    public final void a1(int i9, int i10, boolean z8, z0 z0Var) {
        int k3;
        this.f1037q.f7842l = this.f1038r.i() == 0 && this.f1038r.f() == 0;
        this.f1037q.f7837f = i9;
        int[] iArr = this.D;
        iArr[0] = 0;
        iArr[1] = 0;
        z0(z0Var, iArr);
        int max = Math.max(0, iArr[0]);
        int max2 = Math.max(0, iArr[1]);
        boolean z9 = i9 == 1;
        x xVar = this.f1037q;
        int i11 = z9 ? max2 : max;
        xVar.h = i11;
        if (!z9) {
            max = max2;
        }
        xVar.f7839i = max;
        if (z9) {
            xVar.h = this.f1038r.h() + i11;
            View P0 = P0();
            x xVar2 = this.f1037q;
            xVar2.f7836e = this.f1041u ? -1 : 1;
            int F = o0.F(P0);
            x xVar3 = this.f1037q;
            xVar2.f7835d = F + xVar3.f7836e;
            xVar3.f7833b = this.f1038r.b(P0);
            k3 = this.f1038r.b(P0) - this.f1038r.g();
        } else {
            View Q0 = Q0();
            x xVar4 = this.f1037q;
            xVar4.h = this.f1038r.k() + xVar4.h;
            x xVar5 = this.f1037q;
            xVar5.f7836e = this.f1041u ? 1 : -1;
            int F2 = o0.F(Q0);
            x xVar6 = this.f1037q;
            xVar5.f7835d = F2 + xVar6.f7836e;
            xVar6.f7833b = this.f1038r.e(Q0);
            k3 = (-this.f1038r.e(Q0)) + this.f1038r.k();
        }
        x xVar7 = this.f1037q;
        xVar7.f7834c = i10;
        if (z8) {
            xVar7.f7834c = i10 - k3;
        }
        xVar7.f7838g = k3;
    }

    @Override // o3.o0
    public void b0(z0 z0Var) {
        this.f1046z = null;
        this.f1044x = -1;
        this.f1045y = Integer.MIN_VALUE;
        this.A.e();
    }

    public final void b1(int i9, int i10) {
        this.f1037q.f7834c = this.f1038r.g() - i10;
        x xVar = this.f1037q;
        xVar.f7836e = this.f1041u ? -1 : 1;
        xVar.f7835d = i9;
        xVar.f7837f = 1;
        xVar.f7833b = i10;
        xVar.f7838g = Integer.MIN_VALUE;
    }

    @Override // o3.o0
    public final void c(String str) {
        if (this.f1046z == null) {
            super.c(str);
        }
    }

    @Override // o3.o0
    public final void c0(Parcelable parcelable) {
        if (parcelable instanceof y) {
            y yVar = (y) parcelable;
            this.f1046z = yVar;
            if (this.f1044x != -1) {
                yVar.f7850i = -1;
            }
            k0();
        }
    }

    public final void c1(int i9, int i10) {
        this.f1037q.f7834c = i10 - this.f1038r.k();
        x xVar = this.f1037q;
        xVar.f7835d = i9;
        xVar.f7836e = this.f1041u ? 1 : -1;
        xVar.f7837f = -1;
        xVar.f7833b = i10;
        xVar.f7838g = Integer.MIN_VALUE;
    }

    @Override // o3.o0
    public final boolean d() {
        return this.f1036p == 0;
    }

    @Override // o3.o0
    public final Parcelable d0() {
        y yVar = this.f1046z;
        if (yVar != null) {
            y yVar2 = new y();
            yVar2.f7850i = yVar.f7850i;
            yVar2.f7851j = yVar.f7851j;
            yVar2.f7852k = yVar.f7852k;
            return yVar2;
        }
        y yVar3 = new y();
        if (v() <= 0) {
            yVar3.f7850i = -1;
            return yVar3;
        }
        F0();
        boolean z8 = this.f1039s ^ this.f1041u;
        yVar3.f7852k = z8;
        if (z8) {
            View P0 = P0();
            yVar3.f7851j = this.f1038r.g() - this.f1038r.b(P0);
            yVar3.f7850i = o0.F(P0);
            return yVar3;
        }
        View Q0 = Q0();
        yVar3.f7850i = o0.F(Q0);
        yVar3.f7851j = this.f1038r.e(Q0) - this.f1038r.k();
        return yVar3;
    }

    @Override // o3.o0
    public final boolean e() {
        return this.f1036p == 1;
    }

    @Override // o3.o0
    public final void h(int i9, int i10, z0 z0Var, r rVar) {
        if (this.f1036p != 0) {
            i9 = i10;
        }
        if (v() == 0 || i9 == 0) {
            return;
        }
        F0();
        a1(i9 > 0 ? 1 : -1, Math.abs(i9), true, z0Var);
        A0(z0Var, this.f1037q, rVar);
    }

    @Override // o3.o0
    public final void i(int i9, r rVar) {
        boolean z8;
        int i10;
        y yVar = this.f1046z;
        if (yVar == null || (i10 = yVar.f7850i) < 0) {
            W0();
            z8 = this.f1041u;
            i10 = this.f1044x;
            if (i10 == -1) {
                i10 = z8 ? i9 - 1 : 0;
            }
        } else {
            z8 = yVar.f7852k;
        }
        int i11 = z8 ? -1 : 1;
        for (int i12 = 0; i12 < this.C && i10 >= 0 && i10 < i9; i12++) {
            rVar.b(i10, 0);
            i10 += i11;
        }
    }

    @Override // o3.o0
    public final int j(z0 z0Var) {
        return B0(z0Var);
    }

    @Override // o3.o0
    public int k(z0 z0Var) {
        return C0(z0Var);
    }

    @Override // o3.o0
    public int l(z0 z0Var) {
        return D0(z0Var);
    }

    @Override // o3.o0
    public int l0(int i9, a aVar, z0 z0Var) {
        if (this.f1036p == 1) {
            return 0;
        }
        return X0(i9, aVar, z0Var);
    }

    @Override // o3.o0
    public final int m(z0 z0Var) {
        return B0(z0Var);
    }

    @Override // o3.o0
    public final void m0(int i9) {
        this.f1044x = i9;
        this.f1045y = Integer.MIN_VALUE;
        y yVar = this.f1046z;
        if (yVar != null) {
            yVar.f7850i = -1;
        }
        k0();
    }

    @Override // o3.o0
    public int n(z0 z0Var) {
        return C0(z0Var);
    }

    @Override // o3.o0
    public int n0(int i9, a aVar, z0 z0Var) {
        if (this.f1036p == 0) {
            return 0;
        }
        return X0(i9, aVar, z0Var);
    }

    @Override // o3.o0
    public int o(z0 z0Var) {
        return D0(z0Var);
    }

    @Override // o3.o0
    public final View q(int i9) {
        int v8 = v();
        if (v8 == 0) {
            return null;
        }
        int F = i9 - o0.F(u(0));
        if (F >= 0 && F < v8) {
            View u3 = u(F);
            if (o0.F(u3) == i9) {
                return u3;
            }
        }
        return super.q(i9);
    }

    @Override // o3.o0
    public p0 r() {
        return new p0(-2, -2);
    }

    @Override // o3.o0
    public final boolean u0() {
        if (this.f7759m != 1073741824 && this.f7758l != 1073741824) {
            int v8 = v();
            for (int i9 = 0; i9 < v8; i9++) {
                ViewGroup.LayoutParams layoutParams = u(i9).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // o3.o0
    public void w0(RecyclerView recyclerView, int i9) {
        z zVar = new z(recyclerView.getContext());
        zVar.f7853a = i9;
        x0(zVar);
    }

    @Override // o3.o0
    public boolean y0() {
        return this.f1046z == null && this.f1039s == this.f1042v;
    }

    public void z0(z0 z0Var, int[] iArr) {
        int i9;
        int l4 = z0Var.f7868a != -1 ? this.f1038r.l() : 0;
        if (this.f1037q.f7837f == -1) {
            i9 = 0;
        } else {
            i9 = l4;
            l4 = 0;
        }
        iArr[0] = l4;
        iArr[1] = i9;
    }

    @Override // o3.o0
    public final void P(RecyclerView recyclerView) {
    }

    public LinearLayoutManager(int i9) {
        this.f1036p = 1;
        this.f1040t = false;
        this.f1041u = false;
        this.f1042v = false;
        this.f1043w = true;
        this.f1044x = -1;
        this.f1045y = Integer.MIN_VALUE;
        this.f1046z = null;
        this.A = new u();
        this.B = new w();
        this.C = 2;
        this.D = new int[2];
        Y0(i9);
        c(null);
        if (this.f1040t) {
            this.f1040t = false;
            k0();
        }
    }

    public void T0(a aVar, z0 z0Var, u uVar, int i9) {
    }
}
