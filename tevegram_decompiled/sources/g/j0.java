package g;

import java.util.concurrent.Executor;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class j0 implements Executor {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f3570i;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f3570i) {
            case 0:
                new Thread(runnable).start();
                break;
            case 1:
                w4.n.f().post(runnable);
                break;
            default:
                runnable.run();
                break;
        }
    }
}
