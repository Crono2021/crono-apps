package com.bumptech.glide.manager;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.fragment.app.h0;
import androidx.fragment.app.v;
import androidx.lifecycle.u;
import java.util.HashMap;
import k4.w;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class k implements Handler.Callback {

    /* renamed from: l, reason: collision with root package name */
    public static final u5.e f1835l = new u5.e(23);

    /* renamed from: i, reason: collision with root package name */
    public volatile com.bumptech.glide.m f1836i;

    /* renamed from: j, reason: collision with root package name */
    public final f f1837j;

    /* renamed from: k, reason: collision with root package name */
    public final a5.d f1838k = new a5.d(f1835l);

    public k() {
        this.f1837j = (w.f5598f && w.f5597e) ? new e() : new u5.e(20);
    }

    public static Activity a(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return a(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public final com.bumptech.glide.m b(Context context) {
        if (context == null) {
            m7.c.n("You cannot start a load on a null Context");
            return null;
        }
        char[] cArr = w4.n.f9951a;
        if (Looper.myLooper() == Looper.getMainLooper() && !(context instanceof Application)) {
            if (context instanceof g.l) {
                return c((g.l) context);
            }
            if (context instanceof ContextWrapper) {
                ContextWrapper contextWrapper = (ContextWrapper) context;
                if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                    return b(contextWrapper.getBaseContext());
                }
            }
        }
        if (this.f1836i == null) {
            synchronized (this) {
                try {
                    if (this.f1836i == null) {
                        this.f1836i = new com.bumptech.glide.m(com.bumptech.glide.b.a(context.getApplicationContext()), new u5.e(18), new u5.e(21), context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return this.f1836i;
    }

    public final com.bumptech.glide.m c(g.l lVar) {
        char[] cArr = w4.n.f9951a;
        if (!(Looper.myLooper() == Looper.getMainLooper())) {
            return b(lVar.getApplicationContext());
        }
        if (lVar.isDestroyed()) {
            m7.c.n("You cannot start a load for a destroyed activity");
            return null;
        }
        this.f1837j.a(lVar);
        Activity a9 = a(lVar);
        boolean z8 = a9 == null || !a9.isFinishing();
        com.bumptech.glide.b a10 = com.bumptech.glide.b.a(lVar.getApplicationContext());
        u uVar = lVar.f300l;
        h0 h0Var = ((v) lVar.f3577y.f8j).f874r;
        a5.d dVar = this.f1838k;
        dVar.getClass();
        HashMap hashMap = (HashMap) dVar.f174j;
        w4.n.a();
        w4.n.a();
        com.bumptech.glide.m mVar = (com.bumptech.glide.m) hashMap.get(uVar);
        if (mVar != null) {
            return mVar;
        }
        LifecycleLifecycle lifecycleLifecycle = new LifecycleLifecycle(uVar);
        u5.e eVar = (u5.e) dVar.f175k;
        u5.e eVar2 = new u5.e(dVar, h0Var);
        eVar.getClass();
        com.bumptech.glide.m mVar2 = new com.bumptech.glide.m(a10, lifecycleLifecycle, eVar2, lVar);
        hashMap.put(uVar, mVar2);
        lifecycleLifecycle.f(new i(dVar, uVar));
        if (z8) {
            mVar2.j();
        }
        return mVar2;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        return false;
    }
}
