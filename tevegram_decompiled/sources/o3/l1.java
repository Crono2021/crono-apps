package o3;

import android.view.View;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l1 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f7722a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public int f7723b = Integer.MIN_VALUE;

    /* renamed from: c, reason: collision with root package name */
    public int f7724c = Integer.MIN_VALUE;

    /* renamed from: d, reason: collision with root package name */
    public int f7725d = 0;

    /* renamed from: e, reason: collision with root package name */
    public final int f7726e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ StaggeredGridLayoutManager f7727f;

    public l1(StaggeredGridLayoutManager staggeredGridLayoutManager, int i9) {
        this.f7727f = staggeredGridLayoutManager;
        this.f7726e = i9;
    }

    public final void a() {
        View view = (View) this.f7722a.get(r0.size() - 1);
        i1 i1Var = (i1) view.getLayoutParams();
        this.f7724c = this.f7727f.f1092r.b(view);
        i1Var.getClass();
    }

    public final void b() {
        this.f7722a.clear();
        this.f7723b = Integer.MIN_VALUE;
        this.f7724c = Integer.MIN_VALUE;
        this.f7725d = 0;
    }

    public final int c() {
        return this.f7727f.f1097w ? e(r1.size() - 1, -1) : e(0, this.f7722a.size());
    }

    public final int d() {
        return this.f7727f.f1097w ? e(0, this.f7722a.size()) : e(r1.size() - 1, -1);
    }

    public final int e(int i9, int i10) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = this.f7727f;
        int k3 = staggeredGridLayoutManager.f1092r.k();
        int g9 = staggeredGridLayoutManager.f1092r.g();
        int i11 = i10 > i9 ? 1 : -1;
        while (i9 != i10) {
            View view = (View) this.f7722a.get(i9);
            int e9 = staggeredGridLayoutManager.f1092r.e(view);
            int b9 = staggeredGridLayoutManager.f1092r.b(view);
            boolean z8 = e9 <= g9;
            boolean z9 = b9 >= k3;
            if (z8 && z9 && (e9 < k3 || b9 > g9)) {
                return o0.F(view);
            }
            i9 += i11;
        }
        return -1;
    }

    public final int f(int i9) {
        int i10 = this.f7724c;
        if (i10 != Integer.MIN_VALUE) {
            return i10;
        }
        if (this.f7722a.size() == 0) {
            return i9;
        }
        a();
        return this.f7724c;
    }

    public final View g(int i9, int i10) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = this.f7727f;
        View view = null;
        ArrayList arrayList = this.f7722a;
        if (i10 != -1) {
            int size = arrayList.size() - 1;
            while (size >= 0) {
                View view2 = (View) arrayList.get(size);
                if ((staggeredGridLayoutManager.f1097w && o0.F(view2) >= i9) || ((!staggeredGridLayoutManager.f1097w && o0.F(view2) <= i9) || !view2.hasFocusable())) {
                    break;
                }
                size--;
                view = view2;
            }
            return view;
        }
        int size2 = arrayList.size();
        int i11 = 0;
        while (i11 < size2) {
            View view3 = (View) arrayList.get(i11);
            if ((staggeredGridLayoutManager.f1097w && o0.F(view3) <= i9) || ((!staggeredGridLayoutManager.f1097w && o0.F(view3) >= i9) || !view3.hasFocusable())) {
                break;
            }
            i11++;
            view = view3;
        }
        return view;
    }

    public final int h(int i9) {
        int i10 = this.f7723b;
        if (i10 != Integer.MIN_VALUE) {
            return i10;
        }
        ArrayList arrayList = this.f7722a;
        if (arrayList.size() == 0) {
            return i9;
        }
        View view = (View) arrayList.get(0);
        i1 i1Var = (i1) view.getLayoutParams();
        this.f7723b = this.f7727f.f1092r.e(view);
        i1Var.getClass();
        return this.f7723b;
    }
}
