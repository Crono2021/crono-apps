package org.webrtc;

import android.os.Looper;
import java.util.concurrent.CountDownLatch;
import org.webrtc.GlGenericDrawer;
import org.webrtc.TextureBufferImpl;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class q implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f8068i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f8069j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f8070k;

    public /* synthetic */ q(Object obj, int i9, Object obj2) {
        this.f8068i = i9;
        this.f8069j = obj;
        this.f8070k = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8068i) {
            case 0:
                ((TextureBufferImpl) this.f8069j).lambda$new$0((TextureBufferImpl.RefCountMonitor) this.f8070k);
                break;
            case 1:
                ((EglRenderer) this.f8069j).lambda$getTexture$7((GlGenericDrawer.TextureCallback) this.f8070k);
                break;
            case 2:
                ((EglRenderer) this.f8069j).lambda$release$1((CountDownLatch) this.f8070k);
                break;
            case 3:
                ((EglRenderer) this.f8069j).lambda$release$2((Looper) this.f8070k);
                break;
            case 4:
                ((VideoFileRenderer) this.f8069j).lambda$onFrame$0((VideoFrame) this.f8070k);
                break;
            case 5:
                ((VideoFileRenderer) this.f8069j).lambda$release$2((CountDownLatch) this.f8070k);
                break;
            default:
                ((VideoSource) this.f8069j).lambda$setVideoProcessor$0((VideoFrame) this.f8070k);
                break;
        }
    }
}
