package o3;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f7650a;

    public /* synthetic */ f0(RecyclerView recyclerView) {
        this.f7650a = recyclerView;
    }

    public void a(a aVar) {
        int i9 = aVar.f7585a;
        RecyclerView recyclerView = this.f7650a;
        if (i9 == 1) {
            recyclerView.f1080v.V(aVar.f7586b, aVar.f7588d);
            return;
        }
        if (i9 == 2) {
            recyclerView.f1080v.Y(aVar.f7586b, aVar.f7588d);
        } else if (i9 == 4) {
            recyclerView.f1080v.Z(aVar.f7586b, aVar.f7588d);
        } else {
            if (i9 != 8) {
                return;
            }
            recyclerView.f1080v.X(aVar.f7586b, aVar.f7588d);
        }
    }

    public d1 b(int i9) {
        RecyclerView recyclerView = this.f7650a;
        int Z = recyclerView.f1064n.Z();
        int i10 = 0;
        d1 d1Var = null;
        while (true) {
            if (i10 >= Z) {
                break;
            }
            d1 J = RecyclerView.J(recyclerView.f1064n.Y(i10));
            if (J != null && !J.h() && J.f7620c == i9) {
                if (!((ArrayList) recyclerView.f1064n.f730l).contains(J.f7618a)) {
                    d1Var = J;
                    break;
                }
                d1Var = J;
            }
            i10++;
        }
        if (d1Var != null) {
            if (!((ArrayList) recyclerView.f1064n.f730l).contains(d1Var.f7618a)) {
                return d1Var;
            }
        }
        return null;
    }

    public void c(int i9, int i10, Object obj) {
        int i11;
        int i12;
        RecyclerView recyclerView = this.f7650a;
        int Z = recyclerView.f1064n.Z();
        int i13 = i10 + i9;
        for (int i14 = 0; i14 < Z; i14++) {
            View Y = recyclerView.f1064n.Y(i14);
            d1 J = RecyclerView.J(Y);
            if (J != null && !J.o() && (i12 = J.f7620c) >= i9 && i12 < i13) {
                J.a(2);
                if (obj == null) {
                    J.a(1024);
                } else if ((1024 & J.f7626j) == 0) {
                    if (J.f7627k == null) {
                        ArrayList arrayList = new ArrayList();
                        J.f7627k = arrayList;
                        J.f7628l = Collections.unmodifiableList(arrayList);
                    }
                    J.f7627k.add(obj);
                }
                ((p0) Y.getLayoutParams()).f7767c = true;
            }
        }
        l7.a aVar = recyclerView.f1058k;
        ArrayList arrayList2 = (ArrayList) aVar.f6275e;
        for (int size = arrayList2.size() - 1; size >= 0; size--) {
            d1 d1Var = (d1) arrayList2.get(size);
            if (d1Var != null && (i11 = d1Var.f7620c) >= i9 && i11 < i13) {
                d1Var.a(2);
                aVar.g(size);
            }
        }
        recyclerView.f1075s0 = true;
    }

    public void d(int i9, int i10) {
        RecyclerView recyclerView = this.f7650a;
        int Z = recyclerView.f1064n.Z();
        for (int i11 = 0; i11 < Z; i11++) {
            d1 J = RecyclerView.J(recyclerView.f1064n.Y(i11));
            if (J != null && !J.o() && J.f7620c >= i9) {
                J.l(i10, false);
                recyclerView.f1067o0.f7873f = true;
            }
        }
        ArrayList arrayList = (ArrayList) recyclerView.f1058k.f6275e;
        int size = arrayList.size();
        for (int i12 = 0; i12 < size; i12++) {
            d1 d1Var = (d1) arrayList.get(i12);
            if (d1Var != null && d1Var.f7620c >= i9) {
                d1Var.l(i10, false);
            }
        }
        recyclerView.requestLayout();
        recyclerView.f1073r0 = true;
    }

    public void e(int i9, int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        RecyclerView recyclerView = this.f7650a;
        int Z = recyclerView.f1064n.Z();
        int i18 = -1;
        if (i9 < i10) {
            i12 = i9;
            i11 = i10;
            i13 = -1;
        } else {
            i11 = i9;
            i12 = i10;
            i13 = 1;
        }
        for (int i19 = 0; i19 < Z; i19++) {
            d1 J = RecyclerView.J(recyclerView.f1064n.Y(i19));
            if (J != null && (i17 = J.f7620c) >= i12 && i17 <= i11) {
                if (i17 == i9) {
                    J.l(i10 - i9, false);
                } else {
                    J.l(i13, false);
                }
                recyclerView.f1067o0.f7873f = true;
            }
        }
        ArrayList arrayList = (ArrayList) recyclerView.f1058k.f6275e;
        if (i9 < i10) {
            i15 = i9;
            i14 = i10;
        } else {
            i14 = i9;
            i15 = i10;
            i18 = 1;
        }
        int size = arrayList.size();
        for (int i20 = 0; i20 < size; i20++) {
            d1 d1Var = (d1) arrayList.get(i20);
            if (d1Var != null && (i16 = d1Var.f7620c) >= i15 && i16 <= i14) {
                if (i16 == i9) {
                    d1Var.l(i10 - i9, false);
                } else {
                    d1Var.l(i18, false);
                }
            }
        }
        recyclerView.requestLayout();
        recyclerView.f1073r0 = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(o3.d1 r9, d1.k0 r10, d1.k0 r11) {
        /*
            r8 = this;
            r0 = 0
            r9.n(r0)
            androidx.recyclerview.widget.RecyclerView r0 = r8.f7650a
            o3.k0 r1 = r0.T
            r2 = r1
            o3.i r2 = (o3.i) r2
            if (r10 == 0) goto L1d
            r2.getClass()
            int r4 = r10.f2492a
            int r6 = r11.f2492a
            if (r4 != r6) goto L1f
            int r1 = r10.f2493b
            int r3 = r11.f2493b
            if (r1 == r3) goto L1d
            goto L1f
        L1d:
            r3 = r9
            goto L29
        L1f:
            int r5 = r10.f2493b
            int r7 = r11.f2493b
            r3 = r9
            boolean r9 = r2.g(r3, r4, r5, r6, r7)
            goto L38
        L29:
            r2.l(r3)
            android.view.View r9 = r3.f7618a
            r10 = 0
            r9.setAlpha(r10)
            java.util.ArrayList r9 = r2.f7678i
            r9.add(r3)
            r9 = 1
        L38:
            if (r9 == 0) goto L3d
            r0.T()
        L3d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.f0.f(o3.d1, d1.k0, d1.k0):void");
    }

    public void g(d1 d1Var, d1.k0 k0Var, d1.k0 k0Var2) {
        boolean z8;
        RecyclerView recyclerView = this.f7650a;
        recyclerView.f1058k.l(d1Var);
        recyclerView.f(d1Var);
        d1Var.n(false);
        i iVar = (i) recyclerView.T;
        iVar.getClass();
        int i9 = k0Var.f2492a;
        int i10 = k0Var.f2493b;
        View view = d1Var.f7618a;
        int left = k0Var2 == null ? view.getLeft() : k0Var2.f2492a;
        int top = k0Var2 == null ? view.getTop() : k0Var2.f2493b;
        if (d1Var.h() || (i9 == left && i10 == top)) {
            iVar.l(d1Var);
            iVar.h.add(d1Var);
            z8 = true;
        } else {
            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
            z8 = iVar.g(d1Var, i9, i10, left, top);
        }
        if (z8) {
            recyclerView.T();
        }
    }

    public void h(int i9) {
        RecyclerView recyclerView = this.f7650a;
        View childAt = recyclerView.getChildAt(i9);
        if (childAt != null) {
            RecyclerView.J(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeViewAt(i9);
    }
}
