package org.webrtc;

import android.view.Choreographer;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final /* synthetic */ class l implements Choreographer.FrameCallback {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ RenderSynchronizer f8058i;

    public /* synthetic */ l(RenderSynchronizer renderSynchronizer) {
        this.f8058i = renderSynchronizer;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j5) {
        this.f8058i.onDisplayRefreshCycleBegin(j5);
    }
}
