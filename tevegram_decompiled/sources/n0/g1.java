package n0;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.PathInterpolator;
import java.util.Collections;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g1 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m1 f7154a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a2 f7155b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a2 f7156c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f7157d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ View f7158e;

    public g1(m1 m1Var, a2 a2Var, a2 a2Var2, int i9, View view) {
        this.f7154a = m1Var;
        this.f7155b = a2Var;
        this.f7156c = a2Var2;
        this.f7157d = i9;
        this.f7158e = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        m1 m1Var = this.f7154a;
        l1 l1Var = m1Var.f7177a;
        l1Var.d(animatedFraction);
        float b9 = l1Var.b();
        PathInterpolator pathInterpolator = i1.f7165e;
        int i9 = Build.VERSION.SDK_INT;
        a2 a2Var = this.f7155b;
        r1 q1Var = i9 >= 30 ? new q1(a2Var) : i9 >= 29 ? new p1(a2Var) : new o1(a2Var);
        for (int i10 = 1; i10 <= 256; i10 <<= 1) {
            int i11 = this.f7157d & i10;
            x1 x1Var = a2Var.f7139a;
            if (i11 == 0) {
                q1Var.c(i10, x1Var.f(i10));
            } else {
                f0.c f9 = x1Var.f(i10);
                f0.c f10 = this.f7156c.f7139a.f(i10);
                float f11 = 1.0f - b9;
                q1Var.c(i10, a2.e(f9, (int) (((f9.f3193a - f10.f3193a) * f11) + 0.5d), (int) (((f9.f3194b - f10.f3194b) * f11) + 0.5d), (int) (((f9.f3195c - f10.f3195c) * f11) + 0.5d), (int) (((f9.f3196d - f10.f3196d) * f11) + 0.5d)));
            }
        }
        i1.g(this.f7158e, q1Var.b(), Collections.singletonList(m1Var));
    }
}
