package com.network.tvgramplayer;

import a7.a;
import android.app.Application;
import b8.i;
import h7.k0;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class TvgramApplication extends Application {

    /* renamed from: j, reason: collision with root package name */
    public static volatile boolean f2329j;

    /* renamed from: i, reason: collision with root package name */
    public k0 f2330i;

    public final k0 a() {
        k0 k0Var = this.f2330i;
        if (k0Var != null) {
            return k0Var;
        }
        i.d("tdClient");
        throw null;
    }

    @Override // android.app.Application
    public final void onCreate() {
        super.onCreate();
        this.f2330i = new k0(this);
        new Thread(new a(this, 0)).start();
    }
}
