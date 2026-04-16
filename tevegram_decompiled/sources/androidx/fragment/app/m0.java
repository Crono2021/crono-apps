package androidx.fragment.app;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class m0 implements View.OnAttachStateChangeListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f796i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f797j;

    public /* synthetic */ m0(Object obj, int i9) {
        this.f796i = i9;
        this.f797j = obj;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        int i9 = this.f796i;
        Object obj = this.f797j;
        switch (i9) {
            case 0:
                View view2 = (View) obj;
                view2.removeOnAttachStateChangeListener(this);
                WeakHashMap weakHashMap = n0.t0.f7209a;
                n0.g0.c(view2);
                break;
            case 1:
            case 2:
                break;
            default:
                x5.l lVar = (x5.l) obj;
                AccessibilityManager accessibilityManager = lVar.B;
                if (lVar.C != null && accessibilityManager != null) {
                    WeakHashMap weakHashMap2 = n0.t0.f7209a;
                    if (n0.f0.b(lVar)) {
                        o0.c.a(accessibilityManager, lVar.C);
                        break;
                    }
                }
                break;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        AccessibilityManager accessibilityManager;
        switch (this.f796i) {
            case 0:
                break;
            case 1:
                m.g gVar = (m.g) this.f797j;
                ViewTreeObserver viewTreeObserver = gVar.F;
                if (viewTreeObserver != null) {
                    if (!viewTreeObserver.isAlive()) {
                        gVar.F = view.getViewTreeObserver();
                    }
                    gVar.F.removeGlobalOnLayoutListener(gVar.f6410q);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
            case 2:
                m.e0 e0Var = (m.e0) this.f797j;
                ViewTreeObserver viewTreeObserver2 = e0Var.f6396w;
                if (viewTreeObserver2 != null) {
                    if (!viewTreeObserver2.isAlive()) {
                        e0Var.f6396w = view.getViewTreeObserver();
                    }
                    e0Var.f6396w.removeGlobalOnLayoutListener(e0Var.f6390q);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
            default:
                x5.l lVar = (x5.l) this.f797j;
                o0.d dVar = lVar.C;
                if (dVar != null && (accessibilityManager = lVar.B) != null) {
                    o0.c.b(accessibilityManager, dVar);
                    break;
                }
                break;
        }
    }

    private final void a(View view) {
    }

    private final void b(View view) {
    }

    private final void c(View view) {
    }
}
