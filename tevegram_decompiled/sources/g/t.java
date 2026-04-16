package g;

import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import java.util.WeakHashMap;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class t extends com.bumptech.glide.c {

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f3632p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f3633q;

    public /* synthetic */ t(Object obj, int i9) {
        this.f3632p = i9;
        this.f3633q = obj;
    }

    @Override // n0.d1
    public final void a() {
        int i9 = this.f3632p;
        Object obj = this.f3633q;
        switch (i9) {
            case 0:
                c0 c0Var = ((r) obj).f3629j;
                c0Var.D.setAlpha(1.0f);
                c0Var.G.d(null);
                c0Var.G = null;
                break;
            case 1:
                c0 c0Var2 = (c0) obj;
                c0Var2.D.setAlpha(1.0f);
                c0Var2.G.d(null);
                c0Var2.G = null;
                break;
            default:
                c0 c0Var3 = (c0) ((a5.d) obj).f175k;
                c0Var3.D.setVisibility(8);
                PopupWindow popupWindow = c0Var3.E;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (c0Var3.D.getParent() instanceof View) {
                    View view = (View) c0Var3.D.getParent();
                    WeakHashMap weakHashMap = t0.f7209a;
                    n0.g0.c(view);
                }
                c0Var3.D.e();
                c0Var3.G.d(null);
                c0Var3.G = null;
                ViewGroup viewGroup = c0Var3.I;
                WeakHashMap weakHashMap2 = t0.f7209a;
                n0.g0.c(viewGroup);
                break;
        }
    }

    @Override // com.bumptech.glide.c, n0.d1
    public void c() {
        int i9 = this.f3632p;
        Object obj = this.f3633q;
        switch (i9) {
            case 0:
                ((r) obj).f3629j.D.setVisibility(0);
                break;
            case 1:
                c0 c0Var = (c0) obj;
                c0Var.D.setVisibility(0);
                if (c0Var.D.getParent() instanceof View) {
                    View view = (View) c0Var.D.getParent();
                    WeakHashMap weakHashMap = t0.f7209a;
                    n0.g0.c(view);
                    break;
                }
                break;
        }
    }
}
