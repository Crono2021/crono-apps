package m;

import android.widget.PopupWindow;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class v implements PopupWindow.OnDismissListener {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ x f6483i;

    public v(x xVar) {
        this.f6483i = xVar;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.f6483i.c();
    }
}
