package d5;

import android.animation.ValueAnimator;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.textfield.TextInputLayout;
import o3.q;
import u5.g;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2947a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2948b;

    public /* synthetic */ b(Object obj, int i9) {
        this.f2947a = i9;
        this.f2948b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f2947a) {
            case 0:
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                g gVar = ((BottomSheetBehavior) this.f2948b).f1931i;
                if (gVar != null) {
                    gVar.m(floatValue);
                    break;
                }
                break;
            case 1:
                int floatValue2 = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
                q qVar = (q) this.f2948b;
                qVar.f7771c.setAlpha(floatValue2);
                qVar.f7772d.setAlpha(floatValue2);
                qVar.f7786s.invalidate();
                break;
            default:
                ((TextInputLayout) this.f2948b).C0.k(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
        }
    }
}
