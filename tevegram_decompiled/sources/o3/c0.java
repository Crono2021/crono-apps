package o3;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c0 extends q0 {

    /* renamed from: a, reason: collision with root package name */
    public RecyclerView f7599a;

    /* renamed from: b, reason: collision with root package name */
    public final g1 f7600b = new g1(this);

    /* renamed from: c, reason: collision with root package name */
    public a0 f7601c;

    /* renamed from: d, reason: collision with root package name */
    public a0 f7602d;

    public static int b(View view, androidx.emoji2.text.h hVar) {
        return ((hVar.c(view) / 2) + hVar.e(view)) - ((hVar.l() / 2) + hVar.k());
    }

    public static View c(o0 o0Var, androidx.emoji2.text.h hVar) {
        int v8 = o0Var.v();
        View view = null;
        if (v8 == 0) {
            return null;
        }
        int l4 = (hVar.l() / 2) + hVar.k();
        int i9 = Integer.MAX_VALUE;
        for (int i10 = 0; i10 < v8; i10++) {
            View u3 = o0Var.u(i10);
            int abs = Math.abs(((hVar.c(u3) / 2) + hVar.e(u3)) - l4);
            if (abs < i9) {
                view = u3;
                i9 = abs;
            }
        }
        return view;
    }

    public final int[] a(o0 o0Var, View view) {
        int[] iArr = new int[2];
        if (o0Var.d()) {
            iArr[0] = b(view, d(o0Var));
        } else {
            iArr[0] = 0;
        }
        if (o0Var.e()) {
            iArr[1] = b(view, e(o0Var));
            return iArr;
        }
        iArr[1] = 0;
        return iArr;
    }

    public final androidx.emoji2.text.h d(o0 o0Var) {
        a0 a0Var = this.f7602d;
        if (a0Var == null || ((o0) a0Var.f618b) != o0Var) {
            this.f7602d = new a0(o0Var, 0);
        }
        return this.f7602d;
    }

    public final androidx.emoji2.text.h e(o0 o0Var) {
        a0 a0Var = this.f7601c;
        if (a0Var == null || ((o0) a0Var.f618b) != o0Var) {
            this.f7601c = new a0(o0Var, 1);
        }
        return this.f7601c;
    }

    public final void f() {
        o0 layoutManager;
        RecyclerView recyclerView = this.f7599a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
            return;
        }
        View c9 = layoutManager.e() ? c(layoutManager, e(layoutManager)) : layoutManager.d() ? c(layoutManager, d(layoutManager)) : null;
        if (c9 == null) {
            return;
        }
        int[] a9 = a(layoutManager, c9);
        int i9 = a9[0];
        if (i9 == 0 && a9[1] == 0) {
            return;
        }
        this.f7599a.f0(i9, a9[1], false);
    }
}
