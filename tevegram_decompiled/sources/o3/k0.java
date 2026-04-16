package o3;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class k0 {

    /* renamed from: a, reason: collision with root package name */
    public f0 f7703a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f7704b;

    /* renamed from: c, reason: collision with root package name */
    public long f7705c;

    /* renamed from: d, reason: collision with root package name */
    public long f7706d;

    /* renamed from: e, reason: collision with root package name */
    public long f7707e;

    /* renamed from: f, reason: collision with root package name */
    public long f7708f;

    public static void b(d1 d1Var) {
        RecyclerView recyclerView;
        int i9 = d1Var.f7626j;
        if (d1Var.f() || (i9 & 4) != 0 || (recyclerView = d1Var.f7634r) == null) {
            return;
        }
        recyclerView.G(d1Var);
    }

    public abstract boolean a(d1 d1Var, d1 d1Var2, d1.k0 k0Var, d1.k0 k0Var2);

    public final void c(d1 d1Var) {
        f0 f0Var = this.f7703a;
        if (f0Var != null) {
            RecyclerView recyclerView = f0Var.f7650a;
            boolean z8 = true;
            d1Var.n(true);
            View view = d1Var.f7618a;
            if (d1Var.h != null && d1Var.f7625i == null) {
                d1Var.h = null;
            }
            d1Var.f7625i = null;
            if ((d1Var.f7626j & 16) != 0) {
                return;
            }
            l7.a aVar = recyclerView.f1058k;
            recyclerView.g0();
            androidx.fragment.app.g gVar = recyclerView.f1064n;
            b2.d0 d0Var = (b2.d0) gVar.f729k;
            f0 f0Var2 = (f0) gVar.f728j;
            int indexOfChild = f0Var2.f7650a.indexOfChild(view);
            if (indexOfChild == -1) {
                gVar.m0(view);
            } else if (d0Var.u(indexOfChild)) {
                d0Var.w(indexOfChild);
                gVar.m0(view);
                f0Var2.h(indexOfChild);
            } else {
                z8 = false;
            }
            if (z8) {
                d1 J = RecyclerView.J(view);
                aVar.l(J);
                aVar.i(J);
            }
            recyclerView.h0(!z8);
            if (z8 || !d1Var.j()) {
                return;
            }
            recyclerView.removeDetachedView(view, false);
        }
    }

    public abstract void d(d1 d1Var);

    public abstract void e();

    public abstract boolean f();
}
