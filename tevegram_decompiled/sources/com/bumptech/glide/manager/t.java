package com.bumptech.glide.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class t implements h {

    /* renamed from: i, reason: collision with root package name */
    public final Set f1860i = Collections.newSetFromMap(new WeakHashMap());

    @Override // com.bumptech.glide.manager.h
    public final void c() {
        ArrayList e9 = w4.n.e(this.f1860i);
        int size = e9.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = e9.get(i9);
            i9++;
            ((t4.b) obj).c();
        }
    }

    @Override // com.bumptech.glide.manager.h
    public final void j() {
        ArrayList e9 = w4.n.e(this.f1860i);
        int size = e9.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = e9.get(i9);
            i9++;
            ((t4.b) obj).j();
        }
    }

    @Override // com.bumptech.glide.manager.h
    public final void k() {
        ArrayList e9 = w4.n.e(this.f1860i);
        int size = e9.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = e9.get(i9);
            i9++;
            ((t4.b) obj).k();
        }
    }
}
