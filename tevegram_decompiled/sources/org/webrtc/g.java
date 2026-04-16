package org.webrtc;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f8049i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8050j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f8051k;

    public /* synthetic */ g(int i9, int i10, Object obj) {
        this.f8049i = i10;
        this.f8051k = obj;
        this.f8050j = i9;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8049i) {
            case 0:
                ((HardwareVideoEncoder) this.f8051k).lambda$deliverEncodedImage$0(this.f8050j);
                break;
            default:
                ((SurfaceTextureHelper) this.f8051k).lambda$setFrameRotation$4(this.f8050j);
                break;
        }
    }
}
