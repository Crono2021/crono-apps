package o3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d1 f7636a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f7637b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f7638c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f7639d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f7640e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ i f7641f;

    public e(i iVar, d1 d1Var, int i9, View view, int i10, ViewPropertyAnimator viewPropertyAnimator) {
        this.f7641f = iVar;
        this.f7636a = d1Var;
        this.f7637b = i9;
        this.f7638c = view;
        this.f7639d = i10;
        this.f7640e = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        int i9 = this.f7637b;
        View view = this.f7638c;
        if (i9 != 0) {
            view.setTranslationX(0.0f);
        }
        if (this.f7639d != 0) {
            view.setTranslationY(0.0f);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f7640e.setListener(null);
        i iVar = this.f7641f;
        d1 d1Var = this.f7636a;
        iVar.c(d1Var);
        iVar.f7685p.remove(d1Var);
        iVar.i();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f7641f.getClass();
    }
}
