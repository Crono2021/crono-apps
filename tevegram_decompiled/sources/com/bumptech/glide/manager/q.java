package com.bumptech.glide.manager;

import android.content.IntentFilter;
import android.util.Log;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class q implements Runnable {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f1846i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ r f1847j;

    public /* synthetic */ q(r rVar, int i9) {
        this.f1846i = i9;
        this.f1847j = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1846i) {
            case 0:
                r rVar = this.f1847j;
                rVar.f1852d = rVar.c();
                try {
                    r rVar2 = this.f1847j;
                    rVar2.f1849a.registerReceiver(rVar2.f1854f, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    this.f1847j.f1853e = true;
                    break;
                } catch (SecurityException e9) {
                    if (Log.isLoggable("ConnectivityMonitor", 5)) {
                        Log.w("ConnectivityMonitor", "Failed to register", e9);
                    }
                    this.f1847j.f1853e = false;
                    return;
                }
            case 1:
                if (this.f1847j.f1853e) {
                    this.f1847j.f1853e = false;
                    r rVar3 = this.f1847j;
                    rVar3.f1849a.unregisterReceiver(rVar3.f1854f);
                    break;
                }
                break;
            default:
                boolean z8 = this.f1847j.f1852d;
                r rVar4 = this.f1847j;
                rVar4.f1852d = rVar4.c();
                if (z8 != this.f1847j.f1852d) {
                    if (Log.isLoggable("ConnectivityMonitor", 3)) {
                        Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + this.f1847j.f1852d);
                    }
                    r rVar5 = this.f1847j;
                    w4.n.f().post(new n(rVar5, rVar5.f1852d, 1));
                    break;
                }
                break;
        }
    }
}
