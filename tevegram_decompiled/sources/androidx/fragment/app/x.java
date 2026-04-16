package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class x implements View.OnAttachStateChangeListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ n0 f881i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ y f882j;

    public x(y yVar, n0 n0Var) {
        this.f882j = yVar;
        this.f881i = n0Var;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        n0 n0Var = this.f881i;
        s sVar = n0Var.f802c;
        n0Var.k();
        k.f((ViewGroup) sVar.M.getParent(), this.f882j.f883i.B()).e();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
