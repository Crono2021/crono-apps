package n;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class p0 implements PopupWindow.OnDismissListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ m.d f6998i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ q0 f6999j;

    public p0(q0 q0Var, m.d dVar) {
        this.f6999j = q0Var;
        this.f6998i = dVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        ViewTreeObserver viewTreeObserver = this.f6999j.P.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f6998i);
        }
    }
}
