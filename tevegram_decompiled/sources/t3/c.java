package t3;

import android.animation.Animator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c implements Animator.AnimatorListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f8922a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f8923b;

    public c(e eVar, d dVar) {
        this.f8923b = eVar;
        this.f8922a = dVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
        e eVar = this.f8923b;
        d dVar = this.f8922a;
        eVar.a(1.0f, dVar, true);
        dVar.f8933k = dVar.f8928e;
        dVar.f8934l = dVar.f8929f;
        dVar.f8935m = dVar.f8930g;
        dVar.a((dVar.f8932j + 1) % dVar.f8931i.length);
        if (!eVar.f8952n) {
            eVar.f8951m += 1.0f;
            return;
        }
        eVar.f8952n = false;
        animator.cancel();
        animator.setDuration(1332L);
        animator.start();
        if (dVar.f8936n) {
            dVar.f8936n = false;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.f8923b.f8951m = 0.0f;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
    }
}
