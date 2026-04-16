package com.bumptech.glide;

import com.bumptech.glide.manager.s;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import w4.n;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class l implements com.bumptech.glide.manager.a {

    /* renamed from: a, reason: collision with root package name */
    public final s f1785a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f1786b;

    public l(m mVar, s sVar) {
        this.f1786b = mVar;
        this.f1785a = sVar;
    }

    @Override // com.bumptech.glide.manager.a
    public final void a(boolean z8) {
        if (z8) {
            synchronized (this.f1786b) {
                s sVar = this.f1785a;
                ArrayList e9 = n.e((Set) sVar.f1858k);
                int size = e9.size();
                int i9 = 0;
                while (i9 < size) {
                    Object obj = e9.get(i9);
                    i9++;
                    s4.c cVar = (s4.c) obj;
                    if (!cVar.i() && !cVar.d()) {
                        cVar.clear();
                        if (sVar.f1857j) {
                            ((HashSet) sVar.f1859l).add(cVar);
                        } else {
                            cVar.g();
                        }
                    }
                }
            }
        }
    }
}
