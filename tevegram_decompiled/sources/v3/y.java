package v3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class y extends AnimatorListenerAdapter implements j {

    /* renamed from: a, reason: collision with root package name */
    public final View f9562a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9563b;

    /* renamed from: c, reason: collision with root package name */
    public final ViewGroup f9564c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f9566e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f9567f = false;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f9565d = true;

    public y(View view, int i9) {
        this.f9562a = view;
        this.f9563b = i9;
        this.f9564c = (ViewGroup) view.getParent();
        f(true);
    }

    @Override // v3.j
    public final void b(k kVar) {
        if (!this.f9567f) {
            r.f9551a.P(this.f9562a, this.f9563b);
            ViewGroup viewGroup = this.f9564c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        f(false);
        kVar.u(this);
    }

    @Override // v3.j
    public final void c() {
        f(false);
    }

    @Override // v3.j
    public final void d() {
        f(true);
    }

    public final void f(boolean z8) {
        ViewGroup viewGroup;
        if (!this.f9565d || this.f9566e == z8 || (viewGroup = this.f9564c) == null) {
            return;
        }
        this.f9566e = z8;
        com.bumptech.glide.d.d0(viewGroup, z8);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f9567f = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (!this.f9567f) {
            r.f9551a.P(this.f9562a, this.f9563b);
            ViewGroup viewGroup = this.f9564c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        f(false);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationPause(Animator animator) {
        if (this.f9567f) {
            return;
        }
        r.f9551a.P(this.f9562a, this.f9563b);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationResume(Animator animator) {
        if (this.f9567f) {
            return;
        }
        r.f9551a.P(this.f9562a, 0);
    }

    @Override // v3.j
    public final void a() {
    }

    @Override // v3.j
    public final void e() {
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
