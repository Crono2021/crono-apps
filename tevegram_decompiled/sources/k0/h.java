package k0;

import android.os.Process;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class h extends Thread {

    /* renamed from: i, reason: collision with root package name */
    public final int f5524i;

    public h(Runnable runnable) {
        super(runnable, "fonts-androidx");
        this.f5524i = 10;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.f5524i);
        super.run();
    }
}
