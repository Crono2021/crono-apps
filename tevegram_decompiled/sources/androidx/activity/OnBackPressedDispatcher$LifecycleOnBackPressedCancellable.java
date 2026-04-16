package androidx.activity;

import androidx.fragment.app.a0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
final class OnBackPressedDispatcher$LifecycleOnBackPressedCancellable implements androidx.lifecycle.q, c {

    /* renamed from: i, reason: collision with root package name */
    public final androidx.lifecycle.u f274i;

    /* renamed from: j, reason: collision with root package name */
    public final a0 f275j;

    /* renamed from: k, reason: collision with root package name */
    public v f276k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ x f277l;

    public OnBackPressedDispatcher$LifecycleOnBackPressedCancellable(x xVar, androidx.lifecycle.u uVar, a0 a0Var) {
        a0Var.getClass();
        this.f277l = xVar;
        this.f274i = uVar;
        this.f275j = a0Var;
        uVar.a(this);
    }

    @Override // androidx.lifecycle.q
    public final void a(androidx.lifecycle.s sVar, androidx.lifecycle.l lVar) {
        if (lVar != androidx.lifecycle.l.ON_START) {
            if (lVar != androidx.lifecycle.l.ON_STOP) {
                if (lVar == androidx.lifecycle.l.ON_DESTROY) {
                    cancel();
                    return;
                }
                return;
            } else {
                v vVar = this.f276k;
                if (vVar != null) {
                    vVar.cancel();
                    return;
                }
                return;
            }
        }
        x xVar = this.f277l;
        xVar.getClass();
        a0 a0Var = this.f275j;
        a0Var.getClass();
        xVar.f355b.addLast(a0Var);
        v vVar2 = new v(xVar, a0Var);
        a0Var.f675b.add(vVar2);
        xVar.d();
        a0Var.f676c = new w(0, xVar, x.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0, 0, 1);
        this.f276k = vVar2;
    }

    @Override // androidx.activity.c
    public final void cancel() {
        this.f274i.f(this);
        a0 a0Var = this.f275j;
        a0Var.getClass();
        a0Var.f675b.remove(this);
        v vVar = this.f276k;
        if (vVar != null) {
            vVar.cancel();
        }
        this.f276k = null;
    }
}
