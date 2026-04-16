package com.bumptech.glide.manager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class r implements m {

    /* renamed from: g, reason: collision with root package name */
    public static final Executor f1848g = AsyncTask.SERIAL_EXECUTOR;

    /* renamed from: a, reason: collision with root package name */
    public final Context f1849a;

    /* renamed from: b, reason: collision with root package name */
    public final l f1850b;

    /* renamed from: c, reason: collision with root package name */
    public final c.a f1851c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f1852d;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f1853e;

    /* renamed from: f, reason: collision with root package name */
    public final p f1854f = new p(this, 0);

    public r(Context context, c.a aVar, l lVar) {
        this.f1849a = context.getApplicationContext();
        this.f1851c = aVar;
        this.f1850b = lVar;
    }

    @Override // com.bumptech.glide.manager.m
    public final void a() {
        f1848g.execute(new q(this, 1));
    }

    @Override // com.bumptech.glide.manager.m
    public final boolean b() {
        f1848g.execute(new q(this, 0));
        return true;
    }

    public final boolean c() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f1851c.get()).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e9) {
            if (!Log.isLoggable("ConnectivityMonitor", 5)) {
                return true;
            }
            Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e9);
            return true;
        }
    }
}
