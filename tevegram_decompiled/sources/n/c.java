package n;

import androidx.appcompat.widget.ActionBarOverlayLayout;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f6813i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ ActionBarOverlayLayout f6814j;

    public /* synthetic */ c(ActionBarOverlayLayout actionBarOverlayLayout, int i9) {
        this.f6813i = i9;
        this.f6814j = actionBarOverlayLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6813i) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = this.f6814j;
                actionBarOverlayLayout.h();
                actionBarOverlayLayout.E = actionBarOverlayLayout.f423l.animate().translationY(0.0f).setListener(actionBarOverlayLayout.F);
                break;
            default:
                ActionBarOverlayLayout actionBarOverlayLayout2 = this.f6814j;
                actionBarOverlayLayout2.h();
                actionBarOverlayLayout2.E = actionBarOverlayLayout2.f423l.animate().translationY(-actionBarOverlayLayout2.f423l.getHeight()).setListener(actionBarOverlayLayout2.F);
                break;
        }
    }
}
