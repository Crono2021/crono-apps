package com.bumptech.glide.manager;

import android.content.Context;
import java.util.HashSet;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class c implements b {

    /* renamed from: i, reason: collision with root package name */
    public final Context f1827i;

    /* renamed from: j, reason: collision with root package name */
    public final com.bumptech.glide.l f1828j;

    public c(Context context, com.bumptech.glide.l lVar) {
        this.f1827i = context.getApplicationContext();
        this.f1828j = lVar;
    }

    @Override // com.bumptech.glide.manager.h
    public final void c() {
        s c9 = s.c(this.f1827i);
        com.bumptech.glide.l lVar = this.f1828j;
        synchronized (c9) {
            ((HashSet) c9.f1859l).remove(lVar);
            if (c9.f1857j && ((HashSet) c9.f1859l).isEmpty()) {
                ((m) c9.f1858k).a();
                c9.f1857j = false;
            }
        }
    }

    @Override // com.bumptech.glide.manager.h
    public final void j() {
        s c9 = s.c(this.f1827i);
        com.bumptech.glide.l lVar = this.f1828j;
        synchronized (c9) {
            ((HashSet) c9.f1859l).add(lVar);
            if (!c9.f1857j && !((HashSet) c9.f1859l).isEmpty()) {
                c9.f1857j = ((m) c9.f1858k).b();
            }
        }
    }

    @Override // com.bumptech.glide.manager.h
    public final void k() {
    }
}
