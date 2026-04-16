package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.activity.j;
import androidx.emoji2.text.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.WeakHashMap;
import l7.a;
import m1.b;
import m7.c;
import n0.c0;
import n0.t0;
import o3.h1;
import o3.i1;
import o3.k1;
import o3.l1;
import o3.n0;
import o3.o;
import o3.o0;
import o3.p0;
import o3.r;
import o3.v;
import o3.y0;
import o3.z;
import o3.z0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class StaggeredGridLayoutManager extends o0 implements y0 {
    public final b B;
    public final int C;
    public boolean D;
    public boolean E;
    public k1 F;
    public final Rect G;
    public final h1 H;
    public final boolean I;
    public int[] J;
    public final j K;

    /* renamed from: p, reason: collision with root package name */
    public final int f1090p;

    /* renamed from: q, reason: collision with root package name */
    public final l1[] f1091q;

    /* renamed from: r, reason: collision with root package name */
    public final h f1092r;

    /* renamed from: s, reason: collision with root package name */
    public final h f1093s;

    /* renamed from: t, reason: collision with root package name */
    public final int f1094t;

    /* renamed from: u, reason: collision with root package name */
    public int f1095u;

    /* renamed from: v, reason: collision with root package name */
    public final v f1096v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f1097w;

    /* renamed from: y, reason: collision with root package name */
    public final BitSet f1099y;

    /* renamed from: x, reason: collision with root package name */
    public boolean f1098x = false;

    /* renamed from: z, reason: collision with root package name */
    public int f1100z = -1;
    public int A = Integer.MIN_VALUE;

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i9, int i10) {
        this.f1090p = -1;
        this.f1097w = false;
        b bVar = new b(9, false);
        this.B = bVar;
        this.C = 2;
        this.G = new Rect();
        this.H = new h1(this);
        this.I = true;
        this.K = new j(this, 13);
        n0 G = o0.G(context, attributeSet, i9, i10);
        int i11 = G.f7743a;
        if (i11 != 0 && i11 != 1) {
            c.n("invalid orientation.");
            throw null;
        }
        c(null);
        if (i11 != this.f1094t) {
            this.f1094t = i11;
            h hVar = this.f1092r;
            this.f1092r = this.f1093s;
            this.f1093s = hVar;
            k0();
        }
        int i12 = G.f7744b;
        c(null);
        if (i12 != this.f1090p) {
            bVar.e();
            k0();
            this.f1090p = i12;
            this.f1099y = new BitSet(this.f1090p);
            this.f1091q = new l1[this.f1090p];
            for (int i13 = 0; i13 < this.f1090p; i13++) {
                this.f1091q[i13] = new l1(this, i13);
            }
            k0();
        }
        boolean z8 = G.f7745c;
        c(null);
        k1 k1Var = this.F;
        if (k1Var != null && k1Var.f7716p != z8) {
            k1Var.f7716p = z8;
        }
        this.f1097w = z8;
        k0();
        v vVar = new v();
        vVar.f7818a = true;
        vVar.f7823f = 0;
        vVar.f7824g = 0;
        this.f1096v = vVar;
        this.f1092r = h.a(this, this.f1094t);
        this.f1093s = h.a(this, 1 - this.f1094t);
    }

    public static int Z0(int i9, int i10, int i11) {
        int mode;
        return (!(i10 == 0 && i11 == 0) && ((mode = View.MeasureSpec.getMode(i9)) == Integer.MIN_VALUE || mode == 1073741824)) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i9) - i10) - i11), mode) : i9;
    }

    public final int A0(z0 z0Var) {
        if (v() == 0) {
            return 0;
        }
        boolean z8 = !this.I;
        return o.e(z0Var, this.f1092r, D0(z8), C0(z8), this, this.I, this.f1098x);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x025f, code lost:
    
        R0(r20, r3);
     */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v32 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int B0(l7.a r20, o3.v r21, o3.z0 r22) {
        /*
            Method dump skipped, instructions count: 661
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.B0(l7.a, o3.v, o3.z0):int");
    }

    public final View C0(boolean z8) {
        int k3 = this.f1092r.k();
        int g9 = this.f1092r.g();
        View view = null;
        for (int v8 = v() - 1; v8 >= 0; v8--) {
            View u3 = u(v8);
            int e9 = this.f1092r.e(u3);
            int b9 = this.f1092r.b(u3);
            if (b9 > k3 && e9 < g9) {
                if (b9 <= g9 || !z8) {
                    return u3;
                }
                if (view == null) {
                    view = u3;
                }
            }
        }
        return view;
    }

    public final View D0(boolean z8) {
        int k3 = this.f1092r.k();
        int g9 = this.f1092r.g();
        int v8 = v();
        View view = null;
        for (int i9 = 0; i9 < v8; i9++) {
            View u3 = u(i9);
            int e9 = this.f1092r.e(u3);
            if (this.f1092r.b(u3) > k3 && e9 < g9) {
                if (e9 >= k3 || !z8) {
                    return u3;
                }
                if (view == null) {
                    view = u3;
                }
            }
        }
        return view;
    }

    public final void E0(a aVar, z0 z0Var, boolean z8) {
        int g9;
        int I0 = I0(Integer.MIN_VALUE);
        if (I0 != Integer.MIN_VALUE && (g9 = this.f1092r.g() - I0) > 0) {
            int i9 = g9 - (-V0(-g9, aVar, z0Var));
            if (!z8 || i9 <= 0) {
                return;
            }
            this.f1092r.o(i9);
        }
    }

    public final void F0(a aVar, z0 z0Var, boolean z8) {
        int k3;
        int J0 = J0(Integer.MAX_VALUE);
        if (J0 != Integer.MAX_VALUE && (k3 = J0 - this.f1092r.k()) > 0) {
            int V0 = k3 - V0(k3, aVar, z0Var);
            if (!z8 || V0 <= 0) {
                return;
            }
            this.f1092r.o(-V0);
        }
    }

    public final int G0() {
        if (v() == 0) {
            return 0;
        }
        return o0.F(u(0));
    }

    public final int H0() {
        int v8 = v();
        if (v8 == 0) {
            return 0;
        }
        return o0.F(u(v8 - 1));
    }

    public final int I0(int i9) {
        int f9 = this.f1091q[0].f(i9);
        for (int i10 = 1; i10 < this.f1090p; i10++) {
            int f10 = this.f1091q[i10].f(i9);
            if (f10 > f9) {
                f9 = f10;
            }
        }
        return f9;
    }

    @Override // o3.o0
    public final boolean J() {
        return this.C != 0;
    }

    public final int J0(int i9) {
        int h = this.f1091q[0].h(i9);
        for (int i10 = 1; i10 < this.f1090p; i10++) {
            int h9 = this.f1091q[i10].h(i9);
            if (h9 < h) {
                h = h9;
            }
        }
        return h;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void K0(int r10, int r11, int r12) {
        /*
            Method dump skipped, instructions count: 219
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.K0(int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00fb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x002c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View L0() {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.L0():android.view.View");
    }

    @Override // o3.o0
    public final void M(int i9) {
        super.M(i9);
        for (int i10 = 0; i10 < this.f1090p; i10++) {
            l1 l1Var = this.f1091q[i10];
            int i11 = l1Var.f7723b;
            if (i11 != Integer.MIN_VALUE) {
                l1Var.f7723b = i11 + i9;
            }
            int i12 = l1Var.f7724c;
            if (i12 != Integer.MIN_VALUE) {
                l1Var.f7724c = i12 + i9;
            }
        }
    }

    public final boolean M0() {
        return A() == 1;
    }

    @Override // o3.o0
    public final void N(int i9) {
        super.N(i9);
        for (int i10 = 0; i10 < this.f1090p; i10++) {
            l1 l1Var = this.f1091q[i10];
            int i11 = l1Var.f7723b;
            if (i11 != Integer.MIN_VALUE) {
                l1Var.f7723b = i11 + i9;
            }
            int i12 = l1Var.f7724c;
            if (i12 != Integer.MIN_VALUE) {
                l1Var.f7724c = i12 + i9;
            }
        }
    }

    public final void N0(View view, int i9, int i10) {
        RecyclerView recyclerView = this.f7749b;
        Rect rect = this.G;
        if (recyclerView == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(recyclerView.K(view));
        }
        i1 i1Var = (i1) view.getLayoutParams();
        int Z0 = Z0(i9, ((ViewGroup.MarginLayoutParams) i1Var).leftMargin + rect.left, ((ViewGroup.MarginLayoutParams) i1Var).rightMargin + rect.right);
        int Z02 = Z0(i10, ((ViewGroup.MarginLayoutParams) i1Var).topMargin + rect.top, ((ViewGroup.MarginLayoutParams) i1Var).bottomMargin + rect.bottom);
        if (t0(view, Z0, Z02, i1Var)) {
            view.measure(Z0, Z02);
        }
    }

    @Override // o3.o0
    public final void O() {
        this.B.e();
        for (int i9 = 0; i9 < this.f1090p; i9++) {
            this.f1091q[i9].b();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01a4, code lost:
    
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01a0, code lost:
    
        if ((r11 < G0()) != r16.f1098x) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x040d, code lost:
    
        if (z0() != false) goto L255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0192, code lost:
    
        if (r16.f1098x != false) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01a2, code lost:
    
        r11 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void O0(l7.a r17, o3.z0 r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 1067
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.O0(l7.a, o3.z0, boolean):void");
    }

    @Override // o3.o0
    public final void P(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f7749b;
        if (recyclerView2 != null) {
            recyclerView2.removeCallbacks(this.K);
        }
        for (int i9 = 0; i9 < this.f1090p; i9++) {
            this.f1091q[i9].b();
        }
        recyclerView.requestLayout();
    }

    public final boolean P0(int i9) {
        if (this.f1094t == 0) {
            return (i9 == -1) != this.f1098x;
        }
        return ((i9 == -1) == this.f1098x) == M0();
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x0052, code lost:
    
        if (r8.f1094t == 1) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0058, code lost:
    
        if (r8.f1094t == 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0064, code lost:
    
        if (M0() == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0070, code lost:
    
        if (M0() == false) goto L37;
     */
    @Override // o3.o0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View Q(android.view.View r9, int r10, l7.a r11, o3.z0 r12) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.Q(android.view.View, int, l7.a, o3.z0):android.view.View");
    }

    public final void Q0(int i9, z0 z0Var) {
        int G0;
        int i10;
        if (i9 > 0) {
            G0 = H0();
            i10 = 1;
        } else {
            G0 = G0();
            i10 = -1;
        }
        v vVar = this.f1096v;
        vVar.f7818a = true;
        X0(G0, z0Var);
        W0(i10);
        vVar.f7820c = G0 + vVar.f7821d;
        vVar.f7819b = Math.abs(i9);
    }

    @Override // o3.o0
    public final void R(AccessibilityEvent accessibilityEvent) {
        super.R(accessibilityEvent);
        if (v() > 0) {
            View D0 = D0(false);
            View C0 = C0(false);
            if (D0 == null || C0 == null) {
                return;
            }
            int F = o0.F(D0);
            int F2 = o0.F(C0);
            if (F < F2) {
                accessibilityEvent.setFromIndex(F);
                accessibilityEvent.setToIndex(F2);
            } else {
                accessibilityEvent.setFromIndex(F2);
                accessibilityEvent.setToIndex(F);
            }
        }
    }

    public final void R0(a aVar, v vVar) {
        if (!vVar.f7818a || vVar.f7825i) {
            return;
        }
        int i9 = vVar.f7819b;
        int i10 = vVar.f7822e;
        if (i9 == 0) {
            if (i10 == -1) {
                S0(aVar, vVar.f7824g);
                return;
            } else {
                T0(aVar, vVar.f7823f);
                return;
            }
        }
        int i11 = 1;
        if (i10 == -1) {
            int i12 = vVar.f7823f;
            int h = this.f1091q[0].h(i12);
            while (i11 < this.f1090p) {
                int h9 = this.f1091q[i11].h(i12);
                if (h9 > h) {
                    h = h9;
                }
                i11++;
            }
            int i13 = i12 - h;
            int i14 = vVar.f7824g;
            if (i13 >= 0) {
                i14 -= Math.min(i13, vVar.f7819b);
            }
            S0(aVar, i14);
            return;
        }
        int i15 = vVar.f7824g;
        int f9 = this.f1091q[0].f(i15);
        while (i11 < this.f1090p) {
            int f10 = this.f1091q[i11].f(i15);
            if (f10 < f9) {
                f9 = f10;
            }
            i11++;
        }
        int i16 = f9 - vVar.f7824g;
        int i17 = vVar.f7823f;
        if (i16 >= 0) {
            i17 += Math.min(i16, vVar.f7819b);
        }
        T0(aVar, i17);
    }

    public final void S0(a aVar, int i9) {
        for (int v8 = v() - 1; v8 >= 0; v8--) {
            View u3 = u(v8);
            if (this.f1092r.e(u3) < i9 || this.f1092r.n(u3) < i9) {
                return;
            }
            i1 i1Var = (i1) u3.getLayoutParams();
            i1Var.getClass();
            if (i1Var.f7688e.f7722a.size() == 1) {
                return;
            }
            l1 l1Var = i1Var.f7688e;
            ArrayList arrayList = l1Var.f7722a;
            int size = arrayList.size();
            View view = (View) arrayList.remove(size - 1);
            i1 i1Var2 = (i1) view.getLayoutParams();
            i1Var2.f7688e = null;
            if (i1Var2.f7765a.h() || i1Var2.f7765a.k()) {
                l1Var.f7725d -= l1Var.f7727f.f1092r.c(view);
            }
            if (size == 1) {
                l1Var.f7723b = Integer.MIN_VALUE;
            }
            l1Var.f7724c = Integer.MIN_VALUE;
            h0(u3, aVar);
        }
    }

    public final void T0(a aVar, int i9) {
        while (v() > 0) {
            View u3 = u(0);
            if (this.f1092r.b(u3) > i9 || this.f1092r.m(u3) > i9) {
                return;
            }
            i1 i1Var = (i1) u3.getLayoutParams();
            i1Var.getClass();
            if (i1Var.f7688e.f7722a.size() == 1) {
                return;
            }
            l1 l1Var = i1Var.f7688e;
            ArrayList arrayList = l1Var.f7722a;
            View view = (View) arrayList.remove(0);
            i1 i1Var2 = (i1) view.getLayoutParams();
            i1Var2.f7688e = null;
            if (arrayList.size() == 0) {
                l1Var.f7724c = Integer.MIN_VALUE;
            }
            if (i1Var2.f7765a.h() || i1Var2.f7765a.k()) {
                l1Var.f7725d -= l1Var.f7727f.f1092r.c(view);
            }
            l1Var.f7723b = Integer.MIN_VALUE;
            h0(u3, aVar);
        }
    }

    public final void U0() {
        if (this.f1094t == 1 || !M0()) {
            this.f1098x = this.f1097w;
        } else {
            this.f1098x = !this.f1097w;
        }
    }

    @Override // o3.o0
    public final void V(int i9, int i10) {
        K0(i9, i10, 1);
    }

    public final int V0(int i9, a aVar, z0 z0Var) {
        if (v() == 0 || i9 == 0) {
            return 0;
        }
        Q0(i9, z0Var);
        v vVar = this.f1096v;
        int B0 = B0(aVar, vVar, z0Var);
        if (vVar.f7819b >= B0) {
            i9 = i9 < 0 ? -B0 : B0;
        }
        this.f1092r.o(-i9);
        this.D = this.f1098x;
        vVar.f7819b = 0;
        R0(aVar, vVar);
        return i9;
    }

    @Override // o3.o0
    public final void W() {
        this.B.e();
        k0();
    }

    public final void W0(int i9) {
        v vVar = this.f1096v;
        vVar.f7822e = i9;
        vVar.f7821d = this.f1098x != (i9 == -1) ? -1 : 1;
    }

    @Override // o3.o0
    public final void X(int i9, int i10) {
        K0(i9, i10, 8);
    }

    public final void X0(int i9, z0 z0Var) {
        int i10;
        int i11;
        RecyclerView recyclerView;
        int i12;
        v vVar = this.f1096v;
        boolean z8 = false;
        vVar.f7819b = 0;
        vVar.f7820c = i9;
        z zVar = this.f7752e;
        if (zVar == null || !zVar.f7857e || (i12 = z0Var.f7868a) == -1) {
            i10 = 0;
        } else {
            boolean z9 = this.f1098x;
            boolean z10 = i12 < i9;
            h hVar = this.f1092r;
            if (z9 != z10) {
                i11 = hVar.l();
                i10 = 0;
                recyclerView = this.f7749b;
                if (recyclerView == null && recyclerView.f1068p) {
                    vVar.f7823f = this.f1092r.k() - i11;
                    vVar.f7824g = this.f1092r.g() + i10;
                } else {
                    vVar.f7824g = this.f1092r.f() + i10;
                    vVar.f7823f = -i11;
                }
                vVar.h = false;
                vVar.f7818a = true;
                if (this.f1092r.i() == 0 && this.f1092r.f() == 0) {
                    z8 = true;
                }
                vVar.f7825i = z8;
            }
            i10 = hVar.l();
        }
        i11 = 0;
        recyclerView = this.f7749b;
        if (recyclerView == null) {
        }
        vVar.f7824g = this.f1092r.f() + i10;
        vVar.f7823f = -i11;
        vVar.h = false;
        vVar.f7818a = true;
        if (this.f1092r.i() == 0) {
            z8 = true;
        }
        vVar.f7825i = z8;
    }

    @Override // o3.o0
    public final void Y(int i9, int i10) {
        K0(i9, i10, 2);
    }

    public final void Y0(l1 l1Var, int i9, int i10) {
        int i11 = l1Var.f7725d;
        int i12 = l1Var.f7726e;
        if (i9 != -1) {
            int i13 = l1Var.f7724c;
            if (i13 == Integer.MIN_VALUE) {
                l1Var.a();
                i13 = l1Var.f7724c;
            }
            if (i13 - i11 >= i10) {
                this.f1099y.set(i12, false);
                return;
            }
            return;
        }
        int i14 = l1Var.f7723b;
        if (i14 == Integer.MIN_VALUE) {
            View view = (View) l1Var.f7722a.get(0);
            i1 i1Var = (i1) view.getLayoutParams();
            l1Var.f7723b = l1Var.f7727f.f1092r.e(view);
            i1Var.getClass();
            i14 = l1Var.f7723b;
        }
        if (i14 + i11 <= i10) {
            this.f1099y.set(i12, false);
        }
    }

    @Override // o3.o0
    public final void Z(int i9, int i10) {
        K0(i9, i10, 4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0019, code lost:
    
        if ((r4 < G0()) != r3.f1098x) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
    
        if (r3.f1098x != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000c, code lost:
    
        r1 = 1;
     */
    @Override // o3.y0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.PointF a(int r4) {
        /*
            r3 = this;
            int r0 = r3.v()
            r1 = -1
            r2 = 1
            if (r0 != 0) goto Le
            boolean r4 = r3.f1098x
            if (r4 == 0) goto L1b
        Lc:
            r1 = 1
            goto L1b
        Le:
            int r0 = r3.G0()
            if (r4 >= r0) goto L16
            r4 = 1
            goto L17
        L16:
            r4 = 0
        L17:
            boolean r0 = r3.f1098x
            if (r4 == r0) goto Lc
        L1b:
            android.graphics.PointF r4 = new android.graphics.PointF
            r4.<init>()
            if (r1 != 0) goto L24
            r4 = 0
            return r4
        L24:
            int r0 = r3.f1094t
            r2 = 0
            if (r0 != 0) goto L2f
            float r0 = (float) r1
            r4.x = r0
            r4.y = r2
            return r4
        L2f:
            r4.x = r2
            float r0 = (float) r1
            r4.y = r0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.a(int):android.graphics.PointF");
    }

    @Override // o3.o0
    public final void a0(a aVar, z0 z0Var) {
        O0(aVar, z0Var, true);
    }

    @Override // o3.o0
    public final void b0(z0 z0Var) {
        this.f1100z = -1;
        this.A = Integer.MIN_VALUE;
        this.F = null;
        this.H.a();
    }

    @Override // o3.o0
    public final void c(String str) {
        if (this.F == null) {
            super.c(str);
        }
    }

    @Override // o3.o0
    public final void c0(Parcelable parcelable) {
        if (parcelable instanceof k1) {
            k1 k1Var = (k1) parcelable;
            this.F = k1Var;
            if (this.f1100z != -1) {
                k1Var.f7709i = -1;
                k1Var.f7710j = -1;
                k1Var.f7712l = null;
                k1Var.f7711k = 0;
                k1Var.f7713m = 0;
                k1Var.f7714n = null;
                k1Var.f7715o = null;
            }
            k0();
        }
    }

    @Override // o3.o0
    public final boolean d() {
        return this.f1094t == 0;
    }

    @Override // o3.o0
    public final Parcelable d0() {
        int h;
        int k3;
        int[] iArr;
        k1 k1Var = this.F;
        if (k1Var != null) {
            k1 k1Var2 = new k1();
            k1Var2.f7711k = k1Var.f7711k;
            k1Var2.f7709i = k1Var.f7709i;
            k1Var2.f7710j = k1Var.f7710j;
            k1Var2.f7712l = k1Var.f7712l;
            k1Var2.f7713m = k1Var.f7713m;
            k1Var2.f7714n = k1Var.f7714n;
            k1Var2.f7716p = k1Var.f7716p;
            k1Var2.f7717q = k1Var.f7717q;
            k1Var2.f7718r = k1Var.f7718r;
            k1Var2.f7715o = k1Var.f7715o;
            return k1Var2;
        }
        k1 k1Var3 = new k1();
        k1Var3.f7716p = this.f1097w;
        k1Var3.f7717q = this.D;
        k1Var3.f7718r = this.E;
        b bVar = this.B;
        if (bVar == null || (iArr = (int[]) bVar.f6510j) == null) {
            k1Var3.f7713m = 0;
        } else {
            k1Var3.f7714n = iArr;
            k1Var3.f7713m = iArr.length;
            k1Var3.f7715o = (ArrayList) bVar.f6511k;
        }
        if (v() <= 0) {
            k1Var3.f7709i = -1;
            k1Var3.f7710j = -1;
            k1Var3.f7711k = 0;
            return k1Var3;
        }
        k1Var3.f7709i = this.D ? H0() : G0();
        View C0 = this.f1098x ? C0(true) : D0(true);
        k1Var3.f7710j = C0 != null ? o0.F(C0) : -1;
        int i9 = this.f1090p;
        k1Var3.f7711k = i9;
        k1Var3.f7712l = new int[i9];
        for (int i10 = 0; i10 < this.f1090p; i10++) {
            boolean z8 = this.D;
            l1[] l1VarArr = this.f1091q;
            if (z8) {
                h = l1VarArr[i10].f(Integer.MIN_VALUE);
                if (h != Integer.MIN_VALUE) {
                    k3 = this.f1092r.g();
                    h -= k3;
                    k1Var3.f7712l[i10] = h;
                } else {
                    k1Var3.f7712l[i10] = h;
                }
            } else {
                h = l1VarArr[i10].h(Integer.MIN_VALUE);
                if (h != Integer.MIN_VALUE) {
                    k3 = this.f1092r.k();
                    h -= k3;
                    k1Var3.f7712l[i10] = h;
                } else {
                    k1Var3.f7712l[i10] = h;
                }
            }
        }
        return k1Var3;
    }

    @Override // o3.o0
    public final boolean e() {
        return this.f1094t == 1;
    }

    @Override // o3.o0
    public final void e0(int i9) {
        if (i9 == 0) {
            z0();
        }
    }

    @Override // o3.o0
    public final boolean f(p0 p0Var) {
        return p0Var instanceof i1;
    }

    @Override // o3.o0
    public final void h(int i9, int i10, z0 z0Var, r rVar) {
        v vVar;
        int f9;
        int i11;
        if (this.f1094t != 0) {
            i9 = i10;
        }
        if (v() == 0 || i9 == 0) {
            return;
        }
        Q0(i9, z0Var);
        int[] iArr = this.J;
        if (iArr == null || iArr.length < this.f1090p) {
            this.J = new int[this.f1090p];
        }
        int i12 = 0;
        int i13 = 0;
        while (true) {
            int i14 = this.f1090p;
            vVar = this.f1096v;
            if (i12 >= i14) {
                break;
            }
            if (vVar.f7821d == -1) {
                f9 = vVar.f7823f;
                i11 = this.f1091q[i12].h(f9);
            } else {
                f9 = this.f1091q[i12].f(vVar.f7824g);
                i11 = vVar.f7824g;
            }
            int i15 = f9 - i11;
            if (i15 >= 0) {
                this.J[i13] = i15;
                i13++;
            }
            i12++;
        }
        Arrays.sort(this.J, 0, i13);
        for (int i16 = 0; i16 < i13; i16++) {
            int i17 = vVar.f7820c;
            if (i17 < 0 || i17 >= z0Var.b()) {
                return;
            }
            rVar.b(vVar.f7820c, this.J[i16]);
            vVar.f7820c += vVar.f7821d;
        }
    }

    @Override // o3.o0
    public final int j(z0 z0Var) {
        if (v() == 0) {
            return 0;
        }
        boolean z8 = !this.I;
        return o.d(z0Var, this.f1092r, D0(z8), C0(z8), this, this.I);
    }

    @Override // o3.o0
    public final int k(z0 z0Var) {
        return A0(z0Var);
    }

    @Override // o3.o0
    public final int l(z0 z0Var) {
        if (v() == 0) {
            return 0;
        }
        boolean z8 = !this.I;
        return o.f(z0Var, this.f1092r, D0(z8), C0(z8), this, this.I);
    }

    @Override // o3.o0
    public final int l0(int i9, a aVar, z0 z0Var) {
        return V0(i9, aVar, z0Var);
    }

    @Override // o3.o0
    public final int m(z0 z0Var) {
        if (v() == 0) {
            return 0;
        }
        boolean z8 = !this.I;
        return o.d(z0Var, this.f1092r, D0(z8), C0(z8), this, this.I);
    }

    @Override // o3.o0
    public final void m0(int i9) {
        k1 k1Var = this.F;
        if (k1Var != null && k1Var.f7709i != i9) {
            k1Var.f7712l = null;
            k1Var.f7711k = 0;
            k1Var.f7709i = -1;
            k1Var.f7710j = -1;
        }
        this.f1100z = i9;
        this.A = Integer.MIN_VALUE;
        k0();
    }

    @Override // o3.o0
    public final int n(z0 z0Var) {
        return A0(z0Var);
    }

    @Override // o3.o0
    public final int n0(int i9, a aVar, z0 z0Var) {
        return V0(i9, aVar, z0Var);
    }

    @Override // o3.o0
    public final int o(z0 z0Var) {
        if (v() == 0) {
            return 0;
        }
        boolean z8 = !this.I;
        return o.f(z0Var, this.f1092r, D0(z8), C0(z8), this, this.I);
    }

    @Override // o3.o0
    public final void q0(Rect rect, int i9, int i10) {
        int g9;
        int g10;
        int D = D() + C();
        int B = B() + E();
        int i11 = this.f1094t;
        int i12 = this.f1090p;
        if (i11 == 1) {
            int height = rect.height() + B;
            RecyclerView recyclerView = this.f7749b;
            WeakHashMap weakHashMap = t0.f7209a;
            g10 = o0.g(i10, height, c0.d(recyclerView));
            g9 = o0.g(i9, (this.f1095u * i12) + D, c0.e(this.f7749b));
        } else {
            int width = rect.width() + D;
            RecyclerView recyclerView2 = this.f7749b;
            WeakHashMap weakHashMap2 = t0.f7209a;
            g9 = o0.g(i9, width, c0.e(recyclerView2));
            g10 = o0.g(i10, (this.f1095u * i12) + B, c0.d(this.f7749b));
        }
        this.f7749b.setMeasuredDimension(g9, g10);
    }

    @Override // o3.o0
    public final p0 r() {
        return this.f1094t == 0 ? new i1(-2, -1) : new i1(-1, -2);
    }

    @Override // o3.o0
    public final p0 s(Context context, AttributeSet attributeSet) {
        return new i1(context, attributeSet);
    }

    @Override // o3.o0
    public final p0 t(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new i1((ViewGroup.MarginLayoutParams) layoutParams) : new i1(layoutParams);
    }

    @Override // o3.o0
    public final void w0(RecyclerView recyclerView, int i9) {
        z zVar = new z(recyclerView.getContext());
        zVar.f7853a = i9;
        x0(zVar);
    }

    @Override // o3.o0
    public final boolean y0() {
        return this.F == null;
    }

    public final boolean z0() {
        int G0;
        if (v() != 0 && this.C != 0 && this.f7754g) {
            if (this.f1098x) {
                G0 = H0();
                G0();
            } else {
                G0 = G0();
                H0();
            }
            if (G0 == 0 && L0() != null) {
                this.B.e();
                this.f7753f = true;
                k0();
                return true;
            }
        }
        return false;
    }
}
