package i7;

import android.app.Application;
import com.network.tvgramplayer.ui.MainActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class n0 implements a8.a {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f4988i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ MainActivity f4989j;

    public /* synthetic */ n0(MainActivity mainActivity, int i9) {
        this.f4988i = i9;
        this.f4989j = mainActivity;
    }

    @Override // a8.a
    public final Object d() {
        int i9 = this.f4988i;
        MainActivity mainActivity = this.f4989j;
        switch (i9) {
            case 0:
                int i10 = MainActivity.X;
                Application application = mainActivity.getApplication();
                application.getClass();
                break;
            case 1:
                int i11 = MainActivity.X;
                mainActivity.E();
                break;
            default:
                int i12 = MainActivity.X;
                mainActivity.s("> Suscripciones actualizadas.");
                break;
        }
        return n7.g.f7490c;
    }
}
