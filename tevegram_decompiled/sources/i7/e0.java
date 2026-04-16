package i7;

import com.network.tvgramplayer.ui.LiveStreamActivity;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e0 implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ LiveStreamActivity f4827i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ h7.k0 f4828j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int f4829k;

    public e0(LiveStreamActivity liveStreamActivity, h7.k0 k0Var, int i9) {
        this.f4827i = liveStreamActivity;
        this.f4828j = k0Var;
        this.f4829k = i9;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LiveStreamActivity liveStreamActivity = this.f4827i;
        if (liveStreamActivity.isFinishing() || liveStreamActivity.isDestroyed()) {
            return;
        }
        this.f4828j.l(this.f4829k, new h7.c(liveStreamActivity, 5, this));
    }
}
