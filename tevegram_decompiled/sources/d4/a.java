package d4;

import java.util.concurrent.ThreadFactory;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2793a;

    public /* synthetic */ a(int i9) {
        this.f2793a = i9;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.f2793a) {
            case 0:
                return new Thread(new androidx.activity.j(runnable, 5), "glide-active-resources");
            default:
                return new k0.h(runnable);
        }
    }
}
