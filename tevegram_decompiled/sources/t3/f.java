package t3;

import android.view.animation.Animation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.network.tvgramplayer.ui.MediaExplorerActivity;
import i7.d2;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class f implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8953a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SwipeRefreshLayout f8954b;

    public /* synthetic */ f(SwipeRefreshLayout swipeRefreshLayout, int i9) {
        this.f8953a = i9;
        this.f8954b = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        j jVar;
        int i9 = this.f8953a;
        SwipeRefreshLayout swipeRefreshLayout = this.f8954b;
        switch (i9) {
            case 0:
                if (!swipeRefreshLayout.f1104k) {
                    swipeRefreshLayout.l();
                    break;
                } else {
                    swipeRefreshLayout.H.setAlpha(255);
                    swipeRefreshLayout.H.start();
                    if (swipeRefreshLayout.M && (jVar = swipeRefreshLayout.f1103j) != null) {
                        MediaExplorerActivity mediaExplorerActivity = ((d2) jVar).f4823i;
                        int i10 = MediaExplorerActivity.Y;
                        mediaExplorerActivity.w(true);
                    }
                    swipeRefreshLayout.f1115v = swipeRefreshLayout.B.getTop();
                    break;
                }
                break;
            default:
                g gVar = new g(swipeRefreshLayout, 1);
                swipeRefreshLayout.J = gVar;
                gVar.setDuration(150L);
                a aVar = swipeRefreshLayout.B;
                aVar.f8918i = null;
                aVar.clearAnimation();
                swipeRefreshLayout.B.startAnimation(swipeRefreshLayout.J);
                break;
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
        int i9 = this.f8953a;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        int i9 = this.f8953a;
    }

    private final void a(Animation animation) {
    }

    private final void b(Animation animation) {
    }

    private final void c(Animation animation) {
    }

    private final void d(Animation animation) {
    }
}
