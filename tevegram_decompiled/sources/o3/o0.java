package o3;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class o0 {

    /* renamed from: a, reason: collision with root package name */
    public androidx.fragment.app.g f7748a;

    /* renamed from: b, reason: collision with root package name */
    public RecyclerView f7749b;

    /* renamed from: c, reason: collision with root package name */
    public final m1.b f7750c;

    /* renamed from: d, reason: collision with root package name */
    public final m1.b f7751d;

    /* renamed from: e, reason: collision with root package name */
    public z f7752e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7753f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f7754g;
    public final boolean h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f7755i;

    /* renamed from: j, reason: collision with root package name */
    public int f7756j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f7757k;

    /* renamed from: l, reason: collision with root package name */
    public int f7758l;

    /* renamed from: m, reason: collision with root package name */
    public int f7759m;

    /* renamed from: n, reason: collision with root package name */
    public int f7760n;

    /* renamed from: o, reason: collision with root package name */
    public int f7761o;

    public o0() {
        m0 m0Var = new m0(this, 0);
        m0 m0Var2 = new m0(this, 1);
        this.f7750c = new m1.b(m0Var);
        this.f7751d = new m1.b(m0Var2);
        this.f7753f = false;
        this.f7754g = false;
        this.h = true;
        this.f7755i = true;
    }

    public static int F(View view) {
        return ((p0) view.getLayoutParams()).f7765a.b();
    }

    public static n0 G(Context context, AttributeSet attributeSet, int i9, int i10) {
        n0 n0Var = new n0();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, n3.a.f7434a, i9, i10);
        n0Var.f7743a = obtainStyledAttributes.getInt(0, 1);
        n0Var.f7744b = obtainStyledAttributes.getInt(10, 1);
        n0Var.f7745c = obtainStyledAttributes.getBoolean(9, false);
        n0Var.f7746d = obtainStyledAttributes.getBoolean(11, false);
        obtainStyledAttributes.recycle();
        return n0Var;
    }

    public static boolean K(int i9, int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (i11 > 0 && i9 != i11) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= i9;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == i9;
        }
        return true;
    }

    public static void L(View view, int i9, int i10, int i11, int i12) {
        p0 p0Var = (p0) view.getLayoutParams();
        Rect rect = p0Var.f7766b;
        view.layout(i9 + rect.left + ((ViewGroup.MarginLayoutParams) p0Var).leftMargin, i10 + rect.top + ((ViewGroup.MarginLayoutParams) p0Var).topMargin, (i11 - rect.right) - ((ViewGroup.MarginLayoutParams) p0Var).rightMargin, (i12 - rect.bottom) - ((ViewGroup.MarginLayoutParams) p0Var).bottomMargin);
    }

    public static int g(int i9, int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i9);
        int size = View.MeasureSpec.getSize(i9);
        return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i10, i11) : size : Math.min(size, Math.max(i10, i11));
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0019, code lost:
    
        if (r5 == 1073741824) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int w(int r4, int r5, int r6, int r7, boolean r8) {
        /*
            int r4 = r4 - r6
            r6 = 0
            int r4 = java.lang.Math.max(r6, r4)
            r0 = -2
            r1 = -1
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            if (r8 == 0) goto L1e
            if (r7 < 0) goto L13
        L10:
            r5 = 1073741824(0x40000000, float:2.0)
            goto L31
        L13:
            if (r7 != r1) goto L1b
            if (r5 == r2) goto L23
            if (r5 == 0) goto L1b
            if (r5 == r3) goto L23
        L1b:
            r5 = 0
            r7 = 0
            goto L31
        L1e:
            if (r7 < 0) goto L21
            goto L10
        L21:
            if (r7 != r1) goto L25
        L23:
            r7 = r4
            goto L31
        L25:
            if (r7 != r0) goto L1b
            if (r5 == r2) goto L2e
            if (r5 != r3) goto L2c
            goto L2e
        L2c:
            r5 = 0
            goto L23
        L2e:
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L23
        L31:
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.o0.w(int, int, int, int, boolean):int");
    }

    public final int A() {
        RecyclerView recyclerView = this.f7749b;
        WeakHashMap weakHashMap = n0.t0.f7209a;
        return n0.d0.d(recyclerView);
    }

    public final int B() {
        RecyclerView recyclerView = this.f7749b;
        if (recyclerView != null) {
            return recyclerView.getPaddingBottom();
        }
        return 0;
    }

    public final int C() {
        RecyclerView recyclerView = this.f7749b;
        if (recyclerView != null) {
            return recyclerView.getPaddingLeft();
        }
        return 0;
    }

    public final int D() {
        RecyclerView recyclerView = this.f7749b;
        if (recyclerView != null) {
            return recyclerView.getPaddingRight();
        }
        return 0;
    }

    public final int E() {
        RecyclerView recyclerView = this.f7749b;
        if (recyclerView != null) {
            return recyclerView.getPaddingTop();
        }
        return 0;
    }

    public int H(l7.a aVar, z0 z0Var) {
        return -1;
    }

    public final void I(View view, Rect rect) {
        Matrix matrix;
        Rect rect2 = ((p0) view.getLayoutParams()).f7766b;
        rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
        if (this.f7749b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
            RectF rectF = this.f7749b.f1076t;
            rectF.set(rect);
            matrix.mapRect(rectF);
            rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
        }
        rect.offset(view.getLeft(), view.getTop());
    }

    public boolean J() {
        return false;
    }

    public void M(int i9) {
        RecyclerView recyclerView = this.f7749b;
        if (recyclerView != null) {
            int N = recyclerView.f1064n.N();
            for (int i10 = 0; i10 < N; i10++) {
                recyclerView.f1064n.M(i10).offsetLeftAndRight(i9);
            }
        }
    }

    public void N(int i9) {
        RecyclerView recyclerView = this.f7749b;
        if (recyclerView != null) {
            int N = recyclerView.f1064n.N();
            for (int i10 = 0; i10 < N; i10++) {
                recyclerView.f1064n.M(i10).offsetTopAndBottom(i9);
            }
        }
    }

    public View Q(View view, int i9, l7.a aVar, z0 z0Var) {
        return null;
    }

    public void R(AccessibilityEvent accessibilityEvent) {
        RecyclerView recyclerView = this.f7749b;
        l7.a aVar = recyclerView.f1058k;
        if (accessibilityEvent == null) {
            return;
        }
        boolean z8 = true;
        if (!recyclerView.canScrollVertically(1) && !this.f7749b.canScrollVertically(-1) && !this.f7749b.canScrollHorizontally(-1) && !this.f7749b.canScrollHorizontally(1)) {
            z8 = false;
        }
        accessibilityEvent.setScrollable(z8);
        g0 g0Var = this.f7749b.f1078u;
        if (g0Var != null) {
            accessibilityEvent.setItemCount(g0Var.a());
        }
    }

    public void S(l7.a aVar, z0 z0Var, o0.l lVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = lVar.f7564a;
        if (this.f7749b.canScrollVertically(-1) || this.f7749b.canScrollHorizontally(-1)) {
            lVar.a(8192);
            accessibilityNodeInfo.setScrollable(true);
        }
        if (this.f7749b.canScrollVertically(1) || this.f7749b.canScrollHorizontally(1)) {
            lVar.a(4096);
            accessibilityNodeInfo.setScrollable(true);
        }
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(H(aVar, z0Var), x(aVar, z0Var), false, 0));
    }

    public final void T(View view, o0.l lVar) {
        d1 J = RecyclerView.J(view);
        if (J == null || J.h()) {
            return;
        }
        androidx.fragment.app.g gVar = this.f7748a;
        if (((ArrayList) gVar.f730l).contains(J.f7618a)) {
            return;
        }
        RecyclerView recyclerView = this.f7749b;
        U(recyclerView.f1058k, recyclerView.f1067o0, view, lVar);
    }

    public abstract void a0(l7.a aVar, z0 z0Var);

    public final void b(View view, int i9, boolean z8) {
        d1 J = RecyclerView.J(view);
        if (z8 || J.h()) {
            s.h hVar = (s.h) this.f7749b.f1066o.f6510j;
            m1 m1Var = (m1) hVar.getOrDefault(J, null);
            if (m1Var == null) {
                m1Var = m1.a();
                hVar.put(J, m1Var);
            }
            m1Var.f7735a |= 1;
        } else {
            this.f7749b.f1066o.v(J);
        }
        p0 p0Var = (p0) view.getLayoutParams();
        if (J.p() || J.i()) {
            if (J.i()) {
                J.f7630n.l(J);
            } else {
                J.f7626j &= -33;
            }
            this.f7748a.y(view, i9, view.getLayoutParams(), false);
        } else {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.f7749b;
            androidx.fragment.app.g gVar = this.f7748a;
            if (parent == recyclerView) {
                b2.d0 d0Var = (b2.d0) gVar.f729k;
                int indexOfChild = ((f0) gVar.f728j).f7650a.indexOfChild(view);
                int r8 = (indexOfChild == -1 || d0Var.u(indexOfChild)) ? -1 : indexOfChild - d0Var.r(indexOfChild);
                if (i9 == -1) {
                    i9 = this.f7748a.N();
                }
                if (r8 == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f7749b.indexOfChild(view) + this.f7749b.z());
                }
                if (r8 != i9) {
                    o0 o0Var = this.f7749b.f1080v;
                    View u3 = o0Var.u(r8);
                    if (u3 == null) {
                        throw new IllegalArgumentException("Cannot move a child from non-existing index:" + r8 + o0Var.f7749b.toString());
                    }
                    o0Var.u(r8);
                    o0Var.f7748a.H(r8);
                    p0 p0Var2 = (p0) u3.getLayoutParams();
                    d1 J2 = RecyclerView.J(u3);
                    boolean h = J2.h();
                    RecyclerView recyclerView2 = o0Var.f7749b;
                    if (h) {
                        s.h hVar2 = (s.h) recyclerView2.f1066o.f6510j;
                        m1 m1Var2 = (m1) hVar2.getOrDefault(J2, null);
                        if (m1Var2 == null) {
                            m1Var2 = m1.a();
                            hVar2.put(J2, m1Var2);
                        }
                        m1Var2.f7735a = 1 | m1Var2.f7735a;
                    } else {
                        recyclerView2.f1066o.v(J2);
                    }
                    o0Var.f7748a.y(u3, i9, p0Var2, J2.h());
                }
            } else {
                gVar.x(view, i9, false);
                p0Var.f7767c = true;
                z zVar = this.f7752e;
                if (zVar != null && zVar.f7857e) {
                    zVar.f7854b.getClass();
                    d1 J3 = RecyclerView.J(view);
                    if ((J3 != null ? J3.b() : -1) == zVar.f7853a) {
                        zVar.f7858f = view;
                    }
                }
            }
        }
        if (p0Var.f7768d) {
            J.f7618a.invalidate();
            p0Var.f7768d = false;
        }
    }

    public abstract void b0(z0 z0Var);

    public void c(String str) {
        RecyclerView recyclerView = this.f7749b;
        if (recyclerView != null) {
            recyclerView.i(str);
        }
    }

    public abstract boolean d();

    public Parcelable d0() {
        return null;
    }

    public abstract boolean e();

    public boolean f(p0 p0Var) {
        return p0Var != null;
    }

    public final void f0(l7.a aVar) {
        for (int v8 = v() - 1; v8 >= 0; v8--) {
            if (!RecyclerView.J(u(v8)).o()) {
                View u3 = u(v8);
                i0(v8);
                aVar.h(u3);
            }
        }
    }

    public final void g0(l7.a aVar) {
        ArrayList arrayList;
        int size = ((ArrayList) aVar.f6273c).size();
        int i9 = size - 1;
        while (true) {
            arrayList = (ArrayList) aVar.f6273c;
            if (i9 < 0) {
                break;
            }
            View view = ((d1) arrayList.get(i9)).f7618a;
            d1 J = RecyclerView.J(view);
            if (!J.o()) {
                J.n(false);
                if (J.j()) {
                    this.f7749b.removeDetachedView(view, false);
                }
                k0 k0Var = this.f7749b.T;
                if (k0Var != null) {
                    k0Var.d(J);
                }
                J.n(true);
                d1 J2 = RecyclerView.J(view);
                J2.f7630n = null;
                J2.f7631o = false;
                J2.f7626j &= -33;
                aVar.i(J2);
            }
            i9--;
        }
        arrayList.clear();
        ArrayList arrayList2 = (ArrayList) aVar.f6274d;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        if (size > 0) {
            this.f7749b.invalidate();
        }
    }

    public final void h0(View view, l7.a aVar) {
        androidx.fragment.app.g gVar = this.f7748a;
        f0 f0Var = (f0) gVar.f728j;
        int indexOfChild = f0Var.f7650a.indexOfChild(view);
        if (indexOfChild >= 0) {
            if (((b2.d0) gVar.f729k).w(indexOfChild)) {
                gVar.m0(view);
            }
            f0Var.h(indexOfChild);
        }
        aVar.h(view);
    }

    public final void i0(int i9) {
        if (u(i9) != null) {
            androidx.fragment.app.g gVar = this.f7748a;
            int V = gVar.V(i9);
            f0 f0Var = (f0) gVar.f728j;
            View childAt = f0Var.f7650a.getChildAt(V);
            if (childAt == null) {
                return;
            }
            if (((b2.d0) gVar.f729k).w(V)) {
                gVar.m0(childAt);
            }
            f0Var.h(V);
        }
    }

    public abstract int j(z0 z0Var);

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00ab, code lost:
    
        if ((r5.bottom - r10) > r2) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean j0(androidx.recyclerview.widget.RecyclerView r9, android.view.View r10, android.graphics.Rect r11, boolean r12, boolean r13) {
        /*
            r8 = this;
            int r0 = r8.C()
            int r1 = r8.E()
            int r2 = r8.f7760n
            int r3 = r8.D()
            int r2 = r2 - r3
            int r3 = r8.f7761o
            int r4 = r8.B()
            int r3 = r3 - r4
            int r4 = r10.getLeft()
            int r5 = r11.left
            int r4 = r4 + r5
            int r5 = r10.getScrollX()
            int r4 = r4 - r5
            int r5 = r10.getTop()
            int r6 = r11.top
            int r5 = r5 + r6
            int r10 = r10.getScrollY()
            int r5 = r5 - r10
            int r10 = r11.width()
            int r10 = r10 + r4
            int r11 = r11.height()
            int r11 = r11 + r5
            int r4 = r4 - r0
            r0 = 0
            int r6 = java.lang.Math.min(r0, r4)
            int r5 = r5 - r1
            int r1 = java.lang.Math.min(r0, r5)
            int r10 = r10 - r2
            int r2 = java.lang.Math.max(r0, r10)
            int r11 = r11 - r3
            int r11 = java.lang.Math.max(r0, r11)
            int r3 = r8.A()
            r7 = 1
            if (r3 != r7) goto L5c
            if (r2 == 0) goto L57
            goto L64
        L57:
            int r2 = java.lang.Math.max(r6, r10)
            goto L64
        L5c:
            if (r6 == 0) goto L5f
            goto L63
        L5f:
            int r6 = java.lang.Math.min(r4, r2)
        L63:
            r2 = r6
        L64:
            if (r1 == 0) goto L67
            goto L6b
        L67:
            int r1 = java.lang.Math.min(r5, r11)
        L6b:
            int[] r10 = new int[]{r2, r1}
            r11 = r10[r0]
            r10 = r10[r7]
            if (r13 == 0) goto Lae
            android.view.View r13 = r9.getFocusedChild()
            if (r13 != 0) goto L7c
            goto Lb3
        L7c:
            int r1 = r8.C()
            int r2 = r8.E()
            int r3 = r8.f7760n
            int r4 = r8.D()
            int r3 = r3 - r4
            int r4 = r8.f7761o
            int r5 = r8.B()
            int r4 = r4 - r5
            androidx.recyclerview.widget.RecyclerView r5 = r8.f7749b
            android.graphics.Rect r5 = r5.f1072r
            r8.y(r13, r5)
            int r13 = r5.left
            int r13 = r13 - r11
            if (r13 >= r3) goto Lb3
            int r13 = r5.right
            int r13 = r13 - r11
            if (r13 <= r1) goto Lb3
            int r13 = r5.top
            int r13 = r13 - r10
            if (r13 >= r4) goto Lb3
            int r13 = r5.bottom
            int r13 = r13 - r10
            if (r13 > r2) goto Lae
            goto Lb3
        Lae:
            if (r11 != 0) goto Lb4
            if (r10 == 0) goto Lb3
            goto Lb4
        Lb3:
            return r0
        Lb4:
            if (r12 == 0) goto Lba
            r9.scrollBy(r11, r10)
            return r7
        Lba:
            r9.f0(r11, r10, r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.o0.j0(androidx.recyclerview.widget.RecyclerView, android.view.View, android.graphics.Rect, boolean, boolean):boolean");
    }

    public abstract int k(z0 z0Var);

    public final void k0() {
        RecyclerView recyclerView = this.f7749b;
        if (recyclerView != null) {
            recyclerView.requestLayout();
        }
    }

    public abstract int l(z0 z0Var);

    public abstract int l0(int i9, l7.a aVar, z0 z0Var);

    public abstract int m(z0 z0Var);

    public abstract void m0(int i9);

    public abstract int n(z0 z0Var);

    public abstract int n0(int i9, l7.a aVar, z0 z0Var);

    public abstract int o(z0 z0Var);

    public final void o0(RecyclerView recyclerView) {
        p0(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
    }

    public final void p(l7.a aVar) {
        for (int v8 = v() - 1; v8 >= 0; v8--) {
            View u3 = u(v8);
            d1 J = RecyclerView.J(u3);
            if (!J.o()) {
                if (!J.f() || J.h() || this.f7749b.f1078u.f7660b) {
                    u(v8);
                    this.f7748a.H(v8);
                    aVar.j(u3);
                    this.f7749b.f1066o.v(J);
                } else {
                    i0(v8);
                    aVar.i(J);
                }
            }
        }
    }

    public final void p0(int i9, int i10) {
        this.f7760n = View.MeasureSpec.getSize(i9);
        int mode = View.MeasureSpec.getMode(i9);
        this.f7758l = mode;
        if (mode == 0 && !RecyclerView.J0) {
            this.f7760n = 0;
        }
        this.f7761o = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i10);
        this.f7759m = mode2;
        if (mode2 != 0 || RecyclerView.J0) {
            return;
        }
        this.f7761o = 0;
    }

    public View q(int i9) {
        int v8 = v();
        for (int i10 = 0; i10 < v8; i10++) {
            View u3 = u(i10);
            d1 J = RecyclerView.J(u3);
            if (J != null && J.b() == i9 && !J.o() && (this.f7749b.f1067o0.f7874g || !J.h())) {
                return u3;
            }
        }
        return null;
    }

    public void q0(Rect rect, int i9, int i10) {
        int D = D() + C() + rect.width();
        int B = B() + E() + rect.height();
        RecyclerView recyclerView = this.f7749b;
        WeakHashMap weakHashMap = n0.t0.f7209a;
        this.f7749b.setMeasuredDimension(g(i9, D, n0.c0.e(recyclerView)), g(i10, B, n0.c0.d(this.f7749b)));
    }

    public abstract p0 r();

    public final void r0(int i9, int i10) {
        int v8 = v();
        if (v8 == 0) {
            this.f7749b.o(i9, i10);
            return;
        }
        int i11 = Integer.MIN_VALUE;
        int i12 = Integer.MIN_VALUE;
        int i13 = Integer.MAX_VALUE;
        int i14 = Integer.MAX_VALUE;
        for (int i15 = 0; i15 < v8; i15++) {
            View u3 = u(i15);
            Rect rect = this.f7749b.f1072r;
            y(u3, rect);
            int i16 = rect.left;
            if (i16 < i13) {
                i13 = i16;
            }
            int i17 = rect.right;
            if (i17 > i11) {
                i11 = i17;
            }
            int i18 = rect.top;
            if (i18 < i14) {
                i14 = i18;
            }
            int i19 = rect.bottom;
            if (i19 > i12) {
                i12 = i19;
            }
        }
        this.f7749b.f1072r.set(i13, i14, i11, i12);
        q0(this.f7749b.f1072r, i9, i10);
    }

    public p0 s(Context context, AttributeSet attributeSet) {
        return new p0(context, attributeSet);
    }

    public final void s0(RecyclerView recyclerView) {
        if (recyclerView == null) {
            this.f7749b = null;
            this.f7748a = null;
            this.f7760n = 0;
            this.f7761o = 0;
        } else {
            this.f7749b = recyclerView;
            this.f7748a = recyclerView.f1064n;
            this.f7760n = recyclerView.getWidth();
            this.f7761o = recyclerView.getHeight();
        }
        this.f7758l = 1073741824;
        this.f7759m = 1073741824;
    }

    public p0 t(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof p0 ? new p0((p0) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new p0((ViewGroup.MarginLayoutParams) layoutParams) : new p0(layoutParams);
    }

    public final boolean t0(View view, int i9, int i10, p0 p0Var) {
        return (!view.isLayoutRequested() && this.h && K(view.getWidth(), i9, ((ViewGroup.MarginLayoutParams) p0Var).width) && K(view.getHeight(), i10, ((ViewGroup.MarginLayoutParams) p0Var).height)) ? false : true;
    }

    public final View u(int i9) {
        androidx.fragment.app.g gVar = this.f7748a;
        if (gVar != null) {
            return gVar.M(i9);
        }
        return null;
    }

    public boolean u0() {
        return false;
    }

    public final int v() {
        androidx.fragment.app.g gVar = this.f7748a;
        if (gVar != null) {
            return gVar.N();
        }
        return 0;
    }

    public final boolean v0(View view, int i9, int i10, p0 p0Var) {
        return (this.h && K(view.getMeasuredWidth(), i9, ((ViewGroup.MarginLayoutParams) p0Var).width) && K(view.getMeasuredHeight(), i10, ((ViewGroup.MarginLayoutParams) p0Var).height)) ? false : true;
    }

    public abstract void w0(RecyclerView recyclerView, int i9);

    public int x(l7.a aVar, z0 z0Var) {
        return -1;
    }

    public final void x0(z zVar) {
        z zVar2 = this.f7752e;
        if (zVar2 != null && zVar != zVar2 && zVar2.f7857e) {
            zVar2.i();
        }
        this.f7752e = zVar;
        RecyclerView recyclerView = this.f7749b;
        c1 c1Var = recyclerView.f1061l0;
        c1Var.f7609o.removeCallbacks(c1Var);
        c1Var.f7605k.abortAnimation();
        if (zVar.h) {
            Log.w("RecyclerView", "An instance of " + zVar.getClass().getSimpleName() + " was started more than once. Each instance of" + zVar.getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
        }
        zVar.f7854b = recyclerView;
        zVar.f7855c = this;
        int i9 = zVar.f7853a;
        if (i9 == -1) {
            m7.c.n("Invalid target position");
            return;
        }
        recyclerView.f1067o0.f7868a = i9;
        zVar.f7857e = true;
        zVar.f7856d = true;
        zVar.f7858f = recyclerView.f1080v.q(i9);
        zVar.f7854b.f1061l0.b();
        zVar.h = true;
    }

    public void y(View view, Rect rect) {
        int[] iArr = RecyclerView.H0;
        p0 p0Var = (p0) view.getLayoutParams();
        Rect rect2 = p0Var.f7766b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) p0Var).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) p0Var).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) p0Var).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) p0Var).bottomMargin);
    }

    public boolean y0() {
        return false;
    }

    public final int z() {
        RecyclerView recyclerView = this.f7749b;
        g0 adapter = recyclerView != null ? recyclerView.getAdapter() : null;
        if (adapter != null) {
            return adapter.a();
        }
        return 0;
    }

    public void O() {
    }

    public void W() {
    }

    public void P(RecyclerView recyclerView) {
    }

    public void c0(Parcelable parcelable) {
    }

    public void e0(int i9) {
    }

    public void V(int i9, int i10) {
    }

    public void X(int i9, int i10) {
    }

    public void Y(int i9, int i10) {
    }

    public void Z(int i9, int i10) {
    }

    public void i(int i9, r rVar) {
    }

    public void U(l7.a aVar, z0 z0Var, View view, o0.l lVar) {
    }

    public void h(int i9, int i10, z0 z0Var, r rVar) {
    }
}
