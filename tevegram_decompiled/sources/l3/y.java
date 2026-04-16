package l3;

import android.view.TextureView;
import android.view.View;
import androidx.media3.ui.PlayerView;
import androidx.media3.ui.SubtitleView;
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
import d1.w0;
import d1.y0;
import java.util.List;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class y implements r0, View.OnLayoutChangeListener, View.OnClickListener, p, h {

    /* renamed from: i, reason: collision with root package name */
    public final w0 f6261i = new w0();

    /* renamed from: j, reason: collision with root package name */
    public Object f6262j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ PlayerView f6263k;

    public y(PlayerView playerView) {
        this.f6263k = playerView;
    }

    @Override // d1.r0
    public final void A(f1.c cVar) {
        SubtitleView subtitleView = this.f6263k.f1003o;
        if (subtitleView != null) {
            subtitleView.setCues(cVar.f3260a);
        }
    }

    @Override // d1.r0
    public final void B(h1 h1Var) {
        PlayerView playerView;
        t0 t0Var;
        if (h1Var.equals(h1.f2473e) || (t0Var = (playerView = this.f6263k).f1009u) == null || t0Var.t() == 1) {
            return;
        }
        playerView.h();
    }

    @Override // d1.r0
    public final void c(s0 s0Var, s0 s0Var2, int i9) {
        q qVar;
        int i10 = PlayerView.H;
        PlayerView playerView = this.f6263k;
        if (playerView.b() && playerView.E && (qVar = playerView.f1006r) != null) {
            qVar.g();
        }
    }

    @Override // d1.r0
    public final void i() {
        View view = this.f6263k.f999k;
        if (view != null) {
            view.setVisibility(4);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i9 = PlayerView.H;
        this.f6263k.g();
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        PlayerView.a((TextureView) view, this.f6263k.G);
    }

    @Override // d1.r0
    public final void p(int i9, boolean z8) {
        int i10 = PlayerView.H;
        PlayerView playerView = this.f6263k;
        playerView.i();
        if (!playerView.b() || !playerView.E) {
            playerView.c(false);
            return;
        }
        q qVar = playerView.f1006r;
        if (qVar != null) {
            qVar.g();
        }
    }

    @Override // d1.r0
    public final void r(f1 f1Var) {
        PlayerView playerView = this.f6263k;
        t0 t0Var = playerView.f1009u;
        t0Var.getClass();
        y0 U = t0Var.J(17) ? t0Var.U() : y0.f2610a;
        if (U.p()) {
            this.f6262j = null;
        } else {
            boolean J = t0Var.J(30);
            w0 w0Var = this.f6261i;
            if (!J || t0Var.v().f2422a.isEmpty()) {
                Object obj = this.f6262j;
                if (obj != null) {
                    int b9 = U.b(obj);
                    if (b9 != -1) {
                        if (t0Var.I() == U.f(b9, w0Var, false).f2586c) {
                            return;
                        }
                    }
                    this.f6262j = null;
                }
            } else {
                this.f6262j = U.f(t0Var.A(), w0Var, true).f2585b;
            }
        }
        playerView.l(false);
    }

    @Override // d1.r0
    public final void s(int i9) {
        int i10 = PlayerView.H;
        PlayerView playerView = this.f6263k;
        playerView.i();
        playerView.k();
        if (!playerView.b() || !playerView.E) {
            playerView.c(false);
            return;
        }
        q qVar = playerView.f1006r;
        if (qVar != null) {
            qVar.g();
        }
    }

    @Override // d1.r0
    public final /* synthetic */ void D(q0 q0Var) {
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
    public final /* synthetic */ void x(int i9, int i10) {
    }
}
