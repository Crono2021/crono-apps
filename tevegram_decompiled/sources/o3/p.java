package o3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class p extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7762a = 1;

    /* renamed from: b, reason: collision with root package name */
    public boolean f7763b = false;

    /* renamed from: c, reason: collision with root package name */
    public final Object f7764c;

    public p(View view) {
        this.f7764c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f7762a) {
            case 0:
                this.f7763b = true;
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f7762a) {
            case 0:
                q qVar = (q) this.f7764c;
                if (!this.f7763b) {
                    if (((Float) qVar.f7793z.getAnimatedValue()).floatValue() != 0.0f) {
                        qVar.A = 2;
                        qVar.f7786s.invalidate();
                        break;
                    } else {
                        qVar.A = 0;
                        qVar.f(0);
                        break;
                    }
                } else {
                    this.f7763b = false;
                    break;
                }
            default:
                View view = (View) this.f7764c;
                v3.r.f9551a.a0(view, 1.0f);
                if (this.f7763b) {
                    view.setLayerType(0, null);
                    break;
                }
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f7762a) {
            case 1:
                View view = (View) this.f7764c;
                WeakHashMap weakHashMap = n0.t0.f7209a;
                if (n0.c0.h(view) && view.getLayerType() == 0) {
                    this.f7763b = true;
                    view.setLayerType(2, null);
                    break;
                }
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }

    public p(q qVar) {
        this.f7764c = qVar;
    }
}
