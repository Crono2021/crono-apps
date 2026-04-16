package l3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class t extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6231a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v f6232b;

    public /* synthetic */ t(v vVar, int i9) {
        this.f6231a = i9;
        this.f6232b = vVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        switch (this.f6231a) {
            case 0:
                v vVar = this.f6232b;
                View view = vVar.f6237b;
                if (view != null) {
                    view.setVisibility(4);
                }
                ViewGroup viewGroup = vVar.f6238c;
                if (viewGroup != null) {
                    viewGroup.setVisibility(4);
                }
                ViewGroup viewGroup2 = vVar.f6240e;
                if (viewGroup2 != null) {
                    viewGroup2.setVisibility(4);
                    break;
                }
                break;
            case 1:
            default:
                super.onAnimationEnd(animator);
                break;
            case 2:
                this.f6232b.i(0);
                break;
            case 3:
                this.f6232b.i(0);
                break;
            case 4:
                ViewGroup viewGroup3 = this.f6232b.f6241f;
                if (viewGroup3 != null) {
                    viewGroup3.setVisibility(4);
                    break;
                }
                break;
            case 5:
                ViewGroup viewGroup4 = this.f6232b.h;
                if (viewGroup4 != null) {
                    viewGroup4.setVisibility(4);
                    break;
                }
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        int i9 = this.f6231a;
        v vVar = this.f6232b;
        switch (i9) {
            case 0:
                View view = vVar.f6244j;
                if ((view instanceof d) && !vVar.A) {
                    d dVar = (d) view;
                    ValueAnimator valueAnimator = dVar.M;
                    if (valueAnimator.isStarted()) {
                        valueAnimator.cancel();
                    }
                    valueAnimator.setFloatValues(dVar.N, 0.0f);
                    valueAnimator.setDuration(250L);
                    valueAnimator.start();
                    break;
                }
                break;
            case 1:
                View view2 = vVar.f6237b;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
                ViewGroup viewGroup = vVar.f6238c;
                if (viewGroup != null) {
                    viewGroup.setVisibility(0);
                }
                ViewGroup viewGroup2 = vVar.f6240e;
                if (viewGroup2 != null) {
                    viewGroup2.setVisibility(vVar.A ? 0 : 4);
                }
                View view3 = vVar.f6244j;
                if ((view3 instanceof d) && !vVar.A) {
                    d dVar2 = (d) view3;
                    ValueAnimator valueAnimator2 = dVar2.M;
                    if (valueAnimator2.isStarted()) {
                        valueAnimator2.cancel();
                    }
                    dVar2.O = false;
                    valueAnimator2.setFloatValues(dVar2.N, 1.0f);
                    valueAnimator2.setDuration(250L);
                    valueAnimator2.start();
                    break;
                }
                break;
            case 2:
                vVar.i(4);
                break;
            case 3:
                vVar.i(4);
                break;
            case 4:
                ViewGroup viewGroup3 = vVar.h;
                if (viewGroup3 != null) {
                    viewGroup3.setVisibility(0);
                    viewGroup3.setTranslationX(viewGroup3.getWidth());
                    viewGroup3.scrollTo(viewGroup3.getWidth(), 0);
                    break;
                }
                break;
            default:
                ViewGroup viewGroup4 = vVar.f6241f;
                if (viewGroup4 != null) {
                    viewGroup4.setVisibility(0);
                    break;
                }
                break;
        }
    }
}
