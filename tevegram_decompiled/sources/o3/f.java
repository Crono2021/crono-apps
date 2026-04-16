package o3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7645a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f7646b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f7647c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ View f7648d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ i f7649e;

    public /* synthetic */ f(i iVar, g gVar, ViewPropertyAnimator viewPropertyAnimator, View view, int i9) {
        this.f7645a = i9;
        this.f7649e = iVar;
        this.f7646b = gVar;
        this.f7647c = viewPropertyAnimator;
        this.f7648d = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f7645a) {
            case 0:
                this.f7647c.setListener(null);
                View view = this.f7648d;
                view.setAlpha(1.0f);
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
                g gVar = this.f7646b;
                d1 d1Var = gVar.f7653a;
                i iVar = this.f7649e;
                iVar.c(d1Var);
                iVar.f7687r.remove(gVar.f7653a);
                iVar.i();
                break;
            default:
                this.f7647c.setListener(null);
                View view2 = this.f7648d;
                view2.setAlpha(1.0f);
                view2.setTranslationX(0.0f);
                view2.setTranslationY(0.0f);
                g gVar2 = this.f7646b;
                d1 d1Var2 = gVar2.f7654b;
                i iVar2 = this.f7649e;
                iVar2.c(d1Var2);
                iVar2.f7687r.remove(gVar2.f7654b);
                iVar2.i();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f7645a) {
            case 0:
                this.f7649e.getClass();
                break;
            default:
                this.f7649e.getClass();
                break;
        }
    }
}
