package l3;

import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import d1.d1;
import d1.f1;
import d1.h1;
import d1.n0;
import d1.o0;
import d1.p0;
import d1.q0;
import d1.r0;
import d1.s0;
import d1.t0;
import d1.y0;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g implements r0, View.OnClickListener, PopupWindow.OnDismissListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ q f6155i;

    public g(q qVar) {
        this.f6155i = qVar;
    }

    @Override // d1.r0
    public final void D(q0 q0Var) {
        boolean a9 = q0Var.a(4, 5, 13);
        q qVar = this.f6155i;
        if (a9) {
            qVar.m();
        }
        if (q0Var.a(4, 5, 7, 13)) {
            qVar.o();
        }
        if (q0Var.a(8, 13)) {
            qVar.p();
        }
        if (q0Var.a(9, 13)) {
            qVar.r();
        }
        if (q0Var.a(8, 9, 11, 0, 16, 17, 13)) {
            qVar.l();
        }
        if (q0Var.a(11, 0, 13)) {
            qVar.s();
        }
        if (q0Var.a(12, 13)) {
            qVar.n();
        }
        if (q0Var.a(2, 13)) {
            qVar.t();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        q qVar = this.f6155i;
        ImageView imageView = qVar.E;
        View view2 = qVar.J;
        View view3 = qVar.I;
        View view4 = qVar.H;
        v vVar = qVar.f6192i;
        t0 t0Var = qVar.f6206p0;
        if (t0Var == null) {
            return;
        }
        vVar.g();
        if (qVar.f6217v == view) {
            if (t0Var.J(9)) {
                t0Var.c0();
                return;
            }
            return;
        }
        if (qVar.f6215u == view) {
            if (t0Var.J(7)) {
                t0Var.j0();
                return;
            }
            return;
        }
        if (qVar.f6221x == view) {
            if (t0Var.t() == 4 || !t0Var.J(12)) {
                return;
            }
            t0Var.d0();
            return;
        }
        if (qVar.f6223y == view) {
            if (t0Var.J(11)) {
                t0Var.g0();
                return;
            }
            return;
        }
        if (qVar.f6219w == view) {
            if (g1.w.U(t0Var, qVar.f6216u0)) {
                g1.w.E(t0Var);
                return;
            } else {
                if (t0Var.J(1)) {
                    t0Var.pause();
                    return;
                }
                return;
            }
        }
        if (qVar.B == view) {
            if (t0Var.J(15)) {
                int S = t0Var.S();
                int i9 = qVar.f6226z0;
                for (int i10 = 1; i10 <= 2; i10++) {
                    int i11 = (S + i10) % 3;
                    if (i11 != 0) {
                        if (i11 != 1) {
                            if (i11 == 2 && (i9 & 2) != 0) {
                            }
                        } else if ((i9 & 1) == 0) {
                        }
                    }
                    S = i11;
                }
                t0Var.M(S);
                return;
            }
            return;
        }
        if (qVar.C == view) {
            if (t0Var.J(14)) {
                t0Var.r(!t0Var.X());
                return;
            }
            return;
        }
        if (view4 == view) {
            vVar.f();
            qVar.e(qVar.f6201n, view4);
            return;
        }
        if (view3 == view) {
            vVar.f();
            qVar.e(qVar.f6203o, view3);
        } else if (view2 == view) {
            vVar.f();
            qVar.e(qVar.f6207q, view2);
        } else if (imageView == view) {
            vVar.f();
            qVar.e(qVar.f6205p, imageView);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        q qVar = this.f6155i;
        if (qVar.F0) {
            qVar.f6192i.g();
        }
    }

    @Override // d1.r0
    public final /* synthetic */ void i() {
    }

    @Override // d1.r0
    public final /* synthetic */ void A(f1.c cVar) {
    }

    @Override // d1.r0
    public final /* synthetic */ void B(h1 h1Var) {
    }

    @Override // d1.r0
    public final /* synthetic */ void F(boolean z8) {
    }

    @Override // d1.r0
    public final /* synthetic */ void a(int i9) {
    }

    @Override // d1.r0
    public final /* synthetic */ void b(p0 p0Var) {
    }

    @Override // d1.r0
    public final /* synthetic */ void d(boolean z8) {
    }

    @Override // d1.r0
    public final /* synthetic */ void e(int i9) {
    }

    @Override // d1.r0
    public final /* synthetic */ void f(n0 n0Var) {
    }

    @Override // d1.r0
    public final /* synthetic */ void g(int i9) {
    }

    @Override // d1.r0
    public final /* synthetic */ void h(boolean z8) {
    }

    @Override // d1.r0
    public final /* synthetic */ void j(d1.h0 h0Var) {
    }

    @Override // d1.r0
    public final /* synthetic */ void k(boolean z8) {
    }

    @Override // d1.r0
    public final /* synthetic */ void l(List list) {
    }

    @Override // d1.r0
    public final /* synthetic */ void q(float f9) {
    }

    @Override // d1.r0
    public final /* synthetic */ void r(f1 f1Var) {
    }

    @Override // d1.r0
    public final /* synthetic */ void s(int i9) {
    }

    @Override // d1.r0
    public final /* synthetic */ void t(o0 o0Var) {
    }

    @Override // d1.r0
    public final /* synthetic */ void u(n0 n0Var) {
    }

    @Override // d1.r0
    public final /* synthetic */ void v(d1 d1Var) {
    }

    @Override // d1.r0
    public final /* synthetic */ void w(boolean z8) {
    }

    @Override // d1.r0
    public final /* synthetic */ void z(d1.j0 j0Var) {
    }

    @Override // d1.r0
    public final /* synthetic */ void C(d1.e0 e0Var, int i9) {
    }

    @Override // d1.r0
    public final /* synthetic */ void E(y0 y0Var, int i9) {
    }

    @Override // d1.r0
    public final /* synthetic */ void n(int i9, boolean z8) {
    }

    @Override // d1.r0
    public final /* synthetic */ void p(int i9, boolean z8) {
    }

    @Override // d1.r0
    public final /* synthetic */ void x(int i9, int i10) {
    }

    @Override // d1.r0
    public final /* synthetic */ void c(s0 s0Var, s0 s0Var2, int i9) {
    }
}
