package g;

import android.view.ViewGroup;
import java.util.WeakHashMap;
import n0.c1;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class r implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f3628i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ c0 f3629j;

    public /* synthetic */ r(c0 c0Var, int i9) {
        this.f3628i = i9;
        this.f3629j = c0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewGroup viewGroup;
        int i9 = this.f3628i;
        c0 c0Var = this.f3629j;
        switch (i9) {
            case 0:
                if ((c0Var.f3480h0 & 1) != 0) {
                    c0Var.v(0);
                }
                if ((c0Var.f3480h0 & 4096) != 0) {
                    c0Var.v(108);
                }
                c0Var.f3479g0 = false;
                c0Var.f3480h0 = 0;
                break;
            default:
                c0Var.E.showAtLocation(c0Var.D, 55, 0, 0);
                c1 c1Var = c0Var.G;
                if (c1Var != null) {
                    c1Var.b();
                }
                if (c0Var.H && (viewGroup = c0Var.I) != null) {
                    WeakHashMap weakHashMap = t0.f7209a;
                    if (n0.f0.c(viewGroup)) {
                        c0Var.D.setAlpha(0.0f);
                        c1 a9 = t0.a(c0Var.D);
                        a9.a(1.0f);
                        c0Var.G = a9;
                        a9.d(new t(this, 0));
                        break;
                    }
                }
                c0Var.D.setAlpha(1.0f);
                c0Var.D.setVisibility(0);
                break;
        }
    }
}
