package z3;

import java.util.concurrent.Callable;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f10630a;

    public a(d dVar) {
        this.f10630a = dVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        synchronized (this.f10630a) {
            try {
                d dVar = this.f10630a;
                if (dVar.f10646q == null) {
                    return null;
                }
                dVar.n();
                if (this.f10630a.g()) {
                    this.f10630a.l();
                    this.f10630a.f10648s = 0;
                }
                return null;
            } finally {
            }
        }
    }
}
