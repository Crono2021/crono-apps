package n;

import androidx.appcompat.widget.Toolbar;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class q3 implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f7014i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Toolbar f7015j;

    public /* synthetic */ q3(Toolbar toolbar, int i9) {
        this.f7014i = i9;
        this.f7015j = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7014i) {
            case 0:
                t3 t3Var = this.f7015j.U;
                m.o oVar = t3Var == null ? null : t3Var.f7058j;
                if (oVar != null) {
                    oVar.collapseActionView();
                    break;
                }
                break;
            default:
                this.f7015j.n();
                break;
        }
    }
}
