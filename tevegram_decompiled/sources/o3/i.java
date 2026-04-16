package o3;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class i extends k0 {

    /* renamed from: s, reason: collision with root package name */
    public static TimeInterpolator f7676s;

    /* renamed from: g, reason: collision with root package name */
    public boolean f7677g;
    public ArrayList h;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList f7678i;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f7679j;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f7680k;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f7681l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f7682m;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f7683n;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList f7684o;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList f7685p;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList f7686q;

    /* renamed from: r, reason: collision with root package name */
    public ArrayList f7687r;

    public static void h(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((d1) arrayList.get(size)).f7618a.animate().cancel();
        }
    }

    @Override // o3.k0
    public final boolean a(d1 d1Var, d1 d1Var2, d1.k0 k0Var, d1.k0 k0Var2) {
        int i9;
        int i10;
        int i11 = k0Var.f2492a;
        int i12 = k0Var.f2493b;
        if (d1Var2.o()) {
            int i13 = k0Var.f2492a;
            i10 = k0Var.f2493b;
            i9 = i13;
        } else {
            i9 = k0Var2.f2492a;
            i10 = k0Var2.f2493b;
        }
        if (d1Var == d1Var2) {
            return g(d1Var, i11, i12, i9, i10);
        }
        View view = d1Var.f7618a;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        float alpha = view.getAlpha();
        l(d1Var);
        view.setTranslationX(translationX);
        view.setTranslationY(translationY);
        view.setAlpha(alpha);
        View view2 = d1Var2.f7618a;
        l(d1Var2);
        view2.setTranslationX(-((int) ((i9 - i11) - translationX)));
        view2.setTranslationY(-((int) ((i10 - i12) - translationY)));
        view2.setAlpha(0.0f);
        ArrayList arrayList = this.f7680k;
        g gVar = new g();
        gVar.f7653a = d1Var;
        gVar.f7654b = d1Var2;
        gVar.f7655c = i11;
        gVar.f7656d = i12;
        gVar.f7657e = i9;
        gVar.f7658f = i10;
        arrayList.add(gVar);
        return true;
    }

    @Override // o3.k0
    public final void d(d1 d1Var) {
        ArrayList arrayList = this.f7681l;
        ArrayList arrayList2 = this.f7682m;
        ArrayList arrayList3 = this.f7683n;
        View view = d1Var.f7618a;
        view.animate().cancel();
        ArrayList arrayList4 = this.f7679j;
        int size = arrayList4.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (((h) arrayList4.get(size)).f7664a == d1Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                c(d1Var);
                arrayList4.remove(size);
            }
        }
        j(this.f7680k, d1Var);
        if (this.h.remove(d1Var)) {
            view.setAlpha(1.0f);
            c(d1Var);
        }
        if (this.f7678i.remove(d1Var)) {
            view.setAlpha(1.0f);
            c(d1Var);
        }
        for (int size2 = arrayList3.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList5 = (ArrayList) arrayList3.get(size2);
            j(arrayList5, d1Var);
            if (arrayList5.isEmpty()) {
                arrayList3.remove(size2);
            }
        }
        for (int size3 = arrayList2.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList6 = (ArrayList) arrayList2.get(size3);
            int size4 = arrayList6.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (((h) arrayList6.get(size4)).f7664a == d1Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    c(d1Var);
                    arrayList6.remove(size4);
                    if (arrayList6.isEmpty()) {
                        arrayList2.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = arrayList.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList7 = (ArrayList) arrayList.get(size5);
            if (arrayList7.remove(d1Var)) {
                view.setAlpha(1.0f);
                c(d1Var);
                if (arrayList7.isEmpty()) {
                    arrayList.remove(size5);
                }
            }
        }
        this.f7686q.remove(d1Var);
        this.f7684o.remove(d1Var);
        this.f7687r.remove(d1Var);
        this.f7685p.remove(d1Var);
        i();
    }

    @Override // o3.k0
    public final void e() {
        ArrayList arrayList = this.f7680k;
        ArrayList arrayList2 = this.f7683n;
        ArrayList arrayList3 = this.f7681l;
        ArrayList arrayList4 = this.f7682m;
        ArrayList arrayList5 = this.f7678i;
        ArrayList arrayList6 = this.h;
        ArrayList arrayList7 = this.f7679j;
        int size = arrayList7.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            h hVar = (h) arrayList7.get(size);
            View view = hVar.f7664a.f7618a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            c(hVar.f7664a);
            arrayList7.remove(size);
        }
        for (int size2 = arrayList6.size() - 1; size2 >= 0; size2--) {
            c((d1) arrayList6.get(size2));
            arrayList6.remove(size2);
        }
        int size3 = arrayList5.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            d1 d1Var = (d1) arrayList5.get(size3);
            d1Var.f7618a.setAlpha(1.0f);
            c(d1Var);
            arrayList5.remove(size3);
        }
        for (int size4 = arrayList.size() - 1; size4 >= 0; size4--) {
            g gVar = (g) arrayList.get(size4);
            d1 d1Var2 = gVar.f7653a;
            if (d1Var2 != null) {
                k(gVar, d1Var2);
            }
            d1 d1Var3 = gVar.f7654b;
            if (d1Var3 != null) {
                k(gVar, d1Var3);
            }
        }
        arrayList.clear();
        if (f()) {
            for (int size5 = arrayList4.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList8 = (ArrayList) arrayList4.get(size5);
                for (int size6 = arrayList8.size() - 1; size6 >= 0; size6--) {
                    h hVar2 = (h) arrayList8.get(size6);
                    View view2 = hVar2.f7664a.f7618a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    c(hVar2.f7664a);
                    arrayList8.remove(size6);
                    if (arrayList8.isEmpty()) {
                        arrayList4.remove(arrayList8);
                    }
                }
            }
            for (int size7 = arrayList3.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList9 = (ArrayList) arrayList3.get(size7);
                for (int size8 = arrayList9.size() - 1; size8 >= 0; size8--) {
                    d1 d1Var4 = (d1) arrayList9.get(size8);
                    d1Var4.f7618a.setAlpha(1.0f);
                    c(d1Var4);
                    arrayList9.remove(size8);
                    if (arrayList9.isEmpty()) {
                        arrayList3.remove(arrayList9);
                    }
                }
            }
            for (int size9 = arrayList2.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList10 = (ArrayList) arrayList2.get(size9);
                for (int size10 = arrayList10.size() - 1; size10 >= 0; size10--) {
                    g gVar2 = (g) arrayList10.get(size10);
                    d1 d1Var5 = gVar2.f7653a;
                    if (d1Var5 != null) {
                        k(gVar2, d1Var5);
                    }
                    d1 d1Var6 = gVar2.f7654b;
                    if (d1Var6 != null) {
                        k(gVar2, d1Var6);
                    }
                    if (arrayList10.isEmpty()) {
                        arrayList2.remove(arrayList10);
                    }
                }
            }
            h(this.f7686q);
            h(this.f7685p);
            h(this.f7684o);
            h(this.f7687r);
            ArrayList arrayList11 = this.f7704b;
            if (arrayList11.size() <= 0) {
                arrayList11.clear();
            } else {
                arrayList11.get(0).getClass();
                androidx.fragment.app.a.c();
            }
        }
    }

    @Override // o3.k0
    public final boolean f() {
        return (this.f7678i.isEmpty() && this.f7680k.isEmpty() && this.f7679j.isEmpty() && this.h.isEmpty() && this.f7685p.isEmpty() && this.f7686q.isEmpty() && this.f7684o.isEmpty() && this.f7687r.isEmpty() && this.f7682m.isEmpty() && this.f7681l.isEmpty() && this.f7683n.isEmpty()) ? false : true;
    }

    public final boolean g(d1 d1Var, int i9, int i10, int i11, int i12) {
        View view = d1Var.f7618a;
        int translationX = i9 + ((int) view.getTranslationX());
        int translationY = i10 + ((int) d1Var.f7618a.getTranslationY());
        l(d1Var);
        int i13 = i11 - translationX;
        int i14 = i12 - translationY;
        if (i13 == 0 && i14 == 0) {
            c(d1Var);
            return false;
        }
        if (i13 != 0) {
            view.setTranslationX(-i13);
        }
        if (i14 != 0) {
            view.setTranslationY(-i14);
        }
        ArrayList arrayList = this.f7679j;
        h hVar = new h();
        hVar.f7664a = d1Var;
        hVar.f7665b = translationX;
        hVar.f7666c = translationY;
        hVar.f7667d = i11;
        hVar.f7668e = i12;
        arrayList.add(hVar);
        return true;
    }

    public final void i() {
        if (f()) {
            return;
        }
        ArrayList arrayList = this.f7704b;
        if (arrayList.size() <= 0) {
            arrayList.clear();
        } else {
            arrayList.get(0).getClass();
            androidx.fragment.app.a.c();
        }
    }

    public final void j(ArrayList arrayList, d1 d1Var) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            g gVar = (g) arrayList.get(size);
            if (k(gVar, d1Var) && gVar.f7653a == null && gVar.f7654b == null) {
                arrayList.remove(gVar);
            }
        }
    }

    public final boolean k(g gVar, d1 d1Var) {
        if (gVar.f7654b == d1Var) {
            gVar.f7654b = null;
        } else {
            if (gVar.f7653a != d1Var) {
                return false;
            }
            gVar.f7653a = null;
        }
        View view = d1Var.f7618a;
        View view2 = d1Var.f7618a;
        view.setAlpha(1.0f);
        view2.setTranslationX(0.0f);
        view2.setTranslationY(0.0f);
        c(d1Var);
        return true;
    }

    public final void l(d1 d1Var) {
        if (f7676s == null) {
            f7676s = new ValueAnimator().getInterpolator();
        }
        d1Var.f7618a.animate().setInterpolator(f7676s);
        d(d1Var);
    }
}
