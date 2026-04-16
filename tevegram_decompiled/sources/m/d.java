package m;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.WeakHashMap;
import n.j0;
import n.k0;
import n.q0;
import n.q2;
import n.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f6377i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f6378j;

    public /* synthetic */ d(Object obj, int i9) {
        this.f6377i = i9;
        this.f6378j = obj;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int i9 = this.f6377i;
        Object obj = this.f6378j;
        switch (i9) {
            case 0:
                g gVar = (g) obj;
                ArrayList arrayList = gVar.f6409p;
                if (gVar.b() && arrayList.size() > 0) {
                    int i10 = 0;
                    if (!((f) arrayList.get(0)).f6400a.G) {
                        View view = gVar.f6416w;
                        if (view != null && view.isShown()) {
                            int size = arrayList.size();
                            while (i10 < size) {
                                Object obj2 = arrayList.get(i10);
                                i10++;
                                ((f) obj2).f6400a.c();
                            }
                            break;
                        } else {
                            gVar.dismiss();
                            break;
                        }
                    }
                }
                break;
            case 1:
                e0 e0Var = (e0) obj;
                q2 q2Var = e0Var.f6389p;
                if (e0Var.b() && !q2Var.G) {
                    View view2 = e0Var.f6394u;
                    if (view2 != null && view2.isShown()) {
                        q2Var.c();
                        break;
                    } else {
                        e0Var.dismiss();
                        break;
                    }
                }
                break;
            case 2:
                t0 t0Var = (t0) obj;
                if (!t0Var.getInternalPopup().b()) {
                    t0Var.f7041n.l(k0.b(t0Var), k0.a(t0Var));
                }
                ViewTreeObserver viewTreeObserver = t0Var.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    j0.a(viewTreeObserver, this);
                    break;
                }
                break;
            default:
                q0 q0Var = (q0) obj;
                t0 t0Var2 = q0Var.P;
                WeakHashMap weakHashMap = n0.t0.f7209a;
                if (!n0.f0.b(t0Var2) || !t0Var2.getGlobalVisibleRect(q0Var.N)) {
                    q0Var.dismiss();
                    break;
                } else {
                    q0Var.s();
                    q0Var.c();
                    break;
                }
                break;
        }
    }
}
