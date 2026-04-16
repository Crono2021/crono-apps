package l1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class a extends BroadcastReceiver implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final y f5758i;

    /* renamed from: j, reason: collision with root package name */
    public final Handler f5759j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ com.bumptech.glide.manager.s f5760k;

    public a(com.bumptech.glide.manager.s sVar, Handler handler, y yVar) {
        this.f5760k = sVar;
        this.f5759j = handler;
        this.f5758i = yVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
            this.f5759j.post(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f5760k.f1857j) {
            this.f5758i.f6065i.v0(-1, 3, false);
        }
    }
}
