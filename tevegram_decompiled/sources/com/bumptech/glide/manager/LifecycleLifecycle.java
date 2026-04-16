package com.bumptech.glide.manager;

import androidx.lifecycle.u;
import androidx.lifecycle.z;
import java.util.ArrayList;
import java.util.HashSet;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
final class LifecycleLifecycle implements g, androidx.lifecycle.r {

    /* renamed from: i, reason: collision with root package name */
    public final HashSet f1825i = new HashSet();

    /* renamed from: j, reason: collision with root package name */
    public final u f1826j;

    public LifecycleLifecycle(u uVar) {
        this.f1826j = uVar;
        uVar.a(this);
    }

    @Override // com.bumptech.glide.manager.g
    public final void f(h hVar) {
        this.f1825i.add(hVar);
        androidx.lifecycle.m mVar = this.f1826j.f943d;
        if (mVar == androidx.lifecycle.m.f928i) {
            hVar.k();
        } else if (mVar.compareTo(androidx.lifecycle.m.f931l) >= 0) {
            hVar.j();
        } else {
            hVar.c();
        }
    }

    @Override // com.bumptech.glide.manager.g
    public final void g(h hVar) {
        this.f1825i.remove(hVar);
    }

    @z(androidx.lifecycle.l.ON_DESTROY)
    public void onDestroy(androidx.lifecycle.s sVar) {
        ArrayList e9 = w4.n.e(this.f1825i);
        int size = e9.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = e9.get(i9);
            i9++;
            ((h) obj).k();
        }
        sVar.g().f(this);
    }

    @z(androidx.lifecycle.l.ON_START)
    public void onStart(androidx.lifecycle.s sVar) {
        ArrayList e9 = w4.n.e(this.f1825i);
        int size = e9.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = e9.get(i9);
            i9++;
            ((h) obj).j();
        }
    }

    @z(androidx.lifecycle.l.ON_STOP)
    public void onStop(androidx.lifecycle.s sVar) {
        ArrayList e9 = w4.n.e(this.f1825i);
        int size = e9.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = e9.get(i9);
            i9++;
            ((h) obj).c();
        }
    }
}
