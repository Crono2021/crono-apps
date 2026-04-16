package a5;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public abstract class j extends a0.d {

    /* renamed from: a, reason: collision with root package name */
    public k f193a;

    /* renamed from: b, reason: collision with root package name */
    public int f194b = 0;

    public j() {
    }

    @Override // a0.d
    public boolean h(CoordinatorLayout coordinatorLayout, View view, int i9) {
        t(coordinatorLayout, view, i9);
        if (this.f193a == null) {
            this.f193a = new k(view);
        }
        k kVar = this.f193a;
        View view2 = (View) kVar.f198d;
        kVar.f195a = view2.getTop();
        kVar.f196b = view2.getLeft();
        this.f193a.a();
        int i10 = this.f194b;
        if (i10 == 0) {
            return true;
        }
        k kVar2 = this.f193a;
        if (kVar2.f197c != i10) {
            kVar2.f197c = i10;
            kVar2.a();
        }
        this.f194b = 0;
        return true;
    }

    public final int s() {
        k kVar = this.f193a;
        if (kVar != null) {
            return kVar.f197c;
        }
        return 0;
    }

    public void t(CoordinatorLayout coordinatorLayout, View view, int i9) {
        coordinatorLayout.q(view, i9);
    }

    public j(int i9) {
    }
}
