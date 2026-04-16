package s1;

import android.os.HandlerThread;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class b implements a6.h {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f8669i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8670j;

    public /* synthetic */ b(int i9, int i10) {
        this.f8669i = i10;
        this.f8670j = i9;
    }

    @Override // a6.h
    public final Object get() {
        switch (this.f8669i) {
            case 0:
                return new HandlerThread(c.c(this.f8670j, "ExoPlayer:MediaCodecAsyncAdapter:"));
            default:
                return new HandlerThread(c.c(this.f8670j, "ExoPlayer:MediaCodecQueueingThread:"));
        }
    }
}
