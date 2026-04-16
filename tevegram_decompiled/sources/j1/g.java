package j1;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class g extends Thread {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f5367i = 1;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f5368j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(h hVar) {
        super("ExoPlayer:SimpleDecoder");
        this.f5368j = hVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        switch (this.f5367i) {
            case 0:
                do {
                    try {
                    } catch (InterruptedException e9) {
                        throw new IllegalStateException(e9);
                    }
                } while (((h) this.f5368j).i());
                return;
            default:
                ((androidx.activity.d) this.f5368j).d();
                return;
        }
    }

    public g(androidx.activity.d dVar) {
        this.f5368j = dVar;
    }
}
