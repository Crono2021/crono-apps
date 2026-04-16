package g4;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final b f3735a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3736b;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f3738d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicInteger f3739e = new AtomicInteger();

    /* renamed from: c, reason: collision with root package name */
    public final d f3737c = d.f3740a;

    public c(b bVar, String str, boolean z8) {
        this.f3735a = bVar;
        this.f3736b = str;
        this.f3738d = z8;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        androidx.fragment.app.d dVar = new androidx.fragment.app.d(this, runnable, 6, false);
        this.f3735a.getClass();
        a aVar = new a(dVar);
        aVar.setName("glide-" + this.f3736b + "-thread-" + this.f3739e.getAndIncrement());
        return aVar;
    }
}
