package com.bumptech.glide.manager;

import android.content.Context;
import android.media.MediaCodec;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Trace;
import androidx.lifecycle.l;
import androidx.lifecycle.s;
import androidx.lifecycle.u;
import androidx.savedstate.Recreator;
import d1.l0;
import g1.w;
import i7.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import l1.y;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class s implements w4.g, s1.j {

    /* renamed from: m, reason: collision with root package name */
    public static volatile s f1855m;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f1856i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1857j;

    /* renamed from: k, reason: collision with root package name */
    public Object f1858k;

    /* renamed from: l, reason: collision with root package name */
    public Object f1859l;

    public s(Context context) {
        this.f1856i = 0;
        this.f1859l = new HashSet();
        c.a aVar = new c.a(new androidx.emoji2.text.o(context, 1));
        l lVar = new l(this);
        this.f1858k = Build.VERSION.SDK_INT >= 24 ? new b2.b(aVar, lVar) : new r(context, aVar, lVar);
    }

    public static s c(Context context) {
        if (f1855m == null) {
            synchronized (s.class) {
                try {
                    if (f1855m == null) {
                        f1855m = new s(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return f1855m;
    }

    public boolean a(s4.c cVar) {
        boolean z8 = true;
        if (cVar == null) {
            return true;
        }
        boolean remove = ((Set) this.f1858k).remove(cVar);
        if (!((HashSet) this.f1859l).remove(cVar) && !remove) {
            z8 = false;
        }
        if (z8) {
            cVar.clear();
        }
        return z8;
    }

    @Override // s1.j
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public s1.c j(s1.i iVar) {
        MediaCodec mediaCodec;
        int i9;
        s1.l eVar;
        s1.c cVar;
        String str = iVar.f8708a.f8714a;
        s1.c cVar2 = null;
        try {
            g1.a.b("createCodec:" + str);
            mediaCodec = MediaCodec.createByCodecName(str);
            try {
                i9 = 0;
            } catch (Exception e9) {
                e = e9;
            }
        } catch (Exception e10) {
            e = e10;
            mediaCodec = null;
        }
        try {
            if (this.f1857j) {
                if (w.f3713a < 34 ? false : l0.j(iVar.f8710c.f2554m)) {
                    eVar = new x(mediaCodec, 22);
                    i9 = 4;
                    cVar = new s1.c(mediaCodec, (HandlerThread) ((s1.b) this.f1858k).get(), eVar);
                    g1.a.r();
                    s1.c.a(cVar, iVar.f8709b, iVar.f8711d, iVar.f8712e, i9);
                    return cVar;
                }
            }
            g1.a.r();
            s1.c.a(cVar, iVar.f8709b, iVar.f8711d, iVar.f8712e, i9);
            return cVar;
        } catch (Exception e11) {
            e = e11;
            cVar2 = cVar;
            if (cVar2 != null) {
                cVar2.release();
            } else if (mediaCodec != null) {
                mediaCodec.release();
            }
            throw e;
        }
        eVar = new s1.e(mediaCodec, (HandlerThread) ((s1.b) this.f1859l).get());
        cVar = new s1.c(mediaCodec, (HandlerThread) ((s1.b) this.f1858k).get(), eVar);
    }

    public void d() {
        p3.d dVar = (p3.d) this.f1858k;
        u g9 = dVar.g();
        if (g9.f943d != androidx.lifecycle.m.f929j) {
            m7.c.p("Restarter must be created only during owner's initialization stage");
            return;
        }
        g9.a(new Recreator(dVar));
        final n.s sVar = (n.s) this.f1859l;
        sVar.getClass();
        if (sVar.f7027c) {
            m7.c.p("SavedStateRegistry was already attached.");
            return;
        }
        g9.a(new androidx.lifecycle.q() { // from class: p3.a
            @Override // androidx.lifecycle.q
            public final void a(s sVar2, l lVar) {
                n.s sVar3 = n.s.this;
                sVar3.getClass();
                if (lVar == l.ON_START) {
                    sVar3.f7029e = true;
                } else if (lVar == l.ON_STOP) {
                    sVar3.f7029e = false;
                }
            }
        });
        sVar.f7027c = true;
        this.f1857j = true;
    }

    public void e(Bundle bundle) {
        if (!this.f1857j) {
            d();
        }
        u g9 = ((p3.d) this.f1858k).g();
        if (g9.f943d.compareTo(androidx.lifecycle.m.f931l) >= 0) {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + g9.f943d).toString());
        }
        n.s sVar = (n.s) this.f1859l;
        if (!sVar.f7027c) {
            m7.c.p("You must call performAttach() before calling performRestore(Bundle).");
        } else if (sVar.f7028d) {
            m7.c.p("SavedStateRegistry was already restored.");
        } else {
            sVar.f7025a = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
            sVar.f7028d = true;
        }
    }

    public void f(Bundle bundle) {
        bundle.getClass();
        n.s sVar = (n.s) this.f1859l;
        sVar.getClass();
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = (Bundle) sVar.f7025a;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        p.f fVar = (p.f) sVar.f7030f;
        fVar.getClass();
        p.d dVar = new p.d(fVar);
        fVar.f8091k.put(dVar, Boolean.FALSE);
        while (dVar.hasNext()) {
            Map.Entry entry = (Map.Entry) dVar.next();
            bundle2.putBundle((String) entry.getKey(), ((p3.c) entry.getValue()).a());
        }
        if (bundle2.isEmpty()) {
            return;
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    public void g() {
        l1.a aVar = (l1.a) this.f1859l;
        Context context = (Context) this.f1858k;
        if (this.f1857j) {
            context.unregisterReceiver(aVar);
            this.f1857j = false;
        }
    }

    @Override // w4.g
    public Object get() {
        if (this.f1857j) {
            m7.c.p("Recursive Registry initialization! In your AppGlideModule and LibraryGlideModules, Make sure you're using the provided Registry rather calling glide.getRegistry()!");
            return null;
        }
        Trace.beginSection("Glide registry");
        this.f1857j = true;
        try {
            return com.bumptech.glide.c.n((com.bumptech.glide.b) this.f1858k, (ArrayList) this.f1859l);
        } finally {
            this.f1857j = false;
            Trace.endSection();
        }
    }

    public String toString() {
        switch (this.f1856i) {
            case 3:
                return super.toString() + "{numRequests=" + ((Set) this.f1858k).size() + ", isPaused=" + this.f1857j + "}";
            default:
                return super.toString();
        }
    }

    public s(p3.d dVar) {
        this.f1856i = 6;
        this.f1858k = dVar;
        this.f1859l = new n.s();
    }

    public s(Context context, Handler handler, y yVar) {
        this.f1856i = 4;
        this.f1858k = context.getApplicationContext();
        this.f1859l = new l1.a(this, handler, yVar);
    }

    public s(androidx.activity.m mVar, androidx.activity.d dVar) {
        this.f1856i = 1;
        this.f1858k = new Object();
        this.f1859l = new ArrayList();
    }

    public s(int i9, byte b9) {
        this.f1856i = i9;
        switch (i9) {
            case 5:
                break;
            default:
                this.f1858k = Collections.newSetFromMap(new WeakHashMap());
                this.f1859l = new HashSet();
                break;
        }
    }

    public s(int i9) {
        this.f1856i = 7;
        s1.b bVar = new s1.b(i9, 0);
        s1.b bVar2 = new s1.b(i9, 1);
        this.f1858k = bVar;
        this.f1859l = bVar2;
        this.f1857j = true;
    }

    public s(com.bumptech.glide.b bVar, ArrayList arrayList, com.bumptech.glide.d dVar) {
        this.f1856i = 2;
        this.f1858k = bVar;
        this.f1859l = arrayList;
    }
}
