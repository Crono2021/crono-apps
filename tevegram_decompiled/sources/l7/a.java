package l7;

import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import n0.t0;
import o3.d1;
import o3.e1;
import o3.f1;
import o3.g0;
import o3.i;
import o3.k0;
import o3.o0;
import o3.r;
import o3.s0;
import o3.z0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f6271a;

    /* renamed from: b, reason: collision with root package name */
    public int f6272b;

    /* renamed from: c, reason: collision with root package name */
    public Object f6273c;

    /* renamed from: d, reason: collision with root package name */
    public Object f6274d;

    /* renamed from: e, reason: collision with root package name */
    public Object f6275e;

    /* renamed from: f, reason: collision with root package name */
    public Object f6276f;

    /* renamed from: g, reason: collision with root package name */
    public Object f6277g;
    public Object h;

    public void a(d1 d1Var, boolean z8) {
        RecyclerView.j(d1Var);
        View view = d1Var.f7618a;
        RecyclerView recyclerView = (RecyclerView) this.h;
        f1 f1Var = recyclerView.f1081v0;
        if (f1Var != null) {
            e1 e1Var = f1Var.f7652e;
            t0.p(view, e1Var != null ? (n0.c) e1Var.f7644e.remove(view) : null);
        }
        if (z8) {
            ArrayList arrayList = recyclerView.f1082w;
            if (arrayList.size() > 0) {
                arrayList.get(0).getClass();
                androidx.fragment.app.a.c();
                return;
            } else if (recyclerView.f1067o0 != null) {
                recyclerView.f1066o.w(d1Var);
            }
        }
        d1Var.f7635s = null;
        d1Var.f7634r = null;
        o3.t0 c9 = c();
        c9.getClass();
        int i9 = d1Var.f7623f;
        ArrayList arrayList2 = c9.a(i9).f7803a;
        if (((s0) c9.f7813a.get(i9)).f7804b <= arrayList2.size()) {
            a.a.d(view);
        } else {
            d1Var.m();
            arrayList2.add(d1Var);
        }
    }

    public int b(int i9) {
        RecyclerView recyclerView = (RecyclerView) this.h;
        z0 z0Var = recyclerView.f1067o0;
        if (i9 >= 0 && i9 < z0Var.b()) {
            return !z0Var.f7874g ? i9 : recyclerView.f1062m.g(i9, 0);
        }
        StringBuilder p5 = androidx.activity.g.p(i9, "invalid position ", ". State item count is ");
        p5.append(z0Var.b());
        p5.append(recyclerView.z());
        throw new IndexOutOfBoundsException(p5.toString());
    }

    public o3.t0 c() {
        if (((o3.t0) this.f6277g) == null) {
            o3.t0 t0Var = new o3.t0();
            t0Var.f7813a = new SparseArray();
            t0Var.f7814b = 0;
            t0Var.f7815c = Collections.newSetFromMap(new IdentityHashMap());
            this.f6277g = t0Var;
            d();
        }
        return (o3.t0) this.f6277g;
    }

    public void d() {
        RecyclerView recyclerView;
        g0 g0Var;
        o3.t0 t0Var = (o3.t0) this.f6277g;
        if (t0Var == null || (g0Var = (recyclerView = (RecyclerView) this.h).f1078u) == null || !recyclerView.A) {
            return;
        }
        t0Var.f7815c.add(g0Var);
    }

    public void e(g0 g0Var, boolean z8) {
        o3.t0 t0Var = (o3.t0) this.f6277g;
        if (t0Var != null) {
            SparseArray sparseArray = t0Var.f7813a;
            Set set = t0Var.f7815c;
            set.remove(g0Var);
            if (set.size() != 0 || z8) {
                return;
            }
            for (int i9 = 0; i9 < sparseArray.size(); i9++) {
                ArrayList arrayList = ((s0) sparseArray.get(sparseArray.keyAt(i9))).f7803a;
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    a.a.d(((d1) arrayList.get(i10)).f7618a);
                }
            }
        }
    }

    public void f() {
        ArrayList arrayList = (ArrayList) this.f6275e;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            g(size);
        }
        arrayList.clear();
        if (RecyclerView.L0) {
            r rVar = ((RecyclerView) this.h).f1065n0;
            int[] iArr = rVar.f7794a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            rVar.f7797d = 0;
        }
    }

    public void g(int i9) {
        ArrayList arrayList = (ArrayList) this.f6275e;
        a((d1) arrayList.get(i9), true);
        arrayList.remove(i9);
    }

    public void h(View view) {
        RecyclerView recyclerView = (RecyclerView) this.h;
        d1 J = RecyclerView.J(view);
        if (J.j()) {
            recyclerView.removeDetachedView(view, false);
        }
        if (J.i()) {
            J.f7630n.l(J);
        } else if (J.p()) {
            J.f7626j &= -33;
        }
        i(J);
        if (recyclerView.T == null || J.g()) {
            return;
        }
        recyclerView.T.d(J);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0093, code lost:
    
        r7 = r7 - 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void i(o3.d1 r13) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l7.a.i(o3.d1):void");
    }

    public void j(View view) {
        k0 k0Var;
        RecyclerView recyclerView = (RecyclerView) this.h;
        d1 J = RecyclerView.J(view);
        if ((J.f7626j & 12) == 0 && J.k() && (k0Var = recyclerView.T) != null) {
            i iVar = (i) k0Var;
            if (J.c().isEmpty() && iVar.f7677g && !J.f()) {
                if (((ArrayList) this.f6274d) == null) {
                    this.f6274d = new ArrayList();
                }
                J.f7630n = this;
                J.f7631o = true;
                ((ArrayList) this.f6274d).add(J);
                return;
            }
        }
        if (J.f() && !J.h() && !recyclerView.f1078u.f7660b) {
            m7.c.n("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.".concat(recyclerView.z()));
            return;
        }
        J.f7630n = this;
        J.f7631o = false;
        ((ArrayList) this.f6273c).add(J);
    }

    /* JADX WARN: Code restructure failed: missing block: B:237:0x042a, code lost:
    
        if (r12.f() == false) goto L245;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01cd, code lost:
    
        if (r11.f7623f != 0) goto L110;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x03e7  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x052a  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x054a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0534  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0467  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x046c  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0491  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x04de  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0521  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x051c  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0469  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x03d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public o3.d1 k(int r28, long r29) {
        /*
            Method dump skipped, instructions count: 1396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l7.a.k(int, long):o3.d1");
    }

    public void l(d1 d1Var) {
        if (d1Var.f7631o) {
            ((ArrayList) this.f6274d).remove(d1Var);
        } else {
            ((ArrayList) this.f6273c).remove(d1Var);
        }
        d1Var.f7630n = null;
        d1Var.f7631o = false;
        d1Var.f7626j &= -33;
    }

    public void m() {
        ArrayList arrayList = (ArrayList) this.f6275e;
        o0 o0Var = ((RecyclerView) this.h).f1080v;
        this.f6272b = this.f6271a + (o0Var != null ? o0Var.f7756j : 0);
        for (int size = arrayList.size() - 1; size >= 0 && arrayList.size() > this.f6272b; size--) {
            g(size);
        }
    }
}
