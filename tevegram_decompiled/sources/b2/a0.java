package b2;

import android.hardware.display.DisplayManager;
import android.os.Handler;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a0 implements z, DisplayManager.DisplayListener {

    /* renamed from: i, reason: collision with root package name */
    public final DisplayManager f1135i;

    /* renamed from: j, reason: collision with root package name */
    public a3.i f1136j;

    public a0(DisplayManager displayManager) {
        this.f1135i = displayManager;
    }

    @Override // b2.z
    public final void a() {
        this.f1135i.unregisterDisplayListener(this);
        this.f1136j = null;
    }

    @Override // b2.z
    public final void d(a3.i iVar) {
        this.f1136j = iVar;
        Handler l4 = g1.w.l(null);
        DisplayManager displayManager = this.f1135i;
        displayManager.registerDisplayListener(this, l4);
        iVar.g(displayManager.getDisplay(0));
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayChanged(int i9) {
        a3.i iVar = this.f1136j;
        if (iVar == null || i9 != 0) {
            return;
        }
        iVar.g(this.f1135i.getDisplay(0));
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayAdded(int i9) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayRemoved(int i9) {
    }
}
