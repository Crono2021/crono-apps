package com.bumptech.glide.manager;

import android.view.View;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-3ecb04adb5372cce41086c50685c8d30debac27da0c76b9a483628b9c6707d44 */
/* loaded from: C:\Users\crono\Documents\PROYECTOS ANTIGRAVITY\Reproductor telegram\tevegram_extracted\classes.dex */
public final class e implements f {

    /* renamed from: i, reason: collision with root package name */
    public final Set f1831i = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: j, reason: collision with root package name */
    public volatile boolean f1832j;

    @Override // com.bumptech.glide.manager.f
    public final void a(g.l lVar) {
        if (!this.f1832j && this.f1831i.add(lVar)) {
            View decorView = lVar.getWindow().getDecorView();
            decorView.getViewTreeObserver().addOnDrawListener(new d(this, decorView));
        }
    }
}
