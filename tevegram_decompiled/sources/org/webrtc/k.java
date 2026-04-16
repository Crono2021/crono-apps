package org.webrtc;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class k implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f8056i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ RenderSynchronizer f8057j;

    public /* synthetic */ k(RenderSynchronizer renderSynchronizer, int i9) {
        this.f8056i = i9;
        this.f8057j = renderSynchronizer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8056i) {
            case 0:
                this.f8057j.lambda$registerListener$1();
                break;
            default:
                this.f8057j.lambda$new$0();
                break;
        }
    }
}
