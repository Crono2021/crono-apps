package n0;

import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class u implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: i, reason: collision with root package name */
    public final View f7217i;

    /* renamed from: j, reason: collision with root package name */
    public ViewTreeObserver f7218j;

    /* renamed from: k, reason: collision with root package name */
    public final Runnable f7219k;

    public u(View view, Runnable runnable) {
        this.f7217i = view;
        this.f7218j = view.getViewTreeObserver();
        this.f7219k = runnable;
    }

    public static void a(View view, Runnable runnable) {
        if (view == null) {
            m7.c.o("view == null");
            return;
        }
        u uVar = new u(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(uVar);
        view.addOnAttachStateChangeListener(uVar);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        boolean isAlive = this.f7218j.isAlive();
        View view = this.f7217i;
        if (isAlive) {
            this.f7218j.removeOnPreDrawListener(this);
        } else {
            view.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view.removeOnAttachStateChangeListener(this);
        this.f7219k.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.f7218j = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        boolean isAlive = this.f7218j.isAlive();
        View view2 = this.f7217i;
        if (isAlive) {
            this.f7218j.removeOnPreDrawListener(this);
        } else {
            view2.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view2.removeOnAttachStateChangeListener(this);
    }
}
