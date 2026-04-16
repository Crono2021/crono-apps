package n1;

import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class m0 implements Executor {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Handler f7296i;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f7296i.post(runnable);
    }
}
