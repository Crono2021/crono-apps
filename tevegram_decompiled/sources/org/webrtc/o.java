package org.webrtc;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class o implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f8063i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8064j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int f8065k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f8066l;

    public /* synthetic */ o(Object obj, int i9, int i10, int i11) {
        this.f8063i = i11;
        this.f8066l = obj;
        this.f8064j = i9;
        this.f8065k = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8063i) {
            case 0:
                ((SurfaceTextureHelper) this.f8066l).lambda$setTextureSize$2(this.f8064j, this.f8065k);
                break;
            case 1:
                ((SurfaceViewRenderer) this.f8066l).lambda$onFrameResolutionChanged$0(this.f8064j, this.f8065k);
                break;
            default:
                ((TextureViewRenderer) this.f8066l).lambda$updateVideoSizes$1(this.f8064j, this.f8065k);
                break;
        }
    }
}
