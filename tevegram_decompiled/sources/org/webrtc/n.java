package org.webrtc;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class n implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f8061i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ SurfaceTextureHelper f8062j;

    public /* synthetic */ n(SurfaceTextureHelper surfaceTextureHelper, int i9) {
        this.f8061i = i9;
        this.f8062j = surfaceTextureHelper;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8061i) {
            case 0:
                this.f8062j.lambda$stopListening$1();
                break;
            case 1:
                this.f8062j.lambda$dispose$6();
                break;
            case 2:
                this.f8062j.lambda$returnTextureFrame$5();
                break;
            default:
                this.f8062j.lambda$forceFrame$3();
                break;
        }
    }
}
