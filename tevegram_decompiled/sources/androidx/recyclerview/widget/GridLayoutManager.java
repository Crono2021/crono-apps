package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.GridView;
import androidx.activity.g;
import i3.u;
import java.util.WeakHashMap;
import l7.a;
import m1.b;
import m7.c;
import n0.c0;
import n0.t0;
import o0.l;
import o3.o0;
import o3.p0;
import o3.r;
import o3.x;
import o3.z0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    public boolean E;
    public int F;
    public int[] G;
    public View[] H;
    public final SparseIntArray I;
    public final SparseIntArray J;
    public final b K;
    public final Rect L;

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i9, int i10) {
        super(context, attributeSet, i9, i10);
        this.E = false;
        this.F = -1;
        this.I = new SparseIntArray();
        this.J = new SparseIntArray();
        this.K = new b(8);
        this.L = new Rect();
        k1(o0.G(context, attributeSet, i9, i10).f7744b);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void A0(z0 z0Var, x xVar, r rVar) {
        int i9;
        int i10 = this.F;
        for (int i11 = 0; i11 < this.F && (i9 = xVar.f7835d) >= 0 && i9 < z0Var.b() && i10 > 0; i11++) {
            rVar.b(xVar.f7835d, Math.max(0, xVar.f7838g));
            this.K.getClass();
            i10--;
            xVar.f7835d += xVar.f7836e;
        }
    }

    @Override // o3.o0
    public final int H(a aVar, z0 z0Var) {
        if (this.f1036p == 0) {
            return this.F;
        }
        if (z0Var.b() < 1) {
            return 0;
        }
        return g1(z0Var.b() - 1, aVar, z0Var) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final View M0(a aVar, z0 z0Var, boolean z8, boolean z9) {
        int i9;
        int i10;
        int v8 = v();
        int i11 = 1;
        if (z9) {
            i10 = v() - 1;
            i9 = -1;
            i11 = -1;
        } else {
            i9 = v8;
            i10 = 0;
        }
        int b9 = z0Var.b();
        F0();
        int k3 = this.f1038r.k();
        int g9 = this.f1038r.g();
        View view = null;
        View view2 = null;
        while (i10 != i9) {
            View u3 = u(i10);
            int F = o0.F(u3);
            if (F >= 0 && F < b9 && h1(F, aVar, z0Var) == 0) {
                if (((p0) u3.getLayoutParams()).f7765a.h()) {
                    if (view2 == null) {
                        view2 = u3;
                    }
                } else {
                    if (this.f1038r.e(u3) < g9 && this.f1038r.b(u3) >= k3) {
                        return u3;
                    }
                    if (view == null) {
                        view = u3;
                    }
                }
            }
            i10 += i11;
        }
        return view != null ? view : view2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x00e2, code lost:
    
        if (r13 == (r2 > r15)) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0107, code lost:
    
        if (r13 == (r2 > r8)) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0021, code lost:
    
        if (((java.util.ArrayList) r22.f7748a.f730l).contains(r3) != false) goto L10;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, o3.o0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View Q(android.view.View r23, int r24, l7.a r25, o3.z0 r26) {
        /*
            Method dump skipped, instructions count: 323
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.Q(android.view.View, int, l7.a, o3.z0):android.view.View");
    }

    @Override // o3.o0
    public final void S(a aVar, z0 z0Var, l lVar) {
        super.S(aVar, z0Var, lVar);
        lVar.i(GridView.class.getName());
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0092, code lost:
    
        r22.f7828b = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0094, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v20, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v23 */
    /* JADX WARN: Type inference failed for: r12v24 */
    /* JADX WARN: Type inference failed for: r12v31 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void S0(l7.a r19, o3.z0 r20, o3.x r21, o3.w r22) {
        /*
            Method dump skipped, instructions count: 617
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.S0(l7.a, o3.z0, o3.x, o3.w):void");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void T0(a aVar, z0 z0Var, u uVar, int i9) {
        l1();
        if (z0Var.b() > 0 && !z0Var.f7874g) {
            boolean z8 = i9 == 1;
            int h12 = h1(uVar.f4658b, aVar, z0Var);
            if (z8) {
                while (h12 > 0) {
                    int i10 = uVar.f4658b;
                    if (i10 <= 0) {
                        break;
                    }
                    int i11 = i10 - 1;
                    uVar.f4658b = i11;
                    h12 = h1(i11, aVar, z0Var);
                }
            } else {
                int b9 = z0Var.b() - 1;
                int i12 = uVar.f4658b;
                while (i12 < b9) {
                    int i13 = i12 + 1;
                    int h13 = h1(i13, aVar, z0Var);
                    if (h13 <= h12) {
                        break;
                    }
                    i12 = i13;
                    h12 = h13;
                }
                uVar.f4658b = i12;
            }
        }
        e1();
    }

    @Override // o3.o0
    public final void U(a aVar, z0 z0Var, View view, l lVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = lVar.f7564a;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof o3.u)) {
            T(view, lVar);
            return;
        }
        o3.u uVar = (o3.u) layoutParams;
        int g12 = g1(uVar.f7765a.b(), aVar, z0Var);
        int i9 = this.f1036p;
        int i10 = uVar.f7816e;
        int i11 = uVar.f7817f;
        if (i9 == 0) {
            accessibilityNodeInfo.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(i10, i11, g12, 1, false, false));
        } else {
            accessibilityNodeInfo.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(g12, 1, i10, i11, false, false));
        }
    }

    @Override // o3.o0
    public final void V(int i9, int i10) {
        b bVar = this.K;
        bVar.o();
        ((SparseIntArray) bVar.f6511k).clear();
    }

    @Override // o3.o0
    public final void W() {
        b bVar = this.K;
        bVar.o();
        ((SparseIntArray) bVar.f6511k).clear();
    }

    @Override // o3.o0
    public final void X(int i9, int i10) {
        b bVar = this.K;
        bVar.o();
        ((SparseIntArray) bVar.f6511k).clear();
    }

    @Override // o3.o0
    public final void Y(int i9, int i10) {
        b bVar = this.K;
        bVar.o();
        ((SparseIntArray) bVar.f6511k).clear();
    }

    @Override // o3.o0
    public final void Z(int i9, int i10) {
        b bVar = this.K;
        bVar.o();
        ((SparseIntArray) bVar.f6511k).clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void Z0(boolean z8) {
        if (z8) {
            androidx.fragment.app.a.h("GridLayoutManager does not support stack from end. Consider using reverse layout");
        } else {
            super.Z0(false);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, o3.o0
    public final void a0(a aVar, z0 z0Var) {
        boolean z8 = z0Var.f7874g;
        SparseIntArray sparseIntArray = this.J;
        SparseIntArray sparseIntArray2 = this.I;
        if (z8) {
            int v8 = v();
            for (int i9 = 0; i9 < v8; i9++) {
                o3.u uVar = (o3.u) u(i9).getLayoutParams();
                int b9 = uVar.f7765a.b();
                sparseIntArray2.put(b9, uVar.f7817f);
                sparseIntArray.put(b9, uVar.f7816e);
            }
        }
        super.a0(aVar, z0Var);
        sparseIntArray2.clear();
        sparseIntArray.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, o3.o0
    public final void b0(z0 z0Var) {
        super.b0(z0Var);
        this.E = false;
    }

    public final void d1(int i9) {
        int i10;
        int[] iArr = this.G;
        int i11 = this.F;
        if (iArr == null || iArr.length != i11 + 1 || iArr[iArr.length - 1] != i9) {
            iArr = new int[i11 + 1];
        }
        int i12 = 0;
        iArr[0] = 0;
        int i13 = i9 / i11;
        int i14 = i9 % i11;
        int i15 = 0;
        for (int i16 = 1; i16 <= i11; i16++) {
            i12 += i14;
            if (i12 <= 0 || i11 - i12 >= i14) {
                i10 = i13;
            } else {
                i10 = i13 + 1;
                i12 -= i11;
            }
            i15 += i10;
            iArr[i16] = i15;
        }
        this.G = iArr;
    }

    public final void e1() {
        View[] viewArr = this.H;
        if (viewArr == null || viewArr.length != this.F) {
            this.H = new View[this.F];
        }
    }

    @Override // o3.o0
    public final boolean f(p0 p0Var) {
        return p0Var instanceof o3.u;
    }

    public final int f1(int i9, int i10) {
        if (this.f1036p != 1 || !R0()) {
            int[] iArr = this.G;
            return iArr[i10 + i9] - iArr[i9];
        }
        int[] iArr2 = this.G;
        int i11 = this.F;
        return iArr2[i11 - i9] - iArr2[(i11 - i9) - i10];
    }

    public final int g1(int i9, a aVar, z0 z0Var) {
        boolean z8 = z0Var.f7874g;
        b bVar = this.K;
        if (!z8) {
            int i10 = this.F;
            bVar.getClass();
            return b.n(i9, i10);
        }
        int b9 = aVar.b(i9);
        if (b9 != -1) {
            int i11 = this.F;
            bVar.getClass();
            return b.n(b9, i11);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i9);
        return 0;
    }

    public final int h1(int i9, a aVar, z0 z0Var) {
        boolean z8 = z0Var.f7874g;
        b bVar = this.K;
        if (!z8) {
            int i10 = this.F;
            bVar.getClass();
            return i9 % i10;
        }
        int i11 = this.J.get(i9, -1);
        if (i11 != -1) {
            return i11;
        }
        int b9 = aVar.b(i9);
        if (b9 != -1) {
            int i12 = this.F;
            bVar.getClass();
            return b9 % i12;
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i9);
        return 0;
    }

    public final int i1(int i9, a aVar, z0 z0Var) {
        boolean z8 = z0Var.f7874g;
        b bVar = this.K;
        if (!z8) {
            bVar.getClass();
            return 1;
        }
        int i10 = this.I.get(i9, -1);
        if (i10 != -1) {
            return i10;
        }
        if (aVar.b(i9) != -1) {
            bVar.getClass();
            return 1;
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i9);
        return 1;
    }

    public final void j1(View view, int i9, boolean z8) {
        int i10;
        int i11;
        o3.u uVar = (o3.u) view.getLayoutParams();
        Rect rect = uVar.f7766b;
        int i12 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) uVar).topMargin + ((ViewGroup.MarginLayoutParams) uVar).bottomMargin;
        int i13 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) uVar).leftMargin + ((ViewGroup.MarginLayoutParams) uVar).rightMargin;
        int f12 = f1(uVar.f7816e, uVar.f7817f);
        if (this.f1036p == 1) {
            i11 = o0.w(f12, i9, i13, ((ViewGroup.MarginLayoutParams) uVar).width, false);
            i10 = o0.w(this.f1038r.l(), this.f7759m, i12, ((ViewGroup.MarginLayoutParams) uVar).height, true);
        } else {
            int w8 = o0.w(f12, i9, i12, ((ViewGroup.MarginLayoutParams) uVar).height, false);
            int w9 = o0.w(this.f1038r.l(), this.f7758l, i13, ((ViewGroup.MarginLayoutParams) uVar).width, true);
            i10 = w8;
            i11 = w9;
        }
        p0 p0Var = (p0) view.getLayoutParams();
        if (z8 ? v0(view, i11, i10, p0Var) : t0(view, i11, i10, p0Var)) {
            view.measure(i11, i10);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, o3.o0
    public final int k(z0 z0Var) {
        return C0(z0Var);
    }

    public final void k1(int i9) {
        if (i9 == this.F) {
            return;
        }
        this.E = true;
        if (i9 < 1) {
            c.n(g.m(i9, "Span count should be at least 1. Provided "));
            return;
        }
        this.F = i9;
        this.K.o();
        k0();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, o3.o0
    public final int l(z0 z0Var) {
        return D0(z0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, o3.o0
    public final int l0(int i9, a aVar, z0 z0Var) {
        l1();
        e1();
        return super.l0(i9, aVar, z0Var);
    }

    public final void l1() {
        int B;
        int E;
        if (this.f1036p == 1) {
            B = this.f7760n - D();
            E = C();
        } else {
            B = this.f7761o - B();
            E = E();
        }
        d1(B - E);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, o3.o0
    public final int n(z0 z0Var) {
        return C0(z0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, o3.o0
    public final int n0(int i9, a aVar, z0 z0Var) {
        l1();
        e1();
        return super.n0(i9, aVar, z0Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, o3.o0
    public final int o(z0 z0Var) {
        return D0(z0Var);
    }

    @Override // o3.o0
    public final void q0(Rect rect, int i9, int i10) {
        int g9;
        int g10;
        if (this.G == null) {
            super.q0(rect, i9, i10);
        }
        int D = D() + C();
        int B = B() + E();
        if (this.f1036p == 1) {
            int height = rect.height() + B;
            RecyclerView recyclerView = this.f7749b;
            WeakHashMap weakHashMap = t0.f7209a;
            g10 = o0.g(i10, height, c0.d(recyclerView));
            int[] iArr = this.G;
            g9 = o0.g(i9, iArr[iArr.length - 1] + D, c0.e(this.f7749b));
        } else {
            int width = rect.width() + D;
            RecyclerView recyclerView2 = this.f7749b;
            WeakHashMap weakHashMap2 = t0.f7209a;
            g9 = o0.g(i9, width, c0.e(recyclerView2));
            int[] iArr2 = this.G;
            g10 = o0.g(i10, iArr2[iArr2.length - 1] + B, c0.d(this.f7749b));
        }
        this.f7749b.setMeasuredDimension(g9, g10);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, o3.o0
    public final p0 r() {
        return this.f1036p == 0 ? new o3.u(-2, -1) : new o3.u(-1, -2);
    }

    @Override // o3.o0
    public final p0 s(Context context, AttributeSet attributeSet) {
        o3.u uVar = new o3.u(context, attributeSet);
        uVar.f7816e = -1;
        uVar.f7817f = 0;
        return uVar;
    }

    @Override // o3.o0
    public final p0 t(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            o3.u uVar = new o3.u((ViewGroup.MarginLayoutParams) layoutParams);
            uVar.f7816e = -1;
            uVar.f7817f = 0;
            return uVar;
        }
        o3.u uVar2 = new o3.u(layoutParams);
        uVar2.f7816e = -1;
        uVar2.f7817f = 0;
        return uVar2;
    }

    @Override // o3.o0
    public final int x(a aVar, z0 z0Var) {
        if (this.f1036p == 1) {
            return this.F;
        }
        if (z0Var.b() < 1) {
            return 0;
        }
        return g1(z0Var.b() - 1, aVar, z0Var) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, o3.o0
    public final boolean y0() {
        return this.f1046z == null && !this.E;
    }

    public GridLayoutManager(int i9, int i10) {
        super(1);
        this.E = false;
        this.F = -1;
        this.I = new SparseIntArray();
        this.J = new SparseIntArray();
        this.K = new b(8);
        this.L = new Rect();
        k1(i9);
    }

    public GridLayoutManager(int i9) {
        super(1);
        this.E = false;
        this.F = -1;
        this.I = new SparseIntArray();
        this.J = new SparseIntArray();
        this.K = new b(8);
        this.L = new Rect();
        k1(i9);
    }
}
