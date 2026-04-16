package t3;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h extends Animation {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f8957i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8958j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ SwipeRefreshLayout f8959k;

    public h(SwipeRefreshLayout swipeRefreshLayout, int i9, int i10) {
        this.f8959k = swipeRefreshLayout;
        this.f8957i = i9;
        this.f8958j = i10;
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float f9, Transformation transformation) {
        this.f8959k.H.setAlpha((int) (((this.f8958j - r0) * f9) + this.f8957i));
    }
}
