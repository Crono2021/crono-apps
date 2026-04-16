package n0;

import android.view.View;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c1 {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f7146a;

    public c1(View view) {
        this.f7146a = new WeakReference(view);
    }

    public final void a(float f9) {
        View view = (View) this.f7146a.get();
        if (view != null) {
            view.animate().alpha(f9);
        }
    }

    public final void b() {
        View view = (View) this.f7146a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public final void c(long j5) {
        View view = (View) this.f7146a.get();
        if (view != null) {
            view.animate().setDuration(j5);
        }
    }

    public final void d(d1 d1Var) {
        View view = (View) this.f7146a.get();
        if (view != null) {
            if (d1Var != null) {
                view.animate().setListener(new a1(d1Var, view, 0));
            } else {
                view.animate().setListener(null);
            }
        }
    }

    public final void e(float f9) {
        View view = (View) this.f7146a.get();
        if (view != null) {
            view.animate().translationY(f9);
        }
    }
}
