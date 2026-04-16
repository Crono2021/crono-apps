package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.Log;
import com.bumptech.glide.manager.s;
import com.bumptech.glide.manager.t;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import w4.n;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class m implements ComponentCallbacks2, com.bumptech.glide.manager.h {

    /* renamed from: s, reason: collision with root package name */
    public static final s4.e f1814s;

    /* renamed from: i, reason: collision with root package name */
    public final b f1815i;

    /* renamed from: j, reason: collision with root package name */
    public final Context f1816j;

    /* renamed from: k, reason: collision with root package name */
    public final com.bumptech.glide.manager.g f1817k;

    /* renamed from: l, reason: collision with root package name */
    public final s f1818l;

    /* renamed from: m, reason: collision with root package name */
    public final u5.e f1819m;

    /* renamed from: n, reason: collision with root package name */
    public final t f1820n;

    /* renamed from: o, reason: collision with root package name */
    public final androidx.activity.j f1821o;

    /* renamed from: p, reason: collision with root package name */
    public final com.bumptech.glide.manager.b f1822p;

    /* renamed from: q, reason: collision with root package name */
    public final CopyOnWriteArrayList f1823q;

    /* renamed from: r, reason: collision with root package name */
    public s4.e f1824r;

    static {
        s4.e eVar = (s4.e) new s4.e().c(Bitmap.class);
        eVar.f8815v = true;
        f1814s = eVar;
        ((s4.e) new s4.e().c(o4.c.class)).f8815v = true;
    }

    public m(b bVar, com.bumptech.glide.manager.g gVar, u5.e eVar, Context context) {
        s sVar = new s(3, (byte) 0);
        u5.e eVar2 = bVar.f1736n;
        this.f1820n = new t();
        androidx.activity.j jVar = new androidx.activity.j(this, 4);
        this.f1821o = jVar;
        this.f1815i = bVar;
        this.f1817k = gVar;
        this.f1819m = eVar;
        this.f1818l = sVar;
        this.f1816j = context;
        Context applicationContext = context.getApplicationContext();
        l lVar = new l(this, sVar);
        eVar2.getClass();
        boolean z8 = a.a.g(applicationContext, "android.permission.ACCESS_NETWORK_STATE") == 0;
        if (Log.isLoggable("ConnectivityMonitor", 3)) {
            Log.d("ConnectivityMonitor", z8 ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        com.bumptech.glide.manager.b cVar = z8 ? new com.bumptech.glide.manager.c(applicationContext, lVar) : new com.bumptech.glide.manager.j();
        this.f1822p = cVar;
        synchronized (bVar.f1737o) {
            if (bVar.f1737o.contains(this)) {
                throw new IllegalStateException("Cannot register already registered manager");
            }
            bVar.f1737o.add(this);
        }
        char[] cArr = n.f9951a;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            gVar.f(this);
        } else {
            n.f().post(jVar);
        }
        gVar.f(cVar);
        this.f1823q = new CopyOnWriteArrayList(bVar.f1733k.f1762e);
        q(bVar.f1733k.a());
    }

    @Override // com.bumptech.glide.manager.h
    public final synchronized void c() {
        this.f1820n.c();
        o();
    }

    @Override // com.bumptech.glide.manager.h
    public final synchronized void j() {
        p();
        this.f1820n.j();
    }

    @Override // com.bumptech.glide.manager.h
    public final synchronized void k() {
        this.f1820n.k();
        m();
        s sVar = this.f1818l;
        ArrayList e9 = n.e((Set) sVar.f1858k);
        int size = e9.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = e9.get(i9);
            i9++;
            sVar.a((s4.c) obj);
        }
        ((HashSet) sVar.f1859l).clear();
        this.f1817k.g(this);
        this.f1817k.g(this.f1822p);
        n.f().removeCallbacks(this.f1821o);
        this.f1815i.c(this);
    }

    public final void l(t4.b bVar) {
        if (bVar == null) {
            return;
        }
        boolean r8 = r(bVar);
        s4.c g9 = bVar.g();
        if (r8) {
            return;
        }
        b bVar2 = this.f1815i;
        synchronized (bVar2.f1737o) {
            try {
                ArrayList arrayList = bVar2.f1737o;
                int size = arrayList.size();
                int i9 = 0;
                while (i9 < size) {
                    Object obj = arrayList.get(i9);
                    i9++;
                    if (((m) obj).r(bVar)) {
                        return;
                    }
                }
                if (g9 != null) {
                    bVar.a(null);
                    g9.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void m() {
        try {
            ArrayList e9 = n.e(this.f1820n.f1860i);
            int size = e9.size();
            int i9 = 0;
            while (i9 < size) {
                Object obj = e9.get(i9);
                i9++;
                l((t4.b) obj);
            }
            this.f1820n.f1860i.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final k n(String str) {
        return new k(this.f1815i, this, Drawable.class, this.f1816j).z(str);
    }

    public final synchronized void o() {
        s sVar = this.f1818l;
        sVar.f1857j = true;
        ArrayList e9 = n.e((Set) sVar.f1858k);
        int size = e9.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = e9.get(i9);
            i9++;
            s4.c cVar = (s4.c) obj;
            if (cVar.isRunning()) {
                cVar.pause();
                ((HashSet) sVar.f1859l).add(cVar);
            }
        }
    }

    public final synchronized void p() {
        s sVar = this.f1818l;
        int i9 = 0;
        sVar.f1857j = false;
        ArrayList e9 = n.e((Set) sVar.f1858k);
        int size = e9.size();
        while (i9 < size) {
            Object obj = e9.get(i9);
            i9++;
            s4.c cVar = (s4.c) obj;
            if (!cVar.i() && !cVar.isRunning()) {
                cVar.g();
            }
        }
        ((HashSet) sVar.f1859l).clear();
    }

    public final synchronized void q(s4.e eVar) {
        s4.e eVar2 = (s4.e) eVar.clone();
        if (eVar2.f8815v && !eVar2.f8816w) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        eVar2.f8816w = true;
        eVar2.f8815v = true;
        this.f1824r = eVar2;
    }

    public final synchronized boolean r(t4.b bVar) {
        s4.c g9 = bVar.g();
        if (g9 == null) {
            return true;
        }
        if (!this.f1818l.a(g9)) {
            return false;
        }
        this.f1820n.f1860i.remove(bVar);
        bVar.a(null);
        return true;
    }

    public final synchronized String toString() {
        return super.toString() + "{tracker=" + this.f1818l + ", treeNode=" + this.f1819m + "}";
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i9) {
    }
}
