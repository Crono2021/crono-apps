package n0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a1 extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7135a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7136b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f7137c;

    public a1(v3.k kVar, s.d dVar) {
        this.f7135a = 2;
        this.f7136b = kVar;
        this.f7137c = dVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f7135a) {
            case 0:
                ((d1) this.f7137c).b();
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f7135a) {
            case 0:
                ((d1) this.f7137c).a();
                break;
            case 1:
                ((m1) this.f7137c).f7177a.d(1.0f);
                i1.e((View) this.f7136b);
                break;
            default:
                ((s.d) this.f7137c).remove(animator);
                ((v3.k) this.f7136b).f9534u.remove(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f7135a) {
            case 0:
                ((d1) this.f7137c).c();
                break;
            case 1:
            default:
                super.onAnimationStart(animator);
                break;
            case 2:
                ((v3.k) this.f7136b).f9534u.add(animator);
                break;
        }
    }

    public /* synthetic */ a1(Object obj, View view, int i9) {
        this.f7135a = i9;
        this.f7137c = obj;
        this.f7136b = view;
    }
}
