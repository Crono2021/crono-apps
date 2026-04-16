package com.bumptech.glide.manager;

import java.util.ArrayList;
import java.util.HashSet;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l implements a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f1839a;

    public l(s sVar) {
        this.f1839a = sVar;
    }

    @Override // com.bumptech.glide.manager.a
    public final void a(boolean z8) {
        ArrayList arrayList;
        w4.n.a();
        synchronized (this.f1839a) {
            arrayList = new ArrayList((HashSet) this.f1839a.f1859l);
        }
        int size = arrayList.size();
        int i9 = 0;
        while (i9 < size) {
            Object obj = arrayList.get(i9);
            i9++;
            ((a) obj).a(z8);
        }
    }
}
