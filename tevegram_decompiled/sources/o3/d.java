package o3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7610a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d1 f7611b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f7612c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f7613d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ i f7614e;

    public d(i iVar, d1 d1Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f7614e = iVar;
        this.f7611b = d1Var;
        this.f7613d = viewPropertyAnimator;
        this.f7612c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f7610a) {
            case 1:
                this.f7612c.setAlpha(1.0f);
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f7610a) {
            case 0:
                this.f7613d.setListener(null);
                this.f7612c.setAlpha(1.0f);
                i iVar = this.f7614e;
                d1 d1Var = this.f7611b;
                iVar.c(d1Var);
                iVar.f7686q.remove(d1Var);
                iVar.i();
                break;
            default:
                this.f7613d.setListener(null);
                i iVar2 = this.f7614e;
                d1 d1Var2 = this.f7611b;
                iVar2.c(d1Var2);
                iVar2.f7684o.remove(d1Var2);
                iVar2.i();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f7610a) {
            case 0:
                this.f7614e.getClass();
                break;
            default:
                this.f7614e.getClass();
                break;
        }
    }

    public d(i iVar, d1 d1Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.f7614e = iVar;
        this.f7611b = d1Var;
        this.f7612c = view;
        this.f7613d = viewPropertyAnimator;
    }
}
