package n0;

import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public class b2 extends a.a {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f7140i = 0;

    /* renamed from: j, reason: collision with root package name */
    public Window f7141j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f7142k;

    public b2(Window window, i7.x xVar) {
        this.f7141j = window;
        this.f7142k = xVar;
    }

    @Override // a.a
    public void J(boolean z8) {
        switch (this.f7140i) {
            case 1:
                Window window = this.f7141j;
                if (!z8) {
                    if (window != null) {
                        View decorView = window.getDecorView();
                        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-17));
                    }
                    ((WindowInsetsController) this.f7142k).setSystemBarsAppearance(0, 16);
                    break;
                } else {
                    if (window != null) {
                        View decorView2 = window.getDecorView();
                        decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() | 16);
                    }
                    ((WindowInsetsController) this.f7142k).setSystemBarsAppearance(16, 16);
                    break;
                }
        }
    }

    @Override // a.a
    public void K(boolean z8) {
        switch (this.f7140i) {
            case 1:
                Window window = this.f7141j;
                if (!z8) {
                    if (window != null) {
                        View decorView = window.getDecorView();
                        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-8193));
                    }
                    ((WindowInsetsController) this.f7142k).setSystemBarsAppearance(0, 8);
                    break;
                } else {
                    if (window != null) {
                        View decorView2 = window.getDecorView();
                        decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() | 8192);
                    }
                    ((WindowInsetsController) this.f7142k).setSystemBarsAppearance(8, 8);
                    break;
                }
        }
    }

    @Override // a.a
    public final void N() {
        switch (this.f7140i) {
            case 0:
                a0(IjkMediaMeta.FF_PROFILE_H264_INTRA);
                Z(4096);
                break;
            default:
                ((WindowInsetsController) this.f7142k).setSystemBarsBehavior(2);
                break;
        }
    }

    public void Z(int i9) {
        View decorView = this.f7141j.getDecorView();
        decorView.setSystemUiVisibility(i9 | decorView.getSystemUiVisibility());
    }

    public void a0(int i9) {
        View decorView = this.f7141j.getDecorView();
        decorView.setSystemUiVisibility((~i9) & decorView.getSystemUiVisibility());
    }

    @Override // a.a
    public final void y() {
        switch (this.f7140i) {
            case 0:
                for (int i9 = 1; i9 <= 256; i9 <<= 1) {
                    if ((7 & i9) != 0) {
                        if (i9 == 1) {
                            Z(4);
                        } else if (i9 == 2) {
                            Z(2);
                        } else if (i9 == 8) {
                            ((d1.a) ((i7.x) this.f7142k).f5179j).a();
                        }
                    }
                }
                break;
            default:
                ((WindowInsetsController) this.f7142k).hide(7);
                break;
        }
    }

    public b2(WindowInsetsController windowInsetsController, i7.x xVar) {
        this.f7142k = windowInsetsController;
    }
}
