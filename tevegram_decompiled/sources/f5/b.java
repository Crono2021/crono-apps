package f5;

import android.animation.ValueAnimator;
import x5.i;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3388a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3389b;

    public /* synthetic */ b(Object obj, int i9) {
        this.f3388a = i9;
        this.f3389b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f3388a) {
            case 0:
                d dVar = (d) this.f3389b;
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                dVar.f3400j.setAlpha((int) (255.0f * floatValue));
                dVar.f3414x = floatValue;
                break;
            case 1:
                l3.d dVar2 = (l3.d) this.f3389b;
                dVar2.N = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                dVar2.invalidate(dVar2.f6103i);
                break;
            default:
                i iVar = (i) this.f3389b;
                iVar.f10156d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
        }
    }
}
