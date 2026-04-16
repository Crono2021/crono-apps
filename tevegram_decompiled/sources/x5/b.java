package x5;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10106a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f10107b;

    public /* synthetic */ b(c cVar, int i9) {
        this.f10106a = i9;
        this.f10107b = cVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        switch (this.f10106a) {
            case 1:
                this.f10107b.f10154b.h(false);
                break;
            default:
                super.onAnimationEnd(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f10106a) {
            case 0:
                this.f10107b.f10154b.h(true);
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }
}
