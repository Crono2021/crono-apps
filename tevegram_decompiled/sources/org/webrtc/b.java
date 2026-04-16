package org.webrtc;

import org.webrtc.Camera1Session;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f8033i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Camera1Session.AnonymousClass2 f8034j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ byte[] f8035k;

    public /* synthetic */ b(Camera1Session.AnonymousClass2 anonymousClass2, byte[] bArr, int i9) {
        this.f8033i = i9;
        this.f8034j = anonymousClass2;
        this.f8035k = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8033i) {
            case 0:
                this.f8034j.lambda$onPreviewFrame$1(this.f8035k);
                break;
            default:
                this.f8034j.lambda$onPreviewFrame$0(this.f8035k);
                break;
        }
    }
}
