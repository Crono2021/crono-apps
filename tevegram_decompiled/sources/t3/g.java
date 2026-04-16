package t3;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g extends Animation {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f8955i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ SwipeRefreshLayout f8956j;

    public /* synthetic */ g(SwipeRefreshLayout swipeRefreshLayout, int i9) {
        this.f8955i = i9;
        this.f8956j = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float f9, Transformation transformation) {
        switch (this.f8955i) {
            case 0:
                this.f8956j.setAnimationProgress(f9);
                break;
            case 1:
                this.f8956j.setAnimationProgress(1.0f - f9);
                break;
            case 2:
                SwipeRefreshLayout swipeRefreshLayout = this.f8956j;
                int abs = swipeRefreshLayout.F - Math.abs(swipeRefreshLayout.E);
                swipeRefreshLayout.setTargetOffsetTopAndBottom((swipeRefreshLayout.D + ((int) ((abs - r1) * f9))) - swipeRefreshLayout.B.getTop());
                e eVar = swipeRefreshLayout.H;
                float f10 = 1.0f - f9;
                d dVar = eVar.f8947i;
                if (f10 != dVar.f8938p) {
                    dVar.f8938p = f10;
                }
                eVar.invalidateSelf();
                break;
            default:
                this.f8956j.k(f9);
                break;
        }
    }
}
