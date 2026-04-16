package l3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class u extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6233a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f6234b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ v f6235c;

    public /* synthetic */ u(v vVar, q qVar, int i9) {
        this.f6233a = i9;
        this.f6235c = vVar;
        this.f6234b = qVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f6233a) {
            case 0:
                v vVar = this.f6235c;
                vVar.i(1);
                if (vVar.B) {
                    this.f6234b.post(vVar.f6253s);
                    vVar.B = false;
                    break;
                }
                break;
            case 1:
                v vVar2 = this.f6235c;
                vVar2.i(2);
                if (vVar2.B) {
                    this.f6234b.post(vVar2.f6253s);
                    vVar2.B = false;
                    break;
                }
                break;
            default:
                v vVar3 = this.f6235c;
                vVar3.i(2);
                if (vVar3.B) {
                    this.f6234b.post(vVar3.f6253s);
                    vVar3.B = false;
                    break;
                }
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f6233a) {
            case 0:
                this.f6235c.i(3);
                break;
            case 1:
                this.f6235c.i(3);
                break;
            default:
                this.f6235c.i(3);
                break;
        }
    }
}
