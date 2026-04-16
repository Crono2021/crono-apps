package n;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public int f6983a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f6984b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f6985c;

    /* renamed from: d, reason: collision with root package name */
    public Object f6986d;

    /* renamed from: e, reason: collision with root package name */
    public Object f6987e;

    /* renamed from: f, reason: collision with root package name */
    public Object f6988f;

    public o(o3.f0 f0Var) {
        this.f6984b = new m0.d(30);
        this.f6985c = new ArrayList();
        this.f6986d = new ArrayList();
        this.f6983a = 0;
        this.f6987e = f0Var;
        this.f6988f = new i7.x(this, 17);
    }

    public void a() {
        View view = (View) this.f6984b;
        Drawable background = view.getBackground();
        if (background != null) {
            int i9 = Build.VERSION.SDK_INT;
            if (i9 <= 21 ? i9 == 21 : ((o3) this.f6986d) != null) {
                if (((o3) this.f6988f) == null) {
                    this.f6988f = new o3();
                }
                o3 o3Var = (o3) this.f6988f;
                o3Var.f6991a = null;
                o3Var.f6994d = false;
                o3Var.f6992b = null;
                o3Var.f6993c = false;
                WeakHashMap weakHashMap = n0.t0.f7209a;
                ColorStateList g9 = n0.i0.g(view);
                if (g9 != null) {
                    o3Var.f6994d = true;
                    o3Var.f6991a = g9;
                }
                PorterDuff.Mode h = n0.i0.h(view);
                if (h != null) {
                    o3Var.f6993c = true;
                    o3Var.f6992b = h;
                }
                if (o3Var.f6994d || o3Var.f6993c) {
                    t.e(background, o3Var, view.getDrawableState());
                    return;
                }
            }
            o3 o3Var2 = (o3) this.f6987e;
            if (o3Var2 != null) {
                t.e(background, o3Var2, view.getDrawableState());
                return;
            }
            o3 o3Var3 = (o3) this.f6986d;
            if (o3Var3 != null) {
                t.e(background, o3Var3, view.getDrawableState());
            }
        }
    }

    public boolean b(int i9) {
        ArrayList arrayList = (ArrayList) this.f6986d;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            o3.a aVar = (o3.a) arrayList.get(i10);
            int i11 = aVar.f7585a;
            if (i11 != 8) {
                if (i11 == 1) {
                    int i12 = aVar.f7586b;
                    int i13 = aVar.f7588d + i12;
                    while (i12 < i13) {
                        if (g(i12, i10 + 1) == i9) {
                            return true;
                        }
                        i12++;
                    }
                } else {
                    continue;
                }
            } else {
                if (g(aVar.f7588d, i10 + 1) == i9) {
                    return true;
                }
            }
        }
        return false;
    }

    public void c() {
        ArrayList arrayList = (ArrayList) this.f6986d;
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            ((o3.f0) this.f6987e).a((o3.a) arrayList.get(i9));
        }
        q(arrayList);
        this.f6983a = 0;
    }

    public void d() {
        o3.f0 f0Var = (o3.f0) this.f6987e;
        c();
        ArrayList arrayList = (ArrayList) this.f6985c;
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            o3.a aVar = (o3.a) arrayList.get(i9);
            int i10 = aVar.f7585a;
            if (i10 == 1) {
                f0Var.a(aVar);
                f0Var.d(aVar.f7586b, aVar.f7588d);
            } else if (i10 == 2) {
                f0Var.a(aVar);
                int i11 = aVar.f7586b;
                int i12 = aVar.f7588d;
                RecyclerView recyclerView = f0Var.f7650a;
                recyclerView.P(i11, i12, true);
                recyclerView.f1073r0 = true;
                recyclerView.f1067o0.f7870c += i12;
            } else if (i10 == 4) {
                f0Var.a(aVar);
                f0Var.c(aVar.f7586b, aVar.f7588d, aVar.f7587c);
            } else if (i10 == 8) {
                f0Var.a(aVar);
                f0Var.e(aVar.f7586b, aVar.f7588d);
            }
        }
        q(arrayList);
        this.f6983a = 0;
    }

    public void e(o3.a aVar) {
        int i9;
        m0.d dVar = (m0.d) this.f6984b;
        int i10 = aVar.f7585a;
        if (i10 == 1 || i10 == 8) {
            m7.c.n("should not dispatch add or move for pre layout");
            return;
        }
        int u3 = u(aVar.f7586b, i10);
        int i11 = aVar.f7586b;
        int i12 = aVar.f7585a;
        if (i12 == 2) {
            i9 = 0;
        } else {
            if (i12 != 4) {
                androidx.fragment.app.a.n(aVar, "op should be remove or update.");
                return;
            }
            i9 = 1;
        }
        int i13 = 1;
        for (int i14 = 1; i14 < aVar.f7588d; i14++) {
            int u6 = u((i9 * i14) + aVar.f7586b, aVar.f7585a);
            int i15 = aVar.f7585a;
            if (i15 == 2 ? u6 != u3 : !(i15 == 4 && u6 == u3 + 1)) {
                o3.a l4 = l(aVar.f7587c, i15, u3, i13);
                f(l4, i11);
                l4.f7587c = null;
                dVar.a(l4);
                if (aVar.f7585a == 4) {
                    i11 += i13;
                }
                u3 = u6;
                i13 = 1;
            } else {
                i13++;
            }
        }
        Object obj = aVar.f7587c;
        aVar.f7587c = null;
        dVar.a(aVar);
        if (i13 > 0) {
            o3.a l9 = l(obj, aVar.f7585a, u3, i13);
            f(l9, i11);
            l9.f7587c = null;
            dVar.a(l9);
        }
    }

    public void f(o3.a aVar, int i9) {
        o3.f0 f0Var = (o3.f0) this.f6987e;
        f0Var.a(aVar);
        int i10 = aVar.f7585a;
        if (i10 != 2) {
            if (i10 == 4) {
                f0Var.c(i9, aVar.f7588d, aVar.f7587c);
                return;
            } else {
                m7.c.n("only remove and update ops can be dispatched in first pass");
                return;
            }
        }
        int i11 = aVar.f7588d;
        RecyclerView recyclerView = f0Var.f7650a;
        recyclerView.P(i9, i11, true);
        recyclerView.f1073r0 = true;
        recyclerView.f1067o0.f7870c += i11;
    }

    public int g(int i9, int i10) {
        ArrayList arrayList = (ArrayList) this.f6986d;
        int size = arrayList.size();
        while (i10 < size) {
            o3.a aVar = (o3.a) arrayList.get(i10);
            int i11 = aVar.f7585a;
            int i12 = aVar.f7586b;
            if (i11 == 8) {
                if (i12 == i9) {
                    i9 = aVar.f7588d;
                } else {
                    if (i12 < i9) {
                        i9--;
                    }
                    if (aVar.f7588d <= i9) {
                        i9++;
                    }
                }
            } else if (i12 > i9) {
                continue;
            } else if (i11 == 2) {
                int i13 = aVar.f7588d;
                if (i9 < i12 + i13) {
                    return -1;
                }
                i9 -= i13;
            } else if (i11 == 1) {
                i9 += aVar.f7588d;
            }
            i10++;
        }
        return i9;
    }

    public ColorStateList h() {
        o3 o3Var = (o3) this.f6987e;
        if (o3Var != null) {
            return o3Var.f6991a;
        }
        return null;
    }

    public PorterDuff.Mode i() {
        o3 o3Var = (o3) this.f6987e;
        if (o3Var != null) {
            return o3Var.f6992b;
        }
        return null;
    }

    public boolean j() {
        return ((ArrayList) this.f6985c).size() > 0;
    }

    public void k(AttributeSet attributeSet, int i9) {
        ColorStateList i10;
        View view = (View) this.f6984b;
        Context context = view.getContext();
        int[] iArr = f.a.A;
        androidx.fragment.app.g g02 = androidx.fragment.app.g.g0(context, attributeSet, iArr, i9);
        TypedArray typedArray = (TypedArray) g02.f729k;
        View view2 = (View) this.f6984b;
        n0.t0.o(view2, view2.getContext(), iArr, attributeSet, (TypedArray) g02.f729k, i9);
        try {
            if (typedArray.hasValue(0)) {
                this.f6983a = typedArray.getResourceId(0, -1);
                t tVar = (t) this.f6985c;
                Context context2 = view.getContext();
                int i11 = this.f6983a;
                synchronized (tVar) {
                    i10 = tVar.f7034a.i(context2, i11);
                }
                if (i10 != null) {
                    r(i10);
                }
            }
            if (typedArray.hasValue(1)) {
                n0.t0.r(view, g02.O(1));
            }
            if (typedArray.hasValue(2)) {
                n0.i0.r(view, r1.c(typedArray.getInt(2, -1), null));
                if (Build.VERSION.SDK_INT == 21) {
                    Drawable background = view.getBackground();
                    boolean z8 = (n0.i0.g(view) == null && n0.i0.h(view) == null) ? false : true;
                    if (background != null && z8) {
                        if (background.isStateful()) {
                            background.setState(view.getDrawableState());
                        }
                        n0.c0.q(view, background);
                    }
                }
            }
            g02.i0();
        } catch (Throwable th) {
            g02.i0();
            throw th;
        }
    }

    public o3.a l(Object obj, int i9, int i10, int i11) {
        o3.a aVar = (o3.a) ((m0.d) this.f6984b).b();
        if (aVar != null) {
            aVar.f7585a = i9;
            aVar.f7586b = i10;
            aVar.f7588d = i11;
            aVar.f7587c = obj;
            return aVar;
        }
        o3.a aVar2 = new o3.a();
        aVar2.f7585a = i9;
        aVar2.f7586b = i10;
        aVar2.f7588d = i11;
        aVar2.f7587c = obj;
        return aVar2;
    }

    public void m() {
        this.f6983a = -1;
        r(null);
        a();
    }

    public void n(int i9) {
        ColorStateList colorStateList;
        this.f6983a = i9;
        t tVar = (t) this.f6985c;
        if (tVar != null) {
            Context context = ((View) this.f6984b).getContext();
            synchronized (tVar) {
                colorStateList = tVar.f7034a.i(context, i9);
            }
        } else {
            colorStateList = null;
        }
        r(colorStateList);
        a();
    }

    public void o(o3.a aVar) {
        o3.f0 f0Var = (o3.f0) this.f6987e;
        ((ArrayList) this.f6986d).add(aVar);
        int i9 = aVar.f7585a;
        if (i9 == 1) {
            f0Var.d(aVar.f7586b, aVar.f7588d);
            return;
        }
        if (i9 == 2) {
            int i10 = aVar.f7586b;
            int i11 = aVar.f7588d;
            RecyclerView recyclerView = f0Var.f7650a;
            recyclerView.P(i10, i11, false);
            recyclerView.f1073r0 = true;
            return;
        }
        if (i9 == 4) {
            f0Var.c(aVar.f7586b, aVar.f7588d, aVar.f7587c);
        } else if (i9 == 8) {
            f0Var.e(aVar.f7586b, aVar.f7588d);
        } else {
            androidx.fragment.app.a.n(aVar, "Unknown update op type for ");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00b1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0015 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0132 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0125 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void p() {
        /*
            Method dump skipped, instructions count: 698
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n.o.p():void");
    }

    public void q(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            o3.a aVar = (o3.a) arrayList.get(i9);
            aVar.f7587c = null;
            ((m0.d) this.f6984b).a(aVar);
        }
        arrayList.clear();
    }

    public void r(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (((o3) this.f6986d) == null) {
                this.f6986d = new o3();
            }
            o3 o3Var = (o3) this.f6986d;
            o3Var.f6991a = colorStateList;
            o3Var.f6994d = true;
        } else {
            this.f6986d = null;
        }
        a();
    }

    public void s(ColorStateList colorStateList) {
        if (((o3) this.f6987e) == null) {
            this.f6987e = new o3();
        }
        o3 o3Var = (o3) this.f6987e;
        o3Var.f6991a = colorStateList;
        o3Var.f6994d = true;
        a();
    }

    public void t(PorterDuff.Mode mode) {
        if (((o3) this.f6987e) == null) {
            this.f6987e = new o3();
        }
        o3 o3Var = (o3) this.f6987e;
        o3Var.f6992b = mode;
        o3Var.f6993c = true;
        a();
    }

    public int u(int i9, int i10) {
        int i11;
        int i12;
        m0.d dVar = (m0.d) this.f6984b;
        ArrayList arrayList = (ArrayList) this.f6986d;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            o3.a aVar = (o3.a) arrayList.get(size);
            int i13 = aVar.f7585a;
            int i14 = aVar.f7586b;
            if (i13 == 8) {
                int i15 = aVar.f7588d;
                if (i14 < i15) {
                    i12 = i15;
                    i11 = i14;
                } else {
                    i11 = i15;
                    i12 = i14;
                }
                if (i9 < i11 || i9 > i12) {
                    if (i9 < i14) {
                        if (i10 == 1) {
                            aVar.f7586b = i14 + 1;
                            aVar.f7588d = i15 + 1;
                        } else if (i10 == 2) {
                            aVar.f7586b = i14 - 1;
                            aVar.f7588d = i15 - 1;
                        }
                    }
                } else if (i11 == i14) {
                    if (i10 == 1) {
                        aVar.f7588d = i15 + 1;
                    } else if (i10 == 2) {
                        aVar.f7588d = i15 - 1;
                    }
                    i9++;
                } else {
                    if (i10 == 1) {
                        aVar.f7586b = i14 + 1;
                    } else if (i10 == 2) {
                        aVar.f7586b = i14 - 1;
                    }
                    i9--;
                }
            } else if (i14 <= i9) {
                if (i13 == 1) {
                    i9 -= aVar.f7588d;
                } else if (i13 == 2) {
                    i9 += aVar.f7588d;
                }
            } else if (i10 == 1) {
                aVar.f7586b = i14 + 1;
            } else if (i10 == 2) {
                aVar.f7586b = i14 - 1;
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            o3.a aVar2 = (o3.a) arrayList.get(size2);
            int i16 = aVar2.f7585a;
            int i17 = aVar2.f7588d;
            if (i16 == 8) {
                if (i17 == aVar2.f7586b || i17 < 0) {
                    arrayList.remove(size2);
                    aVar2.f7587c = null;
                    dVar.a(aVar2);
                }
            } else if (i17 <= 0) {
                arrayList.remove(size2);
                aVar2.f7587c = null;
                dVar.a(aVar2);
            }
        }
        return i9;
    }

    public o(View view) {
        this.f6983a = -1;
        this.f6984b = view;
        this.f6985c = t.a();
    }
}
