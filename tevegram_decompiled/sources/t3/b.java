package t3;

import android.animation.ValueAnimator;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f8920a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f8921b;

    public b(e eVar, d dVar) {
        this.f8921b = eVar;
        this.f8920a = dVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        d dVar = this.f8920a;
        e.d(floatValue, dVar);
        e eVar = this.f8921b;
        eVar.a(floatValue, dVar, false);
        eVar.invalidateSelf();
    }
}
