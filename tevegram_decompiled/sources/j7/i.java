package j7;

import android.view.View;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class i implements View.OnFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5462a;

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z8) {
        switch (this.f5462a) {
            case 0:
                float f9 = z8 ? 1.05f : 1.0f;
                view.animate().scaleX(f9).scaleY(f9).setDuration(200L).start();
                break;
            case 1:
                float f10 = z8 ? 1.05f : 1.0f;
                view.animate().scaleX(f10).scaleY(f10).setDuration(200L).start();
                break;
            default:
                float f11 = z8 ? 1.05f : 1.0f;
                view.animate().scaleX(f11).scaleY(f11).setDuration(200L).start();
                break;
        }
    }
}
