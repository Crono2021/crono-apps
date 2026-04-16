package n;

import java.util.WeakHashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g2 implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f6867i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ k2 f6868j;

    public /* synthetic */ g2(k2 k2Var, int i9) {
        this.f6867i = i9;
        this.f6868j = k2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i9 = this.f6867i;
        k2 k2Var = this.f6868j;
        switch (i9) {
            case 0:
                x1 x1Var = k2Var.f6926k;
                if (x1Var != null) {
                    x1Var.setListSelectionHidden(true);
                    x1Var.requestLayout();
                    break;
                }
                break;
            default:
                x1 x1Var2 = k2Var.f6926k;
                if (x1Var2 != null) {
                    WeakHashMap weakHashMap = n0.t0.f7209a;
                    if (n0.f0.b(x1Var2) && k2Var.f6926k.getCount() > k2Var.f6926k.getChildCount() && k2Var.f6926k.getChildCount() <= k2Var.f6936u) {
                        k2Var.H.setInputMethodMode(2);
                        k2Var.c();
                        break;
                    }
                }
                break;
        }
    }
}
