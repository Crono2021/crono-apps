package e0;

import android.view.View;
import com.google.android.material.sidesheet.SideSheetBehavior;
import l1.b0;
import l1.y;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class m implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f2998i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f2999j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f3000k;

    public /* synthetic */ m(int i9, int i10, Object obj) {
        this.f2998i = i10;
        this.f3000k = obj;
        this.f2999j = i9;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d1.g gVar;
        switch (this.f2998i) {
            case 0:
                ((b) this.f3000k).h(this.f2999j);
                break;
            case 1:
                l1.d dVar = ((l1.c) this.f3000k).f5807b;
                int i9 = this.f2999j;
                if (i9 != -3 && i9 != -2) {
                    if (i9 == -1) {
                        y yVar = dVar.f5814c;
                        if (yVar != null) {
                            b0 b0Var = yVar.f6065i;
                            boolean p5 = b0Var.p();
                            b0Var.v0(-1, p5 ? 2 : 1, p5);
                        }
                        dVar.a();
                        break;
                    } else if (i9 == 1) {
                        dVar.b(1);
                        y yVar2 = dVar.f5814c;
                        if (yVar2 != null) {
                            b0 b0Var2 = yVar2.f6065i;
                            b0Var2.v0(1, 1, b0Var2.p());
                            break;
                        }
                    } else {
                        androidx.activity.g.t(i9, "Unknown focus change type: ", "AudioFocusManager");
                        break;
                    }
                } else if (i9 != -2 && ((gVar = dVar.f5815d) == null || gVar.f2424a != 1)) {
                    dVar.b(3);
                    break;
                } else {
                    y yVar3 = dVar.f5814c;
                    if (yVar3 != null) {
                        b0 b0Var3 = yVar3.f6065i;
                        boolean p7 = b0Var3.p();
                        b0Var3.v0(0, p7 ? 2 : 1, p7);
                    }
                    dVar.b(2);
                    break;
                }
                break;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f3000k;
                View view = (View) sideSheetBehavior.f2119p.get();
                if (view != null) {
                    sideSheetBehavior.u(view, this.f2999j, false);
                    break;
                }
                break;
        }
    }
}
