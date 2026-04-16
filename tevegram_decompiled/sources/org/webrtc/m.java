package org.webrtc;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class m implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f8059i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ ScreenCapturerAndroid f8060j;

    public /* synthetic */ m(ScreenCapturerAndroid screenCapturerAndroid, int i9) {
        this.f8059i = i9;
        this.f8060j = screenCapturerAndroid;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8059i) {
            case 0:
                this.f8060j.lambda$changeCaptureFormat$1();
                break;
            default:
                this.f8060j.lambda$stopCapture$0();
                break;
        }
    }
}
