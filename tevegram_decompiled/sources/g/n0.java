package g;

import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import java.util.WeakHashMap;
import n0.t0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class n0 extends com.bumptech.glide.c {

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f3587p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ p0 f3588q;

    public /* synthetic */ n0(p0 p0Var, int i9) {
        this.f3587p = i9;
        this.f3588q = p0Var;
    }

    @Override // n0.d1
    public final void a() {
        View view;
        int i9 = this.f3587p;
        p0 p0Var = this.f3588q;
        switch (i9) {
            case 0:
                if (p0Var.f3609o && (view = p0Var.f3602g) != null) {
                    view.setTranslationY(0.0f);
                    p0Var.f3599d.setTranslationY(0.0f);
                }
                p0Var.f3599d.setVisibility(8);
                p0Var.f3599d.setTransitioning(false);
                p0Var.f3613s = null;
                a5.d dVar = p0Var.f3605k;
                if (dVar != null) {
                    dVar.O0(p0Var.f3604j);
                    p0Var.f3604j = null;
                    p0Var.f3605k = null;
                }
                ActionBarOverlayLayout actionBarOverlayLayout = p0Var.f3598c;
                if (actionBarOverlayLayout != null) {
                    WeakHashMap weakHashMap = t0.f7209a;
                    n0.g0.c(actionBarOverlayLayout);
                    break;
                }
                break;
            default:
                p0Var.f3613s = null;
                p0Var.f3599d.requestLayout();
                break;
        }
    }
}
