package j0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public boolean f5337a;

    /* renamed from: b, reason: collision with root package name */
    public c f5338b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f5339c;

    public final void a(c cVar) {
        synchronized (this) {
            while (this.f5339c) {
                try {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                } finally {
                }
            }
            if (this.f5338b == cVar) {
                return;
            }
            this.f5338b = cVar;
            if (this.f5337a) {
                cVar.onCancel();
            }
        }
    }
}
